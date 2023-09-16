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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.def.db.id.PKBT_TyouhyouOutputKengen;
import yuyu.def.db.meta.GenQBT_TyouhyouOutputKengen;
import yuyu.def.db.meta.QBT_TyouhyouOutputKengen;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 帳票出力権限テーブル テーブルのマッピング情報クラスで、 {@link BT_TyouhyouOutputKengen} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TyouhyouOutputKengen}</td><td colspan="3">帳票出力権限テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKBT_TyouhyouOutputKengen ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKBT_TyouhyouOutputKengen ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getIkkatuoutputkahikbn ikkatuoutputkahikbn}</td><td>一括出力可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getKobetuoutputkahikbn kobetuoutputkahikbn}</td><td>個別出力可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_TyouhyouOutputKengen
 * @see     PKBT_TyouhyouOutputKengen
 * @see     QBT_TyouhyouOutputKengen
 * @see     GenQBT_TyouhyouOutputKengen
 */
@MappedSuperclass
@Table(name=GenBT_TyouhyouOutputKengen.TABLE_NAME)
@IdClass(value=PKBT_TyouhyouOutputKengen.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenBT_TyouhyouOutputKengen extends AbstractExDBEntity<BT_TyouhyouOutputKengen, PKBT_TyouhyouOutputKengen> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_TyouhyouOutputKengen";
    public static final String ROLECD                   = "roleCd";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String IKKATUOUTPUTKAHIKBN      = "ikkatuoutputkahikbn";
    public static final String KOBETUOUTPUTKAHIKBN      = "kobetuoutputkahikbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_TyouhyouOutputKengen primaryKey;

    public GenBT_TyouhyouOutputKengen() {
        primaryKey = new PKBT_TyouhyouOutputKengen();
    }

    public GenBT_TyouhyouOutputKengen(String pRoleCd, C_SyoruiCdKbn pSyoruiCd) {
        primaryKey = new PKBT_TyouhyouOutputKengen(pRoleCd, pSyoruiCd);
    }

    @Transient
    @Override
    public PKBT_TyouhyouOutputKengen getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_TyouhyouOutputKengen> getMetaClass() {
        return QBT_TyouhyouOutputKengen.class;
    }

    @Id
    @Column(name=GenBT_TyouhyouOutputKengen.ROLECD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getRoleCd() {
        return getPrimaryKey().getRoleCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        getPrimaryKey().setRoleCd(pRoleCd);
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBT_TyouhyouOutputKengen.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    private C_KahiKbn ikkatuoutputkahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenBT_TyouhyouOutputKengen.IKKATUOUTPUTKAHIKBN)
    public C_KahiKbn getIkkatuoutputkahikbn() {
        return ikkatuoutputkahikbn;
    }

    public void setIkkatuoutputkahikbn(C_KahiKbn pIkkatuoutputkahikbn) {
        ikkatuoutputkahikbn = pIkkatuoutputkahikbn;
    }

    private C_KahiKbn kobetuoutputkahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenBT_TyouhyouOutputKengen.KOBETUOUTPUTKAHIKBN)
    public C_KahiKbn getKobetuoutputkahikbn() {
        return kobetuoutputkahikbn;
    }

    public void setKobetuoutputkahikbn(C_KahiKbn pKobetuoutputkahikbn) {
        kobetuoutputkahikbn = pKobetuoutputkahikbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_TyouhyouOutputKengen.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_TyouhyouOutputKengen.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}