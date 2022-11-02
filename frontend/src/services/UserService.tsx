import axiosService from "./AxiosService";

const API_URL = "http://localhost:8080/";

const getPublicContent = () => {
  return axiosService.get(API_URL + "employee");
};

const getUserBoard = () => {
  return axiosService.get(API_URL + "forUser");
};



const getAdminBoard = () => {
  return axiosService.get(API_URL + "forAdmin");
};

const UserService = {
  getPublicContent,
  getUserBoard,
  getAdminBoard,
};

export default UserService;