package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.id.PKMT_DsMailHaisin;
import yuyu.def.db.meta.GenQMT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsMailHaisin;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳメール配信テーブル テーブルのマッピング情報クラスで、 {@link MT_DsMailHaisin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailHaisin}</td><td colspan="3">ＤＳメール配信テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSousinymd sousinymd}</td><td>送信日</td><td align="center">{@link PKMT_DsMailHaisin ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokmailaddressskbtkey dskokmailaddressskbtkey}</td><td>ＤＳ顧客メールアドレス識別キー</td><td align="center">{@link PKMT_DsMailHaisin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinmailsyubetukbn dssousinmailsyubetukbn}</td><td>ＤＳ送信メール種別区分</td><td align="center">{@link PKMT_DsMailHaisin ○}</td><td align="center">V</td><td>{@link C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">{@link PKMT_DsMailHaisin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddress dsmailaddress}</td><td>ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou01 sasikomikoumokusyou01}</td><td>差込項目（小）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou02 sasikomikoumokusyou02}</td><td>差込項目（小）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou03 sasikomikoumokusyou03}</td><td>差込項目（小）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou04 sasikomikoumokusyou04}</td><td>差込項目（小）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou05 sasikomikoumokusyou05}</td><td>差込項目（小）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou06 sasikomikoumokusyou06}</td><td>差込項目（小）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou07 sasikomikoumokusyou07}</td><td>差込項目（小）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou08 sasikomikoumokusyou08}</td><td>差込項目（小）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou09 sasikomikoumokusyou09}</td><td>差込項目（小）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou10 sasikomikoumokusyou10}</td><td>差込項目（小）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou11 sasikomikoumokusyou11}</td><td>差込項目（小）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou12 sasikomikoumokusyou12}</td><td>差込項目（小）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou13 sasikomikoumokusyou13}</td><td>差込項目（小）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou14 sasikomikoumokusyou14}</td><td>差込項目（小）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou15 sasikomikoumokusyou15}</td><td>差込項目（小）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou16 sasikomikoumokusyou16}</td><td>差込項目（小）１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou17 sasikomikoumokusyou17}</td><td>差込項目（小）１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou18 sasikomikoumokusyou18}</td><td>差込項目（小）１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou19 sasikomikoumokusyou19}</td><td>差込項目（小）１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou20 sasikomikoumokusyou20}</td><td>差込項目（小）２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou21 sasikomikoumokusyou21}</td><td>差込項目（小）２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou22 sasikomikoumokusyou22}</td><td>差込項目（小）２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou23 sasikomikoumokusyou23}</td><td>差込項目（小）２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou24 sasikomikoumokusyou24}</td><td>差込項目（小）２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou25 sasikomikoumokusyou25}</td><td>差込項目（小）２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou26 sasikomikoumokusyou26}</td><td>差込項目（小）２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou27 sasikomikoumokusyou27}</td><td>差込項目（小）２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou28 sasikomikoumokusyou28}</td><td>差込項目（小）２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou29 sasikomikoumokusyou29}</td><td>差込項目（小）２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokusyou30 sasikomikoumokusyou30}</td><td>差込項目（小）３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu01 sasikomikoumokutyuu01}</td><td>差込項目（中）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu02 sasikomikoumokutyuu02}</td><td>差込項目（中）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu03 sasikomikoumokutyuu03}</td><td>差込項目（中）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu04 sasikomikoumokutyuu04}</td><td>差込項目（中）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu05 sasikomikoumokutyuu05}</td><td>差込項目（中）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu06 sasikomikoumokutyuu06}</td><td>差込項目（中）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu07 sasikomikoumokutyuu07}</td><td>差込項目（中）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu08 sasikomikoumokutyuu08}</td><td>差込項目（中）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu09 sasikomikoumokutyuu09}</td><td>差込項目（中）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu10 sasikomikoumokutyuu10}</td><td>差込項目（中）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu11 sasikomikoumokutyuu11}</td><td>差込項目（中）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu12 sasikomikoumokutyuu12}</td><td>差込項目（中）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu13 sasikomikoumokutyuu13}</td><td>差込項目（中）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu14 sasikomikoumokutyuu14}</td><td>差込項目（中）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu15 sasikomikoumokutyuu15}</td><td>差込項目（中）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu16 sasikomikoumokutyuu16}</td><td>差込項目（中）１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu17 sasikomikoumokutyuu17}</td><td>差込項目（中）１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu18 sasikomikoumokutyuu18}</td><td>差込項目（中）１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu19 sasikomikoumokutyuu19}</td><td>差込項目（中）１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokutyuu20 sasikomikoumokutyuu20}</td><td>差込項目（中）２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai01 sasikomikoumokudai01}</td><td>差込項目（大）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai02 sasikomikoumokudai02}</td><td>差込項目（大）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai03 sasikomikoumokudai03}</td><td>差込項目（大）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai04 sasikomikoumokudai04}</td><td>差込項目（大）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai05 sasikomikoumokudai05}</td><td>差込項目（大）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai06 sasikomikoumokudai06}</td><td>差込項目（大）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai07 sasikomikoumokudai07}</td><td>差込項目（大）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai08 sasikomikoumokudai08}</td><td>差込項目（大）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai09 sasikomikoumokudai09}</td><td>差込項目（大）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSasikomikoumokudai10 sasikomikoumokudai10}</td><td>差込項目（大）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailHaisin
 * @see     PKMT_DsMailHaisin
 * @see     QMT_DsMailHaisin
 * @see     GenQMT_DsMailHaisin
 */
@MappedSuperclass
@Table(name=GenMT_DsMailHaisin.TABLE_NAME)
@IdClass(value=PKMT_DsMailHaisin.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSousinMailSyubetuKbn", typeClass=UserType_C_DsSousinMailSyubetuKbn.class)
})
public abstract class GenMT_DsMailHaisin extends AbstractExDBEntity<MT_DsMailHaisin, PKMT_DsMailHaisin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsMailHaisin";
    public static final String SOUSINYMD                = "sousinymd";
    public static final String DSKOKMAILADDRESSSKBTKEY  = "dskokmailaddressskbtkey";
    public static final String DSSOUSINMAILSYUBETUKBN   = "dssousinmailsyubetukbn";
    public static final String DSSOUSINNO               = "dssousinno";
    public static final String SYONO                    = "syono";
    public static final String DSMAILADDRESS            = "dsmailaddress";
    public static final String SASIKOMIKOUMOKUSYOU01    = "sasikomikoumokusyou01";
    public static final String SASIKOMIKOUMOKUSYOU02    = "sasikomikoumokusyou02";
    public static final String SASIKOMIKOUMOKUSYOU03    = "sasikomikoumokusyou03";
    public static final String SASIKOMIKOUMOKUSYOU04    = "sasikomikoumokusyou04";
    public static final String SASIKOMIKOUMOKUSYOU05    = "sasikomikoumokusyou05";
    public static final String SASIKOMIKOUMOKUSYOU06    = "sasikomikoumokusyou06";
    public static final String SASIKOMIKOUMOKUSYOU07    = "sasikomikoumokusyou07";
    public static final String SASIKOMIKOUMOKUSYOU08    = "sasikomikoumokusyou08";
    public static final String SASIKOMIKOUMOKUSYOU09    = "sasikomikoumokusyou09";
    public static final String SASIKOMIKOUMOKUSYOU10    = "sasikomikoumokusyou10";
    public static final String SASIKOMIKOUMOKUSYOU11    = "sasikomikoumokusyou11";
    public static final String SASIKOMIKOUMOKUSYOU12    = "sasikomikoumokusyou12";
    public static final String SASIKOMIKOUMOKUSYOU13    = "sasikomikoumokusyou13";
    public static final String SASIKOMIKOUMOKUSYOU14    = "sasikomikoumokusyou14";
    public static final String SASIKOMIKOUMOKUSYOU15    = "sasikomikoumokusyou15";
    public static final String SASIKOMIKOUMOKUSYOU16    = "sasikomikoumokusyou16";
    public static final String SASIKOMIKOUMOKUSYOU17    = "sasikomikoumokusyou17";
    public static final String SASIKOMIKOUMOKUSYOU18    = "sasikomikoumokusyou18";
    public static final String SASIKOMIKOUMOKUSYOU19    = "sasikomikoumokusyou19";
    public static final String SASIKOMIKOUMOKUSYOU20    = "sasikomikoumokusyou20";
    public static final String SASIKOMIKOUMOKUSYOU21    = "sasikomikoumokusyou21";
    public static final String SASIKOMIKOUMOKUSYOU22    = "sasikomikoumokusyou22";
    public static final String SASIKOMIKOUMOKUSYOU23    = "sasikomikoumokusyou23";
    public static final String SASIKOMIKOUMOKUSYOU24    = "sasikomikoumokusyou24";
    public static final String SASIKOMIKOUMOKUSYOU25    = "sasikomikoumokusyou25";
    public static final String SASIKOMIKOUMOKUSYOU26    = "sasikomikoumokusyou26";
    public static final String SASIKOMIKOUMOKUSYOU27    = "sasikomikoumokusyou27";
    public static final String SASIKOMIKOUMOKUSYOU28    = "sasikomikoumokusyou28";
    public static final String SASIKOMIKOUMOKUSYOU29    = "sasikomikoumokusyou29";
    public static final String SASIKOMIKOUMOKUSYOU30    = "sasikomikoumokusyou30";
    public static final String SASIKOMIKOUMOKUTYUU01    = "sasikomikoumokutyuu01";
    public static final String SASIKOMIKOUMOKUTYUU02    = "sasikomikoumokutyuu02";
    public static final String SASIKOMIKOUMOKUTYUU03    = "sasikomikoumokutyuu03";
    public static final String SASIKOMIKOUMOKUTYUU04    = "sasikomikoumokutyuu04";
    public static final String SASIKOMIKOUMOKUTYUU05    = "sasikomikoumokutyuu05";
    public static final String SASIKOMIKOUMOKUTYUU06    = "sasikomikoumokutyuu06";
    public static final String SASIKOMIKOUMOKUTYUU07    = "sasikomikoumokutyuu07";
    public static final String SASIKOMIKOUMOKUTYUU08    = "sasikomikoumokutyuu08";
    public static final String SASIKOMIKOUMOKUTYUU09    = "sasikomikoumokutyuu09";
    public static final String SASIKOMIKOUMOKUTYUU10    = "sasikomikoumokutyuu10";
    public static final String SASIKOMIKOUMOKUTYUU11    = "sasikomikoumokutyuu11";
    public static final String SASIKOMIKOUMOKUTYUU12    = "sasikomikoumokutyuu12";
    public static final String SASIKOMIKOUMOKUTYUU13    = "sasikomikoumokutyuu13";
    public static final String SASIKOMIKOUMOKUTYUU14    = "sasikomikoumokutyuu14";
    public static final String SASIKOMIKOUMOKUTYUU15    = "sasikomikoumokutyuu15";
    public static final String SASIKOMIKOUMOKUTYUU16    = "sasikomikoumokutyuu16";
    public static final String SASIKOMIKOUMOKUTYUU17    = "sasikomikoumokutyuu17";
    public static final String SASIKOMIKOUMOKUTYUU18    = "sasikomikoumokutyuu18";
    public static final String SASIKOMIKOUMOKUTYUU19    = "sasikomikoumokutyuu19";
    public static final String SASIKOMIKOUMOKUTYUU20    = "sasikomikoumokutyuu20";
    public static final String SASIKOMIKOUMOKUDAI01     = "sasikomikoumokudai01";
    public static final String SASIKOMIKOUMOKUDAI02     = "sasikomikoumokudai02";
    public static final String SASIKOMIKOUMOKUDAI03     = "sasikomikoumokudai03";
    public static final String SASIKOMIKOUMOKUDAI04     = "sasikomikoumokudai04";
    public static final String SASIKOMIKOUMOKUDAI05     = "sasikomikoumokudai05";
    public static final String SASIKOMIKOUMOKUDAI06     = "sasikomikoumokudai06";
    public static final String SASIKOMIKOUMOKUDAI07     = "sasikomikoumokudai07";
    public static final String SASIKOMIKOUMOKUDAI08     = "sasikomikoumokudai08";
    public static final String SASIKOMIKOUMOKUDAI09     = "sasikomikoumokudai09";
    public static final String SASIKOMIKOUMOKUDAI10     = "sasikomikoumokudai10";

    private final PKMT_DsMailHaisin primaryKey;

    public GenMT_DsMailHaisin() {
        primaryKey = new PKMT_DsMailHaisin();
    }

    public GenMT_DsMailHaisin(
        BizDate pSousinymd,
        String pDskokmailaddressskbtkey,
        C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn,
        String pDssousinno
    ) {
        primaryKey = new PKMT_DsMailHaisin(
            pSousinymd,
            pDskokmailaddressskbtkey,
            pDssousinmailsyubetukbn,
            pDssousinno
        );
    }

    @Transient
    @Override
    public PKMT_DsMailHaisin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsMailHaisin> getMetaClass() {
        return QMT_DsMailHaisin.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsMailHaisin.SOUSINYMD)
    public BizDate getSousinymd() {
        return getPrimaryKey().getSousinymd();
    }

    public void setSousinymd(BizDate pSousinymd) {
        getPrimaryKey().setSousinymd(pSousinymd);
    }

    @Id
    @Column(name=GenMT_DsMailHaisin.DSKOKMAILADDRESSSKBTKEY)
    public String getDskokmailaddressskbtkey() {
        return getPrimaryKey().getDskokmailaddressskbtkey();
    }

    public void setDskokmailaddressskbtkey(String pDskokmailaddressskbtkey) {
        getPrimaryKey().setDskokmailaddressskbtkey(pDskokmailaddressskbtkey);
    }

    @Id
    @Type(type="UserType_C_DsSousinMailSyubetuKbn")
    @Column(name=GenMT_DsMailHaisin.DSSOUSINMAILSYUBETUKBN)
    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return getPrimaryKey().getDssousinmailsyubetukbn();
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        getPrimaryKey().setDssousinmailsyubetukbn(pDssousinmailsyubetukbn);
    }

    @Id
    @Column(name=GenMT_DsMailHaisin.DSSOUSINNO)
    public String getDssousinno() {
        return getPrimaryKey().getDssousinno();
    }

    public void setDssousinno(String pDssousinno) {
        getPrimaryKey().setDssousinno(pDssousinno);
    }

    private String syono;

    @Column(name=GenMT_DsMailHaisin.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String dsmailaddress;

    @Column(name=GenMT_DsMailHaisin.DSMAILADDRESS)
    @MaxLength(max=100)
    @SingleByteStrings
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    public String getDsmailaddress() {
        return dsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailaddress(String pDsmailaddress) {
        dsmailaddress = pDsmailaddress;
    }

    private String sasikomikoumokusyou01;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU01)
    public String getSasikomikoumokusyou01() {
        return sasikomikoumokusyou01;
    }

    public void setSasikomikoumokusyou01(String pSasikomikoumokusyou01) {
        sasikomikoumokusyou01 = pSasikomikoumokusyou01;
    }

    private String sasikomikoumokusyou02;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU02)
    public String getSasikomikoumokusyou02() {
        return sasikomikoumokusyou02;
    }

    public void setSasikomikoumokusyou02(String pSasikomikoumokusyou02) {
        sasikomikoumokusyou02 = pSasikomikoumokusyou02;
    }

    private String sasikomikoumokusyou03;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU03)
    public String getSasikomikoumokusyou03() {
        return sasikomikoumokusyou03;
    }

    public void setSasikomikoumokusyou03(String pSasikomikoumokusyou03) {
        sasikomikoumokusyou03 = pSasikomikoumokusyou03;
    }

    private String sasikomikoumokusyou04;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU04)
    public String getSasikomikoumokusyou04() {
        return sasikomikoumokusyou04;
    }

    public void setSasikomikoumokusyou04(String pSasikomikoumokusyou04) {
        sasikomikoumokusyou04 = pSasikomikoumokusyou04;
    }

    private String sasikomikoumokusyou05;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU05)
    public String getSasikomikoumokusyou05() {
        return sasikomikoumokusyou05;
    }

    public void setSasikomikoumokusyou05(String pSasikomikoumokusyou05) {
        sasikomikoumokusyou05 = pSasikomikoumokusyou05;
    }

    private String sasikomikoumokusyou06;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU06)
    public String getSasikomikoumokusyou06() {
        return sasikomikoumokusyou06;
    }

    public void setSasikomikoumokusyou06(String pSasikomikoumokusyou06) {
        sasikomikoumokusyou06 = pSasikomikoumokusyou06;
    }

    private String sasikomikoumokusyou07;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU07)
    public String getSasikomikoumokusyou07() {
        return sasikomikoumokusyou07;
    }

    public void setSasikomikoumokusyou07(String pSasikomikoumokusyou07) {
        sasikomikoumokusyou07 = pSasikomikoumokusyou07;
    }

    private String sasikomikoumokusyou08;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU08)
    public String getSasikomikoumokusyou08() {
        return sasikomikoumokusyou08;
    }

    public void setSasikomikoumokusyou08(String pSasikomikoumokusyou08) {
        sasikomikoumokusyou08 = pSasikomikoumokusyou08;
    }

    private String sasikomikoumokusyou09;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU09)
    public String getSasikomikoumokusyou09() {
        return sasikomikoumokusyou09;
    }

    public void setSasikomikoumokusyou09(String pSasikomikoumokusyou09) {
        sasikomikoumokusyou09 = pSasikomikoumokusyou09;
    }

    private String sasikomikoumokusyou10;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU10)
    public String getSasikomikoumokusyou10() {
        return sasikomikoumokusyou10;
    }

    public void setSasikomikoumokusyou10(String pSasikomikoumokusyou10) {
        sasikomikoumokusyou10 = pSasikomikoumokusyou10;
    }

    private String sasikomikoumokusyou11;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU11)
    public String getSasikomikoumokusyou11() {
        return sasikomikoumokusyou11;
    }

    public void setSasikomikoumokusyou11(String pSasikomikoumokusyou11) {
        sasikomikoumokusyou11 = pSasikomikoumokusyou11;
    }

    private String sasikomikoumokusyou12;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU12)
    public String getSasikomikoumokusyou12() {
        return sasikomikoumokusyou12;
    }

    public void setSasikomikoumokusyou12(String pSasikomikoumokusyou12) {
        sasikomikoumokusyou12 = pSasikomikoumokusyou12;
    }

    private String sasikomikoumokusyou13;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU13)
    public String getSasikomikoumokusyou13() {
        return sasikomikoumokusyou13;
    }

    public void setSasikomikoumokusyou13(String pSasikomikoumokusyou13) {
        sasikomikoumokusyou13 = pSasikomikoumokusyou13;
    }

    private String sasikomikoumokusyou14;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU14)
    public String getSasikomikoumokusyou14() {
        return sasikomikoumokusyou14;
    }

    public void setSasikomikoumokusyou14(String pSasikomikoumokusyou14) {
        sasikomikoumokusyou14 = pSasikomikoumokusyou14;
    }

    private String sasikomikoumokusyou15;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU15)
    public String getSasikomikoumokusyou15() {
        return sasikomikoumokusyou15;
    }

    public void setSasikomikoumokusyou15(String pSasikomikoumokusyou15) {
        sasikomikoumokusyou15 = pSasikomikoumokusyou15;
    }

    private String sasikomikoumokusyou16;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU16)
    public String getSasikomikoumokusyou16() {
        return sasikomikoumokusyou16;
    }

    public void setSasikomikoumokusyou16(String pSasikomikoumokusyou16) {
        sasikomikoumokusyou16 = pSasikomikoumokusyou16;
    }

    private String sasikomikoumokusyou17;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU17)
    public String getSasikomikoumokusyou17() {
        return sasikomikoumokusyou17;
    }

    public void setSasikomikoumokusyou17(String pSasikomikoumokusyou17) {
        sasikomikoumokusyou17 = pSasikomikoumokusyou17;
    }

    private String sasikomikoumokusyou18;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU18)
    public String getSasikomikoumokusyou18() {
        return sasikomikoumokusyou18;
    }

    public void setSasikomikoumokusyou18(String pSasikomikoumokusyou18) {
        sasikomikoumokusyou18 = pSasikomikoumokusyou18;
    }

    private String sasikomikoumokusyou19;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU19)
    public String getSasikomikoumokusyou19() {
        return sasikomikoumokusyou19;
    }

    public void setSasikomikoumokusyou19(String pSasikomikoumokusyou19) {
        sasikomikoumokusyou19 = pSasikomikoumokusyou19;
    }

    private String sasikomikoumokusyou20;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU20)
    public String getSasikomikoumokusyou20() {
        return sasikomikoumokusyou20;
    }

    public void setSasikomikoumokusyou20(String pSasikomikoumokusyou20) {
        sasikomikoumokusyou20 = pSasikomikoumokusyou20;
    }

    private String sasikomikoumokusyou21;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU21)
    public String getSasikomikoumokusyou21() {
        return sasikomikoumokusyou21;
    }

    public void setSasikomikoumokusyou21(String pSasikomikoumokusyou21) {
        sasikomikoumokusyou21 = pSasikomikoumokusyou21;
    }

    private String sasikomikoumokusyou22;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU22)
    public String getSasikomikoumokusyou22() {
        return sasikomikoumokusyou22;
    }

    public void setSasikomikoumokusyou22(String pSasikomikoumokusyou22) {
        sasikomikoumokusyou22 = pSasikomikoumokusyou22;
    }

    private String sasikomikoumokusyou23;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU23)
    public String getSasikomikoumokusyou23() {
        return sasikomikoumokusyou23;
    }

    public void setSasikomikoumokusyou23(String pSasikomikoumokusyou23) {
        sasikomikoumokusyou23 = pSasikomikoumokusyou23;
    }

    private String sasikomikoumokusyou24;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU24)
    public String getSasikomikoumokusyou24() {
        return sasikomikoumokusyou24;
    }

    public void setSasikomikoumokusyou24(String pSasikomikoumokusyou24) {
        sasikomikoumokusyou24 = pSasikomikoumokusyou24;
    }

    private String sasikomikoumokusyou25;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU25)
    public String getSasikomikoumokusyou25() {
        return sasikomikoumokusyou25;
    }

    public void setSasikomikoumokusyou25(String pSasikomikoumokusyou25) {
        sasikomikoumokusyou25 = pSasikomikoumokusyou25;
    }

    private String sasikomikoumokusyou26;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU26)
    public String getSasikomikoumokusyou26() {
        return sasikomikoumokusyou26;
    }

    public void setSasikomikoumokusyou26(String pSasikomikoumokusyou26) {
        sasikomikoumokusyou26 = pSasikomikoumokusyou26;
    }

    private String sasikomikoumokusyou27;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU27)
    public String getSasikomikoumokusyou27() {
        return sasikomikoumokusyou27;
    }

    public void setSasikomikoumokusyou27(String pSasikomikoumokusyou27) {
        sasikomikoumokusyou27 = pSasikomikoumokusyou27;
    }

    private String sasikomikoumokusyou28;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU28)
    public String getSasikomikoumokusyou28() {
        return sasikomikoumokusyou28;
    }

    public void setSasikomikoumokusyou28(String pSasikomikoumokusyou28) {
        sasikomikoumokusyou28 = pSasikomikoumokusyou28;
    }

    private String sasikomikoumokusyou29;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU29)
    public String getSasikomikoumokusyou29() {
        return sasikomikoumokusyou29;
    }

    public void setSasikomikoumokusyou29(String pSasikomikoumokusyou29) {
        sasikomikoumokusyou29 = pSasikomikoumokusyou29;
    }

    private String sasikomikoumokusyou30;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUSYOU30)
    public String getSasikomikoumokusyou30() {
        return sasikomikoumokusyou30;
    }

    public void setSasikomikoumokusyou30(String pSasikomikoumokusyou30) {
        sasikomikoumokusyou30 = pSasikomikoumokusyou30;
    }

    private String sasikomikoumokutyuu01;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU01)
    public String getSasikomikoumokutyuu01() {
        return sasikomikoumokutyuu01;
    }

    public void setSasikomikoumokutyuu01(String pSasikomikoumokutyuu01) {
        sasikomikoumokutyuu01 = pSasikomikoumokutyuu01;
    }

    private String sasikomikoumokutyuu02;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU02)
    public String getSasikomikoumokutyuu02() {
        return sasikomikoumokutyuu02;
    }

    public void setSasikomikoumokutyuu02(String pSasikomikoumokutyuu02) {
        sasikomikoumokutyuu02 = pSasikomikoumokutyuu02;
    }

    private String sasikomikoumokutyuu03;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU03)
    public String getSasikomikoumokutyuu03() {
        return sasikomikoumokutyuu03;
    }

    public void setSasikomikoumokutyuu03(String pSasikomikoumokutyuu03) {
        sasikomikoumokutyuu03 = pSasikomikoumokutyuu03;
    }

    private String sasikomikoumokutyuu04;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU04)
    public String getSasikomikoumokutyuu04() {
        return sasikomikoumokutyuu04;
    }

    public void setSasikomikoumokutyuu04(String pSasikomikoumokutyuu04) {
        sasikomikoumokutyuu04 = pSasikomikoumokutyuu04;
    }

    private String sasikomikoumokutyuu05;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU05)
    public String getSasikomikoumokutyuu05() {
        return sasikomikoumokutyuu05;
    }

    public void setSasikomikoumokutyuu05(String pSasikomikoumokutyuu05) {
        sasikomikoumokutyuu05 = pSasikomikoumokutyuu05;
    }

    private String sasikomikoumokutyuu06;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU06)
    public String getSasikomikoumokutyuu06() {
        return sasikomikoumokutyuu06;
    }

    public void setSasikomikoumokutyuu06(String pSasikomikoumokutyuu06) {
        sasikomikoumokutyuu06 = pSasikomikoumokutyuu06;
    }

    private String sasikomikoumokutyuu07;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU07)
    public String getSasikomikoumokutyuu07() {
        return sasikomikoumokutyuu07;
    }

    public void setSasikomikoumokutyuu07(String pSasikomikoumokutyuu07) {
        sasikomikoumokutyuu07 = pSasikomikoumokutyuu07;
    }

    private String sasikomikoumokutyuu08;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU08)
    public String getSasikomikoumokutyuu08() {
        return sasikomikoumokutyuu08;
    }

    public void setSasikomikoumokutyuu08(String pSasikomikoumokutyuu08) {
        sasikomikoumokutyuu08 = pSasikomikoumokutyuu08;
    }

    private String sasikomikoumokutyuu09;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU09)
    public String getSasikomikoumokutyuu09() {
        return sasikomikoumokutyuu09;
    }

    public void setSasikomikoumokutyuu09(String pSasikomikoumokutyuu09) {
        sasikomikoumokutyuu09 = pSasikomikoumokutyuu09;
    }

    private String sasikomikoumokutyuu10;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU10)
    public String getSasikomikoumokutyuu10() {
        return sasikomikoumokutyuu10;
    }

    public void setSasikomikoumokutyuu10(String pSasikomikoumokutyuu10) {
        sasikomikoumokutyuu10 = pSasikomikoumokutyuu10;
    }

    private String sasikomikoumokutyuu11;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU11)
    public String getSasikomikoumokutyuu11() {
        return sasikomikoumokutyuu11;
    }

    public void setSasikomikoumokutyuu11(String pSasikomikoumokutyuu11) {
        sasikomikoumokutyuu11 = pSasikomikoumokutyuu11;
    }

    private String sasikomikoumokutyuu12;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU12)
    public String getSasikomikoumokutyuu12() {
        return sasikomikoumokutyuu12;
    }

    public void setSasikomikoumokutyuu12(String pSasikomikoumokutyuu12) {
        sasikomikoumokutyuu12 = pSasikomikoumokutyuu12;
    }

    private String sasikomikoumokutyuu13;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU13)
    public String getSasikomikoumokutyuu13() {
        return sasikomikoumokutyuu13;
    }

    public void setSasikomikoumokutyuu13(String pSasikomikoumokutyuu13) {
        sasikomikoumokutyuu13 = pSasikomikoumokutyuu13;
    }

    private String sasikomikoumokutyuu14;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU14)
    public String getSasikomikoumokutyuu14() {
        return sasikomikoumokutyuu14;
    }

    public void setSasikomikoumokutyuu14(String pSasikomikoumokutyuu14) {
        sasikomikoumokutyuu14 = pSasikomikoumokutyuu14;
    }

    private String sasikomikoumokutyuu15;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU15)
    public String getSasikomikoumokutyuu15() {
        return sasikomikoumokutyuu15;
    }

    public void setSasikomikoumokutyuu15(String pSasikomikoumokutyuu15) {
        sasikomikoumokutyuu15 = pSasikomikoumokutyuu15;
    }

    private String sasikomikoumokutyuu16;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU16)
    public String getSasikomikoumokutyuu16() {
        return sasikomikoumokutyuu16;
    }

    public void setSasikomikoumokutyuu16(String pSasikomikoumokutyuu16) {
        sasikomikoumokutyuu16 = pSasikomikoumokutyuu16;
    }

    private String sasikomikoumokutyuu17;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU17)
    public String getSasikomikoumokutyuu17() {
        return sasikomikoumokutyuu17;
    }

    public void setSasikomikoumokutyuu17(String pSasikomikoumokutyuu17) {
        sasikomikoumokutyuu17 = pSasikomikoumokutyuu17;
    }

    private String sasikomikoumokutyuu18;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU18)
    public String getSasikomikoumokutyuu18() {
        return sasikomikoumokutyuu18;
    }

    public void setSasikomikoumokutyuu18(String pSasikomikoumokutyuu18) {
        sasikomikoumokutyuu18 = pSasikomikoumokutyuu18;
    }

    private String sasikomikoumokutyuu19;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU19)
    public String getSasikomikoumokutyuu19() {
        return sasikomikoumokutyuu19;
    }

    public void setSasikomikoumokutyuu19(String pSasikomikoumokutyuu19) {
        sasikomikoumokutyuu19 = pSasikomikoumokutyuu19;
    }

    private String sasikomikoumokutyuu20;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUTYUU20)
    public String getSasikomikoumokutyuu20() {
        return sasikomikoumokutyuu20;
    }

    public void setSasikomikoumokutyuu20(String pSasikomikoumokutyuu20) {
        sasikomikoumokutyuu20 = pSasikomikoumokutyuu20;
    }

    private String sasikomikoumokudai01;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI01)
    public String getSasikomikoumokudai01() {
        return sasikomikoumokudai01;
    }

    public void setSasikomikoumokudai01(String pSasikomikoumokudai01) {
        sasikomikoumokudai01 = pSasikomikoumokudai01;
    }

    private String sasikomikoumokudai02;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI02)
    public String getSasikomikoumokudai02() {
        return sasikomikoumokudai02;
    }

    public void setSasikomikoumokudai02(String pSasikomikoumokudai02) {
        sasikomikoumokudai02 = pSasikomikoumokudai02;
    }

    private String sasikomikoumokudai03;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI03)
    public String getSasikomikoumokudai03() {
        return sasikomikoumokudai03;
    }

    public void setSasikomikoumokudai03(String pSasikomikoumokudai03) {
        sasikomikoumokudai03 = pSasikomikoumokudai03;
    }

    private String sasikomikoumokudai04;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI04)
    public String getSasikomikoumokudai04() {
        return sasikomikoumokudai04;
    }

    public void setSasikomikoumokudai04(String pSasikomikoumokudai04) {
        sasikomikoumokudai04 = pSasikomikoumokudai04;
    }

    private String sasikomikoumokudai05;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI05)
    public String getSasikomikoumokudai05() {
        return sasikomikoumokudai05;
    }

    public void setSasikomikoumokudai05(String pSasikomikoumokudai05) {
        sasikomikoumokudai05 = pSasikomikoumokudai05;
    }

    private String sasikomikoumokudai06;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI06)
    public String getSasikomikoumokudai06() {
        return sasikomikoumokudai06;
    }

    public void setSasikomikoumokudai06(String pSasikomikoumokudai06) {
        sasikomikoumokudai06 = pSasikomikoumokudai06;
    }

    private String sasikomikoumokudai07;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI07)
    public String getSasikomikoumokudai07() {
        return sasikomikoumokudai07;
    }

    public void setSasikomikoumokudai07(String pSasikomikoumokudai07) {
        sasikomikoumokudai07 = pSasikomikoumokudai07;
    }

    private String sasikomikoumokudai08;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI08)
    public String getSasikomikoumokudai08() {
        return sasikomikoumokudai08;
    }

    public void setSasikomikoumokudai08(String pSasikomikoumokudai08) {
        sasikomikoumokudai08 = pSasikomikoumokudai08;
    }

    private String sasikomikoumokudai09;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI09)
    public String getSasikomikoumokudai09() {
        return sasikomikoumokudai09;
    }

    public void setSasikomikoumokudai09(String pSasikomikoumokudai09) {
        sasikomikoumokudai09 = pSasikomikoumokudai09;
    }

    private String sasikomikoumokudai10;

    @Column(name=GenMT_DsMailHaisin.SASIKOMIKOUMOKUDAI10)
    public String getSasikomikoumokudai10() {
        return sasikomikoumokudai10;
    }

    public void setSasikomikoumokudai10(String pSasikomikoumokudai10) {
        sasikomikoumokudai10 = pSasikomikoumokudai10;
    }
}