package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import model.BoardGameModel;
import model.LevelModel;
import model.RecordModel;

public class SaveGame /* extends HashMap<String, String> */ {
	BoardGameModel model;
	RecordModel rcModel;

	public SaveGame(BoardGameModel model, RecordModel rcModel) {
		this.model = model;
		this.rcModel = rcModel;
	}

	public void saveBoard() {
		StringBuffer s = new StringBuffer();
		s.append(model.getM() + "-");
		s.append(model.getN() + "-");
		s.append(rcModel.getTurn() + "-");
		s.append(rcModel.getScore() + "-");
		LevelModel lv = rcModel.getLv();
		s.append(lv.getX() + "-");
		s.append(model.convertLuuVtriToString());
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("board.txt"), "utf-8"));
			writer.write(s.toString());
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}
	}

	public String readBoard() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("board.txt"));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				String everything = sb.toString();
				return everything;
			} catch (Exception e) {

			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}

	}

	public void saveImages() {
		StringBuffer s = new StringBuffer();
		s.append(model.converLuuiMagesToString());
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("images.txt"), "utf-8"));
			writer.write(s.toString());
		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}

	}

	public String readImages() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("images.txt"));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				String everything = sb.toString();
				return everything;
			} catch (Exception e) {

			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return null;

		}

	}

	// public void saveHighScore(String filename) {
	// File file = new File(filename);
	// FileWriter fw = null;
	// try {
	// fw = new FileWriter(file.getName(), true);
	// } catch (IOException e1) {
	// e1.printStackTrace();
	// }
	// BufferedWriter bufferwrite = new BufferedWriter(fw);
	// try {
	// StringBuffer s = new StringBuffer();
	// s.append(boardGame.name + "-");
	// if (filename == "highscore.txt")
	// s.append(boardGame.rc.getScore() + "\n");
	// if (filename == "hightime.txt")
	// s.append(boardGame.rc.countTime + "\n");
	// if (filename == "highturn.txt")
	// s.append(boardGame.rc.getTurn() + "\n");
	//
	// if (!file.exists())
	// file.createNewFile();
	// bufferwrite.write(s.toString());
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// bufferwrite.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// }
	//// Stringtokenize
	// public ArrayList readHighScore(String filename) {
	// ArrayList<ElemtOfHighScore> lstElemt = new ArrayList<>();
	// BufferedReader br = null;
	// try {
	// br = new BufferedReader(new FileReader(filename));
	// try {
	// StringBuilder sb = new StringBuilder();
	// String line = br.readLine();
	//
	// while (line != null) {
	//
	// sb.append(line);
	// sb.append(System.lineSeparator());
	// line = br.readLine();
	// }
	// String everything = sb.toString();
	// } catch (Exception e) {
	//
	// } finally {
	// try {
	// br.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// return null;
	// } catch (FileNotFoundException e1) {
	// e1.printStackTrace();
	// return null;
	// }
	// }

	class ElemtOfHighScore {
		private String name;
		private int number;

		public ElemtOfHighScore(String name, int number) {
			super();
			this.name = name;
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
	}
}
