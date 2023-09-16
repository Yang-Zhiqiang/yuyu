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
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.id.PKAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.GenQAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.QAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.type.UserType_C_NengetuKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 帳票削除対象基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_TyouhyouSakujyotaisyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_TyouhyouSakujyotaisyo}</td><td colspan="3">帳票削除対象基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKAS_TyouhyouSakujyotaisyo ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHozonKikan hozonKikan}</td><td>保存期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNengetukbn nengetukbn}</td><td>年月区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NengetuKbn}</td></tr>
 * </table>
 * @see     AS_TyouhyouSakujyotaisyo
 * @see     PKAS_TyouhyouSakujyotaisyo
 * @see     QAS_TyouhyouSakujyotaisyo
 * @see     GenQAS_TyouhyouSakujyotaisyo
 */
@MappedSuperclass
@Table(name=GenAS_TyouhyouSakujyotaisyo.TABLE_NAME)
@IdClass(value=PKAS_TyouhyouSakujyotaisyo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NengetuKbn", typeClass=UserType_C_NengetuKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenAS_TyouhyouSakujyotaisyo extends AbstractExDBEntity<AS_TyouhyouSakujyotaisyo, PKAS_TyouhyouSakujyotaisyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_TyouhyouSakujyotaisyo";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HOZONKIKAN               = "hozonKikan";
    public static final String NENGETUKBN               = "nengetukbn";

    private final PKAS_TyouhyouSakujyotaisyo primaryKey;

    public GenAS_TyouhyouSakujyotaisyo() {
        primaryKey = new PKAS_TyouhyouSakujyotaisyo();
    }

    public GenAS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn pSyoruiCd) {
        primaryKey = new PKAS_TyouhyouSakujyotaisyo(pSyoruiCd);
    }

    @Transient
    @Override
    public PKAS_TyouhyouSakujyotaisyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_TyouhyouSakujyotaisyo> getMetaClass() {
        return QAS_TyouhyouSakujyotaisyo.class;
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenAS_TyouhyouSakujyotaisyo.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    private Integer hozonKikan;

    @Column(name=GenAS_TyouhyouSakujyotaisyo.HOZONKIKAN)
    public Integer getHozonKikan() {
        return hozonKikan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHozonKikan(Integer pHozonKikan) {
        hozonKikan = pHozonKikan;
    }

    private C_NengetuKbn nengetukbn;

    @Type(type="UserType_C_NengetuKbn")
    @Column(name=GenAS_TyouhyouSakujyotaisyo.NENGETUKBN)
    public C_NengetuKbn getNengetukbn() {
        return nengetukbn;
    }

    public void setNengetukbn(C_NengetuKbn pNengetukbn) {
        nengetukbn = pNengetukbn;
    }
}