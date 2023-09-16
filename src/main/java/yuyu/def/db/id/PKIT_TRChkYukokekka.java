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
import yuyu.def.db.entity.IT_TRChkYukokekka;
import yuyu.def.db.mapping.GenIT_TRChkYukokekka;
import yuyu.def.db.meta.GenQIT_TRChkYukokekka;
import yuyu.def.db.meta.QIT_TRChkYukokekka;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効性確認結果ＴＲテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TRChkYukokekka}</td><td colspan="3">有効性確認結果ＴＲテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYuukoutrrenno yuukoutrrenno}</td><td>有効性確認結果TR連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardnokosumu</td><td>カード番号更新有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>cardykkigenkosumu</td><td>カード有効期限更新有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>newcreditcardno1</td><td>（変更後）クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardno2</td><td>（変更後）クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardno3</td><td>（変更後）クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardno4</td><td>（変更後）クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newcreditcardykkigen</td><td>（変更後）クレジットカード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TRChkYukokekka
 * @see     GenIT_TRChkYukokekka
 * @see     QIT_TRChkYukokekka
 * @see     GenQIT_TRChkYukokekka
 */
public class PKIT_TRChkYukokekka extends AbstractExDBPrimaryKey<IT_TRChkYukokekka, PKIT_TRChkYukokekka> {

    private static final long serialVersionUID = 1L;

    public PKIT_TRChkYukokekka() {
    }

    public PKIT_TRChkYukokekka(
        String pSyono,
        BizDate pSyoriYmd,
        String pYuukoutrrenno
    ) {
        syono = pSyono;
        syoriYmd = pSyoriYmd;
        yuukoutrrenno = pYuukoutrrenno;
    }

    @Transient
    @Override
    public Class<IT_TRChkYukokekka> getEntityClass() {
        return IT_TRChkYukokekka.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String yuukoutrrenno;

    public String getYuukoutrrenno() {
        return yuukoutrrenno;
    }

    public void setYuukoutrrenno(String pYuukoutrrenno) {
        yuukoutrrenno = pYuukoutrrenno;
    }

}