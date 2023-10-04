package yuyu.batch.hozen.khansyuu.khyoyakuidoukousin;

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
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khyoyakuidoukousin.dba.KhYoyakuidouKousinDao;
import yuyu.batch.hozen.khansyuu.khyoyakuidoukousin.dba.YykIdouUktkBean;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.EditHrhnKanryoTuuti;
import yuyu.common.hozen.ascommon.EditHrhnKanryoTuutiParam;
import yuyu.common.hozen.ascommon.KeisanHrhnNewHrkp;
import yuyu.common.hozen.ascommon.SetHrhnSyoriKbn;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakusei;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakuseiBean;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AnnaijyoutaiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 契約保全 案内収納 予約異動更新処理クラス
 */
public class KhYoyakuidouKousinBatch implements Batch {

    private static final String TABLEID = IT_YykIdouUktk.TABLE_NAME;
    private static final String FILTERID = "Kh001";

    private BizDate syoriYMD;
    private String kosID;
    private String kosTime;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private KhYoyakuidouKousinDao khYoyakuidouKousinDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {


        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(batchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            batchParam.getIbKakutyoujobcd()));


        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        syoriYMD = batchParam.getSyoriYmd();
        kosID = khozenCommonParam.getUserID();
        kosTime = BizDate.getSysDateTimeMilli();

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU);


        BizDateYM syoriYM = syoriYMD.getBizDateYM();
        long syoriCnt = 0;

        String kakutyouJobCd = batchParam.getIbKakutyoujobcd();
        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);


        try (ExDBResults<YykIdouUktkBean> yykIdouUktkBeanLst = khYoyakuidouKousinDao.getYykIdouUktkBean(
            syoriYM, kakutyouJobCd);
            MultipleEntityUpdater updater = new MultipleEntityUpdater();
            EntityInserter<BT_TjtIdouNyKh> inserter = new EntityInserter<BT_TjtIdouNyKh>();) {

            for (YykIdouUktkBean yykIdouUktkBean : yykIdouUktkBeanLst) {



                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(yykIdouUktkBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(yykIdouUktkBean.getSyono());



                if (IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(yykIdouUktkBean.getKinouId())) {

                    String syono = yykIdouUktkBean.getSyono();
                    String henkousikibetukey = yykIdouUktkBean.getHenkousikibetukey();


                    IT_KykKihon kykKihon = khYoyakuidouKousinDao.getKykKihon(syono);


                    IT_AnsyuKihon ansyuKihon = khYoyakuidouKousinDao.getAnsyuKihon(syono);


                    IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = khYoyakuidouKousinDao.getYykIdouNaiyoHrhnk(
                        kykKihon, henkousikibetukey);


                    BizDateYM kouryokuhasseiYm = yykIdouNaiyoHrhnk.getKouryokuhasseiymd().getBizDateYM();

                    khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
                    khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
                    khozenCommonParam.setSikibetuKey(null);

                    khozenCommonParam.setFunctionId(null);
                    checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);

                    checkYuukouJyoutaiParam.setSyono(syono);

                    C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                        checkYuukouJyoutaiParam);


                    if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                        cancelYykidou(checkYuukouJyoutai.getErrorMessage(), ansyuKihon.getJkipjytym(),
                            khozenCommonParam, yykIdouNaiyoHrhnk, yykIdouUktkBean);

                        continue;
                    }

                    C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, yykIdouNaiyoHrhnk.getSyono());


                    if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

                        cancelYykidou("手続注意設定あり", ansyuKihon.getJkipjytym(), khozenCommonParam, yykIdouNaiyoHrhnk,
                            yykIdouUktkBean);

                        continue;
                    }

                    khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU);


                    if (BizDateUtil.compareYm(ansyuKihon.getJkipjytym(), kouryokuhasseiYm) ==
                        BizDateUtil.COMPARE_GREATER) {


                        cancelYykidou("編入年月と次回Ｐ充当年月が相違", ansyuKihon.getJkipjytym(), khozenCommonParam,
                            yykIdouNaiyoHrhnk, yykIdouUktkBean);

                        continue;
                    }

                    IT_DattaiUktk dattaiUktk = ansyuKihon.getDattaiUktk();

                    if (dattaiUktk != null && !C_Hrkkeiro.CREDIT.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {


                        cancelYykidou(C_AnnaijyoutaiKbn.DATTAI.getContent(), ansyuKihon.getJkipjytym(),
                            khozenCommonParam, yykIdouNaiyoHrhnk, yykIdouUktkBean);

                        continue;
                    }


                    boolean annaiFlg = true;


                    if (BizDateUtil.compareYm(yykIdouNaiyoHrhnk.getKouryokuhasseiymd().getBizDateYM(), syoriYM) ==
                        BizDateUtil.COMPARE_EQUAL
                        && (C_UmuKbn.NONE.eq(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu()))
                        && (C_UmuKbn.NONE.eq(yykIdouNaiyoHrhnk.getTikiktbrisyuruihnkumu()))) {


                        Long ansyuRirekiCCnt = khYoyakuidouKousinDao.getAnsyuRirekiCount(syono,
                            yykIdouNaiyoHrhnk.getKouryokuhasseiymd().getBizDateYM().getPreviousMonth());


                        if (ansyuRirekiCCnt == 0) {

                            annaiFlg = false;
                        }
                    }


                    if (BizDateUtil.compareYm(ansyuKihon.getJkipjytym(), kouryokuhasseiYm) == BizDateUtil.COMPARE_EQUAL
                        || (annaiFlg == false)) {


                        IT_KykSyouhn kykSyouhnSyu = khYoyakuidouKousinDao.getKykSyouhn(kykKihon, C_SyutkKbn.SYU).get(0);


                        List<IT_KykSyouhn> kykSyouhnLst = khYoyakuidouKousinDao.getKykSyouhn(kykKihon, C_SyutkKbn.TK);


                        String sikibetuKeyRenno = khozenCommonParam.getSikibetuKey(syono);

                        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);


                        tableMaintenanceUtil.backUp(syono, sikibetuKeyRenno);



                        khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                        khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());


                        BizCurrency newp = BizCurrency.valueOf(0, kykSyouhnSyu.getHokenryou().getType());

                        BizCurrency newhrkp = kykKihon.getHrkp();

                        C_Hrkkaisuu oldHrkKaisuu = kykKihon.getHrkkaisuu();
                        C_Hrkkeiro oldHrkkeiro = kykKihon.getHrkkeiro();
                        C_Hrkkaisuu newHrkKaisuu = null;
                        C_Hrkkeiro newHrkKeiro = null;

                        C_TkiktbrisyuruiKbn newtikiktbrisyuruikbn = null;
                        boolean hrkkeiroFlg = false;
                        C_Sdpd sdpdkbn = kykKihon.getSdpdkbn();



                        if (C_Hrkkaisuu.BLNK.eq(yykIdouNaiyoHrhnk.getNewhrkkaisuu())) {
                            newHrkKaisuu = kykKihon.getHrkkaisuu();
                        }

                        else {
                            newHrkKaisuu = yykIdouNaiyoHrhnk.getNewhrkkaisuu();
                        }

                        if (C_Hrkkeiro.BLNK.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {
                            newHrkKeiro = kykKihon.getHrkkeiro();
                        }

                        else {
                            newHrkKeiro = yykIdouNaiyoHrhnk.getNewhrkkeiro();
                        }

                        if (C_TkiktbrisyuruiKbn.BLNK.eq(yykIdouNaiyoHrhnk.getNewtikiktbrisyuruikbn())) {

                            newtikiktbrisyuruikbn = kykKihon.getTikiktbrisyuruikbn();
                        }

                        else {

                            newtikiktbrisyuruikbn = yykIdouNaiyoHrhnk.getNewtikiktbrisyuruikbn();
                        }

                        if(!C_Hrkkeiro.BLNK.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())
                            && !oldHrkkeiro.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())){

                            hrkkeiroFlg = true;
                        }

                        if (hrkkeiroFlg == true || C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu()) ||
                            C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getTikiktbrisyuruihnkumu())) {

                            EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);


                            editKykSyhnRirekiTbl.exec(khozenCommonParam, syono);

                            KeisanHrhnNewHrkp keisanHrhnNewHrkp = SWAKInjector.getInstance(KeisanHrhnNewHrkp.class);

                            C_ErrorKbn errorKbn = C_ErrorKbn.OK;

                            if (C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu())) {

                                errorKbn = keisanHrhnNewHrkp.exec(kykSyouhnSyu, kykSyouhnLst, oldHrkKaisuu, newHrkKaisuu,
                                    newHrkKeiro);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA3054));
                                }

                                newp = keisanHrhnNewHrkp.getSyuP();

                                newhrkp = keisanHrhnNewHrkp.getNewHrkp();
                                sdpdkbn = keisanHrhnNewHrkp.getSdpd();
                            }


                            if (C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getTikiktbrisyuruihnkumu())) {

                                errorKbn = keisanHrhnNewHrkp.exec(kykKihon, newtikiktbrisyuruikbn);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA3054));
                                }
                                newp = keisanHrhnNewHrkp.getSyuP();

                                newhrkp = keisanHrhnNewHrkp.getNewHrkp();

                            }


                            kykSyouhnSyu.setHenkousikibetukey(sikibetuKeyRenno);
                            kykSyouhnSyu.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                            kykSyouhnSyu.setGyoumuKousinsyaId(kosID);
                            kykSyouhnSyu.setGyoumuKousinTime(kosTime);

                            kykSyouhnSyu.setKouryokuhasseiymd(BizDate.valueOf(ansyuKihon.getJkipjytym(),
                                kykSyouhnSyu.getKykymd().getDay()).getRekijyou());


                            if (C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu())) {


                                kykSyouhnSyu.setHokenryou(newp);
                            }

                            for (int i = 0; i < kykSyouhnLst.size(); i++) {

                                IT_KykSyouhn kykSyouhnTK = kykSyouhnLst.get(i);


                                kykSyouhnTK.setHenkousikibetukey(sikibetuKeyRenno);
                                kykSyouhnTK.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                                kykSyouhnTK.setGyoumuKousinsyaId(kosID);
                                kykSyouhnTK.setGyoumuKousinTime(kosTime);

                                kykSyouhnTK.setKouryokuhasseiymd(BizDate.valueOf(ansyuKihon.getJkipjytym(),
                                    kykSyouhnSyu.getKykymd().getDay()).getRekijyou());


                                if (C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu())) {

                                    newp = keisanHrhnNewHrkp.getTkPList().get(i);


                                    kykSyouhnTK.setHokenryou(newp);
                                }
                            }
                        }


                        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
                        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

                        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi =
                            SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);
                        BizDate tyokugoHurikaeBi = null;

                        BizDateYM creditYuukoukakym = null;
                        String kkeiroMongon = "";

                        if(C_Hrkkeiro.KOUHURI.eq(newHrkKeiro)){


                            setHurikaebi.exec(syoriYMD);

                            tyokugoHurikaeBi = setHurikaebi.getTyokugoHurikaebi();

                            kkeiroMongon = "振替日";
                        }
                        if(C_Hrkkeiro.CREDIT.eq(newHrkKeiro)){


                            setCreditUriageSeikyuubi.exec(syoriYMD);

                            tyokugoHurikaeBi = setCreditUriageSeikyuubi.getJikaiUrsktysytbi();


                            creditYuukoukakym = setCreditUriageSeikyuubi.getJikaiUrsktysytbi().getBizDateYM();

                            kkeiroMongon = "売上日";
                        }

                        boolean checkFlg = checkYuuyokkngai.exec(yykIdouUktkBean.getSyono(), tyokugoHurikaeBi);

                        if (!checkFlg) {
                            List<String> jimuRenrakuhyouList = Lists.newArrayList();

                            SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

                            setYuuyokknmanryobi.exec(yykIdouUktkBean.getSyono(), ansyuKihon.getJkipjytym());
                            BizDate tksnYuuyokknMnryBi = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();


                            jimuRenrakuhyouList.add("下記契約について予約異動の反映を行いましたが、");
                            jimuRenrakuhyouList.add("次の" + kkeiroMongon + "までに猶予期間が満了します。");
                            jimuRenrakuhyouList.add("必要に応じて特伸処理を実行してください。");
                            jimuRenrakuhyouList.add("");
                            jimuRenrakuhyouList.add("予約異動名／払方変更");
                            jimuRenrakuhyouList.add("");
                            jimuRenrakuhyouList.add("予約異動受付日　："
                                + DefaultDateFormatter.formatYMDKanji(yykIdouUktkBean.getUktkymd()));
                            jimuRenrakuhyouList.add("編入年月　　　　："
                                + DefaultDateFormatter.formatYMKanji(yykIdouNaiyoHrhnk.getKouryokuhasseiymd()));
                            jimuRenrakuhyouList.add("猶予期間満了日　："
                                + DefaultDateFormatter.formatYMDKanji(tksnYuuyokknMnryBi));

                            editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuhyouList);
                            khozenCommonParam.setFunctionId(null);

                            EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);
                            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                            ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(khozenCommonParam,
                                yykIdouUktkBean.getSyono(), C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,
                                editJimuRenrakusyuunouParam, syoriYMD);
                            createReport.execNoCommit(reportServicesBean);

                            khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU);
                        }


                        kykKihon.setSyhenkouymd(syoriYMD);
                        kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                        kykKihon.setGyoumuKousinsyaId(kosID);
                        kykKihon.setGyoumuKousinTime(kosTime);
                        kykKihon.setSdpdkbn(sdpdkbn);


                        if (C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu())) {

                            kykKihon.setHrkkaisuu(yykIdouNaiyoHrhnk.getNewhrkkaisuu());

                            kykKihon.setHrkp(newhrkp);
                        }


                        if (C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getHrkkeirohnkumu())) {

                            kykKihon.setHrkkeiro(yykIdouNaiyoHrhnk.getNewhrkkeiro());
                        }

                        if(C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getTikiktbrisyuruihnkumu())){


                            kykKihon.setTikiktbrisyuruikbn(yykIdouNaiyoHrhnk.getNewtikiktbrisyuruikbn());
                        }


                        if (C_Hrkkeiro.KOUHURI.eq(oldHrkkeiro)) {

                            if (C_Hrkkeiro.CREDIT.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {

                                khYoyakuidouKousinDao.setKouza(kykKihon, null);


                                if (dattaiUktk != null) {


                                    ansyuKihon.setDattaiUktk(null);
                                }
                            }



                            if (C_Hrkkeiro.KOUHURI.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())
                                && C_UmuKbn.ARI.eq(yykIdouNaiyoHrhnk.getHaraikatahnkumu())) {

                                IT_Kouza kouza = khYoyakuidouKousinDao.getKouza(kykKihon);

                                kouza.setKokno("");

                                kouza.setBankcd(yykIdouNaiyoHrhnk.getBankcd());

                                kouza.setSitencd(yykIdouNaiyoHrhnk.getSitencd());

                                kouza.setYokinkbn(yykIdouNaiyoHrhnk.getYokinkbn());
                                kouza.setKouzano(yykIdouNaiyoHrhnk.getKouzano());

                                kouza.setKzmeiginmkn(yykIdouNaiyoHrhnk.getKzmeiginmkn());

                                kouza.setSinkeizkkbn(yykIdouNaiyoHrhnk.getSinkeizkkbn());

                                kouza.setSyuudaikocd(yykIdouNaiyoHrhnk.getSyuudaikocd());

                                kouza.setKzkykdoukbn(yykIdouNaiyoHrhnk.getKzkykdoukbn());
                                kouza.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                                kouza.setGyoumuKousinsyaId(kosID);
                                kouza.setGyoumuKousinTime(kosTime);
                            }
                        }


                        else if (C_Hrkkeiro.KOUHURI.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {

                            IT_Kouza kouza = khYoyakuidouKousinDao.createKouza(kykKihon);



                            kouza.setBankcd(yykIdouNaiyoHrhnk.getBankcd());

                            kouza.setSitencd(yykIdouNaiyoHrhnk.getSitencd());

                            kouza.setYokinkbn(yykIdouNaiyoHrhnk.getYokinkbn());
                            kouza.setKouzano(yykIdouNaiyoHrhnk.getKouzano());

                            kouza.setKzmeiginmkn(yykIdouNaiyoHrhnk.getKzmeiginmkn());

                            kouza.setSinkeizkkbn(yykIdouNaiyoHrhnk.getSinkeizkkbn());

                            kouza.setSyuudaikocd(yykIdouNaiyoHrhnk.getSyuudaikocd());

                            kouza.setKzkykdoukbn(yykIdouNaiyoHrhnk.getKzkykdoukbn());
                            kouza.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                            kouza.setGyoumuKousinsyaId(kosID);
                            kouza.setGyoumuKousinTime(kosTime);


                            BizPropertyInitializer.initialize(kouza);
                        }


                        if (C_Hrkkeiro.CREDIT.eq(oldHrkkeiro)) {

                            if (C_Hrkkeiro.KOUHURI.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {


                                kykKihon.setCreditCardInfo(null);
                            }


                            if (C_Hrkkeiro.CREDIT.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {


                                IT_CreditCardInfo creditCardInfo = kykKihon.getCreditCardInfo();


                                creditCardInfo.setCreditkessaiyouno(yykIdouNaiyoHrhnk.getCreditkessaiyouno());

                                creditCardInfo.setCredityuukoukakym(creditYuukoukakym);
                                creditCardInfo.setCredityuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
                                creditCardInfo.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                                creditCardInfo.setGyoumuKousinsyaId(kosID);
                                creditCardInfo.setGyoumuKousinTime(kosTime);


                                if (dattaiUktk != null) {


                                    ansyuKihon.setDattaiUktk(null);
                                }
                            }
                        }


                        else if (C_Hrkkeiro.CREDIT.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {


                            IT_CreditCardInfo creditCardInfo = kykKihon.createCreditCardInfo();


                            creditCardInfo.setCreditkessaiyouno(yykIdouNaiyoHrhnk.getCreditkessaiyouno());

                            creditCardInfo.setCredityuukoukakym(creditYuukoukakym);
                            creditCardInfo.setCredityuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
                            creditCardInfo.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                            creditCardInfo.setGyoumuKousinsyaId(kosID);
                            creditCardInfo.setGyoumuKousinTime(kosTime);


                            BizPropertyInitializer.initialize(creditCardInfo);
                        }


                        IT_YykIdouUktk yykIdouUktkUpdate = khYoyakuidouKousinDao.getYykIdouUktks(kykKihon,
                            henkousikibetukey, yykIdouUktkBean.getKinouId());



                        yykIdouUktkUpdate.setYykidousyorikbn(C_YykidousyoriKbn.SYORIZUMI);
                        yykIdouUktkUpdate.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                        yykIdouUktkUpdate.setGyoumuKousinsyaId(kosID);
                        yykIdouUktkUpdate.setGyoumuKousinTime(kosTime);

                        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

                        SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);


                        C_SyoriKbn syoriKbn = setHrhnSyoriKbn.exec(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu(),
                            yykIdouNaiyoHrhnk.getTikiktbrisyuruihnkumu(), oldHrkkeiro,
                            yykIdouNaiyoHrhnk.getNewhrkkeiro());


                        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                        editTtdkRirekiTblParam.setSyoNo(syono);
                        editTtdkRirekiTblParam.setSyoriYmd(syoriYMD);
                        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

                        editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
                        editTtdkRirekiTblParam.setSysTime(kosTime);


                        IT_KhTtdkRireki khTtdkRireki = khYoyakuidouKousinDao.createKhTtdkRireki(kykKihon);


                        khTtdkRireki.setHenkousikibetukey(sikibetuKeyRenno);


                        BizPropertyInitializer.initialize(khTtdkRireki);

                        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);


                        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);


                        EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);

                        EditHrhnKanryoTuuti editHrhnKanryoTuuti = SWAKInjector.getInstance(EditHrhnKanryoTuuti.class);

                        editHrhnKanryoTuutiParam.setHennyuym(yykIdouNaiyoHrhnk.getKouryokuhasseiymd().getBizDateYM());

                        editHrhnKanryoTuutiParam.setJkipJytym(ansyuKihon.getJkipjytym());
                        editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(yykIdouNaiyoHrhnk.getHrkkeirohnkumu());
                        editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(yykIdouNaiyoHrhnk.getHrkkaisuuhnkumu());

                        editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.TYOKUSOU);

                        editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(yykIdouNaiyoHrhnk.getTikiktbrisyuruihnkumu());

                        editHrhnKanryoTuutiParam.setHrkp(newhrkp);

                        editHrhnKanryoTuutiParam.setCardBrandKbn(yykIdouNaiyoHrhnk.getCardbrandkbn());

                        editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4(yykIdouNaiyoHrhnk.getCreditkaiinnosimo4keta());
                        editHrhnKanryoTuutiParam.setHrkkeiro(oldHrkkeiro);

                        IT_HrhnTtdkKan hrhnTtdkKan = editHrhnKanryoTuuti.editTBL(
                            khozenCommonParam, kykKihon, editHrhnKanryoTuutiParam, syoriYMD);

                        List<IT_HrhnTtdkKan> hrhnTtdkKanLst = kykKihon.getHrhnTtdkKans();

                        hrhnTtdkKanLst.add(hrhnTtdkKan);


                        if (hrkkeiroFlg == true) {

                            PALKykNaiyouSakuseiBean pALKykNaiyouSakuseiBean =
                                SWAKInjector.getInstance(PALKykNaiyouSakuseiBean.class);
                            PALKykNaiyouSakusei pALKykNaiyouSakusei =
                                SWAKInjector.getInstance(PALKykNaiyouSakusei.class);

                            pALKykNaiyouSakuseiBean.setKykKihon(kykKihon);

                            C_ErrorKbn errorKbn = pALKykNaiyouSakusei.exec(pALKykNaiyouSakuseiBean);


                            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                                throw new CommonBizAppException("当日異動内容契約保全テーブルの作成に失敗しました。");
                            }


                            BT_TjtIdouNyKh tjtIdouNyKh = pALKykNaiyouSakusei.getTjtIdouNyKh();


                            if (tjtIdouNyKh != null) {

                                inserter.add(tjtIdouNyKh);
                            }
                        }


                        khYoyakuidouKousinDao.addMultipleEntityUpdater(updater, kykKihon);

                        khYoyakuidouKousinDao.addMultipleEntityUpdater(updater, ansyuKihon);
                    }

                    else {
                        kykKihon.detach();
                        ansyuKihon.detach();
                    }

                    syoriCnt++;
                }

                else {

                    continue;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }


        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCnt)));
    }

    private void cancelYykidou(String pCancelRiyuu, BizDateYM pJkipjytym, KhozenCommonParam pKhozenCommonParam,
        IT_YykIdouNaiyoHrhnk pYykIdouNaiyoHrhnk, YykIdouUktkBean pYykIdouUktkBean) {


        IT_YykIdouUktk yykIdouUktk = khYoyakuidouKousinDao.getYykIdouUktks(pKhozenCommonParam.getBatchKeiyakuKihon(),
            pYykIdouUktkBean.getHenkousikibetukey(), pYykIdouUktkBean.getKinouId());


        yykIdouUktk.setYykidousyorikbn(C_YykidousyoriKbn.TORIKESI);
        yykIdouUktk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        yykIdouUktk.setGyoumuKousinsyaId(kosID);
        yykIdouUktk.setGyoumuKousinTime(kosTime);

        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU);


        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(pYykIdouNaiyoHrhnk.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(syoriYMD);

        editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.YYKIDOUTORIKESI);
        editTtdkRirekiTblParam.setSysTime(kosTime);

        String sikibetuKeyRenno = pKhozenCommonParam.getSikibetuKey(pYykIdouNaiyoHrhnk.getSyono());


        IT_KhTtdkRireki khTtdkRireki = khYoyakuidouKousinDao.createKhTtdkRireki(pKhozenCommonParam.getKeiyakuKihon(pYykIdouUktkBean.getSyono()));


        khTtdkRireki.setHenkousikibetukey(sikibetuKeyRenno);


        BizPropertyInitializer.initialize(khTtdkRireki);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);


        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        List<String> jimuRenrakuhyouList = Lists.newArrayList();


        jimuRenrakuhyouList.add("下記内容の予約異動は、以下の理由により取り消されました。");
        jimuRenrakuhyouList.add("必要に応じて異動の再実施を行ってください。");
        jimuRenrakuhyouList.add("");
        jimuRenrakuhyouList.add("予約異動名／払方変更");
        jimuRenrakuhyouList.add("取消理由／" + pCancelRiyuu);
        jimuRenrakuhyouList.add("");
        jimuRenrakuhyouList.add("予約異動受付日　：" + DefaultDateFormatter.formatYMDKanji(
            pYykIdouUktkBean.getUktkymd()));
        jimuRenrakuhyouList.add("編入年月　　　　：" + DefaultDateFormatter.formatYMKanji(
            pYykIdouNaiyoHrhnk.getKouryokuhasseiymd()));


        if (pJkipjytym != null) {

            jimuRenrakuhyouList.add("次回Ｐ充当年月　：" + DefaultDateFormatter.formatYMKanji(pJkipjytym.toString()));
        }

        pKhozenCommonParam.setFunctionId(null);

        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuhyouList);

        EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(pKhozenCommonParam,
            pYykIdouUktkBean.getSyono(), C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, editJimuRenrakusyuunouParam, syoriYMD);

        createReport.execNoCommit(reportServicesBean);
        pKhozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {


        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);


        bzBatchAbendCommonRecovery.exec();
    }
}