package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 申込書類未到着リスト情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHV_MosSyoruiMitoutyakuList extends AbstractExDBTable<HV_MosSyoruiMitoutyakuList> {

    public GenQHV_MosSyoruiMitoutyakuList() {
        this("HV_MosSyoruiMitoutyakuList");
    }

    public GenQHV_MosSyoruiMitoutyakuList(String pAlias) {
        super("HV_MosSyoruiMitoutyakuList", HV_MosSyoruiMitoutyakuList.class, pAlias);
    }

    public String HV_MosSyoruiMitoutyakuList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> simukebanknmkn = new ExDBFieldString<>("simukebanknmkn", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> simukebanknmeiji = new ExDBFieldString<>("simukebanknmeiji", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> simuketennmkn = new ExDBFieldString<>("simuketennmkn", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> simuketennmeiji = new ExDBFieldString<>("simuketennmeiji", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, BizDate> knjyymd = new ExDBFieldString<>("knjyymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<HV_MosSyoruiMitoutyakuList> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldBizCurrency<HV_MosSyoruiMitoutyakuList> dengk = new ExDBFieldBizCurrency<>("dengk", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> nyuukinoyadrtennm = new ExDBFieldString<>("nyuukinoyadrtennm", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, C_UmuKbn> mostokusokuumu = new ExDBFieldString<>("mostokusokuumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, C_HrkmnykndatarenmotoKbn> hrkmnykndatarenmotoKbn = new ExDBFieldString<>("hrkmnykndatarenmotoKbn", this, UserType_C_HrkmnykndatarenmotoKbn.class);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, String> syouhnno = new ExDBFieldString<>("syouhnno", this);

    public final ExDBFieldString<HV_MosSyoruiMitoutyakuList, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);
}
