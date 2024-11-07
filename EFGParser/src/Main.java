import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import tr.edu.iyte.esg.conversion.dot.ESGToDOTFileConverter;
import tr.edu.iyte.esg.model.ESG;
import tr.edu.iyte.esg.testgeneration.TestSuite;
import tr.edu.iyte.esg.testgeneration.TestSuiteGenerator;

public class Main {
	
	public static void main(String[] args)
	{		
		
		FileParser test = new FileParser("D:\\College\\Graduate Project\\EFG Jsons\\firstchoice.json");
		HashMap<String,Set<String>> graph = test.CreateGraph();
		ESG graph1 = test.createESG("First Choice");
		
		ESGToDOTFileConverter.buildDOTFileFromESG(graph1,"D:\\College\\Graduate Project\\firstchoice.dot");
		
		TestSuiteGenerator gen = new TestSuiteGenerator();
		TestSuite tests = gen.generateTestSuite(graph1);
		System.out.println(tests.toString());
	}
}
