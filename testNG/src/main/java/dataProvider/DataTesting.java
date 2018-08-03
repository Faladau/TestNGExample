package dataProvider;

import org.testng.annotations.DataProvider;

public class DataTesting {
	
	@DataProvider(name = "New Users")
	 public static Object[][] users() {
	  return new Object[][] {

	   {"Simona Halep", "tennis player",201},
	   {"Klaus Iohannis", "president",201},
	   {"Ion Iliescu", "Gunoier",201},
	   {"", "Tester",400},
	   {"1234", "Tester",400},
	   {"!@#$%^", "Tester",400},
	   {"Mihaila", "                                                            ",400},
	   {"Klaus Iohannis", "presidentTest",201},
	   {"16 Caractere", "!@#$%^&*",400},
	   {"Ion Creanga", "writer",400},
	   {"Mihai Eminescu", "poet",400}


	  };
	 }

}
