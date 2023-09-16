package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.mapping.GenWT_TorikomiKanri;
import yuyu.def.db.meta.GenQWT_TorikomiKanri;
import yuyu.def.db.meta.QWT_TorikomiKanri;

/**
 * 取込管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_TorikomiKanri}</td><td colspan="3">取込管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>torikomiSyoruiCd</td><td>取込書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tourokuId</td><td>登録者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tourokuTime</td><td>登録時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam1</td><td>拡張パラメータ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam2</td><td>拡張パラメータ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam3</td><td>拡張パラメータ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam4</td><td>拡張パラメータ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam5</td><td>拡張パラメータ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam6</td><td>拡張パラメータ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam7</td><td>拡張パラメータ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam8</td><td>拡張パラメータ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam9</td><td>拡張パラメータ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam10</td><td>拡張パラメータ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam11</td><td>拡張パラメータ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam12</td><td>拡張パラメータ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam13</td><td>拡張パラメータ１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam14</td><td>拡張パラメータ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam15</td><td>拡張パラメータ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_TorikomiKanri
 * @see     GenWT_TorikomiKanri
 * @see     QWT_TorikomiKanri
 * @see     GenQWT_TorikomiKanri
 */
public class PKWT_TorikomiKanri extends AbstractExDBPrimaryKey<WT_TorikomiKanri, PKWT_TorikomiKanri> {

    private static final long serialVersionUID = 1L;

    public PKWT_TorikomiKanri() {
    }

    public PKWT_TorikomiKanri(String pIwfImageId) {
        iwfImageId = pIwfImageId;
    }

    @Transient
    @Override
    public Class<WT_TorikomiKanri> getEntityClass() {
        return WT_TorikomiKanri.class;
    }

    private String iwfImageId;

    public String getIwfImageId() {
        return iwfImageId;
    }

    public void setIwfImageId(String pIwfImageId) {
        iwfImageId = pIwfImageId;
    }

}