package com.eomcs.pms.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class FileListener implements ApplicationContextListener {

  
  @Override
public void contextInitialized(Map<String,Object> params){
    
    List<Board> boardList = (List<Board>)params.get("boardList");
    List<Member> memberList = (List<Member>)params.get("boardList");
    List<Project> projectList = (List<Project>)params.get("boardList");
    
    loadObjects("board.json", boardList, Board.class);
    loadObjects("member.json", memberList, Member.class);
    loadObjects("project.json", projectList, Project.class);
}
  
  public void contextDestroyed(Map<String,Object> params){
    
    List<Board> boardList = (List<Board>)params.get("boardList");
    List<Member> memberList = (List<Member>)params.get("boardList");
    List<Project> projectList = (List<Project>)params.get("boardList");
    
    saveObjects("board.json", boardList);
    saveObjects("member.json", memberList);
    saveObjects("project.json", projectList);
}
  
//JSON 형식으로 저장된 데이터를 읽어서 객체로 만든다.
 private <E> void loadObjects(
     String filepath, // 데이터를 읽어 올 파일 경로 
     List<E> list, // 로딩한 데이터를 객체로 만든 후 저장할 목록 
     Class<E> domainType // 생성할 객체의 타입정보
     ) {

   try (BufferedReader in = new BufferedReader(
       new FileReader(filepath, Charset.forName("UTF-8")))) {

     StringBuilder strBuilder = new StringBuilder();
     String str;
     while ((str = in.readLine()) != null) { // 파일 전체를 읽는다.
       strBuilder.append(str);
     }

     // StringBuilder로 읽어 온 JSON 문자열을 객체로 바꾼다.
     Type type = TypeToken.getParameterized(Collection.class, domainType).getType(); 
     Collection<E> collection = new Gson().fromJson(strBuilder.toString(), type);

     // JSON 데이터로 읽어온 목록을 파라미터로 받은 List 에 저장한다.
     list.addAll(collection);

     System.out.printf("%s 데이터 로딩 완료!\n", filepath);

   } catch (Exception e) {
     System.out.printf("%s 데이터 로딩 오류!\n", filepath);
   }
 }

 // 객체를 JSON 형식으로 저장한다.
 private void saveObjects(String filepath, List<?> list) {
   try (PrintWriter out = new PrintWriter(
       new BufferedWriter(
           new FileWriter(filepath, Charset.forName("UTF-8"))))) {

     out.print(new Gson().toJson(list));

     System.out.printf("%s 데이터 출력 완료!\n", filepath);

   } catch (Exception e) {
     System.out.printf("%s 데이터 출력 오류!\n", filepath);
     e.printStackTrace();
   }
 }
 
}
