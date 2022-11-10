import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import AuthService from '../services/AuthService';

const required = (value: any) => {
	if (!value) {
		return (
			<div className="alert alert-danger" role="alert">
				This field is required!
			</div>
		);
	}
};

const Login = () => {
	let navigate = useNavigate();

	const [username, setUsername] = useState('');
	const [userPassword, setPassword] = useState('');
	const [loading, setLoading] = useState(false);
	const [message, setMessage] = useState('');

	const onChangeUsername = (e: any) => {
		const username = e.target.value;
		setUsername(username);
	};

	const onChangePassword = (e: any) => {
		const userPassword = e.target.value;
		setPassword(userPassword);
	};

	const handleLogin = (e: any) => {
		e.preventDefault();

		setMessage('');
		setLoading(true);

		AuthService.login(username, userPassword).then(
			(response: any) => {
				console.log(response);
				navigate('users');
			},
			(error: any) => {
				const resMessage =
					(error.response &&
						error.response.data &&
						error.response.data.message) ||
					error.message ||
					error.toString();

				setLoading(false);
				setMessage(resMessage);
			}
		);
	};

	return (
		<div
			className="col-md-12"
			style={{ display: 'flex', justifyContent: 'center' }}
		>
			<div className="card card-container" style={{ width: '400px' }}>
				<div className="form-group">
					<label htmlFor="username">Username</label>
					<input
						type="text"
						className="form-control"
						name="username"
						value={username}
						onChange={onChangeUsername}
					/>
				</div>

				<div className="form-group">
					<label htmlFor="password">Password</label>
					<input
						type="password"
						className="form-control"
						name="password"
						value={userPassword}
						onChange={onChangePassword}
					/>
				</div>

				<div className="form-group">
					<button
						className="btn btn-primary btn-block"
						disabled={loading}
						onClick={handleLogin}
					>
						{loading && (
							<span className="spinner-border spinner-border-sm"></span>
						)}
						<span>Login</span>
					</button>
				</div>

				{message && (
					<div className="form-group">
						<div className="alert alert-danger" role="alert">
							{message}
						</div>
					</div>
				)}
			</div>
		</div>
	);
};

export default Login;
