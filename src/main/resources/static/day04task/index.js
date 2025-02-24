console.log("index.js open")

// [4] 개별 삭제 함수
const onDelete = async ( bno ) => {
    console.log('onDelete....');
    // (1) 삭제할 번호 : sno
    // (2) axios 통신
    const response = await axios.delete( `/day04/task/board?bno=${ bno }` )
    if( response.data == true ){ onFindAll(); }
} // f end

// [3] 개별 수정 함수
const onUpdate = async ( bno ) => {
    console.log('onUpdate....');
    // (1) 수정할 값 받기
    const title = prompt('새로운 제목')
    const content = prompt('새로운 내용')
    // (2) 객체화
    const obj = { bno , title , content };
    // (3) axios 통신 ,
    const response = await axios.put( '/day04/task/board' , obj )
    if( response.data == true ){ onFindAll(); } // 만약에 응답 내용이 1 이면 수정 성공 -> 전체조회함수 실행
} // f end

// [2] 전체 조회 함수
const onFindAll = async ( ) => {
    // (동기화) await , async
    console.log('onFileAll...');
    try{
        const response = await axios.get( '/day04/task/board' )
        console.log( response.data ); // response 응답(정보)객체 , response.data : 응답객체내 본문내용
        const tbody = document.querySelector('tbody')
        let html = ``
            response.data.forEach( board => {
                html += `<tr>
                            <td>${ board.bno } </td>
                            <td><a link="#" onclick="javascript:onView(${board.bno})" style="color: blue; text-decoration: underline; cursor: pointer;">${ board.title }</a></td>
                            <td>${ board.content }  </td>
                            <td>
                                <button onclick="onUpdate(${ board.bno })"> 수정 </button>
                                <button onclick="onDelete(${ board.bno })"> 삭제 </button>
                            </td>
                          </tr>`
            })
        tbody.innerHTML = html;
    }catch( e ){ console.log( e ); }
} // f end
onFindAll(); // 전제조회 함수 실행

const onView = async (bno) => {
    console.log(`onView... ${bno}`);
    try{
        const titleElement = document.querySelector('#view-title');
        const contentElement = document.querySelector('#view-content')

        const response = await axios.get( `/day04/task/board/view?bno=${bno}` )
        console.log( response.data );

        titleElement.innerHTML = `${response.data.title}`;
        contentElement.innerHTML = `${response.data.content}`;
    }catch( e ){ console.log( e ); }
}

// [1] 등록 함수
const onSave =  ( ) => {
    // (1)
    const title = document.querySelector('.title').value;
    const content = document.querySelector('.content').value;
    // (*) 객체{} 선언할때 대입할 변수명이 객체의 필드명 동일하면 생략가능
    // const obj = { name : name , kor : kor , math : math };
    const obj = { title , content };
    console.log( obj );

    // (*) fetch 대신에 axios 활용한 비동기화통신 vs 동기화통신 , 상황에 따라 다르다.
    // ( 비동기 )
    axios.post( '/day04/task/board' , obj )
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log( e ); } )
}