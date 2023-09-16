package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_ChkYukokekkaData;
import yuyu.def.db.mapping.GenIT_ChkYukokekkaData;
import yuyu.def.db.meta.GenQIT_ChkYukokekkaData;
import yuyu.def.db.meta.QIT_ChkYukokekkaData;

/**
 * 有効性確認結果データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ChkYukokekkaData}</td><td colspan="3">有効性確認結果データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYuukoukekkarenno yuukoukekkarenno}</td><td>有効性確認結果データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>inputyuukoukigen</td><td>入力有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yuukoutaisyouym</td><td>有効性確認対象年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>cardnokosumu</td><td>カード番号更新有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>cardykkigenkosumu</td><td>カード有効期限更新有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>newcreditcardno1</td><td>（変更後）クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardno2</td><td>（変更後）クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardno3</td><td>（変更後）クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardno4</td><td>（変更後）クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardykkigen</td><td>（変更後）クレジットカード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yuukouhanteikekka</td><td>有効性判定結果</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>errorflg</td><td>エラーフラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditbrerrorcd</td><td>クレジット払エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Creditbrerrorcd C_Creditbrerrorcd}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ChkYukokekkaData
 * @see     GenIT_ChkYukokekkaData
 * @see     QIT_ChkYukokekkaData
 * @see     GenQIT_ChkYukokekkaData
 */
public class PKIT_ChkYukokekkaData extends AbstractExDBPrimaryKey<IT_ChkYukokekkaData, PKIT_ChkYukokekkaData> {

    private static final long serialVersionUID = 1L;

    public PKIT_ChkYukokekkaData() {
    }

    public PKIT_ChkYukokekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pYuukoukekkarenno) {
        ansyuusyskbn = pAnsyuusyskbn;
        yuukoukekkarenno = pYuukoukekkarenno;
    }

    @Transient
    @Override
    public Class<IT_ChkYukokekkaData> getEntityClass() {
        return IT_ChkYukokekkaData.class;
    }

    private C_AnsyuusysKbn ansyuusyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_AnsyuusysKbn")
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return ansyuusyskbn;
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        ansyuusyskbn = pAnsyuusyskbn;
    }
    private String yuukoukekkarenno;

    public String getYuukoukekkarenno() {
        return yuukoukekkarenno;
    }

    public void setYuukoukekkarenno(String pYuukoukekkarenno) {
        yuukoukekkarenno = pYuukoukekkarenno;
    }

}