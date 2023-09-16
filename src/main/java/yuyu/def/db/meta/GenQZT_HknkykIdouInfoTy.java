package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_HknkykIdouInfoTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 保険契約異動情報テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_HknkykIdouInfoTy extends AbstractExDBTable<ZT_HknkykIdouInfoTy> {

    public GenQZT_HknkykIdouInfoTy() {
        this("ZT_HknkykIdouInfoTy");
    }

    public GenQZT_HknkykIdouInfoTy(String pAlias) {
        super("ZT_HknkykIdouInfoTy", ZT_HknkykIdouInfoTy.class, pAlias);
    }

    public String ZT_HknkykIdouInfoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztykyktuukasyu = new ExDBFieldString<>("ztykyktuukasyu", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyidouymd = new ExDBFieldString<>("ztyidouymd", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyidoujiyuukbnzfi = new ExDBFieldString<>("ztyidoujiyuukbnzfi", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyrenno = new ExDBFieldString<>("ztyrenno", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyhhknnen2 = new ExDBFieldString<>("ztyhhknnen2", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyhhknsei = new ExDBFieldString<>("ztyhhknsei", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyaisyoumeikbn = new ExDBFieldString<>("ztyaisyoumeikbn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyzougenkbn = new ExDBFieldString<>("ztyzougenkbn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyhokenkngk13 = new ExDBFieldString<>("ztyhokenkngk13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyp13 = new ExDBFieldString<>("ztyp13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyptumitatekin13 = new ExDBFieldString<>("ztyptumitatekin13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztykiykhnrikn13 = new ExDBFieldString<>("ztykiykhnrikn13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyidouhokenkngk = new ExDBFieldString<>("ztyidouhokenkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyidoup = new ExDBFieldString<>("ztyidoup", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyidouptumitatekin = new ExDBFieldString<>("ztyidouptumitatekin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyidoukiykhnrikn = new ExDBFieldString<>("ztyidoukiykhnrikn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, BizNumber> ztyyoteiriritun5 = new ExDBFieldString<>("ztyyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztytumitatekinkbn = new ExDBFieldString<>("ztytumitatekinkbn", this);

    public final ExDBFieldString<ZT_HknkykIdouInfoTy, String> ztyharaikatakbnkykidou = new ExDBFieldString<>("ztyharaikatakbnkykidou", this);
}
