package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_AuthoriKekkaTr;
import yuyu.def.db.id.PKZT_AuthoriKekkaTr;
import yuyu.def.db.meta.GenQZT_AuthoriKekkaTr;
import yuyu.def.db.meta.QZT_AuthoriKekkaTr;

/**
 * オーソリ結果Ｆテーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_AuthoriKekkaTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AuthoriKekkaTr}</td><td colspan="3">オーソリ結果Ｆテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrrecordkbn ztrrecordkbn}</td><td>（取込用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkaiintourokukbn ztrkaiintourokukbn}</td><td>（取込用）会員登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">{@link PKZT_AuthoriKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv34 ztryobiv34}</td><td>（取込用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcardno ztrcardno}</td><td>（取込用）カード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcardyuukoukigen ztrcardyuukoukigen}</td><td>（取込用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrauthorigkjyusin ztrauthorigkjyusin}</td><td>（取込用）オーソリ金額（受信）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrauthorikekkaerrorcd ztrauthorikekkaerrorcd}</td><td>（取込用）オーソリ結果エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbluegateerrorcd ztrbluegateerrorcd}</td><td>（取込用）ＢｌｕｅＧａｔｅエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv25 ztryobiv25}</td><td>（取込用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhisimukekaisyacd ztrhisimukekaisyacd}</td><td>（取込用）被仕向会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv5 ztryobiv5}</td><td>（取込用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrwentryuserid ztrwentryuserid}</td><td>（取込用）ＷエントリユーザＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrerrorcomment ztrerrorcomment}</td><td>（取込用）エラーコメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrniniinfo ztrniniinfo}</td><td>（取込用）任意情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrskjkssityuumonno ztrskjkssityuumonno}</td><td>（取込用）即時決済注文番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrskjkssiauthorigk ztrskjkssiauthorigk}</td><td>（取込用）即時決済オーソリ金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrskjkssiyosinkekka ztrskjkssiyosinkekka}</td><td>（取込用）即時決済与信結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrskjkssibunruikbn ztrskjkssibunruikbn}</td><td>（取込用）即時決済分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatasyorijyoukyou ztrdatasyorijyoukyou}</td><td>（取込用）データ処理状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatajyusinymd ztrdatajyusinymd}</td><td>（取込用）データ受信日</td><td align="center">{@link PKZT_AuthoriKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv25x2 ztryobiv25x2}</td><td>（取込用）予備項目Ｖ２５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenno7 ztrrenno7}</td><td>（取込用）連番７桁</td><td align="center">{@link PKZT_AuthoriKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv33 ztryobiv33}</td><td>（取込用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_AuthoriKekkaTr
 * @see     PKZT_AuthoriKekkaTr
 * @see     QZT_AuthoriKekkaTr
 * @see     GenQZT_AuthoriKekkaTr
 */
@MappedSuperclass
@Table(name=GenZT_AuthoriKekkaTr.TABLE_NAME)
@IdClass(value=PKZT_AuthoriKekkaTr.class)
public abstract class GenZT_AuthoriKekkaTr extends AbstractExDBEntity<ZT_AuthoriKekkaTr, PKZT_AuthoriKekkaTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_AuthoriKekkaTr";
    public static final String ZTRRECORDKBN             = "ztrrecordkbn";
    public static final String ZTRKAIINTOUROKUKBN       = "ztrkaiintourokukbn";
    public static final String ZTRCREDITKESSAIYOUNO     = "ztrcreditkessaiyouno";
    public static final String ZTRYOBIV34               = "ztryobiv34";
    public static final String ZTRCARDNO                = "ztrcardno";
    public static final String ZTRCARDYUUKOUKIGEN       = "ztrcardyuukoukigen";
    public static final String ZTRAUTHORIGKJYUSIN       = "ztrauthorigkjyusin";
    public static final String ZTRAUTHORIKEKKAERRORCD   = "ztrauthorikekkaerrorcd";
    public static final String ZTRBLUEGATEERRORCD       = "ztrbluegateerrorcd";
    public static final String ZTRYOBIV25               = "ztryobiv25";
    public static final String ZTRHISIMUKEKAISYACD      = "ztrhisimukekaisyacd";
    public static final String ZTRYOBIV5                = "ztryobiv5";
    public static final String ZTRWENTRYUSERID          = "ztrwentryuserid";
    public static final String ZTRERRORCOMMENT          = "ztrerrorcomment";
    public static final String ZTRNINIINFO              = "ztrniniinfo";
    public static final String ZTRSKJKSSITYUUMONNO      = "ztrskjkssityuumonno";
    public static final String ZTRSKJKSSIAUTHORIGK      = "ztrskjkssiauthorigk";
    public static final String ZTRSKJKSSIYOSINKEKKA     = "ztrskjkssiyosinkekka";
    public static final String ZTRSKJKSSIBUNRUIKBN      = "ztrskjkssibunruikbn";
    public static final String ZTRDATASYORIJYOUKYOU     = "ztrdatasyorijyoukyou";
    public static final String ZTRDATAJYUSINYMD         = "ztrdatajyusinymd";
    public static final String ZTRYOBIV25X2             = "ztryobiv25x2";
    public static final String ZTRRENNO7                = "ztrrenno7";
    public static final String ZTRYOBIV33               = "ztryobiv33";

    private final PKZT_AuthoriKekkaTr primaryKey;

    public GenZT_AuthoriKekkaTr() {
        primaryKey = new PKZT_AuthoriKekkaTr();
    }

    public GenZT_AuthoriKekkaTr(
        String pZtrrenno7,
        String pZtrcreditkessaiyouno,
        String pZtrdatajyusinymd
    ) {
        primaryKey = new PKZT_AuthoriKekkaTr(
            pZtrrenno7,
            pZtrcreditkessaiyouno,
            pZtrdatajyusinymd
        );
    }

    @Transient
    @Override
    public PKZT_AuthoriKekkaTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_AuthoriKekkaTr> getMetaClass() {
        return QZT_AuthoriKekkaTr.class;
    }

    private String ztrrecordkbn;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRRECORDKBN)
    public String getZtrrecordkbn() {
        return ztrrecordkbn;
    }

    @DataConvert("toSingleByte")
    public void setZtrrecordkbn(String pZtrrecordkbn) {
        ztrrecordkbn = pZtrrecordkbn;
    }

    private String ztrkaiintourokukbn;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRKAIINTOUROKUKBN)
    public String getZtrkaiintourokukbn() {
        return ztrkaiintourokukbn;
    }

    public void setZtrkaiintourokukbn(String pZtrkaiintourokukbn) {
        ztrkaiintourokukbn = pZtrkaiintourokukbn;
    }

    @Id
    @Column(name=GenZT_AuthoriKekkaTr.ZTRCREDITKESSAIYOUNO)
    public String getZtrcreditkessaiyouno() {
        return getPrimaryKey().getZtrcreditkessaiyouno();
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        getPrimaryKey().setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
    }

    private String ztryobiv34;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRYOBIV34)
    public String getZtryobiv34() {
        return ztryobiv34;
    }

    public void setZtryobiv34(String pZtryobiv34) {
        ztryobiv34 = pZtryobiv34;
    }

    private String ztrcardno;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRCARDNO)
    public String getZtrcardno() {
        return ztrcardno;
    }

    public void setZtrcardno(String pZtrcardno) {
        ztrcardno = pZtrcardno;
    }

    private String ztrcardyuukoukigen;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRCARDYUUKOUKIGEN)
    public String getZtrcardyuukoukigen() {
        return ztrcardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZtrcardyuukoukigen(String pZtrcardyuukoukigen) {
        ztrcardyuukoukigen = pZtrcardyuukoukigen;
    }

    private String ztrauthorigkjyusin;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRAUTHORIGKJYUSIN)
    public String getZtrauthorigkjyusin() {
        return ztrauthorigkjyusin;
    }

    @DataConvert("toSingleByte")
    public void setZtrauthorigkjyusin(String pZtrauthorigkjyusin) {
        ztrauthorigkjyusin = pZtrauthorigkjyusin;
    }

    private String ztrauthorikekkaerrorcd;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRAUTHORIKEKKAERRORCD)
    public String getZtrauthorikekkaerrorcd() {
        return ztrauthorikekkaerrorcd;
    }

    public void setZtrauthorikekkaerrorcd(String pZtrauthorikekkaerrorcd) {
        ztrauthorikekkaerrorcd = pZtrauthorikekkaerrorcd;
    }

    private String ztrbluegateerrorcd;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRBLUEGATEERRORCD)
    public String getZtrbluegateerrorcd() {
        return ztrbluegateerrorcd;
    }

    public void setZtrbluegateerrorcd(String pZtrbluegateerrorcd) {
        ztrbluegateerrorcd = pZtrbluegateerrorcd;
    }

    private String ztryobiv25;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRYOBIV25)
    public String getZtryobiv25() {
        return ztryobiv25;
    }

    public void setZtryobiv25(String pZtryobiv25) {
        ztryobiv25 = pZtryobiv25;
    }

    private String ztrhisimukekaisyacd;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRHISIMUKEKAISYACD)
    public String getZtrhisimukekaisyacd() {
        return ztrhisimukekaisyacd;
    }

    public void setZtrhisimukekaisyacd(String pZtrhisimukekaisyacd) {
        ztrhisimukekaisyacd = pZtrhisimukekaisyacd;
    }

    private String ztryobiv5;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRYOBIV5)
    public String getZtryobiv5() {
        return ztryobiv5;
    }

    public void setZtryobiv5(String pZtryobiv5) {
        ztryobiv5 = pZtryobiv5;
    }

    private String ztrwentryuserid;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRWENTRYUSERID)
    public String getZtrwentryuserid() {
        return ztrwentryuserid;
    }

    public void setZtrwentryuserid(String pZtrwentryuserid) {
        ztrwentryuserid = pZtrwentryuserid;
    }

    private String ztrerrorcomment;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRERRORCOMMENT)
    public String getZtrerrorcomment() {
        return ztrerrorcomment;
    }

    public void setZtrerrorcomment(String pZtrerrorcomment) {
        ztrerrorcomment = pZtrerrorcomment;
    }

    private String ztrniniinfo;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRNINIINFO)
    public String getZtrniniinfo() {
        return ztrniniinfo;
    }

    public void setZtrniniinfo(String pZtrniniinfo) {
        ztrniniinfo = pZtrniniinfo;
    }

    private String ztrskjkssityuumonno;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRSKJKSSITYUUMONNO)
    public String getZtrskjkssityuumonno() {
        return ztrskjkssityuumonno;
    }

    public void setZtrskjkssityuumonno(String pZtrskjkssityuumonno) {
        ztrskjkssityuumonno = pZtrskjkssityuumonno;
    }

    private String ztrskjkssiauthorigk;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRSKJKSSIAUTHORIGK)
    public String getZtrskjkssiauthorigk() {
        return ztrskjkssiauthorigk;
    }

    public void setZtrskjkssiauthorigk(String pZtrskjkssiauthorigk) {
        ztrskjkssiauthorigk = pZtrskjkssiauthorigk;
    }

    private String ztrskjkssiyosinkekka;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRSKJKSSIYOSINKEKKA)
    public String getZtrskjkssiyosinkekka() {
        return ztrskjkssiyosinkekka;
    }

    public void setZtrskjkssiyosinkekka(String pZtrskjkssiyosinkekka) {
        ztrskjkssiyosinkekka = pZtrskjkssiyosinkekka;
    }

    private String ztrskjkssibunruikbn;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRSKJKSSIBUNRUIKBN)
    public String getZtrskjkssibunruikbn() {
        return ztrskjkssibunruikbn;
    }

    public void setZtrskjkssibunruikbn(String pZtrskjkssibunruikbn) {
        ztrskjkssibunruikbn = pZtrskjkssibunruikbn;
    }

    private String ztrdatasyorijyoukyou;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRDATASYORIJYOUKYOU)
    public String getZtrdatasyorijyoukyou() {
        return ztrdatasyorijyoukyou;
    }

    public void setZtrdatasyorijyoukyou(String pZtrdatasyorijyoukyou) {
        ztrdatasyorijyoukyou = pZtrdatasyorijyoukyou;
    }

    @Id
    @Column(name=GenZT_AuthoriKekkaTr.ZTRDATAJYUSINYMD)
    public String getZtrdatajyusinymd() {
        return getPrimaryKey().getZtrdatajyusinymd();
    }

    public void setZtrdatajyusinymd(String pZtrdatajyusinymd) {
        getPrimaryKey().setZtrdatajyusinymd(pZtrdatajyusinymd);
    }

    private String ztryobiv25x2;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRYOBIV25X2)
    public String getZtryobiv25x2() {
        return ztryobiv25x2;
    }

    public void setZtryobiv25x2(String pZtryobiv25x2) {
        ztryobiv25x2 = pZtryobiv25x2;
    }

    @Id
    @Column(name=GenZT_AuthoriKekkaTr.ZTRRENNO7)
    public String getZtrrenno7() {
        return getPrimaryKey().getZtrrenno7();
    }

    public void setZtrrenno7(String pZtrrenno7) {
        getPrimaryKey().setZtrrenno7(pZtrrenno7);
    }

    private String ztryobiv33;

    @Column(name=GenZT_AuthoriKekkaTr.ZTRYOBIV33)
    public String getZtryobiv33() {
        return ztryobiv33;
    }

    public void setZtryobiv33(String pZtryobiv33) {
        ztryobiv33 = pZtryobiv33;
    }
}