package chord.rels;

import chord.program.Method;
import chord.project.Chord;
import chord.project.ProgramRel;
import chord.doms.DomM;

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
        DomM domM = (DomM) doms[0];
        for (Method mVal : domM) {
            if (mVal.isClinit())
                add(mVal);
        }
    }
}
