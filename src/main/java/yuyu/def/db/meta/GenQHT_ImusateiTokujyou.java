package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.db.entity.HT_ImusateiTokujyou;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_Tkjyhyouten;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;

/**
 * 医務査定特条テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_ImusateiTokujyou extends AbstractExDBTable<HT_ImusateiTokujyou> {

    public GenQHT_ImusateiTokujyou() {
        this("HT_ImusateiTokujyou");
    }

    public GenQHT_ImusateiTokujyou(String pAlias) {
        super("HT_ImusateiTokujyou", HT_ImusateiTokujyou.class, pAlias);
    }

    public String HT_ImusateiTokujyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_ImusateiTokujyou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_ImusateiTokujyou, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_ImusateiTokujyou, C_Tkjyhyouten> tkjyhyouten = new ExDBFieldString<>("tkjyhyouten", this, UserType_C_Tkjyhyouten.class);

    public final ExDBFieldString<HT_ImusateiTokujyou, C_Tkjyskgnkkn> tkjyskgnkkn = new ExDBFieldString<>("tkjyskgnkkn", this, UserType_C_Tkjyskgnkkn.class);

    public final ExDBFieldString<HT_ImusateiTokujyou, String> htnpbuicd1 = new ExDBFieldString<>("htnpbuicd1", this);

    public final ExDBFieldString<HT_ImusateiTokujyou, C_Htnpkkn> htnpkkn1 = new ExDBFieldString<>("htnpkkn1", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<HT_ImusateiTokujyou, String> htnpbuicd2 = new ExDBFieldString<>("htnpbuicd2", this);

    public final ExDBFieldString<HT_ImusateiTokujyou, C_Htnpkkn> htnpkkn2 = new ExDBFieldString<>("htnpkkn2", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<HT_ImusateiTokujyou, String> htnpbuicd3 = new ExDBFieldString<>("htnpbuicd3", this);

    public final ExDBFieldString<HT_ImusateiTokujyou, C_Htnpkkn> htnpkkn3 = new ExDBFieldString<>("htnpkkn3", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<HT_ImusateiTokujyou, String> htnpbuicd4 = new ExDBFieldString<>("htnpbuicd4", this);

    public final ExDBFieldString<HT_ImusateiTokujyou, C_Htnpkkn> htnpkkn4 = new ExDBFieldString<>("htnpkkn4", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<HT_ImusateiTokujyou, C_TokkoudosghtnpKbn> tokkoudosghtnpkbn = new ExDBFieldString<>("tokkoudosghtnpkbn", this, UserType_C_TokkoudosghtnpKbn.class);

    public final ExDBFieldString<HT_ImusateiTokujyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_ImusateiTokujyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
