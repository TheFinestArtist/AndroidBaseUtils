package com.thefinestartist.compilers;

/**
 * Created by TheFinestArtist on 2/9/16.
 */
public class Constants {

    public static final String SUFFIX = "$$ExtraBinder";

    public static final String BINDING_ACTIVITY = "        activity.%s = (%s) bundle.get(\"%s\");";
    public static final String BINDER_ACTIVITY = ""
            + "package %s;\n\n"
            + "import android.os.Bundle;\n\n"
            + "public class %s {\n"
            + "    public static void bind(%s activity) {\n"
            + "        Bundle bundle = activity.getIntent().getExtras();\n"
            + "%s"
            + "    }\n"
            + "}\n";

    public static final String BINDING_FRAGMENT = "        fragment.%s = (%s) bundle.get(\"%s\");";
    public static final String BINDER_FRAGMENT = ""
            + "package %s;\n\n"
            + "import android.os.Bundle;\n\n"
            + "public class %s {\n"
            + "    public static void bind(%s fragment) {\n"
            + "        Bundle bundle = fragment.getArguments();\n"
            + "%s"
            + "    }\n"
            + "}\n";
}
