package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Sznjk;
import yuyu.def.classification.C_UkehiDouKbn;
import yuyu.def.db.entity.SV_AlmNnknHyu;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Sznjk;
import yuyu.def.db.type.UserType_C_UkehiDouKbn;

/**
 * ＡＬＭ用年金保有明細ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_AlmNnknHyu extends AbstractExDBTable<SV_AlmNnknHyu> {

    public GenQSV_AlmNnknHyu() {
        this("SV_AlmNnknHyu");
    }

    public GenQSV_AlmNnknHyu(String pAlias) {
        super("SV_AlmNnknHyu", SV_AlmNnknHyu.class, pAlias);
    }

    public String SV_AlmNnknHyu() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<SV_AlmNnknHyu, Integer> renno8keta = new ExDBFieldNumber<>("renno8keta", this);

    public final ExDBFieldString<SV_AlmNnknHyu, C_Sznjk> sznjk = new ExDBFieldString<>("sznjk", this, UserType_C_Sznjk.class);

    public final ExDBFieldString<SV_AlmNnknHyu, BizDate> seisikakymd = new ExDBFieldString<>("seisikakymd", this, BizDateType.class);

    public final ExDBFieldString<SV_AlmNnknHyu, BizDate> nkkknsetymd = new ExDBFieldString<>("nkkknsetymd", this, BizDateType.class);

    public final ExDBFieldString<SV_AlmNnknHyu, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_AlmNnknHyu, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<SV_AlmNnknHyu, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldBizCurrency<SV_AlmNnknHyu> teikihongk = new ExDBFieldBizCurrency<>("teikihongk", this);

    public final ExDBFieldBizCurrency<SV_AlmNnknHyu> teinkkikingk = new ExDBFieldBizCurrency<>("teinkkikingk", this);

    public final ExDBFieldString<SV_AlmNnknHyu, String> teinkspan = new ExDBFieldString<>("teinkspan", this);

    public final ExDBFieldString<SV_AlmNnknHyu, String> teinksyu = new ExDBFieldString<>("teinksyu", this);

    public final ExDBFieldString<SV_AlmNnknHyu, String> nenkinkaisigoyoteiriritukbn = new ExDBFieldString<>("nenkinkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<SV_AlmNnknHyu, C_NenkinKigouSedaiKbn> nenkinkigousedaikbn = new ExDBFieldString<>("nenkinkigousedaikbn", this, UserType_C_NenkinKigouSedaiKbn.class);

    public final ExDBFieldString<SV_AlmNnknHyu, C_NenkinKbn> nenkinkbn = new ExDBFieldString<>("nenkinkbn", this, UserType_C_NenkinKbn.class);

    public final ExDBFieldString<SV_AlmNnknHyu, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<SV_AlmNnknHyu, BizDate> nkkknmanryouymd = new ExDBFieldString<>("nkkknmanryouymd", this, BizDateType.class);

    public final ExDBFieldString<SV_AlmNnknHyu, C_NenkinJimuTesuuryouKbn> nenkinjimutesuuryoukbn = new ExDBFieldString<>("nenkinjimutesuuryoukbn", this, UserType_C_NenkinJimuTesuuryouKbn.class);

    public final ExDBFieldString<SV_AlmNnknHyu, C_NkSyoumetuCd> nksyoumetucd = new ExDBFieldString<>("nksyoumetucd", this, UserType_C_NkSyoumetuCd.class);

    public final ExDBFieldString<SV_AlmNnknHyu, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<SV_AlmNnknHyu, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldString<SV_AlmNnknHyu, String> bosyuucd1 = new ExDBFieldString<>("bosyuucd1", this);

    public final ExDBFieldString<SV_AlmNnknHyu, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_AlmNnknHyu, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_AlmNnknHyu, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_AlmNnknHyu, C_UkehiDouKbn> ukehidouitukbn = new ExDBFieldString<>("ukehidouitukbn", this, UserType_C_UkehiDouKbn.class);

    public final ExDBFieldString<SV_AlmNnknHyu, String> nkuktsakuinnmno = new ExDBFieldString<>("nkuktsakuinnmno", this);
}
