package TaskOne.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Word {
    String text;
    String Clue;
    boolean used;
    ArrayList<Character> usedSymbol;
    Map<Integer, Character> OpenSymbolmap;
}