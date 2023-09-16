package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NyknmeisaiRn;

/**
 * 入出金明細テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NyknmeisaiRn extends AbstractExDBTable<ZT_NyknmeisaiRn> {

    public GenQZT_NyknmeisaiRn() {
        this("ZT_NyknmeisaiRn");
    }

    public GenQZT_NyknmeisaiRn(String pAlias) {
        super("ZT_NyknmeisaiRn", ZT_NyknmeisaiRn.class, pAlias);
    }

    public String ZT_NyknmeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrndatakbn1 = new ExDBFieldString<>("zrndatakbn1", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnsyubetucd = new ExDBFieldString<>("zrnsyubetucd", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrncdkbn = new ExDBFieldString<>("zrncdkbn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnsakuseiymd6keta = new ExDBFieldString<>("zrnsakuseiymd6keta", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnknjyymdfrom6keta = new ExDBFieldString<>("zrnknjyymdfrom6keta", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnknjyymdto6keta = new ExDBFieldString<>("zrnknjyymdto6keta", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnbankcd = new ExDBFieldString<>("zrnbankcd", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnbanknmkn = new ExDBFieldString<>("zrnbanknmkn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnshitencd = new ExDBFieldString<>("zrnshitencd", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnsitennmkn = new ExDBFieldString<>("zrnsitennmkn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnyokinkbn = new ExDBFieldString<>("zrnyokinkbn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnkouzano = new ExDBFieldString<>("zrnkouzano", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnkznmkn = new ExDBFieldString<>("zrnkznmkn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnkasikosikbn = new ExDBFieldString<>("zrnkasikosikbn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntuutyousysykbn = new ExDBFieldString<>("zrntuutyousysykbn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntrhkmaezndk = new ExDBFieldString<>("zrntrhkmaezndk", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnyobiv63 = new ExDBFieldString<>("zrnyobiv63", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnrenno8 = new ExDBFieldString<>("zrnrenno8", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrndatakbn2 = new ExDBFieldString<>("zrndatakbn2", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnsyoukaino = new ExDBFieldString<>("zrnsyoukaino", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnknjyymd6keta = new ExDBFieldString<>("zrnknjyymd6keta", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnazkrhrdsymd6keta = new ExDBFieldString<>("zrnazkrhrdsymd6keta", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrniribaraikbn = new ExDBFieldString<>("zrniribaraikbn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntrhkkbn = new ExDBFieldString<>("zrntrhkkbn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntrhkgk = new ExDBFieldString<>("zrntrhkgk", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntatenkengk = new ExDBFieldString<>("zrntatenkengk", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnkknteijiymd6keta = new ExDBFieldString<>("zrnkknteijiymd6keta", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnhwtrhnknymd6keta = new ExDBFieldString<>("zrnhwtrhnknymd6keta", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntgtkgtkbn = new ExDBFieldString<>("zrntgtkgtkbn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntgtkgtno = new ExDBFieldString<>("zrntgtkgtno", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnryoutenno = new ExDBFieldString<>("zrnryoutenno", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnhrkmirnincd = new ExDBFieldString<>("zrnhrkmirnincd", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnhrkmirninnm = new ExDBFieldString<>("zrnhrkmirninnm", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnsimukebanknmkn = new ExDBFieldString<>("zrnsimukebanknmkn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnsimuketennmkn = new ExDBFieldString<>("zrnsimuketennmkn", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrntekiyounaiyou = new ExDBFieldString<>("zrntekiyounaiyou", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnediinfo = new ExDBFieldString<>("zrnediinfo", this);

    public final ExDBFieldString<ZT_NyknmeisaiRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);
}
