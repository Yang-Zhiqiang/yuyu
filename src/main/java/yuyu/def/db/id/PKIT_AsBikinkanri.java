package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.db.mapping.GenIT_AsBikinkanri;
import yuyu.def.db.meta.GenQIT_AsBikinkanri;
import yuyu.def.db.meta.QIT_AsBikinkanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納備金管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AsBikinkanri}</td><td colspan="3">案内収納備金管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sisyacd</td><td>支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeirisegcd</td><td>区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bkngk</td><td>備金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syoriumukbn</td><td>処理有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>bknjkukbn</td><td>備金時効区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknJkuKbn C_BknJkuKbn}</td></tr>
 *  <tr><td>kaiyakuhrgaika</td><td>解約返戻金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kwsratekjymd</td><td>為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kawaserate</td><td>為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AsBikinkanri
 * @see     GenIT_AsBikinkanri
 * @see     QIT_AsBikinkanri
 * @see     GenQIT_AsBikinkanri
 */
public class PKIT_AsBikinkanri extends AbstractExDBPrimaryKey<IT_AsBikinkanri, PKIT_AsBikinkanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_AsBikinkanri() {
    }

    public PKIT_AsBikinkanri(
        String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        Integer pRenno
    ) {
        syono = pSyono;
        kessankijyunymd = pKessankijyunymd;
        bkncdkbn = pBkncdkbn;
        bknkktymd = pBknkktymd;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_AsBikinkanri> getEntityClass() {
        return IT_AsBikinkanri.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate kessankijyunymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKessankijyunymd() {
        return kessankijyunymd;
    }

    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        kessankijyunymd = pKessankijyunymd;
    }
    private C_BkncdKbn bkncdkbn;

    @org.hibernate.annotations.Type(type="UserType_C_BkncdKbn")
    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
    }
    private BizDate bknkktymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getBknkktymd() {
        return bknkktymd;
    }

    public void setBknkktymd(BizDate pBknkktymd) {
        bknkktymd = pBknkktymd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}