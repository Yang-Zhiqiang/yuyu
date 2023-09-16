package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import yuyu.def.db.id.PKBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.GenQBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.QBM_SyouhnToriatukaiTuuka;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 商品取扱通貨マスタ テーブルのマッピング情報クラスで、 {@link BM_SyouhnToriatukaiTuuka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyouhnToriatukaiTuuka}</td><td colspan="3">商品取扱通貨マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_SyouhnToriatukaiTuuka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkyfromymd tkyfromymd}</td><td>適用日自</td><td align="center">{@link PKBM_SyouhnToriatukaiTuuka ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTkytoymd tkytoymd}</td><td>適用日至</td><td align="center">{@link PKBM_SyouhnToriatukaiTuuka ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZenkizennouumu zenkizennouumu}</td><td>全期前納有無</td><td align="center">{@link PKBM_SyouhnToriatukaiTuuka ○}</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">{@link PKBM_SyouhnToriatukaiTuuka ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">{@link PKBM_SyouhnToriatukaiTuuka ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 * </table>
 * @see     BM_SyouhnToriatukaiTuuka
 * @see     PKBM_SyouhnToriatukaiTuuka
 * @see     QBM_SyouhnToriatukaiTuuka
 * @see     GenQBM_SyouhnToriatukaiTuuka
 */
@MappedSuperclass
@Table(name=GenBM_SyouhnToriatukaiTuuka.TABLE_NAME)
@IdClass(value=PKBM_SyouhnToriatukaiTuuka.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_SyouhnToriatukaiTuuka extends AbstractExDBEntity<BM_SyouhnToriatukaiTuuka, PKBM_SyouhnToriatukaiTuuka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SyouhnToriatukaiTuuka";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String TKYFROMYMD               = "tkyfromymd";
    public static final String TKYTOYMD                 = "tkytoymd";
    public static final String ZENKIZENNOUUMU           = "zenkizennouumu";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKTUUKASYU              = "hrktuukasyu";

    private final PKBM_SyouhnToriatukaiTuuka primaryKey;

    public GenBM_SyouhnToriatukaiTuuka() {
        primaryKey = new PKBM_SyouhnToriatukaiTuuka();
    }

    public GenBM_SyouhnToriatukaiTuuka(
        String pSyouhncd,
        BizDate pTkyfromymd,
        BizDate pTkytoymd,
        C_BlnktkumuKbn pZenkizennouumu,
        C_Tuukasyu pKyktuukasyu,
        C_Tuukasyu pHrktuukasyu
    ) {
        primaryKey = new PKBM_SyouhnToriatukaiTuuka(
            pSyouhncd,
            pTkyfromymd,
            pTkytoymd,
            pZenkizennouumu,
            pKyktuukasyu,
            pHrktuukasyu
        );
    }

    @Transient
    @Override
    public PKBM_SyouhnToriatukaiTuuka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SyouhnToriatukaiTuuka> getMetaClass() {
        return QBM_SyouhnToriatukaiTuuka.class;
    }

    @Id
    @Column(name=GenBM_SyouhnToriatukaiTuuka.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_SyouhnToriatukaiTuuka.TKYFROMYMD)
    @ValidDate
    public BizDate getTkyfromymd() {
        return getPrimaryKey().getTkyfromymd();
    }

    @Trim("both")
    public void setTkyfromymd(BizDate pTkyfromymd) {
        getPrimaryKey().setTkyfromymd(pTkyfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_SyouhnToriatukaiTuuka.TKYTOYMD)
    @ValidDate
    public BizDate getTkytoymd() {
        return getPrimaryKey().getTkytoymd();
    }

    @Trim("both")
    public void setTkytoymd(BizDate pTkytoymd) {
        getPrimaryKey().setTkytoymd(pTkytoymd);
    }

    @Id
    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenBM_SyouhnToriatukaiTuuka.ZENKIZENNOUUMU)
    public C_BlnktkumuKbn getZenkizennouumu() {
        return getPrimaryKey().getZenkizennouumu();
    }

    public void setZenkizennouumu(C_BlnktkumuKbn pZenkizennouumu) {
        getPrimaryKey().setZenkizennouumu(pZenkizennouumu);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_SyouhnToriatukaiTuuka.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return getPrimaryKey().getKyktuukasyu();
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        getPrimaryKey().setKyktuukasyu(pKyktuukasyu);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_SyouhnToriatukaiTuuka.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return getPrimaryKey().getHrktuukasyu();
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        getPrimaryKey().setHrktuukasyu(pHrktuukasyu);
    }
}