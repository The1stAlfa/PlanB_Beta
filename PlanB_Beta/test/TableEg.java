import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableEg {
   public static void main(String[] args) throws IOException {
      String html = "https://docs.google.com/spreadsheets/u/0/d/1opkeRYb5xsf_3CMpvsVVYcFx4ivbY0pchbgoeKpXIx8/gviz/tq?tqx=out:html&tq=SELECT+C,D,G+WHERE+B%3D%27joel%27AND+E%3D%273367ef9001c4f856a971ec60a8731b45575f013b%27&sheet=user&pli=1";
      try{
      Document doc = Jsoup.connect(html).get();
      Elements tableElements = doc.select("table");
      Elements tableHeaderEles = tableElements.select("thead tr th");
      System.out.println("headers");
      for (int i = 0; i < tableHeaderEles.size(); i++) {
          System.out.println(tableHeaderEles.get(i).text());
      }
      System.out.println();
      Elements tableRowElements = tableElements.select(":not(thead) tr");
      for (int i = 0; i < tableRowElements.size(); i++) {
          Element row = tableRowElements.get(i);
          System.out.println("row");
          Elements rowItems = row.select("td");
          for (int j = 0; j < rowItems.size(); j++) {
              System.out.println(rowItems.get(j).text());
          }
          System.out.println();
      }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}