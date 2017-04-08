/*
 * FAQ.java
 * 
 * Copyright 2017 Loren Smith <lorensmith@Lorens-MacBook-Pro.local>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


public class untitled {
	
	public static void main (String[] args) {
		Label FAQ_Label = new Label();
		FAQ_Label.setText("FAQ");
		FAQ_Label.setFont(Font.font("", FontWeight.NORMAL, 16));
		FAQ_Label.setAlignment(Pos.CENTER);
		
		Label FAQ_Q1_Label new Label();
		FAQ_Q1_Label.setText("How do I enroll?");
		FAQ_Q1_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_Q1_Label.setAlignment(Pos.CENTER);
		
		Label FAQ_A1_Label new Label();
		FAQ_A1_Label.setText("After clicking the enroll button on the main page, you will be prompted to enter personal information for your account.");
		FAQ_A1_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_A1_Label.setWrapText(true);
		FAQ_A1_Label.setAlignment(Pos.CENTER);
		
		
		Label FAQ_Q2_Label new Label();
		FAQ_Q2_Label.setText("What happens if I forgot my password?");
		FAQ_Q2_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_Q2_Label.setWrapText(true);
		FAQ_Q2_Label.setAlignment(Pos.CENTER);
		
		Label FAQ_A2_Label new Label();
		FAQ_A2_Label.setText("Using the Forgot Password option, the user can see their current password. It will request the username and Social Security Number associated with the account.");
		FAQ_A2_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_A2_Label.setWrapText(true);
		FAQ_A2_Label.setAlignment(Pos.CENTER);
		
		
		Label FAQ_Q3_Label new Label();
		FAQ_Q3_Label.setText("Somebody else knows my password. How can I change it?");
		FAQ_Q3_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_Q3_Label.setWrapText(true);
		FAQ_Q3_Label.setAlignment(Pos.CENTER);
		
		Label FAQ_A3_Label new Label();
		FAQ_A3_Label.setText("Under the profile option in the menu, you can change your password by inputting a new password and then confirming the password in a separate box.");
		FAQ_A3_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_A3_Label.setWrapText(true);
		FAQ_A3_Label.setAlignment(Pos.CENTER);
		
		

		Label FAQ_Q4_Label new Label();
		FAQ_Q4_Label.setText("Will my password expire?");
		FAQ_Q4_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_Q4_Label.setWrapText(true);
		FAQ_Q4_Label.setAlignment(Pos.CENTER);
		
		Label FAQ_A4_Label new Label();
		FAQ_A4_Label.setText("No. User set passwords don't expire, but for security purposes, we suggest changing your password periodically.");
		FAQ_A4_Label.setFont(Font.font("", FontWeight.NORMAL, 12));
		FAQ_A4_Label.setWrapText(true);
		FAQ_A4_Label.setAlignment(Pos.CENTER);
		
				
	}
}

