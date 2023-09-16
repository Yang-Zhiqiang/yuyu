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
import yuyu.def.classification.C_NengappiKbn;
import yuyu.def.classification.C_SakujyoKbn;
import yuyu.def.classification.C_SakujyoKeyKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.id.PKAS_Sakujyotaisyo;
import yuyu.def.db.meta.GenQAS_Sakujyotaisyo;
import yuyu.def.db.meta.QAS_Sakujyotaisyo;
import yuyu.def.db.type.UserType_C_NengappiKbn;
import yuyu.def.db.type.UserType_C_SakujyoKbn;
import yuyu.def.db.type.UserType_C_SakujyoKeyKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 削除対象基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_Sakujyotaisyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Sakujyotaisyo}</td><td colspan="3">削除対象基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSakujyoTableId sakujyoTableId}</td><td>削除対象テーブルＩＤ</td><td align="center">{@link PKAS_Sakujyotaisyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakujyoKbn sakujyoKbn}</td><td>削除区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SakujyoKbn}</td></tr>
 *  <tr><td>{@link #getSakujyoKey sakujyoKey}</td><td>削除キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakujyoKeyKbn sakujyoKeyKbn}</td><td>削除キー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SakujyoKeyKbn}</td></tr>
 *  <tr><td>{@link #getHozonKikan hozonKikan}</td><td>保存期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNengappiKbn nengappiKbn}</td><td>年月日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NengappiKbn}</td></tr>
 *  <tr><td>{@link #getDataTaihiKbn dataTaihiKbn}</td><td>データ退避区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     AS_Sakujyotaisyo
 * @see     PKAS_Sakujyotaisyo
 * @see     QAS_Sakujyotaisyo
 * @see     GenQAS_Sakujyotaisyo
 */
@MappedSuperclass
@Table(name=GenAS_Sakujyotaisyo.TABLE_NAME)
@IdClass(value=PKAS_Sakujyotaisyo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NengappiKbn", typeClass=UserType_C_NengappiKbn.class),
    @TypeDef(name="UserType_C_SakujyoKbn", typeClass=UserType_C_SakujyoKbn.class),
    @TypeDef(name="UserType_C_SakujyoKeyKbn", typeClass=UserType_C_SakujyoKeyKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenAS_Sakujyotaisyo extends AbstractExDBEntity<AS_Sakujyotaisyo, PKAS_Sakujyotaisyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_Sakujyotaisyo";
    public static final String SAKUJYOTABLEID           = "sakujyoTableId";
    public static final String SAKUJYOKBN               = "sakujyoKbn";
    public static final String SAKUJYOKEY               = "sakujyoKey";
    public static final String SAKUJYOKEYKBN            = "sakujyoKeyKbn";
    public static final String HOZONKIKAN               = "hozonKikan";
    public static final String NENGAPPIKBN              = "nengappiKbn";
    public static final String DATATAIHIKBN             = "dataTaihiKbn";

    private final PKAS_Sakujyotaisyo primaryKey;

    public GenAS_Sakujyotaisyo() {
        primaryKey = new PKAS_Sakujyotaisyo();
    }

    public GenAS_Sakujyotaisyo(String pSakujyoTableId) {
        primaryKey = new PKAS_Sakujyotaisyo(pSakujyoTableId);
    }

    @Transient
    @Override
    public PKAS_Sakujyotaisyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_Sakujyotaisyo> getMetaClass() {
        return QAS_Sakujyotaisyo.class;
    }

    @Id
    @Column(name=GenAS_Sakujyotaisyo.SAKUJYOTABLEID)
    public String getSakujyoTableId() {
        return getPrimaryKey().getSakujyoTableId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakujyoTableId(String pSakujyoTableId) {
        getPrimaryKey().setSakujyoTableId(pSakujyoTableId);
    }

    private C_SakujyoKbn sakujyoKbn;

    @Type(type="UserType_C_SakujyoKbn")
    @Column(name=GenAS_Sakujyotaisyo.SAKUJYOKBN)
    public C_SakujyoKbn getSakujyoKbn() {
        return sakujyoKbn;
    }

    public void setSakujyoKbn(C_SakujyoKbn pSakujyoKbn) {
        sakujyoKbn = pSakujyoKbn;
    }

    private String sakujyoKey;

    @Column(name=GenAS_Sakujyotaisyo.SAKUJYOKEY)
    public String getSakujyoKey() {
        return sakujyoKey;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakujyoKey(String pSakujyoKey) {
        sakujyoKey = pSakujyoKey;
    }

    private C_SakujyoKeyKbn sakujyoKeyKbn;

    @Type(type="UserType_C_SakujyoKeyKbn")
    @Column(name=GenAS_Sakujyotaisyo.SAKUJYOKEYKBN)
    public C_SakujyoKeyKbn getSakujyoKeyKbn() {
        return sakujyoKeyKbn;
    }

    public void setSakujyoKeyKbn(C_SakujyoKeyKbn pSakujyoKeyKbn) {
        sakujyoKeyKbn = pSakujyoKeyKbn;
    }

    private Integer hozonKikan;

    @Column(name=GenAS_Sakujyotaisyo.HOZONKIKAN)
    public Integer getHozonKikan() {
        return hozonKikan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHozonKikan(Integer pHozonKikan) {
        hozonKikan = pHozonKikan;
    }

    private C_NengappiKbn nengappiKbn;

    @Type(type="UserType_C_NengappiKbn")
    @Column(name=GenAS_Sakujyotaisyo.NENGAPPIKBN)
    public C_NengappiKbn getNengappiKbn() {
        return nengappiKbn;
    }

    public void setNengappiKbn(C_NengappiKbn pNengappiKbn) {
        nengappiKbn = pNengappiKbn;
    }

    private C_UmuKbn dataTaihiKbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenAS_Sakujyotaisyo.DATATAIHIKBN)
    public C_UmuKbn getDataTaihiKbn() {
        return dataTaihiKbn;
    }

    public void setDataTaihiKbn(C_UmuKbn pDataTaihiKbn) {
        dataTaihiKbn = pDataTaihiKbn;
    }
}
