package yuyu.batch.hozen.khansyuu.khkijitutouraiannaisks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.batch.hozen.khansyuu.khkijitutouraiannaisks.dba.KhKijitutouraiAnnaiSksDao;
import yuyu.batch.hozen.khansyuu.khkijitutouraiannaisks.dba.KijitutouraiAnnaiSksTaisyouDataBean;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 案内収納 期日到来案内作成
 */
public class KhKijitutouraiAnnaiSksBatch implements Batch {

    private static final String TABLEID = IT_AnsyuKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKijitutouraiAnnaiSksDao khKijitutouraiAnnaiSksDao;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        KhozenCommonParam khCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        Long syoriKensuu = 0l;
        String kinouID = khCommonParam.getFunctionId();
        String kosID = khCommonParam.getUserID();
        String kosTime = BizDate.getSysDateTimeMilli();
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
            YuyuBizConfig.getInstance().getCallcentersosikicd());

        try (ExDBResults<KijitutouraiAnnaiSksTaisyouDataBean> kijitutouraiAnnaiSksTaisyouDataBeanList =
            khKijitutouraiAnnaiSksDao.getKijitutouraiAnnaiSksTaisyouDataBean(syoriYMD.getBizDateYM(), kakutyoujobCd);

            EntityInserter<IT_KijituTouraiAnnai> inserter = new EntityInserter<>();) {

            AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks =
                SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
            ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(20);

            for (KijitutouraiAnnaiSksTaisyouDataBean kijitutouraiAnnaiSksTaisyouDataBean : kijitutouraiAnnaiSksTaisyouDataBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kijitutouraiAnnaiSksTaisyouDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kijitutouraiAnnaiSksTaisyouDataBean.getSyono());

                IT_KykKihon kykKihon = khKijitutouraiAnnaiSksDao.getKykKihon(kijitutouraiAnnaiSksTaisyouDataBean
                    .getSyono());

                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(kijitutouraiAnnaiSksTaisyouDataBean.getSyono());

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khCommonParam,
                    checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    continue;
                }

                IT_KykSya kykSya = khKijitutouraiAnnaiSksDao.getKykSya(kykKihon);
                IT_HhknSya hhknSya = khKijitutouraiAnnaiSksDao.getHhknSya(kykKihon);
                IT_Kouza kouza = khKijitutouraiAnnaiSksDao.getKouza(kykKihon);

                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(kouza.getBankcd(), kouza.getSitencd());
                String bankNmKj = bzGetBankDataBean.getBankNmKj();
                String reportSitenNm = bzGetBankDataBean.getReportSitenNm();

                SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
                setHurikaebi.exec(syoriYMD);
                BizDate tyokugoHurikaebi = setHurikaebi.getTyokugoHurikaebi();

                BM_SyouhnZokusei syouhnZokusei = khKijitutouraiAnnaiSksDao.getSyouhnZokusei(
                    kijitutouraiAnnaiSksTaisyouDataBean.getSyouhncd(),
                    kijitutouraiAnnaiSksTaisyouDataBean.getSyouhnsdno());
                String syouhnNm = syouhnZokusei.getSyouhnnmsyouken();

                String tuutiNm = "";
                String hrkykkMsg1 = "";
                String hrkykkMsg2 = "";
                String hrkykkMsg3 = "";
                String hrkykkMsg4 = "";
                String hrkykkMsg5 = "";
                String hrkykkMsg6 = "";
                String hrkykkMsg7 = "";
                String hrkykkMsg8 = "";

                tuutiNm = "今期保険料お払込みのご案内";
                hrkykkMsg1 = "いつもお引立てをいただきありがとうございます。";
                hrkykkMsg2 = "本通知の記載のご契約につきまして、保険料のお払込月がまいりました";
                hrkykkMsg3 = "ので以下のとおりご案内いたします。";
                hrkykkMsg6 = "お願いいたします。";
                hrkykkMsg7 = "今後とも変わらぬご愛顧を賜りますようお願いいたします。";

                hrkykkMsg4 = FixedDateFormatter.formatMDZenkakuKanji(tyokugoHurikaebi) + "に保険料を振り替えさせていただきますので、";
                hrkykkMsg5 = FixedDateFormatter.formatMDZenkakuKanji(tyokugoHurikaebi.addBusinessDays(-1)) + "までにお払込額をご指定口座にご準備くださいますよう";

                String updKouzaNo = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,KhozenEdit.editKouzaNo(kouza.getBankcd(), kouza.getKouzano()));

                String kzInfo1 = "";
                String kzInfo2 = "";
                String kzInfo3 = "";
                String kzInfo4 = "";
                String kzInfo5 = "";
                String kzInfo6 = "";
                String kzInfo7 = "";
                String kzInfo8 = "";

                kzInfo1 = "振替口座（ご指定の金融機関・口座）";

                kzInfo2 = bankNmKj;
                kzInfo3 = reportSitenNm;

                if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(kouza.getBankcd())) {

                    kzInfo4 = "通帳番号　" + updKouzaNo;

                    if (kouza.getKzmeiginmkn().length() < 19) {

                        kzInfo5 = "口座名義人　" + kouza.getKzmeiginmkn() + "　様";
                        kzInfo6 = "※お客さま情報保護のため、通帳番号の一部を＊にて表示";
                        kzInfo7 = "　しています。";
                    }
                    else {

                        kzInfo5 = "口座名義人　" + kouza.getKzmeiginmkn().substring(0, 18);
                        kzInfo6 = "　　　　　　" + kouza.getKzmeiginmkn().substring(18) + "　" + "様";
                        kzInfo7 = "※お客さま情報保護のため、通帳番号の一部を＊にて表示";
                        kzInfo8 = "　しています。";
                    }
                }
                else {

                    kzInfo4 = C_YokinKbn.getContentByValue(C_YokinKbn.PATTERN_TYOUHYOU, kouza.getYokinkbn().getValue()) + "　口座番号　" + updKouzaNo;

                    if (kouza.getKzmeiginmkn().length() < 19) {

                        kzInfo5 = "口座名義人　" + kouza.getKzmeiginmkn() + "　様";
                        kzInfo6 = "※お客さま情報保護のため、口座番号の一部を＊にて表示";
                        kzInfo7 = "　しています。";
                    }
                    else {

                        kzInfo5 = "口座名義人　" + kouza.getKzmeiginmkn().substring(0, 18);
                        kzInfo6 = "　　　　　　" + kouza.getKzmeiginmkn().substring(18) + "　" + "様";
                        kzInfo7 = "※お客さま情報保護のため、口座番号の一部を＊にて表示";
                        kzInfo8 = "　しています。";
                    }
                }

                String hknjytuKikan = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
                    BizDate.valueOf(kijitutouraiAnnaiSksTaisyouDataBean.getJkipjytym(),
                        kijitutouraiAnnaiSksTaisyouDataBean.getKykymd().getDay()).getRekijyou());

                int jyutouNensuu = 0;
                int jyutouTukisuu = 0;

                if (C_Hrkkaisuu.NEN.eq(kijitutouraiAnnaiSksTaisyouDataBean.getHrkkaisuu())) {

                    hknjytuKikan = hknjytuKikan + "から　１年分";

                    jyutouNensuu = 1;

                    jyutouTukisuu = 0;
                }
                else if (C_Hrkkaisuu.HALFY.eq(kijitutouraiAnnaiSksTaisyouDataBean.getHrkkaisuu())) {

                    hknjytuKikan = hknjytuKikan + "から　６か月分";

                    jyutouNensuu = 0;

                    jyutouTukisuu = Integer.valueOf(C_Hrkkaisuu.HALFY.getValue());
                }
                else if (C_Hrkkaisuu.TUKI.eq(kijitutouraiAnnaiSksTaisyouDataBean.getHrkkaisuu())
                    && (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(
                        kijitutouraiAnnaiSksTaisyouDataBean.getTkiktbrisyuruiKbn()))) {

                    hknjytuKikan = hknjytuKikan + "から１２か月分";

                    jyutouNensuu = 0;

                    jyutouTukisuu = Integer.valueOf(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.getValue());
                }
                else if (C_Hrkkaisuu.TUKI.eq(kijitutouraiAnnaiSksTaisyouDataBean.getHrkkaisuu())
                    && (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(
                        kijitutouraiAnnaiSksTaisyouDataBean.getTkiktbrisyuruiKbn()))) {

                    hknjytuKikan = hknjytuKikan + "から　６か月分";

                    jyutouNensuu = 0;

                    jyutouTukisuu = Integer.valueOf(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.getValue());
                }

                BizCurrency rsgakuGoukei = BizCurrency.valueOf(0);
                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu rstuukasyu = C_Tuukasyu.BLNK;

                C_ErrorKbn resultKbn = keisanRsgaku.exec(
                    kykKihon,
                    C_Nykkeiro.KZHRK,
                    C_NyknaiyouKbn.KEIZOKUP,
                    tyokugoHurikaebi,
                    kijitutouraiAnnaiSksTaisyouDataBean.getJkipjytym(),
                    jyutouNensuu,
                    jyutouTukisuu);

                if (C_ErrorKbn.OK.eq(resultKbn)) {

                    rsgakuGoukei = keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei();

                    rstuukasyu = henkanTuuka.henkanTuukaTypeToKbn(rsgakuGoukei.getType());
                }
                else {

                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    continue;
                }

                String hrkgk = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,BizUtil.comma(
                    rsgakuGoukei.toString()));

                if(hrkgk.length() < 17){

                    hrkgk = Strings.padStart(hrkgk, 17, '　');
                }

                String hrkgk1 = "お払込額　　　　　" + hrkgk + "円";
                String hrkgk2 = "内訳　保険料　　　" + hrkgk + "円";
                String hrkgk3 = "";
                String hrkgk4 = "";

                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);

                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(kijitutouraiAnnaiSksTaisyouDataBean.getSyono());

                C_HassouKbn hassoukbn =null;

                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hassoukbn = C_HassouKbn.HONSYAKAISOU;
                }
                else {

                    hassoukbn = C_HassouKbn.TYOKUSOU;
                }

                String kjttrnnfreearea8 = "";
                String kjttrnnfreearea9 = "";
                String kjttrnnfreearea10 = "";
                String kjttrnnfreearea11 = "";
                String kjttrnnfreearea12 = "";
                String kjttrnnfreearea13 = "";


                kjttrnnfreearea8 = "※保険料円貨払込特約（円貨払込額指定型）または保険料円貨払込特約（円貨";
                kjttrnnfreearea9 = "　払込額変動型）の付加された契約は、円貨払込額（定期一括払いの場合は、";
                kjttrnnfreearea10 = "　定期一括払円貨払込額）について「保険料」と表示しております。";

                C_Tuukasyu ptuukasyu = henkanTuuka.henkanTuukaTypeToKbn(
                    kijitutouraiAnnaiSksTaisyouDataBean.getHokenryou().getType());

                if (!ptuukasyu.eq(rstuukasyu)) {

                    kjttrnnfreearea12 = "※保険料は本通知作成日の前月末営業日における当社所定の為替レートで";
                    kjttrnnfreearea13 = "　円換算した金額をお払い込みいただきます。";
                }

                IT_KijituTouraiAnnai kijituTouraiAnnai = new IT_KijituTouraiAnnai(
                    kijitutouraiAnnaiSksTaisyouDataBean.getSyono(), syoriYMD);

                kijituTouraiAnnai.setShskyno(kykSya.getTsinyno());
                kijituTouraiAnnai.setShsadr1kj(kykSya.getTsinadr1kj());
                kijituTouraiAnnai.setShsadr2kj(kykSya.getTsinadr2kj());
                kijituTouraiAnnai.setShsadr3kj(kykSya.getTsinadr3kj());
                kijituTouraiAnnai.setShsnmkj(kykSya.getKyknmkj());
                kijituTouraiAnnai.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                kijituTouraiAnnai.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                kijituTouraiAnnai.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                kijituTouraiAnnai.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                kijituTouraiAnnai.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                kijituTouraiAnnai.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                kijituTouraiAnnai.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
                kijituTouraiAnnai.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
                kijituTouraiAnnai.setTuutinm20keta(tuutiNm);
                kijituTouraiAnnai.setHrkykkmsg32keta1(hrkykkMsg1);
                kijituTouraiAnnai.setHrkykkmsg32keta2(hrkykkMsg2);
                kijituTouraiAnnai.setHrkykkmsg32keta3(hrkykkMsg3);
                kijituTouraiAnnai.setHrkykkmsg32keta4(hrkykkMsg4);
                kijituTouraiAnnai.setHrkykkmsg32keta5(hrkykkMsg5);
                kijituTouraiAnnai.setHrkykkmsg32keta6(hrkykkMsg6);
                kijituTouraiAnnai.setHrkykkmsg32keta7(hrkykkMsg7);
                kijituTouraiAnnai.setHrkykkmsg32keta8(hrkykkMsg8);
                kijituTouraiAnnai.setHrkkeiro(kykKihon.getHrkkeiro());
                kijituTouraiAnnai.setSyouhnnm(syouhnNm);
                kijituTouraiAnnai.setKykymd(kijitutouraiAnnaiSksTaisyouDataBean.getKykymd());
                kijituTouraiAnnai.setHhknnmkj(hhknSya.getHhknnmkj());
                kijituTouraiAnnai.setKjttrnnfreearea6("「生命保険料控除証明書」につきましては、証明額がある場合、ご申告");
                kijituTouraiAnnai.setKjttrnnfreearea7("時期に送付いたします。");
                kijituTouraiAnnai.setHurikaeymd(tyokugoHurikaebi);
                kijituTouraiAnnai.setKzinfo1(kzInfo1);
                kijituTouraiAnnai.setKzinfo2(kzInfo2);
                kijituTouraiAnnai.setKzinfo3(kzInfo3);
                kijituTouraiAnnai.setKzinfo4(kzInfo4);
                kijituTouraiAnnai.setKzinfo5(kzInfo5);
                kijituTouraiAnnai.setKzinfo6(kzInfo6);
                kijituTouraiAnnai.setKzinfo7(kzInfo7);
                kijituTouraiAnnai.setKzinfo8(kzInfo8);
                kijituTouraiAnnai.setHknjytukikan(hknjytuKikan);
                kijituTouraiAnnai.setHrkgk1(hrkgk1);
                kijituTouraiAnnai.setHrkgk2(hrkgk2);
                kijituTouraiAnnai.setHrkgk3(hrkgk3);
                kijituTouraiAnnai.setHrkgk4(hrkgk4);
                kijituTouraiAnnai.setKjttrnnfreearea8(kjttrnnfreearea8);
                kijituTouraiAnnai.setKjttrnnfreearea9(kjttrnnfreearea9);
                kijituTouraiAnnai.setKjttrnnfreearea10(kjttrnnfreearea10);
                kijituTouraiAnnai.setKjttrnnfreearea11(kjttrnnfreearea11);
                kijituTouraiAnnai.setKjttrnnfreearea12(kjttrnnfreearea12);
                kijituTouraiAnnai.setKjttrnnfreearea13(kjttrnnfreearea13);
                kijituTouraiAnnai.setSyoruiCd(C_SyoruiCdKbn.AS_KIJITUTOURAIANNAI);
                kijituTouraiAnnai.setHassoukbn(hassoukbn);
                kijituTouraiAnnai.setGyoumuKousinKinou(kinouID);
                kijituTouraiAnnai.setGyoumuKousinsyaId(kosID);
                kijituTouraiAnnai.setGyoumuKousinTime(kosTime);

                BizPropertyInitializer.initialize(kijituTouraiAnnai);

                khKijitutouraiAnnaiSksDao.addInsertEntity(inserter, kijituTouraiAnnai);

                syoriKensuu++;

                kykKihon.detach();
            }

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

                ansyuuBatSyoriHunoKykMisslistSks.createReport(khCommonParam, syoriYMD);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, syoriKensuu.toString()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
