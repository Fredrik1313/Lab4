```puml
@startuml
class App{
  Model model
  View view
  Controller controller
  
  + main(String []args): void
  + App()
}

class Model {
- ArrayList<AnimatedVehicle> vehicles
+ getVehicles()
+ gasAll(double amount): void
+ brakeAll(double amount): void
~ stopAll(): void
~ startAll(): void
~ turboOffAll(): void
~ turboOnAll(): void
~ liftBedAll(): void
~ lowerBedAll(): void
+ moveAll(): void
}

class View{
- int x
- int y
  Model model
  Controller controller;
  DrawPanel drawPanel;

+ View(String frameName, Model model, Controller controller)
+ initComponents(String title): void
+ reDraw(): void
}

class Controller{
    Model model
    View view
    - int delay
    
    - Timer(delay, new TimerListener())
    + Controller(Model model)
    + setView(View view): void
    + startTimer(): void
    ~ gasAll(): void
    ~ brakeAll(): void
    ~ stopAll(): void
    ~ startAll(): void
    ~ turboOffAll(): void
    ~ turboOnAll(): void
    ~ liftBedAll(): void
    ~ lowerBedAll(): void
}
class JFrame{}
class JPanel{}
class ArrayList{}
class Point2D{}
class Swing{}
class image{}

class DrawPanel{
 Model model
 + DrawPanel(int x, int y, Model model)
 # paintComponent(Graphics g): void
}

class AnimatedVehicle{
 - MotorVehicle vehicle
 - BufferedImage image
 + AnimatedVehicle(MotorVehicle vehicle, String imgFileName)
 + getVehicle()
 + draw(DrawPanel panel, Graphics g): void
}

abstract class MotorVehicle{
 ~ double enginePower
 ~ double currentSpeed
 ~ String modelName
 ~ double x
 ~ double y
 ~ double direction
 + boolean goingBack
 + getEnginePower()
 + getCurrentSpeed()
 + getPosition
 + startEngine(): void
 + setGoingBack()
 ~ limitTo(double value, double min, double max)
 ~ incrementSpeed(double amount): void
 ~ negativeIncrementSpeed(double amount): void 
 + MotorVehicle(Point2D.Double position)
 ~ decrementSpeed(double amount): void
 ~ negativeDecrementSpeed(double amount): void
 + gas(double amount): void
 + brake(double amount): void
 + stopEngine(): void
 + move(): void
} 
abstract class Truck {
 + Truck(Point2D.Double position)
}

abstract class Car{
 + Car(Point2D.Double position)
}

interface Movable{
move(): void
}

class Volvo240{
- double trimFactor
+ Volvo240(Point2D.Double position)
+ speedFactor()
}

class Scania {
+ double bedAngle
+ Scania(Point2D.Double position)
+ lowerBed(double angle): void
+ raiseBed(double angle)
+ speedFactor()
+ startEngine(): void
}

class Saab95 {
- boolean turboOn
+ setTurboOn(): void
+ setTurboOff(): void
+ Saab95(Point2D.Double position)
+ speedFactor()
}


Movable <|... MotorVehicle
AnimatedVehicle <--- MotorVehicle
Model <--- AnimatedVehicle
image <---  AnimatedVehicle

DrawPanel <--- AnimatedVehicle

Point2D <--- Model
Point2D <--- AnimatedVehicle
Point2D <--- MotorVehicle
Point2D <--- Truck
Point2D <--- Car
Point2D <--- Scania 
Point2D <--- Volvo240
Point2D <--- Saab95


View <--- DrawPanel
Model <--- View
Model <--- Controller
Controller <--- View
App <--- Controller
JPanel <|--- DrawPanel
JFrame <|--- View
ArrayList <--- Model
Swing <--- View
Swing <--- DrawPanel

@enduml