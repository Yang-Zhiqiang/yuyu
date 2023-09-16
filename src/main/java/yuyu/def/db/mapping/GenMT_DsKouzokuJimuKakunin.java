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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.db.id.PKMT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.GenQMT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.QMT_DsKouzokuJimuKakunin;
import yuyu.def.db.type.UserType_C_DsKzkJmKknHsJyKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ後続事務確認テーブル テーブルのマッピング情報クラスで、 {@link MT_DsKouzokuJimuKakunin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsKouzokuJimuKakunin}</td><td colspan="3">ＤＳ後続事務確認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHasseiymd hasseiymd}</td><td>発生日</td><td align="center">{@link PKMT_DsKouzokuJimuKakunin ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskzkjmkknhsjykbn dskzkjmkknhsjykbn}</td><td>ＤＳ後続事務確認発生事由区分</td><td align="center">{@link PKMT_DsKouzokuJimuKakunin ○}</td><td align="center">V</td><td>{@link C_DsKzkJmKknHsJyKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_DsKouzokuJimuKakunin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsKouzokuJimuKakunin
 * @see     PKMT_DsKouzokuJimuKakunin
 * @see     QMT_DsKouzokuJimuKakunin
 * @see     GenQMT_DsKouzokuJimuKakunin
 */
@MappedSuperclass
@Table(name=GenMT_DsKouzokuJimuKakunin.TABLE_NAME)
@IdClass(value=PKMT_DsKouzokuJimuKakunin.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsKzkJmKknHsJyKbn", typeClass=UserType_C_DsKzkJmKknHsJyKbn.class)
})
public abstract class GenMT_DsKouzokuJimuKakunin extends AbstractExDBEntity<MT_DsKouzokuJimuKakunin, PKMT_DsKouzokuJimuKakunin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsKouzokuJimuKakunin";
    public static final String HASSEIYMD                = "hasseiymd";
    public static final String DSKZKJMKKNHSJYKBN        = "dskzkjmkknhsjykbn";
    public static final String SYONO                    = "syono";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsKouzokuJimuKakunin primaryKey;

    public GenMT_DsKouzokuJimuKakunin() {
        primaryKey = new PKMT_DsKouzokuJimuKakunin();
    }

    public GenMT_DsKouzokuJimuKakunin(
        BizDate pHasseiymd,
        C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn,
        String pSyono
    ) {
        primaryKey = new PKMT_DsKouzokuJimuKakunin(
            pHasseiymd,
            pDskzkjmkknhsjykbn,
            pSyono
        );
    }

    @Transient
    @Override
    public PKMT_DsKouzokuJimuKakunin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsKouzokuJimuKakunin> getMetaClass() {
        return QMT_DsKouzokuJimuKakunin.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsKouzokuJimuKakunin.HASSEIYMD)
    public BizDate getHasseiymd() {
        return getPrimaryKey().getHasseiymd();
    }

    public void setHasseiymd(BizDate pHasseiymd) {
        getPrimaryKey().setHasseiymd(pHasseiymd);
    }

    @Id
    @Type(type="UserType_C_DsKzkJmKknHsJyKbn")
    @Column(name=GenMT_DsKouzokuJimuKakunin.DSKZKJMKKNHSJYKBN)
    public C_DsKzkJmKknHsJyKbn getDskzkjmkknhsjykbn() {
        return getPrimaryKey().getDskzkjmkknhsjykbn();
    }

    public void setDskzkjmkknhsjykbn(C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn) {
        getPrimaryKey().setDskzkjmkknhsjykbn(pDskzkjmkknhsjykbn);
    }

    @Id
    @Column(name=GenMT_DsKouzokuJimuKakunin.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsKouzokuJimuKakunin.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsKouzokuJimuKakunin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsKouzokuJimuKakunin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}