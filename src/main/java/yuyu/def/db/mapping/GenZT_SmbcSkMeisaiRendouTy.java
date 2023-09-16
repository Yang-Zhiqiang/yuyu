package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.id.PKZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.GenQZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouTy;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SmbcSkMeisaiRendouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcSkMeisaiRendouTy}</td><td colspan="3">ＳＭＢＣ扱新契約明細連動テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysmbcdatakbn ztysmbcdatakbn}</td><td>（中継用）ＳＭＢＣ＿データ区分</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcdatasakuseiymd ztysmbcdatasakuseiymd}</td><td>（中継用）ＳＭＢＣ＿データ作成日</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbchknkaisyacd ztysmbchknkaisyacd}</td><td>（中継用）ＳＭＢＣ＿保険会社コード</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcuktkkanriid ztysmbcuktkkanriid}</td><td>（中継用）ＳＭＢＣ＿受付管理ＩＤ</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihouktkzmymd ztysmbcseihouktkzmymd}</td><td>（中継用）ＳＭＢＣ＿生保受付済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihohbymd ztysmbcseihohbymd}</td><td>（中継用）ＳＭＢＣ＿生保不備ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcbankhnkykflg ztysmbcbankhnkykflg}</td><td>（中継用）ＳＭＢＣ＿銀行返却フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihohbksyymd ztysmbcseihohbksyymd}</td><td>（中継用）ＳＭＢＣ＿生保不備解消ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihohjyttykymd ztysmbcseihohjyttykymd}</td><td>（中継用）ＳＭＢＣ＿生保報状到着ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihonyknzmymd ztysmbcseihonyknzmymd}</td><td>（中継用）ＳＭＢＣ＿生保入金済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihosnszmymd ztysmbcseihosnszmymd}</td><td>（中継用）ＳＭＢＣ＿生保審査済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihosyknhkkzmymd ztysmbcseihosyknhkkzmymd}</td><td>（中継用）ＳＭＢＣ＿生保証券発行済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihosyumoku ztysmbcseihosyumoku}</td><td>（中継用）ＳＭＢＣ＿生保種目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihosyurui ztysmbcseihosyurui}</td><td>（中継用）ＳＭＢＣ＿生保種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcsyono ztysmbcsyono}</td><td>（中継用）ＳＭＢＣ＿証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcsyonoedaban ztysmbcsyonoedaban}</td><td>（中継用）ＳＭＢＣ＿証券番号枝番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcjktkflg ztysmbcjktkflg}</td><td>（中継用）ＳＭＢＣ＿条件付フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihotrksymd ztysmbcseihotrksymd}</td><td>（中継用）ＳＭＢＣ＿生保取消ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcseihohktymd ztysmbcseihohktymd}</td><td>（中継用）ＳＭＢＣ＿生保否決ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbckykseiymd ztysmbckykseiymd}</td><td>（中継用）ＳＭＢＣ＿契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbckyknmkn ztysmbckyknmkn}</td><td>（中継用）ＳＭＢＣ＿契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcmosuktymd ztysmbcmosuktymd}</td><td>（中継用）ＳＭＢＣ＿申込書受付ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbcmossyoriflg ztysmbcmossyoriflg}</td><td>（中継用）ＳＭＢＣ＿申込処理フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysmbckosyaareastyknr ztysmbckosyaareastyknr}</td><td>（中継用）ＳＭＢＣ＿個社領域（進捗管理）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv60 ztyyobiv60}</td><td>（中継用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcSkMeisaiRendouTy
 * @see     PKZT_SmbcSkMeisaiRendouTy
 * @see     QZT_SmbcSkMeisaiRendouTy
 * @see     GenQZT_SmbcSkMeisaiRendouTy
 */
@MappedSuperclass
@Table(name=GenZT_SmbcSkMeisaiRendouTy.TABLE_NAME)
@IdClass(value=PKZT_SmbcSkMeisaiRendouTy.class)
public abstract class GenZT_SmbcSkMeisaiRendouTy extends AbstractExDBEntity<ZT_SmbcSkMeisaiRendouTy, PKZT_SmbcSkMeisaiRendouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SmbcSkMeisaiRendouTy";
    public static final String ZTYSMBCDATAKBN           = "ztysmbcdatakbn";
    public static final String ZTYSMBCDATASAKUSEIYMD    = "ztysmbcdatasakuseiymd";
    public static final String ZTYSMBCHKNKAISYACD       = "ztysmbchknkaisyacd";
    public static final String ZTYSMBCUKTKKANRIID       = "ztysmbcuktkkanriid";
    public static final String ZTYSMBCSEIHOUKTKZMYMD    = "ztysmbcseihouktkzmymd";
    public static final String ZTYSMBCSEIHOHBYMD        = "ztysmbcseihohbymd";
    public static final String ZTYSMBCBANKHNKYKFLG      = "ztysmbcbankhnkykflg";
    public static final String ZTYSMBCSEIHOHBKSYYMD     = "ztysmbcseihohbksyymd";
    public static final String ZTYSMBCSEIHOHJYTTYKYMD   = "ztysmbcseihohjyttykymd";
    public static final String ZTYSMBCSEIHONYKNZMYMD    = "ztysmbcseihonyknzmymd";
    public static final String ZTYSMBCSEIHOSNSZMYMD     = "ztysmbcseihosnszmymd";
    public static final String ZTYSMBCSEIHOSYKNHKKZMYMD = "ztysmbcseihosyknhkkzmymd";
    public static final String ZTYSMBCSEIHOSYUMOKU      = "ztysmbcseihosyumoku";
    public static final String ZTYSMBCSEIHOSYURUI       = "ztysmbcseihosyurui";
    public static final String ZTYSMBCSYONO             = "ztysmbcsyono";
    public static final String ZTYSMBCSYONOEDABAN       = "ztysmbcsyonoedaban";
    public static final String ZTYSMBCJKTKFLG           = "ztysmbcjktkflg";
    public static final String ZTYSMBCSEIHOTRKSYMD      = "ztysmbcseihotrksymd";
    public static final String ZTYSMBCSEIHOHKTYMD       = "ztysmbcseihohktymd";
    public static final String ZTYSMBCKYKSEIYMD         = "ztysmbckykseiymd";
    public static final String ZTYSMBCKYKNMKN           = "ztysmbckyknmkn";
    public static final String ZTYSMBCMOSUKTYMD         = "ztysmbcmosuktymd";
    public static final String ZTYSMBCMOSSYORIFLG       = "ztysmbcmossyoriflg";
    public static final String ZTYSMBCKOSYAAREASTYKNR   = "ztysmbckosyaareastyknr";
    public static final String ZTYYOBIV60               = "ztyyobiv60";

    private final PKZT_SmbcSkMeisaiRendouTy primaryKey;

    public GenZT_SmbcSkMeisaiRendouTy() {
        primaryKey = new PKZT_SmbcSkMeisaiRendouTy();
    }

    public GenZT_SmbcSkMeisaiRendouTy(
        String pZtysmbcdatakbn,
        String pZtysmbcdatasakuseiymd,
        String pZtysmbchknkaisyacd,
        String pZtysmbcuktkkanriid
    ) {
        primaryKey = new PKZT_SmbcSkMeisaiRendouTy(
            pZtysmbcdatakbn,
            pZtysmbcdatasakuseiymd,
            pZtysmbchknkaisyacd,
            pZtysmbcuktkkanriid
        );
    }

    @Transient
    @Override
    public PKZT_SmbcSkMeisaiRendouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SmbcSkMeisaiRendouTy> getMetaClass() {
        return QZT_SmbcSkMeisaiRendouTy.class;
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCDATAKBN)
    public String getZtysmbcdatakbn() {
        return getPrimaryKey().getZtysmbcdatakbn();
    }

    public void setZtysmbcdatakbn(String pZtysmbcdatakbn) {
        getPrimaryKey().setZtysmbcdatakbn(pZtysmbcdatakbn);
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCDATASAKUSEIYMD)
    public String getZtysmbcdatasakuseiymd() {
        return getPrimaryKey().getZtysmbcdatasakuseiymd();
    }

    public void setZtysmbcdatasakuseiymd(String pZtysmbcdatasakuseiymd) {
        getPrimaryKey().setZtysmbcdatasakuseiymd(pZtysmbcdatasakuseiymd);
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCHKNKAISYACD)
    public String getZtysmbchknkaisyacd() {
        return getPrimaryKey().getZtysmbchknkaisyacd();
    }

    public void setZtysmbchknkaisyacd(String pZtysmbchknkaisyacd) {
        getPrimaryKey().setZtysmbchknkaisyacd(pZtysmbchknkaisyacd);
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCUKTKKANRIID)
    public String getZtysmbcuktkkanriid() {
        return getPrimaryKey().getZtysmbcuktkkanriid();
    }

    public void setZtysmbcuktkkanriid(String pZtysmbcuktkkanriid) {
        getPrimaryKey().setZtysmbcuktkkanriid(pZtysmbcuktkkanriid);
    }

    private String ztysmbcseihouktkzmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOUKTKZMYMD)
    public String getZtysmbcseihouktkzmymd() {
        return ztysmbcseihouktkzmymd;
    }

    public void setZtysmbcseihouktkzmymd(String pZtysmbcseihouktkzmymd) {
        ztysmbcseihouktkzmymd = pZtysmbcseihouktkzmymd;
    }

    private String ztysmbcseihohbymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOHBYMD)
    public String getZtysmbcseihohbymd() {
        return ztysmbcseihohbymd;
    }

    public void setZtysmbcseihohbymd(String pZtysmbcseihohbymd) {
        ztysmbcseihohbymd = pZtysmbcseihohbymd;
    }

    private String ztysmbcbankhnkykflg;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCBANKHNKYKFLG)
    public String getZtysmbcbankhnkykflg() {
        return ztysmbcbankhnkykflg;
    }

    public void setZtysmbcbankhnkykflg(String pZtysmbcbankhnkykflg) {
        ztysmbcbankhnkykflg = pZtysmbcbankhnkykflg;
    }

    private String ztysmbcseihohbksyymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOHBKSYYMD)
    public String getZtysmbcseihohbksyymd() {
        return ztysmbcseihohbksyymd;
    }

    public void setZtysmbcseihohbksyymd(String pZtysmbcseihohbksyymd) {
        ztysmbcseihohbksyymd = pZtysmbcseihohbksyymd;
    }

    private String ztysmbcseihohjyttykymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOHJYTTYKYMD)
    public String getZtysmbcseihohjyttykymd() {
        return ztysmbcseihohjyttykymd;
    }

    public void setZtysmbcseihohjyttykymd(String pZtysmbcseihohjyttykymd) {
        ztysmbcseihohjyttykymd = pZtysmbcseihohjyttykymd;
    }

    private String ztysmbcseihonyknzmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHONYKNZMYMD)
    public String getZtysmbcseihonyknzmymd() {
        return ztysmbcseihonyknzmymd;
    }

    public void setZtysmbcseihonyknzmymd(String pZtysmbcseihonyknzmymd) {
        ztysmbcseihonyknzmymd = pZtysmbcseihonyknzmymd;
    }

    private String ztysmbcseihosnszmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOSNSZMYMD)
    public String getZtysmbcseihosnszmymd() {
        return ztysmbcseihosnszmymd;
    }

    public void setZtysmbcseihosnszmymd(String pZtysmbcseihosnszmymd) {
        ztysmbcseihosnszmymd = pZtysmbcseihosnszmymd;
    }

    private String ztysmbcseihosyknhkkzmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOSYKNHKKZMYMD)
    public String getZtysmbcseihosyknhkkzmymd() {
        return ztysmbcseihosyknhkkzmymd;
    }

    public void setZtysmbcseihosyknhkkzmymd(String pZtysmbcseihosyknhkkzmymd) {
        ztysmbcseihosyknhkkzmymd = pZtysmbcseihosyknhkkzmymd;
    }

    private String ztysmbcseihosyumoku;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOSYUMOKU)
    public String getZtysmbcseihosyumoku() {
        return ztysmbcseihosyumoku;
    }

    public void setZtysmbcseihosyumoku(String pZtysmbcseihosyumoku) {
        ztysmbcseihosyumoku = pZtysmbcseihosyumoku;
    }

    private String ztysmbcseihosyurui;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOSYURUI)
    public String getZtysmbcseihosyurui() {
        return ztysmbcseihosyurui;
    }

    public void setZtysmbcseihosyurui(String pZtysmbcseihosyurui) {
        ztysmbcseihosyurui = pZtysmbcseihosyurui;
    }

    private String ztysmbcsyono;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSYONO)
    public String getZtysmbcsyono() {
        return ztysmbcsyono;
    }

    public void setZtysmbcsyono(String pZtysmbcsyono) {
        ztysmbcsyono = pZtysmbcsyono;
    }

    private String ztysmbcsyonoedaban;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSYONOEDABAN)
    public String getZtysmbcsyonoedaban() {
        return ztysmbcsyonoedaban;
    }

    public void setZtysmbcsyonoedaban(String pZtysmbcsyonoedaban) {
        ztysmbcsyonoedaban = pZtysmbcsyonoedaban;
    }

    private String ztysmbcjktkflg;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCJKTKFLG)
    public String getZtysmbcjktkflg() {
        return ztysmbcjktkflg;
    }

    public void setZtysmbcjktkflg(String pZtysmbcjktkflg) {
        ztysmbcjktkflg = pZtysmbcjktkflg;
    }

    private String ztysmbcseihotrksymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOTRKSYMD)
    public String getZtysmbcseihotrksymd() {
        return ztysmbcseihotrksymd;
    }

    public void setZtysmbcseihotrksymd(String pZtysmbcseihotrksymd) {
        ztysmbcseihotrksymd = pZtysmbcseihotrksymd;
    }

    private String ztysmbcseihohktymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCSEIHOHKTYMD)
    public String getZtysmbcseihohktymd() {
        return ztysmbcseihohktymd;
    }

    public void setZtysmbcseihohktymd(String pZtysmbcseihohktymd) {
        ztysmbcseihohktymd = pZtysmbcseihohktymd;
    }

    private String ztysmbckykseiymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCKYKSEIYMD)
    public String getZtysmbckykseiymd() {
        return ztysmbckykseiymd;
    }

    public void setZtysmbckykseiymd(String pZtysmbckykseiymd) {
        ztysmbckykseiymd = pZtysmbckykseiymd;
    }

    private String ztysmbckyknmkn;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCKYKNMKN)
    public String getZtysmbckyknmkn() {
        return ztysmbckyknmkn;
    }

    public void setZtysmbckyknmkn(String pZtysmbckyknmkn) {
        ztysmbckyknmkn = pZtysmbckyknmkn;
    }

    private String ztysmbcmosuktymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCMOSUKTYMD)
    public String getZtysmbcmosuktymd() {
        return ztysmbcmosuktymd;
    }

    public void setZtysmbcmosuktymd(String pZtysmbcmosuktymd) {
        ztysmbcmosuktymd = pZtysmbcmosuktymd;
    }

    private String ztysmbcmossyoriflg;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCMOSSYORIFLG)
    public String getZtysmbcmossyoriflg() {
        return ztysmbcmossyoriflg;
    }

    public void setZtysmbcmossyoriflg(String pZtysmbcmossyoriflg) {
        ztysmbcmossyoriflg = pZtysmbcmossyoriflg;
    }

    private String ztysmbckosyaareastyknr;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYSMBCKOSYAAREASTYKNR)
    public String getZtysmbckosyaareastyknr() {
        return ztysmbckosyaareastyknr;
    }

    public void setZtysmbckosyaareastyknr(String pZtysmbckosyaareastyknr) {
        ztysmbckosyaareastyknr = pZtysmbckosyaareastyknr;
    }

    private String ztyyobiv60;

    @Column(name=GenZT_SmbcSkMeisaiRendouTy.ZTYYOBIV60)
    public String getZtyyobiv60() {
        return ztyyobiv60;
    }

    public void setZtyyobiv60(String pZtyyobiv60) {
        ztyyobiv60 = pZtyyobiv60;
    }
}
