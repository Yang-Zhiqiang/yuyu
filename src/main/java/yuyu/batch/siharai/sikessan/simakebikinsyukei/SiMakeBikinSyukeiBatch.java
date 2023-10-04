package yuyu.batch.siharai.sikessan.simakebikinsyukei;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyouhnsyuruiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.file.csv.SiSiharaiBikinsyuukeiLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;


/**
 * 保険金給付金支払 決算 保険金給付金支払備金集計表作成
 */
public class SiMakeBikinSyukeiBatch implements Batch {

    private static final String TUSTTISUTABLEID = "JT_SiBikinkanri";

    private static final String RIKABARIFILEKUBUNID = "Si001";

    private BizDate kessanKijyunYmd;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = batchParam.getSyoriYmd();

        String ibKakutyoujobcd = batchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        if (syoriYmd.getDay() <= 15) {

            kessanKijyunYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        }

        else {

            kessanKijyunYmd = syoriYmd.getBizDateYM().getLastDay();
        }

        long syuturyokuKensuu = 0;
        List<SiSiharaiBikinsyuukeiLayoutFile> siSiharaiBikinsyuukeiLayoutFileLst = Lists.newArrayList();

        try(ExDBResults<JT_SiBikinkanri> siBikinkanriLst =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(ibKakutyoujobcd,
                kessanKijyunYmd, C_BknrigiKbn.BLNK)) {
            Iterator<JT_SiBikinkanri> siBikinkanriIter = siBikinkanriLst.iterator();
            if (siBikinkanriIter.hasNext()) {
                long snbknKensu = 0;
                BizCurrency snbKngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long saibknKensu = 0;
                BizCurrency saibKngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long ssaibknKensu = 0;
                BizCurrency ssaibKngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long sssaibknKensu = 0;
                BizCurrency sssaibKngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long goukeiKensu = 0;
                BizCurrency goukeibKngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long jikouKensu = 0;
                BizCurrency jikouKngaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long snbknKensuSyouhn = 0;
                BizCurrency snbKngakuSyouhn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long saibknKensuSyouhn = 0;
                BizCurrency saibKngakuSyouhn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long ssaibknKensuSyouhn = 0;
                BizCurrency ssaibKngakuSyouhn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long sssaibknKensuSyouhn = 0;
                BizCurrency sssaibKngakuSyouhn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long goukeiKensuSyouhn = 0;
                BizCurrency goukeibKngakuSyouhn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long jikouKensuSyouhn = 0;
                BizCurrency jikouKngakuSyouhn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                long dataCount = 0;

                C_HokenkinsyuruiKbn hknknsyruiKbnBkKey = C_HokenkinsyuruiKbn.BLNK;
                C_BkncdKbn bkncdKbnBkKey = C_BkncdKbn.BLNK;
                C_SyouhnsyuruiKbn syouhnsyuruiKbnBkKey = C_SyouhnsyuruiKbn.BLNK;
                C_Segcd segcdBkKey = C_Segcd.BLNK;
                String hknknsyruiNm = "";

                while (siBikinkanriIter.hasNext()) {

                    JT_SiBikinkanri siBikinkanri = siBikinkanriIter.next();

                    dataCount++;

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TUSTTISUTABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RIKABARIFILEKUBUNID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(siBikinkanri.getSyono());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(siBikinkanri.getSkno());

                    if (dataCount == 1) {
                        hknknsyruiKbnBkKey = siBikinkanri.getHokenkinsyuruikbn();
                        bkncdKbnBkKey = siBikinkanri.getSyuukeiyoubkncdkbn();
                        syouhnsyuruiKbnBkKey = siBikinkanri.getSyouhnsyuruikbn();
                        segcdBkKey = siBikinkanri.getKbnkeirisegcd();
                        hknknsyruiNm = siBikinkanri.getHokenkinsyuruikbn().getContent(C_HokenkinsyuruiKbn.PATTERN_REPORT);
                    }
                    else {
                        if (!hknknsyruiKbnBkKey.equals(siBikinkanri.getHokenkinsyuruikbn()) ||
                            !bkncdKbnBkKey.equals(siBikinkanri.getSyuukeiyoubkncdkbn()) ||
                            !syouhnsyuruiKbnBkKey.equals(siBikinkanri.getSyouhnsyuruikbn()) ||
                            !segcdBkKey.equals(siBikinkanri.getKbnkeirisegcd())) {
                            SiSiharaiBikinsyuukeiLayoutFile siSiharaiBikinsyuukeiLayoutFile =
                                SWAKInjector.getInstance(SiSiharaiBikinsyuukeiLayoutFile.class);

                            siSiharaiBikinsyuukeiLayoutFile.setIfcSyoriymdseireki(FixedDateFormatter.
                                formatYMDSeirekiSlashZeroFill(syoriYmd));
                            siSiharaiBikinsyuukeiLayoutFile.setIfcHknknsyruiname(hknknsyruiNm);
                            siSiharaiBikinsyuukeiLayoutFile.setIfcBkncd(bkncdKbnBkKey.getValue());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyruilevelcd(segcdBkKey.getValue());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyurui(C_Segcd.valueOf(segcdBkKey.getValue())
                                .getContent());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikensuu(String.valueOf(snbknKensu));
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikingk(snbKngaku.toString());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikensuu(String.valueOf(saibknKensu));
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikingk(saibKngaku.toString());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikensuu(String.valueOf(ssaibknKensu));
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikingk(ssaibKngaku.toString());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikensuu(String.valueOf(sssaibknKensu));
                            siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikingk(sssaibKngaku.toString());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikensuu(String.valueOf(goukeiKensu));
                            siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikingk(goukeibKngaku.toString());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukensuu(String.valueOf(jikouKensu));
                            siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukingk(jikouKngaku.toString());
                            siSiharaiBikinsyuukeiLayoutFile.setIfcYobisiharai("");

                            siSiharaiBikinsyuukeiLayoutFileLst.add(siSiharaiBikinsyuukeiLayoutFile);

                            snbknKensu = 0;
                            snbKngaku = BizCurrency.valueOf(0);
                            saibknKensu = 0;
                            saibKngaku = BizCurrency.valueOf(0);
                            ssaibknKensu = 0;
                            ssaibKngaku = BizCurrency.valueOf(0);
                            sssaibknKensu = 0;
                            sssaibKngaku = BizCurrency.valueOf(0);
                            goukeiKensu = 0;
                            goukeibKngaku = BizCurrency.valueOf(0);
                            jikouKensu = 0;
                            jikouKngaku = BizCurrency.valueOf(0);

                            syuturyokuKensuu++;

                            if (!hknknsyruiKbnBkKey.equals(siBikinkanri.getHokenkinsyuruikbn()) ||
                                !bkncdKbnBkKey.equals(siBikinkanri.getSyuukeiyoubkncdkbn()) ||
                                !syouhnsyuruiKbnBkKey.equals(siBikinkanri.getSyouhnsyuruikbn())) {
                                siSiharaiBikinsyuukeiLayoutFile =
                                    SWAKInjector.getInstance(SiSiharaiBikinsyuukeiLayoutFile.class);

                                siSiharaiBikinsyuukeiLayoutFile.setIfcSyoriymdseireki(FixedDateFormatter.
                                    formatYMDSeirekiSlashZeroFill(syoriYmd));
                                siSiharaiBikinsyuukeiLayoutFile.setIfcHknknsyruiname(hknknsyruiNm);
                                siSiharaiBikinsyuukeiLayoutFile.setIfcBkncd(bkncdKbnBkKey.getValue());
                                siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyruilevelcd("");
                                siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyurui(C_SyouhnsyuruiKbn
                                    .valueOf(syouhnsyuruiKbnBkKey.getValue()).getContent() + "合計");
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikensuu(String.valueOf(snbknKensuSyouhn));
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikingk(snbKngakuSyouhn.toString());
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikensuu(String.valueOf(saibknKensuSyouhn));
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikingk(saibKngakuSyouhn.toString());
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikensuu(String
                                    .valueOf(ssaibknKensuSyouhn));
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikingk(ssaibKngakuSyouhn.toString());
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikensuu(String
                                    .valueOf(sssaibknKensuSyouhn));
                                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikingk(sssaibKngakuSyouhn.toString());
                                siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikensuu(String.valueOf(goukeiKensuSyouhn));
                                siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikingk(goukeibKngakuSyouhn.toString());
                                siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukensuu(String.valueOf(jikouKensuSyouhn));
                                siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukingk(jikouKngakuSyouhn.toString());
                                siSiharaiBikinsyuukeiLayoutFile.setIfcYobisiharai("");

                                siSiharaiBikinsyuukeiLayoutFileLst.add(siSiharaiBikinsyuukeiLayoutFile);

                                snbknKensuSyouhn = 0;
                                snbKngakuSyouhn = BizCurrency.valueOf(0);
                                saibknKensuSyouhn = 0;
                                saibKngakuSyouhn = BizCurrency.valueOf(0);
                                ssaibknKensuSyouhn = 0;
                                ssaibKngakuSyouhn = BizCurrency.valueOf(0);
                                sssaibknKensuSyouhn = 0;
                                sssaibKngakuSyouhn = BizCurrency.valueOf(0);
                                goukeiKensuSyouhn = 0;
                                goukeibKngakuSyouhn = BizCurrency.valueOf(0);
                                jikouKensuSyouhn = 0;
                                jikouKngakuSyouhn = BizCurrency.valueOf(0);

                                syuturyokuKensuu++;
                            }

                            hknknsyruiKbnBkKey = siBikinkanri.getHokenkinsyuruikbn();
                            bkncdKbnBkKey = siBikinkanri.getSyuukeiyoubkncdkbn();
                            syouhnsyuruiKbnBkKey = siBikinkanri.getSyouhnsyuruikbn();
                            segcdBkKey = siBikinkanri.getKbnkeirisegcd();
                            hknknsyruiNm = siBikinkanri.getHokenkinsyuruikbn().getContent(
                                C_HokenkinsyuruiKbn.PATTERN_REPORT);
                        }
                    }

                    if (C_BknJkuKbn.SINBI.eq(siBikinkanri.getBknjkukbn())) {
                        snbknKensu++;
                        snbKngaku = snbKngaku.add(siBikinkanri.getBkngk());
                        goukeiKensu++;
                        goukeibKngaku = goukeibKngaku.add(siBikinkanri.getBkngk());
                        snbknKensuSyouhn++;
                        snbKngakuSyouhn = snbKngakuSyouhn.add(siBikinkanri.getBkngk());
                        goukeiKensuSyouhn++;
                        goukeibKngakuSyouhn = goukeibKngakuSyouhn.add(siBikinkanri.getBkngk());
                    }
                    else if (C_BknJkuKbn.SAIBI.eq(siBikinkanri.getBknjkukbn())) {
                        saibknKensu++;
                        saibKngaku = saibKngaku.add(siBikinkanri.getBkngk());
                        goukeiKensu++;
                        goukeibKngaku = goukeibKngaku.add(siBikinkanri.getBkngk());
                        saibknKensuSyouhn++;
                        saibKngakuSyouhn = saibKngakuSyouhn.add(siBikinkanri.getBkngk());
                        goukeiKensuSyouhn++;
                        goukeibKngakuSyouhn = goukeibKngakuSyouhn.add(siBikinkanri.getBkngk());
                    }
                    else if (C_BknJkuKbn.SAISAIBI.eq(siBikinkanri.getBknjkukbn())){
                        ssaibknKensu++;
                        ssaibKngaku = ssaibKngaku.add(siBikinkanri.getBkngk());
                        goukeiKensu++;
                        goukeibKngaku = goukeibKngaku.add(siBikinkanri.getBkngk());
                        ssaibknKensuSyouhn++;
                        ssaibKngakuSyouhn = ssaibKngakuSyouhn.add(siBikinkanri.getBkngk());
                        goukeiKensuSyouhn++;
                        goukeibKngakuSyouhn = goukeibKngakuSyouhn.add(siBikinkanri.getBkngk());
                    }
                    else if (C_BknJkuKbn.SAISAISAIBI.eq(siBikinkanri.getBknjkukbn())) {
                        sssaibknKensu++;
                        sssaibKngaku = sssaibKngaku.add(siBikinkanri.getBkngk());
                        goukeiKensu++;
                        goukeibKngaku = goukeibKngaku.add(siBikinkanri.getBkngk());
                        sssaibknKensuSyouhn++;
                        sssaibKngakuSyouhn = sssaibKngakuSyouhn.add(siBikinkanri.getBkngk());
                        goukeiKensuSyouhn++;
                        goukeibKngakuSyouhn = goukeibKngakuSyouhn.add(siBikinkanri.getBkngk());
                    }
                    else if (C_BknJkuKbn.JIKOU.eq(siBikinkanri.getBknjkukbn())) {
                        jikouKensu++;
                        jikouKngaku = jikouKngaku.add(siBikinkanri.getBkngk());
                        jikouKensuSyouhn++;
                        jikouKngakuSyouhn = jikouKngakuSyouhn.add(siBikinkanri.getBkngk());
                    }
                }

                bzRecoveryDatasikibetuBean.initializeBlank();

                SiSiharaiBikinsyuukeiLayoutFile siSiharaiBikinsyuukeiLayoutFile =
                    SWAKInjector.getInstance(SiSiharaiBikinsyuukeiLayoutFile.class);

                siSiharaiBikinsyuukeiLayoutFile.setIfcSyoriymdseireki(FixedDateFormatter.
                    formatYMDSeirekiSlashZeroFill(syoriYmd));
                siSiharaiBikinsyuukeiLayoutFile.setIfcHknknsyruiname(hknknsyruiNm);
                siSiharaiBikinsyuukeiLayoutFile.setIfcBkncd(bkncdKbnBkKey.getValue());
                siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyruilevelcd(segcdBkKey.getValue());
                siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyurui(C_Segcd.valueOf(segcdBkKey.getValue()).getContent());
                siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikensuu(String.valueOf(snbknKensu));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikingk(snbKngaku.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikensuu(String.valueOf(saibknKensu));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikingk(saibKngaku.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikensuu(String.valueOf(ssaibknKensu));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikingk(ssaibKngaku.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikensuu(String.valueOf(sssaibknKensu));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikingk(sssaibKngaku.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikensuu(String.valueOf(goukeiKensu));
                siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikingk(goukeibKngaku.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukensuu(String.valueOf(jikouKensu));
                siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukingk(jikouKngaku.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcYobisiharai("");

                siSiharaiBikinsyuukeiLayoutFileLst.add(siSiharaiBikinsyuukeiLayoutFile);

                siSiharaiBikinsyuukeiLayoutFile = SWAKInjector.getInstance(SiSiharaiBikinsyuukeiLayoutFile.class);

                siSiharaiBikinsyuukeiLayoutFile.setIfcSyoriymdseireki(FixedDateFormatter.
                    formatYMDSeirekiSlashZeroFill(syoriYmd));
                siSiharaiBikinsyuukeiLayoutFile.setIfcHknknsyruiname(hknknsyruiNm);
                siSiharaiBikinsyuukeiLayoutFile.setIfcBkncd(bkncdKbnBkKey.getValue());
                siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyruilevelcd("");
                siSiharaiBikinsyuukeiLayoutFile.setIfcHknsyurui(C_SyouhnsyuruiKbn.valueOf(syouhnsyuruiKbnBkKey
                    .getValue()).getContent() + "合計");
                siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikensuu(String.valueOf(snbknKensuSyouhn));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSinbikingk(snbKngakuSyouhn.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikensuu(String.valueOf(saibknKensuSyouhn));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaibikingk(saibKngakuSyouhn.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikensuu(String.valueOf(ssaibknKensuSyouhn));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaibikingk(ssaibKngakuSyouhn.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikensuu(String.valueOf(sssaibknKensuSyouhn));
                siSiharaiBikinsyuukeiLayoutFile.setIfcSaisaisaibikingk(sssaibKngakuSyouhn.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikensuu(String.valueOf(goukeiKensuSyouhn));
                siSiharaiBikinsyuukeiLayoutFile.setIfcGoukeikingk(goukeibKngakuSyouhn.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukensuu(String.valueOf(jikouKensuSyouhn));
                siSiharaiBikinsyuukeiLayoutFile.setIfcJikoukingk(jikouKngakuSyouhn.toString());
                siSiharaiBikinsyuukeiLayoutFile.setIfcYobisiharai("");

                siSiharaiBikinsyuukeiLayoutFileLst.add(siSiharaiBikinsyuukeiLayoutFile);

                syuturyokuKensuu = syuturyokuKensuu + 2;
            }
            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.SI_SHRBIKINSYKCSVFHKN,
                siSiharaiBikinsyuukeiLayoutFileLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syuturyokuKensuu),
            kinou.getKinouNm()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}