package com.vrp.system.paymentsystem.paymentwallet.api;

import com.vrp.system.paymentsystem.paymentwallet.models.Order;
import com.vrp.system.paymentsystem.paymentwallet.models.entites.WalletEntry;
import com.vrp.system.paymentsystem.paymentwallet.service.PaymentWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
public class MainwalletApi {

    @Autowired
    private PaymentWalletService paymentWalletService;

    @PostMapping("/api/v1/postOrder")
    public int postOrder(@RequestBody Order order){
            paymentWalletService.postOrder(order);
            return 0;
    }

    @DeleteMapping("/api/v1/postOrder")
    public void deleteRestricted(){
        throw new RuntimeException("Delete Operation is supported");
    }

    @PutMapping("/api/v1/postOrder")
    public void putRestricted(){
        throw new RuntimeException("Put Operation is supported");
    }

    @GetMapping("/api/v1/postOrder")
    public void getRestricted(){
        throw new RuntimeException("Get Operation is supported");
    }

    @GetMapping(value = "/api/v1/getBalances",produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<WalletEntry> getBalances(){
        PageRequest pageable=PageRequest.of(1,10);
        return paymentWalletService.getPage(pageable);
    }

    @GetMapping(value = "/api/v1/getBalances",produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<WalletEntry> getBalances(@RequestParam("page") Integer p) {
        PageRequest pageable = PageRequest.of(p, 10);
        return paymentWalletService.getPage(pageable);
    }
}
