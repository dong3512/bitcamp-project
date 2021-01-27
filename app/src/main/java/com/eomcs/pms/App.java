package com.eomcs.pms;

import com.eomcs.pms.handler.BoardList;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

// 1) '/board/add' 명령 처리 추가
// 2) '/board/list' 명령 처리 추가
// 3) 두 번째 게시판 추가
// 4) 세 번째, 네 번째, 다섯 번째, 여섯 번째 게시판 추가
public class App {

  public static void main(String[] args) {

    BoardList boardList1 = new BoardList();
    BoardList boardList2 = new BoardList();
    BoardList boardList3 = new BoardList();
    BoardList boardList4 = new BoardList();
    BoardList boardList5 = new BoardList();
    BoardList boardList6 = new BoardList();

    loop:
      while (true) {
        String command = com.eomcs.util.Prompt.inputString("명령> ");

        switch (command) {
          case "/member/add":
            MemberHandler.add();
            break;
          case "/member/list":
            MemberHandler.list();
            break;
          case "/project/add":
            ProjectHandler.add();
            break;
          case "/project/list":
            ProjectHandler.list();
            break;
          case "/task/add":
            TaskHandler.add();
            break;
          case "/task/list":
            TaskHandler.list();
            break;
          case "/board/add":
            boardList1.add();
            break;
          case "/board/list":
            boardList1.list();
            break;
          case "/board2/add":
            boardList2.add();
            break;
          case "/board2/list":
            boardList2.list();
            break;
          case "/board3/add":
            boardList3.add();
            break;
          case "/board3/list":
            boardList3.list();
            break;
          case "/board4/add":
            boardList4.add();
            break;
          case "/board4/list":
            boardList4.list();
            break;
          case "/board5/add":
            boardList5.add();
            break;
          case "/board5/list":
            boardList5.list();
            break;
          case "/board6/add":
            boardList6.add();
            break;
          case "/board6/list":
            boardList6.list();
            break;
          case "quit":
          case "exit":
            System.out.println("안녕!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }

    Prompt.close();
  }
}
