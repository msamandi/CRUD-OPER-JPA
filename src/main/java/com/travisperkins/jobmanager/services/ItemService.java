package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.*;

import java.util.List;

/**
 * Created by msamandi on 03/03/2017.
 */
public interface ItemService {
     List<Item> getItems(String tag) ;

     List<Tag> getTag(String tag);

}
