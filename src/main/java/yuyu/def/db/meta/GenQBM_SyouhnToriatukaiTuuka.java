package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 商品取扱通貨マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SyouhnToriatukaiTuuka extends AbstractExDBTable<BM_SyouhnToriatukaiTuuka> {

    public GenQBM_SyouhnToriatukaiTuuka() {
        this("BM_SyouhnToriatukaiTuuka");
    }

    public GenQBM_SyouhnToriatukaiTuuka(String pAlias) {
        super("BM_SyouhnToriatukaiTuuka", BM_SyouhnToriatukaiTuuka.class, pAlias);
    }

    public String BM_SyouhnToriatukaiTuuka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SyouhnToriatukaiTuuka, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_SyouhnToriatukaiTuuka, BizDate> tkyfromymd = new ExDBFieldString<>("tkyfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SyouhnToriatukaiTuuka, BizDate> tkytoymd = new ExDBFieldString<>("tkytoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SyouhnToriatukaiTuuka, C_BlnktkumuKbn> zenkizennouumu = new ExDBFieldString<>("zenkizennouumu", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<BM_SyouhnToriatukaiTuuka, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_SyouhnToriatukaiTuuka, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);
}
