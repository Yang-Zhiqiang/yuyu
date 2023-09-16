package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.mapping.GenHT_SmbcStyKanriSsRireki;
import yuyu.def.db.meta.GenQHT_SmbcStyKanriSsRireki;
import yuyu.def.db.meta.QHT_SmbcStyKanriSsRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＳＭＢＣ進捗管理作成履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SmbcStyKanriSsRireki}</td><td colspan="3">ＳＭＢＣ進捗管理作成履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syrctrltblkostime</td><td>処理コントロールTBL更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>renkanryoflg</td><td>連動完了フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
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
 * @see     HT_SmbcStyKanriSsRireki
 * @see     GenHT_SmbcStyKanriSsRireki
 * @see     QHT_SmbcStyKanriSsRireki
 * @see     GenQHT_SmbcStyKanriSsRireki
 */
public class PKHT_SmbcStyKanriSsRireki extends AbstractExDBPrimaryKey<HT_SmbcStyKanriSsRireki, PKHT_SmbcStyKanriSsRireki> {

    private static final long serialVersionUID = 1L;

    public PKHT_SmbcStyKanriSsRireki() {
    }

    public PKHT_SmbcStyKanriSsRireki(String pSyono) {
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<HT_SmbcStyKanriSsRireki> getEntityClass() {
        return HT_SmbcStyKanriSsRireki.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}