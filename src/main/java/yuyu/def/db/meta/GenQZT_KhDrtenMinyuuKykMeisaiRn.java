package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiRn;

/**
 * 代理店未入契約明細テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KhDrtenMinyuuKykMeisaiRn extends AbstractExDBTable<ZT_KhDrtenMinyuuKykMeisaiRn> {

    public GenQZT_KhDrtenMinyuuKykMeisaiRn() {
        this("ZT_KhDrtenMinyuuKykMeisaiRn");
    }

    public GenQZT_KhDrtenMinyuuKykMeisaiRn(String pAlias) {
        super("ZT_KhDrtenMinyuuKykMeisaiRn", ZT_KhDrtenMinyuuKykMeisaiRn.class, pAlias);
    }

    public String ZT_KhDrtenMinyuuKykMeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnsyoriymd = new ExDBFieldString<>("zrnsyoriymd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnpjyuutouyymmwareki4keta = new ExDBFieldString<>("zrnpjyuutouyymmwareki4keta", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnbosyuudrtennmkj = new ExDBFieldString<>("zrnbosyuudrtennmkj", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnminyuujyutuymd = new ExDBFieldString<>("zrnminyuujyutuymd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnhassinka = new ExDBFieldString<>("zrnhassinka", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrndrtnbsyunnmisyou = new ExDBFieldString<>("zrndrtnbsyunnmisyou", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkydatkikbn = new ExDBFieldString<>("zrnkydatkikbn", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkyknmkj35 = new ExDBFieldString<>("zrnkyknmkj35", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldNumber<ZT_KhDrtenMinyuuKykMeisaiRn, Long> zrnhrkgk = new ExDBFieldNumber<>("zrnhrkgk", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnknkimnyuuryu = new ExDBFieldString<>("zrnknkimnyuuryu", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnbosyuuningyouhaiymd = new ExDBFieldString<>("zrnbosyuuningyouhaiymd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkzhurikaebankcd = new ExDBFieldString<>("zrnkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkzhurikaesitencd = new ExDBFieldString<>("zrnkzhurikaesitencd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkzhurikaeyokinkbn = new ExDBFieldString<>("zrnkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkzhurikaekouzano = new ExDBFieldString<>("zrnkzhurikaekouzano", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnknyukknmei = new ExDBFieldString<>("zrnknyukknmei", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnknyykknstnmei = new ExDBFieldString<>("zrnknyykknstnmei", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrndantaicd = new ExDBFieldString<>("zrndantaicd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnkjdntnm = new ExDBFieldString<>("zrnkjdntnm", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnhknsyuruimei = new ExDBFieldString<>("zrnhknsyuruimei", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnbkofccd = new ExDBFieldString<>("zrnbkofccd", this);

    public final ExDBFieldString<ZT_KhDrtenMinyuuKykMeisaiRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);
}
