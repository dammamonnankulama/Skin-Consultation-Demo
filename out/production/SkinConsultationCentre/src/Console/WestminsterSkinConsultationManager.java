package Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {


    public ArrayList<Doctor> doctors;

    protected final String doctorFilePath = "./DOCTORS.txt";


    public WestminsterSkinConsultationManager(){


        doctors = new ArrayList<Doctor>();


        ReadFromFile(doctorFilePath);
    }


    public void AddDoctor(Doctor doctor){


        if(doctors.size()<10) {
            doctors.add(doctor);
        }else{
            System.out.println("maximum number of doctors has been added to the centre ");
        }


    }


    public String DeleteDoctor(String med_licence_no){

        String info="";


        for(Doctor d: doctors){
            if(d.getMedicalLicenceNumber().compareTo(med_licence_no) == 0){
                doctors.remove(d);
                SaveToFile(doctorFilePath);
                info = d.getName() + " " + d.getSurname() + " (Lic No:" + d.getMedicalLicenceNumber() + ") deleted.\nRemaning count :" + doctors.size();
                break;
            }
        }
        return info;
    }


    public Boolean SaveToFile(String filename){

        Boolean isSavedSucessfully = false;
        try{
            FileWriter file = new FileWriter(filename);
            file.write(DoctorsList());
            file.close();
            isSavedSucessfully = true;

        } catch (Exception e) {
            System.out.println(e);
        }

        return isSavedSucessfully;
    }


    public String PrintDoctorsList(){

        String docList="";


        Collections.sort(doctors);

        for(Doctor d: doctors){
            docList = docList + d.getName() + " " +
                    d.getSurname() + " - " +
                    d.getDOB() + " - " +
                    d.getMobile() + " - " +
                    d.getMedicalLicenceNumber()+ " - " +
                    d.getSpecialization() + "\n";
        }
        return docList;
    }


    private String DoctorsList(){

        String docList="";

        for(Doctor d: doctors){
            docList = docList + d.getName() + "|" +
                    d.getSurname() + "|" +
                    d.getDOB() + "|" +
                    d.getMobile() + "|" +
                    d.getMedicalLicenceNumber()+ "|" +
                    d.getSpecialization() + "\n";
        }
        return docList;
    }


    private void ReadFromFile(String filename){

        File file = new File(filename);

        if(file.exists()){
            Scanner sc = null;
            try {
                sc = new Scanner(file);


                while(sc.hasNextLine()){

                    Scanner sc1 = new Scanner(sc.nextLine());
                    sc1.useDelimiter("[|]");

                    Doctor doc = new Doctor();


                    while(sc1.hasNext()){


                        doc.setName(sc1.next());
                        doc.setSurname(sc1.next());
                        doc.setDOB(sc1.next());
                        doc.setMobile(sc1.next());
                        doc.setMedicalLicenceNumber(sc1.next());
                        doc.setSpecialization(sc1.next());

                        AddDoctor(doc);
                    }

                    sc1.close();
                }

            } catch (Exception exp) {
                exp.printStackTrace();
            }

            sc.close();
        }
    }



    public ResultSet CheckAvailability(String lic_no, String date){

        String sql = "";

        if((lic_no.isEmpty())&&(!date.isEmpty()))
            sql = "SELECT * FROM `availability` WHERE date='" + date + "'" ;
        else if((date.isEmpty())&&(!lic_no.isEmpty()))
            sql = "SELECT * FROM `availability` WHERE lic_no='" + lic_no + "'" ;
        else if((lic_no.isEmpty()) && (date.isEmpty()))
            sql = "SELECT * FROM `availability`";
        else
            sql = "SELECT * FROM `availability` WHERE lic_no='" + lic_no + "' AND date='" + date + "'" ;

        SQLCon sc= new SQLCon();
        ResultSet rs =  sc.GetData(sql);

        return rs;
    }


    public Boolean AddPatient(Patient patient){

        Boolean isAdded = false;

        try{

            String sql = "INSERT INTO `patients`(`name`, `surname`, `dob`, `mobile`, `pid`) VALUES ('"
                    + patient.getName() + "','" + patient.getSurname() + "','" + patient.getDOB() + "','"
                    + patient.getMobile() + "','" + patient.getPatientId() + "')";

            SQLCon sc= new SQLCon();
            if(sc.UpdateData(sql)) isAdded=true;

        }catch(Exception e){
            System.out.println(e);
        }

        return isAdded;
    }


    public Boolean AddConsultation(String doc_id, String p_id, Consultation consult){

        Boolean isAdded = false;

        try{
            String sql = "INSERT INTO `consultation`(`patient_id`, `doctor_id`, `booked_date`, `start_time`, `end_time`, `cost`, `notes`, `image_data`, `status`) " +
                    "VALUES ('" + p_id + "','" + doc_id + "','" + consult.getDate() + "','" + consult.getStartTime() + "','"
                    + consult.getEndTime() + "','" + consult.getCost() + "','" + consult.getNotes() + "','"
                    + consult.getImageDate() + "','" + consult.getStatus() + "')";

            SQLCon sc= new SQLCon();
            if(sc.UpdateData(sql)) isAdded=true;

        }catch(Exception e){
            System.out.println(e);
        }

        return isAdded;

    }


    public Boolean CancelConsultation(int booking_id){

        Boolean isUpdated = false;

        try{
            String sql = "UPDATE `consultation` SET `status`= 'C' WHERE booking_id = '" + booking_id + "'";

            SQLCon sc= new SQLCon();
            if(sc.UpdateData(sql)) isUpdated=true;

        }catch(Exception e){
            System.out.println(e);
        }
        return isUpdated;
    }



    public ResultSet ViewConsultation(String status){

        ResultSet rs=null;

        try{
            String sql = "SELECT * FROM `consultation` WHERE status='" + status +"'";

            SQLCon sc= new SQLCon();
            rs =  sc.GetData(sql);

        }catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }


    public double CalculateCost(String patientId){

        int cost=15;

        try{
            String sql = "SELECT * FROM consultation WHERE patient_id = '" + patientId +"'";

            SQLCon sc= new SQLCon();
            ResultSet rs = sc.GetData(sql);

            //if petient exist
            if(rs.next())
                cost = 25;

        }catch(Exception e){
            System.out.println(e);
        }

        return cost;
    }


    public String AutoAssignDoctor(ArrayList<String> rs){

        int i = 0;
        String row_data = "";
        int row_count = rs.size();


        Random random = new Random();
        int size = random.nextInt(row_count);


        for(String row: rs){
            if(size==i){
                row_data = row;
                break;
            }else{
                i = i +1;
            }
        }

        return row_data;

    }


    public ResultSet GetPatientData() {

        ResultSet rs = null;
        String sql = "SELECT * FROM `patients`";

        try {
            SQLCon sc = new SQLCon();
            rs = sc.GetData(sql);

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

}
