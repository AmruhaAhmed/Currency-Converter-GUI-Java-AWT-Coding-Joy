import java.awt.*;
import java.awt.event.*;
class currencyconverter implements ActionListener
{
    Frame f;
    Button b;
    Label title,l1,l2,l3,last;
    TextField tf;
    Choice c1,c2;
     double converter(String curr1,String curr2,double amount)
    {
       if(curr1.equals(curr2))
       return amount;
        String currency[]={"","Indian Rupee","United States Dollar","Euro","Pound Sterling","Chinese Yuan","Japanese Yen"};
        double given_to_rupee[]={0,1,82.60,88.52,101.88,11.69,0.59};
        double rupee_to_final[]={0,1,0.012,0.011,0.0098,0.086,1.70};
        int c1=0;
        int c2=0;
        for(int i=1;i<=6;i++)
        {
            if(curr1.equals(currency[i]))
            c1=i;
            if(curr2.equals(currency[i]))
            c2=i;
            
        }
        double current_to_rupee=amount*given_to_rupee[c1];
        double rupee_to_desired=current_to_rupee*rupee_to_final[c2];
        
        return(rupee_to_desired);
        
    }
    currencyconverter()
    {
        f=new Frame("Currency Conversion");
        title=new Label("Currency Converter GUI using Java AWT");
        l1=new Label("Enter the amount:");
        l2=new Label("Select the current currency :");
        l3=new Label("Select the final currency :");
        last=new Label();
        b=new Button("Submit");
        tf=new TextField();
        c1=new Choice();
        c2=new Choice();
        c1.add("Indian Rupee");
        c1.add("United States Dollar");
        c1.add("Euro");
        c1.add("Pound Sterling");
        c1.add("Chinese Yuan");
        c1.add("Japanese Yen");
        c2.add("Indian Rupee");
        c2.add("United States Dollar");
        c2.add("Euro");
        c2.add("Pound Sterling");
        c2.add("Chinese Yuan");
        c2.add("Japanese Yen");
        boundSetter();
        fontSetter();
        b.addActionListener(this);
        f.setVisible(true);
        f.setLayout(null);
        addComponents();
        
    }
    void addComponents()
    {
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(last);
        f.add(title);
        f.add(tf);
        f.add(b);
        f.add(c1);
        f.add(c2);
        f.add(b);
     
    }
    
    void fontSetter()
    {
        title.setFont(new Font("Arial",Font.BOLD,35));
        l1.setFont(new Font("Arial",Font.PLAIN,22));
        l2.setFont(new Font("Arial",Font.PLAIN,22));
        l3.setFont(new Font("Arial",Font.PLAIN,22));
        tf.setFont(new Font("Arial",Font.BOLD,25));
        c1.setFont(new Font("Arial",Font.PLAIN,22));
        c2.setFont(new Font("Arial",Font.PLAIN,22));
        b.setFont(new Font("Arial",Font.BOLD,25));
        last.setFont(new Font("Arial",Font.PLAIN,22));
        f.setBackground(Color.YELLOW);
        b.setBackground(Color.PINK);
        
    }
    void boundSetter()
    {
       f.setSize(800,800);
        title.setBounds(50,50,700,50);
        l1.setBounds(50,150,300,50);
        tf.setBounds(410,150,300,30);
        l2.setBounds(50,250,300,50);
        l3.setBounds(400,250,350,50);
        c1.setBounds(50,350,250,200);
        c2.setBounds(450,350,250,200);
        last.setBounds(100,550,600,25);
        b.setBounds(350,450,100,50);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String amttext=tf.getText();
        double amount=Double.valueOf(amttext);
        String currency1=c1.getSelectedItem();
        String currency2=c2.getSelectedItem();
        double final_amt=converter(currency1,currency2,amount);
        last.setText(amount+" of "+currency1+" in "+currency2+" is "+final_amt);
        
        
    }
    
    void main()
    {
        currencyconverter ob=new currencyconverter();
    }
}