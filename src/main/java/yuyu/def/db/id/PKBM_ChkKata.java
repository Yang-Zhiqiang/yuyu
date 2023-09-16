package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.def.db.mapping.GenBM_ChkKata;
import yuyu.def.db.meta.GenQBM_ChkKata;
import yuyu.def.db.meta.QBM_ChkKata;

/**
 * 型区分チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKata}</td><td colspan="3">型区分チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTktanbrumu tktanbrumu}</td><td>特約短期払有無</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 * </table>
 * @see     BM_ChkKata
 * @see     GenBM_ChkKata
 * @see     QBM_ChkKata
 * @see     GenQBM_ChkKata
 */
public class PKBM_ChkKata extends AbstractExDBPrimaryKey<BM_ChkKata, PKBM_ChkKata> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkKata() {
    }

    public PKBM_ChkKata(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_UmuKbn pTktanbrumu,
        C_KataKbn pKatakbn
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        tktanbrumu = pTktanbrumu;
        katakbn = pKatakbn;
    }

    @Transient
    @Override
    public Class<BM_ChkKata> getEntityClass() {
        return BM_ChkKata.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syusyouhnsdnofrom;

    public Integer getSyusyouhnsdnofrom() {
        return syusyouhnsdnofrom;
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
    }
    private Integer syusyouhnsdnoto;

    public Integer getSyusyouhnsdnoto() {
        return syusyouhnsdnoto;
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        syusyouhnsdnoto = pSyusyouhnsdnoto;
    }
    private C_UmuKbn tktanbrumu;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getTktanbrumu() {
        return tktanbrumu;
    }

    public void setTktanbrumu(C_UmuKbn pTktanbrumu) {
        tktanbrumu = pTktanbrumu;
    }
    private C_KataKbn katakbn;

    @org.hibernate.annotations.Type(type="UserType_C_KataKbn")
    public C_KataKbn getKatakbn() {
        return katakbn;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        katakbn = pKatakbn;
    }

}