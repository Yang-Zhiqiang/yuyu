package yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks.dba.KhKzhuriKaisiAnnaiSksDao;
import yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks.dba.KzhuriAnnaiDataBean;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
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
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 口座振替開始案内作成のバッチクラスです。
 */
public class KhKzhuriKaisiAnnaiSksBatch implements Batch {

    private static final String TABLEID = IT_AnsyuKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    private String kinouID;

    private String kosID;

    private String kosTime;

    private BizDate syoriYMD;

    private String kakutyouJobcd;

    private KhozenCommonParam kCcommonParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhKzhuriKaisiAnnaiSksDao khKzhuriKaisiAnnaiSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        kCcommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        kinouID = kCcommonParam.getFunctionId();
        kosID = kCcommonParam.getUserID();
        kosTime = BizDate.getSysDateTimeMilli();
        syoriYMD = bzBatchParam.getSyoriYmd();
        kakutyouJobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDateYM syoriYM = bzBatchParam.getSyoriYmd().getBizDateYM();

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        long syoriKensuu = 0;

        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        try ( ExDBResults<KzhuriAnnaiDataBean> kzhuriAnnaiDataBeanList =
            khKzhuriKaisiAnnaiSksDao.getKzhuriAnnaiDataBean(syoriYM, kakutyouJobcd);

            EntityInserter<IT_KouzahuriStartAnnai> inserter = new EntityInserter<>();) {

            AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);

            for (KzhuriAnnaiDataBean dataBean : kzhuriAnnaiDataBeanList) {

                String syono = dataBean.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(syono);
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(
                    kCcommonParam, checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    continue;
                }

                IT_KykKihon kykKihon = khKzhuriKaisiAnnaiSksDao.getKykKihon(syono);
                IT_KykSya kykSya = khKzhuriKaisiAnnaiSksDao.getKykSya(kykKihon);

                if (kykSya == null) {
                    throw new CommonBizAppException("契約者テーブルにデータが存在しません。");
                }

                IT_HhknSya hhknSya = khKzhuriKaisiAnnaiSksDao.getHhknSya(kykKihon);

                if (hhknSya == null) {
                    throw new CommonBizAppException("被保険者テーブルにデータが存在しません。");
                }

                IT_Kouza kouza = khKzhuriKaisiAnnaiSksDao.getKouza(kykKihon);

                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(kouza.getBankcd(), kouza.getSitencd());
                String bankNmKj = bzGetBankDataBean.getBankNmKj();
                String reportSitenNm = bzGetBankDataBean.getReportSitenNm();

                setHurikaebi.exec(syoriYMD);
                BizDate hurikaeYmd = setHurikaebi.getTyokugoHurikaebi();
                String tyokugoHurikaebi = FixedDateFormatter.formatMDZenkakuKanji(hurikaeYmd);

                BM_SyouhnZokusei syouhnZokusei = khKzhuriKaisiAnnaiSksDao.getSyouhnZokusei(
                    dataBean.getSyouhncd(), dataBean.getSyouhnsdno());

                String syouhnnmSyouken = syouhnZokusei.getSyouhnnmsyouken();

                String kouzaNo = ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, KhozenEdit.editKouzaNo(kouza.getBankcd(), kouza.getKouzano()));

                BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
                    YuyuBizConfig.getInstance().getCallcentersosikicd());

                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);

                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(dataBean.getSyono());

                C_HassouKbn hassoukbn =null;

                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hassoukbn = C_HassouKbn.HONSYAKAISOU;
                }
                else {

                    hassoukbn = C_HassouKbn.TYOKUSOU;
                }

                int jyuutouTukisuu = syoriYMD.getBizDateYM().subtractMonths(dataBean.getJkipjytym().addMonths(-1));

                C_ErrorKbn keisanRsgakuKekkaKbn = keisanRsgaku.exec(
                    kykKihon,
                    C_Nykkeiro.KZHRK,
                    C_NyknaiyouKbn.KEIZOKUP,
                    hurikaeYmd,
                    dataBean.getJkipjytym(),
                    0,
                    jyuutouTukisuu);

                BizCurrency rsgakuGoukei = null;

                if (C_ErrorKbn.OK.eq(keisanRsgakuKekkaKbn)) {

                    rsgakuGoukei = keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei();
                }
                else {

                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(
                        kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    continue;
                }

                String kzhuriStartAnfreeArea1 = "";
                String kzhuriStartAnfreeArea2 = "";
                String kzhuriStartAnfreeArea3 = "";
                String kzhuriStartAnfreeArea4 = "";
                String kzhuriStartAnfreeArea5 = "";
                String kzhuriStartAnfreeArea6 = "";
                String kzhuriStartAnfreeArea7 = "";
                String kzhuriStartAnfreeArea8 = "";
                String kzhuriStartAnfreeArea9 = "";
                String kzhuriStartAnfreeArea10 = "";

                kzhuriStartAnfreeArea1 = "※保険料円貨払込特約（円貨払込額指定型）または保険料円貨払込特約（円貨";
                kzhuriStartAnfreeArea2 = "　払込額変動型）の付加された契約は、円貨払込額（定期一括払いの場合は、";
                kzhuriStartAnfreeArea3 = "　定期一括払円貨払込額）について「保険料」と表示しております。";

                C_Tuukasyu rsTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(rsgakuGoukei.getType());
                C_Tuukasyu hokenryouTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(dataBean.getHokenryou().getType());

                if (!rsTuukasyu.eq(hokenryouTuukasyu)) {

                    kzhuriStartAnfreeArea5 = "※保険料は本通知作成日の前月末営業日における当社所定の為替レートで";
                    kzhuriStartAnfreeArea6 = "　円換算した金額をお払い込みいただきます。";
                }

                String hurikaeKz3 = null;
                if (kouza.getBankcd().equals(IGkCommonKoumoku.BANKCD_YTGINKOU)) {
                    hurikaeKz3 = "通帳番号　" + kouzaNo;
                } else {
                    hurikaeKz3 = kouza.getYokinkbn().getContent() + "預金　　　　　　　　　口座番号　" + kouzaNo;
                }

                IT_KouzahuriStartAnnai kouzahuriStartAnnai = new IT_KouzahuriStartAnnai(dataBean.getSyono());

                kouzahuriStartAnnai.setTyouhyouymd(syoriYMD);
                kouzahuriStartAnnai.setKyknmkj(kykSya.getKyknmkj());
                kouzahuriStartAnnai.setTsinyno(kykSya.getTsinyno());
                kouzahuriStartAnnai.setTsinadr1kj(kykSya.getTsinadr1kj());
                kouzahuriStartAnnai.setTsinadr2kj(kykSya.getTsinadr2kj());
                kouzahuriStartAnnai.setTsinadr3kj(kykSya.getTsinadr3kj());
                kouzahuriStartAnnai.setKykymd(dataBean.getKykymd());
                kouzahuriStartAnnai.setHhknnmkj(hhknSya.getHhknnmkj());
                kouzahuriStartAnnai.setSyouhnnm(syouhnnmSyouken);
                kouzahuriStartAnnai.setTuutinm("口座振替開始のご案内");
                kouzahuriStartAnnai.setAisatumongon1("当社の保険にご加入いただき誠にありがとうございます。");
                kouzahuriStartAnnai.setAisatumongon2("お客さまのご契約は、「" + tyokugoHurikaebi +
                    "」の振替日からご指定");
                kouzahuriStartAnnai.setAisatumongon3("の預金口座より保険料の振替を開始させていただきます。");
                kouzahuriStartAnnai.setAisatumongon4("今後とも変わらぬご愛顧を賜りますようお願いいたします。");
                kouzahuriStartAnnai.setAisatumongon5("");
                kouzahuriStartAnnai.setKzhurikaeonegai1("・振替日は毎月２７日（金融機関休日の場合は翌営業日）ですので、振替日の");
                kouzahuriStartAnnai.setKzhurikaeonegai2("　前営業日までに保険料を口座にご準備ください。");
                kouzahuriStartAnnai.setKzhurikaeonegai3("");
                kouzahuriStartAnnai.setKzhurikaeonegai4("・毎月の口座振替結果につきましては、“領収証”は発行いたしませんので、");
                kouzahuriStartAnnai.setKzhurikaeonegai5("　お手元の預金通帳等でご確認くださいますようお願いいたします。");
                kouzahuriStartAnnai.setKzhurikaeonegai6("");
                kouzahuriStartAnnai.setKzhurikaeonegai7("・万一２７日に振り替えできない場合には、その旨をご通知させていただいた");
                kouzahuriStartAnnai.setKzhurikaeonegai8("　うえで、特別な場合を除き翌月に２か月分の保険料を振り替えさせていただ");
                kouzahuriStartAnnai.setKzhurikaeonegai9("　きます。");
                kouzahuriStartAnnai.setKzhurikaeonegai10("・翌月もご案内金額（２か月分）が振り替えできない場合、翌々月に３か月分");
                kouzahuriStartAnnai.setKzhurikaeonegai11("　まとめて振り替えさせていただきます。");
                kouzahuriStartAnnai.setKzhurikaeonegai12("・翌々月もご案内金額（３か月分）が振り替えできない場合、お払込猶予期間");
                kouzahuriStartAnnai.setKzhurikaeonegai13("　を過ぎると、ご契約が消滅しますのであらかじめご了承ください。");
                kouzahuriStartAnnai.setKzhurikaeonegai14("");
                kouzahuriStartAnnai.setKzhurikaeonegai15("");
                kouzahuriStartAnnai.setTkbriphurikaeyoteigk(rsgakuGoukei.toString());
                kouzahuriStartAnnai.setHurikaekzhosokumongon("　　　　　　　　　（お客さま情報保護のため一部を＊表示）");
                kouzahuriStartAnnai.setHurikaekz1(bankNmKj);
                kouzahuriStartAnnai.setHurikaekz2(reportSitenNm);
                kouzahuriStartAnnai.setHurikaekz3(hurikaeKz3);
                kouzahuriStartAnnai.setHurikaekz4("口座名義人　" + kouza.getKzmeiginmkn() + "　様");
                kouzahuriStartAnnai.setHurikaekz5("（改姓等で口座名義を変更されている場合は、表面の照会先までご連絡ください。）");
                kouzahuriStartAnnai.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                kouzahuriStartAnnai.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                kouzahuriStartAnnai.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                kouzahuriStartAnnai.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                kouzahuriStartAnnai.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                kouzahuriStartAnnai.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                kouzahuriStartAnnai.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
                kouzahuriStartAnnai.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
                kouzahuriStartAnnai.setSyoruiCd(C_SyoruiCdKbn.AS_KOUHURIKAISIANNAI);
                kouzahuriStartAnnai.setHassoukbn(hassoukbn);
                kouzahuriStartAnnai.setKzhuristartanfreearea1(kzhuriStartAnfreeArea1);
                kouzahuriStartAnnai.setKzhuristartanfreearea2(kzhuriStartAnfreeArea2);
                kouzahuriStartAnnai.setKzhuristartanfreearea3(kzhuriStartAnfreeArea3);
                kouzahuriStartAnnai.setKzhuristartanfreearea4(kzhuriStartAnfreeArea4);
                kouzahuriStartAnnai.setKzhuristartanfreearea5(kzhuriStartAnfreeArea5);
                kouzahuriStartAnnai.setKzhuristartanfreearea6(kzhuriStartAnfreeArea6);
                kouzahuriStartAnnai.setKzhuristartanfreearea7(kzhuriStartAnfreeArea7);
                kouzahuriStartAnnai.setKzhuristartanfreearea8(kzhuriStartAnfreeArea8);
                kouzahuriStartAnnai.setKzhuristartanfreearea9(kzhuriStartAnfreeArea9);
                kouzahuriStartAnnai.setKzhuristartanfreearea10(kzhuriStartAnfreeArea10);
                kouzahuriStartAnnai.setGyoumuKousinKinou(kinouID);
                kouzahuriStartAnnai.setGyoumuKousinsyaId(kosID);
                kouzahuriStartAnnai.setGyoumuKousinTime(kosTime);

                BizPropertyInitializer.initialize(kouzahuriStartAnnai);

                inserter.add(kouzahuriStartAnnai);

                syoriKensuu = syoriKensuu + 1;
            }

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

                ansyuuBatSyoriHunoKykMisslistSks.createReport(kCcommonParam, syoriYMD);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
