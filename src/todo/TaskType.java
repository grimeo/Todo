package todo;

public interface TaskType {
    public void displayTasks();
}

class Daily extends Gui{
    
    Daily(){
        super(0);
        System.out.println("Daily Tasks display here");
    }

}

class ShortTerm extends Gui{
    ShortTerm(){
        super(0);
        System.out.println("ShortTerm Tasks display here");
    }
}

class LongTerm extends Gui{
    LongTerm(){
        super(0);
        System.out.println("LongTerm Tasks display here");
    }
}