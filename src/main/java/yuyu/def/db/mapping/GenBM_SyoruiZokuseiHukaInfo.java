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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.id.PKBM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.meta.GenQBM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.meta.QBM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 書類属性付加情報マスタ テーブルのマッピング情報クラスで、 {@link BM_SyoruiZokuseiHukaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyoruiZokuseiHukaInfo}</td><td colspan="3">書類属性付加情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKBM_SyoruiZokuseiHukaInfo ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyououtkinousiyouumu tyouhyououtkinousiyouumu}</td><td>帳票出力機能使用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     BM_SyoruiZokuseiHukaInfo
 * @see     PKBM_SyoruiZokuseiHukaInfo
 * @see     QBM_SyoruiZokuseiHukaInfo
 * @see     GenQBM_SyoruiZokuseiHukaInfo
 */
@MappedSuperclass
@Table(name=GenBM_SyoruiZokuseiHukaInfo.TABLE_NAME)
@IdClass(value=PKBM_SyoruiZokuseiHukaInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenBM_SyoruiZokuseiHukaInfo extends AbstractExDBEntity<BM_SyoruiZokuseiHukaInfo, PKBM_SyoruiZokuseiHukaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SyoruiZokuseiHukaInfo";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String TYOUHYOUOUTKINOUSIYOUUMU = "tyouhyououtkinousiyouumu";

    private final PKBM_SyoruiZokuseiHukaInfo primaryKey;

    public GenBM_SyoruiZokuseiHukaInfo() {
        primaryKey = new PKBM_SyoruiZokuseiHukaInfo();
    }

    public GenBM_SyoruiZokuseiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        primaryKey = new PKBM_SyoruiZokuseiHukaInfo(pSyoruiCd);
    }

    @Transient
    @Override
    public PKBM_SyoruiZokuseiHukaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SyoruiZokuseiHukaInfo> getMetaClass() {
        return QBM_SyoruiZokuseiHukaInfo.class;
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBM_SyoruiZokuseiHukaInfo.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    private String subSystemId;

    @Column(name=GenBM_SyoruiZokuseiHukaInfo.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private C_UmuKbn tyouhyououtkinousiyouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyoruiZokuseiHukaInfo.TYOUHYOUOUTKINOUSIYOUUMU)
    public C_UmuKbn getTyouhyououtkinousiyouumu() {
        return tyouhyououtkinousiyouumu;
    }

    public void setTyouhyououtkinousiyouumu(C_UmuKbn pTyouhyououtkinousiyouumu) {
        tyouhyououtkinousiyouumu = pTyouhyououtkinousiyouumu;
    }
}