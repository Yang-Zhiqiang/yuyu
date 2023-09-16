package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AM_TblsTarget;

/**
 * テーブル照会対象マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_TblsTarget extends AbstractExDBTable<AM_TblsTarget> {

    public GenQAM_TblsTarget() {
        this("AM_TblsTarget");
    }

    public GenQAM_TblsTarget(String pAlias) {
        super("AM_TblsTarget", AM_TblsTarget.class, pAlias);
    }

    public String AM_TblsTarget() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_TblsTarget, String> baseTableId = new ExDBFieldString<>("baseTableId", this);

    public final ExDBFieldString<AM_TblsTarget, String> baseTableNm = new ExDBFieldString<>("baseTableNm", this);

    public final ExDBFieldString<AM_TblsTarget, String> subSystemId = new ExDBFieldString<>("subSystemId", this);
}
