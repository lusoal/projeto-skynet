public class Ex05 {      
        
        
        public static void exA(int[] array) 
         {
         int pNum, sNum, tNum;
         
                for (pNum = 1; pNum < array.length; pNum++) 
                {
                tNum = array[pNum];
                sNum = pNum-1;
                        while(sNum >= 0 && tNum < array[sNum])
                        {
                               array[sNum + 1] = array[sNum];
                               sNum--;
                        }
                        array[sNum+1]=tNum;                       
                }               
        } 
        
        public static void exAb(int[] array) 
         {
         int pNum, sNum, tNum;
         
                for (pNum =array.length -1; pNum >=0; pNum--) 
                {
                tNum = array[pNum];
                sNum = pNum-1;
                        while(sNum >= 0 && tNum < array[sNum])
                        {
                               array[sNum + 1] = array[sNum];
                               sNum--;
                        }
                        array[sNum+1]=tNum;                       
                }               
        } 
        
  public static int ExB(int[] array) 
         {
         int i = 0;
         int aux = 0;
         int pNum, sNum, tNum;
       
              
                for (pNum =1; pNum< array.length; pNum++) 
                {
                tNum = array[pNum];
                sNum = pNum-1;
                
                        while(sNum >= 0 && tNum < array[sNum])
                        {
                               array[sNum + 1] = array[sNum];
                               sNum--;
                               i++;
                               aux++;
                        }
                        array[sNum+1]=tNum;  
                                             
                } 
                //Ex05_BeC
                //System.out.println(" o inserion sort fez em: " + cont + " vezes"); 
                //System.out.println(" o inserion sort fez em: " + c + " comparacoes");   
                
               //Ex05_DTrocas
                //return cont;  
                
                //Ex05_Dcomparacoes
                return aux;   
        }   
        
           
         public static int ExBb(int array[]) {
     int pNum, sNum, i=0, tNum;
     int aux = 0;
     int auxX = 0;
    
     for(pNum = 0; pNum<array.length - 1; pNum++) {
      
        aux = pNum;
        tNum = array[pNum]; 
        auxX++;
        
        
        for(sNum = pNum; sNum<array.length-1; sNum++) {
           if(array[sNum] < tNum){
            aux = sNum;
            tNum=  array[sNum];
      
           }
          auxX++; 
          i++;
        }
        array[aux] = array[pNum];
        array[pNum] = tNum;
      
      }
        //Ex05_BeC
        //System.out.println(" o Selection sort fez em: " + cont + " vezes"); 
        //System.out.println(" o Selection sort fez em: " + c2 + " comparacoes");   
       
        //Ex05_DTrocas
        //return cont;
        
     //Ex05_Dcomparacoes
      return auxX;       

   } 
   
 public static int exC(int array[]){
   int pNum, sNum, tNum;
   int i = 0;
   int aux = 0;
  
    for(pNum=0; pNum<array.length-1; pNum++){
		for(sNum=array.length-1; sNum>=pNum; sNum--){
			if(array[sNum - 1] > array[sNum]){
				tNum = array[sNum-1];
				array[sNum-1] = array[sNum];
				array[sNum] = tNum;
         }
         i++;
         aux++;
		}
      
	}
    //Ex05_BeC
    //System.out.println(" o Bubble sort fez em: " + cont + " vezes");
    //System.out.println(" o Bubble sort fez em: " + c + " comparacoes"); 
    
    //Ex05_DTrocas
    //return cont;    
    
    //Ex04_Dcomparacoes
      return i;  
    
    
  }   
    public static void main(String args[]) {
      //int[] vetor = {3,2,1};  
      //int[] vetor = {9,8,7,6,5,4,3,2,1}; 
      int[] array = new int[1000]; 
      int div; 
    
        for ( int i = 0; i < array.length; i++ ) 
        {
           array[i] = (int)Math.round(Math.random() * 1000); 

        }
    div = ExB(array) + exC(array) / 3;
    
     System.out.println(" media  " + div);         
            /*
            //Ex05_A
            //insertionSort(vetor);
            //insertSort(vetor);
            for(int i:vetor){  
            System.out.print(i+" ");  
        }*/
        //Ex04_B e C  
        
   // exB(array);
    //exA(array);
    //exC(array);

          
    }  


}