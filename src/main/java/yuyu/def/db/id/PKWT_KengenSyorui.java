package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.db.mapping.GenWT_KengenSyorui;
import yuyu.def.db.meta.GenQWT_KengenSyorui;
import yuyu.def.db.meta.QWT_KengenSyorui;

/**
 * 権限明細（書類）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KengenSyorui}</td><td colspan="3">権限明細（書類）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTorikomiSyoruiCd torikomiSyoruiCd}</td><td>取込書類コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KengenSyorui
 * @see     GenWT_KengenSyorui
 * @see     QWT_KengenSyorui
 * @see     GenQWT_KengenSyorui
 */
public class PKWT_KengenSyorui extends AbstractExDBPrimaryKey<WT_KengenSyorui, PKWT_KengenSyorui> {

    private static final long serialVersionUID = 1L;

    public PKWT_KengenSyorui() {
    }

    public PKWT_KengenSyorui(String pRoleCd, String pTorikomiSyoruiCd) {
        roleCd = pRoleCd;
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

    @Transient
    @Override
    public Class<WT_KengenSyorui> getEntityClass() {
        return WT_KengenSyorui.class;
    }

    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }
    private String torikomiSyoruiCd;

    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

}