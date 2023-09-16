package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;

/**
 * ＡＫＳ連動済請求契約情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_AksrendouzumiSkKykInfo extends AbstractExDBTable<JT_AksrendouzumiSkKykInfo> {

    public GenQJT_AksrendouzumiSkKykInfo() {
        this("JT_AksrendouzumiSkKykInfo");
    }

    public GenQJT_AksrendouzumiSkKykInfo(String pAlias) {
        super("JT_AksrendouzumiSkKykInfo", JT_AksrendouzumiSkKykInfo.class, pAlias);
    }

    public String JT_AksrendouzumiSkKykInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, BizDate> sibouymd = new ExDBFieldString<>("sibouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, C_GeninKbn> geninkbn = new ExDBFieldString<>("geninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldNumber<JT_AksrendouzumiSkKykInfo, Integer> syoruiimagerendousuu = new ExDBFieldNumber<>("syoruiimagerendousuu", this);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, String> ankenimgjygntyoukahyj = new ExDBFieldString<>("ankenimgjygntyoukahyj", this);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, String> tiffhenkankekkakbn = new ExDBFieldString<>("tiffhenkankekkakbn", this);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_AksrendouzumiSkKykInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
