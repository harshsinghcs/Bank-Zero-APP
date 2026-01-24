package com.bankchor.controller;

import com.bankchor.entity.Bankchor;
import com.bankchor.entity.Transaction;
import com.bankchor.service.BankchorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/accounts")
public class BankchorController {

    private final BankchorService bankchorService;

    // ✅ Constructor Injection (Best Practice)
    public BankchorController(BankchorService bankchorService) {
        this.bankchorService = bankchorService;
    }

    // ✅ Create Account
    @PostMapping
    public Bankchor createAccount(@RequestBody Bankchor bankchor) {
        return bankchorService.createAccount(bankchor);
    }

    // ✅ Get Account by ID
    @GetMapping("/{id}")
    public Bankchor getAccount(@PathVariable Long id) {
        return bankchorService.getAccount(id);
    }
    // to get all acount
    @GetMapping
    public List<Bankchor> getAllAccounts() {
        return bankchorService.getAllAccounts();
    }

    // ✅ Deposit Money
    @PostMapping("/{id}/deposit")
    public Bankchor deposit(@PathVariable Long id,
                            @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return bankchorService.deposit(id, amount);
    }

    // ✅ Withdraw Money
    @PostMapping("/{id}/withdraw")
    public Bankchor withdraw(@PathVariable Long id,
                             @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return bankchorService.withdraw(id, amount);
    }

    // ✅ Transaction History API
        @GetMapping("/{id}/transactions")
    public List<Transaction> getTransactionHistory(@PathVariable Long id) {
        return bankchorService.getTransactionHistory(id);
    }
}



/*
| Operation           | Endpoint                              |
| ------------------- | ------------------------------------- |
| Create Account      | `POST /api/accounts`                  |
| Get Account         | `GET /api/accounts/{id}`              |
| Deposit             | `POST /api/accounts/{id}/deposit`     |
| Withdraw            | `POST /api/accounts/{id}/withdraw`    |
| Transaction History | `GET /api/accounts/{id}/transactions` |

 */