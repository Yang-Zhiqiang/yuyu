package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_ToriatukaibiKbn;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_ToriatukaibiKbn;

/**
 * 通貨別取扱休止日マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_TuukabetuKyuusibi extends AbstractExDBTable<BM_TuukabetuKyuusibi> {

    public GenQBM_TuukabetuKyuusibi() {
        this("BM_TuukabetuKyuusibi");
    }

    public GenQBM_TuukabetuKyuusibi(String pAlias) {
        super("BM_TuukabetuKyuusibi", BM_TuukabetuKyuusibi.class, pAlias);
    }

    public String BM_TuukabetuKyuusibi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_TuukabetuKyuusibi, BizDate> tuukatoriatukaiymd = new ExDBFieldString<>("tuukatoriatukaiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_TuukabetuKyuusibi, C_ToriatukaibiKbn> kyuusijpykbn = new ExDBFieldString<>("kyuusijpykbn", this, UserType_C_ToriatukaibiKbn.class);

    public final ExDBFieldString<BM_TuukabetuKyuusibi, C_ToriatukaibiKbn> kyuusiusdkbn = new ExDBFieldString<>("kyuusiusdkbn", this, UserType_C_ToriatukaibiKbn.class);

    public final ExDBFieldString<BM_TuukabetuKyuusibi, C_ToriatukaibiKbn> kyuusieurkbn = new ExDBFieldString<>("kyuusieurkbn", this, UserType_C_ToriatukaibiKbn.class);

    public final ExDBFieldString<BM_TuukabetuKyuusibi, C_ToriatukaibiKbn> kyuusiaudkbn = new ExDBFieldString<>("kyuusiaudkbn", this, UserType_C_ToriatukaibiKbn.class);
}
