package chord.rels;

import chord.program.CFG;
import chord.program.Method;
import chord.program.Var;
import chord.program.insts.Inst;
import chord.program.insts.StatFldRefInst;
import chord.project.Chord;
import chord.project.ProgramRel;

import chord.doms.DomM;
import chord.doms.DomV;
import chord.doms.DomF;

/**
 * Relation containing each tuple (m,v,f) such that method m contains
 * a statement of the form <tt>v = f</tt>.
 */
@Chord(
	name = "MgetStatFldInst",
	sign = "M0,V0,F0:F0_M0_V0"
)
public class RelMgetStatFldInst extends ProgramRel {

    public void fill() {
        DomM domM = (DomM) doms[0];
        //DomV domV = (DomV) doms[1];
        //DomF domF = (DomF) doms[2];
        for (Method meth : domM) {
            CFG cfg = meth.getCFG();
            if (cfg == null)
                continue;
            for (Inst inst : cfg.getNodes()) {
                if (inst instanceof StatFldRefInst) {
                    StatFldRefInst asgn = (StatFldRefInst) inst;
                    if (!asgn.isWr()) {
                        Var v = asgn.getVar();
                        if (v == null) continue;
                        add(meth, v, asgn.getField());
                    }
                }
            }
        }
    }
}
