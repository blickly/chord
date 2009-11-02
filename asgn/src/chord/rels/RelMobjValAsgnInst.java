package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,v,h) such that method m contains
 * object allocation statement h which assigns to local variable v.
 */
@Chord(
	name = "MobjValAsgnInst",
	sign = "M0,V0,H0:M0_V0_H0"
)
public class RelMobjValAsgnInst extends ProgramRel {
	public void fill() {
		throw new RuntimeException("cs265: implement this method");
	}
}
