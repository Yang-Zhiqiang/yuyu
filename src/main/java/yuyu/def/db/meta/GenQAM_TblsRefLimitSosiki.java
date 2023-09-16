package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AM_TblsRefLimitSosiki;

/**
 * テーブル照会参照組織限定マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_TblsRefLimitSosiki extends AbstractExDBTable<AM_TblsRefLimitSosiki> {

    public GenQAM_TblsRefLimitSosiki() {
        this("AM_TblsRefLimitSosiki");
    }

    public GenQAM_TblsRefLimitSosiki(String pAlias) {
        super("AM_TblsRefLimitSosiki", AM_TblsRefLimitSosiki.class, pAlias);
    }

    public String AM_TblsRefLimitSosiki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_TblsRefLimitSosiki, String> baseTableId = new ExDBFieldString<>("baseTableId", this);

    public final ExDBFieldString<AM_TblsRefLimitSosiki, String> baseDdId = new ExDBFieldString<>("baseDdId", this);

    public final ExDBFieldString<AM_TblsRefLimitSosiki, String> tanmatusettisosikicd = new ExDBFieldString<>("tanmatusettisosikicd", this);
}
