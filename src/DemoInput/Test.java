// Java program to read JSON from a file
package DemoInput;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Test {
	public static void main(String[] args) throws Exception {

		Object obj = new JSONParser().parse(new FileReader("src/test.json"));
		JSONObject jo = (JSONObject) obj;

		long numberOfPlayers = (long) jo.get("i");
		long strategiesPerPlayer = (long) jo.get("j");

		System.out.println("Number of players: " + numberOfPlayers);
		System.out.println("Strategies per player: " + strategiesPerPlayer);

		Long[][] strategies = new Long[(int) numberOfPlayers][(int) strategiesPerPlayer];
		JSONArray strategiesArray = (JSONArray) jo.get("strategies");

		System.out.println();
		System.out.println("Strategies:");
		for (int i = 0; i < strategiesArray.size(); i++) {
			JSONArray internaljsonArray = (JSONArray) strategiesArray.get(i);
			for (int j = 0; j < internaljsonArray.size(); j++) {

				Long num = (Long) internaljsonArray.get(j);
				strategies[i][j] = num;
			}
		}

		int index1 = 0, index2 = 0;
		for (Long[] strategy : strategies) {
			System.out.print("Player " + ++index1 + ": [");
			for (int i = 0; i < strategy.length; i++) {
				if (i < strategy.length - 1)
					System.out.print(strategy[i] + ", ");
				else
					System.out.print(strategy[i]);
			}
			System.out.print("]");
			System.out.println();
		}

		Double[][] weights = new Double[(int) numberOfPlayers][(int) strategiesPerPlayer];
		JSONArray weightsArray = (JSONArray) jo.get("weights");

		System.out.println();
		System.out.println("Weights:");
		for (int i = 0; i < weightsArray.size(); i++) {
			JSONArray internaljsonArray = (JSONArray) weightsArray.get(i);
			for (int j = 0; j < internaljsonArray.size(); j++) {

				Double num = (Double) internaljsonArray.get(j);
				weights[i][j] = num;
			}
		}

		for (Double[] weight : weights) {
			System.out.print("Player " + ++index2 + ": [");
			for (int i = 0; i < weight.length; i++) {
				if (i < weight.length - 1)
					System.out.printf("%f, ", weight[i]);
				else
					System.out.printf("%f", weight[i]);
			}
			System.out.print("]");
			System.out.println();
		}

	}
}
