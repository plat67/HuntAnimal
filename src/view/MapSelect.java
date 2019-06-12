package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import model.active.Hunter;
import model.map.Map;

public class MapSelect extends JPanel {
    Map map;
    JButton f1, f2, shop, zoo, exit;
    JButton hb = new HunterButton(Hunter.getInstance());

    // 멤버 필드에 ImageIcon 클래스 생성자    
    private ImageIcon icon = new ImageIcon("../resourceFolder/image/map4.PNG");
    private Image bg = icon.getImage();
    private Ost ost = new Ost();
    private ViewController F;

    public MapSelect(ViewController f) {

        this.setSize(1280, 720);

        ost.playmusic("../resourceFolder/sound/mapbgm.wav");

        f1 = new JButton(new ImageIcon("../resourceFolder/image/Forest11.png"));
        f2 = new JButton(new ImageIcon("../resourceFolder/image/Forest22.png"));
        shop = new JButton(new ImageIcon("../resourceFolder/image/Shop1.png"));
        zoo = new JButton(new ImageIcon("../resourceFolder/image/Zoo1.png"));
        exit = new JButton(new ImageIcon("../resourceFolder/image/finish1.png"));
        // 백그라운드 이미지 삽입할 메소드에 이름없는 클래스로 구현

        this.setLayout(null);

        F = f;

        f1.setBorderPainted(false);
        f2.setBorderPainted(false);
        shop.setBorderPainted(false);
        zoo.setBorderPainted(false);


        f1.setContentAreaFilled(false);
        f2.setContentAreaFilled(false);
        shop.setContentAreaFilled(false);
        zoo.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);

        f1.setFocusPainted(false);
        f2.setFocusPainted(false);
        shop.setFocusPainted(false);
        zoo.setFocusPainted(false);


        f1.setBounds(190, 140, 100, 100);
        f2.setBounds(460, 305, 100, 100);
        shop.setBounds(700, 500, 100, 100);
        zoo.setBounds(830, 290, 100, 100);
        exit.setBounds(1110, 540, 130, 130);

        f1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("f1 click!");
                ost.playmusic("../resourceFolder/sound/clickbgm.wav");
                F.getCardLayout().show(F.getContentPane(), "f1");
            }
        });
        f2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("f2 click!");
                ost.playmusic("../resourceFolder/sound/clickbgm.wav");
                F.getCardLayout().show(F.getContentPane(), "f2");
            }
        });
        shop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("shop click!");
                ost.playmusic("../resourceFolder/sound/clickbgm.wav");
                F.getCardLayout().show(F.getContentPane(), "shop");
            }
        });
        zoo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("zoo click!");
                ost.playmusic("../resourceFolder/sound/clickbgm.wav");
                F.getCardLayout().show(F.getContentPane(), "zoo");
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("exit click!");
                ost.playmusic("../resourceFolder/sound/clickbgm.wav");
            }
        });

        add(f1);
        add(f2);
        add(shop);
        add(zoo);
        add(exit);
        add(hb);
        this.setVisible(true);

    }

    public void paintComponent(Graphics g) {
        // Display image at at full size
        g.drawImage(bg, 0, 0, null);
        setOpaque(false);
        super.paintComponent(g);
    }


}


