package com.example.foodi.db;


import com.example.foodi.model.Food;
import com.example.foodi.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.foodi.db.dataBase.resturants;


@Component
public class daoRestaurant {

    public List<Restaurant> getAll() {
        return resturants;
    }

    public List<Food> getMenus(int restaurantId){
        for (Restaurant res:resturants
             ) {
            if(res.getId()==restaurantId)return res.getMenu();
        }
        return null;
    }


    public boolean removeRestaurant(int rid, int oid) {

        //if oid is valid
        for (Restaurant re:resturants
             ) {
            if(re.getId()==rid)
                resturants.remove(re);
            return true;
        }
        return false;
    }

    public boolean updatePriceFood(int rid, int fid, int pric) {
        for (Restaurant r:resturants) {
            if(r.getId()==rid){
                int rindex=resturants.indexOf(r);
                for (Food f:r.getMenu()) {
                    if(f.getFoodId()==fid) {
                        int findex = r.getMenu().indexOf(f);
                        resturants.get(rindex).getMenu().get(findex).setPrice(pric);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addFood(int id, Food f) {
        for (Restaurant res:resturants
             ) {
            if(res.getId()==id){
                f.setFoodId(res.getMenu().size()+100);
                resturants.get(res.getId()).getMenu().add(f);
            }

        }
        return false;
    }
}
