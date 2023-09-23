package yuyu.common.hozen.setuibean;

import java.util.List;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;

/**
 * 契約保全 UiBean設定 死亡保険金受取人情報設定
 */
public class SetSbHkukt {

    private static final String BLANK = "";

    public static boolean exec(KhozenCommonParam pKhCParm, SetSbHkuktExecUiBeanParam pUiBean) {
        String syoNo = pUiBean.getSyono();

        IT_KykKihon kykKihon = pKhCParm.getKeiyakuKihon(syoNo);
        Integer sbuktnin =kykKihon.getSbuktnin();

        List<IT_KykUkt> kykUktLst = pKhCParm.getSibouUketorinin(syoNo);

        if (sbuktnin == 0) {
             init(pUiBean);
        }else{
            init(pUiBean);

            BM_SyouhnZokusei syouhnZokusei =pKhCParm.getKeiyakuSyouhin(syoNo,C_SyutkKbn.SYU).get(0).getSyouhnZokusei();

            pUiBean.setVshktsbhkuktumu(syouhnZokusei.getSbhkuktumu());
            pUiBean.setVshktsbkyuuhukinuktumu(syouhnZokusei.getSbkyuuhukinuktumu());
            if(kykUktLst != null){
                    for (int count = 0; count < kykUktLst.size(); count++) {
                        if (count == 0) {
                            pUiBean.setVshktsbuktsyurenno1(kykUktLst.get(count).getUktsyurenno());
                            pUiBean.setVshktdispsbuktkbn1(kykUktLst.get(count).getUktkbn());
                            pUiBean.setVshktdispsbuktnmkn1(kykUktLst.get(count).getUktnmkn());
                            pUiBean.setVshktdispsbuktnmkj1(kykUktLst.get(count).getUktnmkj());
                            pUiBean.setVshktdispsbuktnmkjhukakbn1(kykUktLst.get(count).getUktnmkjkhukakbn());
                            pUiBean.setVshktdispsbuktseiymd1(kykUktLst.get(count).getUktseiymd());
                            pUiBean.setVshktdispsbuktbnwari1(kykUktLst.get(count).getUktbnwari());
                        }
                        if (count == 1) {
                            pUiBean.setVshktsbuktsyurenno2(kykUktLst.get(count).getUktsyurenno());
                            pUiBean.setVshktdispsbuktkbn2(kykUktLst.get(count).getUktkbn());
                            pUiBean.setVshktdispsbuktnmkn2(kykUktLst.get(count).getUktnmkn());
                            pUiBean.setVshktdispsbuktnmkj2(kykUktLst.get(count).getUktnmkj());
                            pUiBean.setVshktdispsbuktnmkjhukakbn2(kykUktLst.get(count).getUktnmkjkhukakbn());
                            pUiBean.setVshktdispsbuktseiymd2(kykUktLst.get(count).getUktseiymd());
                            pUiBean.setVshktdispsbuktbnwari2(kykUktLst.get(count).getUktbnwari());
                        }
                        if (count == 2) {
                            pUiBean.setVshktsbuktsyurenno3(kykUktLst.get(count).getUktsyurenno());
                            pUiBean.setVshktdispsbuktkbn3(kykUktLst.get(count).getUktkbn());
                            pUiBean.setVshktdispsbuktnmkn3(kykUktLst.get(count).getUktnmkn());
                            pUiBean.setVshktdispsbuktnmkj3(kykUktLst.get(count).getUktnmkj());
                            pUiBean.setVshktdispsbuktnmkjhukakbn3(kykUktLst.get(count).getUktnmkjkhukakbn());
                            pUiBean.setVshktdispsbuktseiymd3(kykUktLst.get(count).getUktseiymd());
                            pUiBean.setVshktdispsbuktbnwari3(kykUktLst.get(count).getUktbnwari());
                        }
                        if (count == 3) {
                            pUiBean.setVshktsbuktsyurenno4(kykUktLst.get(count).getUktsyurenno());
                            pUiBean.setVshktdispsbuktkbn4(kykUktLst.get(count).getUktkbn());
                            pUiBean.setVshktdispsbuktnmkn4(kykUktLst.get(count).getUktnmkn());
                            pUiBean.setVshktdispsbuktnmkj4(kykUktLst.get(count).getUktnmkj());
                            pUiBean.setVshktdispsbuktnmkjhukakbn4(kykUktLst.get(count).getUktnmkjkhukakbn());
                            pUiBean.setVshktdispsbuktseiymd4(kykUktLst.get(count).getUktseiymd());
                            pUiBean.setVshktdispsbuktbnwari4(kykUktLst.get(count).getUktbnwari());
                        }
                    }
                }
             }
        pUiBean.setVshktsbuktnin(sbuktnin);

        return true;
    }

    public static void init(SetSbHkuktExecUiBeanParam pUiBean){

        pUiBean.setVshktsbuktnin(0);
        pUiBean.setVshktsbhkuktumu(C_UmuKbn.NONE);
        pUiBean.setVshktsbkyuuhukinuktumu(C_UmuKbn.NONE);
        pUiBean.setVshktsbuktsyurenno1(null);
        pUiBean.setVshktdispsbuktkbn1(C_UktKbn.BLNK);
        pUiBean.setVshktdispsbuktnmkn1(BLANK);
        pUiBean.setVshktdispsbuktnmkj1(BLANK);
        pUiBean.setVshktdispsbuktnmkjhukakbn1(C_KjkhukaKbn.BLNK);
        pUiBean.setVshktdispsbuktseiymd1(null);
        pUiBean.setVshktdispsbuktbnwari1(BizNumber.optional());
        pUiBean.setVshktsbuktsyurenno2(null);
        pUiBean.setVshktdispsbuktkbn2(C_UktKbn.BLNK);
        pUiBean.setVshktdispsbuktnmkn2(BLANK);
        pUiBean.setVshktdispsbuktnmkj2(BLANK);
        pUiBean.setVshktdispsbuktnmkjhukakbn2(C_KjkhukaKbn.BLNK);
        pUiBean.setVshktdispsbuktseiymd2(null);
        pUiBean.setVshktdispsbuktbnwari2(BizNumber.optional());
        pUiBean.setVshktsbuktsyurenno3(null);
        pUiBean.setVshktdispsbuktkbn3(C_UktKbn.BLNK);
        pUiBean.setVshktdispsbuktnmkn3(BLANK);
        pUiBean.setVshktdispsbuktnmkj3(BLANK);
        pUiBean.setVshktdispsbuktnmkjhukakbn3(C_KjkhukaKbn.BLNK);
        pUiBean.setVshktdispsbuktseiymd3(null);
        pUiBean.setVshktdispsbuktbnwari3(BizNumber.optional());
        pUiBean.setVshktsbuktsyurenno4(null);
        pUiBean.setVshktdispsbuktkbn4(C_UktKbn.BLNK);
        pUiBean.setVshktdispsbuktnmkn4(BLANK);
        pUiBean.setVshktdispsbuktnmkj4(BLANK);
        pUiBean.setVshktdispsbuktnmkjhukakbn4(C_KjkhukaKbn.BLNK);
        pUiBean.setVshktdispsbuktseiymd4(null);
        pUiBean.setVshktdispsbuktbnwari4(BizNumber.optional());
    }
}
