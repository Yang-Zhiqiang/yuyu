package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_ImusateiRireki;
import yuyu.def.sinkeiyaku.sorter.SortHT_KnksateiRireki;

/**
 * 新契約 申込内容チェック 査定・決定実施ルール判定
 */
public class SateiKetteiJissiRuleHantei {

    @Inject
    private static Logger logger;

    @Inject
    private HandSateiKetteiHantei handSateiKetteiHantei;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SateiKetteiJissiRuleHantei() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        HT_SyoriCTL syoriCtl = pMP.getDataSyoriControl();
        String monNo = syoriCtl.getMosno();

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 査定・決定実施ルール判定 開始");
            logger.debug("｜ MP処理コントロールTBL・申込点検（１次）要否区分 = " + syoriCtl.getMostenken1jiyhkbn());
            logger.debug("｜ MP処理コントロールTBL・申込点検（２次）要否区分 = " + syoriCtl.getMostenken2jiyhkbn());
            logger.debug("｜ MP処理コントロールTBL・申込点検履歴有無 = " + syoriCtl.getMostenkenrrkumu());
            logger.debug("｜ MP処理コントロールTBL・申込点検状態区分 = " + syoriCtl.getMostenkenjoukbn());
            logger.debug("｜ MP処理コントロールTBL・環境査定（１次）要否区分 = " + syoriCtl.getKnkysatei1jiyhkbn());
            logger.debug("｜ MP処理コントロールTBL・環境査定（２次）要否区分 = " + syoriCtl.getKnkysatei2jiyhkbn());
            logger.debug("｜ MP処理コントロールTBL・環境査定履歴有無 = "         + syoriCtl.getKnkysateirrkumu());
            logger.debug("｜ MP処理コントロールTBL・環境査定状態区分 = "         + syoriCtl.getKnkysateijyoukbn());
            logger.debug("｜ MP処理コントロールTBL・医務査定（簡易）要否区分 = " + syoriCtl.getImusateikaniyhkbn());
            logger.debug("｜ MP処理コントロールTBL・医務査定履歴有無 = "         + syoriCtl.getImusateirrkumu());
            logger.debug("｜ MP処理コントロールTBL・医務査定状態区分 = "         + syoriCtl.getImusateijyoukbn());
            logger.debug("｜ MP処理コントロールTBL・決定状態区分 = "             + syoriCtl.getKetteikbn());
        }

        handSateiKetteiHantei.exec(pMP);

        C_MostenkenyhKbn  mosTenken1jiyhKbn = handSateiKetteiHantei.getMostenken1yhKbn();
        C_MostenkenyhKbn  mosTenken2jiyhKbn = handSateiKetteiHantei.getMostenken2yhKbn();
        C_Knkysatei1jiyhKbn knkySatei1jiyhKbn = handSateiKetteiHantei.getKnkysatei1jiyhKbn();
        C_Knkysatei2jiyhKbn knkySatei2jiyhKbn = handSateiKetteiHantei.getKnkySatei2jiYhKbn();
        C_ImusateikaniyhKbn  imuSateikaniyhKbn = handSateiKetteiHantei.getImuSateiKaniYhKbn();

        C_MostenkenjyouKbn mostenkenjyouKbn = syoriCtl.getMostenkenjoukbn();
        C_UmuKbn mostenkenrrkUmu = syoriCtl.getMostenkenrrkumu();
        C_KnkysateijyouKbn knkSateiJyouKbn = syoriCtl.getKnkysateijyoukbn();
        C_UmuKbn knkSateiRrkUmu = syoriCtl.getKnkysateirrkumu();
        C_ImusateijyouKbn imuSateiJyouKbn = syoriCtl.getImusateijyoukbn();
        C_UmuKbn imuSateiRrkUmu = syoriCtl.getImusateirrkumu();
        C_SateikanKbn sateiKanryouKbn = pMP.getSateiKanryouKbn();
        C_SeirituKbn seirituKbn = syoriCtl.getSeiritukbn();
        C_KetteiKbn ketteiKbn = syoriCtl.getKetteikbn();
        C_SyorikekkaKbn knkSateiKekkaKbn = C_SyorikekkaKbn.BLNK;

        if (C_SateikanKbn.TNK.eq(sateiKanryouKbn)) {

            if(C_MostenkenyhKbn.HUYOU.eq(mosTenken2jiyhKbn)) {

                mostenkenjyouKbn = C_MostenkenjyouKbn.MOSTENKEN_ZUMI;
            }
            else if (C_MostenkenyhKbn.YOU.eq(mosTenken2jiyhKbn)) {

                if (C_MostenkenjyouKbn.TENKENMATI_1.eq(mostenkenjyouKbn)) {
                    mostenkenjyouKbn = C_MostenkenjyouKbn.TENKENMATI_2;
                }
                else {
                    mostenkenjyouKbn = C_MostenkenjyouKbn.MOSTENKEN_ZUMI;
                }
            }
        }
        else if (C_SateikanKbn.KNK.eq(sateiKanryouKbn)) {

            if (C_Knkysatei2jiyhKbn.HUYOU.eq(knkySatei2jiyhKbn)) {

                if (C_KnkysateijyouKbn.SATEIMATI_1.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIZUMI;
                }
                else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIZUMI;
                }
                else if (C_KnkysateijyouKbn.SATEIMATI_2B.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIZUMI;
                }
            }
            else if (C_Knkysatei2jiyhKbn.YOU_A.eq(knkySatei2jiyhKbn)) {

                if (C_KnkysateijyouKbn.SATEIMATI_1.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2A;
                }
                else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIZUMI;
                }
                else if (C_KnkysateijyouKbn.SATEIMATI_2B.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIZUMI;
                }
            }
            else if (C_Knkysatei2jiyhKbn.YOU_B.eq(knkySatei2jiyhKbn)) {

                if (C_KnkysateijyouKbn.SATEIMATI_1.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2B;
                }
                else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2B;
                }
                else if (C_KnkysateijyouKbn.SATEIMATI_2B.eq(knkSateiJyouKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIZUMI;
                }
            }
        }
        else if (C_SateikanKbn.IMU.eq(sateiKanryouKbn)) {

            if (C_ImusateikaniyhKbn.YOU_KANI_MD.eq(imuSateikaniyhKbn)) {
                if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(imuSateiJyouKbn)) {

                    imuSateiJyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_MD;

                }
                else if (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(imuSateiJyouKbn)) {

                    imuSateiJyouKbn = C_ImusateijyouKbn.SATEIZUMI;

                }
            }
            else {

                imuSateiJyouKbn = C_ImusateijyouKbn.SATEIZUMI;
            }
        }

        if (C_UmuKbn.NONE.eq(mostenkenrrkUmu) && C_UmuKbn.NONE.eq(knkSateiRrkUmu) && C_UmuKbn.NONE.eq(imuSateiRrkUmu)) {
            if (C_KetteiKbn.NONE.eq(ketteiKbn) || C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)) {
                if (C_MostenkenyhKbn.HUYOU.eq(mosTenken1jiyhKbn)) {
                    if (C_MostenkenyhKbn.HUYOU.eq(mosTenken2jiyhKbn)) {
                        mostenkenjyouKbn = C_MostenkenjyouKbn.NONE;
                    }
                    else if (C_MostenkenyhKbn.YOU.eq(mosTenken2jiyhKbn)) {
                        mostenkenjyouKbn = C_MostenkenjyouKbn.TENKENMATI_2;
                    }
                }
                else if (C_MostenkenyhKbn.YOU.eq(mosTenken1jiyhKbn)) {
                    mostenkenjyouKbn = C_MostenkenjyouKbn.TENKENMATI_1;
                }
            }
        }

        if (C_UmuKbn.NONE.eq(knkSateiRrkUmu)) {

            if (C_KetteiKbn.NONE.eq(ketteiKbn) ||
                C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)) {

                if (C_Knkysatei1jiyhKbn.HUYOU.eq(knkySatei1jiyhKbn)) {

                    if (C_Knkysatei2jiyhKbn.HUYOU.eq(knkySatei2jiyhKbn)) {

                        knkSateiJyouKbn = C_KnkysateijyouKbn.NONE;

                    } else if (C_Knkysatei2jiyhKbn.YOU_A.eq(knkySatei2jiyhKbn)) {

                        knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2A;

                    } else if (C_Knkysatei2jiyhKbn.YOU_B.eq(knkySatei2jiyhKbn)) {

                        knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2B;

                    }
                }
                else if (C_Knkysatei1jiyhKbn.YOU.eq(knkySatei1jiyhKbn)) {

                    knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_1;

                }
            }
        }
        if (C_UmuKbn.NONE.eq(imuSateiRrkUmu)) {

            if (C_KetteiKbn.NONE.eq(ketteiKbn) ||
                C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)) {

                if (C_ImusateikaniyhKbn.HUYOU.eq(imuSateikaniyhKbn)) {

                    imuSateiJyouKbn = C_ImusateijyouKbn.NONE;

                }
                else if (C_ImusateikaniyhKbn.YOU_KANI_UW.eq(imuSateikaniyhKbn)) {

                    imuSateiJyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_UW;

                }
                else if (C_ImusateikaniyhKbn.YOU_KANI_MD.eq(imuSateikaniyhKbn)) {

                    imuSateiJyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_MD;
                }
            }
        }

        if (C_UmuKbn.ARI.eq(syoriCtl.getKthhbkbn()) &&
            (C_MostenkenjyouKbn.NONE.eq(mostenkenjyouKbn) ||
                C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(mostenkenjyouKbn))) {

            mostenkenjyouKbn = C_MostenkenjyouKbn.TENKENMATI_HUBI;

            syoriCtl.setMostenkenrrkumu(C_UmuKbn.ARI);
            syoriCtl.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_HUBI);

            HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(monNo);
            Integer mostenkenRrkRenno = 0;

            if (mostenkenRireki != null) {
                mostenkenRrkRenno = mostenkenRireki.getRenno();
            }

            mostenkenRireki = syoriCtl.createMostenkenRireki();

            mostenkenRireki.setRenno(mostenkenRrkRenno + 1);
            mostenkenRireki.setSyoriYmd(pMP.getSysDate());
            mostenkenRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.RULEHANTEI);
            mostenkenRireki.setMostenkenkekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_HUBI);
            mostenkenRireki.setMostenkencomment(
                EditSecurityKm.getEncodeData(monNo, MessageUtil.getMessage(MessageId.IHC1040)));
            mostenkenRireki.setGyoumuKousinsyaId(pMP.getKosID());
            mostenkenRireki.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(mostenkenRireki);
        }
        else if (C_UmuKbn.NONE.eq(syoriCtl.getKthhbkbn()) &&
            C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(mostenkenjyouKbn)) {

            if (C_UmuKbn.NONE.eq(mostenkenrrkUmu)) {

                mostenkenjyouKbn = C_MostenkenjyouKbn.NONE;
            }
            else {

                HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(monNo);

                if (C_SateiketsyorinmKbn.RULEHANTEI.eq(mostenkenRireki.getSateiketsyorinmkbn())) {

                    mostenkenjyouKbn = C_MostenkenjyouKbn.MOSTENKEN_ZUMI;
                }
            }
        }

        if (C_KnkysateijyouKbn.SATEIZUMI.eq(knkSateiJyouKbn)) {

            List<HT_KnksateiRireki> knksateiRirekiLst = syoriCtl.getKnksateiRirekis();

            if (knksateiRirekiLst == null || knksateiRirekiLst.size() == 0){
                throw new CommonBizAppException("申込番号＝" + monNo);
            }
            SortHT_KnksateiRireki sortHT_KnksateiRireki = SWAKInjector.getInstance(SortHT_KnksateiRireki.class);
            knksateiRirekiLst = sortHT_KnksateiRireki.OrderHT_KnksateiRirekiByPkDesc(knksateiRirekiLst);

            HT_KnksateiRireki knksateiRireki = knksateiRirekiLst.get(0);
            C_SateiketsyorinmKbn sateiketSyorinmKbn = knksateiRireki.getSateiketsyorinmkbn();

            if (C_SeirituKbn.NONE.eq(seirituKbn)) {

                if (C_KetteiKbn.NONE.eq(ketteiKbn) || C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)) {

                    if (C_Knkysatei2jiyhKbn.YOU_A.eq(knkySatei2jiyhKbn)) {

                        if (C_SateiketsyorinmKbn.KNKSATEI_1.eq(sateiketSyorinmKbn)) {

                            knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2A;
                            knkSateiKekkaKbn = C_SyorikekkaKbn.TENSOU_KANKYOU_2A;

                            addSTKnksateirrk(pMP, knksateiRireki, monNo, knkSateiKekkaKbn);
                        }
                    }
                    else if (C_Knkysatei2jiyhKbn.YOU_B.eq(knkySatei2jiyhKbn)) {

                        if (C_SateiketsyorinmKbn.KNKSATEI_1.eq(sateiketSyorinmKbn)) {

                            knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2B;
                            knkSateiKekkaKbn = C_SyorikekkaKbn.TENSOU_KANKYOU_2B;

                            addSTKnksateirrk(pMP, knksateiRireki, monNo, knkSateiKekkaKbn);
                        }
                        else if (C_SateiketsyorinmKbn.KNKSATEI_2A.eq(sateiketSyorinmKbn)) {

                            knkSateiJyouKbn = C_KnkysateijyouKbn.SATEIMATI_2B;
                            knkSateiKekkaKbn = C_SyorikekkaKbn.TENSOU_KANKYOU_2B;

                            addSTKnksateirrk(pMP, knksateiRireki, monNo, knkSateiKekkaKbn);
                        }
                    }
                }
            }
        }

        if (C_ImusateijyouKbn.SATEIZUMI.eq(imuSateiJyouKbn)) {

            List<HT_ImusateiRireki> imuSateiRireKiLst = syoriCtl.getImusateiRirekis();

            if (imuSateiRireKiLst == null || imuSateiRireKiLst.size() == 0){
                throw new CommonBizAppException("申込番号＝" + monNo);
            }
            SortHT_ImusateiRireki sortHT_ImusateiRireki = SWAKInjector.getInstance(SortHT_ImusateiRireki.class);
            imuSateiRireKiLst = sortHT_ImusateiRireki.OrderHT_ImusateiRirekiByPkDesc(imuSateiRireKiLst);
            HT_ImusateiRireki imuSateiRireKi = imuSateiRireKiLst.get(0);
            C_SateiketsyorinmKbn sateiketSyorinmkbn = imuSateiRireKi.getSateiketsyorinmkbn();

            if (C_SeirituKbn.NONE.eq(seirituKbn)) {

                if (C_KetteiKbn.NONE.eq(ketteiKbn) || C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)) {

                    if (C_ImusateikaniyhKbn.YOU_KANI_MD.eq(imuSateikaniyhKbn)) {

                        if (C_SateiketsyorinmKbn.IMUSATEI_KANI_UW.eq(sateiketSyorinmkbn)) {

                            imuSateiJyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_MD;

                            addSTImusateirrk(pMP, imuSateiRireKi, monNo);
                        }
                    }
                }
            }
        }

        syoriCtl.setMostenken1jiyhkbn(mosTenken1jiyhKbn);
        syoriCtl.setMostenken2jiyhkbn(mosTenken2jiyhKbn);
        syoriCtl.setKnkysatei1jiyhkbn(knkySatei1jiyhKbn);
        syoriCtl.setKnkysatei2jiyhkbn(knkySatei2jiyhKbn);
        syoriCtl.setImusateikaniyhkbn(imuSateikaniyhKbn);
        syoriCtl.setMostenkenjoukbn(mostenkenjyouKbn);
        syoriCtl.setKnkysateijyoukbn(knkSateiJyouKbn);
        syoriCtl.setImusateijyoukbn(imuSateiJyouKbn);

        List<String> knkySateiMsgIdList = null;
        List<String> imuSateiMsgIdList = null;
        List<String> mosTenkenMsgIdLst = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        int msgIdListSize = mosTenkenMsgIdLst.size();
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = new ArrayList<>();
        int renNo = 1;

        for (int i = 0; i < msgIdListSize; i++) {
            HT_RuleHanteiMsg ruleHanteiMsg =  new HT_RuleHanteiMsg();
            ruleHanteiMsg.setMosno(monNo);
            ruleHanteiMsg.setRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
            ruleHanteiMsg.setRenno(renNo);
            ruleHanteiMsg.setRulehanteimsgid(mosTenkenMsgIdLst.get(i));
            ruleHanteiMsg.setGyoumuKousinsyaId(pMP.getKosID());
            ruleHanteiMsg.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(ruleHanteiMsg);
            ruleHanteiMsgLst.add(ruleHanteiMsg);
            renNo++;
        }


        knkySateiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        msgIdListSize = knkySateiMsgIdList.size();

        renNo =1;

        for (int i = 0; i < msgIdListSize; i++) {
            HT_RuleHanteiMsg ruleHanteiMsg =  new HT_RuleHanteiMsg();
            ruleHanteiMsg.setMosno(monNo);
            ruleHanteiMsg.setRulehanteimsg(C_Rulehanteimsg.KNKSATEI);
            ruleHanteiMsg.setRenno(renNo);
            ruleHanteiMsg.setRulehanteimsgid(knkySateiMsgIdList.get(i));
            ruleHanteiMsg.setGyoumuKousinsyaId(pMP.getKosID());
            ruleHanteiMsg.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(ruleHanteiMsg);
            ruleHanteiMsgLst.add(ruleHanteiMsg);
            renNo++;
        }


        renNo =1;
        imuSateiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();
        msgIdListSize = imuSateiMsgIdList.size();
        for (int i = 0; i < msgIdListSize; i++) {
            HT_RuleHanteiMsg ruleHanteiMsg =  new HT_RuleHanteiMsg();
            ruleHanteiMsg.setMosno(monNo);
            ruleHanteiMsg.setRulehanteimsg(C_Rulehanteimsg.IMUSATEI);
            ruleHanteiMsg.setRenno(renNo);
            ruleHanteiMsg.setRulehanteimsgid(imuSateiMsgIdList.get(i));
            ruleHanteiMsg.setGyoumuKousinsyaId(pMP.getKosID());
            ruleHanteiMsg.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(ruleHanteiMsg);
            ruleHanteiMsgLst.add(ruleHanteiMsg);
            renNo++;
        }

        if (ruleHanteiMsgLst != null && ruleHanteiMsgLst.size() != 0) {
            List<HT_RuleHanteiMsg> ruleHanteiMsgTblLst = syoriCtl.getRuleHanteiMsgs();
            BizEntityUtil.exchange (ruleHanteiMsgTblLst, ruleHanteiMsgLst);
        }
        else {
            List<HT_RuleHanteiMsg> ruleHanteiMsgTblLst = syoriCtl.getRuleHanteiMsgs();
            if (ruleHanteiMsgTblLst != null && ruleHanteiMsgTblLst.size() > 0) {
                ruleHanteiMsgTblLst.clear();
            }
        }
        if(logger.isDebugEnabled()) {
            logger.debug("△ 査定・決定実施ルール判定 終了");
        }
    }

    private void addSTKnksateirrk(
        MosnaiCheckParam pMp,
        HT_KnksateiRireki pKnksateiRireki,
        String pMosNo,
        C_SyorikekkaKbn pSyorikekkaKbn) {

        int renNo = pKnksateiRireki.getRenno()  + 1;
        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();

        HT_KnksateiRireki knksateiRireki = syoriCTL.createKnksateiRireki();
        knksateiRireki.setRenno(renNo);
        knksateiRireki.setSyoriYmd(pMp.getSysDate());
        knksateiRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.RULEHANTEI);
        knksateiRireki.setKnksateikekkakbn(pSyorikekkaKbn);
        knksateiRireki.setGyoumuKousinsyaId(pMp.getKosID());
        knksateiRireki.setGyoumuKousinTime(pMp.getKosTime());

        BizPropertyInitializer.initialize(knksateiRireki);

    }

    private void addSTImusateirrk(
        MosnaiCheckParam pMp,
        HT_ImusateiRireki pImusateiRireki,
        String pMosNo) {

        int renNo = pImusateiRireki.getRenno() + 1;
        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();

        HT_ImusateiRireki imuSateiRireKi = syoriCTL.createImusateiRireki();
        imuSateiRireKi.setRenno(renNo);
        imuSateiRireKi.setSyoriYmd(pMp.getSysDate());
        imuSateiRireKi.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.RULEHANTEI);
        imuSateiRireKi.setImusateikekkakbn(C_SyorikekkaKbn.TENSOU_IMU_KANIMD);
        imuSateiRireKi.setGyoumuKousinsyaId(pMp.getKosID());
        imuSateiRireKi.setGyoumuKousinTime(pMp.getKosTime());

        BizPropertyInitializer.initialize(imuSateiRireKi);
    }
}