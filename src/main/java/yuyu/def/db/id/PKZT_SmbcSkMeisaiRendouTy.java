package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.mapping.GenZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.GenQZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouTy;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcSkMeisaiRendouTy}</td><td colspan="3">ＳＭＢＣ扱新契約明細連動テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysmbcdatakbn ztysmbcdatakbn}</td><td>（中継用）ＳＭＢＣ＿データ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysmbcdatasakuseiymd ztysmbcdatasakuseiymd}</td><td>（中継用）ＳＭＢＣ＿データ作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysmbchknkaisyacd ztysmbchknkaisyacd}</td><td>（中継用）ＳＭＢＣ＿保険会社コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysmbcuktkkanriid ztysmbcuktkkanriid}</td><td>（中継用）ＳＭＢＣ＿受付管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihouktkzmymd</td><td>（中継用）ＳＭＢＣ＿生保受付済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihohbymd</td><td>（中継用）ＳＭＢＣ＿生保不備ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcbankhnkykflg</td><td>（中継用）ＳＭＢＣ＿銀行返却フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihohbksyymd</td><td>（中継用）ＳＭＢＣ＿生保不備解消ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihohjyttykymd</td><td>（中継用）ＳＭＢＣ＿生保報状到着ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihonyknzmymd</td><td>（中継用）ＳＭＢＣ＿生保入金済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihosnszmymd</td><td>（中継用）ＳＭＢＣ＿生保審査済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihosyknhkkzmymd</td><td>（中継用）ＳＭＢＣ＿生保証券発行済ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihosyumoku</td><td>（中継用）ＳＭＢＣ＿生保種目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihosyurui</td><td>（中継用）ＳＭＢＣ＿生保種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcsyono</td><td>（中継用）ＳＭＢＣ＿証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcsyonoedaban</td><td>（中継用）ＳＭＢＣ＿証券番号枝番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcjktkflg</td><td>（中継用）ＳＭＢＣ＿条件付フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihotrksymd</td><td>（中継用）ＳＭＢＣ＿生保取消ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcseihohktymd</td><td>（中継用）ＳＭＢＣ＿生保否決ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbckykseiymd</td><td>（中継用）ＳＭＢＣ＿契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbckyknmkn</td><td>（中継用）ＳＭＢＣ＿契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcmosuktymd</td><td>（中継用）ＳＭＢＣ＿申込書受付ＤＡＴＥ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbcmossyoriflg</td><td>（中継用）ＳＭＢＣ＿申込処理フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysmbckosyaareastyknr</td><td>（中継用）ＳＭＢＣ＿個社領域（進捗管理）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv60</td><td>（中継用）予備項目Ｖ６０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcSkMeisaiRendouTy
 * @see     GenZT_SmbcSkMeisaiRendouTy
 * @see     QZT_SmbcSkMeisaiRendouTy
 * @see     GenQZT_SmbcSkMeisaiRendouTy
 */
public class PKZT_SmbcSkMeisaiRendouTy extends AbstractExDBPrimaryKey<ZT_SmbcSkMeisaiRendouTy, PKZT_SmbcSkMeisaiRendouTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SmbcSkMeisaiRendouTy() {
    }

    public PKZT_SmbcSkMeisaiRendouTy(
        String pZtysmbcdatakbn,
        String pZtysmbcdatasakuseiymd,
        String pZtysmbchknkaisyacd,
        String pZtysmbcuktkkanriid
    ) {
        ztysmbcdatakbn = pZtysmbcdatakbn;
        ztysmbcdatasakuseiymd = pZtysmbcdatasakuseiymd;
        ztysmbchknkaisyacd = pZtysmbchknkaisyacd;
        ztysmbcuktkkanriid = pZtysmbcuktkkanriid;
    }

    @Transient
    @Override
    public Class<ZT_SmbcSkMeisaiRendouTy> getEntityClass() {
        return ZT_SmbcSkMeisaiRendouTy.class;
    }

    private String ztysmbcdatakbn;

    public String getZtysmbcdatakbn() {
        return ztysmbcdatakbn;
    }

    public void setZtysmbcdatakbn(String pZtysmbcdatakbn) {
        ztysmbcdatakbn = pZtysmbcdatakbn;
    }
    private String ztysmbcdatasakuseiymd;

    public String getZtysmbcdatasakuseiymd() {
        return ztysmbcdatasakuseiymd;
    }

    public void setZtysmbcdatasakuseiymd(String pZtysmbcdatasakuseiymd) {
        ztysmbcdatasakuseiymd = pZtysmbcdatasakuseiymd;
    }
    private String ztysmbchknkaisyacd;

    public String getZtysmbchknkaisyacd() {
        return ztysmbchknkaisyacd;
    }

    public void setZtysmbchknkaisyacd(String pZtysmbchknkaisyacd) {
        ztysmbchknkaisyacd = pZtysmbchknkaisyacd;
    }
    private String ztysmbcuktkkanriid;

    public String getZtysmbcuktkkanriid() {
        return ztysmbcuktkkanriid;
    }

    public void setZtysmbcuktkkanriid(String pZtysmbcuktkkanriid) {
        ztysmbcuktkkanriid = pZtysmbcuktkkanriid;
    }

}