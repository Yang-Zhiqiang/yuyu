package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;

/**
 * 外貨入出金明細テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_GknyknmeisaiTr extends AbstractExDBTable<ZT_GknyknmeisaiTr> {

    public GenQZT_GknyknmeisaiTr() {
        this("ZT_GknyknmeisaiTr");
    }

    public GenQZT_GknyknmeisaiTr(String pAlias) {
        super("ZT_GknyknmeisaiTr", ZT_GknyknmeisaiTr.class, pAlias);
    }

    public String ZT_GknyknmeisaiTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdatakbn1 = new ExDBFieldString<>("ztrdatakbn1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsyubetucd = new ExDBFieldString<>("ztrsyubetucd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrcdkbn = new ExDBFieldString<>("ztrcdkbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsakuseiymd = new ExDBFieldString<>("ztrsakuseiymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrrenrakuymd = new ExDBFieldString<>("ztrrenrakuymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrrenrakukaisuu = new ExDBFieldString<>("ztrrenrakukaisuu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrknjyymdfrom = new ExDBFieldString<>("ztrknjyymdfrom", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrknjyymdto = new ExDBFieldString<>("ztrknjyymdto", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrbankcd = new ExDBFieldString<>("ztrbankcd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrbanknmej = new ExDBFieldString<>("ztrbanknmej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsitencdtori = new ExDBFieldString<>("ztrsitencdtori", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsitennmejtori = new ExDBFieldString<>("ztrsitennmejtori", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrshitencd = new ExDBFieldString<>("ztrshitencd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsitennmej = new ExDBFieldString<>("ztrsitennmej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztryokinkbn = new ExDBFieldString<>("ztryokinkbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkouzano = new ExDBFieldString<>("ztrkouzano", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkznmej = new ExDBFieldString<>("ztrkznmej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrzndktuukasyu = new ExDBFieldString<>("ztrzndktuukasyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrzndkssketa = new ExDBFieldString<>("ztrzndkssketa", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrgktrhkmaezndk = new ExDBFieldString<>("ztrgktrhkmaezndk", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkasikosikbn = new ExDBFieldString<>("ztrkasikosikbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztryobiv86 = new ExDBFieldString<>("ztryobiv86", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdatakbn2 = new ExDBFieldString<>("ztrdatakbn2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdtrecordkbn1 = new ExDBFieldString<>("ztrdtrecordkbn1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdtrecordkousei = new ExDBFieldString<>("ztrdtrecordkousei", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsyorino1 = new ExDBFieldString<>("ztrsyorino1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrknjyymd = new ExDBFieldString<>("ztrknjyymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrksnymd = new ExDBFieldString<>("ztrksnymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztriribaraikbn = new ExDBFieldString<>("ztriribaraikbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrtrhkkbn = new ExDBFieldString<>("ztrtrhkkbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrtrhktuukasyu = new ExDBFieldString<>("ztrtrhktuukasyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrtrhkssketa = new ExDBFieldString<>("ztrtrhkssketa", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrgktrhkgk = new ExDBFieldString<>("ztrgktrhkgk", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrbanksyoukaino = new ExDBFieldString<>("ztrbanksyoukaino", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrtrhksyoukaino = new ExDBFieldString<>("ztrtrhksyoukaino", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrtekiyounaiyouej = new ExDBFieldString<>("ztrtekiyounaiyouej", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztryobiv103 = new ExDBFieldString<>("ztryobiv103", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdatakbn3 = new ExDBFieldString<>("ztrdatakbn3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdtrecordkbn2 = new ExDBFieldString<>("ztrdtrecordkbn2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdtkouseikbn = new ExDBFieldString<>("ztrdtkouseikbn", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrtrkscd = new ExDBFieldString<>("ztrtrkscd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsyorino2 = new ExDBFieldString<>("ztrsyorino2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrbanksyoukaino2 = new ExDBFieldString<>("ztrbanksyoukaino2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsimukeymd = new ExDBFieldString<>("ztrsimukeymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsetujyuymd = new ExDBFieldString<>("ztrsetujyuymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsoukinsyu = new ExDBFieldString<>("ztrsoukinsyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrvalueymd = new ExDBFieldString<>("ztrvalueymd", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrskntuukasyu = new ExDBFieldString<>("ztrskntuukasyu", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrsknssketa = new ExDBFieldString<>("ztrsknssketa", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrgksoukingk = new ExDBFieldString<>("ztrgksoukingk", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrirninnm = new ExDBFieldString<>("ztrirninnm", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztryobiv40 = new ExDBFieldString<>("ztryobiv40", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdatakbn4 = new ExDBFieldString<>("ztrdatakbn4", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdtrecordkbn3 = new ExDBFieldString<>("ztrdtrecordkbn3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdourecordsuu1 = new ExDBFieldString<>("ztrdourecordsuu1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdourecordno1 = new ExDBFieldString<>("ztrdourecordno1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahensuu1 = new ExDBFieldString<>("ztrkahensuu1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahenketa1 = new ExDBFieldString<>("ztrkahenketa1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahen1 = new ExDBFieldString<>("ztrkahen1", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdatakbn5 = new ExDBFieldString<>("ztrdatakbn5", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdtrecordkbn4 = new ExDBFieldString<>("ztrdtrecordkbn4", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdourecordsuu2 = new ExDBFieldString<>("ztrdourecordsuu2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdourecordno2 = new ExDBFieldString<>("ztrdourecordno2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahensuu2 = new ExDBFieldString<>("ztrkahensuu2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahenketa2 = new ExDBFieldString<>("ztrkahenketa2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahen2 = new ExDBFieldString<>("ztrkahen2", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdatakbn6 = new ExDBFieldString<>("ztrdatakbn6", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdtrecordkbn5 = new ExDBFieldString<>("ztrdtrecordkbn5", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdourecordsuu3 = new ExDBFieldString<>("ztrdourecordsuu3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrdourecordno3 = new ExDBFieldString<>("ztrdourecordno3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahensuu3 = new ExDBFieldString<>("ztrkahensuu3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahenketa3 = new ExDBFieldString<>("ztrkahenketa3", this);

    public final ExDBFieldString<ZT_GknyknmeisaiTr, String> ztrkahen3 = new ExDBFieldString<>("ztrkahen3", this);
}
