package tracker.start;

/**
 * Calss ValidateInput класс валидации вводимых данных.
 */
public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("pls enter number from range");
            } catch (NumberFormatException nfe) {
                System.out.println("pls enter valid data again");
            }
        } while(invalid);
        return value;
    }
}
