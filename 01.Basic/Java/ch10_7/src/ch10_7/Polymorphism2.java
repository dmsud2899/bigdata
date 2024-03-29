package ch10_7;

abstract class Animal
{
	abstract void print();
}

class Cat extends Animal
{
	void print()
	{
		System.out.println("고양이 생성");
	}
}

class Dog extends Animal
{
	void print()
	{
		System.out.println("강아지 생성");
	}
}

public class Polymorphism2
{
	
	public static void animalUse(Animal obj)
	{
		if (obj instanceof Cat)
		{
			Cat c = (Cat)obj;
			c.print();
			
		}
		else
		{
			Dog d = (Dog)obj;
			d.print();
		}
	}
	
	public static void main(String[] args)
	{
		Cat h1 = new Cat();
		animalUse(h1);
		
		Dog h2 = new Dog();
		animalUse(h2);
	}

}


