package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.IT_BAK_Kariukekin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KrkriyuuKbn;
import yuyu.def.db.type.UserType_C_Krkseisanzumiflg;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;

/**
 * 仮受金バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_Kariukekin extends AbstractExDBTable<IT_BAK_Kariukekin> {

    public GenQIT_BAK_Kariukekin() {
        this("IT_BAK_Kariukekin");
    }

    public GenQIT_BAK_Kariukekin(String pAlias) {
        super("IT_BAK_Kariukekin", IT_BAK_Kariukekin.class, pAlias);
    }

    public String IT_BAK_Kariukekin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_Kariukekin, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_Kariukekin, Integer> krkno = new ExDBFieldNumber<>("krkno", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, BizDate> krkkeijyoymd = new ExDBFieldString<>("krkkeijyoymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Kariukekin> krkgk = new ExDBFieldBizCurrency<>("krkgk", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, BizDate> hasseidenymd = new ExDBFieldString<>("hasseidenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, BizDate> seisandenymd = new ExDBFieldString<>("seisandenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, C_Krkseisanzumiflg> krkseisanzumiflg = new ExDBFieldString<>("krkseisanzumiflg", this, UserType_C_Krkseisanzumiflg.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, C_KrkriyuuKbn> krkriyuukbn = new ExDBFieldString<>("krkriyuukbn", this, UserType_C_KrkriyuuKbn.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_Kariukekin, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_BAK_Kariukekin, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_Kariukekin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_Kariukekin, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);
}
