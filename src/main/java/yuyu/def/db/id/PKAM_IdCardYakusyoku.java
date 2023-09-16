package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AM_IdCardYakusyoku;
import yuyu.def.db.mapping.GenAM_IdCardYakusyoku;
import yuyu.def.db.meta.GenQAM_IdCardYakusyoku;
import yuyu.def.db.meta.QAM_IdCardYakusyoku;

/**
 * ＩＤカード役職マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_IdCardYakusyoku}</td><td colspan="3">ＩＤカード役職マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYakusyokuhatureiymd yakusyokuhatureiymd}</td><td>役職発令年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYakusyokuhatureino yakusyokuhatureino}</td><td>役職発令番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yakusyokuhatureisosikicd</td><td>役職発令組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yakusyokucd</td><td>役職コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_IdCardYakusyoku
 * @see     GenAM_IdCardYakusyoku
 * @see     QAM_IdCardYakusyoku
 * @see     GenQAM_IdCardYakusyoku
 */
public class PKAM_IdCardYakusyoku extends AbstractExDBPrimaryKey<AM_IdCardYakusyoku, PKAM_IdCardYakusyoku> {

    private static final long serialVersionUID = 1L;

    public PKAM_IdCardYakusyoku() {
    }

    public PKAM_IdCardYakusyoku(
        String pIdkbn,
        String pIdcd,
        BizDate pYakusyokuhatureiymd,
        String pYakusyokuhatureino
    ) {
        idkbn = pIdkbn;
        idcd = pIdcd;
        yakusyokuhatureiymd = pYakusyokuhatureiymd;
        yakusyokuhatureino = pYakusyokuhatureino;
    }

    @Transient
    @Override
    public Class<AM_IdCardYakusyoku> getEntityClass() {
        return AM_IdCardYakusyoku.class;
    }

    private String idkbn;

    public String getIdkbn() {
        return idkbn;
    }

    public void setIdkbn(String pIdkbn) {
        idkbn = pIdkbn;
    }
    private String idcd;

    public String getIdcd() {
        return idcd;
    }

    public void setIdcd(String pIdcd) {
        idcd = pIdcd;
    }
    private BizDate yakusyokuhatureiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getYakusyokuhatureiymd() {
        return yakusyokuhatureiymd;
    }

    public void setYakusyokuhatureiymd(BizDate pYakusyokuhatureiymd) {
        yakusyokuhatureiymd = pYakusyokuhatureiymd;
    }
    private String yakusyokuhatureino;

    public String getYakusyokuhatureino() {
        return yakusyokuhatureino;
    }

    public void setYakusyokuhatureino(String pYakusyokuhatureino) {
        yakusyokuhatureino = pYakusyokuhatureino;
    }

}