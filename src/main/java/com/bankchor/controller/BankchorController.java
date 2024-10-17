package com.bankchor.controller;

import com.bankchor.entity.Bankchor;
import com.bankchor.service.BankchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")

public class BankchorController {

    @Autowired
    private BankchorService bankchorService;

    @PostMapping
    public Bankchor createAccount(@RequestBody Bankchor bankchor) {
        return bankchorService.createAccount(bankchor);
    }

    @GetMapping("/{id}")
    public Bankchor getAccount(@PathVariable Long id){
        Bankchor account = bankchorService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        return account;
    }

    @PostMapping("/{id}/deposit")
    public Bankchor deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        return bankchorService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
        public Bankchor withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
            Double amount = request.get("amount");
            return bankchorService.withdraw(id, amount);
        }
}
