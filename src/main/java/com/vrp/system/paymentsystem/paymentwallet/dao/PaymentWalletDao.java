package com.vrp.system.paymentsystem.paymentwallet.dao;

import com.vrp.system.paymentsystem.paymentwallet.models.entites.WalletEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PaymentWalletDao extends CrudRepository<WalletEntry, UUID> {
    @Query(value="select * from Wallet_Entry",nativeQuery = true)
    public Page<WalletEntry> getPages(Pageable pageable);

    @Query(value="select count(*) from Wallet_Entry where checkout_id=:checkoutId",nativeQuery = true)
    public int findByUuid(@Param("checkoutId") UUID uuid);
}
