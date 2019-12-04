//package jpastart.main;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import jpastart.jpa.EMF;
//import jpastart.utils.DelayUtil;
//
//public class UserMain2 {
//	
//	private static final String NOT_ALLOWED = " ";
//	private static final String DELIMITER = " ";
//	
//	public static void main(String[] args) {
//		
//		//EntityManagerFactory 생성
//		EMF.init();
//		
//		//콘솔에서 명령어 입력받기 위한 BufferedReader 생성
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		
//		try {
//			
//			while (true) {
//				System.out.println("명령어를 입력하세요.");
//				//콘솔에서 한 줄을 입력받음
//				String line = reader.readLine();
//				System.out.println("입력한 값 : " + "["+line+"]");
//																//System.out.println("빈칸이 입력된 위치 : " + (line.indexOf(NOT_ALLOWED)+1) );
//				//입력받은 문자열을 공백문자로 분리
//				String[] commands = line.split(DELIMITER);
//																//입력받은 문자열을 탭으로 분리
//																//String[] commands = line.split("\t");
//				//분리된 문자열 배열 콘솔에서 확인
//				dumpArray(commands);
//				
//				if(line.indexOf(" ") == 0) {
//					System.out.println("빈 칸을 입력할 수 없습니다. 다시 입력해주세요.");
//				}
//				//입력한 명령어가 "exit"면 while 루프 종료
//				else if (commands[0].equalsIgnoreCase("exit")) {
//					System.out.println("종료합니다");
//					break;
//				} else if (commands[0].equalsIgnoreCase("join")) {
//				} else if (commands[0].equalsIgnoreCase("view")) {
//				} else if (commands[0].equalsIgnoreCase("list")) {
//				} else if (commands[0].equalsIgnoreCase("chagename")) {
//				} else if (commands[0].equalsIgnoreCase("withdraw")) {
//				} else if (commands[0].equalsIgnoreCase(" ")) {
//					
//				//올바른 명령어 가 아니면 안내 메시지 출력	
//				} else if(line.indexOf(" ") == 0) {
//					System.out.println("빈칸은 입력할 수 없습니다. 다시 입력해주세요.");
//				} else {
//					System.out.println("올바른 명령어를 입력하세요.");
//				}
//				System.out.println("---------");
//			}
//			
//			//EntityManagerFactory 종료
//			EMF.close();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("----- 잘못된 명령입니다. 5초 후 입력을 재시작합니다. ----");
//			
//			//sleep 메서드 또는 DelayUtil 사용하여 메인메서드 호출 지연
//			//Thread.sleep(5000);
//			DelayUtil timer = new DelayUtil();
//			timer.delay(5000);
//			
//			main(args);
//			
//			
//		}
//		
//		
//	}
//	
//	
//	public static boolean dumpArray(String[] a) {
//		System.out.println("배열 요소 개수: " + a.length);
//		for (int i = 0; i < a.length; i++)
//			System.out.format("[%2d] = '%s'%n", i, a[i]);
//		
//		return true;
//	}
//}
