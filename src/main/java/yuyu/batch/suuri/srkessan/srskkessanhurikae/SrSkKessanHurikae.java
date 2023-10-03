package yuyu.batch.suuri.srkessan.srskkessanhurikae;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzFurikaeDenpyouJouhou;
import yuyu.common.biz.kaikei.FurikaeDenpyouPage;
import yuyu.common.biz.kaikei.FurikaeDenpyouSiwakeMeisai;
import yuyu.common.suuri.srcommon.SrFindTekiyouCategory;
import yuyu.common.suuri.srcommon.SrFindTekiyouCategoryBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FuriTaniHanteiKekkaKbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.entity.ZT_SkKsnHurikaeHikaeTy;
import yuyu.def.db.entity.ZT_SkKsnHurikaeTy;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約決算用振替伝票作成クラス
 */
public class SrSkKessanHurikae implements Batch {

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SuuriDomManager suuriDomManager;

    private int thRenNo;

    private static final String TKKYTSDENPYOU  = "追込契約調整伝票";

    private static final String BLANK  = "";

    private static final String PIRIODO  = ".";

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate ksnsaisyueigyoubiymd = bzBatchParam.getSyoriYmd().getPreviousMonth().getBizDateYM().getLastDay().
            getBusinessDay(CHolidayAdjustingMode.NEXT_IN_THIS_MONTH);

        List<ST_SkKessanSyukei> skKessanSyukeiLst = suuriDomManager
            .getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(ksnsaisyueigyoubiymd);

        List<BzFurikaeDenpyouJouhou> bzFurikaeDenpyouJouhouLst = new ArrayList<>();
        BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou = null;
        ST_SkKessanSyukei skKessanSyukeiPre = null;
        int srKessu = 0;
        thRenNo = 0;

        for (ST_SkKessanSyukei skKessanSyukei : skKessanSyukeiLst) {

            if (skKessanSyukeiPre == null) {

                bzFurikaeDenpyouJouhou = createSkKsnHurikaeData(skKessanSyukei);
                skKessanSyukeiPre = skKessanSyukei;

                bzFurikaeDenpyouJouhouLst.add(bzFurikaeDenpyouJouhou);
            }
            else {

                C_FuriTaniHanteiKekkaKbn htKekka = getDanpyouTani(skKessanSyukei, skKessanSyukeiPre);

                if (C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI.eq(htKekka)) {

                    bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(
                        skKessanSyukei.getTaisyakukbn(),
                        skKessanSyukei.getDenyenkagk());
                }
                else if (C_FuriTaniHanteiKekkaKbn.DOUITUDEN.eq(htKekka)) {

                    addMeisaiData(skKessanSyukei, bzFurikaeDenpyouJouhou);

                    skKessanSyukeiPre = skKessanSyukei;
                }
                else if (C_FuriTaniHanteiKekkaKbn.BETUDEN.eq(htKekka)) {

                    bzFurikaeDenpyouJouhou = createSkKsnHurikaeData(skKessanSyukei);
                    skKessanSyukeiPre = skKessanSyukei;

                    bzFurikaeDenpyouJouhouLst.add(bzFurikaeDenpyouJouhou);
                }
            }

        }

        if (bzFurikaeDenpyouJouhouLst.size() > 0) {

            bzFurikaeDenpyouJouhouLst.get(bzFurikaeDenpyouJouhouLst.size() - 1).setLastGroupDispFlg(true);
        }

        for (BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhouAto : bzFurikaeDenpyouJouhouLst) {

            List<FurikaeDenpyouPage> furikaeDenpyouPageLst = bzFurikaeDenpyouJouhouAto.furikaeDenPageList();

            for (FurikaeDenpyouPage furikaeDenpyouPage : furikaeDenpyouPageLst) {

                ZT_SkKsnHurikaeTy skKsnHurikaeTy = new ZT_SkKsnHurikaeTy();

                bzFurikaeDenpyouJouhouAto.setFurikaeDenEntity(skKsnHurikaeTy, furikaeDenpyouPage);

                BizPropertyInitializer.initialize(skKsnHurikaeTy);

                suuriDomManager.insert(skKsnHurikaeTy);

                ZT_SkKsnHurikaeHikaeTy skKsnHurikaeHikaeTy = new ZT_SkKsnHurikaeHikaeTy();

                bzFurikaeDenpyouJouhouAto.setFurikaeDenHikaEntity(skKsnHurikaeHikaeTy, furikaeDenpyouPage);

                BizPropertyInitializer.initialize(skKsnHurikaeHikaeTy);

                suuriDomManager.insert(skKsnHurikaeHikaeTy);

                srKessu = srKessu + 1;
            }

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(srKessu),"新契約決算用振替伝票テーブル"));
    }

    private BzFurikaeDenpyouJouhou createSkKsnHurikaeData(ST_SkKessanSyukei pSkKessanSyukei) {

        BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou = SWAKInjector.getInstance(BzFurikaeDenpyouJouhou.class);

        addMeisaiData(pSkKessanSyukei, bzFurikaeDenpyouJouhou);

        thRenNo = thRenNo + 1;
        String thRenNoS3 = Strings.padStart(String.valueOf(thRenNo), 3, '0');
        BizDateMD srMd = bzBatchParam.getSyoriYmd().getBizDateMD();

        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd(pSkKessanSyukei.getHuridenatesakicd());
        bzFurikaeDenpyouJouhou.setTantoCd(pSkKessanSyukei.getTantocd());
        bzFurikaeDenpyouJouhou.setDenYmd(pSkKessanSyukei.getDenymd());
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(pSkKessanSyukei.getKeirisyskbn());
        bzFurikaeDenpyouJouhou.setKjTekiyou1(TKKYTSDENPYOU);
        bzFurikaeDenpyouJouhou.setKjTekiyou2(BLANK);
        bzFurikaeDenpyouJouhou.setKjTekiyou3(BLANK);
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae1(TKKYTSDENPYOU);
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae2(BLANK);
        bzFurikaeDenpyouJouhou.setKjTekiyouHikae3(BLANK);
        bzFurikaeDenpyouJouhou.setTorihikiNo(String.valueOf(srMd).concat(thRenNoS3));
        bzFurikaeDenpyouJouhou.setSyoriYmd(bzBatchParam.getSyoriYmd());

        return bzFurikaeDenpyouJouhou;
    }

    private C_FuriTaniHanteiKekkaKbn getDanpyouTani(
        ST_SkKessanSyukei pSkKessanSyukei,
        ST_SkKessanSyukei pSkKessanSyukeipre) {

        if (pSkKessanSyukeipre.getDenymd().equals(pSkKessanSyukei.getDenymd()) &&
            pSkKessanSyukeipre.getHuridenpagekbn().eq(pSkKessanSyukei.getHuridenpagekbn()) &&
            pSkKessanSyukeipre.getHuridenatesakicd().equals(pSkKessanSyukei.getHuridenatesakicd()) &&
            pSkKessanSyukeipre.getTantocd().eq(pSkKessanSyukei.getTantocd())) {

            if (pSkKessanSyukeipre.getKanjyouKamoku().getKanjyoukmkgroupkbn().equals(
                pSkKessanSyukei.getKanjyouKamoku().getKanjyoukmkgroupkbn()) &&
                pSkKessanSyukeipre.getDenkanjokamokucd().equals(pSkKessanSyukei.getDenkanjokamokucd()) &&
                pSkKessanSyukeipre.getTaisyakukbn().eq(pSkKessanSyukei.getTaisyakukbn()) &&
                pSkKessanSyukeipre.getNaibukeiyakukbn().eq(pSkKessanSyukei.getNaibukeiyakukbn()) &&
                pSkKessanSyukeipre.getTekiyoukbn().eq(pSkKessanSyukei.getTekiyoukbn())) {

                return C_FuriTaniHanteiKekkaKbn.DOUITUDENMEISAI;
            }

            return C_FuriTaniHanteiKekkaKbn.DOUITUDEN;
        }

        return C_FuriTaniHanteiKekkaKbn.BETUDEN;
    }

    private void addMeisaiData(ST_SkKessanSyukei pSkKessanSyukei, BzFurikaeDenpyouJouhou pBzFurikaeDenpyouJouhou) {

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);

        SrFindTekiyouCategoryBean srFindTekiyouCategoryBean = srFindTekiyouCategory.getAppropriateTekiyouCom(
            pSkKessanSyukei.getKanjyoukmkcd(),pSkKessanSyukei.getTekiyoukbn(),pSkKessanSyukei.getNaibukeiyakukbn());

        String tekiyoucd = "";

        if (!BizUtil.isBlank(srFindTekiyouCategoryBean.getTekiyoucd()) ) {

            tekiyoucd = PIRIODO.concat(srFindTekiyouCategoryBean.getTekiyoucd());
        }

        String tyKoumoku = pSkKessanSyukei.getDenkanjokamokucd().concat(PIRIODO).
            concat(pSkKessanSyukei.getSuitoubumoncd()).concat(tekiyoucd);

        FurikaeDenpyouSiwakeMeisai furikaeDenpyouSiwakeMeisai = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);

        furikaeDenpyouSiwakeMeisai.setDenKanjoKamokuCd(pSkKessanSyukei.getDenkanjokamokucd());
        furikaeDenpyouSiwakeMeisai.setDenKanjoKamokuNm(pSkKessanSyukei.getKanjyouKamoku().getKanjyoukmknm());
        furikaeDenpyouSiwakeMeisai.setSuitouBumonCd(pSkKessanSyukei.getSuitoubumoncd());
        furikaeDenpyouSiwakeMeisai.setTekiyouCd(srFindTekiyouCategoryBean.getTekiyoucd());
        furikaeDenpyouSiwakeMeisai.setKinGk(pSkKessanSyukei.getDenyenkagk());
        furikaeDenpyouSiwakeMeisai.setTekiyouKm(tyKoumoku);
        furikaeDenpyouSiwakeMeisai.setKjTekiyouKm(BLANK);

        pBzFurikaeDenpyouJouhou.insertSiwakeMeisai(furikaeDenpyouSiwakeMeisai, pSkKessanSyukei.getTaisyakukbn());
    }
}
