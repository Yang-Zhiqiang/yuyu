package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BatchHeisouKbn;
import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.type.UserType_C_BatchHeisouKbn;
import yuyu.def.db.type.UserType_C_BatchModeKbn;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * バッチマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_Batch extends AbstractExDBTable<AM_Batch> {

    public GenQAM_Batch() {
        this("AM_Batch");
    }

    public GenQAM_Batch(String pAlias) {
        super("AM_Batch", AM_Batch.class, pAlias);
    }

    public String AM_Batch() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_Batch, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AM_Batch, String> batchClass = new ExDBFieldString<>("batchClass", this);

    public final ExDBFieldString<AM_Batch, String> paramBeanClass = new ExDBFieldString<>("paramBeanClass", this);

    public final ExDBFieldString<AM_Batch, C_KahiKbn> tajuukidouKahiKbn = new ExDBFieldString<>("tajuukidouKahiKbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<AM_Batch, C_BatchModeKbn> batchMode = new ExDBFieldString<>("batchMode", this, UserType_C_BatchModeKbn.class);

    public final ExDBFieldString<AM_Batch, C_KahiKbn> tyuudanKahi = new ExDBFieldString<>("tyuudanKahi", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<AM_Batch, C_KahiKbn> onlineHeisouKahiKbn = new ExDBFieldString<>("onlineHeisouKahiKbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<AM_Batch, C_BatchHeisouKbn> batchHeisouKbn = new ExDBFieldString<>("batchHeisouKbn", this, UserType_C_BatchHeisouKbn.class);
}
