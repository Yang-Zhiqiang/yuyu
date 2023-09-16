package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_BAK_HrhnTtdkKan;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 手続完了（払方変更）バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_HrhnTtdkKan extends AbstractExDBTable<IT_BAK_HrhnTtdkKan> {

    public GenQIT_BAK_HrhnTtdkKan() {
        this("IT_BAK_HrhnTtdkKan");
    }

    public GenQIT_BAK_HrhnTtdkKan(String pAlias) {
        super("IT_BAK_HrhnTtdkKan", IT_BAK_HrhnTtdkKan.class, pAlias);
    }

    public String IT_BAK_HrhnTtdkKan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawasekaisyanmkj = new ExDBFieldString<>("toiawasekaisyanmkj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> kouzamaskingmsg = new ExDBFieldString<>("kouzamaskingmsg", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkkaisuutkiktbrisyu = new ExDBFieldString<>("hrkkaisuutkiktbrisyu", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldBizCurrency<IT_BAK_HrhnTtdkKan> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, BizDateYM> kouryokuhasseiym = new ExDBFieldString<>("kouryokuhasseiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> msgarea34keta1 = new ExDBFieldString<>("msgarea34keta1", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> msgarea34keta2 = new ExDBFieldString<>("msgarea34keta2", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> msgarea34keta3 = new ExDBFieldString<>("msgarea34keta3", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> msgarea34keta4 = new ExDBFieldString<>("msgarea34keta4", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> msgarea34keta5 = new ExDBFieldString<>("msgarea34keta5", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> msgarea34keta6 = new ExDBFieldString<>("msgarea34keta6", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> msgarea34keta7 = new ExDBFieldString<>("msgarea34keta7", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta1 = new ExDBFieldString<>("hrkykkmsg34keta1", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta2 = new ExDBFieldString<>("hrkykkmsg34keta2", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta3 = new ExDBFieldString<>("hrkykkmsg34keta3", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta4 = new ExDBFieldString<>("hrkykkmsg34keta4", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta5 = new ExDBFieldString<>("hrkykkmsg34keta5", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta6 = new ExDBFieldString<>("hrkykkmsg34keta6", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta7 = new ExDBFieldString<>("hrkykkmsg34keta7", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta8 = new ExDBFieldString<>("hrkykkmsg34keta8", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta9 = new ExDBFieldString<>("hrkykkmsg34keta9", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta10 = new ExDBFieldString<>("hrkykkmsg34keta10", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta11 = new ExDBFieldString<>("hrkykkmsg34keta11", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta12 = new ExDBFieldString<>("hrkykkmsg34keta12", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta13 = new ExDBFieldString<>("hrkykkmsg34keta13", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta14 = new ExDBFieldString<>("hrkykkmsg34keta14", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta15 = new ExDBFieldString<>("hrkykkmsg34keta15", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta16 = new ExDBFieldString<>("hrkykkmsg34keta16", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta17 = new ExDBFieldString<>("hrkykkmsg34keta17", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta18 = new ExDBFieldString<>("hrkykkmsg34keta18", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta19 = new ExDBFieldString<>("hrkykkmsg34keta19", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta20 = new ExDBFieldString<>("hrkykkmsg34keta20", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta21 = new ExDBFieldString<>("hrkykkmsg34keta21", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta22 = new ExDBFieldString<>("hrkykkmsg34keta22", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta23 = new ExDBFieldString<>("hrkykkmsg34keta23", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta24 = new ExDBFieldString<>("hrkykkmsg34keta24", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta25 = new ExDBFieldString<>("hrkykkmsg34keta25", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta26 = new ExDBFieldString<>("hrkykkmsg34keta26", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta27 = new ExDBFieldString<>("hrkykkmsg34keta27", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> hrkykkmsg34keta28 = new ExDBFieldString<>("hrkykkmsg34keta28", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_HrhnTtdkKan, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
