package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KessanZennouFRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 決算用前納Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KessanZennouFRn extends AbstractExDBTable<ZT_KessanZennouFRn> {

    public GenQZT_KessanZennouFRn() {
        this("ZT_KessanZennouFRn");
    }

    public GenQZT_KessanZennouFRn(String pAlias) {
        super("ZT_KessanZennouFRn", ZT_KessanZennouFRn.class, pAlias);
    }

    public String ZT_KessanZennouFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnkbnkeiriyousegmentcd = new ExDBFieldString<>("zrnkbnkeiriyousegmentcd", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnzennoutoukeilistkbn = new ExDBFieldString<>("zrnzennoutoukeilistkbn", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnzennoukbn = new ExDBFieldString<>("zrnzennoukbn", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnzennoukaisiymd = new ExDBFieldString<>("zrnzennoukaisiymd", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnzennoukaisijizndk = new ExDBFieldNumber<>("zrnzennoukaisijizndk", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrnzennouwrbkrt = new ExDBFieldString<>("zrnzennouwrbkrt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk1 = new ExDBFieldNumber<>("zrnrthndzndk1", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrntkyrt1 = new ExDBFieldString<>("zrntkyrt1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnrthndymd1 = new ExDBFieldString<>("zrnrthndymd1", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk2 = new ExDBFieldNumber<>("zrnrthndzndk2", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrntkyrt2 = new ExDBFieldString<>("zrntkyrt2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnrthndymd2 = new ExDBFieldString<>("zrnrthndymd2", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk3 = new ExDBFieldNumber<>("zrnrthndzndk3", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrntkyrt3 = new ExDBFieldString<>("zrntkyrt3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnrthndymd3 = new ExDBFieldString<>("zrnrthndymd3", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk4 = new ExDBFieldNumber<>("zrnrthndzndk4", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrntkyrt4 = new ExDBFieldString<>("zrntkyrt4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnrthndymd4 = new ExDBFieldString<>("zrnrthndymd4", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrntndmatuzndk = new ExDBFieldNumber<>("zrntndmatuzndk", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrntndmatutkyrt = new ExDBFieldString<>("zrntndmatutkyrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnzennounyuukinymd = new ExDBFieldString<>("zrnzennounyuukinymd", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrntndzndkhikakukbn = new ExDBFieldString<>("zrntndzndkhikakukbn", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnzennoukikan = new ExDBFieldString<>("zrnzennoukikan", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnyobi01xv1 = new ExDBFieldString<>("zrnyobi01xv1", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnyobi02xv11 = new ExDBFieldString<>("zrnyobi02xv11", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrngkdtznnhyj = new ExDBFieldString<>("zrngkdtznnhyj", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnyenkanyknhyj = new ExDBFieldString<>("zrnyenkanyknhyj", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrnnyknjikawaserate = new ExDBFieldString<>("zrnnyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnnyknjikawaseratetkyuymd = new ExDBFieldString<>("zrnnyknjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrnksnkisikawaserate = new ExDBFieldString<>("zrnksnkisikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KessanZennouFRn, BizNumber> zrntndmatuzndkksnjkwsrate = new ExDBFieldString<>("zrntndmatuzndkksnjkwsrate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnzennounyuukinkgkgaika = new ExDBFieldNumber<>("zrnzennounyuukinkgkgaika", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnzennounyuukinkgktkmatu = new ExDBFieldNumber<>("zrnzennounyuukinkgktkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnzennoukaisijizndktkmatu = new ExDBFieldNumber<>("zrnzennoukaisijizndktkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk1tkmatu = new ExDBFieldNumber<>("zrnrthndzndk1tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk2tkmatu = new ExDBFieldNumber<>("zrnrthndzndk2tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk3tkmatu = new ExDBFieldNumber<>("zrnrthndzndk3tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnrthndzndk4tkmatu = new ExDBFieldNumber<>("zrnrthndzndk4tkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrntndmatuzndktkmatu = new ExDBFieldNumber<>("zrntndmatuzndktkmatu", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_KessanZennouFRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldString<ZT_KessanZennouFRn, String> zrnyobiv22 = new ExDBFieldString<>("zrnyobiv22", this);
}
