package yuyu.batch.hozen.khinterf.khgnkumdhnflwcallfilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khgnkumdhnflwcallfilesks.dba.KhFollowCallTaisyouDataBean;
import yuyu.batch.hozen.khinterf.khgnkumdhnflwcallfilesks.dba.KhGnkuMdhnFlwCallFileSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_GinkouMdhnFollowCall;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス 銀行窓販フォローコール対象Ｆ作成クラス
 */
public class KhGnkuMdhnFlwCallFileSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLEID  = IT_GinkouMdhnFollowCall.TABLE_NAME;

    private static final String RECOVERY_FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhGnkuMdhnFlwCallFileSksDao khGnkuMdhnFlwCallFileSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        long syoriKns = 0;

        try (
            ExDBResults<KhFollowCallTaisyouDataBean> khFollowCallTaisyouDataBeanLst =
            khGnkuMdhnFlwCallFileSksDao.getKhFollowCallTaisyouDataBeans(kakutyoujobCd, syoriYmd);
            EntityInserter<ZT_KhGinkouMdhnFollowCallTy> entityInserter = new EntityInserter<>()) {

            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

            for (KhFollowCallTaisyouDataBean khFollowCallTaisyouDataBean : khFollowCallTaisyouDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khFollowCallTaisyouDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khFollowCallTaisyouDataBean.getSyono());

                ZT_KhGinkouMdhnFollowCallTy khGinkouMdhnFollowCallTy = new ZT_KhGinkouMdhnFollowCallTy();

                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                    String.valueOf(khFollowCallTaisyouDataBean.getHrkKeiro()),
                    C_Hrkkeiro.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                String hrkKeiro;

                if (kbnInfoBean.isHenkanFlg()) {

                    hrkKeiro = kbnInfoBean.getKbnData();
                }
                else {
                    throw new CommonBizAppException("他システム連動用区分値変換に失敗しました。区分名：払込経路　　区分値：" +
                        khFollowCallTaisyouDataBean.getHrkKeiro());
                }

                String bankCd = "";
                String sitenCd = "";
                String kouzaNo = "";
                if (C_Hrkkeiro.KOUHURI.eq(khFollowCallTaisyouDataBean.getHrkKeiro())) {

                    bankCd = khFollowCallTaisyouDataBean.getBankCd();
                    sitenCd = khFollowCallTaisyouDataBean.getSitenCd();
                    kouzaNo = khFollowCallTaisyouDataBean.getKouzaNo();
                }
                else {

                    bankCd = "0000";
                    sitenCd = "000";
                    kouzaNo = "0000000";
                }

                String yokinKbn;

                if (C_Hrkkeiro.KOUHURI.eq(khFollowCallTaisyouDataBean.getHrkKeiro())) {

                    kbnInfoBean = bzKbnHenkanUtil.convKbn(String.valueOf(khFollowCallTaisyouDataBean.getYokinKbn()),
                        C_YokinKbn.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                    if (kbnInfoBean.isHenkanFlg()) {
                        yokinKbn = kbnInfoBean.getKbnData();
                    }
                    else {
                        throw new CommonBizAppException("他システム連動用区分値変換に失敗しました。区分名：預金種目区分　　区分値：" +
                            khFollowCallTaisyouDataBean.getYokinKbn());
                    }
                }
                else {

                    yokinKbn = "0";
                }

                kbnInfoBean = bzKbnHenkanUtil.convKbn(String.valueOf(khFollowCallTaisyouDataBean.getHhknSei()),
                    C_Hhknsei.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                String hhknSei;
                if (kbnInfoBean.isHenkanFlg()) {
                    hhknSei = kbnInfoBean.getKbnData();
                }
                else {
                    throw new CommonBizAppException("他システム連動用区分値変換に失敗しました。区分名：性別　　区分値：" +
                        khFollowCallTaisyouDataBean.getHhknSei());
                }

                String hnkngKhmignnmei = "";
                String hnsyugKhmignnmei = "";
                int ketasuu = 0;
                int kyoyoKetasuu = YuyuBizConfig.getInstance().getKzmeigiKanaNmKyoyou();

                hnkngKhmignnmei = ConvertUtil.toHanAll(khFollowCallTaisyouDataBean.getKzMeigiNmKn(), 0, 0);
                ketasuu = hnkngKhmignnmei.length();

                if (ketasuu > kyoyoKetasuu) {
                    hnsyugKhmignnmei = hnkngKhmignnmei.substring(0, kyoyoKetasuu);
                }
                else {
                    hnsyugKhmignnmei = hnkngKhmignnmei;
                }


                khGinkouMdhnFollowCallTy.setZtysyono(khFollowCallTaisyouDataBean.getSyono());
                khGinkouMdhnFollowCallTy.setZtysyorikbn(khFollowCallTaisyouDataBean.getFollowCallSyoriKbn());
                khGinkouMdhnFollowCallTy.setZtyannaip(Long.valueOf(khFollowCallTaisyouDataBean.getAnnaiGk().toString()));
                khGinkouMdhnFollowCallTy.setZtyyobiv8("00000000");
                khGinkouMdhnFollowCallTy.setZtyminyuuym(String.valueOf(khFollowCallTaisyouDataBean.getMinyuYm()));
                khGinkouMdhnFollowCallTy.setZtyyobiv8x2("00000000");
                khGinkouMdhnFollowCallTy.setZtykyksyaskinmeino(Strings.padStart(khFollowCallTaisyouDataBean.getKykSakuinmeiNo(), 10, '0'));
                khGinkouMdhnFollowCallTy.setZtykyksyaseiymd(String.valueOf(khFollowCallTaisyouDataBean.getKykSeiYmd()));
                khGinkouMdhnFollowCallTy.setZtykyknmhnykkbn(khFollowCallTaisyouDataBean.getKykNmHnykKbn());
                khGinkouMdhnFollowCallTy.setZtykjkyknm35keta(khFollowCallTaisyouDataBean.getKykNmKj());
                khGinkouMdhnFollowCallTy.setZtyknkyksyamei(khFollowCallTaisyouDataBean.getKykNmKn());
                khGinkouMdhnFollowCallTy.setZtyhhknnmhnykkbn(khFollowCallTaisyouDataBean.getHhknNmHnykKbn());
                khGinkouMdhnFollowCallTy.setZtyknjhhknmei(khFollowCallTaisyouDataBean.getHhknNmKj());
                khGinkouMdhnFollowCallTy.setZtyknhhknmei(khFollowCallTaisyouDataBean.getHhknNmKn());
                khGinkouMdhnFollowCallTy.setZtyhhknseikbn(hhknSei);
                khGinkouMdhnFollowCallTy.setZtyhhknseiymd(String.valueOf(khFollowCallTaisyouDataBean.getHhknSeiYmd()));
                khGinkouMdhnFollowCallTy.setZtykihontikucd(String.valueOf(khFollowCallTaisyouDataBean.getTsinYno()));
                String tsinAdrKj = khFollowCallTaisyouDataBean.getTsinAdr1Kj() +khFollowCallTaisyouDataBean.getTsinAdr2Kj()
                    + khFollowCallTaisyouDataBean.getTsinAdr3Kj();

                if (tsinAdrKj.length() < 62) {

                    khGinkouMdhnFollowCallTy.setZtykyksyaadr(tsinAdrKj);

                }
                else {

                    khGinkouMdhnFollowCallTy.setZtykyksyaadr(tsinAdrKj.substring(0, 62));
                }
                khGinkouMdhnFollowCallTy.setZtytsintelno(khFollowCallTaisyouDataBean.getTsinTelNo());
                khGinkouMdhnFollowCallTy.setZtykykymd(khFollowCallTaisyouDataBean.getKykYmd().toString());
                khGinkouMdhnFollowCallTy.setZtyjikaipjyuutouym(String.valueOf(khFollowCallTaisyouDataBean.getJkipJytYm()));
                khGinkouMdhnFollowCallTy.setZtyhrkkeirokbn(hrkKeiro);
                khGinkouMdhnFollowCallTy.setZtyhrkkaisuukbn(khFollowCallTaisyouDataBean.getFchrkKaisuu());
                khGinkouMdhnFollowCallTy.setZtyanniskcd(Strings.padEnd(khFollowCallTaisyouDataBean.getAnniSkCd(), 8, '0'));
                if (khFollowCallTaisyouDataBean.getSyouhnNm().length() < 15) {
                    khGinkouMdhnFollowCallTy.setZtyhknmeisyou15keta(khFollowCallTaisyouDataBean.getSyouhnNm());
                }
                else {
                    khGinkouMdhnFollowCallTy.setZtyhknmeisyou15keta(
                        khFollowCallTaisyouDataBean.getSyouhnNm().substring(0, 15));
                }
                khGinkouMdhnFollowCallTy.setZtybsyujdrtencd1(khFollowCallTaisyouDataBean.getBsyujDrtenCd1());
                khGinkouMdhnFollowCallTy.setZtybsyujbosyuucd1(khFollowCallTaisyouDataBean.getBsyujBosyuuCd1());
                khGinkouMdhnFollowCallTy.setZtybsyujdrtencd2(khFollowCallTaisyouDataBean.getBsyujDrtenCd2());
                khGinkouMdhnFollowCallTy.setZtybsyujbosyuucd2(khFollowCallTaisyouDataBean.getBsyujBosyuuCd2());
                khGinkouMdhnFollowCallTy.setZtybsyujdrtencd3(khFollowCallTaisyouDataBean.getBsyujDrtenCd3());
                khGinkouMdhnFollowCallTy.setZtybsyujbosyuucd3(khFollowCallTaisyouDataBean.getBsyujBosyuuCd3());
                khGinkouMdhnFollowCallTy.setZtybsyujdrtencd4(khFollowCallTaisyouDataBean.getBsyujDrtenCd4());
                khGinkouMdhnFollowCallTy.setZtybsyujbosyuucd4(khFollowCallTaisyouDataBean.getBsyujBosyuuCd4());
                khGinkouMdhnFollowCallTy.setZtybsyujdrtencd5(khFollowCallTaisyouDataBean.getBsyujDrtenCd5());
                khGinkouMdhnFollowCallTy.setZtybsyujbosyuucd5(khFollowCallTaisyouDataBean.getBsyujBosyuuCd5());
                khGinkouMdhnFollowCallTy.setZtysaisindrtencd(khFollowCallTaisyouDataBean.getSaisinDrtenCd());
                khGinkouMdhnFollowCallTy.setZtysaisinbosyuucd(khFollowCallTaisyouDataBean.getSaisinBosyuuCd());
                khGinkouMdhnFollowCallTy.setZtykzhurikaebankcd(bankCd);
                khGinkouMdhnFollowCallTy.setZtykzhurikaesitencd(sitenCd);
                khGinkouMdhnFollowCallTy.setZtykzhurikaeyokinkbn(yokinKbn);
                khGinkouMdhnFollowCallTy.setZtykzhurikaekouzano(kouzaNo);
                khGinkouMdhnFollowCallTy.setZtyhnsyugkhmignnmei(hnsyugKhmignnmei);

                BizPropertyInitializer.initialize(khGinkouMdhnFollowCallTy);

                entityInserter.add(khGinkouMdhnFollowCallTy);

                syoriKns++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKns)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
