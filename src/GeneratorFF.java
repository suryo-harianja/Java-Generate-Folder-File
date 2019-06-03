import java.io.*;

public class GeneratorFF {
	public static void generateFolder(String cwd, String i) {

		boolean genDirStatus = false;
		
		File genDir = new File(cwd + "\\" + i);
		System.out.println("Current working directory : " + genDir);
		
		try {
			if(genDir.exists() && genDir.isDirectory())
				genDirStatus = true;
			else
				genDirStatus = genDir.mkdir();
		} catch  (SecurityException Se) {
			System.out.println("Error Saat Membuat Folder genDir" + Se);
		}
		
		if (genDirStatus) {
			generateFile(cwd, i);
		} else {
			System.out.println("Folder Tidak Berhasil Dibuat");
		}
	}
	
	public static void generateFile(String cwd, String i) {
		boolean genFileStatus = false;
		File genFile = new File(cwd + "\\" + i + "\\"+ i +".txt");
		try {
			if (genFile.exists() && !genFile.isDirectory())
				genFileStatus = true;
			else
				genFileStatus = genFile.createNewFile();
		} catch (IOException ioe) {
			System.out.println("Error Membuat File Baru " + ioe);
		}
		
		if(genFileStatus)
			System.out.println("File Baru Dibuat Di " + genFile.getPath());
		else
			System.out.println("Gagal Membuat File");
	}
	
	public static void main(String[] args) {
		String cwd = System.getProperty("user.dir");
		String[] arr = {"Bajigur", "Timus", "Naga Sakti"};
		for(int i=0; i<=arr.length - 1; i++) {
			System.out.println(i);
			generateFolder(cwd, arr[i]);
		}
		
	}
}
