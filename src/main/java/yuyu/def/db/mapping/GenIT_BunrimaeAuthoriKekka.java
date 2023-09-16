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
import yuyu.def.db.entity.IT_BunrimaeAuthoriKekka;
import yuyu.def.db.id.PKIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.GenQIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.QIT_BunrimaeAuthoriKekka;

/**
 * 分離前オーソリ結果テーブル テーブルのマッピング情報クラスで、 {@link IT_BunrimaeAuthoriKekka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BunrimaeAuthoriKekka}</td><td colspan="3">分離前オーソリ結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_BunrimaeAuthoriKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDatajyusinymd datajyusinymd}</td><td>データ受信日</td><td align="center">{@link PKIT_BunrimaeAuthoriKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaiintourokukbn kaiintourokukbn}</td><td>会員登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno creditcardno}</td><td>クレジットカード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardyuukoukigen4keta cardyuukoukigen4keta}</td><td>クレジットカード有効期限（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorigk7keta authorigk7keta}</td><td>オーソリ金額（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorikekkaerrorcd authorikekkaerrorcd}</td><td>オーソリ結果エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBluegateerrorcd bluegateerrorcd}</td><td>ＢｌｕｅＧａｔｅエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHisimukekaisyacd hisimukekaisyacd}</td><td>被仕向会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWentryuserid wentryuserid}</td><td>ＷエントリユーザＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getErrorcomment errorcomment}</td><td>エラーコメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNiniinfo niniinfo}</td><td>任意情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDatasyorijyoukyou datasyorijyoukyou}</td><td>データ処理状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BunrimaeAuthoriKekka
 * @see     PKIT_BunrimaeAuthoriKekka
 * @see     QIT_BunrimaeAuthoriKekka
 * @see     GenQIT_BunrimaeAuthoriKekka
 */
@MappedSuperclass
@Table(name=GenIT_BunrimaeAuthoriKekka.TABLE_NAME)
@IdClass(value=PKIT_BunrimaeAuthoriKekka.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenIT_BunrimaeAuthoriKekka extends AbstractExDBEntity<IT_BunrimaeAuthoriKekka, PKIT_BunrimaeAuthoriKekka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BunrimaeAuthoriKekka";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String DATAJYUSINYMD            = "datajyusinymd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KAIINTOUROKUKBN          = "kaiintourokukbn";
    public static final String CREDITCARDNO             = "creditcardno";
    public static final String CARDYUUKOUKIGEN4KETA     = "cardyuukoukigen4keta";
    public static final String AUTHORIGK7KETA           = "authorigk7keta";
    public static final String AUTHORIKEKKAERRORCD      = "authorikekkaerrorcd";
    public static final String BLUEGATEERRORCD          = "bluegateerrorcd";
    public static final String HISIMUKEKAISYACD         = "hisimukekaisyacd";
    public static final String WENTRYUSERID             = "wentryuserid";
    public static final String ERRORCOMMENT             = "errorcomment";
    public static final String NINIINFO                 = "niniinfo";
    public static final String DATASYORIJYOUKYOU        = "datasyorijyoukyou";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BunrimaeAuthoriKekka primaryKey;

    public GenIT_BunrimaeAuthoriKekka() {
        primaryKey = new PKIT_BunrimaeAuthoriKekka();
    }

    public GenIT_BunrimaeAuthoriKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        primaryKey = new PKIT_BunrimaeAuthoriKekka(pCreditkessaiyouno, pDatajyusinymd);
    }

    @Transient
    @Override
    public PKIT_BunrimaeAuthoriKekka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BunrimaeAuthoriKekka> getMetaClass() {
        return QIT_BunrimaeAuthoriKekka.class;
    }

    @Id
    @Column(name=GenIT_BunrimaeAuthoriKekka.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Column(name=GenIT_BunrimaeAuthoriKekka.DATAJYUSINYMD)
    public String getDatajyusinymd() {
        return getPrimaryKey().getDatajyusinymd();
    }

    public void setDatajyusinymd(String pDatajyusinymd) {
        getPrimaryKey().setDatajyusinymd(pDatajyusinymd);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BunrimaeAuthoriKekka.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String kaiintourokukbn;

    @Column(name=GenIT_BunrimaeAuthoriKekka.KAIINTOUROKUKBN)
    public String getKaiintourokukbn() {
        return kaiintourokukbn;
    }

    public void setKaiintourokukbn(String pKaiintourokukbn) {
        kaiintourokukbn = pKaiintourokukbn;
    }

    private String creditcardno;

    @Column(name=GenIT_BunrimaeAuthoriKekka.CREDITCARDNO)
    public String getCreditcardno() {
        return creditcardno;
    }

    public void setCreditcardno(String pCreditcardno) {
        creditcardno = pCreditcardno;
    }

    private String cardyuukoukigen4keta;

    @Column(name=GenIT_BunrimaeAuthoriKekka.CARDYUUKOUKIGEN4KETA)
    public String getCardyuukoukigen4keta() {
        return cardyuukoukigen4keta;
    }

    public void setCardyuukoukigen4keta(String pCardyuukoukigen4keta) {
        cardyuukoukigen4keta = pCardyuukoukigen4keta;
    }

    private String authorigk7keta;

    @Column(name=GenIT_BunrimaeAuthoriKekka.AUTHORIGK7KETA)
    public String getAuthorigk7keta() {
        return authorigk7keta;
    }

    public void setAuthorigk7keta(String pAuthorigk7keta) {
        authorigk7keta = pAuthorigk7keta;
    }

    private String authorikekkaerrorcd;

    @Column(name=GenIT_BunrimaeAuthoriKekka.AUTHORIKEKKAERRORCD)
    public String getAuthorikekkaerrorcd() {
        return authorikekkaerrorcd;
    }

    public void setAuthorikekkaerrorcd(String pAuthorikekkaerrorcd) {
        authorikekkaerrorcd = pAuthorikekkaerrorcd;
    }

    private String bluegateerrorcd;

    @Column(name=GenIT_BunrimaeAuthoriKekka.BLUEGATEERRORCD)
    public String getBluegateerrorcd() {
        return bluegateerrorcd;
    }

    public void setBluegateerrorcd(String pBluegateerrorcd) {
        bluegateerrorcd = pBluegateerrorcd;
    }

    private String hisimukekaisyacd;

    @Column(name=GenIT_BunrimaeAuthoriKekka.HISIMUKEKAISYACD)
    public String getHisimukekaisyacd() {
        return hisimukekaisyacd;
    }

    public void setHisimukekaisyacd(String pHisimukekaisyacd) {
        hisimukekaisyacd = pHisimukekaisyacd;
    }

    private String wentryuserid;

    @Column(name=GenIT_BunrimaeAuthoriKekka.WENTRYUSERID)
    public String getWentryuserid() {
        return wentryuserid;
    }

    public void setWentryuserid(String pWentryuserid) {
        wentryuserid = pWentryuserid;
    }

    private String errorcomment;

    @Column(name=GenIT_BunrimaeAuthoriKekka.ERRORCOMMENT)
    public String getErrorcomment() {
        return errorcomment;
    }

    public void setErrorcomment(String pErrorcomment) {
        errorcomment = pErrorcomment;
    }

    private String niniinfo;

    @Column(name=GenIT_BunrimaeAuthoriKekka.NINIINFO)
    public String getNiniinfo() {
        return niniinfo;
    }

    public void setNiniinfo(String pNiniinfo) {
        niniinfo = pNiniinfo;
    }

    private String datasyorijyoukyou;

    @Column(name=GenIT_BunrimaeAuthoriKekka.DATASYORIJYOUKYOU)
    public String getDatasyorijyoukyou() {
        return datasyorijyoukyou;
    }

    public void setDatasyorijyoukyou(String pDatasyorijyoukyou) {
        datasyorijyoukyou = pDatasyorijyoukyou;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BunrimaeAuthoriKekka.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BunrimaeAuthoriKekka.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BunrimaeAuthoriKekka.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}