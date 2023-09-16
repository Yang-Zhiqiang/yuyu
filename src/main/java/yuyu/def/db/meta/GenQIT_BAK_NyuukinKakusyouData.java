package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_NyuukinKakusyouData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_CreditUriageSeikyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.db.type.UserType_C_NykhouhouKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_NyuuryokuKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 入金確証データバックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_NyuukinKakusyouData extends AbstractExDBTable<IT_BAK_NyuukinKakusyouData> {

    public GenQIT_BAK_NyuukinKakusyouData() {
        this("IT_BAK_NyuukinKakusyouData");
    }

    public GenQIT_BAK_NyuukinKakusyouData(String pAlias) {
        super("IT_BAK_NyuukinKakusyouData", IT_BAK_NyuukinKakusyouData.class, pAlias);
    }

    public String IT_BAK_NyuukinKakusyouData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> nyuukinkakusyouno = new ExDBFieldString<>("nyuukinkakusyouno", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, BizDate> nyuukinkakusyounrkymd = new ExDBFieldString<>("nyuukinkakusyounrkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_UmuKbn> iktnyuukinnumu = new ExDBFieldString<>("iktnyuukinnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_NyuukinKakusyouData, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_BAK_NyuukinKakusyouData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_BAK_NyuukinKakusyouData> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<IT_BAK_NyuukinKakusyouData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_NykhouhouKbn> nykhouhoukbn = new ExDBFieldString<>("nykhouhoukbn", this, UserType_C_NykhouhouKbn.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, BizDate> nykdenymd = new ExDBFieldString<>("nykdenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> tabakarikanjyono = new ExDBFieldString<>("tabakarikanjyono", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> nyuukinkakusyounrkno = new ExDBFieldString<>("nyuukinkakusyounrkno", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_NyuuryokuKbn> nyuuryokukbn = new ExDBFieldString<>("nyuuryokukbn", this, UserType_C_NyuuryokuKbn.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> suitono = new ExDBFieldString<>("suitono", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_KrkPayEasyHrkmyousiNkKbn> hrkmyousinkkbn = new ExDBFieldString<>("hrkmyousinkkbn", this, UserType_C_KrkPayEasyHrkmyousiNkKbn.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> suitososhikicd = new ExDBFieldString<>("suitososhikicd", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> kzhurikaebankcd = new ExDBFieldString<>("kzhurikaebankcd", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> kzhurikaesitencd = new ExDBFieldString<>("kzhurikaesitencd", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> uketuketencd = new ExDBFieldString<>("uketuketencd", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> cvscd = new ExDBFieldString<>("cvscd", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> ryousyuuhm = new ExDBFieldString<>("ryousyuuhm", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> hurikomiyousiokyksmno = new ExDBFieldString<>("hurikomiyousiokyksmno", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> hurikomiyousikakuninno = new ExDBFieldString<>("hurikomiyousikakuninno", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> kinyuukikankbn = new ExDBFieldString<>("kinyuukikankbn", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_BAK_NyuukinKakusyouData, C_CreditUriageSeikyuuKbn> credituriageseikyuukbn = new ExDBFieldString<>("credituriageseikyuukbn", this, UserType_C_CreditUriageSeikyuuKbn.class);
}
