package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

import java.util.HashMap;
import java.util.Map;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;

    private ViewModelFactory viewModelFactory;

    private Map<String, ViewController> controllers = new HashMap<>();

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView(ViewID.RECORD_LIST);
    }

    public void openView(ViewID view) {
        Region root = null;

        switch (view) {
            case RECORD_LIST -> root = getRoot(view, viewModelFactory.getRecordListViewModel(), this);
            case MANAGE_RECORD -> root = getRoot(view, viewModelFactory.getManageRecordViewModel(), this);
        }

        if (root == null) {
            throw new IllegalStateException("Bro siden findes ik din noob");
        }

        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null) {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    private <T> Region getRoot(ViewID viewId, T viewModel, ViewHandler viewHandler) {
        ViewController<T> vc = controllers.get(viewId.name());

        if (vc == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(viewId.getFilename()));
                Region root = loader.load();
                vc = loader.getController();
                vc.init(this, viewModel, root);
                controllers.put(viewId.name(), vc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        vc.reset();

        return vc.getRoot();
    }

}
