package image;

import java.applet.Applet;
import java.net.URL;

/*
<applet code="ImageTest1.class" width="150" height="150">
</applet>
*/

public class Img extends Applet {
    public void init() {
        URL urlCode = getCodeBase();
        URL urlDoc = getDocumentBase();

        System.out.println(urlCode.getPath());
        System.out.println(urlDoc.getPath());
    }
}
