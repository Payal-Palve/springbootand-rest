package com.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.DaoClass;
import com.pojo.Account;

@Controller
public class UserController {

	@RequestMapping("/validate")
	public String validateshow(HttpServletRequest request) {
		System.out.println("validation start");
		DaoClass dao = new DaoClass();
		Account ac = dao.validateUser(request.getParameter("username"), request.getParameter("password"));
		if (ac != null) {
			System.out.println("validate user succeusfully");
			System.out.println(ac);

			HttpSession session = request.getSession();
			session.setAttribute("customer", ac);
			return "transaction";
		} else {
			System.out.println("invalid");
			return "login";
		}
	}

	@RequestMapping("/registerUser")
	public String registerUser(HttpServletRequest request) {
		System.out.println("validation start");
		DaoClass dao = new DaoClass();
		Account ac = new Account(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
				Integer.parseInt(request.getParameter("deposit")), request.getParameter("username"),
				request.getParameter("password"));
		dao.insertData(ac);
		System.out.println("data inserted ........................");
		System.out.println(ac);
		HttpSession session = request.getSession();
		session.setAttribute("customer", ac);

		// Retrieve the account object stored in the session
		Account ac1 = (Account) session.getAttribute("customer");
		return "transaction";
	}

	@RequestMapping("/deposit")
	public String depositAmount(HttpServletRequest request) {
		System.out.println("deposit controller called...........");
		DaoClass dao = new DaoClass();
		HttpSession session = request.getSession();
		Account ac = (Account) session.getAttribute("customer");

		if (ac != null) {
			try {
				int depositAmount = Integer.parseInt(request.getParameter("depositAmount"));
				dao.depositAmount(ac.getAc_id(), depositAmount);
				System.out.println("Amount deposited successfully for account ID: " + ac.getAc_id());
				
				return "process";
			} catch (NumberFormatException e) {
				System.err.println("Invalid deposit amount: " + request.getParameter("depositAmount"));
				return "error";
			} catch (Exception e) {
				System.err.println("Error occurred during deposit: " + e.getMessage());
				return "error";
			}
		} else {

			System.err.println("No active session found. Please log in again.");
			return "login";
		}

	}
	
	@RequestMapping("/withdraw")
	public String withdrawAmount(HttpServletRequest request) {
		System.out.println("withdraw controller called...........");
		DaoClass dao = new DaoClass();
		HttpSession session = request.getSession();
		Account ac = (Account) session.getAttribute("customer");

		if (ac != null) {
			try {
				int Amount = Integer.parseInt(request.getParameter("withdrawAmount"));
				dao.withdrawAmount(ac.getAc_id(), Amount);
				System.out.println("Amount withdraw successfully for account ID: " + ac.getAc_id());
				return "process";
			} catch (NumberFormatException e) {
				System.err.println("Invalid deposit amount: " + request.getParameter("withdrawAmount"));
				return "error";
			} catch (Exception e) {
				System.err.println("Error occurred during deposit: " + e.getMessage());
				return "error";
			}
		} else {

			System.err.println("No active session found. Please log in again.");
			return "login";
		}

	}
	
	@RequestMapping("/transferAmount")
	public String transferAmount(HttpServletRequest req) {
		System.out.println("transfer controller called...........");
		DaoClass dao = new DaoClass();
		HttpSession session = req.getSession();
		Account ac = (Account) session.getAttribute("customer");
		if (ac != null) {
			try {
				int Amount = Integer.parseInt(req.getParameter("transferAmount"));
				dao.withdrawAmount(ac.getAc_id(), Amount);
				System.out.println("Amount withdraw successfully for account ID: " + ac.getAc_id());
				int destId=Integer.parseInt(req.getParameter("destinationAccountId"));
				dao.depositAmount(destId, Amount);
				return "process";
			} catch (NumberFormatException e) {
				System.err.println("Invalid deposit amount: " + req.getParameter("transferAmount"));
				return "error";
			} catch (Exception e) {
				System.err.println("Error occurred during deposit: " + e.getMessage());
				return "error";
			}
		} else {

			System.err.println("No active session found. Please log in again.");
			return "login";
		}
		
	}
}
