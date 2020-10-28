package seedu.bagel.model;

import javafx.collections.ObservableList;
import seedu.bagel.model.flashcard.Flashcard;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyBagel {

    /**
     * Returns an unmodifiable view of the flashcards list.
     * This list will not contain any duplicate flashcards.
     */
    ObservableList<Flashcard> getFlashcardList();

}