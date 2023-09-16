package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KessanZennouFTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 決算用前納Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KessanZennouFTy extends AbstractExDBTable<ZT_KessanZennouFTy> {

    public GenQZT_KessanZennouFTy() {
        this("ZT_KessanZennouFTy");
    }

    public GenQZT_KessanZennouFTy(String pAlias) {
        super("ZT_KessanZennouFTy", ZT_KessanZennouFTy.class, pAlias);
    }

    public String ZT_KessanZennouFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztykbnkeiriyousegmentcd = new ExDBFieldString<>("ztykbnkeiriyousegmentcd", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyzennoutoukeilistkbn = new ExDBFieldString<>("ztyzennoutoukeilistkbn", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyzennoukbn = new ExDBFieldString<>("ztyzennoukbn", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyzennoukaisiymd = new ExDBFieldString<>("ztyzennoukaisiymd", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyzennoukaisijizndk = new ExDBFieldNumber<>("ztyzennoukaisijizndk", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztyzennouwrbkrt = new ExDBFieldString<>("ztyzennouwrbkrt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk1 = new ExDBFieldNumber<>("ztyrthndzndk1", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztytkyrt1 = new ExDBFieldString<>("ztytkyrt1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyrthndymd1 = new ExDBFieldString<>("ztyrthndymd1", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk2 = new ExDBFieldNumber<>("ztyrthndzndk2", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztytkyrt2 = new ExDBFieldString<>("ztytkyrt2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyrthndymd2 = new ExDBFieldString<>("ztyrthndymd2", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk3 = new ExDBFieldNumber<>("ztyrthndzndk3", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztytkyrt3 = new ExDBFieldString<>("ztytkyrt3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyrthndymd3 = new ExDBFieldString<>("ztyrthndymd3", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk4 = new ExDBFieldNumber<>("ztyrthndzndk4", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztytkyrt4 = new ExDBFieldString<>("ztytkyrt4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyrthndymd4 = new ExDBFieldString<>("ztyrthndymd4", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztytndmatuzndk = new ExDBFieldNumber<>("ztytndmatuzndk", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztytndmatutkyrt = new ExDBFieldString<>("ztytndmatutkyrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyzennounyuukinymd = new ExDBFieldString<>("ztyzennounyuukinymd", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztytndzndkhikakukbn = new ExDBFieldString<>("ztytndzndkhikakukbn", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyzennoukikan = new ExDBFieldString<>("ztyzennoukikan", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyyobi01xv1 = new ExDBFieldString<>("ztyyobi01xv1", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyyobi02xv11 = new ExDBFieldString<>("ztyyobi02xv11", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztygkdtznnhyj = new ExDBFieldString<>("ztygkdtznnhyj", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyyenkanyknhyj = new ExDBFieldString<>("ztyyenkanyknhyj", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztynyknjikawaserate = new ExDBFieldString<>("ztynyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztynyknjikawaseratetkyuymd = new ExDBFieldString<>("ztynyknjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztyksnkisikawaserate = new ExDBFieldString<>("ztyksnkisikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFTy, BizNumber> ztytndmatuzndkksnjkwsrate = new ExDBFieldString<>("ztytndmatuzndkksnjkwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyzennounyuukinkgkgaika = new ExDBFieldNumber<>("ztyzennounyuukinkgkgaika", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyzennounyuukinkgktkmatu = new ExDBFieldNumber<>("ztyzennounyuukinkgktkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyzennoukaisijizndktkmatu = new ExDBFieldNumber<>("ztyzennoukaisijizndktkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk1tkmatu = new ExDBFieldNumber<>("ztyrthndzndk1tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk2tkmatu = new ExDBFieldNumber<>("ztyrthndzndk2tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk3tkmatu = new ExDBFieldNumber<>("ztyrthndzndk3tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyrthndzndk4tkmatu = new ExDBFieldNumber<>("ztyrthndzndk4tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztytndmatuzndktkmatu = new ExDBFieldNumber<>("ztytndmatuzndktkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_KessanZennouFTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_KessanZennouFTy, String> ztyyobiv22 = new ExDBFieldString<>("ztyyobiv22", this);
}
