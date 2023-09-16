package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 査定解除情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SateiKaijyoInfo extends AbstractExDBTable<JT_SateiKaijyoInfo> {

    public GenQJT_SateiKaijyoInfo() {
        this("JT_SateiKaijyoInfo");
    }

    public GenQJT_SateiKaijyoInfo(String pAlias) {
        super("JT_SateiKaijyoInfo", JT_SateiKaijyoInfo.class, pAlias);
    }

    public String JT_SateiKaijyoInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SateiKaijyoInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SateiKaijyoInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SateiKaijyoInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SateiKaijyoInfo, BizDate> kaijokigenymd = new ExDBFieldString<>("kaijokigenymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SateiKaijyoInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SateiKaijyoInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SateiKaijyoInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SateiKaijyoInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
