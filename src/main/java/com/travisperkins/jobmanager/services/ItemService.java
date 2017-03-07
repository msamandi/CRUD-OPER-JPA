package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.representation.ItemRepresentation;

import java.util.List;

/**
 * Created by msamandi on 03/03/2017.
 */
public interface ItemService {

     List<ItemRepresentation> getItems(String tag);

}
