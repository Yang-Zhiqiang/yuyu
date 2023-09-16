package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SosikiRn;

/**
 * 普保用組織ＰＲＴ用連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SosikiRn extends AbstractExDBTable<ZT_SosikiRn> {

    public GenQZT_SosikiRn() {
        this("ZT_SosikiRn");
    }

    public GenQZT_SosikiRn(String pAlias) {
        super("ZT_SosikiRn", ZT_SosikiRn.class, pAlias);
    }

    public String ZT_SosikiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikicd = new ExDBFieldString<>("zrnsosikicd", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikinmkbn = new ExDBFieldString<>("zrnsosikinmkbn", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikinm20 = new ExDBFieldString<>("zrnsosikinm20", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnkanjisosikinm20 = new ExDBFieldString<>("zrnkanjisosikinm20", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikihaisiy = new ExDBFieldString<>("zrnsosikihaisiy", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikihaisim = new ExDBFieldString<>("zrnsosikihaisim", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikisinsetuy = new ExDBFieldString<>("zrnsosikisinsetuy", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikisinsetum = new ExDBFieldString<>("zrnsosikisinsetum", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrntougetukeisyousosikicd = new ExDBFieldString<>("zrntougetukeisyousosikicd", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrntougetukeisyoueigyoubucd = new ExDBFieldString<>("zrntougetukeisyoueigyoubucd", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnzengetukeisyousosikicd = new ExDBFieldString<>("zrnzengetukeisyousosikicd", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnzengetukeisyoueigyoubucd = new ExDBFieldString<>("zrnzengetukeisyoueigyoubucd", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikikihontikucd = new ExDBFieldString<>("zrnsosikikihontikucd", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikikanjikaiadr30 = new ExDBFieldString<>("zrnsosikikanjikaiadr30", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnkanjibilunm15 = new ExDBFieldString<>("zrnkanjibilunm15", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikinyuukyokaisuu = new ExDBFieldString<>("zrnsosikinyuukyokaisuu", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikidenwabangousigai = new ExDBFieldString<>("zrnsosikidenwabangousigai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikitdenwabangousinai = new ExDBFieldString<>("zrnsosikitdenwabangousinai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikidenwabangoubangou = new ExDBFieldString<>("zrnsosikidenwabangoubangou", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikifaxbangousigai = new ExDBFieldString<>("zrnsosikifaxbangousigai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikifaxbangousinai = new ExDBFieldString<>("zrnsosikifaxbangousinai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnsosikifaxbangoubangou = new ExDBFieldString<>("zrnsosikifaxbangoubangou", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnkouryokukaisiy = new ExDBFieldString<>("zrnkouryokukaisiy", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnkouryokukaisim = new ExDBFieldString<>("zrnkouryokukaisim", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnkouryokukaisid = new ExDBFieldString<>("zrnkouryokukaisid", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikikihontikucd = new ExDBFieldString<>("zrnnewsosikikihontikucd", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewkanjisosikikaiadr30 = new ExDBFieldString<>("zrnnewkanjisosikikaiadr30", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewkanjibilunm15 = new ExDBFieldString<>("zrnnewkanjibilunm15", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikinyuukyokaisuu = new ExDBFieldString<>("zrnnewsosikinyuukyokaisuu", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikidenwasigai = new ExDBFieldString<>("zrnnewsosikidenwasigai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikidenwasinai = new ExDBFieldString<>("zrnnewsosikidenwasinai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikidenwabangou = new ExDBFieldString<>("zrnnewsosikidenwabangou", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikifaxsigai = new ExDBFieldString<>("zrnnewsosikifaxsigai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikifaxsinai = new ExDBFieldString<>("zrnnewsosikifaxsinai", this);

    public final ExDBFieldString<ZT_SosikiRn, String> zrnnewsosikifaxbangou = new ExDBFieldString<>("zrnnewsosikifaxbangou", this);
}
