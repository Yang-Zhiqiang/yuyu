package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JV_SmbcSibouInfoRendou;
import yuyu.def.db.mapping.GenJV_SmbcSibouInfoRendou;
import yuyu.def.db.meta.GenQJV_SmbcSibouInfoRendou;
import yuyu.def.db.meta.QJV_SmbcSibouInfoRendou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＳＭＢＣ死亡情報連動ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JV_SmbcSibouInfoRendou}</td><td colspan="3">ＳＭＢＣ死亡情報連動ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>sibouymd</td><td>死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sbuktnin</td><td>死亡受取人人数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uktkbn</td><td>受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>uktnmkn</td><td>受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkj</td><td>受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyakbn</td><td>請求者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuusyaKbn C_SeikyuusyaKbn}</td></tr>
 *  <tr><td>seikyuusyanmkn</td><td>請求者（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyanmkj</td><td>請求者（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyaseiymd</td><td>請求者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hubikanryouymd</td><td>不備完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrsyoriymd</td><td>支払処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JV_SmbcSibouInfoRendou
 * @see     GenJV_SmbcSibouInfoRendou
 * @see     QJV_SmbcSibouInfoRendou
 * @see     GenQJV_SmbcSibouInfoRendou
 */
public class PKJV_SmbcSibouInfoRendou extends AbstractExDBPrimaryKey<JV_SmbcSibouInfoRendou, PKJV_SmbcSibouInfoRendou> {

    private static final long serialVersionUID = 1L;

    public PKJV_SmbcSibouInfoRendou() {
    }

    public PKJV_SmbcSibouInfoRendou(String pSyono, String pSkno) {
        syono = pSyono;
        skno = pSkno;
    }

    @Transient
    @Override
    public Class<JV_SmbcSibouInfoRendou> getEntityClass() {
        return JV_SmbcSibouInfoRendou.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }

}