package yuyu.batch.biz.bzinterf.bzsinkeiyakuhurikaedensks;

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
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_FuriTaniHanteiKekkaKbn;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 新契約振替伝票作成処理
 */
public class BzSinkeiyakuHurikaeDenSksBatch implements Batch {

    private final String PIRIODO = ".";

    private final String FILTERID = "Bz105";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

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
        BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDenBefore = null;
        int count = 0;

        try(ExDBResults<BT_SinkeiyakuHurikaeDen> sinkeiyakuHurikaeDenLst =
            bizDomManager.getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd());
            EntityInserter<ZT_SkFurikaeDenpyouTy> skFurikaeDenpyouTyLst = new EntityInserter<>();
            EntityInserter<ZT_SkFurikaeDenpyouHikaeTy> skFurikaeDenpyouHikaeTyLst = new EntityInserter<>()) {

            for (BT_SinkeiyakuHurikaeDen sinkeiyakuHurikaeDen : sinkeiyakuHurikaeDenLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_SinkeiyakuHurikaeDen.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sinkeiyakuHurikaeDen.getDensyskbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(sinkeiyakuHurikaeDen.getDenrenno());

                if (null == bzFurikaeDenpyouJouhou) {

                    bzFurikaeDenpyouJouhou = createHurikaeDenpyouJouhou(sinkeiyakuHurikaeDen);

                    sinkeiyakuHurikaeDenBefore = sinkeiyakuHurikaeDen;

                    bzFurikaeDenpyouJouhouLst.add(bzFurikaeDenpyouJouhou);

                }
                else {
                    C_FuriTaniHanteiKekkaKbn furiTaniHanteiKekkaKbn =
                        chkDenpyouTani(sinkeiyakuHurikaeDen, sinkeiyakuHurikaeDenBefore);

                    if (C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI.eq(furiTaniHanteiKekkaKbn)) {

                        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(sinkeiyakuHurikaeDen.getTaisyakukbn(),
                            sinkeiyakuHurikaeDen.getDenyenkagk());
                    }
                    else if (C_FuriTaniHanteiKekkaKbn.DOUITUDEN.eq(furiTaniHanteiKekkaKbn)) {

                        insHurikaeDenpyouJouhou(sinkeiyakuHurikaeDen, bzFurikaeDenpyouJouhou);

                        sinkeiyakuHurikaeDenBefore = sinkeiyakuHurikaeDen;
                    }
                    else if (C_FuriTaniHanteiKekkaKbn.BETUDEN.eq(furiTaniHanteiKekkaKbn)) {

                        bzFurikaeDenpyouJouhou = createHurikaeDenpyouJouhou(sinkeiyakuHurikaeDen);

                        sinkeiyakuHurikaeDenBefore = sinkeiyakuHurikaeDen;

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

                    ZT_SkFurikaeDenpyouTy skFurikaeDenpyouTy = new ZT_SkFurikaeDenpyouTy();
                    ZT_SkFurikaeDenpyouHikaeTy skFurikaeDenpyouHikaeTy = new ZT_SkFurikaeDenpyouHikaeTy();

                    furikaeDenpyouJouhou.setFurikaeDenEntity(skFurikaeDenpyouTy, furikaeDenpyouPage);

                    BizPropertyInitializer.initialize(skFurikaeDenpyouTy);

                    skFurikaeDenpyouTyLst.add(skFurikaeDenpyouTy);

                    furikaeDenpyouJouhou.setFurikaeDenHikaEntity(skFurikaeDenpyouHikaeTy, furikaeDenpyouPage);

                    BizPropertyInitializer.initialize(skFurikaeDenpyouHikaeTy);

                    skFurikaeDenpyouHikaeTyLst.add(skFurikaeDenpyouHikaeTy);
                }
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    private C_FuriTaniHanteiKekkaKbn chkDenpyouTani(BT_SinkeiyakuHurikaeDen pSinkeiyakuHurikaeDen,
        BT_SinkeiyakuHurikaeDen pSinkeiyakuHurikaeDenAfter) {

        C_FuriTaniHanteiKekkaKbn furiTaniHanteiKekkaKbn = C_FuriTaniHanteiKekkaKbn.BLNK;

        if (pSinkeiyakuHurikaeDenAfter.getTorihikino().equals(pSinkeiyakuHurikaeDen.getTorihikino())) {
            if (pSinkeiyakuHurikaeDenAfter.getTaisyakukbn().eq(pSinkeiyakuHurikaeDen.getTaisyakukbn()) &&
                pSinkeiyakuHurikaeDenAfter.getKanjyoukmkgroupkbn().eq(pSinkeiyakuHurikaeDen.getKanjyoukmkgroupkbn()) &&
                pSinkeiyakuHurikaeDenAfter.getDenkanjokamokucd().equals(pSinkeiyakuHurikaeDen.getDenkanjokamokucd()) &&
                pSinkeiyakuHurikaeDenAfter.getNaibukeiyakukbn().eq(pSinkeiyakuHurikaeDen.getNaibukeiyakukbn()) &&
                pSinkeiyakuHurikaeDenAfter.getTekiyoukbn().eq(pSinkeiyakuHurikaeDen.getTekiyoukbn())) {

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

    private BzFurikaeDenpyouJouhou createHurikaeDenpyouJouhou(BT_SinkeiyakuHurikaeDen pSinkeiyakuHurikaeDen) {

        BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou = SWAKInjector.getInstance(BzFurikaeDenpyouJouhou.class);

        insHurikaeDenpyouJouhou(pSinkeiyakuHurikaeDen, bzFurikaeDenpyouJouhou);

        bzFurikaeDenpyouJouhou.setTorihikiNo(pSinkeiyakuHurikaeDen.getTorihikino());
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd(pSinkeiyakuHurikaeDen.getHuridenatesakicd());
        bzFurikaeDenpyouJouhou.setTantoCd(pSinkeiyakuHurikaeDen.getTantocd());
        bzFurikaeDenpyouJouhou.setDenYmd(pSinkeiyakuHurikaeDen.getDenymd());
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(pSinkeiyakuHurikaeDen.getKeirisyskbn());
        bzFurikaeDenpyouJouhou.setKjTekiyou1("");
        bzFurikaeDenpyouJouhou.setKjTekiyou2("");
        bzFurikaeDenpyouJouhou.setKjTekiyou3("");
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae1("");
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae2("");
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae3("");
        bzFurikaeDenpyouJouhou.setSyoriYmd(bzBatchParam.getSyoriYmd());

        return bzFurikaeDenpyouJouhou;

    }

    private void insHurikaeDenpyouJouhou(BT_SinkeiyakuHurikaeDen pSinkeiyakuHurikaeDen,
        BzFurikaeDenpyouJouhou pBzFurikaeDenpyouJouhou) {

        String tekiyoukoumoku = pSinkeiyakuHurikaeDen.getDenkanjokamokucd() +
            PIRIODO + pSinkeiyakuHurikaeDen.getSuitoubumoncd();

        String kanzitekiyoukoumoku = "";

        FurikaeDenpyouSiwakeMeisai furikaeDenpyouSiwakeMeisai =
            SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);

        furikaeDenpyouSiwakeMeisai.setDenKanjoKamokuCd(pSinkeiyakuHurikaeDen.getDenkanjokamokucd());
        furikaeDenpyouSiwakeMeisai.setDenKanjoKamokuNm(pSinkeiyakuHurikaeDen.getKanjyouKamoku().getKanjyoukmknm());
        furikaeDenpyouSiwakeMeisai.setSuitouBumonCd(pSinkeiyakuHurikaeDen.getSuitoubumoncd());
        furikaeDenpyouSiwakeMeisai.setTekiyouCd(pSinkeiyakuHurikaeDen.getTekiyoucd());
        furikaeDenpyouSiwakeMeisai.setKinGk(pSinkeiyakuHurikaeDen.getDenyenkagk());
        furikaeDenpyouSiwakeMeisai.setTekiyouKm(tekiyoukoumoku);
        furikaeDenpyouSiwakeMeisai.setKjTekiyouKm(kanzitekiyoukoumoku);

        pBzFurikaeDenpyouJouhou.insertSiwakeMeisai(furikaeDenpyouSiwakeMeisai, pSinkeiyakuHurikaeDen.getTaisyakukbn());
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
