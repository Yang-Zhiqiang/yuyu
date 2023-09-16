package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.mapping.GenAM_Sosiki;
import yuyu.def.db.meta.GenQAM_Sosiki;
import yuyu.def.db.meta.QAM_Sosiki;

/**
 * 組織マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_Sosiki}</td><td colspan="3">組織マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSosikicd sosikicd}</td><td>組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikinmkbn</td><td>組織名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SosikiNmKbn C_SosikiNmKbn}</td></tr>
 *  <tr><td>sosikinm20</td><td>組織名（２０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjisosikinm20</td><td>漢字組織名（２０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikihaisiym</td><td>組織廃止年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>sosikisinsetuym</td><td>組織新設年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>tougetukeisyouusosikicd</td><td>当月継承組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tougetukeisyoueigyoubucd</td><td>当月継承営業推進部コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zengetukeisyousosikicd</td><td>前月継承組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zengetukeisyoueigyoubucd</td><td>前月継承営業推進部コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikikihontikucd</td><td>組織基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikikanjikaijyuusyo30</td><td>組織漢字下位住所（３０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjibirunm15</td><td>漢字ビル名称（１５文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikinyuukyokaisuu</td><td>組織入居階数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikitelno</td><td>組織電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikifaxno</td><td>組織ＦＡＸ番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouryokukaisiymd</td><td>効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hensosikikihontikucd</td><td>(変更後)組織基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkanjisosikikaijyuusyo30</td><td>(変更後)漢字組織下位住所（３０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkanjibirunm15</td><td>(変更後)漢字ビル名称（１５文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hensosikinyuukyokaisuu</td><td>(変更後)組織入居階数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hensosikitelno</td><td>(変更後)組織電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hensosikifaxno</td><td>(変更後)組織ＦＡＸ番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_Sosiki
 * @see     GenAM_Sosiki
 * @see     QAM_Sosiki
 * @see     GenQAM_Sosiki
 */
public class PKAM_Sosiki extends AbstractExDBPrimaryKey<AM_Sosiki, PKAM_Sosiki> {

    private static final long serialVersionUID = 1L;

    public PKAM_Sosiki() {
    }

    public PKAM_Sosiki(String pSosikicd) {
        sosikicd = pSosikicd;
    }

    @Transient
    @Override
    public Class<AM_Sosiki> getEntityClass() {
        return AM_Sosiki.class;
    }

    private String sosikicd;

    public String getSosikicd() {
        return sosikicd;
    }

    public void setSosikicd(String pSosikicd) {
        sosikicd = pSosikicd;
    }

}