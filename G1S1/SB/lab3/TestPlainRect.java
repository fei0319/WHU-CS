import java.util.*;

class Rect
{
    private double length, width;

    public Rect(double __length, double __width)
    {
        length = __length;
        width = __width;
    }

    public Rect()
    {
        length = 10;
        width = 10;
    }

    public double area()
    {
        return length * width;
    }

    public double perimeter()
    {
        return (length + width) * 2;
    }

    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }
}

class PlainRect extends Rect
{
    private double startX, startY;

    PlainRect()
    {
        super(0, 0);
        startX = 0;
        startY = 0;
    }

    PlainRect(double __startX, double __startY, double __length, double __width)
    {
        super(__length, __width);
        startX = __startX;
        startY = __startY;
    }

    boolean isInside(double x, double y)
    {
        return x >= startX && x <= startX + getLength() && y >= startY && y <= startY + getWidth();
    }
}

public class TestPlainRect
{
    public static void main(String args[])
    {
        PlainRect plainRect = new PlainRect(10.0, 10.0, 15.0, 10.0);
        System.out.printf("The length and width of the rectangle is %f and %f.\n", plainRect.getLength(), plainRect.getWidth());
        System.out.printf("The area and perimeter of the rectangle is %f and %f.\n", plainRect.area(), plainRect.perimeter());
        
        double x, y;

        x = 25.5;
        y = 12.2;
        if(plainRect.isInside(x, y))
            System.out.printf("(%f, %f) is in the rectangle.\n", x, y);
        else
            System.out.printf("(%f, %f) is not in the rectangle.\n", x, y);

        Scanner in = new Scanner(System.in);
        System.out.printf("Please enter two number x and y, seperated by a space:");
        x = in.nextDouble();
        y = in.nextDouble();
        if(plainRect.isInside(x, y))
            System.out.printf("(%f, %f) is in the rectangle.\n", x, y);
        else
            System.out.printf("(%f, %f) is not in the rectangle.\n", x, y);
    }
}