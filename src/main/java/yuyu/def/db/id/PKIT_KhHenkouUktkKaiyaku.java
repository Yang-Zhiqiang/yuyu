package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.mapping.GenIT_KhHenkouUktkKaiyaku;
import yuyu.def.db.meta.GenQIT_KhHenkouUktkKaiyaku;
import yuyu.def.db.meta.QIT_KhHenkouUktkKaiyaku;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付内容（解約）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHenkouUktkKaiyaku}</td><td colspan="3">契約保全変更受付内容（解約）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>inputshrhousiteikbn</td><td>入力用支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_InputShrhousiteiKbn C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>yenshrtkhkumu</td><td>円支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
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
 * @see     IT_KhHenkouUktkKaiyaku
 * @see     GenIT_KhHenkouUktkKaiyaku
 * @see     QIT_KhHenkouUktkKaiyaku
 * @see     GenQIT_KhHenkouUktkKaiyaku
 */
public class PKIT_KhHenkouUktkKaiyaku extends AbstractExDBPrimaryKey<IT_KhHenkouUktkKaiyaku, PKIT_KhHenkouUktkKaiyaku> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhHenkouUktkKaiyaku() {
    }

    public PKIT_KhHenkouUktkKaiyaku(
        String pKbnkey,
        String pSyono,
        Integer pHozenhenkouuktkrenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        hozenhenkouuktkrenno = pHozenhenkouuktkrenno;
    }

    @Transient
    @Override
    public Class<IT_KhHenkouUktkKaiyaku> getEntityClass() {
        return IT_KhHenkouUktkKaiyaku.class;
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
    private Integer hozenhenkouuktkrenno;

    public Integer getHozenhenkouuktkrenno() {
        return hozenhenkouuktkrenno;
    }

    public void setHozenhenkouuktkrenno(Integer pHozenhenkouuktkrenno) {
        hozenhenkouuktkrenno = pHozenhenkouuktkrenno;
    }

}