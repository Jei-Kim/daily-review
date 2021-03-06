package com.studywithus;

import static com.studywithus.menu.Menu.ACCESS_ADMIN;
import static com.studywithus.menu.Menu.ACCESS_GENERAL;
import static com.studywithus.menu.Menu.ACCESS_LOGOUT;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.studywithus.domain.ChargeStudy;
import com.studywithus.domain.Community;
import com.studywithus.domain.ExamCalendar;
import com.studywithus.domain.FreeStudy;
import com.studywithus.domain.JobsCalendar;
import com.studywithus.domain.Member;
import com.studywithus.domain.Mentor;
import com.studywithus.handler.AuthLoginHandler;
import com.studywithus.handler.AuthLogoutHandler;
import com.studywithus.handler.ChargeInterestDeleteHandler;
import com.studywithus.handler.ChargeInterestListHandler;
import com.studywithus.handler.ChargeStudyAddHandler;
import com.studywithus.handler.ChargeStudyDeleteHandler;
import com.studywithus.handler.ChargeStudyDetailHandler;
import com.studywithus.handler.ChargeStudyListHandler;
import com.studywithus.handler.ChargeStudySearchHandler;
import com.studywithus.handler.ChargeStudyUpdateHandler;
import com.studywithus.handler.Command;
import com.studywithus.handler.CommunityAddHandler;
import com.studywithus.handler.CommunityDeleteHandler;
import com.studywithus.handler.CommunityDetailHandler;
import com.studywithus.handler.CommunityListHandler;
import com.studywithus.handler.CommunitySearchHandler;
import com.studywithus.handler.CommunityUpdateHandler;
import com.studywithus.handler.ExamCalendarAddHandler;
import com.studywithus.handler.ExamCalendarDeleteHandler;
import com.studywithus.handler.ExamCalendarDetailHandler;
import com.studywithus.handler.ExamCalendarUpdateHandler;
import com.studywithus.handler.FreeInterestDeleteHandler;
import com.studywithus.handler.FreeInterestListHandler;
import com.studywithus.handler.FreeStudyAddHandler;
import com.studywithus.handler.FreeStudyDeleteHandler;
import com.studywithus.handler.FreeStudyDetailHandler;
import com.studywithus.handler.FreeStudyListHandler;
import com.studywithus.handler.FreeStudySearchHandler;
import com.studywithus.handler.FreeStudyUpdateHandler;
import com.studywithus.handler.JobsCalendarAddHandler;
import com.studywithus.handler.JobsCalendarDeleteHandler;
import com.studywithus.handler.JobsCalendarDetailHandler;
import com.studywithus.handler.JobsCalendarUpdateHandler;
import com.studywithus.handler.MemberPrompt;
import com.studywithus.handler.MentorApplicantAddHandler;
import com.studywithus.handler.MentorApplicantDetailHandler;
import com.studywithus.handler.MentorApplicantListHandler;
import com.studywithus.handler.SignUpHandler;
import com.studywithus.menu.Menu;
import com.studywithus.menu.MenuGroup;
import com.studywithus.util.Prompt;

public class App {
  List<Member> memberList = new LinkedList<>();
  List<FreeStudy> freeStudyList = new ArrayList<>();
  List<FreeStudy> freeInterestList = new ArrayList<>();
  List<JobsCalendar> jobsCalendarList = new ArrayList<>();
  List<ExamCalendar> examCalendarList = new ArrayList<>();
  List<Member> mentorApplicantList = new ArrayList<>();
  List<ChargeStudy> chargeStudyList = new ArrayList<>();
  List<ChargeStudy> chargeInterestList = new ArrayList<>();
  List<Community> communityInfoList = new ArrayList<>();
  List<Community> communityQaList = new ArrayList<>();
  List<Community> communityTalkList = new ArrayList<>();
  List<Mentor> mentorList = new ArrayList<>();

  HashMap<String, Command> commandMap = new HashMap<>();

  MemberPrompt memberPrompt = new MemberPrompt(memberList);

  class MenuItem extends Menu {
    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
      Command command = commandMap.get(menuId);
      command.execute();
    }
  }

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  public App() {
    commandMap.put("/freeStudy/add", new FreeStudyAddHandler(freeStudyList));
    commandMap.put("/freeStudy/list", new FreeStudyListHandler(freeStudyList));
    commandMap.put("/freeStudy/detail", new FreeStudyDetailHandler(freeStudyList, freeInterestList));
    commandMap.put("/freeStudy/update", new FreeStudyUpdateHandler(freeStudyList));
    commandMap.put("/freeStudy/delete", new FreeStudyDeleteHandler(freeStudyList));
    commandMap.put("/freeStudy/search", new FreeStudySearchHandler(freeStudyList));

    commandMap.put("/chargeStudy/add", new ChargeStudyAddHandler(chargeStudyList));
    commandMap.put("/chargeStudy/list", new ChargeStudyListHandler(chargeStudyList));
    commandMap.put("/chargeStudy/detail", new ChargeStudyDetailHandler(chargeStudyList, chargeInterestList));
    commandMap.put("/chargeStudy/update", new ChargeStudyUpdateHandler(chargeStudyList));
    commandMap.put("/chargeStudy/delete", new ChargeStudyDeleteHandler(chargeStudyList));
    commandMap.put("/chargeStudy/search", new ChargeStudySearchHandler(chargeStudyList));

    commandMap.put("/communityInfo/add", new CommunityAddHandler(communityInfoList));
    commandMap.put("/communityInfo/list", new CommunityListHandler(communityInfoList));
    commandMap.put("/communityInfo/detail", new CommunityDetailHandler(communityInfoList));
    commandMap.put("/communityInfo/update", new CommunityUpdateHandler(communityInfoList));
    commandMap.put("/communityInfo/delete", new CommunityDeleteHandler(communityInfoList));
    commandMap.put("/communityInfo/search", new CommunitySearchHandler(communityInfoList));

    commandMap.put("/communityQa/add", new CommunityAddHandler(communityQaList));
    commandMap.put("/communityQa/list", new CommunityListHandler(communityQaList));
    commandMap.put("/communityQa/detail", new CommunityDetailHandler(communityQaList));
    commandMap.put("/communityQa/update", new CommunityUpdateHandler(communityQaList));
    commandMap.put("/communityQa/delete", new CommunityDeleteHandler(communityQaList));
    commandMap.put("/communityQa/search", new CommunitySearchHandler(communityQaList));

    commandMap.put("/communityTalk/add", new CommunityAddHandler(communityTalkList));
    commandMap.put("/communityTalk/list", new CommunityListHandler(communityTalkList));
    commandMap.put("/communityTalk/detail", new CommunityDetailHandler(communityTalkList));
    commandMap.put("/communityTalk/update", new CommunityUpdateHandler(communityTalkList));
    commandMap.put("/communityTalk/delete", new CommunityDeleteHandler(communityTalkList));
    commandMap.put("/communityTalk/search", new CommunitySearchHandler(communityTalkList));

    commandMap.put("/jobsCalendar/add", new JobsCalendarAddHandler(jobsCalendarList));
    commandMap.put("/jobsCalendar/detail", new JobsCalendarDetailHandler(jobsCalendarList));
    commandMap.put("/jobsCalendar/update", new JobsCalendarUpdateHandler(jobsCalendarList));
    commandMap.put("/jobsCalendar/delete", new JobsCalendarDeleteHandler(jobsCalendarList));

    commandMap.put("/examCalendar/add", new ExamCalendarAddHandler(examCalendarList));
    commandMap.put("/examCalendar/detail", new ExamCalendarDetailHandler(examCalendarList));
    commandMap.put("/examCalendar/update", new ExamCalendarUpdateHandler(examCalendarList));
    commandMap.put("/examCalendar/delete", new ExamCalendarDeleteHandler(examCalendarList));

    commandMap.put("/mentorApplicant/add", new MentorApplicantAddHandler(mentorApplicantList));
    commandMap.put("/mentorApplicant/list", new MentorApplicantListHandler(mentorApplicantList));
    commandMap.put("/mentorApplicant/detail", new MentorApplicantDetailHandler(mentorApplicantList, mentorList));

    commandMap.put("/freeInterest/list", new FreeInterestListHandler(freeInterestList));
    commandMap.put("/freeInterest/delete", new FreeInterestDeleteHandler(freeInterestList));

    commandMap.put("/chargeInterest/list", new ChargeInterestListHandler(chargeInterestList));
    commandMap.put("/chargeInterest/delete", new ChargeInterestDeleteHandler(chargeInterestList));

    commandMap.put("/auth/login", new AuthLoginHandler(memberList));
    commandMap.put("/auth/logout", new AuthLogoutHandler());
    commandMap.put("/auth/signUp", new SignUpHandler(memberList));
  }

  void service() {
    loadMembers();
    loadFreeStudies();
    loadCommunityQas();
    loadCommunityInfos();
    loadCommunityTalks();
    loadJobsCalendars();
    loadExamCalendars();

    createMainMenu().execute();
    Prompt.close();

    saveMembers();
    saveFreeStudies();
    saveCommunityQas();
    saveCommunityInfos();
    saveCommunityTalks();
    saveJobsalendars();
    saveExamCalendars();
  }

  @SuppressWarnings("unchecked")
  private void loadMembers() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("member.data"))) {

      memberList.addAll((List<Member>) in.readObject());

    } catch (Exception e) {
      System.out.println("???????????? ?????? ???????????? ?????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  private void saveMembers() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("member.data"))) {

      out.writeObject(memberList);

    } catch (Exception e) {
      System.out.println("?????? ???????????? ????????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void loadFreeStudies() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("freeStudy.data"))) {

      freeStudyList.addAll((List<FreeStudy>) in.readObject());

      System.out.println("?????? ????????? ????????? ????????? ?????????????????????.");

    } catch (Exception e) {
      System.out.println("???????????? ?????? ????????? ???????????? ?????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  private void saveFreeStudies() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("freeStudy.data"))) {

      out.writeObject(freeStudyList);

      System.out.println("?????? ????????? ????????? ????????? ?????????????????????.");

    } catch (Exception e) {
      System.out.println("?????? ????????? ???????????? ????????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void loadCommunityQas() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("communityQa.data"))) {

      communityQaList.addAll((List<Community>) in.readObject());

    } catch (Exception e) {
      System.out.println("???????????? ???????????? ?????? ???????????? ?????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  private void saveCommunityQas() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("communityQa.data"))) {

      out.writeObject(communityQaList);

    } catch (Exception e) {
      System.out.println("???????????? ?????? ???????????? ????????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void loadCommunityInfos() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("communityInfo.data"))) {

      communityInfoList.addAll((List<Community>) in.readObject());

    } catch (Exception e) {
      System.out.println("???????????? ???????????? ?????? ???????????? ?????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  private void saveCommunityInfos() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("communityInfo.data"))) {

      out.writeObject(communityInfoList);

    } catch (Exception e) {
      System.out.println("???????????? ?????? ???????????? ????????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void loadCommunityTalks() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("communityTalk.data"))) {

      communityTalkList.addAll((List<Community>) in.readObject());

    } catch (Exception e) {
      System.out.println("???????????? ???????????? ????????? ???????????? ?????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  private void saveCommunityTalks() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("communityTalk.data"))) {

      out.writeObject(communityTalkList);

    } catch (Exception e) {
      System.out.println("???????????? ????????? ???????????? ????????? ?????? ??? ????????? ?????????????????????.");
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void loadJobsCalendars() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("jobsCalendar.data"))) {

      jobsCalendarList.addAll((List<JobsCalendar>) in.readObject());

      System.out.println("????????? ???????????? ????????? ????????? ?????????????????????.");

    } catch (Exception e) {
      System.out.println("???????????? ????????? ???????????? ???????????? ?????? ?????? ??? ????????? ?????????????????????.");
    }
  }

  private void saveJobsalendars() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("jobsCalendar.data"))) {

      out.writeObject(jobsCalendarList);

      System.out.println("????????? ???????????? ????????? ????????? ?????????????????????.");

    } catch (Exception e) {
      System.out.println("????????? ???????????? ???????????? ????????? ?????? ??? ????????? ?????????????????????.");
    }
  }

  @SuppressWarnings("unchecked")
  private void loadExamCalendars() {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("examCalendar.data"))) {

      examCalendarList.addAll((List<ExamCalendar>) in.readObject());

      System.out.println("????????? ???????????? ????????? ????????? ?????????????????????.");

    } catch (Exception e) {
      System.out.println("???????????? ????????? ???????????? ???????????? ?????? ?????? ??? ????????? ?????????????????????.");
    }
  }

  private void saveExamCalendars() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("examCalendar.data"))) {

      out.writeObject(examCalendarList);

      System.out.println("????????? ???????????? ????????? ????????? ?????????????????????.");

    } catch (Exception e) {
      System.out.println("????????? ???????????? ???????????? ????????? ?????? ??? ????????? ?????????????????????.");
    }
  }

  Menu createMainMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("??????");
    mainMenuGroup.setPrevMenuTitle("??????");

    mainMenuGroup.add(new MenuItem("?????????", ACCESS_LOGOUT, "/auth/login"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_LOGOUT, "/auth/signUp"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_GENERAL | ACCESS_ADMIN, "/auth/logout"));

    //    mainMenuGroup.add(createAdminMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createInterestMenu());
    mainMenuGroup.add(createFreeStudyMenu());
    mainMenuGroup.add(createChargeStudyMenu());
    mainMenuGroup.add(createMentorApplyMenu());
    mainMenuGroup.add(createCommunityMenu());
    mainMenuGroup.add(createCalenderMenu());

    return mainMenuGroup;
  }

  //  private Menu createAdminMenu() {
  //    MenuGroup adminMenu = new MenuGroup("?????????", ACCESS_ADMIN);
  //
  //    adminMenu.add(createMemberMenu());
  //    adminMenu.add(createCalenderMenu());
  //
  //    return adminMenu;
  //  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("?????? ??????", ACCESS_ADMIN);

    memberMenu.add(createMentorApplicantMenu());

    return memberMenu;
  }

  private Menu createMentorApplyMenu() {
    MenuGroup mentorApplyMenu = new MenuGroup("?????? ????????????");
    mentorApplyMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/mentorApplicant/add"));

    return mentorApplyMenu;
  }

  private Menu createMentorApplicantMenu() {
    MenuGroup mentorApplicantMenu = new MenuGroup("?????? ?????? ??????");

    mentorApplicantMenu.add(new MenuItem("??????", /*ACCESS_ADMIN,*/ "/mentorApplicant/list"));
    mentorApplicantMenu.add(new MenuItem("????????????", /*ACCESS_ADMIN,*/ "/mentorApplicant/detail"));

    return mentorApplicantMenu;
  }

  private Menu createCalenderMenu() {
    MenuGroup calenderMenu = new MenuGroup("?????????");

    calenderMenu.add(createJobsCalenderMenu());
    calenderMenu.add(createExamCalenderMenu());

    return calenderMenu;
  }

  private Menu createJobsCalenderMenu() {
    MenuGroup jobsCalenderMenu = new MenuGroup("????????? ???????????? ??????");

    jobsCalenderMenu.add(new MenuItem("??????", ACCESS_ADMIN, "/jobsCalender/add"));
    jobsCalenderMenu.add(new MenuItem("????????????", "/jobsCalender/detail"));
    jobsCalenderMenu.add(new MenuItem("??????", ACCESS_ADMIN, "/jobsCalender/update"));
    jobsCalenderMenu.add(new MenuItem("??????", ACCESS_ADMIN, "/jobsCalender/delete"));

    return jobsCalenderMenu;
  }

  private Menu createExamCalenderMenu() {
    MenuGroup examCalenderMenu = new MenuGroup("????????? ???????????? ??????");

    examCalenderMenu.add(new MenuItem("??????", ACCESS_ADMIN, "/examCalender/add"));
    examCalenderMenu.add(new MenuItem("????????????", "/examCalender/detail"));
    examCalenderMenu.add(new MenuItem("??????", ACCESS_ADMIN, "/examCalender/update"));
    examCalenderMenu.add(new MenuItem("??????", ACCESS_ADMIN, "/examCalender/delete"));

    return examCalenderMenu;
  }

  private Menu createInterestMenu() {
    MenuGroup interestMenu = new MenuGroup("????????????");

    interestMenu.add(createFreeInterestMenu());
    interestMenu.add(createChargeInterestMenu());

    return interestMenu;
  }

  private Menu createFreeInterestMenu() {
    MenuGroup freeInterestMenu = new MenuGroup("?????? ????????? ????????????");

    freeInterestMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/freeInterest/list"));
    freeInterestMenu.add(new MenuItem("??????", ACCESS_GENERAL,"/freeInterest/delete"));

    return freeInterestMenu;
  }

  private Menu createChargeInterestMenu() {
    MenuGroup chargeInterestMenu = new MenuGroup("?????? ????????? ????????????");

    chargeInterestMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/chargeInterest/list"));
    chargeInterestMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/chargeInterest/delete"));

    return chargeInterestMenu;
  }

  private Menu createFreeStudyMenu() {
    MenuGroup freeStudyMenu = new MenuGroup("?????? ?????????");

    freeStudyMenu.add(new MenuItem("??????", "/freeStudy/search"));
    freeStudyMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/freeStudy/add"));
    freeStudyMenu.add(new MenuItem("??????", "/freeStudy/list"));
    freeStudyMenu.add(new MenuItem("????????????", "/freeStudy/detail"));
    freeStudyMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/freeStudy/update"));
    freeStudyMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/freeStudy/delete"));

    return freeStudyMenu;
  }

  private Menu createChargeStudyMenu() {
    MenuGroup chargeStudyMenu = new MenuGroup("?????? ?????????");

    chargeStudyMenu.add(new MenuItem("??????", "/chargeStudy/search"));
    chargeStudyMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/chargeStudy/add"));
    chargeStudyMenu.add(new MenuItem("??????", "/chargeStudy/list"));
    chargeStudyMenu.add(new MenuItem("????????????", "/chargeStudy/detail"));
    chargeStudyMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/chargeStudy/update"));
    chargeStudyMenu.add(new MenuItem("?????? ??????", ACCESS_GENERAL, "/chargeStudy/delete"));

    return chargeStudyMenu;
  }

  private Menu createCommunityMenu() {
    MenuGroup communityMenu = new MenuGroup("????????????");

    communityMenu.add(createCommunityInfoMenu());
    communityMenu.add(createCommunityQaMenu());
    communityMenu.add(createCommunityTalkMenu());

    return communityMenu;
  }

  private Menu createCommunityInfoMenu() {
    MenuGroup communityInfoMenu = new MenuGroup("??????");

    communityInfoMenu.add(new MenuItem("??????", "/communityInfo/search"));
    communityInfoMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityInfo/add"));
    communityInfoMenu.add(new MenuItem("??????", "/communityInfo/list"));
    communityInfoMenu.add(new MenuItem("????????????", "/communityInfo/detail"));
    communityInfoMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityInfo/update"));
    communityInfoMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityInfo/delete"));

    return communityInfoMenu;
  }

  private Menu createCommunityQaMenu() {
    MenuGroup communityQaMenu = new MenuGroup("??????");

    communityQaMenu.add(new MenuItem("??????", "/communityQa/search"));
    communityQaMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityQa/add"));
    communityQaMenu.add(new MenuItem("??????", "/communityQa/list"));
    communityQaMenu.add(new MenuItem("????????????", "/communityQa/detail"));
    communityQaMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityQa/update"));
    communityQaMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityQa/delete"));

    return communityQaMenu;
  }

  private Menu createCommunityTalkMenu() {
    MenuGroup communityTalkMenu = new MenuGroup("?????????");

    communityTalkMenu.add(new MenuItem("??????", "/communityTalk/search"));
    communityTalkMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityTalk/add"));
    communityTalkMenu.add(new MenuItem("??????", "/communityTalk/list"));
    communityTalkMenu.add(new MenuItem("????????????", "/communityTalk/detail"));
    communityTalkMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityTalk/update"));
    communityTalkMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/communityTalk/delete"));

    return communityTalkMenu;
  }
}
