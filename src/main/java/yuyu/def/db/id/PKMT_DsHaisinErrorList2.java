package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.MT_DsHaisinErrorList2;
import yuyu.def.db.mapping.GenMT_DsHaisinErrorList2;
import yuyu.def.db.meta.GenQMT_DsHaisinErrorList2;
import yuyu.def.db.meta.QMT_DsHaisinErrorList2;

/**
 * ＤＳ配信エラーリスト２テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHaisinErrorList2}</td><td colspan="3">ＤＳ配信エラーリスト２テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsmailhaisinrenban dsmailhaisinrenban}</td><td>ＤＳメール配信連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dskokno</td><td>ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmailaddressrenban</td><td>ＤＳメールアドレス連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dssousinmailsyubetukbn</td><td>ＤＳ送信メール種別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSousinMailSyubetuKbn C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>dssousinno</td><td>ＤＳ送信番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haisinjidsmailaddress</td><td>配信時ＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmailsousinymd</td><td>ＤＳメール送信日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dsmailsakujyoymd</td><td>ＤＳメール削除日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>haisinerrorcount</td><td>配信エラーカウント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haisinerrorcount2</td><td>配信エラーカウント２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHaisinErrorList2
 * @see     GenMT_DsHaisinErrorList2
 * @see     QMT_DsHaisinErrorList2
 * @see     GenQMT_DsHaisinErrorList2
 */
public class PKMT_DsHaisinErrorList2 extends AbstractExDBPrimaryKey<MT_DsHaisinErrorList2, PKMT_DsHaisinErrorList2> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsHaisinErrorList2() {
    }

    public PKMT_DsHaisinErrorList2(BizDate pDsdatasakuseiymd, Integer pDsmailhaisinrenban) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
        dsmailhaisinrenban = pDsmailhaisinrenban;
    }

    @Transient
    @Override
    public Class<MT_DsHaisinErrorList2> getEntityClass() {
        return MT_DsHaisinErrorList2.class;
    }

    private BizDate dsdatasakuseiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDsdatasakuseiymd() {
        return dsdatasakuseiymd;
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
    }
    private Integer dsmailhaisinrenban;

    public Integer getDsmailhaisinrenban() {
        return dsmailhaisinrenban;
    }

    public void setDsmailhaisinrenban(Integer pDsmailhaisinrenban) {
        dsmailhaisinrenban = pDsmailhaisinrenban;
    }

}