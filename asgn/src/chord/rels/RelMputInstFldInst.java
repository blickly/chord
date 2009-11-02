package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,b,f,v) such that method m
 * contains a statement of the form <tt>b.f = v</tt>.
 */
@Chord(
	name = "MputInstFldInst",
	sign = "M0,V0,F0,V1:F0_M0_V0xV1"
)
public class RelMputInstFldInst extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
