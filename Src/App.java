// Bootstrap of the project, contains the main method
public class App {

    public static void main(String []args) {
        App app = new App();
    }
    public App(){
        // Create the MVC Model
        // Declare the three parts of the MVC paradigm
        Model model = new Model();
        // Create the MVC Controller
        Controller controller = new Controller(model);
        // Create the MVC View
        View view = new View("CarSim 1.0", model, controller);

        // Start the animation
        model.startTimer();
    }
}