package via.sdj2.thread.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import via.sdj2.thread.external.ObservableClock;
import via.sdj2.thread.external.RunnableClock;
import via.sdj2.thread.model.TemperatureModel;
import via.sdj2.thread.viewmodel.TemperatureViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static java.lang.Thread.sleep;

public class TemperatureViewController
{
  @FXML private TextField textInput;

  @FXML private Label labelTimer;

  @FXML private Label labelOutput;

  private TemperatureViewModel model;
  private Region root;
  private ViewHandler viewHandler;

  public TemperatureViewController()
  {
  }

  public void init(ViewHandler viewHandler, TemperatureViewModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    textInput.textProperty().bindBidirectional(model.tempInProperty());
    labelOutput.textProperty().bind(model.tempOutProperty());
    labelTimer.textProperty().bind(model.timeProperty());
  }

  private void showTime(String timeString){
    Platform.runLater(() -> labelTimer.setText(timeString));
    try {
      sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void reset()
  {
    textInput.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void toCelsius()
  {
    model.toCelsius();
  }

  @FXML private void toFahrenheit()
  {
    model.toFahrenheit();
  }
}