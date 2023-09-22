package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Uketorinin;

/**
 * 新契約 申込内容チェック 年金受取人区分入力チェック
 */
public class CheckNkUktKbn {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckNkUktKbn() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, List<HT_Uketorinin> pUketorininLst) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 年金受取人区分入力チェック 開始");
        }
        BM_SyouhnZokusei syuSyouhnZokusei = pMP.getSyuSyouhnZokusei();
        C_UmuKbn zeiseiTekikakuUmu = syuSyouhnZokusei.getZeiseitekikakuumu();

        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();

        C_KykKbn kykKbn = mosKihon.getKykkbn();
        C_Tkhukaumu kjnnkpZeitekiTkhukaKbn = mosKihon.getKjnnkpzeitekitkhukakbn();
        C_Tdk kykTdk = mosKihon.getKyktdk();

        if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
            for (HT_Uketorinin uketorinin : pUketorininLst) {

                if (C_UktKbn.HHKN.eq(uketorinin.getUktkbn())) {

                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        MakeHubiMsg.exec(MessageId.EHA1071,
                            MessageId.EHA1071,
                            C_UktKbn.HHKN.getContent(C_UktKbn.PATTERN_NKUKT)),
                            pMP);

                    break;
                }
            }
        }

        if(C_SysKbn.SKEI.eq(pMP.getSysKbn())){
            if (!C_Tkhukaumu.BLNK.eq(kjnnkpZeitekiTkhukaKbn)) {
                if (C_UmuKbn.ARI.eq(zeiseiTekikakuUmu)) {
                    for (HT_Uketorinin uketorinin : pUketorininLst) {

                        if (C_UktKbn.HHKN.eq(uketorinin.getUktkbn())) {

                            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                                if (!C_Tdk.HGU.eq(kykTdk)) {

                                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                                        MakeHubiMsg.exec(MessageId.WHC1020, MessageId.WHC1020),
                                        pMP);

                                    break;
                                }

                                if (C_Tdk.HGU.eq(kykTdk) && C_Tkhukaumu.NONE.eq(kjnnkpZeitekiTkhukaKbn)) {

                                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                                        MakeHubiMsg.exec(MessageId.WHC1020, MessageId.WHC1020),
                                        pMP);

                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("△ 年金受取人区分入力チェック 終了");
        }
    }
}
