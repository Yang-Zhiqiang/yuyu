package yuyu.common.biz.bzdairiten;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.detacher.BM_BosyuuninDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Bosyuunin;

/**
 * 業務共通 代理店 募集人コード取得（募集人登録番号指定）クラス
 */
public class BzGetBsKeyBstrkno {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetBsKeyBstrkno() {
        super();
    }

    public String exec(String pBosyuuTrkNo) {

        logger.debug("▽ 募集人コード取得（募集人登録番号指定） 開始");
        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 募集人登録番号＝" + pBosyuuTrkNo);
        logger.debug("｜ △ ");

        String bosyuuCd = "";

        if (BizUtil.isBlank(pBosyuuTrkNo)) {

            logger.debug("△ 募集人コード取得（募集人登録番号指定） 終了");

            return bosyuuCd;
        }

        List<BM_Bosyuunin> bosyuuninList = bizDomManager.getBosyuuninByBosyuutrkno(pBosyuuTrkNo);

        bosyuuninList = BM_BosyuuninDetacher.detachBosyuunintouched(bosyuuninList);

        if (bosyuuninList.size() == 0) {

            logger.debug("｜ 指定した募集人登録番号の募集人コードが存在しません。");
            logger.debug("△ 募集人コード取得（募集人登録番号指定） 終了");

            return bosyuuCd;
        }
        else if (bosyuuninList.size() == 1) {

            bosyuuCd = bosyuuninList.get(0).getBosyuucd();
        }
        else {

            int yuukoukensuu = 0;

            for (int n = 0; n < bosyuuninList.size(); n++) {

                if (bosyuuninList.get(n).getBosyuuningyouhaiymd() == null) {

                    bosyuuCd = bosyuuninList.get(n).getBosyuucd();

                    yuukoukensuu += 1;
                }
            }

            if (yuukoukensuu == 0) {

                bosyuuCd = bosyuuninList.get(0).getBosyuucd();
            }
            else if (yuukoukensuu == 1) {

            }
            else {

                bosyuuCd = "";
            }
        }

        logger.debug("｜ ▽ 戻り値");
        logger.debug("｜ ｜ 募集人コード＝  " + bosyuuCd);
        logger.debug("｜ △ ");
        logger.debug("△ 募集人コード取得（募集人登録番号指定） 終了");

        return bosyuuCd;
    }
}