package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiRn;

/**
 * オンライン外貨入出金明細テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_OnlineGknyknmeisaiRn extends AbstractExDBTable<ZT_OnlineGknyknmeisaiRn> {

    public GenQZT_OnlineGknyknmeisaiRn() {
        this("ZT_OnlineGknyknmeisaiRn");
    }

    public GenQZT_OnlineGknyknmeisaiRn(String pAlias) {
        super("ZT_OnlineGknyknmeisaiRn", ZT_OnlineGknyknmeisaiRn.class, pAlias);
    }

    public String ZT_OnlineGknyknmeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndatakbn1 = new ExDBFieldString<>("zrndatakbn1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsyubetucd = new ExDBFieldString<>("zrnsyubetucd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrncdkbn = new ExDBFieldString<>("zrncdkbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsakuseiymd = new ExDBFieldString<>("zrnsakuseiymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnrenrakuymd = new ExDBFieldString<>("zrnrenrakuymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnrenrakukaisuu = new ExDBFieldString<>("zrnrenrakukaisuu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnknjyymdfrom = new ExDBFieldString<>("zrnknjyymdfrom", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnknjyymdto = new ExDBFieldString<>("zrnknjyymdto", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnbankcd = new ExDBFieldString<>("zrnbankcd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnbanknmej = new ExDBFieldString<>("zrnbanknmej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsitencdtori = new ExDBFieldString<>("zrnsitencdtori", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsitennmejtori = new ExDBFieldString<>("zrnsitennmejtori", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnshitencd = new ExDBFieldString<>("zrnshitencd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsitennmej = new ExDBFieldString<>("zrnsitennmej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnyokinkbn = new ExDBFieldString<>("zrnyokinkbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkouzano = new ExDBFieldString<>("zrnkouzano", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkznmej = new ExDBFieldString<>("zrnkznmej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnzndktuukasyu = new ExDBFieldString<>("zrnzndktuukasyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnzndkssketa = new ExDBFieldString<>("zrnzndkssketa", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrngktrhkmaezndk = new ExDBFieldString<>("zrngktrhkmaezndk", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkasikosikbn = new ExDBFieldString<>("zrnkasikosikbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnyobiv86 = new ExDBFieldString<>("zrnyobiv86", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndatakbn2 = new ExDBFieldString<>("zrndatakbn2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndtrecordkbn1 = new ExDBFieldString<>("zrndtrecordkbn1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndtrecordkousei = new ExDBFieldString<>("zrndtrecordkousei", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsyorino1 = new ExDBFieldString<>("zrnsyorino1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnknjyymd = new ExDBFieldString<>("zrnknjyymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnksnymd = new ExDBFieldString<>("zrnksnymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrniribaraikbn = new ExDBFieldString<>("zrniribaraikbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrntrhkkbn = new ExDBFieldString<>("zrntrhkkbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrntrhktuukasyu = new ExDBFieldString<>("zrntrhktuukasyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrntrhkssketa = new ExDBFieldString<>("zrntrhkssketa", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrngktrhkgk = new ExDBFieldString<>("zrngktrhkgk", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnbanksyoukaino = new ExDBFieldString<>("zrnbanksyoukaino", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrntrhksyoukaino = new ExDBFieldString<>("zrntrhksyoukaino", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrntekiyounaiyouej = new ExDBFieldString<>("zrntekiyounaiyouej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnyobiv103 = new ExDBFieldString<>("zrnyobiv103", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndatakbn3 = new ExDBFieldString<>("zrndatakbn3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndtrecordkbn2 = new ExDBFieldString<>("zrndtrecordkbn2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndtkouseikbn = new ExDBFieldString<>("zrndtkouseikbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrntrkscd = new ExDBFieldString<>("zrntrkscd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsyorino2 = new ExDBFieldString<>("zrnsyorino2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnbanksyoukaino2 = new ExDBFieldString<>("zrnbanksyoukaino2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsimukeymd = new ExDBFieldString<>("zrnsimukeymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsetujyuymd = new ExDBFieldString<>("zrnsetujyuymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsoukinsyu = new ExDBFieldString<>("zrnsoukinsyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnvalueymd = new ExDBFieldString<>("zrnvalueymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnskntuukasyu = new ExDBFieldString<>("zrnskntuukasyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnsknssketa = new ExDBFieldString<>("zrnsknssketa", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrngksoukingk = new ExDBFieldString<>("zrngksoukingk", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnirninnm = new ExDBFieldString<>("zrnirninnm", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnyobiv40 = new ExDBFieldString<>("zrnyobiv40", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndatakbn4 = new ExDBFieldString<>("zrndatakbn4", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndtrecordkbn3 = new ExDBFieldString<>("zrndtrecordkbn3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndourecordsuu1 = new ExDBFieldString<>("zrndourecordsuu1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndourecordno1 = new ExDBFieldString<>("zrndourecordno1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahensuu1 = new ExDBFieldString<>("zrnkahensuu1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahenketa1 = new ExDBFieldString<>("zrnkahenketa1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahen1 = new ExDBFieldString<>("zrnkahen1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndatakbn5 = new ExDBFieldString<>("zrndatakbn5", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndtrecordkbn4 = new ExDBFieldString<>("zrndtrecordkbn4", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndourecordsuu2 = new ExDBFieldString<>("zrndourecordsuu2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndourecordno2 = new ExDBFieldString<>("zrndourecordno2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahensuu2 = new ExDBFieldString<>("zrnkahensuu2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahenketa2 = new ExDBFieldString<>("zrnkahenketa2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahen2 = new ExDBFieldString<>("zrnkahen2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndatakbn6 = new ExDBFieldString<>("zrndatakbn6", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndtrecordkbn5 = new ExDBFieldString<>("zrndtrecordkbn5", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndourecordsuu3 = new ExDBFieldString<>("zrndourecordsuu3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrndourecordno3 = new ExDBFieldString<>("zrndourecordno3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahensuu3 = new ExDBFieldString<>("zrnkahensuu3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahenketa3 = new ExDBFieldString<>("zrnkahenketa3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiRn, String> zrnkahen3 = new ExDBFieldString<>("zrnkahen3", this);
}
