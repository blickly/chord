package chord.rels;

import chord.program.CFG;
import chord.program.Method;
import chord.program.insts.Inst;
import chord.program.insts.ObjVarAsgnInst;
import chord.project.Chord;
import chord.project.ProgramRel;

import chord.program.insts.InstFldRefInst;
import chord.program.insts.AryElemRefInst;
import chord.program.Var;

import chord.doms.DomM;
import chord.doms.DomV;
import chord.doms.DomF;

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
	    DomM domM = (DomM) doms[0];
            for (Method meth : domM) {
                CFG cfg = meth.getCFG();
                if (cfg == null)
                    continue;
                for (Inst inst : cfg.getNodes()) {
                    if (inst instanceof InstFldRefInst) {
                        InstFldRefInst asgn = (InstFldRefInst) inst;
                        if (!asgn.isWr()) {
                            Var v = asgn.getVar();
                            if (v == null) continue;
                            add(meth, v, asgn.getField(), asgn.getBase());
                        }
                    } else if (inst instanceof AryElemRefInst) {
                        AryElemRefInst asgn = (AryElemRefInst) inst;
                        if (!asgn.isWr()) {
                            Var v = asgn.getVar();
                            if (v == null) continue;
                            add(meth, v, asgn.getField(), asgn.getBase());
                        }
                    }
                }
            }
	}
}
