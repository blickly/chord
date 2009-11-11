package chord.rels;

import chord.program.CFG;
import chord.program.Method;
import chord.program.insts.Inst;
import chord.program.insts.ObjValAsgnInst;
import chord.program.insts.ObjVarAsgnInst;
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
	    DomM domM = (DomM) doms[0];
            DomV domV = (DomV) doms[1];	    
            for (Method meth : domM) {
                CFG cfg = meth.getCFG();
                if (cfg == null)
                    continue;
                for (Inst inst : cfg.getNodes()) {
                    if (inst instanceof ObjVarAsgnInst) {
                        ObjVarAsgnInst asgn = (ObjVarAsgnInst) inst;
                        int mIdx = domM.get(meth);
                        int v0Idx = domV.get(asgn.getLvar());
                        int v1Idx = domV.get(asgn.getRvar());
                        add(mIdx, v0Idx, v1Idx);
                    }
                }
            }
	}
}
