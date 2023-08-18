package week1.day3.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private static String readFile(String filename) throws IOException {
        return new String(
                Objects.requireNonNull(
                        Streams.class.getResourceAsStream(filename)
                ).readAllBytes()
        );
    }

    public static void main(String args[]) throws IOException {

        List<String> docLines = new ArrayList<>();
        Set<String> stopWords = new HashSet<>();


        try (Stream<String> stream = Arrays.stream(readFile("/stopwords.txt").split("\n"))) {
            stopWords = stream
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }


        String fullPassage = readFile("/TheBrothersKaramazov.txt");

        List<String> sentences = Arrays.stream(fullPassage.split("[.]"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(s -> s.replaceAll("[^\\sa-zA-Z0-9]", ""))
                .toList();

        StreamUtiles utiles = new StreamUtiles();


        utiles.lineLength(sentences);
//        utiles.numberDocByOddEven(sentences);
//        utiles.numberAllWords(sentences,stopWords);
//        utiles.mapByFirstWord(sentences);
//        utiles.numberWordsEachLine(sentences,stopWords);
//        utiles.averageWords(sentences);
//        utiles.mapNumLineByWord(sentences);
//        utiles.wordFreqPerLine(sentences,stopWords);


    }
}



