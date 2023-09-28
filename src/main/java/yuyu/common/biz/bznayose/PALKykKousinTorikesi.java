package yuyu.common.biz.bznayose;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;

/**
 * 業務共通 名寄せ ＰＡＬ契約更新取消処理クラス
 */
public class PALKykKousinTorikesi {

    private static final String PALTORIKESIIRAI_SYORI = "PAL取消依頼処理";

    private static final String TOUJIIDOUNAIYOSAKUJYO = "当日異動内容削除";

    @Inject
    private static Logger logger;

    public PALKykKousinTorikesi() {
        super();
    }

    public void exec(C_Huho2kyknoKbn pHuho2kyknokbn, String pHuho2kykno, String pYoukyuuno) {

        logger.debug("▽ ＰＡＬ契約更新取消処理 開始");

        BzTrksIraiYokenBean bzTrksIraiYokenBean = SWAKInjector.getInstance(BzTrksIraiYokenBean.class);

        bzTrksIraiYokenBean.setYoukyuuno(pYoukyuuno);
        bzTrksIraiYokenBean.setHuho2kyknokbn(pHuho2kyknokbn);
        bzTrksIraiYokenBean.setHuho2kykno(pHuho2kykno);

        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);

        BzTrksIraiKekkaBean bzTrksIraiKekkaBean = bzTrksIraiMq.exec(bzTrksIraiYokenBean);

        if (C_MQSyorikekkaKbn.ERROR.eq(bzTrksIraiKekkaBean.getMqsyorikekkakbn())) {

            throw new BizLogicException(MessageId.EBA1011, PALTORIKESIIRAI_SYORI);
        }

        if (C_TorikesiKekkaKbn.ERR_YOUKYUUNONONE.eq(bzTrksIraiKekkaBean.getTrkskekkakbn())){

            throw new BizLogicException(MessageId.EBA1023);
        }
        else if (C_TorikesiKekkaKbn.ERR_ATOSYORIARI.eq(bzTrksIraiKekkaBean.getTrkskekkakbn())){

            throw new BizLogicException(MessageId.EBA1024);
        }
        else if (C_TorikesiKekkaKbn.ERR_SONOTA.eq(bzTrksIraiKekkaBean.getTrkskekkakbn())){

            throw new BizLogicException(MessageId.EBA1025);
        }
        else if (C_TorikesiKekkaKbn.HUMEI.eq(bzTrksIraiKekkaBean.getTrkskekkakbn())){

            throw new BizLogicException(MessageId.EBA1026);
        }

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean =
            SWAKInjector.getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(pHuho2kyknokbn);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo(pHuho2kykno);
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo(pYoukyuuno);

        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo =
            SWAKInjector.getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new BizLogicException(MessageId.EBA1012, TOUJIIDOUNAIYOSAKUJYO);
        }

        logger.debug("△ ＰＡＬ契約更新取消処理 終了");
    }
}
