package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaTr;

/**
 * 口座振替収納結果Ｆテーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KzhuriSyuunouKekkaTr extends AbstractExDBTable<ZT_KzhuriSyuunouKekkaTr> {

    public GenQZT_KzhuriSyuunouKekkaTr() {
        this("ZT_KzhuriSyuunouKekkaTr");
    }

    public GenQZT_KzhuriSyuunouKekkaTr(String pAlias) {
        super("ZT_KzhuriSyuunouKekkaTr", ZT_KzhuriSyuunouKekkaTr.class, pAlias);
    }

    public String ZT_KzhuriSyuunouKekkaTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrsyono = new ExDBFieldString<>("ztrsyono", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrkzhurikaebankcd = new ExDBFieldString<>("ztrkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrkzhurikaesitencd = new ExDBFieldString<>("ztrkzhurikaesitencd", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrkzhurikaeyokinkbn = new ExDBFieldString<>("ztrkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrkzhurikaekouzano = new ExDBFieldString<>("ztrkzhurikaekouzano", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrhurikaeymd = new ExDBFieldString<>("ztrhurikaeymd", this);

    public final ExDBFieldNumber<ZT_KzhuriSyuunouKekkaTr, Long> ztrrsgaku = new ExDBFieldNumber<>("ztrrsgaku", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrjyuutouym = new ExDBFieldString<>("ztrjyuutouym", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrjyuutounensuu = new ExDBFieldString<>("ztrjyuutounensuu", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrjyuutoutukisuu = new ExDBFieldString<>("ztrjyuutoutukisuu", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrdantaikobetukbn = new ExDBFieldString<>("ztrdantaikobetukbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrnyknaiyoukbn = new ExDBFieldString<>("ztrnyknaiyoukbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrhrkkaisuukbn = new ExDBFieldString<>("ztrhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrkzhurikaetkbtannaihyj = new ExDBFieldString<>("ztrkzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrhurikaekekkakbn = new ExDBFieldString<>("ztrhurikaekekkakbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztrkzhurisyuudaikokbn = new ExDBFieldString<>("ztrkzhurisyuudaikokbn", this);

    public final ExDBFieldString<ZT_KzhuriSyuunouKekkaTr, String> ztryobiv13 = new ExDBFieldString<>("ztryobiv13", this);
}
