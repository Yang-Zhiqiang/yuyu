package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import yuyu.def.db.mapping.GenIT_UriageSkDataSyuKnr;
import yuyu.def.db.meta.GenQIT_UriageSkDataSyuKnr;
import yuyu.def.db.meta.QIT_UriageSkDataSyuKnr;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上請求データ収納管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_UriageSkDataSyuKnr}</td><td colspan="3">売上請求データ収納管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUriagenengappi uriagenengappi}</td><td>売上年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>credituriagekekkahaneiymd</td><td>クレジットカード売上請求結果反映日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>credituragskkkmhnkkchkzmflg</td><td>クレジットカード売上請求結果未返却チェック済フラグ</td><td>&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_UriageSkDataSyuKnr
 * @see     GenIT_UriageSkDataSyuKnr
 * @see     QIT_UriageSkDataSyuKnr
 * @see     GenQIT_UriageSkDataSyuKnr
 */
public class PKIT_UriageSkDataSyuKnr extends AbstractExDBPrimaryKey<IT_UriageSkDataSyuKnr, PKIT_UriageSkDataSyuKnr> {

    private static final long serialVersionUID = 1L;

    public PKIT_UriageSkDataSyuKnr() {
    }

    public PKIT_UriageSkDataSyuKnr(
        String pKbnkey,
        String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        creditkessaiyouno = pCreditkessaiyouno;
        uriagenengappi = pUriagenengappi;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<IT_UriageSkDataSyuKnr> getEntityClass() {
        return IT_UriageSkDataSyuKnr.class;
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