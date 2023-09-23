package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;

/**
 * 契約保全 UiBean設定 契約者代理人情報設定UiBeanパラメータ
 */
public interface SetKyksyadairiExecUiBeanParam {

    String getSyono();

    void setVkykdrkykdrkbn(C_UktKbn pVkykdrkykdrkbn);

    void setVkykdrkykdrnmkn(String pVkykdrkykdrnmkn);

    void setVkykdrkykdrnmkj(String pVkykdrkykdrnmkj);

    void setVkykdrkykdrnmkjkhukakbn(C_KjkhukaKbn pVkykdrkykdrnmkjkhukakbn);

    void setVkykdrkykdrseiymd(BizDate pVkykdrkykdrseiymd);

    void setVkykdrkykdryno(String pVkykdrkykdryno);

    void setVkykdrkykdradr1kj(String pVkykdrkykdradr1kj);

    void setVkykdrkykdradr2kj(String pVkykdrkykdradr2kj);

    void setVkykdrkykdradr3kj(String pVkykdrkykdradr3kj);
}
