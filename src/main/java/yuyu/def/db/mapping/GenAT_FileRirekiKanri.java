package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HozonHousiki;
import yuyu.def.db.entity.AT_FileRirekiKanri;
import yuyu.def.db.id.PKAT_FileRirekiKanri;
import yuyu.def.db.meta.GenQAT_FileRirekiKanri;
import yuyu.def.db.meta.QAT_FileRirekiKanri;
import yuyu.def.db.type.UserType_C_HozonHousiki;

/**
 * ファイル履歴管理テーブル テーブルのマッピング情報クラスで、 {@link AT_FileRirekiKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileRirekiKanri}</td><td colspan="3">ファイル履歴管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHistoryId historyId}</td><td>履歴ＩＤ</td><td align="center">{@link PKAT_FileRirekiKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHozonHousiki hozonHousiki}</td><td>保存方式</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HozonHousiki}</td></tr>
 *  <tr><td>{@link #getHozonSaki hozonSaki}</td><td>保存先</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNamingPattern namingPattern}</td><td>ネーミングパターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRirekiSakujyoJyouken rirekiSakujyoJyouken}</td><td>履歴削除条件</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_FileRirekiKanri
 * @see     PKAT_FileRirekiKanri
 * @see     QAT_FileRirekiKanri
 * @see     GenQAT_FileRirekiKanri
 */
@MappedSuperclass
@Table(name=GenAT_FileRirekiKanri.TABLE_NAME)
@IdClass(value=PKAT_FileRirekiKanri.class)
@TypeDefs({
    @TypeDef(name="UserType_C_HozonHousiki", typeClass=UserType_C_HozonHousiki.class)
})
public abstract class GenAT_FileRirekiKanri extends AbstractExDBEntity<AT_FileRirekiKanri, PKAT_FileRirekiKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_FileRirekiKanri";
    public static final String HISTORYID                = "historyId";
    public static final String HOZONHOUSIKI             = "hozonHousiki";
    public static final String HOZONSAKI                = "hozonSaki";
    public static final String NAMINGPATTERN            = "namingPattern";
    public static final String RIREKISAKUJYOJYOUKEN     = "rirekiSakujyoJyouken";

    private final PKAT_FileRirekiKanri primaryKey;

    public GenAT_FileRirekiKanri() {
        primaryKey = new PKAT_FileRirekiKanri();
    }

    public GenAT_FileRirekiKanri(String pHistoryId) {
        primaryKey = new PKAT_FileRirekiKanri(pHistoryId);
    }

    @Transient
    @Override
    public PKAT_FileRirekiKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_FileRirekiKanri> getMetaClass() {
        return QAT_FileRirekiKanri.class;
    }

    @Id
    @Column(name=GenAT_FileRirekiKanri.HISTORYID)
    public String getHistoryId() {
        return getPrimaryKey().getHistoryId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHistoryId(String pHistoryId) {
        getPrimaryKey().setHistoryId(pHistoryId);
    }

    private C_HozonHousiki hozonHousiki;

    @Type(type="UserType_C_HozonHousiki")
    @Column(name=GenAT_FileRirekiKanri.HOZONHOUSIKI)
    public C_HozonHousiki getHozonHousiki() {
        return hozonHousiki;
    }

    public void setHozonHousiki(C_HozonHousiki pHozonHousiki) {
        hozonHousiki = pHozonHousiki;
    }

    private String hozonSaki;

    @Column(name=GenAT_FileRirekiKanri.HOZONSAKI)
    public String getHozonSaki() {
        return hozonSaki;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHozonSaki(String pHozonSaki) {
        hozonSaki = pHozonSaki;
    }

    private String namingPattern;

    @Column(name=GenAT_FileRirekiKanri.NAMINGPATTERN)
    public String getNamingPattern() {
        return namingPattern;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNamingPattern(String pNamingPattern) {
        namingPattern = pNamingPattern;
    }

    private String rirekiSakujyoJyouken;

    @Column(name=GenAT_FileRirekiKanri.RIREKISAKUJYOJYOUKEN)
    public String getRirekiSakujyoJyouken() {
        return rirekiSakujyoJyouken;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRirekiSakujyoJyouken(String pRirekiSakujyoJyouken) {
        rirekiSakujyoJyouken = pRirekiSakujyoJyouken;
    }
}
