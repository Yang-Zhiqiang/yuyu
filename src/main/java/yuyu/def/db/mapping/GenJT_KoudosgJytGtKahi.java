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
import yuyu.def.classification.C_KdsgJyoutaiGaitouKbn;
import yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn;
import yuyu.def.db.entity.JT_KoudosgJytGtKahi;
import yuyu.def.db.id.PKJT_KoudosgJytGtKahi;
import yuyu.def.db.meta.GenQJT_KoudosgJytGtKahi;
import yuyu.def.db.meta.QJT_KoudosgJytGtKahi;
import yuyu.def.db.type.UserType_C_KdsgJyoutaiGaitouKbn;
import yuyu.def.db.type.UserType_C_SysnJyoujiKaigoGaitouKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 高度障害状態該当可否テーブル テーブルのマッピング情報クラスで、 {@link JT_KoudosgJytGtKahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_KoudosgJytGtKahi}</td><td colspan="3">高度障害状態該当可否テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_KoudosgJytGtKahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_KoudosgJytGtKahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_KoudosgJytGtKahi ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRyougansitumeikbn ryougansitumeikbn}</td><td>両眼失明区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>{@link #getRyougansitumeicomment ryougansitumeicomment}</td><td>両眼失明コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGengososyakusousitukbn gengososyakusousitukbn}</td><td>言語・咀嚼機能喪失区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>{@link #getGengososyakusousitucomment gengososyakusousitucomment}</td><td>言語・咀嚼機能喪失コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyoujyousiyoubousitukbn ryoujyousiyoubousitukbn}</td><td>両上肢用（亡）失区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>{@link #getRyoujyousiyoubousitucomt ryoujyousiyoubousitucomt}</td><td>両上肢用（亡）失コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyoukasiyoubousitukbn ryoukasiyoubousitukbn}</td><td>両下肢用（亡）失区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>{@link #getRyoukasiyoubousitucomt ryoukasiyoubousitucomt}</td><td>両下肢用（亡）失コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIjyobosituikasiyositukbn ijyobosituikasiyositukbn}</td><td>１上肢亡失・１下肢用（亡）失区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>{@link #getIjyobosituikasiyositucomt ijyobosituikasiyositucomt}</td><td>１上肢亡失・１下肢用（亡）失コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIjyoyosituikasibositukbn ijyoyosituikasibositukbn}</td><td>１上肢用失・１下肢亡失区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>{@link #getIjyoyosituikasibositucomt ijyoyosituikasibositucomt}</td><td>１上肢用失・１下肢亡失コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSysnjoujikaigokbn sysnjoujikaigokbn}</td><td>終身常時介護区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>{@link #getSysnjoujikaigocomment sysnjoujikaigocomment}</td><td>終身常時介護コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokoukbn hokoukbn}</td><td>歩行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>{@link #getHokoucomment hokoucomment}</td><td>歩行コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIhukutyakudatukbn ihukutyakudatukbn}</td><td>衣服着脱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>{@link #getIhukutyakudatucomment ihukutyakudatucomment}</td><td>衣服着脱コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuuyokukbn nyuuyokukbn}</td><td>入浴区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>{@link #getNyuuyokucomment nyuuyokucomment}</td><td>入浴コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyokumotusessyukbn syokumotusessyukbn}</td><td>食物摂取区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>{@link #getSyokumotusessyucomment syokumotusessyucomment}</td><td>食物摂取コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHukitorisimatukbn hukitorisimatukbn}</td><td>拭き取り始末区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>{@link #getHukitorisimatucomment hukitorisimatucomment}</td><td>拭き取り始末コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaibenhainyoukbn haibenhainyoukbn}</td><td>排便・排尿区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>{@link #getHaibenhainyoucomment haibenhainyoucomment}</td><td>排便・排尿コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKikyokbn kikyokbn}</td><td>起居区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>{@link #getKikyocomment kikyocomment}</td><td>起居コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_KoudosgJytGtKahi
 * @see     PKJT_KoudosgJytGtKahi
 * @see     QJT_KoudosgJytGtKahi
 * @see     GenQJT_KoudosgJytGtKahi
 */
@MappedSuperclass
@Table(name=GenJT_KoudosgJytGtKahi.TABLE_NAME)
@IdClass(value=PKJT_KoudosgJytGtKahi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KdsgJyoutaiGaitouKbn", typeClass=UserType_C_KdsgJyoutaiGaitouKbn.class),
    @TypeDef(name="UserType_C_SysnJyoujiKaigoGaitouKbn", typeClass=UserType_C_SysnJyoujiKaigoGaitouKbn.class)
})
public abstract class GenJT_KoudosgJytGtKahi extends AbstractExDBEntity<JT_KoudosgJytGtKahi, PKJT_KoudosgJytGtKahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_KoudosgJytGtKahi";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String RYOUGANSITUMEIKBN        = "ryougansitumeikbn";
    public static final String RYOUGANSITUMEICOMMENT    = "ryougansitumeicomment";
    public static final String GENGOSOSYAKUSOUSITUKBN   = "gengososyakusousitukbn";
    public static final String GENGOSOSYAKUSOUSITUCOMMENT = "gengososyakusousitucomment";
    public static final String RYOUJYOUSIYOUBOUSITUKBN  = "ryoujyousiyoubousitukbn";
    public static final String RYOUJYOUSIYOUBOUSITUCOMT = "ryoujyousiyoubousitucomt";
    public static final String RYOUKASIYOUBOUSITUKBN    = "ryoukasiyoubousitukbn";
    public static final String RYOUKASIYOUBOUSITUCOMT   = "ryoukasiyoubousitucomt";
    public static final String IJYOBOSITUIKASIYOSITUKBN = "ijyobosituikasiyositukbn";
    public static final String IJYOBOSITUIKASIYOSITUCOMT = "ijyobosituikasiyositucomt";
    public static final String IJYOYOSITUIKASIBOSITUKBN = "ijyoyosituikasibositukbn";
    public static final String IJYOYOSITUIKASIBOSITUCOMT = "ijyoyosituikasibositucomt";
    public static final String SYSNJOUJIKAIGOKBN        = "sysnjoujikaigokbn";
    public static final String SYSNJOUJIKAIGOCOMMENT    = "sysnjoujikaigocomment";
    public static final String HOKOUKBN                 = "hokoukbn";
    public static final String HOKOUCOMMENT             = "hokoucomment";
    public static final String IHUKUTYAKUDATUKBN        = "ihukutyakudatukbn";
    public static final String IHUKUTYAKUDATUCOMMENT    = "ihukutyakudatucomment";
    public static final String NYUUYOKUKBN              = "nyuuyokukbn";
    public static final String NYUUYOKUCOMMENT          = "nyuuyokucomment";
    public static final String SYOKUMOTUSESSYUKBN       = "syokumotusessyukbn";
    public static final String SYOKUMOTUSESSYUCOMMENT   = "syokumotusessyucomment";
    public static final String HUKITORISIMATUKBN        = "hukitorisimatukbn";
    public static final String HUKITORISIMATUCOMMENT    = "hukitorisimatucomment";
    public static final String HAIBENHAINYOUKBN         = "haibenhainyoukbn";
    public static final String HAIBENHAINYOUCOMMENT     = "haibenhainyoucomment";
    public static final String KIKYOKBN                 = "kikyokbn";
    public static final String KIKYOCOMMENT             = "kikyocomment";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_KoudosgJytGtKahi primaryKey;

    public GenJT_KoudosgJytGtKahi() {
        primaryKey = new PKJT_KoudosgJytGtKahi();
    }

    public GenJT_KoudosgJytGtKahi(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_KoudosgJytGtKahi(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_KoudosgJytGtKahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_KoudosgJytGtKahi> getMetaClass() {
        return QJT_KoudosgJytGtKahi.class;
    }

    @Id
    @Column(name=GenJT_KoudosgJytGtKahi.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_KoudosgJytGtKahi.SYONO)
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
    @Column(name=GenJT_KoudosgJytGtKahi.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_KdsgJyoutaiGaitouKbn ryougansitumeikbn;

    @Type(type="UserType_C_KdsgJyoutaiGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.RYOUGANSITUMEIKBN)
    public C_KdsgJyoutaiGaitouKbn getRyougansitumeikbn() {
        return ryougansitumeikbn;
    }

    public void setRyougansitumeikbn(C_KdsgJyoutaiGaitouKbn pRyougansitumeikbn) {
        ryougansitumeikbn = pRyougansitumeikbn;
    }

    private String ryougansitumeicomment;

    @Column(name=GenJT_KoudosgJytGtKahi.RYOUGANSITUMEICOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getRyougansitumeicomment() {
        return ryougansitumeicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setRyougansitumeicomment(String pRyougansitumeicomment) {
        ryougansitumeicomment = pRyougansitumeicomment;
    }

    private C_KdsgJyoutaiGaitouKbn gengososyakusousitukbn;

    @Type(type="UserType_C_KdsgJyoutaiGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.GENGOSOSYAKUSOUSITUKBN)
    public C_KdsgJyoutaiGaitouKbn getGengososyakusousitukbn() {
        return gengososyakusousitukbn;
    }

    public void setGengososyakusousitukbn(C_KdsgJyoutaiGaitouKbn pGengososyakusousitukbn) {
        gengososyakusousitukbn = pGengososyakusousitukbn;
    }

    private String gengososyakusousitucomment;

    @Column(name=GenJT_KoudosgJytGtKahi.GENGOSOSYAKUSOUSITUCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getGengososyakusousitucomment() {
        return gengososyakusousitucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setGengososyakusousitucomment(String pGengososyakusousitucomment) {
        gengososyakusousitucomment = pGengososyakusousitucomment;
    }

    private C_KdsgJyoutaiGaitouKbn ryoujyousiyoubousitukbn;

    @Type(type="UserType_C_KdsgJyoutaiGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.RYOUJYOUSIYOUBOUSITUKBN)
    public C_KdsgJyoutaiGaitouKbn getRyoujyousiyoubousitukbn() {
        return ryoujyousiyoubousitukbn;
    }

    public void setRyoujyousiyoubousitukbn(C_KdsgJyoutaiGaitouKbn pRyoujyousiyoubousitukbn) {
        ryoujyousiyoubousitukbn = pRyoujyousiyoubousitukbn;
    }

    private String ryoujyousiyoubousitucomt;

    @Column(name=GenJT_KoudosgJytGtKahi.RYOUJYOUSIYOUBOUSITUCOMT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getRyoujyousiyoubousitucomt() {
        return ryoujyousiyoubousitucomt;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setRyoujyousiyoubousitucomt(String pRyoujyousiyoubousitucomt) {
        ryoujyousiyoubousitucomt = pRyoujyousiyoubousitucomt;
    }

    private C_KdsgJyoutaiGaitouKbn ryoukasiyoubousitukbn;

    @Type(type="UserType_C_KdsgJyoutaiGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.RYOUKASIYOUBOUSITUKBN)
    public C_KdsgJyoutaiGaitouKbn getRyoukasiyoubousitukbn() {
        return ryoukasiyoubousitukbn;
    }

    public void setRyoukasiyoubousitukbn(C_KdsgJyoutaiGaitouKbn pRyoukasiyoubousitukbn) {
        ryoukasiyoubousitukbn = pRyoukasiyoubousitukbn;
    }

    private String ryoukasiyoubousitucomt;

    @Column(name=GenJT_KoudosgJytGtKahi.RYOUKASIYOUBOUSITUCOMT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getRyoukasiyoubousitucomt() {
        return ryoukasiyoubousitucomt;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setRyoukasiyoubousitucomt(String pRyoukasiyoubousitucomt) {
        ryoukasiyoubousitucomt = pRyoukasiyoubousitucomt;
    }

    private C_KdsgJyoutaiGaitouKbn ijyobosituikasiyositukbn;

    @Type(type="UserType_C_KdsgJyoutaiGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.IJYOBOSITUIKASIYOSITUKBN)
    public C_KdsgJyoutaiGaitouKbn getIjyobosituikasiyositukbn() {
        return ijyobosituikasiyositukbn;
    }

    public void setIjyobosituikasiyositukbn(C_KdsgJyoutaiGaitouKbn pIjyobosituikasiyositukbn) {
        ijyobosituikasiyositukbn = pIjyobosituikasiyositukbn;
    }

    private String ijyobosituikasiyositucomt;

    @Column(name=GenJT_KoudosgJytGtKahi.IJYOBOSITUIKASIYOSITUCOMT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getIjyobosituikasiyositucomt() {
        return ijyobosituikasiyositucomt;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIjyobosituikasiyositucomt(String pIjyobosituikasiyositucomt) {
        ijyobosituikasiyositucomt = pIjyobosituikasiyositucomt;
    }

    private C_KdsgJyoutaiGaitouKbn ijyoyosituikasibositukbn;

    @Type(type="UserType_C_KdsgJyoutaiGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.IJYOYOSITUIKASIBOSITUKBN)
    public C_KdsgJyoutaiGaitouKbn getIjyoyosituikasibositukbn() {
        return ijyoyosituikasibositukbn;
    }

    public void setIjyoyosituikasibositukbn(C_KdsgJyoutaiGaitouKbn pIjyoyosituikasibositukbn) {
        ijyoyosituikasibositukbn = pIjyoyosituikasibositukbn;
    }

    private String ijyoyosituikasibositucomt;

    @Column(name=GenJT_KoudosgJytGtKahi.IJYOYOSITUIKASIBOSITUCOMT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getIjyoyosituikasibositucomt() {
        return ijyoyosituikasibositucomt;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIjyoyosituikasibositucomt(String pIjyoyosituikasibositucomt) {
        ijyoyosituikasibositucomt = pIjyoyosituikasibositucomt;
    }

    private C_KdsgJyoutaiGaitouKbn sysnjoujikaigokbn;

    @Type(type="UserType_C_KdsgJyoutaiGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.SYSNJOUJIKAIGOKBN)
    public C_KdsgJyoutaiGaitouKbn getSysnjoujikaigokbn() {
        return sysnjoujikaigokbn;
    }

    public void setSysnjoujikaigokbn(C_KdsgJyoutaiGaitouKbn pSysnjoujikaigokbn) {
        sysnjoujikaigokbn = pSysnjoujikaigokbn;
    }

    private String sysnjoujikaigocomment;

    @Column(name=GenJT_KoudosgJytGtKahi.SYSNJOUJIKAIGOCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSysnjoujikaigocomment() {
        return sysnjoujikaigocomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSysnjoujikaigocomment(String pSysnjoujikaigocomment) {
        sysnjoujikaigocomment = pSysnjoujikaigocomment;
    }

    private C_SysnJyoujiKaigoGaitouKbn hokoukbn;

    @Type(type="UserType_C_SysnJyoujiKaigoGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.HOKOUKBN)
    public C_SysnJyoujiKaigoGaitouKbn getHokoukbn() {
        return hokoukbn;
    }

    public void setHokoukbn(C_SysnJyoujiKaigoGaitouKbn pHokoukbn) {
        hokoukbn = pHokoukbn;
    }

    private String hokoucomment;

    @Column(name=GenJT_KoudosgJytGtKahi.HOKOUCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getHokoucomment() {
        return hokoucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHokoucomment(String pHokoucomment) {
        hokoucomment = pHokoucomment;
    }

    private C_SysnJyoujiKaigoGaitouKbn ihukutyakudatukbn;

    @Type(type="UserType_C_SysnJyoujiKaigoGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.IHUKUTYAKUDATUKBN)
    public C_SysnJyoujiKaigoGaitouKbn getIhukutyakudatukbn() {
        return ihukutyakudatukbn;
    }

    public void setIhukutyakudatukbn(C_SysnJyoujiKaigoGaitouKbn pIhukutyakudatukbn) {
        ihukutyakudatukbn = pIhukutyakudatukbn;
    }

    private String ihukutyakudatucomment;

    @Column(name=GenJT_KoudosgJytGtKahi.IHUKUTYAKUDATUCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getIhukutyakudatucomment() {
        return ihukutyakudatucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIhukutyakudatucomment(String pIhukutyakudatucomment) {
        ihukutyakudatucomment = pIhukutyakudatucomment;
    }

    private C_SysnJyoujiKaigoGaitouKbn nyuuyokukbn;

    @Type(type="UserType_C_SysnJyoujiKaigoGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.NYUUYOKUKBN)
    public C_SysnJyoujiKaigoGaitouKbn getNyuuyokukbn() {
        return nyuuyokukbn;
    }

    public void setNyuuyokukbn(C_SysnJyoujiKaigoGaitouKbn pNyuuyokukbn) {
        nyuuyokukbn = pNyuuyokukbn;
    }

    private String nyuuyokucomment;

    @Column(name=GenJT_KoudosgJytGtKahi.NYUUYOKUCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getNyuuyokucomment() {
        return nyuuyokucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setNyuuyokucomment(String pNyuuyokucomment) {
        nyuuyokucomment = pNyuuyokucomment;
    }

    private C_SysnJyoujiKaigoGaitouKbn syokumotusessyukbn;

    @Type(type="UserType_C_SysnJyoujiKaigoGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.SYOKUMOTUSESSYUKBN)
    public C_SysnJyoujiKaigoGaitouKbn getSyokumotusessyukbn() {
        return syokumotusessyukbn;
    }

    public void setSyokumotusessyukbn(C_SysnJyoujiKaigoGaitouKbn pSyokumotusessyukbn) {
        syokumotusessyukbn = pSyokumotusessyukbn;
    }

    private String syokumotusessyucomment;

    @Column(name=GenJT_KoudosgJytGtKahi.SYOKUMOTUSESSYUCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyokumotusessyucomment() {
        return syokumotusessyucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSyokumotusessyucomment(String pSyokumotusessyucomment) {
        syokumotusessyucomment = pSyokumotusessyucomment;
    }

    private C_SysnJyoujiKaigoGaitouKbn hukitorisimatukbn;

    @Type(type="UserType_C_SysnJyoujiKaigoGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.HUKITORISIMATUKBN)
    public C_SysnJyoujiKaigoGaitouKbn getHukitorisimatukbn() {
        return hukitorisimatukbn;
    }

    public void setHukitorisimatukbn(C_SysnJyoujiKaigoGaitouKbn pHukitorisimatukbn) {
        hukitorisimatukbn = pHukitorisimatukbn;
    }

    private String hukitorisimatucomment;

    @Column(name=GenJT_KoudosgJytGtKahi.HUKITORISIMATUCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getHukitorisimatucomment() {
        return hukitorisimatucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHukitorisimatucomment(String pHukitorisimatucomment) {
        hukitorisimatucomment = pHukitorisimatucomment;
    }

    private C_SysnJyoujiKaigoGaitouKbn haibenhainyoukbn;

    @Type(type="UserType_C_SysnJyoujiKaigoGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.HAIBENHAINYOUKBN)
    public C_SysnJyoujiKaigoGaitouKbn getHaibenhainyoukbn() {
        return haibenhainyoukbn;
    }

    public void setHaibenhainyoukbn(C_SysnJyoujiKaigoGaitouKbn pHaibenhainyoukbn) {
        haibenhainyoukbn = pHaibenhainyoukbn;
    }

    private String haibenhainyoucomment;

    @Column(name=GenJT_KoudosgJytGtKahi.HAIBENHAINYOUCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getHaibenhainyoucomment() {
        return haibenhainyoucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHaibenhainyoucomment(String pHaibenhainyoucomment) {
        haibenhainyoucomment = pHaibenhainyoucomment;
    }

    private C_SysnJyoujiKaigoGaitouKbn kikyokbn;

    @Type(type="UserType_C_SysnJyoujiKaigoGaitouKbn")
    @Column(name=GenJT_KoudosgJytGtKahi.KIKYOKBN)
    public C_SysnJyoujiKaigoGaitouKbn getKikyokbn() {
        return kikyokbn;
    }

    public void setKikyokbn(C_SysnJyoujiKaigoGaitouKbn pKikyokbn) {
        kikyokbn = pKikyokbn;
    }

    private String kikyocomment;

    @Column(name=GenJT_KoudosgJytGtKahi.KIKYOCOMMENT)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getKikyocomment() {
        return kikyocomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKikyocomment(String pKikyocomment) {
        kikyocomment = pKikyocomment;
    }

    private String kossyoricd;

    @Column(name=GenJT_KoudosgJytGtKahi.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_KoudosgJytGtKahi.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_KoudosgJytGtKahi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_KoudosgJytGtKahi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}