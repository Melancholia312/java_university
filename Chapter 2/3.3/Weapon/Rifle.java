public class Rifle extends Pistol {

    private final int rateOfFire;

    public Rifle(){
        this(30,30);
    }

    public Rifle(int maxBullets){
        this(maxBullets, (int)(maxBullets * 0.5));
    }

    public Rifle(int maxBullets, int rateOfFire){
        super(maxBullets);
        if (rateOfFire < 0){
            throw new IllegalArgumentException();
        }
        this.rateOfFire = rateOfFire;
    }

    public void shoot(int secs){
        for (int i = 0; i < rateOfFire * secs; i++){
            super.shoot();
        }
    }

    @Override
    public void shoot() {
        shoot(1);
    }
}
