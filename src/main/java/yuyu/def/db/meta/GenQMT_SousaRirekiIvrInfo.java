package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsGyoumuCdKbn;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.classification.C_SetudanKasyoKbn;
import yuyu.def.classification.C_SetudanRiyuuKbn;
import yuyu.def.classification.C_TtdkIsihyouziKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import yuyu.def.db.type.UserType_C_DsGyoumuCdKbn;
import yuyu.def.db.type.UserType_C_DsSyoriNaiyouKbn;
import yuyu.def.db.type.UserType_C_SetudanKasyoKbn;
import yuyu.def.db.type.UserType_C_SetudanRiyuuKbn;
import yuyu.def.db.type.UserType_C_TtdkIsihyouziKbn;
import yuyu.def.db.type.UserType_C_TtdkKekkaKbn;

/**
 * 操作履歴ＩＶＲ情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_SousaRirekiIvrInfo extends AbstractExDBTable<MT_SousaRirekiIvrInfo> {

    public GenQMT_SousaRirekiIvrInfo() {
        this("MT_SousaRirekiIvrInfo");
    }

    public GenQMT_SousaRirekiIvrInfo(String pAlias) {
        super("MT_SousaRirekiIvrInfo", MT_SousaRirekiIvrInfo.class, pAlias);
    }

    public String MT_SousaRirekiIvrInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, String> ttdksikibetuid = new ExDBFieldString<>("ttdksikibetuid", this);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, String> tyakusinymd = new ExDBFieldString<>("tyakusinymd", this);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, C_DsGyoumuCdKbn> dsgyoumucd = new ExDBFieldString<>("dsgyoumucd", this, UserType_C_DsGyoumuCdKbn.class);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, C_DsSyoriNaiyouKbn> syorinaiyoukbn = new ExDBFieldString<>("syorinaiyoukbn", this, UserType_C_DsSyoriNaiyouKbn.class);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, String> callid = new ExDBFieldString<>("callid", this);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, C_TtdkKekkaKbn> dssyorikekkakbn = new ExDBFieldString<>("dssyorikekkakbn", this, UserType_C_TtdkKekkaKbn.class);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, C_SetudanKasyoKbn> setudankasyokbn = new ExDBFieldString<>("setudankasyokbn", this, UserType_C_SetudanKasyoKbn.class);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, C_SetudanRiyuuKbn> setudanriyuukbn = new ExDBFieldString<>("setudanriyuukbn", this, UserType_C_SetudanRiyuuKbn.class);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, String> tuuwatime = new ExDBFieldString<>("tuuwatime", this);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, C_TtdkIsihyouziKbn> ttdkisihyouzikbn = new ExDBFieldString<>("ttdkisihyouzikbn", this, UserType_C_TtdkIsihyouziKbn.class);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_SousaRirekiIvrInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
