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
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.mapping.GenBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.meta.GenQBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTut;

/**
 * 期日到来本番検証用通知テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KijituTuriHnbnKnsouTut}</td><td colspan="3">期日到来本番検証用通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTysytno tysytno}</td><td>抽出番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_KijituTuriHnbnKnsouTut
 * @see     GenBT_KijituTuriHnbnKnsouTut
 * @see     QBT_KijituTuriHnbnKnsouTut
 * @see     GenQBT_KijituTuriHnbnKnsouTut
 */
public class PKBT_KijituTuriHnbnKnsouTut extends AbstractExDBPrimaryKey<BT_KijituTuriHnbnKnsouTut, PKBT_KijituTuriHnbnKnsouTut> {

    private static final long serialVersionUID = 1L;

    public PKBT_KijituTuriHnbnKnsouTut() {
    }

    public PKBT_KijituTuriHnbnKnsouTut(
        BizDate pSyoriYmd,
        String pSubSystemId,
        Integer pTysytno
    ) {
        syoriYmd = pSyoriYmd;
        subSystemId = pSubSystemId;
        tysytno = pTysytno;
    }

    @Transient
    @Override
    public Class<BT_KijituTuriHnbnKnsouTut> getEntityClass() {
        return BT_KijituTuriHnbnKnsouTut.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
    private Integer tysytno;

    public Integer getTysytno() {
        return tysytno;
    }

    public void setTysytno(Integer pTysytno) {
        tysytno = pTysytno;
    }

}