package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarsController {
    private final CarService carService;

    @Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(name = "count", required = false) Integer count, Model model) {
        model.addAttribute("cars", carService.showCarsByNumber(count));
        return "cars";
    }
}
