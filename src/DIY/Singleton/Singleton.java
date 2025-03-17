package DIY.Singleton;

public class Singleton {
    public static void main(String[] args) {
        ConfigManager config = ConfigManager.getInstance();
        System.out.println("Current settings: ");
        config.printConfig();

        //change settings
        config.setWidth(1280);
        config.setHeight(720);
        config.setScreenMode("WINDOWED");
        config.setBgmVolume(40);
        config.setSfxVolume(23);

        System.out.println("\nModified settings:");
        config.printConfig();

        config.resetToDefault();
        System.out.println("\nDefault settings:");
        config.printConfig();

    }

}

class ConfigManager{

    private static ConfigManager instance;

    private int width;
    private int height;
    private String screenMode;
    private int bgmVolume;
    private int sfxVolume;
    
    private ConfigManager(){
        resetToDefault();
    }
    
    public static ConfigManager getInstance() {
        if (instance == null){
            instance = new ConfigManager();
        }
        return instance;
    }

    public void resetToDefault(){

        width = DefaultConfig.DEFAULT_WIDTH;
        height = DefaultConfig.DEFAULT_HEIGHT;
        screenMode = DefaultConfig.DEFAULT_SCREENMODE;
        bgmVolume = DefaultConfig.DEFAULT_BGM;
        sfxVolume = DefaultConfig.DEFAULT_SFX;

    }
    public void printConfig(){
        System.out.println("Resolution: " + width + " x " + height);
        System.out.println("Screen mode: " + screenMode);
        System.out.println("BGM Volume: " + bgmVolume);
        System.out.println("SFX Volume: " + sfxVolume);
        
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public String getScreenMode() {
        return screenMode;
    }

    public void setScreenMode(String screenMode) {
        this.screenMode = screenMode;
    }

    public int getBgmVolume() {
        return bgmVolume;
    }

    public void setBgmVolume(int bgmVolume) {
        this.bgmVolume = bgmVolume;
    }

    public int getSfxVolume() {
        return sfxVolume;
    }

    public void setSfxVolume(int sfxVolume) {
        this.sfxVolume = sfxVolume;
    }

}

class DefaultConfig{

    public static final int DEFAULT_WIDTH = 1920;
    public static final int DEFAULT_HEIGHT = 1080;
    public static final String DEFAULT_SCREENMODE = "FULLSCREEN";
    public static final int DEFAULT_BGM = 100;
    public static final int DEFAULT_SFX = 100;

}