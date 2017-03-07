package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Tag;
import com.travisperkins.jobmanager.repository.TagRepository;
import com.travisperkins.jobmanager.representation.ItemRepresentation;
import com.travisperkins.jobmanager.representation.TagRepresentation;
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
        List<Tag> tag = tagRepository.getTags(tagName);
        List<Item> items = tag.get(0).getItems();

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
                    .tags(mapToTagsRepresentation(item.getTags()))
                    .build());
        }
        return itemRepresentations;
    }

    private List<TagRepresentation> mapToTagsRepresentation(List<Tag> tags) {
        List<TagRepresentation> tagRepresentations = new ArrayList<>();
        for(Tag tag : tags) {
            tagRepresentations.add(
                    new TagRepresentation.TagRepresentationBuilder(tag.getName())
                    .build());

        }
        return tagRepresentations;
    }



}
