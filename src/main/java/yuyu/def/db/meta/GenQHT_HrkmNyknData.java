package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_HrkmNyknData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 振込入金データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_HrkmNyknData extends AbstractExDBTable<HT_HrkmNyknData> {

    public GenQHT_HrkmNyknData() {
        this("HT_HrkmNyknData");
    }

    public GenQHT_HrkmNyknData(String pAlias) {
        super("HT_HrkmNyknData", HT_HrkmNyknData.class, pAlias);
    }

    public String HT_HrkmNyknData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_HrkmNyknData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknData, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> syouhnno = new ExDBFieldString<>("syouhnno", this);

    public final ExDBFieldNumber<HT_HrkmNyknData, Integer> syubetucd = new ExDBFieldNumber<>("syubetucd", this);

    public final ExDBFieldNumber<HT_HrkmNyknData, Integer> cdkbn = new ExDBFieldNumber<>("cdkbn", this);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> knjyymdfrom = new ExDBFieldString<>("knjyymdfrom", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> knjyymdto = new ExDBFieldString<>("knjyymdto", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<HT_HrkmNyknData, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_HrkmNyknData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> kznmkn = new ExDBFieldString<>("kznmkn", this);

    public final ExDBFieldNumber<HT_HrkmNyknData, Integer> kasikosikbn = new ExDBFieldNumber<>("kasikosikbn", this);

    public final ExDBFieldNumber<HT_HrkmNyknData, Integer> tuutyousysykbn = new ExDBFieldNumber<>("tuutyousysykbn", this);

    public final ExDBFieldBizCurrency<HT_HrkmNyknData> trhkmaezndk = new ExDBFieldBizCurrency<>("trhkmaezndk", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> syoukaino = new ExDBFieldString<>("syoukaino", this);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> knjyymd = new ExDBFieldString<>("knjyymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> azkrhrdsymd = new ExDBFieldString<>("azkrhrdsymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_HrkmNyknData, Integer> iribaraikbn = new ExDBFieldNumber<>("iribaraikbn", this);

    public final ExDBFieldNumber<HT_HrkmNyknData, Integer> trhkkbn = new ExDBFieldNumber<>("trhkkbn", this);

    public final ExDBFieldBizCurrency<HT_HrkmNyknData> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldBizCurrency<HT_HrkmNyknData> tatenkengk = new ExDBFieldBizCurrency<>("tatenkengk", this);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> kknteijiymd = new ExDBFieldString<>("kknteijiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknData, BizDate> hwtrhnknymd = new ExDBFieldString<>("hwtrhnknymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknData, String> tgtkgtkbn = new ExDBFieldString<>("tgtkgtkbn", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> tgtkgtno = new ExDBFieldString<>("tgtkgtno", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> ryoutenno = new ExDBFieldString<>("ryoutenno", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> hrkmirnincd = new ExDBFieldString<>("hrkmirnincd", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> hrkmirninnm140 = new ExDBFieldString<>("hrkmirninnm140", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> simukebanknmkn = new ExDBFieldString<>("simukebanknmkn", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> simuketennmkn = new ExDBFieldString<>("simuketennmkn", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> tekiyounaiyou = new ExDBFieldString<>("tekiyounaiyou", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> ediinfo = new ExDBFieldString<>("ediinfo", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_HrkmNyknData, C_TaisyouKbn> oyadrtensyoritarget = new ExDBFieldString<>("oyadrtensyoritarget", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<HT_HrkmNyknData, C_TaisyouKbn> jidonykntargethyouji = new ExDBFieldString<>("jidonykntargethyouji", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<HT_HrkmNyknData, C_UmuKbn> mostokusokuumu = new ExDBFieldString<>("mostokusokuumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_HrkmNyknData, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<HT_HrkmNyknData, C_HrkmnykndatarenmotoKbn> hrkmnykndatarenmotoKbn = new ExDBFieldString<>("hrkmnykndatarenmotoKbn", this, UserType_C_HrkmnykndatarenmotoKbn.class);

    public final ExDBFieldString<HT_HrkmNyknData, String> nyuukinoyadrtennm = new ExDBFieldString<>("nyuukinoyadrtennm", this);

    public final ExDBFieldString<HT_HrkmNyknData, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_HrkmNyknData, String> honkouzacd = new ExDBFieldString<>("honkouzacd", this);

    public final ExDBFieldString<HT_HrkmNyknData, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);

    public final ExDBFieldString<HT_HrkmNyknData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_HrkmNyknData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
