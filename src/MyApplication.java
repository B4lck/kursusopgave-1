import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.Record;
import model.RecordLibrary;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Model model = new RecordLibrary();

        model.addRecord(new Record("Let Me Entertain You", "Robbie Williams Jam", 2012));

        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);
    }
}
