package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhUriageKekkaData;
import yuyu.def.db.mapping.GenIT_KhUriageKekkaData;
import yuyu.def.db.meta.GenQIT_KhUriageKekkaData;
import yuyu.def.db.meta.QIT_KhUriageKekkaData;

/**
 * 売上結果データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhUriageKekkaData}</td><td colspan="3">売上結果データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUriagekekkadatarenno uriagekekkadatarenno}</td><td>売上結果データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syuukeilvkbn</td><td>集計レベル区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyuukeilvKbn C_SyuukeilvKbn}</td></tr>
 *  <tr><td>uriagetorihikikbn</td><td>売上取引区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UriagetorihikiKbn C_UriagetorihikiKbn}</td></tr>
 *  <tr><td>uriageymd</td><td>売上日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>uriagegk</td><td>売上金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zeisoukin</td><td>税・送金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>uriagegoukei</td><td>売上合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syouninno</td><td>承認番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardykkigen</td><td>クレジットカード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardkaisyacd</td><td>カード会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uriagekekkakbn</td><td>売上結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UriagekekkaKbn C_UriagekekkaKbn}</td></tr>
 *  <tr><td>creditbrerrorcd</td><td>クレジット払エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Creditbrerrorcd C_Creditbrerrorcd}</td></tr>
 *  <tr><td>authorikaisuu</td><td>オーソリ回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhUriageKekkaData
 * @see     GenIT_KhUriageKekkaData
 * @see     QIT_KhUriageKekkaData
 * @see     GenQIT_KhUriageKekkaData
 */
public class PKIT_KhUriageKekkaData extends AbstractExDBPrimaryKey<IT_KhUriageKekkaData, PKIT_KhUriageKekkaData> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhUriageKekkaData() {
    }

    public PKIT_KhUriageKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pUriagekekkadatarenno) {
        ansyuusyskbn = pAnsyuusyskbn;
        uriagekekkadatarenno = pUriagekekkadatarenno;
    }

    @Transient
    @Override
    public Class<IT_KhUriageKekkaData> getEntityClass() {
        return IT_KhUriageKekkaData.class;
    }

    private C_AnsyuusysKbn ansyuusyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_AnsyuusysKbn")
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return ansyuusyskbn;
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        ansyuusyskbn = pAnsyuusyskbn;
    }
    private String uriagekekkadatarenno;

    public String getUriagekekkadatarenno() {
        return uriagekekkadatarenno;
    }

    public void setUriagekekkadatarenno(String pUriagekekkadatarenno) {
        uriagekekkadatarenno = pUriagekekkadatarenno;
    }

}