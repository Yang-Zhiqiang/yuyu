package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_HknkykIdouInfoRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 保険契約異動情報テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HknkykIdouInfoRn extends AbstractExDBTable<ZT_HknkykIdouInfoRn> {

    public GenQZT_HknkykIdouInfoRn() {
        this("ZT_HknkykIdouInfoRn");
    }

    public GenQZT_HknkykIdouInfoRn(String pAlias) {
        super("ZT_HknkykIdouInfoRn", ZT_HknkykIdouInfoRn.class, pAlias);
    }

    public String ZT_HknkykIdouInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnkyktuukasyu = new ExDBFieldString<>("zrnkyktuukasyu", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnidouymd = new ExDBFieldString<>("zrnidouymd", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnidoujiyuukbnzfi = new ExDBFieldString<>("zrnidoujiyuukbnzfi", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnrenno = new ExDBFieldString<>("zrnrenno", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnhhknnen2 = new ExDBFieldString<>("zrnhhknnen2", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnhhknsei = new ExDBFieldString<>("zrnhhknsei", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnaisyoumeikbn = new ExDBFieldString<>("zrnaisyoumeikbn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnzougenkbn = new ExDBFieldString<>("zrnzougenkbn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnhokenkngk13 = new ExDBFieldString<>("zrnhokenkngk13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnp13 = new ExDBFieldString<>("zrnp13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnptumitatekin13 = new ExDBFieldString<>("zrnptumitatekin13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnkiykhnrikn13 = new ExDBFieldString<>("zrnkiykhnrikn13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnidouhokenkngk = new ExDBFieldString<>("zrnidouhokenkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnidoup = new ExDBFieldString<>("zrnidoup", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnidouptumitatekin = new ExDBFieldString<>("zrnidouptumitatekin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnidoukiykhnrikn = new ExDBFieldString<>("zrnidoukiykhnrikn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, BizNumber> zrnyoteiriritun5 = new ExDBFieldString<>("zrnyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrntumitatekinkbn = new ExDBFieldString<>("zrntumitatekinkbn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoRn, String> zrnharaikatakbnkykidou = new ExDBFieldString<>("zrnharaikatakbnkykidou", this);
}
