package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (i,z,v) such that local variable v
 * is the zth return variable of method invocation statement i.
 */
@Chord(
	name = "IinvkRet",
	sign = "I0,Z0,V0:I0_V0_Z0"
)
public class RelIinvkRet extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
