package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import model.AuctionModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AuctionItemViewModel implements PropertyChangeListener {
    private StringProperty item;
    private StringProperty time;
    private IntegerProperty bid;
    private StringProperty bidder;
    private IntegerProperty currentBid;
    private StringProperty currentBidder;
    private StringProperty error;
    private BooleanProperty end;
    private StringProperty currentBidTitle;
    private AuctionModel model;

    public AuctionItemViewModel(AuctionModel model) {
        this.model = model;
        item = new SimpleStringProperty(model.getItem());
        time = new SimpleStringProperty();
        bid = new SimpleIntegerProperty();
        bidder = new SimpleStringProperty("You");
        currentBid = new SimpleIntegerProperty(model.getCurrentBid());
        currentBidder = new SimpleStringProperty(model.getCurrentBidder());
        error = new SimpleStringProperty();
        end = new SimpleBooleanProperty();
        currentBidTitle = new SimpleStringProperty("Bid:");
        model.addListener("bid", this);
        model.addListener("time", this);
        model.addListener("end", this);
    }

    public void clear() {
        item.set(null);
        time.set(null);
        bid.set(0);
        bidder.set(null);
        currentBid.set(0);
        currentBidder.set(null);
        error.set(null);
        end.set(false);
        currentBidTitle.set(null);
    }

    public void bid() {
        if (!model.placeBid(bid.get(), bidder.get())) {
            Platform.runLater(() -> error.set("Bid was not placed"));
        } else {
            Platform.runLater(() -> error.set(null));
        }
    }

    public StringProperty itemProperty() {
        return item;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public IntegerProperty bidProperty() {
        return bid;
    }

    public StringProperty bidderProperty() {
        return bidder;
    }

    public IntegerProperty currentBidProperty() {
        return currentBid;
    }

    public StringProperty currentBidderProperty() {
        return currentBidder;
    }

    public StringProperty errorProperty() {
        return error;
    }

    public BooleanProperty endProperty() {
        return end;
    }

    public StringProperty currentBidTitleProperty() {
        return currentBidTitle;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "bid":
                Platform.runLater(() -> {
                    currentBidder.set(model.getCurrentBidder());
                    currentBid.set(model.getCurrentBid());
                });
                break;
            case "time":
                Platform.runLater(() -> time.set(String.format("00:00:%02d", model.getRemainingTimeInSeconds())));
                break;
            case "end":
                Platform.runLater(() -> {
                    currentBidTitle.set("Final Bid: ");
                    error.set("Bid ended");
                });
                end.set(true);
                break;
        }
    }
}
