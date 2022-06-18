package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di game Defend FILKOM !");
        System.out.print("Silakan masukkan nama player : ");
        String nama = input.nextLine();
        System.out.println("Silahkan pilih karakter yang anda inginkan : ");
        System.out.println("1. Magician\n"
                         + "2. Healer\n"
                         + "3. Warrior");
        int pilih = 0;
        try {
            pilih = input.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Tolong masukkan angka !");
            input.nextLine();
            pilih = input.nextInt();
        }
        input.nextLine();

        if (pilih != 1 && pilih != 2 && pilih != 3){
            System.out.println("Tolong masukkan angka !");
            try {
                pilih = input.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Tolong masukkan angka !");
                input.nextLine();
                pilih = input.nextInt();
            }
            input.nextLine();
        }

        ArrayList<Character> player = new ArrayList<>();

        switch (pilih) {
            case 1:
                player.add(new Magician());
                break;
            case 2:
                player.add(new Healer());
                break;
            case 3:
                player.add(new Warrior());
                break;
            default:
                break;
        }

        player.add(new Titan());

        System.out.println("Selamat datang, " + nama + " !");

        System.out.println("------------ STATUS ------------");
        info(player.get(0));

        int i = 1;
        do {
            System.out.println("============ Turn " + i + " ============");
            if (player.get(0).attack()) {
                player.get(1).receiveDamage(player.get(0).getAttack());
            }
            i++;
            System.out.printf("%-10s: %d%n", "Enemy's HP", player.get(1).getHP());
            System.out.printf("%-10s: %d%n", nama + "'s HP", player.get(0).getHP());
            if (player.get(1).getHP() == 0)
                break;

            System.out.println("============ Turn " + i + " ============");
            if (player.get(0) instanceof Healer) {
                System.out.println("Hero mendapatkan heal!");
                ((Healer) player.get(0)).heal();
            }

            if (player.get(1).attack()) {
                player.get(0).receiveDamage(player.get(1).getAttack());
            }
            System.out.printf("%-10s: %d%n", "Enemy's HP", player.get(1).getHP());
            System.out.printf("%-10s: %d%n", nama + "'s HP", player.get(0).getHP());
            i++;
        }
        while(player.get(0).getHP() != 0 && player.get(1).getHP() != 0);
        System.out.println("=================================");
        if (player.get(0).getHP() == 0)
            System.out.println(nama + " kalah");
        else
            System.out.println(nama + " menang");
        
        System.out.println();

        System.out.println("============ PLAYER =============");
        System.out.println("----------- STATUS --------------");
        info(player.get(0));
        System.out.println("============= MUSUH =============");
        System.out.println("------------ STATUS -------------");
        info(player.get(1));
    }

    static void info(Character player){
        Class role = player.getClass();
        System.out.printf("%-10s: %s%n", "Role", role.getSimpleName() );
        player.info();
    }
    
}