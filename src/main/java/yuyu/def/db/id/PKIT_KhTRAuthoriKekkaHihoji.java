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
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.mapping.GenIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.meta.GenQIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.meta.QIT_KhTRAuthoriKekkaHihoji;

/**
 * オーソリ結果ＴＲ（クレカ非保持）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhTRAuthoriKekkaHihoji}</td><td colspan="3">オーソリ結果ＴＲ（クレカ非保持）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardbrandkbn</td><td>カードブランド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CardBrandKbn C_CardBrandKbn}</td></tr>
 *  <tr><td>creditkaiinnosimo4keta</td><td>クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorijkkbn</td><td>オーソリ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthorijkKbn C_AuthorijkKbn}</td></tr>
 *  <tr><td>datajyusinymd</td><td>データ受信日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhTRAuthoriKekkaHihoji
 * @see     GenIT_KhTRAuthoriKekkaHihoji
 * @see     QIT_KhTRAuthoriKekkaHihoji
 * @see     GenQIT_KhTRAuthoriKekkaHihoji
 */
public class PKIT_KhTRAuthoriKekkaHihoji extends AbstractExDBPrimaryKey<IT_KhTRAuthoriKekkaHihoji, PKIT_KhTRAuthoriKekkaHihoji> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhTRAuthoriKekkaHihoji() {
    }

    public PKIT_KhTRAuthoriKekkaHihoji(String pCreditkessaiyouno, BizDate pSyoriYmd) {
        creditkessaiyouno = pCreditkessaiyouno;
        syoriYmd = pSyoriYmd;
    }

    @Transient
    @Override
    public Class<IT_KhTRAuthoriKekkaHihoji> getEntityClass() {
        return IT_KhTRAuthoriKekkaHihoji.class;
    }

    private String creditkessaiyouno;

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

}