package yuyu.common.hozen.khview.viewkyksyadairi;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;

/**
 * 契約保全 契約保全画面部品 契約者代理人情報表示 <br />
 */
public interface ViewKyksyadairiUiBeanParam extends CommonViewUiBeanParam {

    public C_UktKbn getVkykdrkykdrkbn();

    public void setVkykdrkykdrkbn(C_UktKbn pVkykdrkykdrkbn);

    public String getVkykdrkykdrnmkn();

    public void setVkykdrkykdrnmkn(String pVkykdrkykdrnmkn);

    public String getVkykdrkykdrnmkj();

    public void setVkykdrkykdrnmkj(String pVkykdrkykdrnmkj);

    public C_KjkhukaKbn getVkykdrkykdrnmkjkhukakbn();

    public void setVkykdrkykdrnmkjkhukakbn(C_KjkhukaKbn pVkykdrkykdrnmkjkhukakbn);

    public BizDate getVkykdrkykdrseiymd();

    public void setVkykdrkykdrseiymd(BizDate pVkykdrkykdrseiymd);

    public String getVkykdrkykdryno();

    public void setVkykdrkykdryno(String pVkykdrkykdryno);

    public String getVkykdrkykdradr1kj();

    public void setVkykdrkykdradr1kj(String pVkykdrkykdradr1kj);

    public String getVkykdrkykdradr2kj();

    public void setVkykdrkykdradr2kj(String pVkykdrkykdradr2kj);

    public String getVkykdrkykdradr3kj();

    public void setVkykdrkykdradr3kj(String pVkykdrkykdradr3kj);
}
