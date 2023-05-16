package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Wallet;

public interface WalletRepo extends JpaRepository<Wallet,Integer> {

}
