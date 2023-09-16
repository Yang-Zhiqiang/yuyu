package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KouhuristatusKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KouhuristatusKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 新契約口振受付登録結果未反映テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkKouhuriUkTrkMihanei extends AbstractExDBTable<HT_SkKouhuriUkTrkMihanei> {

    public GenQHT_SkKouhuriUkTrkMihanei() {
        this("HT_SkKouhuriUkTrkMihanei");
    }

    public GenQHT_SkKouhuriUkTrkMihanei(String pAlias) {
        super("HT_SkKouhuriUkTrkMihanei", HT_SkKouhuriUkTrkMihanei.class, pAlias);
    }

    public String HT_SkKouhuriUkTrkMihanei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> syukkncd = new ExDBFieldString<>("syukkncd", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kinyuucd8keta = new ExDBFieldString<>("kinyuucd8keta", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, BizDate> kinyuukkntratkiymd = new ExDBFieldString<>("kinyuukkntratkiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kinyuukkntratkitime = new ExDBFieldString<>("kinyuukkntratkitime", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kinyuukkntratkino = new ExDBFieldString<>("kinyuukkntratkino", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kouhuriukchannelkbn = new ExDBFieldString<>("kouhuriukchannelkbn", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kouhuriokyakusamano = new ExDBFieldString<>("kouhuriokyakusamano", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> sitencd5keta = new ExDBFieldString<>("sitencd5keta", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kouzano8keta = new ExDBFieldString<>("kouzano8keta", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> itakusyacd = new ExDBFieldString<>("itakusyacd", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, BizDate> syukkntratkiymd = new ExDBFieldString<>("syukkntratkiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> syukkntratkitime = new ExDBFieldString<>("syukkntratkitime", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> syukkntratkino = new ExDBFieldString<>("syukkntratkino", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, C_KouhuristatusKbn> kouhuristatuskbn = new ExDBFieldString<>("kouhuristatuskbn", this, UserType_C_KouhuristatusKbn.class);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kouhurikekkacd = new ExDBFieldString<>("kouhurikekkacd", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> kouhurihonninkakkekka = new ExDBFieldString<>("kouhurihonninkakkekka", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkKouhuriUkTrkMihanei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
