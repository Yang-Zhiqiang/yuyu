package yuyu.batch.sinkeiyaku.sksonota.sksentakuinfosks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_DecKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoKykTorikesiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 その他 新契約選択情報作成
 */
public class SkSentakuInfoSksBatch implements Batch {

    private static final String TABLEID = "HT_SyoriCTL";

    private static final String RECOVERYFILTERID = "Sk001";

    private static final String HHKNNEN = "新契約選択情報（被保険者）";

    private static final String KEIYAKUSYA = "新契約選択情報（契約者）";

    private static final String BURANNKU = "";

    private long hhknNenSntkInfoKensuu;

    private long keiyakuSyaSntkInfoKensuu;

    private int renNo;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        hhknNenSntkInfoKensuu = 0;
        keiyakuSyaSntkInfoKensuu = 0;
        renNo = 0;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), String.valueOf(kakutyouJobCd)));

        try (
            EntityInserter<IT_KhSntkInfoTouroku> khSntkInfoTouroku = new EntityInserter<>();

            ExDBResults<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymdSeiritukbns(
                kakutyouJobCd, syoriYmd);) {

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                renNo = 1;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                HT_DakuhiKettei dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(syoriCTL.getMosno());

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();

                SortHT_MosSyouhn sortHT_MosSyouhn = SWAKInjector.getInstance(SortHT_MosSyouhn.class);

                mosSyouhnLst = sortHT_MosSyouhn.OrderHT_MosSyouhnBySyutkkbnAsc(mosSyouhnLst);

                HT_Kokutisyo kokutisyo = syoriCTL.getKokutisyo();

                if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

                    if (!C_Ketkekkacd.MUJYOUKEN.eq(dakuhiKettei.getKetkekkacd()) && C_SntkinfosakuseiyhKbn.SAKUSEIYOU.eq(
                        dakuhiKettei.getSntkinfosakuseiyhkbn())) {

                        hhknInfoDkhKttHensyu(khSntkInfoTouroku, syoriCTL, mosKihon, kokutisyo, mosSyouhnLst.get(0), dakuhiKettei);
                    }
                }

                else if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                    if ((C_Ketkekkacd.ENKI_SIJINASI.eq(dakuhiKettei.getKetkekkacd())
                        || C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(dakuhiKettei.getKetkekkacd()))
                        && C_SntkinfosakuseiyhKbn.SAKUSEIYOU.eq(dakuhiKettei.getSntkinfosakuseiyhkbn())) {

                        hhknInfoDkhKttHensyu(khSntkInfoTouroku, syoriCTL, mosKihon, kokutisyo, mosSyouhnLst.get(0), dakuhiKettei);
                    }

                    else if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())
                        && !C_MrRiyuucdKbn.SAIKENSASIOSAETOU.eq(dakuhiKettei.getMrriyuucdkbn())
                        && C_SntkinfosakuseiyhKbn.SAKUSEIYOU.eq(dakuhiKettei.getSntkinfosakuseiyhkbn())) {

                        if (!C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                            keiyakusyaInfoHensyu(khSntkInfoTouroku, syoriCTL, mosKihon, kokutisyo, mosSyouhnLst.get(0), dakuhiKettei);

                            renNo = renNo + 1;
                        }

                        hhknInfoDkhKttHensyu(khSntkInfoTouroku, syoriCTL, mosKihon, kokutisyo, mosSyouhnLst.get(0), dakuhiKettei);
                    }

                    else if ((C_DakuhiktbunruiKbn.DAKUHIKETTEI.eq(dakuhiKettei.getDakuhiktbunruikbn())
                        && C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())
                        && C_MrRiyuucdKbn.SAIKENSASIOSAETOU.eq(dakuhiKettei.getMrriyuucdkbn()))
                        || (C_DakuhiktbunruiKbn.SYOUMETU.eq(dakuhiKettei.getDakuhiktbunruikbn())
                            && (C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd())
                                || C_Ketkekkacd.COOLINGOFF.eq(dakuhiKettei.getKetkekkacd())
                                || C_Ketkekkacd.YUUKOUKKNKKA.eq(dakuhiKettei.getKetkekkacd())))) {

                        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(
                            syoriCTL.getMosno(), C_SyorikekkaKbn.KANRYOU);

                        if (imusateiRireki != null &&
                            imusateiRireki.getKetkekkacd() != C_Ketkekkacd.MUJYOUKEN &&
                            imusateiRireki.getSntkinfosakuseiyhkbn() == C_SntkinfosakuseiyhKbn.SAKUSEIYOU) {
                            hhknInfoImustRrkHensyu(khSntkInfoTouroku, syoriCTL, imusateiRireki, mosKihon, kokutisyo, mosSyouhnLst.get(0));
                        }
                    }
                }
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(hhknNenSntkInfoKensuu), HHKNNEN));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(keiyakuSyaSntkInfoKensuu), KEIYAKUSYA));
    }

    private void keiyakusyaInfoHensyu(EntityInserter<IT_KhSntkInfoTouroku> pKhSntkInfoTouroku, HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon, HT_Kokutisyo pKokutisyo, HT_MosSyouhn pMosSyouhn, HT_DakuhiKettei pDakuhiKettei) {

        keiyakuSyaSntkInfoKensuu = keiyakuSyaSntkInfoKensuu + 1;

        IT_KhSntkInfoTouroku khSntkInfoTouroku = new IT_KhSntkInfoTouroku();

        khSntkInfoKyutsuHensyu(khSntkInfoTouroku, pSyoriCTL, pMosSyouhn);

        if (C_KjkhukaKbn.BLNK.eq(pMosKihon.getKyknmkjkhukakbn())) {

            khSntkInfoTouroku.setTaisyounmkj(pMosKihon.getKyknmkj());
        }
        else {

            khSntkInfoTouroku.setTaisyounmkj(BURANNKU);
        }

        dakuhiKetteiKyutsuHensyu(khSntkInfoTouroku, pDakuhiKettei, pSyoriCTL);

        khSntkInfoTouroku.setSntkinfokankeisyakbn(C_KankeisyaKbn.KYK);
        khSntkInfoTouroku.setTaisyounmkn(pMosKihon.getKyknmkn());
        khSntkInfoTouroku.setTaisyouseiymd(pMosKihon.getKykseiymd());
        khSntkInfoTouroku.setTaisyouseibetu(C_Seibetu.valueOf(pMosKihon.getKyksei().getValue()));
        khSntkInfoTouroku.setKktnaiyouumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setKijinaiyouumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setSintyou(0);
        khSntkInfoTouroku.setTaijyuu(0);
        khSntkInfoTouroku.setKktymd(null);
        khSntkInfoTouroku.setSyoubyoucd1(BURANNKU);
        khSntkInfoTouroku.setSyoubyoujyoutaikbn1(C_SyoubyoujyoutaiKbn.BLNK);
        khSntkInfoTouroku.setKantiym1(null);
        khSntkInfoTouroku.setSyoubyoucd2(BURANNKU);
        khSntkInfoTouroku.setSyoubyoujyoutaikbn2(C_SyoubyoujyoutaiKbn.BLNK);
        khSntkInfoTouroku.setKantiym2(null);
        BizPropertyInitializer.initialize(khSntkInfoTouroku);
        pKhSntkInfoTouroku.add(khSntkInfoTouroku);
    }

    private void hhknInfoDkhKttHensyu(EntityInserter<IT_KhSntkInfoTouroku> pKhSntkInfoTouroku,
        HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, HT_Kokutisyo pKokutisyo, HT_MosSyouhn pMosSyouhn,
        HT_DakuhiKettei pDakuhiKettei) {

        hhknNenSntkInfoKensuu = hhknNenSntkInfoKensuu + 1;
        IT_KhSntkInfoTouroku khSntkInfoTouroku = new IT_KhSntkInfoTouroku();
        khSntkInfoKyutsuHensyu(khSntkInfoTouroku, pSyoriCTL, pMosSyouhn);
        hhknInfoKyutsuHensyu(khSntkInfoTouroku, pSyoriCTL, pMosKihon, pKokutisyo);
        dakuhiKetteiKyutsuHensyu(khSntkInfoTouroku, pDakuhiKettei, pSyoriCTL);

        if (pDakuhiKettei != null) {

            khSntkInfoTouroku.setSyoubyoucd1(pDakuhiKettei.getSyoubyoucd1());
            khSntkInfoTouroku.setSyoubyoujyoutaikbn1(pDakuhiKettei.getSyoubyoujyoutaikbn1());
            khSntkInfoTouroku.setKantiym1(pDakuhiKettei.getKantiym1());
            khSntkInfoTouroku.setSyoubyoucd2(pDakuhiKettei.getSyoubyoucd2());
            khSntkInfoTouroku.setSyoubyoujyoutaikbn2(pDakuhiKettei.getSyoubyoujyoutaikbn2());
            khSntkInfoTouroku.setKantiym2(pDakuhiKettei.getKantiym2());

            if (StringUtil.isNullOrBlank(pDakuhiKettei.getSyoubyoucd1()) &&
                StringUtil.isNullOrBlank(pDakuhiKettei.getSyoubyoucd2())) {

                khSntkInfoTouroku.setKijinaiyouumukbn(C_BlnktkumuKbn.NONE);
            }
            else {

                khSntkInfoTouroku.setKijinaiyouumukbn(C_BlnktkumuKbn.ARI);
            }

        }
        else {

            khSntkInfoTouroku.setKijinaiyouumukbn(C_BlnktkumuKbn.NONE);
        }
        BizPropertyInitializer.initialize(khSntkInfoTouroku);
        pKhSntkInfoTouroku.add(khSntkInfoTouroku);
    }

    private void hhknInfoImustRrkHensyu(EntityInserter<IT_KhSntkInfoTouroku> pKhSntkInfoTouroku, HT_SyoriCTL pSyoriCTL,
        HT_ImusateiRireki pImusateiRireki, HT_MosKihon pMosKihon, HT_Kokutisyo pKokutisyo, HT_MosSyouhn pMosSyouhn) {

        hhknNenSntkInfoKensuu = hhknNenSntkInfoKensuu + 1;
        IT_KhSntkInfoTouroku khSntkInfoTouroku = new IT_KhSntkInfoTouroku();
        khSntkInfoKyutsuHensyu(khSntkInfoTouroku, pSyoriCTL, pMosSyouhn);
        hhknInfoKyutsuHensyu(khSntkInfoTouroku, pSyoriCTL, pMosKihon, pKokutisyo);

        khSntkInfoTouroku.setDakuhiketnaiyouumukbn(C_BlnktkumuKbn.ARI);
        khSntkInfoTouroku.setMrumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setSeiritukbn(pSyoriCTL.getSeiritukbn());
        khSntkInfoTouroku.setDeckbn(C_DecKbn.SKEI);
        khSntkInfoTouroku.setKetymd(pImusateiRireki.getSyoriYmd());
        khSntkInfoTouroku.setKetkekkacd(pImusateiRireki.getKetkekkacd());
        khSntkInfoTouroku.setKetriyuucd1(pImusateiRireki.getKetriyuucd1());
        khSntkInfoTouroku.setKetriyuucd2(pImusateiRireki.getKetriyuucd2());
        khSntkInfoTouroku.setKetriyuucd3(pImusateiRireki.getKetriyuucd3());
        khSntkInfoTouroku.setKetriyuucd4(pImusateiRireki.getKetriyuucd4());
        khSntkInfoTouroku.setKetsyacd(pImusateiRireki.getKetsyacd());
        khSntkInfoTouroku.setPalketsyacd(pImusateiRireki.getPalketsyacd());
        khSntkInfoTouroku.setSyoubyoucd1(pImusateiRireki.getSyoubyoucd1());
        khSntkInfoTouroku.setSyoubyoujyoutaikbn1(pImusateiRireki.getSyoubyoujyoutaikbn1());
        khSntkInfoTouroku.setKantiym1(pImusateiRireki.getKantiym1());
        khSntkInfoTouroku.setSyoubyoucd2(pImusateiRireki.getSyoubyoucd2());
        khSntkInfoTouroku.setSyoubyoujyoutaikbn2(pImusateiRireki.getSyoubyoujyoutaikbn2());
        khSntkInfoTouroku.setKantiym2(pImusateiRireki.getKantiym2());
        khSntkInfoTouroku.setMrriyuucdkbn(C_MrRiyuucdKbn.BLNK);

        if (StringUtil.isNullOrBlank(pImusateiRireki.getSyoubyoucd1()) &&
            StringUtil.isNullOrBlank(pImusateiRireki.getSyoubyoucd2()) ) {

            khSntkInfoTouroku.setKijinaiyouumukbn(C_BlnktkumuKbn.NONE);
        }
        else {

            khSntkInfoTouroku.setKijinaiyouumukbn(C_BlnktkumuKbn.ARI);
        }

        BizPropertyInitializer.initialize(khSntkInfoTouroku);
        pKhSntkInfoTouroku.add(khSntkInfoTouroku);
    }

    private void hhknInfoKyutsuHensyu(IT_KhSntkInfoTouroku pKhSntkInfoTouroku, HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon, HT_Kokutisyo pKokutisyo) {

        if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {

            pKhSntkInfoTouroku.setSntkinfokankeisyakbn(C_KankeisyaKbn.HHKN_KYKDOUITU);
        }
        else if (C_KykKbn.KEIHI_BETU.eq(pMosKihon.getKykkbn())){

            pKhSntkInfoTouroku.setSntkinfokankeisyakbn(C_KankeisyaKbn.HHKN_KYKBETU);
        }

        pKhSntkInfoTouroku.setTaisyounmkn(pMosKihon.getHhknnmkn());
        pKhSntkInfoTouroku.setTaisyouseiymd(pMosKihon.getHhknseiymd());
        pKhSntkInfoTouroku.setTaisyouseibetu(C_Seibetu.valueOf(pMosKihon.getHhknsei().getValue()));

        if (C_KjkhukaKbn.BLNK.eq(pMosKihon.getHhknnmkjkhukakbn())) {

            pKhSntkInfoTouroku.setTaisyounmkj(pMosKihon.getHhknnmkj());
        }
        else {

            pKhSntkInfoTouroku.setTaisyounmkj(BURANNKU);
        }

        if (pSyoriCTL.getKktymd() != null) {

            pKhSntkInfoTouroku.setKktnaiyouumukbn(C_BlnktkumuKbn.ARI);
            pKhSntkInfoTouroku.setKktymd(pSyoriCTL.getKktymd());

            if (C_SntkhouKbn.KKT.eq(pMosKihon.getSntkhoukbn())
                && C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())
                && pKokutisyo != null) {

                pKhSntkInfoTouroku.setSintyou(pKokutisyo.getSintyou());
                pKhSntkInfoTouroku.setTaijyuu(pKokutisyo.getTaijyuu());
            }
            else {

                pKhSntkInfoTouroku.setSintyou(0);
                pKhSntkInfoTouroku.setTaijyuu(0);
            }
        }
        else {

            pKhSntkInfoTouroku.setKktnaiyouumukbn(C_BlnktkumuKbn.NONE);
            pKhSntkInfoTouroku.setKktymd(null);
            pKhSntkInfoTouroku.setSintyou(0);
            pKhSntkInfoTouroku.setTaijyuu(0);
        }
    }

    private void dakuhiKetteiKyutsuHensyu(IT_KhSntkInfoTouroku pKhSntkInfoTouroku,
        HT_DakuhiKettei pDakuhiKettei, HT_SyoriCTL pSyoriCTL){

        if (pDakuhiKettei != null) {

            pKhSntkInfoTouroku.setDakuhiketnaiyouumukbn(C_BlnktkumuKbn.ARI);
            pKhSntkInfoTouroku.setSeiritukbn(pSyoriCTL.getSeiritukbn());
            pKhSntkInfoTouroku.setDeckbn(C_DecKbn.SKEI);
            pKhSntkInfoTouroku.setKetymd(pDakuhiKettei.getKetymd());
            pKhSntkInfoTouroku.setKetkekkacd(pDakuhiKettei.getKetkekkacd());
            pKhSntkInfoTouroku.setKetriyuucd1(pDakuhiKettei.getKetriyuucd1());
            pKhSntkInfoTouroku.setKetriyuucd2(pDakuhiKettei.getKetriyuucd2());
            pKhSntkInfoTouroku.setKetriyuucd3(pDakuhiKettei.getKetriyuucd3());
            pKhSntkInfoTouroku.setKetriyuucd4(pDakuhiKettei.getKetriyuucd4());
            pKhSntkInfoTouroku.setKetsyacd(pDakuhiKettei.getKetsyacd());
            pKhSntkInfoTouroku.setPalketsyacd(pDakuhiKettei.getPalketsyacd());

            if (C_DakuhiktbunruiKbn.DAKUHIKETTEI.eq(pDakuhiKettei.getDakuhiktbunruikbn())
                && C_Ketkekkacd.MIAWASE.eq(pDakuhiKettei.getKetkekkacd())
                && !C_MrRiyuucdKbn.SAIKENSASIOSAETOU.eq(pDakuhiKettei.getMrriyuucdkbn())) {

                pKhSntkInfoTouroku.setMrumukbn(C_BlnktkumuKbn.ARI);
                pKhSntkInfoTouroku.setMrriyuucdkbn(pDakuhiKettei.getMrriyuucdkbn());
            }
            else {

                pKhSntkInfoTouroku.setMrumukbn(C_BlnktkumuKbn.NONE);
                pKhSntkInfoTouroku.setMrriyuucdkbn(C_MrRiyuucdKbn.BLNK);
            }
        }
        else {

            pKhSntkInfoTouroku.setDakuhiketnaiyouumukbn(C_BlnktkumuKbn.NONE);
            pKhSntkInfoTouroku.setSeiritukbn(pSyoriCTL.getSeiritukbn());
            pKhSntkInfoTouroku.setDeckbn(C_DecKbn.BLNK);
            pKhSntkInfoTouroku.setKetymd(null);
            pKhSntkInfoTouroku.setKetkekkacd(C_Ketkekkacd.BLNK);
            pKhSntkInfoTouroku.setKetriyuucd1(C_Ketriyuucd.BLNK);
            pKhSntkInfoTouroku.setKetriyuucd2(C_Ketriyuucd.BLNK);
            pKhSntkInfoTouroku.setKetriyuucd3(C_Ketriyuucd.BLNK);
            pKhSntkInfoTouroku.setKetriyuucd4(C_Ketriyuucd.BLNK);
            pKhSntkInfoTouroku.setKetsyacd(BURANNKU);
            pKhSntkInfoTouroku.setPalketsyacd(BURANNKU);
            pKhSntkInfoTouroku.setMrumukbn(C_BlnktkumuKbn.NONE);
            pKhSntkInfoTouroku.setMrriyuucdkbn(C_MrRiyuucdKbn.BLNK);
        }
    }

    private void khSntkInfoKyutsuHensyu(IT_KhSntkInfoTouroku pKhSntkInfoTouroku, HT_SyoriCTL pSyoriCTL, HT_MosSyouhn
        pMosSyouhn){

        pKhSntkInfoTouroku.setSyono(pSyoriCTL.getSyono());
        pKhSntkInfoTouroku.setRenno(renNo);
        pKhSntkInfoTouroku.setSyoriYmd(bzBatchParam.getSyoriYmd());
        pKhSntkInfoTouroku.setHuho2kykno(pSyoriCTL.getMosno());
        pKhSntkInfoTouroku.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        pKhSntkInfoTouroku.setSyouhncd(pMosSyouhn.getSyouhncd());
        pKhSntkInfoTouroku.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
        pKhSntkInfoTouroku.setTorikaijoumukbn(C_BlnktkumuKbn.NONE);
        pKhSntkInfoTouroku.setSntkinfokyktorikesikbn(C_SntkInfoKykTorikesiKbn.BLNK);
        pKhSntkInfoTouroku.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        pKhSntkInfoTouroku.setGyoumuKousinKinou(kinou.getKinouId());
        pKhSntkInfoTouroku.setGyoumuKousinsyaId(bzBatchParam.getUserId());
        pKhSntkInfoTouroku.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
