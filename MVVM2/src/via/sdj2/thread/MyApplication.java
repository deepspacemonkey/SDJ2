package via.sdj2.thread;

import javafx.application.Application;
import javafx.stage.Stage;
import via.sdj2.thread.model.TemperatureModel;
import via.sdj2.thread.model.TemperatureModelManager;
import via.sdj2.thread.view.ViewHandler;
import via.sdj2.thread.viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();
    ViewModelFactory factory = new ViewModelFactory(model);

    // View
    ViewHandler view = new ViewHandler(factory);
    view.start(primaryStage);

  }
}
