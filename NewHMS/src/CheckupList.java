
class CNode{
    Checkup cu;
    CNode next, prev;
    public CNode(Checkup cu)
    {
        next = null;
        prev = null;
        this.cu = cu;
    }
}

public class CheckupList {

    CNode head, tail;
    public CheckupList(){
        head = null;
        tail = null;
    }

    public void Enqueue(Checkup cu)
    {
        CNode node = new CNode(cu);
        if(head == null || tail == null)
        {
            head = node;
            tail = node;
        }

        else if(head.cu.getPriority() < cu.getPriority())
        {
            head.next = node;
            node.prev = head;
            head = node;
        }

        // lowest priority
        else if(tail.cu.getPriority() >= cu.getPriority())
        {
            tail.prev = node;
            node.next =tail;
            tail = node;
        }
        // if in between the highest priority node comes then it will move in forware direction
        // unless it's priority get more than least priority node
        else{
            CNode  temp = tail;
            while (temp != null)
            {
                if(temp.cu.getPriority() >= cu.getPriority())
                {
                    break;
                }
                temp = temp.next;
            }

            node.next = temp;
            node.prev = temp.prev;
            temp.prev.next = node;
            temp.prev = node;
        }
    }

    public int size()
    {
        CNode temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.prev;
        }
        return count;
    }

    public void addRecommendation(int index, String recommendation)
    {
        CNode temp = head;
        int i = 0;
        while (temp != null)
        {
            if(index == i)
            {
                temp.cu.setRecommendation(recommendation);
                break;
            }
            i++;

            temp = temp.prev;
        }
    }

    public Checkup dequeue()
    {
        if(head == null)
        {
            return null;
        }

        CNode checkup = head;
        head = head.next;
        return checkup.cu;
    }

    public Patient getPatient(int index)
    {
        CNode temp = head;
        int i=0;
        while (temp != null)
        {
            if(index == i)
            {
                break;
            }
            i++;

            temp = temp.prev;
        }
        return temp.cu.getPatient();
    }

    public void print()
    {
        CNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.cu.getPriority()+ " "+ temp.cu.getRecommendation());
            temp = temp.prev;
        }
    }


}
