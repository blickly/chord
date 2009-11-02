package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,z,v) such that local variable
 * v is the zth return variable of method m.
 */
@Chord(
	name = "MmethRet",
	sign = "M0,Z0,V1:M0_V1_Z0"
)
public class RelMmethRet extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
