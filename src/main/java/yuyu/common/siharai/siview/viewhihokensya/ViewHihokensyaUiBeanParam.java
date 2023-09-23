package yuyu.common.siharai.siview.viewhihokensya;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Hhknsei;

/**
 * 保険金給付金支払 支払画面部品 被保険者情報表示 <br />
 */
public interface ViewHihokensyaUiBeanParam extends CommonViewUiBeanParam {

    public String getHhknnmkn();

    public void setHhknnmkn(String pHhknnmkn);

    public String getHhknnmkj();

    public void setHhknnmkj(String pHhknnmkj);

    public BizDate getHhknseiymd();

    public void setHhknseiymd(BizDate pHhknseiymd);

    public String getMskmjskjhknnen();

    public void setMskmjskjhknnen(String pMskmjskjhknnen);

    public C_Hhknsei getHhknsei();

    public void setHhknsei(C_Hhknsei pHhknsei);
}
