package com.vrp.system.paymentsystem.paymentwallet.exceptions;

import com.vrp.system.paymentsystem.paymentwallet.models.entites.PaymentError;
import com.vrp.system.paymentsystem.paymentwallet.pools.PaymentErrorPool;
import com.vrp.system.paymentsystem.paymentwallet.pools.helper.CustomWrapper;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    private static DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ssZ");

    @Autowired
    private PaymentErrorPool paymentErrorPool;

    @ExceptionHandler({DuplicateTransactionException.class})
    public ResponseEntity<PaymentError> commonResponse(RuntimeException re, WebRequest webClient){
              CustomWrapper<PaymentError> customWrapper =paymentErrorPool.getShell();
              PaymentError paymentError =null;
              if(customWrapper==null){
                  paymentError =new PaymentError();
              }else{
                  paymentError =customWrapper.getData();
              }
              paymentError.setReason(re.getMessage());
              paymentError.setTimestamp(ZonedDateTime.now().format(dateTimeFormatter));
              paymentError.setStatus(HttpStatus.BAD_REQUEST.toString());
              return new ResponseEntity<>(paymentError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<PaymentError> validationException(RuntimeException re, WebRequest webClient){
        ConstraintViolationException ce=(ConstraintViolationException)re.getCause().getCause();
        CustomWrapper<PaymentError> customWrapper =paymentErrorPool.getShell();
        PaymentError paymentError =null;
        if(customWrapper==null){
            paymentError =new PaymentError();
        }else{
            paymentError =customWrapper.getData();
        }
        paymentError.setReason(ce==null?"":ce.getMessage());
        paymentError.setTimestamp(ZonedDateTime.now().format(dateTimeFormatter));
        paymentError.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(paymentError,HttpStatus.BAD_REQUEST);
    }

}
