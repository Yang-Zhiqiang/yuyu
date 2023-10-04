package yuyu.batch.hozen.khozen.khsyainmeibosks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_SyainMeiboTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 契約保全社員名簿作成
 */
public class KhSyainMeiboSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERKBNID = "Kh001";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String tysyttaisyouTableId = TYSYTTAISYOUTABLEID;
        String recoveryFilterKbnId = RECOVERYFILTERKBNID;
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        int syoriKensuu = 0;

        try (ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> exDBResults = hozenDomManager.
            getSyainMeiboInfosByKakutyoujobcd(ibKakutyoujobCd);
            EntityInserter<ZT_SyainMeiboTy> entityInserter = new EntityInserter<>()) {

            for (SyainMeiboInfosByKakutyoujobcdBean syainMeiboInfosByKakutyoujobcdBean : exDBResults) {

                IT_KykKihon itKykKihon = syainMeiboInfosByKakutyoujobcdBean.getIT_KykKihon();
                IT_KykSyouhn itKykSyouhn = syainMeiboInfosByKakutyoujobcdBean.getIT_KykSyouhn();
                IT_KykSya itKykSya = syainMeiboInfosByKakutyoujobcdBean.getIT_KykSya();
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterKbnId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(itKykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(itKykKihon.getSyono());

                itKykKihon = IT_KykKihonDetacher.detachKhTtdkTyuuitouched(itKykKihon);
                IT_KhTtdkTyuui itKhTtdkTyuui = itKykKihon.getKhTtdkTyuui();

                String adrHumeiFlag = "0";
                String souhuhunouKbn = "0";

                if (itKhTtdkTyuui != null &&
                    (C_TtdktyuuiKbn.ADRHUMEI.eq(itKhTtdkTyuui.getTtdktyuuikbn1())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(itKhTtdkTyuui.getTtdktyuuikbn2())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(itKhTtdkTyuui.getTtdktyuuikbn3())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(itKhTtdkTyuui.getTtdktyuuikbn4())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(itKhTtdkTyuui.getTtdktyuuikbn5()))) {

                    adrHumeiFlag = "1";

                }

                if ("1".equals(adrHumeiFlag)) {

                    souhuhunouKbn = "1";

                }
                else if (BizUtil.isBlank(itKykSya.getTsinyno()) || BizUtil.isBlank(itKykSya.getTsinadr1kj())) {

                    souhuhunouKbn = "2";

                }
                else if (BizUtil.isBlank(itKykSya.getKyknmkj())) {

                    souhuhunouKbn = "5";

                }

                String kykseiYmd = null;
                if ("null".equals(String.valueOf(itKykSya.getKykseiymd()))) {

                    kykseiYmd = "";
                }
                else {
                    kykseiYmd = String.valueOf(itKykSya.getKykseiymd());
                }

                String tsinyNo = null;
                if (BizUtil.isBlank(itKykSya.getTsinyno())) {

                    tsinyNo = "";
                }
                else {
                    tsinyNo = itKykSya.getTsinyno();
                }

                String tsinadr1kj = null;
                if (BizUtil.isBlank(itKykSya.getTsinadr1kj())) {

                    tsinadr1kj = "";
                }
                else {
                    tsinadr1kj = itKykSya.getTsinadr1kj();
                }

                ZT_SyainMeiboTy ztSyainMeiboTy = new ZT_SyainMeiboTy();

                ztSyainMeiboTy.setZtyhokenkbn("I");
                ztSyainMeiboTy.setZtysyainmeibokbn("1");
                ztSyainMeiboTy.setZtykyksyaskinmeino(itKykSya.getKyksakuinmeino());
                ztSyainMeiboTy.setZtysyainnm(itKykSya.getKyknmkn());
                ztSyainMeiboTy.setZtykanjisyainnm(itKykSya.getKyknmkj());
                ztSyainMeiboTy.setZtysyainseiymd(kykseiYmd);
                ztSyainMeiboTy.setZtytsinkihontikucd(tsinyNo.concat(""));
                ztSyainMeiboTy.setZtykanjitsinkaiadr(tsinadr1kj.concat(itKykSya.getTsinadr2kj()).
                    concat(itKykSya.getTsinadr3kj()));
                ztSyainMeiboTy.setZtysyono(itKykSya.getSyono());
                ztSyainMeiboTy.setZtyhknsyukigou("00");
                ztSyainMeiboTy.setZtyannaifuyouriyuukbn(hanteiAnnaiFuyouRiyuuKbn(itKykKihon, itKykSyouhn));
                ztSyainMeiboTy.setZtyhrkkaisuukbn(hanteiHrkkaisuuKbn(itKykKihon));
                ztSyainMeiboTy.setZtyhrkkeirokbn(hanteiHrkkeiroKbn(itKykKihon));
                ztSyainMeiboTy.setZtytksyuannaikykkbn("0");
                ztSyainMeiboTy.setZtysouhuhunoukbn(souhuhunouKbn);
                ztSyainMeiboTy.setZtysyainmeibos(0L);
                ztSyainMeiboTy.setZtysyainmeibop(0L);
                ztSyainMeiboTy.setZtysyainmeibosyouyop(0L);
                ztSyainMeiboTy.setZtyyofuritysytzumihyouji("0");
                ztSyainMeiboTy.setZtynayosekihontikucd("");
                ztSyainMeiboTy.setZtyyobiv10("");

                BizPropertyInitializer.initialize(ztSyainMeiboTy);

                entityInserter.add(ztSyainMeiboTy);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

        }
    }

    private String hanteiAnnaiFuyouRiyuuKbn(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn) {

        String annaiFuyouRiyuuKbn = "";
        String kykjyoutai = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        if (C_Kykjyoutai.HRKMTYUU.eq(pKykSyouhn.getKykjyoutai()) &&
            (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()))) {
            kykjyoutai = C_Kykjyoutai.IKKATUNK.getValue();
        }
        else {
            kykjyoutai = pKykSyouhn.getKykjyoutai().getValue();
        }

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(kykjyoutai,
            C_Kykjyoutai.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {
            annaiFuyouRiyuuKbn = kbnInfoBean.getKbnData();
        }
        else {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                IT_KykSyouhn.KYKJYOUTAI,
                kykjyoutai));
        }

        return annaiFuyouRiyuuKbn;
    }

    private String hanteiHrkkaisuuKbn(IT_KykKihon pKykKihon) {

        String hrkkaisuuKbn = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pKykKihon.getHrkkaisuu().getValue(),
            C_Hrkkaisuu.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {
            hrkkaisuuKbn = kbnInfoBean.getKbnData();
        }
        else {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                IT_KykKihon.HRKKAISUU,
                pKykKihon.getHrkkaisuu().getValue()));
        }

        return hrkkaisuuKbn;
    }

    private String hanteiHrkkeiroKbn(IT_KykKihon pKykKihon) {

        String hrkkeiroKbn = "";
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pKykKihon.getHrkkeiro().getValue(),
            C_Hrkkeiro.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        if (kbnInfoBean.isHenkanFlg()) {
            hrkkeiroKbn = kbnInfoBean.getKbnData();
        }
        else {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                IT_KykKihon.HRKKEIRO,
                pKykKihon.getHrkkeiro().getValue()));
        }

        return hrkkeiroKbn;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
