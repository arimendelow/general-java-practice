
public class PyramidBase {
	
	public static void main(String[] args) {
		
		System.out.println("How wide do you want your pyramid base to be?");
		int base = IO.readInt();
		int layer = base;
		
		System.out.println("1 for down, 2 for up, 3 for sideways");
		int dir = IO.readInt();
		
		int blank;
		int i = 0;
		int j = 0;
		
		if(dir == 1) { //downwards
			
			while(layer > 0) {
				
				blank = (base - layer)/2;
				
				for(i = blank; i > 0; i--) {
					System.out.print(" ");
				}
				
				for(i = layer; i > 0; i--) {
					System.out.print("*");
				}
				
				layer = layer - 2;
				
				System.out.println();
			}
			
		} else if(dir == 2) { //upwards
		
			if(base % 2 == 0) { //even base
				
				
				for(i = 2; i <= base; i = i + 2) {
					
					blank = (layer/2) - 1;
					
					for(j = blank; j > 0; j--) {
						System.out.print(" ");
					}
					
					for(j = i; j > 0; j--) {
						System.out.print("*");
					}
					
					System.out.println();
					layer = layer - 2;
					
				}
					
			} else if(base % 2 != 0) { //odd base
				
				
				for(i = 1; i <= base; i = i + 2) {
					
					blank = (layer-1)/2;
					
					for(j = blank; j > 0; j--) {
						System.out.print(" ");
					}
					
					for(j = i; j > 0; j--) {
						System.out.print("*");
					}
					
					System.out.println();
					layer = layer - 2;
					
				}
					
			}
				
				
		} else if(dir == 3) { //sideways
			
			int layerMax = base/2;
			
			if(base % 2 == 0) { //even base
				
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
			} else if(base % 2 != 0) { //odd base
					
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
