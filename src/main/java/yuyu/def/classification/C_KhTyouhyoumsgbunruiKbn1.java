
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約保全帳票メッセージ分類区分１ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KhTyouhyoumsgbunruiKbn1</td><td colspan="3">契約保全帳票メッセージ分類区分１</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYAKUSAMAMOUSIDE}</td><td>&quot;101&quot;</td><td>お客さま申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOBETUKANSYOU}</td><td>&quot;102&quot;</td><td>個別勧奨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITEN}</td><td>&quot;201&quot;</td><td>積立金移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITENTORIKESI}</td><td>&quot;202&quot;</td><td>積立金移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKMOUSIDE}</td><td>&quot;301&quot;</td><td>契約者申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRMOUSIDE}</td><td>&quot;302&quot;</td><td>代理人申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNMOUSIDE}</td><td>&quot;303&quot;</td><td>被保険者申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZKMOUSIDE}</td><td>&quot;304&quot;</td><td>家族申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNK_SYUUSIN}</td><td>&quot;401&quot;</td><td>円建終身変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNK_NENKIN}</td><td>&quot;402&quot;</td><td>円建年金変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDT}</td><td>&quot;501&quot;</td><td>円建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKADT}</td><td>&quot;502&quot;</td><td>外貨建</td></tr>
 * </table>
 */
public class C_KhTyouhyoumsgbunruiKbn1 extends Classification<C_KhTyouhyoumsgbunruiKbn1> {

    private static final long serialVersionUID = 1L;


    public static final C_KhTyouhyoumsgbunruiKbn1 BLNK = new C_KhTyouhyoumsgbunruiKbn1("0");

    public static final C_KhTyouhyoumsgbunruiKbn1 OKYAKUSAMAMOUSIDE = new C_KhTyouhyoumsgbunruiKbn1("101");

    public static final C_KhTyouhyoumsgbunruiKbn1 KOBETUKANSYOU = new C_KhTyouhyoumsgbunruiKbn1("102");

    public static final C_KhTyouhyoumsgbunruiKbn1 TMTTKNITEN = new C_KhTyouhyoumsgbunruiKbn1("201");

    public static final C_KhTyouhyoumsgbunruiKbn1 TMTTKNITENTORIKESI = new C_KhTyouhyoumsgbunruiKbn1("202");

    public static final C_KhTyouhyoumsgbunruiKbn1 KYKMOUSIDE = new C_KhTyouhyoumsgbunruiKbn1("301");

    public static final C_KhTyouhyoumsgbunruiKbn1 DRMOUSIDE = new C_KhTyouhyoumsgbunruiKbn1("302");

    public static final C_KhTyouhyoumsgbunruiKbn1 HHKNMOUSIDE = new C_KhTyouhyoumsgbunruiKbn1("303");

    public static final C_KhTyouhyoumsgbunruiKbn1 KZKMOUSIDE = new C_KhTyouhyoumsgbunruiKbn1("304");

    public static final C_KhTyouhyoumsgbunruiKbn1 YENDTHNK_SYUUSIN = new C_KhTyouhyoumsgbunruiKbn1("401");

    public static final C_KhTyouhyoumsgbunruiKbn1 YENDTHNK_NENKIN = new C_KhTyouhyoumsgbunruiKbn1("402");

    public static final C_KhTyouhyoumsgbunruiKbn1 YENDT = new C_KhTyouhyoumsgbunruiKbn1("501");

    public static final C_KhTyouhyoumsgbunruiKbn1 GAIKADT = new C_KhTyouhyoumsgbunruiKbn1("502");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OKYAKUSAMAMOUSIDE, "OKYAKUSAMAMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, KOBETUKANSYOU, "KOBETUKANSYOU", false);
        addPattern(PATTERN_DEFAULT, TMTTKNITEN, "TMTTKNITEN", false);
        addPattern(PATTERN_DEFAULT, TMTTKNITENTORIKESI, "TMTTKNITENTORIKESI", false);
        addPattern(PATTERN_DEFAULT, KYKMOUSIDE, "KYKMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, DRMOUSIDE, "DRMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, HHKNMOUSIDE, "HHKNMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, KZKMOUSIDE, "KZKMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, YENDTHNK_SYUUSIN, "YENDTHNK_SYUUSIN", false);
        addPattern(PATTERN_DEFAULT, YENDTHNK_NENKIN, "YENDTHNK_NENKIN", false);
        addPattern(PATTERN_DEFAULT, YENDT, "YENDT", false);
        addPattern(PATTERN_DEFAULT, GAIKADT, "GAIKADT", false);


        lock(C_KhTyouhyoumsgbunruiKbn1.class);
    }

    private C_KhTyouhyoumsgbunruiKbn1(String value) {
        super(value);
    }

    public static C_KhTyouhyoumsgbunruiKbn1 valueOf(String value) {
        return valueOf(C_KhTyouhyoumsgbunruiKbn1.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KhTyouhyoumsgbunruiKbn1.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KhTyouhyoumsgbunruiKbn1.class, patternId, value);
    }
}
