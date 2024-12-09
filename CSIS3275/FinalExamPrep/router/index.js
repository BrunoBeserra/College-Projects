import { createWebHistory, createRouter } from "vue-router";
import CityRegister from "../components/CityRegister.vue";

const routes = [
    {
        path: "/",
        alias: "/cities",
        name: "cityRegister",
        component: CityRegister
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;