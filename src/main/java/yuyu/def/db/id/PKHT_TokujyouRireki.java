package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_TokujyouRireki;
import yuyu.def.db.mapping.GenHT_TokujyouRireki;
import yuyu.def.db.meta.GenQHT_TokujyouRireki;
import yuyu.def.db.meta.QHT_TokujyouRireki;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 特条履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_TokujyouRireki}</td><td colspan="3">特条履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDakuhiktrenno dakuhiktrenno}</td><td>諾否決定連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tkjyhyouten</td><td>特条標点</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkjyhyouten C_Tkjyhyouten}</td></tr>
 *  <tr><td>tkjyskgnkkn</td><td>特条削減期間</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkjyskgnkkn C_Tkjyskgnkkn}</td></tr>
 *  <tr><td>htnpbuicd1</td><td>不担保部位コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn1</td><td>不担保期間１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd2</td><td>不担保部位コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn2</td><td>不担保期間２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd3</td><td>不担保部位コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn3</td><td>不担保期間３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>htnpbuicd4</td><td>不担保部位コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn4</td><td>不担保期間４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>tokkoudosghtnpkbn</td><td>特定高度障害不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokkoudosghtnpKbn C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_TokujyouRireki
 * @see     GenHT_TokujyouRireki
 * @see     QHT_TokujyouRireki
 * @see     GenQHT_TokujyouRireki
 */
public class PKHT_TokujyouRireki extends AbstractExDBPrimaryKey<HT_TokujyouRireki, PKHT_TokujyouRireki> {

    private static final long serialVersionUID = 1L;

    public PKHT_TokujyouRireki() {
    }

    public PKHT_TokujyouRireki(String pMosno, Integer pDakuhiktrenno) {
        mosno = pMosno;
        dakuhiktrenno = pDakuhiktrenno;
    }

    @Transient
    @Override
    public Class<HT_TokujyouRireki> getEntityClass() {
        return HT_TokujyouRireki.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer dakuhiktrenno;

    public Integer getDakuhiktrenno() {
        return dakuhiktrenno;
    }

    public void setDakuhiktrenno(Integer pDakuhiktrenno) {
        dakuhiktrenno = pDakuhiktrenno;
    }

}