package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.id.PKIT_ItekiToukeiInfo;
import yuyu.def.db.meta.GenQIT_ItekiToukeiInfo;
import yuyu.def.db.meta.QIT_ItekiToukeiInfo;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 医的統計用情報テーブル テーブルのマッピング情報クラスで、 {@link IT_ItekiToukeiInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ItekiToukeiInfo}</td><td colspan="3">医的統計用情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_ItekiToukeiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKetkekkacd ketkekkacd}</td><td>決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ItekiToukeiInfo
 * @see     PKIT_ItekiToukeiInfo
 * @see     QIT_ItekiToukeiInfo
 * @see     GenQIT_ItekiToukeiInfo
 */
@MappedSuperclass
@Table(name=GenIT_ItekiToukeiInfo.TABLE_NAME)
@IdClass(value=PKIT_ItekiToukeiInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class)
})
public abstract class GenIT_ItekiToukeiInfo extends AbstractExDBEntity<IT_ItekiToukeiInfo, PKIT_ItekiToukeiInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_ItekiToukeiInfo";
    public static final String SYONO                    = "syono";
    public static final String KETKEKKACD               = "ketkekkacd";
    public static final String PALKETSYACD              = "palketsyacd";

    private final PKIT_ItekiToukeiInfo primaryKey;

    public GenIT_ItekiToukeiInfo() {
        primaryKey = new PKIT_ItekiToukeiInfo();
    }

    public GenIT_ItekiToukeiInfo(String pSyono) {
        primaryKey = new PKIT_ItekiToukeiInfo(pSyono);
    }

    @Transient
    @Override
    public PKIT_ItekiToukeiInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_ItekiToukeiInfo> getMetaClass() {
        return QIT_ItekiToukeiInfo.class;
    }

    @Id
    @Column(name=GenIT_ItekiToukeiInfo.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenIT_ItekiToukeiInfo.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private String palketsyacd;

    @Column(name=GenIT_ItekiToukeiInfo.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }
}