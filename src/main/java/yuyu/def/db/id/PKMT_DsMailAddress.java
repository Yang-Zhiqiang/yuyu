package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.mapping.GenMT_DsMailAddress;
import yuyu.def.db.meta.GenQMT_DsMailAddress;
import yuyu.def.db.meta.QMT_DsMailAddress;

/**
 * ＤＳメールアドレステーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailAddress}</td><td colspan="3">ＤＳメールアドレステーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dsmailtourokujyoutaikbn</td><td>ＤＳメール登録状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsMailTourokuJyoutaiKbn C_DsMailTourokuJyoutaiKbn}</td></tr>
 *  <tr><td>dsmailaddress</td><td>ＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmailsousinjyoutaikbn</td><td>ＤＳメール送信状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsMailSousinJyoutaiKbn C_DsMailSousinJyoutaiKbn}</td></tr>
 *  <tr><td>dsmailsousintisrykbn</td><td>ＤＳメール送信停止理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn C_DsMailSousinTeisiRiyuuKbn}</td></tr>
 *  <tr><td>dstourokuymdtime</td><td>ＤＳ登録日時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dskousinymdtime</td><td>ＤＳ更新日時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailAddress
 * @see     GenMT_DsMailAddress
 * @see     QMT_DsMailAddress
 * @see     GenQMT_DsMailAddress
 */
public class PKMT_DsMailAddress extends AbstractExDBPrimaryKey<MT_DsMailAddress, PKMT_DsMailAddress> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsMailAddress() {
    }

    public PKMT_DsMailAddress(String pDskokno, Integer pDsmailaddressrenban) {
        dskokno = pDskokno;
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    @Transient
    @Override
    public Class<MT_DsMailAddress> getEntityClass() {
        return MT_DsMailAddress.class;
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