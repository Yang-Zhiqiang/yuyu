package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_GaibuRenkeiKakuJkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.IT_KhAuthoriData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_GaibuRenkeiKakuJkKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;

/**
 * オーソリデータテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhAuthoriData extends AbstractExDBTable<IT_KhAuthoriData> {

    public GenQIT_KhAuthoriData() {
        this("IT_KhAuthoriData");
    }

    public GenQIT_KhAuthoriData(String pAlias) {
        super("IT_KhAuthoriData", IT_KhAuthoriData.class, pAlias);
    }

    public String IT_KhAuthoriData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhAuthoriData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_KhAuthoriData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhAuthoriData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_KhAuthoriData, Integer> authorikaisuu = new ExDBFieldNumber<>("authorikaisuu", this);

    public final ExDBFieldString<IT_KhAuthoriData, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_KhAuthoriData, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_KhAuthoriData, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_KhAuthoriData, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_KhAuthoriData, String> creditcardykkigen = new ExDBFieldString<>("creditcardykkigen", this);

    public final ExDBFieldBizCurrency<IT_KhAuthoriData> authorigk = new ExDBFieldBizCurrency<>("authorigk", this);

    public final ExDBFieldString<IT_KhAuthoriData, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KhAuthoriData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KhAuthoriData, C_GaibuRenkeiKakuJkKbn> gaiburenkeikakujkkbn = new ExDBFieldString<>("gaiburenkeikakujkkbn", this, UserType_C_GaibuRenkeiKakuJkKbn.class);

    public final ExDBFieldString<IT_KhAuthoriData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhAuthoriData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhAuthoriData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
