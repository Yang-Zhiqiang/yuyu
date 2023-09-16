package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiTr;

/**
 * オンライン外貨入出金明細テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_OnlineGknyknmeisaiTr extends AbstractExDBTable<ZT_OnlineGknyknmeisaiTr> {

    public GenQZT_OnlineGknyknmeisaiTr() {
        this("ZT_OnlineGknyknmeisaiTr");
    }

    public GenQZT_OnlineGknyknmeisaiTr(String pAlias) {
        super("ZT_OnlineGknyknmeisaiTr", ZT_OnlineGknyknmeisaiTr.class, pAlias);
    }

    public String ZT_OnlineGknyknmeisaiTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdatakbn1 = new ExDBFieldString<>("ztrdatakbn1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsyubetucd = new ExDBFieldString<>("ztrsyubetucd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrcdkbn = new ExDBFieldString<>("ztrcdkbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsakuseiymd = new ExDBFieldString<>("ztrsakuseiymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrrenrakuymd = new ExDBFieldString<>("ztrrenrakuymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrrenrakukaisuu = new ExDBFieldString<>("ztrrenrakukaisuu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrknjyymdfrom = new ExDBFieldString<>("ztrknjyymdfrom", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrknjyymdto = new ExDBFieldString<>("ztrknjyymdto", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrbankcd = new ExDBFieldString<>("ztrbankcd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrbanknmej = new ExDBFieldString<>("ztrbanknmej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsitencdtori = new ExDBFieldString<>("ztrsitencdtori", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsitennmejtori = new ExDBFieldString<>("ztrsitennmejtori", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrshitencd = new ExDBFieldString<>("ztrshitencd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsitennmej = new ExDBFieldString<>("ztrsitennmej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztryokinkbn = new ExDBFieldString<>("ztryokinkbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkouzano = new ExDBFieldString<>("ztrkouzano", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkznmej = new ExDBFieldString<>("ztrkznmej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrzndktuukasyu = new ExDBFieldString<>("ztrzndktuukasyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrzndkssketa = new ExDBFieldString<>("ztrzndkssketa", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrgktrhkmaezndk = new ExDBFieldString<>("ztrgktrhkmaezndk", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkasikosikbn = new ExDBFieldString<>("ztrkasikosikbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztryobiv86 = new ExDBFieldString<>("ztryobiv86", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdatakbn2 = new ExDBFieldString<>("ztrdatakbn2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdtrecordkbn1 = new ExDBFieldString<>("ztrdtrecordkbn1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdtrecordkousei = new ExDBFieldString<>("ztrdtrecordkousei", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsyorino1 = new ExDBFieldString<>("ztrsyorino1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrknjyymd = new ExDBFieldString<>("ztrknjyymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrksnymd = new ExDBFieldString<>("ztrksnymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztriribaraikbn = new ExDBFieldString<>("ztriribaraikbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrtrhkkbn = new ExDBFieldString<>("ztrtrhkkbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrtrhktuukasyu = new ExDBFieldString<>("ztrtrhktuukasyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrtrhkssketa = new ExDBFieldString<>("ztrtrhkssketa", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrgktrhkgk = new ExDBFieldString<>("ztrgktrhkgk", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrbanksyoukaino = new ExDBFieldString<>("ztrbanksyoukaino", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrtrhksyoukaino = new ExDBFieldString<>("ztrtrhksyoukaino", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrtekiyounaiyouej = new ExDBFieldString<>("ztrtekiyounaiyouej", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztryobiv103 = new ExDBFieldString<>("ztryobiv103", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdatakbn3 = new ExDBFieldString<>("ztrdatakbn3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdtrecordkbn2 = new ExDBFieldString<>("ztrdtrecordkbn2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdtkouseikbn = new ExDBFieldString<>("ztrdtkouseikbn", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrtrkscd = new ExDBFieldString<>("ztrtrkscd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsyorino2 = new ExDBFieldString<>("ztrsyorino2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrbanksyoukaino2 = new ExDBFieldString<>("ztrbanksyoukaino2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsimukeymd = new ExDBFieldString<>("ztrsimukeymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsetujyuymd = new ExDBFieldString<>("ztrsetujyuymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsoukinsyu = new ExDBFieldString<>("ztrsoukinsyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrvalueymd = new ExDBFieldString<>("ztrvalueymd", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrskntuukasyu = new ExDBFieldString<>("ztrskntuukasyu", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrsknssketa = new ExDBFieldString<>("ztrsknssketa", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrgksoukingk = new ExDBFieldString<>("ztrgksoukingk", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrirninnm = new ExDBFieldString<>("ztrirninnm", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztryobiv40 = new ExDBFieldString<>("ztryobiv40", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdatakbn4 = new ExDBFieldString<>("ztrdatakbn4", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdtrecordkbn3 = new ExDBFieldString<>("ztrdtrecordkbn3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdourecordsuu1 = new ExDBFieldString<>("ztrdourecordsuu1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdourecordno1 = new ExDBFieldString<>("ztrdourecordno1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahensuu1 = new ExDBFieldString<>("ztrkahensuu1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahenketa1 = new ExDBFieldString<>("ztrkahenketa1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahen1 = new ExDBFieldString<>("ztrkahen1", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdatakbn5 = new ExDBFieldString<>("ztrdatakbn5", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdtrecordkbn4 = new ExDBFieldString<>("ztrdtrecordkbn4", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdourecordsuu2 = new ExDBFieldString<>("ztrdourecordsuu2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdourecordno2 = new ExDBFieldString<>("ztrdourecordno2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahensuu2 = new ExDBFieldString<>("ztrkahensuu2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahenketa2 = new ExDBFieldString<>("ztrkahenketa2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahen2 = new ExDBFieldString<>("ztrkahen2", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdatakbn6 = new ExDBFieldString<>("ztrdatakbn6", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdtrecordkbn5 = new ExDBFieldString<>("ztrdtrecordkbn5", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdourecordsuu3 = new ExDBFieldString<>("ztrdourecordsuu3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrdourecordno3 = new ExDBFieldString<>("ztrdourecordno3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahensuu3 = new ExDBFieldString<>("ztrkahensuu3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahenketa3 = new ExDBFieldString<>("ztrkahenketa3", this);

    public final ExDBFieldString<ZT_OnlineGknyknmeisaiTr, String> ztrkahen3 = new ExDBFieldString<>("ztrkahen3", this);
}
