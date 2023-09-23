package yuyu.common.hozen.khview.viewsiteiseikyuu;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;

/**
 * 契約保全 契約保全画面部品 被保険者代理人情報表示 <br />
 */
public interface ViewSiteiseikyuuUiBeanParam extends CommonViewUiBeanParam {

    public C_UktKbn getVstsksiteidruktkbn();

    public void setVstsksiteidruktkbn(C_UktKbn pVstsksiteidruktkbn);

    public String getVstskstdrsknmkn();

    public void setVstskstdrsknmkn(String pVstskstdrsknmkn);

    public String getVstskstdrsknmkj();

    public void setVstskstdrsknmkj(String pVstskstdrsknmkj);

    public C_KjkhukaKbn getVstskstdrsknmkjhukakbn();

    public void setVstskstdrsknmkjhukakbn(C_KjkhukaKbn pVstskstdrsknmkjhukakbn);

    public BizDate getVstskstdrskseiymd();

    public void setVstskstdrskseiymd(BizDate pVstskstdrskseiymd);


}
