import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Program {
    static Connection conn;
    public static void main(String[] args) throws Exception {
        //Pemanggilan Constructor
        Programmer rezky = new Programmer();
        System.out.println("Nama programmer\t: " + rezky.namaProgrammer);
        System.out.println("NIM programmer\t: " + rezky.nimProgrammer);
        System.out.println("Tugas\t\t: " + rezky.tugas);
        System.out.println("Kelas\t\t: " + rezky.kelas);

        // Collection Framework (LinkedList)
        LinkedList<String> List = new LinkedList<String>();
        List.add("Teknologi Informasi");
        List.add("Sistem Informasi");
        System.out.println("\nFakultas dan Jurusan : " + List);

        Scanner terimaInput = new Scanner (System.in);
    	String pilihanUser;
    	boolean isLanjutkan = true;
    	
    	// Pengolahan Database (CRUD)
    	String url = "jdbc:mysql://localhost:3306/db_topup";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","");
			System.out.println("\nClass Driver ditemukan");
			Pelanggan pelanggan = new Pelanggan();
			
			// Label keluar
			keluar:
			// Perulangan
			while (isLanjutkan) {
				System.out.println("------------------------");
				System.out.println("Database Data TopUp");
				System.out.println("------------------------");
				System.out.println("1. Lihat Data TopUp");
				System.out.println("2. Tambah Data TopUp");
				System.out.println("3. Ubah Data TopUp");
				System.out.println("4. Hapus Data TopUp");
				System.out.println("5. Cari Data TopUp");
				System.out.println("6. Keluar Program");
				
				System.out.print("\nNomor Pilihan (1/2/3/4/5/6): ");
				pilihanUser = terimaInput.next();
				
				// Percabangan
				switch (pilihanUser) {
				case "1":
					pelanggan.lihatData();
					break;
				case "2":
                    pelanggan.tambahData();
					break;
				case "3":
                    pelanggan.ubahData();
					break;
				case "4":
                    pelanggan.hapusData();
					break;
				case "5":
                    pelanggan.cariData();
					break;
				case "6":
					// Pergi ke label keluar
					break keluar;
				default:
					System.err.println("\nInput anda tidak ditemukan\nSilakan pilih lagi dari [1-6]");
				}
				
				System.out.print("\nApakah Anda ingin melanjutkan [y/n]? ");
				pilihanUser = terimaInput.next();
				isLanjutkan = pilihanUser.equalsIgnoreCase("y");

			}
			// Method Date
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("E yyy.MM.dd 'pada' hh:mm:ss a zzz");
            System.out.println("Tanggal dan Waktu saat ini: " + format.format(date)); 
			System.out.println("Program selesai...");
			
		}
		// Exception
		catch(ClassNotFoundException ex) {
			System.err.println("Driver Error");
			System.exit(0);
		}
		// Exception
		catch(SQLException e){
			System.err.println("Tidak berhasil koneksi");
		}
    }
}
