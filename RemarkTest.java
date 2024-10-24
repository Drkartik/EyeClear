import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Prescription class, specifically for the addRemark method.
 */
public class RemarkTest {
    private Prescription prescription;

    /**
     * Set up a new Prescription object before each test.
     */
    @BeforeEach
    public void setUp() {
        prescription = new Prescription();
    }

    /**
     * Test valid remark from a client.
     */
    @Test
    public void testAddRemark_ValidClientRemark() {
        // Add a valid client remark
        String remark = "This is a valid client remark.";
        String type = "Client";

        // Assert that adding the remark returns true
        assertTrue(prescription.addRemark(remark, type));
    }

    /**
     * Test valid remark from an optometrist.
     */
    @Test
    public void testAddRemark_ValidOptometristRemark() {
        // Add a valid optometrist remark
        String remark = "The patient's vision needs regular check-up.";
        String type = "Optometrist";

        // Assert that adding the remark returns true
        assertTrue(prescription.addRemark(remark, type));
    }

    /**
     * Test invalid remark (too short).
     */
    @Test
    public void testAddRemark_InvalidShortRemark() {
        // Add an invalid short remark
        String remark = "Too short.";
        String type = "Client";

        // Assert that adding the remark returns false
        assertFalse(prescription.addRemark(remark, type));
    }

    /**
     * Test invalid remark (too long).
     */
    @Test
    public void testAddRemark_InvalidLongRemark() {
        // Add an invalid long remark
        String remark = "This remark has too many words and is invalid because it exceeds the limit set for remarks.";
        String type = "Optometrist";

        // Assert that adding the remark returns false
        assertFalse(prescription.addRemark(remark, type));
    }

    /**
     * Test invalid remark (first character lowercase).
     */
    @Test
    public void testAddRemark_InvalidFirstCharacterLowercase() {
        // Add an invalid remark that starts with a lowercase letter
        String remark = "this remark starts with a lowercase letter.";
        String type = "Client";

        // Assert that adding the remark returns false
        assertFalse(prescription.addRemark(remark, type));
    }

    /**
     * Test invalid remark type.
     */
    @Test
    public void testAddRemark_InvalidRemarkType() {
        // Add a valid remark with an invalid type
        String remark = "This is a valid remark.";
        String type = "Doctor"; // Invalid type

        // Assert that adding the remark returns false
        assertFalse(prescription.addRemark(remark, type));
    }

    /**
     * Test adding multiple remarks.
     */
    @Test
    public void testAddRemark_ExceedingRemarksLimit() {
        // Add valid remarks
        prescription.addRemark("First remark.", "Client");
        prescription.addRemark("Second remark.", "Optometrist");

        // Add a third remark which should fail (exceeding limit)
        String remark = "Third remark.";
        String type = "Client";

        // Assert that adding the third remark returns false
        assertFalse(prescription.addRemark(remark, type));
    }
}
