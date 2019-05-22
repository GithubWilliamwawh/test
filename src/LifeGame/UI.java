package LifeGame;

import LifeGame.Matrix;
import LifeGame.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class UI extends JFrame {
	private JButton startGameBtn = new JButton("开始游戏");

	private Matrix cellMatrix = new Matrix(40, 50, Init.arrow);;
	private JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
	private JPanel gridPanel = new JPanel();

	private JTextField[][] textMatrix;

	private boolean isStart = true;
	private boolean stop = false;

	public UI() {
		setTitle("生命游戏");
		startGameBtn.addActionListener(new StartGameActioner());

		buttonPanel.add(startGameBtn);
		buttonPanel.setBackground(Color.WHITE);

		getContentPane().add("North", buttonPanel);

		this.setSize(1000, 1200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private class StartGameActioner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!isStart) {

				// 获取时

				new Thread(new GameControlTask()).start();

			} else {
				stop = true;
				isStart = false;
				startGameBtn.setText("开始游戏");

				initGridLayout();
				showMatrix();
				gridPanel.updateUI();
			}
		}
	}

	private void showMatrix() {

		int[][] matrix = cellMatrix.getMatrix();
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[0].length; x++) {
				if (matrix[y][x] == 1) {
					textMatrix[y][x].setBackground(Color.BLACK);
				} else {
					textMatrix[y][x].setBackground(Color.WHITE);
				}
			}
		}
	}

	private void initGridLayout() {
		int rows = cellMatrix.getHeight();
		int cols = cellMatrix.getWidth();
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(rows, cols));
		textMatrix = new JTextField[rows][cols];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				JTextField text = new JTextField();
				textMatrix[y][x] = text;
				gridPanel.add(text);
			}
		}
		add("Center", gridPanel);

	}

	private class GameControlTask implements Runnable {

		public void run() {

			while (true) {
				cellMatrix.transform();
				showMatrix();

				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

		}
	}

}
