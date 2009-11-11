package chord.rels;

import chord.program.CFG;
import chord.program.Method;
import chord.program.insts.Inst;
import chord.program.insts.ObjValAsgnInst;
import chord.project.Chord;
import chord.project.ProgramRel;

import chord.doms.DomM;
import chord.doms.DomV;
import chord.doms.DomH;

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
	    DomM domM = (DomM) doms[0];
            DomV domV = (DomV) doms[1];
            DomH domH = (DomH) doms[2];
            /* // Canceled approach 1
            int sizeH = domH.size()
            for (int hIdx = 0; hIdx < sizeH; hIdx++) {
                ObjValAsgnInst hVal = domH.get(hIdx);
                // FIXME: Is immediate contaier only adequate?
                mIdx = domM.get(hVal.getImmediateCtnrMethod());
                vIdx = domV.get(hVal.getVar());
                add(mIdx, vIdx, hIdx);
            }
            */
            for (Method meth : domM) {
                CFG cfg = meth.getCFG();
                if (cfg == null)
                        continue;
                for (Inst inst : cfg.getNodes()) {
                        if (inst instanceof ObjValAsgnInst) {
                            ObjValAsgnInst hVal = (ObjValAsgnInst) inst;
                            int mIdx = domM.get(meth);
                            int vIdx = domV.get(hVal.getVar());
                            int hIdx = domH.get(hVal);
                            add(mIdx, vIdx, hIdx);
                        }
                }
            }
	}
}
