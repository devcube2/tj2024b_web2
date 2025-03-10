/*
    리액트 과제3 : 리액트 전화번호부 만들기
        조건1 : '이름' 이랑 '전화번호' 입력받아 배열에 저장
        조건2 : 저장된 배열내 모든 정보(이름, 전화번호)를 table 또는 ol 또는 ul 로 모두 출력하시오.
        조건3 : useState 사용.
    카카오톡 제출 : ip로 제출
*/

import { useState } from "react";

export default function Task2() {
    const [ name, setName ] = useState('');
    const [ telno, setTelno ] = useState('');
    const [ telBook , setTelBook ] = useState([]);

    const 이름입력함수 = (e) => {                
        setName(e.target.value);
    }

    const 전화번호입력함수 = (e) => {
        setTelno(e.target.value);
    }

    const 전화번호부추가함수 = () => {        
        setTelBook([...telBook, { name, telno }]);        
        // 초기화
        setName("");
        setTelno("");
    };

    return (
        <>
            <h3>리액트 과제3</h3>
            이름: <input type="text" value={name} onChange={이름입력함수} />
            전화번호: <input type="text" value={telno} onChange={전화번호입력함수} />
            <button onClick={전화번호부추가함수}>전화번호부 추가</button>

            <ul>
                {telBook.map((book, index) => (
                    <li key={index}>
                        이름: {book.name} , 전화번호: {book.telno}
                    </li>
                ))}
            </ul>
        </>
    );
}