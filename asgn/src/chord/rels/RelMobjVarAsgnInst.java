package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,v1,v2) such that method m
 * contains a copy-assignment statement of the form <tt>v1 = v2</tt> 
 * or a phi-assignment statement of the form 
 * <tt>v1 = phi(...,v2,...)</tt>.
 */
@Chord(
	name = "MobjVarAsgnInst",
	sign = "M0,V0,V1:M0_V0xV1"
)
public class RelMobjVarAsgnInst extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
