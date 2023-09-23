package yuyu.common.hozen.khview.viewkeizokunkukt;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全 契約保全画面部品 継続年金受取人情報表示 <br />
 */
public interface ViewKeizokuNkuktUiBeanParam extends CommonViewUiBeanParam {

    public String getKeizknkuktnmkn();

    public void setKeizknkuktnmkn(String pKeizknkuktnmkn);

    public String getKeizknkuktnmkj();

    public void setKeizknkuktnmkj(String pKeizknkuktnmkj);

    public BizDate getKeizknenkiuktseiymd();

    public void setKeizknenkiuktseiymd(BizDate pKeizknenkiuktseiymd);

    public C_Tdk getKeizknenkinukttdk();

    public void setKeizknenkinukttdk(C_Tdk pKeizknenkinukttdk);

}
