package fr.aseure.tp012;

import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            var loader = new MyClassLoader();
            Class<?> clazz = loader.loadClass("fr.aseure.tp012.Surprise");


            ///////////////////////////////////////////////////////////////////
            // STEP 1: Investigations
            ///////////////////////////////////////////////////////////////////

            System.out.println("--- Declared constructors:");
            for (var ctor : clazz.getDeclaredConstructors()) {
                List<String> params = new ArrayList<>();
                for (var param : ctor.getParameterTypes()) {
                    params.add(param.toString());
                }
                System.out.printf("(%s)\n", String.join(",", params));
                System.out.println();
            }

            // Instantiate a new object of the Surprise class with the
            // 0-argument constructor we found.
            Object o = clazz.getConstructor().newInstance();

            // To investigate all the fields and their respective accessibility.
            System.out.println("--- Declared fields:");
            for (var field : clazz.getDeclaredFields()) {
                System.out.println(field.canAccess(o));
                System.out.println(field.getType());
                System.out.println(field.getName());
                System.out.println();
            }

            // To investigate all the methods and their respective accessibility.
            System.out.println("--- Declared methods:");
            for (var method : clazz.getDeclaredMethods()) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    System.out.println(method.canAccess(o));
                }
                System.out.println(method.getName());
                List<String> params = new ArrayList<>();
                for (var param : method.getParameterTypes()) {
                    params.add(param.toString());
                }
                System.out.printf("(%s)\n", String.join(",", params));
                System.out.println(method.getReturnType());
                System.out.println();
            }

            // We found two private fields, let's investigate what they look
            // like.
            System.out.println("--- Display values of private members:");

            var field = clazz.getDeclaredField("firstStepSecretKey");
            field.setAccessible(true);
            int firstStepSecretKey = (int) field.get(o);
            System.out.println("firstStepSecretKey = " + firstStepSecretKey);

            field = clazz.getDeclaredField("superSecretMessage");
            field.setAccessible(true);
            String superSecretMessage = (String) field.get(o);
            System.out.println("superSecretMessage = " + superSecretMessage);

            System.out.println();


            ///////////////////////////////////////////////////////////////////
            // STEP 2: Think about a solution
            ///////////////////////////////////////////////////////////////////

            // ...


            ///////////////////////////////////////////////////////////////////
            // STEP 3: Implement the solution
            ///////////////////////////////////////////////////////////////////

            // The second step encoder is a Base64 encoder, so we need to first
            // instantiate a Base64 decoder and use it to get the intermediate
            // message.
            var message = new String(Base64.getDecoder().decode(superSecretMessage));

            // The first step encoder is probably using the firstStepEncode
            // method. Since there's a method named firstStepDecode, we're
            // gonna call it, with the private firstStepSecretKey attribute we
            // found earlier.
            var method = clazz.getDeclaredMethod("firstStepDecode", String.class, int.class);
            method.setAccessible(true);
            message = (String) method.invoke(null, message, firstStepSecretKey);

            System.out.println("--- Solution:");
            System.out.println(message);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            String filepath = "surprise.jar";
            var url = new URL("jar:file:" + filepath + "!/");
            var cl = URLClassLoader.newInstance(new URL[]{url});
            return cl.loadClass(name);
        } catch (Exception e) {
            throw new ClassNotFoundException();
        }
    }
}