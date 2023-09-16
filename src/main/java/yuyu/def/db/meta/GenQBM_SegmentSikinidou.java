package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GkhnkzidourtKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SegmentSikinidou;
import yuyu.def.db.type.UserType_C_GkhnkzidourtKbn;
import yuyu.def.db.type.UserType_C_HijynnykzndkkouzaKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * セグメントコード別資金移動処理マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SegmentSikinidou extends AbstractExDBTable<BM_SegmentSikinidou> {

    public GenQBM_SegmentSikinidou() {
        this("BM_SegmentSikinidou");
    }

    public GenQBM_SegmentSikinidou(String pAlias) {
        super("BM_SegmentSikinidou", BM_SegmentSikinidou.class, pAlias);
    }

    public String BM_SegmentSikinidou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SegmentSikinidou, C_Segcd> segcd = new ExDBFieldString<>("segcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BM_SegmentSikinidou, C_HijynnykzndkkouzaKbn> hijynnykzndkkouzakbn = new ExDBFieldString<>("hijynnykzndkkouzakbn", this, UserType_C_HijynnykzndkkouzaKbn.class);

    public final ExDBFieldString<BM_SegmentSikinidou, C_GkhnkzidourtKbn> fstpgkhnkzidourt = new ExDBFieldString<>("fstpgkhnkzidourt", this, UserType_C_GkhnkzidourtKbn.class);

    public final ExDBFieldString<BM_SegmentSikinidou, C_GkhnkzidourtKbn> zenkizennougkhnkzidourt = new ExDBFieldString<>("zenkizennougkhnkzidourt", this, UserType_C_GkhnkzidourtKbn.class);

    public final ExDBFieldString<BM_SegmentSikinidou, C_GkhnkzidourtKbn> keizokupgkhnkzidourt = new ExDBFieldString<>("keizokupgkhnkzidourt", this, UserType_C_GkhnkzidourtKbn.class);

    public final ExDBFieldString<BM_SegmentSikinidou, C_UmuKbn> seiymdseitstuityouhnknumu = new ExDBFieldString<>("seiymdseitstuityouhnknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SegmentSikinidou, String> daihyousyouhncd = new ExDBFieldString<>("daihyousyouhncd", this);
}
