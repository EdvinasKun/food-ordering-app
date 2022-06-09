import axios from "axios";

import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/establishment/";

// function establishmentService() {
//   return (
//     <div>establishmentService</div>
//   )
// }

const getEstablishments = () =>{
    return axios
    .get(API_URL + "all", { headers: authHeader() } );
   
      
}
const insertEstablihsment = (establishmentName, code, address) =>{
    return axios.post(API_URL, { headers: authHeader() }, {
        establishmentName,
        code,
        address
      });
}
const deleteEstablishment = (id) =>{
    return axios.post(API_URL + id , { headers: authHeader() });
}

export default {
    getEstablishments,
    deleteEstablishment,
    insertEstablihsment
}
