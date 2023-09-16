package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TuutiKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_HurikomiIraiTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_TuutiKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 振込依頼通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HurikomiIraiTuuti extends AbstractExDBTable<IT_HurikomiIraiTuuti> {

    public GenQIT_HurikomiIraiTuuti() {
        this("IT_HurikomiIraiTuuti");
    }

    public GenQIT_HurikomiIraiTuuti(String pAlias) {
        super("IT_HurikomiIraiTuuti", IT_HurikomiIraiTuuti.class, pAlias);
    }

    public String IT_HurikomiIraiTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> tsinadr4kj = new ExDBFieldString<>("tsinadr4kj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_HurikomiIraiTuuti, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_HurikomiIraiTuuti, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, BizDate> yykknmnryymd = new ExDBFieldString<>("yykknmnryymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_HurikomiIraiTuuti> ryosyugk = new ExDBFieldBizCurrency<>("ryosyugk", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, BizDate> hrkkigenymd = new ExDBFieldString<>("hrkkigenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, BizDate> nipyykknmnryymd = new ExDBFieldString<>("nipyykknmnryymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> banknmkj = new ExDBFieldString<>("banknmkj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> sitennmkj = new ExDBFieldString<>("sitennmkj", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldNumber<IT_HurikomiIraiTuuti, Integer> injiptnkbn = new ExDBFieldNumber<>("injiptnkbn", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, C_TuutiKbn> tuutikbn = new ExDBFieldString<>("tuutikbn", this, UserType_C_TuutiKbn.class);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> hurikomisyono = new ExDBFieldString<>("hurikomisyono", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> drtennmkj = new ExDBFieldString<>("drtennmkj", this);

    public final ExDBFieldNumber<IT_HurikomiIraiTuuti, Integer> rtratkicd = new ExDBFieldNumber<>("rtratkicd", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> rtyouhyoucd = new ExDBFieldString<>("rtyouhyoucd", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, C_TyhyrenrakusikibetuKbn> tyhyrenrakusikibetukbn = new ExDBFieldString<>("tyhyrenrakusikibetukbn", this, UserType_C_TyhyrenrakusikibetuKbn.class);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HurikomiIraiTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
