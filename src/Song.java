import java.util.Date;
import java.util.Scanner;

public class Song {
     String songId2;
     String songName;
     String desscription;
     String singer;
     String songWriter;
     Date creteDate;
     boolean songStatus=true;
     public  Song(){
     }

    public String getSongId2() {
        return songId2;
    }

    public void setSongId(String songId2) {
        this.songId2 = songId2;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDesscription() {
        return desscription;
    }

    public void setDesscription(String desscription) {
        this.desscription = desscription;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreteDate() {
        return creteDate;
    }

    public void setCreteDate(Date creteDate) {
        this.creteDate = creteDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public Song(int songId, String songName, String desscription, String singer, String songWriter, Date creteDate, boolean songStatus) {
        this.songId2 = songId2;
        this.songName = songName;
        this.desscription = desscription;
        this.singer = singer;
        this.songWriter = songWriter;
        this.creteDate = creteDate;
        this.songStatus = songStatus;
    }
public void inputSong(Scanner scanner){
    System.out.println("Nhập mã bài hát có ít nhất 4 kí tự và bắt đầu bằng chữ S");
    this.songId2 = scanner.next();
    scanner.nextLine();
    System.out.println("Nhập tên bài hát");
    this.songName=scanner.nextLine();
    System.out.println("Mô tả bài hát");
    this.desscription=scanner.nextLine();
    System.out.println("Tên ca sỹ");
    this.singer=scanner.nextLine();
    System.out.println("Người Sáng tác ");
    this.songWriter=scanner.nextLine();
}
public void displaySong(){
    System.out.println(" Mã Bài hát là : " + songId2 +
            " Tên Bài Hát là : " + songName +
            " Mô Tả  " + desscription+
            " Tên ca sỹ " + singer +
            "Người Sáng Tác " + songWriter);
}
}
