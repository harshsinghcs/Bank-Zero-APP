package com.bankchor.service;

import com.bankchor.entity.Bankchor;
import com.bankchor.entity.Transaction;
import com.bankchor.entity.TransactionType;
import com.bankchor.repository.BankchorRepository;
import com.bankchor.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankchorService {

    private final BankchorRepository bankchorRepository;
    private final TransactionRepository transactionRepository;

    // ✅ Constructor Injection (BEST PRACTICE)
    public BankchorService(BankchorRepository bankchorRepository,
                           TransactionRepository transactionRepository) {
        this.bankchorRepository = bankchorRepository;
        this.transactionRepository = transactionRepository;
    }

    // ✅ Create Account
    public Bankchor createAccount(Bankchor bankchor) {
        return bankchorRepository.save(bankchor);
    }

    // ✅ Get Account
    public Bankchor getAccount(Long id) {
        return bankchorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // get all acounts
    public List<Bankchor> getAllAccounts() {
        return bankchorRepository.findAll();
    }

    // ✅ Deposit
    @Transactional
    public Bankchor deposit(Long id, Double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Deposit amount must be greater than zero");
        }

        Bankchor account = getAccount(id);

        account.setBalance(account.getBalance() + amount);

        Transaction tx =
                new Transaction(id, amount, TransactionType.DEPOSIT);

        System.out.println("Saving transaction for accountId = " + id);

        transactionRepository.save(tx);

        // ✅ Save transaction
        transactionRepository.save(
                new Transaction(id, amount, TransactionType.DEPOSIT)
        );

        return bankchorRepository.save(account);
    }

    public List<Transaction> getTransactionHistory(Long accountId) {
        return transactionRepository.findByAccountIdOrderByCreatedAtDesc(accountId);
    }

    // ✅ Withdraw
    @Transactional
    public Bankchor withdraw(Long id, Double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Withdraw amount must be greater than zero");
        }

        Bankchor account = getAccount(id);

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        account.setBalance(account.getBalance() - amount);

        // ✅ Save transaction
        transactionRepository.save(
                new Transaction(id, amount, TransactionType.WITHDRAW)
        );

        return bankchorRepository.save(account);
    }
}


//create account
//featching account
//Deposit
//Withdrawl
