package yuyu.batch.suuri.srkessan.srskoikmtyouseidenpyotyusyutu;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HuridenpageKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Ordering;

/**
 * 新契約追込調整伝票データ抽出クラス
 */
public class SrSkOikmTyouseiDenpyoTyusyutu implements Batch {

    @Inject
    private SrSkOikmTyouseiDenpyoTyusyutuBatchParam srSkOikmTyouseiDenpyoTyusyutuBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {

        return srSkOikmTyouseiDenpyoTyusyutuBatchParam;
    }

    @Execute
    @Transactional
    public void exec() {

        srSkOikmTyouseiDenpyoTyusyutuBatchParam.setParam();

        SrSkOikmTyouseiDenpyoTyusyutuDbaStatement srSkOikmTyouseiDenpyoTyusyutuDbaStatement =
            SWAKInjector.getInstance(SrSkOikmTyouseiDenpyoTyusyutuDbaStatement.class);

        try (ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst =
            srSkOikmTyouseiDenpyoTyusyutuDbaStatement.getSkOikmKaikei(
                srSkOikmTyouseiDenpyoTyusyutuBatchParam.getKsnyokugetufirstdayymd(),
                srSkOikmTyouseiDenpyoTyusyutuBatchParam.getKsndensimeymd());
            EntityInserter<ST_SkOikmTyouseiDenpyou> skOikmTyouseiDenpyouLst = new EntityInserter<>()) {

            List<ST_ConvertKanjyouKamoku> convertKanjyouKamokuLst =
                srSkOikmTyouseiDenpyoTyusyutuDbaStatement.getAllConvertKanjyouKamoku();

            Iterator<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanIter =
                skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst.iterator();

            if (!skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanIter.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, "0", "新契約追込調整伝票データテーブル"));

                return;
            }

            SrSkOikmTyouseiDenpyoTyusyutuItemEditor srSkOikmTyouseiDenpyoTyusyutuItemEditor =
                SWAKInjector.getInstance(SrSkOikmTyouseiDenpyoTyusyutuItemEditor.class);

            List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> aftSkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst =
                srSkOikmTyouseiDenpyoTyusyutuItemEditor.changeKanjyoukmkcd(
                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanIter, convertKanjyouKamokuLst);

            Comparator<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> comparator =
                new Comparator<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean>() {

                @Override
                public int compare(SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean pTarget1,
                    SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean pTarget2) {

                    String mosNoTarget1 = pTarget1.getMosno();

                    String mosNoTarget2 = pTarget2.getMosno();

                    String kanjyouKmkCdTarget1 = pTarget1.getKanjyoukmkcd().getValue();

                    String kanjyouKmkCdTarget2 = pTarget2.getKanjyoukmkcd().getValue();

                    String naibuKeiyakuKbnTarget1 = pTarget1.getNaibukeiyakukbn().getValue();

                    String naibuKeiyakuKbnTarget2 = pTarget2.getNaibukeiyakukbn().getValue();

                    String tekiyouKbnTarget1 = pTarget1.getTekiyoukbn().getValue();

                    String tekiyouKbnTarget2 = pTarget2.getTekiyoukbn().getValue();

                    String seg1CdTarget1 = pTarget1.getSeg1cd().getValue();

                    String seg1CdTarget2 = pTarget2.getSeg1cd().getValue();

                    String huriDenAtesakiCdTarget1 = pTarget1.getHuridenatesakicd();

                    String huriDenAtesakiCdTarget2 = pTarget2.getHuridenatesakicd();

                    String tantoCdTarget1 = pTarget1.getTantocd().getValue();

                    String tantoCdTarget2 = pTarget2.getTantocd().getValue();

                    String suitouBumonCdTarget1 = pTarget1.getSuitoubumoncd();

                    String suitouBumonCdTarget2 = pTarget2.getSuitoubumoncd();

                    String taisyakuKbnTarget1 = pTarget1.getTaisyakukbn().getValue();

                    String taisyakuKbnTarget2 = pTarget2.getTaisyakukbn().getValue();

                    int result = 0;

                    result = mosNoTarget1.compareTo(mosNoTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = kanjyouKmkCdTarget1.compareTo(kanjyouKmkCdTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = naibuKeiyakuKbnTarget1.compareTo(naibuKeiyakuKbnTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = tekiyouKbnTarget1.compareTo(tekiyouKbnTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = seg1CdTarget1.compareTo(seg1CdTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = huriDenAtesakiCdTarget1.compareTo(huriDenAtesakiCdTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = tantoCdTarget1.compareTo(tantoCdTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = suitouBumonCdTarget1.compareTo(suitouBumonCdTarget2);

                    if (result != 0) {

                        return result;
                    }

                    result = taisyakuKbnTarget1.compareTo(taisyakuKbnTarget2);

                    if (result != 0) {

                        return result;
                    }

                    return result;
                }
            };

            Ordering<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> ordering = Ordering.from(comparator);

            List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLstAftSort =
                ordering.sortedCopy(aftSkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst);

            List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanAftEdit =
                srSkOikmTyouseiDenpyoTyusyutuItemEditor.editKoumoku(
                    SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLstAftSort);

            for (SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean :
                skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanAftEdit) {

                ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou = new ST_SkOikmTyouseiDenpyou();

                BM_KanjyouKamoku kanjyouKamoku =
                    srSkOikmTyouseiDenpyoTyusyutuDbaStatement.getKanjyouKamoku(
                        skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getKanjyoukmkcd());

                skOikmTyouseiDenpyou.setDenkanjokamokucd(kanjyouKamoku.getDenkanjokamokucd());

                skOikmTyouseiDenpyou.setMosno(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getMosno());

                skOikmTyouseiDenpyou.setKanjyoukmkcd(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getKanjyoukmkcd());

                skOikmTyouseiDenpyou.setTaisyakukbn(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTaisyakukbn());

                skOikmTyouseiDenpyou.setNaibukeiyakukbn(
                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getNaibukeiyakukbn());

                skOikmTyouseiDenpyou.setTekiyoukbn(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTekiyoukbn());

                skOikmTyouseiDenpyou.setSeg1cd(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getSeg1cd());

                skOikmTyouseiDenpyou.setHuridenatesakicd(
                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getHuridenatesakicd());

                skOikmTyouseiDenpyou.setTantocd(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTantocd());

                skOikmTyouseiDenpyou.setSuitoubumoncd(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getSuitoubumoncd());

                skOikmTyouseiDenpyou.setDenyenkagk(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getDenyenkagk());

                skOikmTyouseiDenpyou.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

                skOikmTyouseiDenpyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                skOikmTyouseiDenpyou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skOikmTyouseiDenpyou);

                skOikmTyouseiDenpyouLst.add(skOikmTyouseiDenpyou);

                srSkOikmTyouseiDenpyoTyusyutuBatchParam.setSyorikensuu(
                    srSkOikmTyouseiDenpyoTyusyutuBatchParam.getSyorikensuu() + 1);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf( srSkOikmTyouseiDenpyoTyusyutuBatchParam.getSyorikensuu()),
            "新契約追込調整伝票データテーブル"));
    }
}
