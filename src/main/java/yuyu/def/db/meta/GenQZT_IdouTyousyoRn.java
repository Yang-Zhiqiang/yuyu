package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_IdouTyousyoRn;

/**
 * 異動調書テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IdouTyousyoRn extends AbstractExDBTable<ZT_IdouTyousyoRn> {

    public GenQZT_IdouTyousyoRn() {
        this("ZT_IdouTyousyoRn");
    }

    public GenQZT_IdouTyousyoRn(String pAlias) {
        super("ZT_IdouTyousyoRn", ZT_IdouTyousyoRn.class, pAlias);
    }

    public String ZT_IdouTyousyoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnsubsystemid = new ExDBFieldString<>("zrnsubsystemid", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnkacd = new ExDBFieldString<>("zrnkacd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrntantocd = new ExDBFieldString<>("zrntantocd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnsyorisosikicd = new ExDBFieldString<>("zrnsyorisosikicd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnshrtysysyuruicd = new ExDBFieldString<>("zrnshrtysysyuruicd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnsyoritaisyoukbn = new ExDBFieldString<>("zrnsyoritaisyoukbn", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnbaitaiskshunoriyuukbn1 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn1", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnbaitaiskshunoriyuukbn2 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn2", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnbaitaiskshunoriyuukbn3 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn3", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnbaitaiskshunoriyuukbn4 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn4", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnbaitaiskshunoriyuukbn5 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn5", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnshrtysyjyuusyocd = new ExDBFieldString<>("zrnshrtysyjyuusyocd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnshrtysyjyuusyo = new ExDBFieldString<>("zrnshrtysyjyuusyo", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnkyknmkj35 = new ExDBFieldString<>("zrnkyknmkj35", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv25 = new ExDBFieldString<>("zrnyobiv25", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnoldkykadrcd = new ExDBFieldString<>("zrnoldkykadrcd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnkjoldkykadr = new ExDBFieldString<>("zrnkjoldkykadr", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnkjoldkyknm35 = new ExDBFieldString<>("zrnkjoldkyknm35", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv3x2 = new ExDBFieldString<>("zrnyobiv3x2", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv25x1 = new ExDBFieldString<>("zrnyobiv25x1", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnhhknnmkj = new ExDBFieldString<>("zrnhhknnmkj", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv3x3 = new ExDBFieldString<>("zrnyobiv3x3", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnkyksibouymd = new ExDBFieldString<>("zrnkyksibouymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnkouryokuhasseiymd = new ExDBFieldString<>("zrnkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnkyksiboumeihensyoriymd = new ExDBFieldString<>("zrnkyksiboumeihensyoriymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv8x3 = new ExDBFieldString<>("zrnyobiv8x3", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv8x4 = new ExDBFieldString<>("zrnyobiv8x4", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Long> zrnkyksibouhyoukagk = new ExDBFieldNumber<>("zrnkyksibouhyoukagk", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Long> zrnkihrkmp = new ExDBFieldNumber<>("zrnkihrkmp", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnoldkykkihrkmpyouhyj = new ExDBFieldString<>("zrnoldkykkihrkmpyouhyj", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Long> zrnoldkykkihrkmp = new ExDBFieldNumber<>("zrnoldkykkihrkmp", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnsakuseiymd = new ExDBFieldString<>("zrnsakuseiymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnhuho2kykdisp = new ExDBFieldString<>("zrnhuho2kykdisp", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnshrtysyhknsyukbn = new ExDBFieldString<>("zrnshrtysyhknsyukbn", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrntekiyouranhensyuukbn1 = new ExDBFieldString<>("zrntekiyouranhensyuukbn1", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrntekiyouranhensyuukbn2 = new ExDBFieldString<>("zrntekiyouranhensyuukbn2", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrntekiyouranhensyuukbn3 = new ExDBFieldString<>("zrntekiyouranhensyuukbn3", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrntekiyouranhensyuukbn4 = new ExDBFieldString<>("zrntekiyouranhensyuukbn4", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrntekiyouranhensyuukbn5 = new ExDBFieldString<>("zrntekiyouranhensyuukbn5", this);

    public final ExDBFieldString<ZT_IdouTyousyoRn, String> zrnyobiv116 = new ExDBFieldString<>("zrnyobiv116", this);
}
