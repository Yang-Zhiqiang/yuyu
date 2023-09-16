package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_SikkouTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 失効通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SikkouTuuti extends AbstractExDBTable<IT_SikkouTuuti> {

    public GenQIT_SikkouTuuti() {
        this("IT_SikkouTuuti");
    }

    public GenQIT_SikkouTuuti(String pAlias) {
        super("IT_SikkouTuuti", IT_SikkouTuuti.class, pAlias);
    }

    public String IT_SikkouTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SikkouTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_SikkouTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SikkouTuuti, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> drtentsinyno = new ExDBFieldString<>("drtentsinyno", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> drtennmkj = new ExDBFieldString<>("drtennmkj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> oyadrtennmkj = new ExDBFieldString<>("oyadrtennmkj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<IT_SikkouTuuti, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SikkouTuuti, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_SikkouTuuti, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_SikkouTuuti, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_SikkouTuuti> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_SikkouTuuti, BizDate> sikkouymd = new ExDBFieldString<>("sikkouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SikkouTuuti, BizDate> fukkatukigenymd = new ExDBFieldString<>("fukkatukigenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SikkouTuuti, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> banknmkj = new ExDBFieldString<>("banknmkj", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> sitennmkj = new ExDBFieldString<>("sitennmkj", this);

    public final ExDBFieldString<IT_SikkouTuuti, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_SikkouTuuti, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> rcreditcardno = new ExDBFieldString<>("rcreditcardno", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SikkouTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
