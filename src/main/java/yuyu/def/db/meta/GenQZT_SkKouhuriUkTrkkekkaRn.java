package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaRn;

/**
 * 新契約口振受付登録結果テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKouhuriUkTrkkekkaRn extends AbstractExDBTable<ZT_SkKouhuriUkTrkkekkaRn> {

    public GenQZT_SkKouhuriUkTrkkekkaRn() {
        this("ZT_SkKouhuriUkTrkkekkaRn");
    }

    public GenQZT_SkKouhuriUkTrkkekkaRn(String pAlias) {
        super("ZT_SkKouhuriUkTrkkekkaRn", ZT_SkKouhuriUkTrkkekkaRn.class, pAlias);
    }

    public String ZT_SkKouhuriUkTrkkekkaRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnsyukkncd = new ExDBFieldString<>("zrnsyukkncd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkinyuukikancd8keta = new ExDBFieldString<>("zrnkinyuukikancd8keta", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkinyuukkntratkiymd = new ExDBFieldString<>("zrnkinyuukkntratkiymd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkinyuukkntratkitime = new ExDBFieldString<>("zrnkinyuukkntratkitime", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkinyuukkntratkino = new ExDBFieldString<>("zrnkinyuukkntratkino", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkouhuriukchannelkbn = new ExDBFieldString<>("zrnkouhuriukchannelkbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkouhuriokyakusamano = new ExDBFieldString<>("zrnkouhuriokyakusamano", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkouhuribankcd = new ExDBFieldString<>("zrnkouhuribankcd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkouhurisitencd5keta = new ExDBFieldString<>("zrnkouhurisitencd5keta", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkzhurikaeyokinkbn = new ExDBFieldString<>("zrnkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkzhurikaekouzano8keta = new ExDBFieldString<>("zrnkzhurikaekouzano8keta", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkzmeiginmei = new ExDBFieldString<>("zrnkzmeiginmei", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnitakusyacd = new ExDBFieldString<>("zrnitakusyacd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnsyukkntratkiymd = new ExDBFieldString<>("zrnsyukkntratkiymd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnsyukkntratkitime = new ExDBFieldString<>("zrnsyukkntratkitime", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnsyukkntratkino = new ExDBFieldString<>("zrnsyukkntratkino", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkouhuristatuskbn = new ExDBFieldString<>("zrnkouhuristatuskbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkouhurikekkacd = new ExDBFieldString<>("zrnkouhurikekkacd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnkouhurihonninkakkekka = new ExDBFieldString<>("zrnkouhurihonninkakkekka", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaRn, String> zrnyobiv207 = new ExDBFieldString<>("zrnyobiv207", this);
}
