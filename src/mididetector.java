import javax.sound.midi.*;


public class mididetector {

   public void detectDevice() {

        MidiDevice.Info[] DeviceInformation = MidiSystem.getMidiDeviceInfo();

        if(DeviceInformation.length == 0) {

            System.out.println("No Midi Devices Connected. Please disconnect your Midi Cable and Try again");
        }
            else {

            System.out.println("Your Device is Connected!. Here's the details of your device:");
        }

            for(MidiDevice.Info information: DeviceInformation){

                try{
                    MidiDevice Device = MidiSystem.getMidiDevice(information);

                    System.out.println("Name:" + information.getName());
                    System.out.println("Vendor:" + information.getVendor());
                    System.out.println("Version:" + information.getVersion());
                    System.out.println("Description:" + information.getDescription());
                    System.out.println("Device:" + Device.toString());
                    System.out.println("------");
                }
                catch (MidiUnavailableException e){
                    e.printStackTrace();
                }
            }

        }
        public static void main(String[] args){
            mididetector detector = new mididetector();
            detector.detectDevice();

    }

}
