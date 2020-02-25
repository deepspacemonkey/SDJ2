package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.AuctionItemViewModel;

public class AuctionItemViewController {
    @FXML
    private Label itemLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label currentBidTitle;
    @FXML
    private Label currentBidLabel;
    @FXML
    private Label currentBidderLabel;
    @FXML
    private TextField bidField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button bidButton;
    private ViewHandler viewHandler;
    private Region root;
    private AuctionItemViewModel viewModel;

    public AuctionItemViewController() {
    }

    public void init(ViewHandler viewHandler, AuctionItemViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
        itemLabel.textProperty().bind(viewModel.itemProperty());
        timeLabel.textProperty().bind(viewModel.timeProperty());
        currentBidTitle.textProperty().bind(viewModel.currentBidTitleProperty());
        currentBidderLabel.textProperty().bind(viewModel.currentBidderProperty());
        Bindings.bindBidirectional(currentBidLabel.textProperty(), viewModel.currentBidProperty(), new StringIntegerConverter(0));
        Bindings.bindBidirectional(bidField.textProperty(), viewModel.bidProperty(), new StringIntegerConverter(0));
        errorLabel.textProperty().bind(viewModel.errorProperty());
        viewModel.endProperty().addListener((obs, oldValue, newValue) -> {
            timeLabel.setStyle("-fx-background-color:RED");
            bidButton.setDisable(true);
        });
    }

    public void reset() {
        itemLabel.setText(null);
        timeLabel.setText(null);
        currentBidTitle.setText(null);
        currentBidderLabel.setText(null);
        currentBidLabel.setText(null);
        bidField.setText(null);
    }

    public Region getRoot() {
        return root;
    }

    @FXML
    public void bidOnAction() {
        viewModel.bid();
    }
}
