package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_Segment;
import yuyu.def.db.mapping.GenBM_Segment;
import yuyu.def.db.meta.GenQBM_Segment;
import yuyu.def.db.meta.QBM_Segment;

/**
 * セグメントマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Segment}</td><td colspan="3">セグメントマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegcd segcd}</td><td>セグメントコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>segnm</td><td>セグメント名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Segment
 * @see     GenBM_Segment
 * @see     QBM_Segment
 * @see     GenQBM_Segment
 */
public class PKBM_Segment extends AbstractExDBPrimaryKey<BM_Segment, PKBM_Segment> {

    private static final long serialVersionUID = 1L;

    public PKBM_Segment() {
    }

    public PKBM_Segment(C_Segcd pSegcd) {
        segcd = pSegcd;
    }

    @Transient
    @Override
    public Class<BM_Segment> getEntityClass() {
        return BM_Segment.class;
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