package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ImagegazoukaKbn;
import yuyu.def.classification.C_KouteiSakuseiKeikiKbn;
import yuyu.def.classification.C_QrCodeTaikeiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.type.UserType_C_ImagegazoukaKbn;
import yuyu.def.db.type.UserType_C_KouteiSakuseiKeikiKbn;
import yuyu.def.db.type.UserType_C_QrCodeTaikeiKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_SyoruiTorikomiHouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 取込書類付加情報マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_TorikomiSyoruiHukaInfo extends AbstractExDBTable<BM_TorikomiSyoruiHukaInfo> {

    public GenQBM_TorikomiSyoruiHukaInfo() {
        this("BM_TorikomiSyoruiHukaInfo");
    }

    public GenQBM_TorikomiSyoruiHukaInfo(String pAlias) {
        super("BM_TorikomiSyoruiHukaInfo", BM_TorikomiSyoruiHukaInfo.class, pAlias);
    }

    public String BM_TorikomiSyoruiHukaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_SyoruiTorikomiHouKbn> syoruitorikomihoukbn = new ExDBFieldString<>("syoruitorikomihoukbn", this, UserType_C_SyoruiTorikomiHouKbn.class);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_KouteiSakuseiKeikiKbn> kouteisakuseikeiki = new ExDBFieldString<>("kouteisakuseikeiki", this, UserType_C_KouteiSakuseiKeikiKbn.class);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_QrCodeTaikeiKbn> qrcodetaikeikbn = new ExDBFieldString<>("qrcodetaikeikbn", this, UserType_C_QrCodeTaikeiKbn.class);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_YouhiKbn> ttykknryouhi = new ExDBFieldString<>("ttykknryouhi", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldNumber<BM_TorikomiSyoruiHukaInfo, Integer> hozonKikan = new ExDBFieldNumber<>("hozonKikan", this);

    public final ExDBFieldNumber<BM_TorikomiSyoruiHukaInfo, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_UmuKbn> qrsealumukbn = new ExDBFieldString<>("qrsealumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_TorikomiSyoruiHukaInfo, C_ImagegazoukaKbn> imagegazoukakbn = new ExDBFieldString<>("imagegazoukakbn", this, UserType_C_ImagegazoukaKbn.class);
}
