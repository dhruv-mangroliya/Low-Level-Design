package org.example.Factories;

import org.example.Models.Location;
import org.example.Models.Shop;

public class ShopFactory {
    public static Shop createShop(int shopId, String shopName, Location location){
        return new Shop(shopId, shopName, location);
    }
}
