package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KakuninjyoutaiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_TyouhyouBunruiKbn;

/**
 * 契約保全帳票本番確認テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhTyouhyouHonbanKakunin extends AbstractExDBTable<IT_KhTyouhyouHonbanKakunin> {

    public GenQIT_KhTyouhyouHonbanKakunin() {
        this("IT_KhTyouhyouHonbanKakunin");
    }

    public GenQIT_KhTyouhyouHonbanKakunin(String pAlias) {
        super("IT_KhTyouhyouHonbanKakunin", IT_KhTyouhyouHonbanKakunin.class, pAlias);
    }

    public String IT_KhTyouhyouHonbanKakunin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, C_TyouhyouBunruiKbn> tyouhyoubunrui = new ExDBFieldString<>("tyouhyoubunrui", this, UserType_C_TyouhyouBunruiKbn.class);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, String> jyoukenbunrui1 = new ExDBFieldString<>("jyoukenbunrui1", this);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, String> jyoukenbunrui2 = new ExDBFieldString<>("jyoukenbunrui2", this);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, String> jyoukenbunrui3 = new ExDBFieldString<>("jyoukenbunrui3", this);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, C_KakuninjyoutaiKbn> kakuninjyoutaikbn = new ExDBFieldString<>("kakuninjyoutaikbn", this, UserType_C_KakuninjyoutaiKbn.class);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, BizDate> honbankakuninstartymd = new ExDBFieldString<>("honbankakuninstartymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, BizDate> firstkaisouymd = new ExDBFieldString<>("firstkaisouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, BizDate> honbankakuninymd = new ExDBFieldString<>("honbankakuninymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhTyouhyouHonbanKakunin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
