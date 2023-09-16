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
import yuyu.def.db.entity.IT_KhUriageData;
import yuyu.def.db.mapping.GenIT_KhUriageData;
import yuyu.def.db.meta.GenQIT_KhUriageData;
import yuyu.def.db.meta.QIT_KhUriageData;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhUriageData}</td><td colspan="3">売上データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAuthorikaisuu authorikaisuu}</td><td>オーソリ回数</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardykkigen</td><td>クレジットカード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardkaisyacd</td><td>カード会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuukeilvkbn</td><td>集計レベル区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyuukeilvKbn C_SyuukeilvKbn}</td></tr>
 *  <tr><td>authorigk</td><td>オーソリ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uriagegk</td><td>売上金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>uriageymd</td><td>売上日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigousdicode</td><td>保険種類記号世代コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyukigoukktkmk1</td><td>保険種類記号拡張項目１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>hknsyukigoukktkmk2</td><td>保険種類記号拡張項目２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyukigoukktkmk3</td><td>保険種類記号拡張項目３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>kameitenno</td><td>加盟店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kameitennm25</td><td>加盟店名（２５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credittsryritu</td><td>クレジット手数料率</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhUriageData
 * @see     GenIT_KhUriageData
 * @see     QIT_KhUriageData
 * @see     GenQIT_KhUriageData
 */
public class PKIT_KhUriageData extends AbstractExDBPrimaryKey<IT_KhUriageData, PKIT_KhUriageData> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhUriageData() {
    }

    public PKIT_KhUriageData(
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pSyono,
        Integer pAuthorikaisuu
    ) {
        ansyuusyskbn = pAnsyuusyskbn;
        syoriYmd = pSyoriYmd;
        syono = pSyono;
        authorikaisuu = pAuthorikaisuu;
    }

    @Transient
    @Override
    public Class<IT_KhUriageData> getEntityClass() {
        return IT_KhUriageData.class;
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
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer authorikaisuu;

    public Integer getAuthorikaisuu() {
        return authorikaisuu;
    }

    public void setAuthorikaisuu(Integer pAuthorikaisuu) {
        authorikaisuu = pAuthorikaisuu;
    }

}