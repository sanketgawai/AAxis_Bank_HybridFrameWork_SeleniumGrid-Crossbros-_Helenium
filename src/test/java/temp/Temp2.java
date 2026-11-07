package temp;

import java.util.HashSet;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Temp2 {

	public static void main(String[] args) {
		
		int no = 100;
		
		for(int i =2;i<=no;i++)
		{
			while(no%i==0)
			{
				no = no/i;
				System.out.println(no);
			}
		}
		
		
	}
	
}

