package com.vrp.system.paymentsystem.paymentwallet.models.entites;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    public String checkoutId;
    @Column
    private String userInfo;
    @Column
    private String currencycode;
    @Column
    private String balance;

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
