package lab8;

import java.sql.*;
import java.util.Scanner;

public class Main {


    public static void afisare_tablea_persoane(Connection connection, String mesaj) throws SQLException {
        String sql = "select * from persoane";
        System.out.println("\n---" + mesaj + "---");
        Statement statement = connection.createStatement();
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta=" + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adaugare_persaone(Connection connection){
        Scanner sc = new Scanner(System.in);
        String sql = "insert into persoane(nume , varsta) values (?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            System.out.println("Introduceti numele: ");
            String nume = sc.nextLine();

            System.out.println("Introduceti varsta: ");
            int varsta = sc.nextInt();

            preparedStatement.setString(1 , nume);
            preparedStatement.setInt(2,varsta);

            preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static void adaugare_excursie(Connection connection){

    }


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/lab8";

        Connection connection = DriverManager.getConnection(url, "root", "Root1234");
        Statement statement = connection.createStatement();

        while(true){
            System.out.println("Alegeti optiunea:");
            System.out.println("1.Afisare tabela");
            System.out.println("2.Adaugare persoana");
            System.out.println("3.Adaugare excursie");
            System.out.println("");
            System.out.println("");
            System.out.println("0.Iesire");

            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune){
                case 1:
                    afisare_tablea_persoane(connection , "Continut initial");
                    break;
                case 2:
                    adaugare_persaone(connection);
                    break;

                default:
                    System.out.println("Invalid!!");
            }
        }
    }
}