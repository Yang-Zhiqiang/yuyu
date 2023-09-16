package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ImagerenkeiKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.type.UserType_C_ImagerenkeiKbn;

/**
 * 事務手続マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQDM_Jimutetuzuki extends AbstractExDBTable<DM_Jimutetuzuki> {

    public GenQDM_Jimutetuzuki() {
        this("DM_Jimutetuzuki");
    }

    public GenQDM_Jimutetuzuki(String pAlias) {
        super("DM_Jimutetuzuki", DM_Jimutetuzuki.class, pAlias);
    }

    public String DM_Jimutetuzuki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<DM_Jimutetuzuki, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<DM_Jimutetuzuki, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<DM_Jimutetuzuki, String> jimutetuzukinm = new ExDBFieldString<>("jimutetuzukinm", this);

    public final ExDBFieldString<DM_Jimutetuzuki, C_ImagerenkeiKbn> imagerenkeikbn = new ExDBFieldString<>("imagerenkeikbn", this, UserType_C_ImagerenkeiKbn.class);

    public final ExDBFieldNumber<DM_Jimutetuzuki, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<DM_Jimutetuzuki, String> syukouteijimutetuzukicd = new ExDBFieldString<>("syukouteijimutetuzukicd", this);
}
