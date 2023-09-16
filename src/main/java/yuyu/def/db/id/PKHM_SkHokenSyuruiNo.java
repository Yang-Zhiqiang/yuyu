package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.mapping.GenHM_SkHokenSyuruiNo;
import yuyu.def.db.meta.GenQHM_SkHokenSyuruiNo;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNo;

/**
 * 保険種類番号マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHokenSyuruiNo}</td><td colspan="3">保険種類番号マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">○</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruinosd hknsyuruinosd}</td><td>保険種類番号世代</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hyoujifromymd</td><td>表示日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujitoymd</td><td>表示日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknsyuruinm</td><td>保険種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyuruinmsyanaidisp</td><td>保険種類名（社内表示用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyuruiworklist</td><td>保険種類名（ワークリスト用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daihyouhknsyuruino</td><td>代表保険種類番号</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknsyuruiNo C_HknsyuruiNo}</td></tr>
 *  <tr><td>inputctrlsyouhncd</td><td>入力制御用商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>inputctrlsyouhnsdno</td><td>入力制御用商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1hknkknselect</td><td>第１保険期間選択肢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>targettkmkhtselect</td><td>ターゲット特約目標値選択肢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syohnsortno</td><td>商品ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HM_SkHokenSyuruiNo
 * @see     GenHM_SkHokenSyuruiNo
 * @see     QHM_SkHokenSyuruiNo
 * @see     GenQHM_SkHokenSyuruiNo
 */
public class PKHM_SkHokenSyuruiNo extends AbstractExDBPrimaryKey<HM_SkHokenSyuruiNo, PKHM_SkHokenSyuruiNo> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkHokenSyuruiNo() {
    }

    public PKHM_SkHokenSyuruiNo(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd) {
        hknsyuruino = pHknsyuruino;
        hknsyuruinosd = pHknsyuruinosd;
    }

    @Transient
    @Override
    public Class<HM_SkHokenSyuruiNo> getEntityClass() {
        return HM_SkHokenSyuruiNo.class;
    }

    private C_HknsyuruiNo hknsyuruino;

    @org.hibernate.annotations.Type(type="UserType_C_HknsyuruiNo")
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }
    private Integer hknsyuruinosd;

    public Integer getHknsyuruinosd() {
        return hknsyuruinosd;
    }

    public void setHknsyuruinosd(Integer pHknsyuruinosd) {
        hknsyuruinosd = pHknsyuruinosd;
    }

}