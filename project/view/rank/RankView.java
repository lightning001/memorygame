package view.rank;

import java.awt.Color;
import java.io.*;
import java.util.*;

import javax.swing.*;

import model.RankModel;

@SuppressWarnings("serial")
public class RankView extends JInternalFrame {
	JList<RankModel> lstTime, lstTurn;
	public ArrayList<RankModel> arraylistTime;
	public ArrayList<RankModel> arraylistTurn;

	JTabbedPane tbpane;
	DefaultListModel<RankModel> modelTime;
	DefaultListModel<RankModel> modelTurn;
	public static final String FILETIME = "hightime.txt";
	public static final String FILETURN = "highturn.txt";

	public RankView() {
		setResizable(false);
		setClosable(true);
		setMaximizable(false);
		setIconifiable(false);
		setBackground(new Color(39, 233, 194));
		tbpane = new JTabbedPane(JTabbedPane.TOP);

		lstTime = new JList<RankModel>();
		lstTime.setCellRenderer(new PaneInRank());
		modelTime = new DefaultListModel<>();

		arraylistTime = readData(RankView.FILETIME);
		if (arraylistTime.size() > 0)
			if (arraylistTime.size() < 10)
				for (int i = 0; i < arraylistTime.size(); i++) {
					modelTime.addElement(arraylistTime.get(i));
				}
			else {
				for (int i = 0; i < 10; i++) {
					modelTime.addElement(arraylistTime.get(i));
				}
			}
		lstTime.setModel(modelTime);

		lstTurn = new JList<RankModel>();
		lstTurn.setCellRenderer(new PaneInRank());
		modelTurn = new DefaultListModel<>();

		arraylistTurn = readData(RankView.FILETURN);
		if (arraylistTurn.size() > 0)
			if (arraylistTurn.size() < 10) {
				for (int i = 0; i < arraylistTurn.size(); i++) {
					modelTurn.addElement(arraylistTurn.get(i));
				}
			} else {
				for (int i = 0; i < 10; i++) {
					modelTurn.addElement(arraylistTurn.get(i));
				}
			}
		lstTurn.setModel(modelTurn);

		JPanel pnTime = new RankPanel(new NameofRank(NameofRank.ONE_TIME), lstTime);
		JPanel pnTurn = new RankPanel(new NameofRank(NameofRank.ONE_TURN), lstTurn);

		tbpane.addTab("Time", null, pnTime, "Click to view Time Rank");
		tbpane.addTab("Turn", null, pnTurn, "Click to view Turn Rank");
		add(tbpane);

//		setVisible(true);
		setSize(250, 290);
	}

	public void addTimeRank(RankModel elemt) {
		modelTime = (DefaultListModel<RankModel>) lstTime.getModel();
		arraylistTime.add(elemt);
		modelTime.addElement(elemt);
		sortRank(arraylistTime);
		if (modelTime.size() < 10)
			for (int i = 0; i < modelTime.size() - 1; i++) {
				modelTime.set(i, arraylistTime.get(i));
			}
		else {
			for (int i = 0; i < modelTime.size() - 1; i++) {
				modelTime.set(i, arraylistTime.get(i));
			}
			modelTime.remove(modelTime.size() - 1);
		}
		lstTime.setModel(modelTime);
	}

	public void addTurnRank(RankModel elemt) {
		modelTurn = (DefaultListModel<RankModel>) lstTurn.getModel();
		arraylistTurn.add(elemt);
		modelTurn.addElement(elemt);
		sortRank(arraylistTurn);
		if (arraylistTurn.size() < 10)
			for (int i = 0; i < arraylistTurn.size(); i++) {
				modelTurn.set(i, arraylistTurn.get(i));
			}
		else {
			for (int i = 0; i < arraylistTurn.size(); i++) {
				modelTurn.set(i, arraylistTurn.get(i));
			}
			modelTurn.remove(modelTurn.size() - 1);
		}
		lstTurn.setModel(modelTurn);
	}

	public void saveRankElemtToFile(String filename, RankModel elemt) {
		File file = new File(filename);
		// dung FileWrite de ghi tiep vao du lieu da co trong file
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getName(), true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		BufferedWriter bufferwrite = new BufferedWriter(fw);
		try {
			StringBuffer s = new StringBuffer();
			s.append(elemt.getStt() + ":" + elemt.getName() + ":" + elemt.getValue() + "\n");
			bufferwrite.write(s.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferwrite.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String readRank(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
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

	public ArrayList<RankModel> readData(String fileName) {
		ArrayList<RankModel> arraylist = new ArrayList<>();
		String s = readRank(fileName);
		System.out.println("File Time: " + s);
		String[] tmp = null;
		if (s.length() > 3) {
			tmp = readRank(fileName).split("\n");
			if (tmp.length > 0) {
				ArrayList<String> arrTmp = new ArrayList<>();
				for (int i = 0; i < tmp.length; i++) {
					if (!tmp[i].equals("") && !tmp[i].isEmpty())
						arrTmp.add(tmp[i]);
					System.out.println("mdmds" + arrTmp.get(i).toString());
				}
				int i = 0;
				System.out.println("tmp: " + tmp.length + "  arrTmp: " + arrTmp.size());
				while (!arrTmp.isEmpty() && i < arrTmp.size()) {
					StringTokenizer st = new StringTokenizer(arrTmp.get(i), ":");
					System.out.println("arr: " + arrTmp.get(i).toString());
					int stt = Integer.parseInt(st.nextToken().trim());
					String name = st.nextToken().trim();
					int score = Integer.parseInt(st.nextToken().trim());
					arraylist.add(new RankModel(stt, name, score));
					i++;
				}
			}
			arraylist = sortRank(arraylist);
		}
		return arraylist;
	}

	public ArrayList<RankModel> sortRank(ArrayList<RankModel> arraylist) {
		if (!arraylist.isEmpty()) {
			Collections.sort(arraylist, new Comparator<RankModel>() {
				@Override
				public int compare(RankModel r1, RankModel r2) {
					if (r1.getValue() - r2.getValue() > 0)
						return -1;
					if (r1.getValue() - r2.getValue() == 0)
						return 0;
					return 1;
				}
			});
			for (int i = 0; i < arraylist.size(); i++) {
				arraylist.get(i).setStt(i + 1);
			}
		}
		return arraylist;
	}
}
