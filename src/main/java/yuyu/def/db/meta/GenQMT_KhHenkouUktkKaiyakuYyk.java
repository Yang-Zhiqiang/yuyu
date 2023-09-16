package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.MT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 契約保全変更受付内容（解約）予約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_KhHenkouUktkKaiyakuYyk extends AbstractExDBTable<MT_KhHenkouUktkKaiyakuYyk> {

    public GenQMT_KhHenkouUktkKaiyakuYyk() {
        this("MT_KhHenkouUktkKaiyakuYyk");
    }

    public GenQMT_KhHenkouUktkKaiyakuYyk(String pAlias) {
        super("MT_KhHenkouUktkKaiyakuYyk", MT_KhHenkouUktkKaiyakuYyk.class, pAlias);
    }

    public String MT_KhHenkouUktkKaiyakuYyk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<MT_KhHenkouUktkKaiyakuYyk, Integer> hozenhenkouuktkrenno = new ExDBFieldNumber<>("hozenhenkouuktkrenno", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_KhHenkouUktkKaiyakuYyk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
