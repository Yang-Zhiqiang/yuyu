package yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagedatasakusei;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagedatasakusei.dba.SkFstpUriageDataSakuseiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.mapping.GenHT_SyoriCTL;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 入金 初回保険料売上請求データ作成
 */
public class SkFstpUriageDataSakuseiBatch implements Batch{

    private static final String TABLE_ID = GenHT_SyoriCTL.TABLE_NAME;

    private static final String FILTER_ID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private  SkFstpUriageDataSakuseiDao skFstpUriageDataSakuseiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BzBatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));

        long syoriKensuu = 0;

        String fukusuukameitennokey = "";

        try ( ExDBUpdatableResults<HT_SyoriCTL> syoriCTLLst =
            skFstpUriageDataSakuseiDao.getFstpUriageMisousinData(kakutyouJobCd);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            ) {

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                HT_MosKihon mosKihon = new HT_MosKihon();
                HT_CreditCardJyouhou creditCardJyouhou = new HT_CreditCardJyouhou();
                HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                mosKihon = syoriCTL.getMosKihon();

                creditCardJyouhou = syoriCTL.getCreditCardJyouhou();

                mosSyouhn = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

                BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {

                    fukusuukameitennokey = "1100010";
                }
                else {

                    fukusuukameitennokey = "1100020";
                }

                BizCurrency uriageseikyuuGk = mosKihon.getFstphrkgk().multiply(mosKihon.getSkjpjyuutoukaisuu());

                HT_SkUriageData skUriageData = new HT_SkUriageData();

                ZT_FstpUriageSeikyuuDataTy fstpUriageSeikyuuDataTy = new ZT_FstpUriageSeikyuuDataTy();

                skUriageData.setAnsyuusyskbn(C_AnsyuusysKbn.SKEI);
                skUriageData.setSyoriYmd(syoriYmd);
                skUriageData.setMosno(syoriCTL.getMosno());
                skUriageData.setAuthorikaisuu(1);
                skUriageData.setJyuutouym(null);
                skUriageData.setJyutoukaisuum(0);
                skUriageData.setUriagegk(uriageseikyuuGk);
                skUriageData.setUriageymd(syoriCTL.getRyosyuymd());
                skUriageData.setHknsyuruino(mosKihon.getHknsyuruino());
                skUriageData.setSrsyoriymd(syoriCTL.getSrsyoriymd());
                skUriageData.setKykymd(mosKihon.getKykymd());
                skUriageData.setAuthorikbn(C_AuthoriKbn.AUTHORINASI);
                skUriageData.setUriageseikyuutorihikicd("0");
                skUriageData.setCreditkessaiyouno(creditCardJyouhou.getCreditkessaiyouno());
                skUriageData.setFukusuukameitennokey(fukusuukameitennokey);
                skUriageData.setCardbrandkbn(creditCardJyouhou.getCardbrandkbn());
                skUriageData.setCarddatasousinymd(syoriYmd.addBusinessDays(1));
                skUriageData.setUriagekekkakbn(C_UriagekekkaKbn.BLNK);
                skUriageData.setGyoumuKousinKinou(kinou.getKinouId());
                skUriageData.setGyoumuKousinsyaId(bzBatchParam.getUserId());
                skUriageData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skUriageData);
                multipleEntityInserter.add(skUriageData);

                fstpUriageSeikyuuDataTy.setZtysyono("");
                fstpUriageSeikyuuDataTy.setZtyrecordno("  ");
                fstpUriageSeikyuuDataTy.setZtyrecordkbn("2");
                fstpUriageSeikyuuDataTy.setZtyauthorikbn("1");
                fstpUriageSeikyuuDataTy.setZtyuriageseikyuutorihikicd("0");

                if((syoriCTL.getRyosyuymd() != null)) {
                    fstpUriageSeikyuuDataTy.setZtyuriageymd6keta(String.valueOf(syoriCTL.getRyosyuymd()).substring(2,8));
                }
                fstpUriageSeikyuuDataTy.setZtycreditkessaiyouno(creditCardJyouhou.getCreditkessaiyouno());
                fstpUriageSeikyuuDataTy.setZtyseikyuukngk11keta(
                    new BigDecimal(String.valueOf(uriageseikyuuGk)).longValue());
                fstpUriageSeikyuuDataTy.setZtyfukusuukameitennokey(fukusuukameitennokey);

                BizPropertyInitializer.initialize(fstpUriageSeikyuuDataTy);
                multipleEntityInserter.add(fstpUriageSeikyuuDataTy);

                syoriCTL.setUriagesousinkbn(C_UriagesousinKbn.SOUSINZUMI);
                syoriCTL.setGyoumuKousinsyaId(bzBatchParam.getUserId());
                syoriCTL.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                syoriKensuu = syoriKensuu + 1;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
            "初回保険料売上請求データテーブル（中）"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
