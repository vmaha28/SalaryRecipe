import axiosService from './AxiosService';

const register = (
	username: string,
	userFirstName: string,
	userLastName: string,
	userPassword: string,
	role: string
) => {
	return axiosService.post('registerNewUser', {
		username,
		userFirstName,
		userLastName,
		userPassword,
		role,
	});
};

const login = (username: string, userPassword: string) => {
	return axiosService
		.post('authenticate', {
			userName: username,
			userPassword,
		})
		.then((response) => {
			if (response?.data?.jwtToken) {
				localStorage.setItem('token', response.data.jwtToken);
			}

			return response.data;
		});
};

// const logout = () => {
//   localStorage.removeItem("user");
// };

// const getCurrentUser = () => {
//   return JSON.parse(localStorage.getItem("user"));
// };

const AuthService = {
	register,
	login,
	//   logout,
	//   getCurrentUser,
};

export default AuthService;
