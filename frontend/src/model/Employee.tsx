import { Salary } from "./Salary"

export interface Employee{
    id: number
    name: string
    hoursWorked: number
    overtimeWorked: number
    salary: Salary
}

