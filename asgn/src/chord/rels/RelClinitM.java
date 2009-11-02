package chord.rels;

import chord.project.Chord;
import chord.project.ProgramRel;

/**
 * Relation containing all class initializer methods, namely, methods
 * having signature <tt>&lt;clinit&gt;()</tt>.
 */
@Chord(
	name = "clinitM",
	sign = "M0"
)
public class RelClinitM extends ProgramRel {
	public void fill() {
        throw new RuntimeException("cs265: implement this method");
	}
}
