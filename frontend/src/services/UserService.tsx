import axiosService from './AxiosService';

const getPublicContent = () => {
	return axiosService.get('employee');
};

const getUserBoard = () => {
	return axiosService.get('forUser');
};

const getAdminBoard = () => {
	return axiosService.get('forAdmin');
};

const getEmployeesPaginated = (pageIndex: number, pageSize: number) => {
	const queryParams = {
		pageIndex,
		pageSize,
	};
	return axiosService.get('employee', { params: queryParams });
};

const UserService = {
	getPublicContent,
	getUserBoard,
	getAdminBoard,
	getEmployeesPaginated,
};

export default UserService;
