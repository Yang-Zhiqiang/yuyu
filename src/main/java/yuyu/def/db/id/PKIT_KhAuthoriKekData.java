package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhAuthoriKekData;
import yuyu.def.db.mapping.GenIT_KhAuthoriKekData;
import yuyu.def.db.meta.GenQIT_KhAuthoriKekData;
import yuyu.def.db.meta.QIT_KhAuthoriKekData;

/**
 * オーソリ結果データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhAuthoriKekData}</td><td colspan="3">オーソリ結果データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAuthorikkdatarenno authorikkdatarenno}</td><td>オーソリ結果データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorikanryoymd</td><td>オーソリ完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardykkigen</td><td>クレジットカード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authoritrkkbn</td><td>オーソリ登録区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthoritrkKbn C_AuthoritrkKbn}</td></tr>
 *  <tr><td>torihikicd</td><td>取引コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorigk</td><td>オーソリ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syouninno</td><td>承認番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tanmatusyorino</td><td>端末処理通番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorijkkbn</td><td>オーソリ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthorijkKbn C_AuthorijkKbn}</td></tr>
 *  <tr><td>creditbrerrorcd</td><td>クレジット払エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Creditbrerrorcd C_Creditbrerrorcd}</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>authorikaisuu</td><td>オーソリ回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhAuthoriKekData
 * @see     GenIT_KhAuthoriKekData
 * @see     QIT_KhAuthoriKekData
 * @see     GenQIT_KhAuthoriKekData
 */
public class PKIT_KhAuthoriKekData extends AbstractExDBPrimaryKey<IT_KhAuthoriKekData, PKIT_KhAuthoriKekData> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhAuthoriKekData() {
    }

    public PKIT_KhAuthoriKekData(C_AnsyuusysKbn pAnsyuusyskbn, String pAuthorikkdatarenno) {
        ansyuusyskbn = pAnsyuusyskbn;
        authorikkdatarenno = pAuthorikkdatarenno;
    }

    @Transient
    @Override
    public Class<IT_KhAuthoriKekData> getEntityClass() {
        return IT_KhAuthoriKekData.class;
    }

    private C_AnsyuusysKbn ansyuusyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_AnsyuusysKbn")
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return ansyuusyskbn;
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        ansyuusyskbn = pAnsyuusyskbn;
    }
    private String authorikkdatarenno;

    public String getAuthorikkdatarenno() {
        return authorikkdatarenno;
    }

    public void setAuthorikkdatarenno(String pAuthorikkdatarenno) {
        authorikkdatarenno = pAuthorikkdatarenno;
    }

}