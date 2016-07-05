package lesson1;

public class PetStore {
    public static void main(String[] args){
    	String dogName = Puppy.name;
    	String dogKind = Puppy.type;
    	String dogColor = Puppy.color;
    	
    	System.out.print("我有一隻聰明的" + dogKind + ", 名叫" + dogName + ", 牠會");
    	Puppy.skill();
    } 
}
