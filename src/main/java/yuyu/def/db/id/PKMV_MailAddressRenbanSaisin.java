package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MV_MailAddressRenbanSaisin;
import yuyu.def.db.mapping.GenMV_MailAddressRenbanSaisin;
import yuyu.def.db.meta.GenQMV_MailAddressRenbanSaisin;
import yuyu.def.db.meta.QMV_MailAddressRenbanSaisin;

/**
 * ＤＳメールアドレス連番最新ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MV_MailAddressRenbanSaisin}</td><td colspan="3">ＤＳメールアドレス連番最新ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     MV_MailAddressRenbanSaisin
 * @see     GenMV_MailAddressRenbanSaisin
 * @see     QMV_MailAddressRenbanSaisin
 * @see     GenQMV_MailAddressRenbanSaisin
 */
public class PKMV_MailAddressRenbanSaisin extends AbstractExDBPrimaryKey<MV_MailAddressRenbanSaisin, PKMV_MailAddressRenbanSaisin> {

    private static final long serialVersionUID = 1L;

    public PKMV_MailAddressRenbanSaisin() {
    }

    public PKMV_MailAddressRenbanSaisin(String pDskokno, Integer pDsmailaddressrenban) {
        dskokno = pDskokno;
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    @Transient
    @Override
    public Class<MV_MailAddressRenbanSaisin> getEntityClass() {
        return MV_MailAddressRenbanSaisin.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private Integer dsmailaddressrenban;

    public Integer getDsmailaddressrenban() {
        return dsmailaddressrenban;
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        dsmailaddressrenban = pDsmailaddressrenban;
    }

}