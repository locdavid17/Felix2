package gen_pass;
import org.mindrot.jbcrypt.BCrypt;

public class GenPass {
	public static void main(String[] args) {
		System.out.println(BCrypt.hashpw("123456", BCrypt.gensalt(12)));
		System.out.println(BCrypt.checkpw("123456", "$2a$12$s8FyYcAauHqILMBcI6x0BepO5JI.9/C16QRYMswF7Avt0rRkOiR0u"));
		System.out.println(BCrypt.checkpw("123456", "$2a$12$nVgg9KNjB8GlrKXPP1ded.UaiOuVrso.or1/LIo3W5Gken4XiYc/6"));
	}
}
