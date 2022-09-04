package chassier;

import java.util.Scanner;
import java.io.*;

public class Chassier {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * menu :
		 * 1. jaket varsity - Rp. 400.000
		 * 2. kemeja lengan panjang - Rp. 300.000
		 * 3. kemeja lengan pendek - Rp. 275.000
		 * 4. jaket bomber - Rp. 450.000
		 * 
		 * must be included :
		 * - file text
		 * - string formatting (System.out.printf()
		 * - `random` method
		 * - Scanner input
		 */
		int[] harga = {400, 300, 275, 450};
		String[] barang = {"jaket varsity", "kemeja lengan panjang", "kemeja lengan pendek", "jaket bomber"};
		
		Scanner input = new Scanner(System.in);
		/** menampilkan menu */
		System.out.printf("%55s" , "--- Selamat datang di Toko Baju XYZ --- \n\n");
		System.out.printf("%30s" ,"Barang");
		System.out.printf("%15s" ,"Harga\n");
		System.out.printf("%30s","------");
		System.out.printf("%15s","------\n");
		System.out.printf("%30s","1. Jaket varsity");
		System.out.printf("%15s", "Rp. 400.000\n");
		System.out.printf("%30s","2. Kemeja Lengan Panjang");
		System.out.printf("%15s", "Rp. 300.000\n");
		System.out.printf("%30s","3. Kemeja Lengan Pendek");
		System.out.printf("%15s", "Rp. 275.000\n");
		System.out.printf("%30s","4. Kemeja Lengan Panjang");
		System.out.printf("%15s", "Rp. 450.000\n");
		
		/** olah data */
		System.out.println("");
		System.out.print("Siapa nama anda : ");
		String nama = input.nextLine();
		System.out.print("berapa banyak barang yang ingin anda pesan ? ");
		int jumlah = input.nextInt();
		input.nextLine();
		int[] belanjaan = new int[jumlah];
		
		for (int i = 0; i < jumlah; i++) {
			System.out.print("barang ke-" + i+1 + " (tulis nomornya) : ");
			belanjaan[i] = input.nextInt();
			input.nextLine();
		}
		
		int total = 0;
		
		for (int i = 0; i < jumlah; i++) {
			total = total + harga[belanjaan[i]-1];
		}
		
		/**
		 * proses menginput data ke file text.
		 * */
		// membuat file filehistory agar bisa men-cek apakah file tersebut sudah ada di current directory
		File fileHistory = new File("history.txt");
		// membuat instance dari class filewriter agar bisa menambahkan isi kepada file jika file tersebut sudah ada
		FileWriter history;
		if(fileHistory.exists()) {
			/** append isi file */
			history = new FileWriter(fileHistory, true);
		}
		else {
			history = new FileWriter(fileHistory, false);
		}
		//membuat instance dari PrintWriter agar bisa menulis isi ke file
		PrintWriter buyingHistory = new PrintWriter(history);
		buyingHistory.println(nama);
		for (int i = 0; i < jumlah; i++) {
			buyingHistory.println(belanjaan[i]);
		}
		
		buyingHistory.close();
		history.close();
		
		System.out.println("");
		System.out.printf("Nama : %s \n", nama);
		System.out.println("barang belanjaan : \n");
		System.out.printf("%-3s %-25s %-10s\n", "No.", "Barang", "Harga");
		for (int i = 0; i < jumlah; i++) {
			System.out.printf("%-3d %-25s %-10d\n", i, barang[belanjaan[i]-1], harga[belanjaan[i]-1]*1000);
		}
		
		
		input.close();
	}

}
