package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_NyuukinHuittiriyuuKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_NyuukinHuittiriyuuKbn;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 入金情報不一致ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_NyuukinJyouhouHuittiWk extends AbstractExDBTable<HW_NyuukinJyouhouHuittiWk> {

    public GenQHW_NyuukinJyouhouHuittiWk() {
        this("HW_NyuukinJyouhouHuittiWk");
    }

    public GenQHW_NyuukinJyouhouHuittiWk(String pAlias) {
        super("HW_NyuukinJyouhouHuittiWk", HW_NyuukinJyouhouHuittiWk.class, pAlias);
    }

    public String HW_NyuukinJyouhouHuittiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> hrkmirnincd = new ExDBFieldString<>("hrkmirnincd", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> hrkmirninnm140 = new ExDBFieldString<>("hrkmirninnm140", this);

    public final ExDBFieldBizCurrency<HW_NyuukinJyouhouHuittiWk> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> simukebanknm = new ExDBFieldString<>("simukebanknm", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> simuketennm = new ExDBFieldString<>("simuketennm", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, C_UmuKbn> seikeijizenkizennouumu = new ExDBFieldString<>("seikeijizenkizennouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, C_NyuukinHuittiriyuuKbn> nyuukinhuittiriyuukbn = new ExDBFieldString<>("nyuukinhuittiriyuukbn", this, UserType_C_NyuukinHuittiriyuuKbn.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, BizDate> knjyymd = new ExDBFieldString<>("knjyymd", this, BizDateType.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, C_HrkmnykndatarenmotoKbn> hrkmnykndatarenmotoKbn = new ExDBFieldString<>("hrkmnykndatarenmotoKbn", this, UserType_C_HrkmnykndatarenmotoKbn.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, C_TaisyouKbn> oyadrtensyoritarget = new ExDBFieldString<>("oyadrtensyoritarget", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HW_NyuukinJyouhouHuittiWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
