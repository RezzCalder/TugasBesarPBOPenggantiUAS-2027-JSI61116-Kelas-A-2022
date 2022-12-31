import java.sql.*;
import java.util.Scanner;

// Class
public class Tampilan {
	// Scanner
	Scanner terimaInput = new Scanner (System.in);
	
	// Pengolahan Database (CRUD)
	static Connection conn;
	String url = "jdbc:mysql://localhost:3306/db_topup";
	
	public void tampilData() throws SQLException{
		// Pengolahan Database (CRUD)
		String sql ="SELECT * FROM data_topup";
		conn = DriverManager.getConnection(url,"root","");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		// Pengulangan
		while(result.next()){
			System.out.print("\nID Pelanggan\t: ");
            System.out.print(result.getInt("id_pelanggan"));
            System.out.print("\nNama Pelanggan\t: ");
            System.out.print(result.getString("nama_pelanggan"));
            System.out.print("\nTotal DIamond\t: ");
            System.out.print(result.getString("total_diamond"));
            System.out.print("\nHarga Total Diamond\t: ");
            System.out.print(result.getString("harga_total_diamond"));
            System.out.print("\nPPN\t: ");
            System.out.print(result.getString("ppn"));
            System.out.print("\nTotal Harga\t: ");
            System.out.print(result.getString("total_harga"));
            System.out.print("\n");
		}
	}
	
	public void tampilCariData() throws SQLException{
		System.out.print("Masukkan Nama Pelanggan : ");    
		String keyword = terimaInput.nextLine();
		
		// Pengolahan Database (CRUD)
		String sql = "SELECT * FROM data_topup WHERE nama_pelanggan LIKE '%"+keyword+"%'";
		conn = DriverManager.getConnection(url,"root","");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		// Pengulangan
		while(result.next()){
			System.out.print("\nID Pelanggan\t: ");
            System.out.print(result.getInt("id_pelanggan"));
            System.out.print("\nNama Pelanggan\t: ");
            System.out.print(result.getString("nama_pelanggan"));
            System.out.print("\nTotal DIamond\t: ");
            System.out.print(result.getString("total_diamond"));
            System.out.print("\nHarga Total Diamond\t: ");
            System.out.print(result.getString("harga_total_diamond"));
            System.out.print("\nPPN\t: ");
            System.out.print(result.getString("ppn"));
            System.out.print("\nTotal Harga\t: ");
            System.out.print(result.getString("total_harga"));
            System.out.print("\n");
		}
	}
}
