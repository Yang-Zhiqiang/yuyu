package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.mapping.GenIT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.meta.GenQIT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.meta.QIT_KhHenkouUktkMkhgkHnk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付内容（目標額変更）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHenkouUktkMkhgkHnk}</td><td colspan="3">契約保全変更受付内容（目標額変更）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>targettkmokuhyouti</td><td>ターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHenkouUktkMkhgkHnk
 * @see     GenIT_KhHenkouUktkMkhgkHnk
 * @see     QIT_KhHenkouUktkMkhgkHnk
 * @see     GenQIT_KhHenkouUktkMkhgkHnk
 */
public class PKIT_KhHenkouUktkMkhgkHnk extends AbstractExDBPrimaryKey<IT_KhHenkouUktkMkhgkHnk, PKIT_KhHenkouUktkMkhgkHnk> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhHenkouUktkMkhgkHnk() {
    }

    public PKIT_KhHenkouUktkMkhgkHnk(
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
    public Class<IT_KhHenkouUktkMkhgkHnk> getEntityClass() {
        return IT_KhHenkouUktkMkhgkHnk.class;
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