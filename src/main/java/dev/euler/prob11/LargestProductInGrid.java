package dev.euler.prob11;

public class LargestProductInGrid {

	public static void main(String[] args) {

		String data="08022297381500400075040507785212507791084949994017811857608717409843694804566200814931735579142993714067538830034913366552709523046011426924685601325671370236912231167151676389419236542240402866331380244732609903450244753353783684203517125032988128642367102638406759547066183864706726206802621220956394396308409166499421245558056673992697177878968314883489637221362309750076442045351400613397343133957817532822753167159403800462161409535692163905429635314755588824001754243629855786560048357189070544443744602158515417581980816805944769287392138652177704895540045208839735991607975732162626793327986688366887576220720346336746551232639353690442167338253911249472180846293240627636206936417230238834629969826759857404361620733529783190017431497148868116235705540170547183515469169233486143520189196748";
		int[][] dataFormat=new int[20][20];
		byte[] bytes=data.getBytes();
		int zero= (int)'0';
		for(int i=0,j=0;i<bytes.length-1;i=i+2,j++){
			//System.out.println("i.."+i+"length--"+bytes.length);
			if(i<20){
				int number=10*(bytes[i]-zero)+bytes[i+1]-zero;
				//System.out.println("adding number "+number);
				dataFormat[0][j%20]=number;
			}
			else{
				//System.out.println("[i/20][i%20]"+j/20+","+j%20);
				int number=10*(bytes[i]-zero)+bytes[i+1]-zero;
				//System.out.println("adding number "+number);
				dataFormat[j/20][j%20]=number;
			}
		}
		int rowProductMaximum=1;
		int columnProductMaximum=1;
		int negativeDiagonalProductMaximum=1;
		int positiveDiagonalProductMaximum=1;
		  
		for(int i=0;i<dataFormat.length;i++){
			for(int j=0;j<dataFormat[i].length;j++){
				if((dataFormat[i][j]+"").length()==1){
				//	System.out.print(0+""+dataFormat[i][j]+" ");
				}
				else{
					//System.out.print(dataFormat[i][j]+" ");	
				}
				
			}
			System.out.println();
		}
System.out.println("-------------scan1---------------");
		int limit=4;
		for(int i=0;i<dataFormat.length;i++){
			for(int j=0;j<dataFormat[i].length-limit+1;j++){
		     int localsum=1;
		     String dataScan="";
		     //System.out.print(i+":"+j+" ");
		     for(int k=0;k<limit&&(j+k)<dataFormat[i].length;k++){
		    	 dataScan=dataScan+dataFormat[i][j+k]+":" ;
		    	 localsum=localsum*dataFormat[i][j+k];
		     }
		    // System.out.println(dataScan);
			 	if(localsum>rowProductMaximum){
			 		rowProductMaximum=localsum;
			 	}
			}
		}
		
	
		
		int[][] transposedDataFormat= new int[20][20];
		//System.out.println("transposing..");
		for(int i=0;i<dataFormat.length;i++){
			for(int j=0;j<dataFormat[i].length;j++){
				transposedDataFormat[i][j]= dataFormat[j][i]; 
				
			}
			
		}
		//System.out.println("----------------------------");
		for(int i=0;i<transposedDataFormat.length;i++){
			for(int j=0;j<transposedDataFormat[i].length;j++){
				if((transposedDataFormat[i][j]+"").length()==1){
			//		System.out.print(0+""+transposedDataFormat[i][j]+" ");
				}
				else{
				//	System.out.print(transposedDataFormat[i][j]+" ");	
				}
				
			}
		//	System.out.println();
		}
		
		
	//	System.out.println("------------------------------");
		for(int i=0;i<transposedDataFormat.length;i++){
			for(int j=0;j<transposedDataFormat[i].length-limit+1;j++){
		     int localsum=1;
		     
		     for(int k=0;k<limit&&(j+k)<transposedDataFormat[i].length;k++){
		    	 
		    	 localsum=localsum*transposedDataFormat[i][j+k];
		     }
			 	if(localsum>columnProductMaximum){
			 		columnProductMaximum=localsum;
			 	}
			}
		}
		//System.out.println(rowSumMaximum);
		//System.out.println(columnSumMaximum);
		
		
		//------------------
		for(int i=0,ip=0;ip<dataFormat.length;ip++){
			
			for(int j=ip;j<dataFormat[i].length-limit+1;j++){
		
				System.out.print(i+":"+j+" ");
				int localproduct=1;
				String dataScan="";
				for(int k=0;k<limit&& (j+k)<dataFormat[i].length;k++){
					dataScan=dataScan+dataFormat[i+k][j+k]+":";
					localproduct=localproduct*dataFormat[i+k][j+k];
				}
				//System.out.println(dataScan);
				if(localproduct>negativeDiagonalProductMaximum){
					negativeDiagonalProductMaximum=localproduct;
				}
				
				localproduct=1;
				dataScan="";
				for(int k=0;k<limit&& (j+k)<dataFormat[i].length;k++){
					dataScan=dataScan+dataFormat[j+k][i+k]+":";
					localproduct=localproduct*dataFormat[j+k][i+k];
				}
				if(localproduct>negativeDiagonalProductMaximum){
					negativeDiagonalProductMaximum=localproduct;
				}
				//System.out.print(j+":"+i+" ");
				//System.out.println(dataScan);
				if(i<dataFormat.length-1){
					i=i+1;	
				}
				
			}
			i=0;
			//System.out.println();
		}
		//---------------------
		
		System.out.println("-----------scan2-------------------");
		int[][] cDataFormat=new int[20][20];
		int length=dataFormat.length;
	for(int i=0,ip=0;ip<dataFormat.length;ip++){
		for(int j=0,k=0;j<dataFormat.length;j++){
			System.out.print((19-j)+":"+ip+" ");
			cDataFormat[ip][j]=dataFormat[(19-j)][ip];
			
			
		}
		
	System.out.println();
		
	}
	for(int i=0;i<cDataFormat.length;i++){

		for(int j=0;j<cDataFormat[i].length;j++){
			
			if((cDataFormat[i][j]+"").length()==1){
				System.out.print(0+""+cDataFormat[i][j]+" ");
				}
				else{
					System.out.print(cDataFormat[i][j]+" ");	
				}
			
		}
		System.out.println();
	}		
		
	
	
	//------------------
			for(int i=0,ip=0;ip<cDataFormat.length;ip++){
				
				for(int j=ip;j<cDataFormat[i].length-limit+1;j++){
			
					System.out.print(i+":"+j+" ");
					int localproduct=1;
					String dataScan="";
					for(int k=0;k<limit&& (j+k)<cDataFormat[i].length;k++){
						dataScan=dataScan+cDataFormat[i+k][j+k]+":";
						localproduct=localproduct*cDataFormat[i+k][j+k];
					}
					//System.out.println(dataScan);
					if(localproduct>positiveDiagonalProductMaximum){
						positiveDiagonalProductMaximum=localproduct;
					}
					
					localproduct=1;
					dataScan="";
					for(int k=0;k<limit&& (j+k)<cDataFormat[i].length;k++){
						dataScan=dataScan+cDataFormat[j+k][i+k]+":";
						localproduct=localproduct*cDataFormat[j+k][i+k];
					}
					if(localproduct>positiveDiagonalProductMaximum){
						positiveDiagonalProductMaximum=localproduct;
					}
					//System.out.print(j+":"+i+" ");
					//System.out.println(dataScan);
					if(i<cDataFormat.length-1){
						i=i+1;	
					}
					
				}
				i=0;
				//System.out.println();
			}
			//---------------------
		
	System.out.println(rowProductMaximum);
	System.out.println(columnProductMaximum);
	System.out.println(negativeDiagonalProductMaximum);
	System.out.println(positiveDiagonalProductMaximum);
	}

	
	
}
