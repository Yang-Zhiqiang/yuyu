package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 帳票編集共通Bean
 */
public class SiTyouhyouHensyuuCommonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate syoriYmd;

    private C_SyoruiCdKbn syoruiCd;

    public SiTyouhyouHensyuuCommonBean() {
        syoriYmd = null;
        syoruiCd = null;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }
}
