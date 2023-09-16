package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_GaibuRenkeiKakuJkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.IT_ChkYuukousei;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_GaibuRenkeiKakuJkKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;

/**
 * 有効性確認データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_ChkYuukousei extends AbstractExDBTable<IT_ChkYuukousei> {

    public GenQIT_ChkYuukousei() {
        this("IT_ChkYuukousei");
    }

    public GenQIT_ChkYuukousei(String pAlias) {
        super("IT_ChkYuukousei", IT_ChkYuukousei.class, pAlias);
    }

    public String IT_ChkYuukousei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_ChkYuukousei, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_ChkYuukousei, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_ChkYuukousei, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_ChkYuukousei, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> creditcardykkigen = new ExDBFieldString<>("creditcardykkigen", this);

    public final ExDBFieldString<IT_ChkYuukousei, BizDateYM> yuukoutaisyouym = new ExDBFieldString<>("yuukoutaisyouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_ChkYuukousei, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldString<IT_ChkYuukousei, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_ChkYuukousei, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> hokensyuruikigousdicode = new ExDBFieldString<>("hokensyuruikigousdicode", this);

    public final ExDBFieldNumber<IT_ChkYuukousei, Long> hknsyukigoukktkmk1 = new ExDBFieldNumber<>("hknsyukigoukktkmk1", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> hknsyukigoukktkmk2 = new ExDBFieldString<>("hknsyukigoukktkmk2", this);

    public final ExDBFieldNumber<IT_ChkYuukousei, Long> hknsyukigoukktkmk3 = new ExDBFieldNumber<>("hknsyukigoukktkmk3", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> kameitenno = new ExDBFieldString<>("kameitenno", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> kameitennm = new ExDBFieldString<>("kameitennm", this);

    public final ExDBFieldString<IT_ChkYuukousei, C_GaibuRenkeiKakuJkKbn> gaiburenkeikakujkkbn = new ExDBFieldString<>("gaiburenkeikakujkkbn", this, UserType_C_GaibuRenkeiKakuJkKbn.class);

    public final ExDBFieldString<IT_ChkYuukousei, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_ChkYuukousei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
