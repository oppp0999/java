package t0916;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class t0916 extends JFrame {
	public t0916(Elements rankE) {
		setTitle("NaverRank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container c = getContentPane();
		c.setBackground(Color.black);
		c.setLayout(new GridLayout(20,1,5,5));
		
		for(Element item:rankE) {
			System.out.println(item.text());
			JLabel la = new JLabel(item.text());
			c.add(la);
			
		}
		setSize(300,500);
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		try {
			
			Document doc = Jsoup.connect("https://datalab.naver.com/keyword/realtimeList.naver?entertainment=-2&groupingLevel=0&marketing=-2&news=-2&sports=-2&where=main").get();
			Elements rankE = doc.select(".ranking_item");
			System.out.println(rankE.first().text());
		
			new t0916(rankE);
		for(Element item:rankE) {
			System.out.println(item.text());
		}
		
		}
		
		
		
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
