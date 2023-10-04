package yuyu.batch.hozen.khinterf.khseihowebdrtenminyuudtlfsks;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khseihowebdrtenminyuudtlfsks.dba.KhSeihowebDrtenMinyuuDtlFSksDao;
import yuyu.batch.hozen.khinterf.khseihowebdrtenminyuudtlfsks.dba.SeihoWebMinyuuDtlBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.db.entity.ZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス 生保Ｗｅｂ代理店未入契約明細Ｆ作成
 */
public class KhSeihowebDrtenMinyuuDtlFSksBatch implements Batch {

    private static String TYSYTTAISYOUTABLEID = "IT_SeihowebMizuhoMinyuuDtl";

    private static String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSeihowebDrtenMinyuuDtlFSksDao khSeihowebDrtenMinyuuDtlFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long kensu = 0;

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobcd));

        try (
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            ExDBResults<SeihoWebMinyuuDtlBean> seihoWebMinyuuDtlBeanList =
                khSeihowebDrtenMinyuuDtlFSksDao.getSeihoWebMinyuuDtlBeans(kakutyoujobcd, syoriYmd.getBizDateYM())) {
            for (SeihoWebMinyuuDtlBean seihoWebMinyuuDtlBean : seihoWebMinyuuDtlBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(seihoWebMinyuuDtlBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(seihoWebMinyuuDtlBean.getSyono());

                String skeitantcd = BizUtil.zeroNum(seihoWebMinyuuDtlBean.getBosyuucd(), 6, 0);

                BizDateFormat dateFormat = new BizDateFormat("GyyMM", FillStyle.Zero);

                String pjytym = dateFormat.format(seihoWebMinyuuDtlBean.getPjytym()).substring(1, 5);

                String keiyakuym = dateFormat.format(seihoWebMinyuuDtlBean.getKeiyakuymd().getBizDateYM())
                    .substring(1, 5);

                String bosyuuym = dateFormat.format(seihoWebMinyuuDtlBean.getBosyuuym()).substring(1, 5);

                String hjnkykhyj = null;

                if (BizUtil.isBlank(seihoWebMinyuuDtlBean.getHjnkykhyj())) {

                    hjnkykhyj = "0";
                }
                else {

                    hjnkykhyj = seihoWebMinyuuDtlBean.getHjnkykhyj();
                }

                String bkofccd = null;

                if (seihoWebMinyuuDtlBean.getDrtenkanrisosikicd().length() < 3) {

                    bkofccd = Strings.padStart(seihoWebMinyuuDtlBean.getDrtenkanrisosikicd(), 3, '0');
                }
                else {

                    bkofccd = seihoWebMinyuuDtlBean.getDrtenkanrisosikicd().substring(0, 3);
                }

                if (C_DrtenChannelSyurui.YUUSEI.eq(seihoWebMinyuuDtlBean.getBosyuudairitengyousyukbn())) {

                    ZT_YuseiMinyuKykDtlSyokaiTy yuseiMinyuKykDtlSyokaiTy = new ZT_YuseiMinyuKykDtlSyokaiTy();

                    yuseiMinyuKykDtlSyokaiTy.setZtysakuseiym(seihoWebMinyuuDtlBean.getSyoriym().toString());
                    yuseiMinyuKykDtlSyokaiTy.setZtybsydrtencd(seihoWebMinyuuDtlBean.getDrtencd());
                    yuseiMinyuKykDtlSyokaiTy.setZtytntusycd(skeitantcd);
                    yuseiMinyuKykDtlSyokaiTy.setZtysyono(seihoWebMinyuuDtlBean.getSyono());
                    yuseiMinyuKykDtlSyokaiTy.setZtypjyuutouyymmwareki4keta(pjytym);
                    yuseiMinyuKykDtlSyokaiTy.setZtykykymwareki4keta(keiyakuym);
                    yuseiMinyuKykDtlSyokaiTy.setZtycifcd(seihoWebMinyuuDtlBean.getCifcd());
                    yuseiMinyuKykDtlSyokaiTy.setZtyatesakinm(seihoWebMinyuuDtlBean.getAtesakinm());
                    yuseiMinyuKykDtlSyokaiTy.setZtyminyuujyutuymdyofuri(seihoWebMinyuuDtlBean.getMinyujytymdyofuri());
                    yuseiMinyuKykDtlSyokaiTy.setZtyminyuujyutuymdyofuriigi(
                        seihoWebMinyuuDtlBean.getMinyujytymdyofuriigi());
                    yuseiMinyuKykDtlSyokaiTy.setZtyhassinka(seihoWebMinyuuDtlBean.getHassinka());
                    yuseiMinyuKykDtlSyokaiTy.setZtytelno15keta(seihoWebMinyuuDtlBean.getTelno());
                    yuseiMinyuKykDtlSyokaiTy.setZtybsyymwareki4keta(bosyuuym);
                    yuseiMinyuKykDtlSyokaiTy.setZtytntusynm(seihoWebMinyuuDtlBean.getTntnm10keta());
                    yuseiMinyuKykDtlSyokaiTy.setZtykydatkikbnkj(seihoWebMinyuuDtlBean.getKydatkikbnkj());
                    yuseiMinyuKykDtlSyokaiTy.setZtyhjnkykhyj(hjnkykhyj);
                    yuseiMinyuKykDtlSyokaiTy.setZtyhrkkaisuukj(seihoWebMinyuuDtlBean.getHrkkaisuukj());
                    yuseiMinyuKykDtlSyokaiTy.setZtyhrkkeirokj(seihoWebMinyuuDtlBean.getHrkkeirokj());
                    yuseiMinyuKykDtlSyokaiTy.setZtyp11keta(
                        new BigDecimal(seihoWebMinyuuDtlBean.getHrkp().toAdsoluteString()).longValue());
                    yuseiMinyuKykDtlSyokaiTy.setZtyknkimnyuuryukj(seihoWebMinyuuDtlBean.getKnkimnyuuryu());
                    yuseiMinyuKykDtlSyokaiTy.setZtyjikaiminyuuji(seihoWebMinyuuDtlBean.getJikaiminyuuji());
                    yuseiMinyuKykDtlSyokaiTy.setZtytntusygyouhaiinfo(seihoWebMinyuuDtlBean.getTntusygyouhaiinfo());
                    yuseiMinyuKykDtlSyokaiTy.setZtyhrkkeirobtjhmidasi(seihoWebMinyuuDtlBean.getHrkkeirobtjhmidasi());
                    yuseiMinyuKykDtlSyokaiTy.setZtyhrkkeirobtjh(seihoWebMinyuuDtlBean.getHrkkeirobtjh());
                    yuseiMinyuKykDtlSyokaiTy.setZtyhknsyuruimei(seihoWebMinyuuDtlBean.getHknsyuruinm30keta());
                    yuseiMinyuKykDtlSyokaiTy.setZtybkofccd(bkofccd);
                    yuseiMinyuKykDtlSyokaiTy.setZtydbskyoteiymd(seihoWebMinyuuDtlBean.getDbskyoteiym().toString());

                    if (seihoWebMinyuuDtlBean.getKyknm35keta().length() > 20) {

                        yuseiMinyuKykDtlSyokaiTy.setZtykyknmkj20(
                            seihoWebMinyuuDtlBean.getKyknm35keta().substring(0, 20));
                    }
                    else {
                        yuseiMinyuKykDtlSyokaiTy.setZtykyknmkj20(seihoWebMinyuuDtlBean.getKyknm35keta());
                    }

                    BizPropertyInitializer.initialize(yuseiMinyuKykDtlSyokaiTy);

                    multipleEntityInserter.add(yuseiMinyuKykDtlSyokaiTy);
                }
                else {

                    ZT_DrtenMinyuKykDtlSyokaiTy drtenMinyuKykDtlSyokaiTy = new ZT_DrtenMinyuKykDtlSyokaiTy();

                    drtenMinyuKykDtlSyokaiTy.setZtysakuseiym(seihoWebMinyuuDtlBean.getSyoriym().toString());
                    drtenMinyuKykDtlSyokaiTy.setZtybsydrtencd(seihoWebMinyuuDtlBean.getDrtencd());
                    drtenMinyuKykDtlSyokaiTy.setZtytntusycd(skeitantcd);
                    drtenMinyuKykDtlSyokaiTy.setZtysyono(seihoWebMinyuuDtlBean.getSyono());
                    drtenMinyuKykDtlSyokaiTy.setZtypjyuutouyymmwareki4keta(pjytym);
                    drtenMinyuKykDtlSyokaiTy.setZtykykymwareki4keta(keiyakuym);
                    drtenMinyuKykDtlSyokaiTy.setZtycifcd(seihoWebMinyuuDtlBean.getCifcd());
                    drtenMinyuKykDtlSyokaiTy.setZtyatesakinm(seihoWebMinyuuDtlBean.getAtesakinm());
                    drtenMinyuKykDtlSyokaiTy.setZtyminyuujyutuymdyofuri(seihoWebMinyuuDtlBean.getMinyujytymdyofuri());
                    drtenMinyuKykDtlSyokaiTy.setZtyminyuujyutuymdyofuriigi(
                        seihoWebMinyuuDtlBean.getMinyujytymdyofuriigi());
                    drtenMinyuKykDtlSyokaiTy.setZtyhassinka(seihoWebMinyuuDtlBean.getHassinka());
                    drtenMinyuKykDtlSyokaiTy.setZtytelno15keta(seihoWebMinyuuDtlBean.getTelno());
                    drtenMinyuKykDtlSyokaiTy.setZtybsyymwareki4keta(bosyuuym);
                    drtenMinyuKykDtlSyokaiTy.setZtytntusynm(seihoWebMinyuuDtlBean.getTntnm10keta());
                    drtenMinyuKykDtlSyokaiTy.setZtykydatkikbnkj(seihoWebMinyuuDtlBean.getKydatkikbnkj());
                    drtenMinyuKykDtlSyokaiTy.setZtyhrkkaisuukj(seihoWebMinyuuDtlBean.getHrkkaisuukj());
                    drtenMinyuKykDtlSyokaiTy.setZtyhrkkeirokj(seihoWebMinyuuDtlBean.getHrkkeirokj());
                    drtenMinyuKykDtlSyokaiTy.setZtyp11keta(
                        new BigDecimal(seihoWebMinyuuDtlBean.getHrkp().toAdsoluteString()).longValue());
                    drtenMinyuKykDtlSyokaiTy.setZtyknkimnyuuryukj(seihoWebMinyuuDtlBean.getKnkimnyuuryu());
                    drtenMinyuKykDtlSyokaiTy.setZtyjikaiminyuuji(seihoWebMinyuuDtlBean.getJikaiminyuuji());
                    drtenMinyuKykDtlSyokaiTy.setZtytntusygyouhaiinfo(seihoWebMinyuuDtlBean.getTntusygyouhaiinfo());
                    drtenMinyuKykDtlSyokaiTy.setZtyhrkkeirobtjhmidasi(seihoWebMinyuuDtlBean.getHrkkeirobtjhmidasi());
                    drtenMinyuKykDtlSyokaiTy.setZtyhrkkeirobtjh(seihoWebMinyuuDtlBean.getHrkkeirobtjh());
                    drtenMinyuKykDtlSyokaiTy.setZtyhknsyuruimei(seihoWebMinyuuDtlBean.getHknsyuruinm30keta());
                    drtenMinyuKykDtlSyokaiTy.setZtybkofccd(bkofccd);
                    drtenMinyuKykDtlSyokaiTy.setZtydbskyoteiymd(seihoWebMinyuuDtlBean.getDbskyoteiym().toString());

                    if (seihoWebMinyuuDtlBean.getKyknm35keta().length() > 20) {

                        drtenMinyuKykDtlSyokaiTy.setZtykyknmkj20(
                            seihoWebMinyuuDtlBean.getKyknm35keta().substring(0, 20));
                    }
                    else {

                        drtenMinyuKykDtlSyokaiTy.setZtykyknmkj20(seihoWebMinyuuDtlBean.getKyknm35keta());
                    }

                    BizPropertyInitializer.initialize(drtenMinyuKykDtlSyokaiTy);

                    multipleEntityInserter.add(drtenMinyuKykDtlSyokaiTy);
                }

                kensu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
