package choixVoyage.gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import choixVoyage.agent.TouristAgent;
import choixVoyage.model.Reservation;

public class ResultJFrame extends javax.swing.JFrame {

	/**
	 * Creates new form ResultJFrame
	 */
	TouristAgent clientAgent;
	TouristGUIReponse TouristGUIReponse;
	ArrayList<Reservation> listReservations = new ArrayList<>();

	public ResultJFrame() {
		initComponents();
	}

	public ResultJFrame(TouristAgent clientAgent, ArrayList<Reservation> reservationsPropose) {
		this.clientAgent = clientAgent;
		this.listReservations.addAll(reservationsPropose);
		initComponents();
		// DefaultTableModel model = new DefaultTableModel();
		String titre[] = { "Company name", "Class", "Flight type", "Price", "Departure airport", "Arrival airport",
				"Departure date", "Arrival date", "nb stopover" };
		Object donnee[][];
		donnee = new Object[reservationsPropose.size()][9];
		for (int j = 0; j < reservationsPropose.size(); j++) {
			donnee[j][0] = reservationsPropose.get(j).getCompagnie();
			donnee[j][1] = reservationsPropose.get(j).getCritere().getClassevol();
			donnee[j][2] = reservationsPropose.get(j).getCritere().getTypevol();
			if (donnee[j][1] == "Economic") {
				donnee[j][3] = Double.toString(reservationsPropose.get(j).getVol().getPrixeco());
			} else {
				donnee[j][3] = Double.toString(reservationsPropose.get(j).getVol().getPrixBuss());
			}

			donnee[j][4] = reservationsPropose.get(j).getCritere().getAeroportDepart();
			donnee[j][5] = reservationsPropose.get(j).getCritere().getAeroportArrivee();
			donnee[j][6] = reservationsPropose.get(j).getCritere().getDatDepart();
			donnee[j][7] = reservationsPropose.get(j).getVol().getDatArrivee();
			donnee[j][8] = reservationsPropose.get(j).getVol().getNbEscale();
		}
		table.setModel(new DefaultTableModel(donnee, titre) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					TouristGUIReponse = new TouristGUIReponse(clientAgent, listReservations.get(row));
					// try{
					TouristGUIReponse.setVisible(true);
					/*
					 * }catch(Exception e){ e.printStackTrace(); }
					 */
					setVisible(false);
				}
			}
		});
	}

	public void activeWindow(boolean act) {
		TouristGUIReponse.setVisible(act);
	}

	public void infoBox(String infoMessage) {
		JOptionPane.showMessageDialog(this, infoMessage, "No offer", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		titreLbl = new javax.swing.JLabel();
		floLbl = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null } },
				new String[] { "Company name", "Locality", "flight type", "Price" }));
		table.setCellSelectionEnabled(true);
		jScrollPane1.setViewportView(table);

		titreLbl.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
		titreLbl.setText("List of Flights corresponding to your criteria (double click on an item for a choice)");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(titreLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addComponent(floLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
								.addComponent(titreLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(floLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										184, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 626, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(22, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel floLbl;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable table;
	private javax.swing.JLabel titreLbl;
	// End of variables declaration//GEN-END:variables
}