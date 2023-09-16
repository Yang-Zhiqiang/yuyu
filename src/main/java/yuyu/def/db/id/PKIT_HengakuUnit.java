package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuUnit;
import yuyu.def.db.mapping.GenIT_HengakuUnit;
import yuyu.def.db.meta.GenQIT_HengakuUnit;
import yuyu.def.db.meta.QIT_HengakuUnit;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 変額ユニットテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HengakuUnit}</td><td colspan="3">変額ユニットテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>unitkouryokuhasseiymd</td><td>ユニット効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>unitkouryokuendymd</td><td>ユニット効力終了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>unitsuu</td><td>ユニット数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>fundhaibunwariai</td><td>ファンド配分割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HengakuUnit
 * @see     GenIT_HengakuUnit
 * @see     QIT_HengakuUnit
 * @see     GenQIT_HengakuUnit
 */
public class PKIT_HengakuUnit extends AbstractExDBPrimaryKey<IT_HengakuUnit, PKIT_HengakuUnit> {

    private static final long serialVersionUID = 1L;

    public PKIT_HengakuUnit() {
    }

    public PKIT_HengakuUnit(
        String pKbnkey,
        String pSyono,
        C_UnitFundKbn pUnitfundkbn
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        unitfundkbn = pUnitfundkbn;
    }

    @Transient
    @Override
    public Class<IT_HengakuUnit> getEntityClass() {
        return IT_HengakuUnit.class;
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
    private C_UnitFundKbn unitfundkbn;

    @org.hibernate.annotations.Type(type="UserType_C_UnitFundKbn")
    public C_UnitFundKbn getUnitfundkbn() {
        return unitfundkbn;
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        unitfundkbn = pUnitfundkbn;
    }

}