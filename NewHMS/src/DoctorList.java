
class DNode {

    Doctor doctor;
    DNode next, prev;

    public DNode(){

    }
    public DNode(Doctor doctor) {
        this.doctor = doctor;
        next = null;
        prev = null;
    }
}

public class DoctorList {

    DNode head, tail;
    public DoctorList()
    {
        head = null;
        tail = null;
    }

    public void Insert(Doctor doctor)
    {
        DNode node = new DNode(doctor);

        if(head == null || tail == null)
        {
            head = node;
            tail = node;
        }

        else{
            head.next = node;
            node.prev = head;
            head = node;
        }
    }

    public Doctor searchByID(String id)
    {
        DNode temp = head;
        while (temp != null)
        {
            if(temp.doctor.getId().equals(id)){
                return temp.doctor;
            }
            temp = temp.prev;
        }
        return null;
    }

    public Doctor searchByContact(String Contact)
    {
        DNode temp = head;
        while (temp != null)
        {
            if(temp.doctor.getContact().equals(Contact)){
                return temp.doctor;
            }
            temp = temp.prev;
        }
        return null;
    }

    public int size()
    {
        DNode temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.prev;
        }
        return count;
    }


    public void AllDoctorInfo()
    {
        DNode temp = head;
        while (temp != null)
        {
            System.out.println("Doctor Id " + temp.doctor.getId() + " "+ "Speciality "+ temp.doctor.getSpeciality());
            temp = temp.prev;
        }
    }

    public Doctor getAtIndex(int index)
    {
        DNode temp = head;
        for(int i=0; i<index; i++)
        {
            temp = temp.prev;
        }
        return temp.doctor;
    }

    public void PrintData()
    {
        DNode temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            System.out.println(count+": "+temp.doctor.toString());
            temp = temp.prev;
        }

    }
}
