/**
 * 
 */
package com.ab.mongo;

import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * @author Abhinav
 *Oct 9, 2018
 */
public class CURDOperationTest {
	public static void main(String[] args) {
		MongoClient mc=new MongoClient("localhost", 27017);
		System.out.println("Server Connection Established SuccessFully.");
		
		//create a database in MongoDb 
		DB db=mc.getDB("Mongo-CURD-JAVA");
		System.out.println("DB Connection Successfull.");
		
		//create Collection
		DBCollection collection=db.getCollection("Employee");
		System.out.println("Collection created SuccessFully..");
		
		//insert data into the DataBase
		/*BasicDBObject bdo=new BasicDBObject("name", "Abhinav").append("age", "25").append("address", "Pune");
		collection.insert(bdo);
		System.out.println("Document Inserted SuccessFully..");
		*/
		
		//fetch all the records
		//Cursor cursor=collection.find();
		DBCursor cursor=collection.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().get("name")); 
			//System.out.println(cursor.next().get("age")); 
			//System.out.println(cursor.next().get("address")); 
		}
	}
}
