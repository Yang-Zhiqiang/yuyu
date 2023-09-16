package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_HaraikatahnkuktknaiyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_BAK_YykIdouNaiyoHrhnk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_HaraikatahnkuktknaiyouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 予約異動受付内容（払方変更）バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_YykIdouNaiyoHrhnk extends AbstractExDBTable<IT_BAK_YykIdouNaiyoHrhnk> {

    public GenQIT_BAK_YykIdouNaiyoHrhnk() {
        this("IT_BAK_YykIdouNaiyoHrhnk");
    }

    public GenQIT_BAK_YykIdouNaiyoHrhnk(String pAlias) {
        super("IT_BAK_YykIdouNaiyoHrhnk", IT_BAK_YykIdouNaiyoHrhnk.class, pAlias);
    }

    public String IT_BAK_YykIdouNaiyoHrhnk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_Hrkkeiro> newhrkkeiro = new ExDBFieldString<>("newhrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_Hrkkaisuu> newhrkkaisuu = new ExDBFieldString<>("newhrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_TkiktbrisyuruiKbn> newtikiktbrisyuruikbn = new ExDBFieldString<>("newtikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_UmuKbn> hrkkeirohnkumu = new ExDBFieldString<>("hrkkeirohnkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_UmuKbn> hrkkaisuuhnkumu = new ExDBFieldString<>("hrkkaisuuhnkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_UmuKbn> tikiktbrisyuruihnkumu = new ExDBFieldString<>("tikiktbrisyuruihnkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_UmuKbn> haraikatahnkumu = new ExDBFieldString<>("haraikatahnkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_HaraikatahnkuktknaiyouKbn> haraikatahnkuktknaiyoukbn = new ExDBFieldString<>("haraikatahnkuktknaiyoukbn", this, UserType_C_HaraikatahnkuktknaiyouKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_YykIdouNaiyoHrhnk> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_SinkeizkKbn> sinkeizkkbn = new ExDBFieldString<>("sinkeizkkbn", this, UserType_C_SinkeizkKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditcardykkigen = new ExDBFieldString<>("creditcardykkigen", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditmeiginmkn = new ExDBFieldString<>("creditmeiginmkn", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, C_CardBrandKbn> cardbrandkbn = new ExDBFieldString<>("cardbrandkbn", this, UserType_C_CardBrandKbn.class);

    public final ExDBFieldString<IT_BAK_YykIdouNaiyoHrhnk, String> creditkaiinnosimo4keta = new ExDBFieldString<>("creditkaiinnosimo4keta", this);
}
