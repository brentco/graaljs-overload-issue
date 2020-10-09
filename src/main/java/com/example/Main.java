package com.example;

import jdk.nashorn.internal.runtime.Source;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.ResourceLimits;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting context...");
        Context newContext = newContext();
        newContext.getBindings("js").putMember("SomeClass", new SomeClass());

        char[] script = Source.readFully(Main.class.getResource("/test.js"));
        System.out.println("Evaluating script...");
        newContext.eval("js", String.valueOf(script));
    }

    private static Context newContext() {
        HostAccess.Builder builder = HostAccess.newBuilder()
                .allowAccessAnnotatedBy(Api.class)
                .allowPublicAccess(false)
                .allowArrayAccess(true);
        HostAccess accessConfig = builder.build();

        ResourceLimits resourceLimits = ResourceLimits.newBuilder()
                .statementLimit(50000, null)
                .build();

        Context.Builder contextBuilder = Context.newBuilder("js");
        contextBuilder.allowExperimentalOptions(true)
                .option("js.graal-builtin", "false")
                .option("js.polyglot-builtin", "false")
                .option("js.experimental-foreign-object-prototype", "true")
                .option("js.ecmascript-version", "6")
                .option("js.strict", "true")
                .option("js.regexp-static-result", "false")
                .option("js.java-package-globals", "false")
                .option("js.global-property", "false")
                .option("js.console", "false")
                .option("js.performance", "false")
                .option("js.print", "false")
                .option("js.load", "false")
                .option("js.disable-eval", "true")
                .allowHostAccess(accessConfig)
                .resourceLimits(resourceLimits);

        return contextBuilder.build();
    }
}
