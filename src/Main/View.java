/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ruang.Balok;
/**
 *
 * @author Febrian
 */
public class View extends JFrame implements ActionListener{
    
    JLabel ltext = new JLabel("KALKULATOR BALOK");
    
    JLabel llength = new JLabel( "Length    : ");
    JTextField flength = new JTextField(30);
    
   
    JLabel lwidth = new JLabel( "Width     : ");
    JTextField fwidth = new JTextField(30);
    
    JLabel lheight = new JLabel( "Height     : ");
    JTextField fheight = new JTextField(30);
    
    JButton bhitung = new JButton("Hitung");
    JButton breset = new JButton("Reset");
    
    JLabel lhasil = new JLabel("Hasil :");
    JLabel lluas = new JLabel();
    JLabel lkeliling = new JLabel();
    JLabel lluaspermukaan = new JLabel();
    JLabel lvolume = new JLabel();
    
    public View(){
        
        setTitle( "Kalkulator Balok");
        setSize(500,500);
        
        ButtonGroup grup = new ButtonGroup();
        grup.add(bhitung);
        grup.add(breset);
        
        setLayout(null);
        add(ltext);
        add(llength);
        add(flength);
        add(lwidth);
        add(fwidth);
        add(lheight);
        add(fheight);
        add(bhitung);
        add(breset);
        
        add(lhasil);
        add(lluas);
        add(lkeliling);
        add(lluaspermukaan);
        add(lvolume);
        
        ltext.setBounds(175, 50, 200, 20);
        
        llength.setBounds(100, 100, 120, 20);
        flength.setBounds(230, 100, 150, 20);
        lwidth.setBounds(100, 150, 120, 20);
        fwidth.setBounds(230, 150, 150, 20);
        lheight.setBounds(100, 200, 120, 20);
        fheight.setBounds(230, 200, 150, 20);
        
        lhasil.setBounds(175,250,200,20);
        lluas.setBounds(100,270,200,20);
        lkeliling.setBounds(100,290,200,20);
        lluaspermukaan.setBounds(100,310,200,20);
        lvolume.setBounds(100,330,200,20);
        
        bhitung.setBounds(125, 400, 120, 20);
        breset.setBounds(250, 400, 120, 20);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        bhitung.addActionListener(this);
        breset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){//event handling
        double panjang, lebar, tinggi;
        
        if(e.getSource() == bhitung){
            if (flength.getText().isEmpty()) { 
                JOptionPane.showMessageDialog(this, "Length cannot empty");//kelas yang menyediakan jendela dialog
            } else if (fwidth.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Width cannot empty");
            } else if (fheight.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Height cannot empty");
            } else {
                try{
                    panjang = Integer.parseInt(flength.getText());
                    lebar = Integer.parseInt(fwidth.getText());
                    tinggi = Integer.parseInt(fheight.getText());

                    Balok balok = new Balok(tinggi, panjang, lebar);

                    lluas.setText("Luas Persegi Panjang          : " + balok.hitungLuas());
                    lkeliling.setText("Keliling Persegi Panjang     : " + balok.hitungKeliling());
                    lluaspermukaan.setText("Luas Permukaan Balok        : " + balok.hitungLuasPermukaan());
                    lvolume.setText("Volume Balok                        : " + balok.hitungVolume());
                
                }catch(NumberFormatException error){//Exception
                    JOptionPane.showMessageDialog(this, error.getMessage());
                    
                }
            }    
        }
        if(e.getSource() == breset){//mengosngkan nilai
            lluas.setText(" ");
            lkeliling.setText(" ");
            lluaspermukaan.setText(" ");
            lvolume.setText(" ");
            flength.setText("");
            fwidth.setText("");
            fheight.setText("");
        }
    }
}
