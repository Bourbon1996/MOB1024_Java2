package Lab8bai3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

	// Tạo annotation
	@Retention(RetentionPolicy.RUNTIME)
	@interface Developer {
	    String name();
	    String version();
	}

	// Class Employee
	class Employee {
	    double getSalary() {
	        return 1000;
	    }

	    @Deprecated
	    void oldMethod() {
	        System.out.println("Phương thức cũ");
	    }

	    void newMethod() {
	        System.out.println("Phương thức mới");
	    }
	}

	// Manager override
	class Manager extends Employee {
	    @Override
	    double getSalary() {
	        return 2000;
	    }
	}

	// Gắn annotation
	@Developer(name = "Hoàng văn Ba Đức", version = "1.0")
	public class Main  {
	    public static void main(String[] args) {

	        Manager m = new Manager();
	        System.out.println("Salary: " + m.getSalary());

	        // Reflection
	        Class<?> classs = Main.class;

	        if (classs.isAnnotationPresent(Developer.class)) {
	            Developer dev = classs.getAnnotation(Developer.class);
	            System.out.println("Developer: " + dev.name());
	            System.out.println("Version: " + dev.version());
	        }
	    }
	}

