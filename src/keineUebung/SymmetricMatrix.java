package keineUebung;

public class SymmetricMatrix {
	
	Object Matrix[];
	int size;

	public SymmetricMatrix (int n)
	{
		size = n;
		int x=0;
		for(int i = n;i>0;i--)
		{
			x+=i;
		}
		Matrix = new Object[x];
		
		for(int i = 0; i<Matrix.length; i++)
		{
			Matrix[i] = null;
		}		
	}
	
	
	
	void set (int row, int column, Object value)throws IndexOutOfBoundsException{
		if(row> size || column>size || column<=0 || row <= 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(row>column)
		{
			int save = row;
			row = column;
			column = save;
		}
		
		int sum = 0;
		for (int i =1; i<row; i++)
		{
			sum += i;
		}
		Matrix[sum+column-1] = value;
		
				
	}
	
	Object get (int row, int column) throws IndexOutOfBoundsException
	{
		if(row> size || column>size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(row>column)
		{
			int save = row;
			row = column;
			column = save;
		}
		
		int sum = 0;
		for (int i =1; i<row-1; i++)
		{
			sum += i;
		}
		return Matrix[sum+column-1];
		
	}
	
	
}
