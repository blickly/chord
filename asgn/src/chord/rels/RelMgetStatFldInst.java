package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,v,f) such that method m contains
 * a statement of the form <tt>v = f</tt>.
 */
@Chord(
	name = "MgetStatFldInst",
	sign = "M0,V0,F0:F0_M0_V0"
)
public class RelMgetStatFldInst extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
