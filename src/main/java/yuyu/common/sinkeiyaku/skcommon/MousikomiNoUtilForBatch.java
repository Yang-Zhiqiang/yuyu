package yuyu.common.sinkeiyaku.skcommon;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.meta.QHT_MosnoKanri;
import yuyu.infr.file.FileControlManager;

/**
 * 新契約 申込書番号管理クラス
 */
public class MousikomiNoUtilForBatch {

    private static final  Logger logger= LoggerFactory.getLogger(MousikomiNoUtilForBatch.class);

    private static final   String FILE_TYPE  = ".txt";

    private static final   String FILE_PREFIX  = "MosnoList_";

    public static synchronized List<String> getMousikomiNo (final String pMosnoChannel, final int pKennsuu,
        final BizDate pSyoriYmd) {

        final List<String>  mosnList = new ArrayList<>();

        final BaseUserInfo baseUserInfo = SWAKInjector.getInstance(BaseUserInfo.class);

        final String userId = baseUserInfo.getUserId();

        final String sysTime = BizDate.getSysDateTimeMilli();

        BizDate mossykykyoteiymdWk = null;

        if (!(CoreConfig.getInstance().isBatchProduct())) {

            throw new CommonBizAppException();
        }

        if (BizUtil.isBlank(pMosnoChannel)) {

            throw new BizAppException(MessageId.EBS1003, "申込番号チャネル", BizUtil.replaceIfNullOrBlank(pMosnoChannel,""));
        }

        if (!NumberUtils.isNumber(pMosnoChannel)){
            throw new BizAppException(MessageId.EBS1003, "申込番号チャネル", pMosnoChannel);
        }

        if ("00".equals(pMosnoChannel)) {

            throw new BizAppException(MessageId.EBS1003, "申込番号チャネル", pMosnoChannel);
        }

        if ("88".equals(pMosnoChannel)) {
            mossykykyoteiymdWk = pSyoriYmd.getBizDateYM().addMonths(60).getLastDay()
                .getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }
        else{
            mossykykyoteiymdWk = pSyoriYmd.getBizDateYM().addMonths(26).getLastDay()
                .getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        final BizDate mossykykyoteiymd = mossykykyoteiymdWk;

        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager em) {

                    List<HT_MosnoKanri> mosnoKanriEntityList = new ArrayList<HT_MosnoKanri>();

                    if (pMosnoChannel.equals("86")) {
                        mosnoKanriEntityList = getMosnoKanris(em, "86000001", "88699999", pKennsuu);
                    }
                    else if (pMosnoChannel.equals("88")) {
                        mosnoKanriEntityList = getMosnoKanris(em, "88700000", "88999999", pKennsuu);
                    }
                    else if (pMosnoChannel.equals("78")) {
                        mosnoKanriEntityList = getMosnoKanris(em, "78000001", "79999999", pKennsuu);
                    }
                    else {
                        mosnoKanriEntityList = getMosnoKanris(em, pMosnoChannel + "000001", pMosnoChannel + "999999", pKennsuu);
                    }

                    if ((CollectionUtils.isEmpty(mosnoKanriEntityList)) || (mosnoKanriEntityList.size() != pKennsuu)) {
                        throw new BizAppException(MessageId.EBS0005, "HT_MosnoKanri", "申込番号チャネル", pMosnoChannel,
                            "件数", String.valueOf(pKennsuu));

                    }
                    for (HT_MosnoKanri mosnoKanri:mosnoKanriEntityList) {

                        mosnoKanri.setSaibankahikbn(C_KahiKbn.HUKA);

                        mosnoKanri.setSaibanymd(pSyoriYmd);

                        mosnoKanri.setMossykykyoteiymd(mossykykyoteiymd);

                        mosnoKanri.setGyoumuKousinsyaId(userId);

                        mosnoKanri.setGyoumuKousinTime(sysTime);

                        mosnList.add(mosnoKanri.getMosno8keta() + String.valueOf(MousikomiNoCheck.
                            calcDegit(mosnoKanri.getMosno8keta())));

                    }
                }
            }
            );

        final FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        String mosnoFileName = FILE_PREFIX + sysTime + FILE_TYPE;

        String filePath = YuyuBizConfig.getInstance().getAplLogOutputDir()
            + System.getProperty("file.separator") + mosnoFileName;

        logger.info("申込番号採番：申込番号チャネル：" + pMosnoChannel
            + "  件数＝" + pKennsuu + "  申込番号リスト＝" + mosnoFileName);

        try {

            fileControlManager.writeFileData(filePath, mosnList, FileType.PLAIN);

        } catch (Exception e) {

            logger.warn(MessageUtil.getMessage(MessageId.EBF0163, mosnoFileName));
        }

        return mosnList;

    }

    protected static synchronized List<HT_MosnoKanri> getMosnoKanris (final ExDBEntityManager pExDBEntityManager,
        final String pMosnoFrom, final String pMosnoTo, final int pKennsuu) {

        QHT_MosnoKanri qHT_MosnoKanri = new QHT_MosnoKanri();

        String jpql = $SELECT + qHT_MosnoKanri +
            $FROM + qHT_MosnoKanri.HT_MosnoKanri() +
            $WHERE + qHT_MosnoKanri.mosno8keta.ge(pMosnoFrom) +
            $AND + qHT_MosnoKanri.mosno8keta.le(pMosnoTo) +
            $AND + qHT_MosnoKanri.saibankahikbn.eq(C_KahiKbn.KA) +
            $ORDER_BY(qHT_MosnoKanri.saibanymd.asc(),qHT_MosnoKanri.mosno8keta.asc());

        return pExDBEntityManager.createJPQL(jpql).bind(qHT_MosnoKanri).setFirstResult(0)
            .setMaxResults(pKennsuu).getResultList();

    }

}