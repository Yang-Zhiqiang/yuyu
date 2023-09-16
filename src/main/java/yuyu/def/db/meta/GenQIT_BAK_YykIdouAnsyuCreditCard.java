package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_AuthoritrkKbn;
import yuyu.def.classification.C_YuukoukakujkKbn;
import yuyu.def.db.entity.IT_BAK_YykIdouAnsyuCreditCard;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_AuthoritrkKbn;
import yuyu.def.db.type.UserType_C_YuukoukakujkKbn;

/**
 * 予約異動案内収納用クレジット払バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_YykIdouAnsyuCreditCard extends AbstractExDBTable<IT_BAK_YykIdouAnsyuCreditCard> {

    public GenQIT_BAK_YykIdouAnsyuCreditCard() {
        this("IT_BAK_YykIdouAnsyuCreditCard");
    }

    public GenQIT_BAK_YykIdouAnsyuCreditCard(String pAlias) {
        super("IT_BAK_YykIdouAnsyuCreditCard", IT_BAK_YykIdouAnsyuCreditCard.class, pAlias);
    }

    public String IT_BAK_YykIdouAnsyuCreditCard() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, BizDate> yukoukachkymd = new ExDBFieldString<>("yukoukachkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, C_YuukoukakujkKbn> yuukoukakujkkbn = new ExDBFieldString<>("yuukoukakujkkbn", this, UserType_C_YuukoukakujkKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, C_AuthorijkKbn> authorijkkbn = new ExDBFieldString<>("authorijkkbn", this, UserType_C_AuthorijkKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, C_AuthoritrkKbn> authoritrkkbn = new ExDBFieldString<>("authoritrkkbn", this, UserType_C_AuthoritrkKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_YykIdouAnsyuCreditCard> authorigk = new ExDBFieldBizCurrency<>("authorigk", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, BizDate> authorikanryoymd = new ExDBFieldString<>("authorikanryoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> syouninno = new ExDBFieldString<>("syouninno", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> tanmatusyorino = new ExDBFieldString<>("tanmatusyorino", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_YykIdouAnsyuCreditCard, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
