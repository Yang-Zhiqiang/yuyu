package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.type.UserType_C_IwfSyoriKbn;
import yuyu.def.db.type.UserType_C_RirekiKbn;

/**
 * 工程履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_KouteiRireki extends AbstractExDBTable<WT_KouteiRireki> {

    public GenQWT_KouteiRireki() {
        this("WT_KouteiRireki");
    }

    public GenQWT_KouteiRireki(String pAlias) {
        super("WT_KouteiRireki", WT_KouteiRireki.class, pAlias);
    }

    public String WT_KouteiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_KouteiRireki, String> tokenId = new ExDBFieldString<>("tokenId", this);

    public final ExDBFieldString<WT_KouteiRireki, String> gyoumuKey = new ExDBFieldString<>("gyoumuKey", this);

    public final ExDBFieldString<WT_KouteiRireki, C_RirekiKbn> rirekiKbn = new ExDBFieldString<>("rirekiKbn", this, UserType_C_RirekiKbn.class);

    public final ExDBFieldString<WT_KouteiRireki, String> syoriTime = new ExDBFieldString<>("syoriTime", this);

    public final ExDBFieldString<WT_KouteiRireki, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WT_KouteiRireki, String> nodeId = new ExDBFieldString<>("nodeId", this);

    public final ExDBFieldString<WT_KouteiRireki, String> nodeNm = new ExDBFieldString<>("nodeNm", this);

    public final ExDBFieldString<WT_KouteiRireki, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<WT_KouteiRireki, C_IwfSyoriKbn> iwfSyoriKbn = new ExDBFieldString<>("iwfSyoriKbn", this, UserType_C_IwfSyoriKbn.class);

    public final ExDBFieldString<WT_KouteiRireki, String> rrkMsg = new ExDBFieldString<>("rrkMsg", this);

    public final ExDBFieldString<WT_KouteiRireki, byte[]> extInfo = new ExDBFieldString<>("extInfo", this);
}
