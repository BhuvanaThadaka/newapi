//package com.rajlee.whatsappendpoint.service;
//
//import com.rajlee.whatsappendpoint.dto.MessageBodyDTO;
//import com.rajlee.whatsappendpoint.model.User; // Assuming this is your User model
//import com.rajlee.whatsappendpoint.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    private final ApiWhatsappService apiWhatsappService;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(ApiWhatsappService apiWhatsappService, UserRepository userRepository) {
//        this.apiWhatsappService = apiWhatsappService;
//        this.userRepository = userRepository;
//    }
//
//    public void sendMessagesToUsers() {
//        List<User> users = userRepository.findAll(); // Assuming this retrieves all users
//
//        for (User user : users) {
//            MessageBodyDTO messageBodyDTO = createMessageBody(user);
//            apiWhatsappService.sendMessage(messageBodyDTO);
//        }
//    }
//
//    private MessageBodyDTO createMessageBody(User user) {
//        // Assuming you construct the MessageBodyDTO based on User details
//        String recipientNumber = user.getContact(); // Adjust this based on your User model
//        String message = "Hello " + user.getUserName() + ", this is a test message.";
//
//        return new MessageBodyDTO(recipientNumber, message);
//    }
//}
//
