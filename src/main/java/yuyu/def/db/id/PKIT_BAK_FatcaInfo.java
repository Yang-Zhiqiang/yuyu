package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_FatcaInfo;
import yuyu.def.db.mapping.GenIT_BAK_FatcaInfo;
import yuyu.def.db.meta.GenQIT_BAK_FatcaInfo;
import yuyu.def.db.meta.QIT_BAK_FatcaInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＦＡＴＣＡ情報バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_FatcaInfo}</td><td colspan="3">ＦＡＴＣＡ情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fatcasnsikbn</td><td>ＦＡＴＣＡ宣誓区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FatcasnsiKbn C_FatcasnsiKbn}</td></tr>
 *  <tr><td>bikkjnssinfokbn</td><td>米国人示唆情報区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BikkjnssinfoKbn C_BikkjnssinfoKbn}</td></tr>
 *  <tr><td>fatcakekkbn</td><td>ＦＡＴＣＡ結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FatcakekKbn C_FatcakekKbn}</td></tr>
 *  <tr><td>fatcahankeiikbn</td><td>ＦＡＴＣＡ判明経緯区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FatcahankeiiKbn C_FatcahankeiiKbn}</td></tr>
 *  <tr><td>bikknzsyno</td><td>米国納税者番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syomeiymd</td><td>署名日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kokno</td><td>顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fatcatgkbn</td><td>ＦＡＴＣＡ対象者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FatcatgKbn C_FatcatgKbn}</td></tr>
 *  <tr><td>seionnmkn</td><td>清音氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nmkn</td><td>氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nmkj</td><td>氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seiymd</td><td>生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seibetu</td><td>性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>kouryokuendymd</td><td>効力終了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkymd</td><td>登録日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_FatcaInfo
 * @see     GenIT_BAK_FatcaInfo
 * @see     QIT_BAK_FatcaInfo
 * @see     GenQIT_BAK_FatcaInfo
 */
public class PKIT_BAK_FatcaInfo extends AbstractExDBPrimaryKey<IT_BAK_FatcaInfo, PKIT_BAK_FatcaInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_FatcaInfo() {
    }

    public PKIT_BAK_FatcaInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_FatcaInfo> getEntityClass() {
        return IT_BAK_FatcaInfo.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}