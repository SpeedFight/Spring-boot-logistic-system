package com.bootLogisticSystem.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.bootLogisticSystem.entity.Request;

/**
 * Utils class to generate random request.
 * 
 * @author speedfight
 *
 */
public class RandomRequest {
	private static Random random = new Random();

	private RandomRequest() {

	};

	public static List<Request> generate(int amount) {
		List<Request> requests = new ArrayList<>();
		
		for (int i = 0; i < amount; i++) {
			requests.add(new Request(
					getRandomClientId(), 
					random.nextInt(clientsId.size()), 
					getRandomProduct(), 
					random.nextInt(1+amount*5), 
					random.nextInt(1+amount*4)));
		}
		
		return requests;
	}

	private static String getRandomProduct() {
		return products.get(random.nextInt(products.size()));		
	}
	
	private static String getRandomClientId() {
		return clientsId.get(random.nextInt(clientsId.size()));	
	}

	//realistic list of product and names to provide better random generated request lists
	private static List<String> products = new ArrayList<>
			(Arrays.asList(new String[]{"Chleb","Mąka","Jaka",
					"Dżem","Mineralna","Miód","Soczki",
					"Płatki","Sól","Pączki","Lody",
					"Czipsy","Rogale","Mleko","Pieprz",
					"Budyń","Kisiel","Ryż","Makaron",
					"Ciasteczka","Precle","Twaróg","Śmietana",
					"Jogurt","Serekhomogenizowany","Szynka","Drób",
					"Wołowina","Kawa","Herbata","Zupkichińskie",
					"Bajgleciasto","Margaryna","Pomidory","Jabłka",
					"Wanilia","Cynamon","Cukierpuder","Konfitury",
					"Parówki","Cola","Babeczki","Azbest",
					"Konina","Karczek","Ocet","Orzechy",
					"Biszkopty","Pieczarki","Musztarda","Keczup",
					"Pory","Cukier","Cukierki"}));

	private static List<String> clientsId = new ArrayList<>
			(Arrays.asList(new String[] { "Lili", "Larry", "Lisa", "Ophelia",
			"Oscar", "Pablo", "Allison", "Arthur", "Rafael", "Sebastien", "Sally", "Karl", "Katrina", "Kirk",
			"Virginie", "Vince", "Valerie", "Youko", "Sachiko", "Mieko", "Toshie" }));

}
