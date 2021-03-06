package chord.rels;

import chord.program.insts.InvkInst;
import chord.program.Var;
import chord.project.Chord;
import chord.project.ProgramRel;

import chord.doms.DomI;
import chord.doms.DomZ;
import chord.doms.DomV;

/**
 * Relation containing each tuple (i,z,v) such that local variable v
 * is the zth argument variable of method invocation statement i.
 */
@Chord(
	name = "IinvkArg",
	sign = "I0,Z0,V1:I0_V1_Z0"
)
public class RelIinvkArg extends ProgramRel {
	public void fill() {
	    DomI domI = (DomI) doms[0];
	    DomZ domZ = (DomZ) doms[1];
	    DomV domV = (DomV) doms[2];
            int numI = domI.size();
            for (int iIdx = 0; iIdx < numI; iIdx++) {
                InvkInst iVal = domI.get(iIdx);
                int zIdx = 0;
                for (Var arg : iVal.getArgs()) {
                        int vIdx = domV.get(arg);
                        add(iIdx, zIdx, vIdx);
                        zIdx++;
                }
            }
	}
}
