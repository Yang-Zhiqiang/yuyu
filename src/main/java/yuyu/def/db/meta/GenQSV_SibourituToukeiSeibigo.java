package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 死亡率統計整備後情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_SibourituToukeiSeibigo extends AbstractExDBTable<SV_SibourituToukeiSeibigo> {

    public GenQSV_SibourituToukeiSeibigo() {
        this("SV_SibourituToukeiSeibigo");
    }

    public GenQSV_SibourituToukeiSeibigo(String pAlias) {
        super("SV_SibourituToukeiSeibigo", SV_SibourituToukeiSeibigo.class, pAlias);
    }

    public String SV_SibourituToukeiSeibigo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<SV_SibourituToukeiSeibigo, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<SV_SibourituToukeiSeibigo, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldBizCurrency<SV_SibourituToukeiSeibigo> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_UmuKbn> drtenbunumu = new ExDBFieldString<>("drtenbunumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_SyoriKbn> syorikbn = new ExDBFieldString<>("syorikbn", this, UserType_C_SyoriKbn.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<SV_SibourituToukeiSeibigo, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_SibourituToukeiSeibigo> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);
}
