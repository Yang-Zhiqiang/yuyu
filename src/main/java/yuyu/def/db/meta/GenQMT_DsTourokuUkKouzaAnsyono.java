package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_TrksriyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.type.UserType_C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.db.type.UserType_C_DsTtdksyubetuKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_TrksriyuuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * ＤＳ登録受付（口座暗証番号）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsTourokuUkKouzaAnsyono extends AbstractExDBTable<MT_DsTourokuUkKouzaAnsyono> {

    public GenQMT_DsTourokuUkKouzaAnsyono() {
        this("MT_DsTourokuUkKouzaAnsyono");
    }

    public GenQMT_DsTourokuUkKouzaAnsyono(String pAlias) {
        super("MT_DsTourokuUkKouzaAnsyono", MT_DsTourokuUkKouzaAnsyono.class, pAlias);
    }

    public String MT_DsTourokuUkKouzaAnsyono() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_DsTtdksyubetuKbn> dsttdksyubetukbn = new ExDBFieldString<>("dsttdksyubetukbn", this, UserType_C_DsTtdksyubetuKbn.class);

    public final ExDBFieldNumber<MT_DsTourokuUkKouzaAnsyono, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_UmuKbn> soukinkzyennrkumu = new ExDBFieldString<>("soukinkzyennrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_UmuKbn> tokuteitrhkansyononrkumu = new ExDBFieldString<>("tokuteitrhkansyononrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_UmuKbn> dstrhkserviceknykeironrumu = new ExDBFieldString<>("dstrhkserviceknykeironrumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> tokuteitrhkansyono = new ExDBFieldString<>("tokuteitrhkansyono", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_TrksriyuuKbn> trksriyuukbn = new ExDBFieldString<>("trksriyuukbn", this, UserType_C_TrksriyuuKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, C_DsTrhkserviceKanyukeiroKbn> dstrhkservicekanyukeirokbn = new ExDBFieldString<>("dstrhkservicekanyukeirokbn", this, UserType_C_DsTrhkserviceKanyukeiroKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsTourokuUkKouzaAnsyono, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
