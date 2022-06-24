package com.xy124.templatecallback.calculate.template;

import java.io.IOException;

public interface LineCallback {

    Integer doSomethingWithLine(String line ,Integer calculateResult) throws IOException;
}
