
import javax.print.Doc;

public class Checkup {
    Doctor Doctor;
    Patient Patient;
    int Priority;
    String Recommendation, Date;

    public Checkup(Doctor Doctor, Patient Patient, int Priority, String Recommendation, String Date)
    {
        this.Doctor = Doctor;
        this.Patient = Patient;
        this.Priority = Priority;
        this.Recommendation = Recommendation;
        this.Date = Date;
    }

    public Doctor getDoctor()
    {
        return Doctor;
    }
    public void setDoctor(Doctor Doctor){
        this.Doctor = Doctor;
    }

    public Patient getPatient(){
        return Patient;
    }
    public void setPatient(Patient Patient)
    {
        this.Patient = Patient;
    }
    public  int getPriority()
    {
        return Priority;
    }

    public void setPriority(int Priority)
    {
        this.Priority = Priority;
    }

    public String getRecommendation()
    {
        return Recommendation;
    }
    public void setRecommendation(String Recommendation)
    {
        this.Recommendation = Recommendation;
    }

    public String getDate()
    {
        return Date;
    }
    public void setDate(String Date)
    {
        this.Date = Date;
    }

    @Override
    public String toString(){
        return "Checkup (" + "Doctor = "+ Doctor.toString() + ", Patient = "+ Patient.toString() + " Priority = "+ Priority + "Recommendation = "+ Recommendation + "Date = "+ Date + ")";
    }
}
