package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.mapping.GenZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.GenQZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouRn;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcSkMeisaiRendouRn}</td><td colspan="3">ＳＭＢＣ扱新契約明細連動テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsmbcdatakbn zrnsmbcdatakbn}</td><td>（連携用）ＳＭＢＣ＿データ区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsmbcdatasakuseiymd zrnsmbcdatasakuseiymd}</td><td>（連携用）ＳＭＢＣ＿データ作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsmbchknkaisyacd zrnsmbchknkaisyacd}</td><td>（連携用）ＳＭＢＣ＿保険会社コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsmbcuktkkanriid zrnsmbcuktkkanriid}</td><td>（連携用）ＳＭＢＣ＿受付管理ＩＤ</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihouktkzmymd</td><td>（連携用）ＳＭＢＣ＿生保受付済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihohbymd</td><td>（連携用）ＳＭＢＣ＿生保不備ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcbankhnkykflg</td><td>（連携用）ＳＭＢＣ＿銀行返却フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihohbksyymd</td><td>（連携用）ＳＭＢＣ＿生保不備解消ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihohjyttykymd</td><td>（連携用）ＳＭＢＣ＿生保報状到着ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihonyknzmymd</td><td>（連携用）ＳＭＢＣ＿生保入金済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihosnszmymd</td><td>（連携用）ＳＭＢＣ＿生保審査済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihosyknhkkzmymd</td><td>（連携用）ＳＭＢＣ＿生保証券発行済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihosyumoku</td><td>（連携用）ＳＭＢＣ＿生保種目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihosyurui</td><td>（連携用）ＳＭＢＣ＿生保種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcsyono</td><td>（連携用）ＳＭＢＣ＿証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcsyonoedaban</td><td>（連携用）ＳＭＢＣ＿証券番号枝番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcjktkflg</td><td>（連携用）ＳＭＢＣ＿条件付フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihotrksymd</td><td>（連携用）ＳＭＢＣ＿生保取消ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcseihohktymd</td><td>（連携用）ＳＭＢＣ＿生保否決ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbckykseiymd</td><td>（連携用）ＳＭＢＣ＿契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbckyknmkn</td><td>（連携用）ＳＭＢＣ＿契約者名（カナ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcmosuktymd</td><td>（連携用）ＳＭＢＣ＿申込書受付ＤＡＴＥ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbcmossyoriflg</td><td>（連携用）ＳＭＢＣ＿申込処理フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsmbckosyaareastyknr</td><td>（連携用）ＳＭＢＣ＿個社領域（進捗管理）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv60</td><td>（連携用）予備項目Ｖ６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcSkMeisaiRendouRn
 * @see     GenZT_SmbcSkMeisaiRendouRn
 * @see     QZT_SmbcSkMeisaiRendouRn
 * @see     GenQZT_SmbcSkMeisaiRendouRn
 */
public class PKZT_SmbcSkMeisaiRendouRn extends AbstractExDBPrimaryKey<ZT_SmbcSkMeisaiRendouRn, PKZT_SmbcSkMeisaiRendouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SmbcSkMeisaiRendouRn() {
    }

    public PKZT_SmbcSkMeisaiRendouRn(
        String pZrnsmbcdatakbn,
        String pZrnsmbcdatasakuseiymd,
        String pZrnsmbchknkaisyacd,
        String pZrnsmbcuktkkanriid
    ) {
        zrnsmbcdatakbn = pZrnsmbcdatakbn;
        zrnsmbcdatasakuseiymd = pZrnsmbcdatasakuseiymd;
        zrnsmbchknkaisyacd = pZrnsmbchknkaisyacd;
        zrnsmbcuktkkanriid = pZrnsmbcuktkkanriid;
    }

    @Transient
    @Override
    public Class<ZT_SmbcSkMeisaiRendouRn> getEntityClass() {
        return ZT_SmbcSkMeisaiRendouRn.class;
    }

    private String zrnsmbcdatakbn;

    public String getZrnsmbcdatakbn() {
        return zrnsmbcdatakbn;
    }

    public void setZrnsmbcdatakbn(String pZrnsmbcdatakbn) {
        zrnsmbcdatakbn = pZrnsmbcdatakbn;
    }
    private String zrnsmbcdatasakuseiymd;

    public String getZrnsmbcdatasakuseiymd() {
        return zrnsmbcdatasakuseiymd;
    }

    public void setZrnsmbcdatasakuseiymd(String pZrnsmbcdatasakuseiymd) {
        zrnsmbcdatasakuseiymd = pZrnsmbcdatasakuseiymd;
    }
    private String zrnsmbchknkaisyacd;

    public String getZrnsmbchknkaisyacd() {
        return zrnsmbchknkaisyacd;
    }

    public void setZrnsmbchknkaisyacd(String pZrnsmbchknkaisyacd) {
        zrnsmbchknkaisyacd = pZrnsmbchknkaisyacd;
    }
    private String zrnsmbcuktkkanriid;

    public String getZrnsmbcuktkkanriid() {
        return zrnsmbcuktkkanriid;
    }

    public void setZrnsmbcuktkkanriid(String pZrnsmbcuktkkanriid) {
        zrnsmbcuktkkanriid = pZrnsmbcuktkkanriid;
    }

}