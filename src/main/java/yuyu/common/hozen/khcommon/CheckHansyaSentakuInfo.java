package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 反社・選択情報チェッククラス
 */
public class CheckHansyaSentakuInfo {

    @Inject
    private static Logger logger;

    @Inject
    private MessageManager messageManager;

    private List<String> worningMsgIdList;

    private List<String> worningMsgList;

    public CheckHansyaSentakuInfo() {
        super();
    }

    public boolean exec(C_HnsychkTaisyousyaKbn pCHnsychkTaisyousyaKbn, String pTaisyouNmKn, String pTaisyouNmKj,
        C_KjkhukaKbn pCKjkhukaKbn, BizDate pTaisyouSeiYMD, String pZrnTaisyou, C_ErrorKbn pTyotkhknHyjSetKekkbn,
        C_UmuKbn pHouteiTyotkhknHyj, C_UmuKbn pTyotkhknHyj) {

        logger.debug("▽ 反社・選択情報チェック 開始");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean =
            SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);

        worningMsgIdList = new ArrayList<>();

        worningMsgList = new ArrayList<>();

        bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.MEIGISYOUKAI);

        bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setHuho2kykno("");

        bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setTaisyounmkn(pTaisyouNmKn);

        if (C_KjkhukaKbn.KJKHUKA.eq(pCKjkhukaKbn)){
            bzSakuinTsnSyoukaiYokenBean.setTaisyounmkj("");
        }
        else{
            bzSakuinTsnSyoukaiYokenBean.setTaisyounmkj(pTaisyouNmKj);
        }

        bzSakuinTsnSyoukaiYokenBean.setTaisyouseiymd(pTaisyouSeiYMD);

        bzSakuinTsnSyoukaiYokenBean.setTaisyouyno(pZrnTaisyou);

        bzSakuinTsnSyoukaiYokenBean.setHhknyno("");

        bzSakuinTsnSyoukaiYokenBean.setHhknsykgycd("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkn1("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkj1("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkn2("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkj2("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkn3("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkj3("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkn4("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkj4("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkn5("");

        bzSakuinTsnSyoukaiYokenBean.setKankeinmkj5("");

        bzSakuinTsnSyoukaiYokenBean.setKanrisosikicd1("");

        bzSakuinTsnSyoukaiYokenBean.setKanrisosikicd2("");

        bzSakuinTsnSyoukaiYokenBean.setTsintelno("");

        bzSakuinTsnSyoukaiYokenBean.setHrkkeiro(C_Hrkkeiro.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setBankcd("");

        bzSakuinTsnSyoukaiYokenBean.setShitencd("");

        bzSakuinTsnSyoukaiYokenBean.setYokinkbn(C_YokinKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setKouzano("");

        bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno("");

        bzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(null);

        bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);

        bzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.OTHER);

        bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno("");

        bzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(null);

        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnkijyunymd(null);

        bzSakuinTsnSyoukaiYokenBean.setDairitencd1("");

        bzSakuinTsnSyoukaiYokenBean.setDairitencd2("");

        bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        BzSakuinTsnSyoukaiMq sakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = sakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        boolean worningFlg = true;

        if (C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())) {

            worningMsgIdList.add(MessageId.WIA1007);

            worningMsgList.add(MessageUtil.getMessage(MessageId.WIA1007));

            worningFlg = false;

            logger.debug("△ 反社・選択情報チェック 終了");

            return worningFlg;
        }
        else if (C_MQSyorikekkaKbn.SEIJYOU.eq(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())) {

            if (C_PalSyoukaiJissiumuKbn.NONE.eq(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())) {

                worningMsgIdList.add(MessageId.WIA1008);

                worningMsgList.add(MessageUtil.getMessage(MessageId.WIA1008));

                worningFlg = false;

                logger.debug("△ 反社・選択情報チェック 終了");

                return worningFlg;
            }
        }

        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getSignalsyoukaierrkbn())) {

            worningMsgIdList.add(MessageId.WIA1009);

            worningMsgList.add(MessageUtil.getMessage(MessageId.WIA1009));
        }
        else {
            if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn())) {
                worningMsgIdList.add(MessageId.WBA0014);

                worningMsgList.add(MessageUtil.getMessage(MessageId.WBA0014,
                    C_HnsychkTaisyousyaKbn.getContentByValue(pCHnsychkTaisyousyaKbn.getValue()), pTaisyouNmKn));
            }

            if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn())) {

                if (C_ErrorKbn.OK.eq(pTyotkhknHyjSetKekkbn)) {

                    if (C_UmuKbn.ARI.eq(pHouteiTyotkhknHyj) || C_UmuKbn.ARI.eq(pTyotkhknHyj)) {

                        worningMsgIdList.add(MessageId.WIA1020);

                        worningMsgList.add(MessageUtil.getMessage(MessageId.WIA1020,
                            C_HnsychkTaisyousyaKbn.getContentByValue(pCHnsychkTaisyousyaKbn.getValue()), pTaisyouNmKn,
                            DateFormatUtil.dateKANJIWareki(pTaisyouSeiYMD)));
                    }
                }
                else {

                    worningMsgIdList.add(MessageId.WIA1029);

                    worningMsgList.add(MessageUtil.getMessage(MessageId.WIA1029));
                }
            }
        }

        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn())) {

            worningMsgIdList.add(MessageId.WIA1009);

            worningMsgList.add(MessageUtil.getMessage(MessageId.WIA1009));
        }
        else if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn())) {

            worningMsgIdList.add(MessageId.WBA1005);

            worningMsgList.add(MessageUtil.getMessage(MessageId.WBA1005,
                C_HnsychkTaisyousyaKbn.getContentByValue(pCHnsychkTaisyousyaKbn.getValue()), pTaisyouNmKj));
        }

        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn())) {

            if (C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU.eq(bzSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn())) {

                worningMsgIdList.add(MessageId.WIA1009);

                worningMsgList.add(MessageUtil.getMessage(MessageId.WIA1009));
            }
            else if (C_NayoseJissiKekkaKbn.NAYOSEHUMEI.eq(bzSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn())) {

                worningMsgIdList.add(MessageId.WBA0015);

                worningMsgList.add(MessageUtil.getMessage(MessageId.WBA0015,
                    C_HnsychkTaisyousyaKbn.getContentByValue(pCHnsychkTaisyousyaKbn.getValue()), pTaisyouNmKn));
            }
        }
        else {
            if (C_NayoseJissiKekkaKbn.DOUITUARI.eq(bzSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn())) {

                if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn())) {

                    worningMsgIdList.add(MessageId.WBA0013);

                    worningMsgList.add(MessageUtil.getMessage(MessageId.WBA0013,
                        C_HnsychkTaisyousyaKbn.getContentByValue(pCHnsychkTaisyousyaKbn.getValue()), pTaisyouNmKn));
                }
            }
        }

        if (worningMsgIdList.size() > 0) {

            worningFlg = false;
        }
        else {

            worningFlg = true;
        }

        logger.debug("△ 反社・選択情報チェック 終了");

        return worningFlg;
    }

    public List<String> getWarningMsgIdList() {
        return this.worningMsgIdList;
    }

    public List<String> getWarningMsgList() {
        return this.worningMsgList;
    }
}
