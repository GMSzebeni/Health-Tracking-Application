import axios from "axios";

const DATA_SAVE_API_BASE_URL = 'http://localhost:8080/api/user/save-data';

class VitalHealthSignService {
    saveHeartRate(saveHeartRateDTO){
        return axios.post(DATA_SAVE_API_BASE_URL + '/heart-rate', saveHeartRateDTO, { withCredentials: true });
    }

    saveBloodPressure(saveBloodPressureDTO) {
        return axios.post(DATA_SAVE_API_BASE_URL + '/blood-pressure', saveBloodPressureDTO, { withCredentials: true });
    }

    saveWeight(saveWeightDTO) {
        return axios.post(DATA_SAVE_API_BASE_URL + '/weight', saveWeightDTO, { withCredentials: true });
    }
}
export default new VitalHealthSignService();