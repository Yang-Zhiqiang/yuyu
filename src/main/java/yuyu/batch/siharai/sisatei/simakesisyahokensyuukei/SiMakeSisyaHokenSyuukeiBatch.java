package yuyu.batch.siharai.sisatei.simakesisyahokensyuukei;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.file.csv.SiSsyHkgksyrSykInfoLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.SiDetailInfosBySknoSyonoSeikyuurirekinoBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 保険金給付金支払 査定／支払 支社別保険金種類別集計情報作成
 */
public class SiMakeSisyaHokenSyuukeiBatch implements Batch {
    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        BizDate syoriYmdStart = syoriYmd.getBizDateYM().addMonths(-1).getFirstDay();
        BizDate syoriYmdEnd = syoriYmd.getBizDateYM().getPreviousMonth().getLastDay();
        List<ZengetuSiharaiBunBean> zengetuSiharaiBunBeanList = Lists.newArrayList();
        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(syoriYmdStart, syoriYmdEnd)) {

            Iterator<JT_SkKihon> skKihon = exDBResults.iterator();
            if (skKihon.hasNext()) {
                KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
                KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
                BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
                while (skKihon.hasNext()) {
                    JT_SkKihon skKihonLoop = skKihon.next();
                    keiyakuPrm.setSyono(skKihonLoop.getSyono());
                    keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
                    keiyakuInfoSyutoku.getInfos(keiyakuPrm);
                    JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);
                    if (siKykKihon == null) {
                        throw new BizAppException(MessageId.EBS0004, "JT_SiKykKihon", JT_SkKihon.SYONO,
                            skKihonLoop.getSyono());
                    }
                    Integer maxSeikyuuRirekiNo = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(
                        skKihonLoop.getSkno(), skKihonLoop.getSyono());
                    JT_Sk sk = skKihonLoop.getSkBySeikyuurirekino(maxSeikyuuRirekiNo);
                    String sosikiCd = siKykKihon.getDrtenkanrisosikicd().substring(0, 3) + "0000";
                    BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(sosikiCd);
                    List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> siDetailInfosBySknoSyonoSeikyuurirekinoBeanList =
                        siharaiDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino(skKihonLoop.getSkno(),
                            skKihonLoop.getSyono(),
                            maxSeikyuuRirekiNo);
                    List<ShrGkMeisaiBean> shrGkMeisaiBeanlist = Lists.newArrayList();
                    HashMap<C_HokenkinsyuruiKbn, ShrGkMeisaiBean> shrGkMeisaiBeanMap =new HashMap<>();

                    for (SiDetailInfosBySknoSyonoSeikyuurirekinoBean siDetailInfosBySknoSyonoSeikyuurirekinoBean : siDetailInfosBySknoSyonoSeikyuurirekinoBeanList) {
                        if (!BizUtil.isZero(siDetailInfosBySknoSyonoSeikyuurirekinoBean.getJT_SiDetail().getKyhkg())) {
                            if (shrGkMeisaiBeanMap.containsKey(siDetailInfosBySknoSyonoSeikyuurirekinoBean
                                .getHokenkinsyuruikbn())) {
                                ShrGkMeisaiBean shrGkMeisaiBean = SWAKInjector.getInstance(ShrGkMeisaiBean.class);
                                shrGkMeisaiBean.setHokenkinSyuruiKbn(siDetailInfosBySknoSyonoSeikyuurirekinoBean
                                    .getHokenkinsyuruikbn());
                                shrGkMeisaiBean.setShrGk(siDetailInfosBySknoSyonoSeikyuurirekinoBean
                                    .getJT_SiDetail()
                                    .getKyhkg()
                                    .add(
                                        shrGkMeisaiBeanMap.get(
                                            siDetailInfosBySknoSyonoSeikyuurirekinoBean.getHokenkinsyuruikbn())
                                            .getShrGk()));
                                shrGkMeisaiBean.setYenshrGk(siDetailInfosBySknoSyonoSeikyuurirekinoBean
                                    .getJT_SiDetail()
                                    .getYenkyhgk()
                                    .add(
                                        shrGkMeisaiBeanMap.get(
                                            siDetailInfosBySknoSyonoSeikyuurirekinoBean.getHokenkinsyuruikbn())
                                            .getYenshrGk()));
                                shrGkMeisaiBean.setKyuuhuCd(siDetailInfosBySknoSyonoSeikyuurirekinoBean.getKyuuhucd());

                                shrGkMeisaiBeanMap.put(siDetailInfosBySknoSyonoSeikyuurirekinoBean.getHokenkinsyuruikbn(),
                                    shrGkMeisaiBean);
                            }
                            else {
                                ShrGkMeisaiBean shrGkMeisaiBean = SWAKInjector.getInstance(ShrGkMeisaiBean.class);
                                shrGkMeisaiBean.setHokenkinSyuruiKbn(siDetailInfosBySknoSyonoSeikyuurirekinoBean
                                    .getHokenkinsyuruikbn());
                                shrGkMeisaiBean.setShrGk(siDetailInfosBySknoSyonoSeikyuurirekinoBean.getJT_SiDetail()
                                    .getKyhkg());
                                shrGkMeisaiBean.setYenshrGk(siDetailInfosBySknoSyonoSeikyuurirekinoBean.getJT_SiDetail()
                                    .getYenkyhgk());
                                shrGkMeisaiBean.setKyuuhuCd(siDetailInfosBySknoSyonoSeikyuurirekinoBean.getKyuuhucd());

                                shrGkMeisaiBeanMap.put(siDetailInfosBySknoSyonoSeikyuurirekinoBean.getHokenkinsyuruikbn(),
                                    shrGkMeisaiBean);
                            }
                        }
                    }

                    for (Map.Entry<C_HokenkinsyuruiKbn, ShrGkMeisaiBean> tempMap :shrGkMeisaiBeanMap.entrySet()) {
                        shrGkMeisaiBeanlist.add(tempMap.getValue());
                    }
                    ZengetuSiharaiBunBean zengetuSiharaiBunBean = SWAKInjector.getInstance(ZengetuSiharaiBunBean.class);
                    zengetuSiharaiBunBean.setSisyaCd(siKykKihon.getDrtenkanrisosikicd().substring(0, 3));
                    zengetuSiharaiBunBean.setSisyaNm(bzGetSosikiDataBean.getKanjisosikinm20());
                    zengetuSiharaiBunBean.setSyoNo(skKihonLoop.getSyono());
                    zengetuSiharaiBunBean.setSkNo(skKihonLoop.getSkno());
                    zengetuSiharaiBunBean.setSeikyuuSyubetu(skKihonLoop.getSeikyuusyubetu());
                    zengetuSiharaiBunBean.setShrTuukaSyu(sk.getShrtuukasyu());
                    zengetuSiharaiBunBean.setKykTuukaSyu(sk.getKyktuukasyu());
                    zengetuSiharaiBunBean.setShrGkMeisaiBeanList(shrGkMeisaiBeanlist);
                    zengetuSiharaiBunBeanList.add(zengetuSiharaiBunBean);
                }
                Comparator<ZengetuSiharaiBunBean> comparator = new Comparator<ZengetuSiharaiBunBean>() {
                    @Override
                    public int compare(ZengetuSiharaiBunBean pTarget1, ZengetuSiharaiBunBean pTarget2) {
                        int iResult = pTarget1.getSisyaCd().compareTo(pTarget2.getSisyaCd());
                        if (iResult != 0) {
                            return iResult;
                        }
                        iResult = pTarget1.getSeikyuuSyubetu().compareTo(pTarget2.getSeikyuuSyubetu());
                        return iResult;

                    }
                };
                Ordering<ZengetuSiharaiBunBean> ordering = Ordering.from(comparator);
                zengetuSiharaiBunBeanList = ordering.sortedCopy(zengetuSiharaiBunBeanList);
            }

            String sisyaCd = null;
            long count = 0L;
            MeisaiRecordBean meisaiRecordBean = SWAKInjector.getInstance(MeisaiRecordBean.class);
            List<SiSsyHkgksyrSykInfoLayoutFile> siSsyHkgksyrSykInfoLayoutFileList = Lists.newArrayList();
            meisaiRecordBean.setSisyaCd("");
            meisaiRecordBean.setSisyaNm("");
            meisaiRecordBean.setSibouSshrCount(0);
            meisaiRecordBean.setSibouSshrGk(BizCurrency.valueOf(0));
            meisaiRecordBean.setSibouSshrCountUsd(0);
            meisaiRecordBean.setSibouSshrGkUsd(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
            meisaiRecordBean.setSibouSshrCountEur(0);
            meisaiRecordBean.setSibouSshrGkEur(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
            meisaiRecordBean.setSibouSshrCountAud(0);
            meisaiRecordBean.setSibouSshrGkAud(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            meisaiRecordBean.setSaigaiSshrCount(0);
            meisaiRecordBean.setSaigaiSshrGk(BizCurrency.valueOf(0));
            meisaiRecordBean.setSaigaiSshrCountUsd(0);
            meisaiRecordBean.setSaigaiSshrGkUsd(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
            meisaiRecordBean.setSaigaiSshrCountEur(0);
            meisaiRecordBean.setSaigaiSshrGkEur(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
            meisaiRecordBean.setSaigaiSshrCountAud(0);
            meisaiRecordBean.setSaigaiSshrGkAud(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            meisaiRecordBean.setSbKyhknShrCount(0);
            meisaiRecordBean.setSbKyhknShrGk(BizCurrency.valueOf(0));
            meisaiRecordBean.setSbKyhknShrCountUsd(0);
            meisaiRecordBean.setSbKyhknShrGkUsd(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
            meisaiRecordBean.setSbKyhknShrCountEur(0);
            meisaiRecordBean.setSbKyhknShrGkEur(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
            meisaiRecordBean.setSbKyhknShrCountAud(0);
            meisaiRecordBean.setSbKyhknShrGkAud(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

            if (zengetuSiharaiBunBeanList.size() > 0) {
                for (ZengetuSiharaiBunBean zengetuSiharaiBunBeanLoop : zengetuSiharaiBunBeanList) {
                    if (C_SeikyuuSyubetu.SB.eq(zengetuSiharaiBunBeanLoop.getSeikyuuSyubetu())) {
                        if (BizUtil.isBlank(sisyaCd)) {
                            meisaiRecordBean.setSisyaCd(zengetuSiharaiBunBeanLoop.getSisyaCd());
                            meisaiRecordBean.setSisyaNm(zengetuSiharaiBunBeanLoop.getSisyaNm());
                            for (ShrGkMeisaiBean shrGkMeisaiBean : zengetuSiharaiBunBeanLoop.getShrGkMeisaiBeanList()) {
                                if (C_HokenkinsyuruiKbn.SBHOKENKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn())) {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCount(1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSibouSshrGk(shrGkMeisaiBean.getShrGk());
                                        }
                                        else {
                                            meisaiRecordBean.setSibouSshrGk(shrGkMeisaiBean.getYenshrGk());
                                        }
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCount(0);
                                        meisaiRecordBean.setSibouSshrGk(BizCurrency.valueOf(0));
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCountUsd(1);
                                        meisaiRecordBean.setSibouSshrGkUsd(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCountUsd(0);
                                        meisaiRecordBean.setSibouSshrGkUsd(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.DOLLAR));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCountEur(1);
                                        meisaiRecordBean.setSibouSshrGkEur(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCountEur(0);
                                        meisaiRecordBean.setSibouSshrGkEur(BizCurrency
                                            .valueOf(0, BizCurrencyTypes.EURO));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCountAud(1);
                                        meisaiRecordBean.setSibouSshrGkAud(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCountAud(0);
                                        meisaiRecordBean.setSibouSshrGkAud(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.AU_DOLLAR));
                                    }
                                }
                                else if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn()))
                                {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCount(1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSaigaiSshrGk(shrGkMeisaiBean.getShrGk());
                                        }
                                        else {
                                            meisaiRecordBean.setSaigaiSshrGk(shrGkMeisaiBean.getYenshrGk());
                                        }
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCount(0);
                                        meisaiRecordBean.setSaigaiSshrGk(BizCurrency.valueOf(0));
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCountUsd(1);
                                        meisaiRecordBean.setSaigaiSshrGkUsd(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCountUsd(0);
                                        meisaiRecordBean.setSaigaiSshrGkUsd(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.DOLLAR));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCountEur(1);
                                        meisaiRecordBean.setSaigaiSshrGkEur(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCountEur(0);
                                        meisaiRecordBean.setSaigaiSshrGkEur(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.EURO));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCountAud(1);
                                        meisaiRecordBean.setSaigaiSshrGkAud(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCountAud(0);
                                        meisaiRecordBean.setSaigaiSshrGkAud(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.AU_DOLLAR));
                                    }

                                }
                                else if (C_HokenkinsyuruiKbn.SBKYUUHUKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn()))
                                {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCount(1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSbKyhknShrGk(shrGkMeisaiBean.getShrGk());
                                        }
                                        else {
                                            meisaiRecordBean.setSbKyhknShrGk(shrGkMeisaiBean.getYenshrGk());
                                        }
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCount(0);
                                        meisaiRecordBean.setSbKyhknShrGk(BizCurrency.valueOf(0));
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCountUsd(1);
                                        meisaiRecordBean.setSbKyhknShrGkUsd(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCountUsd(0);
                                        meisaiRecordBean.setSbKyhknShrGkUsd(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.DOLLAR));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCountEur(1);
                                        meisaiRecordBean.setSbKyhknShrGkEur(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCountEur(0);
                                        meisaiRecordBean.setSbKyhknShrGkEur(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.EURO));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCountAud(1);
                                        meisaiRecordBean.setSbKyhknShrGkAud(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCountAud(0);
                                        meisaiRecordBean.setSbKyhknShrGkAud(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.AU_DOLLAR));
                                    }

                                }
                            }
                        }
                        else if (sisyaCd.equals(zengetuSiharaiBunBeanLoop.getSisyaCd())) {
                            meisaiRecordBean.setSisyaCd(zengetuSiharaiBunBeanLoop.getSisyaCd());
                            meisaiRecordBean.setSisyaNm(zengetuSiharaiBunBeanLoop.getSisyaNm());
                            for (ShrGkMeisaiBean shrGkMeisaiBean : zengetuSiharaiBunBeanLoop.getShrGkMeisaiBeanList()) {
                                if (C_HokenkinsyuruiKbn.SBHOKENKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn())) {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCount(meisaiRecordBean.getSibouSshrCount() + 1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSibouSshrGk(meisaiRecordBean.getSibouSshrGk().add(
                                                shrGkMeisaiBean.getShrGk()));
                                        }
                                        else {
                                            meisaiRecordBean.setSibouSshrGk(meisaiRecordBean.getSibouSshrGk().add(
                                                shrGkMeisaiBean.getYenshrGk()));
                                        }

                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSibouSshrCountUsd(meisaiRecordBean.getSibouSshrCountUsd() + 1);
                                        meisaiRecordBean.setSibouSshrGkUsd(meisaiRecordBean.getSibouSshrGkUsd().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSibouSshrCountEur(meisaiRecordBean.getSibouSshrCountEur() + 1);
                                        meisaiRecordBean.setSibouSshrGkEur(meisaiRecordBean.getSibouSshrGkEur().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSibouSshrCountAud(meisaiRecordBean.getSibouSshrCountAud() + 1);
                                        meisaiRecordBean.setSibouSshrGkAud(meisaiRecordBean.getSibouSshrGkAud().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                }
                                else if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn()))
                                {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCount(meisaiRecordBean.getSaigaiSshrCount() + 1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSaigaiSshrGk(meisaiRecordBean.getSaigaiSshrGk().add(
                                                shrGkMeisaiBean.getShrGk()));
                                        }
                                        else {
                                            meisaiRecordBean.setSaigaiSshrGk(meisaiRecordBean.getSaigaiSshrGk().add(
                                                shrGkMeisaiBean.getYenshrGk()));
                                        }
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSaigaiSshrCountUsd(meisaiRecordBean.getSaigaiSshrCountUsd() + 1);
                                        meisaiRecordBean.setSaigaiSshrGkUsd(meisaiRecordBean.getSaigaiSshrGkUsd().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSaigaiSshrCountEur(meisaiRecordBean.getSaigaiSshrCountEur() + 1);
                                        meisaiRecordBean.setSaigaiSshrGkEur(meisaiRecordBean.getSaigaiSshrGkEur().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSaigaiSshrCountAud(meisaiRecordBean.getSaigaiSshrCountAud() + 1);
                                        meisaiRecordBean.setSaigaiSshrGkAud(meisaiRecordBean.getSaigaiSshrGkAud().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                }
                                else if (C_HokenkinsyuruiKbn.SBKYUUHUKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn()))
                                {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCount(meisaiRecordBean.getSbKyhknShrCount() + 1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSbKyhknShrGk(meisaiRecordBean.getSbKyhknShrGk().add(
                                                shrGkMeisaiBean.getShrGk()));
                                        }
                                        else {
                                            meisaiRecordBean.setSbKyhknShrGk(meisaiRecordBean.getSbKyhknShrGk().add(
                                                shrGkMeisaiBean.getYenshrGk()));
                                        }
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSbKyhknShrCountUsd(meisaiRecordBean.getSbKyhknShrCountUsd() + 1);
                                        meisaiRecordBean.setSbKyhknShrGkUsd(meisaiRecordBean.getSbKyhknShrGkUsd().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSbKyhknShrCountEur(meisaiRecordBean.getSbKyhknShrCountEur() + 1);
                                        meisaiRecordBean.setSbKyhknShrGkEur(meisaiRecordBean.getSbKyhknShrGkEur().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean
                                        .setSbKyhknShrCountAud(meisaiRecordBean.getSbKyhknShrCountAud() + 1);
                                        meisaiRecordBean.setSbKyhknShrGkAud(meisaiRecordBean.getSbKyhknShrGkAud().add(
                                            shrGkMeisaiBean.getShrGk()));
                                    }
                                }

                            }

                        }
                        else if (!sisyaCd.equals(zengetuSiharaiBunBeanLoop.getSisyaCd())) {
                            SiSsyHkgksyrSykInfoLayoutFile siSsyHkgksyrSykInfoLayoutFile = SWAKInjector
                                .getInstance(SiSsyHkgksyrSykInfoLayoutFile.class);
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSisyacd(meisaiRecordBean.getSisyaCd());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSisyanm(meisaiRecordBean.getSisyaNm());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrcount(meisaiRecordBean.getSibouSshrCount());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrgk(meisaiRecordBean.getSibouSshrGk()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSaigaisshrcount(meisaiRecordBean.getSaigaiSshrCount());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSaigaisshrgk(meisaiRecordBean.getSaigaiSshrGk()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrcountusd(meisaiRecordBean
                                .getSibouSshrCountUsd());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrgkusd(meisaiRecordBean.getSibouSshrGkUsd()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile
                            .setIfcSaigaisshrcountusd(meisaiRecordBean.getSaigaiSshrCountUsd());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSaigaisshrgkusd(meisaiRecordBean.getSaigaiSshrGkUsd()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrcountaud(meisaiRecordBean
                                .getSibouSshrCountAud());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrgkaud(meisaiRecordBean.getSibouSshrGkAud()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile
                            .setIfcSaigaisshrcountaud(meisaiRecordBean.getSaigaiSshrCountAud());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSaigaisshrgkaud(meisaiRecordBean.getSaigaiSshrGkAud()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrcounteur(meisaiRecordBean
                                .getSibouSshrCountEur());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSibousshrgkeur(meisaiRecordBean.getSibouSshrGkEur()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile
                            .setIfcSaigaisshrcounteur(meisaiRecordBean.getSaigaiSshrCountEur());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSaigaisshrgkeur(meisaiRecordBean.getSaigaiSshrGkEur()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrcount(meisaiRecordBean.getSbKyhknShrCount());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrgk(meisaiRecordBean.getSbKyhknShrGk()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrcountusd(meisaiRecordBean.
                                getSbKyhknShrCountUsd());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrgkusd(meisaiRecordBean.getSbKyhknShrGkUsd()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrcounteur(meisaiRecordBean.
                                getSbKyhknShrCountEur());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrgkeur(meisaiRecordBean.getSbKyhknShrGkEur()
                                .toString());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrcountaud(meisaiRecordBean.
                                getSbKyhknShrCountAud());
                            siSsyHkgksyrSykInfoLayoutFile.setIfcSbkyhknshrgkaud(meisaiRecordBean.getSbKyhknShrGkAud()
                                .toString());

                            siSsyHkgksyrSykInfoLayoutFileList.add(siSsyHkgksyrSykInfoLayoutFile);
                            count = count + 1;
                            meisaiRecordBean.setSisyaCd(zengetuSiharaiBunBeanLoop.getSisyaCd());
                            meisaiRecordBean.setSisyaNm(zengetuSiharaiBunBeanLoop.getSisyaNm());
                            meisaiRecordBean.setSibouSshrCount(0);
                            meisaiRecordBean.setSibouSshrGk(BizCurrency.valueOf(0));
                            meisaiRecordBean.setSibouSshrCountUsd(0);
                            meisaiRecordBean.setSibouSshrGkUsd(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                            meisaiRecordBean.setSibouSshrCountEur(0);
                            meisaiRecordBean.setSibouSshrGkEur(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
                            meisaiRecordBean.setSibouSshrCountAud(0);
                            meisaiRecordBean.setSibouSshrGkAud(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
                            meisaiRecordBean.setSaigaiSshrCount(0);
                            meisaiRecordBean.setSaigaiSshrGk(BizCurrency.valueOf(0));
                            meisaiRecordBean.setSaigaiSshrCountUsd(0);
                            meisaiRecordBean.setSaigaiSshrGkUsd(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                            meisaiRecordBean.setSaigaiSshrCountEur(0);
                            meisaiRecordBean.setSaigaiSshrGkEur(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
                            meisaiRecordBean.setSaigaiSshrCountAud(0);
                            meisaiRecordBean.setSaigaiSshrGkAud(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
                            meisaiRecordBean.setSbKyhknShrCount(0);
                            meisaiRecordBean.setSbKyhknShrGk(BizCurrency.valueOf(0));
                            meisaiRecordBean.setSbKyhknShrCountUsd(0);
                            meisaiRecordBean.setSbKyhknShrGkUsd(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                            meisaiRecordBean.setSbKyhknShrCountEur(0);
                            meisaiRecordBean.setSbKyhknShrGkEur(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
                            meisaiRecordBean.setSbKyhknShrCountAud(0);
                            meisaiRecordBean.setSbKyhknShrGkAud(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

                            for (ShrGkMeisaiBean shrGkMeisaiBean : zengetuSiharaiBunBeanLoop.getShrGkMeisaiBeanList()) {
                                if (C_HokenkinsyuruiKbn.SBHOKENKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn())) {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCount(1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSibouSshrGk(shrGkMeisaiBean.getShrGk());
                                        }
                                        else {
                                            meisaiRecordBean.setSibouSshrGk(shrGkMeisaiBean.getYenshrGk());
                                        }
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCount(0);
                                        meisaiRecordBean.setSibouSshrGk(BizCurrency.valueOf(0));
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCountUsd(1);
                                        meisaiRecordBean.setSibouSshrGkUsd(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCountUsd(0);
                                        meisaiRecordBean.setSibouSshrGkUsd(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.DOLLAR));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCountEur(1);
                                        meisaiRecordBean.setSibouSshrGkEur(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCountEur(0);
                                        meisaiRecordBean.setSibouSshrGkEur(BizCurrency
                                            .valueOf(0, BizCurrencyTypes.EURO));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSibouSshrCountAud(1);
                                        meisaiRecordBean.setSibouSshrGkAud(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSibouSshrCountAud(0);
                                        meisaiRecordBean.setSibouSshrGkAud(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.AU_DOLLAR));
                                    }
                                }
                                else if (C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn()))
                                {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCount(1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSaigaiSshrGk(shrGkMeisaiBean.getShrGk());
                                        }
                                        else {
                                            meisaiRecordBean.setSaigaiSshrGk(shrGkMeisaiBean.getYenshrGk());
                                        }
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCount(0);
                                        meisaiRecordBean.setSaigaiSshrGk(BizCurrency.valueOf(0));
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCountUsd(1);
                                        meisaiRecordBean.setSaigaiSshrGkUsd(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCountUsd(0);
                                        meisaiRecordBean.setSaigaiSshrGkUsd(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.DOLLAR));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCountEur(1);
                                        meisaiRecordBean.setSaigaiSshrGkEur(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCountEur(0);
                                        meisaiRecordBean.setSaigaiSshrGkEur(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.EURO));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSaigaiSshrCountAud(1);
                                        meisaiRecordBean.setSaigaiSshrGkAud(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSaigaiSshrCountAud(0);
                                        meisaiRecordBean.setSaigaiSshrGkAud(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.AU_DOLLAR));
                                    }
                                }
                                else if (C_HokenkinsyuruiKbn.SBKYUUHUKIN.eq(shrGkMeisaiBean.getHokenkinSyuruiKbn()))
                                {
                                    if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCount(1);
                                        if (C_Tuukasyu.JPY.eq(zengetuSiharaiBunBeanLoop.getKykTuukaSyu())) {
                                            meisaiRecordBean.setSbKyhknShrGk(shrGkMeisaiBean.getShrGk());
                                        }
                                        else {
                                            meisaiRecordBean.setSbKyhknShrGk(shrGkMeisaiBean.getYenshrGk());
                                        }
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCount(0);
                                        meisaiRecordBean.setSbKyhknShrGk(BizCurrency.valueOf(0));
                                    }
                                    if (C_Tuukasyu.USD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCountUsd(1);
                                        meisaiRecordBean.setSbKyhknShrGkUsd(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCountUsd(0);
                                        meisaiRecordBean.setSbKyhknShrGkUsd(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.DOLLAR));
                                    }
                                    if (C_Tuukasyu.EUR.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCountEur(1);
                                        meisaiRecordBean.setSbKyhknShrGkEur(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCountEur(0);
                                        meisaiRecordBean.setSbKyhknShrGkEur(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.EURO));
                                    }
                                    if (C_Tuukasyu.AUD.eq(zengetuSiharaiBunBeanLoop.getShrTuukaSyu())) {
                                        meisaiRecordBean.setSbKyhknShrCountAud(1);
                                        meisaiRecordBean.setSbKyhknShrGkAud(shrGkMeisaiBean.getShrGk());
                                    }
                                    else {
                                        meisaiRecordBean.setSbKyhknShrCountAud(0);
                                        meisaiRecordBean.setSbKyhknShrGkAud(BizCurrency.valueOf(0,
                                            BizCurrencyTypes.AU_DOLLAR));
                                    }
                                }
                            }
                        }
                        sisyaCd = zengetuSiharaiBunBeanLoop.getSisyaCd();
                    }

                }
                SiSsyHkgksyrSykInfoLayoutFile siSsyHkgksyrSykInfoLayoutFileLast = SWAKInjector
                    .getInstance(SiSsyHkgksyrSykInfoLayoutFile.class);
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSisyacd(meisaiRecordBean.getSisyaCd());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSisyanm(meisaiRecordBean.getSisyaNm());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrcount(meisaiRecordBean.getSibouSshrCount());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrgk(meisaiRecordBean.getSibouSshrGk().toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSaigaisshrcount(meisaiRecordBean.getSaigaiSshrCount());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSaigaisshrgk(meisaiRecordBean.getSaigaiSshrGk().toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrcountusd(meisaiRecordBean.getSibouSshrCountUsd());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrgkusd(meisaiRecordBean.getSibouSshrGkUsd()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast
                .setIfcSaigaisshrcountusd(meisaiRecordBean.getSaigaiSshrCountUsd());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSaigaisshrgkusd(meisaiRecordBean.getSaigaiSshrGkUsd()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrcountaud(meisaiRecordBean.getSibouSshrCountAud());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrgkaud(meisaiRecordBean.getSibouSshrGkAud()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast
                .setIfcSaigaisshrcountaud(meisaiRecordBean.getSaigaiSshrCountAud());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSaigaisshrgkaud(meisaiRecordBean.getSaigaiSshrGkAud()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrcounteur(meisaiRecordBean.getSibouSshrCountEur());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSibousshrgkeur(meisaiRecordBean.getSibouSshrGkEur()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast
                .setIfcSaigaisshrcounteur(meisaiRecordBean.getSaigaiSshrCountEur());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSaigaisshrgkeur(meisaiRecordBean.getSaigaiSshrGkEur()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrcount(meisaiRecordBean.getSbKyhknShrCount());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrgk(meisaiRecordBean.getSbKyhknShrGk()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrcountusd(meisaiRecordBean.
                    getSbKyhknShrCountUsd());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrgkusd(meisaiRecordBean.getSbKyhknShrGkUsd()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrcounteur(meisaiRecordBean.
                    getSbKyhknShrCountEur());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrgkeur(meisaiRecordBean.getSbKyhknShrGkEur()
                    .toString());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrcountaud(meisaiRecordBean.
                    getSbKyhknShrCountAud());
                siSsyHkgksyrSykInfoLayoutFileLast.setIfcSbkyhknshrgkaud(meisaiRecordBean.getSbKyhknShrGkAud()
                    .toString());

                siSsyHkgksyrSykInfoLayoutFileList.add(siSsyHkgksyrSykInfoLayoutFileLast);
                count = count + 1;

            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_SISYAHKNKN,
                siSsyHkgksyrSykInfoLayoutFileList, true);
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), kinou.getKinouNm()));
        }
    }
}
