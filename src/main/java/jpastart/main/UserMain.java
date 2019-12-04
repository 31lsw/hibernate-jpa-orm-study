package jpastart.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;

import jpastart.jpa.EMF;
import jpastart.jpa.application.ChangeNameService;
import jpastart.jpa.application.DuplicatedEmailException;
import jpastart.jpa.application.GetUserListService;
import jpastart.jpa.application.GetUserService;
import jpastart.jpa.application.JoinService;
import jpastart.jpa.application.UserNotFoundException;
import jpastart.jpa.application.WithdrawService;
import jpastart.reserve.model.User;

/**
 * @author S
 * == 콘솔 명령어를 통한 JPA를 이용한 사용자 정보 관리 프로그램 ==
 * 현재 메인 클래스를 실행해 콘솔 명령을 입력받아 알맞은 서비스를 실행한다.
 * 1. 각 서비스는 사용자 추가, 조회 , 정보 변경, 삭제 기능
 * 2. 명령어는 다음과 같다.
 * 추가 : join / 조회 : view, list / 변경: changename / 삭제: withdraw
 */
public class UserMain {
	
	private static final String DELIMITER = "\\s";
	private static final String NOT_ALLOWED = "\\s";
	
	private static JoinService joinService = new JoinService();
	private static GetUserService getUserService = new GetUserService();
	private static ChangeNameService changeNameService = new ChangeNameService();
	private static GetUserListService listService = new GetUserListService();
	private static WithdrawService withdrawService = new WithdrawService();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//EntityManagerFactory 생성
		EMF.init();
		
		//콘솔에서 명령어 입력받기 위한 BufferedReader 생성
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
		while (true) {
			System.out.println("명령어를 입력하세요.");
			//콘솔에서 한 줄을 입력받음
			String line = reader.readLine();
														//System.out.println("입력한 문자열 : " + line);
			//입력받은 문자열을 공백문자로 분리
			String[] commands = line.split(DELIMITER);
														//dumpArray(commands);
														//System.out.println("공백문자로 분리 : " + Arrays.toString(commands));
			// 배열 널 처리
			boolean result = commandArrValid(commands);
			
			if(!result) {
				System.out.println("올바른 명령어를 입력하세요.");
			} else {
				//입력한 명령어가 "exit"면 while 루프 종료
				if (commands[0].equalsIgnoreCase("exit")) {
					System.out.println("종료합니다");
					break;
				} else if (commands[0].equalsIgnoreCase("join")) {
					handleJoinCommand(commands);
				} else if (commands[0].equalsIgnoreCase("view")) {
					handleViewCommand(commands);
				} else if (commands[0].equalsIgnoreCase("list")) {
					handleListCommand();
				} else if (commands[0].equalsIgnoreCase("changename")) {
					handleChangeName(commands);
				} else if (commands[0].equalsIgnoreCase("withdraw")) {
					handleWithdrawCommand(commands);
				} else if (commands[0].equalsIgnoreCase(NOT_ALLOWED) || commands[0].equalsIgnoreCase("")) {
				//올바른 명령어 가 아니면 안내 메시지 출력	
				} else {
					System.out.println("올바른 명령어를 입력하세요.");
				}
				System.out.println("---------");
			}
			
		}
		//EntityManagerFactory 종료
		EMF.close();
	}
	
	private static void handleWithdrawCommand(String[] cmd) {
		if(cmd.length !=2) {
			System.out.println("명령어가 올바르지 않습니다.");
			System.out.println("사용법 : withdraw 이메일");
			return;
		}
		try {
			withdrawService.withdraw(cmd[1]);
			System.out.println("탈퇴처리 했습니다.");
		} catch (UserNotFoundException e) {
			System.out.println("존재하지 않습니다.");
			e.printStackTrace();
		}
	}

	private static void handleListCommand() {
		List<User> users = listService.getAllUsers();
		if(users.isEmpty()) {
			System.out.println("사용자가 없습니다.");
		} else {
			users.forEach(user ->
				System.out.printf("| %s | %s | %tY-%<tm-%<td |\n",
									user.getEmail(), user.getName(), user.getCreateDate())
								);
		}
//		if(Optional.ofNullable(users).isPresent()) {
//			
//		}
	}

	private static void handleChangeName(String[] cmd) {
		if (cmd.length != 3) {
			System.out.println("명령어가 올바르지 않습니다.");
			System.out.println("사용법 : changename 이메일 새이름");
			return;
		}
		try {
			//changeNameService.changeName(cmd[1], cmd[2]);
			Optional<User> userOpt = changeNameService.changeName(cmd[1], cmd[2]);
			if(userOpt.isPresent()) {
				System.out.println("이름을 변경했습니다.");
				User user = userOpt.get();
				System.out.println("이름 : " + user.getName());
				System.out.println("이메일 : " + user.getEmail());
				String modifiedDate = String.format("%TF %<TT", user.getModifiedDate());
				System.out.println("변경 : " + modifiedDate);
				System.out.printf("변경 : %TF %<TT\n", user.getModifiedDate());
				
			} else {
				System.out.println("변경을 실패했습니다.");         
			}
		} catch (UserNotFoundException e) {
			System.out.println("존재하지 않습니다.");
		}
	}

	private static void handleViewCommand(String[] cmd) {
		if(cmd.length != 2) {
			System.out.println("명령어가 올바르지 않습니다.");
			System.out.println("사용법 : view 이메일");
			return;
		}
		Optional<User> userOpt = getUserService.getUser(cmd[1]);
		if(userOpt.isPresent()) {
			User user = userOpt.get();
			System.out.println("이름 : " + user.getName());
			System.out.printf("생성 : %tY-%<tm-%<td\n", user.getCreateDate());
//			System.out.printf("현재 : %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", new Date());
			
			String date = String.format("%TF", user.getCreateDate());
			String time = String.format("%TT", user.getCreateDate());
			String createDate = String.format("%TF %<TT", user.getCreateDate());
//			String currentDate = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", new Date());
			
			System.out.println("생성 날짜 : " + date);
			System.out.println("생성 시각 : " + time);
			System.out.println("생성 : " + createDate);
//			System.out.println("현재 : " + currentDate);
			
		} else {
			System.out.println("존재하지 않습니다.");         
		}
	}
	
	private static void handleJoinCommand(String[] cmd) {
		if(cmd.length != 3) {
			System.out.println("명령어가 올바르지 않습니다.");
			System.out.println("사용법: join 이메일 이름");
			return;
		}
		try {
//			joinService.join(new User(cmd[1], cmd[2], new Date()));
			Optional<User> userOpt = joinService.join(new User(cmd[1], cmd[2], new Date()));
			if(userOpt.isPresent()) {
				User user = userOpt.get();
				System.out.println("가입이 완료되었습니다.");
				System.out.println("이름 : " + user.getName());
				System.out.println("이메일 : " + user.getName());
				System.out.printf("가입일 : %tY-%<tm-%<td\n", user.getCreateDate());
//				System.out.printf("가입 : %TF %<TT\n", user.getCreateDate());
//				System.out.printf("가입 : %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", user.getCreateDate());
			} else {
				System.out.println("알 수 없는 오류가 발생했습니다.");         
			}
			
		} catch (DuplicatedEmailException e) {
			System.out.println("이미 같은 이메일을 가진 사용자가 존재합니다.");
		}
	}
	
	
	private static boolean commandArrValid(String[] commands) {
		if(commands.length <= 0) {
			return false;
		}
		return true;
	}
	
	
	
	
}
