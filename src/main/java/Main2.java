import service.Animal;
import service.Flyable;
import service.annotation.AutoWired;
import service.annotation.StartUp;
import service.core.Context;
import service.impl.AnimalImpl;
import service.impl.FlyableImpl;
@StartUp(packageScan = "service.impl")
public class Main2 {
    @AutoWired
    private Flyable flyable;
    @AutoWired
    private Animal animal;
    public static void main(String[] args) {
        Main2 main = Context.getObjectByClass(Main2.class);
        main.getFlyable().fly();
        main.getAnimal().saySmth();
    }

    public Flyable getFlyable() {
        return flyable;
    }

    public Animal getAnimal() {
        return animal;
    }
}
