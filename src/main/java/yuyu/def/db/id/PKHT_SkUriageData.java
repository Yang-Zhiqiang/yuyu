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
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.mapping.GenHT_SkUriageData;
import yuyu.def.db.meta.GenQHT_SkUriageData;
import yuyu.def.db.meta.QHT_SkUriageData;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約売上データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkUriageData}</td><td colspan="3">新契約売上データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAuthorikaisuu authorikaisuu}</td><td>オーソリ回数</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uriagegk</td><td>売上金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>uriageymd</td><td>売上日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknsyuruino</td><td>保険種類番号</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknsyuruiNo C_HknsyuruiNo}</td></tr>
 *  <tr><td>srsyoriymd</td><td>成立処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>authorikbn</td><td>オーソリ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthoriKbn C_AuthoriKbn}</td></tr>
 *  <tr><td>uriageseikyuutorihikicd</td><td>売上請求取引コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkaiinnokami6keta</td><td>クレジット会員番号（上６桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkaiinnosimo4keta</td><td>クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credituriagengjiyuu</td><td>クレジットカード売上請求ＮＧ事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditUriageNgJiyuuKbn C_CreditUriageNgJiyuuKbn}</td></tr>
 *  <tr><td>fukusuukameitennokey</td><td>複数加盟店番号設定キー情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardbrandkbn</td><td>カードブランド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CardBrandKbn C_CardBrandKbn}</td></tr>
 *  <tr><td>carddatasousinymd</td><td>カードデータ送信日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>uriageseikyuuerrorcd</td><td>売上請求エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uriagekekkakbn</td><td>売上結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UriagekekkaKbn C_UriagekekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkUriageData
 * @see     GenHT_SkUriageData
 * @see     QHT_SkUriageData
 * @see     GenQHT_SkUriageData
 */
public class PKHT_SkUriageData extends AbstractExDBPrimaryKey<HT_SkUriageData, PKHT_SkUriageData> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkUriageData() {
    }

    public PKHT_SkUriageData(
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pMosno,
        Integer pAuthorikaisuu
    ) {
        ansyuusyskbn = pAnsyuusyskbn;
        syoriYmd = pSyoriYmd;
        mosno = pMosno;
        authorikaisuu = pAuthorikaisuu;
    }

    @Transient
    @Override
    public Class<HT_SkUriageData> getEntityClass() {
        return HT_SkUriageData.class;
    }

    private C_AnsyuusysKbn ansyuusyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_AnsyuusysKbn")
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return ansyuusyskbn;
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        ansyuusyskbn = pAnsyuusyskbn;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer authorikaisuu;

    public Integer getAuthorikaisuu() {
        return authorikaisuu;
    }

    public void setAuthorikaisuu(Integer pAuthorikaisuu) {
        authorikaisuu = pAuthorikaisuu;
    }

}