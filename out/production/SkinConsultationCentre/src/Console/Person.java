package Console;

abstract class Person implements Comparable<Person>{

    private String name;
    private String surname;
    private String date_of_birth;
    private String mobile;


    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setDOB(String dob){
        this.date_of_birth = dob;
    }

    public void setMobile(String mob){
        this.mobile = mob;
    }


    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getDOB(){
        return this.date_of_birth;
    }

    public String getMobile(){
        return this.mobile;
    }



    @Override
    public int compareTo(Person doc) {

        if(this.surname.compareTo(doc.getSurname()) == 0)
            return 0;
        else if (this.surname.compareTo(doc.getSurname()) > 0)
            return 1;
        else
            return -1;
    }
}