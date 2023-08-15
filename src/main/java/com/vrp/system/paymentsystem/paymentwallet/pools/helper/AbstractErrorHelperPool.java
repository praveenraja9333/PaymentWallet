package com.vrp.system.paymentsystem.paymentwallet.pools.helper;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.locks.ReentrantLock;


public abstract class AbstractErrorHelperPool<E> {
    protected int max_count = 10000;

    protected int min_count = 100;

    public ReentrantLock lock = new ReentrantLock();

    Timer timer = new Timer();

    public int size = 0;
    protected LinkedList<CustomWrapper<E>> total =new LinkedList<>();
    protected LinkedList<CustomWrapper<E>> available = new LinkedList<>();

    protected volatile List<CustomWrapper<E>> tobeadded1 = Collections.synchronizedList(new LinkedList<>());
    protected volatile List<CustomWrapper<E>> tobeadded2 = Collections.synchronizedList(new LinkedList<>());
    protected volatile List<CustomWrapper<E>> receiver = tobeadded1;


    abstract public CustomWrapper<E> getShell();

    public void addPaymentError(CustomWrapper<E> shell) {
        shell.setMilliseconds(System.currentTimeMillis());
        receiver.add(shell);
    }


    public int getMax_count() {
        return this.max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }

}
