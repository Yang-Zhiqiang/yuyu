package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.db.entity.IT_SyuunouKanri;
import yuyu.def.db.mapping.GenIT_SyuunouKanri;
import yuyu.def.db.meta.GenQIT_SyuunouKanri;
import yuyu.def.db.meta.QIT_SyuunouKanri;

/**
 * 収納管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SyuunouKanri}</td><td colspan="3">収納管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>annaikensuu</td><td>案内件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>annaigk</td><td>案内金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hurizumikensuu</td><td>振替済件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hurizumigk</td><td>振替済金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hurihunokensuu</td><td>振替不能件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hurihunogk</td><td>振替不能金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syuunousyoriymd</td><td>収納処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SyuunouKanri
 * @see     GenIT_SyuunouKanri
 * @see     QIT_SyuunouKanri
 * @see     GenQIT_SyuunouKanri
 */
public class PKIT_SyuunouKanri extends AbstractExDBPrimaryKey<IT_SyuunouKanri, PKIT_SyuunouKanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_SyuunouKanri() {
    }

    public PKIT_SyuunouKanri(C_Syuudaikocd pSyuudaikocd, BizDate pHurikaeymd) {
        syuudaikocd = pSyuudaikocd;
        hurikaeymd = pHurikaeymd;
    }

    @Transient
    @Override
    public Class<IT_SyuunouKanri> getEntityClass() {
        return IT_SyuunouKanri.class;
    }

    private C_Syuudaikocd syuudaikocd;

    @org.hibernate.annotations.Type(type="UserType_C_Syuudaikocd")
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }
    private BizDate hurikaeymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getHurikaeymd() {
        return hurikaeymd;
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        hurikaeymd = pHurikaeymd;
    }

}