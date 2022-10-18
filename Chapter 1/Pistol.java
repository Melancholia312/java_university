public class Pistol {
    private int curBullets;
    private final int maxBullets;

    public Pistol(int maxBullets) {
        this(0, maxBullets);
    }

    public Pistol(int curBullets, int maxBullets){
        if (curBullets < 0 || maxBullets < 0){
            throw new IllegalArgumentException();
        }
        this.curBullets = curBullets;
        this.maxBullets = maxBullets;
    }

    public int reload(int bulletsToReload){
        if (bulletsToReload < 0){
            throw new IllegalArgumentException();
        }
        if (bulletsToReload > maxBullets){
            curBullets = maxBullets;
            return bulletsToReload - maxBullets;
        }
        curBullets += bulletsToReload;
        return 0;
    }

    public int unload(){
        int bulletsToUnload = curBullets;
        curBullets = 0;
        return bulletsToUnload;
    }

    public void shoot() {
        if (curBullets > 0) {
            System.out.println("BOOM");
            curBullets -= 1;
        } else {
            System.out.println("CLOCK");
        }
    }

    public boolean isCharged(){
        return curBullets > 0;
    }

    public int getCurBullets() {
        return curBullets;
    }

    public void setCurBullets(int curBullets) {
        if (curBullets < 0 ){
            throw new IllegalArgumentException();
        }
        this.curBullets = curBullets;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

}
