import axios from "axios";
import { useEffect, useState } from "react";

export default function Example2( props ) {
    // [1] 입력받은 데이터를 저장하는 폼 state 변수
    const [ formData , setFormData ] = useState({
        name : '',
        telno : ''        
    });

    // [2] 입력받은 데이터를 렌더링 하는 이벤트 함수
    const formDataChange = (e) => {    
        // 스프레드 연산자 이용한 state 변수 변경
        setFormData ( { ...formData , [e.target.name] : e.target.value } )
    }

    // [3] 현재 state 변수를 스프링 서버에게 보내기 , AXIOS
    const onPost = async (e) => {
        try {
            const response = await axios.post('http://192.168.40.74:8080/day07/react/task', formData) // state 변수를 axios 로 보내기
            
            if (response.data == true) {
                alert('등록성공')
                setFormData({name : '', telno : ''}) // state 초기화
                onFindAll(); // 등록 성공하면 자료 렌더링
            }
        } catch (e) {
            console.error(e)
        }
    }

    useEffect( () => { onFindAll() } , [] );
    const [ boards , setBoards ] = useState([]); // (2) 여러개의 방문록 가지는 state 변수

    const onFindAll = async ( e ) => {
        try {
            const response = await axios.get('http://192.168.40.74:8080/day07/react/task')
            setBoards(response.data) // 서버로부터 받은 정보를 state 변수에 저장 // 재렌더링

        } catch(error) {
            console.log(error)
        }
    }

    return (<>
        <div>
            <h4> 입력 폼 </h4>
            <form>
                이름 : <input type="text" value={formData.name} name='name' onChange={formDataChange}/> <br/>
                전화번호 : <input type="text" value={formData.telno} name='telno' onChange={formDataChange}/> <br/>                
                <button type="button" onClick={onPost}>등록</button>
            </form>

            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>전화번호</th>              
                        <th>비고</th>              
                    </tr>
                </thead>
                <tbody>
                    {
                        boards.map( (board , index) => {
                            return ( 
                                <tr>
                                    <td> { index } </td>                                    
                                    <td> { board.name } </td>
                                    <td> { board.telno } </td>
                                    <td> 수정버튼 / 삭제버튼 </td>                                                           
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    </>)
}