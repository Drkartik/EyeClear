import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Prescription class, specifically for the addPrescription method.
 */
public class PrescriptionTest {
    private Prescription prescription;

    /**
     * Set up a new Prescription object before each test.
     */
    @BeforeEach
    public void setUp() {
        prescription = new Prescription();
    }

    /**
     * Test valid prescription details.
     */
    @Test
    public void testAddPrescription_ValidData() {
        // Set valid prescription data
        prescription.setFirstName("Wang");
        prescription.setLastName("Li");
        prescription.setAddress("123 Beijing Rd, Beijing, 100000, China");
        prescription.setSphere(0.00f);
        prescription.setCylinder(0.00f);
        prescription.setAxis(90);
        prescription.setExaminationDate(new Date()); // Use current date
        prescription.setOptometrist("Zhang Wei");
        
        // Assert that adding the prescription returns true
        assertTrue(prescription.addPrescription());
    }

    /**
     * Test valid prescription details with different data.
     */
    @Test
    public void testAddPrescription_ValidData_DifferentInput() {
        // Set another set of valid prescription data
        prescription.setFirstName("Xiao");
        prescription.setLastName("Chen");
        prescription.setAddress("456 Shanghai St, Shanghai, 200000, China");
        prescription.setSphere(-5.00f);
        prescription.setCylinder(2.00f);
        prescription.setAxis(30);
        prescription.setExaminationDate(new Date()); // Use current date
        prescription.setOptometrist("Li Ming");

        // Assert that adding the prescription returns true
        assertTrue(prescription.addPrescription());
    }

    /**
     * Test invalid first name (too short).
     */
    @Test
    public void testAddPrescription_InvalidFirstName() {
        prescription.setFirstName("W");
        prescription.setLastName("Li");
        prescription.setAddress("123 Beijing Rd, Beijing, 100000, China");
        prescription.setSphere(0.00f);
        prescription.setCylinder(0.00f);
        prescription.setAxis(90);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Zhang Wei");

        // Assert that adding the prescription returns false
        assertFalse(prescription.addPrescription());
    }

    /**
     * Test invalid last name (too short).
     */
    @Test
    public void testAddPrescription_InvalidLastName() {
        prescription.setFirstName("Wang");
        prescription.setLastName("L");
        prescription.setAddress("123 Beijing Rd, Beijing, 100000, China");
        prescription.setSphere(0.00f);
        prescription.setCylinder(0.00f);
        prescription.setAxis(90);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Zhang Wei");

        // Assert that adding the prescription returns false
        assertFalse(prescription.addPrescription());
    }

    /**
     * Test invalid address (too short).
     */
    @Test
    public void testAddPrescription_InvalidAddress() {
        prescription.setFirstName("Wang");
        prescription.setLastName("Li");
        prescription.setAddress("Short Addr");
        prescription.setSphere(0.00f);
        prescription.setCylinder(0.00f);
        prescription.setAxis(90);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Zhang Wei");

        // Assert that adding the prescription returns false
        assertFalse(prescription.addPrescription());
    }

    /**
     * Test invalid sphere value (out of range).
     */
    @Test
    public void testAddPrescription_InvalidSphere() {
        prescription.setFirstName("Wang");
        prescription.setLastName("Li");
        prescription.setAddress("123 Beijing Rd, Beijing, 100000, China");
        prescription.setSphere(21.00f); // Invalid value
        prescription.setCylinder(0.00f);
        prescription.setAxis(90);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Zhang Wei");

        // Assert that adding the prescription returns false
        assertFalse(prescription.addPrescription());
    }

    /**
     * Test invalid optometrist name (too short).
     */
    @Test
    public void testAddPrescription_InvalidOptometristName() {
        prescription.setFirstName("Wang");
        prescription.setLastName("Li");
        prescription.setAddress("123 Beijing Rd, Beijing, 100000, China");
        prescription.setSphere(0.00f);
        prescription.setCylinder(0.00f);
        prescription.setAxis(90);
        prescription.setExaminationDate(new Date());
        prescription.setOptometrist("Z"); // Invalid name

        // Assert that adding the prescription returns false
        assertFalse(prescription.addPrescription());
    }
}
