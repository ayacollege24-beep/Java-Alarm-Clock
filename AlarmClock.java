import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final LocalTime alarmTime;
    private final String filePath;

    AlarmClock(LocalTime alarmTime, String filePath) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;


    }

    @Override
    public void run(){

        while(LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);

                LocalTime now = LocalTime.now();

                System.out.printf("\r%02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond());
            }
            catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }

        System.out.println("\n*alarm noises*");
        Toolkit.getDefaultToolkit().beep();
        playSound(filePath);

    }

    private  void playSound(String filePath){
        File audioFile = new File(filePath);


        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();


        }
        catch(UnsupportedAudioFileException e){
            System.out.println("audio file format is not supported");
        }
        catch (LineUnavailableException e){
            System.out.println("audio is unavailable");
        }
        catch (IOException e){
            System.out.println("error reading audio file");
        }
    }
}