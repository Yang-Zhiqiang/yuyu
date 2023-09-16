package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_Tesuuryou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Boskykjyoutai;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_TsrysyoriKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 手数料情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_Tesuuryou extends AbstractExDBTable<IT_Tesuuryou> {

    public GenQIT_Tesuuryou() {
        this("IT_Tesuuryou");
    }

    public GenQIT_Tesuuryou(String pAlias) {
        super("IT_Tesuuryou", IT_Tesuuryou.class, pAlias);
    }

    public String IT_Tesuuryou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_Tesuuryou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_Tesuuryou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_Tesuuryou, C_TsrysyoriKbn> tsrysyorikbn = new ExDBFieldString<>("tsrysyorikbn", this, UserType_C_TsrysyoriKbn.class);

    public final ExDBFieldNumber<IT_Tesuuryou, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_Tesuuryou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_Tesuuryou, BizDateYM> kouryokuhasseiym = new ExDBFieldString<>("kouryokuhasseiym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_Tesuuryou, Integer> nyknkaisuuy = new ExDBFieldNumber<>("nyknkaisuuy", this);

    public final ExDBFieldNumber<IT_Tesuuryou, Integer> nyknkaisuum = new ExDBFieldNumber<>("nyknkaisuum", this);

    public final ExDBFieldString<IT_Tesuuryou, C_UmuKbn> mikeikapariflg = new ExDBFieldString<>("mikeikapariflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_Tesuuryou, C_UmuKbn> misyuupariflg = new ExDBFieldString<>("misyuupariflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<IT_Tesuuryou> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);

    public final ExDBFieldBizCurrency<IT_Tesuuryou> iktp = new ExDBFieldBizCurrency<>("iktp", this);

    public final ExDBFieldString<IT_Tesuuryou, BizDateYM> seisekiym = new ExDBFieldString<>("seisekiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_Tesuuryou, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_Tesuuryou, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldBizCurrency<IT_Tesuuryou> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_Tesuuryou, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_Tesuuryou, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldString<IT_Tesuuryou, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<IT_Tesuuryou, String> smbckanriid = new ExDBFieldString<>("smbckanriid", this);

    public final ExDBFieldString<IT_Tesuuryou, C_Boskykjyoutai> boskykjyoutai = new ExDBFieldString<>("boskykjyoutai", this, UserType_C_Boskykjyoutai.class);

    public final ExDBFieldString<IT_Tesuuryou, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_Tesuuryou, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_Tesuuryou, BizDate> nyknymd = new ExDBFieldString<>("nyknymd", this, BizDateType.class);

    public final ExDBFieldString<IT_Tesuuryou, BizNumber> yenkansantkykwsrate = new ExDBFieldString<>("yenkansantkykwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_Tesuuryou, BizDate> yenkansantkykwsrateymd = new ExDBFieldString<>("yenkansantkykwsrateymd", this, BizDateType.class);

    public final ExDBFieldString<IT_Tesuuryou, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_Tesuuryou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_Tesuuryou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_Tesuuryou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
