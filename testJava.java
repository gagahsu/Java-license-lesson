import java.math.BigDecimal;
import java.util.ArrayList;


public class testJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str = "-1+1";//1061
        String temp = "";
        String numStr = "";
        ArrayList<String> signalList = new ArrayList<String>();
        ArrayList<String> numList = new ArrayList<String>();
        try{
        	/*Step1:分隔符號和數字*/        
            for(int i = 0 ; i < str.length() ; i++){
            	temp = str.substring(i, i+1);
            	if("+*-/".contains(temp)){
            		numList.add(i == 0 ? "0" : numStr);
            		signalList.add(temp);
            		numStr = "";
            	}else{
            		numStr = numStr + temp;
            	}
            }        
            numList.add(numStr);
            /*Step2:先乘除*/
            int cnt = 0;
            while(signalList.size() > cnt){        	        	
                if("*/".contains(signalList.get(cnt))){
                	if("*".equals(signalList.get(cnt))){
                	   numList.set(cnt+1, String.valueOf(BigDecimal.valueOf(Double.valueOf(numList.get(cnt))).multiply(BigDecimal.valueOf(Double.valueOf(numList.get(cnt+1))))));
                	   numList.remove(cnt);
                	   signalList.remove(cnt);
                	}else{        		   
                	   numList.set(cnt+1, String.valueOf(BigDecimal.valueOf(Double.valueOf(numList.get(cnt))).divide(BigDecimal.valueOf(Double.valueOf(numList.get(cnt+1))))));
                	   numList.remove(cnt);
                	   signalList.remove(cnt);
                	}
                }else{
                	cnt++;
                }                    
            }
            cnt = 0;
            /*Step3:後加減*/        
            while(signalList.size() > 0){
            	if("+".equals(signalList.get(cnt))){
             	   numList.set(cnt+1, String.valueOf(BigDecimal.valueOf(Double.valueOf(numList.get(cnt))).add(BigDecimal.valueOf(Double.valueOf(numList.get(cnt+1))))));
             	   numList.remove(cnt);
             	   signalList.remove(cnt);
             	}else{        		   
             	   numList.set(cnt+1, String.valueOf(BigDecimal.valueOf(Double.valueOf(numList.get(cnt))).subtract(BigDecimal.valueOf(Double.valueOf(numList.get(cnt+1))))));
             	   numList.remove(cnt);
             	   signalList.remove(cnt);
             	}                   
            }
            /*Step4:輸出結果*/
            System.out.println(numList.get(0));
        }catch(Exception e){
        	if(e.getMessage().equals("Division by zero")){
        		System.out.println("You can't " + e.getMessage() + ", please check it.");	
        	}else{
        		System.out.println(e.getMessage());
        	}
        }
	}
}
