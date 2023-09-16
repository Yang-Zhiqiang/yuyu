package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IM_KhHituyouSyorui;
import yuyu.def.db.mapping.GenIM_KhHituyouSyorui;
import yuyu.def.db.meta.GenQIM_KhHituyouSyorui;
import yuyu.def.db.meta.QIM_KhHituyouSyorui;

/**
 * 契約保全必要書類マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhHituyouSyorui}</td><td colspan="3">契約保全必要書類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHanteikbn1 hanteikbn1}</td><td>判定区分１</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHanteikbn2 hanteikbn2}</td><td>判定区分２</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHanteikbn3 hanteikbn3}</td><td>判定区分３</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHtysrirenno htysrirenno}</td><td>必要書類連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>htysyorui</td><td>必要書類メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhHituyouSyorui
 * @see     GenIM_KhHituyouSyorui
 * @see     QIM_KhHituyouSyorui
 * @see     GenQIM_KhHituyouSyorui
 */
public class PKIM_KhHituyouSyorui extends AbstractExDBPrimaryKey<IM_KhHituyouSyorui, PKIM_KhHituyouSyorui> {

    private static final long serialVersionUID = 1L;

    public PKIM_KhHituyouSyorui() {
    }

    public PKIM_KhHituyouSyorui(
        String pKinouId,
        Integer pHanteikbn1,
        Integer pHanteikbn2,
        Integer pHanteikbn3,
        Integer pHtysrirenno
    ) {
        kinouId = pKinouId;
        hanteikbn1 = pHanteikbn1;
        hanteikbn2 = pHanteikbn2;
        hanteikbn3 = pHanteikbn3;
        htysrirenno = pHtysrirenno;
    }

    @Transient
    @Override
    public Class<IM_KhHituyouSyorui> getEntityClass() {
        return IM_KhHituyouSyorui.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private Integer hanteikbn1;

    public Integer getHanteikbn1() {
        return hanteikbn1;
    }

    public void setHanteikbn1(Integer pHanteikbn1) {
        hanteikbn1 = pHanteikbn1;
    }
    private Integer hanteikbn2;

    public Integer getHanteikbn2() {
        return hanteikbn2;
    }

    public void setHanteikbn2(Integer pHanteikbn2) {
        hanteikbn2 = pHanteikbn2;
    }
    private Integer hanteikbn3;

    public Integer getHanteikbn3() {
        return hanteikbn3;
    }

    public void setHanteikbn3(Integer pHanteikbn3) {
        hanteikbn3 = pHanteikbn3;
    }
    private Integer htysrirenno;

    public Integer getHtysrirenno() {
        return htysrirenno;
    }

    public void setHtysrirenno(Integer pHtysrirenno) {
        htysrirenno = pHtysrirenno;
    }

}