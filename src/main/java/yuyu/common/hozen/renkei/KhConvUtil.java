package yuyu.common.hozen.renkei;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_Tdk;

/**
 * 契約保全サブシステム連携項目変換処理
 */
public class KhConvUtil {

    @Inject
    private static Logger logger;

    public KhConvUtil() {
        super();
    }

    public C_Nenkinsyu convNksyukbn(C_Sknenkinsyu pSknenkinsyu) {

        logger.debug("▽ 契約保全サブシステム連携項目変換処理 年金種類区分変換 開始");

        C_Nenkinsyu nenkinsyu = C_Nenkinsyu.BLNK;

        if (C_Sknenkinsyu.BLNK.eq(pSknenkinsyu)) {

            nenkinsyu = C_Nenkinsyu.BLNK;
        }
        else if (C_Sknenkinsyu.KKTI5.eq(pSknenkinsyu) ||
            C_Sknenkinsyu.KKTI10.eq(pSknenkinsyu) ||
            C_Sknenkinsyu.KKTI15.eq(pSknenkinsyu)) {

            nenkinsyu = C_Nenkinsyu.KAKUTEINENKIN;
        }
        else if (C_Sknenkinsyu.SGKHSYSYSN.eq(pSknenkinsyu)) {

            nenkinsyu = C_Nenkinsyu.SGKHSYSYSNNENKIN;
        }
        else if (C_Sknenkinsyu.KKTI5DAI1BAIGAKU.eq(pSknenkinsyu)) {

            nenkinsyu = C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK;
        }

        logger.debug("△ 契約保全サブシステム連携項目変換処理 年金種類区分変換 終了");

        return nenkinsyu;
    }

    public int convNenkinkkn(C_Sknenkinsyu pSknenkinsyu) {

        logger.debug("▽ 契約保全サブシステム連携項目変換処理 年金期間変換 開始");

        int nenkinKikan = 0;

        if (C_Sknenkinsyu.BLNK.eq(pSknenkinsyu)) {

            nenkinKikan = 0;
        }
        else if (C_Sknenkinsyu.KKTI5.eq(pSknenkinsyu) ||
            C_Sknenkinsyu.KKTI5DAI1BAIGAKU.eq(pSknenkinsyu)) {

            nenkinKikan = 5;
        }
        else if (C_Sknenkinsyu.KKTI10.eq(pSknenkinsyu)) {

            nenkinKikan = 10;
        }
        else if (C_Sknenkinsyu.KKTI15.eq(pSknenkinsyu)) {

            nenkinKikan = 15;
        }
        else if (C_Sknenkinsyu.SGKHSYSYSN.eq(pSknenkinsyu)) {

            nenkinKikan = 99;
        }

        logger.debug("△ 契約保全サブシステム連携項目変換処理 年金期間変換 終了");

        return nenkinKikan;
    }

    public C_Tdk convKyktdk(C_KykKbn pKykKbn, C_Tdk pTdk) {

        logger.debug("▽ 契約保全サブシステム連携項目変換処理 契約管理契約者続柄変換 開始");

        if (C_KykKbn.KEIHI_DOUITU.eq(pKykKbn)) {

            logger.debug("△ 契約保全サブシステム連携項目変換処理 契約管理契約者続柄変換 終了");

            return C_Tdk.HONNIN;
        }

        logger.debug("△ 契約保全サブシステム連携項目変換処理 契約管理契約者続柄変換 終了");

        return pTdk;
    }
}