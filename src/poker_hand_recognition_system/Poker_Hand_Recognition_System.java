/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker_hand_recognition_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Bhailoo
 */
public class Poker_Hand_Recognition_System {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        /*Intialization of arrays , scanner object, buffered reader oobject*/
        BufferedReader reader ;
        reader = new BufferedReader(new FileReader("src/Poker_Training.csv"));
        String line=null;
        Scanner scanner = null;
        int index=0;
        int Recognized_Class=0;
        int card_1_color[]=new int[25000];
        int card_1[]=new int[25000];
        int card_2_color[]=new int[25000];
        int card_2[]=new int[25000];
                int card_3_color[]=new int[25000];
        int card_3[]=new int[25000];
                int card_4_color[]=new int[25000];
        int card_4[]=new int[25000];
                int card_5_color[]=new int[25000];
        int card_5[]=new int[25000];
        
        /*Intialization of arrays of each cluster*/
        float High_Card[] = new float[2];
        High_Card[0]=-1;
        float One_Pair[] = new float[2];
         One_Pair[0]=-1;
        float Two_Pair[]=new float[2];
         Two_Pair[0]=-1;
        float[] Three_Of_A_Kind = new float[2];
         Three_Of_A_Kind[0]=-1;
        float Straight[] = new float[2];
         Straight[0]=-1;
        float Flush[]=new float[2];
         Flush[0]=-1;
        float Full_House [] = new float[2];
         Full_House[0]=-1;
        float Four_Of_A_Kind[] = new float[2];
         Four_Of_A_Kind[0]=-1;
        float Straight_Flush[]=new float[2];
         Straight_Flush[0]=-1;
        float Royal_Flush[]=new float[2];
         Royal_Flush[0]=-1;
        int Value = 0;
        
        /*Reading data from csv file and putting into the respective array*/
            
            for(int i=1;i<19000;i++)
            {
               
                line=reader.readLine();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                card_1_color[i-1]=Integer.valueOf(scanner.next());
                 card_1[i-1]=Integer.parseInt(scanner.next());  
                 card_2_color[i-1]=Integer.parseInt(scanner.next());
                  card_2[i-1]=Integer.parseInt(scanner.next());
                   card_3_color[i-1]=Integer.parseInt(scanner.next());
                   card_3[i-1]=Integer.parseInt(scanner.next());
                   card_4_color[i-1]=Integer.parseInt(scanner.next());
                   card_4[i-1]=Integer.parseInt(scanner.next());
                   card_5_color[i-1]=Integer.parseInt(scanner.next());
                   card_5[i-1]=Integer.parseInt(scanner.next());
                   Value=Integer.parseInt(scanner.next());
           

                float node_value;  
            node_value = Sort_And_Give_A_Value( card_1_color[i-1],card_1[i-1],card_2_color[i-1],card_2[i-1],card_3_color[i-1],card_3[i-1],card_4_color[i-1],card_4[i-1],card_5_color[i-1],card_5[i-1],Value);
                    switch(Value)
                    {
                        /*by putting node_value to cluster and simultaneously finding the centroid*/
                             
                        case 0:
                        {
                           if(High_Card[0]==-1)
                           {
                               High_Card[0]=node_value;
                           }
                            High_Card[1]=node_value;
                            High_Card[0]=(High_Card[0]+High_Card[1])/2;
                            break;
                        }
                        case 1:
                        {
                            if(One_Pair[0]==-1)
                            {
                                One_Pair[0]=node_value;
                            }
                            One_Pair[1]=node_value;
                           One_Pair[0]=(One_Pair[0]+One_Pair[1])/2;
                           break;
                        }
                        case 2:
                        {
                             if(Two_Pair[0]==-1)
                            {
                                Two_Pair[0]=node_value;
                            }
                            Two_Pair[1]=node_value;
                           Two_Pair[0]=(Two_Pair[0]+Two_Pair[1])/2;
                           break;
                        }
                        case 3:
                        {
                             if(Three_Of_A_Kind[0]==-1)
                            {
                                Three_Of_A_Kind[0]=node_value;
                            }
                            Three_Of_A_Kind[1]=node_value;
                           Three_Of_A_Kind[0]=(Three_Of_A_Kind[0]+Three_Of_A_Kind[1])/2;
                           break;
                        }
                        case 4:
                        {
                             if(Straight[0]==-1)
                            {
                                Straight[0]=node_value;
                            }
                            Straight[1]=node_value;
                           Straight[0]=(Straight[0]+Straight[1])/2;
                           break;
                        }
                        case 5:
                        {
                               if(Flush[0]==-1)
                            {
                                Flush[0]=node_value;
                            }
                            Flush[1]=node_value;
                           Flush[0]=(Flush[0]+Flush[1])/2;
                           break;
                        }
                        case 6:
                        {
                               if(Full_House[0]==-1)
                            {
                                Full_House[0]=node_value;
                            }
                            Full_House[1]=node_value;
                          Full_House[0]=(Full_House[0]+Full_House[1])/2;     
                          break;
                        }
                        case 7:
                        {
                               if(Four_Of_A_Kind[0]==-1)
                            {
                                Four_Of_A_Kind[0]=node_value;
                            }
                           Four_Of_A_Kind[1]=node_value;
                          Four_Of_A_Kind[0]=(Four_Of_A_Kind[0]+Four_Of_A_Kind[1])/2;     
                          break;
                        }
                        case 8:
                        {
                            
                               if(Straight_Flush[0]==-1)
                            {
                                Straight_Flush[0]=node_value;
                            }
                         Straight_Flush[1]=node_value;
                          Straight_Flush[0]=(Straight_Flush[0]+Straight_Flush[1])/2;     
                         break;   
                        }
                        case 9:
                        {   
                            if(Royal_Flush[0]==-1)
                            {
                                Royal_Flush[0]=node_value;
                            }
                         Royal_Flush[1]=node_value;
                         Royal_Flush[0]=(Royal_Flush[0]+Royal_Flush[1])/2;     
                         break;   
                        }
                            
                    }
                }
            
                /*Assigning the centroid to seperate variable*/
            float High_Card_Centroid=High_Card[0];
            float One_Pair_Centroid=One_Pair[0];
            float Two_Pair_Centroid=Two_Pair[0];
            float Three_Of_A_Kind_Centroid= Three_Of_A_Kind[0];
            float Full_House_Centroid=Full_House[0];
            float Four_Of_A_Kind_Centroid=Four_Of_A_Kind[0];
            float Straight_Centroid=Straight[0];
            float Flush_Centroid=Flush[0];
            float Straight_Flush_Centroid=Straight_Flush[0];
            float Royal_Flush_Centroid=Royal_Flush[0];
            
           System.out.println("High_Card_Centroid:      :"+High_Card_Centroid);
           System.out.println("One_Pair_Centroid:       :"+One_Pair_Centroid);
           System.out.println("Two_Pair_Centroid:       :"+Two_Pair_Centroid);
           System.out.println("Three_Of_A_Kind_Centroid :"+Three_Of_A_Kind_Centroid);
           System.out.println("Full_House_Centroid      :"+ Full_House_Centroid);
           System.out.println("Four_Of_A_Kind_Centroid  :"+Four_Of_A_Kind_Centroid);
           System.out.println("Straight_Centroid        :"+Straight_Centroid);
           System.out.println("Flush_Centroid           :"+Flush_Centroid);
           System.out.println("Straight_Flush_Centroid  :"+Straight_Flush_Centroid);
           System.out.println("Royal_Flush_Centroid     :"+Royal_Flush_Centroid);
           
           Check_Efficiency p;
           
           new Check_Efficiency(High_Card_Centroid,One_Pair_Centroid,Two_Pair_Centroid,Three_Of_A_Kind_Centroid,Full_House_Centroid,Four_Of_A_Kind_Centroid,Straight_Centroid,Flush_Centroid,Straight_Flush_Centroid,Royal_Flush_Centroid);
           
           
    }
    public static float Sort_And_Give_A_Value(int card_1_color, int card_1, int card_2_color, int card_2, int card_3_color, int card_3, int card_4_color, int card_4, int card_5_color, int card_5, int Value) {
        float card_color_weight = 0;
        float card_order_weight=0;
        int card_similarity_weight=1;
        /*checking for flush*/
        if((card_1_color==card_2_color)&&(card_1_color==card_3_color)&&(card_1_color==card_4_color)&&(card_1_color==card_5_color))
        {
             card_color_weight=100000;
            
        }
        /*assigning the card_values to a seperate array to make operations easier and faster*/
        int card_value[] = new int[5];
        int k=0;
        card_value[0]=card_1;
        card_value[1]=card_2;
        card_value[2]=card_3;
        card_value[3]=card_4;
        card_value[4]=card_5;
      
        int frequency_array[]=new int[5];
        int p=0;
        Arrays.sort(card_value);
        /*Finding frequencey of each card values for checking pairs & full house*/
        /*int[] distinct_element = new int[5];
        int counter = 0, count = 0;
        for (int i = 0; i < card_value.length; i++) {
            boolean isDistinct = false;
            for (int j = 0; j < i; j++) {
                if (card_value[i] == card_value[j]) {
                    isDistinct = true;
                    break;
                }
            }
            if (!isDistinct) {
                distinct_element[counter++] = card_value[i];
            }
        }
        for (int i = 0; i < counter; i++) {
            count = 0;
            for (int j = 0; j < card_value.length; j++) {
                if (distinct_element[i] == card_value[j]) {
                    count++;
                }
                if(count>1)
                {
                    for(int x=0;x<5;x++)
                    {
                        if(weight_for_card[x]==0)
                        weight_for_card[x]=1;
                    }
                    weight_for_card[p++]=7^count;
                }
                
            }
            


        }*/
        int check_frequency=0;
        
        
        for(int i=0;i<4;)
        {
            check_frequency=card_value[i++];
            if(check_frequency==card_value[i])
            {
              card_similarity_weight*=15;
              i++;
              if(i<5)
              {
              if(check_frequency==card_value[i])
              {
                  card_similarity_weight*=50;
                  i++;
                  if(i<5){
                  if(check_frequency==card_value[i]&& i<5)
                  {
                      card_similarity_weight*=40;
                  }
                  }
              }
            }
            }
           
        }
            
            /*Checking for straight*/
            if(card_value[4]-card_value[0]==4 && card_similarity_weight<5)
            {
                card_order_weight=5*5*5*5*5;
                
               
            }
            /*Checking for Royal Flush*/
             if(card_value[4]-card_value[0]==12 && card_similarity_weight<5 && card_color_weight==100000)
             {
                 card_order_weight=5*5*5*5*5*10;
             }
            
        
        return (card_similarity_weight+card_order_weight+card_color_weight)/3;

            
        
    }

    
}

    

