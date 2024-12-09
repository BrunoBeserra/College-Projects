<template>
    <div>
        <form className='enrolForm'>
            <h1>Register City</h1>
            <label>City name:</label>
            <input type="text" name="cname" v-model="cityName"/>
            <br />
            <label>City parks:</label>
            <input type="text" name="parksNum" v-model="parksNum"/>
            <br />
            <br />
            <input type='submit' value='Register' @click="handleSubmit" />
            <br />
            <label id="cityMsg" className="message">{{ registerMessage }}</label>
        </form>
    </div>
    <br />
    <div>
        <form className='delCity'>
            <h1>Delete City</h1>
            <label>City ID:</label>
            <input type="text" name="idcity" v-model="idcity"/>
            <br />
            <br />
            <input type='submit' value='Delete' @click="handleDelete" />
            <br />
            <label id="cityMsg2" className="message2">{{ registerMessage2 }}</label>
        </form>
    </div>
    <br />
    <div>
        <form className='updateForm'>
            <h1>Update City</h1>
            <label>ID City:</label>
            <input type="text" name="updidcity" v-model="updidcity"/>
            <br />
            <label>New city name:</label>
            <input type="text" name="updcname" v-model="cityName"/>
            <br />
            <label>New city parks:</label>
            <input type="text" name="parksNum" v-model="parksNum"/>
            <br />
            <br />
            <input type='submit' value='Update' @click="handleUpdate" />
            <br />
            <label id="cityMsg3" className="message">{{ registerMessage3 }}</label>
        </form>
    </div>
    <br />
    <div>
        <h1>List City</h1>
        <button id="listCities" @click="handleListCities">List Cities</button>
        <h2>Information Cities</h2>
        <ul v-if="sections.length">
            <li v-for="sec in sections" :key="sec.id">
                {{ sec.id }} {{ sec.name }} {{ sec.parks }}
            </li>
        </ul>        
    </div>
    <br />
    <div>
        <form className='cityForm'>
            <h1>City by ID</h1>
            <label>ID City:</label>
            <input type="text" name="idcityinf" v-model="idcityinf"/>
            <br />
            <br />
            <input type='submit' value='City Info' @click="handleCitiesById" />
            <br />
        </form>   
        <h2>Information City</h2>     
        <ul v-if="city.length">
            <li v-for="cityInf in city" :key="cityInf.id">
                {{ cityInf.id }} {{ cityInf.name }} {{ cityInf.parks }}
            </li>
        </ul>        
    </div>

    <br />
    <div>
        <h1>Delete all Cities</h1>
        <button id="deleteCities" @click="handleDeleteCities">Delete All Cities</button>
    </div>


</template>

<script>
import RegCityServices from "../services/RegCityServices.js";

export default {
    name: "cityRegister",
    data(){
        return {
            registerMessage: "",
            registerMessage2: "",
            registerMessage3: "",
            cname: "",
            cparks: "",
            sections: [],
            idcity: "",
            updcname: "",
            updcparks: "",
            updidcity: "",
            city: [],
            idcityinf: ""
        }
    },
    methods: {
        handleSubmit(event){
            event.preventDefault();
            RegCityServices.RegCity(this.cityName, this.parksNum)
                .then(response => {
                    const newRegistration = response.data;
                    console.log(newRegistration);
                    this.registerMessage = `Register city ${this.cityName} with ${this.parksNum} parks`;
                    console.log(this.registerMessage);                
                })
                .catch(error => {
                    this.registerMessage = error;
                    console.log(error);
                })
            },
            handleDelete(event){
            event.preventDefault();
            RegCityServices.delCity(this.cityId)
            .then(response => {
                    const newRegistration = response.data;
                    console.log(newRegistration);
                    this.registerMessage2 = `City ID ${this.cityId} deleted`;
                    console.log(this.registerMessage);                
                })
                .catch(error => {
                    this.registerMessage2 = error;
                    console.log(error);
                })            
            },

            handleUpdate(event){
                event.preventDefault();
                RegCityServices.updateCity(this.cityId, this.cityName, this.updcparks)
                    .then(response => {
                        const newRegistration = response.data;
                        console.log(newRegistration);
                        this.registerMessage = `City ID ${this.cityId} updated`;
                        console.log(this.registerMessage);                
                    })
                    .catch(error => {
                        this.registerMessage = error;
                        console.log(error);
                    })
            },

            handleCitiesById(event){
                event.preventDefault();
                RegCityServices.getCity(this.cityId)
                    .then(response => {
                            //this.city = response.data;
                            this.city = Array.isArray(response.data) ? response.data : [response.data];
                        })
                        .catch(error =>{
                            console.log(error)
                        })            
            },

            handleListCities(event){
                event.preventDefault();
                RegCityServices.getCities()
                    .then(response => {
                        this.sections = response.data;
                    })
                    .catch(error =>{
                        console.log(error)
                    })            
            },

            handleDeleteCities(event){
                event.preventDefault();
                RegCityServices.delCities()
                    .then(response => {
                        this.sections = response.data;
                    })
                    .catch(error =>{
                        console.log(error)
                    })            
            }
    },
    mounted() {
        
    },
}

</script>

<style scoped>
.container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    font-family: 'Arial', sans-serif;
}

.card {
    background-color: #f9f9f9;
    border-radius: 8px;
    padding: 20px;
    margin-bottom: 15px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

h2 {
    color: #333;
    margin-bottom: 15px;
    border-bottom: 2px solid #e0e0e0;
    padding-bottom: 10px;
}

.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 5px;
    color: #666;
}

input {
    width: 100%;
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
    transition: border-color 0.3s;
}

input:focus {
    outline: none;
    border-color: #007bff;
}

button {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.btn-primary {
    background-color: #28a745;
    color: white;
}

.btn-danger {
    background-color: #dc3545;
    color: white;
}

.btn-update {
    background-color: #17a2b8;
    color: white;
}

.btn-secondary {
    background-color: #6c757d;
    color: white;
}

.btn-danger-outline {
    background-color: white;
    color: #dc3545;
    border: 2px solid #dc3545;
}

.message {
    color: #666;
    margin-top: 10px;
    font-style: italic;
}

.city-list {
    list-style-type: none;
    padding: 0;
}

.city-item {
    background-color: #f1f1f1;
    margin: 5px 0;
    padding: 10px;
    border-radius: 4px;
}
</style>