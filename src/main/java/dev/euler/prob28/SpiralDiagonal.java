package dev.euler.prob28;

public class SpiralDiagonal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		solve28();

	}

	
	public static void solve28(){
		int rows=1001;
		int columns=1001;
		int[][] array=new int[rows][columns];
		
		int startRow=rows/2;int startColumn=columns/2;
		boolean followRow=true;
		 boolean first = true;
		for(int i=1,j=0, k=1;i<=rows*columns&&startRow<rows&&startColumn<columns;i++){
			//System.out.println(" "+k+" "+followRow+"===="+startRow+"  "+startColumn);
		
			array[startRow][startColumn]=i;
			
				if(followRow){
				if(k%2==0){
				//	System.out.println("backing col");
					startColumn--;	
				}
				else{
					//System.out.println("up col");
					
					startColumn++;
				}
			}
			else{
				if(k%2==0){
					//System.out.println("backing..  row");
					startRow--;	
					
				}
				else{
					//System.out.println("up..  row");
					startRow++;
					
				}
				
			}

				
				if(j%k==0){
					followRow=!followRow;
					if(first){
						j=0;
						first=false;
					}
					else{
						first=true;
						j=0;
						k++;
					}
					
		        }

		j++;
			
		}
		
		int diagonalSum=0;
		for(int i=0;i<array.length;i++){
			for(int k=array[i].length-1;k>=0;k--){
				if(i+k==array[i].length-1){
					diagonalSum=diagonalSum+array[k][i];
				}
			}
			for(int k=0;k<array[i].length;k++){
				if(i==k){
					diagonalSum=diagonalSum+array[i][k];		
				}
				
			
				/*if(array[i][k]<10){
					System.out.print("0000"+array[i][k]+" ");	
				}
				else if(array[i][k]>=10&&array[i][k]<100){
					System.out.print("000"+array[i][k]+" ");	
				}
				else if(array[i][k]>=100&&array[i][k]<1000){
					System.out.print("00"+array[i][k]+" ");	
				}
				else if(array[i][k]>=1000&&array[i][k]<10000){
					System.out.print("0"+array[i][k]+" ");	
				}
				else{
					System.out.print(array[i][k]+" ");	
				}*/
				
			}	
		System.out.println();
		}
		
		System.out.println(diagonalSum-array[rows/2][columns/2]);
	}
	
}
