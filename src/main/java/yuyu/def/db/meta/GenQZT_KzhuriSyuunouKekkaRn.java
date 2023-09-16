package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaRn;

/**
 * 口座振替収納結果Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KzhuriSyuunouKekkaRn extends AbstractExDBTable<ZT_KzhuriSyuunouKekkaRn> {

    public GenQZT_KzhuriSyuunouKekkaRn() {
        this("ZT_KzhuriSyuunouKekkaRn");
    }

    public GenQZT_KzhuriSyuunouKekkaRn(String pAlias) {
        super("ZT_KzhuriSyuunouKekkaRn", ZT_KzhuriSyuunouKekkaRn.class, pAlias);
    }

    public String ZT_KzhuriSyuunouKekkaRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnkzhurikaebankcd = new ExDBFieldString<>("zrnkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnkzhurikaesitencd = new ExDBFieldString<>("zrnkzhurikaesitencd", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnkzhurikaeyokinkbn = new ExDBFieldString<>("zrnkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnkzhurikaekouzano = new ExDBFieldString<>("zrnkzhurikaekouzano", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnhurikaeymd = new ExDBFieldString<>("zrnhurikaeymd", this);

    public final ExDBFieldNumber<ZT_KzhuriSyuunouKekkaRn, Long> zrnrsgaku = new ExDBFieldNumber<>("zrnrsgaku", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnjyuutouym = new ExDBFieldString<>("zrnjyuutouym", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnjyuutounensuu = new ExDBFieldString<>("zrnjyuutounensuu", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnjyuutoutukisuu = new ExDBFieldString<>("zrnjyuutoutukisuu", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrndantaikobetukbn = new ExDBFieldString<>("zrndantaikobetukbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnnyknaiyoukbn = new ExDBFieldString<>("zrnnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnkzhurikaetkbtannaihyj = new ExDBFieldString<>("zrnkzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnhurikaekekkakbn = new ExDBFieldString<>("zrnhurikaekekkakbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnkzhurisyuudaikokbn = new ExDBFieldString<>("zrnkzhurisyuudaikokbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaRn, String> zrnyobiv13 = new ExDBFieldString<>("zrnyobiv13", this);
}
