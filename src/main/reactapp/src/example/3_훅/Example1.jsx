
let a = 0
export default function Example1(props) {
    let b = 0;
    a++;
    b++;

    // 증가 버튼을 클릭했을때 실행되는 함수
    const 증가함수 = () => {
        ++a;
        ++b;
        // + innerHTML 안했기 때문에.
    }

    return (<>
        <div>{ ++a }</div>
        <div>{ ++b }</div>
        <button type="button" onClick={증가함수}>증가함수</button>
    </>)
}