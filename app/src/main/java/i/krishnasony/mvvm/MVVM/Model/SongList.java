package i.krishnasony.mvvm.MVVM.Model;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class SongList{
  private List<Results> results;
  public void setResults(List<Results> results){
   this.results=results;
  }
  public List<Results> getResults(){
   return results;
  }
}