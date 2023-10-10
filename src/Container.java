import java.util.Scanner;

public class Container {
    static Scanner scanner = new Scanner(System.in);
    static int idSinger = 0;
    static int idSong = 0;
    static Singer[] singers = new Singer[100];
    static Song[] songs = new Song[100];

    public static void main(String[] args) {
        while (true) {
            System.out.println("Nhập số từ 1 - 3 để thực hiện : ");
            System.out.println("1 . Quản Lý ca sĩ");
            System.out.println("2 . Quản lý bài hát ");
            System.out.println("3 . Tìm kiếm bài hát ");
            System.out.println("Nhập khác từ 1-4 để thoát ");
            int input = scanner.nextInt();
            handle(input);
        }
    }

    private static void handle(int input) {
        switch (input) {
            case 1:
                managerSinger();
                break;
            case 2:
                managerSong();
                break;
            case 3:
                seachSong();
                break;
            default:
                System.exit(0);
        }
    }

    private static void seachSong() {
        System.out.println("Nhập tên bài hát muốn tìm kiếm ");
        String seachSong=scanner.nextLine();
        for(int i = 0 ;i<idSong;i++){
            if(songs[i].songName.equals(seachSong)){
                songs[i].displaySong();
            }
        }
    }

    private static void managerSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhâp từ 1-4 để thực hiện thao tác");
        System.out.println(" 1 . Nhập bài hát cần thêm");
        System.out.println(" 2 . Hiển thị tất cả bài hát đã lưu trữ");
        System.out.println(" 3 . Thay đổi bài hát theo mã id");
        System.out.println(" 4 . Xóa bài hát theo mã id");
        int inputSong = Integer.parseInt(scanner.nextLine());
        handleSong(inputSong);
    }

    private static void handleSong(int inputSong) {
        switch (inputSong) {
            case 1:
                addSong();
                break;
            case 2:
                renderSong();
                break;
            case 3:
                updateSong();
                break;
            case 4:
                deleSong();
                break;
            default:

        }
    }

    private static void deleSong() {
        System.out.println("Nhập mã bài hát muốn xóa");
        String deleSong=scanner.nextLine();
        for(int i = 0 ;i<idSong;i++){
            if (songs[i].getSongId2().equals(deleSong)){
                for (int j= i;j<idSong;j++){
                    songs[j]=songs[j++];
                    idSong--;
                    System.out.println("Xóa thành công");
                }
            }
        }
    }

    private static void updateSong() {
        System.out.println("Nhập mã bài hát muốn sửa");
        String updateSong=scanner.nextLine();
        for (int i = 0 ; i<idSong;i++){
            if(songs[i].songId2.equals(updateSong)){
                System.out.println("Bài hát muốn sửa là");
                songs[i].displaySong();
                songs[i].inputSong(scanner);
                System.out.println("Đã cập nhập thành công");
            }
        }
    }

    private static void renderSong() {
        System.out.println("Danh sách bài hát là");
        System.out.println(idSong);
        for (int i = 0 ; i< idSong;i++){
            songs[i].displaySong();
        }
    }

    private static void addSong() {
        if (idSong < songs.length) {
            Song song = new Song();
            boolean checkSong = true;
            song.inputSong(scanner);

            if (!song.songId2.startsWith("S") || song.songId2.length() < 4) {
                checkSong = false;
                System.out.println("Mã phải bắt đầu bằng chữ 'S' và có ít nhất 4 ký tự.");
            }
            if (song.songName.length() == 0) {
                System.out.println("Không được để tên bài hát trống.");
                checkSong = false;
            }
            if (song.singer.length() == 0) {
                System.out.println("Tên ca sỹ không được để trống.");
                checkSong = false;
            }
            if (song.songWriter.length() == 0) {
                System.out.println("Người sáng tác không được để trống.");
                checkSong = false;
            }

            if (checkSong) {
                songs[idSong++] = song;
                System.out.println("Thêm bài hát thành công.");
            } else {
                System.out.println("Thêm bài hát không thành công.");
            }
        } else {
            System.out.println("Danh sách bài hát đã đầy. Không thể thêm bài hát mới.");
        }
    }


    private static void managerSinger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập từ 1 - 3 để thực hiện thao tác :  ");
        System.out.println("1 .  Thêm ca sĩ");
        System.out.println("2 . Hiển thị danh sách ca sĩ");
        System.out.println("3 . Xóa ca sỹ theo mã id");
        int inputSinger = scanner.nextInt();
        switch (inputSinger) {
            case 1:
                addSinger();
                break;
            case 2:
                renderSinger();
                break;
            case 3:
                deleteSinger();
                break;
        }
    }

    private static void deleteSinger() {
        System.out.println("Nhập id ca sỹ muốn xóa");
        int idDele = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < idSinger; i++) {
            if (idDele == singers[i].getSigerId()) {
                // Kiểm tra xem ca sĩ có bài hát không
                boolean hasSong = false;
                for (int j = 0; j < idSong; j++) {
                    if (singers[i].getSingerName().equals(songs[j].getSinger())) {
                        hasSong = true;
                        break;
                    }
                }

                if (!hasSong) {
                    found = true;
                    for (int j = i; j < idSinger - 1; j++) {
                        singers[j] = singers[j + 1];
                    }
                    idSinger--;
                    System.out.println("Xóa thành công.");
                    break;  // Dừng vòng lặp sau khi xóa.
                } else {
                    System.out.println("Ca sĩ có bài hát không thể xóa.");
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy id muốn xóa.");
        }
    }







    private static void addSinger() {
        Scanner scanner = new Scanner(System.in);
        Singer singer = new Singer();
        singer.inputSinger(scanner);

        if (idSinger < singers.length) {
            boolean checkSinger = true;
            if (singer.singerName.length() == 0) {
                System.out.println("Không được để trống tên");
                checkSinger = false;
            }
            if (singer.age <= 0) {
                System.out.println("Tuổi phải lớn hơn 0");
                checkSinger = false;
            }
            if (singer.natitionlity.length() == 0) {
                System.out.println("Quốc Tịch không được để trống");
                checkSinger = false;
            }
            if (checkSinger) {
                singers[idSinger++] = singer;
                System.out.println("Thêm ca sĩ thành công.");
            } else {
                System.out.println("Thêm ca sĩ không thành công.");
            }
        } else {
            System.out.println("Danh sách ca sĩ đã đầy. Không thể thêm ca sĩ mới.");
        }
    }

    private static void renderSinger() {
        for (int i = 0; i < idSinger; i++) {
            singers[i].displaySinger();
        }
    }
}
