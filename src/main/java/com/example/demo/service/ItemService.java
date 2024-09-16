package com.example.demo.service;

import com.example.demo.dao.ItemDao;
import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }
}
