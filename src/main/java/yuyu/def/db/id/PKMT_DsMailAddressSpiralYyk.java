package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.mapping.GenMT_DsMailAddressSpiralYyk;
import yuyu.def.db.meta.GenQMT_DsMailAddressSpiralYyk;
import yuyu.def.db.meta.QMT_DsMailAddressSpiralYyk;

/**
 * ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailAddressSpiralYyk}</td><td colspan="3">ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dsmailaddress</td><td>ＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsrendoutaisyoukbn</td><td>ＤＳ連動対象区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsRendouTaisyouKbn C_DsRendouTaisyouKbn}</td></tr>
 *  <tr><td>dsmaildbsyorikbn</td><td>ＤＳメールＤＢ処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsMailDbSyoriKbn C_DsMailDbSyoriKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailAddressSpiralYyk
 * @see     GenMT_DsMailAddressSpiralYyk
 * @see     QMT_DsMailAddressSpiralYyk
 * @see     GenQMT_DsMailAddressSpiralYyk
 */
public class PKMT_DsMailAddressSpiralYyk extends AbstractExDBPrimaryKey<MT_DsMailAddressSpiralYyk, PKMT_DsMailAddressSpiralYyk> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsMailAddressSpiralYyk() {
    }

    public PKMT_DsMailAddressSpiralYyk(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailaddressrenban
    ) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
        dskokno = pDskokno;
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    @Transient
    @Override
    public Class<MT_DsMailAddressSpiralYyk> getEntityClass() {
        return MT_DsMailAddressSpiralYyk.class;
    }

    private BizDate dsdatasakuseiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDsdatasakuseiymd() {
        return dsdatasakuseiymd;
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
    }
    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private Integer dsmailaddressrenban;

    public Integer getDsmailaddressrenban() {
        return dsmailaddressrenban;
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        dsmailaddressrenban = pDsmailaddressrenban;
    }

}