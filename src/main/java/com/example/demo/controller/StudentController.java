package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.StudentService;
import com.example.demo.entity.Student;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/")
	public String index() {
		return "redirect:/import";
	}
	
	@GetMapping("/import")
	public String upload() {
		return "import";
	}
	
	@PostMapping("/upload") 
	public String uploadFileExcel(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
		
		if(file.isEmpty()) {
			attributes.addFlashAttribute("msg" , "Chọn file");
			return "redirect:/import";
		}
		else {
			studentService.addData(file);
			attributes.addFlashAttribute("msg", "Tải file thành công");
		}	
		return "redirect:/import";
	}
	
	@GetMapping("/search")
	public String searchPage() {
		return "search";
	}
	
	@PostMapping("/search")
	public String search(@Param("hoten") String hoten , @Param("ma") String ma , Model model,RedirectAttributes attributes) {
		if(ma == "" && hoten == "") {
			attributes.addFlashAttribute("msg", "Nhập thông tin để tìm kiếm");
			return "redirect:/search";
		}
		else {
			if(ma == "") {
				List<Student> list  = studentService.findByName(hoten);
				if(list.isEmpty()) {
					attributes.addFlashAttribute("msg", "Không tìm thấy tên học sinh");
					return "redirect:/search";
				}
				else {
					model.addAttribute("studentList" , list );
					return "search";
				}
			}
			else {
				List<Student> list  = studentService.findById(ma);
				if(list.isEmpty()) {
					attributes.addFlashAttribute("msg", "Không tìm thấy mã học sinh");
					return "redirect:/search";
				}
				else {
					model.addAttribute("studentList" , list );
					return "search";
				}
			}
		}		
	}
}
