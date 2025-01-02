import axios from 'axios'
import store from "@/vuex/store";

const getUserInfo = (userId,userPw,userEmail,userName,userZipCode,userAddress,userAddressDtl) => {
    const reqData = {
        'user_id': userId,
        'user_pw': userPw,
        'user_email': userEmail,
        'user_name': userName,
        'user_zip_code': userZipCode,
        'user_address': userAddress,
        'user_address_dtl': userAddressDtl,
    }

    let serverUrl = '//localhost:8081'

    return axios.post(serverUrl + '/user/join', reqData, {
        headers: {
            'Content-type': 'application/json'
        }
    })
}

export default {
    async doJoin(userId, userPw, userEmail,userName,userZipCode,userAddress,userAddressDtl) {
        try {
            const getUserInfoPromise = getUserInfo(userId, userPw,userEmail,userName,userZipCode,userAddress,userAddressDtl)
            const [userInfoResponse] = await Promise.all([getUserInfoPromise])
            if (userInfoResponse.data.length === 0) {
                return 'notFound'
            } else {
                return userInfoResponse
            }
        } catch (err) {
            console.error(err)
        }
    }
}