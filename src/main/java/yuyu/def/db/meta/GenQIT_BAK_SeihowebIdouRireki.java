package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_SeihowebIdouRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 生保Ｗｅｂ用異動履歴バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_SeihowebIdouRireki extends AbstractExDBTable<IT_BAK_SeihowebIdouRireki> {

    public GenQIT_BAK_SeihowebIdouRireki() {
        this("IT_BAK_SeihowebIdouRireki");
    }

    public GenQIT_BAK_SeihowebIdouRireki(String pAlias) {
        super("IT_BAK_SeihowebIdouRireki", IT_BAK_SeihowebIdouRireki.class, pAlias);
    }

    public String IT_BAK_SeihowebIdouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, BizDateYM> idouhasseiym = new ExDBFieldString<>("idouhasseiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, BizDate> idouhasseiymd = new ExDBFieldString<>("idouhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> seihowebidoukbnnaiyou1 = new ExDBFieldString<>("seihowebidoukbnnaiyou1", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> seihowebidoukbnnaiyou2 = new ExDBFieldString<>("seihowebidoukbnnaiyou2", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> bosyuucd1 = new ExDBFieldString<>("bosyuucd1", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, C_UmuKbn> drtenbunumu = new ExDBFieldString<>("drtenbunumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> bosyuucd2 = new ExDBFieldString<>("bosyuucd2", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_BAK_SeihowebIdouRireki, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_SeihowebIdouRireki> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_SeihowebIdouRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
