package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_GknyknmeisaiRn;

/**
 * 外貨入出金明細テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_GknyknmeisaiRn extends AbstractExDBTable<ZT_GknyknmeisaiRn> {

    public GenQZT_GknyknmeisaiRn() {
        this("ZT_GknyknmeisaiRn");
    }

    public GenQZT_GknyknmeisaiRn(String pAlias) {
        super("ZT_GknyknmeisaiRn", ZT_GknyknmeisaiRn.class, pAlias);
    }

    public String ZT_GknyknmeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndatakbn1 = new ExDBFieldString<>("zrndatakbn1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsyubetucd = new ExDBFieldString<>("zrnsyubetucd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrncdkbn = new ExDBFieldString<>("zrncdkbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsakuseiymd = new ExDBFieldString<>("zrnsakuseiymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnrenrakuymd = new ExDBFieldString<>("zrnrenrakuymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnrenrakukaisuu = new ExDBFieldString<>("zrnrenrakukaisuu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnknjyymdfrom = new ExDBFieldString<>("zrnknjyymdfrom", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnknjyymdto = new ExDBFieldString<>("zrnknjyymdto", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnbankcd = new ExDBFieldString<>("zrnbankcd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnbanknmej = new ExDBFieldString<>("zrnbanknmej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsitencdtori = new ExDBFieldString<>("zrnsitencdtori", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsitennmejtori = new ExDBFieldString<>("zrnsitennmejtori", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnshitencd = new ExDBFieldString<>("zrnshitencd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsitennmej = new ExDBFieldString<>("zrnsitennmej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnyokinkbn = new ExDBFieldString<>("zrnyokinkbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkouzano = new ExDBFieldString<>("zrnkouzano", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkznmej = new ExDBFieldString<>("zrnkznmej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnzndktuukasyu = new ExDBFieldString<>("zrnzndktuukasyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnzndkssketa = new ExDBFieldString<>("zrnzndkssketa", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrngktrhkmaezndk = new ExDBFieldString<>("zrngktrhkmaezndk", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkasikosikbn = new ExDBFieldString<>("zrnkasikosikbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnyobiv86 = new ExDBFieldString<>("zrnyobiv86", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndatakbn2 = new ExDBFieldString<>("zrndatakbn2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndtrecordkbn1 = new ExDBFieldString<>("zrndtrecordkbn1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndtrecordkousei = new ExDBFieldString<>("zrndtrecordkousei", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsyorino1 = new ExDBFieldString<>("zrnsyorino1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnknjyymd = new ExDBFieldString<>("zrnknjyymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnksnymd = new ExDBFieldString<>("zrnksnymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrniribaraikbn = new ExDBFieldString<>("zrniribaraikbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrntrhkkbn = new ExDBFieldString<>("zrntrhkkbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrntrhktuukasyu = new ExDBFieldString<>("zrntrhktuukasyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrntrhkssketa = new ExDBFieldString<>("zrntrhkssketa", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrngktrhkgk = new ExDBFieldString<>("zrngktrhkgk", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnbanksyoukaino = new ExDBFieldString<>("zrnbanksyoukaino", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrntrhksyoukaino = new ExDBFieldString<>("zrntrhksyoukaino", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrntekiyounaiyouej = new ExDBFieldString<>("zrntekiyounaiyouej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnyobiv103 = new ExDBFieldString<>("zrnyobiv103", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndatakbn3 = new ExDBFieldString<>("zrndatakbn3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndtrecordkbn2 = new ExDBFieldString<>("zrndtrecordkbn2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndtkouseikbn = new ExDBFieldString<>("zrndtkouseikbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrntrkscd = new ExDBFieldString<>("zrntrkscd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsyorino2 = new ExDBFieldString<>("zrnsyorino2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnbanksyoukaino2 = new ExDBFieldString<>("zrnbanksyoukaino2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsimukeymd = new ExDBFieldString<>("zrnsimukeymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsetujyuymd = new ExDBFieldString<>("zrnsetujyuymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsoukinsyu = new ExDBFieldString<>("zrnsoukinsyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnvalueymd = new ExDBFieldString<>("zrnvalueymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnskntuukasyu = new ExDBFieldString<>("zrnskntuukasyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnsknssketa = new ExDBFieldString<>("zrnsknssketa", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrngksoukingk = new ExDBFieldString<>("zrngksoukingk", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnirninnm = new ExDBFieldString<>("zrnirninnm", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnyobiv40 = new ExDBFieldString<>("zrnyobiv40", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndatakbn4 = new ExDBFieldString<>("zrndatakbn4", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndtrecordkbn3 = new ExDBFieldString<>("zrndtrecordkbn3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndourecordsuu1 = new ExDBFieldString<>("zrndourecordsuu1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndourecordno1 = new ExDBFieldString<>("zrndourecordno1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahensuu1 = new ExDBFieldString<>("zrnkahensuu1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahenketa1 = new ExDBFieldString<>("zrnkahenketa1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahen1 = new ExDBFieldString<>("zrnkahen1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndatakbn5 = new ExDBFieldString<>("zrndatakbn5", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndtrecordkbn4 = new ExDBFieldString<>("zrndtrecordkbn4", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndourecordsuu2 = new ExDBFieldString<>("zrndourecordsuu2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndourecordno2 = new ExDBFieldString<>("zrndourecordno2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahensuu2 = new ExDBFieldString<>("zrnkahensuu2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahenketa2 = new ExDBFieldString<>("zrnkahenketa2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahen2 = new ExDBFieldString<>("zrnkahen2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndatakbn6 = new ExDBFieldString<>("zrndatakbn6", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndtrecordkbn5 = new ExDBFieldString<>("zrndtrecordkbn5", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndourecordsuu3 = new ExDBFieldString<>("zrndourecordsuu3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrndourecordno3 = new ExDBFieldString<>("zrndourecordno3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahensuu3 = new ExDBFieldString<>("zrnkahensuu3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahenketa3 = new ExDBFieldString<>("zrnkahenketa3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiRn, String> zrnkahen3 = new ExDBFieldString<>("zrnkahen3", this);
}
