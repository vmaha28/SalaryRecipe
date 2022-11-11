import axios from 'axios';

const API_URL = 'http://localhost:8888/';

const axiosService = axios.create();

axiosService.interceptors.request.use(
	(config: any) => {
		const jwtToken = localStorage.getItem('token');

		if (jwtToken) {
			config.headers['Authorization'] = 'Bearer ' + jwtToken;
		}

		config.url = API_URL + config.url;
		// config.headers['Content-Type'] = 'application/json';
		return config;
	},
	(error) => {
		Promise.reject(error);
	}
);

export default axiosService;
