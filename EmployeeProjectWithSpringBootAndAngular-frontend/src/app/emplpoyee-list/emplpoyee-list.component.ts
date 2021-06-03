import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee'
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-emplpoyee-list',
  templateUrl: './emplpoyee-list.component.html',
  styleUrls: ['./emplpoyee-list.component.css']
})
export class EmplpoyeeListComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService,
    private router: Router) {  }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees=data;
    });
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id: number){
   this.employeeService.deleteEmployee(id).subscribe(data => {
     console.log(data);
     this.getEmployees();
   })
  }

  employeeDetails(id: number){
    this.router.navigate(['employee-details',id]);
  }

}
