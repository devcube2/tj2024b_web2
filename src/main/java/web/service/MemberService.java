package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service // 해당 클래스가 서비스임을 주입
@RequiredArgsConstructor // final 필드에 대해서 @Autowired 생략 가능하다.
public class MemberService {

    private final MemberMapper memberMapper;
    private final FileService fileService;// 파일 서비스 ( 업로드 , 다운로드 , 파일삭제 ) 기능 포함

    // [1] 회원가입
    public boolean sigunUp( MemberDto memberDto ){
        System.out.println("MemberService.sigunUp");
        System.out.println("memberDto = " + memberDto);
        try {
            // (1) 만약에 첨부파일(프로필업로드)이 존재하는지 검사.
            if (memberDto.getUploadfile() == null) {
            } // 업로드가 존재하지 않으면
            else { // 업로드가 존재하면 파일서비스의 업로드 메소드 사용하기.
                // (2) 파일서비스내 업로드 함수 이용하여 첨부파일 업로드하고 파일명 받기.
                String filename = fileService.fileUpload(memberDto.getUploadfile());
                // (3) 업로드된 파일명을 dto 저장
                memberDto.setMimg(filename);
            }

            // (4) 비크립트 라이브러리 이용한 비밀번호 암호화하기.
            // 1. 비크립트 객체 생성
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            // 2. 암호화할 자료에 .encode(암호화할자료);
            String hashedPassword = bCryptPasswordEncoder.encode(memberDto.getMpwd());
            System.out.println("hashedPassword = " + hashedPassword);
            // 3. 암호화된 값을 dto에 넣어서 db처리
            memberDto.setMpwd(hashedPassword);

            boolean result = memberMapper.sigunUp(memberDto);
            System.out.println("result = " + result);
            return result;
        }catch ( Exception e ){ return false; } // 업로드 와 회원가입DB 처리 중 예외 발생시 false 반환
    }

    // [2] 로그인
    public MemberDto login( MemberDto memberDto ){
        System.out.println("MemberService.login");
        System.out.println("memberDto = " + memberDto);
        //return false;
        MemberDto result = memberMapper.login(memberDto);
        return result;
    }
}












