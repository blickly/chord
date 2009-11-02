package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,z,v) such that local variable
 * v is the zth argument variable of method m.
 */
@Chord(
	name = "MmethArg",
	sign = "M0,Z0,V0:M0_V0_Z0"
)
public class RelMmethArg extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
