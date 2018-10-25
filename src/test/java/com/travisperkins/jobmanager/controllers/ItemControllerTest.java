package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.representation.ItemRepresentation;
import com.travisperkins.jobmanager.services.ItemService;
import com.travisperkins.jobmanager.services.JobService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
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
public class ItemControllerTest {

    private static final String tagName = "Bath";

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemServiceMock;


    @Before
    public void setup() {
        initMocks(this);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(itemServiceMock);
    }
    @Test
    public void testGetItems() {
        List<ItemRepresentation> listItem=new ArrayList<ItemRepresentation>();
        //setup behaviour
        when(itemServiceMock.getItems(anyString())).thenReturn(listItem);

        List<ItemRepresentation> listItemReturned= itemController.getItems(tagName);

        verify(itemServiceMock).getItems(tagName);
        assertEquals(listItemReturned, listItem);
    }

}
