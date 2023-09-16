package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTut;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 期日到来本番検証用通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_KijituTuriHnbnKnsouTut extends AbstractExDBTable<BT_KijituTuriHnbnKnsouTut> {

    public GenQBT_KijituTuriHnbnKnsouTut() {
        this("BT_KijituTuriHnbnKnsouTut");
    }

    public GenQBT_KijituTuriHnbnKnsouTut(String pAlias) {
        super("BT_KijituTuriHnbnKnsouTut", BT_KijituTuriHnbnKnsouTut.class, pAlias);
    }

    public String BT_KijituTuriHnbnKnsouTut() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTut, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTut, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldNumber<BT_KijituTuriHnbnKnsouTut, Integer> tysytno = new ExDBFieldNumber<>("tysytno", this);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTut, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTut, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTut, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
