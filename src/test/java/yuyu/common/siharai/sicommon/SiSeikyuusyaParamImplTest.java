package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSeikyuusyaParam;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報Paramインターフェース実装クラス（テスト用）
 */
public class SiSeikyuusyaParamImplTest implements SiSeikyuusyaParam ,EditSkTblParam{

    private C_SeikyuusyaKbn seikyuusyakbn;

    private C_SiHonninKakninKekkaKbn sihonninkakninkbn;

    private BizDate seikyuusyaseiymd;

    private C_Seibetu seikyuusyasei;

    private String seikyuusyanmkn;

    private String seikyuusyanmkj;

    @Override
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    @Override
    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    @Override
    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn() {
        return sihonninkakninkbn;
    }

    @Override
    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn) {
        sihonninkakninkbn = pSihonninkakninkbn;
    }

    @Override
    public BizDate getSeikyuusyaseiymd() {
        return seikyuusyaseiymd;
    }

    @Override
    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd) {
        seikyuusyaseiymd = pSeikyuusyaseiymd;
    }

    @Override
    public C_Seibetu getSeikyuusyasei() {
        return seikyuusyasei;
    }

    @Override
    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei) {
        seikyuusyasei = pSeikyuusyasei;
    }

    @Override
    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Override
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    @Override
    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Override
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }
}
