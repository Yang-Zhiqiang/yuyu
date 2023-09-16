package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_KijituTouraiHonbanKensyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 期日到来本番検証用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_KijituTouraiHonbanKensyou extends AbstractExDBTable<BT_KijituTouraiHonbanKensyou> {

    public GenQBT_KijituTouraiHonbanKensyou() {
        this("BT_KijituTouraiHonbanKensyou");
    }

    public GenQBT_KijituTouraiHonbanKensyou(String pAlias) {
        super("BT_KijituTouraiHonbanKensyou", BT_KijituTouraiHonbanKensyou.class, pAlias);
    }

    public String BT_KijituTouraiHonbanKensyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldNumber<BT_KijituTouraiHonbanKensyou, Integer> tysytno = new ExDBFieldNumber<>("tysytno", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> datakanrino = new ExDBFieldString<>("datakanrino", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou1 = new ExDBFieldString<>("tysytnaiyou1", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou2 = new ExDBFieldString<>("tysytnaiyou2", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou3 = new ExDBFieldString<>("tysytnaiyou3", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou4 = new ExDBFieldString<>("tysytnaiyou4", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou5 = new ExDBFieldString<>("tysytnaiyou5", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou6 = new ExDBFieldString<>("tysytnaiyou6", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou7 = new ExDBFieldString<>("tysytnaiyou7", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou8 = new ExDBFieldString<>("tysytnaiyou8", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou9 = new ExDBFieldString<>("tysytnaiyou9", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> tysytnaiyou10 = new ExDBFieldString<>("tysytnaiyou10", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_KijituTouraiHonbanKensyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
