package yuyu.batch.suuri.srkessan.srskkessankubunkeiri;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Srkessankbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriTy;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約決算用区分経理連動ファイル作成クラス
 */
public class SrSkKessanKubunKeiri implements Batch {

    private static final String KAIKEITANI = "5210000";

    private static final String KANJYOUKBN = "0000";

    private static final String ZERO4KETA = "0000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void exec() {

        int syoriKensuu = 0;

        ArrayList<ZT_SkKsnKubunKeiriTy> skKsnKubunKeiriTyLst = new ArrayList<>();

        ZT_SkKsnKubunKeiriTy bfrSkKsnKubunKeiriTy = null;

        ST_SkKessanSyukei bfrSkKessanSyukei = null;

        BizDate ketsusangetsuSayishuuEyigyoubi = bzBatchParam.getSyoriYmd().getPreviousMonth().getBizDateYM().
            getLastDay().getBusinessDay(CHolidayAdjustingMode.NEXT_IN_THIS_MONTH);

        SrSkKessanKubunKeiriDbaStatement srSkKessanKubunKeiriDbaStatement =
            SWAKInjector.getInstance(SrSkKessanKubunKeiriDbaStatement.class);

        List<ST_SkKessanSyukei> skKessanSyukeiLst =
            srSkKessanKubunKeiriDbaStatement.getSkKessanSyukei(ketsusangetsuSayishuuEyigyoubi);

        for (ST_SkKessanSyukei skKessanSyukei : skKessanSyukeiLst) {

            if (bfrSkKsnKubunKeiriTy == null) {

                bfrSkKsnKubunKeiriTy = new ZT_SkKsnKubunKeiriTy();

                if (skKessanSyukei.getSyoriYmd().getMonth() == SrCommonConstants.MONTH_JULY) {

                    bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.DAI1Q.getValue());
                }
                else if (skKessanSyukei.getSyoriYmd().getMonth() == SrCommonConstants.MONTH_OCTOBER) {

                    bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.TYUUKAN.getValue());
                }
                else if (skKessanSyukei.getSyoriYmd().getMonth() == SrCommonConstants.MONTH_JANUARY) {

                    bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.DAI3Q.getValue());
                }
                else {
                    if (skKessanSyukei.getDenymd().getMonth() == SrCommonConstants.MONTH_MARCH) {

                        bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.NENDOMATU.getValue());
                    }
                    else {

                        bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.BLNK.getValue());
                    }
                }

                bfrSkKsnKubunKeiriTy.setZtysuitoubumoncd(skKessanSyukei.getHuridenatesakicd() + ZERO4KETA);

                bfrSkKsnKubunKeiriTy.setZtykingaku(
                    new BigDecimal(skKessanSyukei.getDenyenkagk().toString()).longValue());

                bfrSkKsnKubunKeiriTy.setZtykaikeitani(KAIKEITANI);

                bfrSkKsnKubunKeiriTy.setZtysystemkbnnum(skKessanSyukei.getKeirisyskbn().getValue());

                bfrSkKsnKubunKeiriTy.setZtytorihikiymd(skKessanSyukei.getDenymd().toString());

                bfrSkKsnKubunKeiriTy.setZtytorihikinon7(Strings.padStart("", 7, '0'));

                bfrSkKsnKubunKeiriTy.setZtynyuuryokubasyo(Strings.padStart("", 7, '0'));

                bfrSkKsnKubunKeiriTy.setZtynyuuryokusyacd(Strings.padStart("", 6, '0'));

                bfrSkKsnKubunKeiriTy.setZtysyoriymdn(skKessanSyukei.getSyoriYmd().toString());

                bfrSkKsnKubunKeiriTy.setZtyonlinesyorikbn(Strings.padStart("", 2, '0'));

                bfrSkKsnKubunKeiriTy.setZtykanjyoukbnn(KANJYOUKBN);

                bfrSkKsnKubunKeiriTy.setZtytaisyakukbnn(skKessanSyukei.getTaisyakukbn().getValue());

                bfrSkKsnKubunKeiriTy.setZtykanjyoukamokucdn(skKessanSyukei.getDenkanjokamokucd());

                bfrSkKsnKubunKeiriTy.setZtykizokusegment(Strings.padStart(skKessanSyukei.getSeg1cd().getValue(), 4, '0'));

                bfrSkKsnKubunKeiriTy.setZtyaitesegment(Strings.padStart("", 4, '0'));

                BizPropertyInitializer.initialize(bfrSkKsnKubunKeiriTy);

                skKsnKubunKeiriTyLst.add(bfrSkKsnKubunKeiriTy);

                bfrSkKessanSyukei = skKessanSyukei;
            }
            else {


                if (BizDateUtil.compareYmd(bfrSkKessanSyukei.getDenymd(), skKessanSyukei.getDenymd()) ==
                    BizDateUtil.COMPARE_EQUAL &&
                    bfrSkKessanSyukei.getHuridenpagekbn().eq(skKessanSyukei.getHuridenpagekbn())&&
                    bfrSkKessanSyukei.getHuridenatesakicd().equals(skKessanSyukei.getHuridenatesakicd()) &&
                    bfrSkKessanSyukei.getKanjyouKamoku().getDenkanjokamokucd().equals(
                        skKessanSyukei.getKanjyouKamoku().getDenkanjokamokucd()) &&
                        bfrSkKessanSyukei.getTaisyakukbn().eq(skKessanSyukei.getTaisyakukbn()) &&
                        bfrSkKessanSyukei.getNaibukeiyakukbn().eq(skKessanSyukei.getNaibukeiyakukbn()) &&
                        bfrSkKessanSyukei.getTekiyoukbn().eq(skKessanSyukei.getTekiyoukbn()) &&
                        bfrSkKessanSyukei.getSeg1cd().equals(skKessanSyukei.getSeg1cd()))  {

                    bfrSkKsnKubunKeiriTy.setZtykingaku(bfrSkKsnKubunKeiriTy.getZtykingaku() +
                        new BigDecimal(skKessanSyukei.getDenyenkagk().toString()).longValue());
                }
                else {

                    bfrSkKsnKubunKeiriTy = new ZT_SkKsnKubunKeiriTy();

                    if (skKessanSyukei.getSyoriYmd().getMonth() == SrCommonConstants.MONTH_JULY) {

                        bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.DAI1Q.getValue());
                    }
                    else if (skKessanSyukei.getSyoriYmd().getMonth() == SrCommonConstants.MONTH_OCTOBER) {

                        bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.TYUUKAN.getValue());
                    }
                    else if (skKessanSyukei.getSyoriYmd().getMonth() == SrCommonConstants.MONTH_JANUARY) {

                        bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.DAI3Q.getValue());
                    }
                    else {
                        if (skKessanSyukei.getDenymd().getMonth() == SrCommonConstants.MONTH_MARCH) {

                            bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.NENDOMATU.getValue());
                        }
                        else {

                            bfrSkKsnKubunKeiriTy.setZtykessankbn(C_Srkessankbn.BLNK.getValue());
                        }
                    }

                    bfrSkKsnKubunKeiriTy.setZtysuitoubumoncd(skKessanSyukei.getHuridenatesakicd() + ZERO4KETA);

                    bfrSkKsnKubunKeiriTy.setZtykingaku(
                        new BigDecimal(skKessanSyukei.getDenyenkagk().toString()).longValue());

                    bfrSkKsnKubunKeiriTy.setZtykaikeitani(KAIKEITANI);

                    bfrSkKsnKubunKeiriTy.setZtysystemkbnnum(skKessanSyukei.getKeirisyskbn().getValue());

                    bfrSkKsnKubunKeiriTy.setZtytorihikiymd(skKessanSyukei.getDenymd().toString());

                    bfrSkKsnKubunKeiriTy.setZtytorihikinon7(Strings.padStart("", 7, '0'));

                    bfrSkKsnKubunKeiriTy.setZtynyuuryokubasyo(Strings.padStart("", 7, '0'));

                    bfrSkKsnKubunKeiriTy.setZtynyuuryokusyacd(Strings.padStart("", 6, '0'));

                    bfrSkKsnKubunKeiriTy.setZtysyoriymdn(skKessanSyukei.getSyoriYmd().toString());

                    bfrSkKsnKubunKeiriTy.setZtyonlinesyorikbn(Strings.padStart("", 2, '0'));

                    bfrSkKsnKubunKeiriTy.setZtykanjyoukbnn(KANJYOUKBN);

                    bfrSkKsnKubunKeiriTy.setZtytaisyakukbnn(skKessanSyukei.getTaisyakukbn().getValue());

                    bfrSkKsnKubunKeiriTy.setZtykanjyoukamokucdn(skKessanSyukei.getDenkanjokamokucd());

                    bfrSkKsnKubunKeiriTy.setZtykizokusegment(Strings.padStart(skKessanSyukei.getSeg1cd().getValue(), 4, '0'));

                    bfrSkKsnKubunKeiriTy.setZtyaitesegment(Strings.padStart("", 4, '0'));

                    BizPropertyInitializer.initialize(bfrSkKsnKubunKeiriTy);

                    skKsnKubunKeiriTyLst.add(bfrSkKsnKubunKeiriTy);

                    bfrSkKessanSyukei = skKessanSyukei;
                }
            }

        }

        for (ZT_SkKsnKubunKeiriTy skKsnKubunKeiriTy : skKsnKubunKeiriTyLst) {

            suuriDomManager.insert(skKsnKubunKeiriTy);

            syoriKensuu += 1;
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
            "新契約決算用区分経理Ｆテーブル（中）"));
    }
}
