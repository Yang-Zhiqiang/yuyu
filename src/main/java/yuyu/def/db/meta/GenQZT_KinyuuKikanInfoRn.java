package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;

/**
 * 金融機関情報連動ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KinyuuKikanInfoRn extends AbstractExDBTable<ZT_KinyuuKikanInfoRn> {

    public GenQZT_KinyuuKikanInfoRn() {
        this("ZT_KinyuuKikanInfoRn");
    }

    public GenQZT_KinyuuKikanInfoRn(String pAlias) {
        super("ZT_KinyuuKikanInfoRn", ZT_KinyuuKikanInfoRn.class, pAlias);
    }

    public String ZT_KinyuuKikanInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnkinyuukikancd = new ExDBFieldString<>("zrnkinyuukikancd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnsitencd = new ExDBFieldString<>("zrnsitencd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrntenpokbn = new ExDBFieldString<>("zrntenpokbn", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnkousinymd = new ExDBFieldString<>("zrnkousinymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnsinsetuymd = new ExDBFieldString<>("zrnsinsetuymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnhaisiymd = new ExDBFieldString<>("zrnhaisiymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnkanakinyuukikannm = new ExDBFieldString<>("zrnkanakinyuukikannm", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnkanasitennm = new ExDBFieldString<>("zrnkanasitennm", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnkanjikinyuukikannm = new ExDBFieldString<>("zrnkanjikinyuukikannm", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnkanjisitennm = new ExDBFieldString<>("zrnkanjisitennm", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrneijikinyuukikannm = new ExDBFieldString<>("zrneijikinyuukikannm", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrneijisitennm = new ExDBFieldString<>("zrneijisitennm", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrncsskyouteikaisiymd = new ExDBFieldString<>("zrncsskyouteikaisiymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrncsskyouteikaijyoymd = new ExDBFieldString<>("zrncsskyouteikaijyoymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnkokunaikawasehyouji = new ExDBFieldString<>("zrnkokunaikawasehyouji", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnhurikomikanousitenhyouji = new ExDBFieldString<>("zrnhurikomikanousitenhyouji", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrngyoutaikbn = new ExDBFieldString<>("zrngyoutaikbn", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnyofurikyouteikaisiymd = new ExDBFieldString<>("zrnyofurikyouteikaisiymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnyofurikyouteikaijyoymd = new ExDBFieldString<>("zrnyofurikyouteikaijyoymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnitakusyakinyuucd = new ExDBFieldString<>("zrnitakusyakinyuucd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnitakusyasitencd = new ExDBFieldString<>("zrnitakusyasitencd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnitakusyayokinkbn = new ExDBFieldString<>("zrnitakusyayokinkbn", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnitakusyakouzano = new ExDBFieldString<>("zrnitakusyakouzano", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrntsrkeisanhoukbn = new ExDBFieldString<>("zrntsrkeisanhoukbn", this);

    public final ExDBFieldNumber<ZT_KinyuuKikanInfoRn, Integer> zrnkinyuutesuuryou = new ExDBFieldNumber<>("zrnkinyuutesuuryou", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnitakusyacd = new ExDBFieldString<>("zrnitakusyacd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrntapekoukankbn1 = new ExDBFieldString<>("zrntapekoukankbn1", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnmdsisyacd = new ExDBFieldString<>("zrnmdsisyacd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnzzkkyouteikaisiymd = new ExDBFieldString<>("zrnzzkkyouteikaisiymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnzzkkyouteikaijyoymd = new ExDBFieldString<>("zrnzzkkyouteikaijyoymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnhuhoyofuriinfokousinymd = new ExDBFieldString<>("zrnhuhoyofuriinfokousinymd", this);

    public final ExDBFieldString<ZT_KinyuuKikanInfoRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);
}
