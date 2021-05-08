package fr.audit.app.client.service;

import fr.audit.app.metier.entity.Beer;
import fr.audit.app.physique.BeerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * @author Snowsdy
 */
@Service
@RestController
public abstract class BeerService implements Serializable {

    @Autowired
    private BeerServiceImpl beerServiceImpl;

    public static final String template = "Bière %s";
    public static final String springMessage = "Spring Service";

    public BeerService() {
    }

    public String sayHello() {
        return springMessage;
    }

    @GetMapping("/message")
    public Beer getBeer(@RequestParam(value = "name", defaultValue = "beer") String name,
                        @RequestParam(value = "price", defaultValue = "1.0") float price,
                        @RequestParam(value = "available", defaultValue = "false") boolean available){
        return new Beer(String.format(template, name), price, available);
    }

    @GetMapping("/end")
    public void endBeer() {
        System.exit(0);
    }

    @GetMapping("/between")
    public List<Beer> searchByPrice(@RequestParam(value = "min") float min,
                                    @RequestParam(value = "max") float max){
        return beerServiceImpl.searchByPrice(min, max);
    }

    @GetMapping("/allBeers")
    public @ResponseBody Iterable<Beer> getAllBeers(){
        return beerServiceImpl.getAll();
    }

    @GetMapping("/testBeer")
    public String test(){
        return beerServiceImpl.test();
    }

    public BeerServiceImpl getBeerServiceImpl() {
        return beerServiceImpl;
    }

    public void setBeerServiceImpl(BeerServiceImpl beerServiceImpl) {
        this.beerServiceImpl = beerServiceImpl;
    }
}
