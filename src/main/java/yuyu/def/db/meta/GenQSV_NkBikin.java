package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Nkshrhsijiyuu;
import yuyu.def.classification.C_TyuuitratkiKbn;
import yuyu.def.db.entity.SV_NkBikin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Nkshrhsijiyuu;
import yuyu.def.db.type.UserType_C_TyuuitratkiKbn;

/**
 * 年金備金ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_NkBikin extends AbstractExDBTable<SV_NkBikin> {

    public GenQSV_NkBikin() {
        this("SV_NkBikin");
    }

    public GenQSV_NkBikin(String pAlias) {
        super("SV_NkBikin", SV_NkBikin.class, pAlias);
    }

    public String SV_NkBikin() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<SV_NkBikin, Integer> renno8keta = new ExDBFieldNumber<>("renno8keta", this);

    public final ExDBFieldString<SV_NkBikin, BizDate> seisikakymd = new ExDBFieldString<>("seisikakymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, BizDate> nkkknsetymd = new ExDBFieldString<>("nkkknsetymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, BizDate> nextnsymd = new ExDBFieldString<>("nextnsymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<SV_NkBikin, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldBizCurrency<SV_NkBikin> teikihongk = new ExDBFieldBizCurrency<>("teikihongk", this);

    public final ExDBFieldString<SV_NkBikin, String> teinkspan = new ExDBFieldString<>("teinkspan", this);

    public final ExDBFieldString<SV_NkBikin, String> teinksyu = new ExDBFieldString<>("teinksyu", this);

    public final ExDBFieldString<SV_NkBikin, C_NenkinJimuTesuuryouKbn> nenkinjimutesuuryoukbn = new ExDBFieldString<>("nenkinjimutesuuryoukbn", this, UserType_C_NenkinJimuTesuuryouKbn.class);

    public final ExDBFieldString<SV_NkBikin, String> nenkinkaisigoyoteiriritukbn = new ExDBFieldString<>("nenkinkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<SV_NkBikin, C_NenkinKigouSedaiKbn> nenkinkigousedaikbn = new ExDBFieldString<>("nenkinkigousedaikbn", this, UserType_C_NenkinKigouSedaiKbn.class);

    public final ExDBFieldString<SV_NkBikin, C_NenkinKbn> nenkinkbn = new ExDBFieldString<>("nenkinkbn", this, UserType_C_NenkinKbn.class);

    public final ExDBFieldString<SV_NkBikin, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, BizDate> nkkknmanryouymd = new ExDBFieldString<>("nkkknmanryouymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, C_Nkshrhsijiyuu> nkshrhsijiyuu = new ExDBFieldString<>("nkshrhsijiyuu", this, UserType_C_Nkshrhsijiyuu.class);

    public final ExDBFieldString<SV_NkBikin, C_NkSyoumetuCd> nksyoumetucd = new ExDBFieldString<>("nksyoumetucd", this, UserType_C_NkSyoumetuCd.class);

    public final ExDBFieldString<SV_NkBikin, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldString<SV_NkBikin, C_Bnshrkaisuu> bnshrkaisuu = new ExDBFieldString<>("bnshrkaisuu", this, UserType_C_Bnshrkaisuu.class);

    public final ExDBFieldString<SV_NkBikin, C_TyuuitratkiKbn> tyuuitratkikbn = new ExDBFieldString<>("tyuuitratkikbn", this, UserType_C_TyuuitratkiKbn.class);

    public final ExDBFieldString<SV_NkBikin, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_NkBikin, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_NkBikin, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_NkBikin, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkBikin, String> tsinyno = new ExDBFieldString<>("tsinyno", this);
}
