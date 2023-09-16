package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SiharaiTyousyoTy;

/**
 * 支払調書テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SiharaiTyousyoTy extends AbstractExDBTable<ZT_SiharaiTyousyoTy> {

    public GenQZT_SiharaiTyousyoTy() {
        this("ZT_SiharaiTyousyoTy");
    }

    public GenQZT_SiharaiTyousyoTy(String pAlias) {
        super("ZT_SiharaiTyousyoTy", ZT_SiharaiTyousyoTy.class, pAlias);
    }

    public String ZT_SiharaiTyousyoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztysubsystemid = new ExDBFieldString<>("ztysubsystemid", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykacd = new ExDBFieldString<>("ztykacd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztytantocd = new ExDBFieldString<>("ztytantocd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztysyorisosikicd = new ExDBFieldString<>("ztysyorisosikicd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyshrtysysyuruicd = new ExDBFieldString<>("ztyshrtysysyuruicd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztysyoritaisyoukbn = new ExDBFieldString<>("ztysyoritaisyoukbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztybaitaiskshunoriyuukbn1 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn1", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztybaitaiskshunoriyuukbn2 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztybaitaiskshunoriyuukbn3 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztybaitaiskshunoriyuukbn4 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn4", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztybaitaiskshunoriyuukbn5 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn5", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyshrtysyjyuusyocd = new ExDBFieldString<>("ztyshrtysyjyuusyocd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyshrtysyjyuusyo = new ExDBFieldString<>("ztyshrtysyjyuusyo", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyuktnmkj35 = new ExDBFieldString<>("ztyuktnmkj35", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztydaihyouktkbn = new ExDBFieldString<>("ztydaihyouktkbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykjdaihyouuktnm = new ExDBFieldString<>("ztykjdaihyouuktnm", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyuktmnmeigibangou = new ExDBFieldString<>("ztyuktmnmeigibangou", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv24 = new ExDBFieldString<>("ztyyobiv24", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztymfjyuusyocd = new ExDBFieldString<>("ztymfjyuusyocd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztymfjyuusyo = new ExDBFieldString<>("ztymfjyuusyo", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykyknmkj35 = new ExDBFieldString<>("ztykyknmkj35", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykykmnmeigibangou = new ExDBFieldString<>("ztykykmnmeigibangou", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyjigyoukykmndantaicd = new ExDBFieldString<>("ztyjigyoukykmndantaicd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyhhknnmkj = new ExDBFieldString<>("ztyhhknnmkj", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv17x2 = new ExDBFieldString<>("ztyyobiv17x2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyoldkykkihontikucd = new ExDBFieldString<>("ztyoldkykkihontikucd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykjoldkykkaiadr = new ExDBFieldString<>("ztykjoldkykkaiadr", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykjoldkyknm = new ExDBFieldString<>("ztykjoldkyknm", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykykhnkkaisuu = new ExDBFieldString<>("ztykykhnkkaisuu", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv23 = new ExDBFieldString<>("ztyyobiv23", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyshrymd = new ExDBFieldString<>("ztyshrymd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztysakuseiymd = new ExDBFieldString<>("ztysakuseiymd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv8x3 = new ExDBFieldString<>("ztyyobiv8x3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv8x4 = new ExDBFieldString<>("ztyyobiv8x4", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyshrgk11 = new ExDBFieldNumber<>("ztyshrgk11", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztywarimsishrgk = new ExDBFieldNumber<>("ztywarimsishrgk", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyznnphr = new ExDBFieldNumber<>("ztyznnphr", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyttkekstkganri = new ExDBFieldNumber<>("ztyttkekstkganri", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztysshkd = new ExDBFieldNumber<>("ztysshkd", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztysasihikisiharaigaku = new ExDBFieldNumber<>("ztysasihikisiharaigaku", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztymihrkmp = new ExDBFieldNumber<>("ztymihrkmp", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyshrtienrsk11 = new ExDBFieldNumber<>("ztyshrtienrsk11", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztytysyouhtykeihi = new ExDBFieldNumber<>("ztytysyouhtykeihi", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztygenkykhtykeihiyouhyj = new ExDBFieldString<>("ztygenkykhtykeihiyouhyj", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztygenkykhtykeihi = new ExDBFieldNumber<>("ztygenkykhtykeihi", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_SiharaiTyousyoTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztygensenkbn = new ExDBFieldString<>("ztygensenkbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztygensentaisyoukkngai = new ExDBFieldString<>("ztygensentaisyoukkngai", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztygensentaisyoukkn = new ExDBFieldString<>("ztygensentaisyoukkn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztymnsaiannaihnskakbn = new ExDBFieldString<>("ztymnsaiannaihnskakbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyshrhousiteikbn = new ExDBFieldString<>("ztyshrhousiteikbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyshrtysykurikosidisp = new ExDBFieldString<>("ztyshrtysykurikosidisp", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztymfadrsiyouhyouji = new ExDBFieldString<>("ztymfadrsiyouhyouji", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztynkshrhkjksyuruikbn = new ExDBFieldString<>("ztynkshrhkjksyuruikbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztynenkinkkn = new ExDBFieldString<>("ztynenkinkkn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztysynyhsjykykndisp = new ExDBFieldString<>("ztysynyhsjykykndisp", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyonlinecentercutkbn = new ExDBFieldString<>("ztyonlinecentercutkbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyhuho2kykdisp = new ExDBFieldString<>("ztyhuho2kykdisp", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyshrtysyhknsyukbn = new ExDBFieldString<>("ztyshrtysyhknsyukbn", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv9x5 = new ExDBFieldString<>("ztyyobiv9x5", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztytekiyouranhensyuukbn1 = new ExDBFieldString<>("ztytekiyouranhensyuukbn1", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztytekiyouranhensyuukbn2 = new ExDBFieldString<>("ztytekiyouranhensyuukbn2", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztytekiyouranhensyuukbn3 = new ExDBFieldString<>("ztytekiyouranhensyuukbn3", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztytekiyouranhensyuukbn4 = new ExDBFieldString<>("ztytekiyouranhensyuukbn4", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztytekiyouranhensyuukbn5 = new ExDBFieldString<>("ztytekiyouranhensyuukbn5", this);

    public final ExDBFieldString<ZT_SiharaiTyousyoTy, String> ztyyobiv181 = new ExDBFieldString<>("ztyyobiv181", this);
}
