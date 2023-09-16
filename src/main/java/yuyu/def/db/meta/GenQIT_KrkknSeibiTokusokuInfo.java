package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KrkknSeibiTokusokuInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KrkriyuuKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 仮受金整備督促情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KrkknSeibiTokusokuInfo extends AbstractExDBTable<IT_KrkknSeibiTokusokuInfo> {

    public GenQIT_KrkknSeibiTokusokuInfo() {
        this("IT_KrkknSeibiTokusokuInfo");
    }

    public GenQIT_KrkknSeibiTokusokuInfo(String pAlias) {
        super("IT_KrkknSeibiTokusokuInfo", IT_KrkknSeibiTokusokuInfo.class, pAlias);
    }

    public String IT_KrkknSeibiTokusokuInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_KrkknSeibiTokusokuInfo, Integer> krkno = new ExDBFieldNumber<>("krkno", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, String> atesakisosikicd = new ExDBFieldString<>("atesakisosikicd", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, String> atesakibusitucd = new ExDBFieldString<>("atesakibusitucd", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, C_UmuKbn> tyoukimiseibikrkumu = new ExDBFieldString<>("tyoukimiseibikrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, C_UmuKbn> hukusuukrkumu = new ExDBFieldString<>("hukusuukrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, BizDate> krkkeijyoymd = new ExDBFieldString<>("krkkeijyoymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KrkknSeibiTokusokuInfo> krkgk = new ExDBFieldBizCurrency<>("krkgk", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, C_KrkriyuuKbn> krkriyuukbn = new ExDBFieldString<>("krkriyuukbn", this, UserType_C_KrkriyuuKbn.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KrkknSeibiTokusokuInfo, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_KrkknSeibiTokusokuInfo, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, C_Hrkkaisuu> krkjhrkkaisuu = new ExDBFieldString<>("krkjhrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KrkknSeibiTokusokuInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
