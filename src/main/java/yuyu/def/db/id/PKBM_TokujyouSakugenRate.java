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
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.db.entity.BM_TokujyouSakugenRate;
import yuyu.def.db.mapping.GenBM_TokujyouSakugenRate;
import yuyu.def.db.meta.GenQBM_TokujyouSakugenRate;
import yuyu.def.db.meta.QBM_TokujyouSakugenRate;

/**
 * 特条削減率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TokujyouSakugenRate}</td><td colspan="3">特条削減率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkjyskgnkkn tkjyskgnkkn}</td><td>特条削減期間</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tkjyskgnkkn}</td></tr>
 *  <tr><td>dai1hknnndskgnsrate</td><td>第１保険年度削減支払割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dai2hknnndskgnsrate</td><td>第２保険年度削減支払割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dai3hknnndskgnsrate</td><td>第３保険年度削減支払割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dai4hknnndskgnsrate</td><td>第４保険年度削減支払割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dai5hknnndskgnsrate</td><td>第５保険年度削減支払割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_TokujyouSakugenRate
 * @see     GenBM_TokujyouSakugenRate
 * @see     QBM_TokujyouSakugenRate
 * @see     GenQBM_TokujyouSakugenRate
 */
public class PKBM_TokujyouSakugenRate extends AbstractExDBPrimaryKey<BM_TokujyouSakugenRate, PKBM_TokujyouSakugenRate> {

    private static final long serialVersionUID = 1L;

    public PKBM_TokujyouSakugenRate() {
    }

    public PKBM_TokujyouSakugenRate(
        String pSyouhncd,
        Integer pSyouhnsdno,
        C_Tkjyskgnkkn pTkjyskgnkkn
    ) {
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        tkjyskgnkkn = pTkjyskgnkkn;
    }

    @Transient
    @Override
    public Class<BM_TokujyouSakugenRate> getEntityClass() {
        return BM_TokujyouSakugenRate.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syouhnsdno;

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }
    private C_Tkjyskgnkkn tkjyskgnkkn;

    @org.hibernate.annotations.Type(type="UserType_C_Tkjyskgnkkn")
    public C_Tkjyskgnkkn getTkjyskgnkkn() {
        return tkjyskgnkkn;
    }

    public void setTkjyskgnkkn(C_Tkjyskgnkkn pTkjyskgnkkn) {
        tkjyskgnkkn = pTkjyskgnkkn;
    }

}