package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.mapping.GenJT_SkByoumei;
import yuyu.def.db.meta.GenQJT_SkByoumei;
import yuyu.def.db.meta.QJT_SkByoumei;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求病名テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkByoumei}</td><td colspan="3">請求病名テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>byoumeitourokuno</td><td>病名登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>byoumeikn</td><td>病名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>byoumeikj</td><td>病名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gankbn</td><td>がん区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GanKbn C_GanKbn}</td></tr>
 *  <tr><td>sandaisippeikbn</td><td>３大疾病区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_3daiSippeiKbn C_3daiSippeiKbn}</td></tr>
 *  <tr><td>nanadaisippeikbn</td><td>７大疾病区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_7daiSippeiKbn C_7daiSippeiKbn}</td></tr>
 *  <tr><td>kansensyoukbn</td><td>感染症区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KansensyouKbn C_KansensyouKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkByoumei
 * @see     GenJT_SkByoumei
 * @see     QJT_SkByoumei
 * @see     GenQJT_SkByoumei
 */
public class PKJT_SkByoumei extends AbstractExDBPrimaryKey<JT_SkByoumei, PKJT_SkByoumei> {

    private static final long serialVersionUID = 1L;

    public PKJT_SkByoumei() {
    }

    public PKJT_SkByoumei(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        Integer pRenno
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
        uketukeno = pUketukeno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<JT_SkByoumei> getEntityClass() {
        return JT_SkByoumei.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer seikyuurirekino;

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }
    private Integer uketukeno;

    public Integer getUketukeno() {
        return uketukeno;
    }

    public void setUketukeno(Integer pUketukeno) {
        uketukeno = pUketukeno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}