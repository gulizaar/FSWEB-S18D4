package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {

   private BurgerDaoImpl burgerDaoImpl;
@Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }
    @GetMapping()
    public List<Burger> findAll(){
        return burgerDaoImpl.findAll();

    }
    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id){
        return burgerDaoImpl.findById(id);
    }
    @PostMapping
    public Burger save(@RequestBody Burger burger){
        return burgerDaoImpl.save(burger);
    }
    @PutMapping("/{id}")
    public Burger update(@PathVariable Long id,
                         @RequestBody Burger burger){
        burger.setId(id);
    burgerDaoImpl.update(burger);
    return burger;
    }
    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable Long id){
    return burgerDaoImpl.remove(id);
    }
    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody int price){
    return burgerDaoImpl.findByPrice(price);
    }
    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestBody BreadType breadType){
        return burgerDaoImpl.findByBreadType(breadType);
    }
    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody String content){
        return burgerDaoImpl.findByContent(content);
    }


}
