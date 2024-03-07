package Console;

public class Doctor extends Person{

    private String medical_licence_number;
    private String specialization;


    public void setMedicalLicenceNumber(String licenceno){
        this.medical_licence_number = licenceno;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }


    public String getMedicalLicenceNumber(){
        return this.medical_licence_number;
    }

    public String getSpecialization(){
        return this.specialization;
    }

}
