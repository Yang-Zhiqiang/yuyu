package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_BatchLogReport;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * バッチログレポートテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_BatchLogReport extends AbstractExDBTable<AT_BatchLogReport> {

    public GenQAT_BatchLogReport() {
        this("AT_BatchLogReport");
    }

    public GenQAT_BatchLogReport(String pAlias) {
        super("AT_BatchLogReport", AT_BatchLogReport.class, pAlias);
    }

    public String AT_BatchLogReport() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_BatchLogReport, String> batchJobId = new ExDBFieldString<>("batchJobId", this);

    public final ExDBFieldString<AT_BatchLogReport, String> reportKey = new ExDBFieldString<>("reportKey", this);

    public final ExDBFieldString<AT_BatchLogReport, String> tyouhyouJoinKey = new ExDBFieldString<>("tyouhyouJoinKey", this);

    public final ExDBFieldString<AT_BatchLogReport, BizDate> batchSyoriYmd = new ExDBFieldString<>("batchSyoriYmd", this, BizDateType.class);
}
