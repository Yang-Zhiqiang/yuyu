package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_CreditdataKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_BAK_DattaiUktk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_CreditdataKbn;
import yuyu.def.db.type.UserType_C_Dattaikeiro;
import yuyu.def.db.type.UserType_C_DattairiyuuKbn;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 脱退受付バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_DattaiUktk extends AbstractExDBTable<IT_BAK_DattaiUktk> {

    public GenQIT_BAK_DattaiUktk() {
        this("IT_BAK_DattaiUktk");
    }

    public GenQIT_BAK_DattaiUktk(String pAlias) {
        super("IT_BAK_DattaiUktk", IT_BAK_DattaiUktk.class, pAlias);
    }

    public String IT_BAK_DattaiUktk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, C_Dattaikeiro> dattaikeiro = new ExDBFieldString<>("dattaikeiro", this, UserType_C_Dattaikeiro.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, C_DattairiyuuKbn> dattairiyuukbn = new ExDBFieldString<>("dattairiyuukbn", this, UserType_C_DattairiyuuKbn.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, BizDateYM> dattaiym = new ExDBFieldString<>("dattaiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, C_CreditdataKbn> creditdatakbn = new ExDBFieldString<>("creditdatakbn", this, UserType_C_CreditdataKbn.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, C_Creditbrerrorcd> creditbrerrorcd = new ExDBFieldString<>("creditbrerrorcd", this, UserType_C_Creditbrerrorcd.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> comment124keta = new ExDBFieldString<>("comment124keta", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_DattaiUktk, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);
}
