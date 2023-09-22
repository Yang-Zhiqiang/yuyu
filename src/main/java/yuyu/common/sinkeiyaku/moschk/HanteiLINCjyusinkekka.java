package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_LincSyoukaiSyubetuKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LinchhknseiKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_KnksateiRireki;

/**
 * 新契約 申込内容チェック ＬＩＮＣ受信結果判定
 */
public class HanteiLINCjyusinkekka {

    private final static int LINCKESSAIKEKKA_MIHANTEI = 0;

    private final static int LINCKESSAIKEKKA_HUYOU = 1;

    private final static int LINCKESSAIKEKKA_JIDOUKAIJYO = 2;

    private final static int LINCKESSAIKEKKA_HANDOYOU = 3;

    public static final BizCurrency ISENMANEN = BizCurrency.valueOf(10000000, BizCurrencyTypes.YEN);

    public static final BizCurrency SICHISENGOHIYAKUMEN = BizCurrency.valueOf(75000000, BizCurrencyTypes.YEN);

    public static final BizCurrency MENNISENDOHIYAKUMEN = BizCurrency.valueOf(125000000, BizCurrencyTypes.YEN);

    public static final BizCurrency MENSICHISENDOHIYAKUMEN = BizCurrency.valueOf(175000000, BizCurrencyTypes.YEN);

    public static final BizCurrency NIMENGOSENMEN = BizCurrency.valueOf(250000000, BizCurrencyTypes.YEN);

    private final static String KANKYOUSATEICOMMENT = "ＬＩＮＣ照会結果が他社加入ありのため環境査定（２次Ａ）が必要です。";

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public HanteiLINCjyusinkekka() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ ＬＩＮＣ受信結果判定 開始");
        }
        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn()) || !C_LincjkKbn.HANEIMATI.eq(syoriCTL.getLincjkkbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ ＬＩＮＣ受信結果判定 終了（対象外）");
            }
            return;
        }
        HT_SkLincJyusinData skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno(mosNo);
        if (skLincJyusinData == null) {
            throw new CommonBizAppException("新契約ＬＩＮＣ受信データ（申込回答）異常 申込番号：" + mosNo);
        }
        int linckessaikekka = LINCKESSAIKEKKA_MIHANTEI;
        List<HT_SkLincJyusinData> skLincJyusinDatanayoseList = new ArrayList<>();
        if (skLincJyusinData.getLincnayoserecordsuu() == 0) {
            linckessaikekka = LINCKESSAIKEKKA_HUYOU;
        }
        else {
            skLincJyusinDatanayoseList = sinkeiyakuDomManager.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(
                skLincJyusinData.getSyoriYmd(), skLincJyusinData.getLinckyknaiykekdatarenno());
            if (skLincJyusinDatanayoseList == null || skLincJyusinDatanayoseList.size() == 0) {
                throw new CommonBizAppException("新契約ＬＩＮＣ受信データ（名寄せ）異常 申込番号：" + mosNo);
            }
            linckessaikekka = hanteitasyakanyuuari(pMP, skLincJyusinData, skLincJyusinDatanayoseList);
        }

        if (linckessaikekka == LINCKESSAIKEKKA_MIHANTEI) {
            for (HT_SkLincJyusinData skLincJyusinDatanayose : skLincJyusinDatanayoseList) {
                skLincJyusinDatanayose.noCheckDetach();
            }
            if (logger.isDebugEnabled()) {
                logger.debug("△ ＬＩＮＣ受信結果判定 終了（未判定）");

            }
            return;
        }
        if (linckessaikekka == LINCKESSAIKEKKA_HUYOU) {
            syoriCTL.setLincjkkbn(C_LincjkKbn.KAITOARI_TASYANASI);
        }
        else {
            syoriCTL.setLincjkkbn(C_LincjkKbn.KAITOARI_TASYAARI);
        }
        if (linckessaikekka == LINCKESSAIKEKKA_HANDOYOU) {
            syoriCTL.setLinckknnjkkbn(C_LinckknnjkKbn.KAKUNINMATI);

        }
        else if (linckessaikekka == LINCKESSAIKEKKA_JIDOUKAIJYO) {
            syoriCTL.setLinckknnjkkbn(C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("｜  ▽MP．処理コントロールTBL設定値");
            logger.debug("｜  ｜ＬＩＮＣ状況区分=" + syoriCTL.getLincjkkbn());
            logger.debug("｜  ｜ＬＩＮＣ確認状況区分=" + syoriCTL.getLinckknnjkkbn());
        }
        if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(syoriCTL.getLincgthtkekkbn())
            && linckessaikekka == LINCKESSAIKEKKA_HANDOYOU) {
            syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
            if (logger.isDebugEnabled()) {
                logger.debug("｜  ｜決定状態区分=" + syoriCTL.getKetteikbn());
            }
            if (C_KnkysateijyouKbn.NONE.eq(syoriCTL.getKnkysateijyoukbn())
                || C_KnkysateijyouKbn.SATEIZUMI.eq(syoriCTL.getKnkysateijyoukbn())) {
                syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2A);
                syoriCTL.setKnkysateirrkumu(C_UmuKbn.ARI);
                if (logger.isDebugEnabled()) {
                    logger.debug("｜  ｜環境査定状態区分=" + syoriCTL.getKnkysateijyoukbn());
                    logger.debug("｜  ｜環境査定履歴有無=" + syoriCTL.getKnkysateirrkumu());
                }
                List<HT_KnksateiRireki> knksateiRirekiList = syoriCTL.getKnksateiRirekis();
                int renno = 1;
                if (knksateiRirekiList != null && knksateiRirekiList.size() > 0) {
                    SortHT_KnksateiRireki knksateiRirekiSort = SWAKInjector.getInstance(SortHT_KnksateiRireki.class);
                    knksateiRirekiList = knksateiRirekiSort.OrderHT_KnksateiRirekiByPkDesc(knksateiRirekiList);
                    renno = knksateiRirekiList.get(0).getRenno() + 1;
                }
                HT_KnksateiRireki knksateiRirekiInsert = syoriCTL.createKnksateiRireki();
                knksateiRirekiInsert.setRenno(renno);
                knksateiRirekiInsert.setSyoriYmd(pMP.getSysDate());
                knksateiRirekiInsert.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.LINCKKA);
                knksateiRirekiInsert.setKnksateikekkakbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2A);
                knksateiRirekiInsert.setKnksateicomment(EditSecurityKm.getEncodeData(syoriCTL.getMosno(), KANKYOUSATEICOMMENT));
                knksateiRirekiInsert.setGyoumuKousinsyaId(pMP.getKosID());
                knksateiRirekiInsert.setGyoumuKousinTime(pMP.getKosTime());
                BizPropertyInitializer.initialize(knksateiRirekiInsert);
            }
        }

        HT_SkLincTourokuInfo skLincTourokuInfo = syoriCTL.getSkLincTourokuInfo();

        skLincTourokuInfo.setKanyuusyano(skLincJyusinData.getLinckanyuusyano());

        skLincJyusinData.noCheckDetach();

        if (linckessaikekka != LINCKESSAIKEKKA_HUYOU) {
            String lincjyusinTRrenno = BizDate.getSysDateTimeMilli();
            Integer renno = 0;
            for (HT_SkLincJyusinData skLincJyusinDatanayose : skLincJyusinDatanayoseList) {
                C_LinchhknseiKbn hhknsei = C_LinchhknseiKbn.BLNK;
                if (skLincJyusinDatanayose.getLinchhknsei() == 1) {
                    hhknsei = C_LinchhknseiKbn.MALE;
                }
                else if (skLincJyusinDatanayose.getLinchhknsei() == 2) {
                    hhknsei = C_LinchhknseiKbn.FEMALE;
                }
                else if (skLincJyusinDatanayose.getLinchhknsei() == 3) {
                    hhknsei = C_LinchhknseiKbn.SYUSSEIMAE;
                }
                renno = renno + 1;
                HT_SkLincSyoukaikekka skLincSyoukaikekka = syoriCTL.createSkLincSyoukaikekka();
                skLincSyoukaikekka.setLincjyusintrrenno(lincjyusinTRrenno);
                skLincSyoukaikekka.setRenno(renno);
                skLincSyoukaikekka.setLincsousinmotokaisya(skLincJyusinDatanayose.getLincsousinmotokaisya());
                skLincSyoukaikekka.setKykkbn(skLincJyusinDatanayose.getLinckeihidjnhyouji());
                skLincSyoukaikekka.setKyknmlinckn(skLincJyusinDatanayose.getLinckyknmkn());
                skLincSyoukaikekka.setKyknmlinckj(skLincJyusinDatanayose.getLinckyknmkj());
                skLincSyoukaikekka.setHhknnmlinckn(skLincJyusinDatanayose.getLinchhknnmkn());
                skLincSyoukaikekka.setHhknnmlinckj(skLincJyusinDatanayose.getLinchhknnmkj());
                skLincSyoukaikekka.setLinchhknseikbn(hhknsei);
                skLincSyoukaikekka.setHhknseiymd(skLincJyusinDatanayose.getLinchhknseiymd());
                skLincSyoukaikekka.setHhknadrlinckn30(skLincJyusinDatanayose.getLinchhknadrkn());
                skLincSyoukaikekka.setKeiyakuymd(skLincJyusinDatanayose.getLinckykymd());
                skLincSyoukaikekka.setTrkmousideymd(skLincJyusinDatanayose.getLinctrkmousideymd());
                skLincSyoukaikekka.setSgnyung(skLincJyusinDatanayose.getLincsgnyukyhng());
                skLincSyoukaikekka.setSipnyung(skLincJyusinDatanayose.getLincsipnyukyhng());
                skLincSyoukaikekka.setSjnyung(skLincJyusinDatanayose.getLincsjnyukyhng());
                skLincSyoukaikekka.setSonotanyuinng(skLincJyusinDatanayose.getLincsonotanyukyhng());
                skLincSyoukaikekka.setHutuusb(skLincJyusinDatanayose.getLinchutuusbs());
                skLincSyoukaikekka.setSgsbksns(skLincJyusinDatanayose.getLincsgsbksns());
                skLincSyoukaikekka.setKanyuusyano(skLincJyusinDatanayose.getLinckanyuusyano());
                skLincSyoukaikekka.setLinckykkanrino(skLincJyusinDatanayose.getLinckykkanrino());
                skLincSyoukaikekka.setLincsyoukaisyubetu(C_LincSyoukaiSyubetuKbn.HOKENKIN);
                skLincSyoukaikekka.setGyoumuKousinsyaId(pMP.getKosID());
                skLincSyoukaikekka.setGyoumuKousinTime(pMP.getKosTime());
                BizPropertyInitializer.initialize(skLincSyoukaikekka);
            }
        }
        if (skLincJyusinDatanayoseList != null) {
            for (HT_SkLincJyusinData skLincJyusinDatanayose : skLincJyusinDatanayoseList) {
                skLincJyusinDatanayose.noCheckDetach();
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("｜  △");
            logger.debug("△ ＬＩＮＣ受信結果判定 終了");
        }
    }

    private int hanteitasyakanyuuari(MosnaiCheckParam pMosnaiCheckParam, HT_SkLincJyusinData pSkLincJyusinData,
        List<HT_SkLincJyusinData> pSkLincJyusinDataList) {
        if (C_UmuKbn.NONE.eq(pMosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou())
            || C_UmuKbn.NONE.eq(pMosnaiCheckParam.getCheckspJissiUmuKbnSeijyou())) {
            return LINCKESSAIKEKKA_MIHANTEI;
        }
        if (pSkLincJyusinData.getLincrecordsyubetu() == 50 || pSkLincJyusinData.getLincmousideflg() == 1
            || pSkLincJyusinData.getLincjgyhknflg() == 1) {
            return LINCKESSAIKEKKA_HANDOYOU;
        }
        HT_SyoriCTL syoriCTL = pMosnaiCheckParam.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (C_Kyksei.HJNKYK.eq(mosKihon.getKyksei())
            || BizUtil.isBlank(mosKihon.getHhknsykgycd())
            || mosKihon.getHhknsykgycd().equals("910")
            || mosKihon.getHhknsykgycd().equals("930")
            || C_NensyuuKbn.BLNK.eq(mosKihon.getHhknnensyuukbn())) {
            return LINCKESSAIKEKKA_HANDOYOU;
        }
        BizCurrency tousytasytsnshkkn = BizCurrency.valueOf(0);
        BizCurrency tasysaigaisbhknkngkgoukei = BizCurrency.valueOf(0);
        BizDate halfyearhanteihikakubi = null;
        BizDate halfyearhanteikijunbi = syoriCTL.getMosnrkymd().addMonths(-6).getRekijyou();
        List<String> tasyazenkilist = new ArrayList<String>();
        List<String> tasyahalfyearlist = new ArrayList<String>();
        for (HT_SkLincJyusinData skLincJyusinData : pSkLincJyusinDataList) {
            if (skLincJyusinData.getLincrecordsyubetu()==37
                || skLincJyusinData.getLincmousideflg() == 1) {
                return LINCKESSAIKEKKA_HANDOYOU;
            }
            if (skLincJyusinData.getLincjgyhknflg() != 1) {

                tousytasytsnshkkn = tousytasytsnshkkn.add(skLincJyusinData.getLinchutuusbs());

            }
            tasysaigaisbhknkngkgoukei = tasysaigaisbhknkngkgoukei.add(skLincJyusinData.getLincsgsbksns());

            halfyearhanteihikakubi = skLincJyusinData.getLinctrkmousideymd();

            if (BizDateUtil.compareYmd(skLincJyusinData.getLinctrkmousideymd(),
                skLincJyusinData.getLinckykymd()) == BizDateUtil.COMPARE_LESSER) {
                halfyearhanteihikakubi = skLincJyusinData.getLinckykymd();
            }

            if (!tasyazenkilist.contains(skLincJyusinData.getLincsousinmotokaisya())) {
                tasyazenkilist.add(skLincJyusinData.getLincsousinmotokaisya());
            }
            if ((BizDateUtil.compareYmd(halfyearhanteikijunbi, halfyearhanteihikakubi) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(halfyearhanteikijunbi, halfyearhanteihikakubi) == BizDateUtil.COMPARE_EQUAL)
                && !tasyahalfyearlist.contains(skLincJyusinData.getLincsousinmotokaisya())) {
                tasyahalfyearlist.add(skLincJyusinData.getLincsousinmotokaisya());
            }
        }
        if (tasyahalfyearlist.size() > 1 || tasyazenkilist.size() > 2) {

            return LINCKESSAIKEKKA_HANDOYOU;
        }
        Tuusan tuusan = pMosnaiCheckParam.getTuusan();
        tousytasytsnshkkn = tousytasytsnshkkn.add(tuusan.getTuusanKetteiSouSouSibouS());
        if (mosKihon.getHhknnen() <= 14 && (tousytasytsnshkkn.add(tasysaigaisbhknkngkgoukei)).compareTo(ISENMANEN) <= 0) {

            return LINCKESSAIKEKKA_JIDOUKAIJYO;
        }
        if (mosKihon.getHhknnen() < 20) {

            return LINCKESSAIKEKKA_HANDOYOU;
        }
        if ((C_NensyuuKbn.UNDER300.eq(mosKihon.getHhknnensyuukbn()) && tousytasytsnshkkn.compareTo(SICHISENGOHIYAKUMEN) < 0) ||
            (C_NensyuuKbn.UNDER500.eq(mosKihon.getHhknnensyuukbn()) && tousytasytsnshkkn.compareTo(MENNISENDOHIYAKUMEN) < 0) ||
            (C_NensyuuKbn.UNDER700.eq(mosKihon.getHhknnensyuukbn()) && tousytasytsnshkkn.compareTo(MENSICHISENDOHIYAKUMEN) < 0) ||
            (C_NensyuuKbn.UNDER1000.eq(mosKihon.getHhknnensyuukbn()) && tousytasytsnshkkn.compareTo(NIMENGOSENMEN) < 0)||
            (C_NensyuuKbn.MORETHAN1000.eq(mosKihon.getHhknnensyuukbn()) && tousytasytsnshkkn.compareTo(NIMENGOSENMEN) < 0)) {

            return LINCKESSAIKEKKA_JIDOUKAIJYO;
        }
        return LINCKESSAIKEKKA_HANDOYOU;
    }
}
