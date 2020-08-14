//package Summa.io.StockWallet.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import Summa.io.StockWallet.Entity.User;
//import Summa.io.StockWallet.Repository.UserRepository;
//
//
//@Service
//public class UserService {
//	
//	@Autowired
//	private UserRepository repository;
//	
////	post methods
//	public User saveUser(User user) {
//		return repository.save(user);
//	}
//
////	all methods
//	public List<User> saveUser(List<User> user){
//		return repository.saveAll(user);
//	}
//	
////	 get methods
//	public List<User> getUser(){
//		return repository.findAll();
//	}
//	
////	all
//	public User getUserById(Long id) {
//		return repository.findById(id).orElse(null);
//	}
//	
////	by name
//	public User getUserByName(String name) {
//		return repository.findByUsername(name);
//	}
//	
////	to delete
//	public String deleteUser(Long id) {
//		return "The user"+id+"has been removed";
//	}
//	
////	to update
//	public User updateUser(User user) {
////		User existingUser=repository.findById(user.getId()).orElse(null);
////		existingUser.setUserName(user.getUserName());
////		existingUser.setEmail(user.getEmail());
////		return repository.save(existingUser);
//		return null;
//	}
//}