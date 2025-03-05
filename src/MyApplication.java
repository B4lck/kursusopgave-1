import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.Record;
import model.RecordLibrary;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

import java.sql.SQLOutput;

public class MyApplication extends Application
{
    private Model model;

    @Override
    public void start(Stage primaryStage) {
        this.model = new RecordLibrary();

        model.addRecord(new Record("Let Me Entertain You", "Robbie Williams Jam", 2012));
        model.addRecord(new Record("A Horse with no name", "America", 1972));
        model.addRecord(new Record("Skyfall", "Adele", 2012));
        model.addRecord(new Record("Lose yourself", "Eminem", 2002));
        model.addRecord(new Record("Vi maler byen rød", "Birthe Kjær", 1996));
        model.addRecord(new Record("Ashawes", "Moudy Al Arabe", 2022));
        model.addRecord(new Record("Tro På Os To", "SEB", 2006));
        model.addRecord(new Record("Supernova", "Babou", 2014));

        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);

        doThreadsTingOgSager();
    }

    private void doThreadsTingOgSager() {
        // Der skal der ske tråde der viber og ting og sager og hygge nygge noget pus

        Customer robot1 = new Customer("Bob", model);
        Customer robot2 = new Customer("Wendy", model);

        Thread thread1 = new Thread(robot1);
        Thread thread2 = new Thread(robot2);

        thread1.start();
        thread2.start();
    }
}
