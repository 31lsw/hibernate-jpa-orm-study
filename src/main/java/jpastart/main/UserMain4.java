//package jpastart.main;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.apache.commons.lang3.ArrayUtils;
//
//import jpastart.jpa.EMF;
//import jpastart.jpa.application.JoinService;
//
///**
// * @author S
// * 콘솔에서 JPA를 이용한 사용자 정보 관리 프로그램
// * 콘솔로 명령을 입력받아 알맞은 서비스를 실행하는 메인 클래스
// * 각 서비스는 사용자 추가, 조회 , 정보 변경, 삭제 기능
// */
//public class UserMain4 {
//	
////	private static final String DELIMITER = " ";
//	private static final String DELIMITER = "\\s";
////	private static final String NOT_ALLOWED = " ";
//	private static final String NOT_ALLOWED = "\\s";
////	private static final String NOT_ALLOWED = "\\s{1,}";
////	private static final String NOT_ALLOWED = "\\s{2,}";
//	private static final String EMPTY = "";
//	private static final String EMPTY_REG = "^$";
//			
//	
//	private static JoinService joinService = new JoinService();
//	
//	public static void main(String[] args) throws IOException, InterruptedException {
//		
//		//EntityManagerFactory 생성
//		EMF.init();
//		
//		//콘솔에서 명령어 입력받기 위한 BufferedReader 생성
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		
//			
//		while (true) {
//			System.out.println("명령어를 입력하세요.");
//			//콘솔에서 한 줄을 입력받음
//			String line = reader.readLine();
//														//System.out.println("입력한 문자열 : " + line);
//			
//			//입력받은 문자열을 공백문자로 분리
//			String[] commands = line.split(DELIMITER);
//														//dumpArray(commands);
//														//System.out.println("공백문자로 분리 : " + Arrays.toString(commands));
//			//첫 명령어에 빈칸 입력 제거(공백이 아니라 빈칸임)
//			commands = removeFirstEmptyCommand(commands);
//			
//			boolean result = isCommandsValid(commands);
//			
//			if(!result) {
//				System.out.println("올바른 명령어를 입력하세요.");
//			} else {
//				//입력한 명령어가 "exit"면 while 루프 종료
//				if (commands[0].equalsIgnoreCase("exit")) {
//					System.out.println("종료합니다");
//					break;
//				} else if (commands[0].equalsIgnoreCase("join")) {
//					
//				} else if (commands[0].equalsIgnoreCase("view")) {
//				} else if (commands[0].equalsIgnoreCase("list")) {
//				} else if (commands[0].equalsIgnoreCase("chagename")) {
//				} else if (commands[0].equalsIgnoreCase("withdraw")) {
//				} else if (commands[0].equalsIgnoreCase(" ")) {
//				//올바른 명령어 가 아니면 안내 메시지 출력	
//				} else {
//					System.out.println("올바른 명령어를 입력하세요.");
//				}
//				System.out.println("---------");
//			}
//				
//			
//			
//		}
//		
//		//EntityManagerFactory 종료
//		EMF.close();
//	}
//
//	@SuppressWarnings("null")
//	private static String[] removeFirstEmptyCommand(String[] commands) {
//		
//		if(commands.length > 0) {
//			commands = ArrayUtils.removeElement(commands, EMPTY);
//		}
//
////		if(commands.length > 0 && commands[0].matches(EMPTY_REG)) {
////			while(true) {
////				if(commands[0].matches(EMPTY_REG)) { //첫번째 인덱스가 빈 칸일 때만 조져
////					//commands = ArrayUtils.remove(commands, 0);
////					commands = ArrayUtils.removeElement(commands, EMPTY);
////				} else break;
////			}
////		}
//		
//		
////		List<String> elements = Arrays.asList(commands);
////		System.out.println("elements -> " + elements);
////		List<Integer> deathNote = new ArrayList<Integer>();
////		if(commands.length > 0 && commands[0].matches(EMPTY_REG)) {
////			for(int i=0; i < commands.length; i++) {
////				if(commands[i].matches(EMPTY_REG)) {
////					deathNote.add(i); 
////				}
////			}
////			for(int i=0; ;i++) {
////				commands = ArrayUtils.removeElement(commands, EMPTY);
////				if(i==deathNote.size()) break;
////			}
////		}
//		
//
//		
//		return commands;
//	}
//
//	private static String[] removeFirstEmptyCommand2(String[] commands) {
//		if(commands.length > 0) {
//			final List<String> list = new ArrayList<String>();
////			System.out.println("배열 첫번째 요소가 비어있는지 확인 : " + "["+commands[0]+"]");
//			if(commands[0].matches(EMPTY)) {
//				Collections.addAll(list, commands);
////				System.out.println("복사뜬 list : " + list.toString() );
//				list.remove(0);
//				commands = list.toArray(new String[list.size()]);
////				System.out.println("비어있는 요소 제거한 list : " + list.toString());
////				System.out.println("복사뜬 commands : " + Arrays.toString(commands));
//			}
//			
//		}
//		return commands;
//	}
//	
//	
//	public static boolean isCommandsValid(String[] commands) {
//		System.out.println("배열 요소 개수: " + commands.length);
//		if(commands.length <= 0) {
//			return false;
//		}
//		for (int i = 0; i < commands.length; i++)
//			System.out.format("[%2d] = '%s'%n", i, commands[i]);
//		return true;
//	}
//	
//	
//		
//	
//	
//}
