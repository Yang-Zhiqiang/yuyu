package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SkHubiMsg;
import yuyu.def.db.mapping.GenJT_SkHubiMsg;
import yuyu.def.db.meta.GenQJT_SkHubiMsg;
import yuyu.def.db.meta.QJT_SkHubiMsg;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求不備テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkHubiMsg}</td><td colspan="3">請求不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uketukeno</td><td>受付番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>msgsyubetu</td><td>メッセージ種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MsgSyubetu C_MsgSyubetu}</td></tr>
 *  <tr><td>hubimsgid</td><td>不備メッセージＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubimsg</td><td>不備メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkHubiMsg
 * @see     GenJT_SkHubiMsg
 * @see     QJT_SkHubiMsg
 * @see     GenQJT_SkHubiMsg
 */
public class PKJT_SkHubiMsg extends AbstractExDBPrimaryKey<JT_SkHubiMsg, PKJT_SkHubiMsg> {

    private static final long serialVersionUID = 1L;

    public PKJT_SkHubiMsg() {
    }

    public PKJT_SkHubiMsg(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pRenno3keta
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<JT_SkHubiMsg> getEntityClass() {
        return JT_SkHubiMsg.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer seikyuurirekino;

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}