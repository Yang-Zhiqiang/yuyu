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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.db.entity.IW_KhTargetTokuyakuHenkouWk;
import yuyu.def.db.id.PKIW_KhTargetTokuyakuHenkouWk;
import yuyu.def.db.meta.GenQIW_KhTargetTokuyakuHenkouWk;
import yuyu.def.db.meta.QIW_KhTargetTokuyakuHenkouWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KanryotuutioutKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TargetTkHenkouKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ターゲット特約変更ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhTargetTokuyakuHenkouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhTargetTokuyakuHenkouWk}</td><td colspan="3">ターゲット特約変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhTargetTokuyakuHenkouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkykkykhenkoymd targettkykkykhenkoymd}</td><td>ターゲット特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkykhnkkbn targettkykhnkkbn}</td><td>ターゲット特約変更区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkHenkouKbn}</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getKanryotuutioutkbn kanryotuutioutkbn}</td><td>完了通知出力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KanryotuutioutKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhTargetTokuyakuHenkouWk
 * @see     PKIW_KhTargetTokuyakuHenkouWk
 * @see     QIW_KhTargetTokuyakuHenkouWk
 * @see     GenQIW_KhTargetTokuyakuHenkouWk
 */
@MappedSuperclass
@Table(name=GenIW_KhTargetTokuyakuHenkouWk.TABLE_NAME)
@IdClass(value=PKIW_KhTargetTokuyakuHenkouWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_KanryotuutioutKbn", typeClass=UserType_C_KanryotuutioutKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_TargetTkHenkouKbn", typeClass=UserType_C_TargetTkHenkouKbn.class)
})
public abstract class GenIW_KhTargetTokuyakuHenkouWk extends AbstractExDBEntity<IW_KhTargetTokuyakuHenkouWk, PKIW_KhTargetTokuyakuHenkouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhTargetTokuyakuHenkouWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String TARGETTKYKKYKHENKOYMD    = "targettkykkykhenkoymd";
    public static final String TARGETTKYKHNKKBN         = "targettkykhnkkbn";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String KANRYOTUUTIOUTKBN        = "kanryotuutioutkbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_KhTargetTokuyakuHenkouWk primaryKey;

    public GenIW_KhTargetTokuyakuHenkouWk() {
        primaryKey = new PKIW_KhTargetTokuyakuHenkouWk();
    }

    public GenIW_KhTargetTokuyakuHenkouWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhTargetTokuyakuHenkouWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhTargetTokuyakuHenkouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhTargetTokuyakuHenkouWk> getMetaClass() {
        return QIW_KhTargetTokuyakuHenkouWk.class;
    }

    @Id
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private BizDate skssakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private BizDate targettkykkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.TARGETTKYKKYKHENKOYMD)
    @ValidDate
    public BizDate getTargettkykkykhenkoymd() {
        return targettkykkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd) {
        targettkykkykhenkoymd = pTargettkykkykhenkoymd;
    }

    private C_TargetTkHenkouKbn targettkykhnkkbn;

    @Type(type="UserType_C_TargetTkHenkouKbn")
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.TARGETTKYKHNKKBN)
    public C_TargetTkHenkouKbn getTargettkykhnkkbn() {
        return targettkykhnkkbn;
    }

    public void setTargettkykhnkkbn(C_TargetTkHenkouKbn pTargettkykhnkkbn) {
        targettkykhnkkbn = pTargettkykhnkkbn;
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_KanryotuutioutKbn kanryotuutioutkbn;

    @Type(type="UserType_C_KanryotuutioutKbn")
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.KANRYOTUUTIOUTKBN)
    public C_KanryotuutioutKbn getKanryotuutioutkbn() {
        return kanryotuutioutkbn;
    }

    public void setKanryotuutioutkbn(C_KanryotuutioutKbn pKanryotuutioutkbn) {
        kanryotuutioutkbn = pKanryotuutioutkbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhTargetTokuyakuHenkouWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}