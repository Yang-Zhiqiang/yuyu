package yuyu.batch.hozen.khinterf.khseihowebdrtensikkoudtlfsks;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khseihowebdrtensikkoudtlfsks.dba.KhSeihowebDrtenSikkouDtlFSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス 生保Ｗｅｂ代理店失効契約明細Ｆ作成
 */
public class KhSeihowebDrtenSikkouDtlFSksBatch implements Batch {

    private static String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSeihowebDrtenSikkouDtlFSksDao khSeihowebDrtenSikkouDtlFSksDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long kensuu = 0;
        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        BizDateYM syoriYM = syoriYmd.getBizDateYM();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobcd));

        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector
            .getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);

        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(10);

        try (
            ExDBResults<IT_KykKihon> kykKihonList = khSeihowebDrtenSikkouDtlFSksDao.getKykkhnTblEntityListBySyoriYm(kakutyoujobcd, syoriYM);
            EntityInserter<ZT_DrtenSkKykDtlSyokaiTy> drtenSkKykDtlSyokaiTyEntityInserter = new EntityInserter<>();) {

            for (IT_KykKihon kykKihon : kykKihonList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykKihon.getSyono());

                IT_PMinyuuSyoumetuInfo pMinyuuSyoumetuInfo = kykKihon.getPMinyuuSyoumetuInfo();

                List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
                if (kykSyouhnList.size() > 0) {
                    kykSyouhn = kykSyouhnList.get(0);
                }

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());

                IT_KykSya kykSya = kykKihon.getKykSya();

                IT_Kouza kouza = kykKihon.getKouza();

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(kykKihon.getSyono());

                BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUHOZEN);
                BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
                BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(tantouCd.getBusitucd() + "0000");
                String hasseinka = editString("　　　　　　　　　　" + YuyuBizConfig.getInstance().getHokenKaisyaNmKanji() + "　"
                    + bzGetSosikiDataBean.getKanjisosikinm20(),  31);

                BizDateFormat warekiFormatYon = new BizDateFormat("GyyMM", FillStyle.Zero);
                String bosyuuymWareki = warekiFormatYon.format(kykKihon.getBosyuuym()).substring(1);
                String kykymWareki = warekiFormatYon.format(kykSyouhn.getKykymd()).substring(1);

                String kykSyaNm = "";
                if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                    kykSyaNm = kykSya.getKyknmkn();
                }
                else {
                    kykSyaNm = kykSya.getKyknmkj();
                }

                BizDateFormat warekiFormatRoku = new BizDateFormat("GyyMMdd", FillStyle.Zero);
                String sikkouYmd = warekiFormatRoku.format(pMinyuuSyoumetuInfo.getSyoumetuymd()).substring(1);

                String hrkKaisuu = "";
                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                        hrkKaisuu = "月６　";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                        hrkKaisuu = "月１２";
                    }
                    else {
                        hrkKaisuu = "月払　";
                    }
                }
                else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    hrkKaisuu = "年１回";
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    hrkKaisuu = "年２回";
                }

                String hrkkeiro = "";
                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                    hrkkeiro = "預振　";
                }
                else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {
                    hrkkeiro = "クレカ";
                }

                BizCurrency hrkHokenryou = BizCurrency.valueOf(0);
                int jyuutouNensuu = 0;
                int jyuutouTukisuu =0;
                C_Nykkeiro nykkeiro = C_Nykkeiro.BLNK;
                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                    if (C_TkiktbrisyuruiKbn.BLNK.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.NONE.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        jyuutouNensuu = 0;
                        jyuutouTukisuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        jyuutouNensuu = 0;
                        jyuutouTukisuu = Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue());
                    }
                }
                else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    jyuutouNensuu = 1;
                    jyuutouTukisuu = 0;
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    jyuutouNensuu = 0;
                    jyuutouTukisuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                }

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                    nykkeiro = C_Nykkeiro.KZHRK;
                }
                else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                    nykkeiro = C_Nykkeiro.CREDIT;
                }

                C_ErrorKbn errorKbn = keisanRsgaku.exec(
                    kykKihon,
                    nykkeiro,
                    C_NyknaiyouKbn.KEIZOKUP,
                    pMinyuuSyoumetuInfo.getSyoumetuymd(),
                    ansyuKihon.getJkipjytym(),
                    jyuutouNensuu,
                    jyuutouTukisuu);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    continue;
                }

                hrkHokenryou = keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei();

                String hrkkeiroBetsuJouhouMidashi = "";
                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                    hrkkeiroBetsuJouhouMidashi = "預振口座　";
                }
                else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {
                    hrkkeiroBetsuJouhouMidashi = "クレジット";
                }

                String hrkkeiroBetsuJouhou = "";
                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                    if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {
                        hrkkeiroBetsuJouhou = "郵便貯金　通帳番号１" +
                            ConvertUtil.toZenAll(kouza.getSitencd(), 0, 1) + "０" + ConvertUtil.toZenAll(kouza.getKouzano(), 0, 1) + "１";
                    }
                    else {
                        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(kouza.getBankcd(), kouza.getSitencd(), syoriYmd);

                        if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

                            String yokinkbn = "";
                            if (C_YokinKbn.HUTUU.eq(kouza.getYokinkbn())) {
                                yokinkbn = "フツウ";
                            }
                            else {
                                yokinkbn = "トウザ";
                            }

                            hrkkeiroBetsuJouhou = ConvertUtil.toZenAll(editString(bzGetBankDataBean.getBankNmKn(), 23), 0, 1) + "　" +
                                ConvertUtil.toZenAll(editString(bzGetBankDataBean.getSitenNmKn(), 22), 0, 1) + "　" +
                                yokinkbn + "　" + ConvertUtil.toZenAll(kouza.getKouzano(), 0, 1);
                        }
                    }
                }

                String hokenSyuruiMei = editString(syouhnZokusei.getSyouhnnmsyouken(), 30);

                BizDateYM dbSakujyoYoteiYm = syoriYM.addMonths(3);

                int minyuuKaisuu = 0;
                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                    minyuuKaisuu = Integer.valueOf(BizNumber.valueOf(
                        BizDateUtil.calcDifferenceMonths(ansyuKihon.getJkipjytym(), kykSyouhn.getKykymd().getBizDateYM()) + 6).
                        divide(6, 0, RoundingMode.UP).toString());
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                    minyuuKaisuu = ansyuKihon.getJkipjytym().getYear() - kykSyouhn.getKykymd().getYear() + 1;
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    minyuuKaisuu = Integer.valueOf(BizNumber.valueOf(
                        BizDateUtil.calcDifferenceMonths(ansyuKihon.getJkipjytym(), kykSyouhn.getKykymd().getBizDateYM()) + 6).
                        divide(6, 0, RoundingMode.UP).toString());

                }
                else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    minyuuKaisuu = ansyuKihon.getJkipjytym().getYear() - kykSyouhn.getKykymd().getYear() + 1;
                }
                else {
                    minyuuKaisuu = BizDateUtil.calcDifferenceMonths(ansyuKihon.getJkipjytym(),
                        kykSyouhn.getKykymd().getBizDateYM()) + 1;
                }

                String oyaDrtenCd = "";
                String kyoudouatukaiKbn = "";
                List<BzGetAgInfoBean> keisyoukoBzGetAgInfoBeanList = new ArrayList<>();

                List<IT_KykDairiten> kykDairitenList = kykKihon.getKykDairitens();

                for (int i = 0; i < kykDairitenList.size(); i++) {

                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                    List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(kykDairitenList.get(i).getDrtencd());

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            keisyoukoBzGetAgInfoBeanList.add(bzGetAgInfoBean);
                            if (i == 0) {
                                oyaDrtenCd = bzGetAgInfoBean.getOyadrtenCd();
                            }
                            else {
                                if (oyaDrtenCd.equals(bzGetAgInfoBean.getOyadrtenCd())) {
                                    kyoudouatukaiKbn = "２";
                                }
                                else {
                                    kyoudouatukaiKbn = "３";
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < keisyoukoBzGetAgInfoBeanList.size(); j++) {
                    ZT_DrtenSkKykDtlSyokaiTy drtenSkKykDtlSyokaiTy = new ZT_DrtenSkKykDtlSyokaiTy();
                    String tantounm = "";
                    String tantouGyouhaiJouhou = "";
                    BzGetBsInfoBean bzGetBsInfoBean = null;

                    String tantcd = Strings.padStart(kykDairitenList.get(j).getBosyuucd(), 6, '0');

                    BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
                    bzGetBsInfoBean = bzGetBsInfo.exec(kykDairitenList.get(j).getBosyuucd());
                    if (bzGetBsInfoBean != null) {
                        tantounm = editString(bzGetBsInfoBean.getKanjiBosyuuninNm(), 10);
                    }

                    if (bzGetBsInfoBean != null && bzGetBsInfoBean.getBosyuuninGyouhaiYmd() != null) {
                        tantouGyouhaiJouhou = "（退社）";
                    }

                    String bkofccd = Strings.padStart(keisyoukoBzGetAgInfoBeanList.get(j).getDrtKanrisosikiCd1(), 3, '0').substring(0, 3);

                    drtenSkKykDtlSyokaiTy.setZtysakuseiym(String.valueOf(syoriYM));
                    drtenSkKykDtlSyokaiTy.setZtybsydrtencd(keisyoukoBzGetAgInfoBeanList.get(j).getDrtenCd());
                    drtenSkKykDtlSyokaiTy.setZtytntusycd(tantcd);
                    drtenSkKykDtlSyokaiTy.setZtysyono(kykKihon.getSyono());
                    drtenSkKykDtlSyokaiTy.setZtykykymwareki4keta(kykymWareki);
                    drtenSkKykDtlSyokaiTy.setZtycifcd(kykKihon.getCifcd());
                    drtenSkKykDtlSyokaiTy.setZtyatesakinm(editString(keisyoukoBzGetAgInfoBeanList.get(j).getKanjiDairitenNm() + "代理店", 20));
                    drtenSkKykDtlSyokaiTy.setZtyhassinka(hasseinka);
                    drtenSkKykDtlSyokaiTy.setZtytelno15keta("");
                    drtenSkKykDtlSyokaiTy.setZtybsyymwareki4keta(bosyuuymWareki);
                    drtenSkKykDtlSyokaiTy.setZtytntusynm(tantounm);
                    drtenSkKykDtlSyokaiTy.setZtykydatkikbnkj(kyoudouatukaiKbn);
                    drtenSkKykDtlSyokaiTy.setZtykyknmkj20(kykSyaNm);
                    drtenSkKykDtlSyokaiTy.setZtyskymdwareki(sikkouYmd);
                    drtenSkKykDtlSyokaiTy.setZtyhrkkaisuukj(hrkKaisuu);
                    drtenSkKykDtlSyokaiTy.setZtyhrkkeirokj(hrkkeiro);
                    drtenSkKykDtlSyokaiTy.setZtyp11keta(Long.valueOf(hrkHokenryou.toAdsoluteString()));
                    drtenSkKykDtlSyokaiTy.setZtyskhr(Long.valueOf(pMinyuuSyoumetuInfo.getShrgkkei().toAdsoluteString()));
                    drtenSkKykDtlSyokaiTy.setZtyjizensyoukaiyouhyj("");
                    drtenSkKykDtlSyokaiTy.setZtytntusygyouhaiinfo(tantouGyouhaiJouhou);
                    drtenSkKykDtlSyokaiTy.setZtyhrkkeirobtjhmidasi(hrkkeiroBetsuJouhouMidashi);
                    drtenSkKykDtlSyokaiTy.setZtyhrkkeirobtjh(hrkkeiroBetsuJouhou);
                    drtenSkKykDtlSyokaiTy.setZtyhknsyuruimei(hokenSyuruiMei);
                    drtenSkKykDtlSyokaiTy.setZtybkofccd(bkofccd);
                    drtenSkKykDtlSyokaiTy.setZtydbskyoteiymd(String.valueOf(dbSakujyoYoteiYm));
                    drtenSkKykDtlSyokaiTy.setZtyminyukaisuu(String.valueOf(minyuuKaisuu));
                    drtenSkKykDtlSyokaiTy.setZtyjikaipjyuutouym(String.valueOf(ansyuKihon.getJkipjytym()));
                    drtenSkKykDtlSyokaiTy.setZtyvitkaiinno("0000000000");
                    drtenSkKykDtlSyokaiTy.setZtyvitkykym("0000");
                    drtenSkKykDtlSyokaiTy.setZtyvitskymd("0000");
                    drtenSkKykDtlSyokaiTy.setZtyvithrkkaisuu("");
                    drtenSkKykDtlSyokaiTy.setZtyvithrkkeiro("");
                    drtenSkKykDtlSyokaiTy.setZtyzkomivitriyoury(Long.valueOf(0));
                    drtenSkKykDtlSyokaiTy.setZtyvitnyknkaisuu("000");
                    drtenSkKykDtlSyokaiTy.setZtyvitbikou("");
                    drtenSkKykDtlSyokaiTy.setZtyyobiv25("");

                    BizPropertyInitializer.initialize(drtenSkKykDtlSyokaiTy);

                    drtenSkKykDtlSyokaiTyEntityInserter.add(drtenSkKykDtlSyokaiTy);

                    kensuu++;

                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

                KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

                ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYmd);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuu)));
        }
    }

    private String editString(String pEditString, int pNum) {
        String editString = pEditString;

        if (pEditString == null) {
            editString = "";
        }
        else if (pEditString.length() > pNum) {
            editString = pEditString.substring(0, pNum);
        }

        return editString;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
