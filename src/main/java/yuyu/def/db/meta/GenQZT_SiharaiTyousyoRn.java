package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SiharaiTyousyoRn;

/**
 * 支払調書テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SiharaiTyousyoRn extends AbstractExDBTable<ZT_SiharaiTyousyoRn> {

    public GenQZT_SiharaiTyousyoRn() {
        this("ZT_SiharaiTyousyoRn");
    }

    public GenQZT_SiharaiTyousyoRn(String pAlias) {
        super("ZT_SiharaiTyousyoRn", ZT_SiharaiTyousyoRn.class, pAlias);
    }

    public String ZT_SiharaiTyousyoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnsubsystemid = new ExDBFieldString<>("zrnsubsystemid", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkacd = new ExDBFieldString<>("zrnkacd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrntantocd = new ExDBFieldString<>("zrntantocd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnsyorisosikicd = new ExDBFieldString<>("zrnsyorisosikicd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnshrtysysyuruicd = new ExDBFieldString<>("zrnshrtysysyuruicd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnsyoritaisyoukbn = new ExDBFieldString<>("zrnsyoritaisyoukbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnbaitaiskshunoriyuukbn1 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn1", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnbaitaiskshunoriyuukbn2 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnbaitaiskshunoriyuukbn3 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnbaitaiskshunoriyuukbn4 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn4", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnbaitaiskshunoriyuukbn5 = new ExDBFieldString<>("zrnbaitaiskshunoriyuukbn5", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnshrtysyjyuusyocd = new ExDBFieldString<>("zrnshrtysyjyuusyocd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnshrtysyjyuusyo = new ExDBFieldString<>("zrnshrtysyjyuusyo", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnuktnmkj35 = new ExDBFieldString<>("zrnuktnmkj35", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrndaihyouktkbn = new ExDBFieldString<>("zrndaihyouktkbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkjdaihyouuktnm = new ExDBFieldString<>("zrnkjdaihyouuktnm", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnuktmnmeigibangou = new ExDBFieldString<>("zrnuktmnmeigibangou", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv24 = new ExDBFieldString<>("zrnyobiv24", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnmfjyuusyocd = new ExDBFieldString<>("zrnmfjyuusyocd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnmfjyuusyo = new ExDBFieldString<>("zrnmfjyuusyo", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkyknmkj35 = new ExDBFieldString<>("zrnkyknmkj35", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkykmnmeigibangou = new ExDBFieldString<>("zrnkykmnmeigibangou", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnjigyoukykmndantaicd = new ExDBFieldString<>("zrnjigyoukykmndantaicd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnhhknnmkj = new ExDBFieldString<>("zrnhhknnmkj", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv17x2 = new ExDBFieldString<>("zrnyobiv17x2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnoldkykkihontikucd = new ExDBFieldString<>("zrnoldkykkihontikucd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkjoldkykkaiadr = new ExDBFieldString<>("zrnkjoldkykkaiadr", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkjoldkyknm = new ExDBFieldString<>("zrnkjoldkyknm", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkykhnkkaisuu = new ExDBFieldString<>("zrnkykhnkkaisuu", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv3x2 = new ExDBFieldString<>("zrnyobiv3x2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv23 = new ExDBFieldString<>("zrnyobiv23", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnshrymd = new ExDBFieldString<>("zrnshrymd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnsakuseiymd = new ExDBFieldString<>("zrnsakuseiymd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnkouryokuhasseiymd = new ExDBFieldString<>("zrnkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv8x3 = new ExDBFieldString<>("zrnyobiv8x3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv8x4 = new ExDBFieldString<>("zrnyobiv8x4", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnshrgk11 = new ExDBFieldNumber<>("zrnshrgk11", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnwarimsishrgk = new ExDBFieldNumber<>("zrnwarimsishrgk", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnznnphr = new ExDBFieldNumber<>("zrnznnphr", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnttkekstkganri = new ExDBFieldNumber<>("zrnttkekstkganri", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnsshkd = new ExDBFieldNumber<>("zrnsshkd", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnsasihikisiharaigaku = new ExDBFieldNumber<>("zrnsasihikisiharaigaku", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnmihrkmp = new ExDBFieldNumber<>("zrnmihrkmp", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnshrtienrsk11 = new ExDBFieldNumber<>("zrnshrtienrsk11", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrntysyouhtykeihi = new ExDBFieldNumber<>("zrntysyouhtykeihi", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrngenkykhtykeihiyouhyj = new ExDBFieldString<>("zrngenkykhtykeihiyouhyj", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrngenkykhtykeihi = new ExDBFieldNumber<>("zrngenkykhtykeihi", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrngensenkbn = new ExDBFieldString<>("zrngensenkbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrngensentaisyoukkngai = new ExDBFieldString<>("zrngensentaisyoukkngai", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrngensentaisyoukkn = new ExDBFieldString<>("zrngensentaisyoukkn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnmnsaiannaihnskakbn = new ExDBFieldString<>("zrnmnsaiannaihnskakbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnshrhousiteikbn = new ExDBFieldString<>("zrnshrhousiteikbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnshrtysykurikosidisp = new ExDBFieldString<>("zrnshrtysykurikosidisp", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnmfadrsiyouhyouji = new ExDBFieldString<>("zrnmfadrsiyouhyouji", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnnkshrhkjksyuruikbn = new ExDBFieldString<>("zrnnkshrhkjksyuruikbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnnenkinkkn = new ExDBFieldString<>("zrnnenkinkkn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnsynyhsjykykndisp = new ExDBFieldString<>("zrnsynyhsjykykndisp", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnonlinecentercutkbn = new ExDBFieldString<>("zrnonlinecentercutkbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnhuho2kykdisp = new ExDBFieldString<>("zrnhuho2kykdisp", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnshrtysyhknsyukbn = new ExDBFieldString<>("zrnshrtysyhknsyukbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv9x5 = new ExDBFieldString<>("zrnyobiv9x5", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrntekiyouranhensyuukbn1 = new ExDBFieldString<>("zrntekiyouranhensyuukbn1", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrntekiyouranhensyuukbn2 = new ExDBFieldString<>("zrntekiyouranhensyuukbn2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrntekiyouranhensyuukbn3 = new ExDBFieldString<>("zrntekiyouranhensyuukbn3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrntekiyouranhensyuukbn4 = new ExDBFieldString<>("zrntekiyouranhensyuukbn4", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrntekiyouranhensyuukbn5 = new ExDBFieldString<>("zrntekiyouranhensyuukbn5", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoRn, String> zrnyobiv181 = new ExDBFieldString<>("zrnyobiv181", this);
}
