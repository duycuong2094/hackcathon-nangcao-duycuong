import java.util.Scanner;

public class Singer {
   private int sigerId;
     String singerName;
    int age;
    String natitionlity;
    boolean gerder;
    String genre;
    private static int idSinger=1;
    public Singer(){
    this.sigerId=idSinger++;
    }

    public Singer(int sigerId, String singerName, int age, String natitionlity, boolean gerder, String genre) {
        this.sigerId = sigerId;
        this.singerName = singerName;
        this.age = age;
        this.natitionlity = natitionlity;
        this.gerder = gerder;
        this.genre = genre;
    };

    public int getSigerId() {
        return sigerId;
    }

    public void setSigerId(int sigerId) {
        this.sigerId = sigerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNatitionlity() {
        return natitionlity;
    }

    public void setNatitionlity(String natitionlity) {
        this.natitionlity = natitionlity;
    }

    public boolean isGerder() {
        return gerder;
    }

    public void setGerder(boolean gerder) {
        this.gerder = gerder;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void displaySinger(){
        System.out.println(" Mã số " + sigerId +
                " Tên ca sỹ : " + singerName +
                " nationlity " + natitionlity+
                 " gender " + gerder +
                " genre " + genre);

    }
    public void inputSinger(Scanner scanner){
        System.out.println("Nhập tên ca sỹ");
        this.singerName=scanner.nextLine();
        System.out.println("Nhập Tuổi");
        this.age=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập quốc tịch");
        this.natitionlity=scanner.nextLine();
        System.out.println("Nhập giới tính ");
        this.gerder=Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập thể loại");
        this.genre=scanner.nextLine();

    }
}
