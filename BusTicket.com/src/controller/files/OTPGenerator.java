package controller.files;

public class OTPGenerator {

	public int OTPGenerator(String to) {
		int min = 100000;
		int max = 999999;
		int otp_final = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		System.out.println(otp_final);
		String from = "19euit065@skcet.ac.in";      
		String password = "19euit065skcet@KJV9";	   
		String title = "OTP Verification mail from BUSTICKET.COM";
		String message = "We have send an OTP for Payment Process."
				+ "Your OTP is valid for two minutes only. OTP is "+otp_final;
		new Gmail().Gmail(from, to, password, title, message);
		return otp_final;
	}

}
