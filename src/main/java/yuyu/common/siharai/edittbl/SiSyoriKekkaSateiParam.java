package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HigaitouRiyuuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_YouhiblnkKbn;


/**
 * 保険金給付金支払 保険金給付金支払共通 処理結果(査定)Paramインターフェースクラス
 */
public interface SiSyoriKekkaSateiParam {

    C_HushrGeninKbn getHushrgeninkbn();

    void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn);

    C_HigaitouRiyuuKbn getHigaitouriyuukbn();

    void setHigaitouriyuukbn(C_HigaitouRiyuuKbn pHigaitouriyuukbn);

    String getReportcomment();

    void setReportcomment(String pReportcomment);

    C_YouhiblnkKbn getSessyouyhkbn();

    void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn);

    String getSessyousisyacd();

    void setSessyousisyacd(String pSessyousisyacd);

    BizDate getKaiketuymd();

    void setKaiketuymd(BizDate pKaiketuymd);

}
