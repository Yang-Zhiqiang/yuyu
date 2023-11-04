package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.edittbl.EditSateiRrkTblParam;
import yuyu.common.siharai.edittbl.SiSyoriKekkaParam;
import yuyu.common.siharai.edittbl.SiSyoriKekkaSateiParam;
import yuyu.def.classification.C_HigaitouRiyuuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定承認履歴TBL編集パラメータ（処理結果Param、処理結果(査定)Param）実現クラス
 */
public class EditSateiRrkTblParamImpl implements EditSateiRrkTblParam, SiSyoriKekkaParam, SiSyoriKekkaSateiParam {

    private C_SyorikekkaKbn syorikekkakbn;

    private String tennousakisousasyacd;

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

    @Override
    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    @Override
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {
        tennousakisousasyacd = pTennousakisousasyacd;
    }

    @Override
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    @Override
    public String getTennousakisousasyacd() {
        return tennousakisousasyacd;
    }
}
