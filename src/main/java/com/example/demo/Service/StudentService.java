package com.example.demo.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;


	@SuppressWarnings("deprecation")
	public void addData(MultipartFile excelFile) throws IOException {
		Workbook workbook = new XSSFWorkbook(excelFile.getInputStream());
		Sheet sheet = workbook.getSheet("data");
		DataFormatter dft = new DataFormatter();
		
		List<Student> listStudents = new ArrayList<Student>();
		for (int i = 5 ; i < sheet.getPhysicalNumberOfRows() ; i++) {
			Row row = sheet.getRow(i);
			Student s = new Student();
			
			s.setTruonghoc(dft.formatCellValue(row.getCell(1)).trim());
			s.setQuanhuyen(dft.formatCellValue(row.getCell(2)).trim());
			s.setMa(dft.formatCellValue(row.getCell(3)).trim());
			s.setLop(dft.formatCellValue(row.getCell(4)).trim());
			s.setHoten(dft.formatCellValue(row.getCell(5)).trim());
		
			s.setNgaysinh(row.getCell(8) + "/" + row.getCell(7) + "/" +row.getCell(6));
			
			s.setGioitinh(dft.formatCellValue(row.getCell(9)).trim());
			s.setNoisinh(dft.formatCellValue(row.getCell(10)).trim());
			s.setDantoc(dft.formatCellValue(row.getCell(11)).trim());
			s.setHokhau(dft.formatCellValue(row.getCell(12)).trim());
			s.setDienthoai(dft.formatCellValue(row.getCell(13)).trim());
			s.setDiem1(Double.parseDouble(dft.formatCellValue(row.getCell(14))));
			s.setDiem2(Double.parseDouble(dft.formatCellValue(row.getCell(15))));
			s.setDiem3(Double.parseDouble(dft.formatCellValue(row.getCell(16))));
			s.setDiem4(Double.parseDouble(dft.formatCellValue(row.getCell(17))));
			s.setDiem5(Double.parseDouble(dft.formatCellValue(row.getCell(18))));
			s.setTong5diem(s.getDiem1() + s.getDiem2() + s.getDiem3() + s.getDiem4() + s.getDiem5());
				
			if(row.getCell(20).getCellType() != Cell.CELL_TYPE_BLANK) {
				s.setDiemUT(Double.parseDouble(dft.formatCellValue(row.getCell(20))));
			}
			else {
				s.setDiemUT(0.0);
			}
			
			s.setDiem(s.getTong5diem() + s.getDiemUT());
			s.setNote(dft.formatCellValue(row.getCell(22)).trim());
			
			listStudents.add(s);
		}
		studentRepository.saveAll(listStudents);
		
	}
	
//	public List<Student> getAllStudent() {
//		return studentRepository.findAll();
//	}
//	
//	public List<Student> findStudent(String args) {
//		List<Student> list = new ArrayList<Student>();
//		return list;
//	}
	
	public List<Student> findByName(String name) {
		List<Student> list = new ArrayList<Student>();
		list = studentRepository.findStudentByName(name);
		return list; 
	}
	
	public List<Student> findById(String id) {
		List<Student> list = new ArrayList<Student>();
		list = studentRepository.findStudentById(id);
		return list;
	}

}
