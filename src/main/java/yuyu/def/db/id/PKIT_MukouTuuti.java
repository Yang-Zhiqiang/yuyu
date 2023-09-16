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
import yuyu.def.db.entity.IT_MukouTuuti;
import yuyu.def.db.mapping.GenIT_MukouTuuti;
import yuyu.def.db.meta.GenQIT_MukouTuuti;
import yuyu.def.db.meta.QIT_MukouTuuti;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 無効通知テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_MukouTuuti}</td><td colspan="3">無効通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtennmkj</td><td>親代理店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr4kj</td><td>通信先住所４（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yykknmnryymd</td><td>猶予期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rtratkicd</td><td>（帳票用）取扱コード</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>rtyouhyoucd</td><td>（帳票用）帳票コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyhyrenrakusikibetukbn</td><td>帳票連絡先識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyhyrenrakusikibetuKbn C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_MukouTuuti
 * @see     GenIT_MukouTuuti
 * @see     QIT_MukouTuuti
 * @see     GenQIT_MukouTuuti
 */
public class PKIT_MukouTuuti extends AbstractExDBPrimaryKey<IT_MukouTuuti, PKIT_MukouTuuti> {

    private static final long serialVersionUID = 1L;

    public PKIT_MukouTuuti() {
    }

    public PKIT_MukouTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
    }

    @Transient
    @Override
    public Class<IT_MukouTuuti> getEntityClass() {
        return IT_MukouTuuti.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
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

}