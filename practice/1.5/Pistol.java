public class Pistol {
    private int curBullets;

    public Pistol() {
        this(5);
    }

    public Pistol(int curBullets) {
        this.curBullets = curBullets;
    }

    public void shoot() {
        if (curBullets > 0) {
            System.out.println("BOOM");
            curBullets -= 1;
        } else {
            System.out.println("CLOCK");
        }
    }

    public int getMaxBullets() {
        return curBullets;
    }

    public void setCurBullets(int curBullets) {
        this.curBullets = curBullets;
    }
}
