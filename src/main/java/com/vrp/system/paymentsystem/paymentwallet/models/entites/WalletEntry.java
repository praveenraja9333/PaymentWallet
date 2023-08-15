package com.vrp.system.paymentsystem.paymentwallet.models.entites;

import com.vrp.system.paymentsystem.paymentwallet.models.builders.Builder;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Entity
@Transactional
@Table(name="Wallet_Entry")
public class WalletEntry {
    @Id
    @GeneratedValue
    public int id;
    @Column
    @NotNull(message="userinfo should not be null")
    @NotBlank(message="Blank object are not allowed for userinfo, Should be a valid name or id of the user")
    public UUID checkoutId;
    @Column
    private String userInfo;
    @Column
    private String currencycode;
    @Column
    private  double balance;

    private WalletEntry(){

    }
    public UUID getCheckoutId() {
        return checkoutId;
    }

    private void setCheckoutId(UUID checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getUserInfo() {
        return userInfo;
    }

    private void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    private void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public static WalletEntryBuilder newBuilder(){
        return new WalletEntryBuilder();
    }

    public static class WalletEntryBuilder implements Builder<WalletEntry> {
        private UUID checkoutId;
        private String userInfo;
        private String currencycode;
        private double balance;

        public WalletEntryBuilder setCheckoutId(UUID checkoutId) {
            this.checkoutId = checkoutId;
            return self();
        }

        public WalletEntryBuilder setUserInfo(String userInfo) {
            this.userInfo = userInfo;
            return self();
        }

        public WalletEntryBuilder setCurrencycode(String currencycode) {
            this.currencycode = currencycode;
            return self();
        }

        public WalletEntryBuilder setBalance(double balance) {
            this.balance = balance;
            return self();
        }

        public WalletEntryBuilder self(){
            return this;
        }

        @Override
        public WalletEntry build() {
            WalletEntry walletEntry=new WalletEntry();
            walletEntry.setCheckoutId(requireNonNull(this.checkoutId));
            walletEntry.setUserInfo(requireNonNull(this.userInfo));
            walletEntry.setCurrencycode(requireNonNull(this.currencycode));
            walletEntry.setBalance(this.balance);
            return walletEntry;
        }
    }
}
