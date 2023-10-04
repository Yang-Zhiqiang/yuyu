package yuyu.batch.hozen.khansyuu.khsinkokuyokokutuutisks;

import java.util.ArrayList;
import java.util.List;

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
import yuyu.batch.hozen.khansyuu.khsinkokuyokokutuutisks.dba.KhSinkokuYokokuTuutiSksDao;
import yuyu.batch.hozen.khansyuu.khsinkokuyokokutuutisks.dba.SinkokuYokokuTuutiSksBean;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.ascommon.EditSinkokuYokokuTuutiParam;
import yuyu.common.hozen.ascommon.KeisanSinkokuYokokugaku;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditKoujyoSyoumeiParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KeisanKoujyogaku;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * 契約保全 案内収納 申告予告通知作成
 */
public class KhSinkokuYokokuTuutiSksBatch implements Batch {

    private static final String TABLEID = IT_KykKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhSinkokuYokokuTuutiSksBatchParam batchParam;

    @Inject
    private KhSinkokuYokokuTuutiSksDao khSinkokuYokokuTuutiSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        String kosCd = khozenCommonParam.getUserID();
        String kostime = BizDate.getSysDateTimeMilli();
        BizDate syoriYmd = batchParam.getSyoriYmd();
        String kakutyouJobCd = batchParam.getIbKakutyoujobcd();
        String heisoukbn = batchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        String syoumeiNendo = String.valueOf(syoriYmd.getBizDateY());
        long syoriKensu = 0;

        try (
            ExDBResults<SinkokuYokokuTuutiSksBean> sinkokuYokokuTuutiSksBeanExDBResults =
            khSinkokuYokokuTuutiSksDao.getSinkokuYokokuTuutiSks(syoumeiNendo, kakutyouJobCd, heisoukbn);
            EntityInserter<IT_SinkokuyokokuTuuti> entityInserter = new EntityInserter<IT_SinkokuyokokuTuuti>()) {

            HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
            CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;

            for (SinkokuYokokuTuutiSksBean sinkokuYokokuTuutiSksBean : sinkokuYokokuTuutiSksBeanExDBResults) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sinkokuYokokuTuutiSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(sinkokuYokokuTuutiSksBean.getSyono());

                int hkryouJyutouYoteikknTukisuu = 0;
                BizDateYM jyutouStartYm = null;
                BizDateYM jyutouEndYm = null;
                String hknjyutoukikan = "";
                int hknKkn = 0;
                // 未実装 TODO
                //                int nkShrkkn = 0;
                //                BizDateYM nkshrstartYm = null;
                //                int pHrkkkn = 0;
                String jyutouStartYmKj = "";
                String hkryouJyutoukknNengetuKj = "";
                String hknKknKj = "";
                // 未実装  TODO
                //                String nkShrkknKj = "";
                //                String nkshrstartYmKj = "";
                //                String pHrkkknKj = "";
                //                BizDate nenkinuktseiYmd = null;
                //                String nenkinuktseiYmdKj = "";
                String uktnmkj = "";
                BizCurrency newIppanyoteip = BizCurrency.valueOf(0);
                BizCurrency newIppanyoteihaitoukin = BizCurrency.valueOf(0);
                BizCurrency newIppanyoteisyoumeigk = BizCurrency.valueOf(0);
                BizCurrency newKaigoiryouyoteip = BizCurrency.valueOf(0);
                BizCurrency newKaigoiryouyoteihaitoukin = BizCurrency.valueOf(0);
                BizCurrency newKaigoiryouyoteisyoumeig = BizCurrency.valueOf(0);
                BizCurrency newNenkinyoteip = BizCurrency.valueOf(0);
                BizCurrency newNenkinyoteihaitoukin = BizCurrency.valueOf(0);
                BizCurrency newNenkinyoteisyoumeigk = BizCurrency.valueOf(0);
                C_UmuKbn kjnnkKoujyum = C_UmuKbn.NONE;
                C_HassouKbn hassouKbn = C_HassouKbn.BLNK;
                String toiawaseSosikiNmKj = "";
                String toiawaseYno = "";
                String toiawaseAdr1Kj = "";
                String toiawaseAdr2Kj = "";
                String toiawaseAdr3Kj = "";
                String toiawaseTelNo = "";
                String toiawaseTelUktkKanou1 = "";
                String toiawaseTelUktkKanou2 = "";

                String syono = sinkokuYokokuTuutiSksBean.getSyono();
                BizDateYM jkipjytym = sinkokuYokokuTuutiSksBean.getJkipjytym();

                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

                if (!C_Kykjyoutai.ZENNOU.eq(sinkokuYokokuTuutiSksBean.getKykjyoutai())) {

                    setYuuyokknmanryobi.exec(syono, jkipjytym);
                    BizDate yuuyokknMnryBi = setYuuyokknmanryobi.getYuuyokknMnrybi();

                    if (BizDateUtil.compareYmd(yuuyokknMnryBi, syoriYmd) == BizDateUtil.COMPARE_LESSER) {
                        continue;
                    }

                }

                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(syono);

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    continue;
                }

                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syono);

                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
                    continue;
                }
                if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {

                    List<String> messageList = new ArrayList<>();
                    List<String> jimurenrakuMsgList = new ArrayList<>();

                    for (String warningMessage : checkYuukouJyoutai.getWarningMessageList()) {

                        messageList.add("対象外理由／"+warningMessage);

                    }

                    jimurenrakuMsgList.add(0, "申告予告通知作成対象外");
                    jimurenrakuMsgList.add(1, "");
                    jimurenrakuMsgList.addAll(2, messageList);

                    EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector
                        .getInstance(EditJimuRenrakusyuunouParam.class);
                    editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimurenrakuMsgList);

                    EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);

                    ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(khozenCommonParam,
                        sinkokuYokokuTuutiSksBean.getSyono(), C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,
                        editJimuRenrakusyuunouParam, syoriYmd);

                    CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
                    createReport.execNoCommit(reportServicesBean);

                    continue;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

                if (kykKihon == null) {
                    continue;
                }

                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

                if (kykSyouhn == null) {
                    continue;
                }

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

                if (ansyuKihon == null) {
                    continue;
                }

                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

                if (syouhnZokusei == null) {
                    continue;
                }

                khozenCommonParam.setSikibetuKey(null);
                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                KeisanSinkokuYokokugaku keisanSinkokuYokokugaku = SWAKInjector.getInstance(KeisanSinkokuYokokugaku.class);
                keisanSinkokuYokokugaku.exec(
                    khozenCommonParam,
                    kykSyouhn,
                    syouhnZokusei,
                    syoumeiNendo,
                    kykSyouhn.getKykjyoutai(),
                    syono);

                EditSinkokuYokokuTuutiParam editSinkokuYokokuTuutiParam = keisanSinkokuYokokugaku.getSkkYkkTuutiParam();
                editSinkokuYokokuTuutiParam.setSyoumeiNendo(syoumeiNendo);

                KeisanKoujyogaku keisanKoujyogaku = SWAKInjector.getInstance(KeisanKoujyogaku.class);
                keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);

                keisanKoujyogaku.exec(syono, syoumeiNendo);

                EditKoujyoSyoumeiParam editKoujyoSyoumeiParam = keisanKoujyogaku.getParam();

                List<IT_KykUkt> kykUktSbuktLst = khSinkokuYokokuTuutiSksDao.getUketorinin(kykKihon, C_UktsyuKbn.SBUKT);

                // 未実装 TODO
                //                List<IT_KykUkt> kykUktNenkintLst = khSinkokuYokokuTuutiSksDao.getUketorinin(kykKihon, C_UktsyuKbn.NKUKT);

                newIppanyoteip = editSinkokuYokokuTuutiParam.getNewippanykkp().add(
                    editKoujyoSyoumeiParam.getNewIppanJissekiP());
                newIppanyoteihaitoukin = editKoujyoSyoumeiParam.getNewIppanJissekiHaitoukin();
                newIppanyoteisyoumeigk = editSinkokuYokokuTuutiParam.getNewippanykksyoumeigk().add(
                    editKoujyoSyoumeiParam.getNewIppanJissekiSyoumeigk());
                newKaigoiryouyoteip = editSinkokuYokokuTuutiParam.getNewiryouykkp().add(
                    editKoujyoSyoumeiParam.getNewIryouJissekiP());
                newKaigoiryouyoteihaitoukin = editKoujyoSyoumeiParam.getNewIryouJissekiHaitoukin();
                newKaigoiryouyoteisyoumeig = editSinkokuYokokuTuutiParam.getNewiryouykksyoumeigk().add(
                    editKoujyoSyoumeiParam.getNewIryouJissekiSyoumeigk());
                newNenkinyoteip = editSinkokuYokokuTuutiParam.getNewnenkinykkp().add(
                    editKoujyoSyoumeiParam.getNewNenkinJissekiP());
                newNenkinyoteihaitoukin = editKoujyoSyoumeiParam.getNewNenkinJissekiHaitoukin();
                newNenkinyoteisyoumeigk = editSinkokuYokokuTuutiParam.getNewnenkinykksyoumeigk().add(
                    editKoujyoSyoumeiParam.getNewNenkinJissekiSyoumeigk());

                if (newIppanyoteisyoumeigk.compareTo(BizCurrency.valueOf(0, newIppanyoteisyoumeigk.getType())) <= 0 &&
                    newKaigoiryouyoteisyoumeig.compareTo(BizCurrency.valueOf(0, newKaigoiryouyoteisyoumeig.getType())) <= 0 &&
                    newNenkinyoteisyoumeigk.compareTo(BizCurrency.valueOf(0, newNenkinyoteisyoumeigk.getType())) <= 0) {

                    continue;
                }

                // 未実装 TODO
                //                if (newNenkinyoteisyoumeigk.compareTo(BizCurrency.valueOf(0, newNenkinyoteisyoumeigk.getType())) > 0) {
                //                    kjnnkKoujyum = C_UmuKbn.ARI;
                //                }
                //                else {
                //                    kjnnkKoujyum = C_UmuKbn.NONE;
                //                }

                if (editKoujyoSyoumeiParam.getSyoumeiStartYm() != null) {

                    jyutouStartYm = editKoujyoSyoumeiParam.getSyoumeiStartYm();
                }
                else {

                    jyutouStartYm = editSinkokuYokokuTuutiParam.getPjyutoustartyoteiym();
                }

                jyutouEndYm = editSinkokuYokokuTuutiParam.getPjyutouendyoteiym();

                hkryouJyutouYoteikknTukisuu = BizDateUtil.calcDifferenceMonths(jyutouStartYm, jyutouEndYm) + 1;


                if (hkryouJyutouYoteikknTukisuu % 12 == 0) {

                    hkryouJyutoukknNengetuKj =
                        Strings.padStart(ConvertUtil.toZenAll(String.valueOf(hkryouJyutouYoteikknTukisuu / 12), 1, 1), 2, '　') + "年" ;
                }
                else if (hkryouJyutouYoteikknTukisuu % 12 != 0) {

                    if (hkryouJyutouYoteikknTukisuu / 12 == 0){

                        hkryouJyutoukknNengetuKj =
                            Strings.padStart(ConvertUtil.toZenAll(String.valueOf(hkryouJyutouYoteikknTukisuu % 12), 1, 1), 2, '　') + "か月" ;
                    }
                    else if (hkryouJyutouYoteikknTukisuu / 12 != 0) {

                        hkryouJyutoukknNengetuKj =
                            Strings.padStart(ConvertUtil.toZenAll(String.valueOf(hkryouJyutouYoteikknTukisuu / 12), 1, 1), 2, '　') + "年" +
                                Strings.padStart(ConvertUtil.toZenAll(String.valueOf(hkryouJyutouYoteikknTukisuu % 12), 1, 1), 2, '　') + "か月" ;
                    }
                }

                jyutouStartYmKj = FixedDateFormatter.formatYMZenkakuSeirekiKanji(jyutouStartYm.getFirstDay());

                if (kykSyouhn.getHknkkn() == 99) {

                    hknKknKj = "終身";
                }
                else {

                    if (C_HknkknsmnKbn.SAIMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {

                        hknKkn = kykSyouhn.getHknkkn() - kykSyouhn.getHhknnen();
                    }
                    else {

                        hknKkn = kykSyouhn.getHknkkn();
                    }

                    hknKknKj = Strings.padStart(ConvertUtil.toZenAll(String.valueOf(hknKkn), 1, 1), 2, '　') + "年";
                }

                // 未実装 TODO
                //                if (C_UmuKbn.ARI.eq(kjnnkKoujyum)) {
                //
                //                    nkShrkkn = sinkokuYokokuTuutiSksBean.getXXXXX(); TODO DAO未実装
                //                    nkShrkknKj = ConvertUtil.toZenAll(String.valueOf(nkShrkkn), 1, 1) + "年";
                //
                //                }
                //
                //                if (C_UmuKbn.ARI.eq(kjnnkKoujyum)) {
                //
                //                    nkshrstartYm = kykSyouhn.getHknkknmanryouymd().getBizDateYM();
                //                    nkshrstartYmKj =  FixedDateFormatter.formatYMZenkakuSeirekiKanji(nkshrstartYm.getFirstDay());
                //                }
                //
                //                if (C_UmuKbn.ARI.eq(kjnnkKoujyum)) {
                //                    if (C_HknkknsmnKbn.SAIMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {
                //
                //                        pHrkkkn =  kykSyouhn.getHrkkkn() - kykSyouhn.getHhknnen();
                //                    }
                //                    else {
                //
                //                        pHrkkkn =  kykSyouhn.getHrkkkn();
                //                    }
                //
                //                    pHrkkknKj =  ConvertUtil.toZenAll(String.valueOf(pHrkkkn), 1, 1) + "年";
                //                }

                if (kykSyouhn.getHknkkn() == 99) {

                    hknjyutoukikan = "終身";
                }
                else {

                    hknjyutoukikan = jyutouStartYmKj + "から" + hkryouJyutoukknNengetuKj + "分";
                }

                BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(
                    BzGetSosikiMadogutiInfo.class);
                BzGetSosikiMadogutiInfoKekkaBean ccSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
                    YuyuBizConfig.getInstance().getCallcentersosikicd());

                if (ccSosikiMadogutiInfoKekkaBean == null) {

                    continue;
                }

                toiawaseSosikiNmKj = ccSosikiMadogutiInfoKekkaBean.getKanjisosikinm();
                toiawaseYno = ccSosikiMadogutiInfoKekkaBean.getPostalCd();
                toiawaseAdr1Kj = ccSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1();
                toiawaseAdr2Kj = ccSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2();
                toiawaseAdr3Kj = ccSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3();
                toiawaseTelNo = ccSosikiMadogutiInfoKekkaBean.getTelno();
                toiawaseTelUktkKanou1 = YuyuBizConfig.getInstance().getUketimecallcenter1();
                toiawaseTelUktkKanou2 = YuyuBizConfig.getInstance().getUketimecallcenter2();

                // 未実装 TODO
                //                if (C_UmuKbn.NONE.eq(kjnnkKoujyum)) {

                if (kykUktSbuktLst.size() > 0) {
                    if (kykKihon.getSbuktnin() ==1) {
                        if (C_UktKbn.KYK.equals(kykUktSbuktLst.get(0).getUktkbn())) {

                            uktnmkj = ViewReport.editSama(sinkokuYokokuTuutiSksBean.getKyknmkj());

                        }
                        else if (C_UktKbn.HHKN.equals(kykUktSbuktLst.get(0).getUktkbn())) {

                            uktnmkj = ViewReport.editSama(sinkokuYokokuTuutiSksBean.getHhknnmkj());

                        }
                        else if (C_UktKbn.SOUZOKUNIN.equals(kykUktSbuktLst.get(0).getUktkbn())) {

                            uktnmkj = "法定相続人様";
                        }
                        else {
                            uktnmkj = ViewReport.editSama(kykUktSbuktLst.get(0).getUktnmkj());
                        }
                    }
                    else if (kykKihon.getSbuktnin() > 1) {
                        uktnmkj = "保険証券をご覧ください。";
                    }
                }

                //                }
                // 未実装 TODO
                //                else {
                //                if (C_UktKbn.HHKN.eq(kykUktNenkintLst.get(0).getUktkbn())) {
                //
                //                    uktnmkj = sinkokuYokokuTuutiSksBean.getHhknnmkj();
                //                    nenkinuktseiYmd = sinkokuYokokuTuutiSksBean.getHhknseiymd();
                //                }
                //                else if (C_UktKbn.KYK.eq(kykUktNenkintLst.get(0).getUktkbn())) {
                //
                //                    uktnmkj = sinkokuYokokuTuutiSksBean.getKyknmkj();
                //                    nenkinuktseiYmd = sinkokuYokokuTuutiSksBean.getKykseiymd();
                //                }
                //
                //                nenkinuktseiYmdKj = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(nenkinuktseiYmd);
                //                }
                //            }

                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);
                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(syono);

                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                }
                else {

                    hassouKbn = C_HassouKbn.TYOKUSOU;
                }

                IT_SinkokuyokokuTuuti sinkokuyokokuTuuti = new IT_SinkokuyokokuTuuti(syono, syoumeiNendo,
                    syoriYmd, 1);

                sinkokuyokokuTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_SINKOKUYOKOKUTUUTI);
                sinkokuyokokuTuuti.setHassoukbn(hassouKbn);
                sinkokuyokokuTuuti.setTsinyno(sinkokuYokokuTuutiSksBean.getTsinyno());
                sinkokuyokokuTuuti.setTsinadr1kj(sinkokuYokokuTuutiSksBean.getTsinadr1kj());
                sinkokuyokokuTuuti.setTsinadr2kj(sinkokuYokokuTuutiSksBean.getTsinadr2kj());
                sinkokuyokokuTuuti.setTsinadr3kj(sinkokuYokokuTuutiSksBean.getTsinadr3kj());
                sinkokuyokokuTuuti.setToiawasesosikinmkj(toiawaseSosikiNmKj);
                sinkokuyokokuTuuti.setToiawaseyno(toiawaseYno);
                sinkokuyokokuTuuti.setToiawaseadr1kj(toiawaseAdr1Kj);
                sinkokuyokokuTuuti.setToiawaseadr2kj(toiawaseAdr2Kj);
                sinkokuyokokuTuuti.setToiawaseadr3kj(toiawaseAdr3Kj);
                sinkokuyokokuTuuti.setToiawasetelno(toiawaseTelNo);
                sinkokuyokokuTuuti.setToiawaseteluktkkanou1(toiawaseTelUktkKanou1);
                sinkokuyokokuTuuti.setToiawaseteluktkkanou2(toiawaseTelUktkKanou2);
                sinkokuyokokuTuuti.setKyknmkj(sinkokuYokokuTuutiSksBean.getKyknmkj());
                sinkokuyokokuTuuti.setSinkokunen(syoumeiNendo);
                sinkokuyokokuTuuti.setMidasi1("証券番号");

                //                // 未実装  TODO
                //                if (C_UmuKbn.NONE.eq(kjnnkKoujyum)) {

                sinkokuyokokuTuuti.setMidasi2("保険種類");
                sinkokuyokokuTuuti.setMidasi3("保険期間");
                sinkokuyokokuTuuti.setMidasi4("保険金お受取人");
                //                }
                //                // 未実装 TODO
                //                else {
                //                    sinkokuyokokuTuuti.setMidasi2("年金種類");
                //                    sinkokuyokokuTuuti.setMidasi3("年金支払期間");
                //                    sinkokuyokokuTuuti.setMidasi4("年金支払開始年月");
                //                }
                sinkokuyokokuTuuti.setMidasi5("配当方法");

                //                // 未実装
                //                if (C_UmuKbn.NONE.eq(kjnnkKoujyum)) {

                sinkokuyokokuTuuti.setMidasi6("");
                sinkokuyokokuTuuti.setMidasi7("");
                //                }
                //                // 未実装
                //                else {
                //                    sinkokuyokokuTuuti.setMidasi6("年金お受取人");
                //                    sinkokuyokokuTuuti.setMidasi7("お受取人生年月日");
                //                }
                sinkokuyokokuTuuti.setKihonjouhoumongon1(sinkokuYokokuTuutiSksBean.getSyono());
                sinkokuyokokuTuuti.setKihonjouhoumongon2(syouhnZokusei.getHknsyuruikoujyosyoumei());

                //                // 未実装
                //                if (C_UmuKbn.NONE.eq(kjnnkKoujyum)) {

                sinkokuyokokuTuuti.setKihonjouhoumongon3(hknKknKj);
                sinkokuyokokuTuuti.setKihonjouhoumongon4(uktnmkj);

                if (C_HaitoukinuketorihouKbn.TUMIHAI.eq(sinkokuYokokuTuutiSksBean.getHaitoukinuketorihoukbn())) {

                    sinkokuyokokuTuuti.setKihonjouhoumongon5("積立");
                }
                else {

                    sinkokuyokokuTuuti.setKihonjouhoumongon5("無配当");
                }
                sinkokuyokokuTuuti.setKihonjouhoumongon6("");
                sinkokuyokokuTuuti.setKihonjouhoumongon7("");
                //                }
                //                // 未実装
                //                else {
                //                    sinkokuyokokuTuuti.setKihonjouhoumongon3(nkShrkknKj);
                //                    sinkokuyokokuTuuti.setKihonjouhoumongon4(nkshrstartYmKj);
                //                    sinkokuyokokuTuuti.setKihonjouhoumongon6(pHrkkknKj);
                //                    sinkokuyokokuTuuti.setKihonjouhoumongon6(uktnmkj);
                //                    sinkokuyokokuTuuti.setKihonjouhoumongon7(nenkinuktseiYmdKj);
                //                }
                sinkokuyokokuTuuti.setNewippanykkp(newIppanyoteip);
                sinkokuyokokuTuuti.setNewippanykkhaitoukin(newIppanyoteihaitoukin);
                sinkokuyokokuTuuti.setNewippanykksyoumeigk(newIppanyoteisyoumeigk);
                sinkokuyokokuTuuti.setNewiryouykkp(newKaigoiryouyoteip);
                sinkokuyokokuTuuti.setNewiryouykkhaitoukin(newKaigoiryouyoteihaitoukin);
                sinkokuyokokuTuuti.setNewiryouykksyoumeigk(newKaigoiryouyoteisyoumeig);
                sinkokuyokokuTuuti.setNewnenkinykkp(newNenkinyoteip);
                sinkokuyokokuTuuti.setNewnenkinykkhaitoukin(newNenkinyoteihaitoukin);
                sinkokuyokokuTuuti.setNewnenkinykksyoumeigk(newNenkinyoteisyoumeigk);
                sinkokuyokokuTuuti.setHknjyutoukikan(hknjyutoukikan);
                sinkokuyokokuTuuti.setKykymd(kykSyouhn.getKykymd());
                sinkokuyokokuTuuti.setHrkkaisuu(sinkokuYokokuTuutiSksBean.getHrkkaisuu());
                sinkokuyokokuTuuti.setGyoumuKousinKinou(kinouId);
                sinkokuyokokuTuuti.setGyoumuKousinsyaId(kosCd);
                sinkokuyokokuTuuti.setGyoumuKousinTime(kostime);

                BizPropertyInitializer.initialize(sinkokuyokokuTuuti);

                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(syono);
                editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.NONE);
                editTtdkRirekiTblParam.setSysTime(kostime);
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

                String sikibetuKey = khozenCommonParam.getSikibetuKey(syono);

                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                kykKihon.setSyhenkouymd(syoriYmd);
                kykKihon.setGyoumuKousinKinou(kinouId);
                kykKihon.setGyoumuKousinsyaId(kosCd);
                kykKihon.setGyoumuKousinTime(kostime);
                hozenDomManager.update(kykKihon);

                khSinkokuYokokuTuutiSksDao.addInserterEntity(entityInserter, sinkokuyokokuTuuti);

                syoriKensu = syoriKensu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.
            getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
