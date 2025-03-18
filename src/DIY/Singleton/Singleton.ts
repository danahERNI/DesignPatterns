// Singleton.ts

class DefaultConfig {
    static readonly DEFAULT_WIDTH = 1920;
    static readonly DEFAULT_HEIGHT = 1080;
    static readonly DEFAULT_SCREENMODE = "FULLSCREEN";
    static readonly DEFAULT_BGM = 100;
    static readonly DEFAULT_SFX = 100;
}

class ConfigManager {
    private static instance: ConfigManager;

    private width: number;
    private height: number;
    private screenMode: string;
    private bgmVolume: number;
    private sfxVolume: number;

    private constructor() {
        this.resetToDefault();
    }

    public static getInstance(): ConfigManager {
        if (!ConfigManager.instance) {
            ConfigManager.instance = new ConfigManager();
        }
        return ConfigManager.instance;
    }

    public resetToDefault(): void {
        this.width = DefaultConfig.DEFAULT_WIDTH;
        this.height = DefaultConfig.DEFAULT_HEIGHT;
        this.screenMode = DefaultConfig.DEFAULT_SCREENMODE;
        this.bgmVolume = DefaultConfig.DEFAULT_BGM;
        this.sfxVolume = DefaultConfig.DEFAULT_SFX;
    }

    public printConfig(): void {
        console.log(`Resolution: ${this.width} x ${this.height}`);
        console.log(`Screen mode: ${this.screenMode}`);
        console.log(`BGM Volume: ${this.bgmVolume}`);
        console.log(`SFX Volume: ${this.sfxVolume}`);
    }

    getWidth(): number {
        return this.width;
    }

    setWidth(width: number): void {
        this.width = width;
    }

    getHeight(): number {
        return this.height;
    }

    setHeight(height: number): void {
        this.height = height;
    }

    getScreenMode(): string {
        return this.screenMode;
    }

    setScreenMode(screenMode: string): void {
        this.screenMode = screenMode;
    }

    getBgmVolume(): number {
        return this.bgmVolume;
    }

    setBgmVolume(bgmVolume: number): void {
        this.bgmVolume = bgmVolume;
    }

    getSfxVolume(): number {
        return this.sfxVolume;
    }

    setSfxVolume(sfxVolume: number): void {
        this.sfxVolume = sfxVolume;
    }
}

// main
(function main() {
    const config = ConfigManager.getInstance();
    console.log("Current settings: ");
    config.printConfig();

    // Change settings
    config.setWidth(1280);
    config.setHeight(720);
    config.setScreenMode("WINDOWED");
    config.setBgmVolume(40);
    config.setSfxVolume(23);

    console.log("\nModified settings:");
    config.printConfig();

    config.resetToDefault();
    console.log("\nDefault settings:");
    config.printConfig();
})();
