import java.awt.*;

import org.apache.commons.numbers.complex.Complex;
import org.apache.commons.numbers.fraction.BigFraction;

public class Fractal {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500,500);
        Graphics g = panel.getGraphics();
        g.drawLine(0,0,0,0);

//
//        Fraction f1 = Fraction.of(3,7);
//        System.out.println(f1);
//        Fraction f2 = Fraction.of(75,12);
//        System.out.println(f2);
//        Fraction f3 = f1.add(f2);
//        System.out.println(f3);
//        System.out.println(f3.doubleValue());
//
//
//
//        //treeFractal(250,400,100,80,10,g,panel,10);
//
//
//        int l = 50;
//        int[] xPoints = {100,150,200};
//        int[] yPoints = {100,150,100};
//        //g.fillPolygon(xPoints,yPoints,3);
//        g.drawLine(100,101,200,101);
//        g.drawLine(100,99,200,99);
//        g.setColor(Color.red);
//        g.drawLine(100,100,100,100);
//
//        int x = 100;
//        int y = 200;
//        for (int i = 0; i < 50; i += 2) {
//            for (int j = 0; j < 50; j+=2) {
//                g.drawLine(x + i, y + j, x + i, y + j);
//            }
//        }
//        y = 300;
//        for (int i = 0; i < 20; i += 2) {
//            g.drawLine(100,300+i, 200, 300+i);
//        }
//
        ZFrac zf1 = new ZFrac(frac(6,1),frac(6,1));
//        System.out.println(zf1 + " is zf1");
//        ZFrac zf2 = new ZFrac(frac(-2,1),frac(6,9));
//        System.out.println(zf2 + " is zf2");
//
//        ZFrac zf3 = zf1.multi(zf2);
//        ZFrac zf4 = zf2.multi(zf1);
//        System.out.println(zf3);
//        System.out.println(zf4);

        zf1 = zf1.sqr();
        ZFrac zfm = zf1;


//        System.out.println(zf1);
//        System.out.println(zfm);
//

        ZFrac z1 = new ZFrac(frac(1,10),frac(2,10));
        Complex c1 = Complex.ofCartesian(.1,.2);

        
       // M(Complex.ZERO, c1, 15);

//        BigInteger big = BigInteger.valueOf(3);
//        System.out.println(3);
//        Complex c1 = Complex.ofCartesian(0.1,-.5);
//        Md(Complex.ZERO,c1, 100);
double test = 1.5;
        System.out.println(Math.round(1.5));
        System.out.println(Math.ceilDiv(7,2));






    }

    public static void MSuperPrecise(ZFrac z, ZFrac c, int max) {
        ZFrac next = (z.sqr()).add(c);
        System.out.println(max);
        if (max > 1) {
            MSuperPrecise(next, c, max-1);
        } else {
            System.out.println(next);
            System.out.println(next.toDouble());
        }
    }

    public static void MandelSetItt(Complex z, Complex c, int max) {
        Complex next = MF(z,c);
        if (max > 1 && next.abs() < 2) {
            MandelSetItt(next,c,max-1);
        } else System.out.println(next);
    }

    public static Complex MF(Complex z, Complex c) {
        return (z.pow(2)).add(c);
    }

    public static void treeFractal(int x, int y, int r, int theta, int steps, Graphics g, DrawingPanel panel, int pause) {
        panel.sleep(pause);
        double thetaRad = degToRad(theta);
        if (steps > 0) {
            drawTree(x,y,theta,r,g);
            int[] endPoint0 = {
                    (int)((r*Math.cos(thetaRad)) + x - r)
                    ,
                    (int)(y - (r*Math.sin(thetaRad)))
            };
            int[] endPoint1 = {
                    (int)(x + r - 1*(r*Math.cos(thetaRad)))
                    ,
                    (int)(y - (r*Math.sin(thetaRad)))
            };
            treeFractal(endPoint0[0],endPoint0[1], r/2, theta, steps-1,g,panel,pause);
            treeFractal(endPoint1[0],endPoint1[1], r/2, theta, steps-1,g,panel,pause);

        }


    }

    public static double degToRad(double deg) {
        return (Math.PI/180.0) * deg;
    }

    public static void drawTree(int x, int y, int arcDeg, int r, Graphics g) {
        g.setColor(Color.RED);
        g.drawArc(x-2*r, y-r, 2*r, 2*r, 0, arcDeg);
        g.setColor(Color.BLUE);
        g.drawArc(x, y-r, 2*r, 2*r, 180-arcDeg, arcDeg);
    }

    public static BigFraction frac(int a, int b) {
        return BigFraction.of(a,b);
    }

}
