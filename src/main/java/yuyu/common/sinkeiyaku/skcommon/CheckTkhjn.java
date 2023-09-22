package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 新契約 新契約共通 特定関係法人チェック
 */
public class CheckTkhjn {

    private static final int BUBUNITTIMOJIRETUSUU = 5;

    // private static final String[] TKHJNKINYUUCDLST = {"0009"};

    private static final String HANKAKUSPACE = " ";

    private static final String ZENKAKUSPACE  = "　";

    private static final String BLANK  = "";

    private static final String[] JYOKYOKEYWORDLST = {"リース","ビジネス","システム","サービス","ファイナンス","生命保険",
        "損害保険","火災保険","信用金庫","センター","ホールディングス","コンサルティング"};

    private static final String[] ALPHABET_L = {
        "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ",
        "Ｋ", "Ｌ", "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ",
        "Ｕ", "Ｖ", "Ｗ", "Ｘ", "Ｙ", "Ｚ"};

    private static final String[] KANA1 = {
        "エイ", "ビー", "シー", "ディー", "イー", "エフ", "ジー", "エイチ", "アイ", "ジェイ",
        "ケー", "エル", "エム", "エヌ", "オー", "ピー", "キュー", "アール", "エス", "ティー",
        "ユー", "ブイ", "ダブリュー", "エックス", "ワイ", "ゼット"};

    private static final String[] KANA2 = {
        "エー", "ビィ", "シィ", "デー", "イー", "エフ", "ジィ", "エッチ", "アイ", "ジェー",
        "ケィ", "エル", "エム", "エヌ", "オー", "ピィ", "キュー", "アール", "エス", "テー",
        "ユー", "ブイ", "ダブリュー", "エックス", "ワイ", "ゼット"};

    @Inject
    private static Logger logger;

    public CheckTkhjn() {
        super();
    }

    public C_YouhiKbn hanteiCheckYouhi(String pTkhjnKinyuuCd) {

        logger.debug("▽ 特定関係法人チェック 開始");


        logger.debug("△ 特定関係法人チェック 終了");

        return C_YouhiKbn.YOU;
    }

    public List<String> crtCheckTaisyouLst(String pSiteiMojiretu) {

        logger.debug("▽ 特定関係法人チェック 開始");

        String changeKekka = pSiteiMojiretu;
        List<String> checkTaisyouLst = new ArrayList<>();

        changeKekka = changeMojiretu(changeKekka);

        changeKekka = removeTokuteiKey(changeKekka);

        if (BizUtil.isBlank(changeKekka)) {
            logger.debug("△ 特定関係法人チェック 終了");

            return checkTaisyouLst;
        }

        checkTaisyouLst.add(changeKekka);

        boolean eijiUmu = false;
        Pattern pattern = Pattern.compile("[Ａ-Ｚ]");
        Matcher matcher = pattern.matcher(changeKekka);
        if (matcher.find()) {
            eijiUmu = true;
        }

        if (eijiUmu) {
            String kanaKeka1 = changeKekka;
            String kanaKeka2 = changeKekka;

            for (int i = 0; i < ALPHABET_L.length; i++) {
                kanaKeka1 = changeKana(kanaKeka1, ALPHABET_L[i], KANA1[i]);

                kanaKeka2 = changeKana(kanaKeka2, ALPHABET_L[i], KANA2[i]);
            }

            checkTaisyouLst.add(kanaKeka1);

            if (!kanaKeka1.equals(kanaKeka2)) {
                checkTaisyouLst.add(kanaKeka2);
            }
        }

        logger.debug("△ 特定関係法人チェック 終了");

        return checkTaisyouLst;
    }

    public C_YouhiKbn checkJissi(List<String> pHjnnmLst, List<String> pCheckTaisyouLst) {

        logger.debug("▽ 特定関係法人チェック 開始");

        for (String checkTaisyou : pCheckTaisyouLst) {
            int startKensakuMoji = 0;
            int endKensakuMoji = checkTaisyou.length() - BUBUNITTIMOJIRETUSUU;

            if (endKensakuMoji < 0) {
                endKensakuMoji = 0;
            }

            while (startKensakuMoji <= endKensakuMoji) {
                String kensakuMoji = "";

                if (checkTaisyou.substring(startKensakuMoji).length() < BUBUNITTIMOJIRETUSUU) {
                    kensakuMoji = checkTaisyou.substring(startKensakuMoji);
                }
                else {
                    kensakuMoji = checkTaisyou.substring(startKensakuMoji, startKensakuMoji + BUBUNITTIMOJIRETUSUU);
                }

                for (String hjnNm : pHjnnmLst) {
                    if (hjnNm.contains(kensakuMoji)) {
                        logger.debug("△ 特定関係法人チェック 終了");

                        return C_YouhiKbn.YOU;
                    }
                }

                startKensakuMoji++;
            }
        }

        logger.debug("△ 特定関係法人チェック 終了");

        return C_YouhiKbn.HUYOU;
    }

    private String changeMojiretu (String pSiteiMojiretu) {
        String henkanKekka = pSiteiMojiretu;
        henkanKekka = henkanKekka.replaceAll(HANKAKUSPACE, BLANK);
        henkanKekka = henkanKekka.replaceAll(ZENKAKUSPACE, BLANK);
        henkanKekka = ConvertUtil.fromZenAlphabet(henkanKekka, 1);
        henkanKekka = ConvertUtil.toZenAll(henkanKekka, 1, 1);
        return henkanKekka;
    }

    private String removeTokuteiKey (String pSiteiMojiretu) {
        String henkanKekka = pSiteiMojiretu;

        for (int i = 0; i < JYOKYOKEYWORDLST.length; i++) {
            if (henkanKekka.contains(JYOKYOKEYWORDLST[i])) {
                henkanKekka = henkanKekka.replaceAll(JYOKYOKEYWORDLST[i], BLANK);
            }
        }

        return henkanKekka;
    }

    private  String changeKana(String pSource, String pBefore, String pAfter) {
        String henkanKekka = pSource;

        if (henkanKekka.contains(pBefore)) {
            henkanKekka = henkanKekka.replaceAll(pBefore, pAfter);
        }

        return henkanKekka;
    }
}
