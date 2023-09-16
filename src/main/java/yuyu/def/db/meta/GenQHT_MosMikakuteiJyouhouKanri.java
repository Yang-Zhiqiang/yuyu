package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 申込未確定情報管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosMikakuteiJyouhouKanri extends AbstractExDBTable<HT_MosMikakuteiJyouhouKanri> {

    public GenQHT_MosMikakuteiJyouhouKanri() {
        this("HT_MosMikakuteiJyouhouKanri");
    }

    public GenQHT_MosMikakuteiJyouhouKanri(String pAlias) {
        super("HT_MosMikakuteiJyouhouKanri", HT_MosMikakuteiJyouhouKanri.class, pAlias);
    }

    public String HT_MosMikakuteiJyouhouKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, C_MosUketukeKbn> mosuketukekbn = new ExDBFieldString<>("mosuketukekbn", this, UserType_C_MosUketukeKbn.class);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> jimuyoucd = new ExDBFieldString<>("jimuyoucd", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, C_UmuKbn> doujimosumu = new ExDBFieldString<>("doujimosumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, BizDate> sakujoyoteiymd = new ExDBFieldString<>("sakujoyoteiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> setmosno1 = new ExDBFieldString<>("setmosno1", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosMikakuteiJyouhouKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
