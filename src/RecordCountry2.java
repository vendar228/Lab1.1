import java.util.Scanner;

class Strana1 {
    String name;
    double square;
}

public class RecordCountry2 {
    public static Strana1[] setCountryArr(int k){
        Scanner sc = new Scanner(System.in, "cp1251");
        Strana1 country[] = new Strana1[k];

        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            country[i] = new Strana1();
            System.out.print("Название " + (i + 1) + "-й страны => ");

            country[i].name=sc.nextLine();
            System.out.print("Площадь "+(i+1)+"-й страны => ");

            country[i].square=sc.nextDouble();
            sc.nextLine();
        }

        return country;
    }
    public static void showArray(Strana1 [] cntr){
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + " \t" + cntr[i].square + " млн кв. км");
        }
    }
    public static void showCountry(Strana1 cntr){
        System.out.println(""+cntr.name+"\t"+cntr.square+" млн кв. км"); }
    public static int NomMax(Strana1 []st){
        int nommax=0;

        double max=st[nommax].square;
        for (int i = 0; i < st.length; i++)
            if (st[i].square>max) {
                max= st[i].square;
                nommax=i;
            }
        return nommax;
    }
    public static void sortSquare(Strana1 []cntr){
        for (int i = 0; i < cntr.length-1; i++)
            for (int j = 0; j < cntr.length-1-i; j++)
                if (cntr[j].square>cntr[j+1].square){
                    Strana1 rab=cntr[j]; // rab – рабочая переменная для перестановки
                    cntr[j]=cntr[j+1];
                    cntr[j+1]=rab;
                }
    }
    public static void sortName(Strana1 [] cntr){
        for (int i = 0; i < cntr.length-1; i++)
            for (int j = 0; j < cntr.length-i-1; j++)
                if(cntr[j].name.compareTo(cntr[i+1].name)>0){
                    Strana1 rab=cntr[j]; // rab – рабочая переменная для перестановки
                    cntr[j]=cntr[j+1];
                    cntr[j+1]=rab;
                }
    }
    public static double avgSquare( Strana1 [] cntr){
        double s=0; // суммарная площадь
        for (int i = 0; i < cntr.length; i++)
            s+=cntr[i].square;
        double sr=s/cntr.length;
        return sr;
    }
    public static Strana1 [] Bigger(Strana1 cntr[]){
        double sred=avgSquare(cntr);
        int kol=0; // количество стран
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square>sred)
                ++kol;
        }
        if (kol != 0){
            Strana1 [] bigCountry=new Strana1[kol];
            int n=-1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].square>sred) {
                    bigCountry[++n]=cntr[i];
                }
            return bigCountry;
        } else return null;
    }
    public static Strana1 findForName(Strana1 cntr[], String name){
        int n=-1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n=i;
        if (n!= -1) {
            return cntr[n];
        }else return null;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введите количество стран=> ");
        int n=sc.nextInt();
        Strana1 country[]= setCountryArr(n);
        System.out.println("\nХарактеристики стран:");
        showArray(country);
        int nommax=NomMax(country);
        System.out.println("\nСтрана с максимальной площадью:");
        showCountry(country[nommax]);
        sortSquare(country);
        System.out.println("\nОтсортированный список по площади:");
        showArray(country);
        sortName(country);
        System.out.println("\nОтсортированный список по названиям:");
        showArray(country);
        System.out.println("Средняя площадь ="+avgSquare(country));
        System.out.println("\nСтраны, с площадью больше средней");
        Strana1 [] larger=Bigger(country);
        showArray(larger);
        System.out.println("\nПОИСК СТРАНЫ \n Введите название страны => ");
        sc.nextLine();
        String sname=sc.nextLine();
        Strana1 sfind =findForName(country, sname);
        if (sfind!=null) {
            showCountry(sfind);
        } else {
            System.out.println("Такой страны нет в списке!");
        }}}