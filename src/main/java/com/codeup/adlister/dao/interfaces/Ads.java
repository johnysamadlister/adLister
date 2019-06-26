package com.codeup.adlister.dao.interfaces;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> limit(long limit, long offset);

    List<Ad> addToAds(long limit, long offset, List<Ad> previousAds);

    List<Ad> searchAds(String search);

    List<Ad> listadsplusinfo();

    List<Ad> listEverything();

    List<Ad> listEverythingExceptUser(String username);

    List<Ad> retrieveAdsByUsername(String username);

    List<Ad> NotUsersAds(String username);


    void updateAd(String column, String value, String id);

    Ad deleteAd(Long id);

}


