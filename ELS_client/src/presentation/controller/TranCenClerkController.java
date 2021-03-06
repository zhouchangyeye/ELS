package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import bean.JavaBean1;
import businesslogic.documentsbl.TranCenArrivalOrder;
import businesslogic.documentsbl.TranCenLoadingList;
import businesslogic.documentsbl.TransferOrder;
import businesslogicservice.documentsblservice.TranCenArrivalOrderblservice;
import businesslogicservice.documentsblservice.TranCenLoadingListblservice;
import businesslogicservice.documentsblservice.TransferOrderblservice;
import po.documentsPO.TranCenArrivalOrderPO;
import presentation.documentsui.TranCenArrivalOrderui.TranCenArrivalOrderListui;
import presentation.documentsui.TranCenArrivalOrderui.TranCenArrivalOrderui;
import presentation.documentsui.TranCenLoadingListui.TransferCenterLoadingListListui;
import presentation.documentsui.TranCenLoadingListui.TransferCenterLoadingListui;
import presentation.documentsui.TransferOrderui.TransferOrderListui;
import presentation.documentsui.TransferOrderui.TransferOrderui;
import presentation.reuse.EMSDialog;
import presentation.reuse.Skip;
import presentation.userui.TranCenClerkui;
import state.ResultMessage;
import vo.documentsVO.TranCenArrivalOrderVO;
import vo.documentsVO.TranCenLoadingListVO;
import vo.documentsVO.TransferOrderVO;

public class TranCenClerkController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	TranCenClerkui tranCenClerkui;
	TranCenArrivalOrderListui tranCenArrivalOrderListui;
	TransferOrderListui transferOrderListui;
	TransferCenterLoadingListListui transferCenterLoadingListListui;
	TranCenArrivalOrderui tranCenArrivalOrderui;
	TransferOrderui transferOrderui;
	TransferCenterLoadingListui transferCenterLoadingListui;
	TransferOrderblservice transferOrderblservice;
	TranCenArrivalOrderblservice tranCenArrivalOrderblservice;
	TranCenLoadingListblservice tranCenLoadingListblservice;
	TransferOrderVO transferOrderVO;
	TranCenArrivalOrderVO tranCenArrivalOrderVO;
	TranCenLoadingListVO tranCenLoadingListVO;
	JavaBean1 javaBean1;
	
	public TranCenClerkController(){
		tranCenClerkui = new TranCenClerkui();
		transferOrderListui = new TransferOrderListui();
		transferOrderListui.setLocation(0, 0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(transferOrderListui);
		JLayeredPane layeredPane = tranCenClerkui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inTranCenClerkui();
		inTransferOrderListui();
	}
	public void inTranCenClerkui() {
		tranCenClerkui.tranCenArraivalOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tranCenArrivalOrderListui= new TranCenArrivalOrderListui();
				childPanel = tranCenArrivalOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTranCenArrivalOrderListui();
			}
		});
		tranCenClerkui.trensferOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferOrderListui= new TransferOrderListui();
				childPanel = transferOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferOrderListui();
			}
		});
		tranCenClerkui.transferCenterLoadingList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferCenterLoadingListListui= new TransferCenterLoadingListListui();
				childPanel = transferCenterLoadingListListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferCenterLoadingListListui();
			}
		});
	}
	public void inTranCenArrivalOrderListui() {
		tranCenArrivalOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tranCenArrivalOrderui= new TranCenArrivalOrderui();
				childPanel = tranCenArrivalOrderui;
				Skip.skip(mainPanel,childPanel);
				inTranCenArrivalOrderui();
			}	
		});
		tranCenArrivalOrderListui.idFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tranCenArrivalOrderblservice=new TranCenArrivalOrder();
				javaBean1=new JavaBean1();
				javaBean1=tranCenArrivalOrderblservice.inquireA(tranCenArrivalOrderListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					EMSDialog d=new EMSDialog();
					int n = d.showDialog(tranCenClerkui,"单据不存在",30);
				}
				ArrayList<TranCenArrivalOrderVO> arrayList=(ArrayList<TranCenArrivalOrderVO>)javaBean1.getObject();
				tranCenArrivalOrderVO=arrayList.get(0);
				tranCenArrivalOrderui=findTranCenArrivalOrder(tranCenArrivalOrderVO);
				childPanel = tranCenArrivalOrderui;
				Skip.skip(mainPanel,childPanel);
				inTranCenArrivalOrderui();
			}
		});
		tranCenArrivalOrderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)tranCenArrivalOrderListui.tableModel.
               			getValueAt(tranCenArrivalOrderListui.table.getSelectedRow(),1);
               	try {
               		tranCenArrivalOrderblservice=new TranCenArrivalOrder();
				    javaBean1=new JavaBean1();
				    javaBean1=tranCenArrivalOrderblservice.inquireA(id);
				    ArrayList<TranCenArrivalOrderVO> arrayList=(ArrayList<TranCenArrivalOrderVO>)javaBean1.getObject();
				    tranCenArrivalOrderVO=arrayList.get(0);
				    tranCenArrivalOrderui=findTranCenArrivalOrder(tranCenArrivalOrderVO);
				    childPanel = tranCenArrivalOrderui;
				    Skip.skip(mainPanel,childPanel);
				    inTranCenArrivalOrderui();
               	} catch (Exception e2) {
               		e2.printStackTrace();
				}
            }
         }
    });
	}
	public TranCenArrivalOrderui findTranCenArrivalOrder(TranCenArrivalOrderVO tranCenArrivalOrderVO){
		tranCenArrivalOrderui=new TranCenArrivalOrderui();
		tranCenArrivalOrderui.refresh();
		tranCenArrivalOrderui.tranCenArrivalOrderVO=tranCenArrivalOrderVO;
		tranCenArrivalOrderui.tranCenId.setText(tranCenArrivalOrderVO.getTranCenID());
		tranCenArrivalOrderui.transferOrderId.setText(tranCenArrivalOrderVO.getTransferOrderID());
		tranCenArrivalOrderui.departureField.setText(tranCenArrivalOrderVO.getOrigin());
		switch(tranCenArrivalOrderVO.getGoodState()){
		case COMPLETE:tranCenArrivalOrderui.goodStateType.setSelectedIndex(0);break;
		case BROKE:tranCenArrivalOrderui.goodStateType.setSelectedIndex(1);break;
		case LOST:tranCenArrivalOrderui.goodStateType.setSelectedIndex(2);break;
		default:break;
		}
		switch(tranCenArrivalOrderVO.getApproState()){
		case Approve:tranCenArrivalOrderui.approState.setText("已审批");break;
		case NotApprove:tranCenArrivalOrderui.approState.setText("未审批");break;
			default:break;
		}
		tranCenArrivalOrderui.docmID.setText(tranCenArrivalOrderVO.getID());
		tranCenArrivalOrderui.docmDate.setText(tranCenArrivalOrderVO.getArrivalDate());
		return tranCenArrivalOrderui;
	}
	public void inTranCenArrivalOrderui(){
		tranCenArrivalOrderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog d=new EMSDialog();
				int n = d.showDialog(tranCenClerkui, "确认删除?",30);  
		        if (n == 1) {
				    String deleteId=tranCenArrivalOrderui.docmID.getText();
				    ArrayList<String> deletearray=new ArrayList<String>();;
				    deletearray.add(deleteId);
				    tranCenArrivalOrderblservice=new TranCenArrivalOrder();
				    tranCenArrivalOrderblservice.deleteMany(deletearray);
				    tranCenArrivalOrderListui = new TranCenArrivalOrderListui();
				    childPanel = tranCenArrivalOrderListui;
				    Skip.skip(mainPanel,childPanel);
				    inTransferOrderListui();
		        } else if (n == 0) {  
		        }
			}
		});
	}
	public void inTransferOrderListui(){
		transferOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferOrderui= new TransferOrderui();
				childPanel = transferOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferOrderui();
			}	
		});
		transferOrderListui.idFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferOrderblservice=new TransferOrder();
				javaBean1=new JavaBean1();
				javaBean1=transferOrderblservice.inquireA(transferOrderListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					EMSDialog d=new EMSDialog();
					int n = d.showDialog(tranCenClerkui,"单据不存在",30);
				}
				transferOrderVO=(TransferOrderVO)javaBean1.getObject();
				transferOrderui=findTransferOrder(transferOrderVO);
				childPanel = transferOrderui;
				Skip.skip(mainPanel,childPanel);
				inTransferOrderui();
			}
		});
		transferOrderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)transferOrderListui.tableModel.
               			getValueAt(transferOrderListui.table.getSelectedRow(),1);
               	transferOrderblservice=new TransferOrder();
				javaBean1=new JavaBean1();
				javaBean1=transferOrderblservice.inquireA(id);
				transferOrderVO=(TransferOrderVO)javaBean1.getObject();
				transferOrderui=findTransferOrder(transferOrderVO);
				childPanel = transferOrderui;
				Skip.skip(mainPanel,childPanel);
				inTransferOrderui();
            }
         }
    });
	}
	public TransferOrderui findTransferOrder(TransferOrderVO transferOrderVO){
		transferOrderui=new TransferOrderui();
		transferOrderui.refresh();
		transferOrderui.transferOrderVO=transferOrderVO;
		switch(transferOrderVO.getTransportType()){
		case Truck:transferOrderui.transportTypeType.setSelectedIndex(0);break;
		case Train:transferOrderui.transportTypeType.setSelectedIndex(1);break;
		case Plane:transferOrderui.transportTypeType.setSelectedIndex(2);break;
		default:break;
		}
		transferOrderui.departureField.setText(transferOrderVO.getOrigin());
		transferOrderui.arrivalField.setText(transferOrderVO.getDestination());
		transferOrderui.jZYField.setText(transferOrderVO.getSupervisionMan());
		transferOrderui.transportNumField.setText(transferOrderVO.getFlightNum());
		transferOrderui.containerIdField.setText(transferOrderVO.getContainerNum());
		transferOrderui.carriageField.setText(String.valueOf(transferOrderVO.getCarriage()));
		ArrayList<String> idList=new ArrayList<String>();;
		idList=transferOrderVO.getOrderIDs();
		for(int i=0;i<idList.size();i++){
			transferOrderblservice=new TransferOrder();
			transferOrderui.orderlineitemVO=transferOrderblservice.addOrder(idList.get(i));
			String[] oneRow={"",transferOrderui.orderlineitemVO.getId(),
					transferOrderui.orderlineitemVO.getSenderAdd(),
					transferOrderui.orderlineitemVO.getAddresseeAdd(),
					transferOrderui.orderlineitemVO.getExpressType().toString(),
					transferOrderui.orderlineitemVO.getGenerateDate()};
			transferOrderui.tableModel.addRow(oneRow);
		}
		switch(transferOrderVO.getApproState()){
		case Approve:transferOrderui.approState.setText("已审批");break;
		case NotApprove:transferOrderui.approState.setText("未审批");break;
			default:break;
		}
		transferOrderui.docmID.setText(transferOrderVO.getID());
		transferOrderui.docmDate.setText(transferOrderVO.getLoadingDate());
		return transferOrderui;
	}
	public void inTransferOrderui(){
		transferOrderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog d=new EMSDialog();
				int n = d.showDialog(tranCenClerkui, "确认删除?",30);  
		        if (n == 1) {
				    String deleteId=transferOrderui.docmID.getText();
				    ArrayList<String> deletearray=new ArrayList<String>();
				    deletearray.add(deleteId);
				    transferOrderblservice=new TransferOrder();
				    transferOrderblservice.delete(deletearray);
				    transferOrderListui = new TransferOrderListui();
				    childPanel = transferOrderListui;
				    Skip.skip(mainPanel,childPanel);
				    inTransferOrderListui();
		        }else if(n==0){
		        }
			}
		});
	}
	public void inTransferCenterLoadingListListui(){
		transferCenterLoadingListListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferCenterLoadingListui= new TransferCenterLoadingListui();
				childPanel = transferCenterLoadingListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferCenterLoadingListui();
			}	
		});
		transferCenterLoadingListListui.idFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tranCenLoadingListblservice=new TranCenLoadingList();
				javaBean1=new JavaBean1();
				javaBean1=tranCenLoadingListblservice.inquireA(transferCenterLoadingListListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					EMSDialog d=new EMSDialog();
					int n = d.showDialog(tranCenClerkui,"单据不存在",30);
				}
				tranCenLoadingListVO=(TranCenLoadingListVO)javaBean1.getObject();
				transferCenterLoadingListui=findTransferCenterLoadingList(tranCenLoadingListVO);
				childPanel = transferCenterLoadingListui;
				Skip.skip(mainPanel,childPanel);
				inTransferCenterLoadingListui();
			}
		});
		transferCenterLoadingListListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)transferCenterLoadingListListui.tableModel.
               			getValueAt(transferCenterLoadingListListui.table.getSelectedRow(),1);
               	try {
               		tranCenLoadingListblservice=new TranCenLoadingList();
				    javaBean1=new JavaBean1();
				    javaBean1=tranCenLoadingListblservice.inquireA(id);
				    tranCenLoadingListVO=(TranCenLoadingListVO)javaBean1.getObject();
				    transferCenterLoadingListui=findTransferCenterLoadingList(tranCenLoadingListVO);
				    childPanel = transferCenterLoadingListui;
				    Skip.skip(mainPanel,childPanel);
				    inTransferCenterLoadingListui();
               	} catch (Exception e2) {
               		e2.printStackTrace();
				}
            }
         }
    });
	}
	public TransferCenterLoadingListui findTransferCenterLoadingList(TranCenLoadingListVO tranCenLoadingListVO){
		transferCenterLoadingListui=new TransferCenterLoadingListui();
		transferCenterLoadingListui.refresh();
		transferCenterLoadingListui.tranCenLoadingListVO=tranCenLoadingListVO;
		transferCenterLoadingListui.motorIdField.setText(tranCenLoadingListVO.getTrucksNum());
		transferCenterLoadingListui.vehicleIdField.setText(tranCenLoadingListVO.getVehiclesID());
		transferCenterLoadingListui.arrivalField.setText(tranCenLoadingListVO.getDestination());
		transferCenterLoadingListui.jZYField.setText(tranCenLoadingListVO.getSupervisionMan());
		transferCenterLoadingListui.yYYField.setText(tranCenLoadingListVO.getEscortMan());
		transferCenterLoadingListui.fareField.setText(String.valueOf(tranCenLoadingListVO.getCarriage()));
		ArrayList<String> idList=new ArrayList<String>();
		idList=tranCenLoadingListVO.getOrderIDs();
		for(int i=0;i<idList.size();i++){
			tranCenLoadingListblservice=new TranCenLoadingList();
			transferCenterLoadingListui.orderlineitemVO=tranCenLoadingListblservice.addOrder(idList.get(i));
			String[] oneRow={"",transferCenterLoadingListui.orderlineitemVO.getId(),
					transferCenterLoadingListui.orderlineitemVO.getSenderAdd(),
					transferCenterLoadingListui.orderlineitemVO.getAddresseeAdd(),
					transferCenterLoadingListui.orderlineitemVO.getExpressType().toString(),
					transferCenterLoadingListui.orderlineitemVO.getGenerateDate()};
			transferCenterLoadingListui.tableModel.addRow(oneRow);
		}
		switch(tranCenLoadingListVO.getApproState()){
		case Approve:transferCenterLoadingListui.approState.setText("已审批");break;
		case NotApprove:transferCenterLoadingListui.approState.setText("未审批");break;
			default:break;
		}
		transferCenterLoadingListui.docmID.setText(tranCenLoadingListVO.getID());
		transferCenterLoadingListui.docmDate.setText(tranCenLoadingListVO.getLoadingDate());
		return transferCenterLoadingListui;
	}
	public void inTransferCenterLoadingListui(){
		transferCenterLoadingListui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog d=new EMSDialog();
				int n = d.showDialog(tranCenClerkui, "确认删除?",30);  
		        if (n == 1) {
				    String deleteId=transferCenterLoadingListui.docmID.getText();
				    ArrayList<String> deletearray=new ArrayList<String>();;
				    deletearray.add(deleteId);
				    tranCenLoadingListblservice=new TranCenLoadingList();
				    tranCenLoadingListblservice.delete(deletearray);
				    transferCenterLoadingListListui = new TransferCenterLoadingListListui();
				    childPanel = transferCenterLoadingListListui;
				    Skip.skip(mainPanel,childPanel);
				    inTransferCenterLoadingListListui();
		        }else if(n==0){
		        }
			}
		});
	}
	
}
