package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.mapping.GenST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.GenQST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknTmttd;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効契約配当準備金（積立Ｄ）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_YuukoukykHtjynbknTmttd}</td><td colspan="3">有効契約配当準備金（積立Ｄ）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haraikomikaisukbn</td><td>払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkeirokbn</td><td>払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>annaihuyouriyuukbn</td><td>案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennendkurikosid</td><td>前年度繰越Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tounendod</td><td>当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tndmatutumitated</td><td>当年度末積立Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitaterisoku</td><td>積立利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hsys</td><td>保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syuruicd1</td><td>種類コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuruicd3</td><td>種類コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>srutiwake</td><td>数理用内訳</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSrkijyunym srkijyunym}</td><td>数理用基準年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeiriyousegmentkbn</td><td>区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeiriyourgnbnskkbn</td><td>区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuruicd2</td><td>種類コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mankitouraiym</td><td>満期到来年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syukeiyakusyuruicd</td><td>主契約種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknendo</td><td>契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daihyouyoteiriritu</td><td>代表予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>haraikatakbn</td><td>払方区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yobiv20</td><td>予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>srhaitoukinsyuukeiptnkbn</td><td>数理配当金集計パターン区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn C_SrHaitoukinSyuukeiPtnKbn}</td></tr>
 * </table>
 * @see     ST_YuukoukykHtjynbknTmttd
 * @see     GenST_YuukoukykHtjynbknTmttd
 * @see     QST_YuukoukykHtjynbknTmttd
 * @see     GenQST_YuukoukykHtjynbknTmttd
 */
public class PKST_YuukoukykHtjynbknTmttd extends AbstractExDBPrimaryKey<ST_YuukoukykHtjynbknTmttd, PKST_YuukoukykHtjynbknTmttd> {

    private static final long serialVersionUID = 1L;

    public PKST_YuukoukykHtjynbknTmttd() {
    }

    public PKST_YuukoukykHtjynbknTmttd(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pSrkijyunym
    ) {
        syoriYmd = pSyoriYmd;
        kakutyoujobcd = pKakutyoujobcd;
        syono = pSyono;
        srkijyunym = pSrkijyunym;
    }

    @Transient
    @Override
    public Class<ST_YuukoukykHtjynbknTmttd> getEntityClass() {
        return ST_YuukoukykHtjynbknTmttd.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String kakutyoujobcd;

    public String getKakutyoujobcd() {
        return kakutyoujobcd;
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        kakutyoujobcd = pKakutyoujobcd;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String srkijyunym;

    public String getSrkijyunym() {
        return srkijyunym;
    }

    public void setSrkijyunym(String pSrkijyunym) {
        srkijyunym = pSrkijyunym;
    }

}