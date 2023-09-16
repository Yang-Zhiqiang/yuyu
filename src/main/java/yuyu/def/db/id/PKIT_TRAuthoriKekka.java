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
import yuyu.def.db.entity.IT_TRAuthoriKekka;
import yuyu.def.db.mapping.GenIT_TRAuthoriKekka;
import yuyu.def.db.meta.GenQIT_TRAuthoriKekka;
import yuyu.def.db.meta.QIT_TRAuthoriKekka;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * オーソリ結果ＴＲテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TRAuthoriKekka}</td><td colspan="3">オーソリ結果ＴＲテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAuthorikktrrenno authorikktrrenno}</td><td>オーソリ結果TR連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorijkkbn</td><td>オーソリ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthorijkKbn C_AuthorijkKbn}</td></tr>
 *  <tr><td>authoritrkkbn</td><td>オーソリ登録区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthoritrkKbn C_AuthoritrkKbn}</td></tr>
 *  <tr><td>authorigk</td><td>オーソリ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>authorikanryoymd</td><td>オーソリ完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syouninno</td><td>承認番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tanmatusyorino</td><td>端末処理通番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TRAuthoriKekka
 * @see     GenIT_TRAuthoriKekka
 * @see     QIT_TRAuthoriKekka
 * @see     GenQIT_TRAuthoriKekka
 */
public class PKIT_TRAuthoriKekka extends AbstractExDBPrimaryKey<IT_TRAuthoriKekka, PKIT_TRAuthoriKekka> {

    private static final long serialVersionUID = 1L;

    public PKIT_TRAuthoriKekka() {
    }

    public PKIT_TRAuthoriKekka(
        String pSyono,
        BizDate pSyoriYmd,
        String pAuthorikktrrenno
    ) {
        syono = pSyono;
        syoriYmd = pSyoriYmd;
        authorikktrrenno = pAuthorikktrrenno;
    }

    @Transient
    @Override
    public Class<IT_TRAuthoriKekka> getEntityClass() {
        return IT_TRAuthoriKekka.class;
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
    private String authorikktrrenno;

    public String getAuthorikktrrenno() {
        return authorikktrrenno;
    }

    public void setAuthorikktrrenno(String pAuthorikktrrenno) {
        authorikktrrenno = pAuthorikktrrenno;
    }

}