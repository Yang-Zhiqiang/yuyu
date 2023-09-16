package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_AuthoritrkKbn;
import yuyu.def.classification.C_YuukoukakujkKbn;
import yuyu.def.db.entity.IT_BAK_AnsyuCreditCard;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_AuthoritrkKbn;
import yuyu.def.db.type.UserType_C_YuukoukakujkKbn;

/**
 * 案内収納用クレジット払バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_AnsyuCreditCard extends AbstractExDBTable<IT_BAK_AnsyuCreditCard> {

    public GenQIT_BAK_AnsyuCreditCard() {
        this("IT_BAK_AnsyuCreditCard");
    }

    public GenQIT_BAK_AnsyuCreditCard(String pAlias) {
        super("IT_BAK_AnsyuCreditCard", IT_BAK_AnsyuCreditCard.class, pAlias);
    }

    public String IT_BAK_AnsyuCreditCard() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, BizDate> yukoukachkymd = new ExDBFieldString<>("yukoukachkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, C_YuukoukakujkKbn> yuukoukakujkkbn = new ExDBFieldString<>("yuukoukakujkkbn", this, UserType_C_YuukoukakujkKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, C_AuthorijkKbn> authorijkkbn = new ExDBFieldString<>("authorijkkbn", this, UserType_C_AuthorijkKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, C_AuthoritrkKbn> authoritrkkbn = new ExDBFieldString<>("authoritrkkbn", this, UserType_C_AuthoritrkKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_AnsyuCreditCard> authorigk = new ExDBFieldBizCurrency<>("authorigk", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, BizDate> authorikanryoymd = new ExDBFieldString<>("authorikanryoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> syouninno = new ExDBFieldString<>("syouninno", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> tanmatusyorino = new ExDBFieldString<>("tanmatusyorino", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, BizDate> uriageymd = new ExDBFieldString<>("uriageymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_AnsyuCreditCard, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
