package com.example.calculation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.calculation.services.CalculationService;

@RestController
@RequestMapping("/api/calculator")
public class CalculationController {

   
    @Autowired
    private  CalculationService calculationService;
    @GetMapping("/calculate")
    public void calculate() {
        calculationService.executeCalculations();
    }
}
