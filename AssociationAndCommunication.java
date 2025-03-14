import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void listDoctors() {
        System.out.println(name + " is consulting with:");
        for (Doctor doctor : doctors) {
            System.out.println(" - Dr. " + doctor.getName());
        }
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // Ensure bidirectional relationship
        }
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting with " + patient.getName());
    }

    public void listPatients() {
        System.out.println("Dr. " + name + " is treating:");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getName());
        }
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void listDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor doctor : doctors) {
            System.out.println(" - Dr. " + doctor.getName());
        }
    }

    public void listPatients() {
        System.out.println("Patients at " + name + ":");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getName());
        }
    }
}

public class AssociationAndCommunication {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor drRia = new Doctor("Ria");
        Doctor drPia = new Doctor("Pia");

        Patient R = new Patient("R");
        Patient P = new Patient("P");

        hospital.addDoctor(drRia);
        hospital.addDoctor(drPia);
        hospital.addPatient(R);
        hospital.addPatient(P);

        drRia.addPatient(R);
        drRia.addPatient(P);
        drPia.addPatient(R);

        // Consultations
        drRia.consult(R);
        drPia.consult(R);
        drRia.consult(P);

        // List doctors and patients
        hospital.listDoctors();
        hospital.listPatients();

        drRia.listPatients();
        drPia.listPatients();

        R.listDoctors();
        P.listDoctors();
    }
}