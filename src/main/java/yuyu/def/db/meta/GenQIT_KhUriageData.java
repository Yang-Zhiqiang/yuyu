package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyuukeilvKbn;
import yuyu.def.db.entity.IT_KhUriageData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_SyuukeilvKbn;

/**
 * 売上データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhUriageData extends AbstractExDBTable<IT_KhUriageData> {

    public GenQIT_KhUriageData() {
        this("IT_KhUriageData");
    }

    public GenQIT_KhUriageData(String pAlias) {
        super("IT_KhUriageData", IT_KhUriageData.class, pAlias);
    }

    public String IT_KhUriageData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhUriageData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_KhUriageData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhUriageData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_KhUriageData, Integer> authorikaisuu = new ExDBFieldNumber<>("authorikaisuu", this);

    public final ExDBFieldString<IT_KhUriageData, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_KhUriageData, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_KhUriageData, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_KhUriageData, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_KhUriageData, String> creditcardykkigen = new ExDBFieldString<>("creditcardykkigen", this);

    public final ExDBFieldString<IT_KhUriageData, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldString<IT_KhUriageData, C_SyuukeilvKbn> syuukeilvkbn = new ExDBFieldString<>("syuukeilvkbn", this, UserType_C_SyuukeilvKbn.class);

    public final ExDBFieldBizCurrency<IT_KhUriageData> authorigk = new ExDBFieldBizCurrency<>("authorigk", this);

    public final ExDBFieldString<IT_KhUriageData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KhUriageData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_KhUriageData> uriagegk = new ExDBFieldBizCurrency<>("uriagegk", this);

    public final ExDBFieldString<IT_KhUriageData, BizDate> uriageymd = new ExDBFieldString<>("uriageymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhUriageData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KhUriageData, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<IT_KhUriageData, String> hokensyuruikigousdicode = new ExDBFieldString<>("hokensyuruikigousdicode", this);

    public final ExDBFieldNumber<IT_KhUriageData, Long> hknsyukigoukktkmk1 = new ExDBFieldNumber<>("hknsyukigoukktkmk1", this);

    public final ExDBFieldString<IT_KhUriageData, String> hknsyukigoukktkmk2 = new ExDBFieldString<>("hknsyukigoukktkmk2", this);

    public final ExDBFieldNumber<IT_KhUriageData, Long> hknsyukigoukktkmk3 = new ExDBFieldNumber<>("hknsyukigoukktkmk3", this);

    public final ExDBFieldString<IT_KhUriageData, String> kameitenno = new ExDBFieldString<>("kameitenno", this);

    public final ExDBFieldString<IT_KhUriageData, String> kameitennm25 = new ExDBFieldString<>("kameitennm25", this);

    public final ExDBFieldNumber<IT_KhUriageData, Long> credittsryritu = new ExDBFieldNumber<>("credittsryritu", this);

    public final ExDBFieldString<IT_KhUriageData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhUriageData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhUriageData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
