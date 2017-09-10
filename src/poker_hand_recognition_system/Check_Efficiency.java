/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker_hand_recognition_system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
public class Check_Efficiency {
    private float Straight_Flush_Cetroid;
    Check_Efficiency(float High_Card_Centroid,float One_Pair_Centroid,float Two_Pair_Centroid,float Three_Of_A_Kind_Centroid,float Full_House_Centroid,float Four_Of_A_Kind_Centroid,float Straight_Centroid,float Flush_Centroid,float Striaght_Flush_Centroid,float Royal_Flush_Centroid) throws FileNotFoundException, IOException
    {
        
    
            BufferedReader reader ;
        reader = new BufferedReader(new FileReader("src/Poker_Training.csv"));
        String line=null;
        Scanner scanner = null;
        int index=0;
        int Recognized_Class=0;
        int card_1_color=0;
        int card_1=0;
                int card_2_color=0;
        int card_2=0;
                int card_3_color=0;
        int card_3=0;
                int card_4_color=0;
        int card_4=0;
                int card_5_color=0;
        int card_5=0;
        int Value;
        float node_value;
        int correctly_classified=0;
        int correctly_classified_High_Card=0;
        int correctly_classified_One_Pair=0;
        int correctly_classified_Two_Pair=0;
        int correctly_classified_Three_Of_A_Kind=0;
        int correctly_classified_Four_Of_A_Kind=0;
        int correctly_classified_Full_House=0;
        int correctly_classified_Straight=0;
        int correctly_classified_Straight_Flush=0;
        int correctly_classified_Flush=0;
        int correctly_classified_Royal_Flush=0;
        int incorrectly_classified=0;
         int incorrectly_classified_High_Card=0;
        int incorrectly_classified_One_Pair=0;
        int incorrectly_classified_Two_Pair=0;
        int incorrectly_classified_Three_Of_A_Kind=0;
        int incorrectly_classified_Four_Of_A_Kind=0;
        int incorrectly_classified_Full_House=0;
        int incorrectly_classified_Straight=0;
        int incorrectly_classified_Straight_Flush=0;
        int incorrectly_classified_Flush=0;
        int incorrectly_classified_Royal_Flush=0;

        Poker_Hand_Recognition_System obj = null;
        for(int i=0;i<25010;i++)
        {
             line=reader.readLine();
            if(i>19000)
            {
                
            
        
                       
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                card_1_color=Integer.valueOf(scanner.next());
                 card_1=Integer.parseInt(scanner.next());  
                 card_2_color=Integer.parseInt(scanner.next());
                  card_2=Integer.parseInt(scanner.next());
                   card_3_color=Integer.parseInt(scanner.next());
                   card_3=Integer.parseInt(scanner.next());
                   card_4_color=Integer.parseInt(scanner.next());
                   card_4=Integer.parseInt(scanner.next());
                   card_5_color=Integer.parseInt(scanner.next());
                   card_5=Integer.parseInt(scanner.next());
                   Value=Integer.parseInt(scanner.next());
                  // System.out.print("Given Class:     "+Value);
                    node_value =obj.Sort_And_Give_A_Value( card_1_color[i-1],card_1[i-1],card_2_color[i-1],card_2[i-1],card_3_color[i-1],card_3[i-1],card_4_color[i-1],card_4[i-1],card_5_color[i-1],card_5[i-1],Value);  
                    
                   int recognized_class= recognize_class( node_value,High_Card_Centroid, One_Pair_Centroid, Two_Pair_Centroid, Three_Of_A_Kind_Centroid, Full_House_Centroid, Four_Of_A_Kind_Centroid, Straight_Centroid, Flush_Centroid,Straight_Flush_Cetroid, Royal_Flush_Centroid);
                   //System.out.println("         Recognized Class:    "+recognized_class);
                   if(Value==recognized_class)
                   {
                       correctly_classified++;
                       switch(Value)
                       {
                           case 0:
                           {
                               correctly_classified_High_Card++;
                               break;
                           }
                           case 1:
                           {
                               correctly_classified_One_Pair++;
                               break;
                           }
                           case 2:
                           {
                               correctly_classified_Two_Pair++;
                               break;
                           }
                           case 3:
                           {
                               correctly_classified_Three_Of_A_Kind++;
                               break;
                           }
                           case 4:
                           {
                               correctly_classified_Full_House++;
                               break;
                           }
                           case 5:
                           {
                               correctly_classified_Four_Of_A_Kind++;
                               break;
                           }
                           case 6:
                           {
                               correctly_classified_Straight++;
                               break;
                           }
                           case 7:
                           {
                               correctly_classified_Flush++;
                               break;
                           }
                           case 8:
                           {
                               correctly_classified_Straight_Flush++;
                               break;
                           }
                           case 9:
                           {
                               correctly_classified_Royal_Flush++;
                               break;
                           }
                               
                       }
                       
                   }
                   else
                   {
                       incorrectly_classified++;
                       switch(Value)
                       {
                           case 0:
                           {
                               incorrectly_classified_High_Card++;
                               break;
                           }
                           case 1:
                           {
                               incorrectly_classified_One_Pair++;
                               break;
                           }
                           case 2:
                           {
                               incorrectly_classified_Two_Pair++;
                               break;
                           }
                           case 3:
                           {
                               incorrectly_classified_Three_Of_A_Kind++;
                               break;
                           }
                           case 4:
                           {
                               incorrectly_classified_Full_House++;
                               break;
                           }
                           case 5:
                           {
                               incorrectly_classified_Four_Of_A_Kind++;
                               break;
                           }
                           case 6:
                           {
                               incorrectly_classified_Straight++;
                               break;
                           }
                           case 7:
                           {
                               incorrectly_classified_Flush++;
                               break;
                           }
                           case 8:
                           {
                               incorrectly_classified_Straight_Flush++;
                               break;
                           }
                           case 9:
                           {
                               incorrectly_classified_Royal_Flush++;
                               break;
                           }
                               
                       }
                   }
            }
        }           
           
                    /* giving node value to every row and putting into the respective cluster*/
                
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Correctly classified:            "+correctly_classified);
                    System.out.println();
                    
                    System.out.println("Incorrectly classified:           "+incorrectly_classified);
                    System.out.println();
                    System.out.println("Efficiency:                      "+(float)(correctly_classified)*100/(correctly_classified+incorrectly_classified)+"%");
                    
                     /*System.out.print("HighCard:"+ correctly_classified_High_Card);
        System.out.println("OnePair"+ correctly_classified_One_Pair);
        System.out.println("TwoPair"+correctly_classified_Two_Pair);
        System.out.println( "Three Of A Kind"+correctly_classified_Three_Of_A_Kind);
        System.out.println("Four Of A Kind"+ correctly_classified_Four_Of_A_Kind);
        System.out.println("Full House"+ correctly_classified_Full_House);
        System.out.println("Straight"+ correctly_classified_Straight);
        System.out.println("Straight Flush"+ correctly_classified_Straight_Flush);
        System.out.println("Flush"+correctly_classified_Flush);
        System.out.println("Royal Flush"+ correctly_classified_Royal_Flush);*/

                    
    
    }

    

    private int recognize_class(float node_value,float High_Card_Centroid, float One_Pair_Centroid, float Two_Pair_Centroid, float Three_Of_A_Kind_Centroid, float Full_House_Centroid, float Four_Of_A_Kind_Centroid, float Straight_Centroid, float Flush_Centroid,float Straight_Flush_Centroid, float Royal_Flush_Centroid) {
        int recognized_class;
                recognized_class=0;
                        float min_distance;
        
        float distance_with_High_Card_Centroid=(node_value-High_Card_Centroid)*(node_value-High_Card_Centroid);
        min_distance=distance_with_High_Card_Centroid;
        
                    float distance_with_One_Pair_Centroid=(node_value-One_Pair_Centroid)*(node_value-One_Pair_Centroid);
                    if(distance_with_One_Pair_Centroid<min_distance)
                    {
                        min_distance=distance_with_One_Pair_Centroid;
                        recognized_class=1;
                    }
                    float distance_with_Two_Pair_Centroid=(node_value-Two_Pair_Centroid)*(node_value-Two_Pair_Centroid);
                     if(distance_with_Two_Pair_Centroid<min_distance)
                    {
                        min_distance=distance_with_Two_Pair_Centroid;
                        recognized_class=2;
                    }
                    float distance_with_Three_Of_A_Kind_Centroid=(node_value-Three_Of_A_Kind_Centroid)*(node_value-Three_Of_A_Kind_Centroid);
                    if(distance_with_Three_Of_A_Kind_Centroid<min_distance)
                    {
                        min_distance=distance_with_Three_Of_A_Kind_Centroid;
                        recognized_class=3;
                    }
                     float distance_with_Straight_Centroid=(node_value-Straight_Centroid)*(node_value-Straight_Centroid);
                     if(distance_with_Straight_Centroid<min_distance)
                    {
                        min_distance=distance_with_Straight_Centroid;
                        recognized_class=4;
                    }
                     float distance_with_Flush_Centroid=(node_value-Flush_Centroid)*(node_value-Flush_Centroid);
                     if(distance_with_Flush_Centroid<min_distance)
                    {
                        min_distance=distance_with_Flush_Centroid;
                        recognized_class=5;
                    }
                     float distance_with_Full_House_Centroid=(node_value-Full_House_Centroid)*(node_value-Full_House_Centroid);
                    if(distance_with_Full_House_Centroid<min_distance)
                    {
                        min_distance=distance_with_Full_House_Centroid;
                        recognized_class=6;
                    }
                   

                    float distance_with_Four_Of_A_Kind_Centroid=(node_value-Four_Of_A_Kind_Centroid)*(node_value-Four_Of_A_Kind_Centroid);
                   if(distance_with_Four_Of_A_Kind_Centroid<min_distance)
                    {
                        min_distance=distance_with_Four_Of_A_Kind_Centroid;
                        recognized_class=7;
                    } 
                    float distance_with_Straight_Flush_Centroid=(node_value-Straight_Flush_Centroid)*(node_value-Straight_Flush_Centroid);
                    if(distance_with_Straight_Flush_Centroid<min_distance)
                    {
                        min_distance=distance_with_Straight_Flush_Centroid;
                        recognized_class=8;
                    }
                    float distance_with_Royal_Flush_Centroid=(node_value-Royal_Flush_Centroid)*(node_value-Royal_Flush_Centroid);
                    if(distance_with_Royal_Flush_Centroid<min_distance)
                    {
                        min_distance=distance_with_Royal_Flush_Centroid;
                        recognized_class=9;
                    }
                    
        
            return recognized_class;

    
    
}
 
}
       
