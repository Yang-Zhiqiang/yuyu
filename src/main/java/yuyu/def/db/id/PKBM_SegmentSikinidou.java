package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_SegmentSikinidou;
import yuyu.def.db.mapping.GenBM_SegmentSikinidou;
import yuyu.def.db.meta.GenQBM_SegmentSikinidou;
import yuyu.def.db.meta.QBM_SegmentSikinidou;

/**
 * セグメントコード別資金移動処理マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SegmentSikinidou}</td><td colspan="3">セグメントコード別資金移動処理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegcd segcd}</td><td>セグメントコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>hijynnykzndkkouzakbn</td><td>平準払入金額残高口座区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HijynnykzndkkouzaKbn C_HijynnykzndkkouzaKbn}</td></tr>
 *  <tr><td>fstpgkhnkzidourt</td><td>初回Ｐ外貨本口座移動ルート</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GkhnkzidourtKbn C_GkhnkzidourtKbn}</td></tr>
 *  <tr><td>zenkizennougkhnkzidourt</td><td>全期前納外貨本口座移動ルート</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GkhnkzidourtKbn C_GkhnkzidourtKbn}</td></tr>
 *  <tr><td>keizokupgkhnkzidourt</td><td>継続Ｐ外貨本口座移動ルート</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GkhnkzidourtKbn C_GkhnkzidourtKbn}</td></tr>
 *  <tr><td>seiymdseitstuityouhnknumu</td><td>生年月日性訂正追徴返還有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>daihyousyouhncd</td><td>代表商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SegmentSikinidou
 * @see     GenBM_SegmentSikinidou
 * @see     QBM_SegmentSikinidou
 * @see     GenQBM_SegmentSikinidou
 */
public class PKBM_SegmentSikinidou extends AbstractExDBPrimaryKey<BM_SegmentSikinidou, PKBM_SegmentSikinidou> {

    private static final long serialVersionUID = 1L;

    public PKBM_SegmentSikinidou() {
    }

    public PKBM_SegmentSikinidou(C_Segcd pSegcd) {
        segcd = pSegcd;
    }

    @Transient
    @Override
    public Class<BM_SegmentSikinidou> getEntityClass() {
        return BM_SegmentSikinidou.class;
    }

    private C_Segcd segcd;

    @org.hibernate.annotations.Type(type="UserType_C_Segcd")
    public C_Segcd getSegcd() {
        return segcd;
    }

    public void setSegcd(C_Segcd pSegcd) {
        segcd = pSegcd;
    }

}