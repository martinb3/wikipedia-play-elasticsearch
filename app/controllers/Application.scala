package controllers;

import scala.collection.JavaConversions
import play.api._
import play.api.mvc._
import io.searchbox.client.config.ClientConfig
import io.searchbox.client.JestClientFactory
import io.searchbox.client.config.HttpClientConfig
import io.searchbox.core.Search
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.suggest.SuggestBuilder
import org.elasticsearch.search.suggest.Suggest
import io.searchbox.params.SearchType

object Application extends Controller {
  
  def index = Action {
	  val clientConfig = new HttpClientConfig.Builder("http://foo.bar").multiThreaded(true).build();
	  val factory = new JestClientFactory();
	  factory.setHttpClientConfig(clientConfig);
	  val jestClient = factory.getObject();
	  
	  val searchSourceBuilder = new SearchSourceBuilder();
	  searchSourceBuilder.query(QueryBuilders.matchQuery("user", "kimchy"));
    
	  val search = new Search.Builder(searchSourceBuilder.toString())
                                // multiple index or types can be added.
                                .addIndex("en-wikipedia")
                                .build();
	  
	  
	  // POST en-wikipedia/_suggest "title_suggest" : "text" : "Alexa", "completion" : "field" : "suggest" 
	  //TODO : var ss = new Suggest.SuggestBuilder().phraseSuggestion("title")

	  val result = jestClient.execute(search);
	  
	  val s = result.getJsonString()
	  
	  jestClient.shutdownClient();
	  
    Ok("Hello world: " + s)
    
  }
  
}