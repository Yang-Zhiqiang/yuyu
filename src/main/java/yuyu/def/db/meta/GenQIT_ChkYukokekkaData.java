package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_ChkYukokekkaData;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 有効性確認結果データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_ChkYukokekkaData extends AbstractExDBTable<IT_ChkYukokekkaData> {

    public GenQIT_ChkYukokekkaData() {
        this("IT_ChkYukokekkaData");
    }

    public GenQIT_ChkYukokekkaData(String pAlias) {
        super("IT_ChkYukokekkaData", IT_ChkYukokekkaData.class, pAlias);
    }

    public String IT_ChkYukokekkaData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_ChkYukokekkaData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> yuukoukekkarenno = new ExDBFieldString<>("yuukoukekkarenno", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> inputyuukoukigen = new ExDBFieldString<>("inputyuukoukigen", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, BizDateYM> yuukoutaisyouym = new ExDBFieldString<>("yuukoutaisyouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_ChkYukokekkaData, C_UmuKbn> cardnokosumu = new ExDBFieldString<>("cardnokosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_ChkYukokekkaData, C_UmuKbn> cardykkigenkosumu = new ExDBFieldString<>("cardykkigenkosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> newcreditcardno1 = new ExDBFieldString<>("newcreditcardno1", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> newcreditcardno2 = new ExDBFieldString<>("newcreditcardno2", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> newcreditcardno3 = new ExDBFieldString<>("newcreditcardno3", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> newcreditcardno4 = new ExDBFieldString<>("newcreditcardno4", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> newcreditcardykkigen = new ExDBFieldString<>("newcreditcardykkigen", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> yuukouhanteikekka = new ExDBFieldString<>("yuukouhanteikekka", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> errorflg = new ExDBFieldString<>("errorflg", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, C_Creditbrerrorcd> creditbrerrorcd = new ExDBFieldString<>("creditbrerrorcd", this, UserType_C_Creditbrerrorcd.class);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_ChkYukokekkaData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
