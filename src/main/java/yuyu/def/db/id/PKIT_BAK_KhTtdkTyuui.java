package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_KhTtdkTyuui;
import yuyu.def.db.mapping.GenIT_BAK_KhTtdkTyuui;
import yuyu.def.db.meta.GenQIT_BAK_KhTtdkTyuui;
import yuyu.def.db.meta.QIT_BAK_KhTtdkTyuui;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全手続注意バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhTtdkTyuui}</td><td colspan="3">契約保全手続注意バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuisetymd</td><td>手続注意設定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuisetnm</td><td>手続注意設定者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kktyuitakbn</td><td>契約管理注意取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KktyuitaKbn C_KktyuitaKbn}</td></tr>
 *  <tr><td>ttdktyuuinaiyou1</td><td>手続注意内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuinaiyou2</td><td>手続注意内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuinaiyou3</td><td>手続注意内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbn1</td><td>手続注意区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn2</td><td>手続注意区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn3</td><td>手続注意区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn4</td><td>手続注意区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn5</td><td>手続注意区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou1</td><td>手続注意区分補足内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou2</td><td>手続注意区分補足内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou3</td><td>手続注意区分補足内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou4</td><td>手続注意区分補足内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnhsknaiyou5</td><td>手続注意区分補足内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd1</td><td>手続注意区分設定日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd2</td><td>手続注意区分設定日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd3</td><td>手続注意区分設定日３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd4</td><td>手続注意区分設定日４</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbnsetymd5</td><td>手続注意区分設定日５</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>setsosikicd1</td><td>設定組織コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setsosikicd2</td><td>設定組織コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setsosikicd3</td><td>設定組織コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setsosikicd4</td><td>設定組織コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>setsosikicd5</td><td>設定組織コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrknhatudoujyoutai</td><td>契約者代理権発動状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykdrknHtdjytKbn C_KykdrknHtdjytKbn}</td></tr>
 *  <tr><td>kykdrdouiyouhi</td><td>契約者代理人同意要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykdrDouiYouhiKbn C_KykdrDouiYouhiKbn}</td></tr>
 * </table>
 * @see     IT_BAK_KhTtdkTyuui
 * @see     GenIT_BAK_KhTtdkTyuui
 * @see     QIT_BAK_KhTtdkTyuui
 * @see     GenQIT_BAK_KhTtdkTyuui
 */
public class PKIT_BAK_KhTtdkTyuui extends AbstractExDBPrimaryKey<IT_BAK_KhTtdkTyuui, PKIT_BAK_KhTtdkTyuui> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhTtdkTyuui() {
    }

    public PKIT_BAK_KhTtdkTyuui(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhTtdkTyuui> getEntityClass() {
        return IT_BAK_KhTtdkTyuui.class;
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

}