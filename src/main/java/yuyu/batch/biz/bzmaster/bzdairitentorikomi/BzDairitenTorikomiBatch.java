package yuyu.batch.biz.bzmaster.bzdairitentorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DaisinHiDaisinKbn;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.def.classification.C_TykatukaiyouDrtenHyouji;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.entity.ZT_DairitenRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（代理店ＰＲＴ用連動Ｆテーブル（連））を読み込み、代理店マスタに反映するクラス
 */
public class BzDairitenTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzDairitenTorikomiDao bzDairitenTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long dairitenRnCount = zdbDomManager.getDairitenRnCount();

        if (dairitenRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "代理店ＰＲＴ用連動Ｆテーブル（連）");

        }

        deleteDairitenData();

        BzRenkeiHenkanUtil<BM_Dairiten, BM_Dairiten> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(BM_Dairiten.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        dairitenRnCount = registDairitenData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(dairitenRnCount)));
    }

    private void deleteDairitenData() {

        bzDairitenTorikomiDao.deleteDairiten();
    }

    @Transactional
    Long registDairitenData(BzRenkeiHenkanUtil<BM_Dairiten, BM_Dairiten> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (EntityInserter<BM_Dairiten> entityInserter = new EntityInserter<>();
            ExDBResults<ZT_DairitenRn> exDBResults = zdbDomManager.getAllDairitenRn()) {

            BM_Dairiten bmDairiten = null;
            for (ZT_DairitenRn ztDairitenRn : exDBResults) {

                bmDairiten = createDairitenData(ztDairitenRn);

                bmDairiten = pBzRenkeiHenkanUtil.convDouituBean(bmDairiten);

                BizPropertyInitializer.initialize(bmDairiten);

                entityInserter.add(bmDairiten);

                syoriCount++;
            }
        }
        return syoriCount;
    }

    private BM_Dairiten createDairitenData(ZT_DairitenRn pZtDairitenRn) {

        BM_Dairiten bmDairiten = new BM_Dairiten();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        bmDairiten.setDrtencd(pZtDairitenRn.getZrndairitencd());
        bmDairiten.setDrtennm(pZtDairitenRn.getZrndairitennm());
        bmDairiten.setKanjidairitennm(pZtDairitenRn.getZrnkanjidairitennm());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtDairitenRn.getZrnitakukeiyakuymd());
        bmDairiten.setItakukeiyakuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtDairitenRn.getZrnitakukeiyakukaiyakuymd());
        bmDairiten.setItakukeiyakukaiyakuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtDairitenRn.getZrndairitentourokuymd());
        bmDairiten.setDairitentourokuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bmDairiten.setDaisinhidaisinkbn(C_DaisinHiDaisinKbn.valueOf(pZtDairitenRn.getZrndaisinhidaisinkbn()));
        bmDairiten.setDrtkanrisosikicd1(BizUtil.zero2blank(pZtDairitenRn.getZrnkanrisosikicd1()));
        bmDairiten.setDrtkanrisosikicd2(BizUtil.zero2blank(pZtDairitenRn.getZrnkanrisosikicd2()));
        bmDairiten.setDrtkanrisosikicd3(BizUtil.zero2blank(pZtDairitenRn.getZrnkanrisosikicd3()));
        bmDairiten.setKeisyousakidrtencd(pZtDairitenRn.getZrnkeisyousakidairitencd());
        bmDairiten.setKsymtdrtencd(pZtDairitenRn.getZrnkeisyoumotodairitencd());
        bmDairiten.setDrtensyouhncdkami3x1(pZtDairitenRn.getZrndrtensyouhncdkami3x1());
        bmDairiten.setTsryshrkbntougetux1(pZtDairitenRn.getZrntsryshrkbntougetux1());
        bmDairiten.setTsryshrkbnyokugetux1(pZtDairitenRn.getZrntsryshrkbnyokugetux1());
        bmDairiten.setBntnptnkbnx1(pZtDairitenRn.getZrnbntnptnkbnx1());
        bmDairiten.setDrtensyouhncdkami3x2(pZtDairitenRn.getZrndrtensyouhncdkami3x2());
        bmDairiten.setTsryshrkbntougetux2(pZtDairitenRn.getZrntsryshrkbntougetux2());
        bmDairiten.setTsryshrkbnyokugetux2(pZtDairitenRn.getZrntsryshrkbnyokugetux2());
        bmDairiten.setBntnptnkbnx2(pZtDairitenRn.getZrnbntnptnkbnx2());
        bmDairiten.setDrtensyouhncdkami3x3(pZtDairitenRn.getZrndrtensyouhncdkami3x3());
        bmDairiten.setTsryshrkbntougetux3(pZtDairitenRn.getZrntsryshrkbntougetux3());
        bmDairiten.setTsryshrkbnyokugetux3(pZtDairitenRn.getZrntsryshrkbnyokugetux3());
        bmDairiten.setBntnptnkbnx3(pZtDairitenRn.getZrnbntnptnkbnx3());
        bmDairiten.setDrtensyouhncdkami3x4(pZtDairitenRn.getZrndrtensyouhncdkami3x4());
        bmDairiten.setTsryshrkbntougetux4(pZtDairitenRn.getZrntsryshrkbntougetux4());
        bmDairiten.setTsryshrkbnyokugetux4(pZtDairitenRn.getZrntsryshrkbnyokugetux4());
        bmDairiten.setBntnptnkbnx4(pZtDairitenRn.getZrnbntnptnkbnx4());
        bmDairiten.setDrtensyouhncdkami3x5(pZtDairitenRn.getZrndrtensyouhncdkami3x5());
        bmDairiten.setTsryshrkbntougetux5(pZtDairitenRn.getZrntsryshrkbntougetux5());
        bmDairiten.setTsryshrkbnyokugetux5(pZtDairitenRn.getZrntsryshrkbnyokugetux5());
        bmDairiten.setBntnptnkbnx5(pZtDairitenRn.getZrnbntnptnkbnx5());
        bmDairiten.setDrtensyouhncdkami3x6(pZtDairitenRn.getZrndrtensyouhncdkami3x6());
        bmDairiten.setTsryshrkbntougetux6(pZtDairitenRn.getZrntsryshrkbntougetux6());
        bmDairiten.setTsryshrkbnyokugetux6(pZtDairitenRn.getZrntsryshrkbnyokugetux6());
        bmDairiten.setBntnptnkbnx6(pZtDairitenRn.getZrnbntnptnkbnx6());
        bmDairiten.setDrtensyouhncdkami3x7(pZtDairitenRn.getZrndrtensyouhncdkami3x7());
        bmDairiten.setTsryshrkbntougetux7(pZtDairitenRn.getZrntsryshrkbntougetux7());
        bmDairiten.setTsryshrkbnyokugetux7(pZtDairitenRn.getZrntsryshrkbnyokugetux7());
        bmDairiten.setBntnptnkbnx7(pZtDairitenRn.getZrnbntnptnkbnx7());
        bmDairiten.setDrtensyouhncdkami3x8(pZtDairitenRn.getZrndrtensyouhncdkami3x8());
        bmDairiten.setTsryshrkbntougetux8(pZtDairitenRn.getZrntsryshrkbntougetux8());
        bmDairiten.setTsryshrkbnyokugetux8(pZtDairitenRn.getZrntsryshrkbnyokugetux8());
        bmDairiten.setBntnptnkbnx8(pZtDairitenRn.getZrnbntnptnkbnx8());
        bmDairiten.setDrtensyouhncdkami3x9(pZtDairitenRn.getZrndrtensyouhncdkami3x9());
        bmDairiten.setTsryshrkbntougetux9(pZtDairitenRn.getZrntsryshrkbntougetux9());
        bmDairiten.setTsryshrkbnyokugetux9(pZtDairitenRn.getZrntsryshrkbnyokugetux9());
        bmDairiten.setBntnptnkbnx9(pZtDairitenRn.getZrnbntnptnkbnx9());
        bmDairiten.setDrtensyouhncdkami3x10(pZtDairitenRn.getZrndrtensyouhncdkami3x10());
        bmDairiten.setTsryshrkbntougetux10(pZtDairitenRn.getZrntsryshrkbntougetux10());
        bmDairiten.setTsryshrkbnyokugetux10(pZtDairitenRn.getZrntsryshrkbnyokugetux10());
        bmDairiten.setBntnptnkbnx10(pZtDairitenRn.getZrnbntnptnkbnx10());
        bmDairiten.setDrtensyouhncdkami3x11(pZtDairitenRn.getZrndrtensyouhncdkami3x11());
        bmDairiten.setTsryshrkbntougetux11(pZtDairitenRn.getZrntsryshrkbntougetux11());
        bmDairiten.setTsryshrkbnyokugetux11(pZtDairitenRn.getZrntsryshrkbnyokugetux11());
        bmDairiten.setBntnptnkbnx11(pZtDairitenRn.getZrnbntnptnkbnx11());
        bmDairiten.setDrtensyouhncdkami3x12(pZtDairitenRn.getZrndrtensyouhncdkami3x12());
        bmDairiten.setTsryshrkbntougetux12(pZtDairitenRn.getZrntsryshrkbntougetux12());
        bmDairiten.setTsryshrkbnyokugetux12(pZtDairitenRn.getZrntsryshrkbnyokugetux12());
        bmDairiten.setBntnptnkbnx12(pZtDairitenRn.getZrnbntnptnkbnx12());
        bmDairiten.setDrtensyouhncdkami3x13(pZtDairitenRn.getZrndrtensyouhncdkami3x13());
        bmDairiten.setTsryshrkbntougetux13(pZtDairitenRn.getZrntsryshrkbntougetux13());
        bmDairiten.setTsryshrkbnyokugetux13(pZtDairitenRn.getZrntsryshrkbnyokugetux13());
        bmDairiten.setBntnptnkbnx13(pZtDairitenRn.getZrnbntnptnkbnx13());
        bmDairiten.setDrtensyouhncdkami3x14(pZtDairitenRn.getZrndrtensyouhncdkami3x14());
        bmDairiten.setTsryshrkbntougetux14(pZtDairitenRn.getZrntsryshrkbntougetux14());
        bmDairiten.setTsryshrkbnyokugetux14(pZtDairitenRn.getZrntsryshrkbnyokugetux14());
        bmDairiten.setBntnptnkbnx14(pZtDairitenRn.getZrnbntnptnkbnx14());
        bmDairiten.setDrtensyouhncdkami3x15(pZtDairitenRn.getZrndrtensyouhncdkami3x15());
        bmDairiten.setTsryshrkbntougetux15(pZtDairitenRn.getZrntsryshrkbntougetux15());
        bmDairiten.setTsryshrkbnyokugetux15(pZtDairitenRn.getZrntsryshrkbnyokugetux15());
        bmDairiten.setBntnptnkbnx15(pZtDairitenRn.getZrnbntnptnkbnx15());
        bmDairiten.setTsrybntnaitedrtencdx1(pZtDairitenRn.getZrntsrybntnaitedrtencdx1());
        bmDairiten.setTsrybntnwarix1(pZtDairitenRn.getZrntsrybntnwarix1());
        bmDairiten.setTsrybntnaitedrtencdx2(pZtDairitenRn.getZrntsrybntnaitedrtencdx2());
        bmDairiten.setTsrybntnwarix2(pZtDairitenRn.getZrntsrybntnwarix2());
        bmDairiten.setTsrybntnaitedrtencdx3(pZtDairitenRn.getZrntsrybntnaitedrtencdx3());
        bmDairiten.setTsrybntnwarix3(pZtDairitenRn.getZrntsrybntnwarix3());
        bmDairiten.setTsrybntnaitedrtencdx4(pZtDairitenRn.getZrntsrybntnaitedrtencdx4());
        bmDairiten.setTsrybntnwarix4(pZtDairitenRn.getZrntsrybntnwarix4());
        bmDairiten.setHnsituhykranktougetu(BizNumber.valueOf(pZtDairitenRn.getZrnhnsituhykranktougetu()));
        bmDairiten.setHnsituhykrankyokugetu(BizNumber.valueOf(pZtDairitenRn.getZrnhnsituhykrankyokugetu()));
        bmDairiten.setDairitentelno(pZtDairitenRn.getZrndairitentelno());
        bmDairiten.setDairitenfaxno(pZtDairitenRn.getZrndairitenfaxno());
        bmDairiten.setOyadrtencd(pZtDairitenRn.getZrnoyadairitencd());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtDairitenRn.getZrndairitenkouryokustartymd());
        bmDairiten.setDairitenkouryokukaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtDairitenRn.getZrndairitenkouryokuendymd());
        bmDairiten.setDairitenkouryokusyuuryouymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bmDairiten.setKinyuucd(BizUtil.zero2blank(pZtDairitenRn.getZrnkinyuukikancd()));
        bmDairiten.setKinyuusitencd(pZtDairitenRn.getZrnkinyuukikansitencd());
        bmDairiten.setDrtenjimcd(pZtDairitenRn.getZrndairitenjimusyocd());
        bmDairiten.setDaibosyuucd(pZtDairitenRn.getZrndaihyoubosyuunincd());
        bmDairiten.setBntndrtencd(pZtDairitenRn.getZrnbuntanaitedairitencd());
        bmDairiten.setBunwari(BizNumber.valueOf(pZtDairitenRn.getZrnbuntanwariai()));
        bmDairiten.setTkrtkkinyuuknhyouji(C_TkrtkKinyuuknHyouji.valueOf(pZtDairitenRn.getZrntokureitiikihyouji()));
        bmDairiten.setKydsskkinyuuknhyouji(C_KydsskKinyuuknHyouji.valueOf(pZtDairitenRn.getZrnkyoudousosikhyouji()));
        bmDairiten.setKydbosyuudairitenhyouji(
            C_KydBosyuuDairitenHyouji.valueOf(pZtDairitenRn.getZrnkyoudoubosyuhyouji()));
        bmDairiten.setYuuseijimusyocd(pZtDairitenRn.getZrnyuuseijimusyocd());
        bmDairiten.setToukatudairitencd(pZtDairitenRn.getZrntoukatudairitencd());
        bmDairiten.setMdhnschemedrtenhyouji(
            C_MdhnSchemeDrtenHyouji.valueOf(pZtDairitenRn.getZrnmdhnschemedrtenhyouji()));
        bmDairiten.setTykatukaiyoudrtenhyouji(
            C_TykatukaiyouDrtenHyouji.valueOf(pZtDairitenRn.getZrntykatukaiyoudrtenhyouji()));
        bmDairiten.setDrtentrkno(pZtDairitenRn.getZrndrtentrkno());

        return bmDairiten;
    }

}
