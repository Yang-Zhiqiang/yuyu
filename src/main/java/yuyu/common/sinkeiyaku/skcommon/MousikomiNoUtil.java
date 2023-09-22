package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 申込番号採番
 */
public class MousikomiNoUtil {

    private final String[][] MOSNOCHANNEL_TABLE =
    { { "00", "00", "00", "00", "00", "00", "00" },
        { "00", "86", "98", "98", "00", "00", "88" },
        { "00", "97", "97", "97", "00", "00", "00" },
        { "00", "86", "98", "98", "00", "00", "00" },
        { "00", "97", "97", "97", "00", "00", "00" },
        { "00", "86", "98", "98", "00", "00", "00" },
        { "00", "78", "99", "99", "00", "00", "00" } };

    private final int RETRY_COUNT = 5;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private static Logger logger;

    @Transactional
    public String getMosNo(C_SkeijimuKbn pSkeiJimuKbn, C_MosUketukeKbn pMosUketukeKbn, String pSousasyaCd) {

        String mosno = "";

        int loopCount = 0;

        String moschannel = getMosChannel(pSkeiJimuKbn, pMosUketukeKbn);

        for (loopCount = 1;; loopCount++) {

            String getMosno = "";

            try {

                getMosno = exec(moschannel, pSousasyaCd);
            }

            catch (CommonBizAppException bizEx) {

                throw bizEx;
            }
            catch (Exception ex) {

                if (loopCount > RETRY_COUNT) {

                    throw new CommonBizAppException();
                }

                logger.debug("申込番号採番リトライ（"+String.valueOf(loopCount)+"回目）");

                continue;
            }

            mosno = getMosno;

            break;
        }

        return mosno;
    }

    public String getMosChannel(C_SkeijimuKbn pSkeiJimuKbn, C_MosUketukeKbn pMosUketukeKbn) {

        String moschannel = "";

        int skeiJimuKbnValue = 0;

        int mosUketukeKbnValue = 0;

        if (C_SkeijimuKbn.TIGINSINKIN.eq(pSkeiJimuKbn)) {

            skeiJimuKbnValue = 1;
        }
        else if (C_SkeijimuKbn.SMBC.eq(pSkeiJimuKbn)) {

            skeiJimuKbnValue = 2;
        }
        else if (C_SkeijimuKbn.SMTB.eq(pSkeiJimuKbn)) {

            skeiJimuKbnValue = 3;
        }
        else if (C_SkeijimuKbn.MIZUHO.eq(pSkeiJimuKbn)) {

            skeiJimuKbnValue = 4;
        }
        else if (C_SkeijimuKbn.SHOP.eq(pSkeiJimuKbn)) {

            skeiJimuKbnValue = 5;
        }
        else if ((C_SkeijimuKbn.YUUTYO.eq(pSkeiJimuKbn)) || (C_SkeijimuKbn.NIHONYUUBIN.eq(pSkeiJimuKbn))
            || (C_SkeijimuKbn.KANPOSEIMEI.eq(pSkeiJimuKbn))) {

            skeiJimuKbnValue = 6;
        }
        else {

            skeiJimuKbnValue = 0;
        }

        if (C_MosUketukeKbn.MOSKIT.eq(pMosUketukeKbn)) {

            mosUketukeKbnValue = 1;
        }
        else if (C_MosUketukeKbn.SEIHOWEB.eq(pMosUketukeKbn)) {

            mosUketukeKbnValue = 2;
        }
        else if (C_MosUketukeKbn.PAPERLESS.eq(pMosUketukeKbn)) {

            mosUketukeKbnValue = 3;
        }
        else if (C_MosUketukeKbn.PAPERLESSNIT.eq(pMosUketukeKbn)) {

            mosUketukeKbnValue = 6;
        }
        else {

            mosUketukeKbnValue = 0;
        }

        if ("00".equals(MOSNOCHANNEL_TABLE[skeiJimuKbnValue][mosUketukeKbnValue])) {

            throw new CommonBizAppException();
        }

        moschannel = MOSNOCHANNEL_TABLE[skeiJimuKbnValue][mosUketukeKbnValue];

        return moschannel;
    }

    private String exec(String pMosnoChannel, String pSousasyaCD) throws CommonBizAppException,
    Exception {

        int checkDegit = 0;

        String syonoFrom = "";

        String syonoTo = "";

        if (pMosnoChannel.equals("86")) {
            syonoFrom = "86000001";
            syonoTo = "88699999";
        }
        else if (pMosnoChannel.equals("88")) {
            syonoFrom = "88700000";
            syonoTo = "88999999";
        }
        else if (pMosnoChannel.equals("78")) {
            syonoFrom = "78000001";
            syonoTo = "79999999";
        }
        else {
            syonoFrom = pMosnoChannel + "000001";
            syonoTo = pMosnoChannel + "999999";
        }

        String mosNo = sinkeiyakuDomManager.getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn(syonoFrom, syonoTo,
            C_KahiKbn.KA);

        if (BizUtil.isBlank(mosNo)) {

            throw new CommonBizAppException();
        }

        checkDegit = MousikomiNoCheck.calcDegit(mosNo);

        if (checkDegit < 0) {

            throw new CommonBizAppException();
        }

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mosNo);

        if(mosnoKanri.getSaibankahikbn().eq(C_KahiKbn.HUKA)){
            throw new Exception();
        }

        mosnoKanri.setSaibankahikbn(C_KahiKbn.HUKA);

        mosnoKanri.setSaibanymd(BizDate.getSysDate());

        mosnoKanri.setMossykykyoteiymd(
            mosnoKanri.getSaibanymd().getBizDateYM().addMonths(14)
            .getLastDay().getBusinessDay(CHolidayAdjustingMode.PREVIOUS));

        mosnoKanri.setGyoumuKousinsyaId(pSousasyaCD);

        mosnoKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        ExDBTransactionalUtil.update(mosnoKanri);

        mosNo = mosNo + String.valueOf(checkDegit);

        return mosNo;
    }
}
