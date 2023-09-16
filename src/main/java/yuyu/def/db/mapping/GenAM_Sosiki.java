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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SosikiNmKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.id.PKAM_Sosiki;
import yuyu.def.db.meta.GenQAM_Sosiki;
import yuyu.def.db.meta.QAM_Sosiki;
import yuyu.def.db.type.UserType_C_SosikiNmKbn;

/**
 * 組織マスタ テーブルのマッピング情報クラスで、 {@link AM_Sosiki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_Sosiki}</td><td colspan="3">組織マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSosikicd sosikicd}</td><td>組織コード</td><td align="center">{@link PKAM_Sosiki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikinmkbn sosikinmkbn}</td><td>組織名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SosikiNmKbn}</td></tr>
 *  <tr><td>{@link #getSosikinm20 sosikinm20}</td><td>組織名（２０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjisosikinm20 kanjisosikinm20}</td><td>漢字組織名（２０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikihaisiym sosikihaisiym}</td><td>組織廃止年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSosikisinsetuym sosikisinsetuym}</td><td>組織新設年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTougetukeisyouusosikicd tougetukeisyouusosikicd}</td><td>当月継承組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTougetukeisyoueigyoubucd tougetukeisyoueigyoubucd}</td><td>当月継承営業推進部コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZengetukeisyousosikicd zengetukeisyousosikicd}</td><td>前月継承組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZengetukeisyoueigyoubucd zengetukeisyoueigyoubucd}</td><td>前月継承営業推進部コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikikihontikucd sosikikihontikucd}</td><td>組織基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikikanjikaijyuusyo30 sosikikanjikaijyuusyo30}</td><td>組織漢字下位住所（３０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjibirunm15 kanjibirunm15}</td><td>漢字ビル名称（１５文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikinyuukyokaisuu sosikinyuukyokaisuu}</td><td>組織入居階数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikitelno sosikitelno}</td><td>組織電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikifaxno sosikifaxno}</td><td>組織ＦＡＸ番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouryokukaisiymd kouryokukaisiymd}</td><td>効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHensosikikihontikucd hensosikikihontikucd}</td><td>(変更後)組織基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkanjisosikikaijyuusyo30 henkanjisosikikaijyuusyo30}</td><td>(変更後)漢字組織下位住所（３０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkanjibirunm15 henkanjibirunm15}</td><td>(変更後)漢字ビル名称（１５文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHensosikinyuukyokaisuu hensosikinyuukyokaisuu}</td><td>(変更後)組織入居階数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHensosikitelno hensosikitelno}</td><td>(変更後)組織電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHensosikifaxno hensosikifaxno}</td><td>(変更後)組織ＦＡＸ番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_Sosiki
 * @see     PKAM_Sosiki
 * @see     QAM_Sosiki
 * @see     GenQAM_Sosiki
 */
@MappedSuperclass
@Table(name=GenAM_Sosiki.TABLE_NAME)
@IdClass(value=PKAM_Sosiki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_SosikiNmKbn", typeClass=UserType_C_SosikiNmKbn.class)
})
public abstract class GenAM_Sosiki extends AbstractExDBEntity<AM_Sosiki, PKAM_Sosiki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_Sosiki";
    public static final String SOSIKICD                 = "sosikicd";
    public static final String SOSIKINMKBN              = "sosikinmkbn";
    public static final String SOSIKINM20               = "sosikinm20";
    public static final String KANJISOSIKINM20          = "kanjisosikinm20";
    public static final String SOSIKIHAISIYM            = "sosikihaisiym";
    public static final String SOSIKISINSETUYM          = "sosikisinsetuym";
    public static final String TOUGETUKEISYOUUSOSIKICD  = "tougetukeisyouusosikicd";
    public static final String TOUGETUKEISYOUEIGYOUBUCD = "tougetukeisyoueigyoubucd";
    public static final String ZENGETUKEISYOUSOSIKICD   = "zengetukeisyousosikicd";
    public static final String ZENGETUKEISYOUEIGYOUBUCD = "zengetukeisyoueigyoubucd";
    public static final String SOSIKIKIHONTIKUCD        = "sosikikihontikucd";
    public static final String SOSIKIKANJIKAIJYUUSYO30  = "sosikikanjikaijyuusyo30";
    public static final String KANJIBIRUNM15            = "kanjibirunm15";
    public static final String SOSIKINYUUKYOKAISUU      = "sosikinyuukyokaisuu";
    public static final String SOSIKITELNO              = "sosikitelno";
    public static final String SOSIKIFAXNO              = "sosikifaxno";
    public static final String KOURYOKUKAISIYMD         = "kouryokukaisiymd";
    public static final String HENSOSIKIKIHONTIKUCD     = "hensosikikihontikucd";
    public static final String HENKANJISOSIKIKAIJYUUSYO30 = "henkanjisosikikaijyuusyo30";
    public static final String HENKANJIBIRUNM15         = "henkanjibirunm15";
    public static final String HENSOSIKINYUUKYOKAISUU   = "hensosikinyuukyokaisuu";
    public static final String HENSOSIKITELNO           = "hensosikitelno";
    public static final String HENSOSIKIFAXNO           = "hensosikifaxno";

    private final PKAM_Sosiki primaryKey;

    public GenAM_Sosiki() {
        primaryKey = new PKAM_Sosiki();
    }

    public GenAM_Sosiki(String pSosikicd) {
        primaryKey = new PKAM_Sosiki(pSosikicd);
    }

    @Transient
    @Override
    public PKAM_Sosiki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_Sosiki> getMetaClass() {
        return QAM_Sosiki.class;
    }

    @Id
    @Column(name=GenAM_Sosiki.SOSIKICD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getSosikicd() {
        return getPrimaryKey().getSosikicd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSosikicd(String pSosikicd) {
        getPrimaryKey().setSosikicd(pSosikicd);
    }

    private C_SosikiNmKbn sosikinmkbn;

    @Type(type="UserType_C_SosikiNmKbn")
    @Column(name=GenAM_Sosiki.SOSIKINMKBN)
    public C_SosikiNmKbn getSosikinmkbn() {
        return sosikinmkbn;
    }

    public void setSosikinmkbn(C_SosikiNmKbn pSosikinmkbn) {
        sosikinmkbn = pSosikinmkbn;
    }

    private String sosikinm20;

    @Column(name=GenAM_Sosiki.SOSIKINM20)
    public String getSosikinm20() {
        return sosikinm20;
    }

    public void setSosikinm20(String pSosikinm20) {
        sosikinm20 = pSosikinm20;
    }

    private String kanjisosikinm20;

    @Column(name=GenAM_Sosiki.KANJISOSIKINM20)
    public String getKanjisosikinm20() {
        return kanjisosikinm20;
    }

    public void setKanjisosikinm20(String pKanjisosikinm20) {
        kanjisosikinm20 = pKanjisosikinm20;
    }

    private BizDateYM sosikihaisiym;

    @Type(type="BizDateYMType")
    @Column(name=GenAM_Sosiki.SOSIKIHAISIYM)
    public BizDateYM getSosikihaisiym() {
        return sosikihaisiym;
    }

    public void setSosikihaisiym(BizDateYM pSosikihaisiym) {
        sosikihaisiym = pSosikihaisiym;
    }

    private BizDateYM sosikisinsetuym;

    @Type(type="BizDateYMType")
    @Column(name=GenAM_Sosiki.SOSIKISINSETUYM)
    public BizDateYM getSosikisinsetuym() {
        return sosikisinsetuym;
    }

    public void setSosikisinsetuym(BizDateYM pSosikisinsetuym) {
        sosikisinsetuym = pSosikisinsetuym;
    }

    private String tougetukeisyouusosikicd;

    @Column(name=GenAM_Sosiki.TOUGETUKEISYOUUSOSIKICD)
    public String getTougetukeisyouusosikicd() {
        return tougetukeisyouusosikicd;
    }

    public void setTougetukeisyouusosikicd(String pTougetukeisyouusosikicd) {
        tougetukeisyouusosikicd = pTougetukeisyouusosikicd;
    }

    private String tougetukeisyoueigyoubucd;

    @Column(name=GenAM_Sosiki.TOUGETUKEISYOUEIGYOUBUCD)
    public String getTougetukeisyoueigyoubucd() {
        return tougetukeisyoueigyoubucd;
    }

    public void setTougetukeisyoueigyoubucd(String pTougetukeisyoueigyoubucd) {
        tougetukeisyoueigyoubucd = pTougetukeisyoueigyoubucd;
    }

    private String zengetukeisyousosikicd;

    @Column(name=GenAM_Sosiki.ZENGETUKEISYOUSOSIKICD)
    public String getZengetukeisyousosikicd() {
        return zengetukeisyousosikicd;
    }

    public void setZengetukeisyousosikicd(String pZengetukeisyousosikicd) {
        zengetukeisyousosikicd = pZengetukeisyousosikicd;
    }

    private String zengetukeisyoueigyoubucd;

    @Column(name=GenAM_Sosiki.ZENGETUKEISYOUEIGYOUBUCD)
    public String getZengetukeisyoueigyoubucd() {
        return zengetukeisyoueigyoubucd;
    }

    public void setZengetukeisyoueigyoubucd(String pZengetukeisyoueigyoubucd) {
        zengetukeisyoueigyoubucd = pZengetukeisyoueigyoubucd;
    }

    private String sosikikihontikucd;

    @Column(name=GenAM_Sosiki.SOSIKIKIHONTIKUCD)
    public String getSosikikihontikucd() {
        return sosikikihontikucd;
    }

    public void setSosikikihontikucd(String pSosikikihontikucd) {
        sosikikihontikucd = pSosikikihontikucd;
    }

    private String sosikikanjikaijyuusyo30;

    @Column(name=GenAM_Sosiki.SOSIKIKANJIKAIJYUUSYO30)
    public String getSosikikanjikaijyuusyo30() {
        return sosikikanjikaijyuusyo30;
    }

    public void setSosikikanjikaijyuusyo30(String pSosikikanjikaijyuusyo30) {
        sosikikanjikaijyuusyo30 = pSosikikanjikaijyuusyo30;
    }

    private String kanjibirunm15;

    @Column(name=GenAM_Sosiki.KANJIBIRUNM15)
    public String getKanjibirunm15() {
        return kanjibirunm15;
    }

    public void setKanjibirunm15(String pKanjibirunm15) {
        kanjibirunm15 = pKanjibirunm15;
    }

    private String sosikinyuukyokaisuu;

    @Column(name=GenAM_Sosiki.SOSIKINYUUKYOKAISUU)
    public String getSosikinyuukyokaisuu() {
        return sosikinyuukyokaisuu;
    }

    public void setSosikinyuukyokaisuu(String pSosikinyuukyokaisuu) {
        sosikinyuukyokaisuu = pSosikinyuukyokaisuu;
    }

    private String sosikitelno;

    @Column(name=GenAM_Sosiki.SOSIKITELNO)
    public String getSosikitelno() {
        return sosikitelno;
    }

    public void setSosikitelno(String pSosikitelno) {
        sosikitelno = pSosikitelno;
    }

    private String sosikifaxno;

    @Column(name=GenAM_Sosiki.SOSIKIFAXNO)
    public String getSosikifaxno() {
        return sosikifaxno;
    }

    public void setSosikifaxno(String pSosikifaxno) {
        sosikifaxno = pSosikifaxno;
    }

    private BizDate kouryokukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenAM_Sosiki.KOURYOKUKAISIYMD)
    public BizDate getKouryokukaisiymd() {
        return kouryokukaisiymd;
    }

    public void setKouryokukaisiymd(BizDate pKouryokukaisiymd) {
        kouryokukaisiymd = pKouryokukaisiymd;
    }

    private String hensosikikihontikucd;

    @Column(name=GenAM_Sosiki.HENSOSIKIKIHONTIKUCD)
    public String getHensosikikihontikucd() {
        return hensosikikihontikucd;
    }

    public void setHensosikikihontikucd(String pHensosikikihontikucd) {
        hensosikikihontikucd = pHensosikikihontikucd;
    }

    private String henkanjisosikikaijyuusyo30;

    @Column(name=GenAM_Sosiki.HENKANJISOSIKIKAIJYUUSYO30)
    public String getHenkanjisosikikaijyuusyo30() {
        return henkanjisosikikaijyuusyo30;
    }

    public void setHenkanjisosikikaijyuusyo30(String pHenkanjisosikikaijyuusyo30) {
        henkanjisosikikaijyuusyo30 = pHenkanjisosikikaijyuusyo30;
    }

    private String henkanjibirunm15;

    @Column(name=GenAM_Sosiki.HENKANJIBIRUNM15)
    public String getHenkanjibirunm15() {
        return henkanjibirunm15;
    }

    public void setHenkanjibirunm15(String pHenkanjibirunm15) {
        henkanjibirunm15 = pHenkanjibirunm15;
    }

    private String hensosikinyuukyokaisuu;

    @Column(name=GenAM_Sosiki.HENSOSIKINYUUKYOKAISUU)
    public String getHensosikinyuukyokaisuu() {
        return hensosikinyuukyokaisuu;
    }

    public void setHensosikinyuukyokaisuu(String pHensosikinyuukyokaisuu) {
        hensosikinyuukyokaisuu = pHensosikinyuukyokaisuu;
    }

    private String hensosikitelno;

    @Column(name=GenAM_Sosiki.HENSOSIKITELNO)
    public String getHensosikitelno() {
        return hensosikitelno;
    }

    public void setHensosikitelno(String pHensosikitelno) {
        hensosikitelno = pHensosikitelno;
    }

    private String hensosikifaxno;

    @Column(name=GenAM_Sosiki.HENSOSIKIFAXNO)
    public String getHensosikifaxno() {
        return hensosikifaxno;
    }

    public void setHensosikifaxno(String pHensosikifaxno) {
        hensosikifaxno = pHensosikifaxno;
    }
}
