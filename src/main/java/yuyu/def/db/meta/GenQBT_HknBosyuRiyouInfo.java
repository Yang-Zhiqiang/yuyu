package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GwriyouKbn;
import yuyu.def.classification.C_GwtsryKbn;
import yuyu.def.classification.C_HitmbosyuuKbn;
import yuyu.def.classification.C_HokenbossysriyouKbn;
import yuyu.def.classification.C_InternetstzkriyouKbn;
import yuyu.def.classification.C_IssriyouKbn;
import yuyu.def.classification.C_LphteikeitiginKbn;
import yuyu.def.classification.C_TmbosyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BT_HknBosyuRiyouInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_GwriyouKbn;
import yuyu.def.db.type.UserType_C_GwtsryKbn;
import yuyu.def.db.type.UserType_C_HitmbosyuuKbn;
import yuyu.def.db.type.UserType_C_HokenbossysriyouKbn;
import yuyu.def.db.type.UserType_C_InternetstzkriyouKbn;
import yuyu.def.db.type.UserType_C_IssriyouKbn;
import yuyu.def.db.type.UserType_C_LphteikeitiginKbn;
import yuyu.def.db.type.UserType_C_TmbosyuuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;

/**
 * 保険募集システム利用情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HknBosyuRiyouInfo extends AbstractExDBTable<BT_HknBosyuRiyouInfo> {

    public GenQBT_HknBosyuRiyouInfo() {
        this("BT_HknBosyuRiyouInfo");
    }

    public GenQBT_HknBosyuRiyouInfo(String pAlias) {
        super("BT_HknBosyuRiyouInfo", BT_HknBosyuRiyouInfo.class, pAlias);
    }

    public String BT_HknBosyuRiyouInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_GwriyouKbn> gwriyoukbn = new ExDBFieldString<>("gwriyoukbn", this, UserType_C_GwriyouKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_UmuKbn> gwkykrendouumukbn = new ExDBFieldString<>("gwkykrendouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_UmuKbn> gwtsryrendouumukbn = new ExDBFieldString<>("gwtsryrendouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_UmuKbn> gwmisyuurendouumukbn = new ExDBFieldString<>("gwmisyuurendouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_IssriyouKbn> issriyoukbn = new ExDBFieldString<>("issriyoukbn", this, UserType_C_IssriyouKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, BizDate> gwtkyyoteiymd = new ExDBFieldString<>("gwtkyyoteiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, String> gwsousinsikibetusi = new ExDBFieldString<>("gwsousinsikibetusi", this);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_GwtsryKbn> gwtsrykbn = new ExDBFieldString<>("gwtsrykbn", this, UserType_C_GwtsryKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_InternetstzkriyouKbn> internetstzkriyoukbn = new ExDBFieldString<>("internetstzkriyoukbn", this, UserType_C_InternetstzkriyouKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_HokenbossysriyouKbn> hokenbossysriyoukbn = new ExDBFieldString<>("hokenbossysriyoukbn", this, UserType_C_HokenbossysriyouKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_LphteikeitiginKbn> lphteikeitiginkbn = new ExDBFieldString<>("lphteikeitiginkbn", this, UserType_C_LphteikeitiginKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_TmbosyuuKbn> tmbosyuukbn = new ExDBFieldString<>("tmbosyuukbn", this, UserType_C_TmbosyuuKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_HitmbosyuuKbn> hitmbosyuukbn = new ExDBFieldString<>("hitmbosyuukbn", this, UserType_C_HitmbosyuuKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_YouhiblnkKbn> kansyoutuutisakuseiyhkbn = new ExDBFieldString<>("kansyoutuutisakuseiyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, C_YouhiblnkKbn> fatcakakuninyhkbn = new ExDBFieldString<>("fatcakakuninyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_HknBosyuRiyouInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
