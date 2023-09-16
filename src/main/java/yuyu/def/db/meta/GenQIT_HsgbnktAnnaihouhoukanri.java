package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BnktAnnaiHouhouKbn;
import yuyu.def.db.entity.IT_HsgbnktAnnaihouhoukanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BnktAnnaiHouhouKbn;

/**
 * 被災害分割案内方法管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HsgbnktAnnaihouhoukanri extends AbstractExDBTable<IT_HsgbnktAnnaihouhoukanri> {

    public GenQIT_HsgbnktAnnaihouhoukanri() {
        this("IT_HsgbnktAnnaihouhoukanri");
    }

    public GenQIT_HsgbnktAnnaihouhoukanri(String pAlias) {
        super("IT_HsgbnktAnnaihouhoukanri", IT_HsgbnktAnnaihouhoukanri.class, pAlias);
    }

    public String IT_HsgbnktAnnaihouhoukanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, BizDate> hsgymd = new ExDBFieldString<>("hsgymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, C_BnktAnnaiHouhouKbn> bnktannaihouhoukbn = new ExDBFieldString<>("bnktannaihouhoukbn", this, UserType_C_BnktAnnaiHouhouKbn.class);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, BizDate> bnktannaikaisiymd = new ExDBFieldString<>("bnktannaikaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, BizDate> bnktannaiendymd = new ExDBFieldString<>("bnktannaiendymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, BizDate> hsgtkbtymd1 = new ExDBFieldString<>("hsgtkbtymd1", this, BizDateType.class);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, BizDate> hsgtkbtymd2 = new ExDBFieldString<>("hsgtkbtymd2", this, BizDateType.class);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, String> hsgtkbtkbn1 = new ExDBFieldString<>("hsgtkbtkbn1", this);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, String> hsgtkbtkbn2 = new ExDBFieldString<>("hsgtkbtkbn2", this);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HsgbnktAnnaihouhoukanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
