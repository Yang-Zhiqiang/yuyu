package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.mapping.GenMT_DsMailHaisin;
import yuyu.def.db.meta.GenQMT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsMailHaisin;

/**
 * ＤＳメール配信テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailHaisin}</td><td colspan="3">ＤＳメール配信テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSousinymd sousinymd}</td><td>送信日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokmailaddressskbtkey dskokmailaddressskbtkey}</td><td>ＤＳ顧客メールアドレス識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDssousinmailsyubetukbn dssousinmailsyubetukbn}</td><td>ＤＳ送信メール種別区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmailaddress</td><td>ＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou01</td><td>差込項目（小）０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou02</td><td>差込項目（小）０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou03</td><td>差込項目（小）０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou04</td><td>差込項目（小）０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou05</td><td>差込項目（小）０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou06</td><td>差込項目（小）０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou07</td><td>差込項目（小）０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou08</td><td>差込項目（小）０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou09</td><td>差込項目（小）０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou10</td><td>差込項目（小）１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou11</td><td>差込項目（小）１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou12</td><td>差込項目（小）１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou13</td><td>差込項目（小）１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou14</td><td>差込項目（小）１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou15</td><td>差込項目（小）１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou16</td><td>差込項目（小）１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou17</td><td>差込項目（小）１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou18</td><td>差込項目（小）１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou19</td><td>差込項目（小）１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou20</td><td>差込項目（小）２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou21</td><td>差込項目（小）２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou22</td><td>差込項目（小）２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou23</td><td>差込項目（小）２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou24</td><td>差込項目（小）２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou25</td><td>差込項目（小）２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou26</td><td>差込項目（小）２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou27</td><td>差込項目（小）２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou28</td><td>差込項目（小）２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou29</td><td>差込項目（小）２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokusyou30</td><td>差込項目（小）３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu01</td><td>差込項目（中）０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu02</td><td>差込項目（中）０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu03</td><td>差込項目（中）０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu04</td><td>差込項目（中）０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu05</td><td>差込項目（中）０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu06</td><td>差込項目（中）０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu07</td><td>差込項目（中）０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu08</td><td>差込項目（中）０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu09</td><td>差込項目（中）０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu10</td><td>差込項目（中）１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu11</td><td>差込項目（中）１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu12</td><td>差込項目（中）１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu13</td><td>差込項目（中）１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu14</td><td>差込項目（中）１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu15</td><td>差込項目（中）１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu16</td><td>差込項目（中）１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu17</td><td>差込項目（中）１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu18</td><td>差込項目（中）１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu19</td><td>差込項目（中）１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokutyuu20</td><td>差込項目（中）２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai01</td><td>差込項目（大）０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai02</td><td>差込項目（大）０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai03</td><td>差込項目（大）０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai04</td><td>差込項目（大）０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai05</td><td>差込項目（大）０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai06</td><td>差込項目（大）０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai07</td><td>差込項目（大）０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai08</td><td>差込項目（大）０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai09</td><td>差込項目（大）０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sasikomikoumokudai10</td><td>差込項目（大）１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailHaisin
 * @see     GenMT_DsMailHaisin
 * @see     QMT_DsMailHaisin
 * @see     GenQMT_DsMailHaisin
 */
public class PKMT_DsMailHaisin extends AbstractExDBPrimaryKey<MT_DsMailHaisin, PKMT_DsMailHaisin> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsMailHaisin() {
    }

    public PKMT_DsMailHaisin(
        BizDate pSousinymd,
        String pDskokmailaddressskbtkey,
        C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn,
        String pDssousinno
    ) {
        sousinymd = pSousinymd;
        dskokmailaddressskbtkey = pDskokmailaddressskbtkey;
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
        dssousinno = pDssousinno;
    }

    @Transient
    @Override
    public Class<MT_DsMailHaisin> getEntityClass() {
        return MT_DsMailHaisin.class;
    }

    private BizDate sousinymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSousinymd() {
        return sousinymd;
    }

    public void setSousinymd(BizDate pSousinymd) {
        sousinymd = pSousinymd;
    }
    private String dskokmailaddressskbtkey;

    public String getDskokmailaddressskbtkey() {
        return dskokmailaddressskbtkey;
    }

    public void setDskokmailaddressskbtkey(String pDskokmailaddressskbtkey) {
        dskokmailaddressskbtkey = pDskokmailaddressskbtkey;
    }
    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    @org.hibernate.annotations.Type(type="UserType_C_DsSousinMailSyubetuKbn")
    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }
    private String dssousinno;

    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

}