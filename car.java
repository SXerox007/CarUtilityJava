import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.io.FileOutputStream;

interface AdminChoice{
    int ADD_COUSTOMER=1;
    int ADD_CAR=2;
    int LIST_ALL_COUSTORMER=3;
    int SORT_USER_LIST=4;
    int GENERATE_PRIZES=5;
    int USER_DISPLAY=6;
    
}
interface CarAddChoice{
    int MARUTI=2;
    int HYUNDAI=3;
    int TOYOTA=1;
    int MARUTI_RESALE = (80/100);
    int HYUNDAI_RESALE = (60/100);
    int TOYOTA_RESALE = (40/100);
}


class AddCoustomer{
    public int coustomerId;
    public String coustomerName;
    public ArrayList<CarProperties> list=new ArrayList<CarProperties>();
    
    AddCoustomer(){
        coustomerId=0;
        coustomerName=" ";
        
    }
    
    public void setCar(CarProperties car){
        list.add(car);
    }
    
    public void setCoustomerId(int coustomerId,AddCoustomer coustomerAdd){
        coustomerAdd.coustomerId=coustomerId;
    }
    public void setCoustomerName(String coustomerName,AddCoustomer coustomerAdd){
        coustomerAdd.coustomerName=coustomerName;
    }
    public void addCoustomer(AddCoustomer coustomerAdd,int coustomerId,String coustomerName){
        setCoustomerId(coustomerId,coustomerAdd);
        setCoustomerName(coustomerName,coustomerAdd);
        
    }
    
    public int getCoustomerId(){
        return coustomerId;
    }
    
    public String getCoustomerName(){
        return coustomerName;
    }
    
    public ArrayList<CarProperties> getCar(){
        return list;
    }
    
    
    
}


//car properties
class CarProperties implements CarAddChoice{
    public int id;
    public String model;
    public int price;
    public String Name;
    public double resaleValue;
    CarProperties(){
        id=0;
        model=" ";
        price=0;
        Name=" ";
    }
     public void addCar(int carId,String model,int price,CarProperties car,int option){
         if(option==TOYOTA){
             car.setName("Tyota");
             car.SetId(carId);
             car.SetModel(model);
             car.SetPrice(price);
             //car.setResale(price,0.8);
         }
         else
         if(option==MARUTI){
             car.setName("Maruti");
             car.SetId(carId);
             car.SetModel(model);
             car.SetPrice(price);
         }
         else{
             car.setName("Hyundai");
             car.SetId(carId);
             car.SetModel(model);
             car.SetPrice(price);
         }
         
     }
    
    public void setName(String Name){
        this.Name=Name;
    }
    
    public String getName(){
        return Name;
    }
    public int GetId(){
        return id;
    }
    public void SetId(int id){
        this.id = id;
    }
    public String GetModel(){
        return model;
    }
    public void SetModel(String model){
        this.model = model;
    }
    public int GetPrice(){
        return price;
    }
    public void SetPrice(int price){
        this.price = price;
    }
    
     //public void setResale(int price){
     //   this.resaleValue=
     //}
}




 class NewCarAdd implements CarAddChoice{
 private int options;
     public int chooseOptions(){
         Scanner scanf=new Scanner(System.in);
         System.out.println("Choose any options to add car:- \n 1. Toyota \n 2. Maruti \n 3. Hyundai ");
         options=scanf.nextInt();
         switch(options){
         
             case TOYOTA:
                 return 1;
             case MARUTI:
                 return 2;
             case HYUNDAI:
                 return 3;
             default:
                 return 34;
        }
     }
 }



 class Toyota extends CarProperties implements CarAddChoice{
     
     int resaleValue=MARUTI_RESALE*price;
     Toyota(int resaleValue)
     {
         resaleValue=this.resaleValue;
     }
 }
 
 class Maruti extends CarProperties implements CarAddChoice{
     int resaleValue=HYUNDAI_RESALE*price;
     Maruti(int resaleValue){
         this.resaleValue=resaleValue;
     }
 }
 class Hyundai extends CarProperties implements CarAddChoice{
     int resaleValue=TOYOTA_RESALE*price;
 
     Hyundai(int resaleValue){
         this.resaleValue=resaleValue;
     }
 }




class Options implements AdminChoice{
    private int entry;
    ArrayList<AddCoustomer>coustomer=new ArrayList<AddCoustomer>();
    public int id,flag=0;
    public String name;
    public int carId;
    public String modelCar;
    public int price,option;
    AddCoustomer temp;
    Scanner scanf=new Scanner(System.in);
    public void checkListCustomer(int id){
        for(int i=0;i<coustomer.size();i++)
        {
             temp=coustomer.get(i);
            if(id==temp.getCoustomerId()){
                System.out.println("Id matched");
                flag=1;
                break;
            }
            
        }
    }
    public void menu(){
        System.out.println("Enter the Car Id:-");
        carId=scanf.nextInt();
        System.out.println("Enter the car of Model:-");
        modelCar=scanf.next();
        System.out.println("Enter the Price of Car:-");
        price=scanf.nextInt();
    }
    
    public void random(){
        int[] arr=new int[6];
        int flag=0;
        Random rand=new Random();
        for(int i=0;i<6;i++){
         arr[i]=rand.nextInt(20);
        }
        System.out.println("Enter the 3 Random Id's:-");
        for(int i=0;i<3;i++){
            System.out.println("Enter the Id:-");
            id=scanf.nextInt();
            for(int j=0;j<6;j++)
            {
                System.out.println(arr[j] + " == " + id);
                if(arr[j]==id)
                {
                    System.out.println("Winner Id is:-----" + arr[j]);
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                break;
        }
        if(flag==0)
            System.out.println("No one Win's");
   
        
    }
    public void optionsEntry(){
        do{
        System.out.println("Choose the option:- \n 1. Add new Coustomer \n 2. Add car \n 3. Display the User List \n 4. Sort the User list \n 5. Generate Prizes  \n 6. Display the User:-  \n And press 7 key to Exit");
        entry=scanf.nextInt();
        switch(entry){
            case ADD_COUSTOMER:
                //coustomerAdd.AddCoustomer();
                //---------
                AddCoustomer coustomerAdd=new AddCoustomer();
                coustomer.add(coustomerAdd);
                System.out.println("Enter the Coustomer Id:-");
                id=scanf.nextInt();
                System.out.println("Enter the Coustomer Name:-");
                name=scanf.next();
                coustomerAdd.addCoustomer(coustomerAdd,id,name);
                break;
            case ADD_CAR:
                //NewCarAdd addCar= new NewCarAdd();
                 System.out.println("Enter the Coustomer Id:-");
                 id=scanf.nextInt();
                 //--------
                 checkListCustomer(id);
                 if(flag==1)
                 {
                 NewCarAdd carAd=new NewCarAdd();
                 CarProperties car=new CarProperties();
                 option=carAd.chooseOptions();
                 if(option==1){
                      menu();
                      //Toyota=new Toyota();
                      car.addCar(carId, modelCar, price,car,1);
                      temp.setCar(car);
                 }
                 else if(option==2){
                     menu();
                     car.addCar(carId, modelCar, price,car,2);
                     temp.setCar(car);
                     
                 }
                 else if(option==3){
                     menu();
                     car.addCar(carId, modelCar, price,car,2);
                     temp.setCar(car);
                 }
                 else{
                     System.out.println("Error! \n options Not Matched");
                 }
                     
                 }
                 else{
                     System.out.println("Error! \n Key Not Matched");
                 }
                break;
            case LIST_ALL_COUSTORMER:
                for(int i=0;i<coustomer.size();i++)
                {
                    AddCoustomer temp1=coustomer.get(i);
                    System.out.println("Id:-" + temp1.getCoustomerId());
                    System.out.println("Name:-" + temp1.getCoustomerName());
                    ArrayList<CarProperties>temp2=temp1.getCar();
                    for(int j=0;j<temp2.size();j++)
                    {
                    System.out.println("Car Detail:---------");
                    System.out.println("CarId:-" + temp2.get(j).GetId());
                    System.out.println("Model:-" + temp2.get(j).GetModel());
                    System.out.println("Price:-" + temp2.get(j).GetPrice());
                    System.out.println("Car Name:-" + temp2.get(j).getName());
                    System.out.println("----------------------------------------");
                    }

                }
                
                break;
            case SORT_USER_LIST:
                //Collections.sort(coustomer);
                
        
                break;
            case GENERATE_PRIZES:
                random();
                break;
            case USER_DISPLAY:
                System.out.println("Enter the Coustomer Id:-");
                id=scanf.nextInt();
                checkListCustomer(id);
                if(flag==1)
                {
                    System.out.println("Coustomer Detail:---------");
                    System.out.println("Id:-" + temp.getCoustomerId());
                    System.out.println("Name:-" + temp.getCoustomerName());
                    System.out.println("----------------------------------------");
                    ArrayList<CarProperties>temp2=temp.getCar();
                    for(int j=0;j<temp2.size();j++)
                    {
                        System.out.println("Car Detail:---------");
                        System.out.println("CarId:-" + temp2.get(j).GetId());
                        System.out.println("Model:-" + temp2.get(j).GetModel());
                        System.out.println("Price:-" + temp2.get(j).GetPrice());
                        System.out.println("Car Name:-" + temp2.get(j).getName());
                        System.out.println("----------------------------------------");
                        
                    }
                }
                else
                {
                    System.out.println("Error! \n wrong Input");
   
                }
                break;
           
        }
        }while(entry<7);
        
        
    }
    
    
}

class Admin{
    private String adminName;
    private String adminPassword;
    private void checkAdminData(String adminName,String adminPassword){
        
        if(adminName.equals("sumit") && adminPassword.equals("sumit")){
            System.out.println("Enter Sucessfully");
            Options options=new Options();
            options.optionsEntry();
        }
        else{
            System.out.println("Error");
            throw new ArithmeticException("not valid");
        }
    }
    public void loginAdmin(){
        //FileOutputStream fout= new FileOutputStream("testout.txt");

        System.out.println("Enter the UserName:- ");
        Scanner scanf=new Scanner(System.in);
        adminName=scanf.next();
        //byte b[]=adminName.getBytes();
        //fout.write(b);
        //fout.close();
        System.out.println("Enter the Password:-");
        adminPassword=scanf.next();


        checkAdminData(adminName,adminPassword);
    }
}





public class car{
    public static void main(String args[]){
        try{
            System.out.println(" \n Username:- sumit \n Password:- sumit \n ");
            Admin sumit=new Admin();
            sumit.loginAdmin();
        }catch(ArithmeticException ae){
            System.out.println("Exception Catch");
        }
    }
}
