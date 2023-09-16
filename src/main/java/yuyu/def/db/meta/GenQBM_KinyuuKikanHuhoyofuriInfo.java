package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TapekoukanKbn;
import yuyu.def.classification.C_TsrkeisanhouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_TapekoukanKbn;
import yuyu.def.db.type.UserType_C_TsrkeisanhouKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 金融機関普保預振情報マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KinyuuKikanHuhoyofuriInfo extends AbstractExDBTable<BM_KinyuuKikanHuhoyofuriInfo> {

    public GenQBM_KinyuuKikanHuhoyofuriInfo() {
        this("BM_KinyuuKikanHuhoyofuriInfo");
    }

    public GenQBM_KinyuuKikanHuhoyofuriInfo(String pAlias) {
        super("BM_KinyuuKikanHuhoyofuriInfo", BM_KinyuuKikanHuhoyofuriInfo.class, pAlias);
    }

    public String BM_KinyuuKikanHuhoyofuriInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, BizDate> yofurikyouteikaisiymd = new ExDBFieldString<>("yofurikyouteikaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, BizDate> yofurikyouteikaijyoymd = new ExDBFieldString<>("yofurikyouteikaijyoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, String> itakusyakinyuucd = new ExDBFieldString<>("itakusyakinyuucd", this);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, String> itakusyasitencd = new ExDBFieldString<>("itakusyasitencd", this);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, C_YokinKbn> itakusyayokinkbn = new ExDBFieldString<>("itakusyayokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, String> itakusyakouzano = new ExDBFieldString<>("itakusyakouzano", this);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, C_TsrkeisanhouKbn> tsrkeisanhoukbn = new ExDBFieldString<>("tsrkeisanhoukbn", this, UserType_C_TsrkeisanhouKbn.class);

    public final ExDBFieldNumber<BM_KinyuuKikanHuhoyofuriInfo, Integer> kinyuutesuuryou = new ExDBFieldNumber<>("kinyuutesuuryou", this);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, String> itakusyacd = new ExDBFieldString<>("itakusyacd", this);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, C_TapekoukanKbn> tapekoukankbn1 = new ExDBFieldString<>("tapekoukankbn1", this, UserType_C_TapekoukanKbn.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, String> mdsisyacd = new ExDBFieldString<>("mdsisyacd", this);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, BizDate> zzkkyouteikaisiymd = new ExDBFieldString<>("zzkkyouteikaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, BizDate> zzkkyouteikaijyoymd = new ExDBFieldString<>("zzkkyouteikaijyoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, BizDate> csskyouteikaisiymd = new ExDBFieldString<>("csskyouteikaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, BizDate> csskyouteikaijyoymd = new ExDBFieldString<>("csskyouteikaijyoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_KinyuuKikanHuhoyofuriInfo, BizDate> huhoyofuriinfokousinymd = new ExDBFieldString<>("huhoyofuriinfokousinymd", this, BizDateType.class);
}
