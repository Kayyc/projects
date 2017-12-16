package zist_kajetan_vigenerCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VigenerCipher {
	
	private String kljuc; // ključ, ki ga bo vnesel uporabnik
	final private String defaultkey= "kajetan"; //default vrednos, če uporabnik ne vnese ključa
	private String filetext;
	private String matrix;
	final private String abeceda = "ABCČDEFGHIJKLMNOPRSŠTUVZŽ";
	final private String stevila = "0123456789";

	public String getFiletext() {
		return filetext;
	}
	public void setFiletext(String filetext) {
		this.filetext = filetext;
	}
	
	public String getKljuc() {
		return kljuc;
	}
	public void setKljuc(String key) {
		this.kljuc = key;
	}
	
	public void shraniKljuc(String key) {
		if(key.equals("")) {
			key = defaultkey;
		} 
		setKljuc(key);
	}
	
	public void preberiBesedilo(String filename) throws IOException {
		StringBuilder sb = new StringBuilder();
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
			setFiletext(sb.toString().trim());
		}
		br.close();
	}
	
	public String newKey(int dolzina, String key) {
		char newKey[] = new char[dolzina];
		for(int i = 0, j = 0; i < dolzina; i++,j++){
			if(j == key.length()) {
				j = 0;	
			}			
			newKey[i] = key.charAt(j);			
		}
		return String.valueOf(newKey).toUpperCase();
	}
	
	public String sifriraj(String text, String key) {	
		String sifriranText = text;
		String newKey = newKey(sifriranText.length(), key);
		StringBuilder sb = new StringBuilder();	
		for(int i = 0; i  < sifriranText.length(); i++) {			
			if(Character.toString(sifriranText.charAt(i)).matches("[,\\s.\n\r ]")) {
				sb.append(sifriranText.charAt(i));
				continue;
			} 
			if(Character.toString(sifriranText.charAt(i)).matches("\\d")) {
				sb.append(stevila.charAt((stevila.indexOf(sifriranText.charAt(i)) + abeceda.indexOf(newKey.charAt(i)))%stevila.length()));					
			} else if (String.valueOf(sifriranText.charAt(i)).matches("\\D")) {
				if(Character.isUpperCase(sifriranText.charAt(i))) {
					sb.append(String.valueOf(abeceda.charAt((abeceda.indexOf(sifriranText.charAt(i)) + abeceda.indexOf(newKey.charAt(i)))%25)));
				} else {
					String maleCrke = abeceda.toLowerCase();
					String kljuc = newKey.toLowerCase();
					sb.append(String.valueOf(maleCrke.charAt((maleCrke.indexOf(sifriranText.charAt(i)) + maleCrke.indexOf(kljuc.charAt(i)))%25)));
				}
			}
		}
		return sb.toString();
	}

	public String desifriraj(String text, String key) {
		String sifriranText = text;
		String newKey = newKey(sifriranText.length(), key);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i  < sifriranText.length(); i++) {
			if(Character.toString(sifriranText.charAt(i)).matches("[,\\s.\r\n ]")) {
				sb.append(sifriranText.charAt(i));
				continue;
			} 
			if(Character.toString(sifriranText.charAt(i)).matches("\\d")) {
				int position = (stevila.indexOf(sifriranText.charAt(i)) - abeceda.indexOf(newKey.charAt(i))+stevila.length())%stevila.length();
				if(position < 0) {
					position = position + stevila.length();
					sb.append(position);	
				} else {
					sb.append(stevila.charAt(position));	
				}				
			} else if(Character.toString(sifriranText.charAt(i)).matches("\\D")) {				
				if(Character.isUpperCase(sifriranText.charAt(i))) {
					sb.append(String.valueOf(abeceda.charAt((abeceda.indexOf(sifriranText.charAt(i)) - abeceda.indexOf(newKey.charAt(i))+abeceda.length())%abeceda.length())));	
				} else {
					String maleCrke = abeceda.toLowerCase();
					String kljuc = newKey.toLowerCase();
					sb.append(String.valueOf(maleCrke.charAt((maleCrke.indexOf(sifriranText.charAt(i)) - maleCrke.indexOf(kljuc.charAt(i))+abeceda.length())%abeceda.length())));	
				}
			}
		}	
		return sb.toString();
	}

}