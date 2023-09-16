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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IT_BAK_KhTtdkTyuui;
import yuyu.def.db.id.PKIT_BAK_KhTtdkTyuui;
import yuyu.def.db.meta.GenQIT_BAK_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_BAK_KhTtdkTyuui;
import yuyu.def.db.type.UserType_C_KktyuitaKbn;
import yuyu.def.db.type.UserType_C_KykdrDouiYouhiKbn;
import yuyu.def.db.type.UserType_C_KykdrknHtdjytKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全手続注意バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KhTtdkTyuui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhTtdkTyuui}</td><td colspan="3">契約保全手続注意バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KhTtdkTyuui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KhTtdkTyuui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KhTtdkTyuui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuisetymd ttdktyuuisetymd}</td><td>手続注意設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuisetnm ttdktyuuisetnm}</td><td>手続注意設定者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKktyuitakbn kktyuitakbn}</td><td>契約管理注意取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KktyuitaKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuinaiyou1 ttdktyuuinaiyou1}</td><td>手続注意内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuinaiyou2 ttdktyuuinaiyou2}</td><td>手続注意内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuinaiyou3 ttdktyuuinaiyou3}</td><td>手続注意内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn1 ttdktyuuikbn1}</td><td>手続注意区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn2 ttdktyuuikbn2}</td><td>手続注意区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn3 ttdktyuuikbn3}</td><td>手続注意区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn4 ttdktyuuikbn4}</td><td>手続注意区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn5 ttdktyuuikbn5}</td><td>手続注意区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou1 ttdktyuuikbnhsknaiyou1}</td><td>手続注意区分補足内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou2 ttdktyuuikbnhsknaiyou2}</td><td>手続注意区分補足内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou3 ttdktyuuikbnhsknaiyou3}</td><td>手続注意区分補足内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou4 ttdktyuuikbnhsknaiyou4}</td><td>手続注意区分補足内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou5 ttdktyuuikbnhsknaiyou5}</td><td>手続注意区分補足内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd1 ttdktyuuikbnsetymd1}</td><td>手続注意区分設定日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd2 ttdktyuuikbnsetymd2}</td><td>手続注意区分設定日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd3 ttdktyuuikbnsetymd3}</td><td>手続注意区分設定日３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd4 ttdktyuuikbnsetymd4}</td><td>手続注意区分設定日４</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd5 ttdktyuuikbnsetymd5}</td><td>手続注意区分設定日５</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSetsosikicd1 setsosikicd1}</td><td>設定組織コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetsosikicd2 setsosikicd2}</td><td>設定組織コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetsosikicd3 setsosikicd3}</td><td>設定組織コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetsosikicd4 setsosikicd4}</td><td>設定組織コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetsosikicd5 setsosikicd5}</td><td>設定組織コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrknhatudoujyoutai kykdrknhatudoujyoutai}</td><td>契約者代理権発動状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykdrknHtdjytKbn}</td></tr>
 *  <tr><td>{@link #getKykdrdouiyouhi kykdrdouiyouhi}</td><td>契約者代理人同意要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykdrDouiYouhiKbn}</td></tr>
 * </table>
 * @see     IT_BAK_KhTtdkTyuui
 * @see     PKIT_BAK_KhTtdkTyuui
 * @see     QIT_BAK_KhTtdkTyuui
 * @see     GenQIT_BAK_KhTtdkTyuui
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KhTtdkTyuui.TABLE_NAME)
@IdClass(value=PKIT_BAK_KhTtdkTyuui.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KktyuitaKbn", typeClass=UserType_C_KktyuitaKbn.class),
    @TypeDef(name="UserType_C_KykdrDouiYouhiKbn", typeClass=UserType_C_KykdrDouiYouhiKbn.class),
    @TypeDef(name="UserType_C_KykdrknHtdjytKbn", typeClass=UserType_C_KykdrknHtdjytKbn.class),
    @TypeDef(name="UserType_C_TtdktyuuiKbn", typeClass=UserType_C_TtdktyuuiKbn.class)
})
public abstract class GenIT_BAK_KhTtdkTyuui extends AbstractExDBEntity<IT_BAK_KhTtdkTyuui, PKIT_BAK_KhTtdkTyuui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KhTtdkTyuui";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String TTDKTYUUISETYMD          = "ttdktyuuisetymd";
    public static final String TTDKTYUUISETNM           = "ttdktyuuisetnm";
    public static final String KKTYUITAKBN              = "kktyuitakbn";
    public static final String TTDKTYUUINAIYOU1         = "ttdktyuuinaiyou1";
    public static final String TTDKTYUUINAIYOU2         = "ttdktyuuinaiyou2";
    public static final String TTDKTYUUINAIYOU3         = "ttdktyuuinaiyou3";
    public static final String TTDKTYUUIKBN1            = "ttdktyuuikbn1";
    public static final String TTDKTYUUIKBN2            = "ttdktyuuikbn2";
    public static final String TTDKTYUUIKBN3            = "ttdktyuuikbn3";
    public static final String TTDKTYUUIKBN4            = "ttdktyuuikbn4";
    public static final String TTDKTYUUIKBN5            = "ttdktyuuikbn5";
    public static final String TTDKTYUUIKBNHSKNAIYOU1   = "ttdktyuuikbnhsknaiyou1";
    public static final String TTDKTYUUIKBNHSKNAIYOU2   = "ttdktyuuikbnhsknaiyou2";
    public static final String TTDKTYUUIKBNHSKNAIYOU3   = "ttdktyuuikbnhsknaiyou3";
    public static final String TTDKTYUUIKBNHSKNAIYOU4   = "ttdktyuuikbnhsknaiyou4";
    public static final String TTDKTYUUIKBNHSKNAIYOU5   = "ttdktyuuikbnhsknaiyou5";
    public static final String TTDKTYUUIKBNSETYMD1      = "ttdktyuuikbnsetymd1";
    public static final String TTDKTYUUIKBNSETYMD2      = "ttdktyuuikbnsetymd2";
    public static final String TTDKTYUUIKBNSETYMD3      = "ttdktyuuikbnsetymd3";
    public static final String TTDKTYUUIKBNSETYMD4      = "ttdktyuuikbnsetymd4";
    public static final String TTDKTYUUIKBNSETYMD5      = "ttdktyuuikbnsetymd5";
    public static final String SETSOSIKICD1             = "setsosikicd1";
    public static final String SETSOSIKICD2             = "setsosikicd2";
    public static final String SETSOSIKICD3             = "setsosikicd3";
    public static final String SETSOSIKICD4             = "setsosikicd4";
    public static final String SETSOSIKICD5             = "setsosikicd5";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String KYKDRKNHATUDOUJYOUTAI    = "kykdrknhatudoujyoutai";
    public static final String KYKDRDOUIYOUHI           = "kykdrdouiyouhi";

    private final PKIT_BAK_KhTtdkTyuui primaryKey;

    public GenIT_BAK_KhTtdkTyuui() {
        primaryKey = new PKIT_BAK_KhTtdkTyuui();
    }

    public GenIT_BAK_KhTtdkTyuui(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        primaryKey = new PKIT_BAK_KhTtdkTyuui(
            pKbnkey,
            pSyono,
            pTrkssikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KhTtdkTyuui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KhTtdkTyuui> getMetaClass() {
        return QIT_BAK_KhTtdkTyuui.class;
    }

    @Id
    @Column(name=GenIT_BAK_KhTtdkTyuui.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KhTtdkTyuui.SYONO)
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
    @Column(name=GenIT_BAK_KhTtdkTyuui.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private BizDate ttdktyuuisetymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUISETYMD)
    public BizDate getTtdktyuuisetymd() {
        return ttdktyuuisetymd;
    }

    public void setTtdktyuuisetymd(BizDate pTtdktyuuisetymd) {
        ttdktyuuisetymd = pTtdktyuuisetymd;
    }

    private String ttdktyuuisetnm;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUISETNM)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getTtdktyuuisetnm() {
        return ttdktyuuisetnm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuisetnm(String pTtdktyuuisetnm) {
        ttdktyuuisetnm = pTtdktyuuisetnm;
    }

    private C_KktyuitaKbn kktyuitakbn;

    @Type(type="UserType_C_KktyuitaKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.KKTYUITAKBN)
    public C_KktyuitaKbn getKktyuitakbn() {
        return kktyuitakbn;
    }

    public void setKktyuitakbn(C_KktyuitaKbn pKktyuitakbn) {
        kktyuitakbn = pKktyuitakbn;
    }

    private String ttdktyuuinaiyou1;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUINAIYOU1)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getTtdktyuuinaiyou1() {
        return ttdktyuuinaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou1(String pTtdktyuuinaiyou1) {
        ttdktyuuinaiyou1 = pTtdktyuuinaiyou1;
    }

    private String ttdktyuuinaiyou2;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUINAIYOU2)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getTtdktyuuinaiyou2() {
        return ttdktyuuinaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou2(String pTtdktyuuinaiyou2) {
        ttdktyuuinaiyou2 = pTtdktyuuinaiyou2;
    }

    private String ttdktyuuinaiyou3;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUINAIYOU3)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getTtdktyuuinaiyou3() {
        return ttdktyuuinaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou3(String pTtdktyuuinaiyou3) {
        ttdktyuuinaiyou3 = pTtdktyuuinaiyou3;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn1;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBN1)
    public C_TtdktyuuiKbn getTtdktyuuikbn1() {
        return ttdktyuuikbn1;
    }

    public void setTtdktyuuikbn1(C_TtdktyuuiKbn pTtdktyuuikbn1) {
        ttdktyuuikbn1 = pTtdktyuuikbn1;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn2;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBN2)
    public C_TtdktyuuiKbn getTtdktyuuikbn2() {
        return ttdktyuuikbn2;
    }

    public void setTtdktyuuikbn2(C_TtdktyuuiKbn pTtdktyuuikbn2) {
        ttdktyuuikbn2 = pTtdktyuuikbn2;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn3;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBN3)
    public C_TtdktyuuiKbn getTtdktyuuikbn3() {
        return ttdktyuuikbn3;
    }

    public void setTtdktyuuikbn3(C_TtdktyuuiKbn pTtdktyuuikbn3) {
        ttdktyuuikbn3 = pTtdktyuuikbn3;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn4;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBN4)
    public C_TtdktyuuiKbn getTtdktyuuikbn4() {
        return ttdktyuuikbn4;
    }

    public void setTtdktyuuikbn4(C_TtdktyuuiKbn pTtdktyuuikbn4) {
        ttdktyuuikbn4 = pTtdktyuuikbn4;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn5;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBN5)
    public C_TtdktyuuiKbn getTtdktyuuikbn5() {
        return ttdktyuuikbn5;
    }

    public void setTtdktyuuikbn5(C_TtdktyuuiKbn pTtdktyuuikbn5) {
        ttdktyuuikbn5 = pTtdktyuuikbn5;
    }

    private String ttdktyuuikbnhsknaiyou1;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNHSKNAIYOU1)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou1() {
        return ttdktyuuikbnhsknaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou1(String pTtdktyuuikbnhsknaiyou1) {
        ttdktyuuikbnhsknaiyou1 = pTtdktyuuikbnhsknaiyou1;
    }

    private String ttdktyuuikbnhsknaiyou2;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNHSKNAIYOU2)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou2() {
        return ttdktyuuikbnhsknaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou2(String pTtdktyuuikbnhsknaiyou2) {
        ttdktyuuikbnhsknaiyou2 = pTtdktyuuikbnhsknaiyou2;
    }

    private String ttdktyuuikbnhsknaiyou3;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNHSKNAIYOU3)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou3() {
        return ttdktyuuikbnhsknaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou3(String pTtdktyuuikbnhsknaiyou3) {
        ttdktyuuikbnhsknaiyou3 = pTtdktyuuikbnhsknaiyou3;
    }

    private String ttdktyuuikbnhsknaiyou4;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNHSKNAIYOU4)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou4() {
        return ttdktyuuikbnhsknaiyou4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou4(String pTtdktyuuikbnhsknaiyou4) {
        ttdktyuuikbnhsknaiyou4 = pTtdktyuuikbnhsknaiyou4;
    }

    private String ttdktyuuikbnhsknaiyou5;

    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNHSKNAIYOU5)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou5() {
        return ttdktyuuikbnhsknaiyou5;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou5(String pTtdktyuuikbnhsknaiyou5) {
        ttdktyuuikbnhsknaiyou5 = pTtdktyuuikbnhsknaiyou5;
    }

    private BizDate ttdktyuuikbnsetymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNSETYMD1)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd1() {
        return ttdktyuuikbnsetymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd1(BizDate pTtdktyuuikbnsetymd1) {
        ttdktyuuikbnsetymd1 = pTtdktyuuikbnsetymd1;
    }

    private BizDate ttdktyuuikbnsetymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNSETYMD2)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd2() {
        return ttdktyuuikbnsetymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd2(BizDate pTtdktyuuikbnsetymd2) {
        ttdktyuuikbnsetymd2 = pTtdktyuuikbnsetymd2;
    }

    private BizDate ttdktyuuikbnsetymd3;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNSETYMD3)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd3() {
        return ttdktyuuikbnsetymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd3(BizDate pTtdktyuuikbnsetymd3) {
        ttdktyuuikbnsetymd3 = pTtdktyuuikbnsetymd3;
    }

    private BizDate ttdktyuuikbnsetymd4;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNSETYMD4)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd4() {
        return ttdktyuuikbnsetymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd4(BizDate pTtdktyuuikbnsetymd4) {
        ttdktyuuikbnsetymd4 = pTtdktyuuikbnsetymd4;
    }

    private BizDate ttdktyuuikbnsetymd5;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTtdkTyuui.TTDKTYUUIKBNSETYMD5)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd5() {
        return ttdktyuuikbnsetymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd5(BizDate pTtdktyuuikbnsetymd5) {
        ttdktyuuikbnsetymd5 = pTtdktyuuikbnsetymd5;
    }

    private String setsosikicd1;

    @Column(name=GenIT_BAK_KhTtdkTyuui.SETSOSIKICD1)
    public String getSetsosikicd1() {
        return setsosikicd1;
    }

    public void setSetsosikicd1(String pSetsosikicd1) {
        setsosikicd1 = pSetsosikicd1;
    }

    private String setsosikicd2;

    @Column(name=GenIT_BAK_KhTtdkTyuui.SETSOSIKICD2)
    public String getSetsosikicd2() {
        return setsosikicd2;
    }

    public void setSetsosikicd2(String pSetsosikicd2) {
        setsosikicd2 = pSetsosikicd2;
    }

    private String setsosikicd3;

    @Column(name=GenIT_BAK_KhTtdkTyuui.SETSOSIKICD3)
    public String getSetsosikicd3() {
        return setsosikicd3;
    }

    public void setSetsosikicd3(String pSetsosikicd3) {
        setsosikicd3 = pSetsosikicd3;
    }

    private String setsosikicd4;

    @Column(name=GenIT_BAK_KhTtdkTyuui.SETSOSIKICD4)
    public String getSetsosikicd4() {
        return setsosikicd4;
    }

    public void setSetsosikicd4(String pSetsosikicd4) {
        setsosikicd4 = pSetsosikicd4;
    }

    private String setsosikicd5;

    @Column(name=GenIT_BAK_KhTtdkTyuui.SETSOSIKICD5)
    public String getSetsosikicd5() {
        return setsosikicd5;
    }

    public void setSetsosikicd5(String pSetsosikicd5) {
        setsosikicd5 = pSetsosikicd5;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KhTtdkTyuui.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KhTtdkTyuui.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KhTtdkTyuui.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_KykdrknHtdjytKbn kykdrknhatudoujyoutai;

    @Type(type="UserType_C_KykdrknHtdjytKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.KYKDRKNHATUDOUJYOUTAI)
    public C_KykdrknHtdjytKbn getKykdrknhatudoujyoutai() {
        return kykdrknhatudoujyoutai;
    }

    public void setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai) {
        kykdrknhatudoujyoutai = pKykdrknhatudoujyoutai;
    }

    private C_KykdrDouiYouhiKbn kykdrdouiyouhi;

    @Type(type="UserType_C_KykdrDouiYouhiKbn")
    @Column(name=GenIT_BAK_KhTtdkTyuui.KYKDRDOUIYOUHI)
    public C_KykdrDouiYouhiKbn getKykdrdouiyouhi() {
        return kykdrdouiyouhi;
    }

    public void setKykdrdouiyouhi(C_KykdrDouiYouhiKbn pKykdrdouiyouhi) {
        kykdrdouiyouhi = pKykdrdouiyouhi;
    }
}