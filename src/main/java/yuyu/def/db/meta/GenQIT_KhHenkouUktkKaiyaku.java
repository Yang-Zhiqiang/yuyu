package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 契約保全変更受付内容（解約）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhHenkouUktkKaiyaku extends AbstractExDBTable<IT_KhHenkouUktkKaiyaku> {

    public GenQIT_KhHenkouUktkKaiyaku() {
        this("IT_KhHenkouUktkKaiyaku");
    }

    public GenQIT_KhHenkouUktkKaiyaku(String pAlias) {
        super("IT_KhHenkouUktkKaiyaku", IT_KhHenkouUktkKaiyaku.class, pAlias);
    }

    public String IT_KhHenkouUktkKaiyaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_KhHenkouUktkKaiyaku, Integer> hozenhenkouuktkrenno = new ExDBFieldNumber<>("hozenhenkouuktkrenno", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhHenkouUktkKaiyaku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
