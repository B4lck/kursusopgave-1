package viewmodel;

import model.Model;

public class ViewModelFactory {

    private ViewState viewState;
    private RecordListViewModel recordListViewModel;
    private ManageRecordViewModel manageRecordViewModel;

    public ViewModelFactory(Model model) {
        viewState = new ViewState();
        recordListViewModel = new RecordListViewModel(model, viewState);
        manageRecordViewModel = new ManageRecordViewModel(model, viewState);
    }

    public RecordListViewModel getRecordListViewModel() {
        return recordListViewModel;
    }

    public ManageRecordViewModel getManageRecordViewModel() {
        return manageRecordViewModel;
    }
}
