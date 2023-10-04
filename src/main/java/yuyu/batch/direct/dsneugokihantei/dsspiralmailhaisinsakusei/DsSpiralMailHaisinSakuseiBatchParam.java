package yuyu.batch.direct.dsneugokihantei.dsspiralmailhaisinsakusei;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_DsBatchKadouKnkKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;

/**
 * ダイレクトサービス 値動き判定 ＳＰＩＲＡＬメール配信Ｆ作成バッチパラメータ
 */
@BatchScoped
public class DsSpiralMailHaisinSakuseiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    private int syoriymdhoseinissuu;

    private C_DsBatchKadouKnkKbn dsBatchKadouknkKbn;

    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }

    public int getSyoriymdhoseinissuu() {
        return syoriymdhoseinissuu;
    }

    public void setSyoriymdhoseinissuu(int pSyoriymdhoseinissuu) {
        syoriymdhoseinissuu = pSyoriymdhoseinissuu;
    }
    public C_DsBatchKadouKnkKbn getDsBatchKadouknkKbn() {
        return dsBatchKadouknkKbn;
    }

    public void setDsBatchKadouknkKbn(C_DsBatchKadouKnkKbn pDsBatchKadouknkKbn) {
        dsBatchKadouknkKbn = pDsBatchKadouknkKbn;
    }
}
