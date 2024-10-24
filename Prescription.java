import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Prescription {
    private int presclD;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private String[] remarkTypes = {"Client", "Optometrist"};
    private ArrayList<String> postRemarks = new ArrayList<>();

    public boolean addPrescription(String firstName, String lastName, String address,
                                   float sphere, float cylinder, float axis,
                                   Date examinationDate, String optometrist) {
        // Validate input
        if (!isValidName(firstName) || !isValidName(lastName) || !isValidAddress(address) ||
            !isValidSphere(sphere) || !isValidCylinder(cylinder) || !isValidAxis(axis) ||
            !isValidDate(examinationDate) || !isValidOptometrist(optometrist)) {
            return false;
        }

        // If all validations pass, write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", true))) {
            writer.write(firstName + "," + lastName + "," + address + "," +
                         sphere + "," + cylinder + "," + axis + "," +
                         examinationDate + "," + optometrist);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addRemark(String remark, String category) {
        // Validate input
        if (!isValidRemark(remark) || !isValidCategory(category) || postRemarks.size() >= 2) {
            return false;
        }

        // If valid, add the remark
        postRemarks.add(remark);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
            writer.write(category + ": " + remark);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isValidName(String name) {
        return name.length() >= 4 && name.length() <= 15;
    }

    private boolean isValidAddress(String address) {
        return address.length() >= 20;
    }

    private boolean isValidSphere(float sphere) {
        return sphere >= -20.00 && sphere <= 20.00;
    }

    private boolean isValidCylinder(float cylinder) {
        return cylinder >= -4.00 && cylinder <= 4.00;
    }

    private boolean isValidAxis(float axis) {
        return axis >= 0 && axis <= 180;
    }

    private boolean isValidDate(Date date) {
        // Simplified validation for the purpose of this assignment
        return date != null;
    }

    private boolean isValidOptometrist(String optometrist) {
        return optometrist.length() >= 8 && optometrist.length() <= 25;
    }

    private boolean isValidRemark(String remark) {
        String[] words = remark.split(" ");
        return words.length >= 6 && words.length <= 20 && Character.isUpperCase(remark.charAt(0));
    }

    private boolean isValidCategory(String category) {
        for (String type : remarkTypes) {
            if (type.equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
}