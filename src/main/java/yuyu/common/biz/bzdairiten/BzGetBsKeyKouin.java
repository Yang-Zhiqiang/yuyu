package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.fieldconfig.FieldDefManager;
import jp.co.slcs.swak.bizinfr.configuration.fieldconfig.MFieldDef;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.def.db.mapping.GenBM_Kouin;

/**
 * 業務共通 代理店 募集人コード取得（行員コード指定）クラス
 */
public class BzGetBsKeyKouin {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    @Inject
    FieldDefManager fieldDefManager;

    public BzGetBsKeyKouin() {
        super();
    }

    public String exec(String pKinyuuCd, String pKouinCd) {

        logger.debug("▽ 募集人コード取得（行員コード指定） 開始");
        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 金融機関コード＝" + pKinyuuCd);
        logger.debug("｜ ｜ 行員コード＝    " + pKouinCd);
        logger.debug("｜ △ ");

        String bosyuuCd = "";

        String kouincd = "";

        List<String> kouincdList = new ArrayList<>();

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        fieldDefManager = FieldDefManager.getInstance();

        MFieldDef mFieldDef = fieldDefManager.getMFieldDef(GenBM_Kouin.KOUINCD);

        String[] kouincdArray = new String[mFieldDef.getMaxlength().intValue()];

        String[] bosyuuCdArray = new String[2];

        if (BizUtil.isBlank(pKinyuuCd)) {

            logger.debug("△ 募集人コード取得（行員コード指定） 終了");

            return bosyuuCd;
        }
        else if (BizUtil.isBlank(pKouinCd)) {

            logger.debug("△ 募集人コード取得（行員コード指定） 終了");

            return bosyuuCd;
        }

        BM_Kouin kouin = bizDomManager.getKouin(pKinyuuCd, pKouinCd);

        if (kouin == null) {

            String trimPKouinCd = pKouinCd.trim();

            if (trimPKouinCd.length() == mFieldDef.getMaxlength().intValue() && !trimPKouinCd.substring(0, 1).equals("0")) {
                logger.debug("｜ 指定した金融機関コードおよび行員コードの募集人コードが存在しません。");
                logger.debug("△ 募集人コード取得（行員コード指定） 終了");

                return bosyuuCd;
            }

            for (int i = 0; i < trimPKouinCd.length(); i++) {
                if (i == trimPKouinCd.length() -1) {
                    kouincd = trimPKouinCd.substring(i);
                } else {
                    if (!trimPKouinCd.substring(i, i + 1).equals("0")) {
                        kouincd = trimPKouinCd.substring(i);
                        break;
                    }
                }
            }

            kouincdList.add(kouincd);

            for (int i = kouincd.length(); i < mFieldDef.getMaxlength().intValue(); i++) {
                kouincd = "0" + kouincd;
                kouincdList.add(kouincd);
            }

            for (int i = 0; i < kouincdList.size(); i++) {
                kouincdArray[i] = kouincdList.get(i);
            }

            List<BM_Kouin> kouinList = bizDomManager.getKouinsByKouincds(pKinyuuCd, kouincdArray);

            if (kouinList.size() == 0) {
                logger.debug("｜ 指定した金融機関コードおよび行員コードの募集人コードが存在しません。");
                logger.debug("△ 募集人コード取得（行員コード指定） 終了");

                return bosyuuCd;
            }

            if (kouinList.size() == 1) {
                bosyuuCd = kouinList.get(0).getBosyuucd();

                logger.debug("｜ ▽ 戻り値");
                logger.debug("｜ ｜ 募集人コード＝  " + bosyuuCd);
                logger.debug("｜ △ ");
                logger.debug("△ 募集人コード取得（行員コード指定） 終了");

                return bosyuuCd;
            }

            if (kouinList.size() >= 2) {
                for (int i = 0; i < kouinList.size(); i++){
                    BM_Kouin kouinData = kouinList.get(i);

                    String wkBosyuuCd = kouinData.getBosyuucd();

                    BM_Bosyuunin bosyuunin = bizDomManager.getBosyuunin(wkBosyuuCd);

                    if (bosyuunin.getBosyuuningyouhaiymd() == null) {
                        bosyuuCd = bosyuunin.getBosyuucd();

                        logger.debug("｜ ▽ 戻り値");
                        logger.debug("｜ ｜ 募集人コード＝  " + bosyuuCd);
                        logger.debug("｜ △ ");
                        logger.debug("△ 募集人コード取得（行員コード指定） 終了");

                        return bosyuuCd;
                    }

                    if (i == 0) {
                        bosyuuCdArray[0] = bosyuunin.getBosyuucd();
                        bosyuuCdArray[1] = String.valueOf(bosyuunin.getBosyuuningyouhaiymd());

                    } else {
                        if (BizDate.valueOf(bosyuuCdArray[1]).compareTo(bosyuunin.getBosyuuningyouhaiymd()) < 0) {
                            bosyuuCdArray[0] = bosyuunin.getBosyuucd();
                            bosyuuCdArray[1] = String.valueOf(bosyuunin.getBosyuuningyouhaiymd());

                        }
                    }
                }

                bosyuuCd = bosyuuCdArray[0];

                logger.debug("｜ ▽ 戻り値");
                logger.debug("｜ ｜ 募集人コード＝  " + bosyuuCd);
                logger.debug("｜ △ ");
                logger.debug("△ 募集人コード取得（行員コード指定） 終了");

                return bosyuuCd;
            }
        }

        bosyuuCd = kouin.getBosyuucd();

        logger.debug("｜ ▽ 戻り値");
        logger.debug("｜ ｜ 募集人コード＝  " + bosyuuCd);
        logger.debug("｜ △ ");
        logger.debug("△ 募集人コード取得（行員コード指定） 終了");

        return bosyuuCd;
    }
}
