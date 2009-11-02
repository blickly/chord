package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,i) such that method m contains
 * method invocation statement i.
 */
@Chord(
	name = "MI",
	sign = "M0,I0:I0xM0"
)
public class RelMI extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
