//Use a Sealed class Class concept to create a class hierarchy. Mark Child classes as final, sealed, and non sealed and observe their behavior

// Sealed parent
public sealed abstract class Question6
        permits MCQ, Descriptive, Coding {
}

// Final child: cannot be extended further
public final class MCQ extends Question {
}

// Sealed child: controls its own subclasses
public sealed abstract class Descriptive extends Question
        permits ShortAnswer {
}

// Final grandchild
public final class ShortAnswer extends Descriptive {
}

// Non-sealed child: reopens extension
public non-sealed class Coding extends Question {
}

// Allowed because Coding is non-sealed
public class JavaCoding extends Coding {
}
