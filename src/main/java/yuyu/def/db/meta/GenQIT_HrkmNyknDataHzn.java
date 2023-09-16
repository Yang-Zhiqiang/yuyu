package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_HrkmNyknDataHzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 振込入金データ（保全用）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HrkmNyknDataHzn extends AbstractExDBTable<IT_HrkmNyknDataHzn> {

    public GenQIT_HrkmNyknDataHzn() {
        this("IT_HrkmNyknDataHzn");
    }

    public GenQIT_HrkmNyknDataHzn(String pAlias) {
        super("IT_HrkmNyknDataHzn", IT_HrkmNyknDataHzn.class, pAlias);
    }

    public String IT_HrkmNyknDataHzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HrkmNyknDataHzn, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_HrkmNyknDataHzn, Integer> syubetucd = new ExDBFieldNumber<>("syubetucd", this);

    public final ExDBFieldNumber<IT_HrkmNyknDataHzn, Integer> cdkbn = new ExDBFieldNumber<>("cdkbn", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> knjyymdfrom = new ExDBFieldString<>("knjyymdfrom", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> knjyymdto = new ExDBFieldString<>("knjyymdto", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> kznmkn = new ExDBFieldString<>("kznmkn", this);

    public final ExDBFieldNumber<IT_HrkmNyknDataHzn, Integer> kasikosikbn = new ExDBFieldNumber<>("kasikosikbn", this);

    public final ExDBFieldNumber<IT_HrkmNyknDataHzn, Integer> tuutyousysykbn = new ExDBFieldNumber<>("tuutyousysykbn", this);

    public final ExDBFieldBizCurrency<IT_HrkmNyknDataHzn> trhkmaezndk = new ExDBFieldBizCurrency<>("trhkmaezndk", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> syoukaino = new ExDBFieldString<>("syoukaino", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> knjyymd = new ExDBFieldString<>("knjyymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> azkrhrdsymd = new ExDBFieldString<>("azkrhrdsymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_HrkmNyknDataHzn, Integer> iribaraikbn = new ExDBFieldNumber<>("iribaraikbn", this);

    public final ExDBFieldNumber<IT_HrkmNyknDataHzn, Integer> trhkkbn = new ExDBFieldNumber<>("trhkkbn", this);

    public final ExDBFieldBizCurrency<IT_HrkmNyknDataHzn> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldBizCurrency<IT_HrkmNyknDataHzn> tatenkengk = new ExDBFieldBizCurrency<>("tatenkengk", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> kknteijiymd = new ExDBFieldString<>("kknteijiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, BizDate> hwtrhnknymd = new ExDBFieldString<>("hwtrhnknymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> tgtkgtkbn = new ExDBFieldString<>("tgtkgtkbn", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> tgtkgtno = new ExDBFieldString<>("tgtkgtno", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> ryoutenno = new ExDBFieldString<>("ryoutenno", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> hrkmirnincd = new ExDBFieldString<>("hrkmirnincd", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> simukebanknmkn = new ExDBFieldString<>("simukebanknmkn", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> simuketennmkn = new ExDBFieldString<>("simuketennmkn", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> tekiyounaiyou = new ExDBFieldString<>("tekiyounaiyou", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> ediinfo = new ExDBFieldString<>("ediinfo", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HrkmNyknDataHzn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
