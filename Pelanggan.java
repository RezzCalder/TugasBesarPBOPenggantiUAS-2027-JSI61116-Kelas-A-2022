import java.util.InputMismatchException;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

// Class (Inheritance dan Interface)
public class Pelanggan extends Tampilan implements Penilaian{
	static Connection conn;
	// Pengolahan Database (CRUD)
	String url = "jdbc:mysql://localhost:3306/db_topup";
	
	public int idPelanggan = 0;
    public String namaPelanggan;
    public int totalDiamond = 0;
    public int hargaTotalDiamond = 0;
    public int ppn = 0;
    public int totalHarga = 0;

    Scanner terimaInput = new Scanner (System.in);

    public void lihatData() throws SQLException {
		String text1 = "\n===Daftar Seluruh Data TopUp===";
		// Method String
		System.out.println(text1.toUpperCase());	
		// Inheritance (class Tampilan)
		tampilData();
	}
    
    public void tambahData() throws SQLException {
    	String text2 = "\n===Tambah Data TopUp===";
    	// Method String
		System.out.println(text2.toUpperCase());
		
    	try {
	        // ID Pelanggan
	    	System.out.print("Masukkan ID Pelanggan: ");
	        idPelanggan = terimaInput.nextInt();
	        terimaInput.nextLine();
	
	        // Nama Pelanggan
	        System.out.print("Masukkan Nama Pelanggan: ");
	        namaPelanggan = terimaInput.nextLine(); 
	
	        System.out.print("\n ID dan Nama Pelanggan: ");
	        System.out.println( idPelanggan +" ("+ namaPelanggan +")");
	        
	        // Total Diamond
	    	System.out.print("\nMasukkan Total Diamond: ");
	        totalDiamond = terimaInput.nextInt();
	        terimaInput.nextLine();

            // hargaTotalDiamond
            hargaTotalDiamond = (1500 * totalDiamond);
            System.out.println("\n Harga Total Diamond: " +hargaTotalDiamond); 

            // PPN
            ppn = 10000;
            System.out.println("\n PPN: " +ppn);
	        
	        // Total Harga
            totalHarga = (hargaTotalDiamond + ppn);
            System.out.println("\nTotal Harga: " + totalHarga);
	        
	        // Pengolahan Database (CRUD)
	        String sql = "INSERT INTO data_topup (id_pelanggan, nama_pelanggan, total_diamond, harga_total_diamond, ppn, total_harga) VALUES ('"+idPelanggan+"','"+namaPelanggan+"','"+totalDiamond+"','"+hargaTotalDiamond+"','"+ppn+"','"+totalHarga+"')";
	        conn = DriverManager.getConnection(url,"root","");
	        Statement statement = conn.createStatement();
	        statement.execute(sql);
	        System.out.println("Berhasil input data");
    	}
    	catch (SQLException e) {
	        System.err.println("Terjadi kesalahan input data");
	    } 
    	catch (InputMismatchException e) {
	    	System.err.println("Inputlah dengan angka saja");
	   	}
	} 
	public void ubahData() throws SQLException{
		String text3 = "\n===Ubah Data TopUp===";
		// Method String
		System.out.println(text3.toUpperCase());
		
		try {
            lihatData();
            System.out.print("\nMasukkan ID Pelanggan yang akan di ubah atau update : ");
            Integer idPelanggan = Integer.parseInt(terimaInput.nextLine());
            
            // Pengolahan Database (CRUD)
            String sql = "SELECT * FROM data_topup WHERE id_pelanggan = " +idPelanggan;
            conn = DriverManager.getConnection(url,"root","");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Nama baru ["+result.getString("nama_pelanggan")+"]\t: ");
                String namaPelanggan = terimaInput.nextLine();
                   
                // Pengolahan Database (CRUD)
                sql = "UPDATE data_topup SET nama_pelanggan='"+namaPelanggan+"' WHERE id_pelanggan='"+idPelanggan+"'";

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data topup (ID: "+idPelanggan+")");
                }
            }
            statement.close();        
        } 
		catch (SQLException e) {
        	System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
	}
	
	public void hapusData() {
		String text4 = "\n===Hapus Data TopUP===";
		// Method String
		System.out.println(text4.toUpperCase());
		
		try{
	        lihatData();
	        System.out.print("\nKetik ID Pelanggan yang akan dihapus : ");
	        Integer idPelanggan = Integer.parseInt(terimaInput.nextLine());
	        
	        // Pengolahan Database (CRUD)
	        String sql = "DELETE FROM data_topup WHERE id_pelanggan = "+ idPelanggan;
	        conn = DriverManager.getConnection(url,"root","");
	        Statement statement = conn.createStatement();
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Berhasil menghapus data topup (ID: "+idPelanggan+")");
	        }
	   }
		catch(SQLException e){
	        System.out.println("Terjadi kesalahan dalam menghapus data");
	    }
	}
	
	public void cariData () throws SQLException {
		String text5 = "\n===Cari Data TopUp===";
		// Method String
		System.out.println(text5.toUpperCase());
				
		// Inheritance (class Tampilan)
		tampilCariData();
	}
}