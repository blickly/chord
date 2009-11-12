package chord.rels;

import chord.program.CFG;
import chord.program.Method;
import chord.program.Var;
import chord.program.insts.Inst;
import chord.program.insts.InvkInst;
import chord.project.Chord;
import chord.project.ProgramRel;

import chord.doms.DomM;

/**
 * Relation containing each tuple (m,i) such that method m contains
 * method invocation statement i.
 */
@Chord(
	name = "MI",
	sign = "M0,I0:I0xM0"
)
public class RelMI extends ProgramRel {
    public void fill() {
        DomM domM = (DomM) doms[0];
        for (Method meth : domM) {
            CFG cfg = meth.getCFG();
            if (cfg == null)
                continue;
            for (Inst inst : cfg.getNodes()) {
                if (inst instanceof InvkInst) {
                    add(meth, (InvkInst) inst);
                }
            }
        }
    }
}
