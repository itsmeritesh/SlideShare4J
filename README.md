# SlideShare4J

SlideShare4J is a Java version of [SlideShare4S](https://github.com/ntaro/SlideShare4S),
i.e. a library for Java to use SlideShare API.

## Sample

```java
import com.taroid.slideshare4j.*;

public class Main {
  public static void main(String[] args) {
    final String apiKey = "YOUR_API_KEY";
    final String sharedSecret = "YOUR_API_KEY";

    final SlideShare ss = SlideShareFactory.newInstance(apiKey, sharedSecret);
    final Query query = new QueryBuilder().setWords("java").setSortOrder(SortOrder.LATEST).create();
    final Paging paging = new PagingBuilder().setItemsPerPage(12).setPage(1).create();

    final List<Slideshow> slideshows = ss.searchSlideshows(query, paging);

    for(Slideshow s: slideshows) {
      System.out.format("%s [%s]%n", s.getTitle(), s.getID());
    }
  }
}
```