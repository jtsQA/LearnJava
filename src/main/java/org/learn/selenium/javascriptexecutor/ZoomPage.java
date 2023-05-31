package org.learn.selenium.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;

public class ZoomPage {

    public static JavascriptExecutor zoomIn(JavascriptExecutor js, int zoomPercent) {
        String script = "document.body.style.zoom = '" + zoomPercent + "%'";
        return (JavascriptExecutor) js.executeScript(script);
    }

}
