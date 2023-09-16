package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_IdouTyousyoTy;

/**
 * 異動調書テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IdouTyousyoTy extends AbstractExDBTable<ZT_IdouTyousyoTy> {

    public GenQZT_IdouTyousyoTy() {
        this("ZT_IdouTyousyoTy");
    }

    public GenQZT_IdouTyousyoTy(String pAlias) {
        super("ZT_IdouTyousyoTy", ZT_IdouTyousyoTy.class, pAlias);
    }

    public String ZT_IdouTyousyoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztysubsystemid = new ExDBFieldString<>("ztysubsystemid", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztykacd = new ExDBFieldString<>("ztykacd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztytantocd = new ExDBFieldString<>("ztytantocd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztysyorisosikicd = new ExDBFieldString<>("ztysyorisosikicd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyshrtysysyuruicd = new ExDBFieldString<>("ztyshrtysysyuruicd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztysyoritaisyoukbn = new ExDBFieldString<>("ztysyoritaisyoukbn", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztybaitaiskshunoriyuukbn1 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn1", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztybaitaiskshunoriyuukbn2 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn2", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztybaitaiskshunoriyuukbn3 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn3", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztybaitaiskshunoriyuukbn4 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn4", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztybaitaiskshunoriyuukbn5 = new ExDBFieldString<>("ztybaitaiskshunoriyuukbn5", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyshrtysyjyuusyocd = new ExDBFieldString<>("ztyshrtysyjyuusyocd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyshrtysyjyuusyo = new ExDBFieldString<>("ztyshrtysyjyuusyo", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztykyknmkj35 = new ExDBFieldString<>("ztykyknmkj35", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv25 = new ExDBFieldString<>("ztyyobiv25", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyoldkykadrcd = new ExDBFieldString<>("ztyoldkykadrcd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztykjoldkykadr = new ExDBFieldString<>("ztykjoldkykadr", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztykjoldkyknm35 = new ExDBFieldString<>("ztykjoldkyknm35", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv25x1 = new ExDBFieldString<>("ztyyobiv25x1", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyhhknnmkj = new ExDBFieldString<>("ztyhhknnmkj", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv3x3 = new ExDBFieldString<>("ztyyobiv3x3", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztykyksibouymd = new ExDBFieldString<>("ztykyksibouymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztykyksiboumeihensyoriymd = new ExDBFieldString<>("ztykyksiboumeihensyoriymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv8x3 = new ExDBFieldString<>("ztyyobiv8x3", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv8x4 = new ExDBFieldString<>("ztyyobiv8x4", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Long> ztykyksibouhyoukagk = new ExDBFieldNumber<>("ztykyksibouhyoukagk", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Long> ztykihrkmp = new ExDBFieldNumber<>("ztykihrkmp", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyoldkykkihrkmpyouhyj = new ExDBFieldString<>("ztyoldkykkihrkmpyouhyj", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Long> ztyoldkykkihrkmp = new ExDBFieldNumber<>("ztyoldkykkihrkmp", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_IdouTyousyoTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztysakuseiymd = new ExDBFieldString<>("ztysakuseiymd", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyhuho2kykdisp = new ExDBFieldString<>("ztyhuho2kykdisp", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyshrtysyhknsyukbn = new ExDBFieldString<>("ztyshrtysyhknsyukbn", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztytekiyouranhensyuukbn1 = new ExDBFieldString<>("ztytekiyouranhensyuukbn1", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztytekiyouranhensyuukbn2 = new ExDBFieldString<>("ztytekiyouranhensyuukbn2", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztytekiyouranhensyuukbn3 = new ExDBFieldString<>("ztytekiyouranhensyuukbn3", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztytekiyouranhensyuukbn4 = new ExDBFieldString<>("ztytekiyouranhensyuukbn4", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztytekiyouranhensyuukbn5 = new ExDBFieldString<>("ztytekiyouranhensyuukbn5", this);

    public final ExDBFieldString<ZT_IdouTyousyoTy, String> ztyyobiv116 = new ExDBFieldString<>("ztyyobiv116", this);
}
