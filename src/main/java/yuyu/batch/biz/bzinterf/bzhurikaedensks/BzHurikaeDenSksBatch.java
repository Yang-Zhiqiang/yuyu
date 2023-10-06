package yuyu.batch.biz.bzinterf.bzhurikaedensks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzFurikaeDenpyouJouhou;
import yuyu.common.biz.kaikei.FurikaeDenpyouPage;
import yuyu.common.biz.kaikei.FurikaeDenpyouSiwakeMeisai;
import yuyu.def.MessageId;
import yuyu.def.base.detacher.AS_KinouDetacher;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.base.sorter.SortAS_Kinou;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_FuriTaniHanteiKekkaKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeTy;
import yuyu.def.db.entity.ZT_FurikaeDenpyouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 インターフェイス 振替伝票作成処理
 */
public class BzHurikaeDenSksBatch implements Batch {

    private final String BIKOU1 = "区分＝";

    private final String BIKOU2 = "支払方法区分＝";

    private final String BIKOU3 = "発生区分＝";

    private final String BIKOU4 = "証券番号";

    private final String KORON = "：";

    private final String PIRIODO = ".";

    private final String KANZITEKIYOUKOUMOKU = "　　　　　　　　Ｎｏ．";

    private final String FILTERID = "Bz105";

    private static final String JIGYOUHI_KMKCD = "41101";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        List<BzFurikaeDenpyouJouhou> bzFurikaeDenpyouJouhouLst = new ArrayList<>();
        BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou = null;
        BT_HuriDenpyou huriDenpyouBefore = null;
        int count = 0;

        try(ExDBResults<BT_HuriDenpyou> huriDenpyouLst =
            bizDomManager.getHuriDenpyousByKakutyoujobcdSyoriYmdTorihikino(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd());
            EntityInserter<ZT_FurikaeDenpyouTy> furikaeDenpyouTyLst = new EntityInserter<>();
            EntityInserter<ZT_FurikaeDenpyouHikaeTy> furikaeDenpyouHikaeTyLst = new EntityInserter<>()) {

            for (BT_HuriDenpyou huriDenpyou : huriDenpyouLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_HuriDenpyou.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(huriDenpyou.getDensyskbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(huriDenpyou.getDenrenno());

                if (null == bzFurikaeDenpyouJouhou) {

                    bzFurikaeDenpyouJouhou = createHurikaedenpyoujouhou(huriDenpyou);

                    huriDenpyouBefore = huriDenpyou;

                    bzFurikaeDenpyouJouhouLst.add(bzFurikaeDenpyouJouhou);
                }
                else {

                    C_FuriTaniHanteiKekkaKbn furiTaniHanteiKekkaKbn = chkDenpyoutani(huriDenpyou, huriDenpyouBefore);

                    if (C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI.eq(furiTaniHanteiKekkaKbn)) {

                        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(huriDenpyou.getTaisyakukbn(),
                            huriDenpyou.getDenyenkagk());
                    }
                    else if (C_FuriTaniHanteiKekkaKbn.DOUITUDEN.eq(furiTaniHanteiKekkaKbn)) {

                        insHurikaedenpyoujouhou(huriDenpyou, bzFurikaeDenpyouJouhou);

                        huriDenpyouBefore = huriDenpyou;
                    }
                    else if (C_FuriTaniHanteiKekkaKbn.BETUDEN.eq(furiTaniHanteiKekkaKbn)) {

                        bzFurikaeDenpyouJouhou = createHurikaedenpyoujouhou(huriDenpyou);

                        huriDenpyouBefore = huriDenpyou;

                        bzFurikaeDenpyouJouhouLst.add(bzFurikaeDenpyouJouhou);
                    }

                }
                count++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (bzFurikaeDenpyouJouhouLst.size() > 0) {

                bzFurikaeDenpyouJouhouLst.get(bzFurikaeDenpyouJouhouLst.size() - 1).setLastGroupDispFlg(true);
            }

            for (BzFurikaeDenpyouJouhou furikaeDenpyouJouhou : bzFurikaeDenpyouJouhouLst) {

                List<FurikaeDenpyouPage> furikaeDenpyouPageLst = furikaeDenpyouJouhou.furikaeDenPageList();

                for (FurikaeDenpyouPage furikaeDenpyouPage : furikaeDenpyouPageLst) {

                    ZT_FurikaeDenpyouTy furikaeDenpyouTy = new ZT_FurikaeDenpyouTy();
                    ZT_FurikaeDenpyouHikaeTy furikaeDenpyouHikaeTy = new ZT_FurikaeDenpyouHikaeTy();

                    furikaeDenpyouJouhou.setFurikaeDenEntity(furikaeDenpyouTy, furikaeDenpyouPage);

                    BizPropertyInitializer.initialize(furikaeDenpyouTy);

                    furikaeDenpyouTyLst.add(furikaeDenpyouTy);

                    furikaeDenpyouJouhou.setFurikaeDenHikaEntity(furikaeDenpyouHikaeTy, furikaeDenpyouPage);

                    BizPropertyInitializer.initialize(furikaeDenpyouHikaeTy);

                    furikaeDenpyouHikaeTyLst.add(furikaeDenpyouHikaeTy);
                }
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    private C_FuriTaniHanteiKekkaKbn chkDenpyoutani(BT_HuriDenpyou pHuriDenpyou, BT_HuriDenpyou pHuriDenpyouBefore) {

        C_FuriTaniHanteiKekkaKbn furiTaniHanteiKekkaKbn = C_FuriTaniHanteiKekkaKbn.BLNK;

        if (pHuriDenpyouBefore.getTorihikino().equals(pHuriDenpyou.getTorihikino()) &&
            pHuriDenpyouBefore.getHuridenatesakicd().equals(pHuriDenpyou.getHuridenatesakicd()) &&
            pHuriDenpyouBefore.getTantocd().eq(pHuriDenpyou.getTantocd()) &&
            pHuriDenpyouBefore.getDenymd().equals(pHuriDenpyou.getDenymd()) &&
            pHuriDenpyouBefore.getHuridenskskbn().eq(pHuriDenpyou.getHuridenskskbn())) {
            if (pHuriDenpyouBefore.getTaisyakukbn().eq(pHuriDenpyou.getTaisyakukbn()) &&
                pHuriDenpyouBefore.getDenkanjokamokucd().equals(pHuriDenpyou.getDenkanjokamokucd()) &&
                pHuriDenpyouBefore.getJigyouhiutiwakecd().equals(pHuriDenpyou.getJigyouhiutiwakecd())) {

                furiTaniHanteiKekkaKbn = C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI;
            }
            else {

                furiTaniHanteiKekkaKbn = C_FuriTaniHanteiKekkaKbn.DOUITUDEN;
            }

        }
        else {

            furiTaniHanteiKekkaKbn = C_FuriTaniHanteiKekkaKbn.BETUDEN;
        }

        return furiTaniHanteiKekkaKbn;
    }

    private BzFurikaeDenpyouJouhou createHurikaedenpyoujouhou(BT_HuriDenpyou pHuriDenpyou) {

        BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou = SWAKInjector.getInstance(BzFurikaeDenpyouJouhou.class);

        insHurikaedenpyoujouhou(pHuriDenpyou, bzFurikaeDenpyouJouhou);

        String kanzitekiyou1 = selkanzitekiyou(pHuriDenpyou);

        String kanzitekiyou2 = selkanzitekiyou2(pHuriDenpyou);

        bzFurikaeDenpyouJouhou.setTorihikiNo(pHuriDenpyou.getTorihikino());
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd(pHuriDenpyou.getHuridenatesakicd());
        bzFurikaeDenpyouJouhou.setTantoCd(pHuriDenpyou.getTantocd());
        bzFurikaeDenpyouJouhou.setDenYmd(pHuriDenpyou.getDenymd());
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(pHuriDenpyou.getKeirisyskbn());
        bzFurikaeDenpyouJouhou.setKjTekiyou1("");
        bzFurikaeDenpyouJouhou.setKjTekiyou2("");
        bzFurikaeDenpyouJouhou.setKjTekiyou3("");
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae1(kanzitekiyou1);
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae2(kanzitekiyou2);
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae3("");
        bzFurikaeDenpyouJouhou.setSyoriYmd(bzBatchParam.getSyoriYmd());

        return bzFurikaeDenpyouJouhou;
    }

    private String selkanzitekiyou(BT_HuriDenpyou pHuriDenpyou) {

        String bikou1 = "";
        String bikou2 = "";
        String bikou3 = "";
        String bikou4 = "";

        bikou1 = BIKOU1 + pHuriDenpyou.getHuridenskskbn().getValue() +
            KORON + pHuriDenpyou.getHuridenskskbn().getContent();

        if (C_HuridensksKbn.HOZENYAKAN.eq(pHuriDenpyou.getHuridenskskbn()) ||
            C_HuridensksKbn.KOBETU.eq(pHuriDenpyou.getHuridenskskbn()) ||
            C_HuridensksKbn.HONSYARYOUKIN.eq(pHuriDenpyou.getHuridenskskbn())) {

            bikou2 = BIKOU2 + pHuriDenpyou.getDenshrhoukbn().getValue() +
                KORON + pHuriDenpyou.getDenshrhoukbn().getContent();
        }

        if ((C_HuridensksKbn.KOBETU.eq(pHuriDenpyou.getHuridenskskbn()) ||
            C_HuridensksKbn.HONSYARYOUKIN.eq(pHuriDenpyou.getHuridenskskbn())) &&
            !C_DenSyorisyousaiKbn.BLNK.eq(pHuriDenpyou.getDensyorisyousaikbn())) {

            bikou3 = BIKOU3 + pHuriDenpyou.getDensyorisyousaikbn().getContent();
        }

        if (C_HuridensksKbn.KOBETU.eq(pHuriDenpyou.getHuridenskskbn())) {

            bikou4 = BIKOU4 + pHuriDenpyou.getKeirisyono();
        }

        String kanzitekiyou1 = bikou1 + "　" + bikou2 + "　" + bikou3 + "　" + bikou4;

        return kanzitekiyou1;
    }

    private void insHurikaedenpyoujouhou(BT_HuriDenpyou pHuriDenpyou, BzFurikaeDenpyouJouhou pBzFurikaeDenpyouJouhou) {

        String tekiyoukoumoku = pHuriDenpyou.getDenkanjokamokucd() + PIRIODO + pHuriDenpyou.getSuitoubumoncd();

        if (!Strings.isNullOrEmpty(pHuriDenpyou.getTekiyoucd())) {

            tekiyoukoumoku = tekiyoukoumoku + PIRIODO + pHuriDenpyou.getTekiyoucd();
        }

        String kanzitekiyoukoumoku;
        if (JIGYOUHI_KMKCD.equals(pHuriDenpyou.getDenkanjokamokucd())) {

            kanzitekiyoukoumoku = pHuriDenpyou.getJigyouhiutiwakenm();
        }
        else if(!Strings.isNullOrEmpty(pHuriDenpyou.getTekiyoucd())) {

            kanzitekiyoukoumoku = KANZITEKIYOUKOUMOKU + pHuriDenpyou.getTekiyoucd();
        }

        else {
            kanzitekiyoukoumoku = "";
        }

        FurikaeDenpyouSiwakeMeisai furikaeDenpyouSiwakeMeisai =
            SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);

        furikaeDenpyouSiwakeMeisai.setDenKanjoKamokuCd(pHuriDenpyou.getDenkanjokamokucd());
        furikaeDenpyouSiwakeMeisai.setDenKanjoKamokuNm(pHuriDenpyou.getKanjyouKamoku().getKanjyoukmknm());
        furikaeDenpyouSiwakeMeisai.setSuitouBumonCd(pHuriDenpyou.getSuitoubumoncd());
        furikaeDenpyouSiwakeMeisai.setTekiyouCd(pHuriDenpyou.getTekiyoucd());
        furikaeDenpyouSiwakeMeisai.setKinGk(pHuriDenpyou.getDenyenkagk());
        furikaeDenpyouSiwakeMeisai.setTekiyouKm(tekiyoukoumoku);
        furikaeDenpyouSiwakeMeisai.setKjTekiyouKm(kanzitekiyoukoumoku);

        pBzFurikaeDenpyouJouhou.insertSiwakeMeisai(furikaeDenpyouSiwakeMeisai, pHuriDenpyou.getTaisyakukbn());
    }

    private String selkanzitekiyou2(BT_HuriDenpyou pHuriDenpyou) {

        if (!C_HuridensksKbn.KOBETU.eq(pHuriDenpyou.getHuridenskskbn())
            && (!C_HuridensksKbn.HONSYARYOUKIN.eq(pHuriDenpyou.getHuridenskskbn()))) {

            return null;
        }
        SortAS_Kinou sortAsKinou = SWAKInjector.getInstance(SortAS_Kinou.class);

        List<AS_Kinou> asKinouList = baseDomManager.getKinousBySyoricd(pHuriDenpyou.getSyoricd());

        asKinouList = AS_KinouDetacher.detachKinoutouched(asKinouList);

        asKinouList = sortAsKinou.OrderAS_KinouByPkAsc(asKinouList);

        if (asKinouList == null || asKinouList.size() == 0) {

            return "";
        }

        AS_Kinou asKinou = asKinouList.get(0);

        return asKinou.getKinouNm();
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
