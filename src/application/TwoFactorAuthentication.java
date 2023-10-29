package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class TwoFactorAuthentication {
	//2FA GUI Components
	@FXML
	private AnchorPane twoFAScene;
	@FXML
	private Circle circleLogo;
	@FXML
	private Line checkLogo1, checkLogo2;
	@FXML
	private Label nameLogo, sceneLabel, emailNotifLabel, timerLabel;
	@FXML
	private VBox vb;
	@FXML
	private TextField keyField;
	@FXML
	private Button verifyButton;
	//private static Timer timer;
	private static int delay, interval;
	private ScheduledExecutorService scheduler;
	private ScheduledFuture<?> timer;
	
	@FXML
	//initializes GUI components
	public void initialize() {
		twoFAScene = new AnchorPane();
		twoFAScene.getChildren().add(timerLabel);
		
		//connects keyField to handler and connects verifyButton to button handler within key handler
		keyField = new TextField();
		keyField.setOnAction(this::keyFieldHandler);
		
		//starting state of timer
		timerLabel = new Label("1:00");
		timerLabel.setVisible(true);
		
		verifyButton.setOnAction(this::verifyButtonHandler);
		//instantiate timerHandler to start timer and connect it to timerLabel
		/*delay = 1;
		interval = 59;
		timerHandler();*/
	}
	
	//handler for generating random key for 2FA
	public String keyGenerator(int keyLength) {
		String keyChars = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder keyBuilder = new StringBuilder(keyLength);
		
		for(int i = 0; i <= keyLength+1; i++) {
			int index = (int) (keyChars.length() * Math.random());
			keyBuilder.append(keyChars.charAt(index));
		}
		
		System.out.println(keyBuilder.toString());
		return keyBuilder.toString();
	}
	
	//key password field event handler for inputting key
	public void keyFieldHandler(ActionEvent event) {
		/*String key = keyGenerator(7);
		
		while(!verifyButton.isPressed()) {
			if(keyField.getText().equals(key)) {
				verifyButton.setOnAction(this::verifyButtonHandler);
				break;
			}
		}*/
	}
	
	//verification button event handler to move to home scene
	public void verifyButtonHandler(ActionEvent event) {
		Main.setScene("/Home.fxml");
	}
	
	//counts down timer and returns to login screen if reaches 0
	private void timerHandler() {
		scheduler = Executors.newScheduledThreadPool(1);
		Runnable countdown = () -> timerLabelDisplay();
		timer = scheduler.scheduleWithFixedDelay(countdown, delay, delay, TimeUnit.SECONDS);
		Runnable endCountdown = () -> timer.cancel(true);
		scheduler.schedule(endCountdown, 61, TimeUnit.SECONDS);
		Main.setScene("/LoginScreen.fxml");
	}
	
	private void timerLabelDisplay() {
		timerLabel.setText(String.format("0:%d", interval));
		--interval;
	}
}
