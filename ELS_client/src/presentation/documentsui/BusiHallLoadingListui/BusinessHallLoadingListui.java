package presentation.documentsui.BusiHallLoadingListui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.documentsbl.BusiHallLoadingList;
import businesslogicservice.documentsblservice.BusiHallLoadingListblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.Loginui;
import vo.documentsVO.BusiHallLoadingListVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class BusinessHallLoadingListui extends ParentDocuments{
	public JLabel busiLoadOrder;
	public JLabel busiId;
	public JTextField busiIdField;
	public JLabel motorId;
	public JTextField motorIdField;
	public JLabel arrival;
	public JTextField arrivalField;
	public JLabel vehicleId;
	public JTextField vehicleIdField;
	public JLabel jZY;
	public JTextField jZYField;
	public JLabel yYY;
	public JTextField yYYField;
	public JLabel fare;
	public JTextField fareField;
	public JLabel orderId;
	public JTextField orderIdField;
	public JButton addOrder;
	public JTable orderList;
	public DefaultTableModel tableModel;
	public JScrollPane scroller;
	public JButton deleteOrder;
	JavaBean1 javaBean1;
	public OrderlineitemVO orderlineitemVO;
	BusiHallLoadingListblservice busiHallLoadingListblservice;
	public BusiHallLoadingListVO busiHallLoadingListVO;
	
	public BusinessHallLoadingListui(){
		busiLoadOrder=new JLabel();
		busiId=new JLabel();
		busiIdField=new JTextField();
		motorId=new JLabel();
		motorIdField=new JTextField();
		vehicleId=new JLabel();
		vehicleIdField=new JTextField();
		arrival=new JLabel();
		arrivalField=new JTextField();
		jZY=new JLabel();
		jZYField=new JTextField();
		yYY=new JLabel();
		yYYField=new JTextField();
		fare=new JLabel();
		fareField=new JTextField();
		orderId=new JLabel();
		orderIdField=new JTextField();
		addOrder=new JButton();
		busiHallLoadingListVO=new BusiHallLoadingListVO();
		String[] columnNames = {"选择","ID","寄件地址","收件地址","快递类型","时间"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		orderList = new JTable(tableModel){  
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
		 deleteOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		
		busiLoadOrder.setBounds(218,10,180,30);
		busiLoadOrder.setText("装车单信息");
		busiLoadOrder.setHorizontalAlignment(SwingConstants.CENTER);
		busiLoadOrder.setFont(font1);
		busiLoadOrder.setBackground(Color.WHITE);
		
		busiId.setBounds(40,50,100,24);
		busiId.setText("营业厅编号：");
		busiId.setFont(font2);
		busiId.setBackground(Color.WHITE);
		
		busiIdField.setBounds(140,52,120,20);
		busiIdField.setText(Loginui.agency);
		busiIdField.setBackground(Color.WHITE);
		busiIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		busiIdField.setEditable(false);
		
		motorId.setBounds(300,50,100,24);
		motorId.setText("汽运编号：");
		motorId.setFont(font2);
		motorId.setBackground(Color.WHITE);
		
		motorIdField.setBounds(400,52,120,20);
		motorIdField.setBackground(Color.WHITE);
		motorIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		motorIdField.setEditable(false);
		
		vehicleId.setBounds(40,80,100,24);
		vehicleId.setText("车辆代号：");
		vehicleId.setFont(font2);
		vehicleId.setBackground(Color.WHITE);
		
		vehicleIdField.setBounds(140,82,120,20);
		
		arrival.setBounds(300,80,100,24);
		arrival.setText("到达地：");
		arrival.setFont(font2);
		arrival.setBackground(Color.WHITE);
		
		arrivalField.setBounds(400,82,120,20);
		
		jZY.setBounds(40,110,100,24);
		jZY.setText("监装员：");
		jZY.setFont(font2);
		jZY.setBackground(Color.WHITE);
		
		jZYField.setBounds(140,112,120,20);
		
		yYY.setBounds(300,110,100,24);
		yYY.setText("押运员：");
		yYY.setFont(font2);
		yYY.setBackground(Color.WHITE);
		
		yYYField.setBounds(400,112,120,20);
		
		fare.setBounds(40,140,100,24);
		fare.setText("运费：");
		fare.setFont(font2);
		fare.setBackground(Color.WHITE);
		
		fareField.setBounds(140,142,120,20);
		fareField.setBackground(Color.WHITE);
		fareField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fareField.setEditable(false);
		
		orderId.setBounds(40,170,200,24);
		orderId.setText("本次装箱所有订单条形码号：");
		orderId.setFont(font2);
		orderId.setBackground(Color.WHITE);
		
		orderIdField.setBounds(140,202,120,20);
		
		addOrder.setBounds(280,200,70,24);
		addOrder.setText("添加订单");
		addOrder.setFont(font2);
		addOrder.setBackground(Color.WHITE);
		addOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				busiHallLoadingListblservice=new BusiHallLoadingList();
				orderlineitemVO=busiHallLoadingListblservice.addOrder(orderIdField.getText());
				String[] oneRow={"",orderlineitemVO.getId(),orderlineitemVO.getSenderAdd(),
						orderlineitemVO.getAddresseeAdd(),orderlineitemVO.getExpressType().toString(),
						orderlineitemVO.getGenerateDate()};
			    tableModel.addRow(oneRow);
			}
		});
		
		orderList.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
			 @Override
			 public Component getTableCellRendererComponent(JTable table,
					 Object value, boolean isSelected, boolean hasFocus,
					 int row, int column) {
				 JCheckBox ck=new JCheckBox();
				 ck.setSelected(isSelected);
				 ck.setHorizontalAlignment((int) 0.5f);
				 ck.setBackground(Color.WHITE);
				 return ck;
			 }
		 });
		orderList.setRowHeight(24);
		orderList.setBackground(Color.WHITE);
		orderList.setShowVerticalLines(true);
		orderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderList.getColumnModel().getColumn(0).setPreferredWidth(40);
		scroller=new JScrollPane(orderList);
		scroller.setSize(500,144);
		scroller.setLocation(40,230);
		scroller.setViewportView(orderList);
		orderList.setFont(font2);
		orderList.setBackground(Color.WHITE);
		orderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		deleteOrder.setBounds(40,400,50,24);
		deleteOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		deleteOrder.setBackground(Color.WHITE);
		deleteOrder.setText("删除");
		deleteOrder.setFont(font2);
		deleteOrder.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   for(int i=0;i<orderList.getRowCount();i++){
				    int selectedRow = orderList.getSelectedRow();//获得选中行的索引
				    if(selectedRow!=-1){
				     tableModel.removeRow(selectedRow);  //删除行 
				    }
				   }
				  }});
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				approState.setText("未审批");
				busiHallLoadingListblservice=new BusiHallLoadingList();
				busiHallLoadingListVO.setVehiclesID(vehicleIdField.getText());
				busiHallLoadingListVO.setDestination(arrivalField.getText());
				busiHallLoadingListVO.setEscortMan(yYYField.getText());
				busiHallLoadingListVO.setSupervisionMan(jZYField.getText());
				ArrayList<String> idList=new ArrayList<String>();
				for(int i=0;i<orderList.getRowCount();i++){
					idList.add((String)orderList.getValueAt(i,1));
				}
				busiHallLoadingListVO.setOrderIDs(idList);
				javaBean1=new JavaBean1();
				javaBean1=busiHallLoadingListblservice.addBusinessHallLoadingList(busiHallLoadingListVO);
				busiHallLoadingListVO=(BusiHallLoadingListVO)javaBean1.getObject();
				motorIdField.setText(busiHallLoadingListVO.getTruckNum());
				docmID.setText(busiHallLoadingListVO.getID());
				docmDate.setText(busiHallLoadingListVO.getLoadingDate());
				fareField.setText(String.valueOf(busiHallLoadingListVO.getCarriage()));
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				busiHallLoadingListblservice=new BusiHallLoadingList();
				busiHallLoadingListVO.setVehiclesID(vehicleIdField.getText());
				busiHallLoadingListVO.setDestination(arrivalField.getText());
				busiHallLoadingListVO.setEscortMan(yYYField.getText());
				busiHallLoadingListVO.setSupervisionMan(jZYField.getText());
				ArrayList<String> idList=new ArrayList<String>();
				for(int i=0;i<orderList.getRowCount();i++){
					idList.add((String)orderList.getValueAt(i,1));
				}
				busiHallLoadingListVO.setOrderIDs(idList);
				javaBean1=new JavaBean1();
				javaBean1=busiHallLoadingListblservice.modify(busiHallLoadingListVO);
				busiHallLoadingListVO=(BusiHallLoadingListVO)javaBean1.getObject();
				motorIdField.setText(busiHallLoadingListVO.getTruckNum());
				docmDate.setText(busiHallLoadingListVO.getLoadingDate());
				fareField.setText(String.valueOf(busiHallLoadingListVO.getCarriage()));
			}
		});
		
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(busiLoadOrder);
		this.add(busiId);
		this.add(busiIdField);
		this.add(motorId);
		this.add(motorIdField);
		this.add(vehicleId);
		this.add(vehicleIdField);
		this.add(arrival);
		this.add(arrivalField);
		this.add(jZY);
		this.add(jZYField);
		this.add(yYY);
		this.add(yYYField);
		this.add(fare);
		this.add(fareField);
		this.add(orderId);
		this.add(orderIdField);
		this.add(addOrder);
		this.add(scroller);
		this.add(deleteOrder);
	}
	public void refresh() {
		vehicleIdField.setEditable(false);
		arrivalField.setEditable(false);
		jZYField.setEditable(false);
		yYYField.setEditable(false);
		orderIdField.setEditable(false);
		addOrder.setEnabled(false);
		deleteOrder.setEnabled(false);
		
		vehicleIdField.setBackground(Color.white);
		arrivalField.setBackground(Color.white);
		jZYField.setBackground(Color.white);
		yYYField.setBackground(Color.white);
		orderIdField.setBackground(Color.white);
		
		vehicleIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		arrivalField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jZYField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		yYYField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
		
	}
	public void modifying() {
		vehicleIdField.setEditable(true);
		arrivalField.setEditable(true);
		jZYField.setEditable(true);
		yYYField.setEditable(true);
		orderIdField.setEditable(true);
		addOrder.setEnabled(true);
		deleteOrder.setEnabled(true);
		modifyOrder.setVisible(true);
		
		vehicleIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		arrivalField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		jZYField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		yYYField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
