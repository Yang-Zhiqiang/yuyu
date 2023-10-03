package yuyu.batch.suuri.srkessan.srskoikomipdenpyoudata;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約追込保険料伝票データ抽出クラス
 */
public class SrSkOikomiPDenpyouData implements Batch {

    @Inject
    private SrSkOikomiPDenpyouDataBatchParam srSkOikomiPDenpyouDataBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Override
    public BatchParam getParam() {

        return srSkOikomiPDenpyouDataBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srSkOikomiPDenpyouDataBatchParam.setParam();

        try (ExDBResults<ST_SkOikmKaikei> skOikmKaikeiLst = suuriDomManager
            .getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(
                srSkOikomiPDenpyouDataBatchParam.getKsnyokugetufirstdayymd(),
                srSkOikomiPDenpyouDataBatchParam.getKsndensimeymd());

            EntityInserter<ST_SkOikmSyukeiPDenpyou> skOikmSyukeiPDenpyouLst = new EntityInserter<>();) {

            int srKensuu = 0;

            for (ST_SkOikmKaikei skOikmKaikei : skOikmKaikeiLst) {

                ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou = new ST_SkOikmSyukeiPDenpyou();

                skOikmSyukeiPDenpyou.setDensyskbn(skOikmKaikei.getDensyskbn());
                skOikmSyukeiPDenpyou.setDenrenno(skOikmKaikei.getDenrenno());
                skOikmSyukeiPDenpyou.setEdano(skOikmKaikei.getEdano());
                skOikmSyukeiPDenpyou.setKanjyoukmkcd(skOikmKaikei.getKanjyoukmkcd());
                skOikmSyukeiPDenpyou.setTaisyakukbn(skOikmKaikei.getTaisyakukbn());
                skOikmSyukeiPDenpyou.setNaibukeiyakukbn(skOikmKaikei.getNaibukeiyakukbn());
                skOikmSyukeiPDenpyou.setTekiyoukbn(skOikmKaikei.getTekiyoukbn());
                skOikmSyukeiPDenpyou.setSeg1cd(skOikmKaikei.getSeg1cd());
                skOikmSyukeiPDenpyou.setHuridenatesakicd(skOikmKaikei.getHuridenatesakicd());
                skOikmSyukeiPDenpyou.setTantocd(skOikmKaikei.getTantocd());
                skOikmSyukeiPDenpyou.setSuitoubumoncd(skOikmKaikei.getSuitoubumoncd());
                skOikmSyukeiPDenpyou.setDenyenkagk(skOikmKaikei.getDenyenkagk());
                skOikmSyukeiPDenpyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                skOikmSyukeiPDenpyou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skOikmSyukeiPDenpyou);

                skOikmSyukeiPDenpyouLst.add(skOikmSyukeiPDenpyou);

                srKensuu = srKensuu + 1;
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(srKensuu), "新契約追込保険料伝票データテーブル"));
        }
    }
}
