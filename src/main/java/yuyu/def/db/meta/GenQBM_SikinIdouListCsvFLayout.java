package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SikinidoukouzaKbn;
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SikinIdouListCsvFLayout;
import yuyu.def.db.type.UserType_C_SikinidoukouzaKbn;
import yuyu.def.db.type.UserType_C_SikinidoulistKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 資金移動リストＣＳＶファイルレイアウトマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SikinIdouListCsvFLayout extends AbstractExDBTable<BM_SikinIdouListCsvFLayout> {

    public GenQBM_SikinIdouListCsvFLayout() {
        this("BM_SikinIdouListCsvFLayout");
    }

    public GenQBM_SikinIdouListCsvFLayout(String pAlias) {
        super("BM_SikinIdouListCsvFLayout", BM_SikinIdouListCsvFLayout.class, pAlias);
    }

    public String BM_SikinIdouListCsvFLayout() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<BM_SikinIdouListCsvFLayout, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<BM_SikinIdouListCsvFLayout, C_SikinidoulistKbn> sikinidoulistkbn = new ExDBFieldString<>("sikinidoulistkbn", this, UserType_C_SikinidoulistKbn.class);

    public final ExDBFieldString<BM_SikinIdouListCsvFLayout, C_Tuukasyu> syukkinkouzatuukasyu = new ExDBFieldString<>("syukkinkouzatuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_SikinIdouListCsvFLayout, String> syukkinkouzano = new ExDBFieldString<>("syukkinkouzano", this);

    public final ExDBFieldString<BM_SikinIdouListCsvFLayout, C_SikinidoukouzaKbn> syukkinkouzakbn = new ExDBFieldString<>("syukkinkouzakbn", this, UserType_C_SikinidoukouzaKbn.class);

    public final ExDBFieldString<BM_SikinIdouListCsvFLayout, C_Tuukasyu> nyuukinkouzatuukasyu = new ExDBFieldString<>("nyuukinkouzatuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_SikinIdouListCsvFLayout, String> nyuukinkouzano = new ExDBFieldString<>("nyuukinkouzano", this);

    public final ExDBFieldString<BM_SikinIdouListCsvFLayout, C_SikinidoukouzaKbn> nyuukinkouzakbn = new ExDBFieldString<>("nyuukinkouzakbn", this, UserType_C_SikinidoukouzaKbn.class);
}
