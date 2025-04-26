package com.media.operations;

import java.util.Scanner;
import java.util.List;
import com.media.entity.*;
import static com.media.operations.AllOperations.*;

public class MainOperation {

	static Scanner sc = new Scanner(System.in);

	public static void mainOps() {
		while (true) {
			System.out.println("Press 1. Sign in\nPress 2. Login\nPress 3. User\nPress 4. Friends\n"
					+ "Press 5. Messages \nPress 6. Groups\n"
					+ "Press 7. Posts \nPress 8. Exit");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				signUpOperations();
				System.out.println("=======================================");
				break;
			case 2:
				loginOperations();
				System.out.println("=======================================");
				break;
			case 3:
				userOperations();
				System.out.println("=======================================");
				break;

			case 4:
				friendOperations();
				System.out.println("=======================================");
				break;

			case 5:
				messageOperations();
				System.out.println("=======================================");
				break;

			case 6:
				groupOperations();
				System.out.println("=======================================");
				break;

			case 7:
				postOperations();
				System.out.println("=======================================");
				break;

			case 8:
				System.exit(0);

			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}


	public static void main(String[] args) {
		mainOps();
	}
}