package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.mapping.GenIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.GenQIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.QIT_KhTyouhyouHonbanKakunin;

/**
 * 契約保全帳票本番確認テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhTyouhyouHonbanKakunin}</td><td colspan="3">契約保全帳票本番確認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyoubunrui tyouhyoubunrui}</td><td>帳票分類</td><td align="center">○</td><td align="center">V</td><td>{@link C_TyouhyouBunruiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyoukenbunrui1 jyoukenbunrui1}</td><td>条件分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyoukenbunrui2 jyoukenbunrui2}</td><td>条件分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJyoukenbunrui3 jyoukenbunrui3}</td><td>条件分類３</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kakuninjyoutaikbn</td><td>確認状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KakuninjyoutaiKbn C_KakuninjyoutaiKbn}</td></tr>
 *  <tr><td>honbankakuninstartymd</td><td>本番確認開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>firstkaisouymd</td><td>初回回送日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>honbankakuninymd</td><td>本番確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhTyouhyouHonbanKakunin
 * @see     GenIT_KhTyouhyouHonbanKakunin
 * @see     QIT_KhTyouhyouHonbanKakunin
 * @see     GenQIT_KhTyouhyouHonbanKakunin
 */
public class PKIT_KhTyouhyouHonbanKakunin extends AbstractExDBPrimaryKey<IT_KhTyouhyouHonbanKakunin, PKIT_KhTyouhyouHonbanKakunin> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhTyouhyouHonbanKakunin() {
    }

    public PKIT_KhTyouhyouHonbanKakunin(
        C_TyouhyouBunruiKbn pTyouhyoubunrui,
        C_SyoruiCdKbn pSyoruiCd,
        String pJyoukenbunrui1,
        String pJyoukenbunrui2,
        String pJyoukenbunrui3
    ) {
        tyouhyoubunrui = pTyouhyoubunrui;
        syoruiCd = pSyoruiCd;
        jyoukenbunrui1 = pJyoukenbunrui1;
        jyoukenbunrui2 = pJyoukenbunrui2;
        jyoukenbunrui3 = pJyoukenbunrui3;
    }

    @Transient
    @Override
    public Class<IT_KhTyouhyouHonbanKakunin> getEntityClass() {
        return IT_KhTyouhyouHonbanKakunin.class;
    }

    private C_TyouhyouBunruiKbn tyouhyoubunrui;

    @org.hibernate.annotations.Type(type="UserType_C_TyouhyouBunruiKbn")
    public C_TyouhyouBunruiKbn getTyouhyoubunrui() {
        return tyouhyoubunrui;
    }

    public void setTyouhyoubunrui(C_TyouhyouBunruiKbn pTyouhyoubunrui) {
        tyouhyoubunrui = pTyouhyoubunrui;
    }
    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }
    private String jyoukenbunrui1;

    public String getJyoukenbunrui1() {
        return jyoukenbunrui1;
    }

    public void setJyoukenbunrui1(String pJyoukenbunrui1) {
        jyoukenbunrui1 = pJyoukenbunrui1;
    }
    private String jyoukenbunrui2;

    public String getJyoukenbunrui2() {
        return jyoukenbunrui2;
    }

    public void setJyoukenbunrui2(String pJyoukenbunrui2) {
        jyoukenbunrui2 = pJyoukenbunrui2;
    }
    private String jyoukenbunrui3;

    public String getJyoukenbunrui3() {
        return jyoukenbunrui3;
    }

    public void setJyoukenbunrui3(String pJyoukenbunrui3) {
        jyoukenbunrui3 = pJyoukenbunrui3;
    }

}