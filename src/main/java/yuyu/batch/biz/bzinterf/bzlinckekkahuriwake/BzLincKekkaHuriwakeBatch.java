package yuyu.batch.biz.bzinterf.bzlinckekkahuriwake;

import java.math.BigDecimal;

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
import yuyu.batch.biz.bzinterf.bzlinckekkahuriwake.dba.BzLincKekkaHuriwakeDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.entity.ZT_LincJyusinTr;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス ＬＩＮＣ結果振分
 */
public class BzLincKekkaHuriwakeBatch implements Batch{

    private static final String TYSYTTAISYOU_TABLE_ID = "ZT_LincJyusinTr";

    private static final String RECOVERY_FILTER_KBNID = "Bz115";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzLincKekkaHuriwakeDao bzLincKekkaHuriwakeDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String syoriYmd = String.valueOf(bzBatchParam.getSyoriYmd());
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        long sinkeiyakuCount = 0;
        long hozennbunnCount = 0;
        String sinnlennbann = "0";
        String sinnkakusyasiyouran = "";

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd));

        try (
            ExDBResults<ZT_LincJyusinTr> lincJyusinTrLst = bzLincKekkaHuriwakeDao.getLincJyusinTr(ibKakutyoujobcd);

            EntityInserter<HT_SkLincJyusinData> skLincJyusinDataListInsert = new EntityInserter<>();) {

            for (ZT_LincJyusinTr lincJyusinTr : lincJyusinTrLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(lincJyusinTr.getZtrsyoriymd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(lincJyusinTr.getZtrrenno10());


                String lennbann2 = "0";
                String kakusyasiyouran2 = "";

                if (lincJyusinTr.getZtrrecordsyubetukbn().equals("07") ||
                    lincJyusinTr.getZtrrecordsyubetukbn().equals("17") ||
                    lincJyusinTr.getZtrrecordsyubetukbn().equals("27") ||
                    lincJyusinTr.getZtrrecordsyubetukbn().equals("37") ||
                    lincJyusinTr.getZtrrecordsyubetukbn().equals("51")) {

                    lennbann2 = sinnlennbann;
                    kakusyasiyouran2 = sinnkakusyasiyouran;
                }
                else {

                    lennbann2 = lincJyusinTr.getZtrrenno10();
                    sinnlennbann = lincJyusinTr.getZtrrenno10();
                    kakusyasiyouran2 = lincJyusinTr.getZtrkakusyasiyouran();
                    sinnkakusyasiyouran = lincJyusinTr.getZtrkakusyasiyouran();
                }

                C_LincsoujyusinsysKbn lincsoujyusinsysKbn = null;

                if (kakusyasiyouran2.substring(38, 39).equals("S")) {

                    lincsoujyusinsysKbn = C_LincsoujyusinsysKbn.SKEI;
                }
                else if (kakusyasiyouran2.substring(38, 39).equals("H")) {

                    lincsoujyusinsysKbn = C_LincsoujyusinsysKbn.HOZEN;
                }

                HT_SkLincJyusinData skLincJyusinDataInsert = new HT_SkLincJyusinData();

                skLincJyusinDataInsert.setSyoriYmd(BizDate.valueOf(lincJyusinTr.getZtrsyoriymd()));
                skLincJyusinDataInsert.setLinckyknaiykekdatarenno(lincJyusinTr.getZtrrenno10());
                skLincJyusinDataInsert.setLinckyknaiykekdatarennooya(lennbann2);
                skLincJyusinDataInsert.setLincsousinymd(BizDate.valueOf(lincJyusinTr.getZtrheadersousinymd()));
                skLincJyusinDataInsert.setLincdatasyubetu(lincJyusinTr.getZtrheaderdatasyubetu());
                skLincJyusinDataInsert.setLincsoujyusinsyskbn(lincsoujyusinsysKbn);
                skLincJyusinDataInsert.setSyono(kakusyasiyouran2.substring(0, 11));
                skLincJyusinDataInsert.setRendoumosnochknasi(kakusyasiyouran2.substring(11, 20));
                skLincJyusinDataInsert.setLincrecordsyubetu(Integer.valueOf(lincJyusinTr.getZtrrecordsyubetukbn()));
                skLincJyusinDataInsert.setLinchenkoutype(lincJyusinTr.getZtrhenkoutype());
                skLincJyusinDataInsert.setLincsyorikekkakekkacd(Integer.valueOf(lincJyusinTr.getZtrsyorikekkacd()));
                skLincJyusinDataInsert.setLincsyorikekkakekkajiyu(Integer.valueOf(lincJyusinTr.getZtrsyorikekkaerrjiyuu()));
                skLincJyusinDataInsert.setLincsyorikekkaerrkouban(Integer.valueOf(lincJyusinTr.getZtrsyorikekkaerrno()));
                skLincJyusinDataInsert.setLincnayoserecordsuu(Integer.valueOf(lincJyusinTr.getZtrnayoserecordsuu()));
                skLincJyusinDataInsert.setLinckanyuusyano(Long.valueOf(lincJyusinTr.getZtrkanyuusyano()));
                skLincJyusinDataInsert.setLincnayoseyomiknnm(lincJyusinTr.getZtrkyoukaisiyouknnm());
                skLincJyusinDataInsert.setLinchhknnmkn(lincJyusinTr.getZtryuyusiyouknnm());
                skLincJyusinDataInsert.setLinchhknnmkj(lincJyusinTr.getZtrknjhhknmei30());
                skLincJyusinDataInsert.setLinchhknsei(Integer.valueOf(lincJyusinTr.getZtrhhknseikbn()));
                skLincJyusinDataInsert.setLinchhknseiymd(BizDate.valueOf(lincJyusinTr.getZtrhhknseiymd()));
                skLincJyusinDataInsert.setLinchhknadrkn(lincJyusinTr.getZtrhhknadrkn());
                skLincJyusinDataInsert.setLinckeihidjnhyouji(C_KykKbn.valueOf(lincJyusinTr.getZtrkyksyhhknsydouituhyouji()));
                skLincJyusinDataInsert.setLinckyknmkn(lincJyusinTr.getZtrkykknnm());
                skLincJyusinDataInsert.setLinckyknmkj(lincJyusinTr.getZtrkjkyknm30());
                skLincJyusinDataInsert.setLinckyksei(Integer.valueOf(lincJyusinTr.getZtrkyksyaseikbn()));
                skLincJyusinDataInsert.setLinckykseiymd(BizDate.valueOf(lincJyusinTr.getZtrkyksyaseiymd()));
                skLincJyusinDataInsert.setLinckykadrkn(lincJyusinTr.getZtrkykadrkn());
                skLincJyusinDataInsert.setLinckjhngflg(Integer.valueOf(lincJyusinTr.getZtrkjhngflg()));
                skLincJyusinDataInsert.setLinctrkmousideymd(BizDate.valueOf(lincJyusinTr.getZtrtrkmousideymd()));
                skLincJyusinDataInsert.setLinckykytymd(BizDate.valueOf(lincJyusinTr.getZtrkykytymd()));
                skLincJyusinDataInsert.setLinckykymd(BizDate.valueOf(lincJyusinTr.getZtrkykymd()));
                skLincJyusinDataInsert.setLinchozenytymd(BizDate.valueOf(lincJyusinTr.getZtrhozenytymd()));
                skLincJyusinDataInsert.setLinchozenymd(BizDate.valueOf(lincJyusinTr.getZtrhozenymd()));
                skLincJyusinDataInsert.setLincsousinmotokaisya(lincJyusinTr.getZtrsousinmotokaisyacd());
                skLincJyusinDataInsert.setLincsgnyukyhng(BizCurrency.valueOf(new BigDecimal(lincJyusinTr.getZtrsiginyuintkykntgkstr())));
                skLincJyusinDataInsert.setLincsipnyukyhng(BizCurrency.valueOf(new BigDecimal(lincJyusinTr.getZtrsppinyuintkykntgkstr())));
                skLincJyusinDataInsert.setLincsjnyukyhng(BizCurrency.valueOf(new BigDecimal(lincJyusinTr.getZtrsijnbyutkykntgkstr())));
                skLincJyusinDataInsert.setLincsonotanyukyhng(BizCurrency.valueOf(new BigDecimal(lincJyusinTr.getZtrsonotatokuyakuntgkstr())));
                skLincJyusinDataInsert.setLinchutuusbs(BizCurrency.valueOf(new BigDecimal(lincJyusinTr.getZtrhutuusbsstr())));
                skLincJyusinDataInsert.setLincsgsbksns(BizCurrency.valueOf(new BigDecimal(lincJyusinTr.getZtrsgsbstr())));
                skLincJyusinDataInsert.setLinc15sai1000manflg(Integer.valueOf(lincJyusinTr.getZtr15sai1000manflg()));
                skLincJyusinDataInsert.setLinclincsyoriymd(BizDate.valueOf(lincJyusinTr.getZtrlincsyoriymd()));
                skLincJyusinDataInsert.setLinckykkanrino(lincJyusinTr.getZtrkykkanrino());
                skLincJyusinDataInsert.setLinckakusyasiyouran(lincJyusinTr.getZtrkakusyasiyouran());
                skLincJyusinDataInsert.setLincmousideflg(Integer.valueOf(lincJyusinTr.getZtrmousideflg()));
                skLincJyusinDataInsert.setLincmousideflgsetymd(BizDate.valueOf(lincJyusinTr.getZtrmousideflgsetymd()));
                skLincJyusinDataInsert.setLincmousideflgkaijyoymd(BizDate.valueOf(lincJyusinTr.getZtrmousideflgkaijyoymd()));
                skLincJyusinDataInsert.setLincjgyhknflg(Integer.valueOf(lincJyusinTr.getZtrjgyhknflg()));
                skLincJyusinDataInsert.setLinctenkanflg(Integer.valueOf(lincJyusinTr.getZtrtnknflg()));
                skLincJyusinDataInsert.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                skLincJyusinDataInsert.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skLincJyusinDataInsert);

                skLincJyusinDataListInsert.add(skLincJyusinDataInsert);

                if (C_LincsoujyusinsysKbn.SKEI.eq(lincsoujyusinsysKbn)) {

                    sinkeiyakuCount = sinkeiyakuCount + 1;
                }
                else if (C_LincsoujyusinsysKbn.HOZEN.eq(lincsoujyusinsysKbn)) {

                    hozennbunnCount = hozennbunnCount + 1;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(sinkeiyakuCount), "新契約"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(hozennbunnCount), "保全分"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
