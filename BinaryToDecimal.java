import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class BinaryToDecimal {

    static int i = 0;

    public static String[] arr = new String[4];



    public static void main(String[] args) throws IOException {
        StringBuilder sb1 = new StringBuilder();

        File file = new File("input.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();

        arr[i] = satir;


        while (satir != null) {
            System.out.println(arr[i]);
            i += 1;
            satir = reader.readLine();
            if (satir != null) {
                arr[i] = satir;
            }
        }
        ///////////////////////////////////////////////



        for (int st=0; st<=2; st++){
            System.out.println("for the" + st + "' number");
            Scanner input = new Scanner(System.in);
            System.out.print("Data type size: ");
            String size = input.nextLine();
            String[] h = size.split(" ");

            int datatypesize = Integer.valueOf(h[0]);
        String[] arr1 = arr[st].split(" ");
        String[] arrnew = new String[datatypesize];
        String[] endian = new String[datatypesize];
        for (int i = 0; i < datatypesize; i++) {
            arrnew[i] = arr1[i];
        }
        int k;
        int o;
        Scanner input2 = new Scanner(System.in);
        System.out.print("Data type: ");
        String datatype = input2.nextLine();
        long term = 0;
        int iter = 8 * (arrnew.length) - 4;
        int nter = 8 * (arrnew.length);

        Scanner input1 = new Scanner(System.in);
        System.out.print("Byte ordering: ");
        String ordering = input1.nextLine();

        if (ordering.equals("Little Endian")) {

            for (int i = 0; i < datatypesize; i++) {
                endian[i] = arrnew[i];
            }
            for (int i = 0; i < datatypesize; i++) {
                arrnew[i] = endian[endian.length - i - 1];
                System.out.print(arrnew[i]);
        }
            //////////////////////////////////////////////////


            if (datatype.equals("Signed integer")) {
                for (k = 0; k < arrnew.length; k++) {
                    for (int s = 0; s < 2; s++) {

                        if (arrnew[k].charAt(s) == 'f' || arrnew[k].charAt(s) == 'F') {
                            String array[] = new String[1];
                            array[0] = "1111";
                            if (s == 0 && k == 0) {
                                term += -1 * Math.pow(2, nter);
                                System.out.println(term);

                                for (o = nter - 1; o <= nter - 3; nter--) {//
                                    term += 1 * Math.pow(2, o);
                                }
                                if (s == 0 && k != 0) {
                                    for (o = nter; o <= nter - 3; nter--) {
                                        term += 1 * Math.pow(2, o);

                                    }
                                } else if (s == 1) {
                                    for (o = iter; o <= iter - 3; iter--) {
                                        term += 1 * Math.pow(2, o);
                                    }
                                }

                            }
                        }//end of F
                        else if(arrnew[k].charAt(s)=='e' ) {
                            String array[] = new String[1];
                            array[0] = "1110";
                            if (s == 0) {
                                for (o = nter; o <= nter-2; nter--) {//
                                    term +=  1 * Math.pow(2, o);}

                            }}
                        else if(arrnew[k].charAt(s)=='0') {
                            term+=0;

                        }
                        else if(arrnew[k].charAt(s)=='1' ) {
                            String array[] = new String[1];
                            array[0] = "0001";
                            if (s == 0) {
                                for (o = nter; o <= nter-2; nter--) {//
                                    term += 0 * Math.pow(2, o);}

                                term += 1*Math.pow(2, nter-3);}


                            else if (s == 1) {
                                term +=  1 * Math.pow(2, iter-3);
                            }}
                        else if(arrnew[k].charAt(s)=='3' ) {
                            String array[] = new String[1];
                            array[0] = "0011";
                            if (s == 0) {
                                for (o = nter; o <= nter -1; nter--) {//
                                    term += 0 * Math.pow(2, o);}
                                term += 1*Math.pow(2, nter-2);
                                term += 1*Math.pow(2, nter-3);}


                            else if (s == 1) {
                                term += 0 * Math.pow(2, iter) + 1 * Math.pow(2, iter-2) + 1 * Math.pow(2, iter-3);
                            }}

                        else if(arrnew[k].charAt(s)=='4' ) {
                            String array[] = new String[1];
                            array[0] = "0100";
                            if (s == 0) {
                                term += 0 * Math.pow(2, nter) ;
                                term += 1*Math.pow(2, nter-1);
                                term += 0*Math.pow(2, nter-2) +  0 * Math.pow(2, nter-3);}
                            else if (s == 1) {
                                term += 0 * Math.pow(2, iter) + 1 * Math.pow(2, iter-1);
                            }

                        }
                        else if(arrnew[k].charAt(s)=='7' ) {
                            String array[] = new String[1];
                            array[0] = "0111";
                            if (s == 0) {
                                for (o = nter-3; o <= nter-1; nter++) {//
                                    term += 1 * Math.pow(2, o);}

                            }


                            else if (s == 1) {
                                term +=  1 * Math.pow(2, iter-3) +1 * Math.pow(2, iter-2) + 1 * Math.pow(2, iter-1) ;
                            }}
                        else if(arrnew[k].charAt(s)=='8' ) {
                            String array[] = new String[1];
                            array[0] = "1000";
                            if (s == 0) {
                                for (o = nter-1; o <= nter-3; nter--) {//
                                    term += 0;}
                                term +=  1 * Math.pow(2, nter);

                            }


                            else if (s == 1) {
                                term +=  1 * Math.pow(2, iter) ;
                            }}
                        else if(arrnew[k].charAt(s)=='9' ) {
                            String array[] = new String[1];
                            array[0] = "1001";
                            if (s == 0 && k == 0) {
                                term += -1 * Math.pow(2, nter);

                                for (o = nter - 1; o <= nter - 2; nter--) {//
                                    term += 0 * Math.pow(2, o);
                                }
                                term += 1 * Math.pow(2, nter-3);}
                            if (s == 0 && k != 0) {

                                term += 1 * Math.pow(2, nter) + 1 * Math.pow(2, nter-3);


                            } else if (s == 1) {
                                term += 1 * Math.pow(2, iter) + 1 * Math.pow(2, iter-3);
                            }

                        }



                    }
                }
                System.out.println("   " + term);
        }else if(datatype.equals("Unsigned integer")){

             converttoUnsignedinteger(arrnew);
            }
            else if (datatype.equals("Floating point")){

            }}
        else if (ordering.equals("Big Endian")){



            if (datatype.equals("Signed integer")) {


                for (k = 0; k < arrnew.length; k++) {
                    for (int s = 0; s < 2; s++) {

                        if (arrnew[k].charAt(s) == 'f' || arrnew[k].charAt(s) == 'F') {
                            String array[] = new String[1];
                            array[0] = "1111";
                            if (s == 0 && k == 0) {
                                term += -1 * Math.pow(2, nter);

                                for (o = nter - 1; o <= nter - 3; nter--) {//
                                    term += 1 * Math.pow(2, o);
                                }
                                if (s == 0 && k != 0) {
                                    for (o = nter; o <= nter - 3; nter--) {
                                        term += 1 * Math.pow(2, o);

                                    }
                                } else if (s == 1) {
                                    for (o = iter; o <= iter - 3; iter--) {
                                        term += 1 * Math.pow(2, o);
                                    }
                                }

                            }
                        }//end of F
                        else if(arrnew[k].charAt(s)=='e' ) {
                            String array[] = new String[1];
                            array[0] = "1110";
                            if (s == 0) {
                                for (o = nter; o <= nter-2; nter--) {//
                                    term +=  1 * Math.pow(2, o);}

                            }}
                        else if(arrnew[k].charAt(s)=='0') {
                            term+=0;

                        }
                        else if(arrnew[k].charAt(s)=='1' ) {
                            String array[] = new String[1];
                            array[0] = "0001";
                            if (s == 0) {
                                for (o = nter; o <= nter-2; nter--) {//
                                    term += 0 * Math.pow(2, o);}

                                term += 1*Math.pow(2, nter-3);}


                            else if (s == 1) {
                                term +=  1 * Math.pow(2, iter-3);
                            }}
                        else if(arrnew[k].charAt(s)=='3' ) {
                            String array[] = new String[1];
                            array[0] = "0011";
                            if (s == 0) {
                                for (o = nter; o <= nter -1; nter--) {//
                                    term += 0 * Math.pow(2, o);}
                                term += 1*Math.pow(2, nter-2);
                                term += 1*Math.pow(2, nter-3);}


                            else if (s == 1) {
                                term += 0 * Math.pow(2, iter) + 1 * Math.pow(2, iter-2) + 1 * Math.pow(2, iter-3);
                            }}

                        else if(arrnew[k].charAt(s)=='4' ) {
                            String array[] = new String[1];
                            array[0] = "0100";
                            if (s == 0) {
                                term += 0 * Math.pow(2, nter) ;
                                    term += 1*Math.pow(2, nter-1);
                                term += 0*Math.pow(2, nter-2) +  0 * Math.pow(2, nter-3);}
                            else if (s == 1) {
                                term += 0 * Math.pow(2, iter) + 1 * Math.pow(2, iter-1);
                            }

                        }
                        else if(arrnew[k].charAt(s)=='7' ) {
                            String array[] = new String[1];
                            array[0] = "0111";
                            if (s == 0) {
                                for (o = nter-3; o <= nter-1; nter++) {//
                                    term += 1 * Math.pow(2, o);}

                            }


                            else if (s == 1) {
                                term +=  1 * Math.pow(2, iter-3) +1 * Math.pow(2, iter-2) + 1 * Math.pow(2, iter-1) ;
                            }}
                        else if(arrnew[k].charAt(s)=='8' ) {
                            String array[] = new String[1];
                            array[0] = "1000";
                            if (s == 0) {
                                for (o = nter-1; o <= nter-3; nter--) {//
                                    term += 0;}
                                term +=  1 * Math.pow(2, nter);

                            }


                            else if (s == 1) {
                                term +=  1 * Math.pow(2, iter) ;
                            }}
                        else if(arrnew[k].charAt(s)=='9' ) {
                            String array[] = new String[1];
                            array[0] = "1001";
                            if (s == 0 && k == 0) {
                                term += -1 * Math.pow(2, nter);

                                for (o = nter - 1; o <= nter - 2; nter--) {//
                                    term += 0 * Math.pow(2, o);
                                }
                                term += 1 * Math.pow(2, nter-3);}
                            if (s == 0 && k != 0) {

                                term += 1 * Math.pow(2, nter) + 1 * Math.pow(2, nter-3);


                            } else if (s == 1) {
                                term += 1 * Math.pow(2, iter) + 1 * Math.pow(2, iter-3);
                            }

                        }



        }
    }

                System.out.println("   " + term);
            }
            else if(datatype.equals("Unsigned integer")){
                converttoUnsignedinteger(arrnew);
            }
            else if (datatype.equals("Floating point")){

            }

        }}}

    public static void converttoUnsignedinteger(String [] taken){
String digits = "0123456789ABCDEF";
        for(int kn=0; kn<taken.length; kn++){
taken[kn] = taken[kn].toUpperCase();}
int value = 0;
for(int x=0; x<taken.length; x++){
    for(int l=0; l<taken.length; l++){
    char c = taken[x].charAt(x);
    int b = digits.indexOf(c);
    value = 16 * value + b;}
    System.out.println(value);

}
    }


}
