package Console;

public class Consultation {

    private String booked_date;
    private String start_time;
    private String end_time;
    private double cost;
    private String notes;
    private String image_data;
    private String status;


    public void setDate(String date){
        this.booked_date = date;
    }

    public void setStartTime(String starttime){
        this.start_time = starttime;
    }

    public void setEndTime(String endtime){
        this.end_time = endtime;
    }

    public void setCost(Double cost){
        this.cost = cost;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public void setImageData(String img){
        this.image_data = img;
    }

    public void setStatus(String status){
        this.status = status;
    }


    public String getDate(){
        return this.booked_date;
    }

    public String getStartTime(){
        return this.start_time;
    }

    public String getEndTime(){
        return this.end_time;
    }

    public Double getCost(){
        return this.cost;
    }

    public String getNotes(){
        return this.notes;
    }

    public String getImageDate(){
        return this.image_data;
    }

    public String getStatus(){
        return this.status;
    }

}
