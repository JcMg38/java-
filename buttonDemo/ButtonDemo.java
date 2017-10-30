import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonDemo extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 2193808284157152076L;
	public ButtonDemo() {
		initButtonDemo();
	}
	private void initButtonDemo() {
		JPanel panel = new JPanel();
		JButton buttonChange = new JButton("换题");
		JTextField text1 = new JTextField(3);
		text1.setText(" ");
		JLabel label1 = new JLabel(" + ");
		JTextField text2 = new JTextField(3);
		text2.setText(" ");
		JLabel label2 = new JLabel(" = ");
		JTextField text3 = new JTextField(3);
		JButton buttonSum = new JButton("计算");
		JLabel label3 = new JLabel("输入计算结果");
		panel.add(buttonChange);
		panel.add(text1);
		panel.add(label1);
		panel.add(text2);
		panel.add(label2);
		panel.add(text3);
		panel.add(buttonSum);
		panel.add(label3);
		add(panel);
		pack();
		setTitle("ButtonDemo");
		setLocationRelativeTo(null);
		setVisible(true);
		
		buttonChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int a = rand.nextInt(100);
				int b = rand.nextInt(100);
				int c = rand.nextInt(2);
				if(c == 0) {
					label1.setText(" + ");
				}else if(c == 1) {
					label1.setText(" × ");
				}
				String texta = Double.toString(a);
				text1.setText(texta);
				String textb = Double.toString(b);
				text2.setText(textb);
				if(label1.getText().equals(" + ")) {
					System.out.print(a);
					System.out.print(" + ");
					System.out.print(b);
					System.out.print(" = ");
					System.out.println(a+b);
				}else if(label1.getText().equals(" × ")) {
					System.out.print(a);
					System.out.print(" × ");
					System.out.print(b);
					System.out.print(" = ");
					System.out.println(a*b);
				}
			}
		});
		buttonSum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double a = Double.valueOf(text1.getText());
				double b = Double.valueOf(text2.getText());
				char []find;
				boolean flag = true;
				double c = 0;
				
				if(!text3.getText().isEmpty()) {
					find = text3.getText().toCharArray();
					flag = true;
					for(int i = 0;i<find.length;i++) {
						if(find[i]>'9'||find[i]<'0') {
							flag = false;
							break;
						}
					}
					if(flag)
						c = Double.valueOf(text3.getText());
				}else {
					flag = false;
				}
				boolean right = false;
				if(label1.getText().equals(" + ")) {
					if(a + b == c)
						right = true;
				}else if(label1.getText().equals(" × ")) {
					if(a * b == c)
						right = true;
				}
				if(flag && right) {
					label3.setText("计算正确");
				}else if(flag){
					label3.setText("计算错误");
				}else if(text3.getText().isEmpty()){
					label3.setText("请输入数字");
				}else {
					label3.setText("输入不是数字");
				}
			}
			
		});
	}
	
	private static void createAndShowGUI() {
        new ButtonDemo().setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
	}
}
