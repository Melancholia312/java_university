public class TestClass {

    public static double sum(Number ...numbers){
        double result = 0.0;
        for (Number number : numbers){
            result += number.doubleValue();
        }
        return result;
    }

    public static void singAll(Bird ...birds){
        for (Bird bird : birds){
            bird.sing();
        }
    }

    public static int calculateArea(Figure ...figures){
        int resArea = 0;
        for (Figure figure : figures){
            resArea += figure.area();
        }
        return resArea;
    }

    public static void meowAll(Meowable ...cats){
        for (Meowable cat : cats){
            cat.meow();
        }
    }

    public static int calculateLength(Lengthable ...lines){
        int resLength = 0;
        for (Lengthable line : lines){
            resLength += line.length();
        }
        return resLength;
    }

    public static BrokenLine createBigBrokenLine(Brokenlineable ...figures){
        BrokenLine brokenLine = new BrokenLine();
        for (Brokenlineable figure : figures){
            brokenLine.addPoint(figure.returnBrokenLine().getPoints().toArray(new Point[0]));
        }
        return brokenLine;
    }

    public static void createCityGraph(){
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");

        a.addTwoDirectionWay(b, 0);
        a.addOneDirectionWay(c, 1);
        b.addOneDirectionWay(c,2);
        b.addTwoDirectionWay(d, 3);
        d.addTwoDirectionWay(e,4);
        e.addOneDirectionWay(c,5);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);


    }


}
