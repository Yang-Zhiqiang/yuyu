package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.def.db.id.PKAM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.GenQAM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.QAM_HonyakutsgSosikiCd;

/**
 * 翻訳対象外組織コードマスタ テーブルのマッピング情報クラスで、 {@link AM_HonyakutsgSosikiCd} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_HonyakutsgSosikiCd}</td><td colspan="3">翻訳対象外組織コードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSosikicd sosikicd}</td><td>組織コード</td><td align="center">{@link PKAM_HonyakutsgSosikiCd ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_HonyakutsgSosikiCd
 * @see     PKAM_HonyakutsgSosikiCd
 * @see     QAM_HonyakutsgSosikiCd
 * @see     GenQAM_HonyakutsgSosikiCd
 */
@MappedSuperclass
@Table(name=GenAM_HonyakutsgSosikiCd.TABLE_NAME)
@IdClass(value=PKAM_HonyakutsgSosikiCd.class)
public abstract class GenAM_HonyakutsgSosikiCd extends AbstractExDBEntity<AM_HonyakutsgSosikiCd, PKAM_HonyakutsgSosikiCd> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_HonyakutsgSosikiCd";
    public static final String SOSIKICD                 = "sosikicd";

    private final PKAM_HonyakutsgSosikiCd primaryKey;

    public GenAM_HonyakutsgSosikiCd() {
        primaryKey = new PKAM_HonyakutsgSosikiCd();
    }

    public GenAM_HonyakutsgSosikiCd(String pSosikicd) {
        primaryKey = new PKAM_HonyakutsgSosikiCd(pSosikicd);
    }

    @Transient
    @Override
    public PKAM_HonyakutsgSosikiCd getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_HonyakutsgSosikiCd> getMetaClass() {
        return QAM_HonyakutsgSosikiCd.class;
    }

    @Id
    @Column(name=GenAM_HonyakutsgSosikiCd.SOSIKICD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getSosikicd() {
        return getPrimaryKey().getSosikicd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSosikicd(String pSosikicd) {
        getPrimaryKey().setSosikicd(pSosikicd);
    }
}
