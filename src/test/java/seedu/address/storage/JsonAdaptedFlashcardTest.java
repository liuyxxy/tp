package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedFlashcard.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalFlashcards.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.flashcard.Description;
import seedu.address.model.flashcard.Title;

public class JsonAdaptedFlashcardTest {
    private static final String INVALID_TITLE = "R@chel";
    // private static final String INVALID_DESC = "+651234";
    // private static final String INVALID_TAG = "#friend";

    private static final String VALID_TITLE = BENSON.getTitle().toString();
    private static final String VALID_DESC = BENSON.getDescription().toString();
    // private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
    //         .map(JsonAdaptedTag::new)
    //         .collect(Collectors.toList());

    @Test
    public void toModelType_validFlashcardDetails_returnsFlashcard() throws Exception {
        JsonAdaptedFlashcard flashcard = new JsonAdaptedFlashcard(BENSON);
        assertEquals(BENSON, flashcard.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedFlashcard flashcard =
                new JsonAdaptedFlashcard(INVALID_TITLE, VALID_DESC);
        String expectedMessage = Title.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, flashcard::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedFlashcard flashcard = new JsonAdaptedFlashcard(null, VALID_DESC);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, flashcard::toModelType);
    }

    @Test
    public void toModelType_nullDescription_throwsIllegalValueException() {
        JsonAdaptedFlashcard flashcard = new JsonAdaptedFlashcard(VALID_TITLE, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, flashcard::toModelType);
    }

    // @Test
    // public void toModelType_invalidTags_throwsIllegalValueException() {
    //    List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
    //     invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
    //     JsonAdaptedFlashcard flashcard =
    //             new JsonAdaptedFlashcard(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, invalidTags);
    //     assertThrows(IllegalValueException.class, flashcard::toModelType);
    // }
}