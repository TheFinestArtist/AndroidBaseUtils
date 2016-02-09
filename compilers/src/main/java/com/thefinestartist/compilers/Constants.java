package com.thefinestartist.compilers;

/**
 * Created by TheFinestArtist on 2/9/16.
 */
public class Constants {

    public static final String BINDING_ACTIVITY = "        activity.%s = (%s) intent.getSerializableExtra(\"%s\");";
    public static final String BINDER_ACTIVITY = ""
            + "package %s;\n\n"
            + "import android.content.Intent;\n\n"
            + "public class %s {\n"
            + "    public static void bind(%s activity) {\n"
            + "        Intent intent = activity.getIntent();\n"
            + "%s"
            + "    }\n"
            + "}\n";

    public static final String BINDING_FRAGMENT = "        fragment.%s = (%s) bundle.getSerializable(\"%s\");";
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
