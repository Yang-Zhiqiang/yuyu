package yuyu.batch.suuri.srsuuritoukei.srjigyounendosikitkhoyuu;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 事業年度式特約保有情報作成
 */
public class SrJigyounendosikiTkHoyuuBatch implements Batch {

    private static final String KINOUNM = "事業年度式特約保有情報作成";

    private static final String MSGINFO = "数理用エラー情報テーブル";

    private static final String FIRSTDAY = "01";

    @Inject
    private SrJigyounendosikiTkHoyuuBatchParam srJigyounendosikiTkHoyuuBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {
        return srJigyounendosikiTkHoyuuBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        SrJigyounendosikiTkHoyuuBatchDbAccess srJigyounendosikiTkHoyuuBatchDbAccess =
            SWAKInjector.getInstance(SrJigyounendosikiTkHoyuuBatchDbAccess.class);

        String kbnkey = srJigyounendosikiTkHoyuuBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, kbnkey));


        try (ExDBResults<IT_KykSyouhn> kykSyouhnLst
            = srJigyounendosikiTkHoyuuBatchDbAccess.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU, kbnkey);
            EntityInserter<ZT_JigyounndsikiTkHoyuuTy> jigyouNndsikiTkHoyuuTyLst = new EntityInserter<>();) {

            for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {

                IT_KhTtdkRireki khTtdkRireki = srJigyounendosikiTkHoyuuBatchDbAccess.getKhTtdkRireki(
                    kykSyouhn.getSyono(), kykSyouhn.getHenkousikibetukey());

                BM_SyouhnZokusei syouhnZokusei = srJigyounendosikiTkHoyuuBatchDbAccess.getSyouhnZokusei(
                    kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());

                BizDate hyuHanteiKijyunYmd = BizDate.valueOf(srJigyounendosikiTkHoyuuBatchParam.getSyoriYmd()
                    .getBizDateYM() + FIRSTDAY);

                srJigyounendosikiTkHoyuuBatchParam.setHoyuuHanteiymd(hyuHanteiKijyunYmd);

                if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn()) &&
                    BizDateUtil.compareYmd(kykSyouhn.getSyoumetuymd(), hyuHanteiKijyunYmd) ==
                    BizDateUtil.COMPARE_LESSER  &&
                    (BizDateUtil.compareYmd(khTtdkRireki.getSyoriYmd(),
                        srJigyounendosikiTkHoyuuBatchParam.getSyoriYmd()) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(khTtdkRireki.getSyoriYmd(),
                            srJigyounendosikiTkHoyuuBatchParam.getSyoriYmd()) == BizDateUtil.COMPARE_EQUAL)) {

                    continue;
                }

                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());
                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn ||
                    SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {

                }
                else {

                    continue;
                }

                HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
                HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

                hanteiHokenKikanBean.setKykYmd(kykSyouhn.getKykymd());
                hanteiHokenKikanBean.setCalcKijyunYmd(hyuHanteiKijyunYmd);
                hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);
                hanteiHokenKikanBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

                C_HknKknKbn hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

                if (C_HknKknKbn.DAI1HKNKKN.eq(hknKknKbn)) {

                }
                else {
                    continue;
                }

                IT_KykDairiten kykDairiten = srJigyounendosikiTkHoyuuBatchDbAccess.getKykDairitenByDrtenrenno(
                    kykSyouhn.getSyono());

                IT_KykSonotaTkyk kykSonotaTkyk = srJigyounendosikiTkHoyuuBatchDbAccess.getKykSonotaTkyk(
                    kykSyouhn.getSyono());

                IT_ItekiToukeiInfo itekiToukeiInfo = srJigyounendosikiTkHoyuuBatchDbAccess.getItekiToukeiInfoBySyono(
                    kykSyouhn.getSyono());

                IT_KykKihon kykKihon = srJigyounendosikiTkHoyuuBatchDbAccess.getKykKihon(
                    kykSyouhn.getSyono());

                ZT_JigyounndsikiTkHoyuuTy jigyounndsikiTkHoyuuTy = new ZT_JigyounndsikiTkHoyuuTy();

                SrJigyounendosikiTkHoyuuBatchEdit srJigyounendosikiTkHoyuuBatchEdit =
                    SWAKInjector.getInstance(SrJigyounendosikiTkHoyuuBatchEdit.class);
                boolean errorFlag = srJigyounendosikiTkHoyuuBatchEdit.editKoumoku(
                    srJigyounendosikiTkHoyuuBatchParam,
                    kykSyouhn,
                    kykDairiten,
                    kykSonotaTkyk,
                    itekiToukeiInfo,
                    kykKihon,
                    syouhnZokusei,
                    jigyounndsikiTkHoyuuTy);

                if (!errorFlag) {

                    jigyouNndsikiTkHoyuuTyLst.add(jigyounndsikiTkHoyuuTy);

                    srJigyounendosikiTkHoyuuBatchParam.setSyoriKensuu(srJigyounendosikiTkHoyuuBatchParam.getSyoriKensuu() + 1);
                }
                else {

                    continue;
                }

            }

        }

        if (SrJigyounendosikiTkHoyuuBatchParam.KAKUTYOUJOBCD.equals(
            srJigyounendosikiTkHoyuuBatchParam.getIbKakutyoujobcd()) &&
            srJigyounendosikiTkHoyuuBatchParam.getErrorSyoriKensuu() != 0) {
            throw new BizAppException(MessageId.IBC1027, MSGINFO, kbnkey,
                String.valueOf(srJigyounendosikiTkHoyuuBatchParam.getErrorSyoriKensuu()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, KINOUNM, kbnkey,
            String.valueOf(srJigyounendosikiTkHoyuuBatchParam.getSyoriKensuu())));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1027, MSGINFO, kbnkey,
            String.valueOf(srJigyounendosikiTkHoyuuBatchParam.getErrorSyoriKensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, kbnkey));
    }

}