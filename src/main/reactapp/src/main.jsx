import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// react18
// (!) 기본값 주석처리
// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>,
// )

// (*) index.html에 root 구역 가져오기.
const root = createRoot(document.querySelector('#root'));

// // day01 : '컴포넌트 만들기' 렌더링
//     // import 호출할컴포넌트명 ㄹ개ㅡ '경로/파일명(확장자)';
// import Component1 from './example/1_동작구조/Component1.jsx';
// // root.render(<Component1/>);

// // day01 : 여러 컴포넌트 만들기
// import Component2 from './example/1_동작구조/Component2.jsx';
// root.render(<Component2/>);

// day03 : 생명주기1
// import Example1 from './example/3_ 훅/Example1.jsx';
// root.render(<Example1/>);

// day03 : 생명주기2
// import Example1 from './example/3_훅/Example2.jsx';
// root.render(<Example1/>);

// day03 : 생명주기3
// import Example3 from './example/3_훅/Example3.jsx';
// root.render(<Example3/>);

// day03 : 과제
// import Task1 from './example/3_훅/Task1.jsx';
// root.render(<Task1/>);

// day03 : 과제2
// import Task2 from './example/3_훅/Task2.jsx';
// root.render(<Task2/>);

// day05 : axios
// import Example1 from './example/6_AXIOS/Example1.jsx';
// root.render(<Example1/>)

// day05 : axios 2
// import Example2 from './example/6_AXIOS/Example2.jsx';
// root.render(<Example2/>)

import Task from './example/6_AXIOS/Task.jsx';
root.render(<Task></Task>);