package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.util.HashMap;
import java.util.Map;

import jp.co.slcs.swak.number.BizCurrency;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * テーブル照会 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TableSyoukaiConstants extends GenTableSyoukaiConstants {
    public static final int TABLE_SEARCH_PTN_RESULT_MAX_ROWS = 200;

    public static final int DATA_RESULT_MAX_ROWS = 100;

    public static final String MASKING_DATA = "■■■■■（参照不可項目）";

    public static final String MASKING_NONE_DATA = "値未設定（参照不可項目）";

    public static final Map<Class<?>, Pair<String, String>> TWO_DBDD_JAVA_TYPE = new HashMap<>();

    static{
        TWO_DBDD_JAVA_TYPE.put(BizCurrency.class, new Pair<>("$", "（通貨型）"));
    }
}
