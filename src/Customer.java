import model.*;
import model.Record;

import java.util.ArrayList;
import java.util.Random;

/**
 * Robot customer til at simulere
 */
public class Customer implements Runnable {
    private String username;
    private Model model;
    private Random random;

    public Customer(String username, Model model) {
        this.model = model;
        this.username = username;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                ArrayList<Record> records = model.getAllRecords();
                Record recordToInfluence = records.get(random.nextInt(records.size()));
                switch (random.nextInt(3)) {
                    case 0:
                        recordToInfluence.lendRecord(this.username);
                        break;
                    case 1:
                        recordToInfluence.reserveRecord(this.username);
                        break;
                    case 2:
                        recordToInfluence.returnRecord();
                        break;
                    default:
                        System.out.println("Stjerner afgiver partikler som tilfældigvis har ændret en bit på din computer, som nu har gjort at dette er sket. Du er en heldig vinder");
                        break;
                }
                model.update();

            } catch(Exception e) {
                // Tihi
            }
        }
    }
}
