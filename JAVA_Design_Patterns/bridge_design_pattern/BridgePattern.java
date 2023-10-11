package bridge_design_pattern;

// Abstract class TV acts as a bridge between TV types and remote control types
abstract class TV {
    Remote remote; // Reference to the remote control

    TV(Remote r) {
        this.remote = r;
    }

    abstract void on(); // Abstract method to turn the TV on
    abstract void off(); // Abstract method to turn the TV off
}

// Sony class extends TV, representing a specific TV brand
class Sony extends TV {
    Remote remoteType; // Reference to the type of remote control used with Sony TV

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Philips class extends TV, representing another specific TV brand
class Philips extends TV {
    Remote remoteType; // Reference to the type of remote control used with Philips TV

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Remote interface defines the methods to control a TV
interface Remote {
    public void on(); // Method to turn the TV on
    public void off(); // Method to turn the TV off
}

// OldRemote class implements the Remote interface for old remote controls
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

// NewRemote class implements the Remote interface for new remote controls
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Create Sony TV with an old remote
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Create Sony TV with a new remote
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Create Philips TV with an old remote
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Create Philips TV with a new remote
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
