/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lang;

import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author jkrne
 */
public class AudioPlayer {

    AudioFormat audioFormat;
    TargetDataLine targetDataLine;
    String fileName;
    String fileToPlay;

    public void captureAudio(String fileName) {
        this.fileName = fileName;
        try {
            //Get things set up for capture
            audioFormat = getAudioFormat();
            DataLine.Info dataLineInfo
                    = new DataLine.Info(
                            TargetDataLine.class,
                            audioFormat);
            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);

      //Create a thread to capture the microphone
            // data into an audio file and start the
            // thread running.  It will run until the
            // Stop button is clicked.  This method
            // will return after starting the thread.
            new AudioPlayer.CaptureThread().start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }//end catch
    }//end captureAudio method

    public void stopRecording() {
  //Terminate the capturing of input data
        // from the microphone.
        targetDataLine.stop();
        targetDataLine.close();

    }

    public void play(String fileToPlay) {
        try {
            File file = new File(fileToPlay + ".wav");
            final Clip clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));

            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });

            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

    }
      //This method creates and returns an
    // AudioFormat object for a given set of format
    // parameters.  If these parameters don't work
    // well for you, try some of the other
    // allowable parameter values, which are shown
    // in comments following the declarations.
    private AudioFormat getAudioFormat() {
        float sampleRate = 8000.0F;
        //8000,11025,16000,22050,44100
        int sampleSizeInBits = 16;
        //8,16
        int channels = 1;
        //1,2
        boolean signed = true;
        //true,false
        boolean bigEndian = false;
        //true,false
        return new AudioFormat(sampleRate,
                sampleSizeInBits,
                channels,
                signed,
                bigEndian);
    }//end getAudioFormat
//=============================================//

    class CaptureThread extends Thread {

        public void run() {
            AudioFileFormat.Type fileType = null;
            File audioFile = null;

    //Set the file type and the file extension
      /*
             fileType = AudioFileFormat.Type.AIFC;
             audioFile = new File("junk.aifc");
    
             fileType = AudioFileFormat.Type.AIFF;
             audioFile = new File("junk.aif");
  
             fileType = AudioFileFormat.Type.AU;
             audioFile = new File("junk.au");
   
             fileType = AudioFileFormat.Type.SND;
             audioFile = new File("junk.snd");
             */
            fileType = AudioFileFormat.Type.WAVE;
            audioFile = new File(fileName + ".wav");

            try {
                targetDataLine.open(audioFormat);
                targetDataLine.start();
                AudioSystem.write(
                        new AudioInputStream(targetDataLine),
                        fileType,
                        audioFile);
            } catch (Exception e) {
                e.printStackTrace();
            }//end catch

        }//end run
    }

}
