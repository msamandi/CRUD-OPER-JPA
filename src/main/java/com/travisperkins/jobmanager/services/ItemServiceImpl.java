package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Tag;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.TagRepository;
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
    private ItemRepository itemRepository ;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Item> getItems(String tag) {
        return new ArrayList<>();
    }

    @Override
    public List<Tag> getTag(String tag) {
        return tagRepository.getTag(tag);
    }
}
