package JavaCodingExamplePkg;

import java.util.HashSet;

class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return employee.getAge() == this.getAge()
                && employee.getName() == this.getName();
    }

    // commented    
      @Override
        public int hashCode() {
            int result=17;
            result=31*result+age;
            result=31*result+(name!=null ? name.hashCode():0);
            return result;
        }
     
}
public class EqualsHashCodeDemo {
	public static void main(String[] args) { Object o;
        Employee employee = new Employee("rajeev", 24);
        Employee employee1 = new Employee("rajeev", 25);
        Employee employee2 = new Employee("rajeev", 24);

        HashSet<Employee> employeesSet = new HashSet<Employee>();
        employeesSet.add(employee);
        System.out.println(employeesSet.contains(employee2));
        //If hashcode is commented then ObjectsClassHashcode will just look at memory addr and conclude that since addr is diffferent then different Obj 
        //if equals is commented then default ObjectsEqMethod will be call which does this==obj, memory addr check and it will return false
        //both ways contains gives false
        System.out.println("employee.hashCode():  " + employee.hashCode()
        + "  employee2.hashCode():" + employee2.hashCode());
    }
}
