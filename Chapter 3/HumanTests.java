public class HumanTests {
    public static void checkHeight(Human human){
        if (human.getHeight() > 250){
            throw new IllegalArgumentException();
        }
    }

    public static void checkNameLength(Human human){
        if (human.getName().getName().length() > 25 || human.getName().getName().length() == 0){
            throw new IllegalArgumentException();
        }
    }


}
