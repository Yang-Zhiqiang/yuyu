package yuyu.batch.biz.bzkaikei.bzhurikaedentblsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuriDenpyouKykTuukaKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_SougouKobetuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 振替伝票テーブル作成処理
 */
public class BzHurikaeDenTblSksBatch implements Batch {

    private final int HOZONKIKAN = 120;

    private final String TABLE_ID = "BT_DenpyoData";

    private final String FILTER_ID = "Bz105";

    private final String ONLINENYUUKIN_ID = "RD34";

    private final String NYUUKIN_ID = "RDHU";

    private final String KARIUKETEISEI_ID = "RD36";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean recoveryBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        BizDate delSyoriYmd = bzBatchParam.getSyoriYmd().addDays(HOZONKIKAN * -1);
        BzHurikaeDenTblSksDao bzHurikaeDenTblSksDao = SWAKInjector.getInstance(BzHurikaeDenTblSksDao.class);
        bzHurikaeDenTblSksDao.deleteHuriDenpyousBySyoriYmd(delSyoriYmd);

        long syoriKensuu = 0;
        String denpyoDataSerialNum = "";
        int furikaedenItirenno = 0;
        String systemTime = BizDate.getSysDateTime();

        try (ExDBResults<BT_DenpyoData> denpyoDataLst =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd(), C_DensysKbn.HOZEN, C_DensysKbn.NENKIN, C_DensysKbn.HKSIHARAI);

            EntityInserter<BT_HuriDenpyou> huriDenpyouLst = new EntityInserter<BT_HuriDenpyou>();) {

            for (BT_DenpyoData denpyoData : denpyoDataLst) {

                recoveryBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                recoveryBean.setIbTableid(TABLE_ID);
                recoveryBean.setIbRecoveryfilterid(FILTER_ID);
                recoveryBean.setIbRecoveryfilterkey1(denpyoData.getDensyskbn().getValue());
                recoveryBean.setIbRecoveryfilterkey2(denpyoData.getDenrenno().toString());

                BT_HuriDenpyou huriDenpyou = new BT_HuriDenpyou();
                huriDenpyou.setDensyskbn(denpyoData.getDensyskbn());
                huriDenpyou.setDenrenno(denpyoData.getDenrenno());
                huriDenpyou.setEdano(denpyoData.getEdano());
                huriDenpyou.setKeirisyskbn(C_KeirisysKbn.FUHO);
                huriDenpyou.setKeirisyono(denpyoData.getKeirisyono());
                huriDenpyou.setHuridenatesakicd(denpyoData.getHuridenatesakicd());
                huriDenpyou.setTantocd(denpyoData.getTantocd());
                huriDenpyou.setDenymd(denpyoData.getDenymd());
                huriDenpyou.setTaisyakukbn(denpyoData.getTaisyakukbn());
                huriDenpyou.setKanjyoukmkcd(denpyoData.getKanjyoukmkcd());
                huriDenpyou.setDenkanjokamokucd(denpyoData.getKanjyouKamoku().getDenkanjokamokucd());
                huriDenpyou.setJigyouhiutiwakecd(denpyoData.getKanjyouKamoku().getJigyouhiutiwakecd());
                huriDenpyou.setJigyouhiutiwakenm(denpyoData.getKanjyouKamoku().getJigyouhiutiwakenm());
                huriDenpyou.setSuitoubumoncd(denpyoData.getSuitoubumoncd());
                huriDenpyou.setDenyenkagk(denpyoData.getDenyenkagk());
                huriDenpyou.setHuridenskskbn(denpyoData.getHuridenskskbn());
                huriDenpyou.setDenhnknhoukbn(denpyoData.getDenhnknhoukbn());
                huriDenpyou.setDenshrhoukbn(denpyoData.getDenshrhoukbn());
                huriDenpyou.setSyoriYmd(bzBatchParam.getSyoriYmd());
                huriDenpyou.setSyoricd(denpyoData.getSyoricd());
                huriDenpyou.setTuukasyu(denpyoData.getTuukasyu());
                huriDenpyou.setDengyoumucd(denpyoData.getDengyoumucd());
                huriDenpyou.setDenkarikanjyono(denpyoData.getDenkarikanjyono());
                huriDenpyou.setDensyorisyousaikbn(denpyoData.getDensyorisyousaikbn());
                huriDenpyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                huriDenpyou.setGyoumuKousinTime(systemTime);

                if (denpyoData.getHuridenskskbn().eq(C_HuridensksKbn.KOBETU) &&
                    (ONLINENYUUKIN_ID.equals(denpyoData.getSyoricd()) ||
                        NYUUKIN_ID.equals(denpyoData.getSyoricd()) ||
                        KARIUKETEISEI_ID.equals(denpyoData.getSyoricd()) ||
                        BizUtil.isBlank(denpyoData.getSyoricd()))) {
                    huriDenpyou.setSougoukobetukbn(C_SougouKobetuKbn.KOBETUDENPYOU);

                    if(!denpyoDataSerialNum.equals(huriDenpyou.getDenrenno())){

                        furikaedenItirenno++;
                        denpyoDataSerialNum = huriDenpyou.getDenrenno();
                    }

                    huriDenpyou.setFurikaedenpyouitirenno(furikaedenItirenno);
                }

                if (denpyoData.getKyktuukasyu().eq(C_Tuukasyu.JPY)) {
                    huriDenpyou.setHuridenpyoukyktuukakbn(C_HuriDenpyouKykTuukaKbn.ENKA);
                } else {
                    huriDenpyou.setHuridenpyoukyktuukakbn(C_HuriDenpyouKykTuukaKbn.GAIKA);
                }

                BizPropertyInitializer.initialize(huriDenpyou);
                huriDenpyouLst.add(huriDenpyou);
                syoriKensuu++;
            }
        }

        recoveryBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
