package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.id.PKZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.GenQZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouRn;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SmbcSkMeisaiRendouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcSkMeisaiRendouRn}</td><td colspan="3">ＳＭＢＣ扱新契約明細連動テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsmbcdatakbn zrnsmbcdatakbn}</td><td>（連携用）ＳＭＢＣ＿データ区分</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcdatasakuseiymd zrnsmbcdatasakuseiymd}</td><td>（連携用）ＳＭＢＣ＿データ作成日</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbchknkaisyacd zrnsmbchknkaisyacd}</td><td>（連携用）ＳＭＢＣ＿保険会社コード</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcuktkkanriid zrnsmbcuktkkanriid}</td><td>（連携用）ＳＭＢＣ＿受付管理ＩＤ</td><td align="center">{@link PKZT_SmbcSkMeisaiRendouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihouktkzmymd zrnsmbcseihouktkzmymd}</td><td>（連携用）ＳＭＢＣ＿生保受付済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihohbymd zrnsmbcseihohbymd}</td><td>（連携用）ＳＭＢＣ＿生保不備ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcbankhnkykflg zrnsmbcbankhnkykflg}</td><td>（連携用）ＳＭＢＣ＿銀行返却フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihohbksyymd zrnsmbcseihohbksyymd}</td><td>（連携用）ＳＭＢＣ＿生保不備解消ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihohjyttykymd zrnsmbcseihohjyttykymd}</td><td>（連携用）ＳＭＢＣ＿生保報状到着ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihonyknzmymd zrnsmbcseihonyknzmymd}</td><td>（連携用）ＳＭＢＣ＿生保入金済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihosnszmymd zrnsmbcseihosnszmymd}</td><td>（連携用）ＳＭＢＣ＿生保審査済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihosyknhkkzmymd zrnsmbcseihosyknhkkzmymd}</td><td>（連携用）ＳＭＢＣ＿生保証券発行済ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihosyumoku zrnsmbcseihosyumoku}</td><td>（連携用）ＳＭＢＣ＿生保種目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihosyurui zrnsmbcseihosyurui}</td><td>（連携用）ＳＭＢＣ＿生保種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcsyono zrnsmbcsyono}</td><td>（連携用）ＳＭＢＣ＿証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcsyonoedaban zrnsmbcsyonoedaban}</td><td>（連携用）ＳＭＢＣ＿証券番号枝番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcjktkflg zrnsmbcjktkflg}</td><td>（連携用）ＳＭＢＣ＿条件付フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihotrksymd zrnsmbcseihotrksymd}</td><td>（連携用）ＳＭＢＣ＿生保取消ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcseihohktymd zrnsmbcseihohktymd}</td><td>（連携用）ＳＭＢＣ＿生保否決ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbckykseiymd zrnsmbckykseiymd}</td><td>（連携用）ＳＭＢＣ＿契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbckyknmkn zrnsmbckyknmkn}</td><td>（連携用）ＳＭＢＣ＿契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcmosuktymd zrnsmbcmosuktymd}</td><td>（連携用）ＳＭＢＣ＿申込書受付ＤＡＴＥ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbcmossyoriflg zrnsmbcmossyoriflg}</td><td>（連携用）ＳＭＢＣ＿申込処理フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsmbckosyaareastyknr zrnsmbckosyaareastyknr}</td><td>（連携用）ＳＭＢＣ＿個社領域（進捗管理）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv60 zrnyobiv60}</td><td>（連携用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcSkMeisaiRendouRn
 * @see     PKZT_SmbcSkMeisaiRendouRn
 * @see     QZT_SmbcSkMeisaiRendouRn
 * @see     GenQZT_SmbcSkMeisaiRendouRn
 */
@MappedSuperclass
@Table(name=GenZT_SmbcSkMeisaiRendouRn.TABLE_NAME)
@IdClass(value=PKZT_SmbcSkMeisaiRendouRn.class)
public abstract class GenZT_SmbcSkMeisaiRendouRn extends AbstractExDBEntityForZDB<ZT_SmbcSkMeisaiRendouRn, PKZT_SmbcSkMeisaiRendouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SmbcSkMeisaiRendouRn";
    public static final String ZRNSMBCDATAKBN           = "zrnsmbcdatakbn";
    public static final String ZRNSMBCDATASAKUSEIYMD    = "zrnsmbcdatasakuseiymd";
    public static final String ZRNSMBCHKNKAISYACD       = "zrnsmbchknkaisyacd";
    public static final String ZRNSMBCUKTKKANRIID       = "zrnsmbcuktkkanriid";
    public static final String ZRNSMBCSEIHOUKTKZMYMD    = "zrnsmbcseihouktkzmymd";
    public static final String ZRNSMBCSEIHOHBYMD        = "zrnsmbcseihohbymd";
    public static final String ZRNSMBCBANKHNKYKFLG      = "zrnsmbcbankhnkykflg";
    public static final String ZRNSMBCSEIHOHBKSYYMD     = "zrnsmbcseihohbksyymd";
    public static final String ZRNSMBCSEIHOHJYTTYKYMD   = "zrnsmbcseihohjyttykymd";
    public static final String ZRNSMBCSEIHONYKNZMYMD    = "zrnsmbcseihonyknzmymd";
    public static final String ZRNSMBCSEIHOSNSZMYMD     = "zrnsmbcseihosnszmymd";
    public static final String ZRNSMBCSEIHOSYKNHKKZMYMD = "zrnsmbcseihosyknhkkzmymd";
    public static final String ZRNSMBCSEIHOSYUMOKU      = "zrnsmbcseihosyumoku";
    public static final String ZRNSMBCSEIHOSYURUI       = "zrnsmbcseihosyurui";
    public static final String ZRNSMBCSYONO             = "zrnsmbcsyono";
    public static final String ZRNSMBCSYONOEDABAN       = "zrnsmbcsyonoedaban";
    public static final String ZRNSMBCJKTKFLG           = "zrnsmbcjktkflg";
    public static final String ZRNSMBCSEIHOTRKSYMD      = "zrnsmbcseihotrksymd";
    public static final String ZRNSMBCSEIHOHKTYMD       = "zrnsmbcseihohktymd";
    public static final String ZRNSMBCKYKSEIYMD         = "zrnsmbckykseiymd";
    public static final String ZRNSMBCKYKNMKN           = "zrnsmbckyknmkn";
    public static final String ZRNSMBCMOSUKTYMD         = "zrnsmbcmosuktymd";
    public static final String ZRNSMBCMOSSYORIFLG       = "zrnsmbcmossyoriflg";
    public static final String ZRNSMBCKOSYAAREASTYKNR   = "zrnsmbckosyaareastyknr";
    public static final String ZRNYOBIV60               = "zrnyobiv60";

    private final PKZT_SmbcSkMeisaiRendouRn primaryKey;

    public GenZT_SmbcSkMeisaiRendouRn() {
        primaryKey = new PKZT_SmbcSkMeisaiRendouRn();
    }

    public GenZT_SmbcSkMeisaiRendouRn(
        String pZrnsmbcdatakbn,
        String pZrnsmbcdatasakuseiymd,
        String pZrnsmbchknkaisyacd,
        String pZrnsmbcuktkkanriid
    ) {
        primaryKey = new PKZT_SmbcSkMeisaiRendouRn(
            pZrnsmbcdatakbn,
            pZrnsmbcdatasakuseiymd,
            pZrnsmbchknkaisyacd,
            pZrnsmbcuktkkanriid
        );
    }

    @Transient
    @Override
    public PKZT_SmbcSkMeisaiRendouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SmbcSkMeisaiRendouRn> getMetaClass() {
        return QZT_SmbcSkMeisaiRendouRn.class;
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCDATAKBN)
    public String getZrnsmbcdatakbn() {
        return getPrimaryKey().getZrnsmbcdatakbn();
    }

    public void setZrnsmbcdatakbn(String pZrnsmbcdatakbn) {
        getPrimaryKey().setZrnsmbcdatakbn(pZrnsmbcdatakbn);
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCDATASAKUSEIYMD)
    public String getZrnsmbcdatasakuseiymd() {
        return getPrimaryKey().getZrnsmbcdatasakuseiymd();
    }

    public void setZrnsmbcdatasakuseiymd(String pZrnsmbcdatasakuseiymd) {
        getPrimaryKey().setZrnsmbcdatasakuseiymd(pZrnsmbcdatasakuseiymd);
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCHKNKAISYACD)
    public String getZrnsmbchknkaisyacd() {
        return getPrimaryKey().getZrnsmbchknkaisyacd();
    }

    public void setZrnsmbchknkaisyacd(String pZrnsmbchknkaisyacd) {
        getPrimaryKey().setZrnsmbchknkaisyacd(pZrnsmbchknkaisyacd);
    }

    @Id
    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCUKTKKANRIID)
    public String getZrnsmbcuktkkanriid() {
        return getPrimaryKey().getZrnsmbcuktkkanriid();
    }

    public void setZrnsmbcuktkkanriid(String pZrnsmbcuktkkanriid) {
        getPrimaryKey().setZrnsmbcuktkkanriid(pZrnsmbcuktkkanriid);
    }

    private String zrnsmbcseihouktkzmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOUKTKZMYMD)
    public String getZrnsmbcseihouktkzmymd() {
        return zrnsmbcseihouktkzmymd;
    }

    public void setZrnsmbcseihouktkzmymd(String pZrnsmbcseihouktkzmymd) {
        zrnsmbcseihouktkzmymd = pZrnsmbcseihouktkzmymd;
    }

    private String zrnsmbcseihohbymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOHBYMD)
    public String getZrnsmbcseihohbymd() {
        return zrnsmbcseihohbymd;
    }

    public void setZrnsmbcseihohbymd(String pZrnsmbcseihohbymd) {
        zrnsmbcseihohbymd = pZrnsmbcseihohbymd;
    }

    private String zrnsmbcbankhnkykflg;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCBANKHNKYKFLG)
    public String getZrnsmbcbankhnkykflg() {
        return zrnsmbcbankhnkykflg;
    }

    public void setZrnsmbcbankhnkykflg(String pZrnsmbcbankhnkykflg) {
        zrnsmbcbankhnkykflg = pZrnsmbcbankhnkykflg;
    }

    private String zrnsmbcseihohbksyymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOHBKSYYMD)
    public String getZrnsmbcseihohbksyymd() {
        return zrnsmbcseihohbksyymd;
    }

    public void setZrnsmbcseihohbksyymd(String pZrnsmbcseihohbksyymd) {
        zrnsmbcseihohbksyymd = pZrnsmbcseihohbksyymd;
    }

    private String zrnsmbcseihohjyttykymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOHJYTTYKYMD)
    public String getZrnsmbcseihohjyttykymd() {
        return zrnsmbcseihohjyttykymd;
    }

    public void setZrnsmbcseihohjyttykymd(String pZrnsmbcseihohjyttykymd) {
        zrnsmbcseihohjyttykymd = pZrnsmbcseihohjyttykymd;
    }

    private String zrnsmbcseihonyknzmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHONYKNZMYMD)
    public String getZrnsmbcseihonyknzmymd() {
        return zrnsmbcseihonyknzmymd;
    }

    public void setZrnsmbcseihonyknzmymd(String pZrnsmbcseihonyknzmymd) {
        zrnsmbcseihonyknzmymd = pZrnsmbcseihonyknzmymd;
    }

    private String zrnsmbcseihosnszmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOSNSZMYMD)
    public String getZrnsmbcseihosnszmymd() {
        return zrnsmbcseihosnszmymd;
    }

    public void setZrnsmbcseihosnszmymd(String pZrnsmbcseihosnszmymd) {
        zrnsmbcseihosnszmymd = pZrnsmbcseihosnszmymd;
    }

    private String zrnsmbcseihosyknhkkzmymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOSYKNHKKZMYMD)
    public String getZrnsmbcseihosyknhkkzmymd() {
        return zrnsmbcseihosyknhkkzmymd;
    }

    public void setZrnsmbcseihosyknhkkzmymd(String pZrnsmbcseihosyknhkkzmymd) {
        zrnsmbcseihosyknhkkzmymd = pZrnsmbcseihosyknhkkzmymd;
    }

    private String zrnsmbcseihosyumoku;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOSYUMOKU)
    public String getZrnsmbcseihosyumoku() {
        return zrnsmbcseihosyumoku;
    }

    public void setZrnsmbcseihosyumoku(String pZrnsmbcseihosyumoku) {
        zrnsmbcseihosyumoku = pZrnsmbcseihosyumoku;
    }

    private String zrnsmbcseihosyurui;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOSYURUI)
    public String getZrnsmbcseihosyurui() {
        return zrnsmbcseihosyurui;
    }

    public void setZrnsmbcseihosyurui(String pZrnsmbcseihosyurui) {
        zrnsmbcseihosyurui = pZrnsmbcseihosyurui;
    }

    private String zrnsmbcsyono;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSYONO)
    public String getZrnsmbcsyono() {
        return zrnsmbcsyono;
    }

    public void setZrnsmbcsyono(String pZrnsmbcsyono) {
        zrnsmbcsyono = pZrnsmbcsyono;
    }

    private String zrnsmbcsyonoedaban;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSYONOEDABAN)
    public String getZrnsmbcsyonoedaban() {
        return zrnsmbcsyonoedaban;
    }

    public void setZrnsmbcsyonoedaban(String pZrnsmbcsyonoedaban) {
        zrnsmbcsyonoedaban = pZrnsmbcsyonoedaban;
    }

    private String zrnsmbcjktkflg;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCJKTKFLG)
    public String getZrnsmbcjktkflg() {
        return zrnsmbcjktkflg;
    }

    public void setZrnsmbcjktkflg(String pZrnsmbcjktkflg) {
        zrnsmbcjktkflg = pZrnsmbcjktkflg;
    }

    private String zrnsmbcseihotrksymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOTRKSYMD)
    public String getZrnsmbcseihotrksymd() {
        return zrnsmbcseihotrksymd;
    }

    public void setZrnsmbcseihotrksymd(String pZrnsmbcseihotrksymd) {
        zrnsmbcseihotrksymd = pZrnsmbcseihotrksymd;
    }

    private String zrnsmbcseihohktymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCSEIHOHKTYMD)
    public String getZrnsmbcseihohktymd() {
        return zrnsmbcseihohktymd;
    }

    public void setZrnsmbcseihohktymd(String pZrnsmbcseihohktymd) {
        zrnsmbcseihohktymd = pZrnsmbcseihohktymd;
    }

    private String zrnsmbckykseiymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCKYKSEIYMD)
    public String getZrnsmbckykseiymd() {
        return zrnsmbckykseiymd;
    }

    public void setZrnsmbckykseiymd(String pZrnsmbckykseiymd) {
        zrnsmbckykseiymd = pZrnsmbckykseiymd;
    }

    private String zrnsmbckyknmkn;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCKYKNMKN)
    public String getZrnsmbckyknmkn() {
        return zrnsmbckyknmkn;
    }

    public void setZrnsmbckyknmkn(String pZrnsmbckyknmkn) {
        zrnsmbckyknmkn = pZrnsmbckyknmkn;
    }

    private String zrnsmbcmosuktymd;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCMOSUKTYMD)
    public String getZrnsmbcmosuktymd() {
        return zrnsmbcmosuktymd;
    }

    public void setZrnsmbcmosuktymd(String pZrnsmbcmosuktymd) {
        zrnsmbcmosuktymd = pZrnsmbcmosuktymd;
    }

    private String zrnsmbcmossyoriflg;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCMOSSYORIFLG)
    public String getZrnsmbcmossyoriflg() {
        return zrnsmbcmossyoriflg;
    }

    public void setZrnsmbcmossyoriflg(String pZrnsmbcmossyoriflg) {
        zrnsmbcmossyoriflg = pZrnsmbcmossyoriflg;
    }

    private String zrnsmbckosyaareastyknr;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNSMBCKOSYAAREASTYKNR)
    public String getZrnsmbckosyaareastyknr() {
        return zrnsmbckosyaareastyknr;
    }

    public void setZrnsmbckosyaareastyknr(String pZrnsmbckosyaareastyknr) {
        zrnsmbckosyaareastyknr = pZrnsmbckosyaareastyknr;
    }

    private String zrnyobiv60;

    @Column(name=GenZT_SmbcSkMeisaiRendouRn.ZRNYOBIV60)
    public String getZrnyobiv60() {
        return zrnyobiv60;
    }

    public void setZrnyobiv60(String pZrnyobiv60) {
        zrnyobiv60 = pZrnyobiv60;
    }
}