package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_AuthoritrkKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.IT_KhAuthoriKekData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_AuthoritrkKbn;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;

/**
 * オーソリ結果データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhAuthoriKekData extends AbstractExDBTable<IT_KhAuthoriKekData> {

    public GenQIT_KhAuthoriKekData() {
        this("IT_KhAuthoriKekData");
    }

    public GenQIT_KhAuthoriKekData(String pAlias) {
        super("IT_KhAuthoriKekData", IT_KhAuthoriKekData.class, pAlias);
    }

    public String IT_KhAuthoriKekData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhAuthoriKekData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> authorikkdatarenno = new ExDBFieldString<>("authorikkdatarenno", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, BizDate> authorikanryoymd = new ExDBFieldString<>("authorikanryoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> creditcardykkigen = new ExDBFieldString<>("creditcardykkigen", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, C_AuthoritrkKbn> authoritrkkbn = new ExDBFieldString<>("authoritrkkbn", this, UserType_C_AuthoritrkKbn.class);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> torihikicd = new ExDBFieldString<>("torihikicd", this);

    public final ExDBFieldBizCurrency<IT_KhAuthoriKekData> authorigk = new ExDBFieldBizCurrency<>("authorigk", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> syouninno = new ExDBFieldString<>("syouninno", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> tanmatusyorino = new ExDBFieldString<>("tanmatusyorino", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, C_AuthorijkKbn> authorijkkbn = new ExDBFieldString<>("authorijkkbn", this, UserType_C_AuthorijkKbn.class);

    public final ExDBFieldString<IT_KhAuthoriKekData, C_Creditbrerrorcd> creditbrerrorcd = new ExDBFieldString<>("creditbrerrorcd", this, UserType_C_Creditbrerrorcd.class);

    public final ExDBFieldString<IT_KhAuthoriKekData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KhAuthoriKekData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldNumber<IT_KhAuthoriKekData, Integer> authorikaisuu = new ExDBFieldNumber<>("authorikaisuu", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhAuthoriKekData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
