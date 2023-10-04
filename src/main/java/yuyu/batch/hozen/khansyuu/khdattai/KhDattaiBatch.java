package yuyu.batch.hozen.khansyuu.khdattai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khansyuu.khdattai.dba.DattaiBean;
import yuyu.batch.hozen.khansyuu.khdattai.dba.KhDattaiDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.CreditCardNoHensyuu;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_DattaiTuutiKzhuri;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;

/**
 * 契約保全 案内収納 脱退処理のバッチクラスです。
 */
public class KhDattaiBatch implements Batch {

    private static final String TABLEID = IT_TRDattai.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    private static final String OSIRASE_MONGON_1 = "";

    private static final String OSIRASE_MONGON_2 = "いつもお引立てをいただきありがとうございます。";

    private static final String OSIRASE_MONGON_3 = "";

    private static final String OSIRASE_MONGON_4_1 = "お客さまのご契約につきまして、金融機関より";

    private static final String OSIRASE_MONGON_4_2 = "の振替日に口座振替ができない旨連絡がありました。";

    private static final String OSIRASE_MONGON_5 = "つきましては、現在口座振替を中止しております。同封の生命保険料口座振替依頼書をご返送くださいますよう";

    private static final String OSIRASE_MONGON_6 = "お願いいたします。";

    private static final String OSIRASE_MONGON_7 = "";

    private static final String OSIRASE_MONGON_8 = "";

    private static final String OSIRASE_MONGON_9 = "";

    private static final String OSIRASE_CREDITCARDINFOMDS = "【ご利用のクレジットカード】";

    private static final String OSIRASE_CARDBRAND = "　";

    private static final String OSIRASE_CARDNO = "　カード番号　　";

    private static final String OSIRASE_CREDITCARDMASKINGMSG = "　※お客さま情報保護のため、クレジットカード番号の一部を＊にて表示しています。";

    private static final String OSIRASE_CREDIT_MONGON_1 = "いつもお引立ていただきありがとうございます。";

    private static final String OSIRASE_CREDIT_MONGON_2 = "";

    private static final String OSIRASE_CREDIT_MONGON_3 = "次のご契約につきましては、現在、クレジットカードにより保険料をお払い込みいただいていますが、";

    private static final String OSIRASE_CREDIT_MONGON_4 = "このたび、クレジットカード会社より、ご登録のクレジットカードについてお払込みにご利用いただ";

    private static final String OSIRASE_CREDIT_MONGON_5 = "けない旨の連絡がございました。";

    private static final String OSIRASE_CREDIT_MONGON_6_1 = "このままでは、";

    private static final String OSIRASE_CREDIT_MONGON_6_2 = "分以降の保険料のお払込みができなくなるため、お払込方法（クレ";

    private static final String OSIRASE_CREDIT_MONGON_7 = "ジットカード）の変更手続きをお願いいたします。";

    private static final String OSIRASE_CREDIT_MONGON_8 = "なお、このご案内と行き違いにお手続きをいただいている場合は、あしからずご了承ください。";

    private static final String OSIRASE_CREDIT_MONGON_9 = "";

    private static final String OSIRASE_CREDIT_MONGON_10 = "今後とも変わらぬご愛顧を賜りますようお願いいたします。";

    private static final String OSIRASE_GOIRAIJIKOUTOUMONGON1 = "■ご依頼事項等";

    private static final String OSIRASE_GOIRAIJIKOUTOUMONGON2 = "　同封の「保険料クレジットカード扱い申込書」に必要事項をご記入のうえ、";

    private static final String OSIRASE_GOIRAIJIKOUTOUMONGON3_1 = "　";

    private static final String OSIRASE_GOIRAIJIKOUTOUMONGON3_2 = "までに同封の返信封筒にてご投函ください。";

    private static final String OSIRASE_PHRKMONGON1 = "■保険料のお払込みについて";

    private static final String OSIRASE_PHRKMONGON2_1 = "　";

    private static final String OSIRASE_PHRKMONGON2_2 = "分以降の保険料は、毎月１５日（カードご利用日）に、クレジットカードにて決済";

    private static final String OSIRASE_PHRKMONGON3 = "　させていただきます。";

    private static final String OSIRASE_PHRKMONGON4 = "　なお、ご変更後のクレジットカードによる決済開始時期は前後することがありますので、変更手続き";

    private static final String OSIRASE_PHRKMONGON5 = "　完了後のお知らせにてご確認ください。（ご指定口座からの振替日はクレジットカード会社によって";

    private static final String OSIRASE_PHRKMONGON6 = "　異なり、ご利用日の翌月や翌々月となることがあります。）";

    private static final String OSIRASE_PHRKMONGON7 = "";

    private static final String OSIRASE_PHRKMONGON8 = "※保険料円貨払込特約（円貨払込額指定型）の付加された契約は、円貨払込額について「保険料」と";

    private static final String OSIRASE_PHRKMONGON9 = "　表示しております。";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhDattaiDao khDattaiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl  editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        long syoriKensuu = 0;
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouID = khozenCommonParam.getFunctionId();
        String kosID = khozenCommonParam.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        List<EditKhMisslstParam> misslstPrmLstKouhuriTs = new ArrayList<>();
        List<EditKhMisslstParam> misslstPrmLstKouhuriTsg = new ArrayList<>();
        List<EditKhMisslstParam> misslstPrmLstCreditTs = new ArrayList<>();
        List<EditKhMisslstParam> misslstPrmLstCreditTsg = new ArrayList<>();
        CreditCardNoHensyuu creditCardNoHensyuu = SWAKInjector.getInstance(CreditCardNoHensyuu.class);
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYMD)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        try (ExDBResults<DattaiBean> dattaiBeanLst = khDattaiDao.getDattaiBean(kakutyouJobCd);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            EntityInserter<IT_DattaiTuutiKzhuri> dattaiTuutiKzhuriIns = new EntityInserter<>();
            EntityInserter<IT_YuukouseiNgTuuti> yuukouseiNgTuutiIns = new EntityInserter<>();
            EntityDeleter<IT_TRDattai> tRDattaiEntityDeleter = new EntityDeleter<>();) {
            int countKouhuriTs = 0;
            int countKouhuriTsg = 0;
            int countCreditTs = 0;
            int countCreditTsg = 0;

            IT_DattaiUktk dattaiUktkAdd;

            IT_DattaiTuutiKzhuri dattaiTuutiKzhuri = null;

            IT_YuukouseiNgTuuti yuukouseiNgTuuti = null;

            BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
            BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
                YuyuBizConfig.getInstance().getCallcentersosikicd());

            for (DattaiBean dattaiBean : dattaiBeanLst) {

                String syoNo = dattaiBean.getSyono();
                C_NyknaiyouKbn nyknaiyouKbn = dattaiBean.getNyknaiyouKbn();
                BizDateYM dattaiym = dattaiBean.getDattaiym();
                C_Nykkeiro nykkeiro = dattaiBean.getNykkeiro();
                Integer jyutoukaisuuy = dattaiBean.getJyutoukaisuuy();
                Integer jyutoukaisuum = dattaiBean.getJyutoukaisuum();
                String dattaitrrenno = dattaiBean.getDattaitrrenno();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dattaiBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);
                checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(syoNo);

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                    String message2 = MessageUtil.getMessage(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());

                    if (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {

                        countCreditTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countCreditTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstCreditTsg.add(editKhMisslstParam);
                    }
                    else {

                        countKouhuriTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countKouhuriTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstKouhuriTsg.add(editKhMisslstParam);
                    }

                    IT_TRDattai tRDattai = hozenDomManager.getTRDattai(
                        syoNo,
                        dattaiBean.getSyoriYmd(),
                        dattaitrrenno);

                    tRDattaiEntityDeleter.add(tRDattai);

                    continue;
                }

                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syoNo);

                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

                    String message2 = "手続注意設定あり";

                    if (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {

                        countCreditTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countCreditTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstCreditTsg.add(editKhMisslstParam);
                    }
                    else {

                        countKouhuriTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countKouhuriTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstKouhuriTsg.add(editKhMisslstParam);
                    }

                    IT_TRDattai tRDattai = hozenDomManager.getTRDattai(
                        syoNo,
                        dattaiBean.getSyoriYmd(),
                        dattaitrrenno);

                    tRDattaiEntityDeleter.add(tRDattai);

                    continue;
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

                if (!C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro()) &&
                    !C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {

                    countKouhuriTsg ++;

                    EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                        countKouhuriTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, "脱退経路対象外");

                    misslstPrmLstKouhuriTsg.add(editKhMisslstParam);

                    IT_TRDattai tRDattai = hozenDomManager.getTRDattai(
                        syoNo,
                        dattaiBean.getSyoriYmd(),
                        dattaitrrenno);

                    tRDattaiEntityDeleter.add(tRDattai);

                    continue;
                }

                if ((C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro()) && !C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro()))
                    || (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro()) && !C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro()))) {

                    String message2 = "脱退経路と払込経路の相違（払込経路："+ kykKihon.getHrkkeiro().getContent() + "）";

                    if (C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro())) {

                        countKouhuriTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countKouhuriTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstKouhuriTsg.add(editKhMisslstParam);
                    }
                    else if (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {

                        countCreditTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countCreditTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstCreditTsg.add(editKhMisslstParam);
                    }

                    IT_TRDattai tRDattai = hozenDomManager.getTRDattai(
                        syoNo,
                        dattaiBean.getSyoriYmd(),
                        dattaitrrenno);

                    tRDattaiEntityDeleter.add(tRDattai);

                    continue;
                }

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);

                if (BizDateUtil.compareYm(ansyuKihon.getJkipjytym(), dattaiBean.getDattaiym()) != BizDateUtil.COMPARE_EQUAL) {

                    String message2 = "次回Ｐ充当年月と脱退年月の相違（次回Ｐ充当年月：" +
                        DateFormatUtil.dateKANJISeirekiNoZero(ansyuKihon.getJkipjytym().getFirstDay()).substring(0, 8) + "）";

                    if (C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro())) {

                        countKouhuriTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countKouhuriTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstKouhuriTsg.add(editKhMisslstParam);
                    }
                    else if (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {

                        countCreditTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countCreditTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, message2);

                        misslstPrmLstCreditTsg.add(editKhMisslstParam);
                    }

                    IT_TRDattai tRDattai = hozenDomManager.getTRDattai(
                        syoNo,
                        dattaiBean.getSyoriYmd(),
                        dattaitrrenno);

                    tRDattaiEntityDeleter.add(tRDattai);

                    continue;
                }

                if (C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro())) {

                    List<IT_AnsyuRireki> ansyuRirekiList = khDattaiDao.getAnsyuRirekis(
                        ansyuKihon,
                        nyknaiyouKbn,
                        dattaiym,
                        nykkeiro,
                        jyutoukaisuuy,
                        jyutoukaisuum,
                        dattaiBean.getHurikaeymd());

                    IT_AnsyuRireki ansyuRireki = ansyuRirekiList.get(0);

                    IT_Kouza kouza = kykKihon.getKouza();

                    if (!(kouza.getBankcd().equals(ansyuRireki.getBankcd())) ||
                        !(kouza.getSitencd().equals(ansyuRireki.getSitencd())) ||
                        !(kouza.getYokinkbn().eq(ansyuRireki.getYokinkbn())) ||
                        !(kouza.getKouzano().equals(ansyuRireki.getKouzano())) ||
                        !(kouza.getKzmeiginmkn().equals(ansyuRireki.getKzmeiginmkn()))) {

                        countKouhuriTsg ++;

                        EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                            countKouhuriTsg, dattaiBean.getDattaikeiro(), C_Dbhanei.NONE, "口座情報の相違");

                        misslstPrmLstKouhuriTsg.add(editKhMisslstParam);

                        IT_TRDattai tRDattai = hozenDomManager.getTRDattai(
                            syoNo,
                            dattaiBean.getSyoriYmd(),
                            dattaitrrenno);

                        tRDattaiEntityDeleter.add(tRDattai);

                        continue;
                    }
                }

                String comment = "";

                if (C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro())) {

                    comment = "振替不能理由区分／収納結果脱退：" + dattaiBean.getHurihunokbn().getContent() + "\r\n" +
                        "振替日：" + DateFormatUtil.dateKANJISeirekiNoZero(dattaiBean.getHurikaeymd());

                    countKouhuriTs ++;

                    EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                        countKouhuriTs, dattaiBean.getDattaikeiro(), C_Dbhanei.SUMI, comment.replace("\r\n", "　"));

                    misslstPrmLstKouhuriTs.add(editKhMisslstParam);

                }
                else if (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {

                    comment = "クレジット有効確認時脱退";

                    countCreditTs ++;

                    EditKhMisslstParam editKhMisslstParam = createEditKhMisslstParam(syoNo,
                        countCreditTs, dattaiBean.getDattaikeiro(), C_Dbhanei.SUMI, comment);

                    misslstPrmLstCreditTs.add(editKhMisslstParam);
                }

                dattaiUktkAdd = ansyuKihon.createDattaiUktk();
                dattaiUktkAdd.setSyoriYmd(dattaiBean.getSyoriYmd());
                dattaiUktkAdd.setSyorisosikicd(C_Tantositucd.SYUUNOUSV.getValue() + "0000");
                dattaiUktkAdd.setDattaikeiro(dattaiBean.getDattaikeiro());
                dattaiUktkAdd.setDattairiyuukbn(C_DattairiyuuKbn.HRHENKIBOU);
                dattaiUktkAdd.setDattaiym(dattaiBean.getDattaiym());
                dattaiUktkAdd.setBankcd(dattaiBean.getBankcd());
                dattaiUktkAdd.setSitencd(dattaiBean.getSitencd());
                dattaiUktkAdd.setYokinkbn(dattaiBean.getYokinkbn());
                dattaiUktkAdd.setKouzano(dattaiBean.getKouzano());
                dattaiUktkAdd.setHurihunokbn(dattaiBean.getHurihunokbn());
                dattaiUktkAdd.setHurikaeymd(dattaiBean.getHurikaeymd());
                dattaiUktkAdd.setCreditdatakbn(dattaiBean.getCreditdatakbn());
                dattaiUktkAdd.setCreditcardno1(dattaiBean.getCreditcardno1());
                dattaiUktkAdd.setCreditcardno2(dattaiBean.getCreditcardno2());
                dattaiUktkAdd.setCreditcardno3(dattaiBean.getCreditcardno3());
                dattaiUktkAdd.setCreditcardno4(dattaiBean.getCreditcardno4());
                dattaiUktkAdd.setCreditbrerrorcd(dattaiBean.getCreditbrerrorcd());
                dattaiUktkAdd.setJkipjytym(ansyuKihon.getJkipjytym());
                dattaiUktkAdd.setComment124keta(comment);
                dattaiUktkAdd.setGyoumuKousinKinou(kinouID);
                dattaiUktkAdd.setGyoumuKousinsyaId(kosID);
                dattaiUktkAdd.setGyoumuKousinTime(sysDateTime);
                dattaiUktkAdd.setCreditkessaiyouno(dattaiBean.getCreditkessaiyouno());

                BizPropertyInitializer.initialize(dattaiUktkAdd);

                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
                khozenCommonParam.setSikibetuKey(null);
                khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(syoNo));

                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(syoNo);
                editTtdkRirekiTblParam.setSyoriYmd(syoriYMD);
                editTtdkRirekiTblParam.setSysTime(sysDateTime);
                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);


                IT_KykSya kykSya = kykKihon.getKykSya();

                IT_HhknSya hhknSya = kykKihon.getHhknSya();

                C_HassouKbn hassouKbn =  C_HassouKbn.HONSYAKAISOU;

                if (C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro())) {

                    BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(dattaiBean.getBankcd(),
                        dattaiBean.getSitencd());

                    String bankNmKj = bzGetBankDataBean.getBankNmKj();
                    String reportSitenNm = bzGetBankDataBean.getReportSitenNm();

                    String kouzaNoMsk = ConvertUtil.toZenAll(KhozenEdit.editKouzaNo(dattaiBean.getBankcd(), dattaiBean.getKouzano()), 0, 0);

                    String kzInfo1 = bankNmKj;
                    String kzInfo2 = reportSitenNm;
                    String kzInfo3;

                    if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(dattaiBean.getBankcd())) {

                        kzInfo3 = "通帳番号　" + kouzaNoMsk;
                    }
                    else {

                        kzInfo3 = C_YokinKbn.getContentByValue(C_YokinKbn.PATTERN_TYOUHYOU,
                            dattaiBean.getYokinkbn().getValue()) + "　　口座番号　" + kouzaNoMsk;
                    }

                    String kouzamaskingMsg = "";
                    if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(dattaiBean.getBankcd())) {

                        kouzamaskingMsg = "＊お客さま情報保護のため、通帳番号の一部を＊にて表示しています。";
                    }
                    else {

                        kouzamaskingMsg = "＊お客さま情報保護のため、口座番号の一部を＊にて表示しています。";
                    }

                    String osirasemongon1 = OSIRASE_MONGON_1;
                    String osirasemongon2 = OSIRASE_MONGON_2;
                    String osirasemongon3 = OSIRASE_MONGON_3;
                    String osirasemongon4 = OSIRASE_MONGON_4_1 + FixedDateFormatter.
                        formatMDZenkakuKanji(dattaiBean.getHurikaeymd()) + OSIRASE_MONGON_4_2;
                    String osirasemongon5 = OSIRASE_MONGON_5;
                    String osirasemongon6 = OSIRASE_MONGON_6;
                    String osirasemongon7 = OSIRASE_MONGON_7;
                    String osirasemongon8 = OSIRASE_MONGON_8;
                    String osirasemongon9 = OSIRASE_MONGON_9;

                    dattaiTuutiKzhuri = new IT_DattaiTuutiKzhuri(syoNo, syoriYMD);
                    dattaiTuutiKzhuri.setShskyno(kykSya.getTsinyno());
                    dattaiTuutiKzhuri.setShsadr1kj(kykSya.getTsinadr1kj());
                    dattaiTuutiKzhuri.setShsadr2kj(kykSya.getTsinadr2kj());
                    dattaiTuutiKzhuri.setShsadr3kj(kykSya.getTsinadr3kj());
                    dattaiTuutiKzhuri.setShsnmkj(kykSya.getKyknmkj());
                    dattaiTuutiKzhuri.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                    dattaiTuutiKzhuri.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                    dattaiTuutiKzhuri.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                    dattaiTuutiKzhuri.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                    dattaiTuutiKzhuri.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                    dattaiTuutiKzhuri.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                    dattaiTuutiKzhuri.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
                    dattaiTuutiKzhuri.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
                    dattaiTuutiKzhuri.setOsirasemongon1(osirasemongon1);
                    dattaiTuutiKzhuri.setOsirasemongon2(osirasemongon2);
                    dattaiTuutiKzhuri.setOsirasemongon3(osirasemongon3);
                    dattaiTuutiKzhuri.setOsirasemongon4(osirasemongon4);
                    dattaiTuutiKzhuri.setOsirasemongon5(osirasemongon5);
                    dattaiTuutiKzhuri.setOsirasemongon6(osirasemongon6);
                    dattaiTuutiKzhuri.setOsirasemongon7(osirasemongon7);
                    dattaiTuutiKzhuri.setOsirasemongon8(osirasemongon8);
                    dattaiTuutiKzhuri.setOsirasemongon9(osirasemongon9);

                    dattaiTuutiKzhuri.setHhknnmkj(hhknSya.getHhknnmkj());
                    dattaiTuutiKzhuri.setKzinfo30keta1(kzInfo1);
                    dattaiTuutiKzhuri.setKzinfo30keta2(kzInfo2);
                    dattaiTuutiKzhuri.setKzinfo30keta3(kzInfo3);
                    dattaiTuutiKzhuri.setKouzamaskingmsg(kouzamaskingMsg);
                    dattaiTuutiKzhuri.setSyoruiCd(C_SyoruiCdKbn.AS_DATTAITUUTI_KOUHURI);
                    dattaiTuutiKzhuri.setHassoukbn(hassouKbn);
                    dattaiTuutiKzhuri.setGyoumuKousinKinou(kinouID);
                    dattaiTuutiKzhuri.setGyoumuKousinsyaId(kosID);
                    dattaiTuutiKzhuri.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(dattaiTuutiKzhuri);
                }

                else if (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {
                    String cardBrandNm = OSIRASE_CARDBRAND + dattaiBean.getCardbrandkbn().getContent();
                    String creditCardNo = OSIRASE_CARDNO + creditCardNoHensyuu.exec(
                        dattaiBean.getCardbrandkbn(), dattaiBean.getCreditkaiinnosimo4keta());

                    String nextHrkYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(ansyuKihon.getJkipjytym().getFirstDay());

                    BizDate dattaiym20 = BizDate.valueOf(dattaiBean.getDattaiym(), 20);
                    if (!dattaiym20.isBusinessDay()) {
                        dattaiym20 = dattaiym20.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
                    }
                    String henshinKigenYmd = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(dattaiym20);

                    String osirasemongon1 = OSIRASE_CREDIT_MONGON_1;
                    String osirasemongon2 = OSIRASE_CREDIT_MONGON_2;
                    String osirasemongon3 = OSIRASE_CREDIT_MONGON_3;
                    String osirasemongon4 = OSIRASE_CREDIT_MONGON_4;
                    String osirasemongon5 = OSIRASE_CREDIT_MONGON_5;
                    String osirasemongon6 = OSIRASE_CREDIT_MONGON_6_1 + nextHrkYm + OSIRASE_CREDIT_MONGON_6_2;
                    String osirasemongon7 = OSIRASE_CREDIT_MONGON_7;
                    String osirasemongon8 = OSIRASE_CREDIT_MONGON_8;
                    String osirasemongon9 = OSIRASE_CREDIT_MONGON_9;
                    String osirasemongon10 = OSIRASE_CREDIT_MONGON_10;
                    String goiraijikoutoumongon1 = OSIRASE_GOIRAIJIKOUTOUMONGON1;
                    String goiraijikoutoumongon2 = OSIRASE_GOIRAIJIKOUTOUMONGON2;
                    String goiraijikoutoumongon3 = OSIRASE_GOIRAIJIKOUTOUMONGON3_1 + henshinKigenYmd + OSIRASE_GOIRAIJIKOUTOUMONGON3_2;

                    String phrkmongon1 = OSIRASE_PHRKMONGON1;
                    String phrkmongon2 = OSIRASE_PHRKMONGON2_1 + nextHrkYm + OSIRASE_PHRKMONGON2_2;
                    String phrkmongon3 = OSIRASE_PHRKMONGON3;
                    String phrkmongon4 = OSIRASE_PHRKMONGON4;
                    String phrkmongon5 = OSIRASE_PHRKMONGON5;
                    String phrkmongon6 = OSIRASE_PHRKMONGON6;
                    String phrkmongon7 = OSIRASE_PHRKMONGON7;
                    String phrkmongon8 = OSIRASE_PHRKMONGON8;
                    String phrkmongon9 = OSIRASE_PHRKMONGON9;

                    yuukouseiNgTuuti = new IT_YuukouseiNgTuuti(syoNo, syoriYMD);

                    yuukouseiNgTuuti.setShskyno(kykSya.getTsinyno());
                    yuukouseiNgTuuti.setShsadr1kj(kykSya.getTsinadr1kj());
                    yuukouseiNgTuuti.setShsadr2kj(kykSya.getTsinadr2kj());
                    yuukouseiNgTuuti.setShsadr3kj(kykSya.getTsinadr3kj());
                    yuukouseiNgTuuti.setShsnmkj(kykSya.getKyknmkj());
                    yuukouseiNgTuuti.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
                    yuukouseiNgTuuti.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
                    yuukouseiNgTuuti.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
                    yuukouseiNgTuuti.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
                    yuukouseiNgTuuti.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
                    yuukouseiNgTuuti.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
                    yuukouseiNgTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
                    yuukouseiNgTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
                    yuukouseiNgTuuti.setOsirasemongon46keta1(osirasemongon1);
                    yuukouseiNgTuuti.setOsirasemongon46keta2(osirasemongon2);
                    yuukouseiNgTuuti.setOsirasemongon46keta3(osirasemongon3);
                    yuukouseiNgTuuti.setOsirasemongon46keta4(osirasemongon4);
                    yuukouseiNgTuuti.setOsirasemongon46keta5(osirasemongon5);
                    yuukouseiNgTuuti.setOsirasemongon46keta6(osirasemongon6);
                    yuukouseiNgTuuti.setOsirasemongon46keta7(osirasemongon7);
                    yuukouseiNgTuuti.setOsirasemongon46keta8(osirasemongon8);
                    yuukouseiNgTuuti.setOsirasemongon46keta9(osirasemongon9);
                    yuukouseiNgTuuti.setOsirasemongon46keta10(osirasemongon10);
                    yuukouseiNgTuuti.setKyknmkj(kykSya.getKyknmkj());
                    yuukouseiNgTuuti.setHokenryou(kykKihon.getHrkp());
                    yuukouseiNgTuuti.setCreditcardinfo1(OSIRASE_CREDITCARDINFOMDS);
                    yuukouseiNgTuuti.setCreditcardinfo2(cardBrandNm);
                    yuukouseiNgTuuti.setCreditcardinfo3(creditCardNo);
                    yuukouseiNgTuuti.setCreditcardmaskingmsg(OSIRASE_CREDITCARDMASKINGMSG);
                    yuukouseiNgTuuti.setGoiraijikoutoumongon1(goiraijikoutoumongon1);
                    yuukouseiNgTuuti.setGoiraijikoutoumongon2(goiraijikoutoumongon2);
                    yuukouseiNgTuuti.setGoiraijikoutoumongon3(goiraijikoutoumongon3);
                    yuukouseiNgTuuti.setPhrkmongon1(phrkmongon1);
                    yuukouseiNgTuuti.setPhrkmongon2(phrkmongon2);
                    yuukouseiNgTuuti.setPhrkmongon3(phrkmongon3);
                    yuukouseiNgTuuti.setPhrkmongon4(phrkmongon4);
                    yuukouseiNgTuuti.setPhrkmongon5(phrkmongon5);
                    yuukouseiNgTuuti.setPhrkmongon6(phrkmongon6);
                    yuukouseiNgTuuti.setPhrkmongon7(phrkmongon7);
                    yuukouseiNgTuuti.setPhrkmongon8(phrkmongon8);
                    yuukouseiNgTuuti.setPhrkmongon9(phrkmongon9);
                    yuukouseiNgTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_YUUKOUSEINGTUUTI);
                    yuukouseiNgTuuti.setHassoukbn(hassouKbn);
                    yuukouseiNgTuuti.setGyoumuKousinKinou(kinouID);
                    yuukouseiNgTuuti.setGyoumuKousinsyaId(kosID);
                    yuukouseiNgTuuti.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(yuukouseiNgTuuti);
                }

                multipleEntityUpdater.add(ansyuKihon);
                multipleEntityUpdater.add(kykKihon);
                if (C_Dattaikeiro.KOUHURI.eq(dattaiBean.getDattaikeiro())) {

                    dattaiTuutiKzhuriIns.add(dattaiTuutiKzhuri);

                }
                else if (C_Dattaikeiro.CREDIT.eq(dattaiBean.getDattaikeiro())) {

                    yuukouseiNgTuutiIns.add(yuukouseiNgTuuti);
                }

                IT_TRDattai tRDattai = hozenDomManager.getTRDattai(
                    syoNo,
                    dattaiBean.getSyoriYmd(),
                    dattaitrrenno);

                tRDattaiEntityDeleter.add(tRDattai);

                syoriKensuu = syoriKensuu + 1;
            }
            if (misslstPrmLstKouhuriTs.size() > 0) {
                createReport.execNoCommit(editKhMisslstTbl.editBean(
                    C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU ,
                    khozenCommonParam,
                    misslstPrmLstKouhuriTs,
                    syoriYMD));
            }

            if (misslstPrmLstKouhuriTsg.size() > 0) {
                createReport.execNoCommit(editKhMisslstTbl.editBean(
                    C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU ,
                    khozenCommonParam,
                    misslstPrmLstKouhuriTsg,
                    syoriYMD));
            }

            if (misslstPrmLstCreditTs.size() > 0) {
                createReport.execNoCommit(editKhMisslstTbl.editBean(
                    C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU ,
                    khozenCommonParam,
                    misslstPrmLstCreditTs,
                    syoriYMD));
            }

            if (misslstPrmLstCreditTsg.size() > 0) {
                createReport.execNoCommit(editKhMisslstTbl.editBean(
                    C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU ,
                    khozenCommonParam,
                    misslstPrmLstCreditTsg,
                    syoriYMD));
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private EditKhMisslstParam createEditKhMisslstParam(String pSyoNo, int pCount, C_Dattaikeiro pDattaikeiro,
        C_Dbhanei pDbHaneikbn, String pMessage2) {

        String message = null;

        if (C_Dbhanei.NONE.eq(pDbHaneikbn)) {

            message = pDattaikeiro.getContent() + "／脱退処理されませんでした。"+ "\r\n" + "対象外理由：" + pMessage2;
        }
        else {

            message = pDattaikeiro.getContent() + "／脱退処理を行いました。"+ "\r\n" + pMessage2;
        }

        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

        editKhMisslstParam.setDataNo(pCount);
        editKhMisslstParam.setSeqNo(pCount);
        editKhMisslstParam.setMisslistMsg(message);
        editKhMisslstParam.setDBhaneikbn(pDbHaneikbn);
        editKhMisslstParam.setSyoNo(pSyoNo);

        return editKhMisslstParam;
    }
}
