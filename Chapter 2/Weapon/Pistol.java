package Weapon;

public class Pistol extends Weapon {
    private final int maxBullets;

    public Pistol(int maxBullets) {
        this(0, maxBullets);
    }

    public Pistol(int ammo, int maxBullets){
        super(ammo);
        if (maxBullets < 0) throw new IllegalArgumentException();
        this.maxBullets = maxBullets;
    }

    public int unload(){
        int bulletsToUnload = ammo();
        for (int i = 0; i < bulletsToUnload; i++){
            getAmmo();
        }
        return bulletsToUnload;
    }

    public void shoot() {
        if (ammo() > 0) {
            System.out.println("BOOM");
            getAmmo();
        } else {
            System.out.println("CLOCK");
        }
    }

    public boolean isCharged(){
        return ammo() > 0;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

}
