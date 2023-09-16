package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.mapping.GenWT_KouteiSummary;
import yuyu.def.db.meta.GenQWT_KouteiSummary;
import yuyu.def.db.meta.QWT_KouteiSummary;

/**
 * 工程サマリテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KouteiSummary}</td><td colspan="3">工程サマリテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>flowId</td><td>フローＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lastSyoriTime</td><td>最終処理時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syokaiAccountId</td><td>初回アカウントＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenkaiAccountId</td><td>前回アカウントＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenkaiNodeNm</td><td>前回ノード名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenkaiTaskLocalNm</td><td>前回タスクローカル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nodeNm</td><td>ノード名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>genzaiAccountId</td><td>現在アカウントＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>genzaiTaskLocalNm</td><td>現在タスクローカル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>iwfKouteiKaisiYmd</td><td>IWF工程開始日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouteiKanryouYmd</td><td>工程完了日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriStatus</td><td>処理状態</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam1</td><td>拡張パラメータ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam2</td><td>拡張パラメータ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam3</td><td>拡張パラメータ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam4</td><td>拡張パラメータ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam5</td><td>拡張パラメータ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam6</td><td>拡張パラメータ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam7</td><td>拡張パラメータ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam8</td><td>拡張パラメータ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam9</td><td>拡張パラメータ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam10</td><td>拡張パラメータ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam11</td><td>拡張パラメータ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam12</td><td>拡張パラメータ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam13</td><td>拡張パラメータ１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam14</td><td>拡張パラメータ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam15</td><td>拡張パラメータ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam16</td><td>拡張パラメータ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam17</td><td>拡張パラメータ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam18</td><td>拡張パラメータ１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam19</td><td>拡張パラメータ１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam20</td><td>拡張パラメータ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam21</td><td>拡張パラメータ２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam22</td><td>拡張パラメータ２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam23</td><td>拡張パラメータ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam24</td><td>拡張パラメータ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam25</td><td>拡張パラメータ２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam26</td><td>拡張パラメータ２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam27</td><td>拡張パラメータ２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam28</td><td>拡張パラメータ２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam29</td><td>拡張パラメータ２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>extParam30</td><td>拡張パラメータ３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KouteiSummary
 * @see     GenWT_KouteiSummary
 * @see     QWT_KouteiSummary
 * @see     GenQWT_KouteiSummary
 */
public class PKWT_KouteiSummary extends AbstractExDBPrimaryKey<WT_KouteiSummary, PKWT_KouteiSummary> {

    private static final long serialVersionUID = 1L;

    public PKWT_KouteiSummary() {
    }

    public PKWT_KouteiSummary(String pGyoumuKey) {
        gyoumuKey = pGyoumuKey;
    }

    @Transient
    @Override
    public Class<WT_KouteiSummary> getEntityClass() {
        return WT_KouteiSummary.class;
    }

    private String gyoumuKey;

    public String getGyoumuKey() {
        return gyoumuKey;
    }

    public void setGyoumuKey(String pGyoumuKey) {
        gyoumuKey = pGyoumuKey;
    }

}