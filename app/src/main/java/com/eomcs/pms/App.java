package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

// 1) 낱개의 변수를 사용하여 여러 회원 정보 처리하기
// 2) 조건문을 사용하여 입출력 제어하기
// - 필요한 만큼만 입력 받고 출력하고 싶다.
// 3) 배열을 사용하여 여러 개의 값을 다루기
// - 배열을 사용하면 간단하게 여러 개의 변수를 선언할 수 있다.
// 4) 반복문을 사용하여 여러 개의 값을 다루기
// - 반복문을 사용하면 같은 코드를 중복해서 작성할 필요가 없다.
// 5) 배열 개수를 변수에서 관리하기
// - 변수의 값만 바꾸면 배열 개수를 바로 변경할 수 있어 편하다.
// 6) 상수를 사용하여 초기 값을 변경하지 못하게 막기
// - 변수는 중간에 값을 바꿀 수 있기 때문에 값을 바꾸지 말아야 하는 경우
//   상수로 선언한다.
public class App {

  public static void main(String[] args) {

    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH];
    int size = 0;

    final int pLENGTH = 100;
    int[] pno = new int[LENGTH];
    String[] ptitle = new String[LENGTH];
    String[] pcontent = new String[LENGTH];
    Date[] pstartDate = new Date[LENGTH];
    Date[] pendDate = new Date[LENGTH];
    String[] powner = new String[LENGTH];
    String[] pmembers = new String[LENGTH];
    int psize = 0;

    final int tLENGTH = 100;

    int[] tno = new int[LENGTH];
    String[] tcontent = new String[LENGTH];
    Date[] tdeadline = new Date[LENGTH];
    String[] towner = new String[LENGTH];
    int[] tstatus = new int[LENGTH];
    int tsize = 0;

    loop:
      while(true) {
        System.out.print("명령>");
        String command = keyboardScan.nextLine();

        switch (command) {
          case "/member/add":
            System.out.println("[회원 등록]");

            System.out.print("번호? ");
            no[size] = Integer.parseInt(keyboardScan.nextLine());

            System.out.print("이름? ");
            name[size] = keyboardScan.nextLine();

            System.out.print("이메일? ");
            email[size] = keyboardScan.nextLine();

            System.out.print("암호? ");
            password[size] = keyboardScan.nextLine();

            System.out.print("사진? ");
            photo[size] = keyboardScan.nextLine();

            System.out.print("전화? ");
            tel[size] = keyboardScan.nextLine();

            registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

            size++;
            break;
          case "/member/list":
            System.out.println("[회원 목록]");
            for (int i = 0; i < size; i++) {
              // 번호, 이름, 이메일, 전화, 가입일
              System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
                  no[i], name[i], email[i], tel[i], registeredDate[i]);
            }
            break;
          case "/project/add":
            System.out.println("[프로젝트 등록]");

            System.out.print("번호? ");
            pno[psize] = Integer.valueOf(keyboardScan.nextLine());

            System.out.print("프로젝트명? ");
            ptitle[psize] = keyboardScan.nextLine();

            System.out.print("내용? ");
            pcontent[psize] = keyboardScan.nextLine();

            System.out.print("시작일? ");
            pstartDate[psize] = Date.valueOf(keyboardScan.nextLine());

            System.out.print("종료일? ");
            pendDate[psize] = Date.valueOf(keyboardScan.nextLine());

            System.out.print("만든이? ");
            powner[psize] = keyboardScan.nextLine();

            System.out.print("팀원? ");
            pmembers[psize] = keyboardScan.nextLine();

            psize++;
          case "/project/list":
            System.out.println("[프로젝트 목록]");
            for (int i = 0; i < size; i++) {
              // 번호, 프로젝트명, 시작일, 종료일, 만든이
              System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
                  pno[i], ptitle[i], pstartDate[i], pendDate[i], powner[i]);
            }
          case "/task/add":
            System.out.println("[작업등록]");
            System.out.print("번호? ");
            tno[tsize] = Integer.parseInt(keyboardScan.nextLine());

            System.out.print("내용? ");
            tcontent[tsize] = keyboardScan.nextLine();

            System.out.print("마감일? ");
            tdeadline[tsize] = Date.valueOf(keyboardScan.nextLine());

            System.out.println("상태?");
            System.out.println("0: 신규");
            System.out.println("1: 진행중");
            System.out.println("2: 완료");
            System.out.print("> ");
            tstatus[tsize] = Integer.valueOf(keyboardScan.nextLine());

            System.out.print("담당자? ");
            towner[tsize] = keyboardScan.nextLine();

            tsize++;
            break;
          case "/task/list":
            System.out.println("[작업목록]");

            for (int i = 0; i < tsize; i++) {
              String stateLabel = null;
              switch (tstatus[i]) {
                case 1:
                  stateLabel = "진행중";
                  break;
                case 2:
                  stateLabel = "완료";
                  break;
                default:
                  stateLabel = "신규";
              }
              // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
              System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
                  tno[i], tcontent[i], tdeadline[i], stateLabel, towner[i]);
            }
          case "quit":
          case "exit":
            System.out.println("안녕");
            break loop;
          default: 
            System.out.println("실행 할 수 없는 명령입니다.");
        }

      }

    keyboardScan.close();

  }
}
