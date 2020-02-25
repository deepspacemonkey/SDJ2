package via.sdj2.thread.viewmodel;

import via.sdj2.thread.model.TemperatureModel;

public class ViewModelFactory {
    private TemperatureViewModel temperatureViewModel;

    public ViewModelFactory(TemperatureModel model) {
        temperatureViewModel = new TemperatureViewModel(model);
    }

    public TemperatureViewModel getTemperatureViewModel() {
        return temperatureViewModel;
    }
}
