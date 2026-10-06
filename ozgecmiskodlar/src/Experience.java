public class Experience {
    private String companyName;
    private String position;
    private String duration;
    private String description;

    public Experience(String companyName, String position, String duration, String description) {
        this.companyName = companyName;
        this.position = position;
        this.duration = duration;
        this.description = description;
    }

    public String getCompanyName() { return companyName; }
    public String getPosition() { return position; }
    public String getDuration() { return duration; }
    public String getDescription() { return description; }
}
