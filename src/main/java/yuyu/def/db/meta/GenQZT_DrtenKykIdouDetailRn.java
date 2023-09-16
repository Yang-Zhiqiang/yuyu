package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailRn;

/**
 * 代理店契約異動明細テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenKykIdouDetailRn extends AbstractExDBTable<ZT_DrtenKykIdouDetailRn> {

    public GenQZT_DrtenKykIdouDetailRn() {
        this("ZT_DrtenKykIdouDetailRn");
    }

    public GenQZT_DrtenKykIdouDetailRn(String pAlias) {
        super("ZT_DrtenKykIdouDetailRn", ZT_DrtenKykIdouDetailRn.class, pAlias);
    }

    public String ZT_DrtenKykIdouDetailRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkinyuukikancd = new ExDBFieldString<>("zrnkinyuukikancd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkinyuukikansitencd = new ExDBFieldString<>("zrnkinyuukikansitencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnidouhasseiymd = new ExDBFieldString<>("zrnidouhasseiymd", this);

    public final ExDBFieldNumber<ZT_DrtenKykIdouDetailRn, Long> zrnkykmfksnctrlkh = new ExDBFieldNumber<>("zrnkykmfksnctrlkh", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnidoukbn = new ExDBFieldString<>("zrnidoukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkydatkikbn = new ExDBFieldString<>("zrnkydatkikbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrndntcd = new ExDBFieldString<>("zrndntcd", this);

    public final ExDBFieldNumber<ZT_DrtenKykIdouDetailRn, Long> zrnharaikomip = new ExDBFieldNumber<>("zrnharaikomip", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkjsyagaihknnm = new ExDBFieldString<>("zrnkjsyagaihknnm", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrntelno = new ExDBFieldString<>("zrntelno", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnhensyuubosyuudrtennm = new ExDBFieldString<>("zrnhensyuubosyuudrtennm", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkyknmkjdirtnkykido = new ExDBFieldString<>("zrnkyknmkjdirtnkykido", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkjdntnm = new ExDBFieldString<>("zrnkjdntnm", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkzhurikaebankcd = new ExDBFieldString<>("zrnkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkzhurikaesitencd = new ExDBFieldString<>("zrnkzhurikaesitencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkzhurikaeyokinkbn = new ExDBFieldString<>("zrnkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnkzhurikaekouzano = new ExDBFieldString<>("zrnkzhurikaekouzano", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnoyabosyuudairitencd = new ExDBFieldString<>("zrnoyabosyuudairitencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnbsydrtenkanrisosikicd = new ExDBFieldString<>("zrnbsydrtenkanrisosikicd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnbosyuudairitengyousyukbn = new ExDBFieldString<>("zrnbosyuudairitengyousyukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnbosyuudrtennmkj = new ExDBFieldString<>("zrnbosyuudrtennmkj", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrndoujitusyoricount = new ExDBFieldString<>("zrndoujitusyoricount", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnhjnnmkj = new ExDBFieldString<>("zrnhjnnmkj", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnsyuhrkkaisuukbn = new ExDBFieldString<>("zrnsyuhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailRn, String> zrnyobiv103 = new ExDBFieldString<>("zrnyobiv103", this);
}
