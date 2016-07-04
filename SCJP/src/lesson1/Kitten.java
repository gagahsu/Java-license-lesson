package Chapter1;

class Kitten {
    static String catType = "米克斯"; //類別變數
    String catName = "胖仔"; //物件變數
    String catColor = "豹紋"; //物件變數
    void skill(){ //物件方法
    	String skill_1 = "坐下"; //區域變數
    	String skill_2 = "握手"; //區域變數
    	System.out.println("吃飯前要先" + skill_1);
    	System.out.println(skill_1 + "後要" + skill_2);
    }
	static void move(){ //類別方法		
	}
	Kitten(){ //建構子
	   
   }
}
