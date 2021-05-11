package com.websitenhaccu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.entity.Huyen;
import com.websitenhaccu.entity.Tinh;
import com.websitenhaccu.entity.Xa;
import com.websitenhaccu.service.UserService;

@Controller
public class Test {
	@Autowired
	UserService userService;

	Map<String, String> listTinh;
	Map<String, String> listHuyen;
	Map<String, String> listXa;

	@RequestMapping("/user-info")
	public ModelAndView getUser() {
		ModelAndView mav = new ModelAndView("User");
		
		Tinh tinh = new Tinh("1", "Thành phố Hồ Chí Minh");
		Huyen huyen = new Huyen("1", "Quận 1");
		Xa xa = new Xa("1", "Phường 1");
		
		initData();
		
		mav.addObject("listTinh", listTinh);
		mav.addObject("listHuyen", listHuyen);
		mav.addObject("listXa", listXa);
		mav.addObject("tinh", tinh);
		mav.addObject("huyen", huyen);
		mav.addObject("xa", xa);

		return mav;
	}

	public void initData() {
		List<Tinh> tinhs = new ArrayList<Tinh>();
		List<Huyen> huyens = new ArrayList<Huyen>();
		List<Xa> xas = new ArrayList<Xa>();

		Tinh tinh = new Tinh("1", "Thành phố Hồ Chí Minh");
		tinhs.add(tinh);
		tinh = new Tinh("2", "Tỉnh Bà Rịa-Vũng Tàu");
		tinhs.add(tinh);

		listTinh = new HashMap<String, String>();
		for (Tinh item : tinhs) {
			listTinh.put(item.getMaTinh(), item.getTenTinh());
		}

		Huyen huyen = new Huyen("1", "Quận 1");
		huyens.add(huyen);
		huyen = new Huyen("2", "Quận 2");
		huyens.add(huyen);
		huyen = new Huyen("3", "Quận 3");
		huyens.add(huyen);
		huyen = new Huyen("4", "Quận 4");
		huyens.add(huyen);

		listHuyen = new HashMap<String, String>();
		for (Huyen item : huyens) {
			listHuyen.put(item.getMaHuyen(), item.getTenHuyen());
		}

		Xa xa = new Xa("1", "Phường 1");
		xas.add(xa);
		xa = new Xa("2", "Phường 2");
		xas.add(xa);
		xa = new Xa("3", "Phường 3");
		xas.add(xa);
		xa = new Xa("4", "Phường 4");
		xas.add(xa);
		xa = new Xa("5", "Phường 5");
		xas.add(xa);
		xa = new Xa("6", "Phường 6");
		xas.add(xa);
		xa = new Xa("7", "Phường 7");
		xas.add(xa);

		listXa = new HashMap<String, String>();
		for (Xa item : xas) {
			listXa.put(item.getMaXa(), item.getTenXa());
		}

	}
//	@RequestMapping("/user-info")
//	public ModelAndView getUser() {
//		UserDTO user = userService.getByEmail("admin");
//		
//		return new ModelAndView("User", "user", user);
//	}

}
