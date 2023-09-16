package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.mapping.GenWM_TorikomiSyorui;
import yuyu.def.db.meta.GenQWM_TorikomiSyorui;
import yuyu.def.db.meta.QWM_TorikomiSyorui;

/**
 * 取込書類マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WM_TorikomiSyorui}</td><td colspan="3">取込書類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTorikomiSyoruiCd torikomiSyoruiCd}</td><td>取込書類コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>torikomiSyoruiNm</td><td>取込書類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>torikomiSyoruiRyaku</td><td>取込書類略称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syzkDaiBunruiId</td><td>所属大分類ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syzkSyouBunruiId</td><td>所属小分類ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>angoukaKbn</td><td>暗号化区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 *  <tr><td>angoukaHousikiKbn</td><td>暗号化方式区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AngoukaHousikiKbn C_AngoukaHousikiKbn}</td></tr>
 *  <tr><td>zipHozonKbn</td><td>ＺＩＰ保存区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 *  <tr><td>kouteiSeigyoUmuKbn</td><td>工程制御有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouteiSeigyoUmuKbn C_KouteiSeigyoUmuKbn}</td></tr>
 *  <tr><td>flowId</td><td>フローＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nodeId</td><td>ノードＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WM_TorikomiSyorui
 * @see     GenWM_TorikomiSyorui
 * @see     QWM_TorikomiSyorui
 * @see     GenQWM_TorikomiSyorui
 */
public class PKWM_TorikomiSyorui extends AbstractExDBPrimaryKey<WM_TorikomiSyorui, PKWM_TorikomiSyorui> {

    private static final long serialVersionUID = 1L;

    public PKWM_TorikomiSyorui() {
    }

    public PKWM_TorikomiSyorui(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

    @Transient
    @Override
    public Class<WM_TorikomiSyorui> getEntityClass() {
        return WM_TorikomiSyorui.class;
    }

    private String torikomiSyoruiCd;

    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

}