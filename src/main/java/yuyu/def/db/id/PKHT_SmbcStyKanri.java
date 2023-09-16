package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.mapping.GenHT_SmbcStyKanri;
import yuyu.def.db.meta.GenQHT_SmbcStyKanri;
import yuyu.def.db.meta.QHT_SmbcStyKanri;

/**
 * ＳＭＢＣ進捗管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SmbcStyKanri}</td><td colspan="3">ＳＭＢＣ進捗管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenymd datarenymd}</td><td>データ連動日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatasakuseirenno datasakuseirenno}</td><td>データ作成連番</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rendouflg</td><td>連動フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Rendouflg C_Rendouflg}</td></tr>
 *  <tr><td>smbcdatakbn</td><td>ＳＭＢＣ＿データ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcdatasakuseiymd</td><td>ＳＭＢＣ＿データ作成日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbchknkaisyacd</td><td>ＳＭＢＣ＿保険会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcuktkkanriid</td><td>ＳＭＢＣ＿受付管理ID</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihouktkzmymd</td><td>ＳＭＢＣ＿生保受付済DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihohbymd</td><td>ＳＭＢＣ＿生保不備DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcbankhnkykflg</td><td>ＳＭＢＣ＿銀行返却フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihohbksyymd</td><td>ＳＭＢＣ＿生保不備解消DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihohjyttykymd</td><td>ＳＭＢＣ＿生保報状到着DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihonyknzmymd</td><td>ＳＭＢＣ＿生保入金済DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihosnszmymd</td><td>ＳＭＢＣ＿生保審査済DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihosyknhkkzmymd</td><td>ＳＭＢＣ＿生保証券発行済DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihosyumoku</td><td>ＳＭＢＣ＿生保種目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihosyurui</td><td>ＳＭＢＣ＿生保種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcsyono</td><td>ＳＭＢＣ＿証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcsyonoedaban</td><td>ＳＭＢＣ＿証券番号枝番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcjktkflg</td><td>ＳＭＢＣ＿条件付フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihotrksymd</td><td>ＳＭＢＣ＿生保取消DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcseihohktymd</td><td>ＳＭＢＣ＿生保否決DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbckykseiymd</td><td>ＳＭＢＣ＿契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbckyknmkn</td><td>ＳＭＢＣ＿契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcmosuktymd</td><td>ＳＭＢＣ＿申込書受付DATE</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbcmossyoriflg</td><td>ＳＭＢＣ＿申込処理フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbckosyaareastyknr</td><td>ＳＭＢＣ＿個社領域（進捗管理）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SmbcStyKanri
 * @see     GenHT_SmbcStyKanri
 * @see     QHT_SmbcStyKanri
 * @see     GenQHT_SmbcStyKanri
 */
public class PKHT_SmbcStyKanri extends AbstractExDBPrimaryKey<HT_SmbcStyKanri, PKHT_SmbcStyKanri> {

    private static final long serialVersionUID = 1L;

    public PKHT_SmbcStyKanri() {
    }

    public PKHT_SmbcStyKanri(BizDate pDatarenymd, BizNumber pDatasakuseirenno) {
        datarenymd = pDatarenymd;
        datasakuseirenno = pDatasakuseirenno;
    }

    @Transient
    @Override
    public Class<HT_SmbcStyKanri> getEntityClass() {
        return HT_SmbcStyKanri.class;
    }

    private BizDate datarenymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDatarenymd() {
        return datarenymd;
    }

    public void setDatarenymd(BizDate pDatarenymd) {
        datarenymd = pDatarenymd;
    }
    private BizNumber datasakuseirenno;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getDatasakuseirenno() {
        return datasakuseirenno;
    }

    public void setDatasakuseirenno(BizNumber pDatasakuseirenno) {
        datasakuseirenno = pDatasakuseirenno;
    }

}