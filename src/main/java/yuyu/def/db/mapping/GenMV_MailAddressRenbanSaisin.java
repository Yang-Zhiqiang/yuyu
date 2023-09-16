package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.MV_MailAddressRenbanSaisin;
import yuyu.def.db.id.PKMV_MailAddressRenbanSaisin;
import yuyu.def.db.meta.GenQMV_MailAddressRenbanSaisin;
import yuyu.def.db.meta.QMV_MailAddressRenbanSaisin;

/**
 * ＤＳメールアドレス連番最新ビュー テーブルのマッピング情報クラスで、 {@link MV_MailAddressRenbanSaisin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MV_MailAddressRenbanSaisin}</td><td colspan="3">ＤＳメールアドレス連番最新ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMV_MailAddressRenbanSaisin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">{@link PKMV_MailAddressRenbanSaisin ○}</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     MV_MailAddressRenbanSaisin
 * @see     PKMV_MailAddressRenbanSaisin
 * @see     QMV_MailAddressRenbanSaisin
 * @see     GenQMV_MailAddressRenbanSaisin
 */
@MappedSuperclass
@Table(name=GenMV_MailAddressRenbanSaisin.TABLE_NAME)
@IdClass(value=PKMV_MailAddressRenbanSaisin.class)
public abstract class GenMV_MailAddressRenbanSaisin extends AbstractExDBEntity<MV_MailAddressRenbanSaisin, PKMV_MailAddressRenbanSaisin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MV_MailAddressRenbanSaisin";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILADDRESSRENBAN      = "dsmailaddressrenban";

    private final PKMV_MailAddressRenbanSaisin primaryKey;

    public GenMV_MailAddressRenbanSaisin() {
        primaryKey = new PKMV_MailAddressRenbanSaisin();
    }

    public GenMV_MailAddressRenbanSaisin(String pDskokno, Integer pDsmailaddressrenban) {
        primaryKey = new PKMV_MailAddressRenbanSaisin(pDskokno, pDsmailaddressrenban);
    }

    @Transient
    @Override
    public PKMV_MailAddressRenbanSaisin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMV_MailAddressRenbanSaisin> getMetaClass() {
        return QMV_MailAddressRenbanSaisin.class;
    }

    @Id
    @Column(name=GenMV_MailAddressRenbanSaisin.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMV_MailAddressRenbanSaisin.DSMAILADDRESSRENBAN)
    public Integer getDsmailaddressrenban() {
        return getPrimaryKey().getDsmailaddressrenban();
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        getPrimaryKey().setDsmailaddressrenban(pDsmailaddressrenban);
    }
}