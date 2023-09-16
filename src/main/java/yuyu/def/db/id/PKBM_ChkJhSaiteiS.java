package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.mapping.GenBM_ChkJhSaiteiS;
import yuyu.def.db.meta.GenQBM_ChkJhSaiteiS;
import yuyu.def.db.meta.QBM_ChkJhSaiteiS;

/**
 * 最低Ｓ事方書チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkJhSaiteiS}</td><td colspan="3">最低Ｓ事方書チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDntsdnumufrom dntsdnumufrom}</td><td>団体集団有無自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDntsdnumuto dntsdnumuto}</td><td>団体集団有無至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkkknsmnkbnfrom hrkkknsmnkbnfrom}</td><td>払込期間歳満期区分自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkkknsmnkbnto hrkkknsmnkbnto}</td><td>払込期間歳満期区分至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknkknfrom hknkknfrom}</td><td>保険期間自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknkknto hknkknto}</td><td>保険期間至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSaiteisknwtkumufrom saiteisknwtkumufrom}</td><td>最低Ｓ緩和特約有無自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSaiteisknwtkumuto saiteisknwtkumuto}</td><td>最低Ｓ緩和特約有無至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>saiteis</td><td>最低Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkJhSaiteiS
 * @see     GenBM_ChkJhSaiteiS
 * @see     QBM_ChkJhSaiteiS
 * @see     GenQBM_ChkJhSaiteiS
 */
public class PKBM_ChkJhSaiteiS extends AbstractExDBPrimaryKey<BM_ChkJhSaiteiS, PKBM_ChkJhSaiteiS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkJhSaiteiS() {
    }

    public PKBM_ChkJhSaiteiS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pDntsdnumufrom,
        Integer pDntsdnumuto,
        Integer pHrkkknsmnkbnfrom,
        Integer pHrkkknsmnkbnto,
        BizNumber pHknkknfrom,
        BizNumber pHknkknto,
        Integer pSaiteisknwtkumufrom,
        Integer pSaiteisknwtkumuto,
        C_Tuukasyu pTuukasyu
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        dntsdnumufrom = pDntsdnumufrom;
        dntsdnumuto = pDntsdnumuto;
        hrkkknsmnkbnfrom = pHrkkknsmnkbnfrom;
        hrkkknsmnkbnto = pHrkkknsmnkbnto;
        hknkknfrom = pHknkknfrom;
        hknkknto = pHknkknto;
        saiteisknwtkumufrom = pSaiteisknwtkumufrom;
        saiteisknwtkumuto = pSaiteisknwtkumuto;
        tuukasyu = pTuukasyu;
    }

    @Transient
    @Override
    public Class<BM_ChkJhSaiteiS> getEntityClass() {
        return BM_ChkJhSaiteiS.class;
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
    private Integer dntsdnumufrom;

    public Integer getDntsdnumufrom() {
        return dntsdnumufrom;
    }

    public void setDntsdnumufrom(Integer pDntsdnumufrom) {
        dntsdnumufrom = pDntsdnumufrom;
    }
    private Integer dntsdnumuto;

    public Integer getDntsdnumuto() {
        return dntsdnumuto;
    }

    public void setDntsdnumuto(Integer pDntsdnumuto) {
        dntsdnumuto = pDntsdnumuto;
    }
    private Integer hrkkknsmnkbnfrom;

    public Integer getHrkkknsmnkbnfrom() {
        return hrkkknsmnkbnfrom;
    }

    public void setHrkkknsmnkbnfrom(Integer pHrkkknsmnkbnfrom) {
        hrkkknsmnkbnfrom = pHrkkknsmnkbnfrom;
    }
    private Integer hrkkknsmnkbnto;

    public Integer getHrkkknsmnkbnto() {
        return hrkkknsmnkbnto;
    }

    public void setHrkkknsmnkbnto(Integer pHrkkknsmnkbnto) {
        hrkkknsmnkbnto = pHrkkknsmnkbnto;
    }
    private BizNumber hknkknfrom;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHknkknfrom() {
        return hknkknfrom;
    }

    public void setHknkknfrom(BizNumber pHknkknfrom) {
        hknkknfrom = pHknkknfrom;
    }
    private BizNumber hknkknto;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHknkknto() {
        return hknkknto;
    }

    public void setHknkknto(BizNumber pHknkknto) {
        hknkknto = pHknkknto;
    }
    private Integer saiteisknwtkumufrom;

    public Integer getSaiteisknwtkumufrom() {
        return saiteisknwtkumufrom;
    }

    public void setSaiteisknwtkumufrom(Integer pSaiteisknwtkumufrom) {
        saiteisknwtkumufrom = pSaiteisknwtkumufrom;
    }
    private Integer saiteisknwtkumuto;

    public Integer getSaiteisknwtkumuto() {
        return saiteisknwtkumuto;
    }

    public void setSaiteisknwtkumuto(Integer pSaiteisknwtkumuto) {
        saiteisknwtkumuto = pSaiteisknwtkumuto;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

}