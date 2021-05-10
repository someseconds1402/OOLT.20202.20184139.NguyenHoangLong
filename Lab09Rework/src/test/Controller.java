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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.ResourceBundle;



public class Controller implements Initializable {
	
	private static Order managerOrder = createManageOrder();
	private static Order newOrder = new Order();
	private boolean check = false;
	private int index;
	
	private static Order createManageOrder() {

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", "Animation", "The Lion King", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("George Lucas", "Science Fiction", "Star Wars", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker", "Science Fiction", "Aladdin", 90, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Bit Bucket", "Coder", "Javascript", 66, 15.33f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Three teacher", "Parody", "Susan 0175", 66, 15.33f);

		Book book1 = new Book("Nightmare", "Chemical periodic table", 100.0f, "Dmitri Ivanovich Mendeleev");
		Book book2 = new Book("Fiction", "Doraemon", 20.05f, "Fujiko F. Fujio", "Someone1", "Someone2");
		Book book3 = new Book("Tragedy", "Nauy forest", 25.12f, "Murakami Haruki");
		Book book4 = new Book("Fantasy", "Road to thach dau", 20.12f, "S1mple");
		Book book5 = new Book("Legendary", "300 bai code thieu nhi", 100.00f, "Vozer");
		
		Track track1 = new Track(12, "Hello");
		Track track2 = new Track(10, "Send my love");
		Track track3 = new Track(8, "Someone like you");
		Track track4 = new Track(21, "All i ask");
		Track track5 = new Track(15, "Skyfall");

		CompactDisc album1 = new CompactDisc("Adele", "Classic", "21", 245.55f, track1, track2, track3, track4, track5);

		Order managerOrder = new Order();
		managerOrder.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, book1, book2, book3, book4, book5, album1);

		return managerOrder;
	}
	
	
	// Return homepage
	
	public void returnHomeEvent(ActionEvent e) {
		topLabel.setText("So...");
		bottomLabel.setText("That's your choice, Itachi?");
		sasuke.setVisible(true);
		pain.setVisible(false);
		tobirama.setVisible(false);
		
		searchField.setText(null);
		for(int i = 0; i < List2.size(); i++) {
			Media item = List2.get(i);
			if(item.getSelected().isSelected()) {
				item.getSelected().setSelected(false);;
			}
		}
		removeEventListening();
		
		showImage.setVisible(true);
		addItems.setVisible(false);
		removeItems.setVisible(false);
		showOrder.setVisible(false);
	}
	
	
	// Button 'Create New Order' eventHandle
	
	@FXML AnchorPane showImage;
	@FXML Label topLabel;
	@FXML Label bottomLabel;
	@FXML Button button1;
	@FXML ImageView sasuke, pain, tobirama;
	
	public void showDialog(ActionEvent e) {
		
		if(check) {			
			index = (int)(Math.random()*7);
			switch (index) {
			case 0:
				topLabel.setText("So...");
				bottomLabel.setText("That's your choice, Itachi?");
				sasuke.setVisible(true);
				pain.setVisible(false);
				tobirama.setVisible(false);
				break;
			case 1:
				topLabel.setText("The world...");
				bottomLabel.setText("Shall know pain!");
				sasuke.setVisible(false);
				pain.setVisible(true);
				tobirama.setVisible(false);
				break;
			case 2:
				topLabel.setText("LOVE...");
				bottomLabel.setText("hatred AROSE");
				sasuke.setVisible(false);
				pain.setVisible(true);
				tobirama.setVisible(false);
				break;
			case 3:
				topLabel.setText("In my eyes...");
				bottomLabel.setText("Only darkness remains...");
				sasuke.setVisible(true);
				pain.setVisible(false);
				tobirama.setVisible(false);
				break;
			case 4:
				topLabel.setText("What is the village?");
				bottomLabel.setText("What is shinobi? ");
				sasuke.setVisible(true);
				pain.setVisible(false);
				tobirama.setVisible(false);
				break;
			case 5:
				topLabel.setText("It was all due to the ");
				bottomLabel.setText("UCHIHA");
				sasuke.setVisible(false);
				pain.setVisible(false);
				tobirama.setVisible(true);
				break;
			case 6:
				topLabel.setText("You are also possessed by");
				bottomLabel.setText("the evil UCHIHA, kid");
				sasuke.setVisible(false);
				pain.setVisible(false);
				tobirama.setVisible(true);
				break;
			case 7:
				break;
			}
			
			showImage.setVisible(true);
			addItems.setVisible(false);
			
			for(int i = 0; i < List2.size(); i++) {
				Media item = List2.get(i);
				if(item.getSelected().isSelected()) {
					item.getSelected().setSelected(false);;
				}
			}
			removeItems.setVisible(false);
			showOrder.setVisible(false);
		}
		else {
			topLabel.setText("CREATE NEW ORDER");
			bottomLabel.setText("SUCCESSFUL!");
			check = true;
			button1.setText("Home");
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
	
	@FXML private TableColumn<Media, CheckBox> selectedTable;
	
	private ObservableList<Media> List;
	private FilteredList<Media> filteredOrder;
	private SortedList<Media> sortedOrder;
	
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
	
	// Add items eventHandle
	
	public void addItemsEvent(ActionEvent e) {
		int count = 0;
		for(int i = 0; i < sortedOrder.size(); i++) {
			Media item = sortedOrder.get(i);
			if(item.getSelected().isSelected()) {
				newOrder.addMedia(item);
				item.getSelected().setSelected(false);
				count++;
			}
		}	
//		System.out.println(newOrder.getSize());
//		System.out.println(List2.size());
//		System.out.println(sortedOrder2.size());
		Dialog<String> dialog = new Dialog<String>();
		if(count == 0) {
			dialog.setTitle("MESSAGE!");
			dialog.setContentText("No item to add!");
		} else {
			dialog.setTitle("MESSAGE!");
			dialog.setContentText("Add item(s) successful!");	
			removeEventListening();
			showEventListening();
		}
		
		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		dialog.show();

	}
	
	
	// Button 'Remove Items' eventHandle

	@FXML private AnchorPane removeItems;
	
	@FXML private TableView<Media> table2;
	
	@FXML private TableColumn<Media, Integer> IDTable2;
	
	@FXML private TableColumn<Media, String> TitleTable2;

	@FXML private TableColumn<Media, String> CategoryTable2;
	
	@FXML private TableColumn<Media, Float> CostTable2;

	@FXML private TableColumn<Media, String> typeTable2;
	
	@FXML private TableColumn<Media, CheckBox> selectedTable2;
	
	private ObservableList<Media> List2;
	
	public void showOptionPane2(ActionEvent e) {
		if(check) {
			showImage.setVisible(false);
			addItems.setVisible(false);
			removeItems.setVisible(true);
			showOrder.setVisible(false);
		}
		else {
			topLabel.setText("WARNING!");
			bottomLabel.setText("Please create new order!");
		}
		
	}
	
	
	public void removeItemsEvent(ActionEvent e) {
		int count = 0;
		for(int i = 0; i < List2.size(); i++) {
			Media item = List2.get(i);
			if(item.getSelected().isSelected()) {
				newOrder.removeMedia(item);
				count++;
			}
		}
		Dialog<String> dialog = new Dialog<String>();
		if(count == 0) {
			dialog.setTitle("MESSAGE!");
			dialog.setContentText("No item to remove!");
		} else {
			dialog.setTitle("MESSAGE!");
			dialog.setContentText("Remove item(s) successful!");	
			removeEventListening();
			showEventListening();
		}
		
		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		dialog.show();
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
		
		addEventListening();
		
		//Remove Items
		removeEventListening();
	
		//Show Order
		showEventListening();
		
	}
	
	
	/******************************************************************************/
	//Draw layout in addEvent
	
	public void addEventListening() {
		List = FXCollections.observableArrayList();
		
		for(Media item : managerOrder.getItemsOrdered()) {
			CheckBox cb = new CheckBox();
			item.setSelected(cb);
			List.add(item);
		}
		
		IDTable.setCellValueFactory(new PropertyValueFactory<Media, Integer>("ID"));
		TitleTable.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		CategoryTable.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		CostTable.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		typeTable.setCellValueFactory(new PropertyValueFactory<Media, String>("typeString"));
		selectedTable.setCellValueFactory(new PropertyValueFactory<Media, CheckBox>("selected"));
		table.setItems(List);
		
		filteredOrder = new FilteredList<>(List, b ->true);
		
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
		
		sortedOrder = new SortedList<>(filteredOrder);
		
		sortedOrder.comparatorProperty().bind(table.comparatorProperty());
		
		table.setItems(sortedOrder);
	}
	
	/******************************************************************************/
	//Draw layout in addEvent
	
	public void removeEventListening() {
		List2 = FXCollections.observableArrayList();
		
		for(Media item : newOrder.getItemsOrdered()) {
			CheckBox cb = new CheckBox();
			item.setSelected(cb);
			List2.add(item);
		}
		
		IDTable2.setCellValueFactory(new PropertyValueFactory<Media, Integer>("ID"));
		TitleTable2.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		CategoryTable2.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		CostTable2.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		typeTable2.setCellValueFactory(new PropertyValueFactory<Media, String>("typeString"));
		selectedTable2.setCellValueFactory(new PropertyValueFactory<Media, CheckBox>("selected"));
		table2.setItems(List2);
	}
	
	
	/******************************************************************************/
	//Draw layout in showEvent
	
	public void showEventListening() {
		int type, size = newOrder.getSize();
		Media media;
		ArrayList<Track> tracksList;
		TreeItem<String> title, category, cost, tracks;
		TreeItem<String> root = new TreeItem<>();
		root.getChildren().add(new TreeItem<>("***********************************************"));
		root.getChildren().add(new TreeItem<>("***[Your Order]:"));
		
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
		showOrder.setShowRoot(false);
		showOrder.setVisible(false);
	}
}
