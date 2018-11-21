package com.poscoict.sample.sp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "RestTemplate 테스트", description = "GlueRestClientAcivity 테스트용입니다.", tags = { "RestTemplate 테스트" })
@RestController
@RequestMapping(value = "/dept")
public class DeptController {
	private List<Dept> deptList = new ArrayList<>();

	@GetMapping
	public List<Dept> getDeptList() {
		System.out.println("GET /dept");
		return this.deptList;
	}

	@PostMapping
	public void addDept(@RequestBody Dept dept) {
		System.out.println("POST /dept");
		this.deptList.add(dept);
	}

	@PutMapping(path = "{deptno}")
	public void updateDept(@PathVariable String deptno, @RequestBody Dept data) {
		System.out.println("PUT /dept/{deptno}");
		for (Dept dept : deptList) {
			if (deptno.equals(dept.getDeptno())) {
				dept.setDloc(data.getDloc());
				dept.setDname(data.getDname());
			}
		}
	}

	@DeleteMapping(path = "{deptno}")
	public void deleteDept(@PathVariable String deptno) {
		System.out.println("DELETE /dept/{deptno}");
		for (Dept dept : deptList) {
			if (deptno.equals(dept.getDeptno())) {
				deptList.remove(dept);
			}
		}
	}
}
