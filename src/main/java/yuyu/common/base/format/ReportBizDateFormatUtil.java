package yuyu.common.base.format;

import javax.inject.Inject;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

/**
 * BizDateフォーマット編集処理インターフェース<br />
 */
public class ReportBizDateFormatUtil {

    @Inject
    private static Logger logger = LoggerFactory.getLogger(ReportBizDateFormatUtil.class);

    public static String toFormatedYmd(BizDate pBizDate) {

        try {
            return BizDateFormatUtil.toFormatedYmd(pBizDate);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

    }

    public static String toFormatedYmd(BizDate pBizDate, BizDateFormatter pBizDateFormatter) {

        try {
            return BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

    }

    public static String toFormatedCommaYmd(BizDate pBizDate) {

        try {
            return BizDateFormatUtil.toFormatedCommaYmd(pBizDate);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

    }

}
