package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.def.db.mapping.GenBT_TyouhyouOutputKengen;
import yuyu.def.db.meta.GenQBT_TyouhyouOutputKengen;
import yuyu.def.db.meta.QBT_TyouhyouOutputKengen;

/**
 * 帳票出力権限テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TyouhyouOutputKengen}</td><td colspan="3">帳票出力権限テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>ikkatuoutputkahikbn</td><td>一括出力可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>kobetuoutputkahikbn</td><td>個別出力可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_TyouhyouOutputKengen
 * @see     GenBT_TyouhyouOutputKengen
 * @see     QBT_TyouhyouOutputKengen
 * @see     GenQBT_TyouhyouOutputKengen
 */
public class PKBT_TyouhyouOutputKengen extends AbstractExDBPrimaryKey<BT_TyouhyouOutputKengen, PKBT_TyouhyouOutputKengen> {

    private static final long serialVersionUID = 1L;

    public PKBT_TyouhyouOutputKengen() {
    }

    public PKBT_TyouhyouOutputKengen(String pRoleCd, C_SyoruiCdKbn pSyoruiCd) {
        roleCd = pRoleCd;
        syoruiCd = pSyoruiCd;
    }

    @Transient
    @Override
    public Class<BT_TyouhyouOutputKengen> getEntityClass() {
        return BT_TyouhyouOutputKengen.class;
    }

    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }
    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

}