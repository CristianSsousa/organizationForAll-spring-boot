package com.br.csousa.organizationForAll.controllers;

import com.br.csousa.organizationForAll.models.request.RequestCostumerCreate;
import com.br.csousa.organizationForAll.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/costumers")
@CrossOrigin(origins = "*")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createCostumer(@RequestBody(required = true) RequestCostumerCreate request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(costumerService.createCostumer(request));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAllCostumers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(costumerService.getAllCostumers());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/{idCostumer}", produces = "application/json")
    public ResponseEntity<?> getCostumerById(@PathVariable Long idCostumer) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(costumerService.findById(idCostumer));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
