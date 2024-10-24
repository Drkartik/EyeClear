import java.util.ArrayList;
import java.util.Date;

/**
 * The Prescription class represents an eyewear prescription
 * and includes methods for adding prescription details and remarks.
 */
public class Prescription {
    // Attributes of the Prescription class
    private int presclD; // Prescription ID
    private String firstName; // Patient's first name
    private String lastName; // Patient's last name
    private String address; // Patient's address
    private float sphere; // Spherical correction value
    private float axis; // Axis value for cylinder correction
    private float cylinder; // Cylindrical correction value
    private Date examinationDate; // Date of the eye examination
    private String optometrist; // Name of the optometrist
    private String[] remarkTypes = { "Client", "Optometrist" }; // Types of remarks allowed
    private ArrayList<String> postRemarks = new ArrayList<>(); // List to store remarks for the prescription

    /**
     * Adds a prescription's information to a TXT file if it meets the specified conditions.
     * 
     * @return true if the prescription is successfully added; false otherwise.
     */
    public boolean addPrescription() {
        // Check if the prescription's information meets the specified conditions
        if (isValidPrescription()) {
            // TODO: Add the prescription's information to a TXT file (e.g., presc.txt)
            // If the operation is successful, return true
            return true;
        }
        // If conditions are not met, do not add to file and return false
        return false;
    }

    /**
     * Checks if the prescription's information is valid according to the defined conditions.
     * 
     * @return true if valid; false otherwise.
     */
    private boolean isValidPrescription() {
        // Check name length conditions
        if (firstName.length() < 4 || firstName.length() > 15 ||
            lastName.length() < 4 || lastName.length() > 15) {
            return false; // Invalid name length
        }
        // Check address length condition
        if (address.length() < 20) {
            return false; // Invalid address length
        }
        // Check value ranges for sphere, cylinder, and axis
        if (sphere < -20.00 || sphere > 20.00 ||
            cylinder < -4.00 || cylinder > 4.00 ||
            axis < 0 || axis > 180) {
            return false; // Invalid sphere, cylinder, or axis values
        }
        // Check examination date format (should be DD/MM/YY)
        if (!isValidExaminationDate()) {
            return false; // Invalid examination date
        }
        // Check optometrist name length conditions
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            return false; // Invalid optometrist name length
        }
        // All conditions are met
        return true;
    }

    /**
     * Validates the format of the examination date.
     * 
     * @return true if valid; false otherwise.
     */
    private boolean isValidExaminationDate() {
        // TODO: Implement logic to validate examination date in DD/MM/YY format
        return true; // Placeholder for date validation logic
    }

    /**
     * Adds a remark to the prescription if it meets the specified conditions.
     * 
     * @param remark The remark text to add.
     * @param type The type of the remark (Client or Optometrist).
     * @return true if the remark is successfully added; false otherwise.
     */
    public boolean addRemark(String remark, String type) {
        // Validate the remark type
        if (!isValidRemarkType(type)) {
            return false; // Invalid remark type
        }
        // Check if the remark meets the required conditions
        if (isValidRemark(remark)) {
            // Add the remark to the list of remarks
            postRemarks.add(remark);
            // TODO: Add the remark to a TXT file (e.g., remark.txt)
            return true; // Successfully added
        }
        return false; // Remark did not meet the conditions
    }

    /**
     * Checks if the remark is valid according to the defined conditions.
     * 
     * @param remark The remark text to validate.
     * @return true if valid; false otherwise.
     */
    private boolean isValidRemark(String remark) {
        // Check word count: minimum 6 words and maximum 20 words
        String[] words = remark.trim().split("\\s+");
        if (words.length < 6 || words.length > 20) {
            return false; // Invalid word count
        }
        // Check if the first character is uppercase
        if (!Character.isUpperCase(remark.charAt(0))) {
            return false; // First character is not uppercase
        }
        return true; // Remark meets all conditions
    }

    /**
     * Checks if the remark type is valid.
     * 
     * @param type The remark type to validate.
     * @return true if valid; false otherwise.
     */
    private boolean isValidRemarkType(String type) {
        // Check if the type is one of the allowed types (Client or Optometrist)
        for (String remarkType : remarkTypes) {
            if (remarkType.equalsIgnoreCase(type)) {
                return true; // Valid remark type found
            }
        }
        return false; // Invalid remark type
    }
}
