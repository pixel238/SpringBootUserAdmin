package com.tavisca.springapplication.helper;

import com.tavisca.springapplication.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class UserHelper {
    private static String generateUsername(String firstName, String lastName){

        Random random = new Random();
        int i = random.nextInt(10000);
        //Storing it in a arrayList the number generated.
        ArrayList<String> list = new ArrayList<>();

        String username =  (firstName + lastName).length() > 10 ? (firstName + lastName).substring(0,10) + i :
                (firstName + lastName) + i;

        return username;
    }

    private static String generatePassword(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static User createUser(User user){

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String address = user.getAddress();
        String dateOfJoining = user.getDateOfJoining();
        String phoneNumber = user.getPhoneNumber();
        Long salary = user.getSalary();
        String dob = user.getDob();
        String createdBy = user.getCreatedBy();
        int departmentId = user.getDepartmentId();

        String userName = generateUsername(firstName,lastName);
        String password = generatePassword(10);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String createdOn = simpleDateFormat.format(new Date());

        User finalUser = new User(firstName,lastName,dob,email,address,phoneNumber,departmentId,
                salary,dateOfJoining,createdBy,userName,password,createdOn);

        return finalUser;
    }

    public static User copyUserDetails(User oldUser, User newUser) {
     newUser.setUid(oldUser.getUid());
     newUser.setCreatedBy(oldUser.getCreatedBy());
     newUser.setSalary(oldUser.getSalary());
     newUser.setDateOfJoining(oldUser.getDateOfJoining());

     return newUser;
    }
}
