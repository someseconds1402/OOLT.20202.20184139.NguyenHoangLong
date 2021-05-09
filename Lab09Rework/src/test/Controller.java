package test;

import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.media.Track;
import hust.soict.hespi.aims.order.Order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.ResourceBundle;



public class Controller implements Initializable {
	
	private static Order managerOrder = createManageOrder();
	private static Order newOrder = createManageOrder();
	boolean check = false;
	
	private static Order createManageOrder() {

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", "Animation", "The Lion King", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("George Lucas", "Science Fiction", "Star Wars", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker", "Science Fiction", "Aladdin", 90, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Bit Bucket", "Coder", "Javascript", 66, 15.33f);

		Book book1 = new Book("Nightmare", "Chemical periodic table", 100.0f, "Dmitri Ivanovich Mendeleev");
		Book book2 = new Book("Fiction", "Doraemon", 20.05f, "Fujiko F. Fujio", "Someone1", "Someone2");

		Track track1 = new Track(12, "Hello");
		Track track2 = new Track(10, "Send my love");
		Track track3 = new Track(8, "Someone like you");
		Track track4 = new Track(21, "All i ask");
		Track track5 = new Track(15, "Skyfall");

		CompactDisc album1 = new CompactDisc("Adele", "Classic", "21", 245.55f, track1, track2, track3, track4, track5);

		Order managerOrder = new Order();
		managerOrder.addMedia(dvd1, dvd2, dvd3, dvd4, book1, book2, album1);

		return managerOrder;
	}
	
	
	// Return homepage
	
	public void returnHomeEvent(ActionEvent e) {
		showImage.setVisible(true);
		addItems.setVisible(false);
		removeItems.setVisible(false);
		showOrder.setVisible(false);
	}
	
	
	// Button 'Create New Order' eventHandle
	
	@FXML AnchorPane showImage = new AnchorPane();
	@FXML Label topLabel = new Label();
	@FXML Label bottomLabel = new Label();
	
	public void showDialog(ActionEvent e) {
		if(check) {
			topLabel.setText("So...");
			bottomLabel.setText("That's your choice, Itachi?");
			
			showImage.setVisible(true);
			addItems.setVisible(false);
			removeItems.setVisible(false);
			showOrder.setVisible(false);
		}
		else {
			topLabel.setText("CONGRATULATION!");
			bottomLabel.setText("Create new order successful!");
			check = true;
		}
//		Dialog<String> dialog = new Dialog<String>();

//		dialog.setTitle("MESSAGE!");
//		dialog.setContentText("Create new order successful!");
//		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
//		dialog.show();
	}
	
	// Button 'Add Items' eventHandle

	@FXML private AnchorPane addItems;
	
	@FXML private TableView<Media> table;
	
	@FXML private TableColumn<Media, Integer> IDTable;
	
	@FXML private TableColumn<Media, String> TitleTable;

	@FXML private TableColumn<Media, String> CategoryTable;
	
	@FXML private TableColumn<Media, Float> CostTable;

	@FXML private TableColumn<Media, String> typeTable;
	
	private ObservableList<Media> List;
	
	@FXML private TextField searchField;
	
	public void showOptionPane(ActionEvent e) {
		if(check) {
			showImage.setVisible(false);
			addItems.setVisible(true);
			removeItems.setVisible(false);
			showOrder.setVisible(false);
		}
		else {
			topLabel.setText("WARNING!");
			bottomLabel.setText("Please create new order!");
		}
		
	}
	
	// Button 'Remove Items' eventHandle
	
	@FXML private AnchorPane removeItems = new AnchorPane();
	
	public void removeItemsEvent(ActionEvent e) {
		if(check) {
			showImage.setVisible(false);
			addItems.setVisible(false);
			removeItems.setVisible(true);
			showOrder.setVisible(true);
		}
		else {
			topLabel.setText("WARNING!");
			bottomLabel.setText("Please create new order!");
		}
	}
	
	
	// Button 'Show Order' eventHandle
	
	@FXML private TreeView<String> showOrder;
	
	public void showOrderEvent(ActionEvent e) {
		
		if(check) {
			showImage.setVisible(false);
			addItems.setVisible(false);
			removeItems.setVisible(false);
			showOrder.setVisible(true);
		}
		else {
			topLabel.setText("WARNING!");
			bottomLabel.setText("Please create new order!");
		}
		
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		
		//Add Items
		
		List = FXCollections.observableArrayList();
		
		for(Media item : managerOrder.getItemsOrdered()) {
			List.add(item);
		}
		
		IDTable.setCellValueFactory(new PropertyValueFactory<Media, Integer>("ID"));
		TitleTable.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		CategoryTable.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		CostTable.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		typeTable.setCellValueFactory(new PropertyValueFactory<Media, String>("typeString"));
		table.setItems(List);
		
		FilteredList<Media> filteredOrder = new FilteredList<>(List, b ->true);
		
		searchField.textProperty().addListener((Observable, oldValue, newValue) -> {
			filteredOrder.setPredicate(media -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				
				if(media.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if(media.getCategory().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if(media.getTypeString().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if(String.valueOf(media.getCost()).indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if(String.valueOf(media.getID()).indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else 
					return false;
				
			});
		});
		
		SortedList<Media> sortedOrder = new SortedList<>(filteredOrder);
		
		sortedOrder.comparatorProperty().bind(table.comparatorProperty());
		
		table.setItems(sortedOrder);
		
		
		//Show Order
		
		int type, size = newOrder.getSize();
		Media media;
		ArrayList<Track> tracksList;
		TreeItem<String> title, category, cost, tracks;
		TreeItem<String> root = new TreeItem<>("Your Order:");
		for(int i = 0; i < size; i++) {
			media = newOrder.pop(i);
			title = new TreeItem<>(media.getTitle());
			type = media.getType();
			
			category = new TreeItem<>("[Category]: " + media.getCategory());
			cost = new TreeItem<>("[Cost]: " + media.getCost() + "$");
			
			title.getChildren().add(category);
			
			if(type == 1) {
				title.getChildren().add(new TreeItem<>("[Author]: " + ((Book)media).getAuthor()));
			}
			else if(type == 2) {
				title.getChildren().add(new TreeItem<>("[Director]: " + ((DigitalVideoDisc)media).getDirector()));
				title.getChildren().add(new TreeItem<>("[Length]: " + ((DigitalVideoDisc)media).getLength()));
			}
			else {
				title.getChildren().add(new TreeItem<>("[Artist]: " + ((CompactDisc)media).getArtist()));
				tracksList = ((CompactDisc)media).getTracks();
				tracks = new TreeItem<>("[Tracks's Info]: ");
				for(Track track : tracksList) {
					tracks.getChildren().add(new TreeItem<>("[Title]: " + track.getTitle() + " - [Length]: " + track.getLength()));
				}
				title.getChildren().add(tracks);
			}
			title.getChildren().add(cost);
			
			root.getChildren().add(title);
			
		}
		root.getChildren().add(new TreeItem<String>("--------------------------------------------"));
		root.getChildren().add(new TreeItem<String>("***[Total cost]: " + newOrder.totalCost() + "$"));
		showOrder.setRoot(root);
		showOrder.setVisible(false);
	}
	
	
}
