package org.example;

public class User {
    private String password;
    
    public void initPassword(PasswordGenerator passwordGenerator) {
        //as-is  내부에서 RandomPassworGenerator에 의존
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator(); 강한 결합도

        //to-be  (인터페이스 구현) 테스트를 위한 코드
        //낮은 결합도
        String Password = passwordGenerator.generatePassword();
        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if(Password.length() >= 8 && Password.length() <= 12) {
            this.password = Password;
        }
    }

    public String getPassword() {
        return password;
    }
}
