package yuyu.batch.direct.dsmailhaisinkanri.dsjkihknryouosirsmailsakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dsmailhaisinkanri.dsjkihknryouosirsmailsakusei.dba.DsJkiHknryouOsirsMailSakuseiDao;
import yuyu.batch.direct.dsmailhaisinkanri.dsjkihknryouosirsmailsakusei.dba.DsJkiHknryouOsirsMailSakuseiTaisyouBean;
import yuyu.batch.direct.dsmailhaisinkanri.dsjkihknryouosirsmailsakusei.dba.DsKawaseRateTuutiDataBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.direct.dscommon.DsKankyouizonmojiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス ＤＳメール配信管理 次回保険料お知らせメール作成<br />
 *
 * 次回保険料お知らせメール作成バッチクラス。<br />
 *
 */
public class DsJkiHknryouOsirsMailSakuseiBatch implements Batch {

    private static final C_DsSousinMailSyubetuKbn DSSOUSINMAILSYUBETUKBN = C_DsSousinMailSyubetuKbn.HOKENRYOUYENOSIRASEMAIL;

    private static final int DSMAILHAISINRENNO_DEFAULT = 200000001;

    private static final String ASTERISK = "＊＊＊";

    private static final String TABLE_ID  = "IT_KawaseRateTuutiData";

    private static final String FILTER_ID = "Kh001";

    private static final String KAWASERATETUUTIDATATYSYT = "為替レート通知データ抽出件数";

    private static final String DSJIKAIHOKENRYOUOSIRASEMAILSAKUSEISOUSINKENSUU = "次回保険料お知らせメール送信対象件数";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private DsJkiHknryouOsirsMailSakuseiDao dsJkiHknryouOsirsMailSakuseiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        String gyoumuKousinKinouId = kinou.getKinouId();
        String gyoumuKousinsyaId = baseUserInfo.getUserId();
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        long kensuu = 0;
        int syoriKensuu = 0;

        batchLogger.info(
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd.toString()));

        dsJkiHknryouOsirsMailSakuseiDao.deleteDsMailHaisin(syoriYmd.addBusinessDays(1), DSSOUSINMAILSYUBETUKBN);

        try (
        ExDBResults<DsKawaseRateTuutiDataBean> kawaseRateTuutiDataList =
            dsJkiHknryouOsirsMailSakuseiDao.getDsKawaseRateTuutiTysyt(kakutyouJobCd, syoriYmd);
        MultipleEntityInserter multipleEntityInserter = SWAKInjector.getInstance(MultipleEntityInserter.class);) {

            BizDate dsdatasakuseiymd = syoriYmd.addBusinessDays(1);

            Integer maxDsMailHaisinRenNo = dsJkiHknryouOsirsMailSakuseiDao
                .getDsMailHaisinRirekiMaxDsMailHaisinRenNo(dsdatasakuseiymd);

            if (maxDsMailHaisinRenNo == null || maxDsMailHaisinRenNo < DSMAILHAISINRENNO_DEFAULT) {

                maxDsMailHaisinRenNo = DSMAILHAISINRENNO_DEFAULT;
            }
            else {

                maxDsMailHaisinRenNo = maxDsMailHaisinRenNo + 1;
            }

            String dsSousinNoSystemYmd = gyoumuKousinTime.substring(2, 8) + "T" + gyoumuKousinTime.substring(8, 12) + "NC";
            int dsSousinNoRenNo = 1;
            BizDate sousinYmd = syoriYmd.addBusinessDays(1);

            for (DsKawaseRateTuutiDataBean kawaseRateTuutiData : kawaseRateTuutiDataList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kawaseRateTuutiData.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kawaseRateTuutiData.getSyono());

                kensuu = kensuu + 1;

                List<DsJkiHknryouOsirsMailSakuseiTaisyouBean> dsJkiHknryouOsirsMailSakuseiTaisyouBeanList =
                    dsJkiHknryouOsirsMailSakuseiDao.getDsJkiHknryouOsirsMailSakuseiTaisyouHantei(kawaseRateTuutiData.getSyono());

                if (dsJkiHknryouOsirsMailSakuseiTaisyouBeanList.size() == 0) {

                    continue;
                }

                DsJkiHknryouOsirsMailSakuseiTaisyouBean dsJkiHknryouOsirsMailSakuseiTaisyouBean =
                    dsJkiHknryouOsirsMailSakuseiTaisyouBeanList.get(0);
                String dsSousinNo = dsSousinNoSystemYmd + Strings.padStart(String.valueOf(dsSousinNoRenNo), 8, '0');
                String dsMailAddress = dsJkiHknryouOsirsMailSakuseiTaisyouBean.getDsmailaddress();

                DsKankyouizonmojiHenkanUtil dsKankyouizonmojiHenkanUtil = SWAKInjector
                    .getInstance(DsKankyouizonmojiHenkanUtil.class);

                String dsKokMailAddressSkbtKey = dsJkiHknryouOsirsMailSakuseiTaisyouBean.getDskokno()
                    +
                    Strings.padStart(
                        String.valueOf(dsJkiHknryouOsirsMailSakuseiTaisyouBean.getDsmailaddressrenban()), 9, '0');
                String drtennm = "";
                if (!BizUtil.isBlank(kawaseRateTuutiData.getBosyuujiaatukaidrtenkj())) {

                    drtennm = kawaseRateTuutiData.getBosyuujiaatukaidrtenkj();
                }
                else {

                    drtennm = ASTERISK;
                }
                String aisyoumei = dsKankyouizonmojiHenkanUtil.henkanRomesuuji(kawaseRateTuutiData
                    .getAisyoumeikbn().getContent());

                MT_DsMailHaisin dsMailHaisin = new MT_DsMailHaisin();
                dsMailHaisin.setSousinymd(sousinYmd);
                dsMailHaisin.setDskokmailaddressskbtkey(dsKokMailAddressSkbtKey);
                dsMailHaisin.setDssousinmailsyubetukbn(DSSOUSINMAILSYUBETUKBN);
                dsMailHaisin.setDssousinno(dsSousinNo);
                dsMailHaisin.setSyono(kawaseRateTuutiData.getSyono());
                dsMailHaisin.setDsmailaddress(dsMailAddress);
                dsMailHaisin.setSasikomikoumokutyuu01("（送信番号" + dsSousinNo + "）");
                dsMailHaisin.setSasikomikoumokudai01(DateFormatUtil.dateKANJI(kawaseRateTuutiData.getKykymd())
                    + "に" + drtennm + "様にてご契約いただきました以下の保険商品につきまして、円貨払込額をお知らせいたします。\\n");
                dsMailHaisin.setSasikomikoumokudai02("保険料円貨払込特約（円貨払込額変動型）に基づき、"
                    + kawaseRateTuutiData.getKyktuukasyu().getContent()
                    + "建保険料を換算基準日における当社所定の為替レートで円換算した金額になります。\\n\\n");
                dsMailHaisin.setSasikomikoumokudai03("【商品名】" + aisyoumei + "\\n");
                dsMailHaisin.setSasikomikoumokudai04("【円貨払込額（保険料）】"
                    + kawaseRateTuutiData.getHrkp().toFormatString() + "円（"
                    + kawaseRateTuutiData.getSiteituukap().toFormatString()
                    + kawaseRateTuutiData.getKyktuukasyu().getContent() + "）\\n");
                dsMailHaisin.setSasikomikoumokudai05("【換算基準日】"
                    + DateFormatUtil.dateKANJI(kawaseRateTuutiData.getKwsratekjymd()) + "\\n" + "【為替レート】１"
                    + kawaseRateTuutiData.getKyktuukasyu().getContent() + "　＝　"
                    + kawaseRateTuutiData.getKawaserate() + "円\\n\\n");
                dsMailHaisin
                .setSasikomikoumokudai06("※前回の保険料をお払い込みいただいていない場合は、2ヶ月または3ヶ月分の保険料をまとめて振り替えさせていただくことがございます。\\n\\n"
                    + "今後とも、引き続きお引立て賜りますよう、よろしくお願いいたします。 \\n");

                BizPropertyInitializer.initialize(dsMailHaisin);

                multipleEntityInserter.add(dsMailHaisin);

                String dsKokNo = dsJkiHknryouOsirsMailSakuseiTaisyouBean.getDskokno();

                MT_DsMailHaisinRireki dsMailHaisinRireki = new MT_DsMailHaisinRireki();
                dsMailHaisinRireki.setDsdatasakuseiymd(dsdatasakuseiymd);
                dsMailHaisinRireki.setDskokno(dsKokNo);
                dsMailHaisinRireki.setDsmailhaisinrenban(maxDsMailHaisinRenNo);
                dsMailHaisinRireki.setHaisinjidsmailaddress(dsMailAddress);
                dsMailHaisinRireki.setDssousinno(dsSousinNo);
                dsMailHaisinRireki.setGyoumuKousinKinou(gyoumuKousinKinouId);
                dsMailHaisinRireki.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                dsMailHaisinRireki.setGyoumuKousinTime(gyoumuKousinTime);
                dsMailHaisinRireki.setDssousinmailsyubetukbn(DSSOUSINMAILSYUBETUKBN);
                dsMailHaisinRireki.setSyono(kawaseRateTuutiData.getSyono());

                BizPropertyInitializer.initialize(dsMailHaisinRireki);

                multipleEntityInserter.add(dsMailHaisinRireki);

                maxDsMailHaisinRenNo = maxDsMailHaisinRenNo + 1;
                dsSousinNoRenNo = dsSousinNoRenNo + 1;
                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kensuu), KAWASERATETUUTIDATATYSYT));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
            DSJIKAIHOKENRYOUOSIRASEMAILSAKUSEISOUSINKENSUU));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
