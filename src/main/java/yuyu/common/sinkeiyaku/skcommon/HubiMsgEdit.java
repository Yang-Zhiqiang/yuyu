package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubiSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 不備メッセージ編集
 */
public class HubiMsgEdit {

    private static final String MSG_HOKENRYOU = "保険料";
    private static final String MSG_HARAIKOMIKINGAKU = "払込金額";
    private static final String MSG_KIBOUGAKU = "希望額";
    private static final String MSG_ENKAHARAIKOMIGAKU = "円貨払込額";
    private static final String MSG_ZENNOUHOKENRYOU = "前納保険料";
    private static final String MSG_HOKENKNGK = "保険金額";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public HubiMsgEdit() {
        super();
    }

    public ArrayList<String> getHubiMsgSourceData_1MousikomiNo(String pMousikomiNo) {

        return getHubiMsgSourceData_1MousikomiNo(pMousikomiNo, C_HubiSyoriKbn.SYORI);
    }

    public ArrayList<String> getHubiMsgSourceData_1MousikomiNo(String pMousikomiNo, C_HubiSyoriKbn pHubiSyoriKbn) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMousikomiNo);
        List<List<HT_HubiMsg>> hubiMsglst = new ArrayList<>();
        ArrayList<String> hubiLst = new ArrayList<>();

        hubiMsglst.add(syoriCTL.getHubiMsgsByMessageId("E"));
        hubiMsglst.add(syoriCTL.getHubiMsgsByMessageId("T"));
        hubiMsglst.add(syoriCTL.getHubiMsgsByMessageId("W"));
        hubiMsglst.add(syoriCTL.getHubiMsgsByMessageId("K"));

        String hubiSyubetuKbn;
        String hubiMsgId;
        String hubiMessage;

        for (List<HT_HubiMsg> hubiMsgLst : hubiMsglst) {

            if (hubiMsgLst != null && hubiMsgLst.size() > 0) {

                for (HT_HubiMsg hubiMsg : hubiMsgLst) {

                    hubiSyubetuKbn = "";
                    hubiMsgId      = "";
                    hubiMessage    = "";

                    if (hubiMsg.getHubisyubetukbn() != null) {
                        hubiSyubetuKbn = hubiMsg.getHubisyubetukbn().toString();
                    }

                    if (hubiMsg.getMessageId() != null) {
                        hubiMsgId = hubiMsg.getMessageId();
                    }

                    if (hubiMsg.getHubimsg() != null) {
                        hubiMessage = hubiMsg.getHubimsg();
                    }

                    hubiLst.add(hubiSyubetuKbn + " " + hubiMsgId + " " + hubiMessage);
                }
            }
        }

        return hubiLst;
    }

    public String editSeihoWebMsg_Hokenryou(
        MosnaiCheckParam pMosnaiCheckParam, HT_MosKihon pMosKihon, BM_SyouhnZokusei pSyouhnZokusei) {

        String editMoji = MSG_HOKENRYOU;

        int syouhinHanteiKekka = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());

        if (!C_Tuukasyu.JPY.eq(pMosKihon.getKyktuukasyu())) {

            if (C_Hrkkaisuu.ITIJI.eq(pMosKihon.getHrkkaisuu())) {

                editMoji = MSG_HARAIKOMIKINGAKU;
            }
            else {

                if (syouhinHanteiKekka == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                    if (C_UmuKbn.ARI.eq(pMosnaiCheckParam.getSekmossakuseiHrksknnyrykUmuKbn())) {

                        editMoji = MSG_KIBOUGAKU;

                        return editMoji;
                    }

                    editMoji = MSG_ENKAHARAIKOMIGAKU;

                    return editMoji;
                }
            }
        }
        else {

            if (!C_Hrkkaisuu.ITIJI.eq(pMosKihon.getHrkkaisuu())) {
                if (C_UmuKbn.ARI.eq(pMosnaiCheckParam.getSekmossakuseiHrksknnyrykUmuKbn())) {

                    editMoji = MSG_ZENNOUHOKENRYOU;

                    return editMoji;
                }
            }
        }

        return editMoji;
    }

    public String editSeihoWebMsg_Hokenkngk(
        MosnaiCheckParam pMosnaiCheckParam, HT_MosKihon pMosKihon, BM_SyouhnZokusei pSyouhnZokusei) {

        String editMoji = MSG_HOKENKNGK;

        return editMoji;

    }
}