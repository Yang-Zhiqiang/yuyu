package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ImagerenkeiKbn;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_ImagerenkeiKbn;

/**
 * 事務手続マスタ履歴保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQDM_JimutetuzukiRireki extends AbstractExDBTable<DM_JimutetuzukiRireki> {

    public GenQDM_JimutetuzukiRireki() {
        this("DM_JimutetuzukiRireki");
    }

    public GenQDM_JimutetuzukiRireki(String pAlias) {
        super("DM_JimutetuzukiRireki", DM_JimutetuzukiRireki.class, pAlias);
    }

    public String DM_JimutetuzukiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<DM_JimutetuzukiRireki, BizDate> kensuuHokanYmd = new ExDBFieldString<>("kensuuHokanYmd", this, BizDateType.class);

    public final ExDBFieldString<DM_JimutetuzukiRireki, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<DM_JimutetuzukiRireki, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<DM_JimutetuzukiRireki, String> jimutetuzukinm = new ExDBFieldString<>("jimutetuzukinm", this);

    public final ExDBFieldString<DM_JimutetuzukiRireki, C_ImagerenkeiKbn> imagerenkeikbn = new ExDBFieldString<>("imagerenkeikbn", this, UserType_C_ImagerenkeiKbn.class);

    public final ExDBFieldNumber<DM_JimutetuzukiRireki, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<DM_JimutetuzukiRireki, String> syukouteijimutetuzukicd = new ExDBFieldString<>("syukouteijimutetuzukicd", this);
}
