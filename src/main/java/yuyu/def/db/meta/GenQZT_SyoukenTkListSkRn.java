package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyoukenTkListSkRn;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyoukenTkListSkRn extends AbstractExDBTable<ZT_SyoukenTkListSkRn> {

    public GenQZT_SyoukenTkListSkRn() {
        this("ZT_SyoukenTkListSkRn");
    }

    public GenQZT_SyoukenTkListSkRn(String pAlias) {
        super("ZT_SyoukenTkListSkRn", ZT_SyoukenTkListSkRn.class, pAlias);
    }

    public String ZT_SyoukenTkListSkRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnsyoruicd = new ExDBFieldString<>("zrnsyoruicd", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntyouhyouymd = new ExDBFieldString<>("zrntyouhyouymd", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnhassoukbn = new ExDBFieldString<>("zrnhassoukbn", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnatesakitantnm = new ExDBFieldString<>("zrnatesakitantnm", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnhozonkkn = new ExDBFieldString<>("zrnhozonkkn", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntyouhyouymdwa = new ExDBFieldString<>("zrntyouhyouymdwa", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnsagyoukbn = new ExDBFieldString<>("zrnsagyoukbn", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnyobiv25 = new ExDBFieldString<>("zrnyobiv25", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnhhknnmkj = new ExDBFieldString<>("zrnhhknnmkj", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou1 = new ExDBFieldString<>("zrntksysyorinaiyou1", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou2 = new ExDBFieldString<>("zrntksysyorinaiyou2", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou3 = new ExDBFieldString<>("zrntksysyorinaiyou3", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou4 = new ExDBFieldString<>("zrntksysyorinaiyou4", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou5 = new ExDBFieldString<>("zrntksysyorinaiyou5", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou6 = new ExDBFieldString<>("zrntksysyorinaiyou6", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou7 = new ExDBFieldString<>("zrntksysyorinaiyou7", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou8 = new ExDBFieldString<>("zrntksysyorinaiyou8", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou9 = new ExDBFieldString<>("zrntksysyorinaiyou9", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou10 = new ExDBFieldString<>("zrntksysyorinaiyou10", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou11 = new ExDBFieldString<>("zrntksysyorinaiyou11", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou12 = new ExDBFieldString<>("zrntksysyorinaiyou12", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou13 = new ExDBFieldString<>("zrntksysyorinaiyou13", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrntksysyorinaiyou14 = new ExDBFieldString<>("zrntksysyorinaiyou14", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnbikouupside = new ExDBFieldString<>("zrnbikouupside", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnbikoudownside = new ExDBFieldString<>("zrnbikoudownside", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnyakkanbunsyono = new ExDBFieldString<>("zrnyakkanbunsyono", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkRn, String> zrnyobiv21 = new ExDBFieldString<>("zrnyobiv21", this);
}
