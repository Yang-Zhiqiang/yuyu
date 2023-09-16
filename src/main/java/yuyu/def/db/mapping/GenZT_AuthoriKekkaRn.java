package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_AuthoriKekkaRn;
import yuyu.def.db.id.PKZT_AuthoriKekkaRn;
import yuyu.def.db.meta.GenQZT_AuthoriKekkaRn;
import yuyu.def.db.meta.QZT_AuthoriKekkaRn;

/**
 * オーソリ結果Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_AuthoriKekkaRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AuthoriKekkaRn}</td><td colspan="3">オーソリ結果Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiintourokukbn zrnkaiintourokukbn}</td><td>（連携用）会員登録区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">{@link PKZT_AuthoriKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv34 zrnyobiv34}</td><td>（連携用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncardno zrncardno}</td><td>（連携用）カード番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncardyuukoukigen zrncardyuukoukigen}</td><td>（連携用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnauthorigkjyusin zrnauthorigkjyusin}</td><td>（連携用）オーソリ金額（受信）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnauthorikekkaerrorcd zrnauthorikekkaerrorcd}</td><td>（連携用）オーソリ結果エラーコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluegateerrorcd zrnbluegateerrorcd}</td><td>（連携用）ＢｌｕｅＧａｔｅエラーコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv25 zrnyobiv25}</td><td>（連携用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhisimukekaisyacd zrnhisimukekaisyacd}</td><td>（連携用）被仕向会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwentryuserid zrnwentryuserid}</td><td>（連携用）ＷエントリユーザＩＤ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnerrorcomment zrnerrorcomment}</td><td>（連携用）エラーコメント</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnniniinfo zrnniniinfo}</td><td>（連携用）任意情報</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskjkssityuumonno zrnskjkssityuumonno}</td><td>（連携用）即時決済注文番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskjkssiauthorigk zrnskjkssiauthorigk}</td><td>（連携用）即時決済オーソリ金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskjkssiyosinkekka zrnskjkssiyosinkekka}</td><td>（連携用）即時決済与信結果</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskjkssibunruikbn zrnskjkssibunruikbn}</td><td>（連携用）即時決済分類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatasyorijyoukyou zrndatasyorijyoukyou}</td><td>（連携用）データ処理状況</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatajyusinymd zrndatajyusinymd}</td><td>（連携用）データ受信日</td><td align="center">{@link PKZT_AuthoriKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv25x2 zrnyobiv25x2}</td><td>（連携用）予備項目Ｖ２５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenno7 zrnrenno7}</td><td>（連携用）連番７桁</td><td align="center">{@link PKZT_AuthoriKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv33 zrnyobiv33}</td><td>（連携用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_AuthoriKekkaRn
 * @see     PKZT_AuthoriKekkaRn
 * @see     QZT_AuthoriKekkaRn
 * @see     GenQZT_AuthoriKekkaRn
 */
@MappedSuperclass
@Table(name=GenZT_AuthoriKekkaRn.TABLE_NAME)
@IdClass(value=PKZT_AuthoriKekkaRn.class)
public abstract class GenZT_AuthoriKekkaRn extends AbstractExDBEntityForZDB<ZT_AuthoriKekkaRn, PKZT_AuthoriKekkaRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_AuthoriKekkaRn";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNKAIINTOUROKUKBN       = "zrnkaiintourokukbn";
    public static final String ZRNCREDITKESSAIYOUNO     = "zrncreditkessaiyouno";
    public static final String ZRNYOBIV34               = "zrnyobiv34";
    public static final String ZRNCARDNO                = "zrncardno";
    public static final String ZRNCARDYUUKOUKIGEN       = "zrncardyuukoukigen";
    public static final String ZRNAUTHORIGKJYUSIN       = "zrnauthorigkjyusin";
    public static final String ZRNAUTHORIKEKKAERRORCD   = "zrnauthorikekkaerrorcd";
    public static final String ZRNBLUEGATEERRORCD       = "zrnbluegateerrorcd";
    public static final String ZRNYOBIV25               = "zrnyobiv25";
    public static final String ZRNHISIMUKEKAISYACD      = "zrnhisimukekaisyacd";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
    public static final String ZRNWENTRYUSERID          = "zrnwentryuserid";
    public static final String ZRNERRORCOMMENT          = "zrnerrorcomment";
    public static final String ZRNNINIINFO              = "zrnniniinfo";
    public static final String ZRNSKJKSSITYUUMONNO      = "zrnskjkssityuumonno";
    public static final String ZRNSKJKSSIAUTHORIGK      = "zrnskjkssiauthorigk";
    public static final String ZRNSKJKSSIYOSINKEKKA     = "zrnskjkssiyosinkekka";
    public static final String ZRNSKJKSSIBUNRUIKBN      = "zrnskjkssibunruikbn";
    public static final String ZRNDATASYORIJYOUKYOU     = "zrndatasyorijyoukyou";
    public static final String ZRNDATAJYUSINYMD         = "zrndatajyusinymd";
    public static final String ZRNYOBIV25X2             = "zrnyobiv25x2";
    public static final String ZRNRENNO7                = "zrnrenno7";
    public static final String ZRNYOBIV33               = "zrnyobiv33";

    private final PKZT_AuthoriKekkaRn primaryKey;

    public GenZT_AuthoriKekkaRn() {
        primaryKey = new PKZT_AuthoriKekkaRn();
    }

    public GenZT_AuthoriKekkaRn(
        String pZrnrenno7,
        String pZrncreditkessaiyouno,
        String pZrndatajyusinymd
    ) {
        primaryKey = new PKZT_AuthoriKekkaRn(
            pZrnrenno7,
            pZrncreditkessaiyouno,
            pZrndatajyusinymd
        );
    }

    @Transient
    @Override
    public PKZT_AuthoriKekkaRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_AuthoriKekkaRn> getMetaClass() {
        return QZT_AuthoriKekkaRn.class;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrnkaiintourokukbn;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNKAIINTOUROKUKBN)
    public String getZrnkaiintourokukbn() {
        return zrnkaiintourokukbn;
    }

    public void setZrnkaiintourokukbn(String pZrnkaiintourokukbn) {
        zrnkaiintourokukbn = pZrnkaiintourokukbn;
    }

    @Id
    @Column(name=GenZT_AuthoriKekkaRn.ZRNCREDITKESSAIYOUNO)
    public String getZrncreditkessaiyouno() {
        return getPrimaryKey().getZrncreditkessaiyouno();
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        getPrimaryKey().setZrncreditkessaiyouno(pZrncreditkessaiyouno);
    }

    private String zrnyobiv34;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNYOBIV34)
    public String getZrnyobiv34() {
        return zrnyobiv34;
    }

    public void setZrnyobiv34(String pZrnyobiv34) {
        zrnyobiv34 = pZrnyobiv34;
    }

    private String zrncardno;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNCARDNO)
    public String getZrncardno() {
        return zrncardno;
    }

    public void setZrncardno(String pZrncardno) {
        zrncardno = pZrncardno;
    }

    private String zrncardyuukoukigen;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNCARDYUUKOUKIGEN)
    public String getZrncardyuukoukigen() {
        return zrncardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZrncardyuukoukigen(String pZrncardyuukoukigen) {
        zrncardyuukoukigen = pZrncardyuukoukigen;
    }

    private String zrnauthorigkjyusin;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNAUTHORIGKJYUSIN)
    public String getZrnauthorigkjyusin() {
        return zrnauthorigkjyusin;
    }

    @DataConvert("toSingleByte")
    public void setZrnauthorigkjyusin(String pZrnauthorigkjyusin) {
        zrnauthorigkjyusin = pZrnauthorigkjyusin;
    }

    private String zrnauthorikekkaerrorcd;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNAUTHORIKEKKAERRORCD)
    public String getZrnauthorikekkaerrorcd() {
        return zrnauthorikekkaerrorcd;
    }

    public void setZrnauthorikekkaerrorcd(String pZrnauthorikekkaerrorcd) {
        zrnauthorikekkaerrorcd = pZrnauthorikekkaerrorcd;
    }

    private String zrnbluegateerrorcd;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNBLUEGATEERRORCD)
    public String getZrnbluegateerrorcd() {
        return zrnbluegateerrorcd;
    }

    public void setZrnbluegateerrorcd(String pZrnbluegateerrorcd) {
        zrnbluegateerrorcd = pZrnbluegateerrorcd;
    }

    private String zrnyobiv25;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNYOBIV25)
    public String getZrnyobiv25() {
        return zrnyobiv25;
    }

    public void setZrnyobiv25(String pZrnyobiv25) {
        zrnyobiv25 = pZrnyobiv25;
    }

    private String zrnhisimukekaisyacd;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNHISIMUKEKAISYACD)
    public String getZrnhisimukekaisyacd() {
        return zrnhisimukekaisyacd;
    }

    public void setZrnhisimukekaisyacd(String pZrnhisimukekaisyacd) {
        zrnhisimukekaisyacd = pZrnhisimukekaisyacd;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private String zrnwentryuserid;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNWENTRYUSERID)
    public String getZrnwentryuserid() {
        return zrnwentryuserid;
    }

    public void setZrnwentryuserid(String pZrnwentryuserid) {
        zrnwentryuserid = pZrnwentryuserid;
    }

    private String zrnerrorcomment;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNERRORCOMMENT)
    public String getZrnerrorcomment() {
        return zrnerrorcomment;
    }

    public void setZrnerrorcomment(String pZrnerrorcomment) {
        zrnerrorcomment = pZrnerrorcomment;
    }

    private String zrnniniinfo;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNNINIINFO)
    public String getZrnniniinfo() {
        return zrnniniinfo;
    }

    public void setZrnniniinfo(String pZrnniniinfo) {
        zrnniniinfo = pZrnniniinfo;
    }

    private String zrnskjkssityuumonno;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNSKJKSSITYUUMONNO)
    public String getZrnskjkssityuumonno() {
        return zrnskjkssityuumonno;
    }

    public void setZrnskjkssityuumonno(String pZrnskjkssityuumonno) {
        zrnskjkssityuumonno = pZrnskjkssityuumonno;
    }

    private String zrnskjkssiauthorigk;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNSKJKSSIAUTHORIGK)
    public String getZrnskjkssiauthorigk() {
        return zrnskjkssiauthorigk;
    }

    public void setZrnskjkssiauthorigk(String pZrnskjkssiauthorigk) {
        zrnskjkssiauthorigk = pZrnskjkssiauthorigk;
    }

    private String zrnskjkssiyosinkekka;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNSKJKSSIYOSINKEKKA)
    public String getZrnskjkssiyosinkekka() {
        return zrnskjkssiyosinkekka;
    }

    public void setZrnskjkssiyosinkekka(String pZrnskjkssiyosinkekka) {
        zrnskjkssiyosinkekka = pZrnskjkssiyosinkekka;
    }

    private String zrnskjkssibunruikbn;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNSKJKSSIBUNRUIKBN)
    public String getZrnskjkssibunruikbn() {
        return zrnskjkssibunruikbn;
    }

    public void setZrnskjkssibunruikbn(String pZrnskjkssibunruikbn) {
        zrnskjkssibunruikbn = pZrnskjkssibunruikbn;
    }

    private String zrndatasyorijyoukyou;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNDATASYORIJYOUKYOU)
    public String getZrndatasyorijyoukyou() {
        return zrndatasyorijyoukyou;
    }

    public void setZrndatasyorijyoukyou(String pZrndatasyorijyoukyou) {
        zrndatasyorijyoukyou = pZrndatasyorijyoukyou;
    }

    @Id
    @Column(name=GenZT_AuthoriKekkaRn.ZRNDATAJYUSINYMD)
    public String getZrndatajyusinymd() {
        return getPrimaryKey().getZrndatajyusinymd();
    }

    public void setZrndatajyusinymd(String pZrndatajyusinymd) {
        getPrimaryKey().setZrndatajyusinymd(pZrndatajyusinymd);
    }

    private String zrnyobiv25x2;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNYOBIV25X2)
    public String getZrnyobiv25x2() {
        return zrnyobiv25x2;
    }

    public void setZrnyobiv25x2(String pZrnyobiv25x2) {
        zrnyobiv25x2 = pZrnyobiv25x2;
    }

    @Id
    @Column(name=GenZT_AuthoriKekkaRn.ZRNRENNO7)
    public String getZrnrenno7() {
        return getPrimaryKey().getZrnrenno7();
    }

    public void setZrnrenno7(String pZrnrenno7) {
        getPrimaryKey().setZrnrenno7(pZrnrenno7);
    }

    private String zrnyobiv33;

    @Column(name=GenZT_AuthoriKekkaRn.ZRNYOBIV33)
    public String getZrnyobiv33() {
        return zrnyobiv33;
    }

    public void setZrnyobiv33(String pZrnyobiv33) {
        zrnyobiv33 = pZrnyobiv33;
    }
}