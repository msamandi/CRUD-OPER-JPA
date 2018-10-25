package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.model.Tag;
import com.travisperkins.jobmanager.model.Task;
import com.travisperkins.jobmanager.repository.*;
import com.travisperkins.jobmanager.representation.ItemRepresentation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by msamandi on 08/03/2017.
 */
public class ItemServiceTest {
    private static final String tagName = "Bath";

    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private TagRepository tagRepositoryMock;

    @Before
    public void setup() {
        initMocks(this);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(tagRepositoryMock);
    }

    @Test
    public void testGetItem() {
        final long count = 10;
        final Tag tag = new Tag("Test Tag");
        final Task task = new Task();
        task.setId(1L);
        task.setName("Task");
        List<Item> items =new ArrayList<Item>();
        for(long i=1; i<=count; i++){
            Item item = new Item();
            item.setCategory("Category"+i);
            item.setId(i);
            item.setDescription("Description " + i);
            item.setQuantity((int)i);
            item.setPrice(BigDecimal.valueOf(i*10));
            item.setTags(Arrays.asList(new Tag[]{tag}));
            item.setTask(task);
            items.add(item);
        }
        tag.setItems(items);
        List<Tag>tags = new ArrayList<Tag>();
        tags.add(tag);


        //setup behaviour
        List<ItemRepresentation> listItem=new ArrayList<ItemRepresentation>();
        for(long i=1; i<=count; i++){
            ItemRepresentation itemRepresentation = new ItemRepresentation.ItemRepresentationBuilder(i)
                    .category("Category"+i)
                    .description("Description " + i)
                    .price(BigDecimal.valueOf(i*10))
                    .quantity((int)i)
                    .task(task)
                    .build();
            listItem.add(itemRepresentation);
        }
        when(tagRepositoryMock.getTag(anyString())).thenReturn(tag);
        List<ItemRepresentation> returned = itemService.getItems(tagName);

        verify(tagRepositoryMock).getTag(tagName);
        assertEquals(listItem.size(), returned.size());
        for(int i=0; i<count; i++) {
            assertEquals(listItem.get(i), returned.get(i));
        }
    }
}
