package com.media.operations;

import com.media.service.*;
import com.media.service_impl.*;
import com.media.entity.*;
import static  com.media.operations.MainOperation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.media.exception.*;

public class AllOperations {

	static UserService userService = new UserService_impl();
	static FriendsService friendsService = new FriendsService_impl();
	static MessagesService messagesService = new MessagesService_impl();
	static GroupsService groupsService = new GroupsService_impl();
	static PostsService postsService = new PostsService_impl();
	static SignUpService sign_upservice = new Sign_UpService_impl();
	static LoginService loginservice = new LoginService_Impl();
	static Scanner sc = new Scanner(System.in);

	// ========================= USER OPERATIONS =========================


	public static  Login loginInput() {
		System.out.print("Enter username: ");
		String username = sc.next();

		System.out.print("Enter password: ");
		String password = sc.next();

		Login User = new Login();

		System.out.println("Login successful!");
		return User;
	}

	public static User userInput() {
		sc.nextLine();
		System.out.println("Enter User ID");
		String UserId=sc.nextLine();

		System.out.println("Enter Username");
		String Username=sc.nextLine();

		System.out.println("Enter Email");
		String Email=sc.nextLine();

		System.out.println("Enter Password");
		String Password=sc.nextLine();

		System.out.println("Enter Full Name");
		String Full_name=sc.nextLine();

		System.out.println("Enter Age");
		int Age =sc.nextInt();
		sc.nextLine(); 

		System.out.println("Enter Gender");
		String Gender =sc.nextLine();

		System.out.println("what is your current loction");
		String Location=sc.nextLine();

		System.out.println("how much post have you created");
		int Posts_count=sc.nextInt();
		return new User(UserId, Username, Email, Password, Full_name, Age, Gender, Location, Posts_count);
	}

	public static Posts postsInput() {
		sc.nextLine();
		System.out.println("Enter posts ID");
		String Posts_Id=sc.nextLine();
		
		System.out.println("Enter UserId");
		String UserId=sc.nextLine();

		System.out.println("Enter content");
		String Content=sc.nextLine();
		
		System.out.println("Enter Comments");
		String Comments=sc.nextLine();

		System.out.println("how much Views do you have");
		int Views =sc.nextInt();

		System.out.println("what is your Likes count");
		int Likes_count=sc.nextInt();

		return new Posts(Posts_Id, UserId, Content, Comments, Views, Likes_count);
	}

	public static Friends friendsInput() {
		sc.nextLine();
		System.out.println("Enter friend ID");
		String friend_Id=sc.nextLine();

		System.out.println("add one UserId1");
		String UserId1=sc.nextLine();

		System.out.println("add another UserId2");
		String UserId2=sc.nextLine();

		System.out.println("Enter follow if you want to follow them");
		String follow=sc.nextLine();

		System.out.println("Enter status (pending/accepted)");
		String status =sc.nextLine();

		return new Friends(friend_Id, UserId1, UserId2, follow, status);
	}

	public static Messages messagesInput() {
		sc.nextLine();
		System.out.println("Enter Messages ID");
		String Msg_Id=sc.nextLine();

		//System.out.println("Enter Sender Id");
		//String Sender_Id=sc.next(System.in);
		//sc.nextLine(); 

		System.out.println("Enter Reciver Id ");
		String Reciver_Id=sc.nextLine();

		System.out.println("Enter sender id :");
		String Sender_Id = sc.nextLine(); 
		
		System.out.println("Enter your message");
		String Msg_Txt=sc.nextLine();
		
		System.out.println("Message was send at ");
		String send_at =sc.nextLine();

		return new Messages(Msg_Id, Sender_Id, Reciver_Id, Msg_Txt, send_at);
	}

	public static SocialGrps groupsInput() {
		sc.nextLine();
		System.out.println("Enter the Group ID");
		String Grp_Id=sc.nextLine();

		System.out.println("Enter the name of the group");
		String Grp_name=sc.nextLine();

		System.out.println("enter the name who created the group");
		String create_by =sc.nextLine();
		
		System.out.println("Enter description for the group");
		String desc=sc.nextLine();
		
		System.out.println("enter the name who created the group");
		String members =sc.nextLine();

		return new SocialGrps(Grp_Id, Grp_name, create_by, desc, members);
	}
	
	public static void signUpOperations() {
	    while (true) {
	        System.out.println("1. Sign in\n2. Check Username/Email Availability\n3. Back to Main Menu");
	        int choice = sc.nextInt();
	        sc.nextLine(); // Consume newline

	        switch (choice) {
	            case 1: 
	                User user = userInput();
	                User saved = userService.createUser(user);
					System.out.println("User Data has been saved successfully"+ saved);

	                break;

	            case 2:
	                System.out.println("Enter Username to Check Availability:");
	                String username = sc.next();

	                SignUpService signUpService = new Sign_UpService_impl(); //  Create an instance

	                if (signUpService.checkUsernameExists(username)) { //  Call the method on the instance
	                    System.out.println("Username is already taken.");
	                } else {
	                    System.out.println("Username is available.");
	                }
	         
	                System.out.println("Enter Email to Check Availability:");
	                String email = sc.next();
	                

	                if (signUpService.checkEmailExists(email)) { //Call the method on the instance
	                    System.out.println("Email is already registered.");
	                } else {
	                    System.out.println("Email is available.");
	                }
	                break;

	            case 3:
	                return; // Go back to the main menu

	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
	}

	public static void loginOperations() {
	    while (true) {
	        System.out.println("1. Login\n2. Back to Main Menu");
	        int choice = sc.nextInt();
	        sc.nextLine(); // Consume newline

	        switch (choice) {
	            case 1:
	                System.out.println("Enter Username:");
	                String username = sc.nextLine();
	                System.out.println("Enter Password:");
	                String password = sc.nextLine();

	                // Call login validation service
	                Login validateLogin = new Login(username, password);
	                boolean isLoggedIn = LoginService.validateLogin(validateLogin);

	                if (isLoggedIn) {
	                    System.out.println("Login successful! Welcome back, " + username);
	                    return; // Exit loop after successful login
	                } else {
	                    System.out.println("Invalid credentials. Please try again.");
	                }
	                break;

	            case 2:
	                return; // Go back to the main menu

	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
	}



	public static void userOperations() {
		while (true) {
			System.out.println("1. View All Users\n2. Get User By ID\n3. Update User\n4. Delete User\n5. Back to Main Menu");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 :
				List<User> user1 = null;
				userService.getAllUsers().forEach(System.out::println);
				break;
				
			case 2 :
			{
				System.out.println("Enter User ID:");
				System.out.println(userService.getUser(sc.next()));
			}
			break;

			case 3: {
			    System.out.println("Enter User ID to Update:");
			    String updateId = sc.next(); // Read User ID

			    // Create an empty User object to store updated fields
			    User updatedUser = new User();

			    System.out.println("Enter New Email:");
			    updatedUser.setEmail(sc.next());

			    System.out.println("Enter New Password:");
			    updatedUser.setPassword(sc.next());

			    System.out.println("Enter New Age:");
			    updatedUser.setAge(sc.nextInt());

			    System.out.println("Enter New Location:");
			    updatedUser.setLocation(sc.next());

			    System.out.println("Enter New Post Count:");
			    updatedUser.setPost_count(sc.nextInt());

			    // Call update method
			    User updatedInfo = userService.updateUser(updateId, updatedUser);

			    System.out.println("User Data has been updated Successfully: " + updatedInfo);
			}
			break;

			case 4:
			{
				System.out.println("Enter User ID to Delete:");
				System.out.println(userService.deleteUser(sc.next()));
			}
			break;
			
			case 5:
			{
				mainOps();
			}
			break;
			
			default :
				System.out.println("Invalid choice.");
			}
		}
	}

	// ========================= FRIENDS OPERATIONS =========================
	public static void friendOperations() {
	    while (true) {
	        System.out.println("1. Add Friend\n2. Remove Friend\n3. View Friends List\n4. Update Friendship Status\n5. Back to Main Menu");
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1: {
	                // Add Friend
	                System.out.println("Enter Friend ID:");
	                String friendId = sc.next();
	                System.out.println("Enter User ID1:");
	                String userId1 = sc.next();
	                System.out.println("Enter User ID2:");
	                String userId2 = sc.next();
	                System.out.println("Enter Status:");
	                String status = sc.next();
	                System.out.println("Enter Follow (follow/unfollow):");
	                String follow = sc.next();
	                Friends newFriend = new Friends(friendId, userId1, userId2, status, follow);
	                System.out.println(friendsService.createFriend(newFriend));
	            }
	            break;

	            case 2: {
	                // Remove Friend
	                System.out.println("Enter Friend ID to Remove:");
	                String friendId = sc.next();  // Get the friend ID

	                String result = friendsService.removeFriend(friendId);
	                System.out.println(result);
	            }
	            break;


	            case 3: {
	                // View Friends List
	                System.out.println("Enter User ID to View Friends:");
	                String userId = sc.next();  

	                List<Friends> friends = friendsService.getAllFriends(userId); 

	                if (friends.isEmpty()) {
	                    System.out.println("No friends found for this user.");
	                } else {
	                    System.out.println("Friends of User ID: " + userId);
	                    friends.forEach(friend -> System.out.println("Friend ID: " + friend.getUserId1() + ", Name: "));
	                }
	            }
	            break;


	            case 4: {
	                System.out.println("Enter Friend ID:");
	                String friendId = sc.next(); // Read friend ID

	                System.out.println("Enter Action (accepted/rejected):");
	                String status = sc.next(); // Read friendship status

	                // Creating an updated Friend object
	                Friends updatedFriend = new Friends();
	                updatedFriend.setStatus(status); // Set status (accepted/rejected)

	                // If accepted, also set follow status
	                if (status.equalsIgnoreCase("accepted")) {
	                    updatedFriend.setFollow("follow"); // Automatically follow the friend
	                } else {
	                    updatedFriend.setFollow("unfollow"); // Automatically unfollow if rejected
	                }

	                System.out.println(friendsService.updateFriend(friendId, "friend_update", updatedFriend));
	            }
	            break;

	            case 5: {
	                // Back to Main Menu
	                mainOps();
	            }
	            break;

	            default:
	                System.out.println("Invalid choice.");
	        }
	    }
	}

	// ========================= MESSAGES OPERATIONS =========================
	public static void messageOperations() {
	    while (true) {
	        System.out.println("1. create Messages\n2. Send Message\n3. View Messages\n4. Delete Message\n5. Back to Main Menu");
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1: {
	                // Send Message
	                System.out.println("Enter Message ID:");
	                String messageId = sc.next();

	                //System.out.println("Enter Sender Email ID:");
	                //String senderEmailId = sc.nextLine();
	                //sc.nextLine(); // Consume the newline character

	                System.out.println("Enter Receiver Email ID:");
	                String receiverEmailId = sc.nextLine();
	                sc.nextLine();
	               // sc.nextLine();
	                
	                System.out.println("Enter Sender Email ID:");
	                String senderEmailId = sc.nextLine();

	                System.out.println("Enter Message Content:");
	                String messageContent = sc.nextLine();

	                System.out.println("Enter Sent At (use a valid integer, like timestamp or time in seconds):");
	                String sentAt = sc.nextLine();

	                Messages message = new Messages(messageId, senderEmailId, receiverEmailId, messageContent, sentAt);
	                System.out.println(messagesService.createMessage(message));
	                break; // Ends case 1 after execution
	            }
	            
	            case 2: {
	            	System.out.println("to send the message enter send");
	            	String send = sc.next();
	            	System.out.println(messagesService.sendMessages(send, send, send, send, send));
	            }

	            case 3: {
	                // View Message
	                List<Messages> message = messagesService.getAllMessages();
	                
	                if (message != null) {
	                    System.out.println(message);  // Print the message details
	                } else {
	                    System.out.println("No messages are to be found.");
	                }
	                break;
	            }

	            case 4: {
	                // Delete Message
	                System.out.println("Enter Message ID to Delete:");
	                String messageIdToDelete = sc.next();
	                System.out.println(messagesService.deleteMessage(messageIdToDelete));
	                break;
	            }

	            case 5: {
	                // Back to Main Menu
	                mainOps();
	                break;
	            }

	            default:
	                System.out.println("Invalid choice.");
	                break;
	        }
	    }
	}


	// ========================= GROUPS OPERATIONS =========================
	public static void groupOperations() {
		while (true) {
			System.out.println("1. Create Group\n2. View All Groups\n3. Add Member to Group\n4. Remove Member from Group\n5. Delete Group\n6. Back to Main Menu");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
			    System.out.println("Enter Group ID:");
			    String groupId = sc.next();

			    System.out.println("Enter Group Name:");
			    sc.nextLine(); // Consume the newline character
			    String groupName = sc.nextLine();

			    System.out.println("Enter Admin Name (the one who created the group):");
			    String createdby = sc.nextLine();
			    
			    System.out.println("Enter Description:");
			    String description = sc.nextLine();

			    System.out.println("Enter Members (separated by commas if multiple):");
			    String members = sc.nextLine();

			    SocialGrps group = new SocialGrps(groupId, groupName, createdby, description, members);
			    System.out.println(groupsService.createGroup(group));
			    break;
			}

			case 2: {
			    // Call the method directly, without passing null
			    groupsService.getAllGroups().forEach(System.out::println);
			
			break;
			}

			case 3 :
			{
				System.out.println("Enter Group ID to Add Member:");
				System.out.println(groupsService.addMember(sc.next(), sc.next()));
			}
			break;

			case 4 :
			{
				System.out.println("Enter Group ID to Remove Member:");
				System.out.println(groupsService.removeMember(sc.next(), sc.next()));
			}
			break;

			case 5 :
			{
				System.out.println("Enter Group ID to Delete:");
				System.out.println(groupsService.deleteGroup(sc.next()));
			}
			break;

			case 6 :
			{
				mainOps();
			}
			break;

			default : System.out.println("Invalid choice.");
			}
		}
	}

	// ========================= POSTS OPERATIONS =========================
	public static void postOperations() {
		while (true) {
			System.out.println("1. Create Post\n2. View All Posts\n3. Delete Post\n4. Back to Main Menu");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 :
			
				 System.out.println("Enter Post ID:");
				    String postId = sc.next();
				    
				    System.out.println("Enter User ID:");
				    String userId = sc.next();
				    
				    System.out.println("Enter Content:");
				    sc.nextLine(); // Consume the newline character
				    String content = sc.nextLine();
				    
				    System.out.println("Enter Comments:");
				    String comments = sc.nextLine();
				    
				    System.out.println("Enter Views:");
				    int views = sc.nextInt();
				    
				    System.out.println("Enter Likes Count:");
				    int likesCount = sc.nextInt();
				    
				    Posts post = new Posts(postId, userId, content, comments, views, likesCount);
				    System.out.println(postsService.createPost(post));
				   
			break;

			case 2 :
				List<Posts> posts_Id = null ;
				postsService.getAllPosts(posts_Id).forEach(System.out::println);
				
				break;

			case 3 :
			
				System.out.println("Enter Post ID to Delete:");
				System.out.println(postsService.deletePost(sc.next()));
		
			break;

			case 4 : 
				mainOps();
			
			break;

			default : System.out.println("Invalid choice.");
			}
		}
	}
} 