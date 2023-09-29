import java.util.*;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(this.age, otherPerson.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + " years old)";
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());

        }
    }


class PeopleDatabase implements Iterable<Person>  {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }
    public void sort(){
        Collections.sort(people);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PeopleIterator();
    }

    private class PeopleIterator implements Iterator<Person> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < people.size();
        }

        @Override
        public Person next() {
            if (hasNext()) {
                return people.get(currentIndex++);
            }
            return null;
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "PeopleDatabase{" +
                "people=" + people +
                '}';
    }
}

 class Main {
    public static void main(String[] args) {
        PeopleDatabase database = new PeopleDatabase();
        database.addPerson(new Person("Charlie", 20));
        database.addPerson(new Person("Charlie", 27));
        database.addPerson(new Person("Charlie", 30));
        database.addPerson(new Person("Charlie", 15));
        database.addPerson(new Person("Charlie", 5));




        // Используем итератор для перебора элементов


        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.add(new Person("Charlie", 20));
        personTreeSet.add(new Person("Zina",50));
        personTreeSet.add(new Person("Alice", 25));
        personTreeSet.add(new Person("Bob", 30));
        System.out.println(personTreeSet);
        database.sort();
        System.out.println(database.toString());




    }
}