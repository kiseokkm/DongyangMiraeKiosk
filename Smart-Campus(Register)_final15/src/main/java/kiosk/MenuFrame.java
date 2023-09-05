/*
 * Copyright (c) 2020 Self-Order Kiosk
 */
package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import java.awt.FlowLayout;

import kiosk.NoticeFrame;


public class MenuFrame extends javax.swing.JFrame implements StateObserver {

  services.ItemService itemService;
  OrderTable tbmOrder;
  java.util.ArrayList<models.Item> itemsMealCombos;
  java.util.ArrayList<models.Item> itemsSides;
  java.util.ArrayList<models.Item> itemsDesserts;
  java.util.ArrayList<models.Item> itemsBeverages;

  /**
   * Creates new form MenuFrame
   */
  public MenuFrame() {
     try {
           app.Global.setAppIcon(this);

           /**
            * Initialize
            */
           initModels();
           initComponents();
           initCustomComponents();
           initState();
       } catch (Exception e) {
           e.printStackTrace(); // 여기서 오류 메시지를 출력합니다.
           JOptionPane.showMessageDialog(this, "An error occurred while initializing the frame: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
   }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Fform Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    pnlContent = new javax.swing.JPanel();
    tabbedPane = new javax.swing.JTabbedPane();
    pnlMealCombos = new javax.swing.JPanel();
    pnlSides = new javax.swing.JPanel();
    pnlDesserts = new javax.swing.JPanel();
    pnlBeverages = new javax.swing.JPanel();
    pnlOrder = new javax.swing.JPanel();
    lblOrder = new javax.swing.JLabel();
    scpOrder = new javax.swing.JScrollPane();
    tblOrder = new javax.swing.JTable();
    pnlTotal = new javax.swing.JPanel();
    lblTotal = new javax.swing.JLabel();
    lblTotalValue = new javax.swing.JLabel();
    pnlFooter = new javax.swing.JPanel();
    btnBack = new javax.swing.JButton();
    btnContinue = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Menu");
    setMinimumSize(new java.awt.Dimension(720, 860));
    setName(""); // NOI18N
    setPreferredSize(new java.awt.Dimension(720, 860));

    pnlContent.setLayout(new java.awt.GridBagLayout());

    tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
    tabbedPane.setMinimumSize(new java.awt.Dimension(574, 400));
    tabbedPane.setPreferredSize(new java.awt.Dimension(700, 400));
    tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        tabbedPaneStateChanged(evt);
      }
    });

    pnlMealCombos.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));
    pnlMealCombos.setMaximumSize(new java.awt.Dimension(0, 0));
    pnlMealCombos.setPreferredSize(new java.awt.Dimension(560, 500));
    pnlMealCombos.setLayout(new java.awt.GridLayout(2, 3, 20, 20));
    tabbedPane.addTab("공지사항", pnlMealCombos);

    pnlSides.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));
    pnlSides.setLayout(new java.awt.GridLayout(2, 3, 20, 20));
    tabbedPane.addTab("강의실 안내", pnlSides);

    pnlDesserts.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));
    pnlDesserts.setLayout(new java.awt.GridLayout(2, 3, 20, 20));
    tabbedPane.addTab("학식 정보", pnlDesserts);

    pnlBeverages.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));
    pnlBeverages.setLayout(new java.awt.GridLayout(2, 3, 20, 20));
    tabbedPane.addTab("캠퍼스 지도", pnlBeverages);
    
    pnlAcademicSchedule = new javax.swing.JPanel();
    pnlAcademicSchedule.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));
    pnlAcademicSchedule.setLayout(new java.awt.GridLayout(2, 3, 20, 20));
    tabbedPane.addTab("학사 일정", pnlAcademicSchedule);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
    pnlContent.add(tabbedPane, gridBagConstraints);

    pnlOrder.setPreferredSize(new java.awt.Dimension(472, 600));
    java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
    jPanel1Layout.columnWidths = new int[] {140, 0};
    pnlOrder.setLayout(jPanel1Layout);





    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
    gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
    pnlOrder.add(pnlTotal, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 1.0;
    pnlContent.add(pnlOrder, gridBagConstraints);

    getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

    pnlFooter.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    pnlFooter.setLayout(new java.awt.GridBagLayout());

    btnBack.setText("Back");
    btnBack.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBackActionPerformed(evt);
      }
    });
    pnlFooter.add(btnBack, new java.awt.GridBagConstraints());

    btnContinue.setText("Continue");
    btnContinue.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnContinueActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weightx = 1.0;
    pnlFooter.add(btnContinue, gridBagConstraints);

    getContentPane().add(pnlFooter, java.awt.BorderLayout.SOUTH);

    getAccessibleContext().setAccessibleName("");

    pack();
    setLocationRelativeTo(null);
    
    
  }// </editor-fold>//GEN-END:initComponents
  
  
  private javax.swing.JTable noticeTable;
  private javax.swing.table.DefaultTableModel noticeTableModel;
  
  
  
  
  

  private void initModels() {
    itemService = new services.ItemService();
    itemsMealCombos = itemService.getAllByCategory(1);

    tbmOrder = new OrderTable();
  }

  private void initState() {
    getAllOrderedItems();
  }

  private void initCustomComponents() {
    itemsMealCombos.forEach((item) -> {
      BtnItem btnItem = new BtnItem(item);
      btnItem.addActionListener((java.awt.event.ActionEvent evt) -> itemActionPeformed(item));
      pnlMealCombos.add(btnItem);
    });
  }

  private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    new StartFrame().setVisible(true);
    dispose();
  }//GEN-LAST:event_btnBackActionPerformed

  private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
    java.util.ArrayList<models.OrderDetail> orderedItems = StateManager.getOrderedItems();
    if (orderedItems != null && orderedItems.size() > 0) {
      new OrderSummaryFrame().setVisible(true);
      dispose();
    } else {
      javax.swing.JOptionPane.showMessageDialog(null, "Please order something so\nMr. Krabs can get some cash!", "No Items Ordered", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
  }//GEN-LAST:event_btnContinueActionPerformed

  
  
  private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {
	    int tabIndex = tabbedPane.getSelectedIndex();

	    // When 공지사항 tab is selected
	    if (tabIndex == 0) {
	        int noticeCount = NoticeFrame.getNoticeCount();  // 게시물의 총 개수를 가져옵니다.
	        JLabel lblNoticeCount = new JLabel("총 " + noticeCount + " 개의 게시물이 있습니다.");  // 레이블 생성

	        JTable noticeTable = NoticeFrame.getNoticeTable();
	        
	        noticeTable.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int rowIndex = noticeTable.getSelectedRow();
	                String title = (String) noticeTable.getModel().getValueAt(rowIndex, 1);

	                // ... (기존의 코드: 조회수 증가 등)
		               System.out.println("Incrementing view count for title: " + title); // 로깅 추가
		               NoticeFrame.incrementViewCount(title);  // 조회수 증가 메서드 호출
		               System.out.println("Incremented view count for title: " + title);  // 로깅 추가

	                JTextArea noticeContent = NoticeFrame.getNoticeDetails(title);
	                JScrollPane scrollPane = new JScrollPane(noticeContent);

	                // 데이터베이스에서 추가 정보를 가져오는 코드
	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_order_kiosk?serverTimezone=UTC&characterEncoding=utf-8", "root", "dongyang");
	                    String sql = "SELECT * FROM notices WHERE title = ?";
	                    PreparedStatement statement = connection.prepareStatement(sql);
	                    statement.setString(1, title);
	                    ResultSet rs = statement.executeQuery();
	                    if (rs.next()) {
	                        // 상단에 표시할 레이블을 생성합니다.
	                        String additionalInfo = String.format("번호: %d | 제목: %s | 작성자: %s | 작성일: %s | 조회수: %d",
	                            rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("date"), rs.getInt("viewCount"));
	                        JLabel additionalLabel = new JLabel(additionalInfo);

	                     // 뒤로 가기 버튼 생성
	                        JButton backButton = new JButton("뒤로 가기");
	                        backButton.addActionListener(new ActionListener() {
	                            @Override
	                            public void actionPerformed(ActionEvent event) {
	                                int noticeCount = NoticeFrame.getNoticeCount();  // 게시물의 총 개수를 가져옵니다.
	                                JLabel lblNoticeCount = new JLabel("총 " + noticeCount + " 개의 게시물이 있습니다.");  // 레이블 생성

	                                pnlMealCombos.removeAll();
	                                pnlMealCombos.setLayout(new BorderLayout());
	                                pnlMealCombos.add(lblNoticeCount, BorderLayout.NORTH);  // 레이블을 상단에 추가
	                                pnlMealCombos.add(new JScrollPane(noticeTable), BorderLayout.CENTER);
	                                pnlMealCombos.revalidate();
	                                pnlMealCombos.repaint();
	                            }
	                        });

	                        // 레이아웃에 컴포넌트를 추가합니다.
	                        JPanel contentPanel = new JPanel(new BorderLayout());
	                        contentPanel.add(additionalLabel, BorderLayout.NORTH);
	                        contentPanel.add(scrollPane, BorderLayout.CENTER);
	                        contentPanel.add(backButton, BorderLayout.SOUTH);

	                        pnlMealCombos.removeAll();
	                        pnlMealCombos.setLayout(new BorderLayout());
	                        pnlMealCombos.add(contentPanel, BorderLayout.CENTER);
	                        pnlMealCombos.revalidate();
	                        pnlMealCombos.repaint();
	                    }
	                    rs.close();
	                    statement.close();
	                    connection.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	        
	        pnlMealCombos.removeAll();
	        pnlMealCombos.setLayout(new BorderLayout());
	        pnlMealCombos.add(lblNoticeCount, BorderLayout.NORTH);  // 레이블을 상단에 추가
	        pnlMealCombos.add(new JScrollPane(noticeTable), BorderLayout.CENTER);
	        pnlMealCombos.revalidate();
	        pnlMealCombos.repaint();
	    }





       if (tabIndex == 1 && itemsSides == null) {
         itemsSides = itemService.getAllByCategory(2);
         itemsSides.forEach((item) -> {
           BtnItem btnItem = new BtnItem(item);
           btnItem.addActionListener((java.awt.event.ActionEvent e) -> itemActionPeformed(item));
           pnlSides.add(btnItem);
         });
       }

       if (tabIndex == 2 && itemsDesserts == null) { // Assuming 학식 정보 is at index 2
    	   JPanel mealInfoPanel = CafeTeria.getMealInfoPanel();
    	   
    	   pnlDesserts.removeAll(); // Assuming pnlDesserts is the panel for 학식 정보
    	   pnlDesserts.setLayout(new BorderLayout());
    	   pnlDesserts.add(mealInfoPanel, BorderLayout.CENTER);
    	   pnlDesserts.revalidate();
    	   pnlDesserts.repaint();
    	 }


       if (tabIndex == 3 && itemsBeverages == null) {
         // Connect with campus map
         java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
         try {
           java.net.URI uri = new java.net.URI("file:///C:/jolspring/Smart%20Campus_Map.html");
           desktop.browse(uri);
         } catch (java.net.URISyntaxException | java.io.IOException ex) {
           ex.printStackTrace();
         }
       }
   } //GEN-LAST:event_tabbedPaneStateChanged
  
  
  
  
 
	   /* 
  private void loadNotices() {
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_order_kiosk?serverTimezone=UTC&characterEncoding=utf-8", "root", "dongyang");
	        String sql = "SELECT * FROM notices ORDER BY id DESC";
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	        
	        noticeTableModel = new javax.swing.table.DefaultTableModel(new Object[]{"번호", "제목", "작성자", "작성일", "조회수"}, 0);
	        noticeTable = new javax.swing.JTable(noticeTableModel);

	        int noticeCount = 0; // 게시글의 개수를 저장할 변수입니다.
	        
	        while (resultSet.next()) {
	            Object[] row = {
	                resultSet.getInt("id"),
	                resultSet.getString("title"),
	                resultSet.getString("author"),
	                resultSet.getString("date"),
	                resultSet.getInt("viewCount")
	            };
	            noticeTableModel.addRow(row);
	            noticeCount++; // 게시글의 개수를 증가시킵니다.
	        }

	        // 게시글의 총 개수를 레이블에 표시합니다.
	        JLabel lblNoticeCount = new JLabel("총 " + noticeCount + " 개의 게시물이 있습니다.");

	        pnlMealCombos.removeAll();
	        pnlMealCombos.setLayout(new BorderLayout());
	        pnlMealCombos.add(lblNoticeCount, BorderLayout.NORTH);
	        pnlMealCombos.add(new JScrollPane(noticeTable), BorderLayout.CENTER);
	        
	        pnlMealCombos.revalidate();
	        pnlMealCombos.repaint();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "데이터베이스 연결 또는 쿼리 중 오류 발생: " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
	    }
	}
*/





       
     /*
  private void showNoticeDetails(String title) {
     System.out.println("showNoticeDetails called with title: " + title);

       try {
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_order_kiosk?serverTimezone=UTC&characterEncoding=utf-8", "root", "dongyang");
           String sql = "SELECT content FROM notices WHERE title = ?";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1, title);
           ResultSet rs = statement.executeQuery();
           if (rs.next()) {
               String content = rs.getString("content");
               JTextArea textArea = new JTextArea(10, 40);
               textArea.setText(content);
               textArea.setWrapStyleWord(true);
               textArea.setLineWrap(true);
               textArea.setCaretPosition(0);
               textArea.setEditable(false);

               JDialog dialog = new JDialog();
               dialog.setTitle("Notice Details");
               dialog.setSize(400, 300);
               dialog.add(new JScrollPane(textArea));
               dialog.setLocationRelativeTo(null);  // center on screen
               dialog.setVisible(true);

           }
           rs.close();
           statement.close();
           connection.close();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
   }
   */
       
       
       
       
       
      


  
  
  

  private void itemActionPeformed(models.Item item) {
    CustomizeDialog customizeDialog = new CustomizeDialog(item);
    customizeDialog.addObserver(this);
    customizeDialog.setVisible(true);
  }

  private void getAllOrderedItems() {
    java.util.ArrayList<models.OrderDetail> orderedItems = StateManager.getOrderedItems();
    if (orderedItems != null) {
      tbmOrder.addRows(orderedItems);
      tbmOrder.resizeColumns(tblOrder.getColumnModel());
      app.Global.setTotalPrice(orderedItems, lblTotalValue);
    }
  }

  @Override
  public void onStateChange() {
    getAllOrderedItems();
  }

  /**
   * @param args the command line arguments
   */
  /* Create and display the form */
  public static void main(String args[]) {
    /* Set default theme */
    app.Global.setDefaultTheme();

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
      new MenuFrame().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnBack;
  private javax.swing.JButton btnContinue;
  private javax.swing.JLabel lblOrder;
  private javax.swing.JLabel lblTotal;
  private javax.swing.JLabel lblTotalValue;
  private javax.swing.JPanel pnlBeverages;
  private javax.swing.JPanel pnlContent;
  private javax.swing.JPanel pnlDesserts;
  private javax.swing.JPanel pnlFooter;
  private javax.swing.JPanel pnlMealCombos;
  private javax.swing.JPanel pnlOrder;
  private javax.swing.JPanel pnlSides;
  private javax.swing.JPanel pnlTotal;
  private javax.swing.JScrollPane scpOrder;
  private javax.swing.JTabbedPane tabbedPane;
  private javax.swing.JTable tblOrder;
  private javax.swing.JPanel pnlAcademicSchedule;
  // End of variables declaration//GEN-END:variables
}

class BtnItem extends javax.swing.JButton {

  BtnItem(models.Item item) {
    setIcon(app.Global.getImagePreview(item.getImage(), 100, 100, this));
    setText("<html><center>" + item.getName() + "<p style=\"font-weight:bold;margin-top:10px\">" + app.Global.toCurrency(item.getPrice()) + "</p></center></html>");
    setAlignmentY(0.0F);
    setHideActionText(true);
    setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    setIconTextGap(20);
    setPreferredSize(new java.awt.Dimension(160, 160));
    setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
  }

}