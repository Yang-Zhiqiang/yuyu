package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.MT_BAK_DsSoukinyouKouza;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * ＤＳ送金用口座バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_BAK_DsSoukinyouKouza extends AbstractExDBTable<MT_BAK_DsSoukinyouKouza> {

    public GenQMT_BAK_DsSoukinyouKouza() {
        this("MT_BAK_DsSoukinyouKouza");
    }

    public GenQMT_BAK_DsSoukinyouKouza(String pAlias) {
        super("MT_BAK_DsSoukinyouKouza", MT_BAK_DsSoukinyouKouza.class, pAlias);
    }

    public String MT_BAK_DsSoukinyouKouza() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_BAK_DsSoukinyouKouza, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
