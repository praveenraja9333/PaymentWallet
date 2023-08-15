package com.vrp.system.paymentsystem.paymentwallet.dao;

import com.vrp.system.paymentsystem.paymentwallet.models.entites.WalletEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentWalletDao extends CrudRepository<WalletEntry, UUID> {
    @Query("select * from Wallet_Entry")
    public Page<WalletEntry> getPages(Pageable pageable);
}
