package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.MT_DsHaisinErrorList;
import yuyu.def.db.mapping.GenMT_DsHaisinErrorList;
import yuyu.def.db.meta.GenQMT_DsHaisinErrorList;
import yuyu.def.db.meta.QMT_DsHaisinErrorList;

/**
 * ＤＳ配信エラーリストテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHaisinErrorList}</td><td colspan="3">ＤＳ配信エラーリストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>haisinjidsmailaddress</td><td>配信時ＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dssousinno</td><td>ＤＳ送信番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haisinerrorcount</td><td>配信エラーカウント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHaisinErrorList
 * @see     GenMT_DsHaisinErrorList
 * @see     QMT_DsHaisinErrorList
 * @see     GenQMT_DsHaisinErrorList
 */
public class PKMT_DsHaisinErrorList extends AbstractExDBPrimaryKey<MT_DsHaisinErrorList, PKMT_DsHaisinErrorList> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsHaisinErrorList() {
    }

    public PKMT_DsHaisinErrorList(
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
    public Class<MT_DsHaisinErrorList> getEntityClass() {
        return MT_DsHaisinErrorList.class;
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