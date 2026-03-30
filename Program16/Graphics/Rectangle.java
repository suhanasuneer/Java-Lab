package Graphics;
public class Rectangle implements GraphicsRec
	{
	int length,breadth;
	public Rectangle(int l,int w)
	{
	length=l;
	breadth=w;
	}		
	public int perimeter()
	{
	return 2*(length + breadth);
	}
	public int area()
	{
	return length*breadth;
	}
}


