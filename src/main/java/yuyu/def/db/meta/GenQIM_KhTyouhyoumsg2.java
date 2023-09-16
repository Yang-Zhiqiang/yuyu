package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhTyouhyoumsg2;
import yuyu.def.db.type.UserType_C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.db.type.UserType_C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.db.type.UserType_C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.db.type.UserType_C_KyksyaSibouUmuKbn;
import yuyu.def.db.type.UserType_C_Meigihnkjiyuu;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全帳票メッセージマスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_KhTyouhyoumsg2 extends AbstractExDBTable<IM_KhTyouhyoumsg2> {

    public GenQIM_KhTyouhyoumsg2() {
        this("IM_KhTyouhyoumsg2");
    }

    public GenQIM_KhTyouhyoumsg2(String pAlias) {
        super("IM_KhTyouhyoumsg2", IM_KhTyouhyoumsg2.class, pAlias);
    }

    public String IM_KhTyouhyoumsg2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_Meigihnkjiyuu> meigihnkjiyuu = new ExDBFieldString<>("meigihnkjiyuu", this, UserType_C_Meigihnkjiyuu.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_KyksyaSibouUmuKbn> kyksbumu = new ExDBFieldString<>("kyksbumu", this, UserType_C_KyksyaSibouUmuKbn.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_UmuKbn> shrumu = new ExDBFieldString<>("shrumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_UmuKbn> tuityouumu = new ExDBFieldString<>("tuityouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_KhTyouhyoumsgbunruiKbn1> khtyouhyoumsgbunruikbn1 = new ExDBFieldString<>("khtyouhyoumsgbunruikbn1", this, UserType_C_KhTyouhyoumsgbunruiKbn1.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_KhTyouhyoumsgbunruiKbn2> khtyouhyoumsgbunruikbn2 = new ExDBFieldString<>("khtyouhyoumsgbunruikbn2", this, UserType_C_KhTyouhyoumsgbunruiKbn2.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, C_KhTyouhyoumsgbunruiKbn3> khtyouhyoumsgbunruikbn3 = new ExDBFieldString<>("khtyouhyoumsgbunruikbn3", this, UserType_C_KhTyouhyoumsgbunruiKbn3.class);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> tyouhyoutitle = new ExDBFieldString<>("tyouhyoutitle", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> sksnm = new ExDBFieldString<>("sksnm", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg1 = new ExDBFieldString<>("rsouhuannaimsg1", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg2 = new ExDBFieldString<>("rsouhuannaimsg2", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg3 = new ExDBFieldString<>("rsouhuannaimsg3", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg4 = new ExDBFieldString<>("rsouhuannaimsg4", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg5 = new ExDBFieldString<>("rsouhuannaimsg5", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg6 = new ExDBFieldString<>("rsouhuannaimsg6", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg7 = new ExDBFieldString<>("rsouhuannaimsg7", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg8 = new ExDBFieldString<>("rsouhuannaimsg8", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg9 = new ExDBFieldString<>("rsouhuannaimsg9", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rsouhuannaimsg10 = new ExDBFieldString<>("rsouhuannaimsg10", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg1 = new ExDBFieldString<>("rannainaiyoumsg1", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg2 = new ExDBFieldString<>("rannainaiyoumsg2", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg3 = new ExDBFieldString<>("rannainaiyoumsg3", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg4 = new ExDBFieldString<>("rannainaiyoumsg4", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg5 = new ExDBFieldString<>("rannainaiyoumsg5", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg6 = new ExDBFieldString<>("rannainaiyoumsg6", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg7 = new ExDBFieldString<>("rannainaiyoumsg7", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg8 = new ExDBFieldString<>("rannainaiyoumsg8", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg9 = new ExDBFieldString<>("rannainaiyoumsg9", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg10 = new ExDBFieldString<>("rannainaiyoumsg10", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg11 = new ExDBFieldString<>("rannainaiyoumsg11", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg12 = new ExDBFieldString<>("rannainaiyoumsg12", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg13 = new ExDBFieldString<>("rannainaiyoumsg13", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg14 = new ExDBFieldString<>("rannainaiyoumsg14", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg15 = new ExDBFieldString<>("rannainaiyoumsg15", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg16 = new ExDBFieldString<>("rannainaiyoumsg16", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg17 = new ExDBFieldString<>("rannainaiyoumsg17", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg18 = new ExDBFieldString<>("rannainaiyoumsg18", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg19 = new ExDBFieldString<>("rannainaiyoumsg19", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg20 = new ExDBFieldString<>("rannainaiyoumsg20", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg21 = new ExDBFieldString<>("rannainaiyoumsg21", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg22 = new ExDBFieldString<>("rannainaiyoumsg22", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg23 = new ExDBFieldString<>("rannainaiyoumsg23", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg24 = new ExDBFieldString<>("rannainaiyoumsg24", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg25 = new ExDBFieldString<>("rannainaiyoumsg25", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg26 = new ExDBFieldString<>("rannainaiyoumsg26", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg27 = new ExDBFieldString<>("rannainaiyoumsg27", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg28 = new ExDBFieldString<>("rannainaiyoumsg28", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg29 = new ExDBFieldString<>("rannainaiyoumsg29", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> rannainaiyoumsg30 = new ExDBFieldString<>("rannainaiyoumsg30", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_KhTyouhyoumsg2, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
