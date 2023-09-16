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
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.id.PKIT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.meta.GenQIT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.meta.QIT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 銀行窓販未収情報テーブル テーブルのマッピング情報クラスで、 {@link IT_KhGinkouMdhnMisyuuInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhGinkouMdhnMisyuuInfo}</td><td colspan="3">銀行窓販未収情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhGinkouMdhnMisyuuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDatarenymd datarenymd}</td><td>データ連動日</td><td align="center">{@link PKIT_KhGinkouMdhnMisyuuInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhGinkouMdhnMisyuuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_KhGinkouMdhnMisyuuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwbsydrtencd gwbsydrtencd}</td><td>ＧＷ＿募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwdatakbn gwdatakbn}</td><td>ＧＷ＿データ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwdatasakuseiymd gwdatasakuseiymd}</td><td>ＧＷ＿データ作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwhknkaisyacd gwhknkaisyacd}</td><td>ＧＷ＿保険会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwhknsyuruicd gwhknsyuruicd}</td><td>ＧＷ＿保険種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwsyonosyuban gwsyonosyuban}</td><td>ＧＷ＿証券番号主番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwmisyuutatekaekbn gwmisyuutatekaekbn}</td><td>ＧＷ＿未収・立替区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwmisyuutatekaeym gwmisyuutatekaeym}</td><td>ＧＷ＿未収・立替発生年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwmisyuukg gwmisyuukg}</td><td>ＧＷ＿未収金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwbnkaisuu gwbnkaisuu}</td><td>ＧＷ＿分割回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwmisyuujiyuu gwmisyuujiyuu}</td><td>ＧＷ＿未収事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwjikaidatakousinymd gwjikaidatakousinymd}</td><td>ＧＷ＿次回データ更新日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIkkatubaraikbn ikkatubaraikbn}</td><td>一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>{@link #getIkkatubaraikaisuu ikkatubaraikaisuu}</td><td>一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhGinkouMdhnMisyuuInfo
 * @see     PKIT_KhGinkouMdhnMisyuuInfo
 * @see     QIT_KhGinkouMdhnMisyuuInfo
 * @see     GenQIT_KhGinkouMdhnMisyuuInfo
 */
@MappedSuperclass
@Table(name=GenIT_KhGinkouMdhnMisyuuInfo.TABLE_NAME)
@IdClass(value=PKIT_KhGinkouMdhnMisyuuInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_IkkatubaraiKaisuuKbn", typeClass=UserType_C_IkkatubaraiKaisuuKbn.class),
    @TypeDef(name="UserType_C_IkkatubaraiKbn", typeClass=UserType_C_IkkatubaraiKbn.class)
})
public abstract class GenIT_KhGinkouMdhnMisyuuInfo extends AbstractExDBEntity<IT_KhGinkouMdhnMisyuuInfo, PKIT_KhGinkouMdhnMisyuuInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhGinkouMdhnMisyuuInfo";
    public static final String KBNKEY                   = "kbnkey";
    public static final String DATARENYMD               = "datarenymd";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String GWBSYDRTENCD             = "gwbsydrtencd";
    public static final String GWDATAKBN                = "gwdatakbn";
    public static final String GWDATASAKUSEIYMD         = "gwdatasakuseiymd";
    public static final String GWHKNKAISYACD            = "gwhknkaisyacd";
    public static final String GWHKNSYURUICD            = "gwhknsyuruicd";
    public static final String GWSYONOSYUBAN            = "gwsyonosyuban";
    public static final String GWMISYUUTATEKAEKBN       = "gwmisyuutatekaekbn";
    public static final String GWMISYUUTATEKAEYM        = "gwmisyuutatekaeym";
    public static final String GWMISYUUKG               = "gwmisyuukg";
    public static final String GWBNKAISUU               = "gwbnkaisuu";
    public static final String GWMISYUUJIYUU            = "gwmisyuujiyuu";
    public static final String GWJIKAIDATAKOUSINYMD     = "gwjikaidatakousinymd";
    public static final String IKKATUBARAIKBN           = "ikkatubaraikbn";
    public static final String IKKATUBARAIKAISUU        = "ikkatubaraikaisuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhGinkouMdhnMisyuuInfo primaryKey;

    public GenIT_KhGinkouMdhnMisyuuInfo() {
        primaryKey = new PKIT_KhGinkouMdhnMisyuuInfo();
    }

    public GenIT_KhGinkouMdhnMisyuuInfo(
        String pKbnkey,
        BizDate pDatarenymd,
        String pSyono,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_KhGinkouMdhnMisyuuInfo(
            pKbnkey,
            pDatarenymd,
            pSyono,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_KhGinkouMdhnMisyuuInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhGinkouMdhnMisyuuInfo> getMetaClass() {
        return QIT_KhGinkouMdhnMisyuuInfo.class;
    }

    @Id
    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.DATARENYMD)
    public BizDate getDatarenymd() {
        return getPrimaryKey().getDatarenymd();
    }

    public void setDatarenymd(BizDate pDatarenymd) {
        getPrimaryKey().setDatarenymd(pDatarenymd);
    }

    @Id
    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private String gwbsydrtencd;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWBSYDRTENCD)
    public String getGwbsydrtencd() {
        return gwbsydrtencd;
    }

    public void setGwbsydrtencd(String pGwbsydrtencd) {
        gwbsydrtencd = pGwbsydrtencd;
    }

    private String gwdatakbn;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWDATAKBN)
    public String getGwdatakbn() {
        return gwdatakbn;
    }

    public void setGwdatakbn(String pGwdatakbn) {
        gwdatakbn = pGwdatakbn;
    }

    private String gwdatasakuseiymd;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWDATASAKUSEIYMD)
    public String getGwdatasakuseiymd() {
        return gwdatasakuseiymd;
    }

    public void setGwdatasakuseiymd(String pGwdatasakuseiymd) {
        gwdatasakuseiymd = pGwdatasakuseiymd;
    }

    private String gwhknkaisyacd;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWHKNKAISYACD)
    public String getGwhknkaisyacd() {
        return gwhknkaisyacd;
    }

    public void setGwhknkaisyacd(String pGwhknkaisyacd) {
        gwhknkaisyacd = pGwhknkaisyacd;
    }

    private String gwhknsyuruicd;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWHKNSYURUICD)
    public String getGwhknsyuruicd() {
        return gwhknsyuruicd;
    }

    public void setGwhknsyuruicd(String pGwhknsyuruicd) {
        gwhknsyuruicd = pGwhknsyuruicd;
    }

    private String gwsyonosyuban;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWSYONOSYUBAN)
    public String getGwsyonosyuban() {
        return gwsyonosyuban;
    }

    public void setGwsyonosyuban(String pGwsyonosyuban) {
        gwsyonosyuban = pGwsyonosyuban;
    }

    private String gwmisyuutatekaekbn;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWMISYUUTATEKAEKBN)
    public String getGwmisyuutatekaekbn() {
        return gwmisyuutatekaekbn;
    }

    public void setGwmisyuutatekaekbn(String pGwmisyuutatekaekbn) {
        gwmisyuutatekaekbn = pGwmisyuutatekaekbn;
    }

    private String gwmisyuutatekaeym;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWMISYUUTATEKAEYM)
    public String getGwmisyuutatekaeym() {
        return gwmisyuutatekaeym;
    }

    public void setGwmisyuutatekaeym(String pGwmisyuutatekaeym) {
        gwmisyuutatekaeym = pGwmisyuutatekaeym;
    }

    private String gwmisyuukg;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWMISYUUKG)
    public String getGwmisyuukg() {
        return gwmisyuukg;
    }

    public void setGwmisyuukg(String pGwmisyuukg) {
        gwmisyuukg = pGwmisyuukg;
    }

    private String gwbnkaisuu;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWBNKAISUU)
    public String getGwbnkaisuu() {
        return gwbnkaisuu;
    }

    public void setGwbnkaisuu(String pGwbnkaisuu) {
        gwbnkaisuu = pGwbnkaisuu;
    }

    private String gwmisyuujiyuu;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWMISYUUJIYUU)
    public String getGwmisyuujiyuu() {
        return gwmisyuujiyuu;
    }

    public void setGwmisyuujiyuu(String pGwmisyuujiyuu) {
        gwmisyuujiyuu = pGwmisyuujiyuu;
    }

    private String gwjikaidatakousinymd;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GWJIKAIDATAKOUSINYMD)
    public String getGwjikaidatakousinymd() {
        return gwjikaidatakousinymd;
    }

    public void setGwjikaidatakousinymd(String pGwjikaidatakousinymd) {
        gwjikaidatakousinymd = pGwjikaidatakousinymd;
    }

    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Type(type="UserType_C_IkkatubaraiKbn")
    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.IKKATUBARAIKBN)
    public C_IkkatubaraiKbn getIkkatubaraikbn() {
        return ikkatubaraikbn;
    }

    public void setIkkatubaraikbn(C_IkkatubaraiKbn pIkkatubaraikbn) {
        ikkatubaraikbn = pIkkatubaraikbn;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Type(type="UserType_C_IkkatubaraiKaisuuKbn")
    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.IKKATUBARAIKAISUU)
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhGinkouMdhnMisyuuInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}