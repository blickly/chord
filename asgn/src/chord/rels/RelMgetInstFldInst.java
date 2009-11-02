package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing each tuple (m,v,f,b) such that method m
 * contains a statement of the form <tt>v = b.f</tt>.
 */
@Chord(
	name = "MgetInstFldInst",
	sign = "M0,V0,F0,V1:F0_M0_V0xV1"
)
public class RelMgetInstFldInst extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
