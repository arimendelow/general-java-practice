
public class PyramidHeight {
	
	public static void main(String[] args) {
		
		System.out.println("How high do you want your pyramid to be?");
		int height = IO.readInt();
		int layer = height;
		
		System.out.println("1 for up, 2 for sideways");
		int dir = IO.readInt();
		
		int blank;
		int i = 0;
		int j = 0;
		
	
		if(dir == 1) { //upwards
		
			for(i = 0; i < height; i = i++) {
				
				blank = layer - 1;
				
				for(j = blank; j > 0; j--) {
					System.out.print(" ");
				}
				
				for(j = i; j > 0; j--) {
					System.out.print("*");
				}
				
				System.out.println();
				layer = layer + 2;
				
				
			}
				
		} else if(dir == 2) { //sideways
			
			int layerMax = height/2;
			
			if(height % 2 == 0) { //even height
				
				for(layer = 1; layer <= layerMax; layer ++) {
					for(i = 1; i <=layer; i++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for(layer = layerMax; layer > 0; layer --) {
					for(i = 1; i <=layer; i++) {
						System.out.print("*");
					}
					System.out.println();
				}
			} else if(height % 2 != 0) { //odd height
					
				for(layer = 1; layer <= layerMax; layer ++) {
					for(i = 1; i <=layer; i++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for(layer = layerMax - 1; layer > 0; layer --) {
					for(i = 1; i <=layer; i++) {
						System.out.print("*");
					}
					System.out.println();
				}	
			}
		}
	}
}
