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
import yuyu.def.db.entity.IT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.mapping.GenIT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.meta.GenQIT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.meta.QIT_HsgbnktAnnaihouhoukanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 被災害分割案内方法管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HsgbnktAnnaihouhoukanri}</td><td colspan="3">被災害分割案内方法管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHsgymd hsgymd}</td><td>被災害年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bnktannaihouhoukbn</td><td>分割案内方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BnktAnnaiHouhouKbn C_BnktAnnaiHouhouKbn}</td></tr>
 *  <tr><td>bnktannaikaisiymd</td><td>分割案内開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bnktannaiendymd</td><td>分割案内終了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hsgtkbtymd1</td><td>被災害特別年月日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hsgtkbtymd2</td><td>被災害特別年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hsgtkbtkbn1</td><td>被災害特別区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hsgtkbtkbn2</td><td>被災害特別区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HsgbnktAnnaihouhoukanri
 * @see     GenIT_HsgbnktAnnaihouhoukanri
 * @see     QIT_HsgbnktAnnaihouhoukanri
 * @see     GenQIT_HsgbnktAnnaihouhoukanri
 */
public class PKIT_HsgbnktAnnaihouhoukanri extends AbstractExDBPrimaryKey<IT_HsgbnktAnnaihouhoukanri, PKIT_HsgbnktAnnaihouhoukanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_HsgbnktAnnaihouhoukanri() {
    }

    public PKIT_HsgbnktAnnaihouhoukanri(
        String pKbnkey,
        String pSyono,
        BizDate pHsgymd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        hsgymd = pHsgymd;
    }

    @Transient
    @Override
    public Class<IT_HsgbnktAnnaihouhoukanri> getEntityClass() {
        return IT_HsgbnktAnnaihouhoukanri.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate hsgymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getHsgymd() {
        return hsgymd;
    }

    public void setHsgymd(BizDate pHsgymd) {
        hsgymd = pHsgymd;
    }

}