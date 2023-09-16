package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.id.PKZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.GenQZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrTr;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_SkCreditTourokukekkaQrTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkCreditTourokukekkaQrTr}</td><td colspan="3">新契約クレジットカード登録結果（ＱＲ）テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrrecordkbn ztrrecordkbn}</td><td>（取込用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsystemjyusinymd ztrsystemjyusinymd}</td><td>（取込用）システム受信日</td><td align="center">{@link PKZT_SkCreditTourokukekkaQrTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsystemjyusintime ztrsystemjyusintime}</td><td>（取込用）システム受信時刻</td><td align="center">{@link PKZT_SkCreditTourokukekkaQrTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditqrtrkkbn ztrcreditqrtrkkbn}</td><td>（取込用）クレジットカードＱＲ登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditqrsousinkbn ztrcreditqrsousinkbn}</td><td>（取込用）クレジットカードＱＲ送信区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">{@link PKZT_SkCreditTourokukekkaQrTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv34 ztryobiv34}</td><td>（取込用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkaiinno ztrcreditkaiinno}</td><td>（取込用）クレジット会員番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcardyuukoukigen ztrcardyuukoukigen}</td><td>（取込用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrauthorigkjyusin ztrauthorigkjyusin}</td><td>（取込用）オーソリ金額（受信）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv153 ztryobiv153}</td><td>（取込用）予備項目Ｖ１５３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtyuumonno ztrtyuumonno}</td><td>（取込用）注文番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv50 ztryobiv50}</td><td>（取込用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbluegateshopid ztrbluegateshopid}</td><td>（取込用）ＢｌｕｅＧａｔｅショップＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv81 ztryobiv81}</td><td>（取込用）予備項目Ｖ８１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkessaisyoriymd ztrkessaisyoriymd}</td><td>（取込用）決済処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv24 ztryobiv24}</td><td>（取込用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditqrerrorcd ztrcreditqrerrorcd}</td><td>（取込用）クレジットカードＱＲエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyouninno7keta ztrsyouninno7keta}</td><td>（取込用）承認番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbluegateerrorcd ztrbluegateerrorcd}</td><td>（取込用）ＢｌｕｅＧａｔｅエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhisimukekaisyacd ztrhisimukekaisyacd}</td><td>（取込用）被仕向会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbluegatejyusinymdtime ztrbluegatejyusinymdtime}</td><td>（取込用）ＢｌｕｅＧａｔｅ受付日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv160 ztryobiv160}</td><td>（取込用）予備項目Ｖ１６０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkCreditTourokukekkaQrTr
 * @see     PKZT_SkCreditTourokukekkaQrTr
 * @see     QZT_SkCreditTourokukekkaQrTr
 * @see     GenQZT_SkCreditTourokukekkaQrTr
 */
@MappedSuperclass
@Table(name=GenZT_SkCreditTourokukekkaQrTr.TABLE_NAME)
@IdClass(value=PKZT_SkCreditTourokukekkaQrTr.class)
public abstract class GenZT_SkCreditTourokukekkaQrTr extends AbstractExDBEntity<ZT_SkCreditTourokukekkaQrTr, PKZT_SkCreditTourokukekkaQrTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkCreditTourokukekkaQrTr";
    public static final String ZTRRECORDKBN             = "ztrrecordkbn";
    public static final String ZTRSYSTEMJYUSINYMD       = "ztrsystemjyusinymd";
    public static final String ZTRSYSTEMJYUSINTIME      = "ztrsystemjyusintime";
    public static final String ZTRCREDITQRTRKKBN        = "ztrcreditqrtrkkbn";
    public static final String ZTRCREDITQRSOUSINKBN     = "ztrcreditqrsousinkbn";
    public static final String ZTRCREDITKESSAIYOUNO     = "ztrcreditkessaiyouno";
    public static final String ZTRYOBIV34               = "ztryobiv34";
    public static final String ZTRCREDITKAIINNO         = "ztrcreditkaiinno";
    public static final String ZTRCARDYUUKOUKIGEN       = "ztrcardyuukoukigen";
    public static final String ZTRAUTHORIGKJYUSIN       = "ztrauthorigkjyusin";
    public static final String ZTRYOBIV153              = "ztryobiv153";
    public static final String ZTRTYUUMONNO             = "ztrtyuumonno";
    public static final String ZTRYOBIV50               = "ztryobiv50";
    public static final String ZTRBLUEGATESHOPID        = "ztrbluegateshopid";
    public static final String ZTRYOBIV81               = "ztryobiv81";
    public static final String ZTRKESSAISYORIYMD        = "ztrkessaisyoriymd";
    public static final String ZTRYOBIV24               = "ztryobiv24";
    public static final String ZTRCREDITQRERRORCD       = "ztrcreditqrerrorcd";
    public static final String ZTRSYOUNINNO7KETA        = "ztrsyouninno7keta";
    public static final String ZTRBLUEGATEERRORCD       = "ztrbluegateerrorcd";
    public static final String ZTRHISIMUKEKAISYACD      = "ztrhisimukekaisyacd";
    public static final String ZTRBLUEGATEJYUSINYMDTIME = "ztrbluegatejyusinymdtime";
    public static final String ZTRYOBIV160              = "ztryobiv160";

    private final PKZT_SkCreditTourokukekkaQrTr primaryKey;

    public GenZT_SkCreditTourokukekkaQrTr() {
        primaryKey = new PKZT_SkCreditTourokukekkaQrTr();
    }

    public GenZT_SkCreditTourokukekkaQrTr(
        String pZtrsystemjyusinymd,
        String pZtrsystemjyusintime,
        String pZtrcreditkessaiyouno
    ) {
        primaryKey = new PKZT_SkCreditTourokukekkaQrTr(
            pZtrsystemjyusinymd,
            pZtrsystemjyusintime,
            pZtrcreditkessaiyouno
        );
    }

    @Transient
    @Override
    public PKZT_SkCreditTourokukekkaQrTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkCreditTourokukekkaQrTr> getMetaClass() {
        return QZT_SkCreditTourokukekkaQrTr.class;
    }

    private String ztrrecordkbn;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRRECORDKBN)
    public String getZtrrecordkbn() {
        return ztrrecordkbn;
    }

    @DataConvert("toSingleByte")
    public void setZtrrecordkbn(String pZtrrecordkbn) {
        ztrrecordkbn = pZtrrecordkbn;
    }

    @Id
    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRSYSTEMJYUSINYMD)
    public String getZtrsystemjyusinymd() {
        return getPrimaryKey().getZtrsystemjyusinymd();
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtrsystemjyusinymd(String pZtrsystemjyusinymd) {
        getPrimaryKey().setZtrsystemjyusinymd(pZtrsystemjyusinymd);
    }

    @Id
    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRSYSTEMJYUSINTIME)
    public String getZtrsystemjyusintime() {
        return getPrimaryKey().getZtrsystemjyusintime();
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtrsystemjyusintime(String pZtrsystemjyusintime) {
        getPrimaryKey().setZtrsystemjyusintime(pZtrsystemjyusintime);
    }

    private String ztrcreditqrtrkkbn;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRCREDITQRTRKKBN)
    public String getZtrcreditqrtrkkbn() {
        return ztrcreditqrtrkkbn;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtrcreditqrtrkkbn(String pZtrcreditqrtrkkbn) {
        ztrcreditqrtrkkbn = pZtrcreditqrtrkkbn;
    }

    private String ztrcreditqrsousinkbn;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRCREDITQRSOUSINKBN)
    public String getZtrcreditqrsousinkbn() {
        return ztrcreditqrsousinkbn;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtrcreditqrsousinkbn(String pZtrcreditqrsousinkbn) {
        ztrcreditqrsousinkbn = pZtrcreditqrsousinkbn;
    }

    @Id
    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRCREDITKESSAIYOUNO)
    public String getZtrcreditkessaiyouno() {
        return getPrimaryKey().getZtrcreditkessaiyouno();
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        getPrimaryKey().setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
    }

    private String ztryobiv34;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRYOBIV34)
    public String getZtryobiv34() {
        return ztryobiv34;
    }

    public void setZtryobiv34(String pZtryobiv34) {
        ztryobiv34 = pZtryobiv34;
    }

    private String ztrcreditkaiinno;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRCREDITKAIINNO)
    public String getZtrcreditkaiinno() {
        return ztrcreditkaiinno;
    }

    @DataConvert("toSingleByte")
    public void setZtrcreditkaiinno(String pZtrcreditkaiinno) {
        ztrcreditkaiinno = pZtrcreditkaiinno;
    }

    private String ztrcardyuukoukigen;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRCARDYUUKOUKIGEN)
    public String getZtrcardyuukoukigen() {
        return ztrcardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZtrcardyuukoukigen(String pZtrcardyuukoukigen) {
        ztrcardyuukoukigen = pZtrcardyuukoukigen;
    }

    private String ztrauthorigkjyusin;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRAUTHORIGKJYUSIN)
    public String getZtrauthorigkjyusin() {
        return ztrauthorigkjyusin;
    }

    @DataConvert("toSingleByte")
    public void setZtrauthorigkjyusin(String pZtrauthorigkjyusin) {
        ztrauthorigkjyusin = pZtrauthorigkjyusin;
    }

    private String ztryobiv153;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRYOBIV153)
    public String getZtryobiv153() {
        return ztryobiv153;
    }

    public void setZtryobiv153(String pZtryobiv153) {
        ztryobiv153 = pZtryobiv153;
    }

    private String ztrtyuumonno;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRTYUUMONNO)
    public String getZtrtyuumonno() {
        return ztrtyuumonno;
    }

    @DataConvert("toSingleByte")
    public void setZtrtyuumonno(String pZtrtyuumonno) {
        ztrtyuumonno = pZtrtyuumonno;
    }

    private String ztryobiv50;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRYOBIV50)
    public String getZtryobiv50() {
        return ztryobiv50;
    }

    public void setZtryobiv50(String pZtryobiv50) {
        ztryobiv50 = pZtryobiv50;
    }

    private String ztrbluegateshopid;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRBLUEGATESHOPID)
    public String getZtrbluegateshopid() {
        return ztrbluegateshopid;
    }

    @DataConvert("toSingleByte")
    public void setZtrbluegateshopid(String pZtrbluegateshopid) {
        ztrbluegateshopid = pZtrbluegateshopid;
    }

    private String ztryobiv81;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRYOBIV81)
    public String getZtryobiv81() {
        return ztryobiv81;
    }

    public void setZtryobiv81(String pZtryobiv81) {
        ztryobiv81 = pZtryobiv81;
    }

    private String ztrkessaisyoriymd;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRKESSAISYORIYMD)
    public String getZtrkessaisyoriymd() {
        return ztrkessaisyoriymd;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtrkessaisyoriymd(String pZtrkessaisyoriymd) {
        ztrkessaisyoriymd = pZtrkessaisyoriymd;
    }

    private String ztryobiv24;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRYOBIV24)
    public String getZtryobiv24() {
        return ztryobiv24;
    }

    public void setZtryobiv24(String pZtryobiv24) {
        ztryobiv24 = pZtryobiv24;
    }

    private String ztrcreditqrerrorcd;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRCREDITQRERRORCD)
    public String getZtrcreditqrerrorcd() {
        return ztrcreditqrerrorcd;
    }

    @DataConvert("toSingleByte")
    public void setZtrcreditqrerrorcd(String pZtrcreditqrerrorcd) {
        ztrcreditqrerrorcd = pZtrcreditqrerrorcd;
    }

    private String ztrsyouninno7keta;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRSYOUNINNO7KETA)
    public String getZtrsyouninno7keta() {
        return ztrsyouninno7keta;
    }

    @DataConvert("toSingleByte")
    public void setZtrsyouninno7keta(String pZtrsyouninno7keta) {
        ztrsyouninno7keta = pZtrsyouninno7keta;
    }

    private String ztrbluegateerrorcd;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRBLUEGATEERRORCD)
    public String getZtrbluegateerrorcd() {
        return ztrbluegateerrorcd;
    }

    public void setZtrbluegateerrorcd(String pZtrbluegateerrorcd) {
        ztrbluegateerrorcd = pZtrbluegateerrorcd;
    }

    private String ztrhisimukekaisyacd;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRHISIMUKEKAISYACD)
    public String getZtrhisimukekaisyacd() {
        return ztrhisimukekaisyacd;
    }

    public void setZtrhisimukekaisyacd(String pZtrhisimukekaisyacd) {
        ztrhisimukekaisyacd = pZtrhisimukekaisyacd;
    }

    private String ztrbluegatejyusinymdtime;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRBLUEGATEJYUSINYMDTIME)
    public String getZtrbluegatejyusinymdtime() {
        return ztrbluegatejyusinymdtime;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 14)
    public void setZtrbluegatejyusinymdtime(String pZtrbluegatejyusinymdtime) {
        ztrbluegatejyusinymdtime = pZtrbluegatejyusinymdtime;
    }

    private String ztryobiv160;

    @Column(name=GenZT_SkCreditTourokukekkaQrTr.ZTRYOBIV160)
    public String getZtryobiv160() {
        return ztryobiv160;
    }

    public void setZtryobiv160(String pZtryobiv160) {
        ztryobiv160 = pZtryobiv160;
    }
}