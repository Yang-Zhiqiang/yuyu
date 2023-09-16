package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SkeittdkrenrakuKbn;

/**
 * 新契約手続注意テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkTtdkTyuui extends AbstractExDBTable<HT_SkTtdkTyuui> {

    public GenQHT_SkTtdkTyuui() {
        this("HT_SkTtdkTyuui");
    }

    public GenQHT_SkTtdkTyuui(String pAlias) {
        super("HT_SkTtdkTyuui", HT_SkTtdkTyuui.class, pAlias);
    }

    public String HT_SkTtdkTyuui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkTtdkTyuui, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkTtdkTyuui, C_SkeittdkrenrakuKbn> skeittdkrenrakukbn = new ExDBFieldString<>("skeittdkrenrakukbn", this, UserType_C_SkeittdkrenrakuKbn.class);

    public final ExDBFieldNumber<HT_SkTtdkTyuui, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldString<HT_SkTtdkTyuui, String> skeittdktyuuinaiyou = new ExDBFieldString<>("skeittdktyuuinaiyou", this);

    public final ExDBFieldString<HT_SkTtdkTyuui, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkTtdkTyuui, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkTtdkTyuui, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
