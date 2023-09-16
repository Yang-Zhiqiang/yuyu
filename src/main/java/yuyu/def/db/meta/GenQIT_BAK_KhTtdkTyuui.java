package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IT_BAK_KhTtdkTyuui;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KktyuitaKbn;
import yuyu.def.db.type.UserType_C_KykdrDouiYouhiKbn;
import yuyu.def.db.type.UserType_C_KykdrknHtdjytKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;

/**
 * 契約保全手続注意バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhTtdkTyuui extends AbstractExDBTable<IT_BAK_KhTtdkTyuui> {

    public GenQIT_BAK_KhTtdkTyuui() {
        this("IT_BAK_KhTtdkTyuui");
    }

    public GenQIT_BAK_KhTtdkTyuui(String pAlias) {
        super("IT_BAK_KhTtdkTyuui", IT_BAK_KhTtdkTyuui.class, pAlias);
    }

    public String IT_BAK_KhTtdkTyuui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, BizDate> ttdktyuuisetymd = new ExDBFieldString<>("ttdktyuuisetymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuisetnm = new ExDBFieldString<>("ttdktyuuisetnm", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_KktyuitaKbn> kktyuitakbn = new ExDBFieldString<>("kktyuitakbn", this, UserType_C_KktyuitaKbn.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuinaiyou1 = new ExDBFieldString<>("ttdktyuuinaiyou1", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuinaiyou2 = new ExDBFieldString<>("ttdktyuuinaiyou2", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuinaiyou3 = new ExDBFieldString<>("ttdktyuuinaiyou3", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_TtdktyuuiKbn> ttdktyuuikbn1 = new ExDBFieldString<>("ttdktyuuikbn1", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_TtdktyuuiKbn> ttdktyuuikbn2 = new ExDBFieldString<>("ttdktyuuikbn2", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_TtdktyuuiKbn> ttdktyuuikbn3 = new ExDBFieldString<>("ttdktyuuikbn3", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_TtdktyuuiKbn> ttdktyuuikbn4 = new ExDBFieldString<>("ttdktyuuikbn4", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_TtdktyuuiKbn> ttdktyuuikbn5 = new ExDBFieldString<>("ttdktyuuikbn5", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuikbnhsknaiyou1 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou1", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuikbnhsknaiyou2 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou2", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuikbnhsknaiyou3 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou3", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuikbnhsknaiyou4 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou4", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> ttdktyuuikbnhsknaiyou5 = new ExDBFieldString<>("ttdktyuuikbnhsknaiyou5", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, BizDate> ttdktyuuikbnsetymd1 = new ExDBFieldString<>("ttdktyuuikbnsetymd1", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, BizDate> ttdktyuuikbnsetymd2 = new ExDBFieldString<>("ttdktyuuikbnsetymd2", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, BizDate> ttdktyuuikbnsetymd3 = new ExDBFieldString<>("ttdktyuuikbnsetymd3", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, BizDate> ttdktyuuikbnsetymd4 = new ExDBFieldString<>("ttdktyuuikbnsetymd4", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, BizDate> ttdktyuuikbnsetymd5 = new ExDBFieldString<>("ttdktyuuikbnsetymd5", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> setsosikicd1 = new ExDBFieldString<>("setsosikicd1", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> setsosikicd2 = new ExDBFieldString<>("setsosikicd2", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> setsosikicd3 = new ExDBFieldString<>("setsosikicd3", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> setsosikicd4 = new ExDBFieldString<>("setsosikicd4", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> setsosikicd5 = new ExDBFieldString<>("setsosikicd5", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_KykdrknHtdjytKbn> kykdrknhatudoujyoutai = new ExDBFieldString<>("kykdrknhatudoujyoutai", this, UserType_C_KykdrknHtdjytKbn.class);

    public final ExDBFieldString<IT_BAK_KhTtdkTyuui, C_KykdrDouiYouhiKbn> kykdrdouiyouhi = new ExDBFieldString<>("kykdrdouiyouhi", this, UserType_C_KykdrDouiYouhiKbn.class);
}
