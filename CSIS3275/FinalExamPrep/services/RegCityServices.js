import http from "../http-common.js";

class RegCityServices {
    
    //POST Method - create new data
    RegCity(cityName, parksNum){
        const newItem = {
            "name": cityName,
            "parks": parksNum
        }
        return http.post("/cities", newItem);
    }

    // Show all cities
    getCities(){
        return http.get("/cities");
    }

    // Delete city
    delCity(cityId){
        return http.delete(`/cities/${cityId}`);
    }

    // Update city
    updateCity(cityId, cityName, parksNum){
        const updateItem = {
            "name": cityName,
            "parks": parksNum
        }
        return http.put(`/cities/${cityId}`, updateItem);
    }

    // Show city by ID
    getCity(cityId){
        return http.get(`/cities/${cityId}`);
    }

    // Delete all cities
    delCities(){
        return http.delete("/cities");
    }
}

export default new RegCityServices();