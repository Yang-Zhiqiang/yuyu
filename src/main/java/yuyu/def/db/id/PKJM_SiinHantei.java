package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.db.mapping.GenJM_SiinHantei;
import yuyu.def.db.meta.GenQJM_SiinHantei;
import yuyu.def.db.meta.QJM_SiinHantei;

/**
 * 死因判定マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiinHantei}</td><td colspan="3">死因判定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSiboukariuketukejigeninkbn siboukariuketukejigeninkbn}</td><td>死亡仮受付時原因区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuuuketukejigeninkbn seikyuuuketukejigeninkbn}</td><td>請求受付時原因区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKansensyouumukbn kansensyouumukbn}</td><td>感染症有無区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSaigaikanouseiumukbn saigaikanouseiumukbn}</td><td>災害可能性有無区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHusyounosiumukbn husyounosiumukbn}</td><td>不詳の死有無区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSateikaksaigaikanouseikbn sateikaksaigaikanouseikbn}</td><td>査定回送要否確認（災害可能性）区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSateikakhusyousikbn sateikakhusyousikbn}</td><td>査定回送要否確認（不詳の死）区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>siinkbn</td><td>死因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiinKbn C_SiinKbn}</td></tr>
 * </table>
 * @see     JM_SiinHantei
 * @see     GenJM_SiinHantei
 * @see     QJM_SiinHantei
 * @see     GenQJM_SiinHantei
 */
public class PKJM_SiinHantei extends AbstractExDBPrimaryKey<JM_SiinHantei, PKJM_SiinHantei> {

    private static final long serialVersionUID = 1L;

    public PKJM_SiinHantei() {
    }

    public PKJM_SiinHantei(
        C_GeninKbn pSiboukariuketukejigeninkbn,
        C_GeninKbn pSeikyuuuketukejigeninkbn,
        C_UmuKbn pKansensyouumukbn,
        C_UmuKbn pSaigaikanouseiumukbn,
        C_UmuKbn pHusyounosiumukbn,
        C_UmuKbn pSateikaksaigaikanouseikbn,
        C_UmuKbn pSateikakhusyousikbn
    ) {
        siboukariuketukejigeninkbn = pSiboukariuketukejigeninkbn;
        seikyuuuketukejigeninkbn = pSeikyuuuketukejigeninkbn;
        kansensyouumukbn = pKansensyouumukbn;
        saigaikanouseiumukbn = pSaigaikanouseiumukbn;
        husyounosiumukbn = pHusyounosiumukbn;
        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
        sateikakhusyousikbn = pSateikakhusyousikbn;
    }

    @Transient
    @Override
    public Class<JM_SiinHantei> getEntityClass() {
        return JM_SiinHantei.class;
    }

    private C_GeninKbn siboukariuketukejigeninkbn;

    @org.hibernate.annotations.Type(type="UserType_C_GeninKbn")
    public C_GeninKbn getSiboukariuketukejigeninkbn() {
        return siboukariuketukejigeninkbn;
    }

    public void setSiboukariuketukejigeninkbn(C_GeninKbn pSiboukariuketukejigeninkbn) {
        siboukariuketukejigeninkbn = pSiboukariuketukejigeninkbn;
    }
    private C_GeninKbn seikyuuuketukejigeninkbn;

    @org.hibernate.annotations.Type(type="UserType_C_GeninKbn")
    public C_GeninKbn getSeikyuuuketukejigeninkbn() {
        return seikyuuuketukejigeninkbn;
    }

    public void setSeikyuuuketukejigeninkbn(C_GeninKbn pSeikyuuuketukejigeninkbn) {
        seikyuuuketukejigeninkbn = pSeikyuuuketukejigeninkbn;
    }
    private C_UmuKbn kansensyouumukbn;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getKansensyouumukbn() {
        return kansensyouumukbn;
    }

    public void setKansensyouumukbn(C_UmuKbn pKansensyouumukbn) {
        kansensyouumukbn = pKansensyouumukbn;
    }
    private C_UmuKbn saigaikanouseiumukbn;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getSaigaikanouseiumukbn() {
        return saigaikanouseiumukbn;
    }

    public void setSaigaikanouseiumukbn(C_UmuKbn pSaigaikanouseiumukbn) {
        saigaikanouseiumukbn = pSaigaikanouseiumukbn;
    }
    private C_UmuKbn husyounosiumukbn;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getHusyounosiumukbn() {
        return husyounosiumukbn;
    }

    public void setHusyounosiumukbn(C_UmuKbn pHusyounosiumukbn) {
        husyounosiumukbn = pHusyounosiumukbn;
    }
    private C_UmuKbn sateikaksaigaikanouseikbn;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return sateikaksaigaikanouseikbn;
    }

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {
        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
    }
    private C_UmuKbn sateikakhusyousikbn;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getSateikakhusyousikbn() {
        return sateikakhusyousikbn;
    }

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {
        sateikakhusyousikbn = pSateikakhusyousikbn;
    }

}