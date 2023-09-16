package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TuutiJkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.type.UserType_C_TuutiJkKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 期日到来本番検証用通知状況テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_KijituTuriHnbnKnsouTutJk extends AbstractExDBTable<BT_KijituTuriHnbnKnsouTutJk> {

    public GenQBT_KijituTuriHnbnKnsouTutJk() {
        this("BT_KijituTuriHnbnKnsouTutJk");
    }

    public GenQBT_KijituTuriHnbnKnsouTutJk(String pAlias) {
        super("BT_KijituTuriHnbnKnsouTutJk", BT_KijituTuriHnbnKnsouTutJk.class, pAlias);
    }

    public String BT_KijituTuriHnbnKnsouTutJk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTutJk, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldNumber<BT_KijituTuriHnbnKnsouTutJk, Integer> tysytno = new ExDBFieldNumber<>("tysytno", this);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTutJk, C_YouhiKbn> nikaimeikoutuutiyouhi = new ExDBFieldString<>("nikaimeikoutuutiyouhi", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTutJk, C_TuutiJkKbn> tuutijkkbn = new ExDBFieldString<>("tuutijkkbn", this, UserType_C_TuutiJkKbn.class);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTutJk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTutJk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_KijituTuriHnbnKnsouTutJk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
