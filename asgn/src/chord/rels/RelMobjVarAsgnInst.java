package chord.rels;

import chord.program.CFG;
import chord.program.Method;
import chord.program.insts.Inst;
import chord.program.insts.ObjValAsgnInst;
import chord.program.insts.ObjVarAsgnInst;
import chord.project.Chord;
import chord.project.ProgramRel;

import chord.program.Var;
import chord.program.insts.PhiExpAsgnInst;
import chord.doms.DomM;
import chord.doms.DomV;

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
            for (Method meth : domM) {
                CFG cfg = meth.getCFG();
                if (cfg == null)
                    continue;
                for (Inst inst : cfg.getNodes()) {
                    if (inst instanceof ObjVarAsgnInst) {
                        ObjVarAsgnInst asgn = (ObjVarAsgnInst) inst;
                        add(meth, asgn.getLvar(), asgn.getRvar());
                    } else if (inst instanceof PhiExpAsgnInst) {
                        PhiExpAsgnInst asgn = (PhiExpAsgnInst) inst;
                        for (Var rVar : asgn.getRvars()) {
                            add(meth, asgn.getLvar(), rVar);
                        }
                    }
                }
            }
	}
}
