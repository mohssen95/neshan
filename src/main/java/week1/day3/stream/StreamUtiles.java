package week1.day3.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamUtiles {
    public void lineLength (List<String> list){
        System.out.println(list.stream().count());
    }
    public void numberWordsEachLine (List<String> list,Set<String> stopWords){
        list.stream()
                .map(sentence -> Arrays.stream(sentence.split(" "))
                        .filter(w -> !w.trim().isEmpty())
                        .filter(w -> !stopWords.contains(w))
                        .map(String::toLowerCase)
                        .count()
                ).forEach(System.out::println);
    }
    public void numberAllWords (List<String> list,Set<String> stopWords){
        System.out.println(list.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" "))
                        .filter(w -> !w.trim().isEmpty())
                        .filter(w -> !stopWords.contains(w)))
                        .map(String::toLowerCase)
                .count());

    }
    public void wordFreqPerLine (List<String> list,Set<String> stopWords){
        System.out.println(list.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" "))
                        .filter(w -> !w.trim().isEmpty())
                        .filter(w -> !stopWords.contains(w))
                        .map(String::toLowerCase)
                )
                .collect(groupingBy(Function.identity(), counting())));
    }
    public void mapNumLineByWord (List<String> sentences){
        System.out.println(IntStream.range(0, 10)
                .mapToObj(i -> Arrays.stream(sentences.get(i).split(" "))
                        .distinct()
                        .map(w -> w.toLowerCase())
                        .map(s -> i + " " + s)
                ).flatMap(stringStream -> stringStream)

                .collect(groupingBy(w -> w.split(" ")[1] != null ? w.split(" ")[1] : "",
                        Collectors.mapping(s -> s.split(" ")[0], Collectors.toList()))));

    }
    public void mapByFirstWord (List<String> list){
        System.out.println(list.stream()
                .collect(groupingBy(
                        line -> line.split(" ")[0],
                        Collectors.toList())));

    }
    public void averageWords (List<String> list){
        System.out.println(list.stream()
                .map(line -> line.replace(" ", ""))
                .mapToInt(String::length)
                .average().orElse(Double.NaN));

    }
    public void numberDocByOddEven (List<String> list){
        System.out.println(list.stream()
                .mapToInt(line -> {
                    return (line.split(" ").length % 2 == 0) ? line.split(" ").length : -line.split(" ").length;
                }).sum());
    }



}
