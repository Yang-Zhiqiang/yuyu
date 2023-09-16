package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.id.PKJT_Toriatukaifuryouinfo;
import yuyu.def.db.meta.GenQJT_Toriatukaifuryouinfo;
import yuyu.def.db.meta.QJT_Toriatukaifuryouinfo;
import yuyu.def.db.type.UserType_C_NoinitSyorizumiKbn;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_NoinitYouhiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 取扱不良情報テーブル テーブルのマッピング情報クラスで、 {@link JT_Toriatukaifuryouinfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Toriatukaifuryouinfo}</td><td colspan="3">取扱不良情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_Toriatukaifuryouinfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_Toriatukaifuryouinfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_Toriatukaifuryouinfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTratkihuryouumukbn tratkihuryouumukbn}</td><td>取扱不良有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getGyousinkaisouyouhikbn gyousinkaisouyouhikbn}</td><td>業審回送要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitYouhiKbn}</td></tr>
 *  <tr><td>{@link #getAireqdaityoukisaikbn aireqdaityoukisaikbn}</td><td>あいリク台帳記載区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitSyorizumiKbn}</td></tr>
 *  <tr><td>{@link #getTratkihuryoucomment tratkihuryoucomment}</td><td>取扱不良コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Toriatukaifuryouinfo
 * @see     PKJT_Toriatukaifuryouinfo
 * @see     QJT_Toriatukaifuryouinfo
 * @see     GenQJT_Toriatukaifuryouinfo
 */
@MappedSuperclass
@Table(name=GenJT_Toriatukaifuryouinfo.TABLE_NAME)
@IdClass(value=PKJT_Toriatukaifuryouinfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NoinitSyorizumiKbn", typeClass=UserType_C_NoinitSyorizumiKbn.class),
    @TypeDef(name="UserType_C_NoinitUmuKbn", typeClass=UserType_C_NoinitUmuKbn.class),
    @TypeDef(name="UserType_C_NoinitYouhiKbn", typeClass=UserType_C_NoinitYouhiKbn.class)
})
public abstract class GenJT_Toriatukaifuryouinfo extends AbstractExDBEntity<JT_Toriatukaifuryouinfo, PKJT_Toriatukaifuryouinfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_Toriatukaifuryouinfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String TRATKIHURYOUUMUKBN       = "tratkihuryouumukbn";
    public static final String GYOUSINKAISOUYOUHIKBN    = "gyousinkaisouyouhikbn";
    public static final String AIREQDAITYOUKISAIKBN     = "aireqdaityoukisaikbn";
    public static final String TRATKIHURYOUCOMMENT      = "tratkihuryoucomment";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_Toriatukaifuryouinfo primaryKey;

    public GenJT_Toriatukaifuryouinfo() {
        primaryKey = new PKJT_Toriatukaifuryouinfo();
    }

    public GenJT_Toriatukaifuryouinfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_Toriatukaifuryouinfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_Toriatukaifuryouinfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_Toriatukaifuryouinfo> getMetaClass() {
        return QJT_Toriatukaifuryouinfo.class;
    }

    @Id
    @Column(name=GenJT_Toriatukaifuryouinfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_Toriatukaifuryouinfo.SYONO)
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
    @Column(name=GenJT_Toriatukaifuryouinfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_NoinitUmuKbn tratkihuryouumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_Toriatukaifuryouinfo.TRATKIHURYOUUMUKBN)
    public C_NoinitUmuKbn getTratkihuryouumukbn() {
        return tratkihuryouumukbn;
    }

    public void setTratkihuryouumukbn(C_NoinitUmuKbn pTratkihuryouumukbn) {
        tratkihuryouumukbn = pTratkihuryouumukbn;
    }

    private C_NoinitYouhiKbn gyousinkaisouyouhikbn;

    @Type(type="UserType_C_NoinitYouhiKbn")
    @Column(name=GenJT_Toriatukaifuryouinfo.GYOUSINKAISOUYOUHIKBN)
    public C_NoinitYouhiKbn getGyousinkaisouyouhikbn() {
        return gyousinkaisouyouhikbn;
    }

    public void setGyousinkaisouyouhikbn(C_NoinitYouhiKbn pGyousinkaisouyouhikbn) {
        gyousinkaisouyouhikbn = pGyousinkaisouyouhikbn;
    }

    private C_NoinitSyorizumiKbn aireqdaityoukisaikbn;

    @Type(type="UserType_C_NoinitSyorizumiKbn")
    @Column(name=GenJT_Toriatukaifuryouinfo.AIREQDAITYOUKISAIKBN)
    public C_NoinitSyorizumiKbn getAireqdaityoukisaikbn() {
        return aireqdaityoukisaikbn;
    }

    public void setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn pAireqdaityoukisaikbn) {
        aireqdaityoukisaikbn = pAireqdaityoukisaikbn;
    }

    private String tratkihuryoucomment;

    @Column(name=GenJT_Toriatukaifuryouinfo.TRATKIHURYOUCOMMENT)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getTratkihuryoucomment() {
        return tratkihuryoucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTratkihuryoucomment(String pTratkihuryoucomment) {
        tratkihuryoucomment = pTratkihuryoucomment;
    }

    private String kossyoricd;

    @Column(name=GenJT_Toriatukaifuryouinfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_Toriatukaifuryouinfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_Toriatukaifuryouinfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_Toriatukaifuryouinfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}