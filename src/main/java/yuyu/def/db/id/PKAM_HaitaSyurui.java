package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AM_HaitaSyurui;
import yuyu.def.db.mapping.GenAM_HaitaSyurui;
import yuyu.def.db.meta.GenQAM_HaitaSyurui;
import yuyu.def.db.meta.QAM_HaitaSyurui;

/**
 * 排他種類マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_HaitaSyurui}</td><td colspan="3">排他種類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitaSyuruiCd haitaSyuruiCd}</td><td>排他種類コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haitaSyuruiNm</td><td>排他種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haitaKeyKousei</td><td>排他キー構成</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_HaitaSyurui
 * @see     GenAM_HaitaSyurui
 * @see     QAM_HaitaSyurui
 * @see     GenQAM_HaitaSyurui
 */
public class PKAM_HaitaSyurui extends AbstractExDBPrimaryKey<AM_HaitaSyurui, PKAM_HaitaSyurui> {

    private static final long serialVersionUID = 1L;

    public PKAM_HaitaSyurui() {
    }

    public PKAM_HaitaSyurui(String pHaitaSyuruiCd) {
        haitaSyuruiCd = pHaitaSyuruiCd;
    }

    @Transient
    @Override
    public Class<AM_HaitaSyurui> getEntityClass() {
        return AM_HaitaSyurui.class;
    }

    private String haitaSyuruiCd;

    public String getHaitaSyuruiCd() {
        return haitaSyuruiCd;
    }

    public void setHaitaSyuruiCd(String pHaitaSyuruiCd) {
        haitaSyuruiCd = pHaitaSyuruiCd;
    }

}