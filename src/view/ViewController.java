package view;

import javafx.scene.layout.Region;

public abstract class ViewController<T> {
    private ViewHandler viewHandler;
    private Region root;
    private T viewModel;

    protected abstract void init();
}
