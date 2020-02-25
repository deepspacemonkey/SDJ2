package via.sdj2.thread.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import via.sdj2.thread.external.ObservableClock;
import via.sdj2.thread.model.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;

public class TemperatureViewModel implements PropertyChangeListener {
    private StringProperty tempIn;
    private StringProperty tempOut;
    private StringProperty time;
    private TemperatureModel model;

    public TemperatureViewModel(TemperatureModel model) {
        tempIn = new SimpleStringProperty();
        tempOut = new SimpleStringProperty();
        time = new SimpleStringProperty();
        this.model = model;
        ObservableClock clock = new ObservableClock();
        clock.addListener(this);
        Thread thread = new Thread(clock);
        thread.setDaemon(true);
        thread.start();
    }

    public StringProperty tempInProperty() {
        return tempIn;
    }

    public StringProperty tempOutProperty() {
        return tempOut;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void toCelsius() {
        try {
            double temperature = Double.parseDouble(tempIn.get());
            double converted = model.toCelsius(temperature);
            tempOut.set(Double.toString(converted));
            tempIn.set(null);
        } catch (NumberFormatException e) {
            tempOut.set("Invalid input");
        } catch (NullPointerException e) {
            tempOut.set("Empty input");
        }
    }

    public void toFahrenheit() {
        try {
            double temperature = Double.parseDouble(tempIn.get());
            double converted = model.toFahrenheit(temperature);
            tempOut.set(Double.toString(converted));
            tempIn.set(null);
        } catch (NumberFormatException e) {
            tempOut.set("Invalid input");
        } catch (NullPointerException e) {
            tempOut.set("Empty input");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> time.set((String) evt.getNewValue()));
    }
}
