package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.db.entity.BM_CreditCardKaisya;
import yuyu.def.db.id.PKBM_CreditCardKaisya;
import yuyu.def.db.meta.GenQBM_CreditCardKaisya;
import yuyu.def.db.meta.QBM_CreditCardKaisya;
import yuyu.def.db.type.UserType_C_HasuusyoriKbn;

/**
 * クレジットカード会社マスタ テーブルのマッピング情報クラスで、 {@link BM_CreditCardKaisya} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_CreditCardKaisya}</td><td colspan="3">クレジットカード会社マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">{@link PKBM_CreditCardKaisya ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPrefixstart prefixstart}</td><td>プレフィックス（開始）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPrefixend prefixend}</td><td>プレフィックス（終了）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardnolength cardnolength}</td><td>カード番号長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCardkaisyanm cardkaisyanm}</td><td>カード会社名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardkaisyanmryk cardkaisyanmryk}</td><td>カード会社名（略称）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditsyuudaikocd creditsyuudaikocd}</td><td>クレカ収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTorihikisakicd torihikisakicd}</td><td>取引先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthoriyuukoukikannissuu authoriyuukoukikannissuu}</td><td>オーソリ有効期間日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTesuuryouryouritu tesuuryouryouritu}</td><td>手数料料率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTesuuryouhasuusyorikbn tesuuryouhasuusyorikbn}</td><td>手数料端数処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasuusyoriKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_CreditCardKaisya
 * @see     PKBM_CreditCardKaisya
 * @see     QBM_CreditCardKaisya
 * @see     GenQBM_CreditCardKaisya
 */
@MappedSuperclass
@Table(name=GenBM_CreditCardKaisya.TABLE_NAME)
@IdClass(value=PKBM_CreditCardKaisya.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HasuusyoriKbn", typeClass=UserType_C_HasuusyoriKbn.class)
})
public abstract class GenBM_CreditCardKaisya extends AbstractExDBEntity<BM_CreditCardKaisya, PKBM_CreditCardKaisya> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_CreditCardKaisya";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String PREFIXSTART              = "prefixstart";
    public static final String PREFIXEND                = "prefixend";
    public static final String CARDNOLENGTH             = "cardnolength";
    public static final String CARDKAISYANM             = "cardkaisyanm";
    public static final String CARDKAISYANMRYK          = "cardkaisyanmryk";
    public static final String CREDITSYUUDAIKOCD        = "creditsyuudaikocd";
    public static final String TORIHIKISAKICD           = "torihikisakicd";
    public static final String AUTHORIYUUKOUKIKANNISSUU = "authoriyuukoukikannissuu";
    public static final String TESUURYOURYOURITU        = "tesuuryouryouritu";
    public static final String TESUURYOUHASUUSYORIKBN   = "tesuuryouhasuusyorikbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_CreditCardKaisya primaryKey;

    public GenBM_CreditCardKaisya() {
        primaryKey = new PKBM_CreditCardKaisya();
    }

    public GenBM_CreditCardKaisya(String pCardkaisyacd) {
        primaryKey = new PKBM_CreditCardKaisya(pCardkaisyacd);
    }

    @Transient
    @Override
    public PKBM_CreditCardKaisya getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_CreditCardKaisya> getMetaClass() {
        return QBM_CreditCardKaisya.class;
    }

    @Id
    @Column(name=GenBM_CreditCardKaisya.CARDKAISYACD)
    public String getCardkaisyacd() {
        return getPrimaryKey().getCardkaisyacd();
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        getPrimaryKey().setCardkaisyacd(pCardkaisyacd);
    }

    private Integer hyoujijyun;

    @Column(name=GenBM_CreditCardKaisya.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private String prefixstart;

    @Column(name=GenBM_CreditCardKaisya.PREFIXSTART)
    public String getPrefixstart() {
        return prefixstart;
    }

    public void setPrefixstart(String pPrefixstart) {
        prefixstart = pPrefixstart;
    }

    private String prefixend;

    @Column(name=GenBM_CreditCardKaisya.PREFIXEND)
    public String getPrefixend() {
        return prefixend;
    }

    public void setPrefixend(String pPrefixend) {
        prefixend = pPrefixend;
    }

    private Integer cardnolength;

    @Column(name=GenBM_CreditCardKaisya.CARDNOLENGTH)
    public Integer getCardnolength() {
        return cardnolength;
    }

    public void setCardnolength(Integer pCardnolength) {
        cardnolength = pCardnolength;
    }

    private String cardkaisyanm;

    @Column(name=GenBM_CreditCardKaisya.CARDKAISYANM)
    public String getCardkaisyanm() {
        return cardkaisyanm;
    }

    public void setCardkaisyanm(String pCardkaisyanm) {
        cardkaisyanm = pCardkaisyanm;
    }

    private String cardkaisyanmryk;

    @Column(name=GenBM_CreditCardKaisya.CARDKAISYANMRYK)
    public String getCardkaisyanmryk() {
        return cardkaisyanmryk;
    }

    public void setCardkaisyanmryk(String pCardkaisyanmryk) {
        cardkaisyanmryk = pCardkaisyanmryk;
    }

    private String creditsyuudaikocd;

    @Column(name=GenBM_CreditCardKaisya.CREDITSYUUDAIKOCD)
    public String getCreditsyuudaikocd() {
        return creditsyuudaikocd;
    }

    public void setCreditsyuudaikocd(String pCreditsyuudaikocd) {
        creditsyuudaikocd = pCreditsyuudaikocd;
    }

    private String torihikisakicd;

    @Column(name=GenBM_CreditCardKaisya.TORIHIKISAKICD)
    public String getTorihikisakicd() {
        return torihikisakicd;
    }

    public void setTorihikisakicd(String pTorihikisakicd) {
        torihikisakicd = pTorihikisakicd;
    }

    private Integer authoriyuukoukikannissuu;

    @Column(name=GenBM_CreditCardKaisya.AUTHORIYUUKOUKIKANNISSUU)
    public Integer getAuthoriyuukoukikannissuu() {
        return authoriyuukoukikannissuu;
    }

    public void setAuthoriyuukoukikannissuu(Integer pAuthoriyuukoukikannissuu) {
        authoriyuukoukikannissuu = pAuthoriyuukoukikannissuu;
    }

    private BizNumber tesuuryouryouritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_CreditCardKaisya.TESUURYOURYOURITU)
    public BizNumber getTesuuryouryouritu() {
        return tesuuryouryouritu;
    }

    public void setTesuuryouryouritu(BizNumber pTesuuryouryouritu) {
        tesuuryouryouritu = pTesuuryouryouritu;
    }

    private C_HasuusyoriKbn tesuuryouhasuusyorikbn;

    @Type(type="UserType_C_HasuusyoriKbn")
    @Column(name=GenBM_CreditCardKaisya.TESUURYOUHASUUSYORIKBN)
    public C_HasuusyoriKbn getTesuuryouhasuusyorikbn() {
        return tesuuryouhasuusyorikbn;
    }

    public void setTesuuryouhasuusyorikbn(C_HasuusyoriKbn pTesuuryouhasuusyorikbn) {
        tesuuryouhasuusyorikbn = pTesuuryouhasuusyorikbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_CreditCardKaisya.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_CreditCardKaisya.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}