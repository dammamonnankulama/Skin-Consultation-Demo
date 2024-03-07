package Console;

import java.sql.ResultSet;

public interface SkinConsultationManager {

    public void AddDoctor(Doctor doctor);
    public String DeleteDoctor(String med_licence_no);
    public Boolean SaveToFile(String filename);
    public String PrintDoctorsList();

    public ResultSet CheckAvailability(String licno, String date);
    public Boolean AddPatient(Patient patient);
    public Boolean AddConsultation(String doc_id, String p_id, Consultation consult);
    public Boolean CancelConsultation(int booking_id);
    public ResultSet ViewConsultation(String status);

}
