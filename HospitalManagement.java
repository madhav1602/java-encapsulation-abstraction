abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    abstract void calculateBill(int daysOrVisits);

    void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private static final int DAILY_CHARGE = 2000; // Fixed charge per day
    private int totalBill = 0;

    InPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    @Override
    void calculateBill(int days) {
        totalBill = days * DAILY_CHARGE;
        System.out.println("Total Bill for InPatient: ₹" + totalBill);
    }

    @Override
    public void addRecord(String record) {
        System.out.println("InPatient Record Added: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Viewing InPatient records...");
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private static final int CONSULTATION_FEE = 500; // Fixed charge per visit
    private int totalBill = 0;

    OutPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    @Override
    void calculateBill(int visits) {
        totalBill = visits * CONSULTATION_FEE;
        System.out.println("Total Bill for OutPatient: ₹" + totalBill);
    }

    @Override
    public void addRecord(String record) {
        System.out.println("OutPatient Record Added: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Viewing OutPatient records...");
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient(101, "Rakesh", 45);
        p1.getPatientDetails();
        p1.calculateBill(5); // 5 days of admission

        MedicalRecord m1 = (MedicalRecord) p1;
        m1.addRecord("Admitted for surgery");
        m1.viewRecords();

        Patient p2 = new OutPatient(102, "Madhav", 30);
        p2.getPatientDetails();
        p2.calculateBill(3); // 3 consultation visits

        MedicalRecord m2 = (MedicalRecord) p2;
        m2.addRecord("Routine checkup");
        m2.viewRecords();
    }
}
