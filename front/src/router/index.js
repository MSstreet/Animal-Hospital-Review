import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/PageHome.vue'
import List from "../views/board/BoardList.vue"
import Detail from "../views/board/BoardDetail.vue"
import Write from "../views/board/BoardWrite.vue"
import Login from "../views/common/UserLogin.vue"


const requireAuth = () => (from, to, next) => {
    const token = localStorage.getItem('user_token')

    if (token) {

        return next()
    } // isLogin === true면 페이지 이동
    next('/login') // isLogin === false면 다시 로그인 화면으로 이동
}

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login  //로그인 컴포넌트 추가
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/PageAbout.vue')
    },
    {
        path: '/board/list',
        name: 'List',
        component: List
    },
    {
        path: '/board/detail',
        name: 'Detail',
        component: Detail,
        beforeEnter: requireAuth()
    },
    {
        path: '/board/write',
        name: 'Write',
        component: Write,
        beforeEnter: requireAuth()
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router