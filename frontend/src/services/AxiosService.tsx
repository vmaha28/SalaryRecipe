import axios from 'axios';

const axiosService = axios.create();

axiosService.interceptors.request.use(
	(config: any) => {
		console.log(config);

		const jwtToken = localStorage.getItem('token');

		if (jwtToken) {
			config.headers['Authorization'] = 'Bearer ' + jwtToken;
		}
		// config.headers['Content-Type'] = 'application/json';
		return config;
	},
	(error) => {
		Promise.reject(error);
	}
);

export default axiosService;
