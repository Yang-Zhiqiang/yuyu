package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.mapping.GenMT_DsKokyakuKanri;
import yuyu.def.db.meta.GenQMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;

/**
 * ＤＳ顧客管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsKokyakuKanri}</td><td colspan="3">ＤＳ顧客管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskokyakujtkbn</td><td>ＤＳ顧客状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsKokyakuJtKbn C_DsKokyakuJtKbn}</td></tr>
 *  <tr><td>dskokyakusakuseiymd</td><td>ＤＳ顧客作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dsteisiriyuukbn</td><td>ＤＳ停止理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsTeisiRiyuuKbn C_DsTeisiRiyuuKbn}</td></tr>
 *  <tr><td>dskokyakumukouymd</td><td>ＤＳ顧客無効年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seisahuyouhyj</td><td>精査不要表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeisaHuyouHyj C_SeisaHuyouHyj}</td></tr>
 *  <tr><td>dskokyakunmkn</td><td>ＤＳ顧客名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskokyakunmkj</td><td>ＤＳ顧客名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskokyakuseiymd</td><td>ＤＳ顧客生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dskokyakuyno</td><td>ＤＳ顧客郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskanyuukeirokbn</td><td>ＤＳ加入経路区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsKanyuuKeiroKbn C_DsKanyuuKeiroKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsKokyakuKanri
 * @see     GenMT_DsKokyakuKanri
 * @see     QMT_DsKokyakuKanri
 * @see     GenQMT_DsKokyakuKanri
 */
public class PKMT_DsKokyakuKanri extends AbstractExDBPrimaryKey<MT_DsKokyakuKanri, PKMT_DsKokyakuKanri> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsKokyakuKanri() {
    }

    public PKMT_DsKokyakuKanri(String pDskokno) {
        dskokno = pDskokno;
    }

    @Transient
    @Override
    public Class<MT_DsKokyakuKanri> getEntityClass() {
        return MT_DsKokyakuKanri.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

}