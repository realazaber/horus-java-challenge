import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface Structure { 
    // Returns any element with the given color 
    Optional<Block> findBlockByColor(String color); 
    
    // Return all elements from the given material 
    List<Block> findBlocksByMaterial(String material); 
    
    // Returns the number of all elements in the structure 
    int count();

    } 
    
    public abstract class Wall implements Structure { 
        private List<Block> blocks;

    // Find block by color
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    // Find block by material
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    public int count() {
        return blocks.size();
    }

    public List<Block> getAllBlocks() {
        List<Block> allBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                allBlocks.addAll(((CompositeBlock) block).getBlocks());
            } else {
                allBlocks.add(block);
            }
        }
        return allBlocks;
    }
    } 
    
    interface Block { 
        String getColor(); 
        String getMaterial(); 
    } 
    
    interface CompositeBlock extends Block { 
        List<Block> getBlocks(); 
    } 

