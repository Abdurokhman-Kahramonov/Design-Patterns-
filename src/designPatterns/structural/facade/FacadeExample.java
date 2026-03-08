package designPatterns.structural.facade;

public class FacadeExample {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Light(),
                new Seats(),
                new Projector(),
                new SoundSystem()
        );
        homeTheater.watchMovie("Star Wars");
    }
}

class Light{
    public void changeLightVolume(int volume){
        System.out.println("Changing light volume to " + volume);
    }
}

class Seats{
    public void cleanSeats(){
        System.out.println("Cleaning seats");
    }
}
class Projector{
    public void turnOnProjector(){
        System.out.println("Turning on projector");
    }
    public void chooseMovie(String movie){
        System.out.println("Choosing movie: " + movie);
    }
}
class SoundSystem{
    public void turnOnSoundSystem(){
        System.out.println("Turning on sound system");
    }
    public void setVolume(int volume){
        System.out.println("Setting sound system volume to " + volume);
    }
}

class HomeTheaterFacade{
    private Light light;
    private Seats seats;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(Light light, Seats seats, Projector projector, SoundSystem soundSystem) {
        this.light = light;
        this.seats = seats;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie){
        light.changeLightVolume(4);
        seats.cleanSeats();
        projector.turnOnProjector();
        projector.chooseMovie(movie);
        soundSystem.turnOnSoundSystem();
        soundSystem.setVolume(5);
        System.out.println("Enjoy your movie!");
    }

}
