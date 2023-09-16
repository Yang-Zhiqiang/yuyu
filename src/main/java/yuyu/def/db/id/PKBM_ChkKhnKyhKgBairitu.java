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
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.def.db.mapping.GenBM_ChkKhnKyhKgBairitu;
import yuyu.def.db.meta.GenQBM_ChkKhnKyhKgBairitu;
import yuyu.def.db.meta.QBM_ChkKhnKyhKgBairitu;

/**
 * 基本給付金額倍率チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKhnKyhKgBairitu}</td><td colspan="3">基本給付金額倍率チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKhnkyhkgbairitukbn khnkyhkgbairitukbn}</td><td>基本給付金額倍率区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KhnkyhkgbairituKbn}</td></tr>
 * </table>
 * @see     BM_ChkKhnKyhKgBairitu
 * @see     GenBM_ChkKhnKyhKgBairitu
 * @see     QBM_ChkKhnKyhKgBairitu
 * @see     GenQBM_ChkKhnKyhKgBairitu
 */
public class PKBM_ChkKhnKyhKgBairitu extends AbstractExDBPrimaryKey<BM_ChkKhnKyhKgBairitu, PKBM_ChkKhnKyhKgBairitu> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkKhnKyhKgBairitu() {
    }

    public PKBM_ChkKhnKyhKgBairitu(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        khnkyhkgbairitukbn = pKhnkyhkgbairitukbn;
    }

    @Transient
    @Override
    public Class<BM_ChkKhnKyhKgBairitu> getEntityClass() {
        return BM_ChkKhnKyhKgBairitu.class;
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
    private C_KhnkyhkgbairituKbn khnkyhkgbairitukbn;

    @org.hibernate.annotations.Type(type="UserType_C_KhnkyhkgbairituKbn")
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {
        return khnkyhkgbairitukbn;
    }

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        khnkyhkgbairitukbn = pKhnkyhkgbairitukbn;
    }

}