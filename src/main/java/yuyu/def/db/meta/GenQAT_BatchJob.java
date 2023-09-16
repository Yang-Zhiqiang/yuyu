package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.db.entity.AT_BatchJob;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BatchJyoutaiKbn;
import yuyu.def.db.type.UserType_C_BatchKidouKbn;
import yuyu.def.db.type.UserType_C_BatchResultKbn;

/**
 * バッチジョブテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_BatchJob extends AbstractExDBTable<AT_BatchJob> {

    public GenQAT_BatchJob() {
        this("AT_BatchJob");
    }

    public GenQAT_BatchJob(String pAlias) {
        super("AT_BatchJob", AT_BatchJob.class, pAlias);
    }

    public String AT_BatchJob() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_BatchJob, String> batchJobId = new ExDBFieldString<>("batchJobId", this);

    public final ExDBFieldString<AT_BatchJob, String> batchId = new ExDBFieldString<>("batchId", this);

    public final ExDBFieldString<AT_BatchJob, C_BatchKidouKbn> batchKidouKbn = new ExDBFieldString<>("batchKidouKbn", this, UserType_C_BatchKidouKbn.class);

    public final ExDBFieldString<AT_BatchJob, C_BatchJyoutaiKbn> batchJyoutaiKbn = new ExDBFieldString<>("batchJyoutaiKbn", this, UserType_C_BatchJyoutaiKbn.class);

    public final ExDBFieldString<AT_BatchJob, C_BatchResultKbn> batchResultKbn = new ExDBFieldString<>("batchResultKbn", this, UserType_C_BatchResultKbn.class);

    public final ExDBFieldString<AT_BatchJob, BizDate> batchSyoriYmd = new ExDBFieldString<>("batchSyoriYmd", this, BizDateType.class);

    public final ExDBFieldString<AT_BatchJob, String> batchStartTime = new ExDBFieldString<>("batchStartTime", this);

    public final ExDBFieldString<AT_BatchJob, String> batchEndTime = new ExDBFieldString<>("batchEndTime", this);

    public final ExDBFieldString<AT_BatchJob, String> elapsedTime = new ExDBFieldString<>("elapsedTime", this);

    public final ExDBFieldNumber<AT_BatchJob, Long> elapsedSeconds = new ExDBFieldNumber<>("elapsedSeconds", this);
}
