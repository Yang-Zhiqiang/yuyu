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
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import yuyu.def.db.mapping.GenIT_KhIdouTyousyo;
import yuyu.def.db.meta.GenQIT_KhIdouTyousyo;
import yuyu.def.db.meta.QIT_KhIdouTyousyo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全異動調書テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhIdouTyousyo}</td><td colspan="3">契約保全異動調書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getShrtysyrenno shrtysyrenno}</td><td>支払調書連番</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>kacd</td><td>課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysysyuruicd</td><td>支払調書種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoritaisyoukbn</td><td>処理対象区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tblsakuseihunodisp</td><td>テープ作成不能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinyno</td><td>（旧）通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinadr1kj</td><td>（旧）通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinadr2kj</td><td>（旧）通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinadr3kj</td><td>（旧）通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldkyknmkj</td><td>（旧）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldkyksibouymd</td><td>（旧）契約者死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyksiboumeighnksyoriymd</td><td>契約者死亡名義変更処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaiyakuhrstgk</td><td>解約返戻金相当額</td><td>&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmp</td><td>既払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldkykkihrkmpyouhyj</td><td>（旧）契約者既払込保険料要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldkykkihrkmp</td><td>（旧）契約者既払込保険料</td><td>&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>sakuseiymd</td><td>作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>huho2kykdisp</td><td>普保Ⅱ契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysyhknsyukbn</td><td>支払調書保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrtysyhknsyuKbn C_ShrtysyhknsyuKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhIdouTyousyo
 * @see     GenIT_KhIdouTyousyo
 * @see     QIT_KhIdouTyousyo
 * @see     GenQIT_KhIdouTyousyo
 */
public class PKIT_KhIdouTyousyo extends AbstractExDBPrimaryKey<IT_KhIdouTyousyo, PKIT_KhIdouTyousyo> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhIdouTyousyo() {
    }

    public PKIT_KhIdouTyousyo(
        String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno
    ) {
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
        shrtysyrenno = pShrtysyrenno;
    }

    @Transient
    @Override
    public Class<IT_KhIdouTyousyo> getEntityClass() {
        return IT_KhIdouTyousyo.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }
    private Long shrtysyrenno;

    public Long getShrtysyrenno() {
        return shrtysyrenno;
    }

    public void setShrtysyrenno(Long pShrtysyrenno) {
        shrtysyrenno = pShrtysyrenno;
    }

}