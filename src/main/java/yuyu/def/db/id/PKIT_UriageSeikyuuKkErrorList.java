package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import yuyu.def.db.mapping.GenIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.meta.GenQIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.meta.QIT_UriageSeikyuuKkErrorList;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上請求結果エラーリストテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_UriageSeikyuuKkErrorList}</td><td colspan="3">売上請求結果エラーリストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUriagenengappi uriagenengappi}</td><td>売上年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>credituriagegk</td><td>クレジットカード売上金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>uriageseikyuuerrorcd</td><td>売上請求エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credituriagengjiyuu</td><td>クレジットカード売上請求ＮＧ事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditUriageNgJiyuuKbn C_CreditUriageNgJiyuuKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorikbn</td><td>オーソリ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthoriKbn C_AuthoriKbn}</td></tr>
 *  <tr><td>kinouId</td><td>機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credituriageseikyuukbn</td><td>クレジットカード売上請求区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditUriageSeikyuuKbn C_CreditUriageSeikyuuKbn}</td></tr>
 * </table>
 * @see     IT_UriageSeikyuuKkErrorList
 * @see     GenIT_UriageSeikyuuKkErrorList
 * @see     QIT_UriageSeikyuuKkErrorList
 * @see     GenQIT_UriageSeikyuuKkErrorList
 */
public class PKIT_UriageSeikyuuKkErrorList extends AbstractExDBPrimaryKey<IT_UriageSeikyuuKkErrorList, PKIT_UriageSeikyuuKkErrorList> {

    private static final long serialVersionUID = 1L;

    public PKIT_UriageSeikyuuKkErrorList() {
    }

    public PKIT_UriageSeikyuuKkErrorList(
        String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        syono = pSyono;
        creditkessaiyouno = pCreditkessaiyouno;
        uriagenengappi = pUriagenengappi;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<IT_UriageSeikyuuKkErrorList> getEntityClass() {
        return IT_UriageSeikyuuKkErrorList.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String creditkessaiyouno;

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
    private BizDate uriagenengappi;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getUriagenengappi() {
        return uriagenengappi;
    }

    public void setUriagenengappi(BizDate pUriagenengappi) {
        uriagenengappi = pUriagenengappi;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}