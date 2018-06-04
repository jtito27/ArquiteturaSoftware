package br.usjt.arqsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Login;
import br.usjt.arqsw.service.LoginService;

@Controller
public class LoginController {
	private LoginService ls;

	@Autowired
	public LoginController(LoginService ls) {
		this.ls = ls;
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Login login, HttpSession session) throws IOException {
		if (ls.validaLogin(login)) {
			session.setAttribute("usuarioLogado", login);
			return "index";
		}
		return "redirect:loginForm";
	}
}
