import java.util.Scanner;

class Country{
    String name;
    double square;
}
public class InfoAboutCountries {
    //Метод для вывода массива стран
    public static void printCountries(Country[]countries){
        for (int i = 0; i < countries.length; i++) {
            System.out.println("Name: " + countries[i].name + " Square: " + countries[i].square);
        }
    }
    //Метод для вывода информации о стран
    public static void printCountry(Country country){
        System.out.println("Name: " + country.name + " Square: " + country.square);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter count");
        int count = sc.nextInt();
        sc.nextLine();
        Country [] countries = new Country[count];
        for (int i = 0; i < count; i++) {
            countries[i] = new Country();
            System.out.println("Name=>");
            countries[i].name = sc.nextLine();
            System.out.println("Square=>");
            countries[i].square = sc.nextDouble();
            sc.nextLine();
        }
        /*for (int i = 0; i < count; i++ ) {
            System.out.println("Name: " + countries[i].name + "Square " + countries[i].square);
        }*/
        printCountries(countries);

        int indexMax = 0;
        double max = countries[indexMax].square;
        for (int i = 1; i < countries.length; i++) {
            if(countries[i].square>max) {
                indexMax = i;
                max = countries[indexMax].square;
            }
        }
        System.out.println("Country with max square is " + countries[indexMax].name
                + " where square is equal " +countries[indexMax].square);

        /*Сортировка по площади*/
        for (int i = 0; i < count-1; i++) {
            for (int j = 0; j < count-1-i; j++) {
                if(countries[j].square>countries[j+1].square){
                    Country temp = countries[j];
                    countries[j] = countries[j+1];
                    countries[j+1] = temp;
                }
            }
        }
        System.out.println("Sorted list (by square)");
        printCountries(countries);

        /*Сортировка по имени*/
        for (int i = 0; i < count-1; i++) {
            for (int j = 0; j < count-1-i; j++) {
                if(countries[j].name.compareTo(countries[j+1].name)>0){
                    Country temp = countries[j];
                    countries[j] = countries[j+1];
                    countries[j+1] = temp;
                }
            }
        }
        System.out.println("Sorted list (by name)");
        printCountries(countries);

        double sumSquare = 0;
        for (int i = 0; i < count; i++) {
            sumSquare += countries[i].square;
        }
        double srSquare = sumSquare/count;
        System.out.println("Средняя площадь " + srSquare);

        System.out.println("Страны с площадью больше средней");
        for (int i = 0; i <count ; i++) {
            if(countries[i].square>srSquare){
                System.out.println("Name: " + countries[i].name + "Square " + countries[i].square);
            }
        }
        //Поиск по имени и вывод страны
        System.out.println("Enter country=>");
        String countrySearch = sc.nextLine();
        int nom = -1;
        for (int i = 0; i < count; i++) {
            if(countrySearch.equalsIgnoreCase(countries[i].name)){
                nom = i;
            }
        }
        if(nom!=-1){
            printCountry(countries[nom]);
        }
        else{
            System.out.println("Nothing found!");
        }
    }
}