package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;

/**
 * 新契約口振受付登録結果テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKouhuriUkTrkkekkaTr extends AbstractExDBTable<ZT_SkKouhuriUkTrkkekkaTr> {

    public GenQZT_SkKouhuriUkTrkkekkaTr() {
        this("ZT_SkKouhuriUkTrkkekkaTr");
    }

    public GenQZT_SkKouhuriUkTrkkekkaTr(String pAlias) {
        super("ZT_SkKouhuriUkTrkkekkaTr", ZT_SkKouhuriUkTrkkekkaTr.class, pAlias);
    }

    public String ZT_SkKouhuriUkTrkkekkaTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrsyukkncd = new ExDBFieldString<>("ztrsyukkncd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkinyuukikancd8keta = new ExDBFieldString<>("ztrkinyuukikancd8keta", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrrecordkbn = new ExDBFieldString<>("ztrrecordkbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkinyuukkntratkiymd = new ExDBFieldString<>("ztrkinyuukkntratkiymd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkinyuukkntratkitime = new ExDBFieldString<>("ztrkinyuukkntratkitime", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkinyuukkntratkino = new ExDBFieldString<>("ztrkinyuukkntratkino", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkouhuriukchannelkbn = new ExDBFieldString<>("ztrkouhuriukchannelkbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkouhuriokyakusamano = new ExDBFieldString<>("ztrkouhuriokyakusamano", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkouhuribankcd = new ExDBFieldString<>("ztrkouhuribankcd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkouhurisitencd5keta = new ExDBFieldString<>("ztrkouhurisitencd5keta", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkzhurikaeyokinkbn = new ExDBFieldString<>("ztrkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkzhurikaekouzano8keta = new ExDBFieldString<>("ztrkzhurikaekouzano8keta", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkzmeiginmei = new ExDBFieldString<>("ztrkzmeiginmei", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztritakusyacd = new ExDBFieldString<>("ztritakusyacd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrsyukkntratkiymd = new ExDBFieldString<>("ztrsyukkntratkiymd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrsyukkntratkitime = new ExDBFieldString<>("ztrsyukkntratkitime", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrsyukkntratkino = new ExDBFieldString<>("ztrsyukkntratkino", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkouhuristatuskbn = new ExDBFieldString<>("ztrkouhuristatuskbn", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkouhurikekkacd = new ExDBFieldString<>("ztrkouhurikekkacd", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztrkouhurihonninkakkekka = new ExDBFieldString<>("ztrkouhurihonninkakkekka", this);

    public final ExDBFieldString<ZT_SkKouhuriUkTrkkekkaTr, String> ztryobiv207 = new ExDBFieldString<>("ztryobiv207", this);
}
