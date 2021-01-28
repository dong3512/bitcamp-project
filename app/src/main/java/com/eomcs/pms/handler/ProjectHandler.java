package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  static final int LENGTH = 100;

  public MemberHandler memberList;

  Project[] projects = new Project[LENGTH];
  int size = 0;

  public ProjectHandler(MemberHandler memberHandler) {
    this.memberList = memberHandler;
  }
  public void add() {
    System.out.println("[프로젝트 등록]");

    Project p = new Project();
    p.no = Prompt.inputInt("번호? ");
    p.title = Prompt.inputString("프로젝트명? ");
    p.content = Prompt.inputString("내용? ");
    p.startDate = Prompt.inputDate("시작일? ");
    p.endDate = Prompt.inputDate("종료일? ");

    while (true) {
      String name = Prompt.inputString("만든이?(취소: 빈 문자열) ");
      if (name.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      } 
      if (this.memberList.exist(name)) {
        p.owner = name;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    p.members = "";
    while (true) {
      String name = Prompt.inputString("팀원?(완료: 빈 문자열) ");
      if (name.length() == 0) {
        break;
      } else if (this.memberList.exist(name)) {
        if (!p.members.isEmpty()) {
          p.members += ",";
        }
        p.members += name;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }

    this.projects[this.size++] = p;
  }

  public void list() {
    System.out.println("[프로젝트 목록]");

    for (int i = 0; i < size; i++) {
      Project p = projects[i];
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          p.no, p.title, p.startDate, p.endDate, p.owner, p.members);
    }
  }

  public void detail() {
    System.out.println("[프로젝트 상세조회]");

    int no = Prompt.inputInt("번호? ");

    for(int i = 0 ; i < this.size; i ++) {
      Project project = this.projects[i];
      if(project.no == no) {
        System.out.printf("프로젝트명? %s\n", project.title);
        System.out.printf("내용? %s\n", project.content);
        System.out.printf("시작일? %s\n", project.startDate);
        System.out.printf("종료일? %s\n", project.endDate);
        System.out.printf("만든이? %s\n", project.owner);
        System.out.printf("팀원? %s\n", project.members);
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다.");
  }

  public void update() {
    System.out.println("[프로젝트 수정]");

    int no = Prompt.inputInt("번호? ");
    for (int i = 0; i <this.size; i++) {
      Project project = this.projects[i];
      if(project.no == no) {
        String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
        String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
        Date startDate = Prompt.inputDate(String.format("시작일?(%s)? ",project.startDate));
        Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));

        String owner = null;
        while(true) {
          owner = Prompt.inputString(String.format("만든이(%s)?(취소: 빈 문자열)", project.owner));
          if(owner.length() == 0) {
            System.out.println("프로젝트 변경을 취소합니다.");
            return;
          }
          if(this.memberList.exist(owner)) {
            break;
          }
          System.out.println("등록된 회원이 아닙니다.");
        }

        String members = "";
        while (true) {
          String name = Prompt.inputString("팀원?(완료: 빈 문자열) ");
          if (name.length() == 0) {
            break;
          } else if (this.memberList.exist(name)) {
            if (!members.isEmpty()) {
              members += ",";
            }
            members += name;
          } else {
            System.out.println("등록된 회원이 아닙니다.");
          }
        }
        String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ") ;

        if(input.equalsIgnoreCase("Y")) {
          project.title = title;
          project.content = content;
          project.startDate = startDate;
          project.endDate = endDate;
          project.owner = owner;
          project.members = members;

          System.out.println("프로젝트를 변경하였습니다.");

        }else {
          System.out.println("프로젝트 변경을 취소하였습니다.");
        }
      }


    }
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");

    int no = Prompt.inputInt("번호? ");

    for(int i = 0; i < this.size; i++) {
      Project project = this.projects[i];
      if(project != null && project.no == no) {
        String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N");

        if(input.equalsIgnoreCase("Y")) {
          this.projects[i] = null;
          System.out.println("게시글을 삭제하였습니다.");
        }else {
          System.out.println("게시글 삭제를 취소하였습니다.");
        }

        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다.");
  }


}








