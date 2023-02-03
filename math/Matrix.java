package math;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final strictfp class Matrix {
	
	static private long numberOfVariables = 0;
	private long thisVariable;
	private long _lines = 0;
	private long _rows = 0;
	
	private void initVariable(String data) {
		try(FileWriter out = new FileWriter("var" + thisVariable + ".matrix")) {
			
			String lastStr = "%";
			
			for(int i = 0; i < data.length()-1; i++) {
				lastStr += String.valueOf(data.charAt(i));
			}
			
			lastStr += "%";
			
			out.append(lastStr);
			out.close();
			
		}catch(IOException err) {
			System.out.println(err.getMessage());
		}
	}
	private String getElements(long line, long row) {
		
		String data = "";
		
		try(FileReader in = new FileReader("var" + thisVariable + ".matrix")) {
			
			long currentPositionX = 0;
			long currentPositionY = 1;
			
			boolean start = false;
			
			int symbol;
            while((symbol = in.read()) != -1) {
           
            	if (currentPositionX == line) {
	            	if(currentPositionY == row) {
	            		start = true;
	            	}
	            	
	            	if(( (char) symbol == '|' || (char) symbol == '%' )  && start == true) {
	            		start = false;
	                	break;
	                }
	               
	               if((char) symbol == '|') {
	            	   currentPositionY+=1;
	               }
	            	
	            	if(start == true) {
	            		data += (char) symbol;
	            	}
            	} 	
            	if((char) symbol == '%') {
            		currentPositionX += 1;
            	}
            } 
		}catch(IOException err) {
			System.out.println(err.getMessage());
		}
		return data;
	}
	
	public Matrix(int... MatrixVar) {
		_lines += 1;
		numberOfVariables += 1;
		thisVariable = numberOfVariables;
		
		String data = "";
		for(int val : MatrixVar) {
			data += String.valueOf(val);
			data += "|";
			_rows++;
		}
		initVariable(data);
	}
	
	public int getElement(long line, long row) {
		if(line > _lines) {
			System.out.println("Incorrect matrix position in arguments for method - getElement(),");
			System.out.println("You have [" + _lines + "] - lines, but you select [" + line + "] line.");
			return 0;
		}
		if(row > _rows) {
			System.out.println("Incorrect matrix position in arguments for method - getElement(),");
			System.out.println("You have [" + _rows + "] - rows, but you select [" + row + "] row.");
			return 0;
		}
		return Integer.parseInt(getElements(line, row));
		
	}
	
}