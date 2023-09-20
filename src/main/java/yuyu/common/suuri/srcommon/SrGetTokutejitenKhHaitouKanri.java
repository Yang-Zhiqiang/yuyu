package yuyu.common.suuri.srcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_KhHaitouKanri;

/**
 * 数理 数理共通 特定時点配当管理テーブル取得
 */
public class SrGetTokutejitenKhHaitouKanri {

    @Inject
    private static Logger logger;

    public IT_KhHaitouKanri exec(List<IT_KhHaitouKanri> pKhHaitouKanriList, BizDate pKijyunYmd) {

        logger.debug("▽ 特定時点配当管理テーブル取得 開始");

        IT_KhHaitouKanri khHaitouKanri = null;
        boolean umuFlg = false;

        for (IT_KhHaitouKanri khHaitouKanri1 : pKhHaitouKanriList) {

            if (umuFlg) {

                break;
            }

            if (BizDateUtil.compareYmd(khHaitouKanri1.getKariwariatedshrymd(), pKijyunYmd) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYmd(khHaitouKanri1.getKariwariatedshrymd(), pKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                umuFlg = true;

                khHaitouKanri = khHaitouKanri1;
            }
            else {

                umuFlg = false;
            }
        }

        logger.debug("△ 特定時点配当管理テーブル取得 終了");

        return khHaitouKanri;
    }
}
