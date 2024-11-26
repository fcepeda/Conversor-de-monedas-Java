import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    ArrayList<String> historyStrings = new ArrayList<>();

    public void addConversion(String line)
    {
        historyStrings.add(line);
    }

    @Override
    public String toString() {

        String history = "";

        System.out.println("Este es el historial de las conversiones realizadas: \n\n");

        for (int i = 0; i < historyStrings.size(); i++) {
            history += historyStrings.get(i)+"\n";
        }

        return history;
    }
}
