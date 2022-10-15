import {
	Box,
	FormControl,
	InputLabel,
	MenuItem,
	Paper,
	Select,
	Tab,
	Table,
	TableBody,
	TableCell,
	TableContainer,
	TableHead,
	TableRow,
	Tabs,
	Typography,
} from '@mui/material';
import axios from 'axios';
import React, { FC, useEffect, useState } from 'react';
import './App.css';
import { Employee } from './model/Employee';

const App: FC = () => {
	const [employees, setEmployees] = useState<Employee[]>([]);
	const [selectedEmployee, setSelectedEmployee] = useState<Employee>();
	const [value, setValue] = React.useState(0);

	useEffect(() => {
		axios
			.get('http://localhost:8888/employee')
			.then((response) => setEmployees(response.data)).then(()=> setSelectedEmployee(employees[0]))
	}, []);

	return (
		<div className="App">
				<Box sx={{ flex: 'center', justifyContent: 'center' }}>
					<h1>
						<Typography> Please Select an Employee: </Typography>
					</h1>
					<FormControl sx={{ m: 1, minWidth: 120 }}>
						<InputLabel id="Employee-select-helper-label">
							Employee
						</InputLabel>
						<Select
							labelId="Employee-select-label"
							id="Employee-simple-select"
							value={JSON.stringify(selectedEmployee)}
							autoWidth
							label="Employees"
							onChange={(e) => {
								setSelectedEmployee(JSON.parse(e.target.value));
							}}
							renderValue={(employee) => {
								return JSON.parse(employee).name;
							}}
						>
							{employees.map((employee) => (
								<MenuItem value={JSON.stringify(employee)}>
									{employee.name}
								</MenuItem>
							))}
						</Select>
					</FormControl>
				</Box>
			<TableContainer component={Paper}>
				<Table sx={{ minWidth: 650 }} aria-label="simple table">
					<TableHead>
						<TableRow>
							<TableCell align="center">Name</TableCell>
							<TableCell align="center">Hours Worked</TableCell>
							<TableCell align="center">OverTime Hours</TableCell>
							<TableCell align="center">Base salary</TableCell>
							<TableCell align="center">
								OverTime salary
							</TableCell>
							<TableCell align="center">Increases</TableCell>
							<TableCell align="center">Salary</TableCell>
						</TableRow>
					</TableHead>
					{selectedEmployee && (
						<TableBody>
							<TableRow key={selectedEmployee.name}>
								<TableCell align="center">
									{selectedEmployee.name}
								</TableCell>
								<TableCell align="center">
									{selectedEmployee.hoursWorked}
								</TableCell>
								<TableCell align="center">
									{selectedEmployee.overtimeWorked}
								</TableCell>
								<TableCell align="center">
									{selectedEmployee.salary.baseSalaryPerHour}
								</TableCell>
								<TableCell align="center">
									{selectedEmployee.salary.salaryOvertime}
								</TableCell>
								<TableCell align="center">
									{selectedEmployee.salary.employeeIncreas}
								</TableCell>
								<TableCell align="center">
									{(selectedEmployee.salary
										.baseSalaryPerHour *
										selectedEmployee.hoursWorked +
										selectedEmployee.salary.salaryOvertime *
											selectedEmployee.overtimeWorked) *
										(selectedEmployee.salary
											.employeeIncreas /
											100) +
										selectedEmployee.salary
											.baseSalaryPerHour *
											selectedEmployee.hoursWorked +
										selectedEmployee.salary.salaryOvertime *
											selectedEmployee.overtimeWorked}
								</TableCell>
							</TableRow>
						</TableBody>
					)}
				</Table>
			</TableContainer>
		</div>
	);
};

export default App;
