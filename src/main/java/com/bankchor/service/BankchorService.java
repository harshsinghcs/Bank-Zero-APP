package com.bankchor.service;

import com.bankchor.entity.Bankchor;
import com.bankchor.repository.BankchorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankchorService {

    @Autowired
    private BankchorRepository bankchorRepository;

    public Bankchor createAccount(Bankchor bankchor){
        return bankchorRepository.save(bankchor);
    }

    public Optional<Bankchor> getAccount(Long id){
        return bankchorRepository.findById(id);
    }

    public Bankchor/*account*/ deposit(Long id,double amount){
        Bankchor bankchor = getAccount(id).orElseThrow(()->new RuntimeException("No Account Found"));
        bankchor.setBalance(bankchor.getBalance() + amount);
        return bankchorRepository.save(bankchor);
    }

    public Bankchor withdraw(Long id, double ammount){
        Bankchor bankchor = getAccount(id).orElseThrow(()->new RuntimeException("No Account Found"));
        if(bankchor.getBalance() < ammount){
            throw new RuntimeException("Insufficient Balance");
        }
        bankchor.setBalance(bankchor.getBalance() - ammount);
        return bankchorRepository.save(bankchor);
    }
}

//create account
//featching account
//Deposit
//Withdrawl
