package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.db.entity.IT_BAK_SyouhnTokujou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tkjyhyouten;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;

/**
 * 商品特条バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_SyouhnTokujou extends AbstractExDBTable<IT_BAK_SyouhnTokujou> {

    public GenQIT_BAK_SyouhnTokujou() {
        this("IT_BAK_SyouhnTokujou");
    }

    public GenQIT_BAK_SyouhnTokujou(String pAlias) {
        super("IT_BAK_SyouhnTokujou", IT_BAK_SyouhnTokujou.class, pAlias);
    }

    public String IT_BAK_SyouhnTokujou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_BAK_SyouhnTokujou, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<IT_BAK_SyouhnTokujou, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_Tkjyhyouten> tkjyhyouten = new ExDBFieldString<>("tkjyhyouten", this, UserType_C_Tkjyhyouten.class);

    public final ExDBFieldBizCurrency<IT_BAK_SyouhnTokujou> tkjyp = new ExDBFieldBizCurrency<>("tkjyp", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_Tkjyskgnkkn> tkjyskgnkkn = new ExDBFieldString<>("tkjyskgnkkn", this, UserType_C_Tkjyskgnkkn.class);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> htnpbuicd1 = new ExDBFieldString<>("htnpbuicd1", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_Htnpkkn> htnpkkn1 = new ExDBFieldString<>("htnpkkn1", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> htnpbuicd2 = new ExDBFieldString<>("htnpbuicd2", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_Htnpkkn> htnpkkn2 = new ExDBFieldString<>("htnpkkn2", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> htnpbuicd3 = new ExDBFieldString<>("htnpbuicd3", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_Htnpkkn> htnpkkn3 = new ExDBFieldString<>("htnpkkn3", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> htnpbuicd4 = new ExDBFieldString<>("htnpbuicd4", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_Htnpkkn> htnpkkn4 = new ExDBFieldString<>("htnpkkn4", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, C_TokkoudosghtnpKbn> tokkoudosghtnpkbn = new ExDBFieldString<>("tokkoudosghtnpkbn", this, UserType_C_TokkoudosghtnpKbn.class);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_SyouhnTokujou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
