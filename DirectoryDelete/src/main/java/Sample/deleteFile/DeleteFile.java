package Sample.deleteFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Custom button");

		int returnValue = jfc.showDialog(null, "Delete");
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			
			System.out.println(jfc.getSelectedFile().getPath());
			String fileName = jfc.getSelectedFile().getPath();
			File fileObj = new File(fileName);
			try {
				
				if(fileObj.delete()) {
					JOptionPane.showMessageDialog(new JFrame(), "File successfully deleted !!");
				}else {
					fileObj.deleteOnExit();
					JOptionPane.showMessageDialog(new JFrame(), "After restart, Your file will be deleted. Don't worry !!");
					Runtime r = Runtime.getRuntime();
					r.exec("shutdown -r -t "+10);
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), "System errors occur, Please try again later !!");
				System.out.println(e);
			}
		}
	}

}
