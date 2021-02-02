package service.impl;


import service.Animal;
import service.annotation.Service;

@Service
public class AnimalImpl implements Animal {
    @Override
    public void saySmth() {
        System.out.println("Smth sound");
    }
}
