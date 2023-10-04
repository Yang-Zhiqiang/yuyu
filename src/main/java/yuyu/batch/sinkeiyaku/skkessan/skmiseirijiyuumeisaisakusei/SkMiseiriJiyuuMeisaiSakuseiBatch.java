package yuyu.batch.sinkeiyaku.skkessan.skmiseirijiyuumeisaisakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.DengkByMosnoRstuukasyuBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 決算 未整理事由別明細作成処理
 */
public class SkMiseiriJiyuuMeisaiSakuseiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkMiseiriJiyuuMeisaiSakuseiDao skMiseiriJiyuuMeisaiSakuseiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        BizDate kessankimatuYmd = syoriYmd.getBizDateYM().getLastDay();
        BizDate kessankimatueigyoubi = kessankimatuYmd.addBusinessDays(-1, true);
        if (BizDateUtil.compareYmd(syoriYmd, kessankimatueigyoubi) != BizDateUtil.COMPARE_EQUAL) {
            kessankimatuYmd = syoriYmd.getBizDateYM().getPreviousMonth().getLastDay();
            kessankimatueigyoubi = kessankimatuYmd.addBusinessDays(-1, true);
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMiseirijiyuuMeisai());

        sinkeiyakuDomManager.flush();

        long count = 0;
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        String userId = bzBatchParam.getUserId();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsBySrsyoriymdNull(kessankimatueigyoubi.addDays(-1));
            EntityInserter<HT_MiseirijiyuuMeisai> miseirijiyuuMeisaiIns = new EntityInserter<>();) {

            for (HT_SyoriCTL syoriCTL : exDBResults) {

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                boolean taisyoukykFlg = false;
                boolean taisyoukykSknnkaisiymdFlg = false;
                boolean taisyoukykFstpryosyuymdFlg = false;

                if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())
                    && BizDateUtil.compareYmd(syoriCTL.getSrsyoriymd(), syoriYmd) <= BizDateUtil.COMPARE_EQUAL) {
                    taisyoukykFlg = true;
                }

                if (mosKihon != null) {
                    if (mosKihon.getSknnkaisiymd() != null) {
                        if (BizDateUtil.compareYmd(mosKihon.getSknnkaisiymd(), kessankimatuYmd) <= BizDateUtil.COMPARE_EQUAL) {
                            taisyoukykSknnkaisiymdFlg = true;
                        }
                    }
                }

                BizDate nyuukinMaxRyosyuYmd = sinkeiyakuDomManager.getNyuukinMaxRyosyuymdByMosno(syoriCTL.getMosno());
                if (BizDateUtil.compareYmd(nyuukinMaxRyosyuYmd, kessankimatuYmd) <= BizDateUtil.COMPARE_EQUAL) {
                    taisyoukykFstpryosyuymdFlg = true;
                }

                if (taisyoukykFlg == true && taisyoukykSknnkaisiymdFlg == true && taisyoukykFstpryosyuymdFlg == true) {
                    continue;
                }

                GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
                getRsgakukei.getPkakinsumiRsgaku(syoriCTL, kessankimatuYmd, kessankimatueigyoubi);
                BizCurrency firstNyknkgk = getRsgakukei.getRsgakukei();
                if (BizUtil.isZero(firstNyknkgk)) {
                    continue;
                }
                C_Tuukasyu tuukasyu = getRsgakukei.getTuukasyu();

                String miseirijiyuuKbn = "";
                String miseirijiyuudetailKbn = "";
                List<C_SyoruiCdKbn> syoruiCdLst = Lists.newArrayList();
                boolean miketteisonotaflg1 = false;
                boolean miketteisonotaflg2 = false;
                boolean kouzokusyorihuyouflg = false;

                if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())
                    && (mosKihon.getSknnkaisiymd() == null
                    || BizDateUtil.compareYmd(mosKihon.getSknnkaisiymd(), kessankimatueigyoubi) == BizDateUtil.COMPARE_GREATER)) {
                    miseirijiyuuKbn = "10";
                    miseirijiyuudetailKbn = "01";
                    kouzokusyorihuyouflg = true;
                }
                else if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())
                    && BizDateUtil.compareYmd(mosKihon.getSknnkaisiymd(), kessankimatueigyoubi) == BizDateUtil.COMPARE_GREATER) {
                    miseirijiyuuKbn = "10";
                    miseirijiyuudetailKbn = "02";
                    kouzokusyorihuyouflg = true;
                }
                else if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                    miseirijiyuuKbn = "20";
                    C_Ketkekkacd ketkekkacd = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno(
                        syoriCTL.getMosno()).getKetkekkacd();
                    if (C_Ketkekkacd.ENKI_SIJINASI.eq(ketkekkacd) || C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(ketkekkacd)
                        || C_Ketkekkacd.MIAWASE.eq(ketkekkacd)) {
                        miseirijiyuudetailKbn = "01";
                        kouzokusyorihuyouflg = true;
                    }
                    else if (C_Ketkekkacd.COOLINGOFF.eq(ketkekkacd) || C_Ketkekkacd.MOS_TORIKESI.eq(ketkekkacd)) {
                        miseirijiyuudetailKbn = "02";
                        kouzokusyorihuyouflg = true;
                    }
                    else if (C_Ketkekkacd.YUUKOUKKNKKA.eq(ketkekkacd)) {
                        miseirijiyuudetailKbn = "03";
                        kouzokusyorihuyouflg = true;
                    }
                }

                if (!kouzokusyorihuyouflg
                    && C_KetteiKbn.NONE.eq(syoriCTL.getKetteikbn())) {

                    miseirijiyuuKbn = "01";
                    if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {
                        miseirijiyuudetailKbn = "01";
                        kouzokusyorihuyouflg = true;
                    }
                    else if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()) && C_UmuKbn.NONE.eq(syoriCTL.getKktnrkumu())) {
                        miseirijiyuudetailKbn = "07";
                        kouzokusyorihuyouflg = true;
                    }
                    else if (C_MostenkenjyouKbn.TENKENMATI_1.eq(syoriCTL.getMostenkenjoukbn())
                        || C_MostenkenjyouKbn.TENKENMATI_2.eq(syoriCTL.getMostenkenjoukbn())) {
                        miseirijiyuudetailKbn = "03";
                        kouzokusyorihuyouflg = true;
                    }
                    else if (C_UmuKbn.ARI.eq(syoriCTL.getKhnhbkbn())) {
                        miseirijiyuudetailKbn = "04";
                        kouzokusyorihuyouflg = true;
                    }
                    else if (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn())) {
                        miseirijiyuudetailKbn = "05";
                        kouzokusyorihuyouflg = true;
                    }
                    else {
                        miketteisonotaflg1 = true;
                    }
                }

                if (!kouzokusyorihuyouflg
                    &&( C_KnkysateijyouKbn.SATEIMATI_1.eq(syoriCTL.getKnkysateijyoukbn())
                        || C_KnkysateijyouKbn.SATEIMATI_2A.eq(syoriCTL.getKnkysateijyoukbn())
                        || C_KnkysateijyouKbn.SATEIMATI_2B.eq(syoriCTL.getKnkysateijyoukbn()))
                        || (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(syoriCTL.getImusateijyoukbn())
                            || C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(syoriCTL.getImusateijyoukbn()))) {
                    miseirijiyuuKbn = "02";
                    miseirijiyuudetailKbn = "01";
                    kouzokusyorihuyouflg = true;

                }
                else if (!kouzokusyorihuyouflg
                    && C_SateijtKbn.SATEI_TYUU.eq(syoriCTL.getSateijtkbn())
                    && (C_KykkakjkKbn.KETMAE_KAKUNIN.eq(syoriCTL.getKykkakjkkbn())
                        || C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(syoriCTL.getKykkakjkkbn()))) {
                    miseirijiyuuKbn = "02";
                    miseirijiyuudetailKbn = "03";
                    kouzokusyorihuyouflg = true;
                }
                else if (C_KetteiKbn.NONE.eq(syoriCTL.getKetteikbn())){
                    miketteisonotaflg2 = true;
                }

                if (miketteisonotaflg1 == true && miketteisonotaflg2 == true) {
                    miseirijiyuuKbn = "01";
                    miseirijiyuudetailKbn = "06";
                    kouzokusyorihuyouflg = true;
                }

                if (!kouzokusyorihuyouflg
                    && C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn())) {
                    miseirijiyuuKbn = "03";
                    if (C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu())
                        && !C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU.eq(syoriCTL.getNyuukinjoutaikbn())) {
                        miseirijiyuudetailKbn = "01";
                    }
                    else {

                        syoruiCdLst = sinkeiyakuDomManager.getSkHubiDetailsByMosnoKaisyouymdNull(syoriCTL.getMosno());
                        if (syoruiCdLst.size() > 0) {
                            miseirijiyuudetailKbn = "02";
                        }
                        else if (C_JimusrhKbn.HORYU.eq(syoriCTL.getJimusrhkbn())
                            && C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {
                            miseirijiyuudetailKbn = "03";
                        }
                        else {
                            miseirijiyuudetailKbn = "05";
                        }
                    }
                }
                if (BizUtil.isBlank(miseirijiyuuKbn)) {
                    throw new BizAppException(MessageId.EBA0023, "申込番号：" + syoriCTL.getMosno());
                }

                BizDate syokaidenymd = sinkeiyakuDomManager.getSkDenpyoDataMinDenymdByMosnoRstuukasyu(
                    syoriCTL.getMosno(), tuukasyu);
                BizDate syokairsymd = syoriCTL.getRyosyuymd();
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(tuukasyu);
                BizCurrency krkdai1kaikeigakuen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency krkdai1kaikeigakugaika = BizCurrency.valueOf(0, currencyType);
                BizCurrency rsgakuen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency rsgakugaika = BizCurrency.valueOf(0, currencyType);
                BizCurrency krkhuho2syoukai = BizCurrency.valueOf(0, currencyType);
                BizCurrency krkhuho2kobetu = BizCurrency.valueOf(0, currencyType);

                DengkByMosnoRstuukasyuBean krkdai1kaidengkBean = skMiseiriJiyuuMeisaiSakuseiDao.getDengkByMosnoRstuukasyuNyksyoriymd(
                    syoriCTL.getMosno(), tuukasyu, kessankimatueigyoubi, kessankimatuYmd);

                if (krkdai1kaidengkBean != null) {

                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {
                        krkdai1kaikeigakuen = krkdai1kaidengkBean.getDenyenkagk();
                        krkdai1kaikeigakugaika = krkdai1kaidengkBean.getDenyenkagk();
                    } else {
                        krkdai1kaikeigakuen = krkdai1kaidengkBean.getDenyenkagk();
                        krkdai1kaikeigakugaika = krkdai1kaidengkBean.getDengaikagk();
                    }
                }

                DengkByMosnoRstuukasyuBean dengkByMosnoRstuukasyuBean = sinkeiyakuDomManager.getDengkByMosnoRstuukasyuRyosyuymd(
                    syoriCTL.getMosno(), tuukasyu, kessankimatuYmd);
                if (dengkByMosnoRstuukasyuBean != null) {
                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {
                        rsgakuen = dengkByMosnoRstuukasyuBean.getDenyenkagk();
                        rsgakugaika = dengkByMosnoRstuukasyuBean.getDenyenkagk();
                    } else {
                        rsgakuen = dengkByMosnoRstuukasyuBean.getDenyenkagk();
                        rsgakugaika = dengkByMosnoRstuukasyuBean.getDengaikagk();
                    }
                }

                DengkByMosnoRstuukasyuBean dengkByMosnoHnkntuukasyuBean = skMiseiriJiyuuMeisaiSakuseiDao.getDengkByMosnoHnkntuukasyuPkakinsyoriymd(
                    syoriCTL.getMosno(), tuukasyu, kessankimatueigyoubi);

                if (dengkByMosnoHnkntuukasyuBean != null) {
                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {
                        rsgakuen = rsgakuen.subtract(dengkByMosnoHnkntuukasyuBean.getDenyenkagk());
                        rsgakugaika = rsgakugaika.subtract(dengkByMosnoHnkntuukasyuBean.getDenyenkagk());
                    } else {
                        rsgakuen = rsgakuen.subtract(dengkByMosnoHnkntuukasyuBean.getDenyenkagk());
                        rsgakugaika = rsgakugaika.subtract(dengkByMosnoHnkntuukasyuBean.getDengaikagk());
                    }
                }

                getRsgakukei.getPkakinsumiRsgaku(syoriCTL, kessankimatueigyoubi.addDays(-1));
                if (!BizUtil.isZero(getRsgakukei.getRsgakukei())) {
                    krkhuho2syoukai = getRsgakukei.getRsgakukei();
                }

                int syoruihubikensuu = 0;
                String[] syoruikbns = new String[10];

                if ("03".equals(miseirijiyuuKbn) && "02".equals(miseirijiyuudetailKbn)) {
                    for (int idx = 0; idx < syoruiCdLst.size(); idx++) {
                        if (idx < 10) {
                            String syoruiCdKbn = C_SyoruiCdKbn.getContentByValue(
                                C_SyoruiCdKbn.PATTERN_KESSANYOUHUBISYORUIHYJ, syoruiCdLst.get(idx).getValue());
                            if (BizUtil.isBlank(syoruiCdKbn)) {
                                syoruikbns[idx] = C_SyoruiCdKbn.SK_SONOTAHUZOKU.getContent("3");
                            }
                            else {
                                syoruikbns[idx] = syoruiCdKbn;
                            }
                        }
                        syoruihubikensuu++;
                    }
                }

                String kyknmkn = "";
                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                    kyknmkn = mosKihon.getHhknnmkn();

                }
                else if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {
                    kyknmkn = mosKihon.getKyknmkn();
                }

                HT_MiseirijiyuuMeisai miseirijiyuuMeisai = new HT_MiseirijiyuuMeisai();

                miseirijiyuuMeisai.setMosno(syoriCTL.getMosno());
                miseirijiyuuMeisai.setSyono(syoriCTL.getSyono());
                miseirijiyuuMeisai.setKyknmkn(kyknmkn);
                miseirijiyuuMeisai.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
                miseirijiyuuMeisai.setKykymd(mosKihon.getKykymd());
                miseirijiyuuMeisai.setMiseirijiyuukbn(miseirijiyuuKbn);
                miseirijiyuuMeisai.setMiseirijiyuudetailkbn(miseirijiyuudetailKbn);
                miseirijiyuuMeisai.setNyuukinjoutaikbn(syoriCTL.getNyuukinjoutaikbn());
                miseirijiyuuMeisai.setSyoruikbn1(syoruikbns[0]);
                miseirijiyuuMeisai.setSyoruikbn2(syoruikbns[1]);
                miseirijiyuuMeisai.setSyoruikbn3(syoruikbns[2]);
                miseirijiyuuMeisai.setSyoruikbn4(syoruikbns[3]);
                miseirijiyuuMeisai.setSyoruikbn5(syoruikbns[4]);
                miseirijiyuuMeisai.setSyoruikbn6(syoruikbns[5]);
                miseirijiyuuMeisai.setSyoruikbn7(syoruikbns[6]);
                miseirijiyuuMeisai.setSyoruikbn8(syoruikbns[7]);
                miseirijiyuuMeisai.setSyoruikbn9(syoruikbns[8]);
                miseirijiyuuMeisai.setSyoruikbn10(syoruikbns[9]);
                miseirijiyuuMeisai.setSyoruihubikensuu(syoruihubikensuu);
                miseirijiyuuMeisai.setSyokaidenymd(syokaidenymd);
                miseirijiyuuMeisai.setSyokairsymd(syokairsymd);
                miseirijiyuuMeisai.setRsgakuen(rsgakuen);
                miseirijiyuuMeisai.setRsgakugaika(rsgakugaika);
                miseirijiyuuMeisai.setRstuukasyu(tuukasyu);
                miseirijiyuuMeisai.setKrkhuho2syoukai(krkhuho2syoukai);
                miseirijiyuuMeisai.setKrkhuho2kobetu(krkhuho2kobetu);
                miseirijiyuuMeisai.setGyoumuKousinsyaId(userId);
                miseirijiyuuMeisai.setGyoumuKousinTime(sysDateTime);
                miseirijiyuuMeisai.setKrkdai1kaikeijyougkyen(krkdai1kaikeigakuen);
                miseirijiyuuMeisai.setKrkdai1kaikeijyougkgaika(krkdai1kaikeigakugaika);
                miseirijiyuuMeisai.setKrkdai1kaituukasyu(tuukasyu);
                miseirijiyuuMeisai.setKyktuukasyu(mosKihon.getKyktuukasyu());

                BizPropertyInitializer.initialize(miseirijiyuuMeisai);

                miseirijiyuuMeisaiIns.add(miseirijiyuuMeisai);

                count++;
            }

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), "未整理事由別明細TBL追加件数"));

    }
}
