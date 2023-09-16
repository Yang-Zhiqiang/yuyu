package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsMailHaisin extends AbstractExDBTable<MT_DsMailHaisin> {

    public GenQMT_DsMailHaisin() {
        this("MT_DsMailHaisin");
    }

    public GenQMT_DsMailHaisin(String pAlias) {
        super("MT_DsMailHaisin", MT_DsMailHaisin.class, pAlias);
    }

    public String MT_DsMailHaisin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsMailHaisin, BizDate> sousinymd = new ExDBFieldString<>("sousinymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsMailHaisin, String> dskokmailaddressskbtkey = new ExDBFieldString<>("dskokmailaddressskbtkey", this);

    public final ExDBFieldString<MT_DsMailHaisin, C_DsSousinMailSyubetuKbn> dssousinmailsyubetukbn = new ExDBFieldString<>("dssousinmailsyubetukbn", this, UserType_C_DsSousinMailSyubetuKbn.class);

    public final ExDBFieldString<MT_DsMailHaisin, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> dsmailaddress = new ExDBFieldString<>("dsmailaddress", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou01 = new ExDBFieldString<>("sasikomikoumokusyou01", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou02 = new ExDBFieldString<>("sasikomikoumokusyou02", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou03 = new ExDBFieldString<>("sasikomikoumokusyou03", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou04 = new ExDBFieldString<>("sasikomikoumokusyou04", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou05 = new ExDBFieldString<>("sasikomikoumokusyou05", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou06 = new ExDBFieldString<>("sasikomikoumokusyou06", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou07 = new ExDBFieldString<>("sasikomikoumokusyou07", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou08 = new ExDBFieldString<>("sasikomikoumokusyou08", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou09 = new ExDBFieldString<>("sasikomikoumokusyou09", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou10 = new ExDBFieldString<>("sasikomikoumokusyou10", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou11 = new ExDBFieldString<>("sasikomikoumokusyou11", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou12 = new ExDBFieldString<>("sasikomikoumokusyou12", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou13 = new ExDBFieldString<>("sasikomikoumokusyou13", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou14 = new ExDBFieldString<>("sasikomikoumokusyou14", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou15 = new ExDBFieldString<>("sasikomikoumokusyou15", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou16 = new ExDBFieldString<>("sasikomikoumokusyou16", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou17 = new ExDBFieldString<>("sasikomikoumokusyou17", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou18 = new ExDBFieldString<>("sasikomikoumokusyou18", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou19 = new ExDBFieldString<>("sasikomikoumokusyou19", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou20 = new ExDBFieldString<>("sasikomikoumokusyou20", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou21 = new ExDBFieldString<>("sasikomikoumokusyou21", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou22 = new ExDBFieldString<>("sasikomikoumokusyou22", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou23 = new ExDBFieldString<>("sasikomikoumokusyou23", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou24 = new ExDBFieldString<>("sasikomikoumokusyou24", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou25 = new ExDBFieldString<>("sasikomikoumokusyou25", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou26 = new ExDBFieldString<>("sasikomikoumokusyou26", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou27 = new ExDBFieldString<>("sasikomikoumokusyou27", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou28 = new ExDBFieldString<>("sasikomikoumokusyou28", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou29 = new ExDBFieldString<>("sasikomikoumokusyou29", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokusyou30 = new ExDBFieldString<>("sasikomikoumokusyou30", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu01 = new ExDBFieldString<>("sasikomikoumokutyuu01", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu02 = new ExDBFieldString<>("sasikomikoumokutyuu02", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu03 = new ExDBFieldString<>("sasikomikoumokutyuu03", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu04 = new ExDBFieldString<>("sasikomikoumokutyuu04", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu05 = new ExDBFieldString<>("sasikomikoumokutyuu05", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu06 = new ExDBFieldString<>("sasikomikoumokutyuu06", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu07 = new ExDBFieldString<>("sasikomikoumokutyuu07", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu08 = new ExDBFieldString<>("sasikomikoumokutyuu08", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu09 = new ExDBFieldString<>("sasikomikoumokutyuu09", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu10 = new ExDBFieldString<>("sasikomikoumokutyuu10", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu11 = new ExDBFieldString<>("sasikomikoumokutyuu11", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu12 = new ExDBFieldString<>("sasikomikoumokutyuu12", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu13 = new ExDBFieldString<>("sasikomikoumokutyuu13", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu14 = new ExDBFieldString<>("sasikomikoumokutyuu14", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu15 = new ExDBFieldString<>("sasikomikoumokutyuu15", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu16 = new ExDBFieldString<>("sasikomikoumokutyuu16", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu17 = new ExDBFieldString<>("sasikomikoumokutyuu17", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu18 = new ExDBFieldString<>("sasikomikoumokutyuu18", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu19 = new ExDBFieldString<>("sasikomikoumokutyuu19", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokutyuu20 = new ExDBFieldString<>("sasikomikoumokutyuu20", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai01 = new ExDBFieldString<>("sasikomikoumokudai01", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai02 = new ExDBFieldString<>("sasikomikoumokudai02", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai03 = new ExDBFieldString<>("sasikomikoumokudai03", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai04 = new ExDBFieldString<>("sasikomikoumokudai04", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai05 = new ExDBFieldString<>("sasikomikoumokudai05", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai06 = new ExDBFieldString<>("sasikomikoumokudai06", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai07 = new ExDBFieldString<>("sasikomikoumokudai07", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai08 = new ExDBFieldString<>("sasikomikoumokudai08", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai09 = new ExDBFieldString<>("sasikomikoumokudai09", this);

    public final ExDBFieldString<MT_DsMailHaisin, String> sasikomikoumokudai10 = new ExDBFieldString<>("sasikomikoumokudai10", this);
}
