

/**
 *
 * @author Le Trang
 */

import java.util.Arrays;
public class PPL_assignment {

    
      
     
    
    
/**
	 * main procedure
	 * @effects:
	 * 	initialize a coffee tin
	 * 	display the tin content
	 * 	 {@link CoffeeTInGame#takeTwo(int,String[])}: choose 2 beans randomly
     *   {@link CoffeeTInGame#updateTin(int,String[])}: update the content of the tin
	 */
    public static void main(String[] args) {
        // initialize a tin with 6 beans
        String Tin[] = {"blue","green","blue","blue","green","blue"};
        int beanNum=Tin.length;// beanNum la so bean ban dau trong tin
        System.out.printf("the tin of beans before: %s %n", Arrays.toString(Tin));
        // P(beanNum) = true if n >= 2
     	// false if n = 1
     	// beanNum = number of bean
        while(beanNum>1){
            int chosenBean[] = takeTwo(beanNum);//chosenBean = int[a,b] /\a!=b/\a<beanNum/\b<beanNum(a and b is index of chosen bean)
            System.out.printf("the tin after: %s %n", Arrays.toString(chosenBean));
            Tin=updateTin(chosenBean, Tin,beanNum);//update tin
            beanNum--;//decrease the number of bean remains 1
            System.out.printf("the tin after choosing: %s %n", Arrays.toString(Tin));
            System.out.println();
        }// beanNum=1
        System.out.printf("the tin after: %s %n", Arrays.toString(Tin));
        System.out.println("the last bean:"+Tin[0]);
    }
    /**
	 * pick randomly two beans from the tin \
	 * @requires: tin has more than 1 bean
	 * @effects: 
	 * 		take randomly two separated beans in tin
	 * 		return index of 2  chosen beans in the tin
	 */
    public static int[] takeTwo(int n){ // ham tra ve mang cac so nguyen la kieu int []
        int i;
        int j;
        int a[] = new int[2];// khai bao mang so nguyen co 2 phan tu
        // take randomly two bean
     	// Loop variant:
     	//i= math.random(0 to n(number of beans remain))
     	//j= math.random(0 to n)
     	// true if i!=j
     	// false if i=j
        do{
        i=(int)(Math.random()*n);
        j=(int)(Math.random()*n);
       
        a[0]=i;// phan tu dau tien chua so thu tu cua bean dau tien mk chon trong mang
        a[1]=j;
        }while(a[0]==a[1]);//chose two bean again if the chosen indices is the same 
        return a;
    }
    /**
	 *  update the tin after taking two beans
	 * @modifies: tin
	 * @effects:
	 * 		remove the marked bean:
	 * 		if two beans have the same color
	 * 			remove both
	 * 			n=n-2
	 * 			add a blue bean at the end of the array
	 * 			n=n+1
	 * 		if only one is blue
	 * 			remove the blue one
	 * 			n=n-1
	 * 		return tin after updating
	 */
    public static String[] updateTin(int a[], String [] tin, int beanNum){
    	
        if(tin[a[0]]==tin[a[1]]){//tin[a[0]] = tin[a[1]] ->remove both
            for(int i=a[0];i<tin.length-1;i++){
            	//a[0]<i<tin.length-1=>tin[i]=tin[i+1]
            	tin[i]=tin[i+1];
            }
            tin[tin.length-1]="";//number of bean decrease 1
            for(int i=a[1];i<tin.length-1;i++){
            	tin[i]=tin[i+1];
            }
            tin[beanNum-2]="blue";//and one blue back
        }
        else{//tin[a[0]] != tin[a[1]] ->remove blue one
        	int remove;
        	if(tin[a[0]]=="blue")//tin[a[0]] = blue /\tin[a[1]] = green -> remove tin a[0]
        		remove = a[0];
        	else
        		remove = a[1];
        	for(int i=remove;i<tin.length-1;i++){
        		tin[i]=tin[i+1];
        	}
        	tin[tin.length-1]="";
        }
        return tin;
    }
}
