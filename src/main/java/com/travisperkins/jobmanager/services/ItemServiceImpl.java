package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Tag;
import com.travisperkins.jobmanager.repository.TagRepository;
import com.travisperkins.jobmanager.representation.ItemRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msamandi on 07/03/2017.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<ItemRepresentation> getItems(String tagName) {
        Tag tag = tagRepository.getTag(tagName);
        List<Item> items ;
        if (tag!=null)
            items = tag.getItems();
        else

             items = new ArrayList<Item>();

        return mapToItemRepresentation(items);
    }

    private List<ItemRepresentation> mapToItemRepresentation(List<Item> items) {
        List<ItemRepresentation> itemRepresentations = new ArrayList<>();
        for(Item item : items) {
            itemRepresentations.add(
                    new ItemRepresentation.ItemRepresentationBuilder(item.getId())
                    .category(item.getCategory())
                    .description(item.getDescription())
                    .price(item.getPrice())
                    .quantity(item.getQuantity())
                    .task(item.getTask())
                    .build());
        }
        return itemRepresentations;
    }
}
