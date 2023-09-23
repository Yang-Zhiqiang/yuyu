package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 UiBean設定 死亡保険金受取人情報設定UiBeanパラメータ
 */
public interface SetSbHkuktExecUiBeanParam {

    String getSyono();

    public void setVshktsbuktnin(Integer pVshktsbuktnin);

    public void setVshktsbhkuktumu(C_UmuKbn pVshktsbhkuktumu);

    public void setVshktsbuktsyurenno1(Integer pVshktsbuktsyurenno1);

    public void setVshktsbkyuuhukinuktumu(C_UmuKbn pVshktsbkyuuhukinuktumu);

    public void setVshktdispsbuktkbn1(C_UktKbn pVshktdispsbuktkbn1);

    public void setVshktdispsbuktnmkn1(String pVshktdispsbuktnmkn1);

    public void setVshktdispsbuktnmkj1(String pVshktdispsbuktnmkj1);
    public void setVshktdispsbuktnmkjhukakbn1(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn1);
    public void setVshktdispsbuktseiymd1(BizDate pVshktdispsbuktseiymd1);

    public void setVshktdispsbuktbnwari1(BizNumber pVshktdispsbuktbnwari1);

    public void setVshktsbuktsyurenno2(Integer pVshktsbuktsyurenno2);

    public void setVshktdispsbuktkbn2(C_UktKbn pVshktdispsbuktkbn2);

    public void setVshktdispsbuktnmkn2(String pVshktdispsbuktnmkn2);

    public void setVshktdispsbuktnmkj2(String pVshktdispsbuktnmkj2);

    public void setVshktdispsbuktnmkjhukakbn2(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn2);

    public void setVshktdispsbuktseiymd2(BizDate pVshktdispsbuktseiymd2);

    public void setVshktdispsbuktbnwari2(BizNumber pVshktdispsbuktbnwari2);

    public void setVshktsbuktsyurenno3(Integer pVshktsbuktsyurenno3);

    public void setVshktdispsbuktkbn3(C_UktKbn pVshktdispsbuktkbn3);

    public void setVshktdispsbuktnmkn3(String pVshktdispsbuktnmkn3);

    public void setVshktdispsbuktnmkj3(String pVshktdispsbuktnmkj3);

    public void setVshktdispsbuktnmkjhukakbn3(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn3);

    public void setVshktdispsbuktseiymd3(BizDate pVshktdispsbuktseiymd3);


    public void setVshktdispsbuktbnwari3(BizNumber pVshktdispsbuktbnwari3);

    public void setVshktsbuktsyurenno4(Integer pVshktsbuktsyurenno4);

    public void setVshktdispsbuktkbn4(C_UktKbn pVshktdispsbuktkbn4);

    public void setVshktdispsbuktnmkn4(String pVshktdispsbuktnmkn4);

    public void setVshktdispsbuktnmkj4(String pVshktdispsbuktnmkj4);

    public void setVshktdispsbuktnmkjhukakbn4(C_KjkhukaKbn pVshktdispsbuktnmkjhukakbn4);

    public void setVshktdispsbuktseiymd4(BizDate pVshktdispsbuktseiymd4);

    public void setVshktdispsbuktbnwari4(BizNumber pVshktdispsbuktbnwari4);

}
