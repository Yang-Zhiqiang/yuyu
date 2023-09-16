package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;

/**
 * 資金移動グループマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SikinIdouGroup extends AbstractExDBTable<BM_SikinIdouGroup> {

    public GenQBM_SikinIdouGroup() {
        this("BM_SikinIdouGroup");
    }

    public GenQBM_SikinIdouGroup(String pAlias) {
        super("BM_SikinIdouGroup", BM_SikinIdouGroup.class, pAlias);
    }

    public String BM_SikinIdouGroup() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SikinIdouGroup, C_Segcd> segcd = new ExDBFieldString<>("segcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BM_SikinIdouGroup, C_SikinidougroupKbn> sikinidougroupkbn = new ExDBFieldString<>("sikinidougroupkbn", this, UserType_C_SikinidougroupKbn.class);
}
