package controller;

import model.City;
import model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CityService;
import service.NationService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value = "/")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("city/list");
        nationService.save(new Nation((long) 1, "Việt Nam"));
        nationService.save(new Nation((long) 2, "Thái Lan"));
        nationService.save(new Nation((long) 3, "Nhật Bản"));
        Iterable<City> cities = cityService.fillAll();
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping(value = "/create-city")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;

    }

    @PostMapping(value = "/create-city")
    public ModelAndView addBook(@ModelAttribute("city") City city) {
        ModelAndView modelAndView = new ModelAndView("city/create");
        cityService.save(city);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "Đã tạo");
        return modelAndView;
    }

    @GetMapping(value = "/edit-city/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("city/edit");
        City city = cityService.findBook(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("city/view");
        City city = cityService.findBook(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping(value = "/edit-city")
    public ModelAndView editBook(@ModelAttribute("city") City city) {
        ModelAndView modelAndView = new ModelAndView("city/edit");
        cityService.save(city);
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Đã sửa ");
        return modelAndView;
    }

    @GetMapping(value = "/delete-city/{id}")
    public ModelAndView showDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("city/delete");
        City city = cityService.findBook(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/delete-city")
    public String delete(@ModelAttribute("city") City city) {
        cityService.delete(city.getId());
        return "redirect:/";
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam("search") String name) {
        ModelAndView modelAndView = new ModelAndView("city/list");
        Iterable<City> cities = cityService.fillBookByName(name);
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @Autowired
    NationService nationService;

    @ModelAttribute("nations")
    public Iterable<Nation> findAll() {
        return nationService.findAll();
    }
}

