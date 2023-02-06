import java.util.Scanner;

public class Lab2 {
    
    public static void main(String[]args) {

        String arr[]= new String[1024];
        int r=0;
        int i=0;
        int d=0;
        int j=0;
        do{
            System.out.println("1.Enter A Name 2.Search For a Name 3.Remove a Name. Enter Your Choice: ");
            Scanner sc=new Scanner(System.in);
            int x= sc.nextInt();            
            switch (x) {
                case 1:
                System.out.println("Enter The No of Names You want To add: ");
                int c=sc.nextInt();
                r=c;
                for(i=0;i<c;i++){
                    System.out.println("Enter Name "+(i+1)+" :");
                    String a= sc.next();
                    for(j=0;j<c;j++){
                        if(arr[j]==a){
                            System.out.println("This Name is already Added:");
                            System.out.println("Enter Name "+(i+1)+" :");
                            arr[i]=sc.next();
                        }
                        else{
                            arr[i]=a;
                        }   
                        break;               
                    }
                    
                }
                break;

                case 2:
                System.out.println("Enter The name You Want To Search: ");
                String val =sc.next();
                int e=0;
                for(i=0;i<r;i++){
                    if(arr[i]==val){
                      e+=1 ;
                    }
                }
                if(e>0){
                    System.out.println("Name In Array");
                }else{
                    System.out.println("Name not In Array");
                }
                break;

                case 3:
                System.out.println("Enter The name You Want To Remove: ");
                String val1 =sc.next();
                for(i=0;i<r;i++){
                    if(arr[i]==val1){
                        for(j=i;j<r;j++){
                            arr[j]=arr[j+1];
                        }
                    }
                }
                break;      
            }
            System.out.println("Do You Want To Continue(1/2): ");
            d=sc.nextInt();
        }while(d==1);

        System.out.println(r);
        System.out.println("The Array is: ");
        for(i=0;i<r;i++){
            System.out.println(arr[i]);
        }

    }
}
