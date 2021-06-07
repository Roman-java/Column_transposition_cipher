import java.util.Arrays;

public class main {
	public static void main(String[] args) {
	
	StringBuilder enc_srt = new StringBuilder();
	StringBuilder dec_srt = new StringBuilder();
	
	String FIO = "Ponomarenko Roman Ruslanovuch";
	char[] FIO_Arr = FIO.replaceAll(" ", "").toCharArray();
	
	System.out.println("Оригіналний текст:");
	System.out.println(FIO);
	
	String keyword = "alchemist";
	char[] keyword_Arr = keyword.toCharArray();
	
	int[] number = new int[keyword.length()];
	
	char[] sort_keyword_Arr = Arrays.copyOf(keyword_Arr, keyword_Arr.length);
	Arrays.sort(sort_keyword_Arr);
	System.out.println("\nКлючове слово:");
	System.out.println(keyword_Arr);
	System.out.println("\nВідсортоване по алфаівту ключове слово:");
	System.out.println(sort_keyword_Arr);
	
	int k = 0;
	for(int j = 0; j < sort_keyword_Arr.length; j++)
		for(int i = 0; i < sort_keyword_Arr.length; i++)
			if(sort_keyword_Arr[j] == keyword_Arr[i]) {
				number[k] = i;
				k++;
			}
	for(int i = 0; i < sort_keyword_Arr.length; i++)
		System.out.print(number[i]);
	
	char[][] matr = new char[FIO_Arr.length / keyword.length()][keyword.length()];
	System.out.println("\n\nМатриця:");
	
	k = 0;
	for(int i = 0; i < FIO_Arr.length / keyword.length(); i++) {//3
		for(int j = 0; j < keyword.length(); j++) {//9
			matr[i][j] = FIO_Arr[j + k];
			System.out.print(matr[i][j]);
		}
		k += 9;
		System.out.println();
	}
	
	System.out.println("\nМатриця зі здвигом:");
	
	for(int i = 0; i < FIO_Arr.length / keyword.length(); i++) {//3
		for(int j = 0; j < keyword.length(); j++)//9
			System.out.print(matr[i][number[j]]);
		System.out.println();
	}
	
	char[][] matr_transp = new char[keyword.length()][FIO_Arr.length / keyword.length()];
	System.out.println("\nТранспонована матриця зі здвигом:");
	
	for (int i = 0; i < FIO_Arr.length / keyword.length(); i++)//3
        for (int j = 0; j < keyword.length(); j++)//9
        	matr_transp[j][i] = matr[i][number[j]];
	
	for(int i = 0; i < keyword.length(); i++) {//9
		for(int j = 0; j < FIO_Arr.length / keyword.length(); j++)//3
			System.out.print(matr_transp[i][j]);
		System.out.println();
	}
	
	System.out.println("\nЗашифрований текст:");
	
	for(int i = 0; i < keyword.length(); i++) {//9
		for(int j = 0; j < FIO_Arr.length / keyword.length(); j++)//3
			enc_srt.append(matr_transp[i][j]);
	}
	
	System.out.println(enc_srt);
	
	char[] enc_srt_Arr = enc_srt.toString().replaceAll(" ", "").toCharArray();
	System.out.println("\nМатриця закодованого тексту:");
	char[][] enc_matr = new char[keyword.length()][enc_srt_Arr.length / keyword.length()];
	
	k = 0;
	for(int i = 0; i < keyword.length(); i++) {//9
		for(int j = 0; j < enc_srt_Arr.length / keyword.length(); j++) {//3
			enc_matr[i][j] = enc_srt_Arr[j + k];
			System.out.print(enc_matr[i][j]);
		}
		k += 3;
		System.out.println();
	}
	
	System.out.println("\nМатриця закодованого тексту в транспонованому вигляді:");
	char[][] enc_matr_transp = new char[enc_srt_Arr.length / keyword.length()][keyword.length()];
	
	for (int i = 0; i < keyword.length(); i++)//9
        for (int j = 0; j < enc_srt_Arr.length / keyword.length(); j++)//3
        	enc_matr_transp[j][i] = enc_matr[i][j];
	
	for(int i = 0; i < enc_srt_Arr.length / keyword.length(); i++) {//3
		for(int j = 0; j < keyword.length(); j++)//9
			System.out.print(enc_matr_transp[i][j]);
		System.out.println();
	}
	
	System.out.println("\nМатриця розкодованого тексту:");
	char[][] dec_matr = new char[enc_srt_Arr.length / keyword.length()][keyword.length()];
	
	for(int i = 0; i < enc_srt_Arr.length / keyword.length(); i++)//3
		for(int j = 0; j < keyword.length(); j++)//9
			dec_matr[i][number[j]] = enc_matr_transp[i][j];
	
	for(int i = 0; i < enc_srt_Arr.length / keyword.length(); i++) {//3
		for(int j = 0; j < keyword.length(); j++) {//9
			System.out.print(dec_matr[i][j]);
			if((Character.isUpperCase(dec_matr[i][j])) && (i!=0))
				dec_srt.append(" ");
			dec_srt.append(dec_matr[i][j]);
		}
		System.out.println();
	}
	
	System.out.println("\nРозкодований текст:");
	System.out.println(dec_srt);
	
	}
}
/* for example:
Ponomarenko Roman Ruslanovuch
11 + 5 + 11 = 27
3 x 9
*/