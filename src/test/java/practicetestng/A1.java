package practicetestng;

import org.testng.annotations.Test;

public class A1 {
	
	@Test  //(priority = 6,invocationCount = 6)
public void z() {
	System.out.println("z");
}
	@Test   //(priority = 1,invocationCount = 1)
public void b() {
	System.out.println("b");
}
	@Test   //(priority = 5,invocationCount = 5)
public void x() {
	System.out.println("x");
}
	@Test   //(priority = 4,invocationCount = 4)
public void g() {
	System.out.println("g");
}
	@Test    //(priority =2 ,invocationCount = 2)
public void e() {
	System.out.println("e");
}
	@Test   //(priority =3 ,invocationCount = 3)
public void f() {
	System.out.println("f");
}
}
