package view.rank;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JPanel;

import model.RankModel;

@SuppressWarnings("serial")
public class RankPanel extends JPanel {
	public RankPanel(NameofRank title, JList<RankModel> lst) {
		setLayout(new BorderLayout());
		
		add(title, BorderLayout.PAGE_START);
		title.setBackground(new Color(39, 233, 194));
		add(lst, BorderLayout.CENTER);
	}
}
