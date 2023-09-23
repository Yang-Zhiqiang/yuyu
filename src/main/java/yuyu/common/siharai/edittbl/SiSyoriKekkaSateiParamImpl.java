package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HigaitouRiyuuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_YouhiblnkKbn;


/**
 * 保険金給付金支払 保険金給付金支払共通 処理結果(査定)Paramインターフェース実現クラス
 */
public class SiSyoriKekkaSateiParamImpl implements SiSyoriKekkaSateiParam{

    private C_HushrGeninKbn hushrgeninkbn;

    private C_HigaitouRiyuuKbn higaitouriyuukbn;

    private String reportcomment;

    private C_YouhiblnkKbn sessyouyhkbn;

    private String sessyousisyacd;

    private BizDate kaiketuymd;

    @Override
    public C_HushrGeninKbn getHushrgeninkbn() {
        return hushrgeninkbn;
    }

    @Override
    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn) {
        hushrgeninkbn = pHushrgeninkbn;
    }

    @Override
    public C_HigaitouRiyuuKbn getHigaitouriyuukbn() {
        return higaitouriyuukbn;
    }

    @Override
    public void setHigaitouriyuukbn(C_HigaitouRiyuuKbn pHigaitouriyuukbn) {
        higaitouriyuukbn = pHigaitouriyuukbn;
    }

    @Override
    public String getReportcomment() {
        return reportcomment;
    }

    @Override
    public void setReportcomment(String pReportcomment) {
        reportcomment = pReportcomment;
    }

    @Override
    public C_YouhiblnkKbn getSessyouyhkbn() {
        return sessyouyhkbn;
    }

    @Override
    public void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn) {
        sessyouyhkbn = pSessyouyhkbn;
    }

    @Override
    public String getSessyousisyacd() {
        return sessyousisyacd;
    }

    @Override
    public void setSessyousisyacd(String pSessyousisyacd) {
        sessyousisyacd = pSessyousisyacd;
    }

    @Override
    public BizDate getKaiketuymd() {
        return kaiketuymd;
    }

    @Override
    public void setKaiketuymd(BizDate pKaiketuymd) {
        kaiketuymd = pKaiketuymd;
    }

}
