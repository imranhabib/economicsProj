package project;

/**
 * Created by ihabib on 1/22/2015.
 */
public class directoryStore {

    static String directory;
    static String adminDirectory;

    public directoryStore(){
        this.getDirectory();
    }

    public directoryStore(String dir){
        this.directory = dir;
    }


    public String getDirectory(){
        return directory;
    }


    public String getAdminDirectory(){
        return adminDirectory;
    }

    public void setDirectory(String dir){
        directory = dir;
    }

    public void setAdminDirectory(String dir){
        adminDirectory = dir;
    }


















}
