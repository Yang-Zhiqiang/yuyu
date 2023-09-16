package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AT_FileSansyoKaisu;
import yuyu.def.db.id.PKAT_FileSansyoKaisu;
import yuyu.def.db.meta.GenQAT_FileSansyoKaisu;
import yuyu.def.db.meta.QAT_FileSansyoKaisu;

/**
 * ファイル参照回数テーブル テーブルのマッピング情報クラスで、 {@link AT_FileSansyoKaisu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileSansyoKaisu}</td><td colspan="3">ファイル参照回数テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_FileSansyoKaisu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSansyoucount sansyoucount}</td><td>参照回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AT_FileSansyoKaisu
 * @see     PKAT_FileSansyoKaisu
 * @see     QAT_FileSansyoKaisu
 * @see     GenQAT_FileSansyoKaisu
 */
@MappedSuperclass
@Table(name=GenAT_FileSansyoKaisu.TABLE_NAME)
@IdClass(value=PKAT_FileSansyoKaisu.class)
public abstract class GenAT_FileSansyoKaisu extends AbstractExDBEntity<AT_FileSansyoKaisu, PKAT_FileSansyoKaisu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_FileSansyoKaisu";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String SANSYOUCOUNT             = "sansyoucount";

    private final PKAT_FileSansyoKaisu primaryKey;

    public GenAT_FileSansyoKaisu() {
        primaryKey = new PKAT_FileSansyoKaisu();
    }

    public GenAT_FileSansyoKaisu(String pUniqueId) {
        primaryKey = new PKAT_FileSansyoKaisu(pUniqueId);
    }

    @Transient
    @Override
    public PKAT_FileSansyoKaisu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_FileSansyoKaisu> getMetaClass() {
        return QAT_FileSansyoKaisu.class;
    }

    @Id
    @Column(name=GenAT_FileSansyoKaisu.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private Integer sansyoucount;

    @Column(name=GenAT_FileSansyoKaisu.SANSYOUCOUNT)
    public Integer getSansyoucount() {
        return sansyoucount;
    }

    public void setSansyoucount(Integer pSansyoucount) {
        sansyoucount = pSansyoucount;
    }
}