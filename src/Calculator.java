import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Calculator 
{
	JFrame fr=new JFrame("Calculator"); 
	JTextField tb=new JTextField("0");
	JButton [] bt=new JButton[20];
	JPanel pa=new JPanel();
	public Calculator()
	{
		fr.setSize(400,450);
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(3);
		fr.setLayout(null);
		addTextBox();
		fr.setVisible(true);
	}
	private void addTextBox()
	{
		tb.setBounds(20,20,360,40);
		tb.setFont(new Font("arial",0,22));
		tb.setHorizontalAlignment(JTextField.RIGHT);
		tb.setEditable(false);
		tb.setBackground(Color.white);
		tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
		fr.add(tb);
		addButtons();
	}
	private void addButtons()
	{
		//pa.setBackground(Color.pink);
		pa.setBounds(20,90,360,300);
		fr.add(pa);
		pa.setLayout(new GridLayout(5,4,5,5));
		String [] str= {"Back","CE","C","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		Font font=new Font("arial",0,20);
		//code to create buttons and add then into container
		CalListener listener=new CalListener();
		for(int i=0;i<20;i++)
		{
			bt[i]=new JButton(str[i]);
			bt[i].addActionListener(listener);
			bt[i].setFont(font);
			if(i==3|| i==7 || i==11|| i==15|| i==18|| i==19)
				bt[i].setForeground(Color.red);
			else
				bt[i].setForeground(Color.blue);
			pa.add(bt[i]);
		}
	}//end of Calculator constructor
	class CalListener implements ActionListener
	{
		String op=null;
		int num1=0;
		boolean opclicked=false;
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			String bbtext=bb.getText();
			String tbtext=tb.getText();
			//condition for arithmetic operation buttons
			if(bb==bt[7] ||bb==bt[11] ||bb==bt[15] ||bb==bt[19])
			{
				op=bbtext;
				num1=Integer.parseInt(tb.getText());
				opclicked=true;
			}
			//condition for digit buttons
			if(bb==bt[4] ||bb==bt[5] ||bb==bt[6] ||bb==bt[8] ||bb==bt[9] ||bb==bt[10] ||bb==bt[12] ||bb==bt[13] ||bb==bt[14] ||bb==bt[16])
			{
				if(tbtext.equals("0") || opclicked )
				{
					//replaces current value of textbox with value of clicked button
					tb.setText(bbtext);
					opclicked=false;
				}
				else
				{
					//concatenates current value of textbox with value of clicked button
					tb.setText(tbtext+bbtext);
				}
			}
			//C buuton
			if(bb==bt[2])
			{
				tb.setText("0");
				op=null;
				opclicked=false;
				num1=0;
			}
			//== button
			if(bb==bt[18])
			{
				cal();
			}
		}//end of actionPerformed method
		private void cal()
		{
			int num2=Integer.parseInt(tb.getText());
			if(op.equals("+")) 
			{
				int res=num1+num2;
				tb.setText(String.valueOf(res));
			}
			if(op.equals("*")) 
			{
				int res=num1*num2;
				tb.setText(String.valueOf(res));
			}
			if(op.equals("-")) 
			{
				int res=num1-num2;
				tb.setText(String.valueOf(res));
			}
			if(op.equals("/")) 
			{
				int res=num1/num2;
				tb.setText(String.valueOf(res));
			}
		}
	}//end of CalListener class 
	public static void main(String[] args) 
	{
		new Calculator();
	}
}//end of main class
