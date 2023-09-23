package yuyu.common.siharai.siview.viewskjyouhou;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;

/**
 * 保険金給付金支払 支払画面部品 請求者情報表示クラス <br />
 */
public class ViewSkjyouhouUiBeanParamImpl implements ViewSkjyouhouUiBeanParam{

    private C_SeikyuusyaKbn seikyuusyakbn;

    private C_SiHonninKakninKekkaKbn sihonninkakninkbn;

    private BizDate seikyuusyaseiymd;

    private C_Seibetu seikyuusyasei;

    private String seikyuusyanmkn;

    private String seikyuusyanmkj;

    private boolean viewSkjyouhouInputDispFlg;

    private boolean viewSkjyouhouSeigyo;

    private boolean viewSkjyouhouDispFlg;

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

    @Override
    public boolean isViewSkjyouhouInputDispFlg() {
        return viewSkjyouhouInputDispFlg;
    }

    @Override
    public boolean isViewSkjyouhouSeigyo() {
        return viewSkjyouhouSeigyo;
    }

    @Override
    public boolean isViewSkjyouhouDispFlg() {
        return viewSkjyouhouDispFlg;
    }

}
