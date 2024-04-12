
import java.util.Scanner;

public class HMS {

    public static void main(String[] args) {

        PatientList plist = new PatientList();
        DoctorList dlist = new DoctorList();
        Scanner sc = new Scanner(System.in);

        String choice;

        while (true) {
            MainMenu();
            choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("\n Doctor ID");
                String id = sc.nextLine();

                System.out.println("\n Doctor Name");
                String name = sc.nextLine();

                System.out.println("\n Doctor Contact ");
                String contact = sc.nextLine();

                System.out.println("\n Doctor Speciality");
                String speciality = sc.nextLine();

                System.out.println("\n Doctor Fees ");
                int fee = sc.nextInt();
                sc.nextLine();

                Doctor doctor = new Doctor(id, name, contact, speciality, fee);
                dlist.Insert(doctor);
            } else if (choice.equals("2")) {
                System.out.println("\n Patient ID ");
                String id = sc.nextLine();

                System.out.println("\n Patient Name ");
                String name = sc.nextLine();

                System.out.println("\n Patient Contact ");
                String contact = sc.nextLine();

                Patient patient = new Patient(id, name, contact);
                plist.Insert(patient);
            } else if (choice.equals("3")) {
                dlist.PrintData();
            } else if (choice.equals("4")) {
                plist.PrintData();
            } else if (choice.equals("5")) {
                System.out.println("\n Welcome To CheckUp Menu \n");

                CheckupList[] clist = new CheckupList[dlist.size()];
                for (int i = 0; i < clist.length; i++) {
                    clist[i] = new CheckupList();
                    Doctor doctor = dlist.getAtIndex(i);

                    System.out.println("\n\n Enter Patine for Doctor:");
                    System.out.println("Name     :"+ doctor.getName());
                    System.out.println("Speciality      :"+ doctor.getSpeciality());
                    System.out.println("Fees       :"+ doctor.getFees());

                    System.out.println("All Patients :");
                    plist.PrintData();

                    while (true) {
                        System.out.println("Enter Patients ID Or type null to stop");
                        String id = sc.nextLine();

                        if (id.equals("null")) {
                            break;
                        }

                        System.out.println("Priority 3 for Emergency 2 for Intermediate any other key for normal ");
                        String per = sc.nextLine();

                        int p = 1;

                        if (per.equals("3")) {
                            p = 3;
                        } else if (per.equals("2")) {
                            p = 2;
                        }

                        Patient patient = plist.searchByID(id);
                        if (patient == null) {
                            System.out.println("\n Invalid Patient ID : \n");
                        } else {
                            Checkup cup = new Checkup(doctor, patient, p, "", "" + java.util.Calendar.getInstance().getTime().toString());

                            clist[i].Enqueue(cup);
                        }
                    }
                }

                for(int i=0; i<clist.length; i++)
                {
                    System.out.println("\n\n Patient "+(i+1)+" In queue For Doctor "+ dlist.getAtIndex(i).getName());

                    for(int j=0; j<clist[i].size(); j++)
                    {
                        System.out.println("Enter Recommendation For Patient:"+ clist[i].getPatient(j));

                        String rec = sc.nextLine();
                        clist[i].addRecommendation(j, rec);
                    }
                }
            }
            else if(choice.equals("0"))
            {
                break;
            }
            else{
                System.out.println("\n\n Invalid Choice : \n");
            }
        }
    }

    public static void MainMenu()
    {
        System.out.println("\n\n || ***** HMS  ******      ||");
        System.out.println("        || Main Menu     ||");
        System.out.println("\nEnter 1 : For Insert New Doctor");
        System.out.println("\nEnter 2 : For Insert Patient");
        System.out.println("\nnEnter 3: For Print all Doctor  ");
        System.out.println("Enter 4: For Print all Patients");

        System.out.println("Enter 5: For CheckUp Menu");
        System.out.println("Enter 0 : For Exit");

    }
}

