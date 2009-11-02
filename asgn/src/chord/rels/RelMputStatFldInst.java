package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,f,v) such that method m contains
 * a statement of the form <tt>f = v</tt>.
 */
@Chord(
	name = "MputStatFldInst",
	sign = "M0,F0,V0:F0_M0_V0"
)
public class RelMputStatFldInst extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
