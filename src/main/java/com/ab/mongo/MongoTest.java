/**
 * 
 */
package com.ab.mongo;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author Abhinav Oct 9, 2018
 */
public class MongoTest {
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		System.out.println("Server Connection Successfully Done." + mc);

		// connect to the DataBase
		MongoDatabase md = mc.getDatabase("test");
		System.out.println("Connect to the DataBase SuccessFully.");
		System.out.println("DataBase Name :" + md.getName());
		// get the list of the DataBase Name
		List<String> DbName = mc.getDatabaseNames();
		System.out.println(DbName);

		// Delete the DataBase
		mc.dropDatabase("test");
		DbName = mc.getDatabaseNames();
		System.out.println(DbName);
		mc.close();
	}
}
