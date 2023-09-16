package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AsBikinkanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 案内収納備金管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_AsBikinkanri extends AbstractExDBTable<IT_AsBikinkanri> {

    public GenQIT_AsBikinkanri() {
        this("IT_AsBikinkanri");
    }

    public GenQIT_AsBikinkanri(String pAlias) {
        super("IT_AsBikinkanri", IT_AsBikinkanri.class, pAlias);
    }

    public String IT_AsBikinkanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_AsBikinkanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_AsBikinkanri, BizDate> kessankijyunymd = new ExDBFieldString<>("kessankijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AsBikinkanri, C_BkncdKbn> bkncdkbn = new ExDBFieldString<>("bkncdkbn", this, UserType_C_BkncdKbn.class);

    public final ExDBFieldString<IT_AsBikinkanri, BizDate> bknkktymd = new ExDBFieldString<>("bknkktymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_AsBikinkanri, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_AsBikinkanri, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AsBikinkanri, String> sisyacd = new ExDBFieldString<>("sisyacd", this);

    public final ExDBFieldString<IT_AsBikinkanri, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_AsBikinkanri, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldBizCurrency<IT_AsBikinkanri> bkngk = new ExDBFieldBizCurrency<>("bkngk", this);

    public final ExDBFieldString<IT_AsBikinkanri, C_UmuKbn> syoriumukbn = new ExDBFieldString<>("syoriumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_AsBikinkanri, C_BknJkuKbn> bknjkukbn = new ExDBFieldString<>("bknjkukbn", this, UserType_C_BknJkuKbn.class);

    public final ExDBFieldBizCurrency<IT_AsBikinkanri> kaiyakuhrgaika = new ExDBFieldBizCurrency<>("kaiyakuhrgaika", this);

    public final ExDBFieldString<IT_AsBikinkanri, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_AsBikinkanri, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_AsBikinkanri, BizDate> kwsratekjymd = new ExDBFieldString<>("kwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AsBikinkanri, BizNumber> kawaserate = new ExDBFieldString<>("kawaserate", this, BizNumberType.class);

    public final ExDBFieldString<IT_AsBikinkanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_AsBikinkanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_AsBikinkanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
