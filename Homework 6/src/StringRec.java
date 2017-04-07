
public class StringRec {
	
	public static String decompress(String compressedText){
		
	    String temp;
	    
	    if(compressedText.length() == 1){
	        return compressedText;       
	    }else if(compressedText.charAt(0) == '0' && compressedText.length() != 2){
	        return decompress(compressedText.substring(2));
	    }else if(compressedText.charAt(0) == '0' && compressedText.length() == 2){
	        return "";
	    }else if(Character.isDigit(compressedText.charAt(0)) == true){
	        int i = Integer.parseInt(compressedText.substring(0,1));
	        i--;
	        temp = Integer.toString(i);
	        return compressedText.charAt(1) + decompress(temp.concat(compressedText.substring(1)));
	    }
	    return compressedText.charAt(0) + decompress(compressedText.substring(1));
	}
	
}
