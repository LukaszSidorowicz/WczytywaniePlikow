import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WczytywaniePlikow {

	public static void main(String[] args) {

		String jeden = "jeden";
		String dwa = "dwa";

		if (args.length == 0) {
			System.out
					.println("Nie podano arkumentów, proszę podaj argument o nazwie jeden lub dwa.");
		} else if (args[0].equals(jeden)) {

			WczytywaniePlikow obj = new WczytywaniePlikow();
			obj.run(1);
		}

		else if (args[0].equals(dwa)) {
			WczytywaniePlikow obj = new WczytywaniePlikow();
			obj.run(2);

		}

	}

	public void run(int wybor) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy= "";
		String csvFile = "";

		if (wybor == 1) {
			csvFile = "/home/lukasz/workspace/Wczytywanie/src/plikTekstowy.csv";
			cvsSplitBy = ";";
		}

		if (wybor == 2) {
			csvFile = "/home/lukasz/workspace/Wczytywanie/src/plikTekstowy1.csv";
			cvsSplitBy = ",";
		}

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] dane = line.split(cvsSplitBy);

				System.out.println("Imię [code= " + dane[0] + " , Nazwisko="
						+ dane[1] + "]");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Gotowe.");
	}
}
