//Demonstrate the use of repeat(), strip(),trim(), isBlank(), indent(), transform(), stripIndent(), translateEscapes(),tripleQuotes and formatted() methods.
public class Question4 {
    public static void main(String[] args) {

        // repeat()
        String star = "*".repeat(5);
        System.out.println("repeat(): " + star);

        // trim() vs strip()
        String text = "  ToTheNew  ";
        System.out.println("trim(): [" + text.trim() + "]");
        System.out.println("strip(): [" + text.strip() + "]");

        // isBlank()
        String blank = "   ";
        System.out.println("isBlank(): " + blank.isBlank());

        // indent()
        String line = "Hello\nWorld";
        System.out.println("indent():\n" + line.indent(4));

        // transform()
        String transformed =
            "java"
                .transform(s -> s.toUpperCase())
                .transform(s -> s + " STREAM");
        System.out.println("transform(): " + transformed);

        // stripIndent()
        String indentedText = """
                Line one
                    Line two
                Line three
                """;
        System.out.println("stripIndent():\n" + indentedText.stripIndent());

        // translateEscapes()
        String escaped = "Hello\\nWorld\\tJava";
        System.out.println("translateEscapes():");
        System.out.println(escaped.translateEscapes());

        // tripleQuotes (Text Blocks)
        String json = """
                {
                    "name": "Saurabh",
                    "age": 23
                }
                """;
        System.out.println("Text Block:\n" + json);

        // formatted()
        String formatted =
            "Name: %s, Score: %.2f"
                .formatted("Padam", 92.5);
        System.out.println("formatted(): " + formatted);
    }
}
