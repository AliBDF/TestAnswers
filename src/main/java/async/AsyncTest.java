package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

 public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    return CompletableFuture.supplyAsync(()->{
        Option<Ceo> res=Option.none();  
    for (Ceo a:ceos)
       if (a.id==ceo_id)
        res=Option.of(a);
    return res;});
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id){
    

    return CompletableFuture.supplyAsync(()->
    {Option<Enterprise> res=Option.none();  
        for (Enterprise a:enterprises)
           if (a.ceo_id==ceo_id)
            res=Option.of(a);
        return res;});
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    return    getCeoById(ceo_id).thenApply(
        ceo->Tuple.of(ceo,
            getEnterpriseByCeoId(ceo_id).join()));
            
            
      
    }
}


