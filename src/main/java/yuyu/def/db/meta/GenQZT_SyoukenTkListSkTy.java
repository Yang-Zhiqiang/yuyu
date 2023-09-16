package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyoukenTkListSkTy;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyoukenTkListSkTy extends AbstractExDBTable<ZT_SyoukenTkListSkTy> {

    public GenQZT_SyoukenTkListSkTy() {
        this("ZT_SyoukenTkListSkTy");
    }

    public GenQZT_SyoukenTkListSkTy(String pAlias) {
        super("ZT_SyoukenTkListSkTy", ZT_SyoukenTkListSkTy.class, pAlias);
    }

    public String ZT_SyoukenTkListSkTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztysyoruicd = new ExDBFieldString<>("ztysyoruicd", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytyouhyouymd = new ExDBFieldString<>("ztytyouhyouymd", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztyhassoukbn = new ExDBFieldString<>("ztyhassoukbn", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztyatesakitantnm = new ExDBFieldString<>("ztyatesakitantnm", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztyhozonkkn = new ExDBFieldString<>("ztyhozonkkn", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytyouhyouymdwa = new ExDBFieldString<>("ztytyouhyouymdwa", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztysagyoukbn = new ExDBFieldString<>("ztysagyoukbn", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztyyobiv25 = new ExDBFieldString<>("ztyyobiv25", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztyhhknnmkj = new ExDBFieldString<>("ztyhhknnmkj", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou1 = new ExDBFieldString<>("ztytksysyorinaiyou1", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou2 = new ExDBFieldString<>("ztytksysyorinaiyou2", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou3 = new ExDBFieldString<>("ztytksysyorinaiyou3", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou4 = new ExDBFieldString<>("ztytksysyorinaiyou4", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou5 = new ExDBFieldString<>("ztytksysyorinaiyou5", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou6 = new ExDBFieldString<>("ztytksysyorinaiyou6", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou7 = new ExDBFieldString<>("ztytksysyorinaiyou7", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou8 = new ExDBFieldString<>("ztytksysyorinaiyou8", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou9 = new ExDBFieldString<>("ztytksysyorinaiyou9", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou10 = new ExDBFieldString<>("ztytksysyorinaiyou10", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou11 = new ExDBFieldString<>("ztytksysyorinaiyou11", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou12 = new ExDBFieldString<>("ztytksysyorinaiyou12", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou13 = new ExDBFieldString<>("ztytksysyorinaiyou13", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztytksysyorinaiyou14 = new ExDBFieldString<>("ztytksysyorinaiyou14", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztybikouupside = new ExDBFieldString<>("ztybikouupside", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztybikoudownside = new ExDBFieldString<>("ztybikoudownside", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztyyakkanbunsyono = new ExDBFieldString<>("ztyyakkanbunsyono", this);

    public final ExDBFieldString<ZT_SyoukenTkListSkTy, String> ztyyobiv21 = new ExDBFieldString<>("ztyyobiv21", this);
}
