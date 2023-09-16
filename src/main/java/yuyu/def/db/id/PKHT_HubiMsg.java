package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.mapping.GenHT_HubiMsg;
import yuyu.def.db.meta.GenQHT_HubiMsg;
import yuyu.def.db.meta.QHT_HubiMsg;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 不備メッセージテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_HubiMsg}</td><td colspan="3">不備メッセージテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>messageId</td><td>メッセージＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubimsg</td><td>不備メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubisyubetukbn</td><td>不備種別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HubisyubetuKbn C_HubisyubetuKbn}</td></tr>
 *  <tr><td>hubisyubetusyousaikbn</td><td>不備種別詳細区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HubisyubetusyousaiKbn C_HubisyubetusyousaiKbn}</td></tr>
 *  <tr><td>hituyousyoruicd</td><td>必要書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_HubiMsg
 * @see     GenHT_HubiMsg
 * @see     QHT_HubiMsg
 * @see     GenQHT_HubiMsg
 */
public class PKHT_HubiMsg extends AbstractExDBPrimaryKey<HT_HubiMsg, PKHT_HubiMsg> {

    private static final long serialVersionUID = 1L;

    public PKHT_HubiMsg() {
    }

    public PKHT_HubiMsg(String pMosno, Integer pRenno) {
        mosno = pMosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_HubiMsg> getEntityClass() {
        return HT_HubiMsg.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}