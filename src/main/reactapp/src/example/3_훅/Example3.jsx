import { useState } from "react";

export default function Example3(props) {
    // (1) 일반적인 JS 방법
    const 입력함수 = () => {
        const msg = document.querySelector('#msg').value;
        console.log(msg);
    }

    // (2) 리액트 방법
    const [ msg , setMsg ] = useState('') // 상태(state) 변수 : 변수값에 따른 컴포넌트를 렌더링 제공
    const 입력함수2 = (eventObj) => {
        console.log(eventObj);
        console.log(eventObj.target); // onChange 이벤트를 발생시킨 마크업(대상)
        console.log(eventObj.target.value); // onChange 이벤트를 발생시킨 마크업의 value 반환
        // (기존1)   document.querySelector('xxx').value
        // (리액트2) e.target.value
            // --> 사용자 입력한 input 값을 리액트에서 관리 한다.
        setMsg(eventObj.target.value);
    }
    
    // (3) 리액트 방법2
    // 이미지를 저장하는 state 변수 선언
    const [ image , setImage ] = useState('토끼1.jpg')
    console.log(image);
    // 임의의 이미지를 2개이상 다운로드 받아서 리액트 폴더내 public 에 복사

    const 변경함수3 = () => {
        // state 변수의 값이 변경되면 자동으로 새로고침 => 리액트 UI 업데이트
        setImage( image == '토끼1.jpg' ? '토끼2.jpg' : '토끼1.jpg')
    }

    return (<>
        <h1> 일반적인 JS 방법 </h1>
        <input id="msg" /> <br/>
        <button onClick={입력함수}>입력버튼</button>

        <h1> 리액트 JS 방법 </h1>
        <input value = { msg } onChange={ 입력함수2 }/> <br/>

        <h1> 리액트 이미지 변경 </h1>
        <img onClick={변경함수3} src={image}/>
    </>)
}

/*
    HTML 이벤트 함수 , onXXXX , 미리 만들어진 함수를 제공한다.
        [1] 종류
        onclick     : HTML 마크업에 클릭했을때 이벤트함수 실행
        onchange    : HTML 마크업에 값이 변경되었을때 이벤트함수 실행
        등등
        [2] 반환 제공한다.
            - 이벤트 함수가 실행된 결과를 객체로 다음 로직으로 반환된다.
            - onclick = ( e ) => { }
                onClick 함수가 실행되고 나서 실행결과를 e(매개변수)로 다음 함수에게 전달
    
    HTML 이벤트 함수 vs JSX(리액트) 이벤트 함수 차이점
    함수명 : onclick vs onClick                            * 차이점 : 리액트에서는 카멜표기법 사용한다.
    속성값 : onclick = "함수명()" vs onclick = { 함수명 }   * 차이점 : 리액트에서는 {} 안에 함수호출이 아닌 함수명 표시한다.
    결과리턴 : onclick = "함수명(e)" 
*/