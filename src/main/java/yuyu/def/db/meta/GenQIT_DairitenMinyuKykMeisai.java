package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_DairitenMinyuKykMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 代理店未入契約明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_DairitenMinyuKykMeisai extends AbstractExDBTable<IT_DairitenMinyuKykMeisai> {

    public GenQIT_DairitenMinyuKykMeisai() {
        this("IT_DairitenMinyuKykMeisai");
    }

    public GenQIT_DairitenMinyuKykMeisai(String pAlias) {
        super("IT_DairitenMinyuKykMeisai", IT_DairitenMinyuKykMeisai.class, pAlias);
    }

    public String IT_DairitenMinyuKykMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_DairitenMinyuKykMeisai, Integer> drtenrenno = new ExDBFieldNumber<>("drtenrenno", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, BizDateYM> pjytym = new ExDBFieldString<>("pjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> kanjidairitennm = new ExDBFieldString<>("kanjidairitennm", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, BizDate> minyujytymd = new ExDBFieldString<>("minyujytymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> hassinka = new ExDBFieldString<>("hassinka", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> kanjibosyuuninnm = new ExDBFieldString<>("kanjibosyuuninnm", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> kydatkikbn = new ExDBFieldString<>("kydatkikbn", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldBizCurrency<IT_DairitenMinyuKykMeisai> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, BizDate> bosyuuningyouhaiymd = new ExDBFieldString<>("bosyuuningyouhaiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> dntcd = new ExDBFieldString<>("dntcd", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> kjdntnm = new ExDBFieldString<>("kjdntnm", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> hknsyuruinm = new ExDBFieldString<>("hknsyuruinm", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> hjnkykhyj = new ExDBFieldString<>("hjnkykhyj", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_DairitenMinyuKykMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
