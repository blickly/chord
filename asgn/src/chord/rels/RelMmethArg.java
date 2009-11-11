package chord.rels;

import chord.program.Method;
import chord.project.Chord;
import chord.project.ProgramRel;
import chord.program.Var;

import chord.doms.DomM;
import chord.doms.DomZ;
import chord.doms.DomV;

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
            DomM domM = (DomM) doms[0];
            //DomZ domZ = (DomZ) doms[1];
            DomV domV = (DomV) doms[2];
            int numM = domM.size();
            for (int mIdx = 0; mIdx < numM; mIdx++) {
                Method mVal = domM.get(mIdx);
                int zIdx = 0;
                if (mVal.hasCFG()) {
                    for (Var arg : mVal.getCFG().getArgs()) {
                        int vIdx = domV.get(arg);
                        add(mIdx, zIdx, vIdx);
                        zIdx++;
                    }
                }
            }
	}
}
