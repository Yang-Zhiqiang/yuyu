package yuyu.common.siharai.sicommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.CommonSiwakeUtil;
import yuyu.common.hozen.khcommon.MiKeikaPBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金仕訳共通処理
 */
public class SiCommonSiwake {
    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo baseUserInfo;

    public SiCommonSiwake() {
        super();
    }

    public SiCommonSiwakeKekkaBean exec(SiCommonSiwakeBean pSiCommonSiwakeBean) {

        logger.debug("▽ 保険金給付金仕訳共通処理 開始");
        C_TantouCdKbn tantouCdKbn = null;
        String suitouBumonCdKari = null;
        String suitouBumonCdKasi = null;
        String suitouBumonCdKasiKruk = null;
        C_HuridensksKbn huridensksKbn = null;
        C_DenshrhouKbn denshrhouKbn = null;
        C_Kanjyoukmkcd kanjyoukmkcdKasi = null;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType type = henkanTuuka.henkanTuukaKbnToType(pSiCommonSiwakeBean.getTuukasyu());
        CurrencyType keiyakuType = henkanTuuka.henkanTuukaKbnToType(pSiCommonSiwakeBean.getKeiyakuTuukasyu());

        if (C_InputShrhousiteiKbn.FBSOUKIN.eq(pSiCommonSiwakeBean.getInputShrhousiteiKbn())) {

            tantouCdKbn = C_TantouCdKbn.KAIYAKU;
            suitouBumonCdKasi = C_Tantositucd.SIKINKOUBAIKANRI.getValue();
            suitouBumonCdKasiKruk = C_Tantositucd.HOZENSIHARAISV.getValue();
            huridensksKbn = C_HuridensksKbn.ONLINEFB;
            denshrhouKbn = C_DenshrhouKbn.FBSOUKINYOKU;

            if (pSiCommonSiwakeBean.getSindansyo() != null &&
                BizCurrency.valueOf(new BigDecimal(pSiCommonSiwakeBean.getSindansyo().toString()), type).compareTo(
                    BizCurrency.valueOf(0, type)) > 0){

                suitouBumonCdKari = C_Tantositucd.SIHARAIGYOUMU.getValue();

            } else {
                suitouBumonCdKari = C_Tantositucd.HOZENSIHARAISV.getValue();
            }

            kanjyoukmkcdKasi = getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,pSiCommonSiwakeBean.getTuukasyu(),
                pSiCommonSiwakeBean.getKeiyakuTuukasyu());

        } else if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pSiCommonSiwakeBean.getInputShrhousiteiKbn())){

            tantouCdKbn = C_TantouCdKbn.SIBOUTETUZUKI;
            suitouBumonCdKari = C_Tantositucd.SIHARAIGYOUMU.getValue();
            suitouBumonCdKasi = C_Tantositucd.SIHARAIGYOUMU.getValue();
            suitouBumonCdKasiKruk = C_Tantositucd.SIHARAIGYOUMU.getValue();
            huridensksKbn = C_HuridensksKbn.KOBETU;
            denshrhouKbn = C_DenshrhouKbn.KARIUKERSKARI;

            kanjyoukmkcdKasi = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO;

        } else if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pSiCommonSiwakeBean.getInputShrhousiteiKbn())){

            tantouCdKbn = C_TantouCdKbn.SIBOUTETUZUKI;
            suitouBumonCdKari = C_Tantositucd.SIHARAIGYOUMU.getValue();
            suitouBumonCdKasi = C_Tantositucd.SIHARAIGYOUMU.getValue();
            suitouBumonCdKasiKruk = C_Tantositucd.SIHARAIGYOUMU.getValue();
            huridensksKbn = C_HuridensksKbn.KOBETU;
            denshrhouKbn = C_DenshrhouKbn.KARIUKERSKNASI;

            kanjyoukmkcdKasi = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO;

        } else {
            throw new BizAppException(MessageId.EBA0023, "inputShrhousiteiKbn");
        }

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(tantouCdKbn);
        if (tantouCd == null) {
            throw new BizAppException(MessageId.EBS0004, "BM_TantouCd", "tantouCdKbn", tantouCdKbn.getValue());
        }
        String huriDenatesakiCd = tantouCd.getBusitucd();
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmnetBean = bzSegmentCdSyutoku.exec(pSiCommonSiwakeBean.getSyouhnCd(),
            pSiCommonSiwakeBean.getKeiyakuTuukasyu());
        C_Segcd seg1cd = syouhinbetuSegmnetBean.getSegcd1();
        C_Segcd seg2cd = syouhinbetuSegmnetBean.getSegcd2();
        JM_SiSyouhnZokusei siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(pSiCommonSiwakeBean.getSyouhnCd());
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);
        List<BzSiwakeMeisaiBean> siwakeMeisaiLst = new ArrayList<>();
        BizCurrency keiyakugkKei = BizCurrency.valueOf(0, keiyakuType);
        int taisyakuFlgStiCount = 0;
        Map<C_Kanjyoukmkcd, List<BizCurrency>> kanjyouKamokuBetuSiharaiGakuMp = new HashMap<>();
        C_Kanjyoukmkcd kanjyoukmkcd = null;

        for (SiharaigakuBean siharaigakuBean : pSiCommonSiwakeBean.getSiharaigakuBeanList()) {

            kanjyoukmkcd = getTuukabetuKanjyoukmkcd(siharaigakuBean.getKanjyouKmkCd(),pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu());

            if (!kanjyouKamokuBetuSiharaiGakuMp.containsKey(kanjyoukmkcd)) {
                List<BizCurrency> kingakulist = new ArrayList<>();
                kingakulist.add(BizCurrency.valueOf(new BigDecimal(siharaigakuBean.getSiharaiGk().toString()), type));
                kingakulist.add(BizCurrency.valueOf(new BigDecimal(siharaigakuBean.getKeiyakuGk().toString()), keiyakuType));
                kanjyouKamokuBetuSiharaiGakuMp.put(kanjyoukmkcd,kingakulist);
            }
            else {
                BizCurrency valueSiharaiTemp = kanjyouKamokuBetuSiharaiGakuMp.get(kanjyoukmkcd).get(0);
                BizCurrency valueKeiyakuTemp = kanjyouKamokuBetuSiharaiGakuMp.get(kanjyoukmkcd).get(1);
                List<BizCurrency> addkingakulist = new ArrayList<>();
                addkingakulist.add(valueSiharaiTemp.add(BizCurrency.valueOf(new BigDecimal(siharaigakuBean.getSiharaiGk().toString()), type)));
                addkingakulist.add(valueKeiyakuTemp.add(BizCurrency.valueOf(new BigDecimal(siharaigakuBean.getKeiyakuGk().toString()), keiyakuType)));
                kanjyouKamokuBetuSiharaiGakuMp.put(kanjyoukmkcd,addkingakulist);
            }
        }

        for (Entry<C_Kanjyoukmkcd, List<BizCurrency>> entry : kanjyouKamokuBetuSiharaiGakuMp.entrySet()) {
            BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
            bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            bzSiwakeMeisaiBean.setIbKanjyoukmkcd(entry.getKey());
            bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
            }
            else {
                bzSiwakeMeisaiBean.setIbDengaikagk(entry.getValue().get(0));
            }
            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                bzSiwakeMeisaiBean.setIbDenyenkagk(entry.getValue().get(0));
            }
            else {
                bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, type));
            }
            bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
            bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
            bzSiwakeMeisaiBean.setIbKeiyakutuukagk(entry.getValue().get(1));
            if (taisyakuFlgStiCount == 0) {
                bzSiwakeMeisaiBean.setIbTaisyakutyouseiflg(true);
            }
            siwakeMeisaiLst.add(bzSiwakeMeisaiBean);
            keiyakugkKei = keiyakugkKei.add(entry.getValue().get(1));
            taisyakuFlgStiCount++;
        }
        BizCurrency haitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())) {
            haitoukin = pSiCommonSiwakeBean.getHaitoukin();
        } else {
            haitoukin = pSiCommonSiwakeBean.getYenkaHaitoukin();
        }

        if (haitoukin != null) {
            if (haitoukin.compareTo(BizCurrency.valueOf(0, haitoukin.getType())) > 0) {
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
                    pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu()));
                bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
                bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
                bzSiwakeMeisaiBean.setIbDenyenkagk(haitoukin);
                bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
                bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
                bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0,keiyakuType));
                siwakeMeisaiLst.add(bzSiwakeMeisaiBean);
            }
        }

        CurrencyType currencyType;
        if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
            C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
            currencyType = BizCurrencyTypes.YEN;
        }
        else {

            currencyType =  henkanTuuka.henkanTuukaKbnToType(pSiCommonSiwakeBean.getKeiyakuTuukasyu());
        }

        BizCurrency mikeikapSyonendoSyokaip = BizCurrency.valueOf(0, currencyType);
        BizCurrency mikeikapSyonendo2kaimeikou = BizCurrency.valueOf(0, currencyType);
        BizCurrency mikeikapJinendoikou = BizCurrency.valueOf(0, currencyType);
        BizCurrency sonotaHenrei = BizCurrency.valueOf(0, currencyType);
        BizCurrency zennouKnjukmk = BizCurrency.valueOf(0, currencyType);
        BizCurrency mikeikaPKnjukmk = BizCurrency.valueOf(0, currencyType);

        if (pSiCommonSiwakeBean.getZennouseisank() != null) {
            zennouKnjukmk = pSiCommonSiwakeBean.getZennouseisank();
        }

        if (pSiCommonSiwakeBean.getMikeikap() != null) {
            mikeikaPKnjukmk = pSiCommonSiwakeBean.getMikeikap();
        }

        if (zennouKnjukmk.compareTo(BizCurrency.valueOf(0, zennouKnjukmk.getType())) > 0 ||
            mikeikaPKnjukmk.compareTo(BizCurrency.valueOf(0, mikeikaPKnjukmk.getType())) > 0) {

            CommonSiwakeUtil commonSiwakeUtilKnjukmk = SWAKInjector.getInstance(CommonSiwakeUtil.class);

            MiKeikaPBean[] miKeikaPBeans = null ;

            if (pSiCommonSiwakeBean.getSiDetailMikeikapBeanLst() != null ) {
                if (pSiCommonSiwakeBean.getSiDetailMikeikapBeanLst().size() > 0) {

                    miKeikaPBeans = new MiKeikaPBean[pSiCommonSiwakeBean.getSiDetailMikeikapBeanLst().size()];

                    for (int count = 0 ; count < pSiCommonSiwakeBean.getSiDetailMikeikapBeanLst().size()  ; count++) {

                        SiDetailMikeikapBean siDetailMikeikapBean = pSiCommonSiwakeBean.getSiDetailMikeikapBeanLst().get(count);

                        MiKeikaPBean miKeikaPBean = SWAKInjector.getInstance(MiKeikaPBean.class);
                        miKeikaPBean.setMkeiPNykDenYmd(siDetailMikeikapBean.getDtlmikeikapnykdenymd());
                        miKeikaPBean.setMkeiPHrkKaisuu(siDetailMikeikapBean.getDtlmikeikaphrkkaisuu());
                        miKeikaPBean.setMkeiPJytKaisuuY(siDetailMikeikapBean.getDtlmikeikapjyutoukaisuuy());
                        miKeikaPBean.setMkeiPJytKaisuuM(siDetailMikeikapBean.getDtlmikeikapjyutoukaisuum());
                        miKeikaPBean.setMkeiPJytYm(siDetailMikeikapBean.getDtlmikeikapjyuutouym());

                        if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu()) ||
                            (!C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())
                                && C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()))) {

                            miKeikaPBean.setMiKeikaP(siDetailMikeikapBean.getDtlmikeikap());
                        }
                        else {

                            miKeikaPBean.setMiKeikaP(siDetailMikeikapBean.getDtlmikeikapgaika());
                        }

                        miKeikaPBeans[count] = miKeikaPBean;
                    }
                }
            }

            BizCurrency zennouseisankin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency mikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())) {
                zennouseisankin = pSiCommonSiwakeBean.getZennouseisank();
                mikeikap = pSiCommonSiwakeBean.getMikeikap();
            } else {

                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                    zennouseisankin = pSiCommonSiwakeBean.getYenkaZennouseisank();
                }
                else {
                    zennouseisankin = pSiCommonSiwakeBean.getZennouseisank();
                }
                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn())) {
                    mikeikap = pSiCommonSiwakeBean.getYenkaMikeikap();
                }
                else {
                    mikeikap = pSiCommonSiwakeBean.getMikeikap();
                }
            }

            commonSiwakeUtilKnjukmk.execPKanjokamokuHantei(pSiCommonSiwakeBean.getDenYmd(), pSiCommonSiwakeBean.getKykymd(),
                zennouseisankin, pSiCommonSiwakeBean.getZennouryosyuymd(), pSiCommonSiwakeBean.getNexthrkym(),
                mikeikap, pSiCommonSiwakeBean.getMikeikapJyuutouym(), miKeikaPBeans, null, null,
                pSiCommonSiwakeBean.getHrkkaisuu(), pSiCommonSiwakeBean.getTikiktbrisyuruikbn());

            mikeikapSyonendoSyokaip = commonSiwakeUtilKnjukmk.getTaisyouGkSyonendoSyokaip();
            mikeikapSyonendo2kaimeikou =commonSiwakeUtilKnjukmk.getTaisyouGkSyonendo2kaimeikoup();
            mikeikapJinendoikou =commonSiwakeUtilKnjukmk.getTaisyouGkJinendoikoup();
            sonotaHenrei = commonSiwakeUtilKnjukmk.getTaisyouGkSonotahenreikin();
        }

        if (mikeikapSyonendoSyokaip.compareTo(BizCurrency.valueOf(0, mikeikapSyonendoSyokaip.getType())) > 0) {

            BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
            bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            bzSiwakeMeisaiBean.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY,
                pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu()));
            bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
            }
            else {
                if ( C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                    bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDengaikagk(mikeikapSyonendoSyokaip);
                }
            }
            if ( C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                bzSiwakeMeisaiBean.setIbDenyenkagk(mikeikapSyonendoSyokaip);
            }
            else {
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    bzSiwakeMeisaiBean.setIbDenyenkagk(keisanGaikakanzan.exec(C_Tuukasyu.JPY, mikeikapSyonendoSyokaip,
                        pSiCommonSiwakeBean.getKawaserate(), C_HasuusyoriKbn.AGE));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, type));
                }
            }
            bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
            bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
            bzSiwakeMeisaiBean.setIbKeiyakutuukagk(mikeikapSyonendoSyokaip);
            siwakeMeisaiLst.add(bzSiwakeMeisaiBean);
        }

        if (mikeikapSyonendo2kaimeikou.compareTo(BizCurrency.valueOf(0, mikeikapSyonendo2kaimeikou.getType())) > 0) {

            BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
            bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            bzSiwakeMeisaiBean.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY,
                pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu()));
            bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
            }
            else {
                if ( C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                    bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDengaikagk(mikeikapSyonendo2kaimeikou);
                }
            }

            if ( C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                bzSiwakeMeisaiBean.setIbDenyenkagk(mikeikapSyonendo2kaimeikou);
            }
            else {
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    bzSiwakeMeisaiBean.setIbDenyenkagk(keisanGaikakanzan.exec(C_Tuukasyu.JPY, mikeikapSyonendo2kaimeikou,
                        pSiCommonSiwakeBean.getKawaserate(), C_HasuusyoriKbn.AGE));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, type));
                }
            }

            bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
            bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
            bzSiwakeMeisaiBean.setIbKeiyakutuukagk(mikeikapSyonendo2kaimeikou);
            siwakeMeisaiLst.add(bzSiwakeMeisaiBean);

        }

        if (mikeikapJinendoikou.compareTo(BizCurrency.valueOf(0, mikeikapJinendoikou.getType())) > 0) {

            BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
            bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            bzSiwakeMeisaiBean.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
                pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu()));
            bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);

            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
            }
            else {
                if ( C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                    bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDengaikagk(mikeikapJinendoikou);
                }
            }

            if ( C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                bzSiwakeMeisaiBean.setIbDenyenkagk(mikeikapJinendoikou);
            }
            else {
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    bzSiwakeMeisaiBean.setIbDenyenkagk(keisanGaikakanzan.exec(C_Tuukasyu.JPY, mikeikapJinendoikou,
                        pSiCommonSiwakeBean.getKawaserate(), C_HasuusyoriKbn.AGE));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, type));
                }
            }
            bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
            bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
            bzSiwakeMeisaiBean.setIbKeiyakutuukagk(mikeikapJinendoikou);
            siwakeMeisaiLst.add(bzSiwakeMeisaiBean);

        }

        BizCurrency kariukekin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())) {
            kariukekin = pSiCommonSiwakeBean.getKrkgk();
        } else {
            kariukekin = pSiCommonSiwakeBean.getYenkaKrkgk();
        }

        if (kariukekin != null) {
            if (kariukekin.compareTo(BizCurrency.valueOf(0, kariukekin.getType())) > 0) {

                BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())) {
                    bzSiwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU);
                }
                else {
                    bzSiwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY);
                }
                bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
                bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
                bzSiwakeMeisaiBean.setIbDenyenkagk(kariukekin);
                bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
                bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
                bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0,keiyakuType));
                siwakeMeisaiLst.add(bzSiwakeMeisaiBean);
            }
        }

        boolean gaikaShrKariukekinFlg = false;

        if (!C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu()) &&
            pSiCommonSiwakeBean.getKrkgk() != null) {
            if (pSiCommonSiwakeBean.getKrkgk().compareTo(BizCurrency.valueOf(0, pSiCommonSiwakeBean.getKrkgk().getType())) > 0) {

                BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
                    pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu()));
                bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
                bzSiwakeMeisaiBean.setIbDengaikagk(pSiCommonSiwakeBean.getKrkgk());
                bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, type));
                bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
                bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
                bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0,keiyakuType));
                siwakeMeisaiLst.add(bzSiwakeMeisaiBean);

                gaikaShrKariukekinFlg = true;
            }
        }

        boolean azukarikinFlg = false;

        if (pSiCommonSiwakeBean.getAzukarikingk() != null) {
            if (pSiCommonSiwakeBean.getAzukarikingk().compareTo(
                BizCurrency.valueOf(0, pSiCommonSiwakeBean.getAzukarikingk().getType())) > 0) {
                azukarikinFlg = true;
            }
        }

        if (azukarikinFlg ||
            sonotaHenrei.compareTo(BizCurrency.valueOf(0, sonotaHenrei.getType())) > 0) {

            BizCurrency sonotaHnrKeiyakuTuuka = BizCurrency.valueOf(0, keiyakuType);
            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())) {
                if (pSiCommonSiwakeBean.getAzukarikingk() != null) {
                    sonotaHnrKeiyakuTuuka = pSiCommonSiwakeBean.getAzukarikingk().add(sonotaHenrei);
                } else {
                    sonotaHnrKeiyakuTuuka = sonotaHenrei;
                }
            }
            else {
                if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                    BizCurrency sonotaHnrGaikakanzangk = BizCurrency.valueOf(0, keiyakuType);
                    BizCurrency gaikaKnsnTKgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                    if (pSiCommonSiwakeBean.getZitkAzukarikingkYen() != null) {
                        gaikaKnsnTKgk = gaikaKnsnTKgk.add(pSiCommonSiwakeBean.getZitkAzukarikingkYen());
                    }

                    if (sonotaHenrei.compareTo(BizCurrency.valueOf(0, sonotaHenrei.getType())) > 0) {
                        gaikaKnsnTKgk = gaikaKnsnTKgk.add(sonotaHenrei);
                    }

                    if (gaikaKnsnTKgk.compareTo(BizCurrency.valueOf(0, gaikaKnsnTKgk.getType())) > 0) {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        sonotaHnrGaikakanzangk = keisanGaikakanzan.execDivide(
                            pSiCommonSiwakeBean.getKeiyakuTuukasyu(), gaikaKnsnTKgk,
                            pSiCommonSiwakeBean.getGaikaknsnKwsrate(), C_HasuusyoriKbn.AGE);
                    }

                    if (pSiCommonSiwakeBean.getZitkAzukarikingkSiteituuka() != null) {
                        sonotaHnrKeiyakuTuuka = pSiCommonSiwakeBean.getZitkAzukarikingkSiteituuka().add(
                            sonotaHnrGaikakanzangk);
                    } else {
                        sonotaHnrKeiyakuTuuka = sonotaHnrGaikakanzangk;
                    }

                }
                else {
                    if (pSiCommonSiwakeBean.getAzukarikingk() != null) {
                        sonotaHnrKeiyakuTuuka = pSiCommonSiwakeBean.getAzukarikingk().add(sonotaHenrei);
                    } else {
                        sonotaHnrKeiyakuTuuka = sonotaHenrei;
                    }
                }

            }

            BizCurrency gaikaDenpyoKngkSonotaHnr = BizCurrency.valueOf(0, type);
            BizCurrency yankaDenpyoKngkSonotaHnr = BizCurrency.valueOf(0, type);

            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())) {
                    yankaDenpyoKngkSonotaHnr = sonotaHnrKeiyakuTuuka;
                }
                else {
                    BizCurrency sonotaHenreienka;
                    if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                        C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                        sonotaHenreienka = sonotaHenrei;
                    }
                    else {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        sonotaHenreienka = keisanGaikakanzan.exec(C_Tuukasyu.JPY, sonotaHenrei,
                            pSiCommonSiwakeBean.getKawaserate(), C_HasuusyoriKbn.AGE);
                    }
                    if (pSiCommonSiwakeBean.getYenkaAzukarikingk() != null) {
                        yankaDenpyoKngkSonotaHnr = pSiCommonSiwakeBean.getYenkaAzukarikingk().add(sonotaHenreienka);
                    }
                    else {
                        yankaDenpyoKngkSonotaHnr = sonotaHenreienka;
                    }
                }
            } else {
                gaikaDenpyoKngkSonotaHnr = sonotaHnrKeiyakuTuuka;
            }

            BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
            bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            bzSiwakeMeisaiBean.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
                pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu()));
            bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
            bzSiwakeMeisaiBean.setIbDengaikagk(gaikaDenpyoKngkSonotaHnr);
            bzSiwakeMeisaiBean.setIbDenyenkagk(yankaDenpyoKngkSonotaHnr);
            bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
            bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
            bzSiwakeMeisaiBean.setIbKeiyakutuukagk(sonotaHnrKeiyakuTuuka);

            siwakeMeisaiLst.add(bzSiwakeMeisaiBean);
        }

        if (pSiCommonSiwakeBean.getSindansyo() != null) {
            if (BizCurrency.valueOf(new BigDecimal(pSiCommonSiwakeBean.getSindansyo().toString()), type).compareTo(
                BizCurrency.valueOf(0, type)) > 0) {
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                bzSiwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
                bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
                bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
                bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(new BigDecimal(pSiCommonSiwakeBean
                    .getSindansyo().toString()), type));
                bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
                bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
                bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0,keiyakuType));
                siwakeMeisaiLst.add(bzSiwakeMeisaiBean);
            }
        }
        if (pSiCommonSiwakeBean.getShrtienRsk() != null) {
            if (BizCurrency.valueOf(new BigDecimal(pSiCommonSiwakeBean.getShrtienRsk().toString()), type).compareTo(
                BizCurrency.valueOf(0, type)) > 0) {
                BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
                bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);

                C_Kanjyoukmkcd daikanjokamokucd = null;
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())){
                    daikanjokamokucd = C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU;
                } else {
                    daikanjokamokucd = C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY;
                }
                bzSiwakeMeisaiBean.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(daikanjokamokucd,pSiCommonSiwakeBean.getTuukasyu(),
                    pSiCommonSiwakeBean.getKeiyakuTuukasyu()));

                bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKari);
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                    bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(new BigDecimal(pSiCommonSiwakeBean
                        .getShrtienRsk().toString()), type));
                }
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                    bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(new BigDecimal(pSiCommonSiwakeBean
                        .getShrtienRsk().toString()), type));
                }
                else {
                    bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, type));
                }
                bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
                bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
                if (pSiCommonSiwakeBean.getKeiyakuShrtienRsk() != null) {
                    bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(new BigDecimal(pSiCommonSiwakeBean
                        .getKeiyakuShrtienRsk().toString()), keiyakuType));
                } else {
                    bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0, keiyakuType));
                }
                siwakeMeisaiLst.add(bzSiwakeMeisaiBean);
            }
        }
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
        bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean.setIbKanjyoukmkcd(kanjyoukmkcdKasi);
        bzSiwakeMeisaiBean.setIbSuitoubumoncd(suitouBumonCdKasi);
        if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
            bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0, type));
        }
        else {
            bzSiwakeMeisaiBean.setIbDengaikagk(pSiCommonSiwakeBean.getShrgkkei());
        }
        if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {

            if (pSiCommonSiwakeBean.getShrgkkei() != null && pSiCommonSiwakeBean.getSindansyo() != null) {
                bzSiwakeMeisaiBean.setIbDenyenkagk(pSiCommonSiwakeBean.getShrgkkei().add(pSiCommonSiwakeBean.getSindansyo()));
            }
            else if (pSiCommonSiwakeBean.getShrgkkei() != null && pSiCommonSiwakeBean.getSindansyo() == null) {
                bzSiwakeMeisaiBean.setIbDenyenkagk(pSiCommonSiwakeBean.getShrgkkei());
            }
            else if (pSiCommonSiwakeBean.getShrgkkei() == null && pSiCommonSiwakeBean.getSindansyo() != null) {
                bzSiwakeMeisaiBean.setIbDenyenkagk(pSiCommonSiwakeBean.getSindansyo());
            }
        }
        else {
            bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0, type));
        }
        bzSiwakeMeisaiBean.setIbSeg1cd(seg1cd);
        bzSiwakeMeisaiBean.setIbSeg2cd(seg2cd);
        if (C_UmuKbn.ARI.eq(pSiCommonSiwakeBean.getItijibrumu())) {
            if (pSiCommonSiwakeBean.getKeiyakuShrtienRsk() != null) {
                bzSiwakeMeisaiBean.setIbKeiyakutuukagk(keiyakugkKei.add(pSiCommonSiwakeBean.getKeiyakuShrtienRsk()));
            } else {
                bzSiwakeMeisaiBean.setIbKeiyakutuukagk(keiyakugkKei);
            }
        }
        else {
            bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0, keiyakuType));
        }

        siwakeMeisaiLst.add(bzSiwakeMeisaiBean);

        boolean misyuupFlg = false;

        if (pSiCommonSiwakeBean.getMisyuup() != null) {
            if (pSiCommonSiwakeBean.getMisyuup().compareTo(
                BizCurrency.valueOf(0, pSiCommonSiwakeBean.getMisyuup().getType())) > 0) {

                misyuupFlg = true;
            }
        }

        if (gaikaShrKariukekinFlg || misyuupFlg) {

            BizCurrency gaikaDenpyoKariukekin = BizCurrency.valueOf(0, type);
            BizCurrency yenkaDenpyoKariukekin = BizCurrency.valueOf(0, type);

            if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu())) {
                if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getKeiyakuTuukasyu())) {
                    yenkaDenpyoKariukekin = pSiCommonSiwakeBean.getMisyuup();
                }
                else {
                    BizCurrency yenkaMisyuup = BizCurrency.valueOf(0, type);

                    for (SiDetailMisyuupBean siDetailMisyuupBean : pSiCommonSiwakeBean.getSiDetailMisyuupBeanLst()) {
                        yenkaMisyuup = yenkaMisyuup.add(siDetailMisyuupBean.getDtlmisyuupgaikayenkingk());
                    }

                    yenkaDenpyoKariukekin = yenkaMisyuup;
                }

            } else {
                if (pSiCommonSiwakeBean.getMisyuup() != null) {

                    gaikaDenpyoKariukekin = pSiCommonSiwakeBean.getMisyuup().add(pSiCommonSiwakeBean.getKrkgk());

                } else {

                    gaikaDenpyoKariukekin = pSiCommonSiwakeBean.getKrkgk();
                }
            }

            BzSiwakeMeisaiBean bzSiwakeMeisaiBeanKruk = SWAKInjector.getInstance(BzSiwakeMeisaiBean.class);
            bzSiwakeMeisaiBeanKruk.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            bzSiwakeMeisaiBeanKruk.setIbKanjyoukmkcd(getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
                pSiCommonSiwakeBean.getTuukasyu(), pSiCommonSiwakeBean.getKeiyakuTuukasyu()));
            bzSiwakeMeisaiBeanKruk.setIbSuitoubumoncd(suitouBumonCdKasiKruk);
            bzSiwakeMeisaiBeanKruk.setIbDengaikagk(gaikaDenpyoKariukekin);
            bzSiwakeMeisaiBeanKruk.setIbDenyenkagk(yenkaDenpyoKariukekin);
            bzSiwakeMeisaiBeanKruk.setIbSeg1cd(seg1cd);
            bzSiwakeMeisaiBeanKruk.setIbSeg2cd(seg2cd);
            bzSiwakeMeisaiBeanKruk.setIbKeiyakutuukagk(BizCurrency.valueOf(0,keiyakuType));
            siwakeMeisaiLst.add(bzSiwakeMeisaiBeanKruk);
        }

        if (C_Tuukasyu.JPY.eq(pSiCommonSiwakeBean.getTuukasyu()) && C_UmuKbn.NONE.eq(pSiCommonSiwakeBean.getItijibrumu())) {
            CommonSiwakeUtil commonSiwakeUtilTaisyaku = SWAKInjector.getInstance(CommonSiwakeUtil.class);

            siwakeMeisaiLst = commonSiwakeUtilTaisyaku.execTaisyakuTyousei(pSiCommonSiwakeBean.getTuukasyu(), siwakeMeisaiLst);
        }

        bzDenpyouDataTourokuBean.setIbSyono(pSiCommonSiwakeBean.getSyoNo());
        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(huriDenatesakiCd);
        bzDenpyouDataTourokuBean.setIbTantocd(tantouCdKbn);
        bzDenpyouDataTourokuBean.setIbDenymd(pSiCommonSiwakeBean.getDenYmd());
        bzDenpyouDataTourokuBean.setIbTuukasyu(pSiCommonSiwakeBean.getTuukasyu());
        bzDenpyouDataTourokuBean.setIbHuridenskskbn(huridensksKbn);
        bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bzDenpyouDataTourokuBean.setIbDenshrhoukbn(denshrhouKbn);
        bzDenpyouDataTourokuBean.setIbSyoriymd(pSiCommonSiwakeBean.getSyoriYmd());
        bzDenpyouDataTourokuBean.setIbSyoricd(pSiCommonSiwakeBean.getSyoriCd());
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(pSiCommonSiwakeBean.getSyoriSosikiCd());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(baseUserInfo.getUserId());
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(pSiCommonSiwakeBean.getKakoKawaserateShiteiFlg());
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(pSiCommonSiwakeBean.getKakoKawaserateShiteiYmd());
        bzDenpyouDataTourokuBean.setIbKyktuukasyu(pSiCommonSiwakeBean.getKeiyakuTuukasyu());
        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(siwakeMeisaiLst);
        bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(pSiCommonSiwakeBean.getShrhousiteiKbn());
        bzDenpyouDataTourokuBean.setIbSyouhncd(pSiCommonSiwakeBean.getSyouhnCd());
        bzDenpyouDataTourokuBean.setIbSyouhnsdno(pSiCommonSiwakeBean.getSyouhnsdNo());

        SiCommonSiwakeKekkaBean siCommonSiwakeKekkaBean = SWAKInjector.getInstance(SiCommonSiwakeKekkaBean.class);
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        List<JT_SiDenpyoData> siDenpyoDataLst = bzDenpyouDataSks.execSi(bzDenpyouDataTourokuBean);
        int edaNo = bzDenpyouDataSks.getEdano();
        siCommonSiwakeKekkaBean.setSiDenpyoDataLst(siDenpyoDataLst);
        siCommonSiwakeKekkaBean.setFbSoukinEdaNo(edaNo);
        logger.debug("△ 保険金給付金仕訳共通処理 終了");
        return siCommonSiwakeKekkaBean;
    }

    private C_Kanjyoukmkcd getTuukabetuKanjyoukmkcd(C_Kanjyoukmkcd pKanjoukmkcd, C_Tuukasyu pTuukasyu, C_Tuukasyu pKykTuukasyu){

        C_Kanjyoukmkcd kanjyoukmkcd = pKanjoukmkcd;

        if (C_Tuukasyu.JPY.eq(pKykTuukasyu)){

            if (C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU;

            } else if (C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.SYAINHAITOUKIN_HUTUU;

            }
            else if (C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.SIBOUHOKENKIN_HUTUU;

            }
            else if (C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU;

            }
            else if (C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU;

            }
            else if (C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU;

            }
            else if (C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU;

            }
            else if (C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY.eq(pKanjoukmkcd)){

                kanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU;

            }

        } else {
            if (C_Tuukasyu.USD.eq(pTuukasyu)){

                if (C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN;

                } else if (C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD;

                } else if (C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD;

                }

            } else if (C_Tuukasyu.AUD.eq(pTuukasyu)){

                if (C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN;

                } else if (C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD;

                } else if (C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY.eq(pKanjoukmkcd)){

                    kanjyoukmkcd = C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD;
                }
            }
        }
        return kanjyoukmkcd;
    }

}
