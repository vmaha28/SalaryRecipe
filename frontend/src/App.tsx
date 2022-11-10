import { Table } from '@mui/material';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { FC } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';

import Login from './components/Login';
import Users from './components/Users';

const App: FC = () => {
	return (
		<React.StrictMode>
			<BrowserRouter>
				<Routes>
					<Route path="/" element={<Login />} />
					<Route path="users" element={<Users />} />
				</Routes>
			</BrowserRouter>
		</React.StrictMode>
	);
};

export default App;
