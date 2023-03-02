import axios from 'axios';

export const getCollectionData = async () => {
    try{
        // console.log(process.env.REACT_APP_BACKEND_ROUTE)
        const {data:{data}} = await axios.get(`http://${process.env.REACT_APP_BACKEND_ROUTE}/api/collections/testuser/restaurants/`, {
            headers: {
                'Content-Type': 'application/json',
            }
        });

        console.log(data);
        return data;
    } catch (error){
        console.log(error);
    }
}

export const postCollectionData = async(payload) => {
    try{
        // console.log(payload)
        const result = await axios.post(`http://${process.env.REACT_APP_BACKEND_ROUTE}/api/collections/testuser/restaurants/`, payload
        );
        // console.log(result);
    }catch (error){
        console.log(error);
    }
}
