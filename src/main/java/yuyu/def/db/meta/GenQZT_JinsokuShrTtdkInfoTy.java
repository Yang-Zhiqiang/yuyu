package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoTy;

/**
 * 迅速支払手続情報テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_JinsokuShrTtdkInfoTy extends AbstractExDBTable<ZT_JinsokuShrTtdkInfoTy> {

    public GenQZT_JinsokuShrTtdkInfoTy() {
        this("ZT_JinsokuShrTtdkInfoTy");
    }

    public GenQZT_JinsokuShrTtdkInfoTy(String pAlias) {
        super("ZT_JinsokuShrTtdkInfoTy", ZT_JinsokuShrTtdkInfoTy.class, pAlias);
    }

    public String ZT_JinsokuShrTtdkInfoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztysyorisosikicd = new ExDBFieldString<>("ztysyorisosikicd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztyhknknshrsntkno = new ExDBFieldString<>("ztyhknknshrsntkno", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztysyoruiukeymd = new ExDBFieldString<>("ztysyoruiukeymd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztysyoriymd = new ExDBFieldString<>("ztysyoriymd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztysyoruikeikaeigyoubisuu = new ExDBFieldString<>("ztysyoruikeikaeigyoubisuu", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztysyorikeikaeigyoubisuu = new ExDBFieldString<>("ztysyorikeikaeigyoubisuu", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztytoritugisosikicd = new ExDBFieldString<>("ztytoritugisosikicd", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztytanmatusyuruikbn = new ExDBFieldString<>("ztytanmatusyuruikbn", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_JinsokuShrTtdkInfoTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);
}
