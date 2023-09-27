package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * ダイレクト ダイレクト共通 ＤＳ時間ユーティリティ
 */
public class DsTimeUtil {

    @Inject
    private static Logger logger;

    public DsTimeUtil() {
        super();
    }

    public HourMinSecChangeBean hourMinSecChange(int pSec) {

        logger.debug("▽ ＤＳ時間ユーティリティ 開始");

        int hour = 0;
        int min = 0;
        int sec = 0;

        hour = pSec / 3600;

        min = pSec / 60 % 60;

        sec = pSec % 60;

        HourMinSecChangeBean hourMinSecChangeBean = new HourMinSecChangeBean();

        hourMinSecChangeBean.setHour(hour);
        hourMinSecChangeBean.setMin(min);
        hourMinSecChangeBean.setSec(sec);

        logger.debug("△ ＤＳ時間ユーティリティ 終了");

        return hourMinSecChangeBean;
    }
}
