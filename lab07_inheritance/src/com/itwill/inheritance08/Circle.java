package com.itwill.inheritance08;

public class Circle extends Shape {
	// field
	private double radius;
	
	public Circle (double radius) {
		super ("동그라미");
		this.radius = radius;
	}

	@Override
	public double area() {		
		return radius*radius*Math.PI;
	}

	@Override
	public double perimeter() {
		return radius*2*Math.PI;
	}
	
	
	
}
