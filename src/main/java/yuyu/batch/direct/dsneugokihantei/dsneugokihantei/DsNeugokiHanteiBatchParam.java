package yuyu.batch.direct.dsneugokihantei.dsneugokihantei;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_Tuukasyu;

/**
 * ダイレクトサービス 値動き判定 値動き判定バッチパラメータクラス
 */
@BatchScoped
public class DsNeugokiHanteiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private C_Tuukasyu syorikyktuukasyu;

    private int syoriymdhoseinissuu;

    public C_Tuukasyu getSyorikyktuukasyu() {
        return syorikyktuukasyu;
    }

    public void setSyorikyktuukasyu(C_Tuukasyu pSyorikyktuukasyu) {
        syorikyktuukasyu = pSyorikyktuukasyu;
    }

    public int getSyoriymdhoseinissuu() {
        return syoriymdhoseinissuu;
    }

    public void setSyoriymdhoseinissuu(int pSyoriymdhoseinissuu) {
        syoriymdhoseinissuu = pSyoriymdhoseinissuu;
    }

}
