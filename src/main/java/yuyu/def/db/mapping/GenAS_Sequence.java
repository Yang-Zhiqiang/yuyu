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
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.id.PKAS_Sequence;
import yuyu.def.db.meta.GenQAS_Sequence;
import yuyu.def.db.meta.QAS_Sequence;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 連番管理基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_Sequence} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Sequence}</td><td colspan="3">連番管理基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getId id}</td><td>ＩＤ</td><td align="center">{@link PKAS_Sequence ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getName name}</td><td>名前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStartWith startWith}</td><td>初期値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getIncrease increase}</td><td>増分値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMaxValue maxValue}</td><td>最大値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getCacheSize cacheSize}</td><td>キャッシュサイズ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPadding padding}</td><td>ゼロパディング有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getLength length}</td><td>桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AS_Sequence
 * @see     PKAS_Sequence
 * @see     QAS_Sequence
 * @see     GenQAS_Sequence
 */
@MappedSuperclass
@Table(name=GenAS_Sequence.TABLE_NAME)
@IdClass(value=PKAS_Sequence.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenAS_Sequence extends AbstractExDBEntity<AS_Sequence, PKAS_Sequence> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_Sequence";
    public static final String ID                       = "id";
    public static final String NAME                     = "name";
    public static final String STARTWITH                = "startWith";
    public static final String INCREASE                 = "increase";
    public static final String MAXVALUE                 = "maxValue";
    public static final String CACHESIZE                = "cacheSize";
    public static final String PADDING                  = "padding";
    public static final String LENGTH                   = "length";

    private final PKAS_Sequence primaryKey;

    public GenAS_Sequence() {
        primaryKey = new PKAS_Sequence();
    }

    public GenAS_Sequence(String pId) {
        primaryKey = new PKAS_Sequence(pId);
    }

    @Transient
    @Override
    public PKAS_Sequence getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_Sequence> getMetaClass() {
        return QAS_Sequence.class;
    }

    @Id
    @Column(name=GenAS_Sequence.ID)
    public String getId() {
        return getPrimaryKey().getId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setId(String pId) {
        getPrimaryKey().setId(pId);
    }

    private String name;

    @Column(name=GenAS_Sequence.NAME)
    public String getName() {
        return name;
    }

    @Trim("both")
    public void setName(String pName) {
        name = pName;
    }

    private Long startWith;

    @Column(name=GenAS_Sequence.STARTWITH)
    public Long getStartWith() {
        return startWith;
    }

    public void setStartWith(Long pStartWith) {
        startWith = pStartWith;
    }

    private Integer increase;

    @Column(name=GenAS_Sequence.INCREASE)
    public Integer getIncrease() {
        return increase;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIncrease(Integer pIncrease) {
        increase = pIncrease;
    }

    private Long maxValue;

    @Column(name=GenAS_Sequence.MAXVALUE)
    public Long getMaxValue() {
        return maxValue;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMaxValue(Long pMaxValue) {
        maxValue = pMaxValue;
    }

    private Integer cacheSize;

    @Column(name=GenAS_Sequence.CACHESIZE)
    public Integer getCacheSize() {
        return cacheSize;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCacheSize(Integer pCacheSize) {
        cacheSize = pCacheSize;
    }

    private C_UmuKbn padding;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenAS_Sequence.PADDING)
    public C_UmuKbn getPadding() {
        return padding;
    }

    public void setPadding(C_UmuKbn pPadding) {
        padding = pPadding;
    }

    private Integer length;

    @Column(name=GenAS_Sequence.LENGTH)
    public Integer getLength() {
        return length;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLength(Integer pLength) {
        length = pLength;
    }
}
