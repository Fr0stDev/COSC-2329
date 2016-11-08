import java.util.Arrays;
import java.util.List;

public interface VignereCipher_gmoran {
	public final static List<Character> ENGLISH_LOWERCASE_LETTERS_LIST = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
	public final static List<Character> ENGLISH_UPPERCASE_LETTERS_LIST = Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
	
	/*
	 * PRE CONDITIONS:
	 * 
	 * plainMessage[i] != null, for i in [0, plainMessage.length)
	 * plainMessage[i].charAt(j) is in {'a', 'b', 'c', ..., 'z'}, for i in [0, plainMessage.length) and j in [0, plainMessage[i].length())
	 * 
	 * key != null
	 * key.length() > 0
	 * 
	 * POST CONDITIONS:
	 * rv.charAt(j) is in {'a', 'b', 'c', ..., 'z'} U {' '}, for j in [0, rv.length())
	 */
	
	public static String encrypt(String[] plainMessage, String key) {
		
		if (key == null || key.length() == 0) {
			throw new RuntimeException("Invalid encryption key.");
			
		}
		if (plainMessage == null || plainMessage.length == 0) {
			throw new RuntimeException("Invalid String array.");
		}
		
		String stringToEncrypt = "";
		
		for (String item: plainMessage) {
			
			stringToEncrypt += item + " ";
		}
		
		//System.out.println(stringToEncrypt);
	
		String encryptedString = encrypt(stringToEncrypt, key); //Remove ending space, and encrypt
		return encryptedString.trim(); //Trim end space
		
	}
	
	public static String encrypt(String plainText, String key) {
		
		if (key == null || key.length() == 0) {
			throw new RuntimeException("Invalid encryption key.");
			
		}
		if (plainText == null || plainText.length() == 0 || plainText.equals("")) {
			throw new RuntimeException("Invalid String array.");
		}
		
		char[] keyCharArray = key.toCharArray();
		int keyLen = key.length() - 1; //0-based index
		int keyIndex = 0;
		
		String retValue = "";
		
		for (char letter: plainText.toCharArray()) {
			
			if (keyIndex > keyLen) {
				keyIndex = 0; //loops the key if it happens to be shorter than the plainText
			}
			
			//Ignore Spaces
			if (letter != ' ') {
				
				retValue += getMatrixEntry(letter, keyCharArray[keyIndex]);
				keyIndex++;
			}
			else {
				retValue += " ";
			}
			
		}
		return retValue;
	}
	
	/*
	 * PRE CONDITIONS:
	 * 
	 * encryptedMessage[i] != null, for i in [0, encryptedMessage.length)
	 * encryptedMessage[i].charAt(j) is in {'A', 'B', 'C', ..., 'Z'}, for i in [0, encryptedMessage.length()) and j in [0, encryptedMessage.length())
	 * key != null
	 * key.length > 0
	 * 
	 * POST CONDITION:
	 * 
	 * rv.charAt(j) is in {'A', 'B', 'C', ..., 'Z'} U {' '}, for j in [0, rv.length())
	 * Need to express exactly where spaces are in rv
	 */
	
	public static String decrypt(String[] encryptedMessage, String key) {
		
		if (key == null || key.length() == 0) {
			throw new RuntimeException("Invalid encryption key.");
			
		}
		if (encryptedMessage == null || encryptedMessage.length == 0) {
			throw new RuntimeException("Invalid String array.");
		}
		
		String stringToDecrypt = "";
		
		for (String item: encryptedMessage) {
			stringToDecrypt += item + " ";
		}
		
		//System.out.println(stringToDecrypt);
	
		String encryptedString = decrypt(stringToDecrypt, key); //Remove ending space, and encrypt
		return encryptedString.trim(); //Strip end space
	}
	
	public static String decrypt(String encryptedText, String key) {
		
		if (key == null || key.length() == 0) {
			throw new RuntimeException("Invalid encryption key.");
			
		}
		if (encryptedText == null || encryptedText.length() == 0 || encryptedText.equals("")) {
			throw new RuntimeException("Invalid String array.");
		}
		
		char[] keyCharArray = key.toCharArray();
		int keyLen = key.length() - 1; //0-based index
		int keyIndex = 0;
		
		String retValue = "";
		
		for (char letter: encryptedText.toCharArray()) {
			
			if (keyIndex > keyLen) {
				keyIndex = 0; //loops the key if it happens to be shorter than the plainText
			}
			
			//Ignore Spaces
			if (letter != ' ') {
				retValue += getColumn(keyCharArray[keyIndex],letter);
				keyIndex++;
			}
			else {
				retValue += " ";
			}
			
		}
		return retValue;
		
	}
	
	/*
	 * PRE CONDITION:
	 * 
	 * row 	  is in {'a', 'b', 'c', ..., 'z'}
	 * column is in {'a', 'b', 'c', ..., 'z'}
	 * 
	 * POST CONDITION:
	 * 
	 * RV     is in {'A', 'B', 'C', ..., 'Z'}
	 * 
	 */
	
	public static char getMatrixEntry(char row, char column) {
		
		// Check if row/column are in ENGLISH_LOWERCASE_LETTERS_LIST
		
		if (!ENGLISH_LOWERCASE_LETTERS_LIST.contains(row)) {
			throw new RuntimeException("Invalid Character: " + row);
		}
		
		if (!ENGLISH_LOWERCASE_LETTERS_LIST.contains(column)) {
			throw new RuntimeException("Invalid Character: " + column);
		}
		
		// Proceed if ENGLISH_LOWERCASE_LETTERS_LIST contains row/column
		
		int rowInt = ENGLISH_LOWERCASE_LETTERS_LIST.indexOf(row);
		int colInt = ENGLISH_LOWERCASE_LETTERS_LIST.indexOf(column);
		
		int result = (rowInt + colInt);
		//System.out.println(result);
		
		// If the result > 26, subtract 26 to an actual index value from the matrix
		if (result >= 26) { 
			result = result - 26;
		}
		
		char matrixEntry = ENGLISH_UPPERCASE_LETTERS_LIST.get(result);
		
		//return 'a';
		return matrixEntry;
	}
	
	public static char getColumn(char row, char matrixEntry) {
		
		// Check if row/column are in ENGLISH_UPPERCASE_LETTERS_LIST
		
		if (!ENGLISH_LOWERCASE_LETTERS_LIST.contains(row)) {
			throw new RuntimeException("Invalid Character: " + row);
		}
				
		if (!ENGLISH_UPPERCASE_LETTERS_LIST.contains(matrixEntry)) {
			throw new RuntimeException("Invalid Character: " + matrixEntry);
		}
				
		// Proceed if ENGLISH_UPPERCASE_LETTERS_LIST matrixEntry
		// and ENGLISH_LOWERCASE_LETTERS_LIST contains row
		
		int rowInt = ENGLISH_LOWERCASE_LETTERS_LIST.indexOf(row);
		int matrixInt = ENGLISH_UPPERCASE_LETTERS_LIST.indexOf(matrixEntry);
		
		//System.out.println(rowInt);
		//System.out.println(matrixInt);
		
		/*
		 * matrixInt - rowInt = result
		 * where result = the column 
		 * 
		 * if matrixInt is less than rowInt, 
		 * increment rowInt by 26 to return a positive number
		 * the positive number returned should be the index of the column in {'A','B','C', ..., 'Z'}
		 */
		
		if (matrixInt < rowInt) {
			matrixInt = matrixInt + 26; 
		}
		
		int result = matrixInt - rowInt;
		//System.out.println(result);
		
		char columnValue = ENGLISH_LOWERCASE_LETTERS_LIST.get(result);
		
		return columnValue;
	}
	
	public static void main(String[] args) {
		String k = decrypt("KQFNJZYKWJ QPMLJD UKI XAEGD AAF DUA", "fish");
		System.out.println(k);
		
	}
	
}
