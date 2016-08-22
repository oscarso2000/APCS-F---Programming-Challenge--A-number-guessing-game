import java.util.Scanner;
import java.util.Random;
public class mastermind{
	public static void key (){
		System.out.printf("*********************key*********************\n");
		System.out.printf("*8: number is in the 4 digit code, but is not in the correct position \n");
		System.out.printf("*9: number is in the 4 digit code, and is in the correct position \n");
	}
	public static void main (String[]args){
		Scanner UserInput = new Scanner(System.in);
		int test,n=0;
		int[] x = new int[48];
		System.out.printf("Welcome to Mastermind!\n The computer has randomly generated 4 numbers for you to guess from the set 1-6. \n");
		key();
		Random generator = new Random();
		int[] number = new int[4];
		for(int i=0;i<4;i++){
			number[i]=generator.nextInt(6)+1;
		}
		System.out.printf("You have 6 tries. The computer has finished preparing it's number, you may start guessing. \n");
		/*to check
		  System.out.printf("The number is: ");
		  for(int i=0;i<4;i++){
		  System.out.printf("%d ",number[i]);	
		  }
		 */
		int k=1;
		for(test=0;test<=7;test++){
			if (test==7){
				System.out.printf("The number was %d %d %d %d \n",number[0],number[1],number[2], number[3]);
				break;
			}
			if(test==0){
				for(int i=0;i<48;i++){
					x[i]=0;
				}
			}
			if (test>0){
				for (int j=1;j<=4;j++){;	
					k++;
					do{
						System.out.printf("Enter number %d: ", j);
						x[k]=UserInput.nextInt();
					}while(x[k]<1||x[k]>6);
					if(x[k]==number[j-1]){
						if(k==(2+8*n)||k==(3+8*n)){
							x[k-2]=9;
						}else if(k==(4+8*n)||k==(5+8*n)){
							x[k+2]=9;
						}
					}else if(x[k]==number[0]||x[k]==number[1]||x[k]==number[2]||x[k]==number[3]){
						if(k==(2+8*n)||k==(3+8*n)){
							x[k-2]=8;
						}else if(k==(4+8*n)||k==(5+8*n)){
							x[k+2]=8;
						}

					}
				}
				if (x[k]==number[3]&&x[k-1]==number[2]&&x[k-2]==number[1]&&x[k-3]==number[0]){
					for(int i=0;i<(k+3);i=(i+8)){
						System.out.printf("%d %d ||%d %d %d %d|| %d %d\n\n",x[i],x[i+1],x[i+2],x[i+3],x[i+4],x[i+5],x[i+6],x[i+7]);
					}
					System.out.printf("Congratulations, You Won! \n \n");
					break;
				}
				k=k+4;
				n++;

			}
			for (int i=0;i<48;i=(i+8)){
				System.out.printf("%d %d ||%d %d %d %d|| %d %d\n",x[i],x[i+1],x[i+2],x[i+3],x[i+4],x[i+5],x[i+6],x[i+7]);
			}
		}
	}
}
