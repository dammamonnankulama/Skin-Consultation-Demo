package Console;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws SQLException {

        WestminsterSkinConsultationManager wm = new WestminsterSkinConsultationManager();

        while (true) {


            DisplayMainMenu();

            Scanner value = new Scanner(System.in);
            System.out.println("Enter options 1 to 6: ");

            try{
                switch (value.nextInt()) {



                    case 1:
                        Doctor doctor = new Doctor();

                        System.out.println("Enter First Name: ");
                        doctor.setName(new Scanner(System.in).next());


                        System.out.println("Enter Surname: ");
                        doctor.setSurname(new Scanner(System.in).next());

                        System.out.println("Enter Medical Licence No: ");
                        doctor.setMedicalLicenceNumber(new Scanner(System.in).next());

                        System.out.println("Date of Birth (yyyy-mm-dd): ");
                        doctor.setDOB(new Scanner(System.in).next());

                        System.out.println("Mobile No: ");
                        doctor.setMobile(new Scanner(System.in).next());

                        System.out.println("Specialization (Cosmetic/Medical/Pediatric dermatology): ");
                        doctor.setSpecialization(new Scanner(System.in).nextLine());

                        wm.AddDoctor(doctor);
                        System.out.println("///////////// Console.Doctor is added successfully /////////////");
                        break;

                    case 2:
                        System.out.println(wm.PrintDoctorsList());

                        System.out.println("Enter Medical Licence No: ");
                        System.out.println("Console.Doctor " + wm.DeleteDoctor(new Scanner(System.in).nextLine()) );
                        break;

                    case 3:
                        System.out.println(wm.PrintDoctorsList());
                        break;

                    case 4:
                        if(wm.SaveToFile(wm.doctorFilePath)) System.out.println("///////////// Saved to the file sucessfully /////////////");
                        break;

                    case 5:
                        new LoadingPage();
                        break;

                    case 6:
                        System.exit(0);

                    default:
                        System.out.println("///////////// Option not found, please re-enter /////////////");
                        break;
                }
            }catch (InputMismatchException ex){
                System.out.println("Please Enter A valid Number!");
            }

        }

    }


    static void DisplayMainMenu() {
        System.out.println("\n");
        System.out.println("---------------------------------");
        System.out.println("     Consultants Manager			");
        System.out.println("---------------------------------");
        System.out.println("1. Add a new doctor");
        System.out.println("2. Delete a doctor");
        System.out.println("3. Print the list of the doctors");
        System.out.println("4. Save in a file");
        System.out.println("5. Console.GUI");
        System.out.println("6. Exit");

        System.out.println("\n");
    }

}
