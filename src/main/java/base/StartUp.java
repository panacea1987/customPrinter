package base;

<<<<<<< HEAD
import base.controller.Controller;
=======
import base.controller.PrintController;
>>>>>>> 3 commit
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartUp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
        System.out.println("Welcome to custom printer service!");
        System.out.println("input \"add\" for add new file in printing queue");
        System.out.println("input \"stop\" for stopping print queue");
        System.out.println("input \"rem\" for cancel print one file by his name");
        System.out.println("input \"view\" for show printed files");
        System.out.println("input \"stat\" for show printed time");
<<<<<<< HEAD
        ctx.getBean(Controller.class).getInputCommand();
=======
        ctx.getBean(PrintController.class).getInputCommand();
>>>>>>> 3 commit

    }
}
