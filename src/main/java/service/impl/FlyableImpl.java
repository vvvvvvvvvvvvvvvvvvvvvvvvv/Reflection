package service.impl;


import service.Flyable;
import service.annotation.Service;

@Service
public class FlyableImpl implements Flyable {
    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}
