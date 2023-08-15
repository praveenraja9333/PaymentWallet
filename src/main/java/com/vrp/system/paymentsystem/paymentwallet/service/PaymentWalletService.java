package com.vrp.system.paymentsystem.paymentwallet.service;

import com.vrp.system.paymentsystem.paymentwallet.dao.PaymentWalletDao;
import com.vrp.system.paymentsystem.paymentwallet.exceptions.DuplicateTransactionException;
import com.vrp.system.paymentsystem.paymentwallet.models.Order;
import com.vrp.system.paymentsystem.paymentwallet.models.PaymentOrder;
import com.vrp.system.paymentsystem.paymentwallet.models.entites.WalletEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

@Service
public class PaymentWalletService {

    private static NumberFormat format=NumberFormat.getNumberInstance();
    @Autowired
    private PaymentWalletDao paymentWalletDao;

    public int postOrder(Order order){
            List<PaymentOrder> list=order.getPaymentOrderList();
            if(paymentWalletDao.findByUuid(order.getCheckoutid())>0){
                throw new DuplicateTransactionException(" Checkout id "+order.getCheckoutid()+" already present in the System");
            }
            list.stream().forEach(po->{
                try {
                    WalletEntry walletEntry= WalletEntry.newBuilder().setCheckoutId(order.getCheckoutid())
                            .setCurrencycode(order.getCurrencycode())
                            .setUserInfo(po.getSellername())
                            .setBalance(format.parse(po.getAmount()).doubleValue())
                            .build();
                    paymentWalletDao.save(walletEntry);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            });
            return 0;
    }

    public Page<WalletEntry> getPage(Pageable pageable){
            return paymentWalletDao.getPages(pageable);
    }
}
