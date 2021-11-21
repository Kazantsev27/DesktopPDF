package pdf;

import javax.swing.JOptionPane;

public class exit {

	public exit(String exitHat,String exitLow) {
	int exit = JOptionPane.showConfirmDialog(null,
            exitHat,
            exitLow,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
	
	if (JOptionPane.YES_OPTION==exit) {
		System.exit(1);
	}
	
	}
}
	
