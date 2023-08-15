package com.vrp.system.paymentsystem.paymentwallet.api;

import com.vrp.system.paymentsystem.paymentwallet.models.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainwalletApi {

    @PostMapping("/api/v1/postOrder")
    public int postOrder(@RequestBody Order order){
             return 0;
    }
}
