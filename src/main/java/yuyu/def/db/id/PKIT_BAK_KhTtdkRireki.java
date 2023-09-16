package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_KhTtdkRireki;
import yuyu.def.db.mapping.GenIT_BAK_KhTtdkRireki;
import yuyu.def.db.meta.GenQIT_BAK_KhTtdkRireki;
import yuyu.def.db.meta.QIT_BAK_KhTtdkRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全手続履歴バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhTtdkRireki}</td><td colspan="3">契約保全手続履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrsyousaiumu</td><td>支払詳細有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syorikbn</td><td>処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoriKbn C_SyoriKbn}</td></tr>
 *  <tr><td>honninkakninkekkakbn</td><td>本人確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninKakninKekkaKbn C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>henkourrkumu</td><td>変更履歴有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>smbckanriid</td><td>ＳＭＢＣ受付管理ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nayosekihontblskbtkey</td><td>名寄せ基本テーブル識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouteikanriid</td><td>工程管理ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>youkyuuno</td><td>要求通番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhTtdkRireki
 * @see     GenIT_BAK_KhTtdkRireki
 * @see     QIT_BAK_KhTtdkRireki
 * @see     GenQIT_BAK_KhTtdkRireki
 */
public class PKIT_BAK_KhTtdkRireki extends AbstractExDBPrimaryKey<IT_BAK_KhTtdkRireki, PKIT_BAK_KhTtdkRireki> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhTtdkRireki() {
    }

    public PKIT_BAK_KhTtdkRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhTtdkRireki> getEntityClass() {
        return IT_BAK_KhTtdkRireki.class;
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
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

}