public class SystemConfig implements Cloneable {
    private String theme;
    private String language;

    public SystemConfig(String theme, String language) {
        this.theme = theme;
        this.language = language;
    }

    public void setTheme(String theme) { this.theme = theme; }
    public void setLanguage(String language) { this.language = language; }

    @Override
    public SystemConfig clone() {
        try {
            return (SystemConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void displayConfig(String name) {
        System.out.println("Cấu hình " + name + ": [Theme: " + theme + ", Language: " + language + "]");
    }
}
