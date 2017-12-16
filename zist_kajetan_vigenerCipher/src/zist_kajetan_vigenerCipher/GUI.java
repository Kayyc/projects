package zist_kajetan_vigenerCipher;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField sifriranoTextField;
	private JTextField kljucTextField;
	private JTextField desifriranoKljucTextField;
	private JTextArea desifriranoTextArea;
	private JTextArea SifriranoTextArea;
	JFileChooser sifriranoFile = new JFileChooser("E:\\eclipse_kis");
	VigenerCipher vc = new VigenerCipher();
	public GUI() {		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblVnesiKljuZa = new JLabel("Vnesi klju\u010D za de\u0161ifriranje besedila");
		
		desifriranoKljucTextField = new JTextField();
		desifriranoKljucTextField.setColumns(10);
		
		JButton shraniKljucDekriptiranje = new JButton("Shrani kljuc");
		shraniKljucDekriptiranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kljuc = desifriranoKljucTextField.getText();
				vc.shraniKljuc(kljuc);
			}
		});
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JButton btnDeifriraj = new JButton("De\u0161ifriraj");
		btnDeifriraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desifrirajBesedilo(e);
			}
		});
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblVnesiKljuZa)
							.addContainerGap(351, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(desifriranoKljucTextField, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(shraniKljucDekriptiranje)
							.addGap(34))))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(132)
					.addComponent(btnDeifriraj, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblVnesiKljuZa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(desifriranoKljucTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(shraniKljucDekriptiranje))
					.addGap(18)
					.addComponent(btnDeifriraj)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblSifriranoTitle = new JLabel("\u0160ifrirano besedilo");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblDesifriranoTitle = new JLabel("De\u0161ifrirano besedilo");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, 0, 0, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesifriranoTitle, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSifriranoTitle))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSifriranoTitle))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblDesifriranoTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		
		desifriranoTextArea = new JTextArea();
		scrollPane_1.setViewportView(desifriranoTextArea);
		
		SifriranoTextArea = new JTextArea();
		scrollPane.setViewportView(SifriranoTextArea);
		
		JButton btnOdpriDatoteko = new JButton("Odpri datoteko");
		btnOdpriDatoteko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				odpriDatoteko(arg0);
			}
		});
		
		sifriranoTextField = new JTextField();
		sifriranoTextField.setColumns(10);
		
		JLabel lblSifriranjeTitle = new JLabel("Odpri datoteko, ki jo \u017Eeli\u0161 \u0161ifrirati");
		
		JLabel lblVnesiKlju = new JLabel("Vnesi klju\u010D");
		
		kljucTextField = new JTextField();
		kljucTextField.setColumns(10);
		
		JButton btnShraniKljuc = new JButton("Shrani kljuc");
		btnShraniKljuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vc.shraniKljuc(kljucTextField.getText());
				JOptionPane.showMessageDialog(btnShraniKljuc, "Ključ je bil shranjen");
			}
		});
		
		JButton btnSifriraj = new JButton("\u0160ifriraj");
		btnSifriraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sifrirajBesedilo(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblSifriranjeTitle)
							.addContainerGap(97, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblVnesiKlju)
							.addContainerGap(205, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(kljucTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(sifriranoTextField, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnShraniKljuc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnOdpriDatoteko, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(22))))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(76)
					.addComponent(btnSifriraj, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
					.addGap(79))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblSifriranjeTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(sifriranoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOdpriDatoteko))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVnesiKlju)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(kljucTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShraniKljuc))
					.addGap(18)
					.addComponent(btnSifriraj)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		pack();
	}
	
	private void odpriDatoteko(ActionEvent e) {
		if(sifriranoFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = sifriranoFile.getSelectedFile();
			String filename = f.getAbsolutePath();
			sifriranoTextField.setText(f.getName());
			try {
				vc.preberiBesedilo(filename);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void sifrirajBesedilo(ActionEvent e) {
		String text = vc.sifriraj(vc.getFiletext(), vc.getKljuc());
		vc.setFiletext(text);
		SifriranoTextArea.setText(text);
	}
	
	private void desifrirajBesedilo(ActionEvent e) {
		String text = vc.desifriraj(vc.getFiletext(), vc.getKljuc());
		desifriranoTextArea.setText(text);
	}
}

