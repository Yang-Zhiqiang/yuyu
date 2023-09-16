package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AM_TblsSearchPattern;

/**
 * テーブル照会検索パターンマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_TblsSearchPattern extends AbstractExDBTable<AM_TblsSearchPattern> {

    public GenQAM_TblsSearchPattern() {
        this("AM_TblsSearchPattern");
    }

    public GenQAM_TblsSearchPattern(String pAlias) {
        super("AM_TblsSearchPattern", AM_TblsSearchPattern.class, pAlias);
    }

    public String AM_TblsSearchPattern() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_TblsSearchPattern, String> baseTableId = new ExDBFieldString<>("baseTableId", this);

    public final ExDBFieldString<AM_TblsSearchPattern, String> baseSearchDdId = new ExDBFieldString<>("baseSearchDdId", this);

    public final ExDBFieldString<AM_TblsSearchPattern, String> baseSearchPtnNm = new ExDBFieldString<>("baseSearchPtnNm", this);

    public final ExDBFieldNumber<AM_TblsSearchPattern, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);
}
