package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.HT_MosKihon;

/**
 * 新契約 申込内容チェック 予定契約日チェック
 */
public class CheckYoteiKykYmd {

    @Inject
    private static Logger logger;

    public CheckYoteiKykYmd() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        logger.debug("▽ 予定契約日チェック 開始");

        if (C_YoteikykymdKbn.SITEI.eq(pMp.getYoteiKykymdKbn())) {
            HT_MosKihon mosKhnTbl = pMp.getDataSyoriControl().getMosKihon();
            BizDateYM mosYm = mosKhnTbl.getMosymd().getBizDateYM();
            BizDate kykYmd = mosKhnTbl.getKykymd();
            BizDate fromYmd = mosYm.addMonths(-1).getFirstDay();
            BizDate toYmd = mosYm.addMonths(2).getLastDay();

            if ((kykYmd.compareTo(fromYmd) < 0) || (toYmd.compareTo(kykYmd) < 0)) {
                SetHubiMsg setHubiMsg = SWAKInjector.getInstance(SetHubiMsg.class);
                setHubiMsg.exec(
                    MessageUtil.getMessage(MessageId.EGA1004),
                    MessageUtil.getMessage(MessageId.EGA1005, "１ヶ月前", "２ヶ月後"),
                    C_SekmossakuseiErroutKbn.GAMEN,
                    pMp);
            }
        }

        logger.debug("△ 予定契約日チェック 終了");
    }
}
