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
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoiSyoriKbn;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;
import yuyu.def.db.entity.IT_BAK_AeoiInfo;
import yuyu.def.db.id.PKIT_BAK_AeoiInfo;
import yuyu.def.db.meta.GenQIT_BAK_AeoiInfo;
import yuyu.def.db.meta.QIT_BAK_AeoiInfo;
import yuyu.def.db.type.UserType_C_AeoiHoujinSyuruiKbn;
import yuyu.def.db.type.UserType_C_AeoiKekkaKbn;
import yuyu.def.db.type.UserType_C_AeoiSyoriKbn;
import yuyu.def.db.type.UserType_C_AeoiTaisyousyaKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＡＥＯＩ情報バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_AeoiInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_AeoiInfo}</td><td colspan="3">ＡＥＯＩ情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_AeoiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_AeoiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_AeoiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_BAK_AeoiInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAeoisyoriymd aeoisyoriymd}</td><td>ＡＥＯＩ処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAeoisyorikbn aeoisyorikbn}</td><td>ＡＥＯＩ処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AeoiSyoriKbn}</td></tr>
 *  <tr><td>{@link #getAeoikouryokusttymd aeoikouryokusttymd}</td><td>ＡＥＯＩ効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAeoisyorisosikicd aeoisyorisosikicd}</td><td>ＡＥＯＩ処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAeoitaisyousyakbn aeoitaisyousyakbn}</td><td>ＡＥＯＩ対象者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AeoiTaisyousyaKbn}</td></tr>
 *  <tr><td>{@link #getAeoikekkakbn aeoikekkakbn}</td><td>ＡＥＯＩ結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AeoiKekkaKbn}</td></tr>
 *  <tr><td>{@link #getAeoihoujinsyuruikbn aeoihoujinsyuruikbn}</td><td>ＡＥＯＩ法人種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AeoiHoujinSyuruiKbn}</td></tr>
 *  <tr><td>{@link #getAeoikouryokuendymd aeoikouryokuendymd}</td><td>ＡＥＯＩ効力終了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_AeoiInfo
 * @see     PKIT_BAK_AeoiInfo
 * @see     QIT_BAK_AeoiInfo
 * @see     GenQIT_BAK_AeoiInfo
 */
@MappedSuperclass
@Table(name=GenIT_BAK_AeoiInfo.TABLE_NAME)
@IdClass(value=PKIT_BAK_AeoiInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_AeoiHoujinSyuruiKbn", typeClass=UserType_C_AeoiHoujinSyuruiKbn.class),
    @TypeDef(name="UserType_C_AeoiKekkaKbn", typeClass=UserType_C_AeoiKekkaKbn.class),
    @TypeDef(name="UserType_C_AeoiSyoriKbn", typeClass=UserType_C_AeoiSyoriKbn.class),
    @TypeDef(name="UserType_C_AeoiTaisyousyaKbn", typeClass=UserType_C_AeoiTaisyousyaKbn.class)
})
public abstract class GenIT_BAK_AeoiInfo extends AbstractExDBEntity<IT_BAK_AeoiInfo, PKIT_BAK_AeoiInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_AeoiInfo";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String RENNO                    = "renno";
    public static final String AEOISYORIYMD             = "aeoisyoriymd";
    public static final String AEOISYORIKBN             = "aeoisyorikbn";
    public static final String AEOIKOURYOKUSTTYMD       = "aeoikouryokusttymd";
    public static final String AEOISYORISOSIKICD        = "aeoisyorisosikicd";
    public static final String AEOITAISYOUSYAKBN        = "aeoitaisyousyakbn";
    public static final String AEOIKEKKAKBN             = "aeoikekkakbn";
    public static final String AEOIHOUJINSYURUIKBN      = "aeoihoujinsyuruikbn";
    public static final String AEOIKOURYOKUENDYMD       = "aeoikouryokuendymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_AeoiInfo primaryKey;

    public GenIT_BAK_AeoiInfo() {
        primaryKey = new PKIT_BAK_AeoiInfo();
    }

    public GenIT_BAK_AeoiInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pRenno
    ) {
        primaryKey = new PKIT_BAK_AeoiInfo(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_AeoiInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_AeoiInfo> getMetaClass() {
        return QIT_BAK_AeoiInfo.class;
    }

    @Id
    @Column(name=GenIT_BAK_AeoiInfo.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_AeoiInfo.SYONO)
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
    @Column(name=GenIT_BAK_AeoiInfo.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_AeoiInfo.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate aeoisyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_AeoiInfo.AEOISYORIYMD)
    public BizDate getAeoisyoriymd() {
        return aeoisyoriymd;
    }

    public void setAeoisyoriymd(BizDate pAeoisyoriymd) {
        aeoisyoriymd = pAeoisyoriymd;
    }

    private C_AeoiSyoriKbn aeoisyorikbn;

    @Type(type="UserType_C_AeoiSyoriKbn")
    @Column(name=GenIT_BAK_AeoiInfo.AEOISYORIKBN)
    public C_AeoiSyoriKbn getAeoisyorikbn() {
        return aeoisyorikbn;
    }

    public void setAeoisyorikbn(C_AeoiSyoriKbn pAeoisyorikbn) {
        aeoisyorikbn = pAeoisyorikbn;
    }

    private BizDate aeoikouryokusttymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_AeoiInfo.AEOIKOURYOKUSTTYMD)
    public BizDate getAeoikouryokusttymd() {
        return aeoikouryokusttymd;
    }

    public void setAeoikouryokusttymd(BizDate pAeoikouryokusttymd) {
        aeoikouryokusttymd = pAeoikouryokusttymd;
    }

    private String aeoisyorisosikicd;

    @Column(name=GenIT_BAK_AeoiInfo.AEOISYORISOSIKICD)
    public String getAeoisyorisosikicd() {
        return aeoisyorisosikicd;
    }

    public void setAeoisyorisosikicd(String pAeoisyorisosikicd) {
        aeoisyorisosikicd = pAeoisyorisosikicd;
    }

    private C_AeoiTaisyousyaKbn aeoitaisyousyakbn;

    @Type(type="UserType_C_AeoiTaisyousyaKbn")
    @Column(name=GenIT_BAK_AeoiInfo.AEOITAISYOUSYAKBN)
    public C_AeoiTaisyousyaKbn getAeoitaisyousyakbn() {
        return aeoitaisyousyakbn;
    }

    public void setAeoitaisyousyakbn(C_AeoiTaisyousyaKbn pAeoitaisyousyakbn) {
        aeoitaisyousyakbn = pAeoitaisyousyakbn;
    }

    private C_AeoiKekkaKbn aeoikekkakbn;

    @Type(type="UserType_C_AeoiKekkaKbn")
    @Column(name=GenIT_BAK_AeoiInfo.AEOIKEKKAKBN)
    public C_AeoiKekkaKbn getAeoikekkakbn() {
        return aeoikekkakbn;
    }

    public void setAeoikekkakbn(C_AeoiKekkaKbn pAeoikekkakbn) {
        aeoikekkakbn = pAeoikekkakbn;
    }

    private C_AeoiHoujinSyuruiKbn aeoihoujinsyuruikbn;

    @Type(type="UserType_C_AeoiHoujinSyuruiKbn")
    @Column(name=GenIT_BAK_AeoiInfo.AEOIHOUJINSYURUIKBN)
    public C_AeoiHoujinSyuruiKbn getAeoihoujinsyuruikbn() {
        return aeoihoujinsyuruikbn;
    }

    public void setAeoihoujinsyuruikbn(C_AeoiHoujinSyuruiKbn pAeoihoujinsyuruikbn) {
        aeoihoujinsyuruikbn = pAeoihoujinsyuruikbn;
    }

    private BizDate aeoikouryokuendymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_AeoiInfo.AEOIKOURYOKUENDYMD)
    public BizDate getAeoikouryokuendymd() {
        return aeoikouryokuendymd;
    }

    public void setAeoikouryokuendymd(BizDate pAeoikouryokuendymd) {
        aeoikouryokuendymd = pAeoikouryokuendymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_AeoiInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_AeoiInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_AeoiInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}