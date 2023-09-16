package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 外貨振込入金データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_GaikaHrkmNyknData extends AbstractExDBTable<HT_GaikaHrkmNyknData> {

    public GenQHT_GaikaHrkmNyknData() {
        this("HT_GaikaHrkmNyknData");
    }

    public GenQHT_GaikaHrkmNyknData(String pAlias) {
        super("HT_GaikaHrkmNyknData", HT_GaikaHrkmNyknData.class, pAlias);
    }

    public String HT_GaikaHrkmNyknData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> syouhnno = new ExDBFieldString<>("syouhnno", this);

    public final ExDBFieldNumber<HT_GaikaHrkmNyknData, Integer> syubetucd = new ExDBFieldNumber<>("syubetucd", this);

    public final ExDBFieldNumber<HT_GaikaHrkmNyknData, Integer> cdkbn = new ExDBFieldNumber<>("cdkbn", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, BizDate> knjyymdfrom = new ExDBFieldString<>("knjyymdfrom", this, BizDateType.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, BizDate> knjyymdto = new ExDBFieldString<>("knjyymdto", this, BizDateType.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> kznmkn = new ExDBFieldString<>("kznmkn", this);

    public final ExDBFieldNumber<HT_GaikaHrkmNyknData, Integer> kasikosikbn = new ExDBFieldNumber<>("kasikosikbn", this);

    public final ExDBFieldBizCurrency<HT_GaikaHrkmNyknData> trhkmaezndk = new ExDBFieldBizCurrency<>("trhkmaezndk", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> trhksakisyoukaino = new ExDBFieldString<>("trhksakisyoukaino", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, BizDate> knjyymd = new ExDBFieldString<>("knjyymd", this, BizDateType.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, BizDate> ksnymd = new ExDBFieldString<>("ksnymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_GaikaHrkmNyknData, Integer> iribaraikbn = new ExDBFieldNumber<>("iribaraikbn", this);

    public final ExDBFieldNumber<HT_GaikaHrkmNyknData, Integer> trhkkbn = new ExDBFieldNumber<>("trhkkbn", this);

    public final ExDBFieldBizCurrency<HT_GaikaHrkmNyknData> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldBizCurrency<HT_GaikaHrkmNyknData> dengk = new ExDBFieldBizCurrency<>("dengk", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> hrkmirninnm140 = new ExDBFieldString<>("hrkmirninnm140", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> simukebanknmeiji = new ExDBFieldString<>("simukebanknmeiji", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> simuketennmeiji = new ExDBFieldString<>("simuketennmeiji", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> tekiyounaiyoueiji = new ExDBFieldString<>("tekiyounaiyoueiji", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_TaisyouKbn> oyadrtensyoritarget = new ExDBFieldString<>("oyadrtensyoritarget", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_TaisyouKbn> jidonykntargethyouji = new ExDBFieldString<>("jidonykntargethyouji", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_UmuKbn> mostokusokuumu = new ExDBFieldString<>("mostokusokuumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_HrkmnykndatarenmotoKbn> hrkmnykndatarenmotoKbn = new ExDBFieldString<>("hrkmnykndatarenmotoKbn", this, UserType_C_HrkmnykndatarenmotoKbn.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> nyuukinoyadrtennm = new ExDBFieldString<>("nyuukinoyadrtennm", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> honkouzacd = new ExDBFieldString<>("honkouzacd", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_GaikaHrkmNyknData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
