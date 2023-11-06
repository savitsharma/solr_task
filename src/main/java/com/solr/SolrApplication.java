	package com.solr;

	import org.apache.solr.client.solrj.SolrClient;
	import org.apache.solr.client.solrj.SolrServerException;
	import org.apache.solr.client.solrj.impl.HttpSolrClient;
	import org.apache.solr.common.SolrInputDocument;

	import java.io.IOException;

	public class SolrApplication {

		public static void main(String[] args) throws SolrServerException, IOException {

			String solrUrl = "http://localhost:8983/solr/mycore"; // Replace with your Solr server URL and collection name
			SolrClient solr = new HttpSolrClient.Builder(solrUrl).build();

			// Create a Solr document
			SolrInputDocument document = new SolrInputDocument();
			document.addField("name", "unique_id_123"); // Unique identifier for the document
			document.addField("class", "unique");
			document.addField("section", "id_123");
			document.addField("category", "shirts");
			document.addField("price", "2000");

			// Add the document to Solr index
			solr.add(document);

			// Commit changes to the index
			solr.commit();
			System.out.println("Document indexed successfully.");

			// Close the Solr client
			solr.close();
		}

	}




