package FlappyBird;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


//Decimal Format - show only the number of digit that you decide after the dot, for example in this case will show a 3 digits, every # will add an one more. I can add every symbol that I want.
public class JFrameProject extends JFrame {
	//properties
	public final int WIDTH = 1200, HEIGHT = 800;		//the size of screen
	public static JComboBox jComboBox1;
	public static JComboBox jComboBox2;
	
	public static JTextField field1;
	public static JTextField field2;

	public static JButton b1;

	public JFrameProject()
	{
		setTitle("Currency Converter");   		   //the name of application
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);               //set location to the center of screen
		setResizable(false);					   //can't resizable the size of screen while the application is running
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameProject.class.getResource("/image/conv.jpg")));   //change the image icon
		//setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen
		setLayout(null);

		String[] typesOfCoins = {"ILS", "EURO", "DOLLAR"};
		this.jComboBox1 = new JComboBox(typesOfCoins);		//combo box one
		jComboBox1.setBounds(180, 90, 200, 50);

		this.jComboBox2 = new JComboBox(typesOfCoins);		//combo box two
		jComboBox2.setBounds(760, 90, 200, 50);

		this.add(jComboBox1);
		this.add(jComboBox2);

	}

	public static void conv() 
	{

		field1 = new JTextField();		//text field of from
		field1.setBounds(420, 92, 100, 50);

		field2 = new JTextField();		//text field of to
		field2.setBounds(1000, 92, 100, 50);

		JLabel l1 = new JLabel("From:");			//text of from
		l1.setBounds(100, 100, 60, 30);
		l1.setFont(new Font("Serif", Font.PLAIN, 20));

		JLabel l2 = new JLabel("To:");				//text of to		
		l2.setBounds(700, 100, 60, 30);
		l2.setFont(new Font("Serif", Font.PLAIN, 20));

		JFrameProject jframe = new JFrameProject();
		jframe.setVisible(true);

		b1 = new JButton("Convert");
		b1.setBounds(500, 400, 200, 50);
		b1.setFont(new Font("Serif", Font.PLAIN, 20));


		// Adding action listener
		b1.addActionListener(new Action());

		jframe.add(b1);				//add all component to frame
		jframe.add(l1);
		jframe.add(l2);
		jframe.add(field1);
		jframe.add(field2);


	}

	static class Action implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			String typeCoin = jComboBox2.getSelectedItem().toString();
			String amount = field1.getText();
			if(e.getSource() == b1)
			{
				if(jComboBox1.getSelectedItem().equals("ILS"))
				{
					field2.setText(new DecimalFormat(".###").format(CurrencyConvertor.covFromILS(typeCoin, amount)));        
				}
				else
					if(jComboBox1.getSelectedItem().equals("DOLLAR"))
					{
						field2.setText(new DecimalFormat("##.##").format(CurrencyConvertor.covFromUSD(typeCoin, amount)));     // if the sc2 was USD
					}
					else
						field2.setText(new DecimalFormat("##.##").format(CurrencyConvertor.covFromEUR(typeCoin, amount)));    // if the sc2 was EUR
			}
		}
	}

	public static void main(String[] args)
	{
		//display the screen 
		conv();
	}


}
