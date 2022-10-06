import {
	Paper,
	Tab,
	Table,
	TableBody,
	TableCell,
	TableContainer,
	TableHead,
	TableRow,
	Tabs,
} from '@mui/material';
import axios from 'axios';
import React, { FC, useEffect, useState } from 'react';
import './App.css';
import { Employee } from './model/Employee';

const App: FC = () => {
	const [employees, setEmployees] = useState<Employee[]>([]);
	const [singleEmployee, setEmployeeId] = useState<Employee>();
	const [value, setValue] = React.useState(0);

	useEffect(() => {
		axios
			.get('http://localhost:8888/employee')
			.then((response) => setEmployees(response.data));
	}, []);

	return (
		<div className="App">
			<TableContainer component={Paper}>
				<Table sx={{ minWidth: 650 }} aria-label="simple table">
					<TableHead>
						<TableRow>
							<TableCell align="center">Name</TableCell>
							<TableCell align="center">Hours worked</TableCell>
							<TableCell align="center">Base salary</TableCell>
							<TableCell align="center">Salary</TableCell>
						</TableRow>
					</TableHead>
					<TableBody>
						{employees.map((employee: Employee) => (
							<TableRow
								key={employee.name}
					
							>
								<TableCell align="center">
									{employee.name}
								</TableCell>
								<TableCell align="center">
									{employee.hoursWorked}
								</TableCell>
								<TableCell align="center">
									{employee.salary.baseSalaryPerHour}
								</TableCell>
								<TableCell align="center">
									{employee.salary.baseSalaryPerHour * employee.hoursWorked}
								</TableCell>
							</TableRow>
						))}
					</TableBody>
				</Table>
			</TableContainer>
		</div>
	);
};

export default App;
