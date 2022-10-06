import { Employee } from "./Employee"

export interface Salary {
    id: number
    baseSalaryPerHour: number
    salaryOvertime: number
    employeeIncreas: number
    employee: Employee
}

