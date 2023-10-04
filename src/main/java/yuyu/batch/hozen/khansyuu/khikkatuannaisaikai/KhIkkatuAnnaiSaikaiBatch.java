package yuyu.batch.hozen.khansyuu.khikkatuannaisaikai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khikkatuannaisaikai.dba.KhIkkatuAnnaiSaikaiDao;
import yuyu.batch.hozen.khansyuu.khikkatuannaisaikai.dba.KhIkkatuAnnaiSaikaiDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakusei;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakuseiBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 一括案内再開
 */
public class KhIkkatuAnnaiSaikaiBatch implements Batch {

    private static final String TABLEID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhIkkatuAnnaiSaikaiDao khIkkatuAnnaiSaikaiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        long kensuu = 0;
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo =
            SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobcd));

        try (ExDBResults<KhIkkatuAnnaiSaikaiDataBean> exDBResults = khIkkatuAnnaiSaikaiDao
            .getKhIkkatuAnnaiSaikaiDataBean(syoriYm, kakutyoujobcd);
            EntityUpdater<IT_KykKihon> updater = new EntityUpdater<IT_KykKihon>();
            EntityInserter<BT_TjtIdouNyKh> entityInserter = new EntityInserter<BT_TjtIdouNyKh>();) {

            for (KhIkkatuAnnaiSaikaiDataBean bean : exDBResults) {

                String syoNo = bean.getSyono();
                khozenCommonParam = null;
                khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
                //                BizCurrency rsGaku = bean.getHrkP();
                //                Integer jyutouKaisuuM = 0;
                //                IT_KouzahuriStartAnnai kouzahuriStartAnnai = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(syoNo);
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    continue;
                }

                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syoNo);
                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
                    continue;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);


                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
                editKykSyhnRirekiTbl.exec(khozenCommonParam, syoNo);

                String sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);
                kykSyouhn.setHenkousikibetukey(sikibetuKey);
                kykSyouhn.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
                kykSyouhn.setGyoumuKousinKinou(kinouId);
                kykSyouhn.setGyoumuKousinsyaId(userId);
                kykSyouhn.setGyoumuKousinTime(sysDateTime);

                //                if (BizDateUtil.compareYm(bean.getJkipjytYm(), syoriYm.addMonths(1)) == BizDateUtil.COMPARE_EQUAL) {
                //
                //                    List<Integer> jyutouKaisuuMList = khIkkatuAnnaiSaikaiDao.getNyknJissekiRirekis(syoNo);
                //
                //                    if (jyutouKaisuuMList.size() > 0) {
                //                        jyutouKaisuuM = jyutouKaisuuMList.get(0);
                //                    }
                //                }
                //
                //                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
                //
                //                IT_DattaiUktk dattaiUktk = ansyuKihon.getDattaiUktk();
                //
                //                if (dattaiUktk != null && jyutouKaisuuM >= 6) {
                //                    IT_KykSya kykSya = kykKihon.getKykSya();
                //
                //                    if (kykSya == null) {
                //                        throw new CommonBizAppException("契約者テーブルにデータが存在しません。");
                //                    }
                //
                //                    IT_HhknSya hhknSya = kykKihon.getHhknSya();
                //
                //                    if (hhknSya == null) {
                //                        throw new CommonBizAppException("被保険者テーブルにデータが存在しません。");
                //                    }
                //
                //                    IT_Kouza kouza = kykKihon.getKouza();
                //
                //                    if (kouza == null) {
                //                        throw new CommonBizAppException("口座テーブルにデータが存在しません。");
                //                    }
                //
                //                    BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(kouza.getBankcd(), kouza.getSitencd());
                //
                //                    String bankNmKj = bzGetBankDataBean.getBankNmKj();
                //                    String reportSitenNm = bzGetBankDataBean.getReportSitenNm();
                //
                //                    BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(bean.getSyouhnCd(),
                //                        bean.getSyouhnsdNo());
                //
                //                    String syouhnNmSyouken = syouhnZokusei.getSyouhnnmsyouken();
                //
                //                    String kouzaNo = KhozenEdit.editKouzaNo(kouza.getBankcd(), kouza.getKouzano());
                //
                //                    BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean =
                //                        bzGetSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());
                //
                //                    kouzahuriStartAnnai = new IT_KouzahuriStartAnnai(syoNo, syoriYmd);
                //
                //                    kouzahuriStartAnnai.setKyknmkj(kykSya.getKyknmkj());
                //                    kouzahuriStartAnnai.setTsinyno(kykSya.getTsinyno());
                //                    kouzahuriStartAnnai.setTsinadr1kj(kykSya.getTsinadr1kj());
                //                    kouzahuriStartAnnai.setTsinadr2kj(kykSya.getTsinadr2kj());
                //                    kouzahuriStartAnnai.setTsinadr3kj(kykSya.getTsinadr3kj());
                //                    kouzahuriStartAnnai.setKykymd(bean.getKykYmd());
                //                    kouzahuriStartAnnai.setHhknnmkj(hhknSya.getHhknnmkj());
                //                    kouzahuriStartAnnai.setSyouhnnm(syouhnNmSyouken);
                //                    kouzahuriStartAnnai.setTuutinm("口座振替のご案内");
                //                    kouzahuriStartAnnai.setAisatumongon1("いつもお引立てをいただきありがとうございます。");
                //                    kouzahuriStartAnnai.setAisatumongon2("お客さまのご契約の保険料をご指定の預金口座から");
                //                    kouzahuriStartAnnai.setAisatumongon3("振替させていただきます。");
                //                    kouzahuriStartAnnai.setAisatumongon4("今後ともご愛顧を賜りますよう、よろしく");
                //                    kouzahuriStartAnnai.setAisatumongon5("お願い申し上げます。");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai1(
                //                        "・振替日は毎月２７日（金融機関休日の場合は翌営業日）ですので、振替日の");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai2("　前営業日までに保険料を口座にご準備ください。");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai3("");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai4(
                //                        "・毎月の口座振替結果につきましては、“領収証”は発行いたしませんので、");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai5(
                //                        "　お手元の預金通帳等で確認いただきますようお願いいたします。");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai6("");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai7(
                //                        "・万一２７日に振替できない場合には、その旨をご通知させていただいたうえ");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai8(
                //                        "　で、特別な場合を除き翌月に２か月分あわせて振替させていただきます。");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai9(
                //                        "　なお、翌月もご案内金額（２か月分）が振替できない場合、お払込猶予期間");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai10(
                //                        "　を過ぎますと、ご契約の効力を失うか、もしくは主契約の解約返戻金の範囲");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai11(
                //                        "　内で保険ファンドからの保険料払込み（またはお立替）をさせていただきま");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai12("　すので、あらかじめご了承ください。");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai13("");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai14("");
                //                    kouzahuriStartAnnai.setKzhurikaeonegai15("");
                //                    kouzahuriStartAnnai.setTkbriphurikaeyoteigk(rsGaku.toString());
                //                    kouzahuriStartAnnai.setHurikaekzhosokumongon(
                //                        "　　　　　　　　　（お客さま情報保護のため一部を＊表示）");
                //                    kouzahuriStartAnnai.setHurikaekz1(bankNmKj);
                //                    kouzahuriStartAnnai.setHurikaekz2(reportSitenNm);
                //                    if ("9900".equals(kouza.getBankcd())) {
                //                        kouzahuriStartAnnai.setHurikaekz3("通帳番号　" + kouzaNo);
                //                    }
                //                    else {
                //                        kouzahuriStartAnnai.setHurikaekz3(kouza.getYokinkbn().getContent() +
                //                            "預金　　　　　　　　　口座番号　" + kouzaNo);
                //                    }
                //                    kouzahuriStartAnnai.setHurikaekz4("口座名義人　" + kouza.getKzmeiginmkn() + "　様");
                //                    kouzahuriStartAnnai.setHurikaekz5(
                //                        "（改姓等で口座名義を変更されている場合は、表面の照会先までご連絡ください。）");
                //                    kouzahuriStartAnnai.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                //                    kouzahuriStartAnnai.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                //                    kouzahuriStartAnnai.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                //                    kouzahuriStartAnnai.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                //                    kouzahuriStartAnnai.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                //                    kouzahuriStartAnnai.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                //                    kouzahuriStartAnnai.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
                //                    kouzahuriStartAnnai.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
                //                    kouzahuriStartAnnai.setSyoruiCd(C_SyoruiCdKbn.KK_KOUHURISAIKAIANNAI);
                //                    kouzahuriStartAnnai.setHassoukbn(C_HassouKbn.TYOKUSOU);
                //                    kouzahuriStartAnnai.setGyoumuKousinKinou(kinouId);
                //                    kouzahuriStartAnnai.setGyoumuKousinsyaId(userId);
                //                    kouzahuriStartAnnai.setGyoumuKousinTime(sysDateTime);
                //
                //                    BizPropertyInitializer.initialize(kouzahuriStartAnnai);
                //                }

                PALKykNaiyouSakusei pALKykNaiyouSakusei = SWAKInjector.getInstance(PALKykNaiyouSakusei.class);
                PALKykNaiyouSakuseiBean pALKykNaiyouSakuseiBean = SWAKInjector.getInstance(PALKykNaiyouSakuseiBean.class);
                pALKykNaiyouSakuseiBean.setKykKihon(kykKihon);

                C_ErrorKbn errorKbn = pALKykNaiyouSakusei.exec(pALKykNaiyouSakuseiBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException("当日異動内容契約保全テーブルの作成に失敗しました。");
                }

                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(syoNo);
                editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                editTtdkRirekiTblParam.setSysTime(sysDateTime);

                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                BizPropertyInitializer.initialize(khTtdkRireki);

                EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);


                updater.add(kykKihon);

                //                if (kouzahuriStartAnnai != null) {
                //                    inserter.add(kouzahuriStartAnnai);
                //                }
                //
                //                ansyuKihon.detach();

                entityInserter.add(pALKykNaiyouSakusei.getTjtIdouNyKh());

                kensuu++;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.
            getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
