package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.id.PKZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.GenQZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrRn;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SkCreditTourokukekkaQrRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkCreditTourokukekkaQrRn}</td><td colspan="3">新契約クレジットカード登録結果（ＱＲ）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsystemjyusinymd zrnsystemjyusinymd}</td><td>（連携用）システム受信日</td><td align="center">{@link PKZT_SkCreditTourokukekkaQrRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsystemjyusintime zrnsystemjyusintime}</td><td>（連携用）システム受信時刻</td><td align="center">{@link PKZT_SkCreditTourokukekkaQrRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditqrtrkkbn zrncreditqrtrkkbn}</td><td>（連携用）クレジットカードＱＲ登録区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditqrsousinkbn zrncreditqrsousinkbn}</td><td>（連携用）クレジットカードＱＲ送信区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">{@link PKZT_SkCreditTourokukekkaQrRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv34 zrnyobiv34}</td><td>（連携用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkaiinno zrncreditkaiinno}</td><td>（連携用）クレジット会員番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncardyuukoukigen zrncardyuukoukigen}</td><td>（連携用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnauthorigkjyusin zrnauthorigkjyusin}</td><td>（連携用）オーソリ金額（受信）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv153 zrnyobiv153}</td><td>（連携用）予備項目Ｖ１５３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuumonno zrntyuumonno}</td><td>（連携用）注文番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv50 zrnyobiv50}</td><td>（連携用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluegateshopid zrnbluegateshopid}</td><td>（連携用）ＢｌｕｅＧａｔｅショップＩＤ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv81 zrnyobiv81}</td><td>（連携用）予備項目Ｖ８１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkessaisyoriymd zrnkessaisyoriymd}</td><td>（連携用）決済処理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditqrerrorcd zrncreditqrerrorcd}</td><td>（連携用）クレジットカードＱＲエラーコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouninno7keta zrnsyouninno7keta}</td><td>（連携用）承認番号（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluegateerrorcd zrnbluegateerrorcd}</td><td>（連携用）ＢｌｕｅＧａｔｅエラーコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhisimukekaisyacd zrnhisimukekaisyacd}</td><td>（連携用）被仕向会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluegatejyusinymdtime zrnbluegatejyusinymdtime}</td><td>（連携用）ＢｌｕｅＧａｔｅ受付日時</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv160 zrnyobiv160}</td><td>（連携用）予備項目Ｖ１６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkCreditTourokukekkaQrRn
 * @see     PKZT_SkCreditTourokukekkaQrRn
 * @see     QZT_SkCreditTourokukekkaQrRn
 * @see     GenQZT_SkCreditTourokukekkaQrRn
 */
@MappedSuperclass
@Table(name=GenZT_SkCreditTourokukekkaQrRn.TABLE_NAME)
@IdClass(value=PKZT_SkCreditTourokukekkaQrRn.class)
public abstract class GenZT_SkCreditTourokukekkaQrRn extends AbstractExDBEntityForZDB<ZT_SkCreditTourokukekkaQrRn, PKZT_SkCreditTourokukekkaQrRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkCreditTourokukekkaQrRn";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNSYSTEMJYUSINYMD       = "zrnsystemjyusinymd";
    public static final String ZRNSYSTEMJYUSINTIME      = "zrnsystemjyusintime";
    public static final String ZRNCREDITQRTRKKBN        = "zrncreditqrtrkkbn";
    public static final String ZRNCREDITQRSOUSINKBN     = "zrncreditqrsousinkbn";
    public static final String ZRNCREDITKESSAIYOUNO     = "zrncreditkessaiyouno";
    public static final String ZRNYOBIV34               = "zrnyobiv34";
    public static final String ZRNCREDITKAIINNO         = "zrncreditkaiinno";
    public static final String ZRNCARDYUUKOUKIGEN       = "zrncardyuukoukigen";
    public static final String ZRNAUTHORIGKJYUSIN       = "zrnauthorigkjyusin";
    public static final String ZRNYOBIV153              = "zrnyobiv153";
    public static final String ZRNTYUUMONNO             = "zrntyuumonno";
    public static final String ZRNYOBIV50               = "zrnyobiv50";
    public static final String ZRNBLUEGATESHOPID        = "zrnbluegateshopid";
    public static final String ZRNYOBIV81               = "zrnyobiv81";
    public static final String ZRNKESSAISYORIYMD        = "zrnkessaisyoriymd";
    public static final String ZRNYOBIV24               = "zrnyobiv24";
    public static final String ZRNCREDITQRERRORCD       = "zrncreditqrerrorcd";
    public static final String ZRNSYOUNINNO7KETA        = "zrnsyouninno7keta";
    public static final String ZRNBLUEGATEERRORCD       = "zrnbluegateerrorcd";
    public static final String ZRNHISIMUKEKAISYACD      = "zrnhisimukekaisyacd";
    public static final String ZRNBLUEGATEJYUSINYMDTIME = "zrnbluegatejyusinymdtime";
    public static final String ZRNYOBIV160              = "zrnyobiv160";

    private final PKZT_SkCreditTourokukekkaQrRn primaryKey;

    public GenZT_SkCreditTourokukekkaQrRn() {
        primaryKey = new PKZT_SkCreditTourokukekkaQrRn();
    }

    public GenZT_SkCreditTourokukekkaQrRn(
        String pZrnsystemjyusinymd,
        String pZrnsystemjyusintime,
        String pZrncreditkessaiyouno
    ) {
        primaryKey = new PKZT_SkCreditTourokukekkaQrRn(
            pZrnsystemjyusinymd,
            pZrnsystemjyusintime,
            pZrncreditkessaiyouno
        );
    }

    @Transient
    @Override
    public PKZT_SkCreditTourokukekkaQrRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkCreditTourokukekkaQrRn> getMetaClass() {
        return QZT_SkCreditTourokukekkaQrRn.class;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    @Id
    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNSYSTEMJYUSINYMD)
    public String getZrnsystemjyusinymd() {
        return getPrimaryKey().getZrnsystemjyusinymd();
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsystemjyusinymd(String pZrnsystemjyusinymd) {
        getPrimaryKey().setZrnsystemjyusinymd(pZrnsystemjyusinymd);
    }

    @Id
    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNSYSTEMJYUSINTIME)
    public String getZrnsystemjyusintime() {
        return getPrimaryKey().getZrnsystemjyusintime();
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsystemjyusintime(String pZrnsystemjyusintime) {
        getPrimaryKey().setZrnsystemjyusintime(pZrnsystemjyusintime);
    }

    private String zrncreditqrtrkkbn;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNCREDITQRTRKKBN)
    public String getZrncreditqrtrkkbn() {
        return zrncreditqrtrkkbn;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncreditqrtrkkbn(String pZrncreditqrtrkkbn) {
        zrncreditqrtrkkbn = pZrncreditqrtrkkbn;
    }

    private String zrncreditqrsousinkbn;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNCREDITQRSOUSINKBN)
    public String getZrncreditqrsousinkbn() {
        return zrncreditqrsousinkbn;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncreditqrsousinkbn(String pZrncreditqrsousinkbn) {
        zrncreditqrsousinkbn = pZrncreditqrsousinkbn;
    }

    @Id
    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNCREDITKESSAIYOUNO)
    public String getZrncreditkessaiyouno() {
        return getPrimaryKey().getZrncreditkessaiyouno();
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        getPrimaryKey().setZrncreditkessaiyouno(pZrncreditkessaiyouno);
    }

    private String zrnyobiv34;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNYOBIV34)
    public String getZrnyobiv34() {
        return zrnyobiv34;
    }

    public void setZrnyobiv34(String pZrnyobiv34) {
        zrnyobiv34 = pZrnyobiv34;
    }

    private String zrncreditkaiinno;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNCREDITKAIINNO)
    public String getZrncreditkaiinno() {
        return zrncreditkaiinno;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 16)
    public void setZrncreditkaiinno(String pZrncreditkaiinno) {
        zrncreditkaiinno = pZrncreditkaiinno;
    }

    private String zrncardyuukoukigen;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNCARDYUUKOUKIGEN)
    public String getZrncardyuukoukigen() {
        return zrncardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZrncardyuukoukigen(String pZrncardyuukoukigen) {
        zrncardyuukoukigen = pZrncardyuukoukigen;
    }

    private String zrnauthorigkjyusin;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNAUTHORIGKJYUSIN)
    public String getZrnauthorigkjyusin() {
        return zrnauthorigkjyusin;
    }

    @DataConvert("toSingleByte")
    public void setZrnauthorigkjyusin(String pZrnauthorigkjyusin) {
        zrnauthorigkjyusin = pZrnauthorigkjyusin;
    }

    private String zrnyobiv153;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNYOBIV153)
    public String getZrnyobiv153() {
        return zrnyobiv153;
    }

    public void setZrnyobiv153(String pZrnyobiv153) {
        zrnyobiv153 = pZrnyobiv153;
    }

    private String zrntyuumonno;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNTYUUMONNO)
    public String getZrntyuumonno() {
        return zrntyuumonno;
    }

    @DataConvert("toSingleByte")
    public void setZrntyuumonno(String pZrntyuumonno) {
        zrntyuumonno = pZrntyuumonno;
    }

    private String zrnyobiv50;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNYOBIV50)
    public String getZrnyobiv50() {
        return zrnyobiv50;
    }

    public void setZrnyobiv50(String pZrnyobiv50) {
        zrnyobiv50 = pZrnyobiv50;
    }

    private String zrnbluegateshopid;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNBLUEGATESHOPID)
    public String getZrnbluegateshopid() {
        return zrnbluegateshopid;
    }

    @DataConvert("toSingleByte")
    public void setZrnbluegateshopid(String pZrnbluegateshopid) {
        zrnbluegateshopid = pZrnbluegateshopid;
    }

    private String zrnyobiv81;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNYOBIV81)
    public String getZrnyobiv81() {
        return zrnyobiv81;
    }

    public void setZrnyobiv81(String pZrnyobiv81) {
        zrnyobiv81 = pZrnyobiv81;
    }

    private String zrnkessaisyoriymd;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNKESSAISYORIYMD)
    public String getZrnkessaisyoriymd() {
        return zrnkessaisyoriymd;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkessaisyoriymd(String pZrnkessaisyoriymd) {
        zrnkessaisyoriymd = pZrnkessaisyoriymd;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }

    private String zrncreditqrerrorcd;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNCREDITQRERRORCD)
    public String getZrncreditqrerrorcd() {
        return zrncreditqrerrorcd;
    }

    @DataConvert("toSingleByte")
    public void setZrncreditqrerrorcd(String pZrncreditqrerrorcd) {
        zrncreditqrerrorcd = pZrncreditqrerrorcd;
    }

    private String zrnsyouninno7keta;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNSYOUNINNO7KETA)
    public String getZrnsyouninno7keta() {
        return zrnsyouninno7keta;
    }

    @DataConvert("toSingleByte")
    public void setZrnsyouninno7keta(String pZrnsyouninno7keta) {
        zrnsyouninno7keta = pZrnsyouninno7keta;
    }

    private String zrnbluegateerrorcd;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNBLUEGATEERRORCD)
    public String getZrnbluegateerrorcd() {
        return zrnbluegateerrorcd;
    }

    public void setZrnbluegateerrorcd(String pZrnbluegateerrorcd) {
        zrnbluegateerrorcd = pZrnbluegateerrorcd;
    }

    private String zrnhisimukekaisyacd;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNHISIMUKEKAISYACD)
    public String getZrnhisimukekaisyacd() {
        return zrnhisimukekaisyacd;
    }

    public void setZrnhisimukekaisyacd(String pZrnhisimukekaisyacd) {
        zrnhisimukekaisyacd = pZrnhisimukekaisyacd;
    }

    private String zrnbluegatejyusinymdtime;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNBLUEGATEJYUSINYMDTIME)
    public String getZrnbluegatejyusinymdtime() {
        return zrnbluegatejyusinymdtime;
    }

    @DataConvert("toSingleByte")
    @Padding(mode = "left", padChar = '0', length = 14)
    public void setZrnbluegatejyusinymdtime(String pZrnbluegatejyusinymdtime) {
        zrnbluegatejyusinymdtime = pZrnbluegatejyusinymdtime;
    }

    private String zrnyobiv160;

    @Column(name=GenZT_SkCreditTourokukekkaQrRn.ZRNYOBIV160)
    public String getZrnyobiv160() {
        return zrnyobiv160;
    }

    public void setZrnyobiv160(String pZrnyobiv160) {
        zrnyobiv160 = pZrnyobiv160;
    }
}