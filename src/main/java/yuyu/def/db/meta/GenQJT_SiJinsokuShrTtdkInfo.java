package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TanmatuSyuruiKbn;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_TanmatuSyuruiKbn;

/**
 * 保険金給付金迅速支払手続情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiJinsokuShrTtdkInfo extends AbstractExDBTable<JT_SiJinsokuShrTtdkInfo> {

    public GenQJT_SiJinsokuShrTtdkInfo() {
        this("JT_SiJinsokuShrTtdkInfo");
    }

    public GenQJT_SiJinsokuShrTtdkInfo(String pAlias) {
        super("JT_SiJinsokuShrTtdkInfo", JT_SiJinsokuShrTtdkInfo.class, pAlias);
    }

    public String JT_SiJinsokuShrTtdkInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> hknknshrsntkno = new ExDBFieldString<>("hknknshrsntkno", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldNumber<JT_SiJinsokuShrTtdkInfo, Integer> syoruikeikaeigyoubisuu = new ExDBFieldNumber<>("syoruikeikaeigyoubisuu", this);

    public final ExDBFieldNumber<JT_SiJinsokuShrTtdkInfo, Integer> syorikeikaeigyoubisuu = new ExDBFieldNumber<>("syorikeikaeigyoubisuu", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> toritugisosikicd = new ExDBFieldString<>("toritugisosikicd", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, C_TanmatuSyuruiKbn> tanmatusyuruikbn = new ExDBFieldString<>("tanmatusyuruikbn", this, UserType_C_TanmatuSyuruiKbn.class);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiJinsokuShrTtdkInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
