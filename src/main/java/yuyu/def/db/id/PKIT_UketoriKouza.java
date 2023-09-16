package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_UketoriKouza;
import yuyu.def.db.mapping.GenIT_UketoriKouza;
import yuyu.def.db.meta.GenQIT_UketoriKouza;
import yuyu.def.db.meta.QIT_UketoriKouza;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 受取口座テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_UketoriKouza}</td><td colspan="3">受取口座テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kzsyuruikbn</td><td>口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouzasyuruiKbn C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_UketoriKouza
 * @see     GenIT_UketoriKouza
 * @see     QIT_UketoriKouza
 * @see     GenQIT_UketoriKouza
 */
public class PKIT_UketoriKouza extends AbstractExDBPrimaryKey<IT_UketoriKouza, PKIT_UketoriKouza> {

    private static final long serialVersionUID = 1L;

    public PKIT_UketoriKouza() {
    }

    public PKIT_UketoriKouza(
        String pKbnkey,
        String pSyono,
        C_UktsyuKbn pUktsyukbn,
        Integer pUktsyurenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        uktsyukbn = pUktsyukbn;
        uktsyurenno = pUktsyurenno;
    }

    @Transient
    @Override
    public Class<IT_UketoriKouza> getEntityClass() {
        return IT_UketoriKouza.class;
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
    private C_UktsyuKbn uktsyukbn;

    @org.hibernate.annotations.Type(type="UserType_C_UktsyuKbn")
    public C_UktsyuKbn getUktsyukbn() {
        return uktsyukbn;
    }

    public void setUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        uktsyukbn = pUktsyukbn;
    }
    private Integer uktsyurenno;

    public Integer getUktsyurenno() {
        return uktsyurenno;
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        uktsyurenno = pUktsyurenno;
    }

}