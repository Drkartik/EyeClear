import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PrescriptionTest {

    @Test
    public void testAddPrescription_ValidData() {
        Prescription prescription = new Prescription();

        // Test Data 1
        boolean result1 = prescription.addPrescription("Li", "Wei", "123 Long St, Beijing, 100000, China", 1.00f, 0.50f, 90.00f, new Date(), "Dr. Zhang");
        assertTrue(result1); // Expecting true for valid data

        // Test Data 2
        boolean result2 = prescription.addPrescription("Wang", "Ming", "456 Short St, Shanghai, 200000, China", -1.50f, -1.00f, 180.00f, new Date(), "Dr. Li");
        assertTrue(result2); // Expecting true for valid data
    }

    @Test
    public void testAddPrescription_InvalidNameLength() {
        Prescription prescription = new Prescription();

        // Test Data 1
        boolean result1 = prescription.addPrescription("Li", "Wei", "123 Long St, Beijing, 100000, China", 1.00f, 0.50f, 90.00f, new Date(), "Dr. Zhang");
        assertFalse(result1); // Expecting false due to invalid name length

        // Test Data 2
        boolean result2 = prescription.addPrescription("Wang", "M", "456 Short St, Shanghai, 200000, China", -1.50f, -1.00f, 180.00f, new Date(), "Dr. Li");
        assertFalse(result2); // Expecting false due to invalid name length
    }

    @Test
    public void testAddPrescription_InvalidAddressLength() {
        Prescription prescription = new Prescription();

        // Test Data 1
        boolean result1 = prescription.addPrescription("Li", "Wei", "Short Address", 1.00f, 0.50f, 90.00f, new Date(), "Dr. Zhang");
        assertFalse(result1); // Expecting false due to short address

        // Test Data 2
        boolean result2 = prescription.addPrescription("Wang", "Ming", "123 St", -1.50f, -1.00f, 180.00f, new Date(), "Dr. Li");
        assertFalse(result2); // Expecting false due to short address
    }

    @Test
    public void testAddPrescription_OutOfRangeValues() {
        Prescription prescription = new Prescription();

        // Test Data 1
        boolean result1 = prescription.addPrescription("Li", "Wei", "123 Long St, Beijing, 100000, China", 25.00f, 0.50f, 90.00f, new Date(), "Dr. Zhang");
        assertFalse(result1); // Expecting false due to sphere out of range

        // Test Data 2
        boolean result2 = prescription.addPrescription("Wang", "Ming", "456 Long St, Shanghai, 200000, China", -5.00f, -1.00f, 180.00f, new Date(), "Dr. Li");
        assertFalse(result2); // Expecting false due to cylinder out of range
    }

    @Test
    public void testAddRemark_ValidData() {
        Prescription prescription = new Prescription();

        // Test Data 1
        boolean result1 = prescription.addRemark("The client is satisfied with the service.", "Client");
        assertTrue(result1); // Expecting true for valid data

        // Test Data 2
        boolean result2 = prescription.addRemark("Optometrist recommends regular checkups.", "Optometrist");
        assertTrue(result2); // Expecting true for valid data
    }

    @Test
    public void testAddRemark_InvalidWordCount() {
        Prescription prescription = new Prescription();

        // Test Data 1
        boolean result1 = prescription.addRemark("Short remark.", "Client");
        assertFalse(result1); // Expecting false due to insufficient word count

        // Test Data 2
        boolean result2 = prescription.addRemark("This remark has more than twenty words which should not be accepted as valid input.", "Optometrist");
        assertFalse(result2); // Expecting false due to exceeding word count
    }

    @Test
    public void testAddRemark_InvalidCategory() {
        Prescription prescription = new Prescription();

        // Test Data 1
        boolean result1 = prescription.addRemark("This is a valid remark.", "InvalidCategory");
        assertFalse(result1); // Expecting false due to invalid category

        // Test Data 2
        boolean result2 = prescription.addRemark("Optometrist recommends taking the prescription.", "Patient");
        assertFalse(result2); // Expecting false due to invalid category
    }

    @Test
    public void testAddRemark_ExceedingRemarks() {
        Prescription prescription = new Prescription();
        prescription.addRemark("First remark.", "Client");
        prescription.addRemark("Second remark.", "Optometrist");

        // Test Data 1
        boolean result1 = prescription.addRemark("This should not be added.", "Client");
        assertFalse(result1); // Expecting false due to exceeding remark limit

        // Test Data 2
        boolean result2 = prescription.addRemark("Another remark that exceeds the limit.", "Optometrist");
        assertFalse(result2); // Expecting false due to exceeding remark limit
    }
}