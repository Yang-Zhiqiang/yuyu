package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.entity.MT_BAK_DsSoukinyouKouza;
import yuyu.def.db.mapping.GenMT_BAK_DsSoukinyouKouza;
import yuyu.def.db.meta.GenQMT_BAK_DsSoukinyouKouza;
import yuyu.def.db.meta.QMT_BAK_DsSoukinyouKouza;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ送金用口座バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_BAK_DsSoukinyouKouza}</td><td colspan="3">ＤＳ送金用口座バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzdoukbn</td><td>口座名義人同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kzdou C_Kzdou}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_BAK_DsSoukinyouKouza
 * @see     GenMT_BAK_DsSoukinyouKouza
 * @see     QMT_BAK_DsSoukinyouKouza
 * @see     GenQMT_BAK_DsSoukinyouKouza
 */
public class PKMT_BAK_DsSoukinyouKouza extends AbstractExDBPrimaryKey<MT_BAK_DsSoukinyouKouza, PKMT_BAK_DsSoukinyouKouza> {

    private static final long serialVersionUID = 1L;

    public PKMT_BAK_DsSoukinyouKouza() {
    }

    public PKMT_BAK_DsSoukinyouKouza(
        String pDskokno,
        String pSyono,
        C_KouzasyuruiKbn pKzsyuruikbn,
        String pTrkssikibetukey
    ) {
        dskokno = pDskokno;
        syono = pSyono;
        kzsyuruikbn = pKzsyuruikbn;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<MT_BAK_DsSoukinyouKouza> getEntityClass() {
        return MT_BAK_DsSoukinyouKouza.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private C_KouzasyuruiKbn kzsyuruikbn;

    @org.hibernate.annotations.Type(type="UserType_C_KouzasyuruiKbn")
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}