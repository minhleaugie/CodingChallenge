import java.util.Scanner;

public class FlowLayout {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int maxW = console.nextInt(); // max width
        while (maxW != 0) {
            int w = console.nextInt(); // input width
            int h = console.nextInt(); // input height

            int x = 0; // current width
            int y = 0; // current height

            int boxW = 0; // output width
            int boxH = 0; // output height

            while (!(w == -1 && h == -1)) {
                if (x + w <= maxW) {
                    x += w;
                    if (boxW < x) {
                        boxW = x;
                    }
                    if (y < h) {
                        y = h;
                    }

                } else {
                    x = w;
                    boxH += y;
                    y = h;
                    
                }

                w = console.nextInt();
                h = console.nextInt();
            }
            
            boxH += y;
            System.out.println(boxW + " x " + boxH);
            maxW = console.nextInt();
        }

    }

}
