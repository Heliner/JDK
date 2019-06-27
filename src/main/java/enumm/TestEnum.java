package enumm;

import org.junit.Assert;
import org.junit.Test;

public class TestEnum {
    @Test
    public void testColor() {
        ColorEnum blue = ColorEnum.BLUE;
        System.out.println("bule.toString:" + blue.toString());
        Assert.assertEquals(blue, ColorEnum.valueOf("BLUE"));
        /*not equal*/
//        Assert.assertEquals(blue,ColorEnum.valueOf("blue"));

    }

    @Test
    public void testColorCustomerilize() {
        /*不能被实例化*/
//        ColorEnumCustomerial colorEnumCustomerial = new ColorEnumCustomerial("SoftReferenceOOMDemo");

        ColorEnumCustomerial blue = ColorEnumCustomerial.BLUE;
        switch (blue) {
            case BLUE:
                System.out.println("蓝色");
                break;
            default:
                break;
        }

    }
}
