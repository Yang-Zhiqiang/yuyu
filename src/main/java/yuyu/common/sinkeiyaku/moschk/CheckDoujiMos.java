package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 同時申込チェック
 */
public class CheckDoujiMos {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckDoujiMos() {
        super();
    }

    public void exec(MosnaiCheckParam pMp, List<String> pSkDoujiMosMosNoLstRAY, List<String> pSkDoujiMosMosNoLstPAL) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 申込内容チェック(同時申込チェック) 開始");
        }

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();

        if (pSkDoujiMosMosNoLstRAY != null && pSkDoujiMosMosNoLstRAY.size() != 0) {
            syoriCtl.setDoujimosumu(C_UmuKbn.ARI);
            syoriCtl.setRaydoujimosumu(C_UmuKbn.ARI);

            setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                    MessageId.WHC1003 + " " + MessageUtil.getMessage(MessageId.WHC1003, strlistConnectOfComma(pSkDoujiMosMosNoLstRAY)),
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.WARNING);
        }
        else {
            syoriCtl.setRaydoujimosumu(C_UmuKbn.NONE);
        }

        if (pSkDoujiMosMosNoLstPAL != null && pSkDoujiMosMosNoLstPAL.size() != 0) {
            syoriCtl.setDoujimosumu(C_UmuKbn.ARI);
            syoriCtl.setPaldoujimosumu(C_UmuKbn.ARI);

            setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                    MessageId.WHC1002 + " " + MessageUtil.getMessage(MessageId.WHC1002, strlistConnectOfComma(pSkDoujiMosMosNoLstPAL)),
                    pMp,
                    C_TknKbn.NONE,
                    C_MsgKbn.WARNING);
        }
        else {
            syoriCtl.setPaldoujimosumu(C_UmuKbn.NONE);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 申込内容チェック(同時申込チェック) 終了");
        }
    }

    private String strlistConnectOfComma(List<String> pInStringLst) {
        String outString = "";
        boolean commaFlg = false;
        int mosnoCounter = 0;

        for (String inStr : pInStringLst) {
            if (!commaFlg) {
                outString = inStr;
                commaFlg = true;
            }
            else {
                outString = outString + "、" + inStr;
            }

            mosnoCounter = mosnoCounter + 1;
            if (mosnoCounter >= 10){
                break;
            }
        }

        return outString;
    }
}