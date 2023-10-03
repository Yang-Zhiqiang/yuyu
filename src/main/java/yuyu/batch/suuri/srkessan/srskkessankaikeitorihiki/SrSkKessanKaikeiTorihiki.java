package yuyu.batch.suuri.srkessan.srskkessankaikeitorihiki;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Strings;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約決算用会計取引ファイル作成クラス
 */
public class SrSkKessanKaikeiTorihiki implements Batch {

    private static final String KAIKEITANI = "5210000";

    private static final String KAISYAKANTORIHIKIKBN = "0";

    private static final String TUKEKAEKBN = "0";

    private static final String KANJYOUKBN = "0000";

    private int trhkRenNo = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void exec() {

        BizDate ksnsaisyueigyoubiymd = bzBatchParam.getSyoriYmd().getPreviousMonth().getBizDateYM().getLastDay().
            getBusinessDay(CHolidayAdjustingMode.NEXT_IN_THIS_MONTH);

        int syoriKensuu = 0;

        ArrayList<SrSkKaikeiTorihikiFileInfo> srSkKaikeiTorihikiFileInfoLst = new ArrayList<>();

        SrSkKaikeiTorihikiFileInfo bfrSrSkKaikeiTorihikiFileInfo = null;

        try (EntityInserter<ZT_SkKsnKaikeiTorihikiTy> skKsnKaikeiTorihikiTyLst = new EntityInserter<>()) {

            List<ST_SkKessanSyukei> skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisByDenymd(ksnsaisyueigyoubiymd);

            for (ST_SkKessanSyukei skKessanSyukei : skKessanSyukeiLst) {

                if (bfrSrSkKaikeiTorihikiFileInfo == null) {

                    bfrSrSkKaikeiTorihikiFileInfo = createData(skKessanSyukei);

                    srSkKaikeiTorihikiFileInfoLst.add(bfrSrSkKaikeiTorihikiFileInfo);
                }
                else {

                    if (BizDateUtil.compareYmd(bfrSrSkKaikeiTorihikiFileInfo.getDenYMD(),
                        skKessanSyukei.getDenymd()) == BizDateUtil.COMPARE_EQUAL &&
                        bfrSrSkKaikeiTorihikiFileInfo.getHuriDenPageKbn().equals(
                            skKessanSyukei.getHuridenpagekbn()) &&
                            bfrSrSkKaikeiTorihikiFileInfo.getHuriDenAtesakiCd().equals(
                                skKessanSyukei.getHuridenatesakicd())) {

                        bfrSrSkKaikeiTorihikiFileInfo.getSiwakeMeisaiAdd(skKessanSyukei);
                    }
                    else {

                        bfrSrSkKaikeiTorihikiFileInfo = createData(skKessanSyukei);

                        srSkKaikeiTorihikiFileInfoLst.add(bfrSrSkKaikeiTorihikiFileInfo);
                    }
                }
            }

            for (SrSkKaikeiTorihikiFileInfo srSkKaikeiTorihikiFileInfo : srSkKaikeiTorihikiFileInfoLst) {

                List<SrSkSiwakeKoumokuInfo> srSkSiwakeKoumokuInfoLst =
                    srSkKaikeiTorihikiFileInfo.getSrSkSiwakeKoumokuInfoLst();

                for (SrSkSiwakeKoumokuInfo srSkSiwakeKoumokuInfo : srSkSiwakeKoumokuInfoLst) {

                    ZT_SkKsnKaikeiTorihikiTy skKsnKaikeiTorihikiTy = new ZT_SkKsnKaikeiTorihikiTy();

                    skKsnKaikeiTorihikiTy.setZtykaikeitani(KAIKEITANI);

                    skKsnKaikeiTorihikiTy.setZtysystemkbnnum(srSkKaikeiTorihikiFileInfo.getKeiriSysKbn().getValue());

                    skKsnKaikeiTorihikiTy.setZtytorihikiymd(srSkKaikeiTorihikiFileInfo.getDenYMD().toString());

                    skKsnKaikeiTorihikiTy.setZtytorihikinon7(Strings.padStart(srSkKaikeiTorihikiFileInfo.getTorihikiNo(),7,'0'));

                    skKsnKaikeiTorihikiTy.setZtynyuuryokubasyo(Strings.padStart("",7,'0'));

                    skKsnKaikeiTorihikiTy.setZtynyuuryokusyacd(Strings.padStart("",6,'0'));

                    skKsnKaikeiTorihikiTy.setZtysyoriymdn(bzBatchParam.getSyoriYmd().toString());

                    skKsnKaikeiTorihikiTy.setZtysimekirikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);

                    skKsnKaikeiTorihikiTy.setZtykessankbn(srSkSiwakeKoumokuInfo.getKessanKbn());

                    skKsnKaikeiTorihikiTy.setZtykaisyakantorihikikbn(KAISYAKANTORIHIKIKBN);

                    skKsnKaikeiTorihikiTy.setZtytukekaekbn(TUKEKAEKBN);

                    skKsnKaikeiTorihikiTy.setZtytablekosuu(Strings.padStart(
                        String.valueOf(srSkKaikeiTorihikiFileInfo.getSrSkSiwakeKoumokuInfoLst().size()),3,'0'));

                    skKsnKaikeiTorihikiTy.setZtykanjyoukbnn(KANJYOUKBN);

                    skKsnKaikeiTorihikiTy.setZtytaisyakukbnn(srSkSiwakeKoumokuInfo.getTaisyaKukbn().getValue());

                    skKsnKaikeiTorihikiTy.setZtykanjyoukamokucdn(srSkSiwakeKoumokuInfo.getDenKanjoKamokuCd());

                    skKsnKaikeiTorihikiTy.setZtysuitoubumon(srSkSiwakeKoumokuInfo.getSuitouBumon());

                    skKsnKaikeiTorihikiTy.setZtykingaku(
                        new BigDecimal(srSkSiwakeKoumokuInfo.getGaku().toString()).longValue());

                    skKsnKaikeiTorihikiTy.setZtytekiyoucd(srSkSiwakeKoumokuInfo.getTekiyouCd());

                    skKsnKaikeiTorihikiTy.setZtymeisaikanryoukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);

                    BizPropertyInitializer.initialize(skKsnKaikeiTorihikiTy);

                    skKsnKaikeiTorihikiTyLst.add(skKsnKaikeiTorihikiTy);

                    syoriKensuu += 1;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "新契約決算用会計取引Ｆテーブル（中）"));
    }

    @Execute
    @Transactional
    private SrSkKaikeiTorihikiFileInfo createData(ST_SkKessanSyukei pSkKessanSyukei) {

        SrSkKaikeiTorihikiFileInfo srSkKaikeiTorihikiFileInfo =
            SWAKInjector.getInstance(SrSkKaikeiTorihikiFileInfo.class);

        srSkKaikeiTorihikiFileInfo.setDenYMD(pSkKessanSyukei.getDenymd());

        srSkKaikeiTorihikiFileInfo.setHuriDenAtesakiCd(pSkKessanSyukei.getHuridenatesakicd());

        srSkKaikeiTorihikiFileInfo.setHuriDenPageKbn(pSkKessanSyukei.getHuridenpagekbn());

        srSkKaikeiTorihikiFileInfo.setKeiriSysKbn(pSkKessanSyukei.getKeirisyskbn());

        trhkRenNo = trhkRenNo + 1;

        String torihikiNoS3 = Strings.padStart(String.valueOf(trhkRenNo), 3, '0');

        String syoriMD = bzBatchParam.getSyoriYmd().getBizDateMD().toString();

        srSkKaikeiTorihikiFileInfo.setTorihikiNo(syoriMD + torihikiNoS3);

        srSkKaikeiTorihikiFileInfo.getSiwakeMeisaiAdd(pSkKessanSyukei);

        return srSkKaikeiTorihikiFileInfo;
    }
}
