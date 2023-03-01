import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface Structure { 
    // returns any element with the given color 
    Optional<Block> findBlockByColor(String color); 
    
    // return all elements from the given material 
    List<Block> findBlocksByMaterial(String material); 
    
    //returns the number of all elements in the structure 
    int count();
    } 
    
    public abstract class Wall implements Structure { 
        private List<Block> blocks; 
    } 
    
    interface Block { 
        String getColor(); 
        String getMaterial(); 
    } 
    
    interface CompositeBlock extends Block { 
    List<Block> getBlocks(); 
    } 

