package yuyu.batch.hozen.khzeimu.khidoutyousyo;

import java.util.List;

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
import yuyu.batch.hozen.khzeimu.khidoutyousyo.dba.KhIdouTyousyoDao;
import yuyu.batch.hozen.khzeimu.khidoutyousyo.dba.KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KykSyaHenkouRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 税務 契約保全異動調書作成
 */
public class KhIdouTyousyoBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_KykSyaHenkouRireki";

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhIdouTyousyoDao khIdouTyousyoDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        long shrtysyrenno = 0;

        String zenRecordSyono = "";

        long count = 0;

        try (
            ExDBResults<KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean> exDBResults = khIdouTyousyoDao.
            getKhIdouTyousyoInfosByKakutyoujobcdSyoriYmd(kakutyoujobcd, syoriYmd);
            EntityInserter<IT_KhIdouTyousyo> khIdouTyousyoIst = new EntityInserter<>()) {

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            String batchSyoriKinouId = khozenCommonParam.getFunctionId();
            String batchSyoriKousinsyaId = khozenCommonParam.getUserID();
            String sysDateTime = BizDate.getSysDateTimeMilli();

            for (KhKhIdouTyousyoInfosByKakutyoujobcdSyoriYmdBean bean : exDBResults) {

                IT_KykSyaHenkouRireki kykSyaHenkouRireki = bean.getKykSyaHenkouRireki();
                IT_KykKihon kykKihon = bean.getKykKihon();
                IT_KykSyouhn kykSyouhn = bean.getKykSyouhn();
                IT_KykSya kykSya = bean.getKykSya();
                IT_HhknSya hhknSya = bean.getHhknSya();
                IT_KhTtdkRireki khTtdkRireki = bean.getKhTtdkRireki();


                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykSyaHenkouRireki.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykSyaHenkouRireki.getSyono());


                if (kykSyaHenkouRireki.getYenkaiyakuhrstgk().compareTo(BizCurrency.valueOf(1000000)) <= 0) {
                    continue;
                }


                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(),
                    kykSyouhn.getSyouhnsdno());

                if (syouhnZokusei == null) {

                    throw new CommonBizAppException("商品属性マスタにデータが存在しません。" +
                        "商品コード：" + kykSyouhn.getSyouhncd() + "　商品世代番号：" + kykSyouhn.getSyouhnsdno());
                }


                if (kykSyaHenkouRireki.getSyono().equals(zenRecordSyono)) {
                    shrtysyrenno = shrtysyrenno + 1;
                }
                else {
                    shrtysyrenno = 1;
                }

                zenRecordSyono = kykSyaHenkouRireki.getSyono();


                BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.MEIGIHENKOU);

                if (tantouCd == null) {
                    throw new CommonBizAppException("担当コードマスタにデータが存在しません。担当コード：" +
                        C_TantouCdKbn.MEIGIHENKOU);
                }

                String kaCd = tantouCd.getBusitucd();
                String syoriSosikiCd = khTtdkRireki.getSyorisosikicd();
                String hknSyukigou = kykSyouhn.getSyouhncd().substring(0, 2);


                String oldKykkiHrkmpYouhyj = "";
                BizCurrency oldKykkiHrkmp = null;

                if (BizDateUtil.compareYmd(kykSyouhn.getKykymd(), BizDate.valueOf(20180101)) ==
                    BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(kykSyouhn.getKykymd(), BizDate.valueOf(20180101)) ==
                    BizDateUtil.COMPARE_EQUAL) {

                    oldKykkiHrkmpYouhyj = "1";
                    oldKykkiHrkmp = kykSyaHenkouRireki.getOldkykkihrkmp();
                }
                else {

                    List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiLst = hozenDomManager.
                        getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(kykSyaHenkouRireki.getSyono(), C_Meigihnkjiyuu.KYK);

                    SortIT_KykSyaHenkouRireki kykSyaHenkouRirekiSort = SWAKInjector.getInstance(
                        SortIT_KykSyaHenkouRireki.class);

                    kykSyaHenkouRirekiLst = kykSyaHenkouRirekiSort.OrderIT_KykSyaHenkouRirekiByHenkouSikibetuKeyDesc(
                        kykSyaHenkouRirekiLst);


                    if (kykSyaHenkouRirekiLst.size() != 0) {

                        oldKykkiHrkmpYouhyj = "1";
                        oldKykkiHrkmp = kykSyaHenkouRireki.getOldkykkihrkmp();
                    }
                    else {

                        oldKykkiHrkmpYouhyj = "0";
                        oldKykkiHrkmp = BizCurrency.valueOf(0);
                    }
                }


                kykKihon = IT_KykKihonDetacher.detachKhTtdkTyuuitouched(kykKihon);

                IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

                C_ShrtysyhknsyuKbn shrtysyhknsyuKbn = syouhnZokusei.getShrtysyhknsyukbn();


                String tblsakuseiHunodisp = "";

                if (khTtdkTyuui != null && (C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                    C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                    C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                    C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                    C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn5()))) {

                    tblsakuseiHunodisp = "1";
                }
                else {

                    tblsakuseiHunodisp = "0";
                }


                IT_KhIdouTyousyo khIdouTyousyo = new IT_KhIdouTyousyo();

                khIdouTyousyo.setSyono(kykSyaHenkouRireki.getSyono());
                khIdouTyousyo.setTyouhyouymd(syoriYmd);
                khIdouTyousyo.setShrtysyrenno(shrtysyrenno);
                khIdouTyousyo.setKacd(kaCd);
                khIdouTyousyo.setTantocd(C_TantouCdKbn.MEIGIHENKOU);
                khIdouTyousyo.setHknsyukigou(hknSyukigou);
                khIdouTyousyo.setSyorisosikicd(syoriSosikiCd);
                khIdouTyousyo.setShrtysysyuruicd("4");
                khIdouTyousyo.setSyoritaisyoukbn("44");
                khIdouTyousyo.setTblsakuseihunodisp(tblsakuseiHunodisp);
                khIdouTyousyo.setTsinyno(kykSyaHenkouRireki.getTsinyno());
                khIdouTyousyo.setTsinadr1kj(kykSyaHenkouRireki.getTsinadr1kj());
                khIdouTyousyo.setTsinadr2kj(kykSyaHenkouRireki.getTsinadr2kj());
                khIdouTyousyo.setTsinadr3kj(kykSyaHenkouRireki.getTsinadr3kj());
                khIdouTyousyo.setKyknmkj(kykSya.getKyknmkj());
                khIdouTyousyo.setOldtsinyno(kykSyaHenkouRireki.getOldtsinyno());
                khIdouTyousyo.setOldtsinadr1kj(kykSyaHenkouRireki.getOldtsinadr1kj());
                khIdouTyousyo.setOldtsinadr2kj(kykSyaHenkouRireki.getOldtsinadr2kj());
                khIdouTyousyo.setOldtsinadr3kj(kykSyaHenkouRireki.getOldtsinadr3kj());
                khIdouTyousyo.setOldkyknmkj(kykSyaHenkouRireki.getOldkyknmkj());
                khIdouTyousyo.setHhknnmkj(hhknSya.getHhknnmkj());
                khIdouTyousyo.setOldkyksibouymd(kykSyaHenkouRireki.getOldkyksibouymd());
                khIdouTyousyo.setKouryokuhasseiymd(kykSyaHenkouRireki.getKouryokuhasseiymd());
                khIdouTyousyo.setKyksiboumeighnksyoriymd(kykSyaHenkouRireki.getKouryokuhasseiymd());
                khIdouTyousyo.setKaiyakuhrstgk(kykSyaHenkouRireki.getYenkaiyakuhrstgk());
                khIdouTyousyo.setKihrkmp(kykSyaHenkouRireki.getKihrkmpsgk());
                khIdouTyousyo.setOldkykkihrkmpyouhyj(oldKykkiHrkmpYouhyj);
                khIdouTyousyo.setOldkykkihrkmp(oldKykkiHrkmp);
                khIdouTyousyo.setSakuseiymd(syoriYmd);
                khIdouTyousyo.setHuho2kykdisp("1");
                khIdouTyousyo.setShrtysyhknsyukbn(shrtysyhknsyuKbn);
                khIdouTyousyo.setGyoumuKousinKinou(batchSyoriKinouId);
                khIdouTyousyo.setGyoumuKousinsyaId(batchSyoriKousinsyaId);
                khIdouTyousyo.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(khIdouTyousyo);

                khIdouTyousyoIst.add(khIdouTyousyo);

                count = count + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
