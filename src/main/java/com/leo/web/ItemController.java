package com.leo.web;

import com.leo.domain.Item;
import com.leo.domain.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="mailto:leandro.burgos@globant.com>Leandro Burgos</a>
 */
@Controller
@RequestMapping(value = "/items")
public class ItemController {

    @Autowired
    private ItemsRepository itemsRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String create(String description) {
        Item newItem = new Item(description);
        itemsRepository.save(newItem);
        return String.format("Item created with id: %s", String.valueOf(newItem.getId()));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String read(@PathVariable("id") Long id) {
        Item item = itemsRepository.findOne(id);
        return null != item ? "Item found :" + item.getDescription() : String.format("No item for id: %s", String.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Item> getAll() {
        return itemsRepository.findAll();
    }
}
