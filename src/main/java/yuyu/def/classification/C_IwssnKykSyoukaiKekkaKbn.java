
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 社内用契約内容照会結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IwssnKykSyoukaiKekkaKbn</td><td colspan="3">社内用契約内容照会結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NORMAL}</td><td>&quot;00&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKANKEISYAMEIGI_ERROR}</td><td>&quot;01&quot;</td><td>保険関係者名義編集エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOSYOUNAIYOU_ERROR}</td><td>&quot;02&quot;</td><td>保障内容編集エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CASHVALUEINFO_ERROR}</td><td>&quot;03&quot;</td><td>キャッシュバリュー情報編集エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIOUREKI_ERROR}</td><td>&quot;04&quot;</td><td>既往歴編集エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TANTOUSYAINFO_ERROR}</td><td>&quot;05&quot;</td><td>担当者情報編集エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TDKTYUUIINFO_ERROR}</td><td>&quot;06&quot;</td><td>手続注意情報編集エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKANRENKOUMOKU_ERROR}</td><td>&quot;07&quot;</td><td>ＤＳ関連項目エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONOINPUT_ERROR}</td><td>&quot;81&quot;</td><td>証券番号入力値エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENGEN_ERROR}</td><td>&quot;82&quot;</td><td>権限エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAITOUKEIYAKUNASI_ERROR}</td><td>&quot;83&quot;</td><td>該当契約無しエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUGOUSYOUKAI_MITAIOUSYOUHN}</td><td>&quot;91&quot;</td><td>総合照会未対応商品 ゆうゆう生保照会にて対応要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENSYUU_ERROR}</td><td>&quot;99&quot;</td><td>その他編集エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EXCEPTION}</td><td>&quot;ZZ&quot;</td><td>プログラム不正想定外エラー</td></tr>
 * </table>
 */
public class C_IwssnKykSyoukaiKekkaKbn extends Classification<C_IwssnKykSyoukaiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IwssnKykSyoukaiKekkaKbn NORMAL = new C_IwssnKykSyoukaiKekkaKbn("00");

    public static final C_IwssnKykSyoukaiKekkaKbn HOKENKANKEISYAMEIGI_ERROR = new C_IwssnKykSyoukaiKekkaKbn("01");

    public static final C_IwssnKykSyoukaiKekkaKbn HOSYOUNAIYOU_ERROR = new C_IwssnKykSyoukaiKekkaKbn("02");

    public static final C_IwssnKykSyoukaiKekkaKbn CASHVALUEINFO_ERROR = new C_IwssnKykSyoukaiKekkaKbn("03");

    public static final C_IwssnKykSyoukaiKekkaKbn KIOUREKI_ERROR = new C_IwssnKykSyoukaiKekkaKbn("04");

    public static final C_IwssnKykSyoukaiKekkaKbn TANTOUSYAINFO_ERROR = new C_IwssnKykSyoukaiKekkaKbn("05");

    public static final C_IwssnKykSyoukaiKekkaKbn TDKTYUUIINFO_ERROR = new C_IwssnKykSyoukaiKekkaKbn("06");

    public static final C_IwssnKykSyoukaiKekkaKbn DSKANRENKOUMOKU_ERROR = new C_IwssnKykSyoukaiKekkaKbn("07");

    public static final C_IwssnKykSyoukaiKekkaKbn SYONOINPUT_ERROR = new C_IwssnKykSyoukaiKekkaKbn("81");

    public static final C_IwssnKykSyoukaiKekkaKbn KENGEN_ERROR = new C_IwssnKykSyoukaiKekkaKbn("82");

    public static final C_IwssnKykSyoukaiKekkaKbn GAITOUKEIYAKUNASI_ERROR = new C_IwssnKykSyoukaiKekkaKbn("83");

    public static final C_IwssnKykSyoukaiKekkaKbn SOUGOUSYOUKAI_MITAIOUSYOUHN = new C_IwssnKykSyoukaiKekkaKbn("91");

    public static final C_IwssnKykSyoukaiKekkaKbn SONOTAHENSYUU_ERROR = new C_IwssnKykSyoukaiKekkaKbn("99");

    public static final C_IwssnKykSyoukaiKekkaKbn EXCEPTION = new C_IwssnKykSyoukaiKekkaKbn("ZZ");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NORMAL, "NORMAL", true);
        addPattern(PATTERN_DEFAULT, HOKENKANKEISYAMEIGI_ERROR, "HOKENKANKEISYAMEIGI_ERROR", false);
        addPattern(PATTERN_DEFAULT, HOSYOUNAIYOU_ERROR, "HOSYOUNAIYOU_ERROR", false);
        addPattern(PATTERN_DEFAULT, CASHVALUEINFO_ERROR, "CASHVALUEINFO_ERROR", false);
        addPattern(PATTERN_DEFAULT, KIOUREKI_ERROR, "KIOUREKI_ERROR", false);
        addPattern(PATTERN_DEFAULT, TANTOUSYAINFO_ERROR, "TANTOUSYAINFO_ERROR", false);
        addPattern(PATTERN_DEFAULT, TDKTYUUIINFO_ERROR, "TDKTYUUIINFO_ERROR", false);
        addPattern(PATTERN_DEFAULT, DSKANRENKOUMOKU_ERROR, "DSKANRENKOUMOKU_ERROR", false);
        addPattern(PATTERN_DEFAULT, SYONOINPUT_ERROR, "SYONOINPUT_ERROR", false);
        addPattern(PATTERN_DEFAULT, KENGEN_ERROR, "KENGEN_ERROR", false);
        addPattern(PATTERN_DEFAULT, GAITOUKEIYAKUNASI_ERROR, "GAITOUKEIYAKUNASI_ERROR", false);
        addPattern(PATTERN_DEFAULT, SOUGOUSYOUKAI_MITAIOUSYOUHN, "SOUGOUSYOUKAI_MITAIOUSYOUHN", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENSYUU_ERROR, "SONOTAHENSYUU_ERROR", false);
        addPattern(PATTERN_DEFAULT, EXCEPTION, "EXCEPTION", false);


        lock(C_IwssnKykSyoukaiKekkaKbn.class);
    }

    private C_IwssnKykSyoukaiKekkaKbn(String value) {
        super(value);
    }

    public static C_IwssnKykSyoukaiKekkaKbn valueOf(String value) {
        return valueOf(C_IwssnKykSyoukaiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IwssnKykSyoukaiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IwssnKykSyoukaiKekkaKbn.class, patternId, value);
    }
}
