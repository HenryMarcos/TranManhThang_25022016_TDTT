import java.util.*;
 
  class CountingHashSet<E> extends HashSet<E> {
     private int addCount = 0;
 
     @Override
      public boolean add(E e) {
         addCount++;
         return super.add(e);
     }

     @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
       return super.addAll(c); 
    }
 
     public int getAddCount() {
         return addCount;
    }
 }

 public class Main {
   public static void main(String[] args) {
       CountingHashSet<String> s = new CountingHashSet<>();
        List<String> list = Arrays.asList("A", "B", "C");
        
        s.addAll(list);
        System.out.println(s.getAddCount());
    }
 }