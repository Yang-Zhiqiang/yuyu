package yuyu.common.hozen.khview.viewhihokensya;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;

/**
 * 契約保全 契約保全画面部品 被保険者情報表示 <br />
 */
public interface ViewHihokensyaUiBeanParam extends CommonViewUiBeanParam {

    public String getVhhkshhknnmkn();

    public void setVhhkshhknnmkn(String pVhhkshhknnmkn);

    public String getVhhkshhknnmkj();

    public void setVhhkshhknnmkj(String pVhhkshhknnmkj);

    public C_KjkhukaKbn getVhhkshhknnmkjkhukakbn();

    public void setVhhkshhknnmkjkhukakbn(C_KjkhukaKbn pVhhkshhknnmkjkhukakbn);

    public BizDate getVhhkshhknseiymd();

    public void setVhhkshhknseiymd(BizDate pVhhkshhknseiymd);

    public C_Hhknsei getVhhkshhknsei();

    public void setVhhkshhknsei(C_Hhknsei pVhhkshhknsei);

}
