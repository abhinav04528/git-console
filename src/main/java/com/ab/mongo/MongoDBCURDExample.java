/**
 * 
 */
package com.ab.mongo;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * @author Abhinav Oct 10, 2018 3:32:37 PM
 */
public class MongoDBCURDExample {

	public static void main(String[] args) {
		try {
			// Connect to MongoDB
			MongoClient mc = new MongoClient("localhost", 27017);

			// get the DataBase
			DB db = mc.getDB("testDB");

			// get Collection
			DBCollection collection = db.getCollection("user");

			// insert the record to create the document to store the key and value
			BasicDBObject document = new BasicDBObject();
			document.put("name", "Abhinav");
			document.put("age", "25");
			document.put("createDate", new Date());
			collection.insert(document);

			// find and display the Record
			BasicDBObject search = new BasicDBObject();
			search.put("name", "Abhinav");
			// create the cursor object
			DBCursor cursor = collection.find(search);
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			// search document where name="Abhinav" and update the new values
			BasicDBObject query = new BasicDBObject();
			query.put("name", "Abhinav");

			BasicDBObject newdocument = new BasicDBObject();
			newdocument.put("age", "27");

			BasicDBObject updatedocument = new BasicDBObject();
			updatedocument.put("$set", newdocument);
			collection.update(query, updatedocument);
			// find and display
			BasicDBObject search2 = new BasicDBObject().append("age", "27");
			DBCursor cursor2 = collection.find(search2);
			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}

			// delete the document
			BasicDBObject deleteQuery = new BasicDBObject();
			deleteQuery.put("age", "25");
			collection.remove(deleteQuery);
			System.out.println("Record Deleted SuccessFully..");
		} catch (MongoException me) {
			me.printStackTrace();
		}
	}

}
