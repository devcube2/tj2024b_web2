/*
    리액트 과제2 : 아래 코드들을 사용하여 입력된 값들의 글자수를 실시간으로 출력하시오.
    카카오톡 제출 : ip로 제출
*/

import { useState } from "react";

export default function Task1() {
    // (1) 여기에 state 변수 만들기
    const [ wordCount , setWordCount ] = useState(0);
        
    const handleChange = (event) => {                
        console.log(event.target); // onChange 이벤트를 발생시킨 마크업(대상)
        console.log(event.target.value); // onChange 이벤트를 발생시킨 마크업의 value 반환            
        setWordCount(event.target.value.length);
    }    

    return (
        <>
            <h1> input 에 입력하면 실시간으로 글자 수 세기</h1>
            <input onChange={handleChange}/>
            <p>글자 수: {wordCount}</p>
        </>
    )
}