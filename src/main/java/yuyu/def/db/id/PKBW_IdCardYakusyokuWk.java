package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;
import yuyu.def.db.mapping.GenBW_IdCardYakusyokuWk;
import yuyu.def.db.meta.GenQBW_IdCardYakusyokuWk;
import yuyu.def.db.meta.QBW_IdCardYakusyokuWk;

/**
 * ＩＤカード役職マスタワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_IdCardYakusyokuWk}</td><td colspan="3">ＩＤカード役職マスタワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYakusyokuhatureiymd yakusyokuhatureiymd}</td><td>役職発令年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYakusyokuhatureino yakusyokuhatureino}</td><td>役職発令番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yakusyokuhatureisosikicd</td><td>役職発令組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yakusyokucd</td><td>役職コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BW_IdCardYakusyokuWk
 * @see     GenBW_IdCardYakusyokuWk
 * @see     QBW_IdCardYakusyokuWk
 * @see     GenQBW_IdCardYakusyokuWk
 */
public class PKBW_IdCardYakusyokuWk extends AbstractExDBPrimaryKey<BW_IdCardYakusyokuWk, PKBW_IdCardYakusyokuWk> {

    private static final long serialVersionUID = 1L;

    public PKBW_IdCardYakusyokuWk() {
    }

    public PKBW_IdCardYakusyokuWk(
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
    public Class<BW_IdCardYakusyokuWk> getEntityClass() {
        return BW_IdCardYakusyokuWk.class;
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