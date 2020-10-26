package org.example.asm._1;

import jdk.internal.org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class Generator {
    public static void main(String[] args) throws Exception {

        ClassReader reader = new ClassReader("org/example.asm/_1/Asm_1");
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        MyClassVistor myClassVistor = new MyClassVistor(writer);
        reader.accept(myClassVistor, ClassReader.SKIP_DEBUG);
        byte[] bytes = writer.toByteArray();
        File f = new File("C:\\ww\\exercise\\target\\classes\\org\\example\\asm\\_1\\Asm_1_TMP.class");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bytes);
        fos.flush();
        fos.close();
        System.out.println("generate code success!");
        Class<?> aClass = Class.forName("org.example.asm._1.Asm_1_TMP");
        Method test = aClass.getMethod("test");
        Object o = aClass.newInstance();
        test.invoke(o);
//        Asm_1 asm_1 = new Asm_1();
//        asm_1.test();
    }

    static class MyClassVistor extends ClassVisitor implements Opcodes {

        public MyClassVistor(ClassVisitor cv) {
            super(ASM5, cv);
        }

        @Override
        public void visit(int version,
                          int access,
                          String name,
                          String signature,
                          String supername,
                          String[] interfaces) {
            cv.visit(version, access, name + "_TMP", signature, supername, interfaces);
        }

        @Override
        public MethodVisitor visitMethod(int access,
                                         String name,
                                         String desc,
                                         String signature,
                                         String[] exceptions) {
            MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
            if (!name.equals("<init>") && mv != null) {
                mv = new MyMethodVisitor(mv);
            }
            return mv;
        }
    }

    static class MyMethodVisitor extends MethodVisitor implements Opcodes {

        public MyMethodVisitor(MethodVisitor mv) {
            super(ASM5, mv);
        }

        @Override
        public void visitCode() {
            super.visitCode();
            mv.visitFieldInsn(GETSTATIC,
                    "java/lang/System",
                    "out",
                    "Ljava/io/PrintStream;");
            mv.visitLdcInsn("start....");
            mv.visitMethodInsn(INVOKEVIRTUAL,
                    "java/io/PrintStream",
                    "println",
                    "(Ljava/lang/String;)V", false);
        }

        @Override
        public void visitInsn(int opcode) {
            if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN)
                    || opcode == Opcodes.ATHROW) {
                mv.visitFieldInsn(GETSTATIC,
                        "java/lang/System",
                        "out",
                        "Ljava/io/PrintStream;");
                mv.visitLdcInsn("end....");
                mv.visitMethodInsn(INVOKEVIRTUAL,
                        "java/io/PrintStream",
                        "println",
                        "(Ljava/lang/String;)V", false);

                mv.visitInsn(opcode);
            }
        }
    }
}
