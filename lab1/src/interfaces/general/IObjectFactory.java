package interfaces.general;

import java.util.List;



public interface IObjectFactory<T> {
  
    T generate(List<T> currentList);
}