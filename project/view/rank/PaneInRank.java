package view.rank;

import java.awt.*;

import javax.swing.*;

import model.RankModel;

@SuppressWarnings("serial")
public class PaneInRank extends JPanel implements ListCellRenderer<RankModel> {
	JLabel lbNum, lbName, lbType;

	public PaneInRank() {
		setLayout(new BorderLayout());
		
		lbNum = new JLabel();
		lbNum.setPreferredSize(new Dimension(35, 20));
		lbNum.setMinimumSize(new Dimension(35, 20));
		
		lbName = new JLabel();
		lbName.setPreferredSize(new Dimension(100, 20));
		lbName.setMinimumSize(new Dimension(100, 20));
		lbName.setHorizontalAlignment(JLabel.CENTER);
		lbName.setVerticalAlignment(JLabel.CENTER);

		lbType = new JLabel();
		lbType.setPreferredSize(new Dimension(80, 20));
		lbType.setMinimumSize(new Dimension(80, 20));
		lbType.setHorizontalAlignment(JLabel.CENTER);
		lbType.setVerticalAlignment(JLabel.CENTER);
		
		setBackground(new Color(100, 250, 190));

		add(lbNum, BorderLayout.WEST);
		add(lbName, BorderLayout.CENTER);
		add(lbType, BorderLayout.EAST);
		setSize(215, 20);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends RankModel> list, RankModel valueOfRanlElement, int index,
			boolean isSelected, boolean cellHasFocus) {
		lbNum.setText(" " + valueOfRanlElement.getStt());
		lbName.setText(valueOfRanlElement.getName());
		lbType.setText(valueOfRanlElement.getValue() + "");
		return this;
	}
}
