package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;

@Controller
@RequestMapping("/student.do")
public class StudentController {
	protected final transient Log log = LogFactory.getLog(StudentController.class);
	@Autowired
	private StudentService studentService;

	public StudentController() {

	}

	@RequestMapping
	public String load(ModelMap modelMap) {
		List<Object> list = studentService.getStudentList();
		modelMap.put("list", list);
		return "student";
	}

	@RequestMapping(params = "method=add")
	public String add(HttpServletRequest request, ModelMap modelMap) throws Exception {
		return "student_add";
	}
	
	@RequestMapping(params = "method=edit")
	public String edit(@RequestParam("id") String id, HttpServletResponse response,ModelMap modelMap) throws Exception {
		Student st = new Student();
		st.setId(Integer.valueOf(id));
		List<Object> info = studentService.getStudentInfo(st);
		modelMap.put("info", info);
		return "student_edit";
	}

	@RequestMapping(params = "method=save")
	public String save(HttpServletRequest request, ModelMap modelMap) {
		String user = request.getParameter("user");
		String psw = request.getParameter("password");
		Student st = new Student();
		st.setUser(user);
		st.setPsw(psw);
		try {
			studentService.save(st);
			modelMap.put("addstate", "添加成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			modelMap.put("addstate", "添加失败");
		}

		return "student_add";
	}

	@RequestMapping(params = "method=update")
	public void update(HttpServletRequest request ,HttpServletResponse response) {
		try {
			Student st = new Student();
			//int id = request.getParameter("id");
			String user = request.getParameter("user");
			String psw = request.getParameter("password");
			st.setUser(user);
			st.setPsw(psw);
			st.setId(Integer.valueOf(request.getParameter("id")));
			studentService.update(st);
			response.getWriter().print("{\"update\":\"true\"}");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@RequestMapping(params = "method=del")
	public void del(@RequestParam("id") String id, HttpServletResponse response) {
		try {
			Student st = new Student();
			st.setId(Integer.valueOf(id));
			studentService.delete(st);
			response.getWriter().print("{\"del\":\"true\"}");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
