package org.example.asm._1;

import org.objectweb.asm.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * @author wangwei@huixiangtech.cn
 * @version 1.0
 * @className ClassPrinter
 * @description TODO
 * @date 2020/10/27-14:22
 **/
public class ClassPrinter extends ClassVisitor {

    public static void main(String[] args) throws IOException {
        ClassPrinter cp = new ClassPrinter();
        ClassReader cr = new ClassReader("org.example.asm._1.Asm_1");
        cr.accept(cp, ClassReader.SKIP_DEBUG);
    }

    public ClassPrinter() {
        super(ASM5);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        String inters = interfaces == null ? "" : Arrays.asList(interfaces).stream().collect(Collectors.joining(",", "[", "]"));
        System.err.println("=====visit====");
        System.err.println("access: " + access);
        System.err.println("name: " + name);
        System.err.println("signature: " + signature);
        System.err.println("superName: " + superName);
        System.err.println("interfaces: " + inters);
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
        System.err.println("=====visitSource====");
        System.err.println("source: " + source);
        System.err.println("debug: " + debug);
    }

    @Override
    public ModuleVisitor visitModule(String name, int access, String version) {

        System.err.println("=====visitModule====");
        System.err.println("name: " + name);
        System.err.println("access: " + access);
        System.err.println("version: " + version);

        return super.visitModule(name, access, version);
    }

    @Override
    public void visitNestHost(String nestHost) {
        super.visitNestHost(nestHost);
        System.err.println("=====visitNestHost====");
        System.err.println("nestHost: " + nestHost);
    }

    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {
        super.visitOuterClass(owner, name, descriptor);
        System.err.println("=====visitOuterClass====");
        System.err.println("owner: " + owner);
        System.err.println("name: " + name);
        System.err.println("descriptor: " + descriptor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.err.println("=====visitAnnotation====");
        System.err.println("descriptor: " + descriptor);
        System.err.println("visible: " + visible);

        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        System.err.println("=====visitTypeAnnotation====");
        System.err.println("typeRef: " + typeRef);
        System.err.println("typePath: " + typePath);
        System.err.println("descriptor: " + descriptor);
        System.err.println("visible: " + visible);

        return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
        System.err.println("=====visitAttribute====");
        System.err.println("attribute: " + attribute);
    }

    @Override
    public void visitNestMember(String nestMember) {
        super.visitNestMember(nestMember);
        System.err.println("=====visitNestMember====");
        System.err.println("nestMember: " + nestMember);
    }

    @Override
    public void visitPermittedSubtypeExperimental(String permittedSubtype) {
        super.visitPermittedSubtypeExperimental(permittedSubtype);
        System.err.println("=====visitPermittedSubtypeExperimental====");
        System.err.println("permittedSubtype: " + permittedSubtype);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {

        System.err.println("=====visitInnerClass====");
        System.err.println("name: " + name);
        System.err.println("outerName: " + outerName);
        System.err.println("innerName: " + innerName);
        System.err.println("access: " + access);

        super.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {

        System.err.println("=====visitRecordComponent====");
        System.err.println("name: " + name);
        System.err.println("descriptor: " + descriptor);
        System.err.println("signature: " + signature);

        return super.visitRecordComponent(name, descriptor, signature);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {

        System.err.println("=====visitField====");
        System.err.println("access: " + access);
        System.err.println("name: " + name);
        System.err.println("descriptor: " + descriptor);
        System.err.println("signature: " + signature);
        System.err.println("value: " + value);

        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        String exceps = exceptions == null ? "" :
                Arrays.asList(exceptions).stream().collect(Collectors.joining(",", "[", "]"));
        System.err.println("=====visitMethod====");
        System.err.println("access: " + access);
        System.err.println("name: " + name);
        System.err.println("descriptor: " + descriptor);
        System.err.println("signature: " + signature);
        System.err.println("exceptions: " + exceps);
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        System.err.println("=====visitEnd====");
    }

    public ClassPrinter(int api) {
        super(api);
    }
}
