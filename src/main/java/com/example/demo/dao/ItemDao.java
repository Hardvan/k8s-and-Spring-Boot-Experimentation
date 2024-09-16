package com.example.demo.dao;

import com.example.demo.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ItemDao {
    public List<Item> getAllItems() {
        return Arrays.asList(
                new Item(1L, "Item 1"),
                new Item(2L, "Item 2"),
                new Item(3L, "Item 3")
        );
    }
}
