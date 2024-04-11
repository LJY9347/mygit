package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

	public static void main(String[] args) {
		// TODO Student 1,000,000개를 저장하는 더미 데이터(ArrayList)를 만듦.
		// 더미 데이터를 파일에 씀. 파일에 쓰는 데 걸린 시간 측정.
		// 파일에서 데이터를 읽음. 읽는 데 걸린 시간 측정.

		ArrayList<Student> list = new ArrayList<Student>();
		
		Random rand = new Random(); // 점수 score를 난수로 생성하기 위해서.
		for (int i = 0; i < 1_000_000; i++) {
			Score score = new Score(rand.nextInt(101),rand.nextInt(101),rand.nextInt(101));
			Student student = new Student(i, "Name" + i, score);
			list.add(student);
		}

		final String fileName = "data/stu.dat";

		try (FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bos);) {

			double start = System.currentTimeMillis();

			oos.writeObject(list);

			double end = System.currentTimeMillis();

			System.out.println("쓰기 종료 " + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileInputStream in = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(in);
				ObjectInputStream ois = new ObjectInputStream(bis);) {

			double start = System.currentTimeMillis();
			
			ArrayList<Student> stud = (ArrayList<Student>) ois.readObject();
			
			double end = System.currentTimeMillis();
			
			System.out.println("읽기 종료 " + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
