//package jpastart.main;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.List;
//
//import jpastart.jpa.EMF;
//import jpastart.jpa.application.JoinService;
//import jpastart.utils.DelayUtil;
//
///**
// * @author S
// * 콘솔에서 JPA를 이용한 사용자 정보 관리 프로그램
// * 콘솔로 명령을 입력받아 알맞은 서비스를 실행하는 메인 클래스
// * 각 서비스는 사용자 추가, 조회 , 정보 변경, 삭제 기능
// */
//public class UserMain3 {
//	
//	//	private static final String NOT_ALLOWED = " ";
//	private static final String NOT_ALLOWED = "\\s";
//	//	private static final String NOT_ALLOWED = "\\s{1,}";
//	//	private static final String NOT_ALLOWED = "\\s{2,}";
//	//	private static final String DELIMITER = " ";
//	private static final String DELIMITER = "\\s";
//
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
//			
//			boolean isValidated = dumpArrayChkValid(commands);
//			
//			if(!isValidated) {
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
//	
//	public static boolean dumpArrayChkValid(String[] a) {
//		System.out.println("배열 요소 개수: " + a.length);
//		if(a.length <= 0) {
//			return false;
//		}
//		for (int i = 0; i < a.length; i++)
//			System.out.format("[%2d] = '%s'%n", i, a[i]);
//		return true;
//	}
//	
//	
//		
//	
//	
//}
