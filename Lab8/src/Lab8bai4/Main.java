package Lab8bai4;

public class Main {
	public static void main(String[] args) {
		String welcome = """
                Xin chào!
                Chào mừng bạn đến với Java 2.
                Chúc bạn học tốt!
                """;
        System.out.println(welcome);

        String name = "An";

        String email = """
                Dear %s,
                Welcome to Java course!
                Best regards!
                """.formatted(name);

        System.out.println(email);

        String html = """
                <html>
                    <body>
                        <h1>%s</h1>
                        <p>GPA: %.2f</p>
                    </body>
                </html>
                """.formatted("An", 3.5);

        System.out.println(html);

        String sql = """
                SELECT * FROM Student
                WHERE gpa > 3.0
                """;

        System.out.println(sql);
    }

}
