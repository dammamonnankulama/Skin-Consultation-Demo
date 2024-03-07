package Console;

import java.util.Random;

public class Patient extends Person {

    private String patient_id;


    public Patient(){


        Random randomObj = new Random();
        int randomNum = randomObj.nextInt((9999 - 1000)) + 10;

        this.patient_id = "P" + randomNum;
    }


    public String getPatientId(){
        return this.patient_id;
    }

}
