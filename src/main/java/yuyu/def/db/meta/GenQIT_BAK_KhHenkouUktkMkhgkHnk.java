package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkMkhgkHnk;

/**
 * 契約保全変更受付内容（目標額変更）バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhHenkouUktkMkhgkHnk extends AbstractExDBTable<IT_BAK_KhHenkouUktkMkhgkHnk> {

    public GenQIT_BAK_KhHenkouUktkMkhgkHnk() {
        this("IT_BAK_KhHenkouUktkMkhgkHnk");
    }

    public GenQIT_BAK_KhHenkouUktkMkhgkHnk(String pAlias) {
        super("IT_BAK_KhHenkouUktkMkhgkHnk", IT_BAK_KhHenkouUktkMkhgkHnk.class, pAlias);
    }

    public String IT_BAK_KhHenkouUktkMkhgkHnk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhHenkouUktkMkhgkHnk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkMkhgkHnk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkMkhgkHnk, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KhHenkouUktkMkhgkHnk, Integer> hozenhenkouuktkrenno = new ExDBFieldNumber<>("hozenhenkouuktkrenno", this);

    public final ExDBFieldNumber<IT_BAK_KhHenkouUktkMkhgkHnk, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkMkhgkHnk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkMkhgkHnk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkMkhgkHnk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
