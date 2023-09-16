package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_CreditdataKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_TRDattai;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_CreditdataKbn;
import yuyu.def.db.type.UserType_C_Dattaikeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 脱退ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRDattai extends AbstractExDBTable<IT_TRDattai> {

    public GenQIT_TRDattai() {
        this("IT_TRDattai");
    }

    public GenQIT_TRDattai(String pAlias) {
        super("IT_TRDattai", IT_TRDattai.class, pAlias);
    }

    public String IT_TRDattai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRDattai, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_TRDattai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TRDattai, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRDattai, String> dattaitrrenno = new ExDBFieldString<>("dattaitrrenno", this);

    public final ExDBFieldString<IT_TRDattai, C_Dattaikeiro> dattaikeiro = new ExDBFieldString<>("dattaikeiro", this, UserType_C_Dattaikeiro.class);

    public final ExDBFieldString<IT_TRDattai, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_TRDattai, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_TRDattai, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_TRDattai, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_TRDattai, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_TRDattai, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_TRDattai, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRDattai, C_CreditdataKbn> creditdatakbn = new ExDBFieldString<>("creditdatakbn", this, UserType_C_CreditdataKbn.class);

    public final ExDBFieldString<IT_TRDattai, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_TRDattai, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_TRDattai, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_TRDattai, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_TRDattai, C_Creditbrerrorcd> creditbrerrorcd = new ExDBFieldString<>("creditbrerrorcd", this, UserType_C_Creditbrerrorcd.class);

    public final ExDBFieldString<IT_TRDattai, BizDateYM> dattaiym = new ExDBFieldString<>("dattaiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_TRDattai, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_TRDattai, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldNumber<IT_TRDattai, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_TRDattai, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_TRDattai, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_TRDattai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TRDattai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TRDattai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_TRDattai, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_TRDattai, C_CardBrandKbn> cardbrandkbn = new ExDBFieldString<>("cardbrandkbn", this, UserType_C_CardBrandKbn.class);

    public final ExDBFieldString<IT_TRDattai, String> creditkaiinnosimo4keta = new ExDBFieldString<>("creditkaiinnosimo4keta", this);
}
