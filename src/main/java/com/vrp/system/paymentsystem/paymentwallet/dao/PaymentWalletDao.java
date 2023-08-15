package com.vrp.system.paymentsystem.paymentwallet.dao;

import com.vrp.system.paymentsystem.paymentwallet.models.entites.WalletEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentWalletDao extends CrudRepository<WalletEntry, UUID> {
}
