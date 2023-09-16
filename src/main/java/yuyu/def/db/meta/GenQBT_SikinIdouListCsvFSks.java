package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouListCsvFSks;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SikinidoulistKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 資金移動リストＣＳＶファイル作成用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_SikinIdouListCsvFSks extends AbstractExDBTable<BT_SikinIdouListCsvFSks> {

    public GenQBT_SikinIdouListCsvFSks() {
        this("BT_SikinIdouListCsvFSks");
    }

    public GenQBT_SikinIdouListCsvFSks(String pAlias) {
        super("BT_SikinIdouListCsvFSks", BT_SikinIdouListCsvFSks.class, pAlias);
    }

    public String BT_SikinIdouListCsvFSks() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, C_SikinidoulistKbn> sikinidoulistkbn = new ExDBFieldString<>("sikinidoulistkbn", this, UserType_C_SikinidoulistKbn.class);

    public final ExDBFieldNumber<BT_SikinIdouListCsvFSks, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, BizDate> sikinidouymd = new ExDBFieldString<>("sikinidouymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<BT_SikinIdouListCsvFSks> sikinidoumeisaigk = new ExDBFieldBizCurrency<>("sikinidoumeisaigk", this);

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, C_Tuukasyu> syukkinkouzatuukasyu = new ExDBFieldString<>("syukkinkouzatuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, String> syukkinkouzano = new ExDBFieldString<>("syukkinkouzano", this);

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, C_Tuukasyu> nyuukinkouzatuukasyu = new ExDBFieldString<>("nyuukinkouzatuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, String> nyuukinkouzano = new ExDBFieldString<>("nyuukinkouzano", this);

    public final ExDBFieldString<BT_SikinIdouListCsvFSks, BizDate> filesakuseiymd = new ExDBFieldString<>("filesakuseiymd", this, BizDateType.class);
}
