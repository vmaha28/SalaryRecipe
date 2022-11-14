import {
	Box,
	FormControl,
	InputLabel,
	MenuItem,
	Paper,
	Select,
	SelectChangeEvent,
	Table,
	TableBody,
	TableCell,
	TableContainer,
	TableHead,
	TablePagination,
	TableRow,
	Typography,
} from '@mui/material';
import React, { useEffect, useState } from 'react';

import { Employee } from '../model/Employee';
import UserService from '../services/UserService';
import Pagination from './Pagination';

const Users = () => {
	const [employees, setEmployees] = useState<Employee[]>([]);
	const [displayedEmployees, setDisplayedEmployees] = useState<Employee[]>(
		[]
	);
	const [selectedEmployee, setSelectedEmployee] = useState('');
	const [pageSize, setPageSize] = useState(3);
	const [pageIndex, setPageIndex] = useState(1);
	const [totalRecords, setTotalRecords] = useState(0);

	useEffect(() => {
		UserService.getEmployeesPaginated(pageIndex - 1, pageSize).then(
			(response) => {
				setEmployees(response.data.results);
				setDisplayedEmployees(response.data.results);
				setSelectedEmployee(response.data.results.length);
				setTotalRecords(response.data.totalRecords);
			}
		);
	}, []);

	const handleChange = (event: SelectChangeEvent) => {
		setSelectedEmployee(event.target.value);
		if (JSON.parse(event.target.value) === employees.length) {
			setDisplayedEmployees(employees);
		} else {
			setDisplayedEmployees([employees[JSON.parse(event.target.value)]]);
		}
	};

	const onPageChanged = (pageNumber: number) => {
		console.log(pageNumber);
		UserService.getEmployeesPaginated(pageNumber - 1, pageSize).then(
			(response) => {
				setEmployees(response.data.results);
				setDisplayedEmployees(response.data.results);
				setSelectedEmployee(response.data.results.length);
				setTotalRecords(response.data.totalRecords);
			}
		);
	};

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
						value={selectedEmployee}
						onChange={handleChange}
						autoWidth
						label="Employees"
					>
						{employees.map((employee, index) => (
							<MenuItem key={index} value={index}>
								{employee.name}
							</MenuItem>
						))}
						<MenuItem value={employees.length}>{'All'}</MenuItem>
					</Select>
				</FormControl>
			</Box>
			<TableContainer component={Paper}>
				<Table sx={{ minWidth: 650 }} aria-label="simple table">
					<TableHead>
						<TableRow>
							<TableCell align="center">Name</TableCell>
							<TableCell align="center">Surname</TableCell>
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
					{displayedEmployees && (
						<TableBody>
							{displayedEmployees.map((employee, index) => (
								<TableRow key={index}>
									<TableCell align="center">
										{employee.name}
									</TableCell>
									<TableCell align="center">
										{employee.surname}
									</TableCell>
									<TableCell align="center">
										{employee.hoursWorked}
									</TableCell>
									<TableCell align="center">
										{employee.overtimeWorked}
									</TableCell>
									<TableCell align="center">
										{employee.salary.baseSalaryPerHour}
									</TableCell>
									<TableCell align="center">
										{employee.salary.salaryOvertime}
									</TableCell>
									<TableCell align="center">
										{employee.salary.employeeIncreas}
									</TableCell>
									<TableCell align="center">
										{(employee.salary.baseSalaryPerHour *
											employee.hoursWorked +
											employee.salary.salaryOvertime *
												employee.overtimeWorked) *
											(employee.salary.employeeIncreas /
												100) +
											employee.salary.baseSalaryPerHour *
												employee.hoursWorked +
											employee.salary.salaryOvertime *
												employee.overtimeWorked}
									</TableCell>
								</TableRow>
							))}
						</TableBody>
					)}
				</Table>
				<Pagination
					totalRecords={totalRecords}
					pageSize={pageSize}
					pageIndex={pageIndex}
					onPageChanged={onPageChanged}
				></Pagination>
			</TableContainer>
		</div>
	);
};

export default Users;
