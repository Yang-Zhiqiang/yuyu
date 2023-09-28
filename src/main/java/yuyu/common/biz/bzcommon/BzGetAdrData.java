package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.string.StringUtil;

import org.slf4j.Logger;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.AddressDistinctItemsBypostalCdBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_TodouhukenKbn;

/**
 * 業務共通 共通 住所情報取得クラス
 */
public class BzGetAdrData {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    private C_ErrorKbn errorKbn;

    private String adrknBlankAri;

    private C_TodouhukenKbn todouhuKenCd;

    private String adrKanji1;

    private String adrKanji2;

    private String adrKanji3;

    public BzGetAdrData() {
        super();
    }

    public void execAdrKanaBlankAriByPostalcd(String pPostalCd) {

        logger.debug("▽ 住所情報取得 開始");

        if (BizUtil.isBlank(pPostalCd) || pPostalCd.length() != 7) {

            adrknBlankAri = "";

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 住所情報取得 終了");

            return;
        }

        List<String> adrknBlankAriList = bizDomManager.getAddressDistinctAdrknblankarisByPostalCd(pPostalCd,
            C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        if (adrknBlankAriList.size() == 0) {

            adrknBlankAri = "";

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 住所情報取得 終了");

            return;
        }
        else if (adrknBlankAriList.size() == 1) {

            adrknBlankAri = adrknBlankAriList.get(0);

            errorKbn = C_ErrorKbn.OK;

            logger.debug("△ 住所情報取得 終了");

            return;
        }

        String adrknBlankAriTemp = adrknBlankAriList.get(0);

        for (int n = 0; n < adrknBlankAriList.size() - 1; n++) {

            String adrknBlankAriSame = "";

            if (adrknBlankAriTemp.length() >= adrknBlankAriList.get(n + 1).length()) {

                for (int i = 0; i < adrknBlankAriList.get(n + 1).length(); i++) {

                    if (adrknBlankAriList.get(n + 1).substring(i, i + 1).equals(
                        adrknBlankAriTemp.substring(i, i + 1))) {

                        adrknBlankAriSame = adrknBlankAriSame + adrknBlankAriTemp.substring(i, i + 1);
                    }
                    else {

                        break;
                    }
                }
            }
            else {

                for (int i = 0; i < adrknBlankAriTemp.length(); i++) {

                    if (adrknBlankAriList.get(n + 1).substring(i, i + 1).equals(
                        adrknBlankAriTemp.substring(i, i + 1))) {

                        adrknBlankAriSame = adrknBlankAriSame + adrknBlankAriTemp.substring(i, i + 1);
                    }
                    else {

                        break;
                    }
                }
            }

            if (BizUtil.isBlank(adrknBlankAriSame)) {

                adrknBlankAri = "";

                errorKbn = C_ErrorKbn.OK;

                logger.debug("△ 住所情報取得 終了");

                return;
            }

            adrknBlankAriTemp = adrknBlankAriSame;
        }

        adrknBlankAri = StringUtil.rTrim(adrknBlankAriTemp);

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 住所情報取得 終了");
    }

    public void execTodouhukenCdByPostalcd(String pPostalCd) {

        logger.debug("▽ 住所情報取得 開始");

        if (BizUtil.isBlank(pPostalCd) || pPostalCd.length() != 7) {

            todouhuKenCd = C_TodouhukenKbn.BLNK;

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 住所情報取得 終了");

            return;
        }

        C_TodouhukenKbn todouhuKenCdTemp = bizDomManager.getAddressMinTodouhukencdByPostalCd(pPostalCd,
            C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        if (todouhuKenCdTemp == null || C_TodouhukenKbn.BLNK.eq(todouhuKenCdTemp)) {

            todouhuKenCd = C_TodouhukenKbn.BLNK;

            errorKbn = C_ErrorKbn.ERROR;
        }
        else {

            todouhuKenCd = todouhuKenCdTemp;

            errorKbn = C_ErrorKbn.OK;
        }

        logger.debug("△ 住所情報取得 終了");
    }

    public void execAdrKanjiByPostalcd(String pPostalCd) {

        logger.debug("▽ 住所情報取得 開始");

        if (BizUtil.isBlank(pPostalCd) || pPostalCd.length() != 7) {

            adrKanji1 = "";

            adrKanji2 = "";

            adrKanji3 = "";

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 住所情報取得 終了");

            return;
        }

        List<AddressDistinctItemsBypostalCdBean> adrKanjiInfList = bizDomManager.getAddressDistinctItemsBypostalCd(
            pPostalCd, C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        if (adrKanjiInfList.size() == 0) {

            adrKanji1 = "";

            adrKanji2 = "";

            adrKanji3 = "";

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 住所情報取得 終了");

            return;
        }

        AddressDistinctItemsBypostalCdBean adrKanji0 = adrKanjiInfList.get(0);
        String adrKanjiTemp = adrKanji0.getAdrkj();

        for (int n = 0; n < adrKanjiInfList.size() - 1; n++) {

            String adrKanjiSame = "";

            AddressDistinctItemsBypostalCdBean wkadrKanji = adrKanjiInfList.get(n + 1);
            String wkadrKanjiTemp = wkadrKanji.getAdrkj();
            if (adrKanjiTemp.length() >= wkadrKanjiTemp.length()) {

                for (int i = 0; i < wkadrKanjiTemp.length(); i++) {

                    if (wkadrKanjiTemp.substring(i, i + 1).equals(
                        adrKanjiTemp.substring(i, i + 1))) {

                        adrKanjiSame = adrKanjiSame + adrKanjiTemp.substring(i, i + 1);
                    }
                    else {

                        break;
                    }
                }
            }
            else {

                for (int i = 0; i < adrKanjiTemp.length(); i++) {

                    if (wkadrKanjiTemp.substring(i, i + 1).equals(
                        adrKanjiTemp.substring(i, i + 1))) {

                        adrKanjiSame = adrKanjiSame + adrKanjiTemp.substring(i, i + 1);
                    }
                    else {

                        break;
                    }
                }
            }

            adrKanjiTemp = adrKanjiSame;
        }

        int kjSikugunnmKetasuuTemp = adrKanji0.getKjsikugunnmketasuu();

        for (int n = 0; n < adrKanjiInfList.size() - 1; n++) {

            AddressDistinctItemsBypostalCdBean wkadrKanji = adrKanjiInfList.get(n + 1);
            int wkkjSikugunnmKetasuuTemp = wkadrKanji.getKjsikugunnmketasuu();
            if (kjSikugunnmKetasuuTemp > wkkjSikugunnmKetasuuTemp) {

                kjSikugunnmKetasuuTemp = wkkjSikugunnmKetasuuTemp;

            }

        }


        if (BizUtil.isBlank(adrKanjiTemp)) {

            adrKanji1 = "";

            adrKanji2 = "";

            adrKanji3 = "";

        }

        else if (kjSikugunnmKetasuuTemp <= 30) {

            if (kjSikugunnmKetasuuTemp == 0) {

                adrKanji1 = "";

                if (adrKanjiTemp.length() > 30) {

                    adrKanji2 = adrKanjiTemp.substring(0, 30);

                    adrKanji3 = adrKanjiTemp.substring(30);

                }
                else {

                    adrKanji2 = adrKanjiTemp;

                    adrKanji3 = "";

                }
            }

            else {

                if (adrKanjiTemp.length() > kjSikugunnmKetasuuTemp) {

                    adrKanji1 = adrKanjiTemp.substring(0, kjSikugunnmKetasuuTemp);

                    if (adrKanjiTemp.length() - kjSikugunnmKetasuuTemp > 30) {

                        adrKanji2 = adrKanjiTemp.substring(kjSikugunnmKetasuuTemp, kjSikugunnmKetasuuTemp + 30);

                        adrKanji3 = adrKanjiTemp.substring(kjSikugunnmKetasuuTemp + 30);

                    }

                    else {

                        adrKanji2 = adrKanjiTemp.substring(kjSikugunnmKetasuuTemp);

                        adrKanji3 = "";

                    }
                }

                else {

                    adrKanji1 = adrKanjiTemp;

                    adrKanji2 = "";

                    adrKanji3 = "";

                }

            }
        }

        else {

            if (adrKanjiTemp.length() > 30) {

                adrKanji1 = adrKanjiTemp.substring(0, 30);

                adrKanji2 = adrKanjiTemp.substring(30);

                adrKanji3 = "";

            }

            else {

                adrKanji1 = adrKanjiTemp;

                adrKanji2 = "";

                adrKanji3 = "";

            }
        }

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 住所情報取得 終了");
    }

    public C_ErrorKbn getErrorKbn() {

        return errorKbn;
    }

    public String getAdrKanaBlankAri() {

        return adrknBlankAri;
    }

    public C_TodouhukenKbn getTodouhukenCd() {

        return todouhuKenCd;
    }

    public String getAdrKanji1() {

        return adrKanji1;
    }

    public String getAdrKanji2() {

        return adrKanji2;
    }

    public String getAdrKanji3() {

        return adrKanji3;
    }

}
